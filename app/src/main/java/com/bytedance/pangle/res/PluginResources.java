package com.bytedance.pangle.res;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.Keep;
import c.b.a.m.f;
import c.c.a.u.a;
import c.c.a.x.c;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PluginResources extends Resources {
    public PluginResources(Resources resources) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), Zeus.getAppApplication().getResources().getConfiguration());
    }

    public static AssetManager appendHostRes(Resources resources) {
        ArrayList<String> arrayList = new ArrayList();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 23) {
            try {
                Resources resources2 = Zeus.getAppApplication().getResources();
                arrayList.add(Zeus.getAppApplication().createPackageContext(resources2.getString(resources2.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir);
            } catch (Exception e2) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e2);
            }
        } else if (f.F0()) {
            try {
                Object objInvokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                if (i2 >= 29 || (i2 == 28 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                    Collections.addAll(arrayList, c.b(((Context) objInvokeStaticMethod).getApplicationInfo()));
                } else {
                    arrayList.add(((Context) objInvokeStaticMethod).getApplicationInfo().sourceDir);
                }
            } catch (Exception e3) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e3);
            }
        }
        a aVar = new a();
        AssetManager assets = resources.getAssets();
        AssetManager assets2 = Zeus.getAppApplication().getAssets();
        HashSet hashSet = new HashSet(c.a(assets));
        List<String> listA = c.a(assets2);
        for (String str : arrayList) {
            if (!hashSet.contains(str)) {
                assets = aVar.a(assets, str, true);
            }
        }
        for (String str2 : (ArrayList) listA) {
            if (!hashSet.contains(str2) && !arrayList.contains(str2)) {
                assets = aVar.a(assets, str2, false);
            }
        }
        return assets;
    }
}
