package e.a.a.g.c;

import f.v;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.audio.AudioPlayViewModel;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlayViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.audio.AudioPlayViewModel$changeTo$1", f = "AudioPlayViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class m extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book1;
    public int label;
    public final /* synthetic */ AudioPlayViewModel this$0;

    /* JADX INFO: compiled from: AudioPlayViewModel.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<List<? extends BookChapter>, v> {
        public final /* synthetic */ Book $book1;
        public final /* synthetic */ f.c0.c.s $oldTocSize;
        public final /* synthetic */ AudioPlayViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AudioPlayViewModel audioPlayViewModel, Book book, f.c0.c.s sVar) {
            super(1);
            this.this$0 = audioPlayViewModel;
            this.$book1 = book;
            this.$oldTocSize = sVar;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(List<? extends BookChapter> list) {
            invoke2((List<BookChapter>) list);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<BookChapter> list) {
            f.c0.c.j.e(list, "it");
            AudioPlayViewModel.f(this.this$0, this.$book1, this.$oldTocSize.element, list);
        }
    }

    /* JADX INFO: compiled from: AudioPlayViewModel.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<List<? extends BookChapter>, v> {
        public final /* synthetic */ Book $book1;
        public final /* synthetic */ f.c0.c.s $oldTocSize;
        public final /* synthetic */ AudioPlayViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AudioPlayViewModel audioPlayViewModel, Book book, f.c0.c.s sVar) {
            super(1);
            this.this$0 = audioPlayViewModel;
            this.$book1 = book;
            this.$oldTocSize = sVar;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(List<? extends BookChapter> list) {
            invoke2((List<BookChapter>) list);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<BookChapter> list) {
            f.c0.c.j.e(list, "it");
            AudioPlayViewModel.f(this.this$0, this.$book1, this.$oldTocSize.element, list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Book book, AudioPlayViewModel audioPlayViewModel, f.z.d<? super m> dVar) {
        super(2, dVar);
        this.$book1 = book;
        this.this$0 = audioPlayViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new m(this.$book1, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((m) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        f.c0.c.s sVar = new f.c0.c.s();
        sVar.element = this.$book1.getTotalChapterNum();
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        Book book = e.a.a.f.s.a.f5665e;
        if (book != null) {
            Book book2 = this.$book1;
            sVar.element = book.getTotalChapterNum();
            book2.setOrder(book.getOrder());
            AppDatabaseKt.getAppDb().getBookDao().delete(book);
        }
        AppDatabaseKt.getAppDb().getBookDao().insert(this.$book1);
        e.a.a.f.s.a.f5665e = this.$book1;
        BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(this.$book1.getOrigin());
        if (bookSource != null) {
            e.a.a.f.s.a.f5670j = new WebBook(bookSource);
        }
        if (this.$book1.getTocUrl().length() == 0) {
            AudioPlayViewModel audioPlayViewModel = this.this$0;
            Book book3 = this.$book1;
            a aVar2 = new a(audioPlayViewModel, book3, sVar);
            Objects.requireNonNull(audioPlayViewModel);
            BaseViewModel.a(audioPlayViewModel, null, null, new o(book3, audioPlayViewModel, aVar2, null), 3, null);
        } else {
            AudioPlayViewModel audioPlayViewModel2 = this.this$0;
            Book book4 = this.$book1;
            AudioPlayViewModel.e(audioPlayViewModel2, book4, new b(audioPlayViewModel2, book4, sVar));
        }
        return v.a;
    }
}
