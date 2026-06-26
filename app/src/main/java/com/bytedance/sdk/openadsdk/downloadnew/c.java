package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.efs.sdk.base.Constants;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: TTDownloadLibUrlConnection4DZ.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: compiled from: TTDownloadLibUrlConnection4DZ.java */
    public static class a {
        public InputStream a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f1740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HttpURLConnection f1742d;

        public a(InputStream inputStream, Map<String, String> map, int i2, HttpURLConnection httpURLConnection) {
            this.a = inputStream;
            this.f1740b = map;
            this.f1741c = i2;
            this.f1742d = httpURLConnection;
        }
    }

    public static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception unused) {
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty(d.a.a.b.HEADER_CONNECTION, "Keep-Alive");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? a(httpURLConnection.getHeaderField(HttpUrlFetcher.REDIRECT_HEADER_FIELD), map) : httpURLConnection;
        } catch (Exception unused2) {
            httpURLConnection2 = httpURLConnection;
            return httpURLConnection2;
        }
    }

    public static Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i2 = 0; i2 < size; i2++) {
            map.put(httpURLConnection.getHeaderFieldKey(i2), httpURLConnection.getHeaderField(i2));
        }
        return map;
    }

    public static a a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                map.put(cVar.a(), cVar.b());
            }
        }
        HttpURLConnection httpURLConnectionA = a(str, map);
        if (httpURLConnectionA == null || (responseCode = httpURLConnectionA.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapA = a(httpURLConnectionA);
        InputStream inputStream = httpURLConnectionA.getInputStream();
        String contentEncoding = httpURLConnectionA.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains(Constants.CP_GZIP)) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new a(inputStream, mapA, responseCode, httpURLConnectionA);
    }
}
