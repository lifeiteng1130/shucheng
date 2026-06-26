package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Half.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\bH\u0087\b¢\u0006\u0004\b\u0002\u0010\t¨\u0006\n"}, d2 = {"", "Landroid/util/Half;", "toHalf", "(S)Landroid/util/Half;", "", "(F)Landroid/util/Half;", "", "(D)Landroid/util/Half;", "", "(Ljava/lang/String;)Landroid/util/Half;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class HalfKt {
    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(short s) {
        Half halfValueOf = Half.valueOf(s);
        j.b(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(float f2) {
        Half halfValueOf = Half.valueOf(f2);
        j.b(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(@NotNull String str) {
        j.f(str, "$this$toHalf");
        Half halfValueOf = Half.valueOf(str);
        j.b(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(double d2) {
        Half halfValueOf = Half.valueOf((float) d2);
        j.b(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }
}
