package e.a.a.c;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdProviderType.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum a {
    GDT("gdt"),
    CSJ("csj"),
    BAIDU("baidu");


    @NotNull
    private final String type;

    a(String str) {
        this.type = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static a[] valuesCustom() {
        a[] aVarArrValuesCustom = values();
        return (a[]) Arrays.copyOf(aVarArrValuesCustom, aVarArrValuesCustom.length);
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
