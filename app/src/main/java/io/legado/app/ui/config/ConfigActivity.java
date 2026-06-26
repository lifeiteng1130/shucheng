package io.legado.app.ui.config;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.v;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.databinding.ActivityConfigBinding;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$1;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ConfigActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lio/legado/app/ui/config/ConfigActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityConfigBinding;", "Lio/legado/app/ui/config/ConfigViewModel;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "N0", "()V", "g", "Lf/e;", "getViewModel", "()Lio/legado/app/ui/config/ConfigViewModel;", "viewModel", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ConfigActivity extends VMBaseActivity<ActivityConfigBinding, ConfigViewModel> {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: compiled from: ConfigActivity.kt */
    public static final class a extends k implements l<String, v> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, "it");
            ConfigActivity.this.recreate();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class b extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class c extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            j.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public ConfigActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(ConfigViewModel.class), new c(this), new b(this));
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_config, (ViewGroup) null, false);
        int i2 = R.id.configFrameLayout;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.configFrameLayout);
        if (linearLayout != null) {
            i2 = R.id.title_bar;
            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
            if (titleBar != null) {
                ActivityConfigBinding activityConfigBinding = new ActivityConfigBinding((LinearLayout) viewInflate, linearLayout, titleBar);
                j.d(activityConfigBinding, "inflate(layoutInflater)");
                return activityConfigBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void N0() {
        String[] strArr = {"RECREATE"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$1 = new EventBusExtensionsKt$observeEvent$o$1(new a());
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], String.class);
            j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        int intExtra = getIntent().getIntExtra("configType", -1);
        if (intExtra != -1) {
            ((ConfigViewModel) this.viewModel.getValue()).configType = intExtra;
        }
        int i2 = ((ConfigViewModel) this.viewModel.getValue()).configType;
        if (i2 == 0) {
            ((ActivityConfigBinding) K0()).f6509b.setTitle(getString(R.string.other_setting));
            Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("otherConfigFragment");
            if (fragmentFindFragmentByTag == null) {
                fragmentFindFragmentByTag = new OtherConfigFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.configFrameLayout, fragmentFindFragmentByTag, "otherConfigFragment").commit();
            return;
        }
        if (i2 == 1) {
            ((ActivityConfigBinding) K0()).f6509b.setTitle(getString(R.string.theme_setting));
            Fragment fragmentFindFragmentByTag2 = getSupportFragmentManager().findFragmentByTag("themeConfigFragment");
            if (fragmentFindFragmentByTag2 == null) {
                fragmentFindFragmentByTag2 = new ThemeConfigFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.configFrameLayout, fragmentFindFragmentByTag2, "themeConfigFragment").commit();
            return;
        }
        if (i2 != 2) {
            return;
        }
        ((ActivityConfigBinding) K0()).f6509b.setTitle(getString(R.string.backup_restore));
        Fragment fragmentFindFragmentByTag3 = getSupportFragmentManager().findFragmentByTag("backupConfigFragment");
        if (fragmentFindFragmentByTag3 == null) {
            fragmentFindFragmentByTag3 = new BackupConfigFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.configFrameLayout, fragmentFindFragmentByTag3, "backupConfigFragment").commit();
    }
}
