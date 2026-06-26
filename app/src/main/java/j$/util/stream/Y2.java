package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class Y2<T> implements Spliterator<T>, Consumer<T> {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Spliterator f8160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap f8161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f8162d;

    Y2(Spliterator spliterator) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f8160b = spliterator;
        this.f8161c = concurrentHashMap;
    }

    private Y2(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.f8160b = spliterator;
        this.f8161c = concurrentHashMap;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.f8162d = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.Spliterator
    public boolean b(Consumer consumer) {
        while (this.f8160b.b(this)) {
            ConcurrentHashMap concurrentHashMap = this.f8161c;
            Object obj = this.f8162d;
            if (obj == null) {
                obj = a;
            }
            if (concurrentHashMap.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.f8162d);
                this.f8162d = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.Spliterator
    public int characteristics() {
        return (this.f8160b.characteristics() & (-16469)) | 1;
    }

    @Override // j$.util.Spliterator
    public long estimateSize() {
        return this.f8160b.estimateSize();
    }

    public void f(Consumer consumer, Object obj) {
        if (this.f8161c.putIfAbsent(obj != null ? obj : a, Boolean.TRUE) == null) {
            consumer.accept(obj);
        }
    }

    @Override // j$.util.Spliterator
    public void forEachRemaining(final Consumer consumer) {
        this.f8160b.forEachRemaining(new Consumer() { // from class: j$.util.stream.x0
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                this.a.f(consumer, obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer2) {
                return Consumer.CC.$default$andThen(this, consumer2);
            }
        });
    }

    @Override // j$.util.Spliterator
    public Comparator getComparator() {
        return this.f8160b.getComparator();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ long getExactSizeIfKnown() {
        return j$.time.a.g(this);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i2) {
        return j$.time.a.h(this, i2);
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        Spliterator spliteratorTrySplit = this.f8160b.trySplit();
        if (spliteratorTrySplit != null) {
            return new Y2(spliteratorTrySplit, this.f8161c);
        }
        return null;
    }
}
