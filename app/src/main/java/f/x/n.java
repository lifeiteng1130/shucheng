package f.x;

import f.m;
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
public abstract class n implements Iterator<f.l>, f.c0.c.z.a, j$.util.Iterator {
    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public Object next() {
        m.a aVar = (m.a) this;
        int i2 = aVar.a;
        byte[] bArr = aVar.f6156b;
        if (i2 >= bArr.length) {
            throw new NoSuchElementException(String.valueOf(aVar.a));
        }
        aVar.a = i2 + 1;
        return new f.l(bArr[i2]);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
