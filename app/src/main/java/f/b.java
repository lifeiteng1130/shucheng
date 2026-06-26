package f;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> implements e<T>, Serializable {
    private final T value;

    public b(T t) {
        this.value = t;
    }

    @Override // f.e
    public T getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    @NotNull
    public String toString() {
        return String.valueOf(getValue());
    }
}
