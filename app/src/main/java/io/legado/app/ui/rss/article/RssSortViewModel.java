package io.legado.app.ui.rss.article;

import android.app.Application;
import android.content.Intent;
import androidx.view.MutableLiveData;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.RssSource;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSortViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J#\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010!\u001a\u00020\u001e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lio/legado/app/ui/rss/article/RssSortViewModel;", "Lio/legado/app/base/BaseViewModel;", "Landroid/content/Intent;", "intent", "Lkotlin/Function0;", "Lf/v;", "finally", "e", "(Landroid/content/Intent;Lf/c0/b/a;)V", "Landroidx/lifecycle/MutableLiveData;", "", "Landroidx/lifecycle/MutableLiveData;", "getTitleLiveData", "()Landroidx/lifecycle/MutableLiveData;", "titleLiveData", "Lio/legado/app/data/entities/RssSource;", "d", "Lio/legado/app/data/entities/RssSource;", "getRssSource", "()Lio/legado/app/data/entities/RssSource;", "setRssSource", "(Lio/legado/app/data/entities/RssSource;)V", "rssSource", ai.aD, "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "url", "", "f", "()Z", "isGridLayout", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSortViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String url;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RssSource rssSource;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> titleLiveData;

    /* JADX INFO: compiled from: RssSortViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.article.RssSortViewModel$initData$1", f = "RssSortViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ Intent $intent;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Intent intent, d<? super a> dVar) {
            super(2, dVar);
            this.$intent = intent;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            a aVar = RssSortViewModel.this.new a(this.$intent, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            RssSortViewModel.this.url = this.$intent.getStringExtra("url");
            RssSortViewModel rssSortViewModel = RssSortViewModel.this;
            String str = rssSortViewModel.url;
            v vVar = null;
            if (str == null) {
                return null;
            }
            RssSource byKey = AppDatabaseKt.getAppDb().getRssSourceDao().getByKey(str);
            rssSortViewModel.rssSource = byKey;
            if (byKey != null) {
                rssSortViewModel.titleLiveData.postValue(byKey.getSourceName());
                vVar = v.a;
            }
            if (vVar == null) {
                rssSortViewModel.rssSource = new RssSource(str, null, null, null, null, false, null, false, 0, null, null, null, null, null, null, null, null, null, null, false, false, 0, 4194302, null);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: RssSortViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.article.RssSortViewModel$initData$2", f = "RssSortViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ f.c0.b.a<v> $finally;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f.c0.b.a<v> aVar, d<? super b> dVar) {
            super(2, dVar);
            this.$finally = aVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new b(this.$finally, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            this.$finally.invoke();
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssSortViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.titleLiveData = new MutableLiveData<>();
        System.currentTimeMillis();
    }

    public final void e(@NotNull Intent intent, @NotNull f.c0.b.a<v> aVar) {
        j.e(intent, "intent");
        j.e(aVar, "finally");
        e.a.a.d.u.b.c(BaseViewModel.a(this, null, null, new a(intent, null), 3, null), null, new b(aVar, null), 1);
    }

    public final boolean f() {
        RssSource rssSource = this.rssSource;
        Integer numValueOf = rssSource == null ? null : Integer.valueOf(rssSource.getArticleStyle());
        return numValueOf != null && numValueOf.intValue() == 2;
    }
}
