package e.a.a.g.d.b;

import f.v;
import g.b.a0;
import g.b.k0;
import g.b.o1;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.ui.book.cache.CacheActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.cache.CacheActivity$initCacheSize$1", f = "CacheActivity.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
public final class j extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ List<Book> $books;
    public Object L$0;
    public Object L$1;
    public int label;
    public final /* synthetic */ CacheActivity this$0;

    /* JADX INFO: compiled from: CacheActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.cache.CacheActivity$initCacheSize$1$1$2", f = "CacheActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public int label;
        public final /* synthetic */ CacheActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CacheActivity cacheActivity, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.this$0 = cacheActivity;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.this$0, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            this.this$0.U0().notifyItemRangeChanged(0, this.this$0.U0().getItemCount(), Boolean.TRUE);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(List<Book> list, CacheActivity cacheActivity, f.z.d<? super j> dVar) {
        super(2, dVar);
        this.$books = list;
        this.this$0 = cacheActivity;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new j(this.$books, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((j) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        CacheActivity cacheActivity;
        Iterator it;
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            List<Book> list = this.$books;
            cacheActivity = this.this$0;
            it = list.iterator();
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$1;
            cacheActivity = (CacheActivity) this.L$0;
            c.b.a.m.f.E5(obj);
        }
        while (it.hasNext()) {
            Book book = (Book) it.next();
            HashSet<String> hashSet = new HashSet<>();
            List<String> listC = e.a.a.d.g.a.c(book);
            for (BookChapter bookChapter : AppDatabaseKt.getAppDb().getBookChapterDao().getChapterList(book.getBookUrl())) {
                if (((ArrayList) listC).contains(bookChapter.getFileName())) {
                    hashSet.add(bookChapter.getUrl());
                }
            }
            cacheActivity.U0().cacheChapters.put(book.getBookUrl(), hashSet);
            k0 k0Var = k0.f6264c;
            o1 o1Var = g.b.g2.m.f6207b;
            a aVar2 = new a(cacheActivity, null);
            this.L$0 = cacheActivity;
            this.L$1 = it;
            this.label = 1;
            if (c.b.a.m.f.f6(o1Var, aVar2, this) == aVar) {
                return aVar;
            }
        }
        return v.a;
    }
}
