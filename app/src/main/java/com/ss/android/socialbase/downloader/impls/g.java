package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jsoup.helper.HttpConnection;

/* JADX INFO: compiled from: DefaultDownloadHttpService.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements IDownloadHttpService {
    private final com.ss.android.socialbase.downloader.i.h<String, OkHttpClient> a = new com.ss.android.socialbase.downloader.i.h<>(4, 8);

    private OkHttpClient a(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.a) {
                    OkHttpClient okHttpClient = this.a.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder builderT = com.ss.android.socialbase.downloader.downloader.c.t();
                    builderT.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.g.2
                    });
                    OkHttpClient okHttpClientBuild = builderT.build();
                    synchronized (this.a) {
                        this.a.put(str3, okHttpClientBuild);
                    }
                    return okHttpClientBuild;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return com.ss.android.socialbase.downloader.downloader.c.s();
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public com.ss.android.socialbase.downloader.network.i downloadWithConnection(int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        String strB;
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            strB = null;
        } else {
            strB = null;
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                String strA = cVar.a();
                if (strB == null && "ss_d_request_host_ip_114".equals(strA)) {
                    strB = cVar.b();
                } else {
                    builderUrl.addHeader(strA, com.ss.android.socialbase.downloader.i.f.g(cVar.b()));
                }
            }
        }
        OkHttpClient okHttpClientA = !TextUtils.isEmpty(strB) ? a(str, strB) : com.ss.android.socialbase.downloader.downloader.c.s();
        if (okHttpClientA == null) {
            throw new IOException("can't get httpClient");
        }
        final Call callNewCall = okHttpClientA.newCall(builderUrl.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            return null;
        }
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        String strHeader = responseExecute.header(HttpConnection.CONTENT_ENCODING);
        final InputStream gZIPInputStream = (strHeader == null || !Constants.CP_GZIP.equalsIgnoreCase(strHeader) || (inputStreamByteStream instanceof GZIPInputStream)) ? inputStreamByteStream : new GZIPInputStream(inputStreamByteStream);
        return new com.ss.android.socialbase.downloader.network.e() { // from class: com.ss.android.socialbase.downloader.impls.g.1
            @Override // com.ss.android.socialbase.downloader.network.i
            public InputStream a() {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.network.g
            public int b() {
                return responseExecute.code();
            }

            @Override // com.ss.android.socialbase.downloader.network.g
            public void c() {
                Call call = callNewCall;
                if (call == null || call.getCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.network.i
            public void d() {
                try {
                    ResponseBody responseBody = responseBodyBody;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = callNewCall;
                    if (call == null || call.getCanceled()) {
                        return;
                    }
                    callNewCall.cancel();
                } catch (Throwable unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.network.a
            public String e() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.network.g
            public String a(String str2) {
                return responseExecute.header(str2);
            }
        };
    }
}
