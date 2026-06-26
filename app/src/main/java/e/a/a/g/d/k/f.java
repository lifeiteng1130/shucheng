package e.a.a.g.d.k;

import e.a.a.d.k;
import f.c0.b.p;
import f.c0.c.u;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.ui.book.searchContent.SearchContentActivity;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchContentActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.searchContent.SearchContentActivity$searchChapter$2$1", f = "SearchContentActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ String $bookContent;
    public final /* synthetic */ BookChapter $chapter;
    public final /* synthetic */ u<List<String>> $replaceContents;
    public int label;
    public final /* synthetic */ SearchContentActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(BookChapter bookChapter, u<List<String>> uVar, SearchContentActivity searchContentActivity, Book book, String str, f.z.d<? super f> dVar) {
        super(2, dVar);
        this.$chapter = bookChapter;
        this.$replaceContents = uVar;
        this.this$0 = searchContentActivity;
        this.$book = book;
        this.$bookContent = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new f(this.$chapter, this.$replaceContents, this.this$0, this.$book, this.$bookContent, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((f) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [T, java.util.List] */
    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        String strB5;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        BookChapter bookChapter = this.$chapter;
        int iB = e.a.a.d.e.a.b();
        if (iB == 1) {
            strB5 = c.b.a.m.f.B5(this.$chapter.getTitle());
            f.c0.c.j.d(strB5, "t2s(chapter.title)");
        } else if (iB != 2) {
            strB5 = this.$chapter.getTitle();
        } else {
            strB5 = c.b.a.m.f.U4(this.$chapter.getTitle());
            f.c0.c.j.d(strB5, "s2t(chapter.title)");
        }
        bookChapter.setTitle(strB5);
        u<List<String>> uVar = this.$replaceContents;
        k kVar = this.this$0.V0().contentProcessor;
        f.c0.c.j.c(kVar);
        uVar.element = k.b(kVar, this.$book, this.$chapter.getTitle(), this.$bookContent, false, false, 24);
        return v.a;
    }
}
