package com.efs.sdk.base.a.e;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.a.b.a;
import com.efs.sdk.base.a.b.h;
import com.efs.sdk.base.a.c.c;
import com.efs.sdk.base.a.e.f;
import com.efs.sdk.base.a.i.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Handler {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f1814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f1815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f1816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicInteger f1817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.efs.sdk.base.a.b.f f1818f;

    public static class a {
        private static final d a = new d(0);
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    public static d a() {
        return a.a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        List<File> listEmptyList;
        super.handleMessage(message);
        if (f.a.a.a()) {
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1) {
                    return;
                }
                Object obj = message.obj;
                if (obj != null) {
                    this.f1816d.remove(obj.toString());
                }
                int iIncrementAndGet = message.arg1 != 0 ? this.f1817e.incrementAndGet() : 0;
                if (this.f1816d.isEmpty()) {
                    if (iIncrementAndGet < 5) {
                        sendEmptyMessage(0);
                        return;
                    }
                    this.f1817e.set(0);
                    sendEmptyMessageDelayed(0, com.efs.sdk.base.a.d.a.a().f1784k);
                    com.efs.sdk.base.a.h.d.a("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            String strA = c.a.a.a();
            if ("denied".equalsIgnoreCase(strA) || "disconnected".equalsIgnoreCase(strA)) {
                com.efs.sdk.base.a.h.d.a("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(strA)));
                sendEmptyMessageDelayed(0, com.efs.sdk.base.a.d.a.a().f1785l);
                return;
            }
            List<com.efs.sdk.base.a.f.b> listEmptyList2 = Collections.emptyList();
            try {
                com.efs.sdk.base.a.b.a aVar = a.b.a;
                int i3 = this.a;
                com.efs.sdk.base.a.b.f fVar = this.f1818f;
                aVar.a();
                aVar.a();
                File fileF = com.efs.sdk.base.a.h.a.f(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a);
                if (fileF.exists()) {
                    List<File> listD = com.efs.sdk.base.a.h.b.d(fileF);
                    if (aVar.f1769b) {
                        com.efs.sdk.base.a.i.f fVar2 = f.a.a;
                        int size = listD.size();
                        if (fVar2.f1857b != null && com.efs.sdk.base.a.d.a.a().f1777d) {
                            com.efs.sdk.base.a.i.b bVar = new com.efs.sdk.base.a.i.b("efs_core", "log_lag", fVar2.a.f1851c);
                            bVar.put("cnt", Integer.valueOf(size));
                            fVar2.f1857b.a(bVar);
                        }
                        aVar.f1769b = false;
                    }
                    Collections.sort(listD, aVar.f1771d);
                    ArrayList arrayList = new ArrayList(i3);
                    for (int size2 = listD.size() - 1; size2 >= 0 && arrayList.size() < i3; size2--) {
                        File file = listD.get(size2);
                        if (file.exists() && (fVar == null || !fVar.a(file))) {
                            arrayList.add(file);
                        }
                    }
                    listEmptyList = arrayList;
                } else {
                    listEmptyList = Collections.emptyList();
                }
                ArrayList arrayList2 = new ArrayList(i3);
                for (File file2 : listEmptyList) {
                    com.efs.sdk.base.a.f.b bVarA = aVar.a(file2);
                    if (bVarA == null) {
                        com.efs.sdk.base.a.h.d.a("efs.cache", "file upload error, name is " + file2.getName(), null);
                    } else {
                        arrayList2.add(bVarA);
                    }
                }
                listEmptyList2 = arrayList2;
            } catch (Throwable unused) {
            }
            for (com.efs.sdk.base.a.f.b bVar2 : listEmptyList2) {
                if ("wa".equals(bVar2.a.a) || b.a().a(bVar2.a.a, bVar2.a())) {
                    c cVar = this.f1814b;
                    if ("wa".equals(bVar2.a.a)) {
                        cVar = this.f1815c;
                    }
                    String string = UUID.randomUUID().toString();
                    this.f1816d.add(string);
                    if (com.efs.sdk.base.a.h.a.d.a(new e(bVar2, cVar, string)) == null) {
                        a(string, -1);
                    }
                }
            }
            if (this.f1816d.size() <= 0) {
                sendEmptyMessageDelayed(0, com.efs.sdk.base.a.d.a.a().f1785l);
            }
        }
    }

    private d() {
        super(com.efs.sdk.base.a.h.a.a.a.getLooper());
        this.a = 5;
        this.f1816d = new ArrayList();
        this.f1817e = new AtomicInteger(0);
        this.f1814b = new com.efs.sdk.base.a.e.a();
        this.f1815c = new com.efs.sdk.base.a.i.e();
        this.f1818f = new h();
    }

    public final void a(Object obj, int i2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = obj;
        messageObtain.arg1 = i2;
        sendMessage(messageObtain);
    }
}
