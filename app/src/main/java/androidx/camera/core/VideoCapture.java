package androidx.camera.core;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.camera.core.internal.utils.VideoUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import b.a.b.w1.r;
import c.e.b.a.a.a;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class VideoCapture extends UseCase {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final int DEQUE_TIMEOUT_USEC = 10000;
    public static final int ERROR_ENCODER = 1;
    public static final int ERROR_FILE_IO = 4;
    public static final int ERROR_INVALID_CAMERA = 5;
    public static final int ERROR_MUXER = 2;
    public static final int ERROR_RECORDING_IN_PROGRESS = 3;
    public static final int ERROR_UNKNOWN = 0;
    private static final String TAG = "VideoCapture";
    private static final String VIDEO_MIME_TYPE = "video/avc";
    private int mAudioBitRate;
    private final MediaCodec.BufferInfo mAudioBufferInfo;
    private int mAudioBufferSize;
    private int mAudioChannelCount;

    @NonNull
    private MediaCodec mAudioEncoder;
    private Handler mAudioHandler;
    private HandlerThread mAudioHandlerThread;

    @NonNull
    private AudioRecord mAudioRecorder;
    private int mAudioSampleRate;
    private int mAudioTrackIndex;
    public Surface mCameraSurface;
    private DeferrableSurface mDeferrableSurface;
    private final AtomicBoolean mEndOfAudioStreamSignal;
    private final AtomicBoolean mEndOfAudioVideoSignal;
    private final AtomicBoolean mEndOfVideoStreamSignal;
    private final AtomicBoolean mIsFirstAudioSampleWrite;
    private final AtomicBoolean mIsFirstVideoSampleWrite;
    private boolean mIsRecording;

    @GuardedBy("mMuxerLock")
    private MediaMuxer mMuxer;
    private final Object mMuxerLock;
    private boolean mMuxerStarted;
    private ParcelFileDescriptor mParcelFileDescriptor;

    @Nullable
    private a<Void> mRecordingFuture;
    public Uri mSavedVideoUri;
    private final MediaCodec.BufferInfo mVideoBufferInfo;

    @NonNull
    public MediaCodec mVideoEncoder;
    private Handler mVideoHandler;
    private HandlerThread mVideoHandlerThread;
    private int mVideoTrackIndex;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final int[] CamcorderQuality = {8, 6, 5, 4};
    private static final short[] sAudioEncoding = {2, 3, 4};

    public static final class Builder implements UseCaseConfig.Builder<VideoCapture, VideoCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(@NonNull Config config) {
            return new Builder(MutableOptionsBundle.from(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setAudioBitRate(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_BIT_RATE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setAudioChannelCount(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_CHANNEL_COUNT, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setAudioMinBufferSize(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_MIN_BUFFER_SIZE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setAudioRecordSource(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_RECORD_SOURCE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setAudioSampleRate(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_SAMPLE_RATE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setBitRate(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_BIT_RATE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setIFrameInterval(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_INTRA_FRAME_INTERVAL, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Builder setSupportedResolutions(@NonNull List list) {
            return setSupportedResolutions((List<Pair<Integer, Size[]>>) list);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setTargetClass(@NonNull Class cls) {
            return setTargetClass((Class<VideoCapture>) cls);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setVideoFrameRate(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_FRAME_RATE, Integer.valueOf(i2));
            return this;
        }

        private Builder(@NonNull MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(VideoCapture.class)) {
                setTargetClass(VideoCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        @NonNull
        public static Builder fromConfig(@NonNull VideoCaptureConfig videoCaptureConfig) {
            return new Builder(MutableOptionsBundle.from((Config) videoCaptureConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public VideoCapture build() {
            if (getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) == null || getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) == null) {
                return new VideoCapture(getUseCaseConfig());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public VideoCaptureConfig getUseCaseConfig() {
            return new VideoCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setBackgroundExecutor(@NonNull Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setCameraSelector(@NonNull CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCaptureOptionUnpacker(@NonNull CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultCaptureConfig(@NonNull CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultSessionConfig(@NonNull SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setMaxResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSessionOptionUnpacker(@NonNull SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSupportedResolutions(@NonNull List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSurfaceOccupancyPriority(int i2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetAspectRatio(int i2) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetClass(@NonNull Class<VideoCapture> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        public Builder setTargetName(@NonNull String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetRotation(int i2) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.internal.UseCaseEventConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setUseCaseEventCallback(@NonNull UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Defaults implements ConfigProvider<VideoCaptureConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 1;
        private static final int DEFAULT_AUDIO_BIT_RATE = 64000;
        private static final int DEFAULT_AUDIO_CHANNEL_COUNT = 1;
        private static final int DEFAULT_AUDIO_MIN_BUFFER_SIZE = 1024;
        private static final int DEFAULT_AUDIO_RECORD_SOURCE = 1;
        private static final int DEFAULT_AUDIO_SAMPLE_RATE = 8000;
        private static final int DEFAULT_BIT_RATE = 8388608;
        private static final VideoCaptureConfig DEFAULT_CONFIG;
        private static final int DEFAULT_INTRA_FRAME_INTERVAL = 1;
        private static final Size DEFAULT_MAX_RESOLUTION;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 3;
        private static final int DEFAULT_VIDEO_FRAME_RATE = 30;

        static {
            Size size = new Size(1920, 1080);
            DEFAULT_MAX_RESOLUTION = size;
            DEFAULT_CONFIG = new Builder().setVideoFrameRate(30).setBitRate(8388608).setIFrameInterval(1).setAudioBitRate(DEFAULT_AUDIO_BIT_RATE).setAudioSampleRate(DEFAULT_AUDIO_SAMPLE_RATE).setAudioChannelCount(1).setAudioRecordSource(1).setAudioMinBufferSize(1024).setMaxResolution(size).setSurfaceOccupancyPriority(3).setTargetAspectRatio(1).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        @NonNull
        public VideoCaptureConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    public static final class Metadata {

        @Nullable
        public Location location;
    }

    public interface OnVideoSavedCallback {
        void onError(int i2, @NonNull String str, @Nullable Throwable th);

        void onVideoSaved(@NonNull OutputFileResults outputFileResults);
    }

    public static final class OutputFileOptions {
        private static final Metadata EMPTY_METADATA = new Metadata();

        @Nullable
        private final ContentResolver mContentResolver;

        @Nullable
        private final ContentValues mContentValues;

        @Nullable
        private final File mFile;

        @Nullable
        private final FileDescriptor mFileDescriptor;

        @Nullable
        private final Metadata mMetadata;

        @Nullable
        private final Uri mSaveCollection;

        public OutputFileOptions(@Nullable File file, @Nullable FileDescriptor fileDescriptor, @Nullable ContentResolver contentResolver, @Nullable Uri uri, @Nullable ContentValues contentValues, @Nullable Metadata metadata) {
            this.mFile = file;
            this.mFileDescriptor = fileDescriptor;
            this.mContentResolver = contentResolver;
            this.mSaveCollection = uri;
            this.mContentValues = contentValues;
            this.mMetadata = metadata == null ? EMPTY_METADATA : metadata;
        }

        @Nullable
        public ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        @Nullable
        public ContentValues getContentValues() {
            return this.mContentValues;
        }

        @Nullable
        public File getFile() {
            return this.mFile;
        }

        @Nullable
        public FileDescriptor getFileDescriptor() {
            return this.mFileDescriptor;
        }

        @Nullable
        public Metadata getMetadata() {
            return this.mMetadata;
        }

        @Nullable
        public Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        public boolean isSavingToFile() {
            return getFile() != null;
        }

        public boolean isSavingToFileDescriptor() {
            return getFileDescriptor() != null;
        }

        public boolean isSavingToMediaStore() {
            return (getSaveCollection() == null || getContentResolver() == null || getContentValues() == null) ? false : true;
        }

        public static final class Builder {

            @Nullable
            private ContentResolver mContentResolver;

            @Nullable
            private ContentValues mContentValues;

            @Nullable
            private File mFile;

            @Nullable
            private FileDescriptor mFileDescriptor;

            @Nullable
            private Metadata mMetadata;

            @Nullable
            private Uri mSaveCollection;

            public Builder(@NonNull File file) {
                this.mFile = file;
            }

            @NonNull
            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mFileDescriptor, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mMetadata);
            }

            @NonNull
            public Builder setMetadata(@NonNull Metadata metadata) {
                this.mMetadata = metadata;
                return this;
            }

            public Builder(@NonNull FileDescriptor fileDescriptor) {
                Preconditions.checkArgument(Build.VERSION.SDK_INT >= 26, "Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
                this.mFileDescriptor = fileDescriptor;
            }

            public Builder(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull ContentValues contentValues) {
                this.mContentResolver = contentResolver;
                this.mSaveCollection = uri;
                this.mContentValues = contentValues;
            }
        }
    }

    public static class OutputFileResults {

        @Nullable
        private Uri mSavedUri;

        public OutputFileResults(@Nullable Uri uri) {
            this.mSavedUri = uri;
        }

        @Nullable
        public Uri getSavedUri() {
            return this.mSavedUri;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface VideoCaptureError {
    }

    public static final class VideoSavedListenerWrapper implements OnVideoSavedCallback {

        @NonNull
        public Executor mExecutor;

        @NonNull
        public OnVideoSavedCallback mOnVideoSavedCallback;

        public VideoSavedListenerWrapper(@NonNull Executor executor, @NonNull OnVideoSavedCallback onVideoSavedCallback) {
            this.mExecutor = executor;
            this.mOnVideoSavedCallback = onVideoSavedCallback;
        }

        @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
        public void onError(final int i2, @NonNull final String str, @Nullable final Throwable th) {
            try {
                this.mExecutor.execute(new Runnable() { // from class: b.a.b.m1
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoCapture.VideoSavedListenerWrapper videoSavedListenerWrapper = this.a;
                        videoSavedListenerWrapper.mOnVideoSavedCallback.onError(i2, str, th);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.e(VideoCapture.TAG, "Unable to post to the supplied executor.");
            }
        }

        @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
        public void onVideoSaved(@NonNull final OutputFileResults outputFileResults) {
            try {
                this.mExecutor.execute(new Runnable() { // from class: b.a.b.n1
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoCapture.VideoSavedListenerWrapper videoSavedListenerWrapper = this.a;
                        videoSavedListenerWrapper.mOnVideoSavedCallback.onVideoSaved(outputFileResults);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.e(VideoCapture.TAG, "Unable to post to the supplied executor.");
            }
        }
    }

    public VideoCapture(@NonNull VideoCaptureConfig videoCaptureConfig) {
        super(videoCaptureConfig);
        this.mVideoBufferInfo = new MediaCodec.BufferInfo();
        this.mMuxerLock = new Object();
        this.mEndOfVideoStreamSignal = new AtomicBoolean(true);
        this.mEndOfAudioStreamSignal = new AtomicBoolean(true);
        this.mEndOfAudioVideoSignal = new AtomicBoolean(true);
        this.mAudioBufferInfo = new MediaCodec.BufferInfo();
        this.mIsFirstVideoSampleWrite = new AtomicBoolean(false);
        this.mIsFirstAudioSampleWrite = new AtomicBoolean(false);
        this.mRecordingFuture = null;
        this.mMuxerStarted = false;
        this.mIsRecording = false;
    }

    private AudioRecord autoConfigAudioRecordSource(VideoCaptureConfig videoCaptureConfig) {
        for (short s : sAudioEncoding) {
            int i2 = this.mAudioChannelCount == 1 ? 16 : 12;
            int audioRecordSource = videoCaptureConfig.getAudioRecordSource();
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(this.mAudioSampleRate, i2, s);
                if (minBufferSize <= 0) {
                    minBufferSize = videoCaptureConfig.getAudioMinBufferSize();
                }
                int i3 = minBufferSize;
                AudioRecord audioRecord = new AudioRecord(audioRecordSource, this.mAudioSampleRate, i2, s, i3 * 2);
                if (audioRecord.getState() == 1) {
                    this.mAudioBufferSize = i3;
                    Logger.i(TAG, "source: " + audioRecordSource + " audioSampleRate: " + this.mAudioSampleRate + " channelConfig: " + i2 + " audioFormat: " + ((int) s) + " bufferSize: " + i3);
                    return audioRecord;
                }
                continue;
            } catch (Exception e2) {
                Logger.e(TAG, "Exception, keep trying.", e2);
            }
        }
        return null;
    }

    private MediaFormat createAudioMediaFormat() {
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(AUDIO_MIME_TYPE, this.mAudioSampleRate, this.mAudioChannelCount);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        mediaFormatCreateAudioFormat.setInteger("bitrate", this.mAudioBitRate);
        return mediaFormatCreateAudioFormat;
    }

    private static MediaFormat createMediaFormat(VideoCaptureConfig videoCaptureConfig, Size size) {
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(VIDEO_MIME_TYPE, size.getWidth(), size.getHeight());
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", videoCaptureConfig.getBitRate());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", videoCaptureConfig.getVideoFrameRate());
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", videoCaptureConfig.getIFrameInterval());
        return mediaFormatCreateVideoFormat;
    }

    private ByteBuffer getInputBuffer(MediaCodec mediaCodec, int i2) {
        return mediaCodec.getInputBuffer(i2);
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i2) {
        return mediaCodec.getOutputBuffer(i2);
    }

    @NonNull
    @SuppressLint({"UnsafeNewApiCall"})
    private MediaMuxer initMediaMuxer(@NonNull OutputFileOptions outputFileOptions) throws Throwable {
        MediaMuxer mediaMuxer;
        if (outputFileOptions.isSavingToFile()) {
            File file = outputFileOptions.getFile();
            this.mSavedVideoUri = Uri.fromFile(outputFileOptions.getFile());
            return new MediaMuxer(file.getAbsolutePath(), 0);
        }
        if (outputFileOptions.isSavingToFileDescriptor()) {
            if (Build.VERSION.SDK_INT < 26) {
                throw new IllegalArgumentException("Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
            }
            mediaMuxer = new MediaMuxer(outputFileOptions.getFileDescriptor(), 0);
        } else {
            if (!outputFileOptions.isSavingToMediaStore()) {
                throw new IllegalArgumentException("The OutputFileOptions should assign before recording");
            }
            Uri uriInsert = outputFileOptions.getContentResolver().insert(outputFileOptions.getSaveCollection(), outputFileOptions.getContentValues() != null ? new ContentValues(outputFileOptions.getContentValues()) : new ContentValues());
            this.mSavedVideoUri = uriInsert;
            if (uriInsert == null) {
                throw new IOException("Invalid Uri!");
            }
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.mParcelFileDescriptor = outputFileOptions.getContentResolver().openFileDescriptor(this.mSavedVideoUri, "rw");
                    return new MediaMuxer(this.mParcelFileDescriptor.getFileDescriptor(), 0);
                }
                String absolutePathFromUri = VideoUtil.getAbsolutePathFromUri(outputFileOptions.getContentResolver(), this.mSavedVideoUri);
                Logger.i(TAG, "Saved Location Path: " + absolutePathFromUri);
                mediaMuxer = new MediaMuxer(absolutePathFromUri, 0);
            } catch (IOException e2) {
                this.mSavedVideoUri = null;
                throw e2;
            }
        }
        return mediaMuxer;
    }

    @UiThread
    private void releaseCameraSurface(final boolean z) {
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface == null) {
            return;
        }
        final MediaCodec mediaCodec = this.mVideoEncoder;
        deferrableSurface.close();
        this.mDeferrableSurface.getTerminationFuture().addListener(new Runnable() { // from class: b.a.b.o1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z2 = z;
                MediaCodec mediaCodec2 = mediaCodec;
                int i2 = VideoCapture.ERROR_UNKNOWN;
                if (!z2 || mediaCodec2 == null) {
                    return;
                }
                mediaCodec2.release();
            }
        }, CameraXExecutors.mainThreadExecutor());
        if (z) {
            this.mVideoEncoder = null;
        }
        this.mCameraSurface = null;
        this.mDeferrableSurface = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: releaseResources, reason: merged with bridge method [inline-methods] */
    public void a() {
        this.mVideoHandlerThread.quitSafely();
        this.mAudioHandlerThread.quitSafely();
        MediaCodec mediaCodec = this.mAudioEncoder;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.mAudioEncoder = null;
        }
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            audioRecord.release();
            this.mAudioRecorder = null;
        }
        if (this.mCameraSurface != null) {
            releaseCameraSurface(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        r7.mAudioChannelCount = r4.audioChannels;
        r7.mAudioSampleRate = r4.audioSampleRate;
        r7.mAudioBitRate = r4.audioBitRate;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setAudioParametersByCamcorderProfile(android.util.Size r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            int[] r1 = androidx.camera.core.VideoCapture.CamcorderQuality     // Catch: java.lang.NumberFormatException -> L3d
            int r2 = r1.length     // Catch: java.lang.NumberFormatException -> L3d
            r3 = 0
        L5:
            if (r3 >= r2) goto L44
            r4 = r1[r3]     // Catch: java.lang.NumberFormatException -> L3d
            int r5 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.NumberFormatException -> L3d
            boolean r5 = android.media.CamcorderProfile.hasProfile(r5, r4)     // Catch: java.lang.NumberFormatException -> L3d
            if (r5 == 0) goto L3a
            int r5 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.NumberFormatException -> L3d
            android.media.CamcorderProfile r4 = android.media.CamcorderProfile.get(r5, r4)     // Catch: java.lang.NumberFormatException -> L3d
            int r5 = r8.getWidth()     // Catch: java.lang.NumberFormatException -> L3d
            int r6 = r4.videoFrameWidth     // Catch: java.lang.NumberFormatException -> L3d
            if (r5 != r6) goto L3a
            int r5 = r8.getHeight()     // Catch: java.lang.NumberFormatException -> L3d
            int r6 = r4.videoFrameHeight     // Catch: java.lang.NumberFormatException -> L3d
            if (r5 != r6) goto L3a
            int r8 = r4.audioChannels     // Catch: java.lang.NumberFormatException -> L3d
            r7.mAudioChannelCount = r8     // Catch: java.lang.NumberFormatException -> L3d
            int r8 = r4.audioSampleRate     // Catch: java.lang.NumberFormatException -> L3d
            r7.mAudioSampleRate = r8     // Catch: java.lang.NumberFormatException -> L3d
            int r8 = r4.audioBitRate     // Catch: java.lang.NumberFormatException -> L3d
            r7.mAudioBitRate = r8     // Catch: java.lang.NumberFormatException -> L3d
            r8 = 1
            r0 = 1
            goto L44
        L3a:
            int r3 = r3 + 1
            goto L5
        L3d:
            java.lang.String r8 = "VideoCapture"
            java.lang.String r9 = "The camera Id is not an integer because the camera may be a removable device. Use the default values for the audio related settings."
            androidx.camera.core.Logger.i(r8, r9)
        L44:
            if (r0 != 0) goto L5e
            androidx.camera.core.impl.UseCaseConfig r8 = r7.getCurrentConfig()
            androidx.camera.core.impl.VideoCaptureConfig r8 = (androidx.camera.core.impl.VideoCaptureConfig) r8
            int r9 = r8.getAudioChannelCount()
            r7.mAudioChannelCount = r9
            int r9 = r8.getAudioSampleRate()
            r7.mAudioSampleRate = r9
            int r8 = r8.getAudioBitRate()
            r7.mAudioBitRate = r8
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.VideoCapture.setAudioParametersByCamcorderProfile(android.util.Size, java.lang.String):void");
    }

    private boolean writeAudioEncodedBuffer(int i2) {
        ByteBuffer outputBuffer = getOutputBuffer(this.mAudioEncoder, i2);
        outputBuffer.position(this.mAudioBufferInfo.offset);
        if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0) {
            MediaCodec.BufferInfo bufferInfo = this.mAudioBufferInfo;
            if (bufferInfo.size > 0 && bufferInfo.presentationTimeUs > 0) {
                try {
                    synchronized (this.mMuxerLock) {
                        if (!this.mIsFirstAudioSampleWrite.get()) {
                            Logger.i(TAG, "First audio sample written.");
                            this.mIsFirstAudioSampleWrite.set(true);
                        }
                        this.mMuxer.writeSampleData(this.mAudioTrackIndex, outputBuffer, this.mAudioBufferInfo);
                    }
                } catch (Exception e2) {
                    StringBuilder sbR = c.a.a.a.a.r("audio error:size=");
                    sbR.append(this.mAudioBufferInfo.size);
                    sbR.append("/offset=");
                    sbR.append(this.mAudioBufferInfo.offset);
                    sbR.append("/timeUs=");
                    sbR.append(this.mAudioBufferInfo.presentationTimeUs);
                    Logger.e(TAG, sbR.toString());
                    e2.printStackTrace();
                }
            }
        }
        this.mAudioEncoder.releaseOutputBuffer(i2, false);
        return (this.mAudioBufferInfo.flags & 4) != 0;
    }

    private boolean writeVideoEncodedBuffer(int i2) {
        if (i2 < 0) {
            Logger.e(TAG, "Output buffer should not have negative index: " + i2);
            return false;
        }
        ByteBuffer outputBuffer = this.mVideoEncoder.getOutputBuffer(i2);
        if (outputBuffer == null) {
            Logger.d(TAG, "OutputBuffer was null.");
            return false;
        }
        if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0) {
            MediaCodec.BufferInfo bufferInfo = this.mVideoBufferInfo;
            if (bufferInfo.size > 0) {
                outputBuffer.position(bufferInfo.offset);
                MediaCodec.BufferInfo bufferInfo2 = this.mVideoBufferInfo;
                outputBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                this.mVideoBufferInfo.presentationTimeUs = System.nanoTime() / 1000;
                synchronized (this.mMuxerLock) {
                    if (!this.mIsFirstVideoSampleWrite.get()) {
                        Logger.i(TAG, "First video sample written.");
                        this.mIsFirstVideoSampleWrite.set(true);
                    }
                    this.mMuxer.writeSampleData(this.mVideoTrackIndex, outputBuffer, this.mVideoBufferInfo);
                }
            }
        }
        this.mVideoEncoder.releaseOutputBuffer(i2, false);
        return (this.mVideoBufferInfo.flags & 4) != 0;
    }

    public boolean audioEncode(OnVideoSavedCallback onVideoSavedCallback) {
        boolean zWriteAudioEncodedBuffer = false;
        while (!zWriteAudioEncodedBuffer && this.mIsRecording) {
            if (this.mEndOfAudioStreamSignal.get()) {
                this.mEndOfAudioStreamSignal.set(false);
                this.mIsRecording = false;
            }
            MediaCodec mediaCodec = this.mAudioEncoder;
            if (mediaCodec != null && this.mAudioRecorder != null) {
                int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1L);
                if (iDequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = getInputBuffer(this.mAudioEncoder, iDequeueInputBuffer);
                    inputBuffer.clear();
                    int i2 = this.mAudioRecorder.read(inputBuffer, this.mAudioBufferSize);
                    if (i2 > 0) {
                        this.mAudioEncoder.queueInputBuffer(iDequeueInputBuffer, 0, i2, System.nanoTime() / 1000, this.mIsRecording ? 0 : 4);
                    }
                }
                do {
                    int iDequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(this.mAudioBufferInfo, 0L);
                    if (iDequeueOutputBuffer == -2) {
                        synchronized (this.mMuxerLock) {
                            int iAddTrack = this.mMuxer.addTrack(this.mAudioEncoder.getOutputFormat());
                            this.mAudioTrackIndex = iAddTrack;
                            if (iAddTrack >= 0 && this.mVideoTrackIndex >= 0) {
                                this.mMuxerStarted = true;
                                this.mMuxer.start();
                            }
                        }
                    } else if (iDequeueOutputBuffer != -1) {
                        zWriteAudioEncodedBuffer = writeAudioEncodedBuffer(iDequeueOutputBuffer);
                    }
                    if (iDequeueOutputBuffer >= 0) {
                    }
                } while (!zWriteAudioEncodedBuffer);
            }
        }
        try {
            Logger.i(TAG, "audioRecorder stop");
            this.mAudioRecorder.stop();
        } catch (IllegalStateException e2) {
            onVideoSavedCallback.onError(1, "Audio recorder stop failed!", e2);
        }
        try {
            this.mAudioEncoder.stop();
        } catch (IllegalStateException e3) {
            onVideoSavedCallback.onError(1, "Audio encoder stop failed!", e3);
        }
        Logger.i(TAG, "Audio encode thread end");
        this.mEndOfVideoStreamSignal.set(true);
        return false;
    }

    public /* synthetic */ void b() {
        this.mRecordingFuture = null;
        if (getCamera() != null) {
            setupEncoder(getCameraId(), getAttachedSurfaceResolution());
            notifyReset();
        }
    }

    @Override // androidx.camera.core.UseCase
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getDefaultConfig(boolean z, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE);
        if (z) {
            config = r.a(config, DEFAULT_CONFIG.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(@NonNull Config config) {
        return Builder.fromConfig(config);
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onAttached() {
        this.mVideoHandlerThread = new HandlerThread("CameraX-video encoding thread");
        this.mAudioHandlerThread = new HandlerThread("CameraX-audio encoding thread");
        this.mVideoHandlerThread.start();
        this.mVideoHandler = new Handler(this.mVideoHandlerThread.getLooper());
        this.mAudioHandlerThread.start();
        this.mAudioHandler = new Handler(this.mAudioHandlerThread.getLooper());
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDetached() {
        stopRecording();
        a<Void> aVar = this.mRecordingFuture;
        if (aVar != null) {
            aVar.addListener(new Runnable() { // from class: b.a.b.t1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a();
                }
            }, CameraXExecutors.mainThreadExecutor());
        } else {
            a();
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public void onStateDetached() {
        stopRecording();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Size onSuggestedResolutionUpdated(@NonNull Size size) {
        if (this.mCameraSurface != null) {
            this.mVideoEncoder.stop();
            this.mVideoEncoder.release();
            this.mAudioEncoder.stop();
            this.mAudioEncoder.release();
            releaseCameraSurface(false);
        }
        try {
            this.mVideoEncoder = MediaCodec.createEncoderByType(VIDEO_MIME_TYPE);
            this.mAudioEncoder = MediaCodec.createEncoderByType(AUDIO_MIME_TYPE);
            setupEncoder(getCameraId(), size);
            return size;
        } catch (IOException e2) {
            StringBuilder sbR = c.a.a.a.a.r("Unable to create MediaCodec due to: ");
            sbR.append(e2.getCause());
            throw new IllegalStateException(sbR.toString());
        }
    }

    public void setTargetRotation(int i2) {
        setTargetRotationInternal(i2);
    }

    @UiThread
    public void setupEncoder(@NonNull final String str, @NonNull final Size size) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getCurrentConfig();
        this.mVideoEncoder.reset();
        this.mVideoEncoder.configure(createMediaFormat(videoCaptureConfig, size), (Surface) null, (MediaCrypto) null, 1);
        if (this.mCameraSurface != null) {
            releaseCameraSurface(false);
        }
        final Surface surfaceCreateInputSurface = this.mVideoEncoder.createInputSurface();
        this.mCameraSurface = surfaceCreateInputSurface;
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(videoCaptureConfig);
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(this.mCameraSurface);
        this.mDeferrableSurface = immediateSurface;
        a<Void> terminationFuture = immediateSurface.getTerminationFuture();
        Objects.requireNonNull(surfaceCreateInputSurface);
        terminationFuture.addListener(new Runnable() { // from class: b.a.b.t0
            @Override // java.lang.Runnable
            public final void run() {
                surfaceCreateInputSurface.release();
            }
        }, CameraXExecutors.mainThreadExecutor());
        builderCreateFrom.addSurface(this.mDeferrableSurface);
        builderCreateFrom.addErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.VideoCapture.1
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public void onError(@NonNull SessionConfig sessionConfig, @NonNull SessionConfig.SessionError sessionError) {
                if (VideoCapture.this.isCurrentCamera(str)) {
                    VideoCapture.this.setupEncoder(str, size);
                    VideoCapture.this.notifyReset();
                }
            }
        });
        updateSessionConfig(builderCreateFrom.build());
        setAudioParametersByCamcorderProfile(size, str);
        this.mAudioEncoder.reset();
        this.mAudioEncoder.configure(createAudioMediaFormat(), (Surface) null, (MediaCrypto) null, 1);
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            audioRecord.release();
        }
        AudioRecord audioRecordAutoConfigAudioRecordSource = autoConfigAudioRecordSource(videoCaptureConfig);
        this.mAudioRecorder = audioRecordAutoConfigAudioRecordSource;
        if (audioRecordAutoConfigAudioRecordSource == null) {
            Logger.e(TAG, "AudioRecord object cannot initialized correctly!");
        }
        this.mVideoTrackIndex = -1;
        this.mAudioTrackIndex = -1;
        this.mIsRecording = false;
    }

    public void startRecording(@NonNull final OutputFileOptions outputFileOptions, @NonNull final Executor executor, @NonNull final OnVideoSavedCallback onVideoSavedCallback) {
        Location location;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: b.a.b.k1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.startRecording(outputFileOptions, executor, onVideoSavedCallback);
                }
            });
            return;
        }
        Logger.i(TAG, "startRecording");
        this.mIsFirstVideoSampleWrite.set(false);
        this.mIsFirstAudioSampleWrite.set(false);
        final VideoSavedListenerWrapper videoSavedListenerWrapper = new VideoSavedListenerWrapper(executor, onVideoSavedCallback);
        CameraInternal camera = getCamera();
        if (camera == null) {
            videoSavedListenerWrapper.onError(5, "Not bound to a Camera [" + this + "]", null);
            return;
        }
        if (!this.mEndOfAudioVideoSignal.get()) {
            videoSavedListenerWrapper.onError(3, "It is still in video recording!", null);
            return;
        }
        try {
            this.mAudioRecorder.startRecording();
            final AtomicReference atomicReference = new AtomicReference();
            this.mRecordingFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.b.r1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    AtomicReference atomicReference2 = atomicReference;
                    int i2 = VideoCapture.ERROR_UNKNOWN;
                    atomicReference2.set(completer);
                    return "startRecording";
                }
            });
            final CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
            this.mRecordingFuture.addListener(new Runnable() { // from class: b.a.b.p1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            }, CameraXExecutors.mainThreadExecutor());
            try {
                Logger.i(TAG, "videoEncoder start");
                this.mVideoEncoder.start();
                Logger.i(TAG, "audioEncoder start");
                this.mAudioEncoder.start();
                try {
                    synchronized (this.mMuxerLock) {
                        MediaMuxer mediaMuxerInitMediaMuxer = initMediaMuxer(outputFileOptions);
                        this.mMuxer = mediaMuxerInitMediaMuxer;
                        Preconditions.checkNotNull(mediaMuxerInitMediaMuxer);
                        this.mMuxer.setOrientationHint(getRelativeRotation(camera));
                        Metadata metadata = outputFileOptions.getMetadata();
                        if (metadata != null && (location = metadata.location) != null) {
                            this.mMuxer.setLocation((float) location.getLatitude(), (float) metadata.location.getLongitude());
                        }
                    }
                    this.mEndOfVideoStreamSignal.set(false);
                    this.mEndOfAudioStreamSignal.set(false);
                    this.mEndOfAudioVideoSignal.set(false);
                    this.mIsRecording = true;
                    notifyActive();
                    this.mAudioHandler.post(new Runnable() { // from class: b.a.b.l1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.audioEncode(videoSavedListenerWrapper);
                        }
                    });
                    final String cameraId = getCameraId();
                    final Size attachedSurfaceResolution = getAttachedSurfaceResolution();
                    this.mVideoHandler.post(new Runnable() { // from class: b.a.b.q1
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoCapture videoCapture = this.a;
                            VideoCapture.OnVideoSavedCallback onVideoSavedCallback2 = videoSavedListenerWrapper;
                            String str = cameraId;
                            Size size = attachedSurfaceResolution;
                            CallbackToFutureAdapter.Completer completer2 = completer;
                            if (!videoCapture.videoEncode(onVideoSavedCallback2, str, size)) {
                                onVideoSavedCallback2.onVideoSaved(new VideoCapture.OutputFileResults(videoCapture.mSavedVideoUri));
                                videoCapture.mSavedVideoUri = null;
                            }
                            completer2.set(null);
                        }
                    });
                } catch (IOException e2) {
                    completer.set(null);
                    videoSavedListenerWrapper.onError(2, "MediaMuxer creation failed!", e2);
                }
            } catch (IllegalStateException e3) {
                completer.set(null);
                videoSavedListenerWrapper.onError(1, "Audio/Video encoder start fail", e3);
            }
        } catch (IllegalStateException e4) {
            videoSavedListenerWrapper.onError(1, "AudioRecorder start fail", e4);
        }
    }

    public void stopRecording() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: b.a.b.s1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.stopRecording();
                }
            });
            return;
        }
        Logger.i(TAG, "stopRecording");
        notifyInactive();
        if (this.mEndOfAudioVideoSignal.get() || !this.mIsRecording) {
            return;
        }
        this.mEndOfAudioStreamSignal.set(true);
    }

    public boolean videoEncode(@NonNull OnVideoSavedCallback onVideoSavedCallback, @NonNull String str, @NonNull Size size) {
        boolean zWriteVideoEncodedBuffer = false;
        boolean z = false;
        while (!zWriteVideoEncodedBuffer && !z) {
            if (this.mEndOfVideoStreamSignal.get()) {
                this.mVideoEncoder.signalEndOfInputStream();
                this.mEndOfVideoStreamSignal.set(false);
            }
            int iDequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(this.mVideoBufferInfo, 10000L);
            if (iDequeueOutputBuffer == -2) {
                if (this.mMuxerStarted) {
                    onVideoSavedCallback.onError(1, "Unexpected change in video encoding format.", null);
                    z = true;
                }
                synchronized (this.mMuxerLock) {
                    int iAddTrack = this.mMuxer.addTrack(this.mVideoEncoder.getOutputFormat());
                    this.mVideoTrackIndex = iAddTrack;
                    if (this.mAudioTrackIndex >= 0 && iAddTrack >= 0) {
                        this.mMuxerStarted = true;
                        Logger.i(TAG, "media mMuxer start");
                        this.mMuxer.start();
                    }
                }
            } else if (iDequeueOutputBuffer != -1) {
                zWriteVideoEncodedBuffer = writeVideoEncodedBuffer(iDequeueOutputBuffer);
            }
        }
        try {
            Logger.i(TAG, "videoEncoder stop");
            this.mVideoEncoder.stop();
        } catch (IllegalStateException e2) {
            onVideoSavedCallback.onError(1, "Video encoder stop failed!", e2);
            z = true;
        }
        try {
            synchronized (this.mMuxerLock) {
                MediaMuxer mediaMuxer = this.mMuxer;
                if (mediaMuxer != null) {
                    if (this.mMuxerStarted) {
                        mediaMuxer.stop();
                    }
                    this.mMuxer.release();
                    this.mMuxer = null;
                }
            }
        } catch (IllegalStateException e3) {
            onVideoSavedCallback.onError(2, "Muxer stop failed!", e3);
            z = true;
        }
        ParcelFileDescriptor parcelFileDescriptor = this.mParcelFileDescriptor;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
                this.mParcelFileDescriptor = null;
            } catch (IOException e4) {
                onVideoSavedCallback.onError(2, "File descriptor close failed!", e4);
                z = true;
            }
        }
        this.mMuxerStarted = false;
        this.mEndOfAudioVideoSignal.set(true);
        Logger.i(TAG, "Video encode thread end.");
        return z;
    }
}
