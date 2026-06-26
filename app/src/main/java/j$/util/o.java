package j$.util;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class o<T> {
    private static final o a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f7998b;

    private o() {
        this.f7998b = null;
    }

    private o(Object obj) {
        Objects.requireNonNull(obj);
        this.f7998b = obj;
    }

    public static o a() {
        return a;
    }

    public static o d(Object obj) {
        return new o(obj);
    }

    public Object b() {
        Object obj = this.f7998b;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f7998b != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            return j$.time.a.u(this.f7998b, ((o) obj).f7998b);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f7998b;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f7998b;
        return obj != null ? String.format("Optional[%s]", obj) : "Optional.empty";
    }
}
