package k.a.a.a;

/* JADX INFO: compiled from: VocabularyImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class i0 implements h0 {
    public static final String[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i0 f8371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f8372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f8373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f8374e;

    static {
        String[] strArr = new String[0];
        a = strArr;
        f8371b = new i0(strArr, strArr, strArr);
    }

    public i0(String[] strArr, String[] strArr2, String[] strArr3) {
        strArr = strArr == null ? a : strArr;
        this.f8372c = strArr;
        strArr2 = strArr2 == null ? a : strArr2;
        this.f8373d = strArr2;
        strArr3 = strArr3 == null ? a : strArr3;
        this.f8374e = strArr3;
        Math.max(strArr3.length, Math.max(strArr.length, strArr2.length));
    }

    public String a(int i2) {
        String str;
        if (i2 >= 0) {
            String[] strArr = this.f8374e;
            if (i2 < strArr.length && (str = strArr[i2]) != null) {
                return str;
            }
        }
        String strB = b(i2);
        if (strB != null) {
            return strB;
        }
        String strC = c(i2);
        return strC != null ? strC : Integer.toString(i2);
    }

    public String b(int i2) {
        if (i2 < 0) {
            return null;
        }
        String[] strArr = this.f8372c;
        if (i2 < strArr.length) {
            return strArr[i2];
        }
        return null;
    }

    public String c(int i2) {
        if (i2 >= 0) {
            String[] strArr = this.f8373d;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        if (i2 == -1) {
            return "EOF";
        }
        return null;
    }
}
