package k.a.a.a.k0;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: ATNDeserializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static final UUID a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UUID f8415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UUID f8416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final UUID f8417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<UUID> f8418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UUID f8419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f8420g;

    /* JADX INFO: compiled from: ATNDeserializer.java */
    public interface a {
        int a(char[] cArr, int i2);

        int size();
    }

    /* JADX INFO: compiled from: ATNDeserializer.java */
    public enum b {
        UNICODE_BMP,
        UNICODE_SMP
    }

    static {
        UUID uuidFromString = UUID.fromString("33761B2D-78BB-4A43-8B0B-4F5BEE8AACF3");
        a = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("1DA0C57D-6C06-438A-9B27-10BCB3CE0F61");
        f8415b = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("AADB8D7E-AEEF-4415-AD2B-8204D6CF042E");
        f8416c = uuidFromString3;
        UUID uuidFromString4 = UUID.fromString("59627784-3BE5-417A-B9EB-8131A7286089");
        f8417d = uuidFromString4;
        ArrayList arrayList = new ArrayList();
        f8418e = arrayList;
        arrayList.add(uuidFromString);
        arrayList.add(uuidFromString2);
        arrayList.add(uuidFromString3);
        arrayList.add(uuidFromString4);
        f8419f = uuidFromString4;
    }

    public g() {
        d dVar = d.a;
        this.f8420g = d.a;
    }

    public static boolean d(UUID uuid, UUID uuid2) {
        List<UUID> list = f8418e;
        int iIndexOf = list.indexOf(uuid);
        return iIndexOf >= 0 && list.indexOf(uuid2) >= iIndexOf;
    }

    public static long e(char[] cArr, int i2) {
        long j2 = ((long) (cArr[i2] | (cArr[i2 + 1] << 16))) & 4294967295L;
        int i3 = i2 + 2;
        return (((long) ((cArr[i3 + 1] << 16) | cArr[i3])) << 32) | j2;
    }

    public void a(boolean z) {
        if (!z) {
            throw new IllegalStateException((String) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k.a.a.a.k0.a b(char[] r19) {
        /*
            Method dump skipped, instruction units count: 1772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.k0.g.b(char[]):k.a.a.a.k0.a");
    }

    public final int c(char[] cArr, int i2, List<k.a.a.a.m0.i> list, a aVar) {
        int i3 = i2 + 1;
        char c2 = cArr[i2];
        for (int i4 = 0; i4 < c2; i4++) {
            char c3 = cArr[i3];
            int i5 = i3 + 1;
            k.a.a.a.m0.i iVar = new k.a.a.a.m0.i(new int[0]);
            list.add(iVar);
            int i6 = i5 + 1;
            if (cArr[i5] != 0) {
                iVar.a(-1);
            }
            i3 = i6;
            int i7 = 0;
            while (i7 < c3) {
                int iA = aVar.a(cArr, i3);
                int size = aVar.size() + i3;
                int iA2 = aVar.a(cArr, size);
                int size2 = size + aVar.size();
                iVar.b(iA, iA2);
                i7++;
                i3 = size2;
            }
        }
        return i3;
    }

    public void f(k.a.a.a.k0.a aVar) {
        for (i iVar : aVar.a) {
            if (iVar != null) {
                a(iVar.f8434d || iVar.b() <= 1);
                if (iVar instanceof u0) {
                    a(((u0) iVar).f8461j != null);
                }
                if (iVar instanceof l1) {
                    l1 l1Var = (l1) iVar;
                    a(l1Var.f8443i != null);
                    a(l1Var.b() == 2);
                    if (l1Var.d(0).f8448b instanceof k1) {
                        a(l1Var.d(1).f8448b instanceof p0);
                        a(!l1Var.f8474h);
                    } else {
                        if (!(l1Var.d(0).f8448b instanceof p0)) {
                            throw new IllegalStateException();
                        }
                        a(l1Var.d(1).f8448b instanceof k1);
                        a(l1Var.f8474h);
                    }
                }
                if (iVar instanceof m1) {
                    a(iVar.b() == 1);
                    a(iVar.d(0).f8448b instanceof l1);
                }
                if (iVar instanceof p0) {
                    a(((p0) iVar).f8449g != null);
                }
                if (iVar instanceof e1) {
                    a(((e1) iVar).f8413g != null);
                }
                if (iVar instanceof s) {
                    a(((s) iVar).f8451i != null);
                }
                if (iVar instanceof r) {
                    a(((r) iVar).f8450g != null);
                }
                if (iVar instanceof w) {
                    w wVar = (w) iVar;
                    a(wVar.b() <= 1 || wVar.f8473g >= 0);
                } else {
                    a(iVar.b() <= 1 || (iVar instanceof f1));
                }
            }
        }
    }

    public g(d dVar) {
        this.f8420g = dVar;
    }
}
