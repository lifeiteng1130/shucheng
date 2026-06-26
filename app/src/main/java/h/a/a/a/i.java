package h.a.a.a;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: Identifier.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements Serializable {
    private static final long serialVersionUID = 955949951416391810L;
    private boolean bookId;
    private String scheme;
    private String value;

    public i() {
        this("UUID", UUID.randomUUID().toString());
    }

    public static i getBookIdIdentifier(List<i> list) {
        i iVar = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next.isBookId()) {
                iVar = next;
                break;
            }
        }
        return iVar == null ? list.get(0) : iVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return c.b.a.m.f.D1(this.scheme, iVar.scheme) && c.b.a.m.f.D1(this.value, iVar.value);
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.scheme;
        if (str == null) {
            str = "";
        }
        int iHashCode = str.hashCode();
        String str2 = this.value;
        return iHashCode ^ (str2 != null ? str2 : "").hashCode();
    }

    public boolean isBookId() {
        return this.bookId;
    }

    public void setBookId(boolean z) {
        this.bookId = z;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        if (c.b.a.m.f.q3(this.scheme)) {
            StringBuilder sbR = c.a.a.a.a.r("");
            sbR.append(this.value);
            return sbR.toString();
        }
        StringBuilder sbR2 = c.a.a.a.a.r("");
        sbR2.append(this.scheme);
        sbR2.append(":");
        sbR2.append(this.value);
        return sbR2.toString();
    }

    public i(String str, String str2) {
        this.bookId = false;
        this.scheme = str;
        this.value = str2;
    }
}
