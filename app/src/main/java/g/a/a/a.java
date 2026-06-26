package g.a.a;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CacheImplementation.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum a {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;


    @NotNull
    public static final C0183a Companion = new Object(null) { // from class: g.a.a.a.a
    };

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static a[] valuesCustom() {
        a[] aVarArrValuesCustom = values();
        a[] aVarArr = new a[aVarArrValuesCustom.length];
        System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
        return aVarArr;
    }
}
