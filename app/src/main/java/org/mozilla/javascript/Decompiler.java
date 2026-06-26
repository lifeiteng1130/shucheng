package org.mozilla.javascript;

import okhttp3.internal.ws.WebSocketProtocol;
import org.jsoup.nodes.Attributes;

/* JADX INFO: loaded from: classes3.dex */
public class Decompiler {
    public static final int CASE_GAP_PROP = 3;
    private static final int FUNCTION_END = 168;
    public static final int INDENT_GAP_PROP = 2;
    public static final int INITIAL_INDENT_PROP = 1;
    public static final int ONLY_BODY_FLAG = 1;
    public static final int TO_SOURCE_FLAG = 2;
    private static final boolean printSource = false;
    private char[] sourceBuffer = new char[128];
    private int sourceTop;

    private void append(char c2) {
        int i2 = this.sourceTop;
        if (i2 == this.sourceBuffer.length) {
            increaseSourceCapacity(i2 + 1);
        }
        char[] cArr = this.sourceBuffer;
        int i3 = this.sourceTop;
        cArr[i3] = c2;
        this.sourceTop = i3 + 1;
    }

    private void appendString(String str) {
        int length = str.length();
        int i2 = this.sourceTop + (length >= 32768 ? 2 : 1) + length;
        if (i2 > this.sourceBuffer.length) {
            increaseSourceCapacity(i2);
        }
        if (length >= 32768) {
            char[] cArr = this.sourceBuffer;
            int i3 = this.sourceTop;
            cArr[i3] = (char) (32768 | (length >>> 16));
            this.sourceTop = i3 + 1;
        }
        char[] cArr2 = this.sourceBuffer;
        int i4 = this.sourceTop;
        cArr2[i4] = (char) length;
        int i5 = i4 + 1;
        this.sourceTop = i5;
        str.getChars(0, length, cArr2, i5);
        this.sourceTop = i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x036d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String decompile(java.lang.String r16, int r17, org.mozilla.javascript.UintMap r18) {
        /*
            Method dump skipped, instruction units count: 1316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Decompiler.decompile(java.lang.String, int, org.mozilla.javascript.UintMap):java.lang.String");
    }

    private static int getNext(String str, int i2, int i3) {
        int i4 = i3 + 1;
        if (i4 < i2) {
            return str.charAt(i4);
        }
        return 0;
    }

    private static int getSourceStringEnd(String str, int i2) {
        return printSourceString(str, i2, false, null);
    }

    private void increaseSourceCapacity(int i2) {
        if (i2 <= this.sourceBuffer.length) {
            Kit.codeBug();
        }
        char[] cArr = this.sourceBuffer;
        int length = cArr.length * 2;
        if (length >= i2) {
            i2 = length;
        }
        char[] cArr2 = new char[i2];
        System.arraycopy(cArr, 0, cArr2, 0, this.sourceTop);
        this.sourceBuffer = cArr2;
    }

    private static int printSourceNumber(String str, int i2, StringBuilder sb) {
        int i3;
        char cCharAt = str.charAt(i2);
        int i4 = i2 + 1;
        if (cCharAt == 'S') {
            dLongBitsToDouble = sb != null ? str.charAt(i4) : 0.0d;
            i3 = i4 + 1;
        } else {
            if (cCharAt != 'J' && cCharAt != 'D') {
                throw new RuntimeException();
            }
            if (sb != null) {
                long jCharAt = (((long) str.charAt(i4)) << 48) | (((long) str.charAt(i4 + 1)) << 32) | (((long) str.charAt(i4 + 2)) << 16) | ((long) str.charAt(i4 + 3));
                dLongBitsToDouble = cCharAt == 'J' ? jCharAt : Double.longBitsToDouble(jCharAt);
            }
            i3 = i4 + 4;
        }
        if (sb != null) {
            sb.append(ScriptRuntime.numberToString(dLongBitsToDouble, 10));
        }
        return i3;
    }

    private static int printSourceString(String str, int i2, boolean z, StringBuilder sb) {
        int iCharAt = str.charAt(i2);
        int i3 = i2 + 1;
        if ((32768 & iCharAt) != 0) {
            iCharAt = ((iCharAt & 32767) << 16) | str.charAt(i3);
            i3++;
        }
        if (sb != null) {
            String strSubstring = str.substring(i3, i3 + iCharAt);
            if (z) {
                sb.append('\"');
                sb.append(ScriptRuntime.escapeString(strSubstring));
                sb.append('\"');
            } else {
                sb.append(strSubstring);
            }
        }
        return i3 + iCharAt;
    }

    private String sourceToString(int i2) {
        if (i2 < 0 || this.sourceTop < i2) {
            Kit.codeBug();
        }
        return new String(this.sourceBuffer, i2, this.sourceTop - i2);
    }

    public void addEOL(int i2) {
        if (i2 < 0 || i2 > 167) {
            throw new IllegalArgumentException();
        }
        append((char) i2);
        append((char) 1);
    }

    public void addName(String str) {
        addToken(39);
        appendString(str);
    }

    public void addNumber(double d2) {
        addToken(40);
        long j2 = (long) d2;
        if (j2 != d2) {
            long jDoubleToLongBits = Double.doubleToLongBits(d2);
            append('D');
            append((char) (jDoubleToLongBits >> 48));
            append((char) (jDoubleToLongBits >> 32));
            append((char) (jDoubleToLongBits >> 16));
            append((char) jDoubleToLongBits);
            return;
        }
        if (j2 < 0) {
            Kit.codeBug();
        }
        if (j2 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            append('S');
            append((char) j2);
            return;
        }
        append('J');
        append((char) (j2 >> 48));
        append((char) (j2 >> 32));
        append((char) (j2 >> 16));
        append((char) j2);
    }

    public void addRegexp(String str, String str2) {
        addToken(48);
        appendString(Attributes.InternalPrefix + str + Attributes.InternalPrefix + str2);
    }

    public void addString(String str) {
        addToken(41);
        appendString(str);
    }

    public void addToken(int i2) {
        if (i2 < 0 || i2 > 167) {
            throw new IllegalArgumentException();
        }
        append((char) i2);
    }

    public int getCurrentOffset() {
        return this.sourceTop;
    }

    public String getEncodedSource() {
        return sourceToString(0);
    }

    public int markFunctionEnd(int i2) {
        int currentOffset = getCurrentOffset();
        append((char) 168);
        return currentOffset;
    }

    public int markFunctionStart(int i2) {
        int currentOffset = getCurrentOffset();
        if (i2 != 4) {
            addToken(110);
            append((char) i2);
        }
        return currentOffset;
    }
}
