package e.a.a.g.b;

import io.legado.app.ui.association.ImportBookSourceDialog;

/* JADX INFO: compiled from: ImportBookSourceDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends f.c0.c.k implements f.c0.b.a<f.v> {
    public final /* synthetic */ e.a.a.g.m.k.k $waitDialog;
    public final /* synthetic */ ImportBookSourceDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(e.a.a.g.m.k.k kVar, ImportBookSourceDialog importBookSourceDialog) {
        super(0);
        this.$waitDialog = kVar;
        this.this$0 = importBookSourceDialog;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$waitDialog.dismiss();
        this.this$0.dismissAllowingStateLoss();
    }
}
