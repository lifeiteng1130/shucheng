package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.media2.session.SessionCommand;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.jsoup.helper.HttpConnection;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.umzid.a$a, reason: collision with other inner class name */
    public static class C0140a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return "aaid.umeng.com".equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str);
        }
    }

    public static SharedPreferences a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("umzid_general_config", 0);
        }
        return null;
    }

    public static synchronized String a(String str, String str2) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setHostnameVerifier(new C0140a());
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setRequestProperty(HttpConnection.CONTENT_TYPE, "application/json");
            httpsURLConnection.setConnectTimeout(SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME);
            httpsURLConnection.setReadTimeout(SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(str2.getBytes());
            outputStream.flush();
            outputStream.close();
            if (httpsURLConnection.getResponseCode() == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnection.getInputStream());
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int i2 = inputStreamReader.read();
                    if (i2 == -1) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char) i2);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
