package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import f.c0.c.j;
import f.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Pair.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a4\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a4\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0005\u001aH\u0010\b\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00008\u0000\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00018\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001a8\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0086\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"F", ExifInterface.LATITUDE_SOUTH, "Landroid/util/Pair;", "kotlin.jvm.PlatformType", "component1", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "Lf/g;", "toKotlinPair", "(Landroid/util/Pair;)Lf/g;", "toAndroidPair", "(Lf/g;)Landroid/util/Pair;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@NotNull android.util.Pair<F, S> pair) {
        j.f(pair, "$this$component1");
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@NotNull android.util.Pair<F, S> pair) {
        j.f(pair, "$this$component2");
        return (S) pair.second;
    }

    @NotNull
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@NotNull g<? extends F, ? extends S> gVar) {
        j.f(gVar, "$this$toAndroidPair");
        return new android.util.Pair<>(gVar.getFirst(), gVar.getSecond());
    }

    @NotNull
    public static final <F, S> g<F, S> toKotlinPair(@NotNull android.util.Pair<F, S> pair) {
        j.f(pair, "$this$toKotlinPair");
        return new g<>(pair.first, pair.second);
    }
}
