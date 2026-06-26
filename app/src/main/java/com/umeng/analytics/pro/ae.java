package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SamsungDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class ae implements y {
    private static final String a = "DeviceIdService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4642b = "com.samsung.android.deviceidservice";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4643c = "com.samsung.android.deviceidservice.DeviceIdService";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountDownLatch f4645e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4644d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ServiceConnection f4646f = new ServiceConnection() { // from class: com.umeng.analytics.pro.ae.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a aVarA = a.AbstractBinderC0123a.a(iBinder);
                ae.this.f4644d = aVarA.a();
            } catch (RemoteException | NullPointerException e2) {
                e2.getMessage();
            }
            ae.this.f4645e.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName(f4642b, f4643c);
            if (context.bindService(intent, this.f4646f, 1)) {
            } else {
                throw new UnsupportedOperationException("not supported service");
            }
        } catch (Error | Exception e2) {
            e2.getMessage();
            this.f4645e.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f4646f);
        } catch (Error | Exception e2) {
            e2.getMessage();
        }
    }

    @Override // com.umeng.analytics.pro.y
    public String a(Context context) {
        this.f4645e = new CountDownLatch(1);
        try {
            try {
                b(context);
                this.f4645e.await(500L, TimeUnit.MILLISECONDS);
                return this.f4644d;
            } catch (InterruptedException e2) {
                e2.getMessage();
                c(context);
                return null;
            }
        } finally {
            c(context);
        }
    }
}
