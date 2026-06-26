package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.futures.Futures;
import c.e.b.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class ImmediateSurface extends DeferrableSurface {
    private final Surface mSurface;

    public ImmediateSurface(@NonNull Surface surface) {
        this.mSurface = surface;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    public a<Surface> provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }
}
