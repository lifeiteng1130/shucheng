package c.c.a.x;

import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static List<String> a(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (c.b.a.m.f.o1()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                    }
                }
            } else {
                int iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i2 = 0;
                while (i2 < iIntValue) {
                    i2++;
                    String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i2));
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "GetAssetsPaths error. ", th);
            th.printStackTrace();
        }
        return arrayList;
    }

    @RequiresApi(api = 21)
    public static String[] b(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) c.c.a.a.b.a.a(ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i2 = 0; i2 < 3; i2++) {
            String[] strArr3 = strArr2[i2];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
