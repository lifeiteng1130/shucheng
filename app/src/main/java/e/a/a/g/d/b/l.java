package e.a.a.g.d.b;

import android.content.DialogInterface;
import f.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CacheActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, v> {
    public static final l INSTANCE = new l();

    public l() {
        super(2);
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
        invoke(dialogInterface, num.intValue());
        return v.a;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
        f.c0.c.j.e(dialogInterface, "$noName_0");
        e.a.a.d.e eVar = e.a.a.d.e.a;
        c.b.a.m.f.p4(k.d.a.h.g(), "exportType", i2);
    }
}
