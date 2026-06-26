package c.b.a.r;

import androidx.annotation.NonNull;
import c.b.a.m.j;
import java.security.MessageDigest;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: ObjectKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f667b;

    public b(@NonNull Object obj) {
        Objects.requireNonNull(obj, "Argument must not be null");
        this.f667b = obj;
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f667b.equals(((b) obj).f667b);
        }
        return false;
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        return this.f667b.hashCode();
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("ObjectKey{object=");
        sbR.append(this.f667b);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f667b.toString().getBytes(j.a));
    }
}
