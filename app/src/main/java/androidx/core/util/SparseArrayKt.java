package androidx.core.util;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.z.a;
import f.v;
import f.x.l;
import j$.util.Iterator;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: SparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a0\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b\t\u0010\n\u001a4\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b\f\u0010\r\u001a(\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u000e\u0010\u0006\u001a(\u0010\u000f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a0\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a6\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a \u0010\u0017\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a \u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a-\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a+\u0010\u001c\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001aX\u0010\"\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010!\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u001eH\u0086\b¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010%\u001a\u00020$\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b%\u0010&\u001a#\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b(\u0010)\"$\u0010,\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/SparseArray;", "", "key", "", "contains", "(Landroid/util/SparseArray;I)Z", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "set", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "other", "plus", "(Landroid/util/SparseArray;Landroid/util/SparseArray;)Landroid/util/SparseArray;", "containsKey", "containsValue", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "defaultValue", "getOrDefault", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseArray;ILf/c0/b/a;)Ljava/lang/Object;", "isEmpty", "(Landroid/util/SparseArray;)Z", "isNotEmpty", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "putAll", "(Landroid/util/SparseArray;Landroid/util/SparseArray;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroid/util/SparseArray;Lf/c0/b/p;)V", "Lf/x/l;", "keyIterator", "(Landroid/util/SparseArray;)Lf/x/l;", "", "valueIterator", "(Landroid/util/SparseArray;)Ljava/util/Iterator;", "getSize", "(Landroid/util/SparseArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SparseArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"androidx/core/util/SparseArrayKt$valueIterator$1", "", "", "hasNext", "()Z", "kotlin.jvm.PlatformType", ES6Iterator.NEXT_METHOD, "()Ljava/lang/Object;", "", "index", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getIndex", "()I", "setIndex", "(I)V", "core-ktx_release"}, k = 1, mv = {1, 4, 0})
    public static final class C02431<T> implements Iterator<T>, a, j$.util.Iterator {
        public final /* synthetic */ SparseArray $this_valueIterator;
        private int index;

        public C02431(SparseArray<T> sparseArray) {
            this.$this_valueIterator = sparseArray;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(j$.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public T next() {
            SparseArray sparseArray = this.$this_valueIterator;
            int i2 = this.index;
            this.index = i2 + 1;
            return (T) sparseArray.valueAt(i2);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }

    public static final <T> boolean contains(@NotNull SparseArray<T> sparseArray, int i2) {
        j.f(sparseArray, "$this$contains");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsKey(@NotNull SparseArray<T> sparseArray, int i2) {
        j.f(sparseArray, "$this$containsKey");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsValue(@NotNull SparseArray<T> sparseArray, T t) {
        j.f(sparseArray, "$this$containsValue");
        return sparseArray.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(@NotNull SparseArray<T> sparseArray, @NotNull p<? super Integer, ? super T, v> pVar) {
        j.f(sparseArray, "$this$forEach");
        j.f(pVar, "action");
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArray<T> sparseArray, int i2, T t) {
        j.f(sparseArray, "$this$getOrDefault");
        T t2 = sparseArray.get(i2);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(@NotNull SparseArray<T> sparseArray, int i2, @NotNull f.c0.b.a<? extends T> aVar) {
        j.f(sparseArray, "$this$getOrElse");
        j.f(aVar, "defaultValue");
        T t = sparseArray.get(i2);
        return t != null ? t : aVar.invoke();
    }

    public static final <T> int getSize(@NotNull SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$size");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@NotNull SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$isEmpty");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$isNotEmpty");
        return sparseArray.size() != 0;
    }

    @NotNull
    public static final <T> l keyIterator(@NotNull final SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$keyIterator");
        return new l() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // f.x.l
            public int nextInt() {
                SparseArray sparseArray2 = sparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @NotNull
    public static final <T> SparseArray<T> plus(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> sparseArray2) {
        j.f(sparseArray, "$this$plus");
        j.f(sparseArray2, "other");
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray2.size() + sparseArray.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> sparseArray2) {
        j.f(sparseArray, "$this$putAll");
        j.f(sparseArray2, "other");
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.put(sparseArray2.keyAt(i2), sparseArray2.valueAt(i2));
        }
    }

    public static final <T> boolean remove(@NotNull SparseArray<T> sparseArray, int i2, T t) {
        j.f(sparseArray, "$this$remove");
        int iIndexOfKey = sparseArray.indexOfKey(i2);
        if (iIndexOfKey < 0 || !j.a(t, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(@NotNull SparseArray<T> sparseArray, int i2, T t) {
        j.f(sparseArray, "$this$set");
        sparseArray.put(i2, t);
    }

    @NotNull
    public static final <T> java.util.Iterator<T> valueIterator(@NotNull SparseArray<T> sparseArray) {
        j.f(sparseArray, "$this$valueIterator");
        return new C02431(sparseArray);
    }
}
