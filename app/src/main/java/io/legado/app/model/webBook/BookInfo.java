package io.legado.app.model.webBook;

import f.c0.c.j;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookSource;
import io.legado.app.model.Debug;
import io.legado.app.model.analyzeRule.AnalyzeRule;
import io.wenyuange.app.release.R;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JG\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010JM\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0013¨\u0006\u0016"}, d2 = {"Lio/legado/app/model/webBook/BookInfo;", "", "Lg/b/a0;", "scope", "Lio/legado/app/data/entities/Book;", "book", "", "body", "Lio/legado/app/data/entities/BookSource;", "bookSource", "baseUrl", "redirectUrl", "", "canReName", "Lf/v;", "analyzeBookInfo", "(Lg/b/a0;Lio/legado/app/data/entities/Book;Ljava/lang/String;Lio/legado/app/data/entities/BookSource;Ljava/lang/String;Ljava/lang/String;Z)V", "Lio/legado/app/model/analyzeRule/AnalyzeRule;", "analyzeRule", "(Lg/b/a0;Lio/legado/app/data/entities/Book;Ljava/lang/String;Lio/legado/app/model/analyzeRule/AnalyzeRule;Lio/legado/app/data/entities/BookSource;Ljava/lang/String;Ljava/lang/String;Z)V", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookInfo {

    @NotNull
    public static final BookInfo INSTANCE = new BookInfo();

    private BookInfo() {
    }

    public final void analyzeBookInfo(@NotNull a0 scope, @NotNull Book book, @Nullable String body, @NotNull BookSource bookSource, @NotNull String baseUrl, @NotNull String redirectUrl, boolean canReName) {
        j.e(scope, "scope");
        j.e(book, "book");
        j.e(bookSource, "bookSource");
        j.e(baseUrl, "baseUrl");
        j.e(redirectUrl, "redirectUrl");
        if (body == null) {
            throw new Exception(h.g().getString(R.string.error_get_web_content, baseUrl));
        }
        Debug debug = Debug.INSTANCE;
        Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("≡获取成功:", baseUrl), false, false, false, 0, 60, null);
        Debug.log$default(debug, bookSource.getBookSourceUrl(), body, false, false, false, 20, 28, null);
        AnalyzeRule analyzeRule = new AnalyzeRule(book);
        AnalyzeRule.setContent$default(analyzeRule, body, null, 2, null).setBaseUrl(baseUrl);
        analyzeRule.setRedirectUrl(redirectUrl);
        analyzeBookInfo(scope, book, body, analyzeRule, bookSource, baseUrl, redirectUrl, canReName);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void analyzeBookInfo(@org.jetbrains.annotations.NotNull g.b.a0 r28, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r29, @org.jetbrains.annotations.NotNull java.lang.String r30, @org.jetbrains.annotations.NotNull io.legado.app.model.analyzeRule.AnalyzeRule r31, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.BookSource r32, @org.jetbrains.annotations.NotNull java.lang.String r33, @org.jetbrains.annotations.NotNull java.lang.String r34, boolean r35) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.BookInfo.analyzeBookInfo(g.b.a0, io.legado.app.data.entities.Book, java.lang.String, io.legado.app.model.analyzeRule.AnalyzeRule, io.legado.app.data.entities.BookSource, java.lang.String, java.lang.String, boolean):void");
    }
}
