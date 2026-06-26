package io.legado.app.ui.book.source.manage;

import android.app.Application;
import c.b.a.m.f;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookSourceDao;
import io.legado.app.data.entities.BookSource;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\b\u0010\u0007¨\u0006\r"}, d2 = {"Lio/legado/app/ui/book/source/manage/BookSourceViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "Lio/legado/app/data/entities/BookSource;", "sources", "Lf/v;", "f", "([Lio/legado/app/data/entities/BookSource;)V", "e", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookSourceViewModel extends BaseViewModel {

    /* JADX INFO: compiled from: BookSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$bottomSource$1", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ BookSource[] $sources;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BookSource[] bookSourceArr, d<? super a> dVar) {
            super(2, dVar);
            this.$sources = bookSourceArr;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.$sources, dVar);
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
            int maxOrder = AppDatabaseKt.getAppDb().getBookSourceDao().getMaxOrder() + 1;
            int i2 = 0;
            for (BookSource bookSource : this.$sources) {
                Integer num = new Integer(i2);
                i2++;
                bookSource.setCustomOrder(num.intValue() + maxOrder);
            }
            BookSourceDao bookSourceDao = AppDatabaseKt.getAppDb().getBookSourceDao();
            BookSource[] bookSourceArr = this.$sources;
            bookSourceDao.update((BookSource[]) Arrays.copyOf(bookSourceArr, bookSourceArr.length));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$topSource$1", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ BookSource[] $sources;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BookSource[] bookSourceArr, d<? super b> dVar) {
            super(2, dVar);
            this.$sources = bookSourceArr;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new b(this.$sources, dVar);
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
            int minOrder = AppDatabaseKt.getAppDb().getBookSourceDao().getMinOrder() - 1;
            int i2 = 0;
            for (BookSource bookSource : this.$sources) {
                Integer num = new Integer(i2);
                i2++;
                bookSource.setCustomOrder(minOrder - num.intValue());
            }
            BookSourceDao bookSourceDao = AppDatabaseKt.getAppDb().getBookSourceDao();
            BookSource[] bookSourceArr = this.$sources;
            bookSourceDao.update((BookSource[]) Arrays.copyOf(bookSourceArr, bookSourceArr.length));
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookSourceViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    public final void e(@NotNull BookSource... sources) {
        j.e(sources, "sources");
        BaseViewModel.a(this, null, null, new a(sources, null), 3, null);
    }

    public final void f(@NotNull BookSource... sources) {
        j.e(sources, "sources");
        BaseViewModel.a(this, null, null, new b(sources, null), 3, null);
    }
}
