package com.ss.android.downloadlib.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: WeakHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends Handler {
    public WeakReference<a> a;

    /* JADX INFO: compiled from: WeakHandler.java */
    public interface a {
        void a(Message message);
    }

    public m(Looper looper, a aVar) {
        super(looper);
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }
}
