package c.e.c;

/* JADX INFO: compiled from: ResultPoint.java */
/* JADX INFO: loaded from: classes.dex */
public class r {
    public final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1359b;

    public r(float f2, float f3) {
        this.a = f2;
        this.f1359b = f3;
    }

    public static float a(r rVar, r rVar2) {
        return c.b.a.m.f.r1(rVar.a, rVar.f1359b, rVar2.a, rVar2.f1359b);
    }

    public static void b(r[] rVarArr) {
        r rVar;
        r rVar2;
        r rVar3;
        float fA = a(rVarArr[0], rVarArr[1]);
        float fA2 = a(rVarArr[1], rVarArr[2]);
        float fA3 = a(rVarArr[0], rVarArr[2]);
        if (fA2 >= fA && fA2 >= fA3) {
            rVar = rVarArr[0];
            rVar2 = rVarArr[1];
            rVar3 = rVarArr[2];
        } else if (fA3 < fA2 || fA3 < fA) {
            rVar = rVarArr[2];
            rVar2 = rVarArr[0];
            rVar3 = rVarArr[1];
        } else {
            rVar = rVarArr[1];
            rVar2 = rVarArr[0];
            rVar3 = rVarArr[2];
        }
        float f2 = rVar.a;
        float f3 = rVar.f1359b;
        if (((rVar2.f1359b - f3) * (rVar3.a - f2)) - ((rVar2.a - f2) * (rVar3.f1359b - f3)) < 0.0f) {
            r rVar4 = rVar3;
            rVar3 = rVar2;
            rVar2 = rVar4;
        }
        rVarArr[0] = rVar2;
        rVarArr[1] = rVar;
        rVarArr[2] = rVar3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.a == rVar.a && this.f1359b == rVar.f1359b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f1359b) + (Float.floatToIntBits(this.a) * 31);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.f1359b + ')';
    }
}
