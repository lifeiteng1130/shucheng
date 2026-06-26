package e.a.a.g.k.d.c;

import android.text.TextUtils;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.entities.RssSource;
import io.legado.app.ui.rss.source.manage.RssSourceViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$delGroup$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class u extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super e.a.a.d.u.b<f.v>>, Object> {
    public final /* synthetic */ String $group;
    public int label;
    public final /* synthetic */ RssSourceViewModel this$0;

    /* JADX INFO: compiled from: RssSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$delGroup$1$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
        public final /* synthetic */ String $group;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$group = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$group, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(f.v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            List<RssSource> byGroup = AppDatabaseKt.getAppDb().getRssSourceDao().getByGroup(this.$group);
            String str = this.$group;
            ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(byGroup, 10));
            for (RssSource rssSource : byGroup) {
                String sourceGroup = rssSource.getSourceGroup();
                f.v vVar = null;
                String[] strArrN5 = sourceGroup == null ? null : c.b.a.m.f.n5(sourceGroup, ",");
                if (strArrN5 != null) {
                    HashSet hashSetI5 = c.b.a.m.f.I5(strArrN5);
                    hashSetI5.remove(str);
                    rssSource.setSourceGroup(TextUtils.join(",", hashSetI5));
                    vVar = f.v.a;
                }
                arrayList.add(vVar);
            }
            RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
            Object[] array = byGroup.toArray(new RssSource[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            RssSource[] rssSourceArr = (RssSource[]) array;
            rssSourceDao.update((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
            return f.v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(RssSourceViewModel rssSourceViewModel, String str, f.z.d<? super u> dVar) {
        super(2, dVar);
        this.this$0 = rssSourceViewModel;
        this.$group = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new u(this.this$0, this.$group, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super e.a.a.d.u.b<f.v>> dVar) {
        return ((u) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        return BaseViewModel.a(this.this$0, null, null, new a(this.$group, null), 3, null);
    }
}
