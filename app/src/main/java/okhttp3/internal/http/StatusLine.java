package okhttp3.internal.http;

import c.a.a.a.a;
import f.c0.c.f;
import f.c0.c.j;
import f.h0.k;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import okhttp3.Protocol;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: StatusLine.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http/StatusLine;", "", "", "toString", "()Ljava/lang/String;", "message", "Ljava/lang/String;", "", "code", OptRuntime.GeneratorState.resumptionPoint_TYPE, "Lokhttp3/Protocol;", "protocol", "Lokhttp3/Protocol;", "<init>", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class StatusLine {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;

    @JvmField
    public final int code;

    @JvmField
    @NotNull
    public final String message;

    @JvmField
    @NotNull
    public final Protocol protocol;

    /* JADX INFO: compiled from: StatusLine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/http/StatusLine$Companion;", "", "Lokhttp3/Response;", "response", "Lokhttp3/internal/http/StatusLine;", "get", "(Lokhttp3/Response;)Lokhttp3/internal/http/StatusLine;", "", "statusLine", "parse", "(Ljava/lang/String;)Lokhttp3/internal/http/StatusLine;", "", "HTTP_CONTINUE", OptRuntime.GeneratorState.resumptionPoint_TYPE, "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final StatusLine get(@NotNull Response response) {
            j.e(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        @NotNull
        public final StatusLine parse(@NotNull String statusLine) throws ProtocolException {
            Protocol protocol;
            String strSubstring;
            j.e(statusLine, "statusLine");
            int i2 = 9;
            if (k.K(statusLine, "HTTP/1.", false, 2)) {
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException(a.i("Unexpected status line: ", statusLine));
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException(a.i("Unexpected status line: ", statusLine));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!k.K(statusLine, "ICY ", false, 2)) {
                    throw new ProtocolException(a.i("Unexpected status line: ", statusLine));
                }
                protocol = Protocol.HTTP_1_0;
                i2 = 4;
            }
            int i3 = i2 + 3;
            if (statusLine.length() < i3) {
                throw new ProtocolException(a.i("Unexpected status line: ", statusLine));
            }
            try {
                String strSubstring2 = statusLine.substring(i2, i3);
                j.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int i4 = Integer.parseInt(strSubstring2);
                if (statusLine.length() <= i3) {
                    strSubstring = "";
                } else {
                    if (statusLine.charAt(i3) != ' ') {
                        throw new ProtocolException(a.i("Unexpected status line: ", statusLine));
                    }
                    strSubstring = statusLine.substring(i2 + 4);
                    j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                }
                return new StatusLine(protocol, i4, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(a.i("Unexpected status line: ", statusLine));
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public StatusLine(@NotNull Protocol protocol, int i2, @NotNull String str) {
        j.e(protocol, "protocol");
        j.e(str, "message");
        this.protocol = protocol;
        this.code = i2;
        this.message = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        String string = sb.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
