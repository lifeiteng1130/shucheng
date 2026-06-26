package k.b.a.b.c;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;

/* JADX INFO: compiled from: NumericEntityUnescaper.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnumSet<a> f8632b;

    /* JADX INFO: compiled from: NumericEntityUnescaper.java */
    public enum a {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon
    }

    public h(a... aVarArr) {
        if (aVarArr.length > 0) {
            this.f8632b = EnumSet.copyOf((Collection) Arrays.asList(aVarArr));
        } else {
            this.f8632b = EnumSet.copyOf((Collection) Arrays.asList(a.semiColonRequired));
        }
    }

    @Override // k.b.a.b.c.b
    public int a(CharSequence charSequence, int i2, Writer writer) throws IOException {
        int i3;
        int length = charSequence.length();
        if (charSequence.charAt(i2) == '&' && i2 < length - 2 && charSequence.charAt(i2 + 1) == '#') {
            int i4 = i2 + 2;
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt == 'x' || cCharAt == 'X') {
                i4++;
                if (i4 == length) {
                    return 0;
                }
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i5 = i4;
            while (i5 < length && ((charSequence.charAt(i5) >= '0' && charSequence.charAt(i5) <= '9') || ((charSequence.charAt(i5) >= 'a' && charSequence.charAt(i5) <= 'f') || (charSequence.charAt(i5) >= 'A' && charSequence.charAt(i5) <= 'F')))) {
                i5++;
            }
            int i6 = (i5 == length || charSequence.charAt(i5) != ';') ? 0 : 1;
            if (i6 == 0) {
                a aVar = a.semiColonRequired;
                EnumSet<a> enumSet = this.f8632b;
                if (enumSet != null && enumSet.contains(aVar)) {
                    return 0;
                }
                a aVar2 = a.errorIfNoSemiColon;
                EnumSet<a> enumSet2 = this.f8632b;
                if (enumSet2 != null && enumSet2.contains(aVar2)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            try {
                int i7 = i3 != 0 ? Integer.parseInt(charSequence.subSequence(i4, i5).toString(), 16) : Integer.parseInt(charSequence.subSequence(i4, i5).toString(), 10);
                if (i7 > 65535) {
                    char[] chars = Character.toChars(i7);
                    writer.write(chars[0]);
                    writer.write(chars[1]);
                } else {
                    writer.write(i7);
                }
                return ((i5 + 2) - i4) + i3 + i6;
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }
}
