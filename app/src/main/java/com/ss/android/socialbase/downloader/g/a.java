package com.ss.android.socialbase.downloader.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.i.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadSetting.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final h<Integer, a> a = new h<>(16, 16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f3676b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static JSONObject f3677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static JSONObject f3678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Boolean f3679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f3680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static a f3681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f3682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f3683i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Boolean f3684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3685k;

    static {
        a();
    }

    private a(JSONObject jSONObject) {
        Boolean bool;
        this.f3682h = jSONObject;
        JSONObject jSONObject2 = null;
        boolValueOf = null;
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (jSONObject == null || f("bugfix")) {
            bool = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("default") && !f("default")) {
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool2 = boolValueOf;
            jSONObject2 = jSONObjectOptJSONObject;
            bool = bool2;
        }
        this.f3683i = jSONObject2;
        this.f3684j = bool;
    }

    public static void a() {
        JSONObject jSONObjectE = c.E();
        f3680f = jSONObjectE.optInt("disable_task_setting", 0) == 1;
        f3677c = jSONObjectE.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectE.optJSONObject("bugfix");
        Boolean boolValueOf = null;
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("default")) {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
        }
        f3678d = jSONObjectOptJSONObject;
        f3679e = boolValueOf;
    }

    @NonNull
    public static JSONObject b() {
        return c.E();
    }

    @NonNull
    public static a c() {
        return f3676b;
    }

    public static boolean f(String str) {
        JSONObject jSONObject = f3677c;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f3682h;
        return (jSONObject == null || !jSONObject.has(str) || f(str)) ? b().optJSONObject(str) : this.f3682h.optJSONObject(str);
    }

    public JSONArray e(String str) {
        JSONObject jSONObject = this.f3682h;
        return (jSONObject == null || !jSONObject.has(str) || f(str)) ? b().optJSONArray(str) : this.f3682h.optJSONArray(str);
    }

    public boolean b(String str, boolean z) {
        if (this.f3683i != null && !f(str)) {
            if (this.f3683i.has(str)) {
                return this.f3683i.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f3684j;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f3678d;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f3678d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f3679e;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String c(String str) {
        return a(str, "");
    }

    private static a c(int i2) {
        DownloadInfo downloadInfo;
        if (f3680f) {
            return f3676b;
        }
        Context contextN = c.N();
        if (contextN != null && (downloadInfo = Downloader.getInstance(contextN).getDownloadInfo(i2)) != null) {
            return b(downloadInfo);
        }
        return f3676b;
    }

    public static void a(String str, boolean z) {
        try {
            if (f3678d == null) {
                f3678d = new JSONObject();
            }
            f3678d.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static a a(int i2) {
        return a(i2, (DownloadInfo) null);
    }

    public int b(String str) {
        return a(str, 0);
    }

    @NonNull
    public static a a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f3676b;
        }
        return a(downloadInfo.getId(), downloadInfo);
    }

    public static void b(int i2) {
        a aVar = f3681g;
        if (aVar != null && aVar.f3685k == i2) {
            f3681g = null;
        }
        h<Integer, a> hVar = a;
        synchronized (hVar) {
            hVar.remove(Integer.valueOf(i2));
        }
    }

    private static a a(int i2, DownloadInfo downloadInfo) {
        a aVarC;
        a aVar = f3681g;
        if (aVar != null && aVar.f3685k == i2) {
            return aVar;
        }
        h<Integer, a> hVar = a;
        synchronized (hVar) {
            aVarC = hVar.get(Integer.valueOf(i2));
        }
        if (aVarC == null) {
            aVarC = downloadInfo == null ? c(i2) : b(downloadInfo);
            synchronized (hVar) {
                hVar.put(Integer.valueOf(i2), aVarC);
            }
        }
        aVarC.f3685k = i2;
        f3681g = aVarC;
        return aVarC;
    }

    private static a b(DownloadInfo downloadInfo) {
        if (f3680f) {
            return f3676b;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new a(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f3676b;
    }

    public boolean a(String str) {
        return b(str, false);
    }

    public int a(String str, int i2) {
        JSONObject jSONObject = this.f3682h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f3682h.optInt(str, i2);
        }
        return b().optInt(str, i2);
    }

    public long a(String str, long j2) {
        JSONObject jSONObject = this.f3682h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f3682h.optLong(str, j2);
        }
        return b().optLong(str, j2);
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f3682h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f3682h.optDouble(str, d2);
        }
        return b().optDouble(str, d2);
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = this.f3682h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f3682h.optString(str, str2);
        }
        return b().optString(str, str2);
    }

    @NonNull
    public static a a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f3680f) {
            a aVar = f3681g;
            if (aVar != null && aVar.f3682h == jSONObject) {
                return aVar;
            }
            h<Integer, a> hVar = a;
            synchronized (hVar) {
                for (a aVar2 : hVar.values()) {
                    if (aVar2.f3682h == jSONObject) {
                        f3681g = aVar2;
                        return aVar2;
                    }
                }
                a aVar3 = new a(jSONObject);
                f3681g = aVar3;
                return aVar3;
            }
        }
        return f3676b;
    }

    public static void a(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f3680f) {
            return;
        }
        h<Integer, a> hVar = a;
        synchronized (hVar) {
            a aVar = f3681g;
            if (aVar != null && aVar.f3682h == jSONObject) {
                aVar.f3685k = i2;
            } else {
                aVar = null;
                Iterator<a> it = hVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f3682h == jSONObject) {
                        next.f3685k = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.f3685k = i2;
                }
                f3681g = aVar;
            }
            a.put(Integer.valueOf(i2), aVar);
        }
    }
}
