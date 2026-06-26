package io.legado.app.ui.rss.article;

import android.app.Application;
import androidx.view.MutableLiveData;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.base.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: RssArticlesViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001f¨\u00061"}, d2 = {"Lio/legado/app/ui/rss/article/RssArticlesViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "f", "Ljava/lang/String;", "nextPageUrl", "", "d", "Z", "isLoading", "()Z", "setLoading", "(Z)V", "", "e", "J", "getOrder", "()J", "setOrder", "(J)V", "order", "Landroidx/lifecycle/MutableLiveData;", ai.aD, "Landroidx/lifecycle/MutableLiveData;", "getLoadFinally", "()Landroidx/lifecycle/MutableLiveData;", "loadFinally", "g", "getSortName", "()Ljava/lang/String;", "setSortName", "(Ljava/lang/String;)V", "sortName", "", ai.aA, OptRuntime.GeneratorState.resumptionPoint_TYPE, "getPage", "()I", "setPage", "(I)V", "page", "h", "getSortUrl", "setSortUrl", "sortUrl", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssArticlesViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> loadFinally;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean isLoading;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long order;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String nextPageUrl;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String sortName;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String sortUrl;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int page;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssArticlesViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.loadFinally = new MutableLiveData<>();
        this.isLoading = true;
        this.order = System.currentTimeMillis();
        this.sortName = "";
        this.sortUrl = "";
        this.page = 1;
    }
}
