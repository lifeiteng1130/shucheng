package okio;

import c.a.a.a.a;
import f.c0.c.j;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "Ljava/io/IOException;", "cause", "newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lf/v;", "timedOut", "()V", "Ljava/net/Socket;", "socket", "Ljava/net/Socket;", "<init>", "(Ljava/net/Socket;)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(@NotNull Socket socket) {
        j.e(socket, "socket");
        this.socket = socket;
    }

    @Override // okio.AsyncTimeout
    @NotNull
    public IOException newTimeoutException(@Nullable IOException cause) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (cause != null) {
            socketTimeoutException.initCause(cause);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    public void timedOut() {
        try {
            this.socket.close();
        } catch (AssertionError e2) {
            if (!Okio.isAndroidGetsocknameError(e2)) {
                throw e2;
            }
            Logger logger = Okio__JvmOkioKt.logger;
            Level level = Level.WARNING;
            StringBuilder sbR = a.r("Failed to close timed out socket ");
            sbR.append(this.socket);
            logger.log(level, sbR.toString(), (Throwable) e2);
        } catch (Exception e3) {
            Logger logger2 = Okio__JvmOkioKt.logger;
            Level level2 = Level.WARNING;
            StringBuilder sbR2 = a.r("Failed to close timed out socket ");
            sbR2.append(this.socket);
            logger2.log(level2, sbR2.toString(), (Throwable) e3);
        }
    }
}
