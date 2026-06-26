package k.e.a;

import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import org.jsoup.nodes.Attributes;

/* JADX INFO: loaded from: classes3.dex */
public class r {
    public static final r a = new r(0, null, 1443168256, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f8909b = new r(1, null, 1509950721, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f8910c = new r(2, null, 1124075009, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f8911d = new r(3, null, 1107297537, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r f8912e = new r(4, null, 1392510721, 1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final r f8913f = new r(5, null, 1224736769, 1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final r f8914g = new r(6, null, 1174536705, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final r f8915h = new r(7, null, 1241579778, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final r f8916i = new r(8, null, 1141048066, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final char[] f8918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8919l;
    public final int m;

    public r(int i2, char[] cArr, int i3, int i4) {
        this.f8917j = i2;
        this.f8918k = cArr;
        this.f8919l = i3;
        this.m = i4;
    }

    public static r a(char[] cArr, int i2) {
        int i3;
        char c2 = cArr[i2];
        if (c2 == 'F') {
            return f8914g;
        }
        if (c2 == 'L') {
            int i4 = 1;
            while (cArr[i2 + i4] != ';') {
                i4++;
            }
            return new r(10, cArr, i2 + 1, i4 - 1);
        }
        if (c2 == 'S') {
            return f8912e;
        }
        if (c2 == 'V') {
            return a;
        }
        if (c2 == 'I') {
            return f8913f;
        }
        if (c2 == 'J') {
            return f8915h;
        }
        if (c2 == 'Z') {
            return f8909b;
        }
        if (c2 != '[') {
            switch (c2) {
                case 'B':
                    return f8911d;
                case 'C':
                    return f8910c;
                case 'D':
                    return f8916i;
                default:
                    return new r(11, cArr, i2, cArr.length - i2);
            }
        }
        int i5 = 1;
        while (true) {
            i3 = i2 + i5;
            if (cArr[i3] != '[') {
                break;
            }
            i5++;
        }
        if (cArr[i3] == 'L') {
            do {
                i5++;
            } while (cArr[i2 + i5] != ';');
        }
        return new r(9, cArr, i2, i5 + 1);
    }

    public static void b(StringBuffer stringBuffer, Class cls) {
        while (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                stringBuffer.append('L');
                String name = cls.getName();
                int length = name.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char cCharAt = name.charAt(i2);
                    if (cCharAt == '.') {
                        cCharAt = Attributes.InternalPrefix;
                    }
                    stringBuffer.append(cCharAt);
                }
                stringBuffer.append(';');
                return;
            }
            stringBuffer.append('[');
            cls = cls.getComponentType();
        }
        stringBuffer.append(cls == Integer.TYPE ? 'I' : cls == Void.TYPE ? 'V' : cls == Boolean.TYPE ? 'Z' : cls == Byte.TYPE ? 'B' : cls == Character.TYPE ? 'C' : cls == Short.TYPE ? 'S' : cls == Double.TYPE ? 'D' : cls == Float.TYPE ? 'F' : 'J');
    }

    public static r[] c(String str) {
        char[] charArray = str.toCharArray();
        int i2 = 1;
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int i5 = i3 + 1;
            char c2 = charArray[i3];
            if (c2 == ')') {
                break;
            }
            if (c2 == 'L') {
                while (true) {
                    i3 = i5 + 1;
                    if (charArray[i5] == ';') {
                        break;
                    }
                    i5 = i3;
                }
                i4++;
            } else {
                if (c2 != '[') {
                    i4++;
                }
                i3 = i5;
            }
        }
        r[] rVarArr = new r[i4];
        int i6 = 0;
        while (charArray[i2] != ')') {
            rVarArr[i6] = a(charArray, i2);
            i2 += rVarArr[i6].m + (rVarArr[i6].f8917j == 10 ? 2 : 0);
            i6++;
        }
        return rVarArr;
    }

    public static int d(String str) {
        int i2;
        char cCharAt;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            i2 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 == ')') {
                break;
            }
            if (cCharAt2 == 'L') {
                while (true) {
                    i4 = i2 + 1;
                    if (str.charAt(i2) == ';') {
                        break;
                    }
                    i2 = i4;
                }
                i5++;
            } else {
                if (cCharAt2 == '[') {
                    while (true) {
                        cCharAt = str.charAt(i2);
                        if (cCharAt != '[') {
                            break;
                        }
                        i2++;
                    }
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i5--;
                    }
                } else {
                    i5 = (cCharAt2 == 'D' || cCharAt2 == 'J') ? i5 + 2 : i5 + 1;
                }
                i4 = i2;
            }
        }
        char cCharAt3 = str.charAt(i2);
        int i6 = i5 << 2;
        if (cCharAt3 == 'V') {
            i3 = 0;
        } else if (cCharAt3 == 'D' || cCharAt3 == 'J') {
            i3 = 2;
        }
        return i6 | i3;
    }

    public static String f(Class cls) {
        return cls.getName().replace('.', Attributes.InternalPrefix);
    }

    public static String g(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        for (Class<?> cls : parameterTypes) {
            b(stringBuffer, cls);
        }
        stringBuffer.append(')');
        b(stringBuffer, method.getReturnType());
        return stringBuffer.toString();
    }

    public static r h(Class cls) {
        if (cls.isPrimitive()) {
            return cls == Integer.TYPE ? f8913f : cls == Void.TYPE ? a : cls == Boolean.TYPE ? f8909b : cls == Byte.TYPE ? f8911d : cls == Character.TYPE ? f8910c : cls == Short.TYPE ? f8912e : cls == Double.TYPE ? f8916i : cls == Float.TYPE ? f8914g : f8915h;
        }
        StringBuffer stringBuffer = new StringBuffer();
        b(stringBuffer, cls);
        return a(stringBuffer.toString().toCharArray(), 0);
    }

    public String e() {
        char c2;
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = this.f8918k;
        if (cArr == null) {
            c2 = (char) ((this.f8919l & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        } else {
            if (this.f8917j != 10) {
                stringBuffer.append(cArr, this.f8919l, this.m);
                return stringBuffer.toString();
            }
            stringBuffer.append('L');
            stringBuffer.append(this.f8918k, this.f8919l, this.m);
            c2 = ';';
        }
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        int i2 = this.f8917j;
        if (i2 != rVar.f8917j) {
            return false;
        }
        if (i2 >= 9) {
            int i3 = this.m;
            if (i3 != rVar.m) {
                return false;
            }
            int i4 = this.f8919l;
            int i5 = rVar.f8919l;
            int i6 = i3 + i4;
            while (i4 < i6) {
                if (this.f8918k[i4] != rVar.f8918k[i5]) {
                    return false;
                }
                i4++;
                i5++;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.f8917j;
        int i3 = i2 * 13;
        if (i2 >= 9) {
            int i4 = this.f8919l;
            int i5 = this.m + i4;
            while (i4 < i5) {
                i3 = (i3 + this.f8918k[i4]) * 17;
                i4++;
            }
        }
        return i3;
    }

    public String toString() {
        return e();
    }
}
