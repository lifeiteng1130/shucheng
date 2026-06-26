package com.jayway.jsonpath.internal.filter;

/* JADX INFO: loaded from: classes.dex */
public enum PatternFlag {
    UNIX_LINES(1, 'd'),
    CASE_INSENSITIVE(2, 'i'),
    COMMENTS(4, 'x'),
    MULTILINE(8, 'm'),
    DOTALL(32, 's'),
    UNICODE_CASE(64, 'u'),
    UNICODE_CHARACTER_CLASS(256, 'U');

    private final int code;
    private final char flag;

    PatternFlag(int i2, char c2) {
        this.code = i2;
        this.flag = c2;
    }

    private static int getCodeByFlag(char c2) {
        PatternFlag[] patternFlagArrValues = values();
        for (int i2 = 0; i2 < 7; i2++) {
            PatternFlag patternFlag = patternFlagArrValues[i2];
            if (patternFlag.flag == c2) {
                return patternFlag.code;
            }
        }
        return 0;
    }

    public static int parseFlags(char[] cArr) {
        int codeByFlag = 0;
        for (char c2 : cArr) {
            codeByFlag |= getCodeByFlag(c2);
        }
        return codeByFlag;
    }

    public static String parseFlags(int i2) {
        StringBuilder sb = new StringBuilder();
        PatternFlag[] patternFlagArrValues = values();
        for (int i3 = 0; i3 < 7; i3++) {
            PatternFlag patternFlag = patternFlagArrValues[i3];
            int i4 = patternFlag.code;
            if ((i4 & i2) == i4) {
                sb.append(patternFlag.flag);
            }
        }
        return sb.toString();
    }
}
