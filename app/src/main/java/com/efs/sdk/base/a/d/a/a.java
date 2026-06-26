package com.efs.sdk.base.a.d.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.efs.sdk.base.a.c.c;
import com.efs.sdk.base.a.h.a.d;
import com.efs.sdk.base.a.h.e;

/* JADX INFO: loaded from: classes.dex */
public final class a extends BroadcastReceiver implements Runnable {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        d.a(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = c.a.a;
        String strB = e.b(com.efs.sdk.base.a.d.a.a().f1776c);
        com.efs.sdk.base.a.h.d.a("efs.info.manager", "network change: ".concat(String.valueOf(strB)), null);
        cVar.a.a("net", strB);
    }
}
