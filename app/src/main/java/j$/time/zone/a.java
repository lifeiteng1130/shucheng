package j$.time.zone;

import j$.time.Instant;
import j$.time.f;
import j$.time.j;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Comparable<a>, Serializable {
    private final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f7901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f7902c;

    a(long j2, j jVar, j jVar2) {
        this.a = f.A(j2, 0, jVar);
        this.f7901b = jVar;
        this.f7902c = jVar2;
    }

    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        return h().t(aVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.f7901b.equals(aVar.f7901b) && this.f7902c.equals(aVar.f7902c);
    }

    public Instant h() {
        return Instant.z(this.a.B(this.f7901b), r0.b().x());
    }

    public int hashCode() {
        return (this.a.hashCode() ^ this.f7901b.hashCode()) ^ Integer.rotateLeft(this.f7902c.hashCode(), 16);
    }

    public j j() {
        return this.f7902c;
    }

    public j l() {
        return this.f7901b;
    }

    public String toString() {
        StringBuilder sbA = j$.com.android.tools.r8.a.a("Transition[");
        sbA.append(this.f7902c.y() > this.f7901b.y() ? "Gap" : "Overlap");
        sbA.append(" at ");
        sbA.append(this.a);
        sbA.append(this.f7901b);
        sbA.append(" to ");
        sbA.append(this.f7902c);
        sbA.append(']');
        return sbA.toString();
    }

    public long u() {
        f fVar = this.a;
        j jVar = this.f7901b;
        Objects.requireNonNull(fVar);
        return j$.time.a.l(fVar, jVar);
    }
}
