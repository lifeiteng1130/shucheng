package c.e.c.v.m;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReedSolomonEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f1422b;

    public d(a aVar) {
        this.a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f1422b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }
}
