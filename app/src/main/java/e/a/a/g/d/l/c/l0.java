package e.a.a.g.d.l.c;

import io.legado.app.data.entities.BookSource;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.manage.BookSourceViewModel$exportSelection$1", f = "BookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class l0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ File $file;
    public final /* synthetic */ List<BookSource> $sources;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(List<BookSource> list, File file, f.z.d<? super l0> dVar) {
        super(2, dVar);
        this.$sources = list;
        this.$file = file;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new l0(this.$sources, this.$file, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((l0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String json = e.a.a.h.n.a().toJson(this.$sources);
        File fileA = FileUtils.a.a(this.$file, "exportBookSource.json");
        f.c0.c.j.d(json, "json");
        f.b0.d.f(fileA, json, null, 2);
        return f.v.a;
    }
}
