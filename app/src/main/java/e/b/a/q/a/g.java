package e.b.a.q.a;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import io.noties.markwon.ext.tables.TableRowSpan;

/* JADX INFO: compiled from: TableRowSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends TableRowSpan.b {
    public final /* synthetic */ Runnable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TableRowSpan tableRowSpan, Runnable runnable) {
        super(null);
        this.a = runnable;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        this.a.run();
    }
}
