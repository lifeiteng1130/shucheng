package org.jsoup.nodes;

import java.io.IOException;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.CharacterReader;
import org.jsoup.parser.Parser;

/* JADX INFO: loaded from: classes3.dex */
public class Entities {
    public static final int codepointRadix = 36;
    private static final int empty = -1;
    private static final String emptyName = "";
    private static final char[] codeDelims = {',', ';'};
    private static final HashMap<String, String> multipoints = new HashMap<>();
    private static final Document.OutputSettings DefaultOutput = new Document.OutputSettings();

    /* JADX INFO: renamed from: org.jsoup.nodes.Entities$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jsoup$nodes$Entities$CoreCharset;

        static {
            CoreCharset.values();
            int[] iArr = new int[3];
            $SwitchMap$org$jsoup$nodes$Entities$CoreCharset = iArr;
            try {
                iArr[CoreCharset.ascii.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$nodes$Entities$CoreCharset[CoreCharset.utf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum CoreCharset {
        ascii,
        utf,
        fallback;

        public static CoreCharset byName(String str) {
            return str.equals("US-ASCII") ? ascii : str.startsWith("UTF-") ? utf : fallback;
        }
    }

    public enum EscapeMode {
        xhtml(EntitiesData.xmlPoints, 4),
        base(EntitiesData.basePoints, 106),
        extended(EntitiesData.fullPoints, 2125);

        private int[] codeKeys;
        private int[] codeVals;
        private String[] nameKeys;
        private String[] nameVals;

        EscapeMode(String str, int i2) {
            Entities.load(this, str, i2);
        }

        private int size() {
            return this.nameKeys.length;
        }

        public int codepointForName(String str) {
            int iBinarySearch = Arrays.binarySearch(this.nameKeys, str);
            if (iBinarySearch >= 0) {
                return this.codeVals[iBinarySearch];
            }
            return -1;
        }

        public String nameForCodepoint(int i2) {
            int iBinarySearch = Arrays.binarySearch(this.codeKeys, i2);
            if (iBinarySearch < 0) {
                return "";
            }
            String[] strArr = this.nameVals;
            if (iBinarySearch < strArr.length - 1) {
                int i3 = iBinarySearch + 1;
                if (this.codeKeys[i3] == i2) {
                    return strArr[i3];
                }
            }
            return strArr[iBinarySearch];
        }
    }

    private Entities() {
    }

    private static void appendEncoded(Appendable appendable, EscapeMode escapeMode, int i2) throws IOException {
        String strNameForCodepoint = escapeMode.nameForCodepoint(i2);
        if ("".equals(strNameForCodepoint)) {
            appendable.append("&#x").append(Integer.toHexString(i2)).append(';');
        } else {
            appendable.append('&').append(strNameForCodepoint).append(';');
        }
    }

    private static boolean canEncode(CoreCharset coreCharset, char c2, CharsetEncoder charsetEncoder) {
        int iOrdinal = coreCharset.ordinal();
        if (iOrdinal == 0) {
            return c2 < 128;
        }
        if (iOrdinal != 1) {
            return charsetEncoder.canEncode(c2);
        }
        return true;
    }

    public static int codepointsForName(String str, int[] iArr) {
        String str2 = multipoints.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        int iCodepointForName = EscapeMode.extended.codepointForName(str);
        if (iCodepointForName == -1) {
            return 0;
        }
        iArr[0] = iCodepointForName;
        return 1;
    }

    public static String escape(String str, Document.OutputSettings outputSettings) {
        if (str == null) {
            return "";
        }
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        try {
            escape(sbBorrowBuilder, str, outputSettings, false, false, false);
            return StringUtil.releaseBuilder(sbBorrowBuilder);
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    public static String getByName(String str) {
        String str2 = multipoints.get(str);
        if (str2 != null) {
            return str2;
        }
        int iCodepointForName = EscapeMode.extended.codepointForName(str);
        return iCodepointForName != -1 ? new String(new int[]{iCodepointForName}, 0, 1) : "";
    }

    public static boolean isBaseNamedEntity(String str) {
        return EscapeMode.base.codepointForName(str) != -1;
    }

    public static boolean isNamedEntity(String str) {
        return EscapeMode.extended.codepointForName(str) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void load(EscapeMode escapeMode, String str, int i2) {
        int i3;
        escapeMode.nameKeys = new String[i2];
        escapeMode.codeVals = new int[i2];
        escapeMode.codeKeys = new int[i2];
        escapeMode.nameVals = new String[i2];
        CharacterReader characterReader = new CharacterReader(str);
        int i4 = 0;
        while (!characterReader.isEmpty()) {
            String strConsumeTo = characterReader.consumeTo('=');
            characterReader.advance();
            int i5 = Integer.parseInt(characterReader.consumeToAny(codeDelims), 36);
            char cCurrent = characterReader.current();
            characterReader.advance();
            if (cCurrent == ',') {
                i3 = Integer.parseInt(characterReader.consumeTo(';'), 36);
                characterReader.advance();
            } else {
                i3 = -1;
            }
            int i6 = Integer.parseInt(characterReader.consumeTo('&'), 36);
            characterReader.advance();
            escapeMode.nameKeys[i4] = strConsumeTo;
            escapeMode.codeVals[i4] = i5;
            escapeMode.codeKeys[i6] = i5;
            escapeMode.nameVals[i6] = strConsumeTo;
            if (i3 != -1) {
                multipoints.put(strConsumeTo, new String(new int[]{i5, i3}, 0, 2));
            }
            i4++;
        }
        Validate.isTrue(i4 == i2, "Unexpected count of entities loaded");
    }

    public static String unescape(String str) {
        return unescape(str, false);
    }

    public static String unescape(String str, boolean z) {
        return Parser.unescapeEntities(str, z);
    }

    public static String escape(String str) {
        return escape(str, DefaultOutput);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void escape(java.lang.Appendable r10, java.lang.String r11, org.jsoup.nodes.Document.OutputSettings r12, boolean r13, boolean r14, boolean r15) {
        /*
            org.jsoup.nodes.Entities$EscapeMode r0 = r12.escapeMode()
            java.nio.charset.CharsetEncoder r1 = r12.encoder()
            org.jsoup.nodes.Entities$CoreCharset r12 = r12.coreCharset
            int r2 = r11.length()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L12:
            if (r4 >= r2) goto Lb6
            int r7 = r11.codePointAt(r4)
            r8 = 1
            if (r14 == 0) goto L33
            boolean r9 = org.jsoup.internal.StringUtil.isWhitespace(r7)
            if (r9 == 0) goto L31
            if (r15 == 0) goto L25
            if (r5 == 0) goto Laf
        L25:
            if (r6 == 0) goto L29
            goto Laf
        L29:
            r6 = 32
            r10.append(r6)
            r6 = 1
            goto Laf
        L31:
            r5 = 1
            r6 = 0
        L33:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r7 >= r8) goto L99
            char r8 = (char) r7
            r9 = 34
            if (r8 == r9) goto L8d
            r9 = 38
            if (r8 == r9) goto L87
            r9 = 60
            if (r8 == r9) goto L76
            r9 = 62
            if (r8 == r9) goto L6a
            r9 = 160(0xa0, float:2.24E-43)
            if (r8 == r9) goto L5a
            boolean r9 = canEncode(r12, r8, r1)
            if (r9 == 0) goto L56
            r10.append(r8)
            goto Laf
        L56:
            appendEncoded(r10, r0, r7)
            goto Laf
        L5a:
            org.jsoup.nodes.Entities$EscapeMode r8 = org.jsoup.nodes.Entities.EscapeMode.xhtml
            if (r0 == r8) goto L64
            java.lang.String r8 = "&nbsp;"
            r10.append(r8)
            goto Laf
        L64:
            java.lang.String r8 = "&#xa0;"
            r10.append(r8)
            goto Laf
        L6a:
            if (r13 != 0) goto L72
            java.lang.String r8 = "&gt;"
            r10.append(r8)
            goto Laf
        L72:
            r10.append(r8)
            goto Laf
        L76:
            if (r13 == 0) goto L81
            org.jsoup.nodes.Entities$EscapeMode r9 = org.jsoup.nodes.Entities.EscapeMode.xhtml
            if (r0 != r9) goto L7d
            goto L81
        L7d:
            r10.append(r8)
            goto Laf
        L81:
            java.lang.String r8 = "&lt;"
            r10.append(r8)
            goto Laf
        L87:
            java.lang.String r8 = "&amp;"
            r10.append(r8)
            goto Laf
        L8d:
            if (r13 == 0) goto L95
            java.lang.String r8 = "&quot;"
            r10.append(r8)
            goto Laf
        L95:
            r10.append(r8)
            goto Laf
        L99:
            java.lang.String r8 = new java.lang.String
            char[] r9 = java.lang.Character.toChars(r7)
            r8.<init>(r9)
            boolean r9 = r1.canEncode(r8)
            if (r9 == 0) goto Lac
            r10.append(r8)
            goto Laf
        Lac:
            appendEncoded(r10, r0, r7)
        Laf:
            int r7 = java.lang.Character.charCount(r7)
            int r4 = r4 + r7
            goto L12
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Entities.escape(java.lang.Appendable, java.lang.String, org.jsoup.nodes.Document$OutputSettings, boolean, boolean, boolean):void");
    }
}
