package f;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i<T> implements e<T>, Serializable {
    private volatile Object _value;
    private f.c0.b.a<? extends T> initializer;
    private final Object lock;

    public i(@NotNull f.c0.b.a<? extends T> aVar, @Nullable Object obj) {
        f.c0.c.j.e(aVar, "initializer");
        this.initializer = aVar;
        this._value = r.a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new b(getValue());
    }

    @Override // f.e
    public T getValue() {
        T tInvoke;
        T t = (T) this._value;
        r rVar = r.a;
        if (t != rVar) {
            return t;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == rVar) {
                f.c0.b.a<? extends T> aVar = this.initializer;
                f.c0.c.j.c(aVar);
                tInvoke = aVar.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    public boolean isInitialized() {
        return this._value != r.a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ i(f.c0.b.a aVar, Object obj, int i2, f.c0.c.f fVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
