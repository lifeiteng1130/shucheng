package e.a.a.g.k.d.c;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.entities.RssSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$enableSelection$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class w extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ List<RssSource> $sources;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(List<RssSource> list, f.z.d<? super w> dVar) {
        super(2, dVar);
        this.$sources = list;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new w(this.$sources, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((w) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ArrayList arrayList = new ArrayList();
        for (RssSource rssSource : this.$sources) {
            arrayList.add(rssSource.copy((4194271 & 1) != 0 ? rssSource.sourceUrl : null, (4194271 & 2) != 0 ? rssSource.sourceName : null, (4194271 & 4) != 0 ? rssSource.sourceIcon : null, (4194271 & 8) != 0 ? rssSource.sourceGroup : null, (4194271 & 16) != 0 ? rssSource.sourceComment : null, (4194271 & 32) != 0 ? rssSource.enabled : true, (4194271 & 64) != 0 ? rssSource.sortUrl : null, (4194271 & 128) != 0 ? rssSource.singleUrl : false, (4194271 & 256) != 0 ? rssSource.articleStyle : 0, (4194271 & 512) != 0 ? rssSource.ruleArticles : null, (4194271 & 1024) != 0 ? rssSource.ruleNextPage : null, (4194271 & 2048) != 0 ? rssSource.ruleTitle : null, (4194271 & 4096) != 0 ? rssSource.rulePubDate : null, (4194271 & 8192) != 0 ? rssSource.ruleDescription : null, (4194271 & 16384) != 0 ? rssSource.ruleImage : null, (4194271 & 32768) != 0 ? rssSource.ruleLink : null, (4194271 & 65536) != 0 ? rssSource.ruleContent : null, (4194271 & 131072) != 0 ? rssSource.style : null, (4194271 & 262144) != 0 ? rssSource.header : null, (4194271 & 524288) != 0 ? rssSource.enableJs : false, (4194271 & 1048576) != 0 ? rssSource.loadWithBaseUrl : false, (4194271 & 2097152) != 0 ? rssSource.customOrder : 0));
        }
        RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
        Object[] array = arrayList.toArray(new RssSource[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        RssSource[] rssSourceArr = (RssSource[]) array;
        rssSourceDao.update((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
        return f.v.a;
    }
}
