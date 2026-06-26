package g.b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements a1 {
    public final boolean a;

    public p0(boolean z) {
        this.a = z;
    }

    @Override // g.b.a1
    @Nullable
    public p1 a() {
        return null;
    }

    @Override // g.b.a1
    public boolean isActive() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("Empty{");
        sbR.append(this.a ? "Active" : "New");
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
