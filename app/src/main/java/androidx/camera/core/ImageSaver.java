package androidx.camera.core;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class ImageSaver implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    private final OnImageSavedCallback mCallback;
    private final ImageProxy mImage;
    private final int mOrientation;

    @NonNull
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final Executor mSequentialIoExecutor;
    private final Executor mUserCallbackExecutor;

    /* JADX INFO: renamed from: androidx.camera.core.ImageSaver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType;

        static {
            ImageUtil.CodecFailedException.FailureType.values();
            int[] iArr = new int[3];
            $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType = iArr;
            try {
                iArr[ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.DECODE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface OnImageSavedCallback {
        void onError(@NonNull SaveError saveError, @NonNull String str, @Nullable Throwable th);

        void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults);
    }

    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    public ImageSaver(ImageProxy imageProxy, @NonNull ImageCapture.OutputFileOptions outputFileOptions, int i2, Executor executor, Executor executor2, OnImageSavedCallback onImageSavedCallback) {
        this.mImage = imageProxy;
        this.mOutputFileOptions = outputFileOptions;
        this.mOrientation = i2;
        this.mCallback = onImageSavedCallback;
        this.mUserCallbackExecutor = executor;
        this.mSequentialIoExecutor = executor2;
    }

    private void copyTempFileToOutputStream(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    fileInputStream.close();
                    return;
                }
                outputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private boolean copyTempFileToUri(@NonNull File file, @NonNull Uri uri) throws IOException {
        OutputStream outputStreamOpenOutputStream = this.mOutputFileOptions.getContentResolver().openOutputStream(uri);
        if (outputStreamOpenOutputStream == null) {
            if (outputStreamOpenOutputStream != null) {
                outputStreamOpenOutputStream.close();
            }
            return false;
        }
        try {
            copyTempFileToOutputStream(file, outputStreamOpenOutputStream);
            outputStreamOpenOutputStream.close();
            return true;
        } catch (Throwable th) {
            try {
                outputStreamOpenOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private boolean isSaveToFile() {
        return this.mOutputFileOptions.getFile() != null;
    }

    private boolean isSaveToMediaStore() {
        return (this.mOutputFileOptions.getSaveCollection() == null || this.mOutputFileOptions.getContentResolver() == null || this.mOutputFileOptions.getContentValues() == null) ? false : true;
    }

    private boolean isSaveToOutputStream() {
        return this.mOutputFileOptions.getOutputStream() != null;
    }

    private void postError(final SaveError saveError, final String str, @Nullable final Throwable th) {
        try {
            this.mUserCallbackExecutor.execute(new Runnable() { // from class: b.a.b.q0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(saveError, str, th);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.");
        }
    }

    private void postSuccess(@Nullable final Uri uri) {
        try {
            this.mUserCallbackExecutor.execute(new Runnable() { // from class: b.a.b.o0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(uri);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.");
        }
    }

    @Nullable
    private File saveImageToTempFile() {
        File fileCreateTempFile;
        SaveError saveError;
        String str;
        Throwable th;
        try {
            if (isSaveToFile()) {
                fileCreateTempFile = new File(this.mOutputFileOptions.getFile().getParent(), TEMP_FILE_PREFIX + UUID.randomUUID().toString() + TEMP_FILE_SUFFIX);
            } else {
                fileCreateTempFile = File.createTempFile(TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
            }
            try {
                ImageProxy imageProxy = this.mImage;
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    try {
                        fileOutputStream.write(ImageUtil.imageToJpegByteArray(this.mImage));
                        Exif exifCreateFromFile = Exif.createFromFile(fileCreateTempFile);
                        exifCreateFromFile.attachTimestamp();
                        if (new ExifRotationAvailability().shouldUseExifOrientation(this.mImage)) {
                            ByteBuffer buffer = this.mImage.getPlanes()[0].getBuffer();
                            buffer.rewind();
                            byte[] bArr = new byte[buffer.capacity()];
                            buffer.get(bArr);
                            exifCreateFromFile.setOrientation(Exif.createFromInputStream(new ByteArrayInputStream(bArr)).getOrientation());
                        } else {
                            exifCreateFromFile.rotate(this.mOrientation);
                        }
                        ImageCapture.Metadata metadata = this.mOutputFileOptions.getMetadata();
                        if (metadata.isReversedHorizontal()) {
                            exifCreateFromFile.flipHorizontally();
                        }
                        if (metadata.isReversedVertical()) {
                            exifCreateFromFile.flipVertically();
                        }
                        if (metadata.getLocation() != null) {
                            exifCreateFromFile.attachLocation(this.mOutputFileOptions.getMetadata().getLocation());
                        }
                        exifCreateFromFile.save();
                        fileOutputStream.close();
                        if (imageProxy != null) {
                            imageProxy.close();
                        }
                        th = null;
                        saveError = null;
                        str = null;
                    } finally {
                    }
                } catch (Throwable th2) {
                    if (imageProxy != null) {
                        try {
                            imageProxy.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (ImageUtil.CodecFailedException e2) {
                int iOrdinal = e2.getFailureType().ordinal();
                if (iOrdinal == 0) {
                    saveError = SaveError.ENCODE_FAILED;
                    str = "Failed to encode mImage";
                    th = e2;
                } else if (iOrdinal != 1) {
                    saveError = SaveError.UNKNOWN;
                    str = "Failed to transcode mImage";
                    th = e2;
                } else {
                    saveError = SaveError.CROP_FAILED;
                    str = "Failed to crop mImage";
                    th = e2;
                }
            } catch (IOException e3) {
                e = e3;
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                th = e;
            } catch (IllegalArgumentException e4) {
                e = e4;
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                th = e;
            }
            if (saveError == null) {
                return fileCreateTempFile;
            }
            postError(saveError, str, th);
            fileCreateTempFile.delete();
            return null;
        } catch (IOException e5) {
            postError(SaveError.FILE_IO_FAILED, "Failed to create temp file", e5);
            return null;
        }
    }

    private void setContentValuePending(@NonNull ContentValues contentValues, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i2));
        }
    }

    private void setUriNotPending(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            setContentValuePending(contentValues, 0);
            this.mOutputFileOptions.getContentResolver().update(uri, contentValues, null, null);
        }
    }

    public /* synthetic */ void a(SaveError saveError, String str, Throwable th) {
        this.mCallback.onError(saveError, str, th);
    }

    public /* synthetic */ void b(Uri uri) {
        this.mCallback.onImageSaved(new ImageCapture.OutputFileResults(uri));
    }

    public void copyTempFileToDestination(@NonNull File file) {
        Uri uriInsert;
        SaveError saveError;
        String str;
        Preconditions.checkNotNull(file);
        Throwable e2 = null;
        try {
            try {
                if (isSaveToMediaStore()) {
                    ContentValues contentValues = this.mOutputFileOptions.getContentValues() != null ? new ContentValues(this.mOutputFileOptions.getContentValues()) : new ContentValues();
                    setContentValuePending(contentValues, 1);
                    uriInsert = this.mOutputFileOptions.getContentResolver().insert(this.mOutputFileOptions.getSaveCollection(), contentValues);
                    try {
                        if (uriInsert == null) {
                            saveError = SaveError.FILE_IO_FAILED;
                            str = "Failed to insert URI.";
                        } else {
                            if (copyTempFileToUri(file, uriInsert)) {
                                saveError = null;
                                str = null;
                            } else {
                                saveError = SaveError.FILE_IO_FAILED;
                                str = "Failed to save to URI.";
                            }
                            setUriNotPending(uriInsert);
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        saveError = SaveError.FILE_IO_FAILED;
                        str = "Failed to write destination file.";
                    } catch (IllegalArgumentException e4) {
                        e2 = e4;
                        saveError = SaveError.FILE_IO_FAILED;
                        str = "Failed to write destination file.";
                    }
                } else {
                    if (isSaveToOutputStream()) {
                        copyTempFileToOutputStream(file, this.mOutputFileOptions.getOutputStream());
                    } else if (isSaveToFile()) {
                        File file2 = this.mOutputFileOptions.getFile();
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (!file.renameTo(file2)) {
                            saveError = SaveError.FILE_IO_FAILED;
                            str = "Failed to rename file.";
                            uriInsert = null;
                        }
                    }
                    uriInsert = null;
                    saveError = null;
                    str = null;
                }
            } finally {
                file.delete();
            }
        } catch (IOException | IllegalArgumentException e5) {
            uriInsert = null;
            e2 = e5;
        }
        if (saveError != null) {
            postError(saveError, str, e2);
        } else {
            postSuccess(uriInsert);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        final File fileSaveImageToTempFile = saveImageToTempFile();
        if (fileSaveImageToTempFile != null) {
            this.mSequentialIoExecutor.execute(new Runnable() { // from class: b.a.b.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.copyTempFileToDestination(fileSaveImageToTempFile);
                }
            });
        }
    }
}
