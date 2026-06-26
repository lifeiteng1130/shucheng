package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class la extends AbstractC0320m implements Cloneable {
    public static ArrayList<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4390b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<String> f4391c = null;

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4390b, 0);
        ArrayList<String> arrayList = this.f4391c;
        if (arrayList != null) {
            c0319l.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4390b = c0318k.a(0, true);
        if (a == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            a = arrayList;
            arrayList.add("");
        }
        this.f4391c = (ArrayList) c0318k.a(a, 1, false);
    }
}
