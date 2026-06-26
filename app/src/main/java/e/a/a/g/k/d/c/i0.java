package e.a.a.g.k.d.c;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.entities.RssSource;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$upOrder$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class i0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public int label;

    public i0(f.z.d<? super i0> dVar) {
        super(2, dVar);
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new i0(dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((i0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        List<RssSource> all = AppDatabaseKt.getAppDb().getRssSourceDao().getAll();
        Iterator<RssSource> it = all.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            it.next().setCustomOrder(i2);
        }
        RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
        Object[] array = all.toArray(new RssSource[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        RssSource[] rssSourceArr = (RssSource[]) array;
        rssSourceDao.update((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
        return f.v.a;
    }
}
