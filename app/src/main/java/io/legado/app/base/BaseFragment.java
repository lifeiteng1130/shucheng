package io.legado.app.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.umeng.analytics.pro.ai;
import e.a.a.h.m;
import f.c0.c.j;
import f.z.f;
import g.b.a0;
import g.b.f1;
import g.b.i1;
import g.b.k0;
import io.legado.app.base.BaseFragment;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001f\u0010\u001aJ\u0017\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\rH\u0002¢\u0006\u0004\b(\u0010\u001aR(\u0010.\u001a\u0004\u0018\u00010\u001b2\b\u0010)\u001a\u0004\u0018\u00010\u001b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0013\u00102\u001a\u00020/8G@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lio/legado/app/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lg/b/a0;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lf/v;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "R", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "(Z)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDestroy", "()V", "Landroidx/appcompat/widget/Toolbar;", "toolbar", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/appcompat/widget/Toolbar;)V", "O", "Landroid/view/Menu;", "menu", "P", "(Landroid/view/Menu;)V", "Landroid/view/MenuItem;", "item", "Q", "(Landroid/view/MenuItem;)V", ExifInterface.LATITUDE_SOUTH, "<set-?>", ai.aD, "Landroidx/appcompat/widget/Toolbar;", "getSupportToolbar", "()Landroidx/appcompat/widget/Toolbar;", "supportToolbar", "Landroid/view/MenuInflater;", "N", "()Landroid/view/MenuInflater;", "menuInflater", "Lg/b/f1;", "b", "Lg/b/f1;", "getJob", "()Lg/b/f1;", "setJob", "(Lg/b/f1;)V", "job", "Lf/z/f;", "getCoroutineContext", "()Lf/z/f;", "coroutineContext", "", "layoutID", "<init>", "(I)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseFragment extends Fragment implements a0 {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public f1 job;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Toolbar supportToolbar;

    public BaseFragment(int i2) {
        super(i2);
    }

    @SuppressLint({"RestrictedApi"})
    @NotNull
    public final MenuInflater N() {
        return new SupportMenuInflater(requireContext());
    }

    public void O() {
    }

    public void P(@NotNull Menu menu) {
        j.e(menu, "menu");
    }

    public void Q(@NotNull MenuItem item) {
        j.e(item, "item");
    }

    public abstract void R(@NotNull View view, @Nullable Bundle savedInstanceState);

    public final void S() {
        View view;
        TitleBar titleBar;
        FragmentActivity activity = getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        if (baseActivity == null || (view = getView()) == null || (titleBar = (TitleBar) view.findViewById(R.id.title_bar)) == null) {
            return;
        }
        titleBar.h(baseActivity.M0(), baseActivity.fullScreen);
    }

    public final void T(@NotNull Toolbar toolbar) {
        j.e(toolbar, "toolbar");
        this.supportToolbar = toolbar;
        if (toolbar == null) {
            return;
        }
        Menu menu = toolbar.getMenu();
        j.d(menu, "this");
        P(menu);
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        m.b(menu, contextRequireContext, null, 2);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: e.a.a.b.a
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BaseFragment baseFragment = this.a;
                int i2 = BaseFragment.a;
                j.e(baseFragment, "this$0");
                j.d(menuItem, "item");
                baseFragment.Q(menuItem);
                return true;
            }
        });
    }

    @Override // g.b.a0
    @NotNull
    public f getCoroutineContext() {
        f1 f1Var = this.job;
        if (f1Var != null) {
            k0 k0Var = k0.f6264c;
            return f1Var.plus(g.b.g2.m.f6207b);
        }
        j.m("job");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        j.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        S();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        i1 i1Var = new i1(null);
        j.e(i1Var, "<set-?>");
        this.job = i1Var;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f1 f1Var = this.job;
        if (f1Var != null) {
            c.b.a.m.f.J0(f1Var, null, 1, null);
        } else {
            j.m("job");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        S();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        S();
        R(view, savedInstanceState);
        O();
    }
}
