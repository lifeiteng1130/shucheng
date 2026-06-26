package e.a.a.g.f;

import f.c0.c.k;
import f.v;

/* JADX INFO: compiled from: FilePickerActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends k implements f.c0.b.a<v> {
    public final /* synthetic */ f.c0.b.a<v> $success;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f.c0.b.a<v> aVar) {
        super(0);
        this.$success = aVar;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ v invoke() {
        invoke2();
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        f.c0.b.a<v> aVar = this.$success;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }
}
