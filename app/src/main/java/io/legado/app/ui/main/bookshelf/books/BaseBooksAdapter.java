package io.legado.app.ui.main.bookshelf.books;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.g;
import io.legado.app.base.adapter.DiffRecyclerAdapter;
import io.legado.app.data.entities.Book;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BaseBooksAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\rB\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lio/legado/app/ui/main/bookshelf/books/BaseBooksAdapter;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lio/legado/app/base/adapter/DiffRecyclerAdapter;", "Lio/legado/app/data/entities/Book;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "f", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffItemCallback", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseBooksAdapter<VB extends ViewBinding> extends DiffRecyclerAdapter<Book, VB> {

    /* JADX INFO: compiled from: BaseBooksAdapter.kt */
    public interface a {
        boolean r(@NotNull String str);

        void t(@NotNull Book book);

        void v(@NotNull Book book);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBooksAdapter(@NotNull Context context) {
        super(context);
        j.e(context, c.R);
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    @NotNull
    public DiffUtil.ItemCallback<Book> f() {
        return new DiffUtil.ItemCallback<Book>() { // from class: io.legado.app.ui.main.bookshelf.books.BaseBooksAdapter$diffItemCallback$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(Book book, Book book2) {
                Book book3 = book;
                Book book4 = book2;
                j.e(book3, "oldItem");
                j.e(book4, "newItem");
                return book3.getDurChapterTime() == book4.getDurChapterTime() && j.a(book3.getName(), book4.getName()) && j.a(book3.getAuthor(), book4.getAuthor()) && j.a(book3.getDurChapterTitle(), book4.getDurChapterTitle()) && j.a(book3.getLatestChapterTitle(), book4.getLatestChapterTitle()) && book3.getLastCheckCount() == book4.getLastCheckCount() && j.a(book3.getDisplayCover(), book4.getDisplayCover()) && book3.getUnreadChapterNum() == book4.getUnreadChapterNum();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(Book book, Book book2) {
                Book book3 = book;
                Book book4 = book2;
                j.e(book3, "oldItem");
                j.e(book4, "newItem");
                return j.a(book3.getName(), book4.getName()) && j.a(book3.getAuthor(), book4.getAuthor());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public Object getChangePayload(Book book, Book book2) {
                Book book3 = book;
                Book book4 = book2;
                j.e(book3, "oldItem");
                j.e(book4, "newItem");
                Bundle bundleBundleOf = BundleKt.bundleOf(new g[0]);
                if (!j.a(book3.getName(), book4.getName())) {
                    bundleBundleOf.putString("name", book4.getName());
                }
                if (!j.a(book3.getAuthor(), book4.getAuthor())) {
                    bundleBundleOf.putString("author", book4.getAuthor());
                }
                if (!j.a(book3.getDurChapterTitle(), book4.getDurChapterTitle())) {
                    bundleBundleOf.putString("dur", book4.getDurChapterTitle());
                }
                if (!j.a(book3.getLatestChapterTitle(), book4.getLatestChapterTitle())) {
                    bundleBundleOf.putString("last", book4.getLatestChapterTitle());
                }
                if (!j.a(book3.getDisplayCover(), book4.getDisplayCover())) {
                    bundleBundleOf.putString("cover", book4.getDisplayCover());
                }
                if (book3.getLastCheckCount() != book4.getLastCheckCount() || book3.getDurChapterTime() != book4.getDurChapterTime() || book3.getUnreadChapterNum() != book4.getUnreadChapterNum() || book3.getLastCheckCount() != book4.getLastCheckCount()) {
                    bundleBundleOf.putBoolean("refresh", true);
                }
                if (bundleBundleOf.isEmpty()) {
                    return null;
                }
                return bundleBundleOf;
            }
        };
    }
}
