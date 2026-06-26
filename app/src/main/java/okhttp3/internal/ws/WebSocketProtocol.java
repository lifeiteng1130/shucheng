package okhttp3.internal.ws;

import c.a.a.a.a;
import f.c0.c.j;
import kotlin.Metadata;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: WebSocketProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00148\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u00148\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0016\u0010 \u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0016\u0010!\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u0016\u0010\"\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0016\u0010#\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b%\u0010\u0013R\u0016\u0010&\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b&\u0010\u0013R\u0016\u0010'\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b'\u0010\u0013R\u0016\u0010(\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b(\u0010\u0013R\u0016\u0010)\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b)\u0010\u0013R\u0016\u0010*\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b*\u0010\u0013R\u0016\u0010+\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b+\u0010\u0013¨\u0006."}, d2 = {"Lokhttp3/internal/ws/WebSocketProtocol;", "", "Lokio/Buffer$UnsafeCursor;", "cursor", "", "key", "Lf/v;", "toggleMask", "(Lokio/Buffer$UnsafeCursor;[B)V", "", "code", "", "closeCodeExceptionMessage", "(I)Ljava/lang/String;", "validateCloseCode", "(I)V", "acceptHeader", "(Ljava/lang/String;)Ljava/lang/String;", "B1_MASK_LENGTH", OptRuntime.GeneratorState.resumptionPoint_TYPE, "", "PAYLOAD_BYTE_MAX", "J", "B0_FLAG_RSV2", "B1_FLAG_MASK", "PAYLOAD_SHORT_MAX", "OPCODE_BINARY", "PAYLOAD_SHORT", "B0_MASK_OPCODE", "CLOSE_CLIENT_GOING_AWAY", "CLOSE_MESSAGE_MAX", "B0_FLAG_FIN", "B0_FLAG_RSV1", "CLOSE_NO_STATUS_CODE", "OPCODE_CONTROL_CLOSE", "ACCEPT_MAGIC", "Ljava/lang/String;", "PAYLOAD_LONG", "B0_FLAG_RSV3", "OPCODE_CONTINUATION", "OPCODE_CONTROL_PONG", "OPCODE_FLAG_CONTROL", "OPCODE_TEXT", "OPCODE_CONTROL_PING", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class WebSocketProtocol {

    @NotNull
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    @NotNull
    public final String acceptHeader(@NotNull String key) {
        j.e(key, "key");
        return ByteString.INSTANCE.encodeUtf8(key + ACCEPT_MAGIC).sha1().base64();
    }

    @Nullable
    public final String closeCodeExceptionMessage(int code) {
        if (code < 1000 || code >= 5000) {
            return a.G("Code must be in range [1000,5000): ", code);
        }
        if ((1004 > code || 1006 < code) && (1015 > code || 2999 < code)) {
            return null;
        }
        return a.d("Code ", code, " is reserved and may not be used.");
    }

    public final void toggleMask(@NotNull Buffer.UnsafeCursor cursor, @NotNull byte[] key) {
        j.e(cursor, "cursor");
        j.e(key, "key");
        int length = key.length;
        int i2 = 0;
        do {
            byte[] bArr = cursor.data;
            int i3 = cursor.start;
            int i4 = cursor.end;
            if (bArr != null) {
                while (i3 < i4) {
                    int i5 = i2 % length;
                    bArr[i3] = (byte) (bArr[i3] ^ key[i5]);
                    i3++;
                    i2 = i5 + 1;
                }
            }
        } while (cursor.next() != -1);
    }

    public final void validateCloseCode(int code) {
        String strCloseCodeExceptionMessage = closeCodeExceptionMessage(code);
        if (strCloseCodeExceptionMessage == null) {
            return;
        }
        j.c(strCloseCodeExceptionMessage);
        throw new IllegalArgumentException(strCloseCodeExceptionMessage.toString());
    }
}
