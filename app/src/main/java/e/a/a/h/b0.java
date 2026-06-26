package e.a.a.h;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* JADX INFO: compiled from: StringUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    @NotNull
    public static final b0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final HashMap<Character, Integer> f5946b;

    static {
        b0 b0Var = new b0();
        a = b0Var;
        Objects.requireNonNull(b0Var);
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = "零一二三四五六七八九十".toCharArray();
        f.c0.c.j.d(charArray, "(this as java.lang.String).toCharArray()");
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            map.put(Character.valueOf(charArray[i3]), Integer.valueOf(i3));
            if (i4 > 10) {
                break;
            } else {
                i3 = i4;
            }
        }
        char[] charArray2 = "〇壹贰叁肆伍陆柒捌玖拾".toCharArray();
        f.c0.c.j.d(charArray2, "(this as java.lang.String).toCharArray()");
        while (true) {
            int i5 = i2 + 1;
            map.put(Character.valueOf(charArray2[i2]), Integer.valueOf(i2));
            if (i5 > 10) {
                map.put((char) 20004, 2);
                map.put((char) 30334, 100);
                map.put((char) 20336, 100);
                map.put((char) 21315, 1000);
                map.put((char) 20191, 1000);
                map.put((char) 19975, 10000);
                map.put((char) 20159, Integer.valueOf(FastDtoa.kTen8));
                f5946b = map;
                return;
            }
            i2 = i5;
        }
    }

    @NotNull
    public final String a(@NotNull String str) {
        f.c0.c.j.e(str, "input");
        char[] charArray = str.toCharArray();
        f.c0.c.j.d(charArray, "(this as java.lang.String).toCharArray()");
        int length = charArray.length - 1;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (charArray[i2] == 12288) {
                    charArray[i2] = ' ';
                } else {
                    char c2 = charArray[i2];
                    if (65281 <= c2 && c2 <= 65374) {
                        charArray[i2] = (char) (charArray[i2] - 65248);
                    }
                }
                if (i3 > length) {
                    break;
                }
                i2 = i3;
            }
        }
        return new String(charArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5 A[Catch: all -> 0x010d, TryCatch #1 {all -> 0x010d, blocks: (B:23:0x007d, B:26:0x0085, B:28:0x00a1, B:51:0x0102, B:31:0x00ad, B:36:0x00b8, B:40:0x00c3, B:42:0x00c7, B:44:0x00de, B:45:0x00f5), top: B:65:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fe A[LOOP:1: B:26:0x0085->B:49:0x00fe, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fb A[EDGE_INSN: B:68:0x00fb->B:48:0x00fb BREAK  A[LOOP:1: B:26:0x0085->B:49:0x00fe], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(@org.jetbrains.annotations.Nullable java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.h.b0.b(java.lang.String):int");
    }

    @NotNull
    public final String c(@Nullable String str) {
        String string = "";
        if (str == null) {
            return "";
        }
        f.c0.c.j.e(str, "str");
        if (!Pattern.compile("[0-9]+").matcher(str).matches()) {
            return str;
        }
        int i2 = Integer.parseInt(str);
        if (i2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append((char) 23383);
            string = sb.toString();
            if (i2 > 10000) {
                return f.c0.c.j.k(new DecimalFormat("#.#").format(((double) (i2 * 1.0f)) / 10000.0d), "万字");
            }
        }
        return string;
    }
}
