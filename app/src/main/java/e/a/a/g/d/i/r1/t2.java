package e.a.a.g.d.i.r1;

import android.view.View;
import android.widget.TextView;
import io.legado.app.ui.book.read.config.ClickActionConfigDialog;

/* JADX INFO: compiled from: ClickActionConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t2 extends f.c0.c.k implements f.c0.b.l<Integer, f.v> {
    public final /* synthetic */ View $it;
    public final /* synthetic */ ClickActionConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t2(ClickActionConfigDialog clickActionConfigDialog, View view) {
        super(1);
        this.this$0 = clickActionConfigDialog;
        this.$it = view;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(Integer num) {
        invoke(num.intValue());
        return f.v.a;
    }

    public final void invoke(int i2) {
        e.a.a.h.m.i(this.this$0, "clickActionBottomRight", i2);
        View view = this.$it;
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView == null) {
            return;
        }
        textView.setText(this.this$0.actions.get(Integer.valueOf(i2)));
    }
}
