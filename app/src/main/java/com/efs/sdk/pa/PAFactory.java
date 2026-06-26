package com.efs.sdk.pa;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.pa.config.ConfigManager;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class PAFactory {
    private static final long DEFAULT_TIME_OUT_TIME = 2000;
    private static final long INVALID_TIME_OUT_TIME = 0;
    private static final long MAX_TIME_OUT_TIME = 4000;
    private static final String TAG = "pafactory";
    public static final ThreadLocal<PA> sThreadLocal = new ThreadLocal<>();
    private ConfigManager mConfigManager;
    private Context mContext;
    private HashMap<String, String> mExtend;
    private EfsReporter mReporter;
    private IEfsReporter mReporterFactory;
    private String mSerial;
    private String mSver;
    private long mTimeOutTime;
    private PATraceListener mTraceListener;

    public static class Builder {
        private PackageLevel a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IEfsReporter f1864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f1866d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f1867e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private HashMap<String, String> f1868f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f1869g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f1870h = PAFactory.DEFAULT_TIME_OUT_TIME;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private PATraceListener f1871i;

        public Builder(Context context, IEfsReporter iEfsReporter) {
            if (context == null) {
                throw new RuntimeException("context Should Not null");
            }
            if (iEfsReporter == null) {
                throw new RuntimeException("reporter Should Not Empty");
            }
            this.f1864b = iEfsReporter;
            this.f1866d = context;
        }

        public PAFactory build() {
            if (this.a != null) {
                return new PAFactory(this.f1866d, this.a, this.f1864b, this.f1865c, this.f1867e, this.f1868f, this.f1869g, this.f1870h, this.f1871i);
            }
            throw new RuntimeException(String.format("%s Should Not Null", ""));
        }

        public Builder extendLogInfo(HashMap<String, String> map) {
            this.f1868f = map;
            return this;
        }

        public Builder isNewInstall(boolean z) {
            this.f1865c = z;
            return this;
        }

        public Builder packageLevel(PackageLevel packageLevel) {
            this.a = packageLevel;
            return this;
        }

        public Builder serial(String str) {
            this.f1867e = str;
            return this;
        }

        public Builder sver(String str) {
            this.f1869g = str;
            return this;
        }

        public Builder timeoutTime(long j2) {
            if (j2 <= 0) {
                this.f1870h = PAFactory.DEFAULT_TIME_OUT_TIME;
            } else {
                if (j2 > PAFactory.MAX_TIME_OUT_TIME) {
                    this.f1870h = PAFactory.DEFAULT_TIME_OUT_TIME;
                    return this;
                }
                this.f1870h = j2;
            }
            return this;
        }

        public Builder traceListener(PATraceListener pATraceListener) {
            this.f1871i = pATraceListener;
            return this;
        }
    }

    public ConfigManager getConfigManager() {
        return this.mConfigManager;
    }

    public HashMap<String, String> getExtend() {
        return this.mExtend;
    }

    public synchronized PA getPaInstance() {
        PA cVar;
        ThreadLocal<PA> threadLocal = sThreadLocal;
        cVar = threadLocal.get();
        if (cVar == null) {
            cVar = new com.efs.sdk.pa.a.c(this.mConfigManager.enableTracer());
            cVar.registerPAANRListener(this.mContext, new a(this), this.mTimeOutTime);
            threadLocal.set(cVar);
        }
        return cVar;
    }

    public EfsReporter getReporter() {
        if (this.mReporter == null) {
            IEfsReporter iEfsReporter = this.mReporterFactory;
            this.mReporter = iEfsReporter != null ? iEfsReporter.getReporter() : null;
        }
        return this.mReporter;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public String getSver() {
        return this.mSver;
    }

    public PATraceListener getTraceListener() {
        return this.mTraceListener;
    }

    private PAFactory(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z, String str, HashMap<String, String> map, String str2, long j2, PATraceListener pATraceListener) {
        this.mReporterFactory = iEfsReporter;
        this.mSerial = str;
        this.mExtend = map;
        this.mSver = str2;
        this.mContext = context;
        this.mTraceListener = pATraceListener;
        this.mTimeOutTime = j2;
        this.mConfigManager = new ConfigManager(context, packageLevel, iEfsReporter, z);
    }
}
