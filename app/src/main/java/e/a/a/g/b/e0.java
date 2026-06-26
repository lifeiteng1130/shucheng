package e.a.a.g.b;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.RssSource;
import io.legado.app.ui.association.ImportRssSourceViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportRssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.association.ImportRssSourceViewModel$importSelect$1", f = "ImportRssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class e0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ ImportRssSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(ImportRssSourceViewModel importRssSourceViewModel, f.z.d<? super e0> dVar) {
        super(2, dVar);
        this.this$0 = importRssSourceViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new e0(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((e0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        RssSource rssSource;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        boolean zG = e.a.a.d.e.a.g();
        ArrayList arrayList = new ArrayList();
        ImportRssSourceViewModel importRssSourceViewModel = this.this$0;
        int i2 = 0;
        for (Object obj2 : importRssSourceViewModel.selectStatus) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                f.x.e.D();
                throw null;
            }
            Integer num = new Integer(i2);
            boolean zBooleanValue = ((Boolean) obj2).booleanValue();
            int iIntValue = num.intValue();
            if (zBooleanValue) {
                RssSource rssSource2 = importRssSourceViewModel.allSources.get(iIntValue);
                f.c0.c.j.d(rssSource2, "allSources[index]");
                RssSource rssSource3 = rssSource2;
                String str = importRssSourceViewModel.groupName;
                if (str != null) {
                    rssSource3.setSourceGroup(str);
                }
                if (zG && (rssSource = importRssSourceViewModel.checkSources.get(iIntValue)) != null) {
                    rssSource3.setSourceName(rssSource.getSourceName());
                    rssSource3.setSourceGroup(rssSource.getSourceGroup());
                }
                arrayList.add(rssSource3);
            }
            i2 = i3;
        }
        e.a.a.d.s sVar = e.a.a.d.s.a;
        Object[] array = arrayList.toArray(new RssSource[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        RssSource[] rssSourceArr = (RssSource[]) array;
        RssSource[] rssSourceArr2 = (RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length);
        f.c0.c.j.e(rssSourceArr2, "rssSources");
        for (final RssSource rssSource4 : rssSourceArr2) {
            e.a.a.d.s sVar2 = e.a.a.d.s.a;
            if (e.a.a.d.s.a(rssSource4.getSourceUrl())) {
                e.a.a.d.s.f5556b.post(new Runnable() { // from class: e.a.a.d.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        RssSource rssSource5 = rssSource4;
                        f.c0.c.j.e(rssSource5, "$rssSource");
                        c.b.a.m.f.R5(k.d.a.h.g(), f.c0.c.j.k(rssSource5.getSourceName(), "是18+网址,禁止导入."));
                    }
                });
            } else {
                AppDatabaseKt.getAppDb().getRssSourceDao().insert(rssSource4);
            }
        }
        return f.v.a;
    }
}
