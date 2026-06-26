package com.tencent.bugly.beta;

import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0330x;
import com.tencent.bugly.proguard.C0331y;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class UpgradeInfo {
    public String apkMd5;
    public String apkUrl;
    public long fileSize;
    public String id;
    public String imageUrl;
    public String newFeature;
    public long popInterval;
    public int popTimes;
    public long publishTime;
    public int publishType;
    public String title;
    public int updateType;
    public int upgradeType;
    public int versionCode;
    public String versionName;

    public UpgradeInfo(B b2) {
        this.id = "";
        this.title = "";
        this.newFeature = "";
        this.publishTime = 0L;
        this.publishType = 0;
        this.upgradeType = 1;
        this.popTimes = 0;
        this.popInterval = 0L;
        this.versionName = "";
        if (b2 != null) {
            this.id = b2.r;
            this.title = b2.f4248f;
            this.newFeature = b2.f4249g;
            this.publishTime = b2.f4250h;
            this.publishType = b2.f4251i;
            this.upgradeType = b2.f4254l;
            this.popTimes = b2.m;
            this.popInterval = b2.n;
            C0331y c0331y = b2.f4252j;
            this.versionCode = c0331y.f4474d;
            this.versionName = c0331y.f4475e;
            this.apkMd5 = c0331y.f4480j;
            C0330x c0330x = b2.f4253k;
            this.apkUrl = c0330x.f4468c;
            this.fileSize = c0330x.f4470e;
            this.imageUrl = b2.q.get("IMG_title");
            this.updateType = b2.u;
        }
    }
}
