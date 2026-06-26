package com.tencent.bugly.proguard;

import android.content.Context;
import androidx.media2.session.SessionCommand;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class O {
    private static O a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f4300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f4301c = null;

    private O(Context context) {
        this.f4300b = context;
    }

    public static O a(Context context) {
        if (a == null) {
            a = new O(context);
        }
        return a;
    }

    private Map<String, String> b(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() >= 1) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    public boolean a(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 307;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0157 A[Catch: all -> 0x014e, TRY_LEAVE, TryCatch #7 {all -> 0x014e, blocks: (B:22:0x0096, B:24:0x009e, B:28:0x00af, B:27:0x00ad, B:36:0x00c2, B:39:0x00ca, B:41:0x00d0, B:43:0x00d7, B:53:0x00fd, B:75:0x0151, B:77:0x0157, B:59:0x0118, B:61:0x011f, B:64:0x013c), top: B:109:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0166 A[PHI: r4 r8 r9 r10 r11
  0x0166: PHI (r4v3 java.lang.String) = (r4v4 java.lang.String), (r4v5 java.lang.String) binds: [B:82:0x0164, B:69:0x0149] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r8v11 int) = (r8v12 int), (r8v13 int) binds: [B:82:0x0164, B:69:0x0149] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r9v3 int) = (r9v4 int), (r9v5 int) binds: [B:82:0x0164, B:69:0x0149] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r10v12 java.lang.Throwable) = (r10v13 java.lang.Throwable), (r10v14 java.lang.Throwable) binds: [B:82:0x0164, B:69:0x0149] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r11v3 boolean) = (r11v4 boolean), (r11v5 boolean) binds: [B:82:0x0164, B:69:0x0149] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] a(java.lang.String r17, byte[] r18, com.tencent.bugly.proguard.U r19, java.util.Map<java.lang.String, java.lang.String> r20) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.O.a(java.lang.String, byte[], com.tencent.bugly.proguard.U, java.util.Map):byte[]");
    }

    public byte[] a(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = bufferedInputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!X.b(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    public HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            X.b("destUrl is null.", new Object[0]);
            return null;
        }
        a();
        HttpURLConnection httpURLConnectionA = a(str2, str);
        if (httpURLConnectionA == null) {
            X.b("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            httpURLConnectionA.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnectionA.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            httpURLConnectionA.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            httpURLConnectionA.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = httpURLConnectionA.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return httpURLConnectionA;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            X.b("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    public HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (Y.a() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(Y.a());
            } else if (str != null && str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (X.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static void a() {
        TrustManager[] trustManagerArr = {new N()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
