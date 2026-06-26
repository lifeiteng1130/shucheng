package k.b.a.b.c;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: OctalUnescaper.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends b {
    @Override // k.b.a.b.c.b
    public int a(CharSequence charSequence, int i2, Writer writer) throws IOException {
        int length = (charSequence.length() - i2) - 1;
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        if (charSequence.charAt(i2) == '\\' && length > 0) {
            int i3 = i2 + 1;
            if (c(charSequence.charAt(i3))) {
                int i4 = i2 + 2;
                int i5 = i2 + 3;
                sb.append(charSequence.charAt(i3));
                if (length > 1 && c(charSequence.charAt(i4))) {
                    sb.append(charSequence.charAt(i4));
                    if (length > 2) {
                        char cCharAt = charSequence.charAt(i3);
                        if (cCharAt >= '0' && cCharAt <= '3') {
                            z = true;
                        }
                        if (z && c(charSequence.charAt(i5))) {
                            sb.append(charSequence.charAt(i5));
                        }
                    }
                }
                writer.write(Integer.parseInt(sb.toString(), 8));
                return sb.length() + 1;
            }
        }
        return 0;
    }

    public final boolean c(char c2) {
        return c2 >= '0' && c2 <= '7';
    }
}
