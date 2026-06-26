package e.a.a.g.d.i.r1;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.TxtTocRuleDao;
import io.legado.app.data.entities.TxtTocRule;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TocRegexViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.config.TocRegexViewModel$importOnLine$1", f = "TocRegexViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
public final class z4 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ String $url;
    public int label;

    /* JADX INFO: compiled from: TocRegexViewModel.kt */
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
    public z4(String str, f.z.d<? super z4> dVar) {
        super(2, dVar);
        this.$url = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new z4(this.$url, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((z4) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Object objM11constructorimpl;
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
        try {
            Object objFromJson = e.a.a.h.n.a().fromJson(c.b.a.m.f.C5((ResponseBody) obj, "utf-8"), new e.a.a.h.y(TxtTocRule.class));
            objM11constructorimpl = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
        }
        if (f.h.m16isFailureimpl(objM11constructorimpl)) {
            objM11constructorimpl = null;
        }
        List list = (List) objM11constructorimpl;
        if (list == null) {
            return null;
        }
        TxtTocRuleDao txtTocRuleDao = AppDatabaseKt.getAppDb().getTxtTocRuleDao();
        Object[] array = list.toArray(new TxtTocRule[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        TxtTocRule[] txtTocRuleArr = (TxtTocRule[]) array;
        txtTocRuleDao.insert((TxtTocRule[]) Arrays.copyOf(txtTocRuleArr, txtTocRuleArr.length));
        return f.v.a;
    }
}
