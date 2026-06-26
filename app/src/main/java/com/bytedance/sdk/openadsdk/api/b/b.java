package com.bytedance.sdk.openadsdk.api.b;

import android.text.TextUtils;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: compiled from: AESUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = a();
        String strA2 = a(strA, 32);
        String strB = b();
        String strA3 = null;
        if (strA2 != null && strB != null) {
            strA3 = a.a(str, strB, strA2);
        }
        return 3 + strA + strB + strA3;
    }

    public static String b() {
        String strA = a(8);
        if (strA == null || strA.length() != 16) {
            return null;
        }
        return strA;
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strA = a(jSONObject.toString());
                if (!TextUtils.isEmpty(strA)) {
                    jSONObject2.put("message", strA);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static String a() {
        String strA = a(16);
        if (strA == null || strA.length() != 32) {
            return null;
        }
        return strA;
    }

    public static String a(String str, int i2) {
        if (str == null || str.length() != i2) {
            return null;
        }
        int i3 = i2 / 2;
        return str.substring(i3, i2) + str.substring(0, i3);
    }

    public static String a(int i2) {
        try {
            byte[] bArr = new byte[i2];
            new SecureRandom().nextBytes(bArr);
            return c.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
