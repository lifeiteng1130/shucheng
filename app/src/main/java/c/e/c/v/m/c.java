package c.e.c.v.m;

import java.util.Objects;

/* JADX INFO: compiled from: ReedSolomonDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public void a(int[] iArr, int i2) throws e {
        int[] iArr2;
        b bVar = new b(this.a, iArr);
        int[] iArr3 = new int[i2];
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = this.a;
            int iB = bVar.b(aVar.f1417i[aVar.o + i3]);
            iArr3[(i2 - 1) - i3] = iB;
            if (iB != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        b bVar2 = new b(this.a, iArr3);
        b bVarA = this.a.a(i2, 1);
        if (bVarA.d() < bVar2.d()) {
            bVarA = bVar2;
            bVar2 = bVarA;
        }
        a aVar2 = this.a;
        b bVar3 = aVar2.f1419k;
        b bVar4 = aVar2.f1420l;
        b bVar5 = bVar3;
        while (bVar2.d() >= i2 / 2) {
            if (bVar2.e()) {
                throw new e("r_{i-1} was zero");
            }
            b bVarA2 = this.a.f1419k;
            int iB2 = this.a.b(bVar2.c(bVar2.d()));
            while (bVarA.d() >= bVar2.d() && !bVarA.e()) {
                int iD = bVarA.d() - bVar2.d();
                int iC = this.a.c(bVarA.c(bVarA.d()), iB2);
                bVarA2 = bVarA2.a(this.a.a(iD, iC));
                bVarA = bVarA.a(bVar2.h(iD, iC));
            }
            b bVarA3 = bVarA2.g(bVar4).a(bVar5);
            if (bVarA.d() >= bVar2.d()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            b bVar6 = bVarA;
            bVarA = bVar2;
            bVar2 = bVar6;
            b bVar7 = bVar4;
            bVar4 = bVarA3;
            bVar5 = bVar7;
        }
        int iC2 = bVar4.c(0);
        if (iC2 == 0) {
            throw new e("sigmaTilde(0) was zero");
        }
        int iB3 = this.a.b(iC2);
        b[] bVarArr = {bVar4.f(iB3), bVar2.f(iB3)};
        b bVar8 = bVarArr[0];
        b bVar9 = bVarArr[1];
        int iD2 = bVar8.d();
        if (iD2 == 1) {
            iArr2 = new int[]{bVar8.c(1)};
        } else {
            int[] iArr4 = new int[iD2];
            int i4 = 0;
            for (int i5 = 1; i5 < this.a.m && i4 < iD2; i5++) {
                if (bVar8.b(i5) == 0) {
                    iArr4[i4] = this.a.b(i5);
                    i4++;
                }
            }
            if (i4 != iD2) {
                throw new e("Error locator degree does not match number of roots");
            }
            iArr2 = iArr4;
        }
        int length = iArr2.length;
        int[] iArr5 = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            int iB4 = this.a.b(iArr2[i6]);
            int iC3 = 1;
            for (int i7 = 0; i7 < length; i7++) {
                if (i6 != i7) {
                    int iC4 = this.a.c(iArr2[i7], iB4);
                    iC3 = this.a.c(iC3, (iC4 & 1) == 0 ? iC4 | 1 : iC4 & (-2));
                }
            }
            iArr5[i6] = this.a.c(bVar9.b(iB4), this.a.b(iC3));
            a aVar3 = this.a;
            if (aVar3.o != 0) {
                iArr5[i6] = aVar3.c(iArr5[i6], iB4);
            }
        }
        for (int i8 = 0; i8 < iArr2.length; i8++) {
            int length2 = iArr.length - 1;
            a aVar4 = this.a;
            int i9 = iArr2[i8];
            Objects.requireNonNull(aVar4);
            if (i9 == 0) {
                throw new IllegalArgumentException();
            }
            int i10 = length2 - aVar4.f1418j[i9];
            if (i10 < 0) {
                throw new e("Bad error location");
            }
            iArr[i10] = iArr[i10] ^ iArr5[i8];
        }
    }
}
