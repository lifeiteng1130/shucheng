package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ZIDManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ZIDManager f5443c;
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5444b = false;

    public class a implements Runnable {
        public final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IZIDCompletionCallback f5445b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.a = context;
            this.f5445b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = ZIDManager.a(ZIDManager.this, this.a);
            if (TextUtils.isEmpty(strA)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f5445b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f5445b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(strA);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.b(ZIDManager.this, this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.a);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.b(ZIDManager.this, this.a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String strOptString = null;
        if (!zIDManager.a) {
            zIDManager.a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put("zdata", id);
                String strC = com.umeng.umzid.c.c(context);
                jSONObject.put("mac", strC);
                String strD = com.umeng.umzid.c.d(context);
                jSONObject.put("oaid", strD);
                zIDManager.a(context, jSONObject);
                String strA = com.umeng.umzid.a.a("https://aaid.umeng.com/api/postZdata", jSONObject.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject2 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        com.umeng.umzid.c.f(context, id);
                        com.umeng.umzid.c.a(context, strC);
                        com.umeng.umzid.c.b(context, strD);
                        strOptString = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            com.umeng.umzid.c.e(context, strOptString);
                        }
                        String string = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string)) {
                            com.umeng.umzid.c.d(context, string);
                        }
                        String string2 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string2)) {
                            com.umeng.umzid.c.c(context, string2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.a = false;
        }
        return strOptString;
    }

    public static /* synthetic */ String b(ZIDManager zIDManager, Context context) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences sharedPreferencesA2;
        SharedPreferences sharedPreferencesA3;
        SharedPreferences sharedPreferencesA4;
        String strOptString = null;
        if (!zIDManager.f5444b) {
            zIDManager.f5444b = true;
            JSONObject jSONObject = new JSONObject();
            try {
                Object objB = com.umeng.umzid.c.b(context);
                String id = Spy.getID();
                jSONObject.put("zdata", id);
                jSONObject.put("old_zdata", objB);
                String string = "";
                Object string2 = (context == null || (sharedPreferencesA4 = com.umeng.umzid.a.a(context)) == null) ? "" : sharedPreferencesA4.getString("oaid", "");
                String strD = com.umeng.umzid.c.d(context);
                jSONObject.put("old_oaid", string2);
                jSONObject.put("oaid", strD);
                Object string3 = (context == null || (sharedPreferencesA3 = com.umeng.umzid.a.a(context)) == null) ? "" : sharedPreferencesA3.getString("mac", "");
                String strC = com.umeng.umzid.c.c(context);
                jSONObject.put("mac", strC);
                jSONObject.put("old_mac", string3);
                zIDManager.a(context, jSONObject);
                jSONObject.put("aaid", com.umeng.umzid.c.a(context));
                jSONObject.put("uabc", (context == null || (sharedPreferencesA2 = com.umeng.umzid.a.a(context)) == null) ? "" : sharedPreferencesA2.getString("uabc", ""));
                if (context != null && (sharedPreferencesA = com.umeng.umzid.a.a(context)) != null) {
                    string = sharedPreferencesA.getString("resetToken", "");
                }
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("resetToken", string);
                }
                String strA = com.umeng.umzid.a.a("https://aaid.umeng.com/api/updateZdata", jSONObject.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject2 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        com.umeng.umzid.c.f(context, id);
                        com.umeng.umzid.c.a(context, strC);
                        com.umeng.umzid.c.b(context, strD);
                        strOptString = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            com.umeng.umzid.c.e(context, strOptString);
                        }
                        String string4 = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string4)) {
                            com.umeng.umzid.c.d(context, string4);
                        }
                        String string5 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string5)) {
                            com.umeng.umzid.c.c(context, string5);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.f5444b = false;
        }
        return strOptString;
    }

    public static synchronized ZIDManager getInstance() {
        if (f5443c == null) {
            f5443c = new ZIDManager();
        }
        return f5443c;
    }

    public static String getSDKVersion() {
        return "1.2.2";
    }

    public synchronized String getZID(Context context) {
        SharedPreferences sharedPreferencesA;
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String strA = com.umeng.umzid.c.a(applicationContext);
        if (TextUtils.isEmpty(strA)) {
            com.umeng.umzid.b.a(new c(applicationContext));
            return "";
        }
        if (!((applicationContext == null || (sharedPreferencesA = com.umeng.umzid.a.a(applicationContext)) == null) ? "" : sharedPreferencesA.getString("zdata", null)).equals(Spy.getID())) {
            com.umeng.umzid.b.a(new d(applicationContext));
        }
        return strA;
    }

    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        if (context == null) {
            if (iZIDCompletionCallback != null) {
                iZIDCompletionCallback.onFailure("1001", "传入参数Context为null");
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iZIDCompletionCallback != null) {
                iZIDCompletionCallback.onFailure("1003", "传入参数appkey为空");
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null && str != null && !TextUtils.isEmpty(str) && (sharedPreferencesA = com.umeng.umzid.a.a(applicationContext)) != null && (editorEdit = sharedPreferencesA.edit()) != null) {
            editorEdit.putString("appkey", str).commit();
        }
        String strA = com.umeng.umzid.c.a(applicationContext);
        if (strA == null || TextUtils.isEmpty(strA)) {
            com.umeng.umzid.b.a(new a(applicationContext, iZIDCompletionCallback));
        } else {
            com.umeng.umzid.b.a(new b(applicationContext));
            if (iZIDCompletionCallback != null) {
                iZIDCompletionCallback.onSuccess(strA);
            }
        }
        SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
        if (TextUtils.isEmpty(sharedPreferencesA2 != null ? sharedPreferencesA2.getString("uuid", "") : "")) {
            String string = "";
            SharedPreferences sharedPreferencesA3 = com.umeng.umzid.a.a(context);
            try {
                string = UUID.randomUUID().toString();
            } catch (Throwable unused) {
            }
            if (sharedPreferencesA3 != null) {
                sharedPreferencesA3.edit().putString("uuid", string).commit();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject a(android.content.Context r9, org.json.JSONObject r10) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }
}
