package e.a.a.g.d.i;

/* JADX INFO: compiled from: ReadBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends f.c0.c.k implements f.c0.b.a<f.v> {
    public final /* synthetic */ f.c0.b.a<f.v> $success;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(f.c0.b.a<f.v> aVar) {
        super(0);
        this.$success = aVar;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        f.c0.b.a<f.v> aVar = this.$success;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }
}
