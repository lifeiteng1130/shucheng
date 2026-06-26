package j$;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.PrimitiveIterator;

/* JADX INFO: renamed from: j$.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0356d implements t.b {
    final /* synthetic */ PrimitiveIterator.OfInt a;

    private /* synthetic */ C0356d(PrimitiveIterator.OfInt ofInt) {
        this.a = ofInt;
    }

    public static /* synthetic */ t.b a(PrimitiveIterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C0358e ? ((C0358e) ofInt).a : new C0356d(ofInt);
    }

    @Override // j$.util.t.b
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void forEachRemaining(j$.util.function.y yVar) {
        this.a.forEachRemaining(Q.a(yVar));
    }

    @Override // j$.util.t.b, j$.util.Iterator
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

    @Override // j$.util.t.b, java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Integer next() {
        return this.a.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override // j$.util.t.b
    public /* synthetic */ int nextInt() {
        return this.a.nextInt();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ void remove() {
        this.a.remove();
    }
}
