package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.setting.f;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.helper.DataUtil;

/* JADX INFO: loaded from: classes.dex */
public class SM {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f2821c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f2824f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2826h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f2829k;
    private Context m;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f2830l = "";
    private a a = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f2822d = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f2825g = new c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d f2827i = new d();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f2828j = new d();
    private String n = SystemUtil.buildNewPathByProcessName("e_qq_com_setting");

    public SM(Context context) {
        this.m = context;
        d();
        c();
        a();
        b();
    }

    private void a() {
        f.b<a> bVarA = f.a(this.m);
        if (bVarA == null) {
            GDTLogger.d("Load Local DEV Cloud setting fail");
        } else {
            this.f2821c = bVarA.a();
            this.f2820b = bVarA.b();
        }
    }

    private void b() {
        f.b<d> bVarB = f.b(this.m);
        if (bVarB == null) {
            GDTLogger.d("Load Local DEV Cloud setting fail");
        } else {
            this.f2827i = bVarB.a();
            this.f2826h = bVarB.b();
        }
    }

    private void c() {
        f.b<e> bVarC = f.c(this.m);
        if (bVarC == null) {
            GDTLogger.d("Load Local SDK Cloud setting fail");
        } else {
            this.f2823e = bVarC.b();
            this.f2824f = bVarC.a();
        }
    }

    private void d() {
        try {
            this.f2829k = StringUtil.readAll(new File(this.m.getDir(this.n, 0), "gdt_suid"));
        } catch (Throwable unused) {
            this.f2829k = null;
            GDTLogger.d("IO Exception while loading suid");
        }
    }

    public Object get(String str) {
        Object objOpt;
        Object objOpt2;
        Object objOpt3;
        Object objOpt4;
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            a aVar = this.a;
            if (aVar != null && (objOpt4 = aVar.a.opt(str)) != null) {
                return objOpt4;
            }
            a aVar2 = this.f2821c;
            if (aVar2 != null && (objOpt3 = aVar2.a.opt(str)) != null) {
                return objOpt3;
            }
            a aVar3 = this.f2822d;
            if (aVar3 != null && (objOpt2 = aVar3.a.opt(str)) != null) {
                return objOpt2;
            }
            e eVar = this.f2824f;
            if (eVar != null && (objOpt = eVar.a.opt(str)) != null) {
                return objOpt;
            }
            e eVar2 = this.f2825g;
            if (eVar2 != null) {
                return eVar2.a.opt(str);
            }
            return null;
        } catch (Throwable unused) {
            GDTLogger.d("Exception in settingManager.get Setting for key");
            return null;
        }
    }

    public String getDevCloudSettingSig() {
        return this.f2820b;
    }

    public Object getDisplaySetting(String str) {
        return this.f2828j.a.opt(str);
    }

    public Object getForPlacement(String str, String str2) {
        Object objA;
        Object objA2;
        Object objA3;
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        if (StringUtil.isEmpty(str2)) {
            return get(str);
        }
        try {
            JSONObject jSONObjectOptJSONObject = this.f2828j.a.optJSONObject(str2);
            Object objOpt = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt(str) : null;
            if (objOpt != null) {
                return objOpt;
            }
            d dVar = this.f2827i;
            if (dVar != null) {
                JSONObject jSONObjectOptJSONObject2 = dVar.a.optJSONObject(str2);
                Object objOpt2 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.opt(str) : null;
                if (objOpt2 != null) {
                    return objOpt2;
                }
            }
            a aVar = this.a;
            if (aVar != null && (objA3 = aVar.a(str, str2)) != null) {
                return objA3;
            }
            a aVar2 = this.f2821c;
            if (aVar2 != null && (objA2 = aVar2.a(str, str2)) != null) {
                return objA2;
            }
            a aVar3 = this.f2822d;
            return (aVar3 == null || (objA = aVar3.a(str, str2)) == null) ? get(str) : objA;
        } catch (Throwable unused) {
            GDTLogger.d("Exception in settingManager.getForPlacement");
            return null;
        }
    }

    @Deprecated
    public int getInteger(String str, int i2) {
        Object obj = get(str);
        return (obj == null || !(obj instanceof Integer)) ? i2 : ((Integer) obj).intValue();
    }

    public int getIntegerForPlacement(String str, String str2, int i2) {
        Object forPlacement = getForPlacement(str, str2);
        return (forPlacement == null || !(forPlacement instanceof Integer)) ? i2 : ((Integer) forPlacement).intValue();
    }

    public String getPlacementCloudSettingSig() {
        return this.f2826h;
    }

    public String getSdkCloudSettingSig() {
        return this.f2823e;
    }

    public String getSettingDir() {
        return this.n;
    }

    public Set<String> getSettingKeySet(String str) {
        JSONObject jSONObject;
        HashSet hashSet = new HashSet();
        ArrayList<JSONObject> arrayList = new ArrayList();
        ArrayList<b> arrayList2 = new ArrayList();
        arrayList2.add(this.f2828j);
        arrayList2.add(this.f2827i);
        arrayList2.add(this.a);
        arrayList2.add(this.f2821c);
        arrayList2.add(this.f2822d);
        arrayList2.add(this.f2824f);
        arrayList2.add(this.f2825g);
        for (b bVar : arrayList2) {
            if (bVar != null && (jSONObject = bVar.a) != null) {
                arrayList.add(jSONObject);
                arrayList.add(bVar.a.optJSONObject(str));
            }
        }
        for (JSONObject jSONObject2 : arrayList) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    hashSet.add(itKeys.next());
                }
            }
        }
        return hashSet;
    }

    public String getSid() {
        return this.f2830l;
    }

    @Deprecated
    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Deprecated
    public String getString(String str, String str2) {
        Object obj = get(str);
        return obj == null ? str2 : obj.toString();
    }

    public String getStringForPlacement(String str, String str2) {
        return getStringForPlacement(str, str2, null);
    }

    public String getStringForPlacement(String str, String str2, String str3) {
        Object forPlacement = getForPlacement(str, str2);
        return forPlacement == null ? str3 : forPlacement.toString();
    }

    public String getSuid() {
        return this.f2829k;
    }

    public void setDEVCodeSetting(String str, Object obj) {
        a aVar = this.f2822d;
        Objects.requireNonNull(aVar);
        try {
            aVar.a.putOpt(str, obj);
        } catch (JSONException unused) {
            GDTLogger.d("Exception while update setting");
        }
    }

    public void updateContextSetting(String str) {
        try {
            a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar = new a(new String(Base64.decode(str, 0), DataUtil.defaultCharset));
            }
            this.a = aVar;
        } catch (Throwable unused) {
            GDTLogger.d("Exception while update Context Setting");
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        if (f.a(this.m, str, str2)) {
            a();
        }
    }

    public void updateDisplaySetting(String str, Object obj) {
        d dVar = this.f2828j;
        Objects.requireNonNull(dVar);
        try {
            dVar.a.putOpt(str, obj);
        } catch (JSONException e2) {
            GDTLogger.d(e2.getMessage());
        }
    }

    public void updatePlacementSetting(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (f.b(this.m, str, str2)) {
                b();
                return;
            }
            return;
        }
        File dir = this.m.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (dir.exists()) {
            File file = new File(dir, "placementCloudSetting.cfg");
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(dir, "placementCloudSetting.sig");
            if (file2.exists()) {
                file2.delete();
            }
        }
        this.f2827i = new d();
        this.f2826h = null;
    }

    public void updateSDKCloudSetting(String str, String str2) {
        if (f.c(this.m, str, str2)) {
            c();
        }
    }

    public void updateSID(String str) {
        this.f2830l = str;
    }

    public void updateSUID(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f2829k)) {
            return;
        }
        this.f2829k = str;
        try {
            StringUtil.writeTo(str, new File(this.m.getDir(this.n, 0), "gdt_suid"));
        } catch (IOException unused) {
            GDTLogger.d("Exception while persit suid");
        }
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        a aVar = this.f2822d;
        Objects.requireNonNull(aVar);
        try {
            JSONObject jSONObjectOptJSONObject = aVar.a.optJSONObject(Constants.KEYS.PLACEMENTS);
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                aVar.a.putOpt(Constants.KEYS.PLACEMENTS, jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2);
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
                jSONObjectOptJSONObject.putOpt(str2, jSONObjectOptJSONObject2);
            }
            if (obj == null) {
                jSONObjectOptJSONObject2.remove(str);
            } else {
                jSONObjectOptJSONObject2.putOpt(str, obj);
            }
        } catch (JSONException unused) {
            GDTLogger.d("Exception while update setting");
        }
    }
}
