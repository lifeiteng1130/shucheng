package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import c.a.a.a.a;
import d.a.a.b;
import f.c0.c.j;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u001a\u001a\u00020#\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b2\u00103JM\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0011J\u001f\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\u001cR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u001c\u0010\u001a\u001a\u00020#8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b'\u0010\u0011R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010\b\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b,\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/R\u001c\u0010\n\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b0\u0010\u0011R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010\"¨\u00064"}, d2 = {"Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/Interceptor$Chain;", "", "index", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/Request;", "request", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "copy$okhttp", "(ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)Lokhttp3/internal/http/RealInterceptorChain;", "copy", "Lokhttp3/Connection;", b.HEADER_CONNECTION, "()Lokhttp3/Connection;", "()I", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "withConnectTimeout", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/Interceptor$Chain;", "withReadTimeout", "withWriteTimeout", "Lokhttp3/Call;", NotificationCompat.CATEGORY_CALL, "()Lokhttp3/Call;", "()Lokhttp3/Request;", "Lokhttp3/Response;", "proceed", "(Lokhttp3/Request;)Lokhttp3/Response;", "Lokhttp3/Request;", "getRequest$okhttp", OptRuntime.GeneratorState.resumptionPoint_TYPE, "Lokhttp3/internal/connection/RealCall;", "Lokhttp3/internal/connection/RealCall;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "getReadTimeoutMillis$okhttp", "", "Lokhttp3/Interceptor;", "interceptors", "Ljava/util/List;", "getConnectTimeoutMillis$okhttp", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getWriteTimeoutMillis$okhttp", "calls", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealInterceptorChain implements Interceptor.Chain {

    @NotNull
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;

    @Nullable
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;

    @NotNull
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(@NotNull RealCall realCall, @NotNull List<? extends Interceptor> list, int i2, @Nullable Exchange exchange, @NotNull Request request, int i3, int i4, int i5) {
        j.e(realCall, NotificationCompat.CATEGORY_CALL);
        j.e(list, "interceptors");
        j.e(request, "request");
        this.call = realCall;
        this.interceptors = list;
        this.index = i2;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i3;
        this.readTimeoutMillis = i4;
        this.writeTimeoutMillis = i5;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i2, Exchange exchange, Request request, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = realInterceptorChain.index;
        }
        if ((i6 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        Exchange exchange2 = exchange;
        if ((i6 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        Request request2 = request;
        if ((i6 & 8) != 0) {
            i3 = realInterceptorChain.connectTimeoutMillis;
        }
        int i7 = i3;
        if ((i6 & 16) != 0) {
            i4 = realInterceptorChain.readTimeoutMillis;
        }
        int i8 = i4;
        if ((i6 & 32) != 0) {
            i5 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i2, exchange2, request2, i7, i8, i5);
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    /* JADX INFO: renamed from: connectTimeoutMillis, reason: from getter */
    public int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    @Nullable
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.getConnection();
        }
        return null;
    }

    @NotNull
    public final RealInterceptorChain copy$okhttp(int index, @Nullable Exchange exchange, @NotNull Request request, int connectTimeoutMillis, int readTimeoutMillis, int writeTimeoutMillis) {
        j.e(request, "request");
        return new RealInterceptorChain(this.call, this.interceptors, index, exchange, request, connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis);
    }

    @NotNull
    /* JADX INFO: renamed from: getCall$okhttp, reason: from getter */
    public final RealCall getCall() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    @Nullable
    /* JADX INFO: renamed from: getExchange$okhttp, reason: from getter */
    public final Exchange getExchange() {
        return this.exchange;
    }

    /* JADX INFO: renamed from: getReadTimeoutMillis$okhttp, reason: from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @NotNull
    /* JADX INFO: renamed from: getRequest$okhttp, reason: from getter */
    public final Request getRequest() {
        return this.request;
    }

    /* JADX INFO: renamed from: getWriteTimeoutMillis$okhttp, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Response proceed(@NotNull Request request) {
        j.e(request, "request");
        if (!(this.index < this.interceptors.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.calls++;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            if (!exchange.getFinder().sameHostAndPort(request.url())) {
                StringBuilder sbR = a.r("network interceptor ");
                sbR.append(this.interceptors.get(this.index - 1));
                sbR.append(" must retain the same host and port");
                throw new IllegalStateException(sbR.toString().toString());
            }
            if (!(this.calls == 1)) {
                StringBuilder sbR2 = a.r("network interceptor ");
                sbR2.append(this.interceptors.get(this.index - 1));
                sbR2.append(" must call proceed() exactly once");
                throw new IllegalStateException(sbR2.toString().toString());
            }
        }
        RealInterceptorChain realInterceptorChainCopy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response responseIntercept = interceptor.intercept(realInterceptorChainCopy$okhttp$default);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.exchange != null) {
            if (!(this.index + 1 >= this.interceptors.size() || realInterceptorChainCopy$okhttp$default.calls == 1)) {
                throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
            }
        }
        if (responseIntercept.body() != null) {
            return responseIntercept;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withConnectTimeout(int timeout, @NotNull TimeUnit unit) {
        j.e(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", timeout, unit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withReadTimeout(int timeout, @NotNull TimeUnit unit) {
        j.e(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", timeout, unit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withWriteTimeout(int timeout, @NotNull TimeUnit unit) {
        j.e(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", timeout, unit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
