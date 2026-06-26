package e.b.a.r.n.c;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import org.jsoup.parser.CharacterReader;

/* JADX INFO: compiled from: CharacterReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final char[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Reader f6063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String[] f6069h;

    public a(String str) {
        StringReader stringReader = new StringReader(str);
        str.length();
        this.f6069h = new String[128];
        c.b.a.m.f.f4(stringReader);
        if (!stringReader.markSupported()) {
            throw new IllegalArgumentException("Must be true");
        }
        this.f6063b = stringReader;
        this.a = new char[4096];
        b();
    }

    public static String c(char[] cArr, String[] strArr, int i2, int i3) {
        if (i3 > 12) {
            return new String(cArr, i2, i3);
        }
        boolean z = true;
        if (i3 < 1) {
            return "";
        }
        int i4 = i2;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            i6 = (i6 * 31) + cArr[i4];
            i5++;
            i4++;
        }
        int length = (strArr.length - 1) & i6;
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i2, i3);
            strArr[length] = str2;
            return str2;
        }
        if (i3 == str.length()) {
            int i7 = i2;
            int i8 = i3;
            int i9 = 0;
            while (true) {
                int i10 = i8 - 1;
                if (i8 == 0) {
                    break;
                }
                int i11 = i7 + 1;
                int i12 = i9 + 1;
                if (cArr[i7] != str.charAt(i9)) {
                    break;
                }
                i7 = i11;
                i8 = i10;
                i9 = i12;
            }
            z = false;
        } else {
            z = false;
        }
        if (z) {
            return str;
        }
        String str3 = new String(cArr, i2, i3);
        strArr[length] = str3;
        return str3;
    }

    public void a() {
        this.f6066e++;
    }

    public final void b() {
        int i2 = this.f6066e;
        if (i2 < this.f6065d) {
            return;
        }
        try {
            this.f6063b.skip(i2);
            this.f6063b.mark(4096);
            int i3 = this.f6063b.read(this.a);
            this.f6063b.reset();
            if (i3 != -1) {
                this.f6064c = i3;
                this.f6067f += this.f6066e;
                this.f6066e = 0;
                this.f6068g = 0;
                if (i3 > 3072) {
                    i3 = 3072;
                }
                this.f6065d = i3;
            }
        } catch (IOException e2) {
            throw new e.b.a.r.n.a(e2);
        }
    }

    public char d() {
        b();
        char c2 = l() ? CharacterReader.EOF : this.a[this.f6066e];
        this.f6066e++;
        return c2;
    }

    public String e() {
        char c2;
        b();
        int i2 = this.f6066e;
        while (true) {
            int i3 = this.f6066e;
            if (i3 >= this.f6064c || (((c2 = this.a[i3]) < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !Character.isLetter(c2)))) {
                break;
            }
            this.f6066e++;
        }
        return c(this.a, this.f6069h, i2, this.f6066e - i2);
    }

    public String f(char c2) {
        int i2;
        b();
        int i3 = this.f6066e;
        while (true) {
            if (i3 >= this.f6064c) {
                i2 = -1;
                break;
            }
            if (c2 == this.a[i3]) {
                i2 = i3 - this.f6066e;
                break;
            }
            i3++;
        }
        if (i2 == -1) {
            return i();
        }
        String strC = c(this.a, this.f6069h, this.f6066e, i2);
        this.f6066e += i2;
        return strC;
    }

    public String g(char... cArr) {
        b();
        int i2 = this.f6066e;
        int i3 = this.f6064c;
        char[] cArr2 = this.a;
        loop0: while (this.f6066e < i3) {
            for (char c2 : cArr) {
                if (cArr2[this.f6066e] == c2) {
                    break loop0;
                }
            }
            this.f6066e++;
        }
        int i4 = this.f6066e;
        return i4 > i2 ? c(this.a, this.f6069h, i2, i4 - i2) : "";
    }

    public String h(char... cArr) {
        b();
        int i2 = this.f6066e;
        int i3 = this.f6064c;
        char[] cArr2 = this.a;
        while (true) {
            int i4 = this.f6066e;
            if (i4 >= i3 || Arrays.binarySearch(cArr, cArr2[i4]) >= 0) {
                break;
            }
            this.f6066e++;
        }
        int i5 = this.f6066e;
        return i5 > i2 ? c(this.a, this.f6069h, i2, i5 - i2) : "";
    }

    public String i() {
        b();
        char[] cArr = this.a;
        String[] strArr = this.f6069h;
        int i2 = this.f6066e;
        String strC = c(cArr, strArr, i2, this.f6064c - i2);
        this.f6066e = this.f6064c;
        return strC;
    }

    public char j() {
        b();
        return l() ? CharacterReader.EOF : this.a[this.f6066e];
    }

    public boolean k() {
        b();
        return this.f6066e >= this.f6064c;
    }

    public final boolean l() {
        return this.f6066e >= this.f6064c;
    }

    public boolean m(String str) {
        boolean z;
        b();
        b();
        int length = str.length();
        if (length > this.f6064c - this.f6066e) {
            z = false;
            break;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != this.a[this.f6066e + i2]) {
                z = false;
                break;
            }
        }
        z = true;
        if (!z) {
            return false;
        }
        this.f6066e = str.length() + this.f6066e;
        return true;
    }

    public boolean n(String str) {
        boolean z;
        b();
        int length = str.length();
        if (length > this.f6064c - this.f6066e) {
            z = false;
            break;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.toUpperCase(str.charAt(i2)) != Character.toUpperCase(this.a[this.f6066e + i2])) {
                z = false;
                break;
            }
        }
        z = true;
        if (!z) {
            return false;
        }
        this.f6066e = str.length() + this.f6066e;
        return true;
    }

    public boolean o(char c2) {
        return !k() && this.a[this.f6066e] == c2;
    }

    public boolean p(char... cArr) {
        if (k()) {
            return false;
        }
        b();
        char c2 = this.a[this.f6066e];
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    public boolean q() {
        if (k()) {
            return false;
        }
        char c2 = this.a[this.f6066e];
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2);
    }

    public int r(CharSequence charSequence) {
        b();
        char cCharAt = charSequence.charAt(0);
        int i2 = this.f6066e;
        while (i2 < this.f6064c) {
            if (cCharAt != this.a[i2]) {
                do {
                    i2++;
                    if (i2 >= this.f6064c) {
                        break;
                    }
                } while (cCharAt != this.a[i2]);
            }
            int i3 = i2 + 1;
            int length = (charSequence.length() + i3) - 1;
            int i4 = this.f6064c;
            if (i2 < i4 && length <= i4) {
                int i5 = i3;
                for (int i6 = 1; i5 < length && charSequence.charAt(i6) == this.a[i5]; i6++) {
                    i5++;
                }
                if (i5 == length) {
                    return i2 - this.f6066e;
                }
            }
            i2 = i3;
        }
        return -1;
    }

    public int s() {
        return this.f6067f + this.f6066e;
    }

    public void t() {
        this.f6066e--;
    }

    public String toString() {
        char[] cArr = this.a;
        int i2 = this.f6066e;
        return new String(cArr, i2, this.f6064c - i2);
    }
}
