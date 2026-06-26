package c.e.a.b.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: ViewOffsetBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public class h<V extends View> extends CoordinatorLayout.Behavior<V> {
    public i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f912b;

    public h() {
        this.f912b = 0;
    }

    public int a() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.f915d;
        }
        return 0;
    }

    public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        coordinatorLayout.onLayoutChild(v, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        b(coordinatorLayout, v, i2);
        if (this.a == null) {
            this.a = new i(v);
        }
        i iVar = this.a;
        iVar.f913b = iVar.a.getTop();
        iVar.f914c = iVar.a.getLeft();
        this.a.a();
        int i3 = this.f912b;
        if (i3 == 0) {
            return true;
        }
        this.a.b(i3);
        this.f912b = 0;
        return true;
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f912b = 0;
    }
}
