package k.a.a.a.m0;

import java.util.Arrays;

/* JADX INFO: compiled from: IntegerList.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static int[] a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f8508b = a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8509c;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f8509c != fVar.f8509c) {
            return false;
        }
        for (int i2 = 0; i2 < this.f8509c; i2++) {
            if (this.f8508b[i2] != fVar.f8508b[i2]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f8509c; i3++) {
            i2 = (i2 * 31) + this.f8508b[i3];
        }
        return i2;
    }

    public String toString() {
        int i2 = this.f8509c;
        return Arrays.toString(i2 == 0 ? a : Arrays.copyOf(this.f8508b, i2));
    }
}
