package okhttp3.internal.http;

import com.ifmvo.togetherad.gdt.other.NetworkRequestAsyncTask;
import f.c0.c.j;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "", "method", "", "requiresRequestBody", "(Ljava/lang/String;)Z", "permitsRequestBody", "invalidatesCache", "redirectsWithBody", "redirectsToGet", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    @JvmStatic
    public static final boolean permitsRequestBody(@NotNull String method) {
        j.e(method, "method");
        return (j.a(method, NetworkRequestAsyncTask.REQUEST_METHOD) || j.a(method, "HEAD")) ? false : true;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(@NotNull String method) {
        j.e(method, "method");
        return j.a(method, "POST") || j.a(method, "PUT") || j.a(method, "PATCH") || j.a(method, "PROPPATCH") || j.a(method, "REPORT");
    }

    public final boolean invalidatesCache(@NotNull String method) {
        j.e(method, "method");
        return j.a(method, "POST") || j.a(method, "PATCH") || j.a(method, "PUT") || j.a(method, "DELETE") || j.a(method, "MOVE");
    }

    public final boolean redirectsToGet(@NotNull String method) {
        j.e(method, "method");
        return !j.a(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(@NotNull String method) {
        j.e(method, "method");
        return j.a(method, "PROPFIND");
    }
}
