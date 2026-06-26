package e.a.a.e.c;

import f.v;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends f.c0.c.k implements f.c0.b.a<v> {
    public final /* synthetic */ String[] $deniedPermissions;
    public final /* synthetic */ l this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, String[] strArr) {
        super(0);
        this.this$0 = lVar;
        this.$deniedPermissions = strArr;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ v invoke() {
        invoke2();
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.e(this.$deniedPermissions);
    }
}
