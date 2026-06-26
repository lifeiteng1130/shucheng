package g.b;

import f.z.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends f.c0.c.k implements f.c0.b.l<f.a, v0> {
    public static final u0 INSTANCE = new u0();

    public u0() {
        super(1);
    }

    @Override // f.c0.b.l
    @Nullable
    public final v0 invoke(@NotNull f.a aVar) {
        if (!(aVar instanceof v0)) {
            aVar = null;
        }
        return (v0) aVar;
    }
}
