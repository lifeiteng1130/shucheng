package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class oa extends AbstractC0320m implements Cloneable {
    public static ArrayList<na> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<na> f4407b = null;

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a((Collection) this.f4407b, 0);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        if (a == null) {
            a = new ArrayList<>();
            a.add(new na());
        }
        this.f4407b = (ArrayList) c0318k.a(a, 0, true);
    }
}
