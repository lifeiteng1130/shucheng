package e.a.a.g.k.d.b;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e.a.a.h.n;
import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.RssSource;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.edit.RssSourceEditViewModel$importSource$1", f = "RssSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class g extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.l<RssSource, v> $finally;
    public final /* synthetic */ String $text;
    public int label;

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<RssSource> {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(String str, f.c0.b.l<? super RssSource, v> lVar, f.z.d<? super g> dVar) {
        super(2, dVar);
        this.$text = str;
        this.$finally = lVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new g(this.$text, this.$finally, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Object objM11constructorimpl;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String str = this.$text;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        String string = f.h0.k.R(str).toString();
        Gson gsonA = n.a();
        try {
            Type type = new a().getType();
            f.c0.c.j.d(type, "object : TypeToken<T>() {}.type");
            Object objFromJson = gsonA.fromJson(string, type);
            if (!(objFromJson instanceof RssSource)) {
                objFromJson = null;
            }
            objM11constructorimpl = f.h.m11constructorimpl((RssSource) objFromJson);
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
        }
        if (f.h.m16isFailureimpl(objM11constructorimpl)) {
            objM11constructorimpl = null;
        }
        RssSource rssSource = (RssSource) objM11constructorimpl;
        if (rssSource == null) {
            return null;
        }
        this.$finally.invoke(rssSource);
        return v.a;
    }
}
