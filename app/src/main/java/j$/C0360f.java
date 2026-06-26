package j$;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.PrimitiveIterator;

/* JADX INFO: renamed from: j$.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0360f implements t.c {
    final /* synthetic */ PrimitiveIterator.OfLong a;

    private /* synthetic */ C0360f(PrimitiveIterator.OfLong ofLong) {
        this.a = ofLong;
    }

    public static /* synthetic */ t.c a(PrimitiveIterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0362g ? ((C0362g) ofLong).a : new C0360f(ofLong);
    }

    @Override // j$.util.t.c
    /* JADX INFO: renamed from: d */
    public /* synthetic */ void forEachRemaining(j$.util.function.E e2) {
        this.a.forEachRemaining(C0361f0.a(e2));
    }

    @Override // j$.util.t.c, j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining(obj);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // j$.util.t.c, java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Long next() {
        return this.a.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override // j$.util.t.c
    public /* synthetic */ long nextLong() {
        return this.a.nextLong();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ void remove() {
        this.a.remove();
    }
}
