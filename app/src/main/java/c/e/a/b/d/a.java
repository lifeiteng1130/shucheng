package c.e.a.b.d;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import c.e.a.b.y.m;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: compiled from: SwipeDismissBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements AccessibilityViewCommand {
    public final /* synthetic */ SwipeDismissBehavior a;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.a = swipeDismissBehavior;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
        boolean z = false;
        if (!this.a.a(view)) {
            return false;
        }
        boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
        int i2 = this.a.f2022d;
        if ((i2 == 0 && z2) || (i2 == 1 && !z2)) {
            z = true;
        }
        int width = view.getWidth();
        if (z) {
            width = -width;
        }
        ViewCompat.offsetLeftAndRight(view, width);
        view.setAlpha(0.0f);
        SwipeDismissBehavior.b bVar = this.a.f2020b;
        if (bVar != null) {
            ((m) bVar).a(view);
        }
        return true;
    }
}
