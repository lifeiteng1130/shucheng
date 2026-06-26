package f.e0;

import java.lang.Comparable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a<T extends Comparable<? super T>> {
    @NotNull
    T getEndInclusive();

    @NotNull
    T getStart();
}
