package e.a.a.g.d.l.b;

import android.view.View;
import com.umeng.analytics.pro.ai;
import io.legado.app.databinding.ItemSourceEditBinding;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookSourceEditAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements View.OnAttachStateChangeListener {
    public final /* synthetic */ ItemSourceEditBinding a;

    public f(ItemSourceEditBinding itemSourceEditBinding) {
        this.a = itemSourceEditBinding;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view) {
        f.c0.c.j.e(view, ai.aC);
        this.a.f6848b.setCursorVisible(false);
        this.a.f6848b.setCursorVisible(true);
        this.a.f6848b.setFocusable(true);
        this.a.f6848b.setFocusableInTouchMode(true);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View view) {
        f.c0.c.j.e(view, ai.aC);
    }
}
