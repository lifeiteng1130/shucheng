package f.g0;

import f.c0.c.j;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SequencesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements e<T> {
    public final AtomicReference<e<T>> a;

    public a(@NotNull e<? extends T> eVar) {
        j.e(eVar, "sequence");
        this.a = new AtomicReference<>(eVar);
    }

    @Override // f.g0.e
    @NotNull
    public Iterator<T> iterator() {
        e<T> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
