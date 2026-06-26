package j$.time.format;

import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final g a = new g('0', '+', '-', '.');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f7866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char f7867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char f7868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final char f7869e;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private g(char c2, char c3, char c4, char c5) {
        this.f7866b = c2;
        this.f7867c = c3;
        this.f7868d = c4;
        this.f7869e = c5;
    }

    String a(String str) {
        char c2 = this.f7866b;
        if (c2 == '0') {
            return str;
        }
        int i2 = c2 - '0';
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            charArray[i3] = (char) (charArray[i3] + i2);
        }
        return new String(charArray);
    }

    public char b() {
        return this.f7869e;
    }

    public char c() {
        return this.f7868d;
    }

    public char d() {
        return this.f7867c;
    }

    public char e() {
        return this.f7866b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f7866b == gVar.f7866b && this.f7867c == gVar.f7867c && this.f7868d == gVar.f7868d && this.f7869e == gVar.f7869e;
    }

    public int hashCode() {
        return this.f7866b + this.f7867c + this.f7868d + this.f7869e;
    }

    public String toString() {
        StringBuilder sbA = j$.com.android.tools.r8.a.a("DecimalStyle[");
        sbA.append(this.f7866b);
        sbA.append(this.f7867c);
        sbA.append(this.f7868d);
        sbA.append(this.f7869e);
        sbA.append("]");
        return sbA.toString();
    }
}
