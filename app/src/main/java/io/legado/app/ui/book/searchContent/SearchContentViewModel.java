package io.legado.app.ui.book.searchContent;

import android.app.Application;
import com.umeng.analytics.pro.ai;
import e.a.a.d.k;
import f.c0.c.j;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.Book;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchContentViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lio/legado/app/ui/book/searchContent/SearchContentViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "f", "Ljava/lang/String;", "getLastQuery", "()Ljava/lang/String;", "setLastQuery", "(Ljava/lang/String;)V", "lastQuery", ai.aD, "getBookUrl", "setBookUrl", "bookUrl", "Lio/legado/app/data/entities/Book;", "d", "Lio/legado/app/data/entities/Book;", "getBook", "()Lio/legado/app/data/entities/Book;", "setBook", "(Lio/legado/app/data/entities/Book;)V", "book", "Le/a/a/d/k;", "e", "Le/a/a/d/k;", "getContentProcessor", "()Le/a/a/d/k;", "setContentProcessor", "(Le/a/a/d/k;)V", "contentProcessor", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchContentViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String bookUrl;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Book book;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public k contentProcessor;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String lastQuery;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchContentViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.bookUrl = "";
        this.lastQuery = "";
    }
}
