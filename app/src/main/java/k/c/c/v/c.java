package k.c.c.v;

import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: Parsing.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static boolean a(CharSequence charSequence, int i2) {
        if (i2 >= charSequence.length()) {
            return false;
        }
        char cCharAt = charSequence.charAt(i2);
        switch (cCharAt) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (cCharAt) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (cCharAt) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                                return true;
                            default:
                                switch (cCharAt) {
                                    case '{':
                                    case '|':
                                    case Token.CATCH /* 125 */:
                                    case '~':
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static boolean b(CharSequence charSequence, int i2) {
        if (i2 >= charSequence.length()) {
            return false;
        }
        char cCharAt = charSequence.charAt(i2);
        return cCharAt == '\t' || cCharAt == ' ';
    }

    public static int c(char c2, CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            if (charSequence.charAt(i2) != c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int d(CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int e(CharSequence charSequence, int i2, int i3) {
        while (i2 >= i3) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i2;
            }
            i2--;
        }
        return i3 - 1;
    }
}
