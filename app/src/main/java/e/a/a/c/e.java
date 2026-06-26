package e.a.a.c;

import f.c0.c.f;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum e {
    Dark,
    Light,
    Auto,
    Transparent,
    EInk;


    @NotNull
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: Theme.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static e[] valuesCustom() {
        e[] eVarArrValuesCustom = values();
        return (e[]) Arrays.copyOf(eVarArrValuesCustom, eVarArrValuesCustom.length);
    }
}
