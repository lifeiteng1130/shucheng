package com.efs.sdk.base.a.c.a;

import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);

    public static boolean a(@NonNull String str, @NonNull b bVar) {
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
            int i2 = jSONObject.getInt("cver");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("common");
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObjectOptJSONObject2.optString(next, ""));
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("app_configs");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i3);
                        if (jSONObject2 != null && jSONObject2.length() == 2) {
                            JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("conditions");
                            JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("actions");
                            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                                a(map, jSONArrayOptJSONArray2, jSONArrayOptJSONArray3);
                            }
                        }
                    }
                }
            }
            bVar.a(map);
            bVar.a = i2;
            return true;
        } catch (Throwable th) {
            com.efs.sdk.base.a.h.d.b("efs.config", "parseConfig error, data is ".concat(String.valueOf(str)), th);
            return false;
        }
    }

    private static int b(String str, String str2) {
        if (str == null) {
            str = "1970/01/01 00:00:00";
        }
        if (str2 == null) {
            str2 = "1970/01/01 00:00:00";
        }
        String[] strArrSplit = str.split("[:/\\s]");
        String[] strArrSplit2 = str2.split("[:/\\s]");
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i2 = 0;
        while (i2 < iMax) {
            int i3 = i2 < strArrSplit.length ? Integer.parseInt(strArrSplit[i2]) : 0;
            int i4 = i2 < strArrSplit2.length ? Integer.parseInt(strArrSplit2[i2]) : 0;
            if (i3 < i4) {
                return -1;
            }
            if (i3 > i4) {
                return 1;
            }
            i2++;
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01dd A[Catch: all -> 0x0242, LOOP:1: B:139:0x01dd->B:155:0x023e, LOOP_START, PHI: r1
  0x01dd: PHI (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:137:0x01da, B:155:0x023e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0242, blocks: (B:3:0x0004, B:5:0x000c, B:7:0x0014, B:10:0x001d, B:15:0x0036, B:17:0x0048, B:31:0x008b, B:136:0x01d6, B:34:0x0094, B:35:0x0099, B:83:0x0141, B:85:0x0146, B:86:0x014c, B:87:0x0152, B:88:0x0158, B:89:0x015e, B:90:0x0164, B:91:0x016a, B:92:0x0170, B:94:0x0176, B:100:0x0184, B:102:0x018a, B:107:0x0194, B:109:0x019a, B:114:0x01a4, B:116:0x01aa, B:121:0x01b4, B:123:0x01ba, B:128:0x01c4, B:130:0x01ca, B:37:0x009e, B:40:0x00aa, B:43:0x00b6, B:46:0x00c2, B:49:0x00ce, B:52:0x00d9, B:55:0x00e3, B:58:0x00ed, B:61:0x00f7, B:64:0x0101, B:67:0x010b, B:70:0x0115, B:73:0x011f, B:76:0x012a, B:79:0x0135, B:18:0x004d, B:20:0x0055, B:21:0x0068, B:23:0x0070, B:24:0x0075, B:26:0x007b, B:28:0x0081, B:139:0x01dd, B:141:0x01e3, B:143:0x01eb, B:145:0x01f1, B:148:0x0201, B:151:0x0211, B:153:0x0225, B:154:0x0237), top: B:160:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.util.Map<java.lang.String, java.lang.String> r13, org.json.JSONArray r14, org.json.JSONArray r15) {
        /*
            Method dump skipped, instruction units count: 684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.a.c.a.d.a(java.util.Map, org.json.JSONArray, org.json.JSONArray):void");
    }

    private static int a(String str, String str2, String str3) {
        if ("ver".equals(str)) {
            return a(str2, str3);
        }
        if ("datetime".equals(str)) {
            return b(str2, str3);
        }
        return -100;
    }

    private static int a(String str, String str2) {
        if (str == null) {
            str = "0";
        }
        if (str2 == null) {
            str2 = "0";
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i2 = 0;
        while (i2 < iMax) {
            int i3 = i2 < strArrSplit.length ? Integer.parseInt(strArrSplit[i2]) : 0;
            int i4 = i2 < strArrSplit2.length ? Integer.parseInt(strArrSplit2[i2]) : 0;
            if (i3 < i4) {
                return -1;
            }
            if (i3 > i4) {
                return 1;
            }
            i2++;
        }
        return 0;
    }
}
