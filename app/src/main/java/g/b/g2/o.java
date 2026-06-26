package g.b.g2;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    @JvmField
    @NotNull
    public final j a;

    public o(@NotNull j jVar) {
        this.a = jVar;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("Removed[");
        sbR.append(this.a);
        sbR.append(']');
        return sbR.toString();
    }
}
