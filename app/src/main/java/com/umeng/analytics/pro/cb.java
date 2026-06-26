package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: TIOStreamTransport.java */
/* JADX INFO: loaded from: classes.dex */
public class cb extends cd {
    public InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OutputStream f4802b;

    public cb() {
        this.a = null;
        this.f4802b = null;
    }

    @Override // com.umeng.analytics.pro.cd
    public int a(byte[] bArr, int i2, int i3) throws ce {
        InputStream inputStream = this.a;
        if (inputStream == null) {
            throw new ce(1, "Cannot read from null inputStream");
        }
        try {
            int i4 = inputStream.read(bArr, i2, i3);
            if (i4 >= 0) {
                return i4;
            }
            throw new ce(4);
        } catch (IOException e2) {
            throw new ce(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.cd
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cd
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cd
    public void b(byte[] bArr, int i2, int i3) throws ce {
        OutputStream outputStream = this.f4802b;
        if (outputStream == null) {
            throw new ce(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i2, i3);
        } catch (IOException e2) {
            throw new ce(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.cd
    public void c() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.a = null;
        }
        OutputStream outputStream = this.f4802b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.f4802b = null;
        }
    }

    @Override // com.umeng.analytics.pro.cd
    public void d() throws ce {
        OutputStream outputStream = this.f4802b;
        if (outputStream == null) {
            throw new ce(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e2) {
            throw new ce(0, e2);
        }
    }

    public cb(InputStream inputStream) {
        this.a = null;
        this.f4802b = null;
        this.a = inputStream;
    }

    public cb(OutputStream outputStream) {
        this.a = null;
        this.f4802b = null;
        this.f4802b = outputStream;
    }

    public cb(InputStream inputStream, OutputStream outputStream) {
        this.a = null;
        this.f4802b = null;
        this.a = inputStream;
        this.f4802b = outputStream;
    }
}
