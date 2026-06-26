package c.e.a.b.q;

import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
public class h implements i {
    public final ViewOverlay a;

    public h(@NonNull View view) {
        this.a = view.getOverlay();
    }
}
