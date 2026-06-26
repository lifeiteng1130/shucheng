package com.umeng.cconfig.c;

import android.text.TextUtils;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.jsoup.helper.HttpConnection;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static HostnameVerifier a;

    public static String a(String str, String str2) {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                HttpsURLConnection httpsURLConnectionB = b(str, str2);
                if (httpsURLConnectionB == null || httpsURLConnectionB.getResponseCode() != 200) {
                    return null;
                }
                InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnectionB.getInputStream());
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int i3 = inputStreamReader.read();
                    if (i3 == -1) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char) i3);
                }
            } catch (Exception unused) {
                if (i2 == 2) {
                    return null;
                }
                try {
                    Thread.sleep(20000L);
                } catch (InterruptedException unused2) {
                }
            }
        }
        return null;
    }

    private static HttpsURLConnection b(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            if (a == null) {
                a = new HostnameVerifier() { // from class: com.umeng.cconfig.c.a.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public final boolean verify(String str3, SSLSession sSLSession) {
                        if (TextUtils.isEmpty(str3)) {
                            return false;
                        }
                        return "ucc.umeng.com".equalsIgnoreCase(str3) || "pslog.umeng.com".equalsIgnoreCase(str3);
                    }
                };
            }
            httpsURLConnection.setHostnameVerifier(a);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(15000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setReadTimeout(15000);
            httpsURLConnection.setRequestProperty(HttpConnection.CONTENT_TYPE, "application/json");
            httpsURLConnection.connect();
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(str2.getBytes());
            outputStream.flush();
            outputStream.close();
            return httpsURLConnection;
        } catch (Exception e3) {
            e = e3;
            httpsURLConnection2 = httpsURLConnection;
            e.printStackTrace();
            return httpsURLConnection2;
        }
    }
}
