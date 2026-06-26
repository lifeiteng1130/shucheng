package e.a.a.g.d.l.c;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookSourceDao;
import io.legado.app.data.entities.BookSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$addGroup$1", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ String $group;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(String str, f.z.d<? super d0> dVar) {
        super(2, dVar);
        this.$group = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d0(this.$group, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((d0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        List<BookSource> noGroup = AppDatabaseKt.getAppDb().getBookSourceDao().getNoGroup();
        String str = this.$group;
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(noGroup, 10));
        Iterator<T> it = noGroup.iterator();
        while (it.hasNext()) {
            ((BookSource) it.next()).setBookSourceGroup(str);
            arrayList.add(f.v.a);
        }
        BookSourceDao bookSourceDao = AppDatabaseKt.getAppDb().getBookSourceDao();
        Object[] array = noGroup.toArray(new BookSource[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        BookSource[] bookSourceArr = (BookSource[]) array;
        bookSourceDao.update((BookSource[]) Arrays.copyOf(bookSourceArr, bookSourceArr.length));
        return f.v.a;
    }
}
