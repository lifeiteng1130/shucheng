package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class b implements Comparable<b> {
    public long a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4166b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4167c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4168d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4169e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4170f = 0;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        long j2 = this.f4166b - bVar.f4166b;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }
}
