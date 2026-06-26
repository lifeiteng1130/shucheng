package androidx.view;

import androidx.core.app.NotificationCompat;
import androidx.view.Lifecycle;
import c.b.a.m.f;
import f.c0.b.a;
import f.c0.c.j;
import f.c0.c.k;
import f.h;
import f.z.d;
import g.b.g2.m;
import g.b.i;
import g.b.k0;
import g.b.o1;
import g.b.y;
import kotlin.Metadata;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001a-\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a5\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\r\u001a-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000e\u001a-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000e\u001a-\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\f2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000e\u001a5\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0081Hø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0007\u001aC\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0081@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"R", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function0;", "block", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lf/c0/b/a;Lf/z/d;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lf/c0/b/a;Lf/z/d;)Ljava/lang/Object;", "withStarted", "withResumed", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lf/c0/b/a;Lf/z/d;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Lf/c0/b/a;Lf/z/d;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "", "dispatchNeeded", "Lg/b/y;", "lifecycleDispatcher", "suspendWithStateAtLeastUnchecked", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLg/b/y;Lf/c0/b/a;Lf/z/d;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    /* JADX INFO: compiled from: WithLifecycleState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"R", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class AnonymousClass2<R> extends k implements a<R> {
        public final /* synthetic */ a $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(a aVar) {
            super(0);
            this.$block = aVar;
        }

        @Override // f.c0.b.a
        public final R invoke() {
            return (R) this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1] */
    @PublishedApi
    @Nullable
    public static final <R> Object suspendWithStateAtLeastUnchecked(@NotNull final Lifecycle lifecycle, @NotNull final Lifecycle.State state, final boolean z, @NotNull final y yVar, @NotNull final a<? extends R> aVar, @NotNull d<? super R> dVar) {
        final i iVar = new i(f.j3(dVar), 1);
        iVar.w();
        final ?? r15 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.view.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Object objM11constructorimpl;
                j.e(source, "source");
                j.e(event, NotificationCompat.CATEGORY_EVENT);
                if (event != Lifecycle.Event.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        iVar.resumeWith(h.m11constructorimpl(f.m1(new LifecycleDestroyedException())));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                g.b.h hVar = iVar;
                try {
                    objM11constructorimpl = h.m11constructorimpl(aVar.invoke());
                } catch (Throwable th) {
                    objM11constructorimpl = h.m11constructorimpl(f.m1(th));
                }
                hVar.resumeWith(objM11constructorimpl);
            }
        };
        if (z) {
            yVar.dispatch(f.z.h.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$2
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r15);
                }
            });
        } else {
            lifecycle.addObserver(r15);
        }
        iVar.a(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3(r15, lifecycle, state, aVar, z, yVar));
        Object objR = iVar.r();
        if (objR == f.z.i.a.COROUTINE_SUSPENDED) {
            j.e(dVar, "frame");
        }
        return objR;
    }

    @Nullable
    public static final <R> Object withCreated(@NotNull Lifecycle lifecycle, @NotNull a<? extends R> aVar, @NotNull d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        y yVar = k0.a;
        o1 o1VarN = m.f6207b.n();
        boolean zIsDispatchNeeded = o1VarN.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, o1VarN, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    private static final Object withCreated$$forInline(@NotNull Lifecycle lifecycle, @NotNull a aVar, @NotNull d dVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        y yVar = k0.a;
        m.f6207b.n();
        throw null;
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull Lifecycle lifecycle, @NotNull a<? extends R> aVar, @NotNull d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        y yVar = k0.a;
        o1 o1VarN = m.f6207b.n();
        boolean zIsDispatchNeeded = o1VarN.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, o1VarN, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    private static final Object withResumed$$forInline(@NotNull Lifecycle lifecycle, @NotNull a aVar, @NotNull d dVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        y yVar = k0.a;
        m.f6207b.n();
        throw null;
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull Lifecycle lifecycle, @NotNull a<? extends R> aVar, @NotNull d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        y yVar = k0.a;
        o1 o1VarN = m.f6207b.n();
        boolean zIsDispatchNeeded = o1VarN.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, o1VarN, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    private static final Object withStarted$$forInline(@NotNull Lifecycle lifecycle, @NotNull a aVar, @NotNull d dVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        y yVar = k0.a;
        m.f6207b.n();
        throw null;
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull a<? extends R> aVar, @NotNull d<? super R> dVar) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        y yVar = k0.a;
        o1 o1VarN = m.f6207b.n();
        boolean zIsDispatchNeeded = o1VarN.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, o1VarN, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    private static final Object withStateAtLeast$$forInline(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull a aVar, @NotNull d dVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            y yVar = k0.a;
            m.f6207b.n();
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @PublishedApi
    @Nullable
    public static final <R> Object withStateAtLeastUnchecked(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull a<? extends R> aVar, @NotNull d<? super R> dVar) {
        y yVar = k0.a;
        o1 o1VarN = m.f6207b.n();
        boolean zIsDispatchNeeded = o1VarN.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, o1VarN, new AnonymousClass2(aVar), dVar);
    }

    @PublishedApi
    @Nullable
    private static final Object withStateAtLeastUnchecked$$forInline(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull a aVar, @NotNull d dVar) {
        y yVar = k0.a;
        m.f6207b.n();
        throw null;
    }

    @Nullable
    private static final Object withCreated$$forInline(@NotNull LifecycleOwner lifecycleOwner, @NotNull a aVar, @NotNull d dVar) {
        j.d(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        y yVar = k0.a;
        m.f6207b.n();
        throw null;
    }

    @Nullable
    private static final Object withResumed$$forInline(@NotNull LifecycleOwner lifecycleOwner, @NotNull a aVar, @NotNull d dVar) {
        j.d(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        y yVar = k0.a;
        m.f6207b.n();
        throw null;
    }

    @Nullable
    private static final Object withStarted$$forInline(@NotNull LifecycleOwner lifecycleOwner, @NotNull a aVar, @NotNull d dVar) {
        j.d(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        y yVar = k0.a;
        m.f6207b.n();
        throw null;
    }

    @Nullable
    private static final Object withStateAtLeast$$forInline(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull a aVar, @NotNull d dVar) {
        j.d(lifecycleOwner.getLifecycle(), "lifecycle");
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        y yVar = k0.a;
        m.f6207b.n();
        throw null;
    }

    @Nullable
    public static final <R> Object withCreated(@NotNull LifecycleOwner lifecycleOwner, @NotNull a<? extends R> aVar, @NotNull d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        j.d(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        y yVar = k0.a;
        o1 o1VarN = m.f6207b.n();
        boolean zIsDispatchNeeded = o1VarN.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, o1VarN, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull LifecycleOwner lifecycleOwner, @NotNull a<? extends R> aVar, @NotNull d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        j.d(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        y yVar = k0.a;
        o1 o1VarN = m.f6207b.n();
        boolean zIsDispatchNeeded = o1VarN.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, o1VarN, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull LifecycleOwner lifecycleOwner, @NotNull a<? extends R> aVar, @NotNull d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        j.d(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        y yVar = k0.a;
        o1 o1VarN = m.f6207b.n();
        boolean zIsDispatchNeeded = o1VarN.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, o1VarN, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull a<? extends R> aVar, @NotNull d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        j.d(lifecycle, "lifecycle");
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            y yVar = k0.a;
            o1 o1VarN = m.f6207b.n();
            boolean zIsDispatchNeeded = o1VarN.isDispatchNeeded(dVar.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, o1VarN, new AnonymousClass2(aVar), dVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
