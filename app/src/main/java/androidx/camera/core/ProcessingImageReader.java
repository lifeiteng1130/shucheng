package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import c.e.b.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ProcessingImageReader implements ImageReaderProxy {
    private static final String TAG = "ProcessingImageReader";
    private final List<Integer> mCaptureIdList;

    @NonNull
    public final CaptureProcessor mCaptureProcessor;
    private FutureCallback<List<ImageProxy>> mCaptureStageReadyCallback;

    @GuardedBy("mLock")
    public CallbackToFutureAdapter.Completer<Void> mCloseCompleter;

    @GuardedBy("mLock")
    private a<Void> mCloseFuture;

    @GuardedBy("mLock")
    public boolean mClosed;

    @Nullable
    @GuardedBy("mLock")
    public Executor mExecutor;
    private ImageReaderProxy.OnImageAvailableListener mImageProcessedListener;

    @GuardedBy("mLock")
    public final MetadataImageReader mInputImageReader;

    @Nullable
    @GuardedBy("mLock")
    public ImageReaderProxy.OnImageAvailableListener mListener;
    public final Object mLock;

    @GuardedBy("mLock")
    public final ImageReaderProxy mOutputImageReader;

    @NonNull
    public final Executor mPostProcessExecutor;

    @GuardedBy("mLock")
    public boolean mProcessing;

    @NonNull
    @GuardedBy("mLock")
    public SettableImageProxyBundle mSettableImageProxyBundle;
    private String mTagBundleKey;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener;

    /* JADX INFO: renamed from: androidx.camera.core.ProcessingImageReader$2, reason: invalid class name */
    public class AnonymousClass2 implements ImageReaderProxy.OnImageAvailableListener {
        public AnonymousClass2() {
        }

        private /* synthetic */ void lambda$onImageAvailable$0(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
            onImageAvailableListener.onImageAvailable(ProcessingImageReader.this);
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
        public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
            final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
            Executor executor;
            synchronized (ProcessingImageReader.this.mLock) {
                ProcessingImageReader processingImageReader = ProcessingImageReader.this;
                onImageAvailableListener = processingImageReader.mListener;
                executor = processingImageReader.mExecutor;
                processingImageReader.mSettableImageProxyBundle.reset();
                ProcessingImageReader.this.setupSettableImageProxyBundleCallbacks();
            }
            if (onImageAvailableListener != null) {
                if (executor != null) {
                    executor.execute(new Runnable() { // from class: b.a.b.w0
                        @Override // java.lang.Runnable
                        public final void run() {
                            onImageAvailableListener.onImageAvailable(ProcessingImageReader.this);
                        }
                    });
                } else {
                    onImageAvailableListener.onImageAvailable(ProcessingImageReader.this);
                }
            }
        }
    }

    public ProcessingImageReader(int i2, int i3, int i4, int i5, @NonNull Executor executor, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor) {
        this(i2, i3, i4, i5, executor, captureBundle, captureProcessor, i4);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireLatestImage() {
        ImageProxy imageProxyAcquireLatestImage;
        synchronized (this.mLock) {
            imageProxyAcquireLatestImage = this.mOutputImageReader.acquireLatestImage();
        }
        return imageProxyAcquireLatestImage;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public ImageProxy acquireNextImage() {
        ImageProxy imageProxyAcquireNextImage;
        synchronized (this.mLock) {
            imageProxyAcquireNextImage = this.mOutputImageReader.acquireNextImage();
        }
        return imageProxyAcquireNextImage;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mListener = null;
            this.mExecutor = null;
            this.mInputImageReader.clearOnImageAvailableListener();
            this.mOutputImageReader.clearOnImageAvailableListener();
            if (!this.mProcessing) {
                this.mSettableImageProxyBundle.close();
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mOutputImageReader.clearOnImageAvailableListener();
            if (!this.mProcessing) {
                this.mInputImageReader.close();
                this.mSettableImageProxyBundle.close();
                this.mOutputImageReader.close();
                CallbackToFutureAdapter.Completer<Void> completer = this.mCloseCompleter;
                if (completer != null) {
                    completer.set(null);
                }
            }
            this.mClosed = true;
        }
    }

    @Nullable
    public CameraCaptureCallback getCameraCaptureCallback() {
        CameraCaptureCallback cameraCaptureCallback;
        synchronized (this.mLock) {
            cameraCaptureCallback = this.mInputImageReader.getCameraCaptureCallback();
        }
        return cameraCaptureCallback;
    }

    @NonNull
    public a<Void> getCloseFuture() {
        a<Void> aVarNonCancellationPropagating;
        synchronized (this.mLock) {
            if (!this.mClosed || this.mProcessing) {
                if (this.mCloseFuture == null) {
                    this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.b.x0
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            ProcessingImageReader processingImageReader = this.a;
                            synchronized (processingImageReader.mLock) {
                                processingImageReader.mCloseCompleter = completer;
                            }
                            return "ProcessingImageReader-close";
                        }
                    });
                }
                aVarNonCancellationPropagating = Futures.nonCancellationPropagating(this.mCloseFuture);
            } else {
                aVarNonCancellationPropagating = Futures.immediateFuture(null);
            }
        }
        return aVarNonCancellationPropagating;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mInputImageReader.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mOutputImageReader.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mInputImageReader.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    @Nullable
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mInputImageReader.getSurface();
        }
        return surface;
    }

    @NonNull
    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mInputImageReader.getWidth();
        }
        return width;
    }

    public void imageIncoming(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            try {
                ImageProxy imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
                if (imageProxyAcquireNextImage != null) {
                    Integer tag = imageProxyAcquireNextImage.getImageInfo().getTagBundle().getTag(this.mTagBundleKey);
                    if (this.mCaptureIdList.contains(tag)) {
                        this.mSettableImageProxyBundle.addImageProxy(imageProxyAcquireNextImage);
                    } else {
                        Logger.w(TAG, "ImageProxyBundle does not contain this id: " + tag);
                        imageProxyAcquireNextImage.close();
                    }
                }
            } catch (IllegalStateException e2) {
                Logger.e(TAG, "Failed to acquire latest image.", e2);
            }
        }
    }

    public void setCaptureBundle(@NonNull CaptureBundle captureBundle) {
        synchronized (this.mLock) {
            if (captureBundle.getCaptureStages() != null) {
                if (this.mInputImageReader.getMaxImages() < captureBundle.getCaptureStages().size()) {
                    throw new IllegalArgumentException("CaptureBundle is larger than InputImageReader.");
                }
                this.mCaptureIdList.clear();
                for (CaptureStage captureStage : captureBundle.getCaptureStages()) {
                    if (captureStage != null) {
                        this.mCaptureIdList.add(Integer.valueOf(captureStage.getId()));
                    }
                }
            }
            String string = Integer.toString(captureBundle.hashCode());
            this.mTagBundleKey = string;
            this.mSettableImageProxyBundle = new SettableImageProxyBundle(this.mCaptureIdList, string);
            setupSettableImageProxyBundleCallbacks();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mListener = (ImageReaderProxy.OnImageAvailableListener) Preconditions.checkNotNull(onImageAvailableListener);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
            this.mInputImageReader.setOnImageAvailableListener(this.mTransformedListener, executor);
            this.mOutputImageReader.setOnImageAvailableListener(this.mImageProcessedListener, executor);
        }
    }

    @GuardedBy("mLock")
    public void setupSettableImageProxyBundleCallbacks() {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.mCaptureIdList.iterator();
        while (it.hasNext()) {
            arrayList.add(this.mSettableImageProxyBundle.getImageProxy(it.next().intValue()));
        }
        Futures.addCallback(Futures.allAsList(arrayList), this.mCaptureStageReadyCallback, this.mPostProcessExecutor);
    }

    public ProcessingImageReader(int i2, int i3, int i4, int i5, @NonNull Executor executor, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor, int i6) {
        this(new MetadataImageReader(i2, i3, i4, i5), executor, captureBundle, captureProcessor, i6);
    }

    public ProcessingImageReader(@NonNull MetadataImageReader metadataImageReader, @NonNull Executor executor, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor) {
        this(metadataImageReader, executor, captureBundle, captureProcessor, metadataImageReader.getImageFormat());
    }

    public ProcessingImageReader(@NonNull MetadataImageReader metadataImageReader, @NonNull Executor executor, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor, int i2) {
        this.mLock = new Object();
        this.mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.ProcessingImageReader.1
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
                ProcessingImageReader.this.imageIncoming(imageReaderProxy);
            }
        };
        this.mImageProcessedListener = new AnonymousClass2();
        this.mCaptureStageReadyCallback = new FutureCallback<List<ImageProxy>>() { // from class: androidx.camera.core.ProcessingImageReader.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable List<ImageProxy> list) {
                synchronized (ProcessingImageReader.this.mLock) {
                    ProcessingImageReader processingImageReader = ProcessingImageReader.this;
                    if (processingImageReader.mClosed) {
                        return;
                    }
                    processingImageReader.mProcessing = true;
                    processingImageReader.mCaptureProcessor.process(processingImageReader.mSettableImageProxyBundle);
                    synchronized (ProcessingImageReader.this.mLock) {
                        ProcessingImageReader processingImageReader2 = ProcessingImageReader.this;
                        processingImageReader2.mProcessing = false;
                        if (processingImageReader2.mClosed) {
                            processingImageReader2.mInputImageReader.close();
                            ProcessingImageReader.this.mSettableImageProxyBundle.close();
                            ProcessingImageReader.this.mOutputImageReader.close();
                            CallbackToFutureAdapter.Completer<Void> completer = ProcessingImageReader.this.mCloseCompleter;
                            if (completer != null) {
                                completer.set(null);
                            }
                        }
                    }
                }
            }
        };
        this.mClosed = false;
        this.mProcessing = false;
        this.mTagBundleKey = new String();
        this.mSettableImageProxyBundle = new SettableImageProxyBundle(Collections.emptyList(), this.mTagBundleKey);
        this.mCaptureIdList = new ArrayList();
        if (metadataImageReader.getMaxImages() >= captureBundle.getCaptureStages().size()) {
            this.mInputImageReader = metadataImageReader;
            int width = metadataImageReader.getWidth();
            int height = metadataImageReader.getHeight();
            if (i2 == 256) {
                width = metadataImageReader.getWidth() * metadataImageReader.getHeight();
                height = 1;
            }
            AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance(width, height, i2, metadataImageReader.getMaxImages()));
            this.mOutputImageReader = androidImageReaderProxy;
            this.mPostProcessExecutor = executor;
            this.mCaptureProcessor = captureProcessor;
            captureProcessor.onOutputSurface(androidImageReaderProxy.getSurface(), i2);
            captureProcessor.onResolutionUpdate(new Size(metadataImageReader.getWidth(), metadataImageReader.getHeight()));
            setCaptureBundle(captureBundle);
            return;
        }
        throw new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
    }
}
