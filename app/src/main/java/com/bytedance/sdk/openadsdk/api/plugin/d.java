package com.bytedance.sdk.openadsdk.api.plugin;

import com.bytedance.pangle.download.PluginDownloadBean;
import java.io.File;

/* JADX INFO: compiled from: PluginConfigInfo.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends PluginDownloadBean {
    public String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f1719b = null;

    public d() {
        this.mOrder = 0;
        this.isOffline = false;
        this.isWifiOnly = true;
        this.mDownloadType = 1;
        this.mBackupUrlList = null;
    }
}
