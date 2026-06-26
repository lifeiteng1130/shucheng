package io.legado.app.utils.viewbindingdelegate;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import b.b.a;
import f.c0.b.l;
import f.c0.c.j;
import f.f0.h;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewBindingProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewBindingProperty<R, T extends ViewBinding> {

    @Deprecated
    @NotNull
    public static final Handler a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final l<R, T> f7800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public T f7801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final ViewBindingProperty<R, T>.ClearOnDestroyLifecycleObserver f7802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public R f7803e;

    /* JADX INFO: compiled from: ViewBindingProperty.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty$ClearOnDestroyLifecycleObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lf/v;", "onDestroy", "(Landroidx/lifecycle/LifecycleOwner;)V", "<init>", "(Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class ClearOnDestroyLifecycleObserver implements DefaultLifecycleObserver {
        public final /* synthetic */ ViewBindingProperty<R, T> a;

        public ClearOnDestroyLifecycleObserver(ViewBindingProperty viewBindingProperty) {
            j.e(viewBindingProperty, "this$0");
            this.a = viewBindingProperty;
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            a.a(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        @MainThread
        public void onDestroy(@NotNull LifecycleOwner owner) {
            j.e(owner, "owner");
            final ViewBindingProperty<R, T> viewBindingProperty = this.a;
            R r = viewBindingProperty.f7803e;
            if (r == null) {
                return;
            }
            viewBindingProperty.f7803e = null;
            viewBindingProperty.a(r).getLifecycle().removeObserver(viewBindingProperty.f7802d);
            ViewBindingProperty.a.post(new Runnable() { // from class: e.a.a.h.f0.a
                @Override // java.lang.Runnable
                public final void run() {
                    ViewBindingProperty viewBindingProperty2 = viewBindingProperty;
                    j.e(viewBindingProperty2, "this$0");
                    viewBindingProperty2.f7801c = null;
                }
            });
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            a.c(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            a.d(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            a.e(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            a.f(this, lifecycleOwner);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewBindingProperty(@NotNull l<? super R, ? extends T> lVar) {
        j.e(lVar, "viewBinder");
        this.f7800b = lVar;
        this.f7802d = new ClearOnDestroyLifecycleObserver(this);
    }

    @NotNull
    public abstract LifecycleOwner a(@NotNull R r);

    @MainThread
    @NotNull
    public T b(@NotNull R r, @NotNull h<?> hVar) {
        j.e(r, "thisRef");
        j.e(hVar, "property");
        T t = this.f7801c;
        if (t != null) {
            return t;
        }
        this.f7803e = r;
        Lifecycle lifecycle = a(r).getLifecycle();
        j.d(lifecycle, "getLifecycleOwner(thisRef).lifecycle");
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            a.post(new Runnable() { // from class: e.a.a.h.f0.b
                @Override // java.lang.Runnable
                public final void run() {
                    ViewBindingProperty viewBindingProperty = this.a;
                    j.e(viewBindingProperty, "this$0");
                    viewBindingProperty.f7801c = null;
                }
            });
        } else {
            lifecycle.addObserver(this.f7802d);
        }
        T tInvoke = this.f7800b.invoke(r);
        this.f7801c = tInvoke;
        return tInvoke;
    }
}
