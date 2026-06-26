package com.efs.sdk.base.a.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.i.f;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.HttpConnection;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.efs.sdk.base.a.e.c {
    private static void a(HttpResponse httpResponse) {
        if (httpResponse == null || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        for (String str : httpResponse.data.split("`")) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit.length >= 2) {
                if (strArrSplit[0].equalsIgnoreCase("retcode")) {
                    httpResponse.setBizCode(strArrSplit[1]);
                } else {
                    ((Map) httpResponse.extra).put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }

    @Override // com.efs.sdk.base.a.e.c
    @NonNull
    public final HttpResponse a(com.efs.sdk.base.a.f.b bVar, boolean z) {
        HttpResponse httpResponse;
        try {
            c cVar = f.a.a.a;
            String strValueOf = String.valueOf(System.currentTimeMillis());
            String strA = com.efs.sdk.base.a.h.c.b.a(cVar.f1850b + cVar.f1851c + strValueOf + "AppChk#2014");
            StringBuilder sb = new StringBuilder();
            String str = cVar.a;
            if (str.startsWith("http")) {
                sb.append(str);
                sb.append("?chk=");
            } else {
                sb.append(str);
                sb.append("?chk=");
            }
            sb.append(strA.substring(strA.length() - 8));
            sb.append("&vno=");
            sb.append(strValueOf);
            sb.append("&uuid=");
            sb.append(cVar.f1851c);
            sb.append("&app=");
            sb.append(cVar.f1850b);
            sb.append("&zip=gzip");
            String string = sb.toString();
            int length = 0;
            byte[] bArrA = new byte[0];
            int i2 = bVar.a.f1824c;
            if (i2 == 0) {
                bArrA = bVar.f1830c;
                length = bArrA.length;
            } else if (1 == i2) {
                bArrA = com.efs.sdk.base.a.h.b.a(bVar.f1831d.getPath());
                length = bArrA.length;
            }
            HashMap map = new HashMap();
            map.put(HttpConnection.CONTENT_TYPE, HttpConnection.FORM_URL_ENCODED);
            map.put("Content-Length", String.valueOf(length));
            com.efs.sdk.base.a.h.b.d dVarA = new com.efs.sdk.base.a.h.b.d(string).a(map);
            dVarA.a.f1839c = bArrA;
            httpResponse = dVarA.a().b();
            a(httpResponse);
        } catch (Throwable th) {
            httpResponse = 0 == 0 ? new HttpResponse() : null;
            com.efs.sdk.base.a.h.d.b("efs.wa.send", "get file size error", th);
        }
        if (httpResponse.succ) {
            com.efs.sdk.base.a.h.d.a("efs.base", "wa upload succ, " + httpResponse.toString());
            com.efs.sdk.base.a.h.b.b(bVar.f1831d);
            return httpResponse;
        }
        com.efs.sdk.base.a.h.d.a("efs.base", "wa upload fail, resp is " + httpResponse.toString());
        return httpResponse;
    }
}
