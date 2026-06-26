package io.legado.app.model.localBook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import e.a.a.d.g;
import e.a.a.h.q;
import e.a.a.h.v;
import f.c0.c.f;
import f.c0.c.j;
import f.h0.k;
import h.a.a.a.d;
import h.a.a.a.n;
import h.a.a.a.p;
import h.a.a.a.s;
import h.a.a.b.e;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.zip.ZipFile;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: EpubFile.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b#\u0010\u001cJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lio/legado/app/model/localBook/EpubFile;", "", "Lh/a/a/a/d;", "readEpub", "()Lh/a/a/a/d;", "Lio/legado/app/data/entities/BookChapter;", "chapter", "", "getContent", "(Lio/legado/app/data/entities/BookChapter;)Ljava/lang/String;", "href", "getChildChapter", "(Lio/legado/app/data/entities/BookChapter;Ljava/lang/String;)Ljava/lang/String;", "Ljava/io/InputStream;", "getImage", "(Ljava/lang/String;)Ljava/io/InputStream;", "Lf/v;", "upBookInfo", "()V", "Ljava/util/ArrayList;", "getChapterList", "()Ljava/util/ArrayList;", "Lio/legado/app/data/entities/Book;", "book", "Lio/legado/app/data/entities/Book;", "getBook", "()Lio/legado/app/data/entities/Book;", "setBook", "(Lio/legado/app/data/entities/Book;)V", "epubBook", "Lh/a/a/a/d;", "getEpubBook", "Ljava/nio/charset/Charset;", "mCharset", "Ljava/nio/charset/Charset;", "<init>", "Companion", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class EpubFile {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static EpubFile eFile;

    @NotNull
    private Book book;

    @Nullable
    private d epubBook;

    @NotNull
    private Charset mCharset;

    /* JADX INFO: compiled from: EpubFile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/legado/app/model/localBook/EpubFile$Companion;", "", "Lio/legado/app/data/entities/Book;", "book", "Lio/legado/app/model/localBook/EpubFile;", "getEFile", "(Lio/legado/app/data/entities/Book;)Lio/legado/app/model/localBook/EpubFile;", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/BookChapter;", "getChapterList", "(Lio/legado/app/data/entities/Book;)Ljava/util/ArrayList;", "chapter", "", "getContent", "(Lio/legado/app/data/entities/Book;Lio/legado/app/data/entities/BookChapter;)Ljava/lang/String;", "href", "Ljava/io/InputStream;", "getImage", "(Lio/legado/app/data/entities/Book;Ljava/lang/String;)Ljava/io/InputStream;", "Lf/v;", "upBookInfo", "(Lio/legado/app/data/entities/Book;)V", "eFile", "Lio/legado/app/model/localBook/EpubFile;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final synchronized EpubFile getEFile(Book book) {
            g.a.g(book);
            if (EpubFile.eFile != null) {
                EpubFile epubFile = EpubFile.eFile;
                if (j.a(epubFile == null ? null : epubFile.getBook().getBookUrl(), book.getBookUrl())) {
                    EpubFile epubFile2 = EpubFile.eFile;
                    if (epubFile2 != null) {
                        epubFile2.setBook(book);
                    }
                    EpubFile epubFile3 = EpubFile.eFile;
                    j.c(epubFile3);
                    return epubFile3;
                }
            }
            EpubFile.eFile = new EpubFile(book);
            EpubFile epubFile4 = EpubFile.eFile;
            j.c(epubFile4);
            return epubFile4;
        }

        @NotNull
        public final synchronized ArrayList<BookChapter> getChapterList(@NotNull Book book) {
            j.e(book, "book");
            return getEFile(book).getChapterList();
        }

        @Nullable
        public final synchronized String getContent(@NotNull Book book, @NotNull BookChapter chapter) {
            j.e(book, "book");
            j.e(chapter, "chapter");
            return getEFile(book).getContent(chapter);
        }

        @Nullable
        public final synchronized InputStream getImage(@NotNull Book book, @NotNull String href) {
            j.e(book, "book");
            j.e(href, "href");
            return getEFile(book).getImage(href);
        }

        public final synchronized void upBookInfo(@NotNull Book book) {
            j.e(book, "book");
            getEFile(book).upBookInfo();
        }
    }

    public EpubFile(@NotNull Book book) throws Throwable {
        p coverImage;
        InputStream inputStream;
        j.e(book, "book");
        this.book = book;
        Charset charsetDefaultCharset = Charset.defaultCharset();
        j.d(charsetDefaultCharset, "defaultCharset()");
        this.mCharset = charsetDefaultCharset;
        try {
            d epubBook = getEpubBook();
            if (epubBook == null) {
                return;
            }
            String coverUrl = getBook().getCoverUrl();
            if (coverUrl == null || coverUrl.length() == 0) {
                Book book2 = getBook();
                File fileR2 = c.b.a.m.f.r2(h.g());
                String[] strArr = {"covers", j.k(v.b(getBook().getBookUrl()), ".jpg")};
                j.e(fileR2, "root");
                j.e(strArr, "subDirFiles");
                StringBuilder sb = new StringBuilder(fileR2.getAbsolutePath());
                for (String str : strArr) {
                    if (str.length() > 0) {
                        sb.append(File.separator);
                        sb.append(str);
                    }
                }
                String string = sb.toString();
                j.d(string, "path.toString()");
                book2.setCoverUrl(string);
            }
            String coverUrl2 = getBook().getCoverUrl();
            j.c(coverUrl2);
            if (new File(coverUrl2).exists() || (coverImage = epubBook.getCoverImage()) == null || (inputStream = coverImage.getInputStream()) == null) {
                return;
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                FileUtils fileUtils = FileUtils.a;
                String coverUrl3 = getBook().getCoverUrl();
                j.c(coverUrl3);
                FileOutputStream fileOutputStream = new FileOutputStream(fileUtils.b(coverUrl3));
                bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                c.b.a.m.f.P0(inputStream, null);
            } finally {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<io.legado.app.data.entities.BookChapter> getChapterList() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.localBook.EpubFile.getChapterList():java.util.ArrayList");
    }

    private final String getChildChapter(BookChapter chapter, String href) throws Throwable {
        Elements elementsByTag;
        Element elementById;
        Elements elementsNextElementSiblings;
        Element elementById2;
        Elements elementsPreviousElementSiblings;
        d epubBook = getEpubBook();
        if (epubBook == null) {
            return null;
        }
        byte[] data = epubBook.getResources().getByHref(href).getData();
        j.d(data, "it.resources.getByHref(href).data");
        Element elementBody = Jsoup.parse(new String(data, this.mCharset)).body();
        if (j.a(chapter.getUrl(), href)) {
            String startFragmentId = chapter.getStartFragmentId();
            String endFragmentId = chapter.getEndFragmentId();
            if (!(startFragmentId == null || k.s(startFragmentId)) && (elementById2 = elementBody.getElementById(startFragmentId)) != null && (elementsPreviousElementSiblings = elementById2.previousElementSiblings()) != null) {
                elementsPreviousElementSiblings.remove();
            }
            if (!(endFragmentId == null || k.s(endFragmentId)) && !j.a(endFragmentId, startFragmentId) && (elementById = elementBody.getElementById(endFragmentId)) != null && (elementsNextElementSiblings = elementById.nextElementSiblings()) != null) {
                elementsNextElementSiblings.remove();
            }
        }
        if (getBook().getDelTag(2L)) {
            Elements elementsByTag2 = elementBody.getElementsByTag("h1");
            if (elementsByTag2 != null) {
                elementsByTag2.remove();
            }
            Elements elementsByTag3 = elementBody.getElementsByTag("h2");
            if (elementsByTag3 != null) {
                elementsByTag3.remove();
            }
            Elements elementsByTag4 = elementBody.getElementsByTag("h3");
            if (elementsByTag4 != null) {
                elementsByTag4.remove();
            }
            Elements elementsByTag5 = elementBody.getElementsByTag("h4");
            if (elementsByTag5 != null) {
                elementsByTag5.remove();
            }
            Elements elementsByTag6 = elementBody.getElementsByTag("h5");
            if (elementsByTag6 != null) {
                elementsByTag6.remove();
            }
            Elements elementsByTag7 = elementBody.getElementsByTag("h6");
            if (elementsByTag7 != null) {
                elementsByTag7.remove();
            }
        }
        if (getBook().getDelTag(8L) && (elementsByTag = elementBody.getElementsByTag("img")) != null) {
            elementsByTag.remove();
        }
        Elements elementsChildren = elementBody.children();
        elementsChildren.select("script").remove();
        elementsChildren.select("style").remove();
        String strOuterHtml = elementsChildren.outerHtml();
        if (getBook().getDelTag(4L)) {
            j.d(strOuterHtml, "html");
            strOuterHtml = new f.h0.g("<ruby>\\s?([\\u4e00-\\u9fa5])\\s?.*?</ruby>").replace(strOuterHtml, "$1");
        }
        q qVar = q.a;
        return q.b(strOuterHtml);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getContent(BookChapter chapter) {
        return getChildChapter(chapter, chapter.getUrl());
    }

    private final d getEpubBook() throws Throwable {
        d dVar = this.epubBook;
        if (dVar != null) {
            return dVar;
        }
        d epub = readEpub();
        this.epubBook = epub;
        return epub;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream getImage(String href) throws Throwable {
        p byHref;
        String strC = k.C(href, "../", "", false, 4);
        d epubBook = getEpubBook();
        s resources = epubBook == null ? null : epubBook.getResources();
        if (resources == null || (byHref = resources.getByHref(strC)) == null) {
            return null;
        }
        return byHref.getInputStream();
    }

    private final d readEpub() throws Throwable {
        try {
            return new e().a(new ZipFile(g.a.g(this.book)), "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upBookInfo() throws Throwable {
        if (getEpubBook() == null) {
            eFile = null;
            this.book.setIntro("书籍导入异常");
            return;
        }
        d epubBook = getEpubBook();
        j.c(epubBook);
        n metadata = epubBook.getMetadata();
        Book book = this.book;
        String firstTitle = metadata.getFirstTitle();
        j.d(firstTitle, "metadata.firstTitle");
        book.setName(firstTitle);
        if (this.book.getName().length() == 0) {
            Book book2 = this.book;
            book2.setName(k.C(book2.getOriginName(), ".epub", "", false, 4));
        }
        if (metadata.getAuthors().size() > 0) {
            String string = metadata.getAuthors().get(0).toString();
            j.d(string, "metadata.authors[0].toString()");
            this.book.setAuthor(new f.h0.g("^, |, $").replace(string, ""));
        }
        if (metadata.getDescriptions().size() > 0) {
            this.book.setIntro(Jsoup.parse(metadata.getDescriptions().get(0)).text());
        }
    }

    @NotNull
    public final Book getBook() {
        return this.book;
    }

    public final void setBook(@NotNull Book book) {
        j.e(book, "<set-?>");
        this.book = book;
    }
}
