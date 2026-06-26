package e.a.a.g.c;

import f.v;
import g.b.a0;
import g.b.k0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.audio.AudioPlayViewModel;
import io.wenyuange.app.release.R;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlayViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.audio.AudioPlayViewModel$loadChapterList$1", f = "AudioPlayViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class p extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super e.a.a.d.u.b<List<? extends BookChapter>>>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ f.c0.b.l<List<BookChapter>, v> $changeDruChapterIndex;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ AudioPlayViewModel this$0;

    /* JADX INFO: compiled from: AudioPlayViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.audio.AudioPlayViewModel$loadChapterList$1$1", f = "AudioPlayViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.q<a0, List<? extends BookChapter>, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ f.c0.b.l<List<BookChapter>, v> $changeDruChapterIndex;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ AudioPlayViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(f.c0.b.l<? super List<BookChapter>, v> lVar, Book book, AudioPlayViewModel audioPlayViewModel, f.z.d<? super a> dVar) {
            super(3, dVar);
            this.$changeDruChapterIndex = lVar;
            this.$book = book;
            this.this$0 = audioPlayViewModel;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @NotNull List<BookChapter> list, @Nullable f.z.d<? super v> dVar) {
            a aVar = new a(this.$changeDruChapterIndex, this.$book, this.this$0, dVar);
            aVar.L$0 = list;
            return aVar.invokeSuspend(v.a);
        }

        @Override // f.c0.b.q
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, List<? extends BookChapter> list, f.z.d<? super v> dVar) {
            return invoke2(a0Var, (List<BookChapter>) list, dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            List<BookChapter> list = (List) this.L$0;
            if (!list.isEmpty()) {
                f.c0.b.l<List<BookChapter>, v> lVar = this.$changeDruChapterIndex;
                if (lVar == null) {
                    BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
                    Object[] array = list.toArray(new BookChapter[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    BookChapter[] bookChapterArr = (BookChapter[]) array;
                    bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
                } else {
                    lVar.invoke(list);
                }
                e.a.a.f.s.a.a.h(this.$book);
            } else {
                this.this$0.c(R.string.error_load_toc);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: AudioPlayViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.audio.AudioPlayViewModel$loadChapterList$1$2", f = "AudioPlayViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements f.c0.b.q<a0, Throwable, f.z.d<? super v>, Object> {
        public int label;
        public final /* synthetic */ AudioPlayViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AudioPlayViewModel audioPlayViewModel, f.z.d<? super b> dVar) {
            super(3, dVar);
            this.this$0 = audioPlayViewModel;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            return new b(this.this$0, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            this.this$0.c(R.string.error_load_toc);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public p(Book book, f.c0.b.l<? super List<BookChapter>, v> lVar, AudioPlayViewModel audioPlayViewModel, f.z.d<? super p> dVar) {
        super(2, dVar);
        this.$book = book;
        this.$changeDruChapterIndex = lVar;
        this.this$0 = audioPlayViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        p pVar = new p(this.$book, this.$changeDruChapterIndex, this.this$0, dVar);
        pVar.L$0 = obj;
        return pVar;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull a0 a0Var, @Nullable f.z.d<? super e.a.a.d.u.b<List<BookChapter>>> dVar) {
        return ((p) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.c0.b.p
    public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, f.z.d<? super e.a.a.d.u.b<List<? extends BookChapter>>> dVar) {
        return invoke2(a0Var, (f.z.d<? super e.a.a.d.u.b<List<BookChapter>>>) dVar);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        a0 a0Var = (a0) this.L$0;
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        WebBook webBook = e.a.a.f.s.a.f5670j;
        e.a.a.d.u.b chapterList$default = webBook == null ? null : WebBook.getChapterList$default(webBook, a0Var, this.$book, null, 4, null);
        if (chapterList$default == null) {
            return null;
        }
        k0 k0Var = k0.f6264c;
        chapterList$default.d(k0.f6263b, new a(this.$changeDruChapterIndex, this.$book, this.this$0, null));
        e.a.a.d.u.b.b(chapterList$default, null, new b(this.this$0, null), 1);
        return chapterList$default;
    }
}
