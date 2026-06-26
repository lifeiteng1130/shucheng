package io.legado.app.ui.association;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import e.a.a.g.b.q;
import e.a.a.g.b.r;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.v;
import f.e;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.databinding.ActivityTranslucenceBinding;
import io.legado.app.ui.association.FileAssociationActivity;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FileAssociationActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\r\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lio/legado/app/ui/association/FileAssociationActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityTranslucenceBinding;", "Lio/legado/app/ui/association/FileAssociationViewModel;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/association/FileAssociationViewModel;", "viewModel", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FileAssociationActivity extends VMBaseActivity<ActivityTranslucenceBinding, FileAssociationViewModel> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f6980g = 0;

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

    public FileAssociationActivity() {
        super(false, e.a.a.c.e.Transparent, null, false, false, 29);
        this.viewModel = new ViewModelLazy(v.a(FileAssociationViewModel.class), new b(this), new a(this));
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
        ((ActivityTranslucenceBinding) K0()).f6569b.b();
        T0().errorLiveData.observe(this, new Observer() { // from class: e.a.a.g.b.b
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                FileAssociationActivity fileAssociationActivity = this.a;
                int i2 = FileAssociationActivity.f6980g;
                f.c0.c.j.e(fileAssociationActivity, "this$0");
                ((ActivityTranslucenceBinding) fileAssociationActivity.K0()).f6569b.a();
                c.b.a.m.f.R5(fileAssociationActivity, (String) obj);
                fileAssociationActivity.finish();
            }
        });
        T0().successLiveData.observe(this, new Observer() { // from class: e.a.a.g.b.a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                FileAssociationActivity fileAssociationActivity = this.a;
                int i2 = FileAssociationActivity.f6980g;
                f.c0.c.j.e(fileAssociationActivity, "this$0");
                ((ActivityTranslucenceBinding) fileAssociationActivity.K0()).f6569b.a();
                fileAssociationActivity.startActivity((Intent) obj);
                fileAssociationActivity.finish();
            }
        });
        Uri data = getIntent().getData();
        if (data == null) {
            return;
        }
        FileAssociationViewModel fileAssociationViewModelT0 = T0();
        Objects.requireNonNull(fileAssociationViewModelT0);
        j.e(data, "uri");
        e.a.a.d.u.b.b(BaseViewModel.a(fileAssociationViewModelT0, null, null, new q(data, fileAssociationViewModelT0, null), 3, null), null, new r(fileAssociationViewModelT0, null), 1);
    }

    @NotNull
    public FileAssociationViewModel T0() {
        return (FileAssociationViewModel) this.viewModel.getValue();
    }
}
