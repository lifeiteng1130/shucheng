package androidx.view;

import c.b.a.m.f;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.i.a;
import f.z.j.a.g;
import g.b.a0;
import g.b.f1;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\t\u001a\u00020\b2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ9\u0010\u000b\u001a\u00020\b2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\nJ9\u0010\f\u001a\u00020\b2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nR\u0016\u0010\u0010\u001a\u00020\r8 @ X \u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScope;", "Lg/b/a0;", "Lkotlin/Function2;", "Lf/z/d;", "Lf/v;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lg/b/f1;", "launchWhenCreated", "(Lf/c0/b/p;)Lg/b/f1;", "launchWhenStarted", "launchWhenResumed", "Landroidx/lifecycle/Lifecycle;", "getLifecycle$lifecycle_runtime_ktx_release", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "()V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
public abstract class LifecycleCoroutineScope implements a0 {

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: Lifecycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lf/v;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ p $block;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(p pVar, d dVar) {
            super(2, dVar);
            this.$block = pVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            j.e(dVar, "completion");
            return LifecycleCoroutineScope.this.new AnonymousClass1(this.$block, dVar);
        }

        @Override // f.c0.b.p
        public final Object invoke(a0 a0Var, d<? super v> dVar) {
            return ((AnonymousClass1) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                Lifecycle lifecycle$lifecycle_runtime_ktx_release = LifecycleCoroutineScope.this.getLifecycle();
                p pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenCreated(lifecycle$lifecycle_runtime_ktx_release, pVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            return v.a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Lifecycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lf/v;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", f = "Lifecycle.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02521 extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ p $block;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02521(p pVar, d dVar) {
            super(2, dVar);
            this.$block = pVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            j.e(dVar, "completion");
            return LifecycleCoroutineScope.this.new C02521(this.$block, dVar);
        }

        @Override // f.c0.b.p
        public final Object invoke(a0 a0Var, d<? super v> dVar) {
            return ((C02521) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                Lifecycle lifecycle$lifecycle_runtime_ktx_release = LifecycleCoroutineScope.this.getLifecycle();
                p pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenResumed(lifecycle$lifecycle_runtime_ktx_release, pVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            return v.a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Lifecycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lf/v;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02531 extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ p $block;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02531(p pVar, d dVar) {
            super(2, dVar);
            this.$block = pVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            j.e(dVar, "completion");
            return LifecycleCoroutineScope.this.new C02531(this.$block, dVar);
        }

        @Override // f.c0.b.p
        public final Object invoke(a0 a0Var, d<? super v> dVar) {
            return ((C02531) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                Lifecycle lifecycle$lifecycle_runtime_ktx_release = LifecycleCoroutineScope.this.getLifecycle();
                p pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_runtime_ktx_release, pVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            return v.a;
        }
    }

    @Override // g.b.a0
    @NotNull
    public abstract /* synthetic */ f.z.f getCoroutineContext();

    @NotNull
    /* JADX INFO: renamed from: getLifecycle$lifecycle_runtime_ktx_release */
    public abstract Lifecycle getLifecycle();

    @NotNull
    public final f1 launchWhenCreated(@NotNull p<? super a0, ? super d<? super v>, ? extends Object> block) {
        j.e(block, "block");
        return f.L3(this, null, null, new AnonymousClass1(block, null), 3, null);
    }

    @NotNull
    public final f1 launchWhenResumed(@NotNull p<? super a0, ? super d<? super v>, ? extends Object> block) {
        j.e(block, "block");
        return f.L3(this, null, null, new C02521(block, null), 3, null);
    }

    @NotNull
    public final f1 launchWhenStarted(@NotNull p<? super a0, ? super d<? super v>, ? extends Object> block) {
        j.e(block, "block");
        return f.L3(this, null, null, new C02531(block, null), 3, null);
    }
}
