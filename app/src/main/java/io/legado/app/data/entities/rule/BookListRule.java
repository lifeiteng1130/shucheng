package io.legado.app.data.entities.rule;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookListRule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b!\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\u0006R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0006R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0006R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0006R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u0006R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u0006¨\u0006#"}, d2 = {"Lio/legado/app/data/entities/rule/BookListRule;", "", "", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "author", "getUpdateTime", "setUpdateTime", "updateTime", "getCoverUrl", "setCoverUrl", "coverUrl", "getIntro", "setIntro", "intro", "getLastChapter", "setLastChapter", "lastChapter", "getWordCount", "setWordCount", "wordCount", "getKind", "setKind", "kind", "getBookUrl", "setBookUrl", "bookUrl", "getName", "setName", "name", "getBookList", "setBookList", "bookList", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface BookListRule {
    @Nullable
    String getAuthor();

    @Nullable
    String getBookList();

    @Nullable
    String getBookUrl();

    @Nullable
    String getCoverUrl();

    @Nullable
    String getIntro();

    @Nullable
    String getKind();

    @Nullable
    String getLastChapter();

    @Nullable
    String getName();

    @Nullable
    String getUpdateTime();

    @Nullable
    String getWordCount();

    void setAuthor(@Nullable String str);

    void setBookList(@Nullable String str);

    void setBookUrl(@Nullable String str);

    void setCoverUrl(@Nullable String str);

    void setIntro(@Nullable String str);

    void setKind(@Nullable String str);

    void setLastChapter(@Nullable String str);

    void setName(@Nullable String str);

    void setUpdateTime(@Nullable String str);

    void setWordCount(@Nullable String str);
}
