package io.legado.app.base;

import androidx.view.ViewModel;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.MobclickAgent;
import e.a.a.c.e;
import f.c0.c.j;
import kotlin.Metadata;

/* JADX INFO: compiled from: VMBaseActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lio/legado/app/base/VMBaseActivity;", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/lifecycle/ViewModel;", "VM", "Lio/legado/app/base/BaseActivity;", "Lf/v;", "onResume", "()V", "onPause", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class VMBaseActivity<VB extends ViewBinding, VM extends ViewModel> extends BaseActivity<VB> {
    public VMBaseActivity() {
        this(false, null, null, false, false, 31);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VMBaseActivity(boolean z, e eVar, e eVar2, boolean z2, boolean z3, int i2) {
        boolean z4 = (i2 & 1) != 0 ? true : z;
        e eVar3 = (i2 & 2) != 0 ? e.Auto : eVar;
        e eVar4 = (i2 & 4) != 0 ? e.Auto : eVar2;
        boolean z5 = (i2 & 8) != 0 ? false : z2;
        boolean z6 = (i2 & 16) != 0 ? true : z3;
        j.e(eVar3, "theme");
        j.e(eVar4, "toolBarTheme");
        super(z4, eVar3, eVar4, z5, z6);
    }

    @Override // io.legado.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        // AD REMOVED: MobclickAgent.onPageEnd(getClass().getName());
    }

    @Override // io.legado.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        // AD REMOVED: MobclickAgent.onPageStart(getClass().getName());
    }
}
