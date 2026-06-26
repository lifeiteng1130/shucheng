package g.b;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    @JvmField
    @Nullable
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public final f.c0.b.l<Throwable, f.v> f6299b;

    /* JADX WARN: Multi-variable type inference failed */
    public t(@Nullable Object obj, @NotNull f.c0.b.l<? super Throwable, f.v> lVar) {
        this.a = obj;
        this.f6299b = lVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return f.c0.c.j.a(this.a, tVar.a) && f.c0.c.j.a(this.f6299b, tVar.f6299b);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        f.c0.b.l<Throwable, f.v> lVar = this.f6299b;
        return iHashCode + (lVar != null ? lVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("CompletedWithCancellation(result=");
        sbR.append(this.a);
        sbR.append(", onCancellation=");
        sbR.append(this.f6299b);
        sbR.append(")");
        return sbR.toString();
    }
}
