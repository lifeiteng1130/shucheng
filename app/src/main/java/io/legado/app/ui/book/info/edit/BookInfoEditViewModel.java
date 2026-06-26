package io.legado.app.ui.book.info.edit;

import android.app.Application;
import androidx.view.MutableLiveData;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.Book;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lio/legado/app/ui/book/info/edit/BookInfoEditViewModel;", "Lio/legado/app/base/BaseViewModel;", "Landroidx/lifecycle/MutableLiveData;", "Lio/legado/app/data/entities/Book;", "d", "Landroidx/lifecycle/MutableLiveData;", "getBookData", "()Landroidx/lifecycle/MutableLiveData;", "bookData", ai.aD, "Lio/legado/app/data/entities/Book;", "getBook", "()Lio/legado/app/data/entities/Book;", "setBook", "(Lio/legado/app/data/entities/Book;)V", "book", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookInfoEditViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Book book;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Book> bookData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookInfoEditViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.bookData = new MutableLiveData<>();
    }
}
