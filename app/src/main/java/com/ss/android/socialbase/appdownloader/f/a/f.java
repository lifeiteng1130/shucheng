package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;

/* JADX INFO: compiled from: StringBlock.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f3390b;

    private f() {
    }

    public static f a(d dVar) throws IOException {
        b.a(dVar, 1835009);
        int iB = dVar.b();
        int iB2 = dVar.b();
        int iB3 = dVar.b();
        dVar.b();
        int iB4 = dVar.b();
        int iB5 = dVar.b();
        f fVar = new f();
        fVar.a = dVar.b(iB2);
        if (iB3 != 0) {
            dVar.b(iB3);
        }
        int i2 = (iB5 == 0 ? iB : iB5) - iB4;
        if (i2 % 4 != 0) {
            throw new IOException(c.a.a.a.a.d("String data size is not multiple of 4 (", i2, ")."));
        }
        fVar.f3390b = dVar.b(i2 / 4);
        if (iB5 != 0) {
            int i3 = iB - iB5;
            if (i3 % 4 != 0) {
                throw new IOException(c.a.a.a.a.d("Style data size is not multiple of 4 (", i3, ")."));
            }
            dVar.b(i3 / 4);
        }
        return fVar;
    }

    public String a(int i2) {
        int[] iArr;
        if (i2 < 0 || (iArr = this.a) == null || i2 >= iArr.length) {
            return null;
        }
        int i3 = iArr[i2];
        int iA = a(this.f3390b, i3);
        StringBuilder sb = new StringBuilder(iA);
        while (iA != 0) {
            i3 += 2;
            sb.append((char) a(this.f3390b, i3));
            iA--;
        }
        return sb.toString();
    }

    private static final int a(int[] iArr, int i2) {
        int i3 = iArr[i2 / 4];
        return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
    }
}
