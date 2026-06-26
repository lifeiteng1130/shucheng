package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.c;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.g;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonDownloadHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements f, m.a {
    private static final String a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f3122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f3123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f3124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f3125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Integer, Object> f3126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DownloadShortInfo f3127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DownloadInfo f3128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f3129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final IDownloadListener f3130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f3132l;
    private long m;
    private DownloadModel n;
    private DownloadEventConfig o;
    private DownloadController p;
    private SoftReference<u> q;
    private boolean r;
    private final boolean s;
    private SoftReference<IDownloadButtonClickListener> t;

    /* JADX INFO: compiled from: CommonDownloadHandler.java */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: CommonDownloadHandler.java */
    public interface b {
        void a(long j2);
    }

    public e() {
        m mVar = new m(Looper.getMainLooper(), this);
        this.f3122b = mVar;
        this.f3126f = new ConcurrentHashMap();
        this.f3130j = new g.a(mVar);
        this.m = -1L;
        this.n = null;
        this.o = null;
        this.p = null;
        this.f3123c = new g(this);
        this.f3124d = new d(mVar);
        this.s = com.ss.android.socialbase.downloader.g.a.c().a("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.f3125e;
        return (weakReference == null || weakReference.get() == null) ? j.getContext() : this.f3125e.get();
    }

    private void j() {
        SoftReference<u> softReference = this.q;
        if (softReference == null || softReference.get() == null) {
            j.b().a(getContext(), this.n, l(), k());
        } else {
            this.q.get().a(this.n, k(), l());
            this.q = null;
        }
    }

    @NonNull
    private DownloadEventConfig k() {
        DownloadEventConfig downloadEventConfig = this.o;
        return downloadEventConfig == null ? new c.a().a() : downloadEventConfig;
    }

    @NonNull
    private DownloadController l() {
        if (this.p == null) {
            this.p = new com.ss.android.download.api.download.b();
        }
        return this.p;
    }

    private void m() {
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "pICD", null);
        if (this.f3123c.d(this.f3128h)) {
            com.ss.android.downloadlib.g.k.a(str, "pICD BC", null);
            e(false);
        } else {
            com.ss.android.downloadlib.g.k.a(str, "pICD IC", null);
            j();
        }
    }

    private boolean n() {
        if (!com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            DownloadInfo downloadInfo = this.f3128h;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || Downloader.getInstance(j.getContext()).canResume(this.f3128h.getId())) || this.f3128h.getStatus() == 0;
        }
        DownloadInfo downloadInfo2 = this.f3128h;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.f3128h.getCurBytes() <= 0) || this.f3128h.getStatus() == 0 || this.f3128h.getStatus() == -4) {
            return true;
        }
        return com.ss.android.socialbase.downloader.i.f.a(this.f3128h.getStatus(), this.f3128h.getSavePath(), this.f3128h.getName());
    }

    private void o() {
        c cVar = this.f3129i;
        if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f3129i.cancel(true);
        }
        c cVar2 = new c();
        this.f3129i = cVar2;
        com.ss.android.downloadlib.g.b.a(cVar2, this.n.getDownloadUrl(), this.n.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo p() {
        if (this.f3127g == null) {
            this.f3127g = new DownloadShortInfo();
        }
        return this.f3127g;
    }

    private boolean q() {
        SoftReference<IDownloadButtonClickListener> softReference = this.t;
        if (softReference == null || softReference.get() == null) {
            com.ss.android.downloadlib.e.c.a().b("mDownloadButtonClickListener has recycled");
            return false;
        }
        this.t.get().handleComplianceDialog(true);
        this.t = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        Iterator<DownloadStatusChangeListener> it = g.a(this.f3126f).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.n, l());
        }
        int iA = this.f3123c.a(j.getContext(), this.f3130j);
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "beginDown id:" + iA, null);
        if (iA == 0) {
            DownloadInfo downloadInfoA = new DownloadInfo.a(this.n.getDownloadUrl()).a();
            downloadInfoA.setStatus(-1);
            a(downloadInfoA);
            com.ss.android.downloadlib.d.a.a().a(this.m, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.e.c.a().b("beginDown");
        } else if (this.f3128h != null && !com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            this.f3123c.a(this.f3128h, false);
        } else if (z) {
            this.f3123c.a();
        }
        if (this.f3123c.a(c())) {
            com.ss.android.downloadlib.g.k.a(str, "beginDown IC id:" + iA, null);
            j();
        }
    }

    public boolean c() {
        DownloadInfo downloadInfo = this.f3128h;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public long d() {
        return this.f3132l;
    }

    public boolean e() {
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && this.n.getQuickAppModel() != null && !TextUtils.isEmpty(this.n.getQuickAppModel().a()) && com.ss.android.downloadlib.addownload.c.a(this.f3128h) && com.ss.android.downloadlib.g.l.a(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.n.getQuickAppModel().a())));
    }

    public void f() {
        this.f3122b.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.e.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = g.a((Map<Integer, Object>) e.this.f3126f).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(e.this.p());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void h() {
        com.ss.android.downloadlib.addownload.b.f.a().f(this.m);
    }

    private boolean c(int i2) {
        if (!e()) {
            return false;
        }
        int i3 = -1;
        String strA = this.n.getQuickAppModel().a();
        if (i2 == 1) {
            i3 = 5;
        } else if (i2 == 2) {
            i3 = 4;
        }
        DownloadModel downloadModel = this.n;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean zC = com.ss.android.downloadlib.g.i.c(j.getContext(), strA);
        if (zC) {
            com.ss.android.downloadlib.d.a.a().a(this.m, i2);
            Message messageObtain = Message.obtain();
            messageObtain.what = i3;
            messageObtain.obj = Long.valueOf(this.n.getId());
            com.ss.android.downloadlib.addownload.c.a().a(this, i3, this.n);
        } else {
            com.ss.android.downloadlib.d.a.a().a(this.m, false, 0);
        }
        return zC;
    }

    private void d(boolean z) {
        if (com.ss.android.downloadlib.g.e.b(this.n).b("notification_opt_2") == 1 && this.f3128h != null) {
            com.ss.android.socialbase.downloader.notification.b.a().f(this.f3128h.getId());
        }
        e(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z) {
        this.f3124d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, k(), l()));
        this.f3124d.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.addownload.e.5
            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (e.this.f3124d.a()) {
                    return;
                }
                e.this.g(z);
            }
        });
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(Context context) {
        if (context != null) {
            this.f3125e = new WeakReference<>(context);
        }
        j.b(context);
        return this;
    }

    /* JADX INFO: compiled from: CommonDownloadHandler.java */
    public class c extends AsyncTask<String, Void, DownloadInfo> {
        private c() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = strArr[0];
            if (e.this.n != null && !TextUtils.isEmpty(e.this.n.getFilePath())) {
                downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(str, e.this.n.getFilePath());
            }
            return downloadInfo == null ? com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), str) : downloadInfo;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || e.this.n == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.b.c cVarA = com.ss.android.downloadlib.g.l.a(e.this.n.getPackageName(), e.this.n.getVersionCode(), e.this.n.getVersionName());
                com.ss.android.downloadlib.addownload.b.h.a().a(e.this.n.getVersionCode(), cVarA.b(), com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo));
                boolean zA = cVarA.a();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (zA || !Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(j.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (e.this.f3128h == null || e.this.f3128h.getStatus() != -4) {
                        e.this.f3128h = downloadInfo;
                        if (e.this.s) {
                            Downloader.getInstance(j.getContext()).setMainThreadListener(e.this.f3128h.getId(), e.this.f3130j, false);
                        } else {
                            Downloader.getInstance(j.getContext()).setMainThreadListener(e.this.f3128h.getId(), e.this.f3130j);
                        }
                    } else {
                        e.this.f3128h = null;
                    }
                    e.this.f3123c.a(e.this.f3128h, e.this.p(), g.a((Map<Integer, Object>) e.this.f3126f));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                        e.this.f3128h = null;
                    }
                    if (e.this.f3128h != null) {
                        Downloader.getInstance(j.getContext()).removeTaskMainListener(e.this.f3128h.getId());
                        if (e.this.s) {
                            Downloader.getInstance(e.this.getContext()).setMainThreadListener(e.this.f3128h.getId(), e.this.f3130j, false);
                        } else {
                            Downloader.getInstance(e.this.getContext()).setMainThreadListener(e.this.f3128h.getId(), e.this.f3130j);
                        }
                    }
                    if (!zA) {
                        Iterator<DownloadStatusChangeListener> it = g.a((Map<Integer, Object>) e.this.f3126f).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        e.this.f3128h = null;
                    } else {
                        e eVar = e.this;
                        eVar.f3128h = new DownloadInfo.a(eVar.n.getDownloadUrl()).a();
                        e.this.f3128h.setStatus(-3);
                        e.this.f3123c.a(e.this.f3128h, e.this.p(), g.a((Map<Integer, Object>) e.this.f3126f));
                    }
                }
                e.this.f3123c.c(e.this.f3128h);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void e(final boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "pBCD", null);
        if (n()) {
            com.ss.android.downloadlib.addownload.b.e eVarE = com.ss.android.downloadlib.addownload.b.f.a().e(this.m);
            DownloadInfo downloadInfo = this.f3128h;
            if (downloadInfo != null && downloadInfo.getStatus() != 0) {
                a(z, true);
                return;
            }
            if (this.r) {
                if (this.n.isAd() && this.t != null) {
                    if (q() && (downloadController2 = eVarE.f3054d) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        a(z, true);
                        return;
                    }
                    return;
                }
                a(z, true);
                return;
            }
            if (this.n.isAd() && (downloadController = eVarE.f3054d) != null && downloadController.enableShowComplianceDialog() && eVarE.f3052b != null && com.ss.android.downloadlib.addownload.compliance.b.a().a(eVarE.f3052b) && com.ss.android.downloadlib.addownload.compliance.b.a().a(eVarE)) {
                return;
            }
            a(z, true);
            return;
        }
        StringBuilder sbR = c.a.a.a.a.r("pBCD continue download, status:");
        sbR.append(this.f3128h.getStatus());
        com.ss.android.downloadlib.g.k.a(str, sbR.toString(), null);
        DownloadInfo downloadInfo2 = this.f3128h;
        if (downloadInfo2 != null && (downloadModel = this.n) != null) {
            downloadInfo2.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.f3128h.getStatus();
        final int id = this.f3128h.getId();
        final com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(this.f3128h);
        if (status != -2 && status != -1) {
            if (l.a(status)) {
                if (this.n.enablePause()) {
                    this.f3124d.a(true);
                    com.ss.android.downloadlib.c.h.a().b(com.ss.android.downloadlib.addownload.b.f.a().d(this.m));
                    com.ss.android.downloadlib.addownload.d.f.a().a(bVarA, status, new com.ss.android.downloadlib.addownload.d.c() { // from class: com.ss.android.downloadlib.addownload.e.3
                        @Override // com.ss.android.downloadlib.addownload.d.c
                        public void a(com.ss.android.downloadad.api.a.b bVar) {
                            e.this.f3123c.a(e.this.f3128h, z);
                            if (com.ss.android.socialbase.downloader.i.f.b(j.getContext()) && e.this.f3128h.isPauseReserveOnWifi()) {
                                e.this.f3128h.stopPauseReserveOnWifi();
                                com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel_on_wifi", bVarA);
                            } else {
                                e eVar = e.this;
                                eVar.a(id, status, eVar.f3128h);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.f3123c.a(this.f3128h, z);
            a(id, status, this.f3128h);
            return;
        }
        this.f3123c.a(this.f3128h, z);
        if (bVarA != null) {
            bVarA.h(System.currentTimeMillis());
            bVarA.i(this.f3128h.getCurBytes());
        }
        this.f3128h.setDownloadFromReserveWifi(false);
        this.f3124d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, k(), l()));
        this.f3124d.a(id, this.f3128h.getCurBytes(), this.f3128h.getTotalBytes(), new a() { // from class: com.ss.android.downloadlib.addownload.e.2
            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (e.this.f3124d.a()) {
                    return;
                }
                e eVar = e.this;
                eVar.a(id, status, eVar.f3128h);
            }
        });
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(int i2, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (j.i().optInt("back_use_softref_listener") == 1) {
                this.f3126f.put(Integer.valueOf(i2), downloadStatusChangeListener);
            } else {
                this.f3126f.put(Integer.valueOf(i2), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean b() {
        return this.f3131k;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void b(int i2) {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.f3123c.a(this.m);
        if (!com.ss.android.downloadlib.addownload.b.f.a().e(this.m).y()) {
            com.ss.android.downloadlib.e.c.a().a("handleDownload ModelBox !isStrictValid");
        }
        if (this.f3123c.a(getContext(), i2, this.r)) {
            return;
        }
        boolean zC = c(i2);
        if (i2 == 1) {
            if (zC) {
                return;
            }
            String str = a;
            StringBuilder sbR = c.a.a.a.a.r("handleDownload id:");
            sbR.append(this.m);
            sbR.append(",pIC:");
            com.ss.android.downloadlib.g.k.a(str, sbR.toString(), null);
            c(true);
            return;
        }
        if (i2 == 2 && !zC) {
            String str2 = a;
            StringBuilder sbR2 = c.a.a.a.a.r("handleDownload id:");
            sbR2.append(this.m);
            sbR2.append(",pBC:");
            com.ss.android.downloadlib.g.k.a(str2, sbR2.toString(), null);
            b(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.e.c.a().a("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.e.c.a().a(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.g.a.c().a("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.b.f.a().a(downloadModel);
            this.m = downloadModel.getId();
            this.n = downloadModel;
            if (h.a(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.a.b bVarD = com.ss.android.downloadlib.addownload.b.f.a().d(this.m);
                if (bVarD != null && bVarD.l() != 3) {
                    bVarD.e(3L);
                    com.ss.android.downloadlib.addownload.b.i.a().a(bVarD);
                }
            }
        }
        return this;
    }

    public void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(this.m, 1);
        }
        m();
    }

    public void g() {
        if (this.f3126f.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = g.a(this.f3126f).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.f3128h;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    public void b(boolean z) {
        d(z);
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(DownloadController downloadController) {
        JSONObject extra;
        this.p = downloadController;
        if (com.ss.android.downloadlib.g.e.b(this.n).b("force_auto_open") == 1) {
            l().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_show_dialog") && (extra = this.n.getExtra()) != null && extra.optInt("subprocess") > 0) {
            l().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(DownloadEventConfig downloadEventConfig) {
        this.o = downloadEventConfig;
        this.r = k().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, k());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(u uVar) {
        if (uVar == null) {
            this.q = null;
        } else {
            this.q = new SoftReference<>(uVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a() {
        this.f3131k = true;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, k());
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
        this.f3123c.a(this.m);
        o();
        if (j.i().optInt("enable_empty_listener", 1) == 1 && this.f3126f.get(Integer.MIN_VALUE) == null) {
            b(Integer.MIN_VALUE, new com.ss.android.download.api.config.a());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean a(int i2) {
        if (i2 == 0) {
            this.f3126f.clear();
        } else {
            this.f3126f.remove(Integer.valueOf(i2));
        }
        if (this.f3126f.isEmpty()) {
            this.f3131k = false;
            this.f3132l = System.currentTimeMillis();
            if (this.f3128h != null) {
                Downloader.getInstance(j.getContext()).removeTaskMainListener(this.f3128h.getId());
            }
            c cVar = this.f3129i;
            if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f3129i.cancel(true);
            }
            this.f3123c.a(this.f3128h);
            String str = a;
            StringBuilder sbR = c.a.a.a.a.r("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f3128h;
            sbR.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.g.k.a(str, sbR.toString(), null);
            this.f3122b.removeCallbacksAndMessages(null);
            this.f3127g = null;
            this.f3128h = null;
            return true;
        }
        if (this.f3126f.size() == 1 && this.f3126f.containsKey(Integer.MIN_VALUE)) {
            this.f3123c.b(this.f3128h);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a(boolean z) {
        if (this.f3128h != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d dVarB = com.ss.android.socialbase.appdownloader.d.j().b();
                if (dVarB != null) {
                    dVarB.a(this.f3128h);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(this.f3128h.getId(), true);
                return;
            }
            Intent intent = new Intent(j.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f3128h.getId());
            j.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(long j2) {
        if (j2 != 0) {
            DownloadModel downloadModelA = com.ss.android.downloadlib.addownload.b.f.a().a(j2);
            if (downloadModelA != null) {
                this.n = downloadModelA;
                this.m = j2;
                this.f3123c.a(j2);
            }
        } else {
            com.ss.android.downloadlib.e.c.a().a(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
        if (message != null && this.f3131k && message.what == 3) {
            this.f3128h = (DownloadInfo) message.obj;
            this.f3123c.a(message, p(), this.f3126f);
        }
    }

    public void a(boolean z, final boolean z2) {
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(this.m, 2);
        }
        if (!com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE") && !l().enableNewActivity()) {
            this.n.setFilePath(this.f3123c.b());
        }
        if (com.ss.android.downloadlib.g.e.c(this.n) == 0) {
            com.ss.android.downloadlib.g.k.a(a, "pBCD not start", null);
            this.f3123c.a(new s() { // from class: com.ss.android.downloadlib.addownload.e.4
                @Override // com.ss.android.download.api.config.s
                public void a() {
                    com.ss.android.downloadlib.g.k.a(e.a, "pBCD start download", null);
                    e.this.f(z2);
                }

                @Override // com.ss.android.download.api.config.s
                public void a(String str) {
                    com.ss.android.downloadlib.g.k.a(e.a, "pBCD onDenied", null);
                }
            });
        } else {
            f(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, @NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            if (i3 != -3 && !com.ss.android.socialbase.downloader.downloader.d.a().e(i2)) {
                a(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i2, i3);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i2, i3);
    }

    private void a(DownloadInfo downloadInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = downloadInfo;
        this.f3122b.sendMessage(messageObtain);
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.t = null;
        } else {
            this.t = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
