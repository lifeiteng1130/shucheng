package e.a.a.g.k.c;

import f.v;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadRssViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends f.c0.c.k implements f.c0.b.l<Request.Builder, v> {
    public final /* synthetic */ String $data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(String str) {
        super(1);
        this.$data = str;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(Request.Builder builder) {
        invoke2(builder);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Request.Builder builder) {
        f.c0.c.j.e(builder, "$this$newCall");
        builder.url(this.$data);
    }
}
