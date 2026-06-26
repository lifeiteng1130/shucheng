package io.legado.app.ui.config;

import android.app.Application;
import androidx.view.AndroidViewModel;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ConfigViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lio/legado/app/ui/config/ConfigViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "", ai.at, OptRuntime.GeneratorState.resumptionPoint_TYPE, "getConfigType", "()I", "setConfigType", "(I)V", "configType", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ConfigViewModel extends AndroidViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int configType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }
}
