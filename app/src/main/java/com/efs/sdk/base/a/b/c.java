package com.efs.sdk.base.a.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.efs.sdk.base.a.b.a;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Handler implements Runnable {
    public boolean a;

    public static class a {
        private static final c a = new c(0);
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static c a() {
        return a.a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            com.efs.sdk.base.a.h.a.d.a(this);
            return;
        }
        com.efs.sdk.base.a.h.d.a("efs.cache", "disk listener not support command: " + message.what, null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.efs.sdk.base.a.b.a unused = a.b.a;
        File fileF = com.efs.sdk.base.a.h.a.f(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a);
        if (fileF.exists()) {
            for (File file : com.efs.sdk.base.a.h.b.d(fileF)) {
                if (com.efs.sdk.base.a.b.a.a(file.getName())) {
                    com.efs.sdk.base.a.b.a.c(file);
                }
            }
        }
        com.efs.sdk.base.a.c.a.c cVarA = com.efs.sdk.base.a.c.a.c.a();
        String str = cVarA.f1793d.f1789e.containsKey("disk_bytes") ? cVarA.f1793d.f1789e.get("disk_bytes") : "4194304";
        long j2 = Long.parseLong(TextUtils.isEmpty(str) ? "4194304" : str);
        long jC = com.efs.sdk.base.a.h.b.c(com.efs.sdk.base.a.h.a.d(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a)) + com.efs.sdk.base.a.h.b.c(com.efs.sdk.base.a.h.a.f(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a));
        boolean z = jC < j2;
        this.a = z;
        if (!z) {
            com.efs.sdk.base.a.h.d.a("efs.cache", "Cache Limited! curr " + jC + "byte, max " + j2 + " byte.", null);
        }
        sendEmptyMessageDelayed(2, TTAdConstant.AD_MAX_EVENT_TIME);
    }

    private c() {
        super(com.efs.sdk.base.a.h.a.a.a.getLooper());
        this.a = true;
        sendEmptyMessageDelayed(2, 60000L);
    }
}
