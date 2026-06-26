package com.efs.sdk.base.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f1757b = -1;
    public boolean a;

    /* JADX INFO: renamed from: com.efs.sdk.base.a.a.a$a, reason: collision with other inner class name */
    public static class C0062a {
        private static final a a = new a(0);
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0062a.a;
    }

    public static long b() {
        return f1757b == -1 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + f1757b;
    }

    private a() {
        this.a = true;
    }

    @NonNull
    public final HttpResponse a(String str, c cVar, File file, boolean z) {
        String strB = cVar.b();
        String strA = a(str, cVar);
        if (this.a) {
            com.efs.sdk.base.a.h.d.a("efs.px.api", "Upload file, url is ".concat(String.valueOf(strA)));
        }
        HashMap map = new HashMap(1);
        map.put("wpk-header", strB);
        com.efs.sdk.base.a.h.b.d dVarA = new com.efs.sdk.base.a.h.b.d(strA).a(map);
        dVarA.a.f1840d = file;
        com.efs.sdk.base.a.h.b.d dVarA2 = dVarA.a("type", cVar.f1764h);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f1768l);
        return dVarA2.a("size", sb.toString()).a("flow_limit", Boolean.toString(z)).a(d.a()).a().b();
    }

    public static String a(@NonNull String str, @NonNull c cVar) {
        byte b2 = cVar.f1763g;
        String str2 = "/api/v1/raw/upload";
        if (b2 != 1) {
            if (b2 == 2) {
                str2 = "/perf_upload";
            } else if (b2 == 3) {
                str2 = "/api/v1/mix/upload";
            }
        }
        return c.a.a.a.a.i(str, str2);
    }

    public static void a(@Nullable HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(httpResponse.data);
            String strOptString = jSONObject.optString("code", "-1");
            httpResponse.setBizCode(strOptString);
            if (!"0".equals(strOptString)) {
                httpResponse.succ = false;
            }
            if (jSONObject.has("cver")) {
                ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
            }
            long j2 = jSONObject.getLong("stm") * 1000;
            if (Math.abs(j2 - b()) > 1500000) {
                f1757b = j2 - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th) {
            com.efs.sdk.base.a.h.d.b("efs.px.api", "checkPxReturn error", th);
        }
    }
}
