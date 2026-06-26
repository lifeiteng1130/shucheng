package androidx.view;

import androidx.core.app.NotificationCompat;
import androidx.view.Lifecycle;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.f;
import f.z.j.a.g;
import g.b.a0;
import g.b.g2.m;
import g.b.k0;
import g.b.y;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0010@\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lf/v;", "register", "()V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", NotificationCompat.CATEGORY_EVENT, "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle$lifecycle_runtime_ktx_release", "()Landroidx/lifecycle/Lifecycle;", "Lf/z/f;", "coroutineContext", "Lf/z/f;", "getCoroutineContext", "()Lf/z/f;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lf/z/f;)V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {

    @NotNull
    private final f coroutineContext;

    @NotNull
    private final Lifecycle lifecycle;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1, reason: invalid class name */
    /* JADX INFO: compiled from: Lifecycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lf/v;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements p<a0, d<? super v>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass1(d dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            j.e(dVar, "completion");
            AnonymousClass1 anonymousClass1 = LifecycleCoroutineScopeImpl.this.new AnonymousClass1(dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // f.c0.b.p
        public final Object invoke(a0 a0Var, d<? super v> dVar) {
            return ((AnonymousClass1) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            a0 a0Var = (a0) this.L$0;
            if (LifecycleCoroutineScopeImpl.this.getLifecycle().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                LifecycleCoroutineScopeImpl.this.getLifecycle().addObserver(LifecycleCoroutineScopeImpl.this);
            } else {
                c.b.a.m.f.H0(a0Var.getCoroutineContext(), null, 1, null);
            }
            return v.a;
        }
    }

    public LifecycleCoroutineScopeImpl(@NotNull Lifecycle lifecycle, @NotNull f fVar) {
        j.e(lifecycle, "lifecycle");
        j.e(fVar, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = fVar;
        if (getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            c.b.a.m.f.H0(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // androidx.view.LifecycleCoroutineScope, g.b.a0
    @NotNull
    public f getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.view.LifecycleCoroutineScope
    @NotNull
    /* JADX INFO: renamed from: getLifecycle$lifecycle_runtime_ktx_release, reason: from getter */
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        j.e(source, "source");
        j.e(event, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle().removeObserver(this);
            c.b.a.m.f.H0(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        y yVar = k0.a;
        c.b.a.m.f.L3(this, m.f6207b.n(), null, new AnonymousClass1(null), 2, null);
    }
}
