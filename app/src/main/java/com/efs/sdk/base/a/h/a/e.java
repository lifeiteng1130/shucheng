package com.efs.sdk.base.a.h.a;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e<T> implements Runnable {
    private List<b<T>> a = new ArrayList(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c<T> f1837b;

    public e(@NonNull c<T> cVar) {
        this.f1837b = cVar;
    }

    public final void a(@NonNull List<b<T>> list) {
        this.a.addAll(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public final T a() {
        T tA = null;
        try {
            Iterator<b<T>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            tA = this.f1837b.a();
            Iterator<b<T>> it2 = this.a.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.f1837b, tA);
            }
            Iterator<b<T>> it3 = this.a.iterator();
            while (it3.hasNext()) {
                it3.next().result(tA);
            }
        } catch (Throwable th) {
            com.efs.sdk.base.a.h.d.a("efs.base", "efs.util.concurrent", th);
            Iterator<b<T>> it4 = this.a.iterator();
            while (it4.hasNext()) {
                it4.next();
            }
        }
        return tA;
    }
}
