package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import androidx.view.Lifecycle;
import c.b.a.m.f;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.i.a;
import f.z.j.a.g;
import g.b.a0;
import g.b.f1;
import g.b.g2.m;
import g.b.k0;
import g.b.y;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: PausingDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aF\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aF\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000b\u001aF\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\t\u001aF\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u001aF\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\t\u001aF\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000b\u001aN\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/Function2;", "Lg/b/a0;", "Lf/z/d;", "", "Lkotlin/ExtensionFunctionType;", "block", "whenCreated", "(Landroidx/lifecycle/LifecycleOwner;Lf/c0/b/p;Lf/z/d;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Lf/c0/b/p;Lf/z/d;)Ljava/lang/Object;", "whenStarted", "whenResumed", "Landroidx/lifecycle/Lifecycle$State;", "minState", "whenStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lf/c0/b/p;Lf/z/d;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class PausingDispatcherKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    /* JADX INFO: compiled from: PausingDispatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lg/b/a0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {Token.COMMENT}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
    public static final class AnonymousClass2<T> extends g implements p<a0, d<? super T>, Object> {
        public final /* synthetic */ p $block;
        public final /* synthetic */ Lifecycle.State $minState;
        public final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Lifecycle lifecycle, Lifecycle.State state, p pVar, d dVar) {
            super(2, dVar);
            this.$this_whenStateAtLeast = lifecycle;
            this.$minState = state;
            this.$block = pVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            j.e(dVar, "completion");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // f.c0.b.p
        public final Object invoke(a0 a0Var, Object obj) {
            return ((AnonymousClass2) create(a0Var, (d) obj)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            LifecycleController lifecycleController;
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lifecycleController = (LifecycleController) this.L$0;
                try {
                    f.E5(obj);
                    lifecycleController.finish();
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController.finish();
                    throw th;
                }
            }
            f.E5(obj);
            f1 f1Var = (f1) ((a0) this.L$0).getCoroutineContext().get(f1.N);
            if (f1Var == null) {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
            PausingDispatcher pausingDispatcher = new PausingDispatcher();
            LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, f1Var);
            try {
                p pVar = this.$block;
                this.L$0 = lifecycleController2;
                this.label = 1;
                obj = f.f6(pausingDispatcher, pVar, this);
                if (obj == aVar) {
                    return aVar;
                }
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                throw th;
            }
        }
    }

    @Nullable
    public static final <T> Object whenCreated(@NotNull LifecycleOwner lifecycleOwner, @NotNull p<? super a0, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        j.d(lifecycle, "lifecycle");
        return whenCreated(lifecycle, pVar, dVar);
    }

    @Nullable
    public static final <T> Object whenResumed(@NotNull LifecycleOwner lifecycleOwner, @NotNull p<? super a0, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        j.d(lifecycle, "lifecycle");
        return whenResumed(lifecycle, pVar, dVar);
    }

    @Nullable
    public static final <T> Object whenStarted(@NotNull LifecycleOwner lifecycleOwner, @NotNull p<? super a0, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        j.d(lifecycle, "lifecycle");
        return whenStarted(lifecycle, pVar, dVar);
    }

    @Nullable
    public static final <T> Object whenStateAtLeast(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull p<? super a0, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar) {
        y yVar = k0.a;
        return f.f6(m.f6207b.n(), new AnonymousClass2(lifecycle, state, pVar, null), dVar);
    }

    @Nullable
    public static final <T> Object whenCreated(@NotNull Lifecycle lifecycle, @NotNull p<? super a0, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, dVar);
    }

    @Nullable
    public static final <T> Object whenResumed(@NotNull Lifecycle lifecycle, @NotNull p<? super a0, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, dVar);
    }

    @Nullable
    public static final <T> Object whenStarted(@NotNull Lifecycle lifecycle, @NotNull p<? super a0, ? super d<? super T>, ? extends Object> pVar, @NotNull d<? super T> dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, dVar);
    }
}
