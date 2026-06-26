package com.qq.e.comm.adevent;

/* JADX INFO: loaded from: classes.dex */
public class ADEvent {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f2766b;

    public ADEvent(int i2) {
        this(i2, null);
    }

    public ADEvent(int i2, Object[] objArr) {
        this.a = i2;
        this.f2766b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f2766b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.a;
    }
}
