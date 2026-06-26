package okhttp3.internal.connection;

import c.a.a.a.a;
import f.c0.c.j;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import okhttp3.ConnectionSpec;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ConnectionSpecSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "Ljavax/net/ssl/SSLSocket;", "socket", "", "isFallbackPossible", "(Ljavax/net/ssl/SSLSocket;)Z", "sslSocket", "Lokhttp3/ConnectionSpec;", "configureSecureSocket", "(Ljavax/net/ssl/SSLSocket;)Lokhttp3/ConnectionSpec;", "Ljava/io/IOException;", "e", "connectionFailed", "(Ljava/io/IOException;)Z", "isFallback", "Z", "", "connectionSpecs", "Ljava/util/List;", "", "nextModeIndex", OptRuntime.GeneratorState.resumptionPoint_TYPE, "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(@NotNull List<ConnectionSpec> list) {
        j.e(list, "connectionSpecs");
        this.connectionSpecs = list;
    }

    private final boolean isFallbackPossible(SSLSocket socket) {
        int size = this.connectionSpecs.size();
        for (int i2 = this.nextModeIndex; i2 < size; i2++) {
            if (this.connectionSpecs.get(i2).isCompatible(socket)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final ConnectionSpec configureSecureSocket(@NotNull SSLSocket sslSocket) throws UnknownServiceException, CloneNotSupportedException {
        ConnectionSpec connectionSpec;
        j.e(sslSocket, "sslSocket");
        int i2 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i2 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.connectionSpecs.get(i2);
            if (connectionSpec.isCompatible(sslSocket)) {
                this.nextModeIndex = i2 + 1;
                break;
            }
            i2++;
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sslSocket);
            connectionSpec.apply$okhttp(sslSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder sbR = a.r("Unable to find acceptable protocols. isFallback=");
        sbR.append(this.isFallback);
        sbR.append(',');
        sbR.append(" modes=");
        sbR.append(this.connectionSpecs);
        sbR.append(',');
        sbR.append(" supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        j.c(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        j.d(string, "java.util.Arrays.toString(this)");
        sbR.append(string);
        throw new UnknownServiceException(sbR.toString());
    }

    public final boolean connectionFailed(@NotNull IOException e2) {
        j.e(e2, "e");
        this.isFallback = true;
        return (!this.isFallbackPossible || (e2 instanceof ProtocolException) || (e2 instanceof InterruptedIOException) || ((e2 instanceof SSLHandshakeException) && (e2.getCause() instanceof CertificateException)) || (e2 instanceof SSLPeerUnverifiedException) || !(e2 instanceof SSLException)) ? false : true;
    }
}
