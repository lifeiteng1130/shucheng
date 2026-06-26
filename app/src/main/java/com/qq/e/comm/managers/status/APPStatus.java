package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
public class APPStatus {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2832b;

    public APPStatus(String str, Context context) {
        this.a = str;
        this.f2832b = context;
    }

    public String getAPPID() {
        return this.a;
    }

    public String getAPPName() {
        return this.f2832b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f2832b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f2832b.getPackageManager()).toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getAPPVersion() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f2832b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
