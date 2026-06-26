package e.a.a.f;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.service.CacheBookService;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheBookService.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.CacheBookService$addDownloadData$1", f = "CacheBookService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class n extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $bookUrl;
    public final /* synthetic */ int $end;
    public final /* synthetic */ int $start;
    public int label;
    public final /* synthetic */ CacheBookService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, int i2, int i3, CacheBookService cacheBookService, f.z.d<? super n> dVar) {
        super(2, dVar);
        this.$bookUrl = str;
        this.$start = i2;
        this.$end = i3;
        this.this$0 = cacheBookService;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new n(this.$bookUrl, this.$start, this.$end, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((n) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        List<BookChapter> chapterList = AppDatabaseKt.getAppDb().getBookChapterDao().getChapterList(this.$bookUrl, this.$start, this.$end);
        CacheBookService cacheBookService = this.this$0;
        String str = this.$bookUrl;
        if (!chapterList.isEmpty()) {
            CopyOnWriteArraySet<BookChapter> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
            copyOnWriteArraySet.addAll(chapterList);
            cacheBookService.downloadMap.put(str, copyOnWriteArraySet);
        } else {
            e.a.a.f.s.h hVar = e.a.a.f.s.h.a;
            Book bookB = CacheBookService.b(cacheBookService, str);
            hVar.a(f.c0.c.j.k(bookB == null ? null : bookB.getName(), " is empty"));
        }
        int i2 = 0;
        int i3 = this.this$0.threadCount;
        if (i3 > 0) {
            do {
                i2++;
                int i4 = this.this$0.downloadingCount;
                CacheBookService cacheBookService2 = this.this$0;
                if (i4 < cacheBookService2.threadCount) {
                    cacheBookService2.e();
                }
            } while (i2 < i3);
        }
        return v.a;
    }
}
