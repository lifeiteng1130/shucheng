package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bj;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: TSerializer.java */
/* JADX INFO: loaded from: classes.dex */
public class az {
    private final ByteArrayOutputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final cb f4717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private bp f4718c;

    public az() {
        this(new bj.a());
    }

    public byte[] a(aq aqVar) {
        this.a.reset();
        aqVar.write(this.f4718c);
        return this.a.toByteArray();
    }

    public String b(aq aqVar) {
        return new String(a(aqVar));
    }

    public az(br brVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        cb cbVar = new cb(byteArrayOutputStream);
        this.f4717b = cbVar;
        this.f4718c = brVar.a(cbVar);
    }

    public String a(aq aqVar, String str) throws aw {
        try {
            return new String(a(aqVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new aw(c.a.a.a.a.i("JVM DOES NOT SUPPORT ENCODING: ", str));
        }
    }
}
