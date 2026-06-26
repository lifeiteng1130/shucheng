package e.a.a.g.d.j;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import g.b.k0;
import g.b.y0;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.SearchKeyword;
import io.legado.app.ui.book.search.HistoryKeyAdapter;
import io.legado.app.ui.widget.anima.explosion_field.ExplosionView;
import java.util.Objects;

/* JADX INFO: compiled from: Click.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements View.OnLongClickListener {
    public final /* synthetic */ HistoryKeyAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f5808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ItemViewHolder f5809c;

    public o(boolean z, HistoryKeyAdapter historyKeyAdapter, View view, ItemViewHolder itemViewHolder) {
        this.a = historyKeyAdapter;
        this.f5808b = view;
        this.f5809c = itemViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ExplosionView explosionView = this.a.explosionField;
        f.c0.c.j.d(this.f5808b, "this");
        View view2 = this.f5808b;
        Boolean bool = Boolean.TRUE;
        Objects.requireNonNull(explosionView);
        f.c0.c.j.e(view2, "view");
        Rect rect = new Rect();
        view2.getGlobalVisibleRect(rect);
        int[] iArr = new int[2];
        explosionView.getLocationOnScreen(iArr);
        rect.offset(-iArr[0], -iArr[1]);
        int[] iArr2 = explosionView.mExpandInset;
        rect.inset(-iArr2[0], -iArr2[1]);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
        duration.addUpdateListener(new e.a.a.g.m.i.d.b(view2));
        duration.addListener(new e.a.a.g.m.i.d.c(explosionView));
        duration.start();
        long j2 = 100;
        view2.animate().setDuration(150L).setStartDelay(j2).scaleX(0.0f).scaleY(0.0f).alpha(0.0f).start();
        f.c0.c.j.c(bool);
        e.a.a.g.m.i.d.e eVar = e.a.a.g.m.i.d.e.a;
        explosionView.a(e.a.a.g.m.i.d.e.a(view2), rect, j2, view2);
        SearchKeyword item = this.a.getItem(this.f5809c.getLayoutPosition());
        if (item != null) {
            y0 y0Var = y0.a;
            k0 k0Var = k0.f6264c;
            c.b.a.m.f.L3(y0Var, k0.f6263b, null, new n(item, null), 2, null);
        }
        return true;
    }
}
