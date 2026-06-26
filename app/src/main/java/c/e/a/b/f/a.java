package c.e.a.b.f;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import c.e.a.b.q.m;
import c.e.a.b.q.n;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* JADX INFO: compiled from: BottomNavigationView.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements m {
    public a(BottomNavigationView bottomNavigationView) {
    }

    @Override // c.e.a.b.q.m
    @NonNull
    public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull n nVar) {
        nVar.f1131d = windowInsetsCompat.getSystemWindowInsetBottom() + nVar.f1131d;
        boolean z = ViewCompat.getLayoutDirection(view) == 1;
        int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
        int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
        int i2 = nVar.a + (z ? systemWindowInsetRight : systemWindowInsetLeft);
        nVar.a = i2;
        int i3 = nVar.f1130c;
        if (!z) {
            systemWindowInsetLeft = systemWindowInsetRight;
        }
        int i4 = i3 + systemWindowInsetLeft;
        nVar.f1130c = i4;
        ViewCompat.setPaddingRelative(view, i2, nVar.f1129b, i4, nVar.f1131d);
        return windowInsetsCompat;
    }
}
