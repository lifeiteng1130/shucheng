package e.a.a.g.d.h;

import f.c0.b.p;
import f.c0.c.k;
import f.v;
import g.b.a0;
import io.legado.app.databinding.ActivityImportBookBinding;
import io.legado.app.ui.book.local.ImportBookActivity;
import io.legado.app.ui.book.local.ImportBookViewModel;
import java.io.File;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.local.ImportBookActivity$scanFolder$2$1", f = "ImportBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ File $file;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ImportBookActivity this$0;

    /* JADX INFO: compiled from: ImportBookActivity.kt */
    public static final class a extends k implements f.c0.b.a<v> {
        public final /* synthetic */ a0 $$this$launch;
        public final /* synthetic */ ImportBookActivity this$0;

        /* JADX INFO: renamed from: e.a.a.g.d.h.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImportBookActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.local.ImportBookActivity$scanFolder$2$1$1$1", f = "ImportBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0162a extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
            public int label;
            public final /* synthetic */ ImportBookActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0162a(ImportBookActivity importBookActivity, f.z.d<? super C0162a> dVar) {
                super(2, dVar);
                this.this$0 = importBookActivity;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new C0162a(this.this$0, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
                return ((C0162a) create(a0Var, dVar)).invokeSuspend(v.a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
                ImportBookActivity importBookActivity = this.this$0;
                int i2 = ImportBookActivity.f7126g;
                ((ActivityImportBookBinding) importBookActivity.K0()).f6517d.setAutoLoading(false);
                return v.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(a0 a0Var, ImportBookActivity importBookActivity) {
            super(0);
            this.$$this$launch = a0Var;
            this.this$0 = importBookActivity;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            c.b.a.m.f.L3(this.$$this$launch, null, null, new C0162a(this.this$0, null), 3, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ImportBookActivity importBookActivity, File file, f.z.d<? super f> dVar) {
        super(2, dVar);
        this.this$0 = importBookActivity;
        this.$file = file;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        f fVar = new f(this.this$0, this.$file, dVar);
        fVar.L$0 = obj;
        return fVar;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((f) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        a0 a0Var = (a0) this.L$0;
        ImportBookViewModel importBookViewModelT0 = this.this$0.T0();
        File file = this.$file;
        ImportBookActivity importBookActivity = this.this$0;
        importBookViewModelT0.f(file, true, importBookActivity.find, new a(a0Var, importBookActivity));
        return v.a;
    }
}
