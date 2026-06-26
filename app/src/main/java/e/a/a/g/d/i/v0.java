package e.a.a.g.d.i;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import java.io.File;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$reverseContent$1", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class v0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Book $book;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(Book book, f.z.d<? super v0> dVar) {
        super(2, dVar);
        this.$book = book;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new v0(this.$book, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((v0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
        String bookUrl = this.$book.getBookUrl();
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        BookChapter chapter = bookChapterDao.getChapter(bookUrl, e.a.a.f.s.k.f5681g);
        if (chapter == null) {
            return null;
        }
        Book book = this.$book;
        e.a.a.d.g gVar = e.a.a.d.g.a;
        f.c0.c.j.e(book, "book");
        f.c0.c.j.e(chapter, "bookChapter");
        if (!book.isLocalBook()) {
            File file = e.a.a.d.g.f5530b;
            String[] strArr = {"book_cache", book.getFolderName(), chapter.getFileName()};
            f.c0.c.j.e(file, "root");
            f.c0.c.j.e(strArr, "subDirFiles");
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, 3);
            f.c0.c.j.e(file, "root");
            f.c0.c.j.e(strArr2, "subDirFiles");
            StringBuilder sb = new StringBuilder(file.getAbsolutePath());
            for (String str : strArr2) {
                if (str.length() > 0) {
                    sb.append(File.separator);
                    sb.append(str);
                }
            }
            String string = sb.toString();
            f.c0.c.j.d(string, "path.toString()");
            File file2 = new File(string);
            if (file2.exists()) {
                String strD = f.b0.d.d(file2, null, 1);
                StringBuilder sb2 = new StringBuilder();
                for (String str2 : c.b.a.m.f.O5(strD)) {
                    sb2.insert(0, str2);
                }
                String string2 = sb2.toString();
                f.c0.c.j.d(string2, "stringBuilder.toString()");
                f.b0.d.f(file2, string2, null, 2);
            }
        }
        e.a.a.f.s.k.j(e.a.a.f.s.k.a, e.a.a.f.s.k.f5681g, false, false, null, 10);
        return f.v.a;
    }
}
