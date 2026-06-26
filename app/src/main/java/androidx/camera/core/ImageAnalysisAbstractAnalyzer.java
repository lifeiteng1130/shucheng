package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import c.e.b.a.a.a;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private final Object mAnalyzerLock = new Object();
    public boolean mIsAttached = true;
    private volatile int mRelativeRotation;

    @GuardedBy("mAnalyzerLock")
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;

    @GuardedBy("mAnalyzerLock")
    private Executor mUserExecutor;

    public /* synthetic */ void a(ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        if (!this.mIsAttached) {
            completer.setException(new OperationCanceledException("ImageAnalysis is detached"));
        } else {
            analyzer.analyze(new SettableImageProxy(imageProxy, ImmutableImageInfo.create(imageProxy.getImageInfo().getTagBundle(), imageProxy.getImageInfo().getTimestamp(), this.mRelativeRotation)));
            completer.set(null);
        }
    }

    @Nullable
    public abstract ImageProxy acquireImage(@NonNull ImageReaderProxy imageReaderProxy);

    public a<Void> analyzeImage(final ImageProxy imageProxy) {
        final Executor executor;
        final ImageAnalysis.Analyzer analyzer;
        synchronized (this.mAnalyzerLock) {
            executor = this.mUserExecutor;
            analyzer = this.mSubscribedAnalyzer;
        }
        return (analyzer == null || executor == null) ? Futures.immediateFailedFuture(new OperationCanceledException("No analyzer or executor currently set.")) : CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.b.s
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                final ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.a;
                Executor executor2 = executor;
                final ImageProxy imageProxy2 = imageProxy;
                final ImageAnalysis.Analyzer analyzer2 = analyzer;
                Objects.requireNonNull(imageAnalysisAbstractAnalyzer);
                executor2.execute(new Runnable() { // from class: b.a.b.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageAnalysisAbstractAnalyzer.a(imageProxy2, analyzer2, completer);
                    }
                });
                return "analyzeImage";
            }
        });
    }

    public void attach() {
        this.mIsAttached = true;
    }

    public abstract void clearCache();

    public void detach() {
        this.mIsAttached = false;
        clearCache();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireImage = acquireImage(imageReaderProxy);
            if (imageProxyAcquireImage != null) {
                onValidImageAvailable(imageProxyAcquireImage);
            }
        } catch (IllegalStateException e2) {
            Logger.e(TAG, "Failed to acquire image.", e2);
        }
    }

    public abstract void onValidImageAvailable(@NonNull ImageProxy imageProxy);

    public void setAnalyzer(@Nullable Executor executor, @Nullable ImageAnalysis.Analyzer analyzer) {
        synchronized (this.mAnalyzerLock) {
            if (analyzer == null) {
                clearCache();
                this.mSubscribedAnalyzer = analyzer;
                this.mUserExecutor = executor;
            } else {
                this.mSubscribedAnalyzer = analyzer;
                this.mUserExecutor = executor;
            }
        }
    }

    public void setRelativeRotation(int i2) {
        this.mRelativeRotation = i2;
    }
}
