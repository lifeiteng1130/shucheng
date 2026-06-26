package com.efs.sdk.base.a.f;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f1829b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f1830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f1831d;

    public b(String str, byte b2) {
        this.a = new a(str, b2);
    }

    private void e() {
        byte[] bArr;
        a aVar = this.a;
        int i2 = aVar.f1824c;
        if (i2 == 0 && (bArr = this.f1830c) != null) {
            aVar.f1827f = bArr.length;
        } else if (i2 == 1 && this.f1831d.exists()) {
            this.a.f1827f = this.f1831d.length();
        }
    }

    public final long a() {
        e();
        return this.a.f1827f;
    }

    public final boolean b() {
        return !Constants.CP_NONE.equals(this.a.f1825d);
    }

    public final boolean c() {
        return 1 != this.a.f1826e;
    }

    public final void d() {
        this.f1829b.a = true;
    }

    public final void b(int i2) {
        this.a.f1824c = i2;
    }

    public final void a(String str) {
        this.a.f1825d = str;
    }

    public final void a(int i2) {
        this.a.f1826e = i2;
        e();
    }

    public final void a(byte[] bArr) {
        this.f1830c = bArr;
        e();
    }

    public static b a(ILogProtocol iLogProtocol) {
        b bVar;
        b bVar2 = null;
        try {
            bVar = new b(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
        } catch (Exception e2) {
            e = e2;
        }
        try {
            int bodyType = iLogProtocol.getBodyType();
            if (bodyType == 0) {
                bVar.b(0);
                bVar.a(iLogProtocol.generate());
            } else if (bodyType != 1) {
                com.efs.sdk.base.a.h.d.a("efs.base", "Can not support body type: " + iLogProtocol.getBodyType(), null);
            } else {
                bVar.b(1);
                bVar.f1831d = new File(iLogProtocol.getFilePath());
            }
            return bVar;
        } catch (Exception e3) {
            e = e3;
            bVar2 = bVar;
            com.efs.sdk.base.a.h.d.b("efs.base", "log send error", e);
            return bVar2;
        }
    }
}
