package c.e.a.b.e;

import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {
    public final /* synthetic */ ActionMenuView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f946d;

    public c(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i2, boolean z) {
        this.f946d = bottomAppBar;
        this.a = actionMenuView;
        this.f944b = i2;
        this.f945c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.setTranslationX(this.f946d.j(r0, this.f944b, this.f945c));
    }
}
