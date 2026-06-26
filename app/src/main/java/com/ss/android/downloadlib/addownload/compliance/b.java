package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.ifmvo.togetherad.gdt.other.NetworkRequestAsyncTask;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.f;
import com.ss.android.downloadlib.g.c;
import com.ss.android.downloadlib.g.l;
import com.umeng.analytics.pro.ai;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdLpComplianceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private SoftReference<Activity> a;

    /* JADX INFO: compiled from: AdLpComplianceManager.java */
    public static class a {
        private static b a = new b();
    }

    public void b(long j2) {
        com.ss.android.downloadlib.addownload.e eVarA = f.a().a(com.ss.android.downloadlib.addownload.b.f.a().e(j2).f3052b.getDownloadUrl());
        if (eVarA != null) {
            eVarA.a(true, true);
        } else {
            e.a(11, j2);
            com.ss.android.downloadlib.e.c.a().b("startDownload handler null");
        }
    }

    private b() {
    }

    public static b a() {
        return a.a;
    }

    public void a(long j2) {
        TTDelegateActivity.a(j2);
    }

    public boolean a(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || j.i().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(j.i().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public Activity b() {
        Activity activity = this.a.get();
        this.a = null;
        return activity;
    }

    public boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        long jA;
        long j2;
        if (!TextUtils.isEmpty(eVar.f3052b.getLogExtra())) {
            try {
                jA = l.a(new JSONObject(eVar.f3052b.getLogExtra()), "convert_id");
            } catch (Exception e2) {
                e2.printStackTrace();
                jA = 0;
            }
            if (jA <= 0) {
                e.a(3, eVar);
            }
            j2 = jA;
        } else {
            e.a(9, eVar);
            com.ss.android.downloadlib.e.c.a().a("requestAppInfo getLogExtra null");
            j2 = 0;
        }
        final long j3 = eVar.a;
        com.ss.android.downloadlib.addownload.b.b bVarA = c.a().a(j2, j3);
        if (bVarA != null) {
            d.a().a(bVarA.a(), j3, bVarA.f3031d);
            a(bVarA.a());
            e.a("lp_app_dialog_try_show", eVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j2 > 0) {
            sb.append("convert_id=");
            sb.append(j2);
        }
        if (!TextUtils.isEmpty(eVar.f3052b.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(eVar.f3052b.getPackageName());
        }
        if (sb.length() <= 0) {
            e.a(6, eVar);
            return false;
        }
        StringBuilder sbR = c.a.a.a.a.r("https://apps.oceanengine.com/customer/api/app/pkg_info?");
        sbR.append(sb.toString());
        final long j4 = j2;
        com.ss.android.downloadlib.g.c.a((c.a<String, R>) new c.a<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2
            @Override // com.ss.android.downloadlib.g.c.a
            public Boolean a(String str) {
                final boolean[] zArr = {false};
                j.d().a(NetworkRequestAsyncTask.REQUEST_METHOD, str, new HashMap(), new q() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2.1
                    @Override // com.ss.android.download.api.config.q
                    public void a(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = b.this.a(j4, j3, str2);
                    }

                    @Override // com.ss.android.download.api.config.q
                    public void a(Throwable th) {
                        e.a(2, j3);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, sbR.toString()).a(new c.a<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.1
            @Override // com.ss.android.downloadlib.g.c.a
            public Object a(Boolean bool) {
                if (!bool.booleanValue()) {
                    b.this.b(j3);
                    return null;
                }
                b.this.a(com.ss.android.downloadlib.addownload.b.b.a(j4, j3));
                e.b("lp_app_dialog_try_show", j3);
                return null;
            }
        }).a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j2, long j3, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(AbsServerManager.PACKAGE_QUERY_BINDER);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.b.b bVar = new com.ss.android.downloadlib.addownload.b.b();
                bVar.a = j2;
                bVar.f3029b = j3;
                bVar.f3031d = jSONObjectOptJSONObject.optString("icon_url");
                bVar.f3032e = jSONObjectOptJSONObject.optString("app_name");
                bVar.f3030c = jSONObjectOptJSONObject.optString(ai.o);
                bVar.f3033f = jSONObjectOptJSONObject.optString("version_name");
                bVar.f3034g = jSONObjectOptJSONObject.optString("developer_name");
                bVar.f3036i = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i2);
                        bVar.f3035h.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                c.a().a(bVar);
                d.a().a(bVar.a(), j3, bVar.f3031d);
                return true;
            }
            e.a(7, j3);
            return false;
        } catch (Exception e2) {
            com.ss.android.downloadlib.e.c.a().a(e2, "AdLpComplianceManager parseResponse");
            e.a(7, j3);
            return false;
        }
    }

    public void a(Activity activity) {
        this.a = new SoftReference<>(activity);
    }
}
