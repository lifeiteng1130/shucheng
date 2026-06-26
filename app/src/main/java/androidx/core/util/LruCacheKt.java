package androidx.core.util;

import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.r;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÿ\u0001\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000328\b\u0006\u0010\n\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u00052%\b\u0006\u0010\f\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000b2d\b\u0006\u0010\u0013\u001a^\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", ES6Iterator.VALUE_PROPERTY, "sizeOf", "Lkotlin/Function1;", "create", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "Lf/v;", "onEntryRemoved", "Landroid/util/LruCache;", "lruCache", "(ILf/c0/b/p;Lf/c0/b/l;Lf/c0/b/r;)Landroid/util/LruCache;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "<anonymous parameter 0>", "<anonymous parameter 1>", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class AnonymousClass1<K, V> extends k implements p<K, V, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(@NotNull K k2, @NotNull V v) {
            j.f(k2, "<anonymous parameter 0>");
            j.f(v, "<anonymous parameter 1>");
            return 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
            return Integer.valueOf(invoke2(obj, obj2));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0006\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class AnonymousClass2<K, V> extends k implements l<K, V> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // f.c0.b.l
        @Nullable
        public final V invoke(@NotNull K k2) {
            j.f(k2, "it");
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0001H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "Lf/v;", "invoke", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class AnonymousClass3<K, V> extends k implements r<Boolean, K, V, V, v> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.c0.b.r
        public /* bridge */ /* synthetic */ v invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
            invoke(bool.booleanValue(), obj, obj2, obj3);
            return v.a;
        }

        public final void invoke(boolean z, @NotNull K k2, @NotNull V v, @Nullable V v2) {
            j.f(k2, "<anonymous parameter 1>");
            j.f(v, "<anonymous parameter 2>");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "key", ES6Iterator.VALUE_PROPERTY, "", "sizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "create", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "evicted", "oldValue", "newValue", "Lf/v;", "entryRemoved", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "core-ktx_release"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        public final /* synthetic */ l $create;
        public final /* synthetic */ int $maxSize;
        public final /* synthetic */ r $onEntryRemoved;
        public final /* synthetic */ p $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(p pVar, l lVar, r rVar, int i2, int i3) {
            super(i3);
            this.$sizeOf = pVar;
            this.$create = lVar;
            this.$onEntryRemoved = rVar;
            this.$maxSize = i2;
        }

        @Override // android.util.LruCache
        @Nullable
        public V create(@NotNull K key) {
            j.f(key, "key");
            return (V) this.$create.invoke(key);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean evicted, @NotNull K key, @NotNull V oldValue, @Nullable V newValue) {
            j.f(key, "key");
            j.f(oldValue, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(evicted), key, oldValue, newValue);
        }

        @Override // android.util.LruCache
        public int sizeOf(@NotNull K key, @NotNull V value) {
            j.f(key, "key");
            j.f(value, ES6Iterator.VALUE_PROPERTY);
            return ((Number) this.$sizeOf.invoke(key, value)).intValue();
        }
    }

    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i2, @NotNull p<? super K, ? super V, Integer> pVar, @NotNull l<? super K, ? extends V> lVar, @NotNull r<? super Boolean, ? super K, ? super V, ? super V, v> rVar) {
        j.f(pVar, "sizeOf");
        j.f(lVar, "create");
        j.f(rVar, "onEntryRemoved");
        return new AnonymousClass4(pVar, lVar, rVar, i2, i2);
    }

    public static /* synthetic */ LruCache lruCache$default(int i2, p pVar, l lVar, r rVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            pVar = AnonymousClass1.INSTANCE;
        }
        p pVar2 = pVar;
        if ((i3 & 4) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        l lVar2 = lVar;
        if ((i3 & 8) != 0) {
            rVar = AnonymousClass3.INSTANCE;
        }
        r rVar2 = rVar;
        j.f(pVar2, "sizeOf");
        j.f(lVar2, "create");
        j.f(rVar2, "onEntryRemoved");
        return new AnonymousClass4(pVar2, lVar2, rVar2, i2, i2);
    }
}
