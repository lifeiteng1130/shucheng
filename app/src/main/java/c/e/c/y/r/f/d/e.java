package c.e.c.y.r.f.d;

/* JADX INFO: compiled from: AI013x0x1xDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1506d;

    public e(c.e.c.v.a aVar, String str, String str2) {
        super(aVar);
        this.f1505c = str2;
        this.f1506d = str;
    }

    @Override // c.e.c.y.r.f.d.j
    public String a() throws c.e.c.k {
        if (this.a.f1375b != 84) {
            throw c.e.c.k.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        f(sb, 48, 20);
        int iD = s.d(this.f1507b.a, 68, 16);
        if (iD != 38400) {
            sb.append('(');
            sb.append(this.f1505c);
            sb.append(')');
            int i2 = iD % 32;
            int i3 = iD / 32;
            int i4 = (i3 % 12) + 1;
            int i5 = i3 / 12;
            if (i5 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i5);
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i2);
        }
        return sb.toString();
    }

    @Override // c.e.c.y.r.f.d.i
    public void d(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.f1506d);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    @Override // c.e.c.y.r.f.d.i
    public int e(int i2) {
        return i2 % 100000;
    }
}
