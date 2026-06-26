package f.x;

import f.o;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.SinceKotlin;

/* JADX INFO: compiled from: UIterators.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(level = f.a.ERROR, message = "This class is not going to be stabilized and is to be removed soon.")
@SinceKotlin(version = "1.3")
public abstract class o implements Iterator<f.n>, f.c0.c.z.a, j$.util.Iterator {
    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public Object next() {
        o.a aVar = (o.a) this;
        int i2 = aVar.a;
        int[] iArr = aVar.f6157b;
        if (i2 >= iArr.length) {
            throw new NoSuchElementException(String.valueOf(aVar.a));
        }
        aVar.a = i2 + 1;
        return new f.n(iArr[i2]);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
