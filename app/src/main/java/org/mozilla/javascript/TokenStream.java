package org.mozilla.javascript;

import java.io.IOException;
import java.io.Reader;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class TokenStream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char BYTE_ORDER_MARK = 65279;
    private static final int EOF_CHAR = -1;
    public Token.CommentType commentType;
    public int cursor;
    private boolean dirtyLine;
    private boolean isBinary;
    private boolean isHex;
    private boolean isOctal;
    private boolean isOldOctal;
    public int lineno;
    private double number;
    private Parser parser;
    private int quoteChar;
    public String regExpFlags;
    private char[] sourceBuffer;
    public int sourceCursor;
    private int sourceEnd;
    private Reader sourceReader;
    private String sourceString;
    private int stringBufferTop;
    public int tokenBeg;
    public int tokenEnd;
    private int ungetCursor;
    private boolean xmlIsAttribute;
    private boolean xmlIsTagContent;
    private int xmlOpenTagsCount;
    private String string = "";
    private char[] stringBuffer = new char[128];
    private ObjToIntMap allStrings = new ObjToIntMap(50);
    private final int[] ungetBuffer = new int[3];
    private boolean hitEOF = false;
    private int lineStart = 0;
    private int lineEndChar = -1;
    private String commentPrefix = "";
    private int commentCursor = -1;

    public TokenStream(Parser parser, Reader reader, String str, int i2) {
        this.parser = parser;
        this.lineno = i2;
        if (reader != null) {
            if (str != null) {
                Kit.codeBug();
            }
            this.sourceReader = reader;
            this.sourceBuffer = new char[512];
            this.sourceEnd = 0;
        } else {
            if (str == null) {
                Kit.codeBug();
            }
            this.sourceString = str;
            this.sourceEnd = str.length();
        }
        this.cursor = 0;
        this.sourceCursor = 0;
    }

    private void addToString(int i2) {
        int i3 = this.stringBufferTop;
        char[] cArr = this.stringBuffer;
        if (i3 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i3);
            this.stringBuffer = cArr2;
        }
        this.stringBuffer[i3] = (char) i2;
        this.stringBufferTop = i3 + 1;
    }

    private boolean canUngetChar() {
        int i2 = this.ungetCursor;
        return i2 == 0 || this.ungetBuffer[i2 - 1] != 10;
    }

    private final int charAt(int i2) {
        if (i2 < 0) {
            return -1;
        }
        String str = this.sourceString;
        if (str != null) {
            if (i2 >= this.sourceEnd) {
                return -1;
            }
            return str.charAt(i2);
        }
        if (i2 >= this.sourceEnd) {
            int i3 = this.sourceCursor;
            try {
                if (!fillSourceBuffer()) {
                    return -1;
                }
                i2 -= i3 - this.sourceCursor;
            } catch (IOException unused) {
                return -1;
            }
        }
        return this.sourceBuffer[i2];
    }

    private static String convertLastCharToHex(String str) {
        int length = str.length() - 1;
        StringBuilder sb = new StringBuilder(str.substring(0, length));
        sb.append("\\u");
        String hexString = Integer.toHexString(str.charAt(length));
        for (int i2 = 0; i2 < 4 - hexString.length(); i2++) {
            sb.append('0');
        }
        sb.append(hexString);
        return sb.toString();
    }

    private boolean fillSourceBuffer() throws IOException {
        if (this.sourceString != null) {
            Kit.codeBug();
        }
        if (this.sourceEnd == this.sourceBuffer.length) {
            if (this.lineStart == 0 || isMarkingComment()) {
                char[] cArr = this.sourceBuffer;
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, this.sourceEnd);
                this.sourceBuffer = cArr2;
            } else {
                char[] cArr3 = this.sourceBuffer;
                int i2 = this.lineStart;
                System.arraycopy(cArr3, i2, cArr3, 0, this.sourceEnd - i2);
                int i3 = this.sourceEnd;
                int i4 = this.lineStart;
                this.sourceEnd = i3 - i4;
                this.sourceCursor -= i4;
                this.lineStart = 0;
            }
        }
        Reader reader = this.sourceReader;
        char[] cArr4 = this.sourceBuffer;
        int i5 = this.sourceEnd;
        int i6 = reader.read(cArr4, i5, cArr4.length - i5);
        if (i6 < 0) {
            return false;
        }
        this.sourceEnd += i6;
        return true;
    }

    private int getChar() {
        return getChar(true);
    }

    private int getCharIgnoreLineEnd() {
        char cCharAt;
        int i2 = this.ungetCursor;
        if (i2 != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i3 = i2 - 1;
            this.ungetCursor = i3;
            return iArr[i3];
        }
        while (true) {
            String str = this.sourceString;
            if (str != null) {
                int i4 = this.sourceCursor;
                if (i4 == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                this.sourceCursor = i4 + 1;
                cCharAt = str.charAt(i4);
            } else {
                if (this.sourceCursor == this.sourceEnd && !fillSourceBuffer()) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                char[] cArr = this.sourceBuffer;
                int i5 = this.sourceCursor;
                this.sourceCursor = i5 + 1;
                cCharAt = cArr[i5];
            }
            if (cCharAt <= 127) {
                if (cCharAt != '\n' && cCharAt != '\r') {
                    return cCharAt;
                }
                this.lineEndChar = cCharAt;
            } else {
                if (cCharAt == 65279) {
                    return cCharAt;
                }
                if (!isJSFormatChar(cCharAt)) {
                    if (!ScriptRuntime.isJSLineTerminator(cCharAt)) {
                        return cCharAt;
                    }
                    this.lineEndChar = cCharAt;
                }
            }
        }
        return 10;
    }

    private String getStringFromBuffer() {
        this.tokenEnd = this.cursor;
        return new String(this.stringBuffer, 0, this.stringBufferTop);
    }

    private static boolean isAlpha(int i2) {
        return i2 <= 90 ? 65 <= i2 : 97 <= i2 && i2 <= 122;
    }

    public static boolean isDigit(int i2) {
        return 48 <= i2 && i2 <= 57;
    }

    private static boolean isJSFormatChar(int i2) {
        return i2 > 127 && Character.getType((char) i2) == 16;
    }

    public static boolean isJSSpace(int i2) {
        return i2 <= 127 ? i2 == 32 || i2 == 9 || i2 == 12 || i2 == 11 : i2 == 160 || i2 == 65279 || Character.getType((char) i2) == 12;
    }

    public static boolean isKeyword(String str, int i2, boolean z) {
        return stringToKeyword(str, i2, z) != 0;
    }

    private boolean isMarkingComment() {
        return this.commentCursor != -1;
    }

    private void markCommentStart() {
        markCommentStart("");
    }

    private boolean matchChar(int i2) {
        int charIgnoreLineEnd = getCharIgnoreLineEnd();
        if (charIgnoreLineEnd == i2) {
            this.tokenEnd = this.cursor;
            return true;
        }
        ungetCharIgnoreLineEnd(charIgnoreLineEnd);
        return false;
    }

    private int peekChar() {
        int i2 = getChar();
        ungetChar(i2);
        return i2;
    }

    private boolean readCDATA() {
        int i2 = getChar();
        while (i2 != -1) {
            addToString(i2);
            if (i2 == 93 && peekChar() == 93) {
                i2 = getChar();
                addToString(i2);
                if (peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                i2 = getChar();
            }
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readEntity() {
        int i2 = getChar();
        int i3 = 1;
        while (i2 != -1) {
            addToString(i2);
            if (i2 == 60) {
                i3++;
            } else if (i2 == 62 && i3 - 1 == 0) {
                return true;
            }
            i2 = getChar();
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readPI() {
        while (true) {
            int i2 = getChar();
            if (i2 == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i2);
            if (i2 == 63 && peekChar() == 62) {
                addToString(getChar());
                return true;
            }
        }
    }

    private boolean readQuotedString(int i2) {
        int i3;
        do {
            i3 = getChar();
            if (i3 == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i3);
        } while (i3 != i2);
        return true;
    }

    private boolean readXmlComment() {
        int i2 = getChar();
        while (i2 != -1) {
            addToString(i2);
            if (i2 == 45 && peekChar() == 45) {
                i2 = getChar();
                addToString(i2);
                if (peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                i2 = getChar();
            }
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private void skipLine() {
        int i2;
        do {
            i2 = getChar();
            if (i2 == -1) {
                break;
            }
        } while (i2 != 10);
        ungetChar(i2);
        this.tokenEnd = this.cursor;
    }

    private static int stringToKeyword(String str, int i2, boolean z) {
        return i2 < 200 ? stringToKeywordForJS(str) : stringToKeywordForES(str, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01aa, code lost:
    
        if (r17.charAt(1) == 'l') goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
    
        if (r1 != 'x') goto L186;
     */
    /* JADX WARN: Removed duplicated region for block: B:186:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0273 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int stringToKeywordForES(java.lang.String r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.stringToKeywordForES(java.lang.String, boolean):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0207, code lost:
    
        if (r17.charAt(1) == 'n') goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0233, code lost:
    
        if (r17.charAt(1) == 'h') goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x02a1, code lost:
    
        if (r17.charAt(1) == 'n') goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x02a3, code lost:
    
        r6 = 128;
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int stringToKeywordForJS(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.stringToKeywordForJS(java.lang.String):int");
    }

    private final String substring(int i2, int i3) {
        String str = this.sourceString;
        if (str != null) {
            return str.substring(i2, i3);
        }
        return new String(this.sourceBuffer, i2, i3 - i2);
    }

    private void ungetChar(int i2) {
        int i3 = this.ungetCursor;
        if (i3 != 0 && this.ungetBuffer[i3 - 1] == 10) {
            Kit.codeBug();
        }
        int[] iArr = this.ungetBuffer;
        int i4 = this.ungetCursor;
        this.ungetCursor = i4 + 1;
        iArr[i4] = i2;
        this.cursor--;
    }

    private void ungetCharIgnoreLineEnd(int i2) {
        int[] iArr = this.ungetBuffer;
        int i3 = this.ungetCursor;
        this.ungetCursor = i3 + 1;
        iArr[i3] = i2;
        this.cursor--;
    }

    public final boolean eof() {
        return this.hitEOF;
    }

    public final String getAndResetCurrentComment() {
        if (this.sourceString != null) {
            if (isMarkingComment()) {
                Kit.codeBug();
            }
            return this.sourceString.substring(this.tokenBeg, this.tokenEnd);
        }
        if (!isMarkingComment()) {
            Kit.codeBug();
        }
        StringBuilder sb = new StringBuilder(this.commentPrefix);
        sb.append(this.sourceBuffer, this.commentCursor, getTokenLength() - this.commentPrefix.length());
        this.commentCursor = -1;
        return sb.toString();
    }

    public Token.CommentType getCommentType() {
        return this.commentType;
    }

    public int getCursor() {
        return this.cursor;
    }

    public int getFirstXMLToken() {
        this.xmlOpenTagsCount = 0;
        this.xmlIsAttribute = false;
        this.xmlIsTagContent = false;
        if (!canUngetChar()) {
            return -1;
        }
        ungetChar(60);
        return getNextXMLToken();
    }

    public final String getLine() {
        int i2;
        int i3 = this.sourceCursor;
        int i4 = this.lineEndChar;
        if (i4 >= 0) {
            i2 = i3 - 1;
            if (i4 == 10 && charAt(i2 - 1) == 13) {
                i2--;
            }
        } else {
            int i5 = i3 - this.lineStart;
            while (true) {
                int iCharAt = charAt(this.lineStart + i5);
                if (iCharAt == -1 || ScriptRuntime.isJSLineTerminator(iCharAt)) {
                    break;
                }
                i5++;
            }
            i2 = i5 + this.lineStart;
        }
        return substring(this.lineStart, i2);
    }

    public final int getLineno() {
        return this.lineno;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0154, code lost:
    
        r10.stringBufferTop = 0;
        r10.string = null;
        r10.parser.addError("msg.XML.bad.form");
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x015d, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getNextXMLToken() {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.getNextXMLToken():int");
    }

    public final double getNumber() {
        return this.number;
    }

    public final int getOffset() {
        int i2 = this.sourceCursor - this.lineStart;
        return this.lineEndChar >= 0 ? i2 - 1 : i2;
    }

    public final char getQuoteChar() {
        return (char) this.quoteChar;
    }

    public final String getSourceString() {
        return this.sourceString;
    }

    public final String getString() {
        return this.string;
    }

    /* JADX WARN: Removed duplicated region for block: B:216:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:217:0x02a4 -> B:209:0x0288). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int getToken() {
        /*
            Method dump skipped, instruction units count: 1508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.getToken():int");
    }

    public int getTokenBeg() {
        return this.tokenBeg;
    }

    public int getTokenEnd() {
        return this.tokenEnd;
    }

    public int getTokenLength() {
        return this.tokenEnd - this.tokenBeg;
    }

    public final boolean isNumberBinary() {
        return this.isBinary;
    }

    public final boolean isNumberHex() {
        return this.isHex;
    }

    public final boolean isNumberOctal() {
        return this.isOctal;
    }

    public final boolean isNumberOldOctal() {
        return this.isOldOctal;
    }

    public boolean isXMLAttribute() {
        return this.xmlIsAttribute;
    }

    public String readAndClearRegExpFlags() {
        String str = this.regExpFlags;
        this.regExpFlags = null;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ba, code lost:
    
        ungetChar(r4);
        r8.tokenEnd = r8.cursor - 1;
        r8.string = new java.lang.String(r8.stringBuffer, 0, r8.stringBufferTop);
        r8.parser.reportError("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d2, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e3, code lost:
    
        ungetChar(r4);
        r8.tokenEnd = r8.cursor - 1;
        r8.string = new java.lang.String(r8.stringBuffer, 0, r8.stringBufferTop);
        r8.parser.reportError("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fb, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void readRegExp(int r9) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.readRegExp(int):void");
    }

    public String tokenToString(int i2) {
        return "";
    }

    private int getChar(boolean z) {
        char cCharAt;
        int i2 = this.ungetCursor;
        if (i2 != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i3 = i2 - 1;
            this.ungetCursor = i3;
            return iArr[i3];
        }
        while (true) {
            String str = this.sourceString;
            if (str != null) {
                int i4 = this.sourceCursor;
                if (i4 == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                this.sourceCursor = i4 + 1;
                cCharAt = str.charAt(i4);
            } else {
                if (this.sourceCursor == this.sourceEnd && !fillSourceBuffer()) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                char[] cArr = this.sourceBuffer;
                int i5 = this.sourceCursor;
                this.sourceCursor = i5 + 1;
                cCharAt = cArr[i5];
            }
            int i6 = this.lineEndChar;
            if (i6 >= 0) {
                if (i6 == 13 && cCharAt == '\n') {
                    this.lineEndChar = 10;
                } else {
                    this.lineEndChar = -1;
                    this.lineStart = this.sourceCursor - 1;
                    this.lineno++;
                }
            }
            if (cCharAt <= 127) {
                if (cCharAt != '\n' && cCharAt != '\r') {
                    return cCharAt;
                }
                this.lineEndChar = cCharAt;
            } else {
                if (cCharAt == 65279) {
                    return cCharAt;
                }
                if (!z || !isJSFormatChar(cCharAt)) {
                    break;
                }
            }
        }
        if (!ScriptRuntime.isJSLineTerminator(cCharAt)) {
            return cCharAt;
        }
        this.lineEndChar = cCharAt;
        return 10;
    }

    private void markCommentStart(String str) {
        if (!this.parser.compilerEnv.isRecordingComments() || this.sourceReader == null) {
            return;
        }
        this.commentPrefix = str;
        this.commentCursor = this.sourceCursor - 1;
    }

    public final String getLine(int i2, int[] iArr) {
        int i3 = (this.cursor + this.ungetCursor) - i2;
        int i4 = this.sourceCursor;
        if (i3 > i4) {
            return null;
        }
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            int iCharAt = charAt(i4 - 1);
            if (ScriptRuntime.isJSLineTerminator(iCharAt)) {
                if (iCharAt == 10 && charAt(i4 - 2) == 13) {
                    i3--;
                    i4--;
                }
                i5++;
                i6 = i4 - 1;
            }
            i3--;
            i4--;
        }
        int i7 = 0;
        while (true) {
            if (i4 <= 0) {
                i4 = 0;
                break;
            }
            if (ScriptRuntime.isJSLineTerminator(charAt(i4 - 1))) {
                break;
            }
            i4--;
            i7++;
        }
        iArr[0] = (this.lineno - i5) + (this.lineEndChar >= 0 ? 1 : 0);
        iArr[1] = i7;
        if (i5 == 0) {
            return getLine();
        }
        return substring(i4, i6);
    }
}
