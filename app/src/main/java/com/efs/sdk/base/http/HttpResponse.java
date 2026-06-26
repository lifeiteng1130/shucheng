package com.efs.sdk.base.http;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.a.a.a;
import com.efs.sdk.base.a.f.d;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponse extends d<Map<String, String>> {
    private static final String KEY_BIZ_CODE = "biz_code";
    private static final String KEY_REQUEST_URL = "req_url";
    public static final int REQUEST_ERROR_DEFAULT = -1;
    public static final int REQUEST_ERROR_NETWORK_DISCONNECT = -2;
    public static final int REQUEST_ERROR_SOCKET_TIMEOUT = -3;

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.HashMap] */
    public HttpResponse() {
        this.extra = new HashMap();
    }

    public String getBizCode() {
        return !((Map) this.extra).containsKey(KEY_BIZ_CODE) ? "" : (String) ((Map) this.extra).get(KEY_BIZ_CODE);
    }

    public int getHttpCode() {
        return this.code;
    }

    public String getReqUrl() {
        return !((Map) this.extra).containsKey(KEY_REQUEST_URL) ? "" : (String) ((Map) this.extra).get(KEY_REQUEST_URL);
    }

    public void setBizCode(@NonNull String str) {
        ((Map) this.extra).put(KEY_BIZ_CODE, str);
    }

    public void setHttpCode(int i2) {
        this.succ = (i2 >= 200 && i2 < 300) || i2 == 304;
        this.code = i2;
    }

    public void setReqUrl(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        ((Map) this.extra).put(KEY_REQUEST_URL, str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpResponse {succ=");
        sb.append(this.succ);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(", data='");
        a.y(sb, this.data, '\'', ", extra=");
        sb.append(this.extra);
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}
