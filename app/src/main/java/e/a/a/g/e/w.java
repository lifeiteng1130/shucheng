package e.a.a.g.e;

import android.content.Context;
import com.tencent.bugly.beta.tinker.TinkerReport;
import e.a.a.d.u.b;
import io.legado.app.ui.config.BackupConfigFragment;
import io.wenyuange.app.release.R;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BackupConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends f.c0.c.k implements f.c0.b.a<f.v> {
    public final /* synthetic */ String $path;
    public final /* synthetic */ BackupConfigFragment this$0;

    /* JADX INFO: compiled from: BackupConfigFragment.kt */
    @DebugMetadata(c = "io.legado.app.ui.config.BackupConfigFragment$backupUsePermission$1$1", f = "BackupConfigFragment.kt", i = {}, l = {TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
        public final /* synthetic */ String $path;
        public int label;
        public final /* synthetic */ BackupConfigFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, BackupConfigFragment backupConfigFragment, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$path = str;
            this.this$0 = backupConfigFragment;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$path, this.this$0, dVar);
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
                e.a.a.d.w.i iVar = e.a.a.d.w.i.a;
                Context contextRequireContext = this.this$0.requireContext();
                f.c0.c.j.d(contextRequireContext, "requireContext()");
                String str = this.$path;
                this.label = 1;
                if (iVar.d(contextRequireContext, str, false, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
            }
            return f.v.a;
        }
    }

    /* JADX INFO: compiled from: BackupConfigFragment.kt */
    @DebugMetadata(c = "io.legado.app.ui.config.BackupConfigFragment$backupUsePermission$1$2", f = "BackupConfigFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements f.c0.b.q<g.b.a0, f.v, f.z.d<? super f.v>, Object> {
        public int label;
        public final /* synthetic */ BackupConfigFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BackupConfigFragment backupConfigFragment, f.z.d<? super b> dVar) {
            super(3, dVar);
            this.this$0 = backupConfigFragment;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull f.v vVar, @Nullable f.z.d<? super f.v> dVar) {
            return new b(this.this$0, dVar).invokeSuspend(f.v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            e.a.a.h.m.l(this.this$0, R.string.backup_success);
            return f.v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(String str, BackupConfigFragment backupConfigFragment) {
        super(0);
        this.$path = str;
        this.this$0 = backupConfigFragment;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new a(this.$path, this.this$0, null), 3).d(null, new b(this.this$0, null));
    }
}
