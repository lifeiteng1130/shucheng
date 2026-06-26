package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: DefaultDownloadHeadHttpService.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.ss.android.socialbase.downloader.network.h {
    @Override // com.ss.android.socialbase.downloader.network.h
    public com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        OkHttpClient okHttpClientS = com.ss.android.socialbase.downloader.downloader.c.s();
        if (okHttpClientS == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder builderHead = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                builderHead.addHeader(cVar.a(), com.ss.android.socialbase.downloader.i.f.g(cVar.b()));
            }
        }
        final Call callNewCall = okHttpClientS.newCall(builderHead.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        if (com.ss.android.socialbase.downloader.i.a.a(2097152)) {
            responseExecute.close();
        }
        return new com.ss.android.socialbase.downloader.network.g() { // from class: com.ss.android.socialbase.downloader.impls.f.1
            @Override // com.ss.android.socialbase.downloader.network.g
            public String a(String str2) {
                return responseExecute.header(str2);
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
        };
    }
}
