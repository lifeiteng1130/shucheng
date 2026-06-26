package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bj;

/* JADX INFO: compiled from: TProtocolUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class bs {
    private static int a = Integer.MAX_VALUE;

    public static void a(int i2) {
        a = i2;
    }

    public static void a(bp bpVar, byte b2) {
        a(bpVar, b2, a);
    }

    public static void a(bp bpVar, byte b2, int i2) throws aw {
        if (i2 > 0) {
            int i3 = 0;
            switch (b2) {
                case 2:
                    bpVar.t();
                    return;
                case 3:
                    bpVar.u();
                    return;
                case 4:
                    bpVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    bpVar.v();
                    return;
                case 8:
                    bpVar.w();
                    return;
                case 10:
                    bpVar.x();
                    return;
                case 11:
                    bpVar.A();
                    return;
                case 12:
                    bpVar.j();
                    while (true) {
                        byte b3 = bpVar.l().f4761b;
                        if (b3 == 0) {
                            bpVar.k();
                            return;
                        } else {
                            a(bpVar, b3, i2 - 1);
                            bpVar.m();
                        }
                    }
                    break;
                case 13:
                    bm bmVarN = bpVar.n();
                    while (i3 < bmVarN.f4765c) {
                        int i4 = i2 - 1;
                        a(bpVar, bmVarN.a, i4);
                        a(bpVar, bmVarN.f4764b, i4);
                        i3++;
                    }
                    bpVar.o();
                    return;
                case 14:
                    bt btVarR = bpVar.r();
                    while (i3 < btVarR.f4779b) {
                        a(bpVar, btVarR.a, i2 - 1);
                        i3++;
                    }
                    bpVar.s();
                    return;
                case 15:
                    bl blVarP = bpVar.p();
                    while (i3 < blVarP.f4763b) {
                        a(bpVar, blVarP.a, i2 - 1);
                        i3++;
                    }
                    bpVar.q();
                    return;
            }
        } else {
            throw new aw("Maximum skip depth exceeded");
        }
    }

    public static br a(byte[] bArr, br brVar) {
        if (bArr[0] > 16) {
            return new bj.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? brVar : new bj.a();
    }
}
