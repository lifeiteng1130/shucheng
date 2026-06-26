package io.legado.app.ui.book.group;

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
import io.legado.app.data.dao.BookGroupDao;
import io.legado.app.data.entities.BookGroup;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GroupViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lio/legado/app/ui/book/group/GroupViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "groupName", "Lf/v;", "e", "(Ljava/lang/String;)V", "", "Lio/legado/app/data/entities/BookGroup;", "bookGroup", "f", "([Lio/legado/app/data/entities/BookGroup;)V", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupViewModel extends BaseViewModel {

    /* JADX INFO: compiled from: GroupViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.group.GroupViewModel$addGroup$1", f = "GroupViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ String $groupName;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, d<? super a> dVar) {
            super(2, dVar);
            this.$groupName = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.$groupName, dVar);
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
            long j2 = 1;
            while ((j2 & AppDatabaseKt.getAppDb().getBookGroupDao().getIdsSum()) != 0) {
                j2 <<= 1;
            }
            AppDatabaseKt.getAppDb().getBookGroupDao().insert(new BookGroup(j2, this.$groupName, AppDatabaseKt.getAppDb().getBookGroupDao().getMaxOrder() + 1, false, 8, null));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: GroupViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.group.GroupViewModel$upGroup$1", f = "GroupViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ BookGroup[] $bookGroup;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BookGroup[] bookGroupArr, d<? super b> dVar) {
            super(2, dVar);
            this.$bookGroup = bookGroupArr;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new b(this.$bookGroup, dVar);
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
            BookGroupDao bookGroupDao = AppDatabaseKt.getAppDb().getBookGroupDao();
            BookGroup[] bookGroupArr = this.$bookGroup;
            bookGroupDao.update((BookGroup[]) Arrays.copyOf(bookGroupArr, bookGroupArr.length));
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    public final void e(@NotNull String groupName) {
        j.e(groupName, "groupName");
        BaseViewModel.a(this, null, null, new a(groupName, null), 3, null);
    }

    public final void f(@NotNull BookGroup... bookGroup) {
        j.e(bookGroup, "bookGroup");
        BaseViewModel.a(this, null, null, new b(bookGroup, null), 3, null);
    }
}
