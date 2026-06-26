package c.e.c.v.l;

import c.b.a.m.f;
import c.e.c.k;
import c.e.c.r;
import c.e.c.v.b;

/* JADX INFO: compiled from: WhiteRectangleDetector.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1409g;

    public a(b bVar, int i2, int i3, int i4) throws k {
        this.a = bVar;
        int i5 = bVar.f1376b;
        this.f1404b = i5;
        int i6 = bVar.a;
        this.f1405c = i6;
        int i7 = i2 / 2;
        int i8 = i3 - i7;
        this.f1406d = i8;
        int i9 = i3 + i7;
        this.f1407e = i9;
        int i10 = i4 - i7;
        this.f1409g = i10;
        int i11 = i4 + i7;
        this.f1408f = i11;
        if (i10 < 0 || i8 < 0 || i11 >= i5 || i9 >= i6) {
            throw k.getNotFoundInstance();
        }
    }

    public final boolean a(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.a.b(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.a.b(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public r[] b() throws k {
        boolean z;
        int i2 = this.f1406d;
        int i3 = this.f1407e;
        int i4 = this.f1409g;
        int i5 = this.f1408f;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (z2) {
            boolean zA = true;
            boolean z8 = false;
            while (true) {
                if ((!zA && z3) || i3 >= this.f1405c) {
                    break;
                }
                zA = a(i4, i5, i3, false);
                if (zA) {
                    i3++;
                    z3 = true;
                    z8 = true;
                } else if (!z3) {
                    i3++;
                }
            }
            if (i3 < this.f1405c) {
                boolean zA2 = true;
                while (true) {
                    if ((!zA2 && z4) || i5 >= this.f1404b) {
                        break;
                    }
                    zA2 = a(i2, i3, i5, true);
                    if (zA2) {
                        i5++;
                        z4 = true;
                        z8 = true;
                    } else if (!z4) {
                        i5++;
                    }
                }
                if (i5 < this.f1404b) {
                    boolean zA3 = true;
                    while (true) {
                        if ((!zA3 && z5) || i2 < 0) {
                            break;
                        }
                        zA3 = a(i4, i5, i2, false);
                        if (zA3) {
                            i2--;
                            z5 = true;
                            z8 = true;
                        } else if (!z5) {
                            i2--;
                        }
                    }
                    if (i2 >= 0) {
                        z2 = z8;
                        boolean zA4 = true;
                        while (true) {
                            if ((!zA4 && z7) || i4 < 0) {
                                break;
                            }
                            zA4 = a(i2, i3, i4, true);
                            if (zA4) {
                                i4--;
                                z2 = true;
                                z7 = true;
                            } else if (!z7) {
                                i4--;
                            }
                        }
                        if (i4 >= 0) {
                            if (z2) {
                                z6 = true;
                            }
                        }
                    }
                }
            }
            z = true;
            break;
        }
        z = false;
        if (z || !z6) {
            throw k.getNotFoundInstance();
        }
        int i6 = i3 - i2;
        r rVarC = null;
        r rVarC2 = null;
        for (int i7 = 1; rVarC2 == null && i7 < i6; i7++) {
            rVarC2 = c(i2, i5 - i7, i2 + i7, i5);
        }
        if (rVarC2 == null) {
            throw k.getNotFoundInstance();
        }
        r rVarC3 = null;
        for (int i8 = 1; rVarC3 == null && i8 < i6; i8++) {
            rVarC3 = c(i2, i4 + i8, i2 + i8, i4);
        }
        if (rVarC3 == null) {
            throw k.getNotFoundInstance();
        }
        r rVarC4 = null;
        for (int i9 = 1; rVarC4 == null && i9 < i6; i9++) {
            rVarC4 = c(i3, i4 + i9, i3 - i9, i4);
        }
        if (rVarC4 == null) {
            throw k.getNotFoundInstance();
        }
        for (int i10 = 1; rVarC == null && i10 < i6; i10++) {
            rVarC = c(i3, i5 - i10, i3 - i10, i5);
        }
        if (rVarC == null) {
            throw k.getNotFoundInstance();
        }
        float f2 = rVarC.a;
        float f3 = rVarC.f1359b;
        float f4 = rVarC2.a;
        float f5 = rVarC2.f1359b;
        float f6 = rVarC4.a;
        float f7 = rVarC4.f1359b;
        float f8 = rVarC3.a;
        float f9 = rVarC3.f1359b;
        return f2 < ((float) this.f1405c) / 2.0f ? new r[]{new r(f8 - 1.0f, f9 + 1.0f), new r(f4 + 1.0f, f5 + 1.0f), new r(f6 - 1.0f, f7 - 1.0f), new r(f2 + 1.0f, f3 - 1.0f)} : new r[]{new r(f8 + 1.0f, f9 + 1.0f), new r(f4 + 1.0f, f5 - 1.0f), new r(f6 - 1.0f, f7 + 1.0f), new r(f2 - 1.0f, f3 - 1.0f)};
    }

    public final r c(float f2, float f3, float f4, float f5) {
        int iR4 = f.R4(f.r1(f2, f3, f4, f5));
        float f6 = iR4;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < iR4; i2++) {
            float f9 = i2;
            int iR42 = f.R4((f9 * f7) + f2);
            int iR43 = f.R4((f9 * f8) + f3);
            if (this.a.b(iR42, iR43)) {
                return new r(iR42, iR43);
            }
        }
        return null;
    }
}
