package c.e.c.w.b;

import org.jsoup.nodes.Attributes;
import org.mozilla.javascript.Token;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final char[] a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f1427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f1428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f1429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f1430e;

    /* JADX INFO: compiled from: DecodedBitStreamParser.java */
    public enum a {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', Attributes.InternalPrefix, ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f1427b = cArr;
        f1428c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f1429d = cArr;
        f1430e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', MessageFormatter.DELIM_START, '|', MessageFormatter.DELIM_STOP, '~', 127};
    }

    public static void a(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    public static int b(int i2, int i3) {
        int i4 = i2 - (((i3 * Token.XMLEND) % 255) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }
}
