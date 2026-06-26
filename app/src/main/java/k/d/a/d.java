package k.d.a;

import org.jsoup.nodes.Attributes;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.UintMap;

/* JADX INFO: compiled from: ConstantPool.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UintMap f8770b = new UintMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObjToIntMap f8771c = new ObjToIntMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObjToIntMap f8772d = new ObjToIntMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjToIntMap f8773e = new ObjToIntMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObjToIntMap f8774f = new ObjToIntMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public UintMap f8777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UintMap f8778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f8779k;

    public d(c cVar) {
        new ObjToIntMap();
        this.f8777i = new UintMap();
        this.f8778j = new UintMap();
        this.a = cVar;
        this.f8776h = 1;
        this.f8779k = new byte[256];
        this.f8775g = 0;
    }

    public short a(String str) {
        String str2;
        int i2 = this.f8774f.get(str, -1);
        if (i2 == -1) {
            if (str.indexOf(46) > 0) {
                String strReplace = str.replace('.', Attributes.InternalPrefix);
                int i3 = this.f8774f.get(strReplace, -1);
                if (i3 != -1) {
                    this.f8774f.put(str, i3);
                }
                str2 = strReplace;
                i2 = i3;
            } else {
                str2 = str;
            }
            if (i2 == -1) {
                short sC = c(str2);
                d(3);
                byte[] bArr = this.f8779k;
                int i4 = this.f8775g;
                int i5 = i4 + 1;
                this.f8775g = i5;
                bArr[i4] = 7;
                this.f8775g = c.L(sC, bArr, i5);
                i2 = this.f8776h;
                this.f8776h = i2 + 1;
                this.f8774f.put(str2, i2);
                if (!str.equals(str2)) {
                    this.f8774f.put(str, i2);
                }
            }
        }
        this.f8777i.put(i2, str);
        this.f8778j.put(i2, 7);
        return (short) i2;
    }

    public final short b(String str, String str2) {
        short sC = c(str);
        short sC2 = c(str2);
        d(5);
        byte[] bArr = this.f8779k;
        int i2 = this.f8775g;
        int i3 = i2 + 1;
        this.f8775g = i3;
        bArr[i2] = 12;
        int iL = c.L(sC, bArr, i3);
        this.f8775g = iL;
        this.f8775g = c.L(sC2, this.f8779k, iL);
        this.f8778j.put(this.f8776h, 12);
        int i4 = this.f8776h;
        this.f8776h = i4 + 1;
        return (short) i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public short c(java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.d.a.d.c(java.lang.String):short");
    }

    public final void d(int i2) {
        int i3 = this.f8775g;
        int i4 = i3 + i2;
        byte[] bArr = this.f8779k;
        if (i4 > bArr.length) {
            int length = bArr.length * 2;
            if (i3 + i2 > length) {
                length = i3 + i2;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            this.f8779k = bArr2;
        }
    }

    public Object e(int i2) {
        return this.f8777i.getObject(i2);
    }

    public int f(String str, int i2, int i3) {
        int i4 = 65535;
        if ((i3 - i2) * 3 <= 65535) {
            return i3;
        }
        while (i2 != i3) {
            char cCharAt = str.charAt(i2);
            i4 = (cCharAt == 0 || cCharAt > 127) ? cCharAt < 2047 ? i4 - 2 : i4 - 3 : i4 - 1;
            if (i4 < 0) {
                return i2;
            }
            i2++;
        }
        return i3;
    }
}
