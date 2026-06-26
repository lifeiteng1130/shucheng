package j$.util;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    private static final r a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f8003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f8004c;

    private r() {
        this.f8003b = false;
        this.f8004c = 0L;
    }

    private r(long j2) {
        this.f8003b = true;
        this.f8004c = j2;
    }

    public static r a() {
        return a;
    }

    public static r d(long j2) {
        return new r(j2);
    }

    public long b() {
        if (this.f8003b) {
            return this.f8004c;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f8003b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        boolean z = this.f8003b;
        if (z && rVar.f8003b) {
            if (this.f8004c == rVar.f8004c) {
                return true;
            }
        } else if (z == rVar.f8003b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.f8003b) {
            return 0;
        }
        long j2 = this.f8004c;
        return (int) (j2 ^ (j2 >>> 32));
    }

    public String toString() {
        return this.f8003b ? String.format("OptionalLong[%s]", Long.valueOf(this.f8004c)) : "OptionalLong.empty";
    }
}
