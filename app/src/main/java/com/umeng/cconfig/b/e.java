package com.umeng.cconfig.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static synchronized JSONArray a(c cVar, Context context) {
        JSONArray jSONArray = null;
        if (cVar != null && context != null) {
            try {
                a aVar = new a();
                String uMId = UMUtils.getUMId(context);
                if (TextUtils.isEmpty(uMId)) {
                    return null;
                }
                aVar.f5026i = uMId;
                String appkey = UMUtils.getAppkey(context);
                if (TextUtils.isEmpty(appkey)) {
                    return null;
                }
                aVar.f5025h = appkey;
                aVar.f5029l = Long.valueOf(System.currentTimeMillis());
                aVar.f5027j = Integer.valueOf(Integer.parseInt(cVar.f5042c));
                aVar.f5028k = Integer.valueOf(Integer.parseInt(cVar.f5043d));
                aVar.m = cVar.a;
                aVar.n = cVar.f5041b;
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                try {
                    try {
                        jSONObject.put(a.a, aVar.f5025h);
                        jSONObject.put(a.f5022e, aVar.f5029l);
                        jSONObject.put(a.f5020c, aVar.f5027j);
                        jSONObject.put(a.f5021d, aVar.f5028k);
                        jSONObject.put(a.f5019b, aVar.f5026i);
                        jSONObject.put(a.f5023f, aVar.m);
                        jSONObject.put(a.f5024g, aVar.n);
                        jSONArray2.put(0, jSONObject);
                        List<JSONObject> listB = b(context);
                        if (listB.size() > 0) {
                            for (int i2 = 1; i2 <= listB.size(); i2++) {
                                jSONArray2.put(i2, listB.get(i2 - 1));
                            }
                        }
                        try {
                            SharedPreferences sharedPreferencesA = com.umeng.cconfig.a.c.a(context);
                            if (sharedPreferencesA != null) {
                                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                                editorEdit.putString("abtest_sp_last_request_data", "");
                                editorEdit.commit();
                            }
                        } catch (Exception unused) {
                        }
                        return jSONArray2;
                    } catch (Exception unused2) {
                        ULog.i("jessie", "[getUpdateAbEventLogParam] error i");
                        jSONArray = jSONArray2;
                        return jSONArray;
                    }
                } catch (Exception unused3) {
                    jSONArray = jSONArray2;
                    ULog.i("jessie", "[getUpdateAbEventLogParam] error ii");
                }
            } catch (Exception unused4) {
            }
            ULog.i("jessie", "[getUpdateAbEventLogParam] error ii");
        }
        return jSONArray;
    }

    public static synchronized JSONObject a(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            b bVar = new b();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            bVar.n = uMId;
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            bVar.o = appkey;
            bVar.p = UMUtils.getAppVersionName(context);
            bVar.q = "9.3.3";
            bVar.r = UMUtils.getChannel(context);
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            bVar.s = sb.toString();
            bVar.t = Build.BRAND;
            bVar.u = Build.MODEL;
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            bVar.v = localeInfo[1];
            bVar.y = localeInfo[0];
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            bVar.x = Integer.valueOf(resolutionArray[1]);
            bVar.w = Integer.valueOf(resolutionArray[0]);
            String strImprintProperty = "";
            if (context != null) {
                strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "install_datetime", "");
            }
            bVar.z = strImprintProperty;
            try {
                jSONObject = new JSONObject();
            } catch (JSONException unused) {
            }
            try {
                jSONObject.put(b.a, bVar.n);
                jSONObject.put(b.f5031c, bVar.p);
                jSONObject.put(b.f5030b, bVar.o);
                jSONObject.put(b.f5032d, bVar.q);
                jSONObject.put(b.f5033e, bVar.r);
                jSONObject.put(b.f5034f, bVar.s);
                jSONObject.put(b.f5035g, bVar.t);
                jSONObject.put(b.f5036h, bVar.u);
                jSONObject.put(b.f5039k, bVar.x);
                jSONObject.put(b.f5038j, bVar.w);
                jSONObject.put(b.f5040l, bVar.y);
                jSONObject.put(b.f5037i, bVar.v);
                jSONObject.put(b.m, bVar.z);
                return jSONObject;
            } catch (JSONException unused2) {
                jSONObject2 = jSONObject;
                ULog.i("jessie", "[getCloudConfigParam] error i");
                return jSONObject2;
            } catch (Exception unused3) {
                jSONObject2 = jSONObject;
            }
        } catch (Exception unused4) {
        }
        ULog.i("jessie", "[getCloudConfigParam] error ii");
        return jSONObject2;
    }

    private static List<JSONObject> b(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            SharedPreferences sharedPreferencesA = com.umeng.cconfig.a.c.a(context);
            if (sharedPreferencesA != null) {
                String string = sharedPreferencesA.getString("abtest_sp_last_request_data", "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            String string2 = jSONArray.getString(i2);
                            if (!TextUtils.isEmpty(string2)) {
                                arrayList.add(new JSONObject(string2));
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
