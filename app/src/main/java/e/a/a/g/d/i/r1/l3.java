package e.a.a.g.d.i.r1;

import android.view.View;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.databinding.ItemReadStyleBinding;
import io.legado.app.ui.book.read.config.ReadStyleDialog;

/* JADX INFO: compiled from: Click.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l3 implements View.OnLongClickListener {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemReadStyleBinding f5733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ReadStyleDialog f5734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ItemViewHolder f5735d;

    public l3(boolean z, ItemReadStyleBinding itemReadStyleBinding, ReadStyleDialog readStyleDialog, ItemViewHolder itemViewHolder) {
        this.a = z;
        this.f5733b = itemReadStyleBinding;
        this.f5734c = readStyleDialog;
        this.f5735d = itemViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.f5733b.f6815b.isInView) {
            ReadStyleDialog.Q(this.f5734c, this.f5735d.getLayoutPosition());
        }
        return this.a;
    }
}
