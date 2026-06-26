package e.a.a.g.d.i.r1;

import io.legado.app.ui.book.read.config.BgTextConfigDialog;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BgTextConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.BgTextConfigDialog$importNetConfig$1", f = "BgTextConfigDialog.kt", i = {}, l = {319}, m = "invokeSuspend", n = {}, s = {})
public final class e2 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ String $url;
    public int label;
    public final /* synthetic */ BgTextConfigDialog this$0;

    /* JADX INFO: compiled from: BgTextConfigDialog.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<Request.Builder, f.v> {
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(1);
            this.$url = str;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(Request.Builder builder) {
            invoke2(builder);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Request.Builder builder) {
            f.c0.c.j.e(builder, "$this$newCall");
            builder.url(this.$url);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(String str, BgTextConfigDialog bgTextConfigDialog, f.z.d<? super e2> dVar) {
        super(2, dVar);
        this.$url = str;
        this.this$0 = bgTextConfigDialog;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new e2(this.$url, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((e2) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            OkHttpClient okHttpClientA = e.a.a.d.v.i.a();
            a aVar2 = new a(this.$url);
            this.label = 1;
            obj = c.b.a.m.f.Z3(okHttpClientA, 0, aVar2, this, 1);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
        }
        BgTextConfigDialog.Q(this.this$0, ((ResponseBody) obj).bytes());
        return f.v.a;
    }
}
