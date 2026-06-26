package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import c.b.a.m.f;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusConstants;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ContentProviderManager {
    public static final String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final String PLUGIN_PROCESS_NAME = "process_name";
    public static final String PROVIDER_PARAM_FEILD = "provider_params";
    public static final String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final String PROVIDER_URI = "uri";
    private static ContentProviderManager sInstance;
    private final Map<b, a> mContentProviderMap = new HashMap();
    private final Map<String, String> mAuthorityProcessNameMap = new HashMap();
    private final Map<String, c> mSystemProviderInfoMap = new HashMap();

    public static final class a {
        public final PluginContentProvider a;

        public a(b bVar, ProviderInfo providerInfo, PluginContentProvider pluginContentProvider) {
            this.a = pluginContentProvider;
        }
    }

    public static class b {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1618c;

        public b(String str, String str2, String str3) {
            this.a = str2;
            this.f1617b = str3;
            this.f1618c = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (TextUtils.equals(this.f1618c, bVar.f1618c) && TextUtils.equals(this.f1617b, bVar.f1617b) && TextUtils.equals(this.a, bVar.a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.a, this.f1617b, this.f1618c);
        }
    }

    public static final class c extends b {
        public c(String str, String str2, ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
        }
    }

    private ContentProviderManager() {
    }

    public static ContentProviderManager getInstance() {
        if (sInstance == null) {
            synchronized (ContentProviderManager.class) {
                if (sInstance == null) {
                    sInstance = new ContentProviderManager();
                }
            }
        }
        return sInstance;
    }

    private void installProvider(ProviderInfo providerInfo, Plugin plugin) {
        if (providerInfo == null) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + plugin.mPkgName + "】");
            return;
        }
        ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + providerInfo.authority + "] [className:" + providerInfo.name + "]");
        try {
            PluginContentProvider pluginContentProviderInstantiateProvider = instantiateProvider(plugin.mClassLoader, providerInfo.name);
            pluginContentProviderInstantiateProvider.attachInfo(ZeusTransformUtils.wrapperContext(plugin.mHostApplication, plugin.mPkgName), providerInfo);
            ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + providerInfo.name + "]");
            b bVar = new b(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
            this.mContentProviderMap.put(bVar, new a(bVar, providerInfo, pluginContentProviderInstantiateProvider));
            this.mAuthorityProcessNameMap.put(providerInfo.authority, providerInfo.processName);
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e2);
        }
    }

    private PluginContentProvider instantiateProvider(ClassLoader classLoader, String str) {
        return (PluginContentProvider) classLoader.loadClass(str).newInstance();
    }

    public Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        if (contentResolver == null || uri == null) {
            return null;
        }
        try {
            try {
                Uri uriG = f.g(uri, str3);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("provider_params", uri.getAuthority());
                bundle.putString(PROVIDER_PROXY_URI, uriG.toString());
                return contentResolver.call(uriG, str, str2, bundle);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
            return contentResolver.call(uri, str, str2, bundle);
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
            return null;
        } catch (IncompatibleClassChangeError e3) {
            e = e3;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
            return null;
        }
    }

    public int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(f.g(uri, str2), str, strArr);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
                return -1;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
            return contentResolver.delete(uri, str, strArr);
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e2);
            return -1;
        }
    }

    public String getPluginProcessNameByAuthority(String str) {
        return this.mAuthorityProcessNameMap.get(str);
    }

    public PluginContentProvider getPluginProvider(b bVar) {
        a aVar = this.mContentProviderMap.get(bVar);
        if (aVar == null) {
            return null;
        }
        return aVar.a;
    }

    public Map<String, c> getSystemProviderInfoMap() {
        return this.mSystemProviderInfoMap;
    }

    public String getType(ContentResolver contentResolver, Uri uri, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.getType(f.g(uri, str));
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#getType throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute getType !!!");
            return contentResolver.getType(uri);
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#getType throw exception:", e2);
            return null;
        }
    }

    public void initSystemContentProviderInfo() {
        String str;
        try {
            ProviderInfo[] providerInfoArr = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;
            if (providerInfoArr == null || providerInfoArr.length == 0) {
                return;
            }
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo != null && (str = providerInfo.authority) != null) {
                    String str2 = ZeusConstants.f1614b;
                    if (str.contains(str2)) {
                        try {
                            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                            if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + str2)) {
                                String str3 = providerInfo.processName;
                                String str4 = c.c.a.n.c.a;
                                String str5 = (TextUtils.isEmpty(str3) || !str3.contains(":")) ? "main" : str3.split(":")[1];
                                this.mSystemProviderInfoMap.put(str5, new c(Zeus.getAppApplication().getPackageName(), str5, providerInfo));
                                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                            }
                        } catch (Exception e2) {
                            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception：", e2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
        }
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(f.g(uri, str), contentValues);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
            return contentResolver.insert(uri, contentValues);
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e2);
            return null;
        }
    }

    public void installContentProviders(Collection<ProviderInfo> collection, Plugin plugin) {
        if (collection == null || collection.size() == 0 || plugin == null) {
            return;
        }
        for (ProviderInfo providerInfo : collection) {
            if (ZeusLogger.isDebug()) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name);
                sb.append("]");
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, sb.toString());
            }
            installProvider(providerInfo, plugin);
        }
    }

    public boolean isPluginProvider(Uri uri) {
        if (uri == null) {
            return true;
        }
        String authority = uri.getAuthority();
        Set<String> setKeySet = this.mAuthorityProcessNameMap.keySet();
        return setKeySet != null && setKeySet.contains(authority);
    }

    @RequiresApi(api = 16)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(f.g(uri, str3), strArr, str, strArr2, str2, cancellationSignal);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(6 params) throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(6 params) !!!");
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
            return null;
        } catch (IncompatibleClassChangeError e3) {
            e = e3;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
            return null;
        }
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(f.g(uri, str2), contentValues, str, strArr);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
                return 0;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
            return contentResolver.update(uri, contentValues, str, strArr);
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e2);
            return 0;
        }
    }

    public int delete(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(f.g(uri, str), bundle);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
                return -1;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
            return contentResolver.delete(uri, bundle);
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
            return -1;
        } catch (IncompatibleClassChangeError e3) {
            e = e3;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
            return -1;
        }
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(f.g(uri, str), contentValues, bundle);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
            return contentResolver.insert(uri, contentValues, bundle);
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
            return null;
        } catch (IncompatibleClassChangeError e3) {
            e = e3;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
            return null;
        }
    }

    @RequiresApi(api = 26)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(f.g(uri, str), strArr, bundle, cancellationSignal);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(4 params) throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
            return contentResolver.query(uri, strArr, bundle, cancellationSignal);
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
            return null;
        } catch (IncompatibleClassChangeError e3) {
            e = e3;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
            return null;
        }
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(f.g(uri, str), contentValues, bundle);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
                return 0;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
            return contentResolver.update(uri, contentValues, bundle);
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
            return 0;
        } catch (IncompatibleClassChangeError e3) {
            e = e3;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
            return 0;
        }
    }

    public final Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        if (contentResolver == null) {
            return null;
        }
        String str5 = getInstance().getSystemProviderInfoMap().get(getInstance().getPluginProcessNameByAuthority(str)).f1617b;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("provider_params", str);
        bundle.putString(PROVIDER_PROXY_URI, f.h(str4, null, str).toString());
        try {
            try {
                return contentResolver.call(str5, str2, str3, bundle);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
            return contentResolver.call(str, str2, str3, bundle);
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
            return null;
        } catch (IncompatibleClassChangeError e3) {
            e = e3;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
            return null;
        }
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(f.g(uri, str3), strArr, str, strArr2, str2);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(5 params) throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(5 params) throw exception:", e2);
            return null;
        }
    }
}
