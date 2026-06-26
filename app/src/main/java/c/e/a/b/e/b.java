package c.e.a.b.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.util.Objects;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f943e;

    public b(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i2, boolean z) {
        this.f943e = bottomAppBar;
        this.f940b = actionMenuView;
        this.f941c = i2;
        this.f942d = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.a) {
            return;
        }
        BottomAppBar bottomAppBar = this.f943e;
        int i2 = bottomAppBar.m;
        boolean z = i2 != 0;
        if (i2 != 0) {
            bottomAppBar.m = 0;
            bottomAppBar.getMenu().clear();
            bottomAppBar.inflateMenu(i2);
        }
        BottomAppBar bottomAppBar2 = this.f943e;
        ActionMenuView actionMenuView = this.f940b;
        int i3 = this.f941c;
        boolean z2 = this.f942d;
        Objects.requireNonNull(bottomAppBar2);
        c cVar = new c(bottomAppBar2, actionMenuView, i3, z2);
        if (z) {
            actionMenuView.post(cVar);
        } else {
            cVar.run();
        }
    }
}
