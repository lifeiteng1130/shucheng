package e.a.a.g.d.i.r1;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadStyleDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m3 extends f.c0.c.k implements f.c0.b.l<Integer, String> {
    public static final m3 INSTANCE = new m3();

    public m3() {
        super(1);
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    @NotNull
    public final String invoke(int i2) {
        return String.valueOf(i2 + 5);
    }
}
