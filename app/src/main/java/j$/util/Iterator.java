package j$.util;

import j$.util.function.Consumer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface Iterator<E> {

    /* JADX INFO: renamed from: j$.util.Iterator$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$forEachRemaining(java.util.Iterator it, Consumer consumer) {
            Objects.requireNonNull(consumer);
            while (it.hasNext()) {
                consumer.accept(it.next());
            }
        }

        public static void a(java.util.Iterator it) {
            throw new UnsupportedOperationException("remove");
        }
    }

    /* JADX INFO: renamed from: j$.util.Iterator$-EL, reason: invalid class name */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void forEachRemaining(java.util.Iterator it, Consumer consumer) {
            if (it instanceof Iterator) {
                ((Iterator) it).forEachRemaining(consumer);
            } else {
                CC.$default$forEachRemaining(it, consumer);
            }
        }
    }

    void forEachRemaining(Consumer consumer);

    boolean hasNext();

    Object next();

    void remove();
}
