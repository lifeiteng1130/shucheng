package com.tencent.bugly.beta.upgrade;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public interface UpgradeStateListener {
    void onDownloadCompleted(boolean z);

    void onUpgradeFailed(boolean z);

    void onUpgradeNoVersion(boolean z);

    void onUpgradeSuccess(boolean z);

    void onUpgrading(boolean z);
}
