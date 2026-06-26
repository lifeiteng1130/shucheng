package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Set;

/* JADX INFO: renamed from: j$.util.stream.m1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC0448m1<T, A, R> {

    /* JADX INFO: renamed from: j$.util.stream.m1$a */
    public enum a {
        CONCURRENT,
        UNORDERED,
        IDENTITY_FINISH
    }

    BiConsumer accumulator();

    Set characteristics();

    j$.util.function.p combiner();

    Function finisher();

    Supplier supplier();
}
