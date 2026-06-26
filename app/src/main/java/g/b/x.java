package g.b;

import f.z.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends f.c0.c.k implements f.c0.b.l<f.a, y> {
    public static final x INSTANCE = new x();

    public x() {
        super(1);
    }

    @Override // f.c0.b.l
    @Nullable
    public final y invoke(@NotNull f.a aVar) {
        if (!(aVar instanceof y)) {
            aVar = null;
        }
        return (y) aVar;
    }
}
