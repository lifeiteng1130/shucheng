package okhttp3.internal.http2;

import c.a.a.a.a;
import f.c0.c.j;
import f.h0.k;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import okhttp3.internal.Util;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: Http2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0016\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0016\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0012R\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0012R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010&\u001a\u00020%8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u0012R\u0016\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u0012R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\"R\u0016\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\u0012R\u0016\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\u0012¨\u0006/"}, d2 = {"Lokhttp3/internal/http2/Http2;", "", "", "inbound", "", "streamId", "length", "type", "flags", "", "frameLog", "(ZIIII)Ljava/lang/String;", "formattedType$okhttp", "(I)Ljava/lang/String;", "formattedType", "formatFlags", "(II)Ljava/lang/String;", "INITIAL_MAX_FRAME_SIZE", OptRuntime.GeneratorState.resumptionPoint_TYPE, "TYPE_WINDOW_UPDATE", "FLAG_COMPRESSED", "TYPE_RST_STREAM", "TYPE_PRIORITY", "TYPE_HEADERS", "FLAG_PRIORITY", "FLAG_PADDED", "FLAG_END_PUSH_PROMISE", "FLAG_NONE", "TYPE_DATA", "FLAG_END_HEADERS", "FLAG_END_STREAM", "TYPE_PING", "", "FLAGS", "[Ljava/lang/String;", "TYPE_SETTINGS", "BINARY", "Lokio/ByteString;", "CONNECTION_PREFACE", "Lokio/ByteString;", "TYPE_PUSH_PROMISE", "FLAG_ACK", "FRAME_NAMES", "TYPE_CONTINUATION", "TYPE_GOAWAY", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2 {
    private static final String[] BINARY;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;
    public static final Http2 INSTANCE = new Http2();

    @JvmField
    @NotNull
    public static final ByteString CONNECTION_PREFACE = ByteString.INSTANCE.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] FLAGS = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i2 = 0; i2 < 256; i2++) {
            String binaryString = Integer.toBinaryString(i2);
            j.d(binaryString, "Integer.toBinaryString(it)");
            String str = Util.format("%8s", binaryString);
            j.e(str, "$this$replace");
            String strReplace = str.replace(' ', '0');
            j.d(strReplace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            strArr[i2] = strReplace;
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = FLAGS;
            strArr3[i4 | 8] = j.k(strArr3[i4], "|PADDED");
        }
        String[] strArr4 = FLAGS;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = FLAGS;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + "|" + strArr5[i6];
                StringBuilder sb = new StringBuilder();
                sb.append(strArr5[i8]);
                sb.append("|");
                strArr5[i9 | 8] = a.p(sb, strArr5[i6], "|PADDED");
            }
        }
        int length = FLAGS.length;
        for (int i10 = 0; i10 < length; i10++) {
            String[] strArr6 = FLAGS;
            if (strArr6[i10] == null) {
                strArr6[i10] = BINARY[i10];
            }
        }
    }

    private Http2() {
    }

    @NotNull
    public final String formatFlags(int type, int flags) {
        String str;
        if (flags == 0) {
            return "";
        }
        if (type != 2 && type != 3) {
            if (type == 4 || type == 6) {
                return flags == 1 ? "ACK" : BINARY[flags];
            }
            if (type != 7 && type != 8) {
                String[] strArr = FLAGS;
                if (flags < strArr.length) {
                    str = strArr[flags];
                    j.c(str);
                } else {
                    str = BINARY[flags];
                }
                return (type != 5 || (flags & 4) == 0) ? (type != 0 || (flags & 32) == 0) ? str : k.C(str, "PRIORITY", "COMPRESSED", false, 4) : k.C(str, "HEADERS", "PUSH_PROMISE", false, 4);
            }
        }
        return BINARY[flags];
    }

    @NotNull
    public final String formattedType$okhttp(int type) {
        String[] strArr = FRAME_NAMES;
        return type < strArr.length ? strArr[type] : Util.format("0x%02x", Integer.valueOf(type));
    }

    @NotNull
    public final String frameLog(boolean inbound, int streamId, int length, int type, int flags) {
        return Util.format("%s 0x%08x %5d %-13s %s", inbound ? "<<" : ">>", Integer.valueOf(streamId), Integer.valueOf(length), formattedType$okhttp(type), formatFlags(type, flags));
    }
}
