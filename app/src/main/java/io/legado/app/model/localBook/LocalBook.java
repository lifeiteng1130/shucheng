package io.legado.app.model.localBook;

import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import c.b.a.m.f;
import e.a.a.d.g;
import f.c0.c.j;
import f.e;
import f.v;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LocalBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lio/legado/app/model/localBook/LocalBook;", "", "Lio/legado/app/data/entities/Book;", "book", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/BookChapter;", "Lkotlin/collections/ArrayList;", "getChapterList", "(Lio/legado/app/data/entities/Book;)Ljava/util/ArrayList;", "chapter", "", "getContext", "(Lio/legado/app/data/entities/Book;Lio/legado/app/data/entities/BookChapter;)Ljava/lang/String;", "Landroid/net/Uri;", "uri", "importFile", "(Landroid/net/Uri;)Lio/legado/app/data/entities/Book;", "", "deleteOriginal", "Lf/v;", "deleteBook", "(Lio/legado/app/data/entities/Book;Z)V", "folderName", "Ljava/lang/String;", "Ljava/io/File;", "cacheFolder$delegate", "Lf/e;", "getCacheFolder", "()Ljava/io/File;", "cacheFolder", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class LocalBook {

    @NotNull
    public static final LocalBook INSTANCE = new LocalBook();

    /* JADX INFO: renamed from: cacheFolder$delegate, reason: from kotlin metadata */
    @NotNull
    private static final e cacheFolder = f.N3(LocalBook$cacheFolder$2.INSTANCE);

    @NotNull
    private static final String folderName = "bookTxt";

    private LocalBook() {
    }

    public final void deleteBook(@NotNull Book book, boolean deleteOriginal) {
        File parentFile;
        j.e(book, "book");
        try {
            if (book.isLocalTxt()) {
                File cacheFolder2 = INSTANCE.getCacheFolder();
                String[] strArr = {book.getOriginName()};
                j.e(cacheFolder2, "root");
                j.e(strArr, "subDirFiles");
                String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
                j.e(cacheFolder2, "root");
                j.e(strArr2, "subDirFiles");
                StringBuilder sb = new StringBuilder(cacheFolder2.getAbsolutePath());
                for (String str : strArr2) {
                    if (str.length() > 0) {
                        sb.append(File.separator);
                        sb.append(str);
                    }
                }
                String string = sb.toString();
                j.d(string, "path.toString()");
                new File(string).delete();
            }
            if (book.isEpub() && (parentFile = g.a.g(book).getParentFile()) != null && parentFile.exists()) {
                FileUtils.a.f(parentFile, true);
            }
            if (deleteOriginal) {
                if (f.t3(book.getBookUrl())) {
                    DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(h.g(), Uri.parse(book.getBookUrl()));
                    if (documentFileFromSingleUri != null) {
                        documentFileFromSingleUri.delete();
                    }
                } else {
                    FileUtils.a.h(book.getBookUrl());
                }
            }
            f.h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            f.h.m11constructorimpl(f.m1(th));
        }
    }

    @NotNull
    public final File getCacheFolder() {
        return (File) cacheFolder.getValue();
    }

    @NotNull
    public final ArrayList<BookChapter> getChapterList(@NotNull Book book) {
        j.e(book, "book");
        return book.isEpub() ? EpubFile.INSTANCE.getChapterList(book) : new AnalyzeTxtFile().analyze(book);
    }

    @Nullable
    public final String getContext(@NotNull Book book, @NotNull BookChapter chapter) {
        j.e(book, "book");
        j.e(chapter, "chapter");
        return book.isEpub() ? EpubFile.INSTANCE.getContent(book, chapter) : AnalyzeTxtFile.INSTANCE.getContent(book, chapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023c  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.legado.app.data.entities.Book importFile(@org.jetbrains.annotations.NotNull android.net.Uri r45) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.localBook.LocalBook.importFile(android.net.Uri):io.legado.app.data.entities.Book");
    }
}
