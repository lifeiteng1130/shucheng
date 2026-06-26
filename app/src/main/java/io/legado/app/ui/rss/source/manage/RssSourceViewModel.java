package io.legado.app.ui.rss.source.manage;

import android.app.Application;
import c.b.a.m.f;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.entities.RssSource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lio/legado/app/ui/rss/source/manage/RssSourceViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "Lio/legado/app/data/entities/RssSource;", "sources", "Lf/v;", "h", "([Lio/legado/app/data/entities/RssSource;)V", "e", "rssSource", "f", "(Lio/legado/app/data/entities/RssSource;)V", "", "g", "(Ljava/util/List;)V", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSourceViewModel extends BaseViewModel {

    /* JADX INFO: compiled from: RssSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$bottomSource$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ RssSource[] $sources;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RssSource[] rssSourceArr, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$sources = rssSourceArr;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$sources, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            int maxOrder = AppDatabaseKt.getAppDb().getRssSourceDao().getMaxOrder() + 1;
            int i2 = 0;
            for (RssSource rssSource : this.$sources) {
                Integer num = new Integer(i2);
                i2++;
                rssSource.setCustomOrder(num.intValue() + maxOrder);
            }
            RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
            RssSource[] rssSourceArr = this.$sources;
            rssSourceDao.update((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: RssSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$del$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ RssSource $rssSource;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RssSource rssSource, f.z.d<? super b> dVar) {
            super(2, dVar);
            this.$rssSource = rssSource;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new b(this.$rssSource, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            AppDatabaseKt.getAppDb().getRssSourceDao().delete(this.$rssSource);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: RssSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$delSelection$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ List<RssSource> $sources;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List<RssSource> list, f.z.d<? super c> dVar) {
            super(2, dVar);
            this.$sources = list;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new c(this.$sources, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
            Object[] array = this.$sources.toArray(new RssSource[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            RssSource[] rssSourceArr = (RssSource[]) array;
            rssSourceDao.delete((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: RssSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$topSource$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ RssSource[] $sources;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(RssSource[] rssSourceArr, f.z.d<? super d> dVar) {
            super(2, dVar);
            this.$sources = rssSourceArr;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new d(this.$sources, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            int minOrder = AppDatabaseKt.getAppDb().getRssSourceDao().getMinOrder() - 1;
            int i2 = 0;
            for (RssSource rssSource : this.$sources) {
                Integer num = new Integer(i2);
                i2++;
                rssSource.setCustomOrder(minOrder - num.intValue());
            }
            RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
            RssSource[] rssSourceArr = this.$sources;
            rssSourceDao.update((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssSourceViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    public final void e(@NotNull RssSource... sources) {
        j.e(sources, "sources");
        BaseViewModel.a(this, null, null, new a(sources, null), 3, null);
    }

    public final void f(@NotNull RssSource rssSource) {
        j.e(rssSource, "rssSource");
        BaseViewModel.a(this, null, null, new b(rssSource, null), 3, null);
    }

    public final void g(@NotNull List<RssSource> sources) {
        j.e(sources, "sources");
        BaseViewModel.a(this, null, null, new c(sources, null), 3, null);
    }

    public final void h(@NotNull RssSource... sources) {
        j.e(sources, "sources");
        BaseViewModel.a(this, null, null, new d(sources, null), 3, null);
    }
}
