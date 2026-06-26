package e.a.a.g.h.g;

import e.a.a.h.n;
import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookshelfViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$exportBookshelf$1", f = "BookshelfViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class j extends f.z.j.a.g implements p<a0, f.z.d<? super String>, Object> {
    public final /* synthetic */ List<Book> $books;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(List<Book> list, f.z.d<? super j> dVar) {
        super(2, dVar);
        this.$books = list;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new j(this.$books, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super String> dVar) {
        return ((j) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ArrayList arrayList = new ArrayList();
        List<Book> list = this.$books;
        if (list != null) {
            for (Book book : list) {
                HashMap map = new HashMap();
                map.put("name", book.getName());
                map.put("author", book.getAuthor());
                map.put("intro", book.getDisplayIntro());
                arrayList.add(map);
            }
        }
        return n.a().toJson(arrayList);
    }
}
