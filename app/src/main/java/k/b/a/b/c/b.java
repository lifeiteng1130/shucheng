package k.b.a.b.c;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: CharSequenceTranslator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public abstract int a(CharSequence charSequence, int i2, Writer writer);

    public final void b(CharSequence charSequence, Writer writer) throws IOException {
        int length = charSequence.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iA = a(charSequence, iCharCount, writer);
            if (iA == 0) {
                char cCharAt = charSequence.charAt(iCharCount);
                writer.write(cCharAt);
                iCharCount++;
                if (Character.isHighSurrogate(cCharAt) && iCharCount < length) {
                    char cCharAt2 = charSequence.charAt(iCharCount);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        writer.write(cCharAt2);
                        iCharCount++;
                    }
                }
            } else {
                for (int i2 = 0; i2 < iA; i2++) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                }
            }
        }
    }
}
