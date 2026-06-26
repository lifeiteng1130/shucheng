package com.tencent.bugly.proguard;

import java.io.Serializable;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class E implements Comparable<E>, Serializable {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4269g;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(E e2) {
        return (int) (this.f4265c - e2.f4265c);
    }
}
