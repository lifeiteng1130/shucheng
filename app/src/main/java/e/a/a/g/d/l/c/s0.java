package e.a.a.g.d.l.c;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookSourceDao;
import io.legado.app.data.entities.BookSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$selectionRemoveFromGroups$1", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class s0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ String $groups;
    public final /* synthetic */ List<BookSource> $sources;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(List<BookSource> list, String str, f.z.d<? super s0> dVar) {
        super(2, dVar);
        this.$sources = list;
        this.$groups = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new s0(this.$sources, this.$groups, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((s0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ArrayList arrayList = new ArrayList();
        List<BookSource> list = this.$sources;
        String str = this.$groups;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                BookSourceDao bookSourceDao = AppDatabaseKt.getAppDb().getBookSourceDao();
                Object[] array = arrayList.toArray(new BookSource[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                BookSource[] bookSourceArr = (BookSource[]) array;
                bookSourceDao.update((BookSource[]) Arrays.copyOf(bookSourceArr, bookSourceArr.length));
                return f.v.a;
            }
            BookSource bookSource = (BookSource) it.next();
            ArrayList arrayList2 = new ArrayList();
            String bookSourceGroup = bookSource.getBookSourceGroup();
            if (bookSourceGroup != null) {
                e.a.a.c.d dVar = e.a.a.c.d.a;
                for (String str2 : c.b.a.m.f.o5(bookSourceGroup, e.a.a.c.d.f5514h, 0, 2)) {
                    arrayList2.add(str2);
                }
            }
            for (String str3 : c.b.a.m.f.n5(str, ",", ";", "，")) {
                arrayList2.remove(str3);
            }
            arrayList.add(bookSource.copy((1048575 & 1) != 0 ? bookSource.bookSourceName : null, (1048575 & 2) != 0 ? bookSource.bookSourceGroup : f.x.e.q(new ArrayList(new LinkedHashSet(arrayList2)), ",", null, null, 0, null, null, 62), (1048575 & 4) != 0 ? bookSource.bookSourceUrl : null, (1048575 & 8) != 0 ? bookSource.bookSourceType : 0, (1048575 & 16) != 0 ? bookSource.bookUrlPattern : null, (1048575 & 32) != 0 ? bookSource.customOrder : 0, (1048575 & 64) != 0 ? bookSource.enabled : false, (1048575 & 128) != 0 ? bookSource.enabledExplore : false, (1048575 & 256) != 0 ? bookSource.header : null, (1048575 & 512) != 0 ? bookSource.loginUrl : null, (1048575 & 1024) != 0 ? bookSource.bookSourceComment : null, (1048575 & 2048) != 0 ? bookSource.lastUpdateTime : 0L, (1048575 & 4096) != 0 ? bookSource.weight : 0, (1048575 & 8192) != 0 ? bookSource.exploreUrl : null, (1048575 & 16384) != 0 ? bookSource.ruleExplore : null, (1048575 & 32768) != 0 ? bookSource.searchUrl : null, (1048575 & 65536) != 0 ? bookSource.ruleSearch : null, (1048575 & 131072) != 0 ? bookSource.ruleBookInfo : null, (1048575 & 262144) != 0 ? bookSource.ruleToc : null, (1048575 & 524288) != 0 ? bookSource.ruleContent : null));
        }
    }
}
