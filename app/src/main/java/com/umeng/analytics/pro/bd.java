package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX INFO: compiled from: FieldValueMetaData.java */
/* JADX INFO: loaded from: classes.dex */
public class bd implements Serializable {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f4724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f4726d;

    public bd(byte b2, boolean z) {
        this.f4724b = b2;
        this.a = false;
        this.f4725c = null;
        this.f4726d = z;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.f4725c;
    }

    public boolean c() {
        return this.f4724b == 12;
    }

    public boolean d() {
        byte b2 = this.f4724b;
        return b2 == 15 || b2 == 13 || b2 == 14;
    }

    public boolean e() {
        return this.f4726d;
    }

    public bd(byte b2) {
        this(b2, false);
    }

    public bd(byte b2, String str) {
        this.f4724b = b2;
        this.a = true;
        this.f4725c = str;
        this.f4726d = false;
    }
}
