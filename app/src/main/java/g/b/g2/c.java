package g.b.g2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Atomic.kt */
/* JADX INFO: loaded from: classes3.dex */
@InternalCoroutinesApi
public abstract class c<T> extends n {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = b.a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.b.g2.n
    @Nullable
    public final Object a(@Nullable Object obj) {
        Object objC = this._consensus;
        Object obj2 = b.a;
        if (objC == obj2) {
            objC = c(obj);
            Object obj3 = this._consensus;
            if (obj3 != obj2) {
                objC = obj3;
            } else if (!a.compareAndSet(this, obj2, objC)) {
                objC = this._consensus;
            }
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(T t, @Nullable Object obj);

    @Nullable
    public abstract Object c(T t);
}
