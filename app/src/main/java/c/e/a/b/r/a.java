package c.e.a.b.r;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: NavigationView.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ NavigationView a;

    public a(NavigationView navigationView) {
        this.a = navigationView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Activity activity;
        NavigationView navigationView = this.a;
        navigationView.getLocationOnScreen(navigationView.m);
        NavigationView navigationView2 = this.a;
        boolean z = navigationView2.m[1] == 0;
        NavigationMenuPresenter navigationMenuPresenter = navigationView2.f2311j;
        if (navigationMenuPresenter.q != z) {
            navigationMenuPresenter.q = z;
            navigationMenuPresenter.d();
        }
        this.a.setDrawTopInsetForeground(z);
        Context context = this.a.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activity != null) {
            this.a.setDrawBottomInsetForeground((activity.findViewById(R.id.content).getHeight() == this.a.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
        }
    }
}
