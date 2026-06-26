package c.e.a.b.b;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: AppBarLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements AccessibilityViewCommand {
    public final /* synthetic */ CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f897e;

    public c(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
        this.f897e = baseBehavior;
        this.a = coordinatorLayout;
        this.f894b = appBarLayout;
        this.f895c = view;
        this.f896d = i2;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
        this.f897e.j(this.a, this.f894b, this.f895c, this.f896d, new int[]{0, 0});
        return true;
    }
}
