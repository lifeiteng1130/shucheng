package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import c.c.a.t.b;
import c.c.a.x.d;

/* JADX INFO: loaded from: classes.dex */
public final class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: com.bytedance.pangle.receiver.a$a, reason: collision with other inner class name */
    public class RunnableC0057a implements Runnable {
        public final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f1619b;

        public RunnableC0057a(a aVar, Context context, Intent intent) {
            this.a = context;
            this.f1619b = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a().b(this.a, this.f1619b);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (b.a().f788d.contains(Integer.valueOf(hashCode()))) {
            b.a().b(context, intent);
            return;
        }
        RunnableC0057a runnableC0057a = new RunnableC0057a(this, context, intent);
        if (d.b().getLooper() == Looper.myLooper()) {
            runnableC0057a.run();
        } else {
            d.b().post(runnableC0057a);
        }
    }
}
