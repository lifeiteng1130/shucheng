package g.b.g2;

import g.b.a0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements a0 {

    @NotNull
    public final f.z.f a;

    public e(@NotNull f.z.f fVar) {
        this.a = fVar;
    }

    @Override // g.b.a0
    @NotNull
    public f.z.f getCoroutineContext() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("CoroutineScope(coroutineContext=");
        sbR.append(this.a);
        sbR.append(')');
        return sbR.toString();
    }
}
