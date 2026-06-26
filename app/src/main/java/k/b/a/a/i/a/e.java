package k.b.a.a.i.a;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

/* JADX INFO: compiled from: JavaUnicodeEscaper.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class e extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8561d;

    public e(int i2, int i3, boolean z) {
        this.f8559b = i2;
        this.f8560c = i3;
        this.f8561d = z;
    }

    public static e d(int i2, int i3) {
        return new e(i2, i3, false);
    }

    @Override // k.b.a.a.i.a.c
    public boolean c(int i2, Writer writer) throws IOException {
        if (this.f8561d) {
            if (i2 < this.f8559b || i2 > this.f8560c) {
                return false;
            }
        } else if (i2 >= this.f8559b && i2 <= this.f8560c) {
            return false;
        }
        if (i2 > 65535) {
            char[] chars = Character.toChars(i2);
            StringBuilder sbR = c.a.a.a.a.r("\\u");
            String hexString = Integer.toHexString(chars[0]);
            Locale locale = Locale.ENGLISH;
            sbR.append(hexString.toUpperCase(locale));
            sbR.append("\\u");
            sbR.append(Integer.toHexString(chars[1]).toUpperCase(locale));
            writer.write(sbR.toString());
        } else {
            writer.write("\\u");
            char[] cArr = b.a;
            writer.write(cArr[(i2 >> 12) & 15]);
            writer.write(cArr[(i2 >> 8) & 15]);
            writer.write(cArr[(i2 >> 4) & 15]);
            writer.write(cArr[i2 & 15]);
        }
        return true;
    }
}
