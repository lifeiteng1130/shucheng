package com.qq.e.comm.managers.status;

/* JADX INFO: loaded from: classes.dex */
public enum Carrier {
    UNKNOWN(0),
    CMCC(1),
    UNICOM(2),
    TELECOM(3);

    private int a;

    Carrier(int i2) {
        this.a = i2;
    }

    public int getValue() {
        return this.a;
    }
}
