package j$.util.function;

/* JADX INFO: loaded from: classes2.dex */
public interface BiFunction<T, U, R> {
    BiFunction andThen(Function function);

    Object apply(Object obj, Object obj2);
}
