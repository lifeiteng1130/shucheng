package c.e.a.b.g;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import c.e.a.b.q.m;
import c.e.a.b.q.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: BottomSheetBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements m {
    public final /* synthetic */ BottomSheetBehavior a;

    public b(BottomSheetBehavior bottomSheetBehavior) {
        this.a = bottomSheetBehavior;
    }

    @Override // c.e.a.b.q.m
    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, n nVar) {
        this.a.f2090k = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
        this.a.s(false);
        return windowInsetsCompat;
    }
}
