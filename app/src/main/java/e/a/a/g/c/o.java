package e.a.a.g.c;

import e.a.a.d.u.b;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.audio.AudioPlayViewModel;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlayViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.audio.AudioPlayViewModel$loadBookInfo$1", f = "AudioPlayViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class o extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super e.a.a.d.u.b<Book>>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ f.c0.b.l<List<BookChapter>, v> $changeDruChapterIndex;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ AudioPlayViewModel this$0;

    /* JADX INFO: compiled from: AudioPlayViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.audio.AudioPlayViewModel$loadBookInfo$1$1", f = "AudioPlayViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.q<a0, Book, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ f.c0.b.l<List<BookChapter>, v> $changeDruChapterIndex;
        public int label;
        public final /* synthetic */ AudioPlayViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(AudioPlayViewModel audioPlayViewModel, Book book, f.c0.b.l<? super List<BookChapter>, v> lVar, f.z.d<? super a> dVar) {
            super(3, dVar);
            this.this$0 = audioPlayViewModel;
            this.$book = book;
            this.$changeDruChapterIndex = lVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Book book, @Nullable f.z.d<? super v> dVar) {
            return new a(this.this$0, this.$book, this.$changeDruChapterIndex, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            AudioPlayViewModel.e(this.this$0, this.$book, this.$changeDruChapterIndex);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public o(Book book, AudioPlayViewModel audioPlayViewModel, f.c0.b.l<? super List<BookChapter>, v> lVar, f.z.d<? super o> dVar) {
        super(2, dVar);
        this.$book = book;
        this.this$0 = audioPlayViewModel;
        this.$changeDruChapterIndex = lVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        o oVar = new o(this.$book, this.this$0, this.$changeDruChapterIndex, dVar);
        oVar.L$0 = obj;
        return oVar;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super e.a.a.d.u.b<Book>> dVar) {
        return ((o) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        e.a.a.d.u.b bookInfo$default;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        a0 a0Var = (a0) this.L$0;
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        WebBook webBook = e.a.a.f.s.a.f5670j;
        if (webBook == null || (bookInfo$default = WebBook.getBookInfo$default(webBook, a0Var, this.$book, null, false, 12, null)) == null) {
            return null;
        }
        a aVar2 = new a(this.this$0, this.$book, this.$changeDruChapterIndex, null);
        b.C0148b c0148b = e.a.a.d.u.b.a;
        bookInfo$default.d(null, aVar2);
        return bookInfo$default;
    }
}
