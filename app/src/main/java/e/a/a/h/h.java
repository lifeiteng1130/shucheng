package e.a.a.h;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: compiled from: ContextExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends f.c0.c.k implements f.c0.b.a<f.v> {
    public final /* synthetic */ int $message;
    public final /* synthetic */ Context $this_longToastOnUi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, int i2) {
        super(0);
        this.$this_longToastOnUi = context;
        this.$message = i2;
    }

    @Override // f.c0.b.a
    public /* bridge */ /* synthetic */ f.v invoke() {
        invoke2();
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Toast.makeText(this.$this_longToastOnUi, this.$message, 1).show();
    }
}
