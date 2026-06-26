package h.a.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: Author.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements Serializable {
    private static final long serialVersionUID = 6663408501416574200L;
    private String firstname;
    private String lastname;
    private o relator;

    public b(String str) {
        this("", str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return c.b.a.m.f.D1(this.firstname, bVar.firstname) && c.b.a.m.f.D1(this.lastname, bVar.lastname);
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public o getRelator() {
        return this.relator;
    }

    public int hashCode() {
        String[] strArr = {this.firstname, this.lastname};
        int iHashCode = 31;
        for (int i2 = 0; i2 < 2; i2++) {
            iHashCode ^= String.valueOf(strArr[i2]).hashCode();
        }
        return iHashCode;
    }

    public void setFirstname(String str) {
        this.firstname = str;
    }

    public void setLastname(String str) {
        this.lastname = str;
    }

    public void setRelator(o oVar) {
        this.relator = oVar;
    }

    public void setRole(String str) {
        o oVarByCode = o.byCode(str);
        if (oVarByCode == null) {
            oVarByCode = o.AUTHOR;
        }
        this.relator = oVarByCode;
    }

    public String toString() {
        return this.lastname + ", " + this.firstname;
    }

    public b(String str, String str2) {
        this.relator = o.AUTHOR;
        this.firstname = str;
        this.lastname = str2;
    }
}
