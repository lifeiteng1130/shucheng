package c.e.a.b.b;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f916e;

    public i(View view) {
        this.a = view;
    }

    public void a() {
        View view = this.a;
        ViewCompat.offsetTopAndBottom(view, this.f915d - (view.getTop() - this.f913b));
        View view2 = this.a;
        ViewCompat.offsetLeftAndRight(view2, this.f916e - (view2.getLeft() - this.f914c));
    }

    public boolean b(int i2) {
        if (this.f915d == i2) {
            return false;
        }
        this.f915d = i2;
        a();
        return true;
    }
}
