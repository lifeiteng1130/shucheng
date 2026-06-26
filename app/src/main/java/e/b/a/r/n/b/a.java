package e.b.a.r.n.b;

import c.b.a.m.f;
import j$.util.Map;
import java.util.Map;

/* JADX INFO: compiled from: Attribute.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements Map.Entry<String, String>, Cloneable, Map.Entry {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f6058c;

    public a(String str, String str2, b bVar) {
        f.f4(str);
        this.a = str.trim();
        if (str.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }
        this.f6057b = str2;
        this.f6058c = bVar;
    }

    public Object clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.a;
        if (str == null ? aVar.a != null : !str.equals(aVar.a)) {
            return false;
        }
        String str2 = this.f6057b;
        String str3 = aVar.f6057b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public Object getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public Object getValue() {
        return this.f6057b;
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f6057b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry, j$.util.Map.Entry
    public Object setValue(Object obj) {
        String str;
        int iB;
        String str2 = (String) obj;
        b bVar = this.f6058c;
        int iB2 = bVar.b(this.a);
        if (iB2 == -1 || (str = bVar.f6061d[iB2]) == null) {
            str = "";
        }
        b bVar2 = this.f6058c;
        if (bVar2 != null && (iB = bVar2.b(this.a)) != -1) {
            this.f6058c.f6061d[iB] = str2;
        }
        this.f6057b = str2;
        return str;
    }
}
