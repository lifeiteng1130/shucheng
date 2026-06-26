package io.legado.app.data.entities;

import c.b.a.m.f;
import f.c0.c.j;
import f.h0.k;
import io.legado.app.model.analyzeRule.RuleDataInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001a\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0013\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0019\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001d"}, d2 = {"Lio/legado/app/data/entities/BaseBook;", "Lio/legado/app/model/analyzeRule/RuleDataInterface;", "", "", "getKindList", "()Ljava/util/List;", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "author", "getWordCount", "setWordCount", "wordCount", "getTocHtml", "setTocHtml", "tocHtml", "getBookUrl", "setBookUrl", "bookUrl", "getInfoHtml", "setInfoHtml", "infoHtml", "getName", "setName", "name", "getKind", "setKind", "kind", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public interface BaseBook extends RuleDataInterface {

    /* JADX INFO: compiled from: BaseBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @NotNull
        public static List<String> getKindList(@NotNull BaseBook baseBook) {
            j.e(baseBook, "this");
            ArrayList arrayList = new ArrayList();
            String wordCount = baseBook.getWordCount();
            if (wordCount != null && (!k.s(wordCount))) {
                arrayList.add(wordCount);
            }
            String kind = baseBook.getKind();
            if (kind != null) {
                f.T(arrayList, f.n5(kind, ",", "\n"));
            }
            return arrayList;
        }
    }

    @NotNull
    String getAuthor();

    @NotNull
    String getBookUrl();

    @Nullable
    String getInfoHtml();

    @Nullable
    String getKind();

    @NotNull
    List<String> getKindList();

    @NotNull
    String getName();

    @Nullable
    String getTocHtml();

    @Nullable
    String getWordCount();

    void setAuthor(@NotNull String str);

    void setBookUrl(@NotNull String str);

    void setInfoHtml(@Nullable String str);

    void setKind(@Nullable String str);

    void setName(@NotNull String str);

    void setTocHtml(@Nullable String str);

    void setWordCount(@Nullable String str);
}
