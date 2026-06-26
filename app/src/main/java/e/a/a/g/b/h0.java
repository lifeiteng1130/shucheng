package e.a.a.g.b;

import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImportRssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends f.c0.c.k implements f.c0.b.l<Request.Builder, f.v> {
    public final /* synthetic */ String $url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(String str) {
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
