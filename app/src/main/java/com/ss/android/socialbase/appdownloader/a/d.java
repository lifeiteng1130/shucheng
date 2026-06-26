package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: DevicePlans.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static a a(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo);
        if (str.equals("v1")) {
            return new j(context, aVarA, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new k(context, aVarA, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new l(context, aVarA, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new g(context, aVarA, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new h(context, aVarA, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new i(context, aVarA, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new c(context, aVarA, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new m(context, aVarA, com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.d.j().d(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean a(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        if (context == null || str == null) {
            return false;
        }
        a mVar = null;
        String strB = com.ss.android.socialbase.appdownloader.c.b();
        if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("v1")) {
            mVar = new j(context, aVar, strB);
        } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("v2")) {
            mVar = new k(context, aVar, strB);
        } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("v3")) {
            mVar = new l(context, aVar, strB);
        } else if (com.ss.android.socialbase.appdownloader.f.d.d() && str.equals("o1")) {
            mVar = new g(context, aVar, strB);
        } else if (com.ss.android.socialbase.appdownloader.f.d.d() && str.equals("o2")) {
            mVar = new h(context, aVar, strB);
        } else if (com.ss.android.socialbase.appdownloader.f.d.d() && str.equals("o3")) {
            mVar = new i(context, aVar, strB, strB, strB);
        } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("custom")) {
            mVar = new c(context, aVar, strB, jSONObject);
        } else if (com.ss.android.socialbase.appdownloader.f.d.c() && str.equals("vbi")) {
            mVar = new m(context, aVar, strB);
        }
        return mVar != null && mVar.a();
    }
}
