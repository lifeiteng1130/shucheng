package c.b.a.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: MultiClassKey.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class<?> f678c;

    public h() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.a.equals(hVar.a) && this.f677b.equals(hVar.f677b) && i.b(this.f678c, hVar.f678c);
    }

    public int hashCode() {
        int iHashCode = (this.f677b.hashCode() + (this.a.hashCode() * 31)) * 31;
        Class<?> cls = this.f678c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("MultiClassKey{first=");
        sbR.append(this.a);
        sbR.append(", second=");
        sbR.append(this.f677b);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    public h(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.a = cls;
        this.f677b = cls2;
        this.f678c = cls3;
    }
}
