package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ifmvo.togetherad.gdt.other.NetworkRequestAsyncTask;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.a.a;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.b.j;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.i;
import j$.util.DesugarCollections;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTDownloadVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static volatile String a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ITTDownloadVisitor f1746c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Context f1748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> f1749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final com.ss.android.download.api.download.a.a f1750g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f1747d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1745b = true;

    /* JADX INFO: compiled from: TTDownloadVisitor.java */
    public static class e implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public i downloadWithConnection(int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) {
            final c.a aVarA = com.bytedance.sdk.openadsdk.downloadnew.c.a(str, list);
            if (aVarA != null) {
                return new i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.e.1
                    @Override // com.ss.android.socialbase.downloader.network.i
                    public InputStream a() {
                        return aVarA.a;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public int b() {
                        return aVarA.f1741c;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public void c() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.i
                    public void d() {
                        try {
                            aVarA.f1742d.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public String a(String str2) {
                        Map<String, String> map = aVarA.f1740b;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }
                };
            }
            return null;
        }
    }

    static {
        try {
            a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f1750g = new com.ss.android.download.api.download.a.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.6
            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.a.a
            public void b(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onInstalled");
                d.c(str);
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        com.ss.android.downloadad.api.a.b bVarA;
        JSONObject jSONObjectG;
        if (TextUtils.isEmpty(str) || (bVarA = f.a().a(str)) == null || (jSONObjectG = bVarA.g()) == null || e() == null) {
            return;
        }
        e().checkAutoControl(jSONObjectG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ITTDownloadVisitor e() {
        ITTDownloadVisitor iTTDownloadVisitor = f1746c;
        return iTTDownloadVisitor == null ? (ITTDownloadVisitor) TTAdSdk.getAdManager().getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.b.a(1)) : iTTDownloadVisitor;
    }

    private static Context getContext() {
        Context context = f1748e;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    /* JADX INFO: compiled from: TTDownloadVisitor.java */
    public static class a implements com.ss.android.download.api.config.f {
        private void c(com.ss.android.download.api.model.c cVar) {
            if (cVar == null) {
                return;
            }
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(cVar.b()).setExtJson(cVar.h()).setLabel(cVar.c());
            boolean z = "download_notification".equals(cVar.b()) || "landing_h5_download_ad_button".equals(cVar.b());
            if (d.e() != null) {
                d.e().executeLogUpload(label, z);
            }
        }

        @Override // com.ss.android.download.api.config.f
        public void a(com.ss.android.download.api.model.c cVar) {
            com.bytedance.sdk.openadsdk.api.b.d.a("LibEventLogger", "onV3Event");
            a(cVar, true);
        }

        @Override // com.ss.android.download.api.config.f
        public void b(com.ss.android.download.api.model.c cVar) {
            com.bytedance.sdk.openadsdk.api.b.d.a("LibEventLogger", "onEvent called");
            a(cVar, false);
            c(cVar);
        }

        private void a(com.ss.android.download.api.model.c cVar, boolean z) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (d.e() == null || (tTDownloadEventLogger = d.e().getTTDownloadEventLogger()) == null || cVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && d.e().isOpenSdkEvent(cVar.toString())) {
                return;
            }
            if (z) {
                tTDownloadEventLogger.onV3Event(d.b(cVar));
            } else {
                tTDownloadEventLogger.onEvent(d.b(cVar));
            }
        }
    }

    /* JADX INFO: compiled from: TTDownloadVisitor.java */
    public static class c implements h {
        @Override // com.ss.android.download.api.config.h
        public void a(Activity activity, int i2, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.h
        public void a(Activity activity, String[] strArr, final s sVar) {
            if (d.e() != null) {
                d.e().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.c.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.a(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.a();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.h
        public boolean a(Context context, String str) {
            if (d.e() != null) {
                return d.e().hasPermission(context, str);
            }
            return false;
        }
    }

    public static void a(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = f1747d;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (d.class) {
            if (!atomicBoolean.get()) {
                f1748e = context.getApplicationContext();
                if (e() != null) {
                    String strInitPath = e().initPath(f1745b);
                    if (!TextUtils.isEmpty(strInitPath)) {
                        a = strInitPath;
                    }
                }
                atomicBoolean.set(b(f1748e));
            }
        }
    }

    public static void b() {
        a().g();
        if (e() != null) {
            e().clearAllData(a);
        }
    }

    /* JADX INFO: compiled from: TTDownloadVisitor.java */
    public static class b implements g {
        private b() {
        }

        @Override // com.ss.android.download.api.config.g
        public void a(String str, String str2, Map<String, Object> map, final q qVar) {
            str.hashCode();
            int i2 = 0;
            if (!str.equals(NetworkRequestAsyncTask.REQUEST_METHOD) && str.equals("POST")) {
                i2 = 1;
            }
            if (d.e() != null) {
                d.e().execute(i2, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.b.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.a(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.a(str3);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.g
        public void a(String str, byte[] bArr, String str2, int i2, final q qVar) {
            if (d.e() != null) {
                d.e().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.b.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.a(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.a(str3);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.downloadnew.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTDownloadVisitor.java */
    public static class C0061d implements k {
        private final WeakReference<Context> a;

        public C0061d(Context context) {
            this.a = new WeakReference<>(context);
        }

        private DialogBuilder c(final com.ss.android.download.api.model.b bVar) {
            return DialogBuilder.builder().setTitle(bVar.f2904b).setMessage(bVar.f2905c).setNegativeBtnText(bVar.f2907e).setPositiveBtnText(bVar.f2906d).setIcon(bVar.f2909g).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.d.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.InterfaceC0074b interfaceC0074b = bVar.f2910h;
                    if (interfaceC0074b != null) {
                        interfaceC0074b.c(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    b.InterfaceC0074b interfaceC0074b = bVar.f2910h;
                    if (interfaceC0074b != null) {
                        try {
                            interfaceC0074b.b(dialogInterface);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    b.InterfaceC0074b interfaceC0074b = bVar.f2910h;
                    if (interfaceC0074b != null) {
                        interfaceC0074b.a(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.k
        public void a(int i2, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }

        @Override // com.ss.android.download.api.config.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AlertDialog b(com.ss.android.download.api.model.b bVar) {
            if (bVar != null && d.e() != null) {
                Context context = bVar.a;
                if (context != null && (context instanceof Activity)) {
                    return d.e().showDialogBySelf((Activity) bVar.a, bVar.f2912j == 1, c(bVar));
                }
                d.e().showDialogByDelegate(this.a, bVar.f2912j == 1, c(bVar));
            }
            return null;
        }
    }

    private static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        com.ss.android.download.api.a aVarA = com.ss.android.downloadlib.g.a(applicationContext).a();
        if (aVarA == null) {
            return false;
        }
        aVarA.a(new c()).a(new a()).a(new C0061d(applicationContext)).a(new b()).a(new com.ss.android.download.api.config.i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.3
            @Override // com.ss.android.download.api.config.i
            public JSONObject a() {
                return d.e() != null ? d.e().getDownloadSettings() : new JSONObject();
            }
        }).a(new com.ss.android.download.api.config.b() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.2
            @Override // com.ss.android.download.api.config.b
            public boolean a() {
                if (d.e() != null) {
                    return d.e().getAppIsBackground();
                }
                return false;
            }
        }).a(new a.C0073a().b("143").a(TTAdConstant.APP_NAME).c("4.0.1.1").d(String.valueOf(4011)).a()).a(new p() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.1
            @Override // com.ss.android.download.api.config.p
            public byte[] a(byte[] bArr, int i2) {
                return EncryptorUtil.encrypt(bArr, i2);
            }
        }).a(packageName + ".TTFileProvider").a(a(applicationContext, e() != null ? e().getDownloadSettings() : new JSONObject())).a();
        com.ss.android.downloadlib.g.a.a();
        com.ss.android.downloadlib.g.a(applicationContext).d().a(1);
        com.ss.android.downloadlib.g.a(applicationContext).a(f1750g);
        com.ss.android.socialbase.appdownloader.d.j().a(new ad() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.4
            @Override // com.ss.android.socialbase.downloader.depend.ad
            public boolean a(Intent intent) {
                return false;
            }
        });
        return true;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> c() {
        return f1749f;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a = str;
    }

    public static com.ss.android.downloadlib.g a() {
        a(getContext());
        return com.ss.android.downloadlib.g.a(getContext());
    }

    public static boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return a().e().a(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean a(Uri uri) {
        return j.a(uri);
    }

    public static void a(int i2) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = f1749f;
        if (map != null) {
            map.remove(Integer.valueOf(i2));
        }
    }

    public static void a(int i2, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (f1749f == null) {
                f1749f = DesugarCollections.synchronizedMap(new WeakHashMap());
            }
            f1749f.put(Integer.valueOf(i2), onEventLogHandler);
        }
    }

    public static boolean a(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> mapC;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (mapC = c()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : mapC.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean zOnEventLog = value.onEventLog(iIntValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !zOnEventLog) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject b(com.ss.android.download.api.model.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", cVar.a());
            jSONObject.put("tag", cVar.b());
            jSONObject.put(TTDownloadField.TT_LABEL, cVar.c());
            jSONObject.put("isAd", cVar.d());
            jSONObject.put("adId", cVar.e());
            jSONObject.put(TTDownloadField.TT_LOG_EXTRA, cVar.f());
            jSONObject.put("extValue", cVar.g());
            jSONObject.put("extJson", cVar.h());
            jSONObject.put("paramsJson", cVar.i());
            jSONObject.put("eventSource", cVar.k());
            jSONObject.put("extraObject", cVar.l());
            jSONObject.put("clickTrackUrl", cVar.j());
            jSONObject.put("isV3", cVar.m());
            jSONObject.put("V3EventName", cVar.n());
            jSONObject.put("V3EventParams", cVar.o());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static DownloaderBuilder a(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new aa() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.5
            @Override // com.ss.android.socialbase.downloader.depend.aa
            public JSONObject a() {
                return d.e() != null ? d.e().getDownloadSettings() : new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new e());
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> listB = com.ss.android.socialbase.appdownloader.d.j().b(context);
            if (!listB.isEmpty()) {
                for (DownloadInfo downloadInfo : listB) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.a.a.a().a(activity, false, new a.InterfaceC0079a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.7
            @Override // com.ss.android.downloadlib.addownload.a.a.InterfaceC0079a
            public void a() {
                ExitInstallListener exitInstallListener2 = exitInstallListener;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
