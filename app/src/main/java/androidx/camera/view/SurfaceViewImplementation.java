package androidx.camera.view;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import c.a.a.a.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class SurfaceViewImplementation extends PreviewViewImplementation {
    private static final String TAG = "SurfaceViewImpl";

    @Nullable
    private PreviewViewImplementation.OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
    public final SurfaceRequestCallback mSurfaceRequestCallback;
    public SurfaceView mSurfaceView;

    public class SurfaceRequestCallback implements SurfaceHolder.Callback {

        @Nullable
        private Size mCurrentSurfaceSize;

        @Nullable
        private SurfaceRequest mSurfaceRequest;

        @Nullable
        private Size mTargetSize;
        private boolean mWasSurfaceProvided = false;

        public SurfaceRequestCallback() {
        }

        private boolean canProvideSurface() {
            Size size;
            return (this.mWasSurfaceProvided || this.mSurfaceRequest == null || (size = this.mTargetSize) == null || !size.equals(this.mCurrentSurfaceSize)) ? false : true;
        }

        @UiThread
        private void cancelPreviousRequest() {
            if (this.mSurfaceRequest != null) {
                StringBuilder sbR = a.r("Request canceled: ");
                sbR.append(this.mSurfaceRequest);
                Logger.d(SurfaceViewImplementation.TAG, sbR.toString());
                this.mSurfaceRequest.willNotProvideSurface();
            }
        }

        @UiThread
        private void invalidateSurface() {
            if (this.mSurfaceRequest != null) {
                StringBuilder sbR = a.r("Surface invalidated ");
                sbR.append(this.mSurfaceRequest);
                Logger.d(SurfaceViewImplementation.TAG, sbR.toString());
                this.mSurfaceRequest.getDeferrableSurface().close();
            }
        }

        @UiThread
        private boolean tryToComplete() {
            Surface surface = SurfaceViewImplementation.this.mSurfaceView.getHolder().getSurface();
            if (!canProvideSurface()) {
                return false;
            }
            Logger.d(SurfaceViewImplementation.TAG, "Surface set on Preview.");
            this.mSurfaceRequest.provideSurface(surface, ContextCompat.getMainExecutor(SurfaceViewImplementation.this.mSurfaceView.getContext()), new Consumer() { // from class: b.a.d.n
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    SurfaceViewImplementation.SurfaceRequestCallback surfaceRequestCallback = this.a;
                    Objects.requireNonNull(surfaceRequestCallback);
                    Logger.d("SurfaceViewImpl", "Safe to release surface.");
                    SurfaceViewImplementation.this.notifySurfaceNotInUse();
                }
            });
            this.mWasSurfaceProvided = true;
            SurfaceViewImplementation.this.onSurfaceProvided();
            return true;
        }

        @UiThread
        public void setSurfaceRequest(@NonNull SurfaceRequest surfaceRequest) {
            cancelPreviousRequest();
            this.mSurfaceRequest = surfaceRequest;
            Size resolution = surfaceRequest.getResolution();
            this.mTargetSize = resolution;
            this.mWasSurfaceProvided = false;
            if (tryToComplete()) {
                return;
            }
            Logger.d(SurfaceViewImplementation.TAG, "Wait for new Surface creation.");
            SurfaceViewImplementation.this.mSurfaceView.getHolder().setFixedSize(resolution.getWidth(), resolution.getHeight());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            Logger.d(SurfaceViewImplementation.TAG, "Surface changed. Size: " + i3 + "x" + i4);
            this.mCurrentSurfaceSize = new Size(i3, i4);
            tryToComplete();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            Logger.d(SurfaceViewImplementation.TAG, "Surface created.");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            Logger.d(SurfaceViewImplementation.TAG, "Surface destroyed.");
            if (this.mWasSurfaceProvided) {
                invalidateSurface();
            } else {
                cancelPreviousRequest();
            }
            this.mWasSurfaceProvided = false;
            this.mSurfaceRequest = null;
            this.mCurrentSurfaceSize = null;
            this.mTargetSize = null;
        }
    }

    public SurfaceViewImplementation(@NonNull FrameLayout frameLayout, @NonNull PreviewTransformation previewTransformation) {
        super(frameLayout, previewTransformation);
        this.mSurfaceRequestCallback = new SurfaceRequestCallback();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    @Nullable
    public View getPreview() {
        return this.mSurfaceView;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    @Nullable
    @TargetApi(24)
    public Bitmap getPreviewBitmap() {
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.mSurfaceView.getHolder().getSurface().isValid()) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.mSurfaceView.getWidth(), this.mSurfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        SurfaceView surfaceView2 = this.mSurfaceView;
        PixelCopy.request(surfaceView2, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: b.a.d.m
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i2) {
                if (i2 == 0) {
                    Logger.d("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
                    return;
                }
                Logger.e("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i2);
            }
        }, surfaceView2.getHandler());
        return bitmapCreateBitmap;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void initializePreview() {
        Preconditions.checkNotNull(this.mParent);
        Preconditions.checkNotNull(this.mResolution);
        SurfaceView surfaceView = new SurfaceView(this.mParent.getContext());
        this.mSurfaceView = surfaceView;
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mParent.removeAllViews();
        this.mParent.addView(this.mSurfaceView);
        this.mSurfaceView.getHolder().addCallback(this.mSurfaceRequestCallback);
    }

    public void notifySurfaceNotInUse() {
        PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener = this.mOnSurfaceNotInUseListener;
        if (onSurfaceNotInUseListener != null) {
            onSurfaceNotInUseListener.onSurfaceNotInUse();
            this.mOnSurfaceNotInUseListener = null;
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onAttachedToWindow() {
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onDetachedFromWindow() {
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void onSurfaceRequested(@NonNull final SurfaceRequest surfaceRequest, @Nullable PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.mResolution = surfaceRequest.getResolution();
        this.mOnSurfaceNotInUseListener = onSurfaceNotInUseListener;
        initializePreview();
        surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor(this.mSurfaceView.getContext()), new Runnable() { // from class: b.a.d.s
            @Override // java.lang.Runnable
            public final void run() {
                this.a.notifySurfaceNotInUse();
            }
        });
        this.mSurfaceView.post(new Runnable() { // from class: b.a.d.l
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceViewImplementation surfaceViewImplementation = this.a;
                surfaceViewImplementation.mSurfaceRequestCallback.setSurfaceRequest(surfaceRequest);
            }
        });
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    @NonNull
    public c.e.b.a.a.a<Void> waitForNextFrame() {
        return Futures.immediateFuture(null);
    }
}
