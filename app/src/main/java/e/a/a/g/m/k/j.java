package e.a.a.g.m.k;

import android.view.View;
import com.umeng.analytics.pro.ai;
import io.legado.app.databinding.ItemLogBinding;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextListDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements View.OnAttachStateChangeListener {
    public final /* synthetic */ ItemLogBinding a;

    public j(ItemLogBinding itemLogBinding) {
        this.a = itemLogBinding;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view) {
        f.c0.c.j.e(view, ai.aC);
        this.a.f6809b.setCursorVisible(false);
        this.a.f6809b.setCursorVisible(true);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View view) {
        f.c0.c.j.e(view, ai.aC);
    }
}
