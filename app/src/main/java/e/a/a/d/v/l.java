package e.a.a.d.v;

import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StrResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    @NotNull
    public Response a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public String f5588b;

    public l(@NotNull Response response, @Nullable String str) {
        f.c0.c.j.e(response, "rawResponse");
        this.a = response;
        this.f5588b = str;
    }

    @NotNull
    public final String a() {
        Response responseNetworkResponse = this.a.networkResponse();
        return responseNetworkResponse == null ? this.a.request().url().getUrl() : responseNetworkResponse.request().url().getUrl();
    }

    @NotNull
    public String toString() {
        return this.a.toString();
    }

    public l(@NotNull String str, @Nullable String str2) {
        f.c0.c.j.e(str, "url");
        this.a = new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url(str).build()).build();
        this.f5588b = str2;
    }
}
