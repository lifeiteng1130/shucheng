package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class TTAdConfig implements AdConfig {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f1646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1650i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f1651j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1652k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f1653l;
    private String[] m;
    private boolean n;
    private Map<String, Object> o;
    private TTCustomController p;
    private int q;

    public static class Builder {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f1654b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f1656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f1657e;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int[] f1662j;
        private String[] m;
        private TTCustomController o;
        private int p;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1655c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1658f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f1659g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f1660h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f1661i = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f1663k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f1664l = false;
        private boolean n = false;
        private int q = 2;

        public Builder allowShowNotify(boolean z) {
            this.f1659g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f1661i = z;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f1654b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setAppName(this.f1654b);
            tTAdConfig.setPaid(this.f1655c);
            tTAdConfig.setKeywords(this.f1656d);
            tTAdConfig.setData(this.f1657e);
            tTAdConfig.setTitleBarTheme(this.f1658f);
            tTAdConfig.setAllowShowNotify(this.f1659g);
            tTAdConfig.setDebug(this.f1660h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f1661i);
            tTAdConfig.setDirectDownloadNetworkType(this.f1662j);
            tTAdConfig.setUseTextureView(this.f1663k);
            tTAdConfig.setSupportMultiProcess(this.f1664l);
            tTAdConfig.setNeedClearTaskReset(this.m);
            tTAdConfig.setAsyncInit(this.n);
            tTAdConfig.setCustomController(this.o);
            tTAdConfig.setThemeStatus(this.p);
            tTAdConfig.setExtra("plugin_update_conf", Integer.valueOf(this.q));
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.o = tTCustomController;
            return this;
        }

        public Builder data(String str) {
            this.f1657e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f1660h = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f1662j = iArr;
            return this;
        }

        public Builder keywords(String str) {
            this.f1656d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f1655c = z;
            return this;
        }

        public Builder setPluginUpdateConfig(int i2) {
            this.q = i2;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.f1664l = z;
            return this;
        }

        public Builder themeStatus(int i2) {
            this.p = i2;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.f1658f = i2;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.f1663k = z;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.f1643b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f1646e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f1651j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.o.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f1645d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String[] getNeedClearTaskReset() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public AdConfig.SdkInfo getSdkInfo() {
        return new AdConfig.SdkInfo() { // from class: com.bytedance.sdk.openadsdk.TTAdConfig.1
            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public boolean isPlugin() {
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String pluginName() {
                return TTAdConstant.BUILT_IN_PLUGIN_NAME;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public int sdkVersionCode() {
                return 4011;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String sdkVersionName() {
                return "4.0.1.1";
            }
        };
    }

    public int getThemeStatus() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f1647f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f1648g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.f1650i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAsyncInit() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f1649h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f1644c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.f1653l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.f1652k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object removeExtra(String str) {
        return this.o.remove(str);
    }

    public void setAllowShowNotify(boolean z) {
        this.f1648g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f1650i = z;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAppName(String str) {
        this.f1643b = str;
    }

    public void setAsyncInit(boolean z) {
        this.n = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.p = tTCustomController;
    }

    public void setData(String str) {
        this.f1646e = str;
    }

    public void setDebug(boolean z) {
        this.f1649h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f1651j = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.o.put(str, obj);
    }

    public void setKeywords(String str) {
        this.f1645d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.m = strArr;
    }

    public void setPaid(boolean z) {
        this.f1644c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.f1653l = z;
    }

    public void setThemeStatus(int i2) {
        this.q = i2;
    }

    public void setTitleBarTheme(int i2) {
        this.f1647f = i2;
    }

    public void setUseTextureView(boolean z) {
        this.f1652k = z;
    }

    private TTAdConfig() {
        this.f1644c = false;
        this.f1647f = 0;
        this.f1648g = true;
        this.f1649h = false;
        this.f1650i = false;
        this.f1652k = false;
        this.f1653l = false;
        this.n = false;
        this.o = new HashMap();
    }
}
