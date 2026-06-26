package e.a.a.g.k.d.c;

import android.content.DialogInterface;
import io.legado.app.ui.rss.source.manage.RssSourceActivity;
import io.legado.app.ui.rss.source.manage.RssSourceAdapter;
import io.legado.app.ui.rss.source.manage.RssSourceViewModel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RssSourceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ RssSourceActivity this$0;

    /* JADX INFO: compiled from: RssSourceActivity.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ RssSourceActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RssSourceActivity rssSourceActivity) {
            super(1);
            this.this$0 = rssSourceActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            RssSourceViewModel rssSourceViewModelT0 = this.this$0.T0();
            RssSourceAdapter rssSourceAdapter = this.this$0.adapter;
            if (rssSourceAdapter != null) {
                rssSourceViewModelT0.g(rssSourceAdapter.A());
            } else {
                f.c0.c.j.m("adapter");
                throw null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(RssSourceActivity rssSourceActivity) {
        super(1);
        this.this$0 = rssSourceActivity;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        hVar.m(new a(this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
