package io.legado.app.ui.about;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import f.c0.c.j;
import io.legado.app.base.BaseActivity;
import io.legado.app.databinding.ActivityDonateBinding;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonateActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lio/legado/app/ui/about/DonateActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivityDonateBinding;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class DonateActivity extends BaseActivity<ActivityDonateBinding> {
    public DonateActivity() {
        super(false, null, null, false, false, 31);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_donate, (ViewGroup) null, false);
        int i2 = R.id.fl_fragment;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.fl_fragment);
        if (frameLayout != null) {
            LinearLayout linearLayout = (LinearLayout) viewInflate;
            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
            if (titleBar != null) {
                ActivityDonateBinding activityDonateBinding = new ActivityDonateBinding(linearLayout, frameLayout, linearLayout, titleBar);
                j.d(activityDonateBinding, "inflate(layoutInflater)");
                return activityDonateBinding;
            }
            i2 = R.id.title_bar;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("donateFragment");
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = new DonateFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, fragmentFindFragmentByTag, "donateFragment").commit();
    }
}
