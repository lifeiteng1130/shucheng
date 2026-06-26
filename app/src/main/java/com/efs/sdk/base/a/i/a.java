package com.efs.sdk.base.a.i;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Handler {
    public com.efs.sdk.base.a.d.a a;

    public a() {
        super(com.efs.sdk.base.a.h.a.a.a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    public abstract void a();

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
