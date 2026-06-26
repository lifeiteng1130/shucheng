package io.legado.app.ui.rss.source.debug;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.ai;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.RssSource;
import io.legado.app.model.Debug;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceDebugModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR*\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006#"}, d2 = {"Lio/legado/app/ui/rss/source/debug/RssSourceDebugModel;", "Lio/legado/app/base/BaseViewModel;", "Lio/legado/app/model/Debug$Callback;", "", "state", "", NotificationCompat.CATEGORY_MESSAGE, "Lf/v;", "printLog", "(ILjava/lang/String;)V", "onCleared", "()V", "Lio/legado/app/data/entities/RssSource;", ai.aD, "Lio/legado/app/data/entities/RssSource;", "rssSource", "Lkotlin/Function2;", "d", "Lf/c0/b/p;", "callback", "e", "Ljava/lang/String;", "getListSrc", "()Ljava/lang/String;", "setListSrc", "(Ljava/lang/String;)V", "listSrc", "f", "getContentSrc", "setContentSrc", "contentSrc", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSourceDebugModel extends BaseViewModel implements Debug.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RssSource rssSource;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public p<? super Integer, ? super String, v> callback;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String listSrc;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String contentSrc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssSourceDebugModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    @Override // io.legado.app.base.BaseViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        Debug.INSTANCE.cancelDebug(true);
    }

    @Override // io.legado.app.model.Debug.Callback
    public void printLog(int state, @NotNull String msg) {
        j.e(msg, NotificationCompat.CATEGORY_MESSAGE);
        if (state == 10) {
            this.listSrc = msg;
            return;
        }
        if (state == 20) {
            this.contentSrc = msg;
            return;
        }
        p<? super Integer, ? super String, v> pVar = this.callback;
        if (pVar == null) {
            return;
        }
        pVar.invoke(Integer.valueOf(state), msg);
    }
}
