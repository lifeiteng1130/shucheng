package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.e.b;
import com.ss.android.downloadlib.g.i;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdWebViewDownloadManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.ss.android.downloadad.api.b {
    private static String a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f3160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f3161c = g.a(j.getContext());

    private b() {
    }

    public static DownloadEventConfig c() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog b(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z2) {
        if (b(downloadModel.getId())) {
            if (z2) {
                a(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                a(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.f3161c.a(context, i2, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) l.a(downloadEventConfig, c());
        final DownloadController downloadController2 = (DownloadController) l.a(downloadController, b());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.b.a().a(downloadModel)) ? true : (j.i().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.f3161c.a(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
            return null;
        }
        String str2 = a;
        StringBuilder sbR = c.a.a.a.a.r("tryStartDownload show dialog appName:");
        sbR.append(downloadModel.getDownloadUrl());
        k.a(str2, sbR.toString(), null);
        Dialog dialogB = j.c().b(new b.a(context).a(downloadModel.getName()).b("确认要下载此应用吗？").c("确认").d("取消").a(new b.InterfaceC0074b() { // from class: com.ss.android.downloadlib.b.2
            @Override // com.ss.android.download.api.model.b.InterfaceC0074b
            public void a(DialogInterface dialogInterface) {
                b.this.f3161c.a(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0074b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0074b
            public void c(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }
        }).a(0).a());
        com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return dialogB;
    }

    public static b a() {
        if (f3160b == null) {
            synchronized (b.class) {
                if (f3160b == null) {
                    f3160b = new b();
                }
            }
        }
        return f3160b;
    }

    @Override // com.ss.android.downloadad.api.b
    public Dialog a(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        return a(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, false);
    }

    public Dialog a(final Context context, final String str, final boolean z, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i2, final boolean z2) {
        return (Dialog) com.ss.android.downloadlib.e.b.a(new b.a<Dialog>() { // from class: com.ss.android.downloadlib.b.1
            @Override // com.ss.android.downloadlib.e.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Dialog b() {
                return b.this.b(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, z2);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(Context context, long j2, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        com.ss.android.downloadad.api.a.b bVarD = com.ss.android.downloadlib.addownload.b.f.a().d(j2);
        if (bVarD != null) {
            this.f3161c.a(context, i2, downloadStatusChangeListener, bVarD.af());
            return true;
        }
        DownloadModel downloadModelA = com.ss.android.downloadlib.addownload.b.f.a().a(j2);
        if (downloadModelA == null) {
            return false;
        }
        this.f3161c.a(context, i2, downloadStatusChangeListener, downloadModelA);
        return true;
    }

    public void a(long j2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel downloadModelA = com.ss.android.downloadlib.addownload.b.f.a().a(j2);
        com.ss.android.downloadad.api.a.b bVarD = com.ss.android.downloadlib.addownload.b.f.a().d(j2);
        if (downloadModelA == null && bVarD != null) {
            downloadModelA = bVarD.af();
        }
        if (downloadModelA == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.c) && !(downloadController instanceof com.ss.android.download.api.download.b)) {
            downloadEventConfig.setDownloadScene(1);
            this.f3161c.a(downloadModelA.getDownloadUrl(), j2, 2, downloadEventConfig, downloadController);
        } else {
            a(j2);
        }
    }

    public void a(long j2) {
        DownloadModel downloadModelA = com.ss.android.downloadlib.addownload.b.f.a().a(j2);
        com.ss.android.downloadad.api.a.b bVarD = com.ss.android.downloadlib.addownload.b.f.a().d(j2);
        if (downloadModelA == null && bVarD != null) {
            downloadModelA = bVarD.af();
        }
        if (downloadModelA == null) {
            return;
        }
        DownloadEventConfig downloadEventConfigB = com.ss.android.downloadlib.addownload.b.f.a().b(j2);
        DownloadController downloadControllerC = com.ss.android.downloadlib.addownload.b.f.a().c(j2);
        if (downloadEventConfigB instanceof com.ss.android.download.api.download.c) {
            downloadEventConfigB = null;
        }
        if (downloadControllerC instanceof com.ss.android.download.api.download.b) {
            downloadControllerC = null;
        }
        if (bVarD == null) {
            if (downloadEventConfigB == null) {
                downloadEventConfigB = c();
            }
            if (downloadControllerC == null) {
                downloadControllerC = b();
            }
        } else {
            if (downloadEventConfigB == null) {
                downloadEventConfigB = new AdDownloadEventConfig.Builder().setClickButtonTag(bVarD.j()).setRefer(bVarD.i()).setIsEnableV3Event(bVarD.m()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (downloadControllerC == null) {
                downloadControllerC = bVarD.ah();
            }
        }
        DownloadEventConfig downloadEventConfig = downloadEventConfigB;
        downloadEventConfig.setDownloadScene(1);
        this.f3161c.a(downloadModelA.getDownloadUrl(), j2, 2, downloadEventConfig, downloadControllerC);
    }

    public boolean b(long j2) {
        return (com.ss.android.downloadlib.addownload.b.f.a().a(j2) == null && com.ss.android.downloadlib.addownload.b.f.a().d(j2) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadController downloadControllerB = downloadController;
        if (!com.ss.android.download.api.c.a.a(uri) || j.i().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? j.getContext() : context;
        String strB = com.ss.android.download.api.c.a.b(uri);
        if (downloadModel == null) {
            return i.a(context2, strB).getType() == 5;
        }
        if (!TextUtils.isEmpty(strB) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(strB);
        }
        if (downloadControllerB != null) {
            downloadControllerB.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadControllerB = a(true);
        } else if (downloadModel.getDownloadUrl().startsWith(BaseConstants.SCHEME_MARKET)) {
            downloadControllerB = a(true);
        } else {
            downloadControllerB = b();
        }
        com.ss.android.downloadlib.addownload.b.e eVar = new com.ss.android.downloadlib.addownload.b.e(downloadModel.getId(), downloadModel, (DownloadEventConfig) l.a(downloadEventConfig, c()), downloadControllerB);
        com.ss.android.downloadlib.addownload.b.f.a().a(eVar.f3052b);
        com.ss.android.downloadlib.addownload.b.f.a().a(eVar.a, eVar.f3053c);
        com.ss.android.downloadlib.addownload.b.f.a().a(eVar.a, eVar.f3054d);
        if (l.a(downloadModel) && com.ss.android.socialbase.downloader.g.a.c().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.a(eVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "market_url", uri.toString());
        l.a(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
        com.ss.android.downloadlib.addownload.b.g gVarA = i.a(context2, eVar, strB);
        String strA = l.a(gVarA.b(), "open_market");
        if (gVarA.getType() == 5) {
            com.ss.android.downloadlib.b.a.a(strA, jSONObject, eVar, true);
            return true;
        }
        if (gVarA.getType() != 6) {
            return true;
        }
        l.a(jSONObject, "error_code", Integer.valueOf(gVarA.a()));
        com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
        return false;
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        return ((Boolean) com.ss.android.downloadlib.e.b.a(new b.a<Boolean>() { // from class: com.ss.android.downloadlib.b.3
            @Override // com.ss.android.downloadlib.e.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(b.this.b(context, uri, downloadModel, downloadEventConfig, downloadController));
            }
        })).booleanValue();
    }

    public static DownloadController a(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    public static DownloadController b() {
        return a(false);
    }
}
