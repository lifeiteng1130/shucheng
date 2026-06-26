package com.ss.android.downloadlib.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.g.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdAppLinkUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        boolean z;
        DeepLink deepLink = eVar.f3052b.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject jSONObjectA = com.ss.android.downloadlib.g.f.a(new JSONObject(), eVar);
        l.a(jSONObjectA, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", jSONObjectA, eVar);
        com.ss.android.downloadlib.addownload.b.g gVarA = com.ss.android.downloadlib.g.i.a(openUrl, eVar);
        if (gVarA.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                b("by_url", gVarA, jSONObjectA, eVar);
            }
            gVarA = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), eVar.f3052b.getPackageName(), eVar);
        }
        boolean z2 = false;
        if (a(eVar.a) && com.ss.android.downloadlib.addownload.j.i().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = eVar.f3052b;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.d.a.a().a(eVar.a, 0);
            z = true;
        } else {
            z = false;
        }
        int type = gVarA.getType();
        if (type == 1) {
            b("by_url", jSONObjectA, eVar);
        } else {
            if (type != 3) {
                if (type != 4) {
                    com.ss.android.downloadlib.e.c.a().b("AppLinkClick default");
                } else {
                    a("by_package", gVarA, jSONObjectA, eVar);
                }
                if (z2 && !z && ((com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(eVar.a, eVar.f3052b.getLogExtra())) || com.ss.android.downloadlib.d.c.a().c())) {
                    com.ss.android.downloadlib.d.a.a().a(eVar.a, 2);
                }
                return z2;
            }
            a("by_package", jSONObjectA, eVar);
        }
        z2 = true;
        if (z2) {
            com.ss.android.downloadlib.d.a.a().a(eVar.a, 2);
        }
        return z2;
    }

    public static void b(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        String strF = com.ss.android.socialbase.downloader.g.a.c().b("app_link_opt") == 1 ? bVar.f() : null;
        JSONObject jSONObjectA = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
        l.a(jSONObjectA, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", jSONObjectA, bVar);
        com.ss.android.downloadlib.addownload.b.g gVarA = com.ss.android.downloadlib.g.i.a(strF, bVar);
        if (gVarA.getType() == 2) {
            if (!TextUtils.isEmpty(strF)) {
                b("dialog_by_url", gVarA, jSONObjectA, bVar);
            }
            gVarA = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), bVar.e(), bVar);
        }
        int type = gVarA.getType();
        if (type == 1) {
            b("dialog_by_url", jSONObjectA, bVar);
            return;
        }
        if (type == 3) {
            a("dialog_by_package", jSONObjectA, bVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.e.c.a().b("AppLinkClickDialog default");
        } else {
            a("dialog_by_package", gVarA, jSONObjectA, bVar);
        }
    }

    public static void b(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.a.a aVar) {
        l.a(jSONObject, "applink_source", str);
        l.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_url_open", jSONObject, aVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((com.ss.android.downloadlib.addownload.j.i().optInt("check_applink_mode") & 1) != 0) {
                    l.a(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    e.a().a(new d() { // from class: com.ss.android.downloadlib.b.a.2
                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            com.ss.android.downloadlib.d.a.a().b(z ? "deeplink_success" : "deeplink_failed", jSONObject, aVar);
                            if (z) {
                                com.ss.android.downloadlib.addownload.j.t().a(com.ss.android.downloadlib.addownload.j.getContext(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    com.ss.android.downloadlib.addownload.j.b().a(com.ss.android.downloadlib.addownload.j.getContext(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), str);
                    break;
                }
                break;
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        String strF = bVar.f();
        JSONObject jSONObjectA = com.ss.android.downloadlib.g.f.a(new JSONObject(), bVar);
        l.a(jSONObjectA, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.d.a.a().b("applink_click", jSONObjectA, bVar);
        com.ss.android.downloadlib.addownload.b.g gVarA = com.ss.android.downloadlib.g.i.a(strF, bVar);
        if (gVarA.getType() == 2) {
            if (!TextUtils.isEmpty(strF)) {
                b("notify_by_url", gVarA, jSONObjectA, bVar);
            }
            gVarA = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), bVar.e(), bVar);
        }
        int type = gVarA.getType();
        if (type == 1) {
            b("notify_by_url", jSONObjectA, bVar);
            return;
        }
        if (type == 3) {
            a("notify_by_package", jSONObjectA, bVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.e.c.a().b("AppLinkClickNotification default");
        } else {
            a("notify_by_package", gVarA, jSONObjectA, bVar);
        }
    }

    public static void b(String str, @NonNull com.ss.android.downloadlib.addownload.b.g gVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        l.a(jSONObject, "applink_source", str);
        l.a(jSONObject, "error_code", Integer.valueOf(gVar.a()));
        l.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_url_open_fail", jSONObject, aVar);
    }

    public static boolean a(String str, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        if (!com.ss.android.downloadlib.addownload.h.b(bVar.O())) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.f()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.b.a().f(bVar.s());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.g.f.a(jSONObject, bVar);
        l.a(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.d.a.a().b("applink_click", bVar);
        com.ss.android.downloadlib.addownload.b.g gVarA = com.ss.android.downloadlib.g.i.a(bVar, bVar.f(), bVar.e());
        int type = gVarA.getType();
        if (type == 1) {
            b("auto_by_url", jSONObject, bVar);
            return true;
        }
        if (type == 2) {
            b("auto_by_url", gVarA, jSONObject, bVar);
            return false;
        }
        if (type == 3) {
            a("auto_by_package", jSONObject, bVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        a("auto_by_package", gVarA, jSONObject, bVar);
        return false;
    }

    public static void a(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.a.a aVar) {
        l.a(jSONObject, "applink_source", str);
        l.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_app_open", jSONObject, aVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((com.ss.android.downloadlib.addownload.j.i().optInt("check_applink_mode") & 1) != 0) {
                    l.a(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    e.a().a(new d() { // from class: com.ss.android.downloadlib.b.a.1
                        @Override // com.ss.android.downloadlib.b.d
                        public void a(boolean z) {
                            com.ss.android.downloadlib.d.a.a().b(z ? "deeplink_success" : "deeplink_failed", jSONObject, aVar);
                            if (z) {
                                com.ss.android.downloadlib.addownload.j.t().a(com.ss.android.downloadlib.addownload.j.getContext(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    com.ss.android.downloadlib.addownload.j.b().a(com.ss.android.downloadlib.addownload.j.getContext(), aVar.u(), aVar.w(), aVar.v(), aVar.e(), str);
                    break;
                }
                break;
        }
    }

    public static void a(String str, @NonNull com.ss.android.downloadlib.addownload.b.g gVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        l.a(jSONObject, "applink_source", str);
        l.a(jSONObject, "error_code", Integer.valueOf(gVar.a()));
        l.a(jSONObject, "download_scene", Integer.valueOf(aVar.t()));
        com.ss.android.downloadlib.d.a.a().b("deeplink_app_open_fail", jSONObject, aVar);
    }

    public static boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, int i2) {
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
        com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
        com.ss.android.downloadlib.addownload.b.g gVarA = com.ss.android.downloadlib.g.i.a(com.ss.android.downloadlib.addownload.j.getContext(), eVar, eVar.f3052b.getPackageName());
        String strA = l.a(gVarA.b(), "open_market");
        int type = gVarA.getType();
        if (type == 5) {
            a(strA, jSONObject, eVar, true);
        } else {
            if (type == 6) {
                l.a(jSONObject, "error_code", Integer.valueOf(gVarA.a()));
                l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
                com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.d.a.a().a(eVar.a, i2);
        return true;
    }

    public static void a(final String str, @Nullable final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.b.e eVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e2) {
                com.ss.android.downloadlib.e.c.a().a(e2, "onMarketSuccess");
                return;
            }
        }
        l.a(jSONObject, "applink_source", str);
        l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
        if (z) {
            com.ss.android.downloadlib.d.a.a().b("market_open_success", jSONObject, eVar);
        }
        if ((com.ss.android.downloadlib.addownload.j.i().optInt("check_applink_mode") & 4) != 0) {
            e.a().b(new d() { // from class: com.ss.android.downloadlib.b.a.3
                @Override // com.ss.android.downloadlib.b.d
                public void a(boolean z2) {
                    if (!z2 && !"open_market".equals(str)) {
                        Context context = com.ss.android.downloadlib.addownload.j.getContext();
                        StringBuilder sbR = c.a.a.a.a.r(BaseConstants.MARKET_PREFIX);
                        sbR.append(eVar.e());
                        a.a(com.ss.android.downloadlib.g.i.a(context, Uri.parse(sbR.toString())), eVar, false);
                    }
                    com.ss.android.downloadlib.d.a.a().a(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, eVar);
                    if (z2) {
                        r rVarT = com.ss.android.downloadlib.addownload.j.t();
                        Context context2 = com.ss.android.downloadlib.addownload.j.getContext();
                        com.ss.android.downloadlib.addownload.b.e eVar2 = eVar;
                        DownloadModel downloadModel = eVar2.f3052b;
                        rVarT.a(context2, downloadModel, eVar2.f3054d, eVar2.f3053c, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.ss.android.download.api.config.c cVarB = com.ss.android.downloadlib.addownload.j.b();
            Context context = com.ss.android.downloadlib.addownload.j.getContext();
            DownloadModel downloadModel = eVar.f3052b;
            cVarB.a(context, downloadModel, eVar.f3054d, eVar.f3053c, downloadModel.getPackageName(), str);
        }
        com.ss.android.downloadad.api.a.b bVar = new com.ss.android.downloadad.api.a.b(eVar.f3052b, eVar.f3053c, eVar.f3054d);
        bVar.e(2);
        bVar.f(System.currentTimeMillis());
        bVar.h(4);
        bVar.i(2);
        com.ss.android.downloadlib.addownload.b.f.a().a(bVar);
    }

    public static void a(com.ss.android.downloadlib.addownload.b.g gVar, com.ss.android.downloadlib.addownload.b.e eVar, boolean z) {
        String strA = l.a(gVar.b(), "open_market");
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "ttdownloader_type", "backup");
        int type = gVar.getType();
        if (type == 5) {
            a(strA, jSONObject, eVar, z);
        } else {
            if (type != 6) {
                return;
            }
            l.a(jSONObject, "error_code", Integer.valueOf(gVar.a()));
            l.a(jSONObject, "download_scene", Integer.valueOf(eVar.t()));
            com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
        }
    }

    public static boolean a(long j2) {
        return com.ss.android.downloadlib.addownload.b.f.a().d(j2) == null;
    }
}
