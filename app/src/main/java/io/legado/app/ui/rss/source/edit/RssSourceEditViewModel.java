package io.legado.app.ui.rss.source.edit;

import android.app.Application;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import f.c0.b.p;
import f.c0.b.q;
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

/* JADX INFO: compiled from: RssSourceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lio/legado/app/ui/rss/source/edit/RssSourceEditViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lio/legado/app/data/entities/RssSource;", "source", "Lkotlin/Function0;", "Lf/v;", "success", "e", "(Lio/legado/app/data/entities/RssSource;Lf/c0/b/a;)V", "", "d", "Ljava/lang/String;", "oldSourceUrl", ai.aD, "Lio/legado/app/data/entities/RssSource;", "getRssSource", "()Lio/legado/app/data/entities/RssSource;", "setRssSource", "(Lio/legado/app/data/entities/RssSource;)V", "rssSource", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSourceEditViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public RssSource rssSource;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String oldSourceUrl;

    /* JADX INFO: compiled from: RssSourceEditViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.source.edit.RssSourceEditViewModel$save$1", f = "RssSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ RssSource $source;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RssSource rssSource, d<? super a> dVar) {
            super(2, dVar);
            this.$source = rssSource;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return RssSourceEditViewModel.this.new a(this.$source, dVar);
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
            if (!j.a(RssSourceEditViewModel.this.oldSourceUrl, this.$source.getSourceUrl())) {
                AppDatabaseKt.getAppDb().getRssSourceDao().delete(RssSourceEditViewModel.this.oldSourceUrl);
                RssSourceEditViewModel.this.oldSourceUrl = this.$source.getSourceUrl();
            }
            AppDatabaseKt.getAppDb().getRssSourceDao().insert(this.$source);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: RssSourceEditViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.source.edit.RssSourceEditViewModel$save$2", f = "RssSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements q<a0, v, d<? super v>, Object> {
        public final /* synthetic */ f.c0.b.a<v> $success;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f.c0.b.a<v> aVar, d<? super b> dVar) {
            super(3, dVar);
            this.$success = aVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull v vVar, @Nullable d<? super v> dVar) {
            return new b(this.$success, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            this.$success.invoke();
            return v.a;
        }
    }

    /* JADX INFO: compiled from: RssSourceEditViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.source.edit.RssSourceEditViewModel$save$3", f = "RssSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements q<a0, Throwable, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public c(d<? super c> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable d<? super v> dVar) {
            c cVar = RssSourceEditViewModel.this.new c(dVar);
            cVar.L$0 = th;
            return cVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            Throwable th = (Throwable) this.L$0;
            RssSourceEditViewModel.this.d(th.getLocalizedMessage());
            th.printStackTrace();
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssSourceEditViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.rssSource = new RssSource(null, null, null, null, null, false, null, false, 0, null, null, null, null, null, null, null, null, null, null, false, false, 0, 4194303, null);
        this.oldSourceUrl = "";
    }

    public final void e(@NotNull RssSource source, @NotNull f.c0.b.a<v> success) {
        j.e(source, "source");
        j.e(success, "success");
        e.a.a.d.u.b bVarA = BaseViewModel.a(this, null, null, new a(source, null), 3, null);
        bVarA.d(null, new b(success, null));
        e.a.a.d.u.b.b(bVarA, null, new c(null), 1);
    }
}
