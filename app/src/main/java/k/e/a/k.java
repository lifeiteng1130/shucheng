package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8868d;

    public k(int i2, String str, String str2, String str3) {
        this.a = i2;
        this.f8866b = str;
        this.f8867c = str2;
        this.f8868d = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a == kVar.a && this.f8866b.equals(kVar.f8866b) && this.f8867c.equals(kVar.f8867c) && this.f8868d.equals(kVar.f8868d);
    }

    public int hashCode() {
        return (this.f8868d.hashCode() * this.f8867c.hashCode() * this.f8866b.hashCode()) + this.a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f8866b);
        stringBuffer.append('.');
        stringBuffer.append(this.f8867c);
        stringBuffer.append(this.f8868d);
        stringBuffer.append(" (");
        stringBuffer.append(this.a);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}
