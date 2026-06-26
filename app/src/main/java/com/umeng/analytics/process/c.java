package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMProcessDBManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f5002b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f5003c;

    private c() {
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        c cVar = a;
        cVar.f5003c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f5002b.get(str) != null) {
            return (a) this.f5002b.get(str);
        }
        a aVarA = a.a(this.f5003c, str);
        this.f5002b.put(str, aVarA);
        return aVarA;
    }

    public synchronized void b(String str) {
        c(str).b();
    }

    /* JADX INFO: compiled from: UMProcessDBManager.java */
    public static class a {
        private AtomicInteger a = new AtomicInteger();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SQLiteOpenHelper f5004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SQLiteDatabase f5005c;

        private a() {
        }

        public static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f5004b = b.a(appContext, str);
            return aVar;
        }

        public synchronized void b() {
            try {
                if (this.a.decrementAndGet() == 0) {
                    this.f5005c.close();
                }
            } catch (Throwable unused) {
            }
        }

        public synchronized SQLiteDatabase a() {
            if (this.a.incrementAndGet() == 1) {
                this.f5005c = this.f5004b.getWritableDatabase();
            }
            return this.f5005c;
        }
    }

    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
