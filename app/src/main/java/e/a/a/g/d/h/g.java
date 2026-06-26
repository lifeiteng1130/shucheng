package e.a.a.g.d.h;

import android.net.Uri;
import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.model.localBook.LocalBook;
import java.util.HashSet;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.local.ImportBookViewModel$addToBookshelf$1", f = "ImportBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class g extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ HashSet<String> $uriList;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(HashSet<String> hashSet, f.z.d<? super g> dVar) {
        super(2, dVar);
        this.$uriList = hashSet;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new g(this.$uriList, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        for (String str : this.$uriList) {
            LocalBook localBook = LocalBook.INSTANCE;
            Uri uri = Uri.parse(str);
            f.c0.c.j.d(uri, "parse(it)");
            localBook.importFile(uri);
        }
        return v.a;
    }
}
