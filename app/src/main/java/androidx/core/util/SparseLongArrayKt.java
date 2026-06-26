package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import f.c0.b.a;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.x.l;
import f.x.m;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: SparseLongArray.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u000e\u0010\u0005\u001a\u001c\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a$\u0010\u0012\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0015\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0087\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a#\u0010\u001a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001aL\u0010\"\u001a\u00020\b*\u00020\u000026\u0010!\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u001eH\u0087\b¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010%\u001a\u00020$*\u00020\u0000H\u0007¢\u0006\u0004\b%\u0010&\u001a\u0013\u0010(\u001a\u00020'*\u00020\u0000H\u0007¢\u0006\u0004\b(\u0010)\"\u0018\u0010,\u001a\u00020\u0001*\u00020\u00008Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Landroid/util/SparseLongArray;", "", "key", "", "contains", "(Landroid/util/SparseLongArray;I)Z", "", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "set", "(Landroid/util/SparseLongArray;IJ)V", "other", "plus", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)Landroid/util/SparseLongArray;", "containsKey", "containsValue", "(Landroid/util/SparseLongArray;J)Z", "defaultValue", "getOrDefault", "(Landroid/util/SparseLongArray;IJ)J", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseLongArray;ILf/c0/b/a;)J", "isEmpty", "(Landroid/util/SparseLongArray;)Z", "isNotEmpty", "remove", "(Landroid/util/SparseLongArray;IJ)Z", "putAll", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroid/util/SparseLongArray;Lf/c0/b/p;)V", "Lf/x/l;", "keyIterator", "(Landroid/util/SparseLongArray;)Lf/x/l;", "Lf/x/m;", "valueIterator", "(Landroid/util/SparseLongArray;)Lf/x/m;", "getSize", "(Landroid/util/SparseLongArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(@NotNull SparseLongArray sparseLongArray, int i2) {
        j.f(sparseLongArray, "$this$contains");
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@NotNull SparseLongArray sparseLongArray, int i2) {
        j.f(sparseLongArray, "$this$containsKey");
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@NotNull SparseLongArray sparseLongArray, long j2) {
        j.f(sparseLongArray, "$this$containsValue");
        return sparseLongArray.indexOfValue(j2) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(@NotNull SparseLongArray sparseLongArray, @NotNull p<? super Integer, ? super Long, v> pVar) {
        j.f(sparseLongArray, "$this$forEach");
        j.f(pVar, "action");
        int size = sparseLongArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseLongArray.keyAt(i2)), Long.valueOf(sparseLongArray.valueAt(i2)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(@NotNull SparseLongArray sparseLongArray, int i2, long j2) {
        j.f(sparseLongArray, "$this$getOrDefault");
        return sparseLongArray.get(i2, j2);
    }

    @RequiresApi(18)
    public static final long getOrElse(@NotNull SparseLongArray sparseLongArray, int i2, @NotNull a<Long> aVar) {
        j.f(sparseLongArray, "$this$getOrElse");
        j.f(aVar, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i2);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : aVar.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(@NotNull SparseLongArray sparseLongArray) {
        j.f(sparseLongArray, "$this$size");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@NotNull SparseLongArray sparseLongArray) {
        j.f(sparseLongArray, "$this$isEmpty");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@NotNull SparseLongArray sparseLongArray) {
        j.f(sparseLongArray, "$this$isNotEmpty");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    @NotNull
    public static final l keyIterator(@NotNull final SparseLongArray sparseLongArray) {
        j.f(sparseLongArray, "$this$keyIterator");
        return new l() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // f.x.l
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @RequiresApi(18)
    @NotNull
    public static final SparseLongArray plus(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        j.f(sparseLongArray, "$this$plus");
        j.f(sparseLongArray2, "other");
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray2.size() + sparseLongArray.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        j.f(sparseLongArray, "$this$putAll");
        j.f(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i2), sparseLongArray2.valueAt(i2));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(@NotNull SparseLongArray sparseLongArray, int i2, long j2) {
        j.f(sparseLongArray, "$this$remove");
        int iIndexOfKey = sparseLongArray.indexOfKey(i2);
        if (iIndexOfKey < 0 || j2 != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(@NotNull SparseLongArray sparseLongArray, int i2, long j2) {
        j.f(sparseLongArray, "$this$set");
        sparseLongArray.put(i2, j2);
    }

    @RequiresApi(18)
    @NotNull
    public static final m valueIterator(@NotNull final SparseLongArray sparseLongArray) {
        j.f(sparseLongArray, "$this$valueIterator");
        return new m() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // f.x.m
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
