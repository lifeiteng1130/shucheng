package j$.util;

import j$.util.v;
import java.util.SortedSet;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes2.dex */
class u<E> extends v.i<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SortedSet f8326f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    u(SortedSet sortedSet, java.util.Collection collection, int i2) {
        super(collection, i2);
        this.f8326f = sortedSet;
    }

    @Override // j$.util.v.i, j$.util.Spliterator
    public java.util.Comparator getComparator() {
        return this.f8326f.comparator();
    }
}
