package e.a.a.g.e;

import e.a.a.d.u.b;
import g.b.k0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BackupConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends f.c0.c.k implements f.c0.b.a<f.v> {
    public final /* synthetic */ String $path;

    /* JADX INFO: compiled from: BackupConfigFragment.kt */
    @DebugMetadata(c = "io.legado.app.ui.config.BackupConfigFragment$restoreUsePermission$1$1", f = "BackupConfigFragment.kt", i = {}, l = {290, 291}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
        public final /* synthetic */ String $path;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$path = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$path, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(f.v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                e.a.a.d.e.a.o(this.$path);
                e.a.a.d.w.q qVar = e.a.a.d.w.q.a;
                String str = this.$path;
                this.label = 1;
                k0 k0Var = k0.f6264c;
                if (c.b.a.m.f.f6(k0.f6263b, new e.a.a.d.w.r(str, null), this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c.b.a.m.f.E5(obj);
                    return f.v.a;
                }
                c.b.a.m.f.E5(obj);
            }
            e.a.a.d.w.q qVar2 = e.a.a.d.w.q.a;
            String str2 = this.$path;
            this.label = 2;
            if (qVar2.d(str2, this) == aVar) {
                return aVar;
            }
            return f.v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(String str) {
        super(0);
        this.$path = str;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new a(this.$path, null), 3);
    }
}
