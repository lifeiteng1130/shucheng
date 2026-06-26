package g.b;

import java.util.Objects;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    @JvmField
    @Nullable
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    @Nullable
    public final f f6286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    @Nullable
    public final f.c0.b.l<Throwable, f.v> f6287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    @Nullable
    public final Object f6288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    @Nullable
    public final Throwable f6289e;

    /* JADX WARN: Multi-variable type inference failed */
    public r(@Nullable Object obj, @Nullable f fVar, @Nullable f.c0.b.l<? super Throwable, f.v> lVar, @Nullable Object obj2, @Nullable Throwable th) {
        this.a = obj;
        this.f6286b = fVar;
        this.f6287c = lVar;
        this.f6288d = obj2;
        this.f6289e = th;
    }

    public static r a(r rVar, Object obj, f fVar, f.c0.b.l lVar, Object obj2, Throwable th, int i2) {
        Object obj3 = (i2 & 1) != 0 ? rVar.a : null;
        if ((i2 & 2) != 0) {
            fVar = rVar.f6286b;
        }
        f fVar2 = fVar;
        f.c0.b.l<Throwable, f.v> lVar2 = (i2 & 4) != 0 ? rVar.f6287c : null;
        Object obj4 = (i2 & 8) != 0 ? rVar.f6288d : null;
        if ((i2 & 16) != 0) {
            th = rVar.f6289e;
        }
        Objects.requireNonNull(rVar);
        return new r(obj3, fVar2, lVar2, obj4, th);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return f.c0.c.j.a(this.a, rVar.a) && f.c0.c.j.a(this.f6286b, rVar.f6286b) && f.c0.c.j.a(this.f6287c, rVar.f6287c) && f.c0.c.j.a(this.f6288d, rVar.f6288d) && f.c0.c.j.a(this.f6289e, rVar.f6289e);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        f fVar = this.f6286b;
        int iHashCode2 = (iHashCode + (fVar != null ? fVar.hashCode() : 0)) * 31;
        f.c0.b.l<Throwable, f.v> lVar = this.f6287c;
        int iHashCode3 = (iHashCode2 + (lVar != null ? lVar.hashCode() : 0)) * 31;
        Object obj2 = this.f6288d;
        int iHashCode4 = (iHashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.f6289e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("CompletedContinuation(result=");
        sbR.append(this.a);
        sbR.append(", cancelHandler=");
        sbR.append(this.f6286b);
        sbR.append(", onCancellation=");
        sbR.append(this.f6287c);
        sbR.append(", idempotentResume=");
        sbR.append(this.f6288d);
        sbR.append(", cancelCause=");
        sbR.append(this.f6289e);
        sbR.append(")");
        return sbR.toString();
    }

    public r(Object obj, f fVar, f.c0.b.l lVar, Object obj2, Throwable th, int i2) {
        fVar = (i2 & 2) != 0 ? null : fVar;
        lVar = (i2 & 4) != 0 ? null : lVar;
        obj2 = (i2 & 8) != 0 ? null : obj2;
        th = (i2 & 16) != 0 ? null : th;
        this.a = obj;
        this.f6286b = fVar;
        this.f6287c = lVar;
        this.f6288d = obj2;
        this.f6289e = th;
    }
}
