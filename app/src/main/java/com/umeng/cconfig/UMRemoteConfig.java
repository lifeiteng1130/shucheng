package com.umeng.cconfig;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.text.TextUtils;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.d;
import com.umeng.cconfig.b.c;
import com.umeng.cconfig.b.d;
import com.umeng.cconfig.b.e;
import com.umeng.cconfig.c.b;
import com.umeng.cconfig.listener.OnConfigStatusChangedListener;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mozilla.javascript.ES6Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class UMRemoteConfig {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RemoteConfigSettings f5012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private OnConfigStatusChangedListener f5013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ReadWriteLock f5014j;
    public static final Pattern a = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]{1,255}");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f5007c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, c> f5008d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Map<String, c> f5009e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, String> f5010f = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5006b = true;

    public static class a {
        private static final UMRemoteConfig a = new UMRemoteConfig(0);
    }

    private UMRemoteConfig() {
        this.f5014j = new ReentrantReadWriteLock(true);
    }

    public /* synthetic */ UMRemoteConfig(byte b2) {
        this();
    }

    private void a(Context context, int i2) {
        if (context == null || i2 <= 0) {
            return;
        }
        try {
            try {
                try {
                    try {
                        this.f5014j.writeLock().lock();
                        XmlResourceParser xml = context.getResources().getXml(i2);
                        String name = null;
                        String text = null;
                        String text2 = null;
                        for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                            if (eventType == 2) {
                                name = xml.getName();
                            } else if (eventType == 3) {
                                if ("entry".equals(xml.getName()) && text != null && text2 != null) {
                                    if (a.matcher(text.trim()).matches()) {
                                        f5010f.put(text, text2);
                                        c cVar = new c();
                                        cVar.a = text;
                                        cVar.f5041b = text2;
                                        f5009e.put(text, cVar);
                                        text = null;
                                        text2 = null;
                                    }
                                    if (f5010f.size() > 1000) {
                                        break;
                                    }
                                }
                                name = null;
                            } else if (eventType == 4) {
                                if ("key".equals(name)) {
                                    text = xml.getText();
                                } else if (ES6Iterator.VALUE_PROPERTY.equals(name)) {
                                    text2 = xml.getText();
                                }
                            }
                        }
                    } catch (XmlPullParserException unused) {
                        ULog.e("jessie", "[xmlLoad] xml load fail");
                    }
                } catch (IOException unused2) {
                    ULog.e("jessie", "[xmlLoad] xml load fail");
                }
            } catch (Exception unused3) {
                ULog.e("jessie", "[xmlLoad] xml load fail");
            }
        } finally {
            this.f5014j.writeLock().unlock();
        }
    }

    private void a(d dVar) {
        if (dVar != null) {
            String str = dVar.f5044b;
            try {
                try {
                    this.f5014j.writeLock().lock();
                    if (!TextUtils.isEmpty(str)) {
                        JSONArray jSONArray = new JSONArray(str);
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject = new JSONObject(jSONArray.getString(i2));
                            try {
                                String string = "";
                                c cVar = new c();
                                if (jSONObject.has("k")) {
                                    string = jSONObject.getString("k");
                                    cVar.a = string;
                                }
                                if (jSONObject.has(ai.aC)) {
                                    cVar.f5041b = jSONObject.getString(ai.aC);
                                }
                                if (jSONObject.has("e")) {
                                    cVar.f5042c = jSONObject.getString("e");
                                }
                                if (jSONObject.has("g")) {
                                    cVar.f5043d = jSONObject.getString("g");
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    f5009e.put(jSONObject.getString("k"), cVar);
                                }
                            } catch (Exception unused) {
                                ULog.e("jessie", "[active] new config active false");
                            }
                        }
                    }
                    f5008d.clear();
                    f5008d.putAll(f5009e);
                    f5009e.clear();
                    ULog.i("jessie", "[active] new config active success i");
                } catch (Exception unused2) {
                    ULog.e("jessie", "[active] new config active false");
                }
            } finally {
                this.f5014j.writeLock().unlock();
            }
        } else {
            try {
                this.f5014j.writeLock().lock();
                f5008d.clear();
                f5008d.putAll(f5009e);
                f5009e.clear();
                ULog.i("[active] new config active success ii");
            } catch (Exception unused3) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static UMRemoteConfig getInstance() {
        return a.a;
    }

    public static String getVersion() {
        return "1.0.0";
    }

    public void activeFetchConfig() {
        if (!f5006b) {
            MLog.d("ucc", "remote config disable");
            return;
        }
        Context context = f5007c;
        if (context == null) {
            MLog.d("ucc", "UMRemoteConfig did not init");
        } else if (!UMUtils.isMainProgress(context)) {
            MLog.d("ucc", "can not be called in child process");
        } else {
            try {
                new com.umeng.cconfig.d.a(f5007c).run();
            } catch (Exception unused) {
            }
        }
    }

    public String getConfigValue(String str) {
        String str2 = null;
        if (!f5006b) {
            MLog.d("ucc", "remote config disable");
            return null;
        }
        Context context = f5007c;
        if (context == null) {
            MLog.d("ucc", "UMRemoteConfig did not init");
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.d("ucc", "can not be called in child process");
            return null;
        }
        try {
            this.f5014j.readLock().lock();
            c cVar = f5008d.get(str);
            if (cVar != null) {
                str2 = cVar.f5041b;
                if (!TextUtils.isEmpty(cVar.f5043d)) {
                    JSONArray jSONArrayA = e.a(cVar, f5007c);
                    ULog.d("jessie", "[ablog] ablog params : " + jSONArrayA.toString());
                    com.umeng.cconfig.c.c.a(new b("https://pslog.umeng.com/ablog", jSONArrayA));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f5014j.readLock().unlock();
            throw th;
        }
        this.f5014j.readLock().unlock();
        return str2;
    }

    public void handlerMessage(int i2, Object obj, String str) {
        SharedPreferences sharedPreferencesA;
        OnConfigStatusChangedListener onConfigStatusChangedListener;
        try {
            if (i2 == 1) {
                String str2 = (String) obj;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    this.f5014j.writeLock().lock();
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.has("cc") ? jSONObject.getString("cc") : "";
                    String string2 = jSONObject.has("ts") ? jSONObject.getString("ts") : "";
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        com.umeng.cconfig.a.b bVarA = com.umeng.cconfig.a.b.a(f5007c);
                        try {
                            try {
                                try {
                                    bVarA.a();
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("__ts", string2);
                                    contentValues.put(d.C0127d.a.f4845d, string);
                                    contentValues.put("__a", "0");
                                    ULog.i("jessie", "[DbManager] insert timeStamp: " + string2 + " content: " + string + " active: 0");
                                    bVarA.a.insert("__cc", null, contentValues);
                                    bVarA.a.setTransactionSuccessful();
                                    SQLiteDatabase sQLiteDatabase = bVarA.a;
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th) {
                                    try {
                                        SQLiteDatabase sQLiteDatabase2 = bVarA.a;
                                        if (sQLiteDatabase2 != null) {
                                            sQLiteDatabase2.endTransaction();
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    bVarA.b();
                                    throw th;
                                }
                            } catch (SQLiteDatabaseCorruptException unused2) {
                                ULog.i("jessie", "[DbManager] insert failed");
                                SQLiteDatabase sQLiteDatabase3 = bVarA.a;
                                if (sQLiteDatabase3 != null) {
                                    sQLiteDatabase3.endTransaction();
                                }
                            } catch (Throwable unused3) {
                                SQLiteDatabase sQLiteDatabase4 = bVarA.a;
                                if (sQLiteDatabase4 != null) {
                                    sQLiteDatabase4.endTransaction();
                                }
                            }
                        } catch (Throwable unused4) {
                        }
                        bVarA.b();
                        com.umeng.cconfig.a.b.a(f5007c).d();
                        MLog.i("ucc", "get new config success");
                        RemoteConfigSettings remoteConfigSettings = this.f5012h;
                        if (remoteConfigSettings != null) {
                            if (remoteConfigSettings.isAutoUpdateModeEnabled()) {
                                activeFetchConfig();
                            } else {
                                OnConfigStatusChangedListener onConfigStatusChangedListener2 = this.f5013i;
                                if (onConfigStatusChangedListener2 != null) {
                                    onConfigStatusChangedListener2.onFetchComplete();
                                }
                            }
                        }
                    }
                } finally {
                }
            } else if (i2 == 2) {
                try {
                    this.f5014j.writeLock().lock();
                    if (TextUtils.isEmpty((String) obj) && !TextUtils.isEmpty(str) && (sharedPreferencesA = com.umeng.cconfig.a.c.a(f5007c)) != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                        editorEdit.putString("abtest_sp_last_request_data", str);
                        editorEdit.commit();
                    }
                } finally {
                }
            } else {
                if (i2 != 3) {
                    return;
                }
                try {
                    this.f5014j.writeLock().lock();
                    if (((Boolean) obj).booleanValue()) {
                        a(f5007c, this.f5011g);
                        a(com.umeng.cconfig.a.b.a(f5007c).c());
                        MLog.i("ucc", "active new config success");
                        if (this.f5012h != null && (onConfigStatusChangedListener = this.f5013i) != null) {
                            onConfigStatusChangedListener.onActiveComplete();
                        }
                    }
                } finally {
                }
            }
        } catch (Exception unused5) {
        }
    }

    public void init(Context context) {
        try {
            if (!f5006b) {
                MLog.d("ucc", "remote config disable");
                return;
            }
            if (context == null) {
                return;
            }
            if (f5007c == null) {
                f5007c = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.d("ucc", "can not be called in child process");
            } else {
                if (this.f5012h == null) {
                    MLog.d("ucc", "please set RemoteConfigSettings using UMRemoteConfig.getInstance().setConfigSettings");
                    return;
                }
                a(f5007c, this.f5011g);
                a(com.umeng.cconfig.a.b.a(f5007c).c());
                ImprintHandler.getImprintService(f5007c).registImprintCallback("ucc", new UMImprintChangeCallback() { // from class: com.umeng.cconfig.UMRemoteConfig.1
                    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                    public final void onImprintValueChanged(String str, String str2) {
                        SharedPreferences sharedPreferencesA;
                        try {
                            if ("ucc".equals(str)) {
                                ULog.i("jessie", "[imprint] key: " + str + " value: " + str2);
                                String[] strArrSplit = str2.split("@");
                                String str3 = strArrSplit[3];
                                if (TextUtils.isEmpty(str3) || !SdkVersion.MINI_VERSION.equals(str3)) {
                                    return;
                                }
                                String str4 = strArrSplit[0];
                                if (TextUtils.isEmpty(str4) || (sharedPreferencesA = com.umeng.cconfig.a.c.a(UMRemoteConfig.f5007c)) == null) {
                                    return;
                                }
                                String string = sharedPreferencesA.getString("cconfig_sp_last_request_time", "");
                                if (!TextUtils.isEmpty(string) && str4.equals(string)) {
                                    ULog.i("jessie", "[imprint] newTimeStamp.equals(oldTimeStamp)");
                                    return;
                                }
                                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                                editorEdit.putString("cconfig_sp_last_request_time", str4);
                                editorEdit.commit();
                                JSONObject jSONObjectA = e.a(UMRemoteConfig.f5007c);
                                if (jSONObjectA != null) {
                                    try {
                                        ULog.i("jessie", "[imprint] send request. body: " + jSONObjectA.toString());
                                        com.umeng.cconfig.c.c.a(new b("https://ucc.umeng.com/v1/fetch", jSONObjectA));
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        } catch (Exception unused2) {
                            ULog.e("jessie", "[imprint] fail");
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void setConfigSettings(RemoteConfigSettings remoteConfigSettings) {
        if (!f5006b) {
            MLog.d("ucc", "remote config disable");
        } else {
            if (remoteConfigSettings != null) {
                this.f5012h = remoteConfigSettings;
            }
        }
    }

    public synchronized void setDefaults(int i2) {
        if (f5006b) {
            this.f5011g = i2;
        } else {
            MLog.d("ucc", "remote config disable");
        }
    }

    public synchronized void setOnNewConfigfecthed(OnConfigStatusChangedListener onConfigStatusChangedListener) {
        if (!f5006b) {
            MLog.d("ucc", "remote config disable");
        } else {
            if (onConfigStatusChangedListener != null) {
                this.f5013i = onConfigStatusChangedListener;
            }
        }
    }
}
