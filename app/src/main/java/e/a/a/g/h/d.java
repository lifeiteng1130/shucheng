package e.a.a.g.h;

import e.a.a.d.m;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.HttpTTSDao;
import io.legado.app.data.entities.HttpTTS;
import io.legado.app.ui.main.MainViewModel;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.MainViewModel$postLoad$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d extends g implements p<a0, f.z.d<? super v>, Object> {
    public int label;
    public final /* synthetic */ MainViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MainViewModel mainViewModel, f.z.d<? super d> dVar) {
        super(2, dVar);
        this.this$0 = mainViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d(this.this$0, dVar);
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
        c.b.a.m.f.E5(obj);
        FileUtils fileUtils = FileUtils.a;
        File cacheDir = this.this$0.b().getCacheDir();
        j.d(cacheDir, "context.cacheDir");
        fileUtils.h(fileUtils.o(cacheDir, "Fonts"));
        if (AppDatabaseKt.getAppDb().getHttpTTSDao().getCount() == 0) {
            m mVar = m.a;
            List list = (List) m.f5545b.getValue();
            HttpTTSDao httpTTSDao = AppDatabaseKt.getAppDb().getHttpTTSDao();
            Object[] array = list.toArray(new HttpTTS[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            HttpTTS[] httpTTSArr = (HttpTTS[]) array;
            httpTTSDao.insert((HttpTTS[]) Arrays.copyOf(httpTTSArr, httpTTSArr.length));
        }
        return v.a;
    }
}
