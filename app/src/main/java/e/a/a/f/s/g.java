package e.a.a.f.s;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.help.CacheBook$download$3", f = "CacheBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class g extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ BookChapter $chapter;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Book book, BookChapter bookChapter, f.z.d<? super g> dVar) {
        super(2, dVar);
        this.$book = book;
        this.$chapter = bookChapter;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new g(this.$book, this.$chapter, dVar);
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
        ConcurrentHashMap<String, CopyOnWriteArraySet<Integer>> concurrentHashMap = h.f5673c;
        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentHashMap.get(this.$book.getBookUrl());
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(new Integer(this.$chapter.getIndex()));
        }
        Collection collection = (Collection) concurrentHashMap.get(this.$book.getBookUrl());
        if (collection == null || collection.isEmpty()) {
            concurrentHashMap.remove(this.$book.getBookUrl());
        }
        k.a.p(this.$chapter.getIndex());
        return v.a;
    }
}
