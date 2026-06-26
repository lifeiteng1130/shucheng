package e.a.a.d.v;

import e.a.a.d.v.i;
import f.c0.c.u;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.ConnectionSpec;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    @NotNull
    public static final f.e a = c.b.a.m.f.N3(b.INSTANCE);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f.e f5584b = c.b.a.m.f.N3(a.INSTANCE);

    /* JADX INFO: compiled from: HttpHelper.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<OkHttpClient> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final OkHttpClient invoke() {
            ArrayList arrayListA = f.x.e.a(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder timeout = builder.connectTimeout(15L, timeUnit).writeTimeout(15L, timeUnit).readTimeout(15L, timeUnit);
            k kVar = k.a;
            return timeout.sslSocketFactory(k.a(), k.f5585b).retryOnConnectionFailure(true).hostnameVerifier(k.f5587d).connectionSpecs(arrayListA).followRedirects(true).followSslRedirects(true).addInterceptor(new Interceptor() { // from class: e.a.a.d.v.b
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain chain) {
                    i.a aVar = i.a.INSTANCE;
                    f.c0.c.j.e(chain, "chain");
                    return chain.proceed(chain.request().newBuilder().addHeader("Keep-Alive", "300").addHeader("Connection", "Keep-Alive").addHeader("Cache-Control", "no-cache").build());
                }
            }).build();
        }
    }

    /* JADX INFO: compiled from: HttpHelper.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.a<ConcurrentHashMap<String, OkHttpClient>> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ConcurrentHashMap<String, OkHttpClient> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    @NotNull
    public static final OkHttpClient a() {
        return (OkHttpClient) f5584b.getValue();
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11, types: [T, java.lang.Object] */
    @NotNull
    public static final OkHttpClient b(@Nullable String str) {
        if (str == null || f.h0.k.s(str)) {
            return a();
        }
        f.e eVar = a;
        OkHttpClient okHttpClient = (OkHttpClient) ((ConcurrentHashMap) eVar.getValue()).get(str);
        if (okHttpClient != null) {
            return okHttpClient;
        }
        f.g0.e eVarFindAll$default = f.h0.g.findAll$default(new f.h0.g("(http|socks4|socks5)://(.*):(\\d{2,5})(@.*@.*)?"), str, 0, 2, null);
        f.c0.c.j.e(eVarFindAll$default, "$this$first");
        Iterator it = eVarFindAll$default.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        f.h0.e eVar2 = (f.h0.e) it.next();
        final u uVar = new u();
        uVar.element = "";
        final u uVar2 = new u();
        uVar2.element = "";
        String str2 = f.c0.c.j.a(eVar2.a().get(1), "http") ? "http" : "socks";
        String str3 = eVar2.a().get(2);
        int i2 = Integer.parseInt(eVar2.a().get(3));
        if (!f.c0.c.j.a(eVar2.a().get(4), "")) {
            uVar.element = f.h0.k.F(eVar2.a().get(4), new String[]{"@"}, false, 0, 6).get(1);
            uVar2.element = f.h0.k.F(eVar2.a().get(4), new String[]{"@"}, false, 0, 6).get(2);
        }
        if (f.c0.c.j.a(str2, "direct") || f.c0.c.j.a(str3, "")) {
            return a();
        }
        OkHttpClient.Builder builderNewBuilder = a().newBuilder();
        if (f.c0.c.j.a(str2, "http")) {
            builderNewBuilder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str3, i2)));
        } else {
            builderNewBuilder.proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(str3, i2)));
        }
        if (!f.c0.c.j.a(uVar.element, "") && !f.c0.c.j.a(uVar2.element, "")) {
            builderNewBuilder.proxyAuthenticator(new Authenticator() { // from class: e.a.a.d.v.c
                /* JADX WARN: Multi-variable type inference failed */
                @Override // okhttp3.Authenticator
                public final Request authenticate(Route route, Response response) {
                    u uVar3 = uVar;
                    u uVar4 = uVar2;
                    f.c0.c.j.e(uVar3, "$username");
                    f.c0.c.j.e(uVar4, "$password");
                    f.c0.c.j.e(response, "response");
                    Credentials credentials = Credentials.INSTANCE;
                    return response.request().newBuilder().header("Proxy-Authorization", Credentials.basic$default((String) uVar3.element, (String) uVar4.element, null, 4, null)).build();
                }
            });
        }
        OkHttpClient okHttpClientBuild = builderNewBuilder.build();
        ((ConcurrentHashMap) eVar.getValue()).put(str, okHttpClientBuild);
        return okHttpClientBuild;
    }
}
