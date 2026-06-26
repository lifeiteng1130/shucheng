package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class A extends AbstractC0320m implements Cloneable {
    public static ArrayList<C0332z> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f4242b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<C0332z> f4243c;

    public A() {
        this.f4243c = null;
    }

    public ArrayList<C0332z> a() {
        return this.f4243c;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f4242b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C0321n.a(this.f4243c, ((A) obj).f4243c);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a((Collection) this.f4243c, 0);
    }

    public A(ArrayList<C0332z> arrayList) {
        this.f4243c = null;
        this.f4243c = arrayList;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        if (a == null) {
            a = new ArrayList<>();
            a.add(new C0332z());
        }
        this.f4243c = (ArrayList) c0318k.a(a, 0, true);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
        new C0316i(sb, i2).a((Collection) this.f4243c, com.umeng.analytics.pro.c.ar);
    }
}
