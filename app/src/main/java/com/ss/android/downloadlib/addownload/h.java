package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadInsideHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static boolean a(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public static boolean a(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean b(int i2) {
        return i2 == 2 || i2 == 1;
    }

    public static boolean b(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static int a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, boolean z, com.ss.android.socialbase.appdownloader.f fVar) {
        int iA;
        if (fVar == null || TextUtils.isEmpty(fVar.a()) || fVar.getContext() == null) {
            return 0;
        }
        try {
            iA = a(fVar, fVar.a());
        } catch (Throwable th) {
            j.s().a(th, "redirectSavePathIfPossible");
            iA = 4;
        }
        fVar.a(iA);
        if (iA == 0) {
            fVar.a(new com.ss.android.downloadlib.c.a());
        }
        if (!fVar.Z()) {
            fVar.a(new com.ss.android.downloadlib.c.b());
        }
        int iA2 = com.ss.android.socialbase.appdownloader.d.j().a(fVar);
        com.ss.android.downloadad.api.a.b bVarA = a(eVar, iA2);
        com.ss.android.downloadlib.addownload.b.f.a().a(bVarA);
        bVarA.g(iA2);
        bVarA.h(System.currentTimeMillis());
        bVarA.i(0L);
        com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(fVar.ad());
        if (!a(fVar, aVarA, iA2) && eVar.f3052b.isShowToast()) {
            String startToast = eVar.f3052b.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = aVarA.c("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            j.c().a(2, fVar.getContext(), eVar.f3052b, startToast, null, 0);
        }
        return iA2;
    }

    private static com.ss.android.downloadad.api.a.b a(com.ss.android.downloadlib.addownload.b.e eVar, int i2) {
        com.ss.android.downloadad.api.a.b bVar = new com.ss.android.downloadad.api.a.b(eVar.f3052b, eVar.f3053c, eVar.f3054d, i2);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.g.a.a(i2).a("download_event_opt", 1) > 1) {
            try {
                String packageName = eVar.f3052b.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (j.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    bVar.h(z);
                }
            } catch (Throwable unused) {
            }
        }
        return bVar;
    }

    private static boolean a(com.ss.android.socialbase.appdownloader.f fVar, @NonNull com.ss.android.socialbase.downloader.g.a aVar, int i2) {
        String strOptString;
        JSONArray jSONArrayE = aVar.e("ah_plans");
        if (jSONArrayE != null && jSONArrayE.length() != 0) {
            int length = jSONArrayE.length();
            JSONObject jSONObject = null;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayE.optJSONObject(i3);
                    if (jSONObjectOptJSONObject != null && ((strOptString = jSONObjectOptJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.f.a.a(jSONObjectOptJSONObject))) {
                        strOptString.hashCode();
                        switch (strOptString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.ss.android.socialbase.appdownloader.b.a(jSONObjectOptJSONObject, aVar).f3294b != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "plan_c":
                                jSONObject = jSONObjectOptJSONObject;
                                continue;
                                break;
                            case "plan_g":
                                if (com.ss.android.socialbase.appdownloader.b.b(jSONObjectOptJSONObject, aVar).f3294b != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                        }
                    }
                    i3++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.c.N(), (Intent) null, jSONObject, i2, new com.ss.android.socialbase.appdownloader.a());
                }
            }
        }
        return false;
    }

    public static String a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static int a(com.ss.android.socialbase.appdownloader.f fVar, String str) {
        com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(fVar.ad());
        JSONObject jSONObjectD = aVarA.d("download_dir");
        if (jSONObjectD == null || TextUtils.isEmpty(jSONObjectD.optString("dir_name"))) {
            return -1;
        }
        String strB = fVar.b();
        String strL = fVar.L();
        if (TextUtils.isEmpty(strL)) {
            strL = com.ss.android.socialbase.appdownloader.c.a(str, strB, fVar.l(), true);
        }
        if (strL.length() > 255) {
            strL = strL.substring(strL.length() - 255);
        }
        if (TextUtils.isEmpty(strB)) {
            strB = strL;
        }
        String strC = fVar.c();
        if (TextUtils.isEmpty(strC)) {
            strC = com.ss.android.socialbase.appdownloader.c.b();
        }
        StringBuilder sbR = c.a.a.a.a.r(strC);
        sbR.append(File.separator);
        sbR.append(com.ss.android.socialbase.appdownloader.c.a(strB, aVarA));
        String string = sbR.toString();
        DownloadInfo downloadInfoA = com.ss.android.socialbase.appdownloader.d.j().a(fVar.getContext(), str);
        if (downloadInfoA != null && downloadInfoA.isSavePathRedirected()) {
            fVar.c(downloadInfoA.getSavePath());
            try {
                fVar.a(new JSONObject(downloadInfoA.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (downloadInfoA != null || !AdBaseConstants.MIME_APK.equalsIgnoreCase(com.ss.android.socialbase.appdownloader.d.j().a(strL, fVar.l()))) {
            return downloadInfoA != null ? 8 : 9;
        }
        int iA = com.ss.android.socialbase.appdownloader.b.a(aVarA);
        if (iA != 0) {
            return iA;
        }
        fVar.c(string);
        return iA;
    }
}
