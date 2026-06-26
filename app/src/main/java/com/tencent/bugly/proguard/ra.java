package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class ra extends AbstractC0320m implements Cloneable {
    public String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4437b = "";

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.a, 0);
        c0319l.a(this.f4437b, 1);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.a = c0318k.a(0, true);
        this.f4437b = c0318k.a(1, true);
    }
}
