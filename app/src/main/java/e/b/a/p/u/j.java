package e.b.a.p.u;

import android.text.Layout;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextLayoutSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public final WeakReference<Layout> a;

    public j(@NonNull Layout layout) {
        this.a = new WeakReference<>(layout);
    }
}
