package e.b.a.s;

import android.view.View;
import android.widget.TextView;
import io.noties.markwon.R$id;

/* JADX INFO: compiled from: AsyncDrawableScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements View.OnAttachStateChangeListener {
    public final /* synthetic */ TextView a;

    public d(TextView textView) {
        this.a = textView;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c.b.a.m.f.T5(this.a);
        view.removeOnAttachStateChangeListener(this);
        view.setTag(R$id.markwon_drawables_scheduler, null);
    }
}
