package com.efs.sdk.pa.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import com.efs.sdk.base.observer.IConfigCallback;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class ConfigManager {
    private static final int A_DAY = 86400000;
    public static final String FLAG_PA_CHECK_IN_STATE = "8f2f54c08600aa25915617fa1371441b";
    public static final String FLAG_PA_FORE_CHECK_TIME = "03f870871950c148387b251894ed3e88";
    private static final int MAX_ANR_STATS_COUNT = 50;
    private static final int MAX_ANR_TRACE_RATE = 100;
    private static final String MODEL_SP = "paconfig";
    public static final String PA_LEVEL = "pa_level";
    private static final String STATS_ANR_LOG_COUNT = "apm_anr_count";
    private boolean mCheckIn;
    private int mCurrentRate;
    private IEfsReporter mEfsReporter;
    private int mLastRate;
    private PackageLevel mPackageLevel;
    private SharedPreferences mSharedPreferences;
    private final String TAG = "WpkPaConfig";
    private final String APM_PATRACE_SWITCH_RATE_LAST = "apm_patrace_switch_rate_last";
    private final String APM_PATRACE_SWITCH_RATE_CURRENT = "apm_patrace_switch_rate";
    private final int DEF_CLOSE_RATE = 0;

    public ConfigManager(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z) {
        boolean zEnableAnrTracer = false;
        this.mCheckIn = false;
        this.mPackageLevel = packageLevel;
        this.mEfsReporter = iEfsReporter;
        this.mSharedPreferences = SharedPreferencesUtils.getSharedPreferences(context, MODEL_SP);
        initRate();
        if (z) {
            resetUploadSmoothLogCnt();
            zEnableAnrTracer = enableAnrTracer();
        } else if (isCountEnable() && enableAnrTracer()) {
            zEnableAnrTracer = true;
        }
        this.mCheckIn = zEnableAnrTracer;
        resetRate();
    }

    private boolean checkIn(boolean z, Long l2, boolean z2, int i2) {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Long lValueOf2 = Long.valueOf(lValueOf.longValue() - l2.longValue());
        if (z2 && lValueOf2.longValue() < 86400000 && !z) {
            return true;
        }
        if (lValueOf2.longValue() < 86400000 && !z) {
            return false;
        }
        boolean z3 = random(i2);
        putBooleanValue(FLAG_PA_CHECK_IN_STATE, z3);
        putLongValue(FLAG_PA_FORE_CHECK_TIME, lValueOf.longValue());
        return z3;
    }

    private boolean enableAnrTracer() {
        long j2 = this.mSharedPreferences.getLong(FLAG_PA_FORE_CHECK_TIME, 0L);
        boolean z = this.mSharedPreferences.getBoolean(FLAG_PA_CHECK_IN_STATE, false);
        int i2 = this.mCurrentRate;
        if (i2 != 0) {
            return checkIn(i2 != this.mLastRate, Long.valueOf(j2), z, this.mCurrentRate);
        }
        if (z) {
            putBooleanValue(FLAG_PA_CHECK_IN_STATE, false);
        }
        if (j2 != 0) {
            putLongValue(FLAG_PA_FORE_CHECK_TIME, 0L);
        }
        return false;
    }

    private int getCurrentConfigRate() {
        int i2 = this.mSharedPreferences.getInt("apm_patrace_switch_rate", -1);
        this.mEfsReporter.getReporter().getAllSdkConfig(new String[]{"apm_patrace_switch_rate"}, new IConfigCallback() { // from class: com.efs.sdk.pa.config.ConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                Object obj = map.get("apm_patrace_switch_rate");
                if (obj != null) {
                    try {
                        ConfigManager.this.putIntValue("apm_patrace_switch_rate", Integer.parseInt(obj.toString()));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        return i2;
    }

    private void initRate() {
        this.mLastRate = this.mSharedPreferences.getInt("apm_patrace_switch_rate_last", 0);
        int currentConfigRate = getCurrentConfigRate();
        if (currentConfigRate != -1) {
            this.mCurrentRate = currentConfigRate;
        } else if (this.mPackageLevel == PackageLevel.TRIAL) {
            this.mCurrentRate = 100;
        } else {
            this.mCurrentRate = 0;
        }
    }

    private boolean isCountEnable() {
        return this.mSharedPreferences.getLong(STATS_ANR_LOG_COUNT, 0L) <= 50;
    }

    private void putBooleanValue(String str, boolean z) {
        SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putIntValue(String str, int i2) {
        SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        editorEdit.putInt(str, i2);
        editorEdit.apply();
    }

    private void putLongValue(String str, long j2) {
        SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        editorEdit.putLong(str, j2);
        editorEdit.apply();
    }

    private boolean random(int i2) {
        if (i2 == 0) {
            return false;
        }
        return i2 == 100 || new Random().nextInt(100) <= i2;
    }

    private void resetRate() {
        putIntValue("apm_patrace_switch_rate_last", this.mCurrentRate);
    }

    private void resetUploadSmoothLogCnt() {
        putLongValue(STATS_ANR_LOG_COUNT, 0L);
    }

    public boolean enableTracer() {
        return this.mCheckIn;
    }

    public void increaseUploadSmoothLogCnt() {
        putLongValue(STATS_ANR_LOG_COUNT, this.mSharedPreferences.getLong(STATS_ANR_LOG_COUNT, 0L) + 1);
    }
}
