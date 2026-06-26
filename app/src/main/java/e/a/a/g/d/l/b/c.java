package e.a.a.g.d.l.b;

import com.google.android.material.tabs.TabLayout;
import io.legado.app.ui.book.source.edit.BookSourceEditActivity;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements TabLayout.d {
    public final /* synthetic */ BookSourceEditActivity a;

    public c(BookSourceEditActivity bookSourceEditActivity) {
        this.a = bookSourceEditActivity;
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void K(@Nullable TabLayout.g gVar) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void m(@Nullable TabLayout.g gVar) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void x(@Nullable TabLayout.g gVar) {
        BookSourceEditActivity bookSourceEditActivity = this.a;
        Integer numValueOf = gVar == null ? null : Integer.valueOf(gVar.f2438d);
        int i2 = BookSourceEditActivity.f7298g;
        bookSourceEditActivity.Y0(numValueOf);
    }
}
