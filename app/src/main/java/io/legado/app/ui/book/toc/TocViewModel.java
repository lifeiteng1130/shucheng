package io.legado.app.ui.book.toc;

import android.app.Application;
import androidx.view.MutableLiveData;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.Book;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TocViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006)"}, d2 = {"Lio/legado/app/ui/book/toc/TocViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lio/legado/app/ui/book/toc/TocViewModel$b;", "e", "Lio/legado/app/ui/book/toc/TocViewModel$b;", "getChapterCallBack", "()Lio/legado/app/ui/book/toc/TocViewModel$b;", "setChapterCallBack", "(Lio/legado/app/ui/book/toc/TocViewModel$b;)V", "chapterCallBack", "", ai.aD, "Ljava/lang/String;", "getBookUrl", "()Ljava/lang/String;", "setBookUrl", "(Ljava/lang/String;)V", "bookUrl", "Landroidx/lifecycle/MutableLiveData;", "Lio/legado/app/data/entities/Book;", "d", "Landroidx/lifecycle/MutableLiveData;", "getBookData", "()Landroidx/lifecycle/MutableLiveData;", "setBookData", "(Landroidx/lifecycle/MutableLiveData;)V", "bookData", "Lio/legado/app/ui/book/toc/TocViewModel$a;", "f", "Lio/legado/app/ui/book/toc/TocViewModel$a;", "getBookMarkCallBack", "()Lio/legado/app/ui/book/toc/TocViewModel$a;", "setBookMarkCallBack", "(Lio/legado/app/ui/book/toc/TocViewModel$a;)V", "bookMarkCallBack", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", ai.at, "b", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TocViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String bookUrl;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public MutableLiveData<Book> bookData;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public b chapterCallBack;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a bookMarkCallBack;

    /* JADX INFO: compiled from: TocViewModel.kt */
    public interface a {
        void l(@Nullable String str);
    }

    /* JADX INFO: compiled from: TocViewModel.kt */
    public interface b {
        void z(@Nullable String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TocViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.bookUrl = "";
        this.bookData = new MutableLiveData<>();
    }
}
