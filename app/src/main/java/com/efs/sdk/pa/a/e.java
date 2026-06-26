package com.efs.sdk.pa.a;

import android.os.SystemClock;
import android.util.Printer;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Printer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f1900f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1896b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1897c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1898d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f1899e = -1;
    public Vector<d> a = new Vector<>();

    @Override // android.util.Printer
    public final void println(String str) {
        if (str.startsWith(">")) {
            this.f1898d = SystemClock.elapsedRealtime();
            this.f1899e = SystemClock.currentThreadTimeMillis();
            this.f1897c = str;
            this.f1896b = true;
            Iterator<d> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            return;
        }
        if (this.f1896b && str.startsWith("<")) {
            this.f1896b = false;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f1898d;
            if (jElapsedRealtime > this.f1900f) {
                long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - this.f1899e;
                Iterator<d> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.f1897c, jElapsedRealtime, jCurrentThreadTimeMillis);
                }
            }
        }
    }
}
