package com.tencent.bugly.beta.download;

import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.NetNotifyDialog;
import com.tencent.bugly.beta.ui.UiManager;
import com.tencent.bugly.proguard.A;
import com.tencent.bugly.proguard.C0323p;
import com.tencent.bugly.proguard.X;
import java.util.ArrayList;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f3975b;

    public d(int i2, Object... objArr) {
        this.a = i2;
        this.f3975b = objArr;
    }

    public synchronized void a(int i2, int i3) {
        try {
            int i4 = this.a;
            if (i4 != 1) {
                if (i4 == 2) {
                    Object[] objArr = this.f3975b;
                    DownloadTask downloadTask = (DownloadTask) objArr[0];
                    NetNotifyDialog netNotifyDialog = (NetNotifyDialog) objArr[2];
                    if (i3 == 1) {
                        downloadTask.download();
                        X.a("continue download", new Object[0]);
                        this.f3975b[1] = Boolean.FALSE;
                        netNotifyDialog.close();
                    } else if (i2 == 1 || ((Boolean) objArr[1]).booleanValue()) {
                        e eVar = e.f3983b;
                        if (!eVar.U && !eVar.V) {
                            downloadTask.stop();
                            X.a("wifi network change to mobile network, stop download", new Object[0]);
                            this.f3975b[1] = Boolean.TRUE;
                            if (com.tencent.bugly.crashreport.common.info.b.c(e.f3983b.v) != null) {
                                UiManager.show(netNotifyDialog, true);
                                this.f3975b[1] = Boolean.FALSE;
                            }
                        }
                    }
                }
            } else if (i3 == 1 || i3 == 3 || i3 == 4) {
                ArrayList arrayList = (ArrayList) C0323p.a.b();
                if (arrayList != null && !arrayList.isEmpty()) {
                    com.tencent.bugly.beta.upgrade.b.a.a(new A(arrayList), true);
                }
            }
        } catch (Exception e2) {
            if (!X.a(e2)) {
                e2.printStackTrace();
            }
        }
    }
}
