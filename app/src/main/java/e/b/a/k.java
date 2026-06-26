package e.b.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: Prop.java */
/* JADX INFO: loaded from: classes3.dex */
public class k<T> {
    public final String a;

    public k(@NonNull String str) {
        this.a = str;
    }

    @NonNull
    public T a(@NonNull m mVar) {
        T t = (T) mVar.a.get(this);
        Objects.requireNonNull(t, this.a);
        return t;
    }

    public void b(@NonNull m mVar, @Nullable T t) {
        if (t == null) {
            mVar.a.remove(this);
        } else {
            mVar.a.put(this, t);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((k) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("Prop{name='");
        sbR.append(this.a);
        sbR.append('\'');
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
