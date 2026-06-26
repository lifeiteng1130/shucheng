package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import f.c0.c.j;
import f.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001aQ\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/collection/ArrayMap;", "arrayMapOf", "()Landroidx/collection/ArrayMap;", "", "Lf/g;", "pairs", "([Lkotlin/Pair;)Landroidx/collection/ArrayMap;", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class ArrayMapKt {
    @NotNull
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    @NotNull
    public static final <K, V> ArrayMap<K, V> arrayMapOf(@NotNull g<? extends K, ? extends V>... gVarArr) {
        j.f(gVarArr, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(gVarArr.length);
        for (g<? extends K, ? extends V> gVar : gVarArr) {
            arrayMap.put(gVar.getFirst(), gVar.getSecond());
        }
        return arrayMap;
    }
}
