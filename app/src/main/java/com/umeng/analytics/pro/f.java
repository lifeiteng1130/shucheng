package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMDBManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SQLiteOpenHelper f4866b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f4867d;
    private AtomicInteger a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f4868c;

    /* JADX INFO: compiled from: UMDBManager.java */
    public static class a {
        private static final f a = new f();

        private a() {
        }
    }

    public static f a(Context context) {
        if (f4867d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            f4867d = applicationContext;
            f4866b = e.a(applicationContext);
        }
        return a.a;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.f4868c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private f() {
        this.a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.f4868c = f4866b.getWritableDatabase();
        }
        return this.f4868c;
    }
}
