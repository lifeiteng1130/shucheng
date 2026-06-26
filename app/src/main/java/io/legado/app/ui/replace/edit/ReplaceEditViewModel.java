package io.legado.app.ui.replace.edit;

import android.app.Application;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.ReplaceRule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReplaceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lio/legado/app/ui/replace/edit/ReplaceEditViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lio/legado/app/data/entities/ReplaceRule;", ai.aD, "Lio/legado/app/data/entities/ReplaceRule;", "getReplaceRule", "()Lio/legado/app/data/entities/ReplaceRule;", "setReplaceRule", "(Lio/legado/app/data/entities/ReplaceRule;)V", "replaceRule", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReplaceEditViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public ReplaceRule replaceRule;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplaceEditViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }
}
