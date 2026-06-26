package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX INFO: compiled from: SimpleDownloadEventConfig.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class c implements DownloadEventConfig {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f2881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f2882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f2883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f2884l;
    private boolean m;
    private boolean n;
    private boolean o;
    private String p;
    private String q;

    /* JADX INFO: compiled from: SimpleDownloadEventConfig.java */
    public static final class a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f2886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f2887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f2888e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2889f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f2890g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f2891h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f2892i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f2893j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f2894k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Object f2895l;
        private boolean m;
        private boolean n;
        private boolean o;
        private String p;
        private String q;

        public c a() {
            return new c(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.a;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f2878f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f2879g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f2875c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f2877e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f2876d;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.f2884l;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.q;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.f2882j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f2874b;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.m;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i2) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public c() {
    }

    private c(a aVar) {
        this.a = aVar.a;
        this.f2874b = aVar.f2885b;
        this.f2875c = aVar.f2886c;
        this.f2876d = aVar.f2887d;
        this.f2877e = aVar.f2888e;
        this.f2878f = aVar.f2889f;
        this.f2879g = aVar.f2890g;
        this.f2880h = aVar.f2891h;
        this.f2881i = aVar.f2892i;
        this.f2882j = aVar.f2893j;
        this.f2883k = aVar.f2894k;
        this.f2884l = aVar.f2895l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
    }
}
