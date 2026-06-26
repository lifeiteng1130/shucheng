package e.b.a.q.a;

import android.view.View;
import android.widget.TextView;
import io.noties.markwon.ext.tables.R$id;

/* JADX INFO: compiled from: TableRowsScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements View.OnAttachStateChangeListener {
    public final /* synthetic */ TextView a;

    public h(TextView textView) {
        this.a = textView;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c.b.a.m.f.S5(this.a);
        this.a.removeOnAttachStateChangeListener(this);
        this.a.setTag(R$id.markwon_tables_scheduler, null);
    }
}
