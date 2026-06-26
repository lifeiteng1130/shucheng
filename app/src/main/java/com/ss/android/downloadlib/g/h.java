package com.ss.android.downloadlib.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.umeng.analytics.pro.ai;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InnerOpenAppUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private static void b(final Context context, final com.ss.android.downloadlib.addownload.b.e eVar, final String str) {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.1
            @Override // java.lang.Runnable
            public void run() {
                final JSONObject jSONObjectI = com.ss.android.downloadlib.addownload.j.i();
                final String strOptString = jSONObjectI.optString(ai.az);
                final JSONObject jSONObject = new JSONObject();
                String strA = com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                l.a(jSONObject2, "p", str);
                l.a(jSONObject2, ai.aA, Build.VERSION.INCREMENTAL);
                l.a(jSONObject2, "m", Build.MODEL);
                l.a(jSONObject2, "im", com.ss.android.downloadlib.a.a.b.a(context));
                l.a(jSONObject2, "d", com.ss.android.downloadlib.a.a.b.b(context));
                l.a(jSONObject2, ai.aF, "m");
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.j.d().a(strA, com.ss.android.downloadlib.addownload.j.q().a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new q() { // from class: com.ss.android.downloadlib.g.h.1.1
                    @Override // com.ss.android.download.api.config.q
                    public void a(String str2) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        h.b(context, str, str2, eVar, jSONObject, jSONObjectI, strOptString);
                    }

                    @Override // com.ss.android.download.api.config.q
                    public void a(Throwable th) {
                        Context context2 = context;
                        StringBuilder sbR = c.a.a.a.a.r(BaseConstants.MARKET_PREFIX);
                        sbR.append(str);
                        com.ss.android.downloadlib.b.a.a(h.a(context2, Uri.parse(sbR.toString())), eVar, true);
                        l.a(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        h.b(eVar, jSONObject, 4, 1);
                    }
                });
            }
        });
    }

    private static com.ss.android.downloadlib.addownload.b.g c(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", eVar.a);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(7, "am_kllk2");
        } catch (Throwable unused) {
            b(eVar, jSONObject, 1, 3);
            return a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    private static com.ss.android.downloadlib.addownload.b.g d(@NonNull Context context, @NonNull String str) {
        try {
            Uri uri = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.b.g(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.b.g(6, 14);
        }
    }

    private static boolean e(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.j.getContext();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
            if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
                intent.addFlags(32768);
            }
        }
        intent.setData(Uri.parse(str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strI = com.ss.android.socialbase.appdownloader.f.d.i();
        if (l.d(com.ss.android.downloadlib.addownload.j.getContext(), strI)) {
            intent.setPackage(strI);
        }
        if (!l.a(com.ss.android.downloadlib.addownload.j.getContext(), intent)) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.b.e eVar, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, String str3) {
        l.a(jSONObject, "ttdownloader_type", (Object) 1);
        try {
            String strA = a(com.ss.android.socialbase.appdownloader.f.c.a(new JSONObject(str2).optString(ai.at)), jSONObject2, str3);
            l.a(jSONObject, "open_url", strA);
            if (e(context, strA)) {
                b(eVar, jSONObject, -1, 1);
                com.ss.android.downloadlib.b.a.a("am_m1", jSONObject, eVar, true);
            } else {
                com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
                b(eVar, jSONObject, 2, 1);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
            b(eVar, jSONObject, 3, 1);
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, Uri uri) {
        if (context != null && uri != null && BaseConstants.SCHEME_MARKET.equals(uri.getScheme())) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!l.a(context, intent)) {
                    return new com.ss.android.downloadlib.addownload.b.g(6, 13);
                }
                String strI = com.ss.android.socialbase.appdownloader.f.d.i();
                if (l.d(context, strI) && !com.ss.android.socialbase.appdownloader.f.d.f()) {
                    intent.setPackage(strI);
                }
                if (com.ss.android.socialbase.downloader.g.a.c().a("fix_jump_market")) {
                    intent.addFlags(335544320);
                } else if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.b.g(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.b.g(6, 14);
            }
        }
        return new com.ss.android.downloadlib.addownload.b.g(6, 12);
    }

    public static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static void d(final Context context, final com.ss.android.downloadlib.addownload.b.e eVar, final String str) {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.2
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                StringBuilder sbR = c.a.a.a.a.r(BaseConstants.MARKET_PREFIX);
                sbR.append(str);
                com.ss.android.downloadlib.b.a.a(h.a(context2, Uri.parse(sbR.toString())), eVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObjectI = com.ss.android.downloadlib.addownload.j.i();
                    Thread.sleep(jSONObjectI.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.a.b.a.a().a(context, true);
                    com.ss.android.downloadlib.a.b.b bVar = new com.ss.android.downloadlib.a.b.b();
                    bVar.a = 1;
                    bVar.f2984b = 0;
                    bVar.f2985c = String.format(com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString(ai.aC), jSONObjectI.optString(ai.az)), str);
                    com.ss.android.downloadlib.a.b.a.a().a(bVar, (com.ss.android.downloadlib.a.b.d) null);
                    com.ss.android.downloadlib.a.b.a.a().b();
                    h.b(eVar, jSONObject, -1, 2);
                } catch (Throwable th) {
                    th.printStackTrace();
                    h.b(eVar, jSONObject, 1, 2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.b.e eVar, @NonNull JSONObject jSONObject) {
        l.a(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String strA = com.ss.android.socialbase.appdownloader.f.c.a(new JSONObject(str2).optString(ai.at));
            if (!TextUtils.isEmpty(strA)) {
                TTDelegateActivity.a(str, eVar.a, strA, jSONObject);
            } else {
                com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
                b(eVar, jSONObject, 5, 5);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
            b(eVar, jSONObject, 6, 5);
        }
    }

    private static void e(final Context context, final com.ss.android.downloadlib.addownload.b.e eVar, final String str) {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.h.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectI = com.ss.android.downloadlib.addownload.j.i();
                String strOptString = jSONObjectI.optString(ai.az);
                final JSONObject jSONObject = new JSONObject();
                String strA = com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                l.a(jSONObject2, ai.aF, ai.aC);
                l.a(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.j.d().a(strA, com.ss.android.downloadlib.addownload.j.q().a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new q() { // from class: com.ss.android.downloadlib.g.h.3.1
                    @Override // com.ss.android.download.api.config.q
                    public void a(String str2) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        h.b(context, str, str2, eVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.q
                    public void a(Throwable th) {
                        Context context2 = context;
                        StringBuilder sbR = c.a.a.a.a.r(BaseConstants.MARKET_PREFIX);
                        sbR.append(str);
                        com.ss.android.downloadlib.b.a.a(h.a(context2, Uri.parse(sbR.toString())), eVar, true);
                        l.a(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        h.b(eVar, jSONObject, 7, 5);
                    }
                });
            }
        });
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.f.d.f() && l.d(context, "com.sec.android.app.samsungapps")) {
                return d(context, str);
            }
            return a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        return new com.ss.android.downloadlib.addownload.b.g(6, 11);
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.f.d.f() && l.d(context, "com.sec.android.app.samsungapps")) {
                return d(context, str);
            }
            if (eVar.f3052b.isAd() && eVar.f3054d.enableAM()) {
                JSONArray jSONArrayOptJSONArray = com.ss.android.downloadlib.addownload.j.i().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.f.d.b() && com.ss.android.socialbase.appdownloader.f.a.a(jSONArrayOptJSONArray, "am_0")) {
                    b(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_m1");
                }
                if (com.ss.android.socialbase.appdownloader.f.d.d() && com.ss.android.socialbase.appdownloader.f.a.a(jSONArrayOptJSONArray, "am_3")) {
                    return c(context, eVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.f.d.e() && com.ss.android.socialbase.appdownloader.f.a.a(jSONArrayOptJSONArray, "am_2")) {
                    d(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_m2");
                }
                if (com.ss.android.socialbase.appdownloader.f.d.c() && com.ss.android.socialbase.appdownloader.f.a.a(jSONArrayOptJSONArray, "am_5")) {
                    e(context, eVar, str);
                    return new com.ss.android.downloadlib.addownload.b.g(7, "am_v1");
                }
                return a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
            }
            return a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        return new com.ss.android.downloadlib.addownload.b.g(6, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.ss.android.downloadlib.addownload.b.e eVar, JSONObject jSONObject, int i2, int i3) {
        l.a(jSONObject, "error_code", Integer.valueOf(i2));
        l.a(jSONObject, "ttdownloader_type", Integer.valueOf(i3));
        l.a(jSONObject, com.ss.android.socialbase.appdownloader.f.d.i(), Integer.valueOf(l.b(com.ss.android.downloadlib.addownload.j.getContext(), com.ss.android.socialbase.appdownloader.f.d.i())));
        com.ss.android.downloadlib.d.a.a().b("am_result", jSONObject, eVar);
    }

    public static com.ss.android.downloadlib.addownload.b.g b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.j.getContext();
        }
        Intent intentF = l.f(context, str);
        if (intentF == null) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 22);
        }
        intentF.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intentF);
            return new com.ss.android.downloadlib.addownload.b.g(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g b(String str, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.b.g(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.j.getContext();
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        intent.putExtra("open_url", str);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        if (l.b(context, intent)) {
            if (com.ss.android.downloadlib.addownload.j.i().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.j.k() != null && com.ss.android.downloadlib.addownload.j.k().a() && Build.VERSION.SDK_INT >= 26 && aVar.q()) {
                TTDelegateActivity.a(str, aVar);
            } else {
                try {
                    com.ss.android.downloadlib.addownload.j.getContext().startActivity(intent);
                } catch (Exception unused) {
                    return new com.ss.android.downloadlib.addownload.b.g(2);
                }
            }
            return new com.ss.android.downloadlib.addownload.b.g(1);
        }
        return new com.ss.android.downloadlib.addownload.b.g(2, 24);
    }

    private static String a(String str, @NonNull JSONObject jSONObject, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strA = com.ss.android.socialbase.appdownloader.f.c.a(jSONObject.optString("g"), str2);
        String strA2 = com.ss.android.socialbase.appdownloader.f.c.a(jSONObject.optString("h"), str2);
        return (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2)) ? str : str.replace(strA, strA2);
    }

    public static void a(Context context, String str, long j2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.b.e eVarE = com.ss.android.downloadlib.addownload.b.f.a().e(j2);
        try {
            JSONObject jSONObjectI = com.ss.android.downloadlib.addownload.j.i();
            String strOptString = jSONObjectI.optString(ai.az);
            String strA = com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString("aa"), strOptString);
            String strA2 = com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString("ac"), strOptString);
            String strA3 = com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString("af"), strOptString);
            boolean zA = com.ss.android.socialbase.appdownloader.f.a.a(jSONObjectI, context, strA2);
            StringBuilder sb = new StringBuilder(String.format(strA, str, strA3, strA2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String strI = com.ss.android.socialbase.appdownloader.f.d.i();
            if (l.d(context, strI)) {
                intent.setPackage(strI);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString("ae"), strOptString));
            } else {
                intent.addFlags(335544320);
            }
            l.a(jSONObject, "mf", Boolean.valueOf(zA));
            l.a(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            com.ss.android.downloadlib.b.a.a("am_kllk2", jSONObject, eVarE, true);
            if (zA) {
                b(eVarE, jSONObject, -1, 3);
            } else {
                b(eVarE, jSONObject, 3, 3);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.b.a.a(a(com.ss.android.downloadlib.addownload.j.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVarE, true);
            b(eVarE, jSONObject, 2, 3);
        }
    }

    private static boolean a(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra("param", map);
        String strI = com.ss.android.socialbase.appdownloader.f.d.i();
        if (l.d(com.ss.android.downloadlib.addownload.j.getContext(), strI)) {
            intent.setPackage(strI);
        }
        if (!l.a(com.ss.android.downloadlib.addownload.j.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.e.c.a().a(e2, "start v1");
            return false;
        }
    }

    public static void a(@NonNull Activity activity, String str, long j2, String str2, String str3) {
        JSONObject jSONObject;
        int i2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.b.e eVarE = com.ss.android.downloadlib.addownload.b.f.a().e(j2);
        try {
            JSONObject jSONObjectI = com.ss.android.downloadlib.addownload.j.i();
            boolean zA = com.ss.android.socialbase.appdownloader.f.a.a(jSONObjectI, activity, com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString("bg"), jSONObjectI.optString(ai.az)));
            HashMap<String, String> mapB = l.b(new JSONObject(str2));
            if (zA && !mapB.isEmpty() && a(activity, str, mapB)) {
                b(eVarE, jSONObject, -1, 5);
                com.ss.android.downloadlib.b.a.a("am_v1", jSONObject, eVarE, true);
                return;
            }
            if (zA) {
                i2 = mapB.isEmpty() ? 1 : 2;
            } else {
                i2 = 3;
            }
            b(eVarE, jSONObject, i2, 5);
            com.ss.android.downloadlib.b.a.a(a(activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVarE, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.b.a.a(a(com.ss.android.downloadlib.addownload.j.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVarE, true);
            b(eVarE, jSONObject, 4, 5);
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent intentF = l.f(context, str);
        if (intentF == null) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 22);
        }
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.j.i().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.j.k() != null && com.ss.android.downloadlib.addownload.j.k().a() && aVar.q()) {
            TTDelegateActivity.b(str, aVar);
            return new com.ss.android.downloadlib.addownload.b.g(3);
        }
        intentF.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intentF);
            return new com.ss.android.downloadlib.addownload.b.g(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.b.g(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(String str, com.ss.android.downloadad.api.a.a aVar) {
        return a(com.ss.android.downloadlib.addownload.j.getContext(), str, aVar);
    }

    public static com.ss.android.downloadlib.addownload.b.g a(@NonNull com.ss.android.downloadad.api.a.b bVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.b.g gVarB = b(str, bVar);
        return (com.ss.android.downloadlib.b.f.a(bVar) && gVarB.getType() == 2) ? a(str2, bVar) : gVarB;
    }
}
