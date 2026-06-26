package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: AXmlResourceParser.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f3375b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f3377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f3378e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f3385l;
    private int m;
    private int n;
    private int o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3376c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C0091a f3379f = new C0091a();

    public a() {
        g();
    }

    private final void g() {
        this.f3381h = -1;
        this.f3382i = -1;
        this.f3383j = -1;
        this.f3384k = -1;
        this.f3385l = null;
        this.m = -1;
        this.n = -1;
        this.o = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        throw new java.io.IOException(c.a.a.a.a.d("Invalid resource ids size (", r2, ")."));
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0172, code lost:
    
        throw new java.io.IOException(c.a.a.a.a.d("Invalid chunk type (", r5, ")."));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void h() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.a.h():void");
    }

    public void a(InputStream inputStream) {
        a();
        if (inputStream != null) {
            this.f3375b = new d(inputStream, false);
        }
    }

    public int b() throws IOException, h {
        if (this.f3375b == null) {
            throw new h("Parser is not opened.", this, null);
        }
        try {
            h();
            return this.f3381h;
        } catch (IOException e2) {
            a();
            throw e2;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int c() {
        return this.f3382i;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public String d() {
        StringBuilder sbR = c.a.a.a.a.r("XML line #");
        sbR.append(c());
        return sbR.toString();
    }

    public int e() {
        if (this.f3381h != 2) {
            return -1;
        }
        return this.f3385l.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int f() {
        return -1;
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.f.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AXmlResourceParser.java */
    public static final class C0091a {
        private int[] a = new int[32];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3387c;

        public final void a() {
            this.f3386b = 0;
            this.f3387c = 0;
        }

        public final int b() {
            int i2 = this.f3386b;
            if (i2 == 0) {
                return 0;
            }
            return this.a[i2 - 1];
        }

        public final boolean c() {
            int i2;
            int[] iArr;
            int i3;
            int i4 = this.f3386b;
            if (i4 == 0 || (i3 = (iArr = this.a)[i4 - 1]) == 0) {
                return false;
            }
            int i5 = i3 - 1;
            int i6 = i2 - 2;
            iArr[i6] = i5;
            iArr[i6 - ((i5 * 2) + 1)] = i5;
            this.f3386b = i4 - 2;
            return true;
        }

        public final int d() {
            return this.f3387c;
        }

        public final void e() {
            a(2);
            int i2 = this.f3386b;
            int[] iArr = this.a;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.f3386b = i2 + 2;
            this.f3387c++;
        }

        public final void f() {
            int i2 = this.f3386b;
            if (i2 != 0) {
                int i3 = i2 - 1;
                int i4 = this.a[i3] * 2;
                if ((i3 - 1) - i4 != 0) {
                    this.f3386b = i2 - (i4 + 2);
                    this.f3387c--;
                }
            }
        }

        public final void a(int i2, int i3) {
            if (this.f3387c == 0) {
                e();
            }
            a(2);
            int i4 = this.f3386b;
            int i5 = i4 - 1;
            int[] iArr = this.a;
            int i6 = iArr[i5];
            int i7 = (i5 - 1) - (i6 * 2);
            int i8 = i6 + 1;
            iArr[i7] = i8;
            iArr[i5] = i2;
            iArr[i5 + 1] = i3;
            iArr[i5 + 2] = i8;
            this.f3386b = i4 + 2;
        }

        private void a(int i2) {
            int[] iArr = this.a;
            int length = iArr.length;
            int i3 = this.f3386b;
            int i4 = length - i3;
            if (i4 <= i2) {
                int[] iArr2 = new int[(iArr.length + i4) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.a = iArr2;
            }
        }
    }

    private final int e(int i2) {
        if (this.f3381h != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i3 = i2 * 5;
        if (i3 < this.f3385l.length) {
            return i3;
        }
        throw new IndexOutOfBoundsException(c.a.a.a.a.d("Invalid attribute index (", i2, ")."));
    }

    public int c(int i2) {
        return this.f3385l[e(i2) + 4];
    }

    public String d(int i2) {
        int iE = e(i2);
        int[] iArr = this.f3385l;
        if (iArr[iE + 3] == 3) {
            return this.f3377d.a(iArr[iE + 2]);
        }
        int i3 = iArr[iE + 4];
        return "";
    }

    public void a() {
        if (this.f3376c) {
            this.f3376c = false;
            this.f3375b.a();
            this.f3375b = null;
            this.f3377d = null;
            this.f3378e = null;
            this.f3379f.a();
            g();
        }
    }

    public int b(int i2) {
        return this.f3385l[e(i2) + 3];
    }

    public String a(int i2) {
        int i3 = this.f3385l[e(i2) + 1];
        return i3 == -1 ? "" : this.f3377d.a(i3);
    }
}
