package com.efs.sdk.base.a.e;

import android.content.Context;
import com.efs.sdk.base.a.h.g;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FileLock f1821b;
    public volatile int a;

    public static class a {
        private static final f a = new f(0);
    }

    public /* synthetic */ f(byte b2) {
        this();
    }

    public final boolean a() {
        if (this.a == 2) {
            return true;
        }
        if (this.a != 0) {
            return false;
        }
        a(com.efs.sdk.base.a.d.a.a().f1776c);
        return false;
    }

    private f() {
        this.a = 0;
        a(com.efs.sdk.base.a.d.a.a().f1776c);
    }

    private synchronized void a(final Context context) {
        com.efs.sdk.base.a.h.d.a("efs.send_log", "tryFileLock start! ", null);
        this.a = 1;
        new Thread(new Runnable() { // from class: com.efs.sdk.base.a.e.f.1
            @Override // java.lang.Runnable
            public final void run() {
                FileLock fileLockLock;
                try {
                    File fileA = com.efs.sdk.base.a.h.a.a(context);
                    if (!fileA.exists()) {
                        fileA.mkdirs();
                    }
                    File file = new File(fileA.getPath() + File.separator + "sendlock");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    do {
                        fileLockLock = new FileOutputStream(file).getChannel().lock();
                        f.f1821b = fileLockLock;
                    } while (!fileLockLock.isValid());
                    com.efs.sdk.base.a.h.d.a("efs.send_log", "tryFileLock sendlock sucess! processname: " + g.b(), null);
                    f.this.a = 2;
                } catch (Exception e2) {
                    com.efs.sdk.base.a.h.d.a("efs.send_log", "tryFileLock fail! " + e2.getMessage(), null);
                    f.this.a = 0;
                }
            }
        }).start();
    }
}
