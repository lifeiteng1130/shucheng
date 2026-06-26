package com.efs.sdk.base.a.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.b.a;
import com.efs.sdk.base.a.i.f;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g extends Handler implements e {
    private final ConcurrentHashMap<String, a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.efs.sdk.base.a.g.a.d f1772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.efs.sdk.base.a.g.a.c f1773c;

    public static class a extends FileOutputStream {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public File f1774b;

        public a(@NonNull File file) {
            super(file);
            this.f1774b = file;
            this.a = System.currentTimeMillis();
        }
    }

    public g() {
        super(com.efs.sdk.base.a.h.a.a.a.getLooper());
        this.a = new ConcurrentHashMap<>();
        this.f1772b = new com.efs.sdk.base.a.g.a.d();
        this.f1773c = new com.efs.sdk.base.a.g.a.c();
    }

    private static long b(String str) {
        Map<String, String> mapC = com.efs.sdk.base.a.c.a.c.a().c();
        String strConcat = "record_accumulation_time_".concat(String.valueOf(str));
        if (!mapC.containsKey(strConcat)) {
            return 60000L;
        }
        String str2 = mapC.get(strConcat);
        if (TextUtils.isEmpty(str2)) {
            return 60000L;
        }
        try {
            return Math.max(Long.parseLong(str2) * 1000, 1000L);
        } catch (Throwable th) {
            com.efs.sdk.base.a.h.d.b("efs.cache", "get cache interval error", th);
            return 60000L;
        }
    }

    private void c(String str) {
        a aVar;
        if (this.a.containsKey(str) && (aVar = (a) this.a.get(str)) != null) {
            try {
                aVar.flush();
                com.efs.sdk.base.a.h.b.a(aVar);
                a(aVar.f1774b);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    this.a.remove(str);
                    if ("wa".equalsIgnoreCase(str)) {
                        return;
                    }
                    f.a.a.f1858c.c();
                } finally {
                    this.a.remove(str);
                    if (!"wa".equalsIgnoreCase(str)) {
                        f.a.a.f1858c.c();
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(com.efs.sdk.base.a.f.b bVar) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = bVar;
        messageObtain.what = 0;
        sendMessage(messageObtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(@NonNull Message message) {
        int i2 = message.what;
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                c(obj.toString());
                return;
            }
            return;
        }
        com.efs.sdk.base.a.f.b bVar = (com.efs.sdk.base.a.f.b) message.obj;
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                a aVarB = b(bVar);
                if (aVarB == null) {
                    com.efs.sdk.base.a.h.d.a("efs.cache", "writer is null for type " + bVar.a.a, null);
                    return;
                }
                if (aVarB.getChannel().position() + ((long) bVar.f1830c.length) > 819200) {
                    c(bVar.a.a);
                    aVarB = b(bVar);
                    if (aVarB == null) {
                        com.efs.sdk.base.a.h.d.a("efs.cache", "writer is null for type " + bVar.a.a, null);
                        return;
                    }
                }
                aVarB.write(Base64.encode(bVar.f1830c, 11));
                aVarB.write("\n".getBytes());
                return;
            } catch (Throwable th) {
                com.efs.sdk.base.a.h.d.b("efs.cache", "cache file error", th);
            }
        }
    }

    @Override // com.efs.sdk.base.a.b.e
    public final boolean a(File file, com.efs.sdk.base.a.f.b bVar) {
        if (!bVar.b()) {
            a(file);
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        bVar.f1831d = file;
        bVar.d();
        bVar.b(1);
        return true;
    }

    private a b(com.efs.sdk.base.a.f.b bVar) {
        a aVar;
        Throwable th;
        a aVar2;
        if (this.a.containsKey(bVar.a.a)) {
            return (a) this.a.get(bVar.a.a);
        }
        File file = new File(com.efs.sdk.base.a.h.a.e(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a), com.efs.sdk.base.a.h.b.a(bVar));
        try {
            aVar = new a(file);
            try {
                aVar2 = (a) this.a.putIfAbsent(bVar.a.a, aVar);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
            }
        } catch (Throwable th3) {
            aVar = null;
            th = th3;
        }
        if (aVar2 != null) {
            com.efs.sdk.base.a.h.b.a(aVar);
            com.efs.sdk.base.a.h.b.b(file);
            return aVar2;
        }
        Message messageObtain = Message.obtain();
        String str = bVar.a.a;
        messageObtain.obj = str;
        messageObtain.what = 1;
        sendMessageDelayed(messageObtain, b(str));
        if (!"wa".equalsIgnoreCase(bVar.a.a)) {
            f.a.a.f1858c.b();
        }
        return aVar;
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = str;
        messageObtain.what = 1;
        sendMessage(messageObtain);
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(File file) {
        byte[] bArr;
        com.efs.sdk.base.a.f.b bVarB = com.efs.sdk.base.a.h.b.b(file.getName());
        if (bVarB == null) {
            com.efs.sdk.base.a.b.a unused = a.b.a;
            com.efs.sdk.base.a.b.a.b(file);
        } else if (!a(bVarB, file) || (bArr = bVarB.f1830c) == null || bArr.length <= 0) {
            com.efs.sdk.base.a.b.a unused2 = a.b.a;
            com.efs.sdk.base.a.b.a.b(file);
        } else {
            com.efs.sdk.base.a.h.b.a(new File(com.efs.sdk.base.a.h.a.f(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a), com.efs.sdk.base.a.h.b.a(bVarB)), bVarB.f1830c);
            com.efs.sdk.base.a.h.b.b(file);
        }
    }

    private boolean a(com.efs.sdk.base.a.f.b bVar, File file) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        String strB = com.efs.sdk.base.a.h.c.b.b(line.getBytes());
                        if (!TextUtils.isEmpty(strB)) {
                            sb.append(strB);
                            sb.append("\n");
                        }
                    }
                    bVar.a(sb.toString().getBytes());
                    bVar.d();
                    this.f1773c.a(bVar);
                    this.f1772b.a(bVar);
                    bVar.f1831d = file;
                    com.efs.sdk.base.a.h.b.a(bufferedReader);
                    com.efs.sdk.base.a.h.b.a(fileReader2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    try {
                        com.efs.sdk.base.a.h.d.b("efs.cache", "local decode error", th);
                        com.efs.sdk.base.a.h.b.a(bufferedReader);
                        com.efs.sdk.base.a.h.b.a(fileReader);
                        return false;
                    } catch (Throwable th2) {
                        com.efs.sdk.base.a.h.b.a(bufferedReader);
                        com.efs.sdk.base.a.h.b.a(fileReader);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }
}
