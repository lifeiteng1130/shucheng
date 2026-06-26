package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class T {
    private static T a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f4306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public P f4307d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f4310g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Integer, Long> f4308e = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f4311h = new LinkedBlockingQueue<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f4312i = new LinkedBlockingQueue<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f4313j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f4314k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4315l = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final J f4305b = J.a();

    public T(Context context) {
        this.f4306c = context;
    }

    public static /* synthetic */ int b(T t) {
        int i2 = t.f4315l - 1;
        t.f4315l = i2;
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #4 {, blocks: (B:9:0x001f, B:13:0x004b, B:14:0x0050, B:25:0x0062, B:30:0x006c, B:38:0x008e, B:37:0x0083, B:41:0x0094, B:49:0x00b6, B:48:0x00ab, B:50:0x00b9, B:20:0x0059, B:22:0x005d, B:33:0x0077, B:44:0x009f), top: B:99:0x001f, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094 A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #4 {, blocks: (B:9:0x001f, B:13:0x004b, B:14:0x0050, B:25:0x0062, B:30:0x006c, B:38:0x008e, B:37:0x0083, B:41:0x0094, B:49:0x00b6, B:48:0x00ab, B:50:0x00b9, B:20:0x0059, B:22:0x005d, B:33:0x0077, B:44:0x009f), top: B:99:0x001f, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(int r13) {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.T.c(int):void");
    }

    public static synchronized T a(Context context) {
        if (a == null) {
            a = new T(context);
        }
        return a;
    }

    public synchronized long b(int i2) {
        if (i2 >= 0) {
            Long l2 = this.f4308e.get(Integer.valueOf(i2));
            if (l2 != null) {
                return l2.longValue();
            }
        } else {
            X.b("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return 0L;
    }

    public static synchronized T a() {
        return a;
    }

    public void a(int i2, int i3, byte[] bArr, String str, String str2, P p, long j2, boolean z) {
        try {
            try {
                a(new U(this.f4306c, i2, i3, bArr, str, str2, p, true, z), true, true, j2);
            } catch (Throwable th) {
                th = th;
                if (X.b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a(int i2, pa paVar, String str, String str2, P p, long j2, boolean z) {
        a(i2, paVar.f4415i, M.a((Object) paVar), str, str2, p, j2, z);
    }

    public void a(int i2, int i3, byte[] bArr, String str, String str2, P p, int i4, int i5, boolean z, Map<String, String> map) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new U(this.f4306c, i2, i3, bArr, str, str2, p, true, i4, i5, false, map), z, false, 0L);
        } catch (Throwable th2) {
            th = th2;
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void a(int i2, int i3, byte[] bArr, String str, String str2, P p, boolean z, Map<String, String> map) {
        a(i2, i3, bArr, str, str2, p, 0, 0, z, map);
    }

    public void a(int i2, pa paVar, String str, String str2, P p, boolean z) {
        a(i2, paVar.f4415i, M.a((Object) paVar), str, str2, p, 0, 0, z, null);
    }

    public long a(boolean z) {
        long jB;
        long jB2 = ca.b();
        int i2 = z ? 5 : 3;
        List<L> listA = this.f4305b.a(i2);
        if (listA != null && listA.size() > 0) {
            jB = 0;
            try {
                L l2 = listA.get(0);
                if (l2.f4297e >= jB2) {
                    jB = ca.b(l2.f4299g);
                    if (i2 == 3) {
                        this.f4309f = jB;
                    } else {
                        this.f4310g = jB;
                    }
                    listA.remove(l2);
                }
            } catch (Throwable th) {
                X.b(th);
            }
            if (listA.size() > 0) {
                this.f4305b.a(listA);
            }
        } else {
            jB = z ? this.f4310g : this.f4309f;
        }
        X.a("[UploadManager] Local network consume: %d KB", Long.valueOf(jB / 1024));
        return jB;
    }

    public synchronized void a(long j2, boolean z) {
        int i2 = z ? 5 : 3;
        L l2 = new L();
        l2.f4294b = i2;
        l2.f4297e = ca.b();
        l2.f4295c = "";
        l2.f4296d = "";
        l2.f4299g = ca.b(j2);
        this.f4305b.b(i2);
        this.f4305b.c(l2);
        if (z) {
            this.f4310g = j2;
        } else {
            this.f4309f = j2;
        }
        X.a("[UploadManager] Network total consume: %d KB", Long.valueOf(j2 / 1024));
    }

    public synchronized void a(int i2, long j2) {
        if (i2 >= 0) {
            this.f4308e.put(Integer.valueOf(i2), Long.valueOf(j2));
            L l2 = new L();
            l2.f4294b = i2;
            l2.f4297e = j2;
            l2.f4295c = "";
            l2.f4296d = "";
            l2.f4299g = new byte[0];
            this.f4305b.b(i2);
            this.f4305b.c(l2);
            X.a("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), ca.a(j2));
        } else {
            X.b("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
        }
    }

    public boolean a(int i2) {
        if (com.tencent.bugly.b.f3960c) {
            X.a("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - b(i2);
        X.a("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(jCurrentTimeMillis / 1000), Integer.valueOf(i2));
        if (jCurrentTimeMillis >= 30000) {
            return true;
        }
        X.c("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            X.c("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            X.a("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f4313j) {
                if (z) {
                    this.f4311h.put(runnable);
                } else {
                    this.f4312i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            X.b("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, long j2) {
        if (runnable == null) {
            X.e("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        X.a("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread threadA = ca.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (threadA == null) {
            X.b("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            threadA.join(j2);
        } catch (Throwable th) {
            X.b("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            c(0);
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j2) {
        if (runnable == null) {
            X.e("[UploadManager] Upload task should not be null", new Object[0]);
        }
        X.a("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            a(runnable, j2);
        } else {
            a(runnable, z);
            c(0);
        }
    }
}
