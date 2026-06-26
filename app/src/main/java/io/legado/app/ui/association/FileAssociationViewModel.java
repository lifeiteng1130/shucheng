package io.legado.app.ui.association;

import android.app.Application;
import android.content.Intent;
import androidx.view.MutableLiveData;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.base.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FileAssociationViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/legado/app/ui/association/FileAssociationViewModel;", "Lio/legado/app/base/BaseViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "getErrorLiveData", "()Landroidx/lifecycle/MutableLiveData;", "errorLiveData", "Landroid/content/Intent;", ai.aD, "getSuccessLiveData", "successLiveData", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FileAssociationViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Intent> successLiveData;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> errorLiveData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileAssociationViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.successLiveData = new MutableLiveData<>();
        this.errorLiveData = new MutableLiveData<>();
    }
}
