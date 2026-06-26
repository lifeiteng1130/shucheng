package e.a.a.g.d.i;

import io.legado.app.ui.book.read.ReadMenu;

/* JADX INFO: compiled from: ReadMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends f.c0.c.k implements f.c0.b.a<f.v> {
    public final /* synthetic */ ReadMenu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(ReadMenu readMenu) {
        super(0);
        this.this$0 = readMenu;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getCallBack().S();
    }
}
