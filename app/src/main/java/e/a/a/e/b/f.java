package e.a.a.e.b;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;

/* JADX INFO: compiled from: CharsetRecog_mbcs.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends h {

    /* JADX INFO: compiled from: CharsetRecog_mbcs.java */
    public static class a extends f {
        public static int[] a = {41280, 41281, 41282, 41283, 41287, 41289, 41333, 41334, 42048, 42054, 42055, 42056, 42065, 42068, 42071, 42084, 42090, 42092, 42103, 42147, 42148, 42151, 42177, 42190, 42193, 42207, 42216, 42237, 42304, 42312, 42328, 42345, 42445, 42471, 42583, 42593, 42594, 42600, 42608, 42664, 42675, 42681, 42707, 42715, 42726, 42738, 42816, 42833, 42841, 42970, 43171, 43173, 43181, 43217, 43219, 43236, 43260, 43456, 43474, 43507, 43627, 43706, 43710, 43724, 43772, 44103, 44111, 44208, 44242, 44377, 44745, 45024, 45290, 45423, 45747, 45764, 45935, 46156, 46158, 46412, 46501, 46525, 46544, 46552, 46705, 47085, 47207, 47428, 47832, 47940, 48033, 48593, 49860, 50105, 50240, 50271};

        @Override // e.a.a.e.b.h
        public String a() {
            return "zh";
        }

        @Override // e.a.a.e.b.h
        public String b() {
            return "Big5";
        }

        @Override // e.a.a.e.b.h
        public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
            int iD = d(aVar, a);
            if (iD == 0) {
                return null;
            }
            return new e.a.a.e.b.b(aVar, this, iD);
        }

        @Override // e.a.a.e.b.f
        public boolean e(e eVar, e.a.a.e.b.a aVar) {
            eVar.f5610c = false;
            int iA = eVar.a(aVar);
            eVar.a = iA;
            if (iA < 0) {
                return false;
            }
            if (iA > 127 && iA != 255) {
                int iA2 = eVar.a(aVar);
                if (iA2 < 0) {
                    return false;
                }
                eVar.a = (eVar.a << 8) | iA2;
                if (iA2 < 64 || iA2 == 127 || iA2 == 255) {
                    eVar.f5610c = true;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: CharsetRecog_mbcs.java */
    public static abstract class b extends f {

        /* JADX INFO: compiled from: CharsetRecog_mbcs.java */
        public static class a extends b {
            public static int[] a = {41377, 41378, 41379, 41382, 41404, 41418, 41419, 41430, 41431, 42146, 42148, 42150, 42152, 42154, 42155, 42156, 42157, 42159, 42161, 42163, 42165, 42167, 42169, 42171, 42173, 42175, 42176, 42177, 42179, 42180, 42182, 42183, 42184, 42185, 42186, 42187, 42190, 42191, 42192, 42206, 42207, 42209, 42210, 42212, 42216, 42217, 42218, 42219, 42220, 42223, 42226, 42227, 42402, 42403, 42404, 42406, 42407, 42410, 42413, 42415, 42416, 42419, 42421, 42423, 42424, 42425, 42431, 42435, 42438, 42439, 42440, 42441, 42443, 42448, 42453, 42454, 42455, 42462, 42464, 42465, 42469, 42473, 42474, 42475, 42476, 42477, 42483, 47273, 47572, 47854, 48072, 48880, 49079, 50410, 50940, 51133, 51896, 51955, 52188, 52689};

            @Override // e.a.a.e.b.h
            public String a() {
                return "ja";
            }

            @Override // e.a.a.e.b.h
            public String b() {
                return "EUC-JP";
            }

            @Override // e.a.a.e.b.h
            public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
                int iD = d(aVar, a);
                if (iD == 0) {
                    return null;
                }
                return new e.a.a.e.b.b(aVar, this, iD);
            }
        }

        /* JADX INFO: renamed from: e.a.a.e.b.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CharsetRecog_mbcs.java */
        public static class C0155b extends b {
            public static int[] a = {45217, 45235, 45253, 45261, 45268, 45286, 45293, 45304, 45306, 45308, 45496, 45497, 45511, 45527, 45538, 45994, 46011, 46274, 46287, 46297, 46315, 46501, 46517, 46527, 46535, 46569, 46835, 47023, 47042, 47054, 47270, 47278, 47286, 47288, 47291, 47337, 47531, 47534, 47564, 47566, 47613, 47800, 47822, 47824, 47857, 48103, 48115, 48125, 48301, 48314, 48338, 48374, 48570, 48576, 48579, 48581, 48838, 48840, 48863, 48878, 48888, 48890, 49057, 49065, 49088, 49124, 49131, 49132, 49144, 49319, 49327, 49336, 49338, 49339, 49341, 49351, 49356, 49358, 49359, 49366, 49370, 49381, 49403, 49404, 49572, 49574, 49590, 49622, 49631, 49654, 49656, 50337, 50637, 50862, 51151, 51153, 51154, 51160, 51173, 51373};

            @Override // e.a.a.e.b.h
            public String a() {
                return "ko";
            }

            @Override // e.a.a.e.b.h
            public String b() {
                return "EUC-KR";
            }

            @Override // e.a.a.e.b.h
            public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
                int iD = d(aVar, a);
                if (iD == 0) {
                    return null;
                }
                return new e.a.a.e.b.b(aVar, this, iD);
            }
        }

        @Override // e.a.a.e.b.f
        public boolean e(e eVar, e.a.a.e.b.a aVar) {
            eVar.f5610c = false;
            int iA = eVar.a(aVar);
            eVar.a = iA;
            if (iA < 0) {
                eVar.f5611d = true;
            } else if (iA > 141) {
                int iA2 = eVar.a(aVar);
                eVar.a = (eVar.a << 8) | iA2;
                if (iA < 161 || iA > 254) {
                    if (iA == 142) {
                        if (iA2 < 161) {
                            eVar.f5610c = true;
                        }
                    } else if (iA == 143) {
                        int iA3 = eVar.a(aVar);
                        eVar.a = (eVar.a << 8) | iA3;
                        if (iA3 < 161) {
                            eVar.f5610c = true;
                        }
                    }
                } else if (iA2 < 161) {
                    eVar.f5610c = true;
                }
            }
            return !eVar.f5611d;
        }
    }

    /* JADX INFO: compiled from: CharsetRecog_mbcs.java */
    public static class c extends f {
        public static int[] a = {41377, 41378, 41379, 41380, 41392, 41393, 41457, 41459, 41889, 41900, 41914, 45480, 45496, 45502, 45755, 46025, 46070, 46323, 46525, 46532, 46563, 46767, 46804, 46816, 47010, 47016, 47037, 47062, 47069, 47284, 47327, 47350, 47531, 47561, 47576, 47610, 47613, 47821, 48039, 48086, 48097, 48122, 48316, 48347, 48382, 48588, 48845, 48861, 49076, 49094, 49097, 49332, 49389, 49611, 49883, 50119, 50396, 50410, 50636, 50935, 51192, 51371, 51403, 51413, 51431, 51663, 51706, 51889, 51893, 51911, 51920, 51926, 51957, 51965, 52460, 52728, 52906, 52932, 52946, 52965, 53173, 53186, 53206, 53442, 53445, 53456, 53460, 53671, 53930, 53938, 53941, 53947, 53972, 54211, 54224, 54269, 54466, 54490, 54754, 54992};

        @Override // e.a.a.e.b.h
        public String a() {
            return "zh";
        }

        @Override // e.a.a.e.b.h
        public String b() {
            return "GB18030";
        }

        @Override // e.a.a.e.b.h
        public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
            int iD = d(aVar, a);
            if (iD == 0) {
                return null;
            }
            return new e.a.a.e.b.b(aVar, this, iD);
        }

        @Override // e.a.a.e.b.f
        public boolean e(e eVar, e.a.a.e.b.a aVar) {
            int iA;
            int iA2;
            eVar.f5610c = false;
            int iA3 = eVar.a(aVar);
            eVar.a = iA3;
            if (iA3 < 0) {
                eVar.f5611d = true;
            } else if (iA3 > 128) {
                int iA4 = eVar.a(aVar);
                eVar.a = (eVar.a << 8) | iA4;
                if (iA3 >= 129 && iA3 <= 254 && ((iA4 < 64 || iA4 > 126) && (iA4 < 80 || iA4 > 254))) {
                    if (iA4 < 48 || iA4 > 57 || (iA = eVar.a(aVar)) < 129 || iA > 254 || (iA2 = eVar.a(aVar)) < 48 || iA2 > 57) {
                        eVar.f5610c = true;
                    } else {
                        eVar.a = iA2 | (eVar.a << 16) | (iA << 8);
                    }
                }
            }
            return !eVar.f5611d;
        }
    }

    /* JADX INFO: compiled from: CharsetRecog_mbcs.java */
    public static class d extends f {
        public static int[] a = {33088, 33089, 33090, 33093, 33115, 33129, 33130, 33141, 33142, 33440, 33442, 33444, 33449, 33450, 33451, 33453, 33455, 33457, 33459, 33461, 33463, 33469, 33470, 33473, 33476, 33477, 33478, 33480, 33481, 33484, 33485, 33500, 33504, 33511, 33512, 33513, 33514, 33520, 33521, 33601, 33603, 33614, 33615, 33624, 33630, 33634, 33639, 33653, 33654, 33673, 33674, 33675, 33677, 33683, 36502, 37882, 38314};

        @Override // e.a.a.e.b.h
        public String a() {
            return "ja";
        }

        @Override // e.a.a.e.b.h
        public String b() {
            return "Shift_JIS";
        }

        @Override // e.a.a.e.b.h
        public e.a.a.e.b.b c(e.a.a.e.b.a aVar) {
            int iD = d(aVar, a);
            if (iD == 0) {
                return null;
            }
            return new e.a.a.e.b.b(aVar, this, iD);
        }

        @Override // e.a.a.e.b.f
        public boolean e(e eVar, e.a.a.e.b.a aVar) {
            eVar.f5610c = false;
            int iA = eVar.a(aVar);
            eVar.a = iA;
            if (iA < 0) {
                return false;
            }
            if (iA > 127 && (iA <= 160 || iA > 223)) {
                int iA2 = eVar.a(aVar);
                if (iA2 < 0) {
                    return false;
                }
                eVar.a = (iA << 8) | iA2;
                if ((iA2 < 64 || iA2 > 127) && (iA2 < 128 || iA2 > 255)) {
                    eVar.f5610c = true;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: CharsetRecog_mbcs.java */
    public static class e {
        public int a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5609b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5610c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5611d = false;

        public int a(e.a.a.e.b.a aVar) {
            int i2 = this.f5609b;
            if (i2 >= aVar.f5606g) {
                this.f5611d = true;
                return -1;
            }
            byte[] bArr = aVar.f5605f;
            this.f5609b = i2 + 1;
            return bArr[i2] & ExifInterface.MARKER;
        }
    }

    public int d(e.a.a.e.b.a aVar, int[] iArr) {
        e eVar = new e();
        eVar.a = 0;
        eVar.f5609b = 0;
        eVar.f5610c = false;
        eVar.f5611d = false;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (e(eVar, aVar)) {
            i3++;
            if (eVar.f5610c) {
                i4++;
            } else {
                long j2 = ((long) eVar.a) & 4294967295L;
                if (j2 > 255) {
                    i2++;
                    if (Arrays.binarySearch(iArr, (int) j2) >= 0) {
                        i5++;
                    }
                }
            }
            if (i4 >= 2 && i4 * 5 >= i2) {
                return 0;
            }
        }
        if (i2 <= 10 && i4 == 0) {
            return (i2 != 0 || i3 >= 10) ? 10 : 0;
        }
        if (i2 < i4 * 20) {
            return 0;
        }
        return Math.min((int) ((Math.log(i5 + 1) * (90.0d / Math.log(i2 / 4.0f))) + 10.0d), 100);
    }

    public abstract boolean e(e eVar, e.a.a.e.b.a aVar);
}
