package c.e.a.b.y;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements SwipeDismissBehavior.b {
    public final /* synthetic */ BaseTransientBottomBar a;

    public m(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    public void a(@NonNull View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        this.a.b(0);
    }
}
