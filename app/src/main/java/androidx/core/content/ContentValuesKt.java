package androidx.core.content;

import android.content.ContentValues;
import f.c0.c.j;
import f.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentValues.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lf/g;", "", "", "pairs", "Landroid/content/ContentValues;", "contentValuesOf", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class ContentValuesKt {
    @NotNull
    public static final ContentValues contentValuesOf(@NotNull g<String, ? extends Object>... gVarArr) {
        j.f(gVarArr, "pairs");
        ContentValues contentValues = new ContentValues(gVarArr.length);
        for (g<String, ? extends Object> gVar : gVarArr) {
            String strComponent1 = gVar.component1();
            Object objComponent2 = gVar.component2();
            if (objComponent2 == null) {
                contentValues.putNull(strComponent1);
            } else if (objComponent2 instanceof String) {
                contentValues.put(strComponent1, (String) objComponent2);
            } else if (objComponent2 instanceof Integer) {
                contentValues.put(strComponent1, (Integer) objComponent2);
            } else if (objComponent2 instanceof Long) {
                contentValues.put(strComponent1, (Long) objComponent2);
            } else if (objComponent2 instanceof Boolean) {
                contentValues.put(strComponent1, (Boolean) objComponent2);
            } else if (objComponent2 instanceof Float) {
                contentValues.put(strComponent1, (Float) objComponent2);
            } else if (objComponent2 instanceof Double) {
                contentValues.put(strComponent1, (Double) objComponent2);
            } else if (objComponent2 instanceof byte[]) {
                contentValues.put(strComponent1, (byte[]) objComponent2);
            } else if (objComponent2 instanceof Byte) {
                contentValues.put(strComponent1, (Byte) objComponent2);
            } else {
                if (!(objComponent2 instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objComponent2.getClass().getCanonicalName() + " for key \"" + strComponent1 + '\"');
                }
                contentValues.put(strComponent1, (Short) objComponent2);
            }
        }
        return contentValues;
    }
}
