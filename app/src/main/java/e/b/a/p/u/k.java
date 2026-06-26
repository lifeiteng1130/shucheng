package e.b.a.p.u;

import android.widget.TextView;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextViewSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class k {
    public final WeakReference<TextView> a;

    public k(@NonNull TextView textView) {
        this.a = new WeakReference<>(textView);
    }
}
