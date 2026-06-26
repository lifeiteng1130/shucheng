package j$.util;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    private static final q a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f8001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8002c;

    private q() {
        this.f8001b = false;
        this.f8002c = 0;
    }

    private q(int i2) {
        this.f8001b = true;
        this.f8002c = i2;
    }

    public static q a() {
        return a;
    }

    public static q d(int i2) {
        return new q(i2);
    }

    public int b() {
        if (this.f8001b) {
            return this.f8002c;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f8001b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        boolean z = this.f8001b;
        if (z && qVar.f8001b) {
            if (this.f8002c == qVar.f8002c) {
                return true;
            }
        } else if (z == qVar.f8001b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f8001b) {
            return this.f8002c;
        }
        return 0;
    }

    public String toString() {
        return this.f8001b ? String.format("OptionalInt[%s]", Integer.valueOf(this.f8002c)) : "OptionalInt.empty";
    }
}
