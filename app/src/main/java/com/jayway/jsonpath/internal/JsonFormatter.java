package com.jayway.jsonpath.internal;

/* JADX INFO: loaded from: classes.dex */
public class JsonFormatter {
    private static final String INDENT = "   ";
    private static final int MODE_BETWEEN = 104;
    private static final int MODE_DOUBLE = 101;
    private static final int MODE_ESCAPE_DOUBLE = 103;
    private static final int MODE_ESCAPE_SINGLE = 102;
    private static final int MODE_SINGLE = 100;
    private static final String NEW_LINE = System.getProperty("line.separator");

    private static void appendIndent(StringBuilder sb, int i2) {
        while (i2 > 0) {
            sb.append(INDENT);
            i2--;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String prettyPrint(java.lang.String r11) {
        /*
            java.lang.String r0 = "[\\r\\n]"
            java.lang.String r1 = ""
            java.lang.String r11 = r11.replaceAll(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r11.length()
            int r1 = r1 * 2
            r0.<init>(r1)
            r1 = 0
            r2 = 104(0x68, float:1.46E-43)
            r3 = 0
            r4 = 104(0x68, float:1.46E-43)
        L19:
            int r5 = r11.length()
            if (r1 >= r5) goto Lb4
            char r5 = r11.charAt(r1)
            r6 = 101(0x65, float:1.42E-43)
            r7 = 100
            r8 = 34
            r9 = 92
            r10 = 39
            switch(r4) {
                case 100: goto La6;
                case 101: goto L98;
                case 102: goto L92;
                case 103: goto L8c;
                case 104: goto L32;
                default: goto L30;
            }
        L30:
            goto Lb0
        L32:
            r9 = 32
            if (r5 == r9) goto Lb0
            if (r5 == r8) goto L88
            if (r5 == r10) goto L84
            r6 = 44
            if (r5 == r6) goto L78
            r6 = 58
            if (r5 == r6) goto L72
            r6 = 91
            if (r5 == r6) goto L64
            r6 = 93
            if (r5 == r6) goto L56
            r6 = 123(0x7b, float:1.72E-43)
            if (r5 == r6) goto L64
            r6 = 125(0x7d, float:1.75E-43)
            if (r5 == r6) goto L56
            r0.append(r5)
            goto Lb0
        L56:
            java.lang.String r6 = com.jayway.jsonpath.internal.JsonFormatter.NEW_LINE
            r0.append(r6)
            int r3 = r3 + (-1)
            appendIndent(r0, r3)
            r0.append(r5)
            goto Lb0
        L64:
            r0.append(r5)
            java.lang.String r5 = com.jayway.jsonpath.internal.JsonFormatter.NEW_LINE
            r0.append(r5)
            int r3 = r3 + 1
            appendIndent(r0, r3)
            goto Lb0
        L72:
            java.lang.String r5 = " : "
            r0.append(r5)
            goto Lb0
        L78:
            r0.append(r5)
            java.lang.String r5 = com.jayway.jsonpath.internal.JsonFormatter.NEW_LINE
            r0.append(r5)
            appendIndent(r0, r3)
            goto Lb0
        L84:
            r0.append(r5)
            goto L95
        L88:
            r0.append(r5)
            goto L8f
        L8c:
            r0.append(r5)
        L8f:
            r4 = 101(0x65, float:1.42E-43)
            goto Lb0
        L92:
            r0.append(r5)
        L95:
            r4 = 100
            goto Lb0
        L98:
            r0.append(r5)
            if (r5 == r8) goto La3
            if (r5 == r9) goto La0
            goto Lb0
        La0:
            r4 = 103(0x67, float:1.44E-43)
            goto Lb0
        La3:
            r4 = 104(0x68, float:1.46E-43)
            goto Lb0
        La6:
            r0.append(r5)
            if (r5 == r10) goto La3
            if (r5 == r9) goto Lae
            goto Lb0
        Lae:
            r4 = 102(0x66, float:1.43E-43)
        Lb0:
            int r1 = r1 + 1
            goto L19
        Lb4:
            java.lang.String r11 = r0.toString()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jayway.jsonpath.internal.JsonFormatter.prettyPrint(java.lang.String):java.lang.String");
    }
}
