package e.a.a.f.s;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.help.CacheBook$download$2", f = "CacheBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f extends f.z.j.a.g implements f.c0.b.q<a0, Throwable, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ BookChapter $chapter;
    public final /* synthetic */ boolean $resetPageOffset;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Book book, BookChapter bookChapter, boolean z, f.z.d<? super f> dVar) {
        super(3, dVar);
        this.$book = book;
        this.$chapter = bookChapter;
        this.$resetPageOffset = z;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
        f fVar = new f(this.$book, this.$chapter, this.$resetPageOffset, dVar);
        fVar.L$0 = th;
        return fVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Throwable th = (Throwable) this.L$0;
        k kVar = k.a;
        Book book = k.f5677c;
        if (f.c0.c.j.a(book == null ? null : book.getBookUrl(), this.$book.getBookUrl())) {
            k.e(kVar, this.$book, this.$chapter, c.b.a.m.f.C2(th), false, this.$resetPageOffset, null, 40);
        }
        return v.a;
    }
}
