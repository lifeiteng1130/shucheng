package com.bytedance.pangle;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.PluginProvider;
import com.bytedance.pangle.util.Lazy;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ZeusParam {
    private int mAppId;
    private String mAppKey;
    private String mAppName;
    private String mAppSecretKey;
    private boolean mAutoFetch;
    private String mChannel;
    private boolean mCheckMatchHostAbi;
    private boolean mCheckPermission;
    private boolean mCloseDefaultReport;
    private boolean mDebug;
    private boolean mEnable;
    private boolean mFastDex2Oat;
    private String mHost;
    private long mHostVersionCode;
    private String mHostVersionName;
    private int mInstallThreads;
    private Lazy<String> mLazyDid;
    private IZeusLogger mLogger;
    private PluginProvider mPluginProvider;
    private IZeusReporter mReporter;
    private ApkVerifier mVerifier;

    @Keep
    public static class Builder {
        private int mAppId;
        private String mAppKey;
        private String mAppSecretKey;
        private String mChannel;
        private boolean mCloseDefaultReport;
        private boolean mFastDex2Oat;
        private String mHost;
        private Lazy<String> mLazyDid;
        private IZeusLogger mLogger;
        private PluginProvider mPluginProvider;
        private IZeusReporter mReporter;
        private ApkVerifier mVerifier;
        private boolean mEnable = true;
        private boolean mDebug = true;
        private boolean mAutoFetch = true;
        private boolean mCheckMatchHostAbi = true;
        private boolean mCheckPermission = true;
        private int mInstallThreads = 4;

        public Builder appId(int i2) {
            this.mAppId = i2;
            return this;
        }

        public Builder appKey(String str) {
            this.mAppKey = str;
            return this;
        }

        public Builder appSecretKey(String str) {
            this.mAppSecretKey = str;
            return this;
        }

        public Builder autoFetch(boolean z) {
            this.mAutoFetch = z;
            return this;
        }

        public ZeusParam build() {
            ZeusParam zeusParam = new ZeusParam();
            zeusParam.mEnable = this.mEnable;
            zeusParam.mDebug = this.mDebug;
            zeusParam.mAutoFetch = this.mAutoFetch;
            zeusParam.mFastDex2Oat = this.mFastDex2Oat;
            zeusParam.mCheckMatchHostAbi = this.mCheckMatchHostAbi;
            zeusParam.mCheckPermission = this.mCheckPermission;
            zeusParam.mInstallThreads = this.mInstallThreads;
            zeusParam.mChannel = this.mChannel;
            zeusParam.mAppId = this.mAppId;
            zeusParam.mHost = this.mHost;
            zeusParam.mAppKey = this.mAppKey;
            zeusParam.mAppSecretKey = this.mAppSecretKey;
            zeusParam.mLazyDid = this.mLazyDid;
            zeusParam.mLogger = this.mLogger;
            zeusParam.mReporter = this.mReporter;
            zeusParam.mVerifier = this.mVerifier;
            zeusParam.mPluginProvider = this.mPluginProvider;
            zeusParam.mCloseDefaultReport = this.mCloseDefaultReport;
            return zeusParam;
        }

        public Builder channel(String str) {
            this.mChannel = str;
            return this;
        }

        public Builder closeDefaultReport(boolean z) {
            this.mCloseDefaultReport = z;
            return this;
        }

        public Builder did(Lazy<String> lazy) {
            this.mLazyDid = lazy;
            return this;
        }

        public Builder host(String str) {
            this.mHost = str;
            return this;
        }

        public Builder logger(IZeusLogger iZeusLogger) {
            this.mLogger = iZeusLogger;
            return this;
        }

        public Builder pluginProvider(PluginProvider pluginProvider) {
            this.mPluginProvider = pluginProvider;
            return this;
        }

        public Builder reporter(IZeusReporter iZeusReporter) {
            this.mReporter = iZeusReporter;
            return this;
        }

        public Builder verifyWith(ApkVerifier apkVerifier) {
            this.mVerifier = apkVerifier;
            return this;
        }

        public Builder withCheckMatchHostAbiByInstall(boolean z) {
            this.mCheckMatchHostAbi = z;
            return this;
        }

        public Builder withCheckPermission(boolean z) {
            this.mCheckPermission = z;
            return this;
        }

        @Deprecated
        public Builder withCustomHook(boolean z) {
            return this;
        }

        public Builder withDebug(boolean z) {
            this.mDebug = z;
            return this;
        }

        public Builder withEnable(boolean z) {
            this.mEnable = z;
            return this;
        }

        public Builder withFastDex2Oat(boolean z) {
            this.mFastDex2Oat = z;
            return this;
        }

        public Builder withInstallThreads(int i2) {
            this.mInstallThreads = i2;
            return this;
        }

        @Deprecated
        public Builder withSupportStandalonePlugin(boolean z) {
            return this;
        }
    }

    public boolean autoFetch() {
        return this.mAutoFetch;
    }

    public boolean checkMatchHostAbi() {
        return this.mCheckMatchHostAbi;
    }

    public boolean checkPermission() {
        return this.mCheckPermission;
    }

    public boolean fastDex2Oat() {
        return this.mFastDex2Oat;
    }

    public int getAppId() {
        return this.mAppId;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppName() {
        if (TextUtils.isEmpty(this.mAppName)) {
            try {
                this.mAppName = (String) Zeus.getAppApplication().getPackageManager().getApplicationLabel(Zeus.getAppApplication().getApplicationInfo());
            } catch (Throwable unused) {
            }
        }
        return this.mAppName;
    }

    public String getAppSecretKey() {
        return this.mAppSecretKey;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public Lazy<String> getDid() {
        return this.mLazyDid;
    }

    public String getHost() {
        return this.mHost;
    }

    public long getHostVersionCode() {
        if (this.mHostVersionCode == -1) {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0);
                if (Build.VERSION.SDK_INT >= 28) {
                    this.mHostVersionCode = packageInfo.getLongVersionCode();
                } else {
                    this.mHostVersionCode = packageInfo.versionCode;
                }
            } catch (Throwable unused) {
            }
        }
        return this.mHostVersionCode;
    }

    public String getHostVersionName() {
        if (TextUtils.isEmpty(this.mHostVersionName)) {
            try {
                this.mHostVersionName = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).versionName;
            } catch (Throwable unused) {
            }
        }
        return this.mHostVersionName;
    }

    public int getInstallThreads() {
        return this.mInstallThreads;
    }

    public IZeusLogger getLogger() {
        return this.mLogger;
    }

    public PluginProvider getPluginProvider() {
        return this.mPluginProvider;
    }

    public IZeusReporter getReporter() {
        return this.mReporter;
    }

    public ApkVerifier getVerifier() {
        return this.mVerifier;
    }

    public boolean isCloseDefaultReport() {
        return this.mCloseDefaultReport;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public String toString() {
        return "ZeusParam{mEnable=" + this.mEnable + ", mDebug=" + this.mDebug + ", mFastDex2Oat=" + this.mFastDex2Oat + ", mInstallThreads=" + this.mInstallThreads + ", mCheckMatchHostAbi=" + this.mCheckMatchHostAbi + MessageFormatter.DELIM_STOP;
    }

    private ZeusParam() {
        this.mHostVersionCode = -1L;
        this.mInstallThreads = 4;
    }
}
