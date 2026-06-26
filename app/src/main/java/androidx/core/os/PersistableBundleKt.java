package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import f.c0.c.j;
import f.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistableBundle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lf/g;", "", "", "pairs", "Landroid/os/PersistableBundle;", "persistableBundleOf", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class PersistableBundleKt {
    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle persistableBundleOf(@NotNull g<String, ? extends Object>... gVarArr) {
        j.f(gVarArr, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(gVarArr.length);
        for (g<String, ? extends Object> gVar : gVarArr) {
            String strComponent1 = gVar.component1();
            Object objComponent2 = gVar.component2();
            if (objComponent2 == null) {
                persistableBundle.putString(strComponent1, null);
            } else if (objComponent2 instanceof Boolean) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean for key \"" + strComponent1 + '\"');
                }
                persistableBundle.putBoolean(strComponent1, ((Boolean) objComponent2).booleanValue());
            } else if (objComponent2 instanceof Double) {
                persistableBundle.putDouble(strComponent1, ((Number) objComponent2).doubleValue());
            } else if (objComponent2 instanceof Integer) {
                persistableBundle.putInt(strComponent1, ((Number) objComponent2).intValue());
            } else if (objComponent2 instanceof Long) {
                persistableBundle.putLong(strComponent1, ((Number) objComponent2).longValue());
            } else if (objComponent2 instanceof String) {
                persistableBundle.putString(strComponent1, (String) objComponent2);
            } else if (objComponent2 instanceof boolean[]) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + strComponent1 + '\"');
                }
                persistableBundle.putBooleanArray(strComponent1, (boolean[]) objComponent2);
            } else if (objComponent2 instanceof double[]) {
                persistableBundle.putDoubleArray(strComponent1, (double[]) objComponent2);
            } else if (objComponent2 instanceof int[]) {
                persistableBundle.putIntArray(strComponent1, (int[]) objComponent2);
            } else if (objComponent2 instanceof long[]) {
                persistableBundle.putLongArray(strComponent1, (long[]) objComponent2);
            } else {
                if (!(objComponent2 instanceof Object[])) {
                    throw new IllegalArgumentException("Illegal value type " + objComponent2.getClass().getCanonicalName() + " for key \"" + strComponent1 + '\"');
                }
                Class<?> componentType = objComponent2.getClass().getComponentType();
                if (componentType == null) {
                    j.l();
                    throw null;
                }
                j.b(componentType, "value::class.java.componentType!!");
                if (!String.class.isAssignableFrom(componentType)) {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + strComponent1 + '\"');
                }
                persistableBundle.putStringArray(strComponent1, (String[]) objComponent2);
            }
        }
        return persistableBundle;
    }
}
