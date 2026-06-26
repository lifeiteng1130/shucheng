package f.x;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g<T> implements f.g0.e<T> {
    public final /* synthetic */ Iterable a;

    public g(Iterable iterable) {
        this.a = iterable;
    }

    @Override // f.g0.e
    @NotNull
    public Iterator<T> iterator() {
        return this.a.iterator();
    }
}
