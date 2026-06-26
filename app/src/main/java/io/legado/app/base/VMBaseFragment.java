package io.legado.app.base;

import androidx.view.ViewModel;
import com.umeng.analytics.MobclickAgent;
import kotlin.Metadata;

/* JADX INFO: compiled from: VMBaseFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\f"}, d2 = {"Lio/legado/app/base/VMBaseFragment;", "Landroidx/lifecycle/ViewModel;", "VM", "Lio/legado/app/base/BaseFragment;", "Lf/v;", "onResume", "()V", "onPause", "", "layoutID", "<init>", "(I)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class VMBaseFragment<VM extends ViewModel> extends BaseFragment {
    public VMBaseFragment(int i2) {
        super(i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        // AD REMOVED: MobclickAgent.onPageEnd(getClass().getName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        // AD REMOVED: MobclickAgent.onPageStart(getClass().getName());
    }
}
