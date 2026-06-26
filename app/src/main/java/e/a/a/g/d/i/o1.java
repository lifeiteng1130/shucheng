package e.a.a.g.d.i;

import android.view.View;
import io.legado.app.ui.book.read.ReadMenu;

/* JADX INFO: compiled from: Click.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o1 implements View.OnLongClickListener {
    public final /* synthetic */ ReadMenu a;

    public o1(boolean z, ReadMenu readMenu) {
        this.a = readMenu;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ReadMenu readMenu = this.a;
        readMenu.h(new d1(readMenu));
        return true;
    }
}
