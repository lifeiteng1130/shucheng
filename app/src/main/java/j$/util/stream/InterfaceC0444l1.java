package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.InterfaceC0444l1;
import java.util.Iterator;

/* JADX INFO: renamed from: j$.util.stream.l1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC0444l1<T, S extends InterfaceC0444l1<T, S>> extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    boolean isParallel();

    Iterator iterator();

    InterfaceC0444l1 onClose(Runnable runnable);

    InterfaceC0444l1 parallel();

    InterfaceC0444l1 sequential();

    Spliterator spliterator();

    InterfaceC0444l1 unordered();
}
