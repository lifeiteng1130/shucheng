package j$.util.function;

import j$.util.function.Consumer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface Consumer<T> {

    /* JADX INFO: renamed from: j$.util.function.Consumer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Consumer $default$andThen(final Consumer consumer, final Consumer consumer2) {
            Objects.requireNonNull(consumer2);
            return new Consumer() { // from class: j$.util.function.e
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    Consumer consumer3 = consumer;
                    Consumer consumer4 = consumer2;
                    consumer3.accept(obj);
                    consumer4.accept(obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer3) {
                    return Consumer.CC.$default$andThen(this, consumer3);
                }
            };
        }
    }

    void accept(Object obj);

    Consumer andThen(Consumer consumer);
}
