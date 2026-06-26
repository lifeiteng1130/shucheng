package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.z.a;
import f.v;
import f.x.l;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: SparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a0\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b\t\u0010\n\u001a4\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b\f\u0010\r\u001a0\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a6\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a \u0010\u0014\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aX\u0010\u001c\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0018H\u0086\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001d\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\"\u0010#\"$\u0010&\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/SparseArrayCompat;", "", "key", "", "contains", "(Landroidx/collection/SparseArrayCompat;I)Z", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "set", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "other", "plus", "(Landroidx/collection/SparseArrayCompat;Landroidx/collection/SparseArrayCompat;)Landroidx/collection/SparseArrayCompat;", "defaultValue", "getOrDefault", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroidx/collection/SparseArrayCompat;ILf/c0/b/a;)Ljava/lang/Object;", "isNotEmpty", "(Landroidx/collection/SparseArrayCompat;)Z", "remove", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroidx/collection/SparseArrayCompat;Lf/c0/b/p;)V", "Lf/x/l;", "keyIterator", "(Landroidx/collection/SparseArrayCompat;)Lf/x/l;", "", "valueIterator", "(Landroidx/collection/SparseArrayCompat;)Ljava/util/Iterator;", "getSize", "(Landroidx/collection/SparseArrayCompat;)I", "size", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SparseArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"androidx/collection/SparseArrayKt$valueIterator$1", "", "", "hasNext", "()Z", "kotlin.jvm.PlatformType", ES6Iterator.NEXT_METHOD, "()Ljava/lang/Object;", "", "index", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getIndex", "()I", "setIndex", "(I)V", "collection-ktx"}, k = 1, mv = {1, 4, 0})
    public static final class C02381<T> implements Iterator<T>, a, j$.util.Iterator {
        public final /* synthetic */ SparseArrayCompat $this_valueIterator;
        private int index;

        public C02381(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_valueIterator = sparseArrayCompat;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
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
            SparseArrayCompat sparseArrayCompat = this.$this_valueIterator;
            int i2 = this.index;
            this.index = i2 + 1;
            return (T) sparseArrayCompat.valueAt(i2);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }

    public static final <T> boolean contains(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i2) {
        j.f(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.containsKey(i2);
    }

    public static final <T> void forEach(@NotNull SparseArrayCompat<T> sparseArrayCompat, @NotNull p<? super Integer, ? super T, v> pVar) {
        j.f(sparseArrayCompat, "receiver$0");
        j.f(pVar, "action");
        int size = sparseArrayCompat.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i2)), sparseArrayCompat.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i2, T t) {
        j.f(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.get(i2, t);
    }

    public static final <T> T getOrElse(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i2, @NotNull f.c0.b.a<? extends T> aVar) {
        j.f(sparseArrayCompat, "receiver$0");
        j.f(aVar, "defaultValue");
        T t = sparseArrayCompat.get(i2);
        return t != null ? t : aVar.invoke();
    }

    public static final <T> int getSize(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        j.f(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        j.f(sparseArrayCompat, "receiver$0");
        return !sparseArrayCompat.isEmpty();
    }

    @NotNull
    public static final <T> l keyIterator(@NotNull final SparseArrayCompat<T> sparseArrayCompat) {
        j.f(sparseArrayCompat, "receiver$0");
        return new l() { // from class: androidx.collection.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArrayCompat.size();
            }

            @Override // f.x.l
            public int nextInt() {
                SparseArrayCompat sparseArrayCompat2 = sparseArrayCompat;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArrayCompat2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @NotNull
    public static final <T> SparseArrayCompat<T> plus(@NotNull SparseArrayCompat<T> sparseArrayCompat, @NotNull SparseArrayCompat<T> sparseArrayCompat2) {
        j.f(sparseArrayCompat, "receiver$0");
        j.f(sparseArrayCompat2, "other");
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<>(sparseArrayCompat2.size() + sparseArrayCompat.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    @Deprecated(message = "Replaced with member function. Remove extension import!")
    public static final <T> boolean remove(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i2, T t) {
        j.f(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.remove(i2, t);
    }

    public static final <T> void set(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i2, T t) {
        j.f(sparseArrayCompat, "receiver$0");
        sparseArrayCompat.put(i2, t);
    }

    @NotNull
    public static final <T> java.util.Iterator<T> valueIterator(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        j.f(sparseArrayCompat, "receiver$0");
        return new C02381(sparseArrayCompat);
    }
}
