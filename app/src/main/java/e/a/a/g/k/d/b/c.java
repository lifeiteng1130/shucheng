package e.a.a.g.k.d.b;

import f.v;
import io.legado.app.data.entities.RssSource;
import io.legado.app.ui.rss.source.edit.RssSourceEditActivity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RssSourceEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends f.c0.c.k implements f.c0.b.l<RssSource, v> {
    public final /* synthetic */ RssSourceEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(RssSourceEditActivity rssSourceEditActivity) {
        super(1);
        this.this$0 = rssSourceEditActivity;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(RssSource rssSource) {
        invoke2(rssSource);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull RssSource rssSource) {
        f.c0.c.j.e(rssSource, "source");
        RssSourceEditActivity rssSourceEditActivity = this.this$0;
        int i2 = RssSourceEditActivity.f7540g;
        rssSourceEditActivity.Z0(rssSource);
    }
}
