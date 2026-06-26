package com.tencent.bugly.proguard;

import java.io.Serializable;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0320m implements Serializable {
    public abstract void a(C0318k c0318k);

    public abstract void a(C0319l c0319l);

    public abstract void a(StringBuilder sb, int i2);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb, 0);
        return sb.toString();
    }
}
