package androidx.view;

import android.view.View;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: androidx.savedstate.ViewKt, reason: from Kotlin metadata and case insensitive filesystem */
/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/View;", "Landroidx/savedstate/SavedStateRegistryOwner;", "findViewTreeSavedStateRegistryOwner", "(Landroid/view/View;)Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class C0255ViewKt {
    @Nullable
    public static final SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(@NotNull View view) {
        j.e(view, "$this$findViewTreeSavedStateRegistryOwner");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
