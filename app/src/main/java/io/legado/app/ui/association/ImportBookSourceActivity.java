package io.legado.app.ui.association;

import android.net.Uri;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import e.a.a.d.o;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.v;
import f.e;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.databinding.ActivityTranslucenceBinding;
import io.legado.app.ui.association.ImportBookSourceActivity;
import io.legado.app.ui.association.ImportBookSourceDialog;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookSourceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\r\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lio/legado/app/ui/association/ImportBookSourceActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityTranslucenceBinding;", "Lio/legado/app/ui/association/ImportBookSourceViewModel;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/association/ImportBookSourceViewModel;", "viewModel", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ImportBookSourceActivity extends VMBaseActivity<ActivityTranslucenceBinding, ImportBookSourceViewModel> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f6984g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class a extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ComponentActivity componentActivity) {
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
    public static final class b extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
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

    public ImportBookSourceActivity() {
        super(false, e.a.a.c.e.Transparent, null, false, false, 29);
        this.viewModel = new ViewModelLazy(v.a(ImportBookSourceViewModel.class), new b(this), new a(this));
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        ActivityTranslucenceBinding activityTranslucenceBindingA = ActivityTranslucenceBinding.a(getLayoutInflater());
        j.d(activityTranslucenceBindingA, "inflate(layoutInflater)");
        return activityTranslucenceBindingA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        String str;
        ((ActivityTranslucenceBinding) K0()).f6569b.b();
        T0().errorLiveData.observe(this, new Observer() { // from class: e.a.a.g.b.c
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ImportBookSourceActivity importBookSourceActivity = this.a;
                String str2 = (String) obj;
                int i2 = ImportBookSourceActivity.f6984g;
                f.c0.c.j.e(importBookSourceActivity, "this$0");
                ((ActivityTranslucenceBinding) importBookSourceActivity.K0()).f6569b.a();
                f.c0.c.j.d(str2, "it");
                ((e.a.a.e.a.i) c.b.a.m.f.g0(importBookSourceActivity, importBookSourceActivity.getString(R.string.error), str2, new s(importBookSourceActivity))).p();
            }
        });
        T0().successLiveData.observe(this, new Observer() { // from class: e.a.a.g.b.d
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ImportBookSourceActivity importBookSourceActivity = this.a;
                Integer num = (Integer) obj;
                int i2 = ImportBookSourceActivity.f6984g;
                f.c0.c.j.e(importBookSourceActivity, "this$0");
                ((ActivityTranslucenceBinding) importBookSourceActivity.K0()).f6569b.a();
                f.c0.c.j.d(num, "it");
                if (num.intValue() <= 0) {
                    String string = importBookSourceActivity.getString(R.string.wrong_format);
                    f.c0.c.j.d(string, "getString(R.string.wrong_format)");
                    ((e.a.a.e.a.i) c.b.a.m.f.g0(importBookSourceActivity, importBookSourceActivity.getString(R.string.error), string, new s(importBookSourceActivity))).p();
                } else {
                    ImportBookSourceDialog importBookSourceDialog = new ImportBookSourceDialog();
                    FragmentManager supportFragmentManager = importBookSourceActivity.getSupportFragmentManager();
                    f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                    importBookSourceDialog.show(supportFragmentManager, "SourceDialog");
                }
            }
        });
        String stringExtra = getIntent().getStringExtra("dataKey");
        if (stringExtra != null && (str = (String) o.a.a(stringExtra)) != null) {
            T0().f(str);
            return;
        }
        String stringExtra2 = getIntent().getStringExtra("source");
        if (stringExtra2 != null) {
            T0().f(stringExtra2);
            return;
        }
        Uri data = getIntent().getData();
        if (data == null) {
            return;
        }
        if (!j.a(data.getPath(), "/importonline")) {
            ((ActivityTranslucenceBinding) K0()).f6569b.a();
            f.Q5(this, R.string.wrong_format);
            finish();
        } else {
            String queryParameter = data.getQueryParameter("src");
            if (queryParameter == null) {
                return;
            }
            T0().f(queryParameter);
        }
    }

    @NotNull
    public ImportBookSourceViewModel T0() {
        return (ImportBookSourceViewModel) this.viewModel.getValue();
    }
}
