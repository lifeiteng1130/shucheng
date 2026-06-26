package io.legado.app.ui.main.bookshelf.books;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import e.a.a.g.h.g.n.g;
import f.c0.c.j;
import f.x.e;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.ItemBookshelfListBinding;
import io.legado.app.ui.main.bookshelf.books.BaseBooksAdapter;
import io.legado.app.ui.main.bookshelf.books.BooksAdapterList;
import io.legado.app.ui.widget.anima.RotateLoading;
import io.legado.app.ui.widget.image.CoverImageView;
import io.legado.app.ui.widget.text.BadgeView;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BooksAdapterList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lio/legado/app/ui/main/bookshelf/books/BooksAdapterList;", "Lio/legado/app/ui/main/bookshelf/books/BaseBooksAdapter;", "Lio/legado/app/databinding/ItemBookshelfListBinding;", "binding", "Lio/legado/app/data/entities/Book;", "item", "Lf/v;", "o", "(Lio/legado/app/databinding/ItemBookshelfListBinding;Lio/legado/app/data/entities/Book;)V", "Lio/legado/app/ui/main/bookshelf/books/BaseBooksAdapter$a;", "d", "Lio/legado/app/ui/main/bookshelf/books/BaseBooksAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/main/bookshelf/books/BaseBooksAdapter$a;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BooksAdapterList extends BaseBooksAdapter<ItemBookshelfListBinding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final BaseBooksAdapter.a callBack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BooksAdapterList(@NotNull Context context, @NotNull BaseBooksAdapter.a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void d(ItemViewHolder itemViewHolder, ViewBinding viewBinding, Book book, List list) {
        ItemBookshelfListBinding itemBookshelfListBinding = (ItemBookshelfListBinding) viewBinding;
        Book book2 = book;
        j.e(itemViewHolder, "holder");
        j.e(itemBookshelfListBinding, "binding");
        j.e(book2, "item");
        j.e(list, "payloads");
        Object objN = e.n(list, 0);
        Bundle bundle = objN instanceof Bundle ? (Bundle) objN : null;
        if (bundle == null) {
            itemBookshelfListBinding.f6766g.setText(book2.getName());
            itemBookshelfListBinding.f6764e.setText(book2.getAuthor());
            itemBookshelfListBinding.f6767h.setText(book2.getDurChapterTitle());
            itemBookshelfListBinding.f6765f.setText(book2.getLatestChapterTitle());
            itemBookshelfListBinding.f6762c.b(book2.getDisplayCover(), book2.getName(), book2.getAuthor());
            o(itemBookshelfListBinding, book2);
            return;
        }
        itemBookshelfListBinding.f6767h.setText(book2.getDurChapterTitle());
        itemBookshelfListBinding.f6765f.setText(book2.getLatestChapterTitle());
        Set<String> setKeySet = bundle.keySet();
        j.d(setKeySet, "bundle.keySet()");
        for (String str : setKeySet) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1406328437:
                        if (str.equals("author")) {
                            itemBookshelfListBinding.f6764e.setText(book2.getAuthor());
                        }
                        break;
                    case 3373707:
                        if (str.equals("name")) {
                            itemBookshelfListBinding.f6766g.setText(book2.getName());
                        }
                        break;
                    case 94852023:
                        if (str.equals("cover")) {
                            itemBookshelfListBinding.f6762c.b(book2.getDisplayCover(), book2.getName(), book2.getAuthor());
                        }
                        break;
                    case 1085444827:
                        if (str.equals("refresh")) {
                            o(itemBookshelfListBinding, book2);
                        }
                        break;
                }
            }
        }
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public ViewBinding i(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_bookshelf_list, viewGroup, false);
        int i2 = R.id.bv_unread;
        BadgeView badgeView = (BadgeView) viewInflate.findViewById(R.id.bv_unread);
        if (badgeView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
            i2 = R.id.fl_has_new;
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.fl_has_new);
            if (frameLayout != null) {
                i2 = R.id.iv_author;
                AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_author);
                if (appCompatImageView != null) {
                    i2 = R.id.iv_cover;
                    CoverImageView coverImageView = (CoverImageView) viewInflate.findViewById(R.id.iv_cover);
                    if (coverImageView != null) {
                        i2 = R.id.iv_last;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_last);
                        if (appCompatImageView2 != null) {
                            i2 = R.id.iv_read;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_read);
                            if (appCompatImageView3 != null) {
                                i2 = R.id.rl_loading;
                                RotateLoading rotateLoading = (RotateLoading) viewInflate.findViewById(R.id.rl_loading);
                                if (rotateLoading != null) {
                                    i2 = R.id.tv_author;
                                    TextView textView = (TextView) viewInflate.findViewById(R.id.tv_author);
                                    if (textView != null) {
                                        i2 = R.id.tv_last;
                                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_last);
                                        if (textView2 != null) {
                                            i2 = R.id.tv_name;
                                            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_name);
                                            if (textView3 != null) {
                                                i2 = R.id.tv_read;
                                                TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_read);
                                                if (textView4 != null) {
                                                    i2 = R.id.vw_foreground;
                                                    View viewFindViewById = viewInflate.findViewById(R.id.vw_foreground);
                                                    if (viewFindViewById != null) {
                                                        ItemBookshelfListBinding itemBookshelfListBinding = new ItemBookshelfListBinding(constraintLayout, badgeView, constraintLayout, frameLayout, appCompatImageView, coverImageView, appCompatImageView2, appCompatImageView3, rotateLoading, textView, textView2, textView3, textView4, viewFindViewById);
                                                        j.d(itemBookshelfListBinding, "inflate(inflater, parent, false)");
                                                        return itemBookshelfListBinding;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void m(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemBookshelfListBinding) viewBinding, "binding");
        View view = itemViewHolder.itemView;
        view.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.h.g.n.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BooksAdapterList booksAdapterList = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(booksAdapterList, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                Book item = booksAdapterList.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                booksAdapterList.callBack.t(item);
            }
        });
        j.d(view, "");
        view.setOnLongClickListener(new g(true, this, itemViewHolder));
    }

    public final void o(ItemBookshelfListBinding binding, Book item) {
        if (!j.a(item.getOrigin(), "loc_book") && this.callBack.r(item.getBookUrl())) {
            BadgeView badgeView = binding.f6761b;
            j.d(badgeView, "binding.bvUnread");
            f.l3(badgeView);
            binding.f6763d.b();
            return;
        }
        binding.f6763d.a();
        if (e.a.a.d.e.a.j()) {
            binding.f6761b.setHighlight(item.getLastCheckCount() > 0);
            binding.f6761b.setBadgeCount(item.getUnreadChapterNum());
        } else {
            BadgeView badgeView2 = binding.f6761b;
            j.d(badgeView2, "binding.bvUnread");
            f.l3(badgeView2);
        }
    }
}
