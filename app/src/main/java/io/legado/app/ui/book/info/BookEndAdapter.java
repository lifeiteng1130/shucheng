package io.legado.app.ui.book.info;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.v;
import f.x.e;
import io.legado.app.base.adapter.DiffRecyclerAdapter;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.databinding.ItemBookEndBinding;
import io.legado.app.ui.book.info.BookEndAdapter;
import io.legado.app.ui.widget.image.CoverImageView;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookEndAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lio/legado/app/ui/book/info/BookEndAdapter;", "Lio/legado/app/base/adapter/DiffRecyclerAdapter;", "Lio/legado/app/data/entities/SearchBook;", "Lio/legado/app/databinding/ItemBookEndBinding;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "f", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffItemCallback", "Lio/legado/app/ui/book/info/BookEndAdapter$a;", "d", "Lio/legado/app/ui/book/info/BookEndAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/info/BookEndAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/info/BookEndAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookEndAdapter extends DiffRecyclerAdapter<SearchBook, ItemBookEndBinding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: BookEndAdapter.kt */
    public interface a {
        void l(@NotNull String str, @NotNull String str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookEndAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void d(ItemViewHolder itemViewHolder, ViewBinding viewBinding, SearchBook searchBook, List list) {
        ItemBookEndBinding itemBookEndBinding = (ItemBookEndBinding) viewBinding;
        SearchBook searchBook2 = searchBook;
        j.e(itemViewHolder, "holder");
        j.e(itemBookEndBinding, "binding");
        j.e(searchBook2, "item");
        j.e(list, "payloads");
        Object objN = e.n(list, 0);
        Bundle bundle = objN instanceof Bundle ? (Bundle) objN : null;
        if (bundle == null) {
            itemBookEndBinding.f6745c.setText(searchBook2.getName());
            itemBookEndBinding.f6744b.b(searchBook2.getCoverUrl(), searchBook2.getName(), searchBook2.getAuthor());
            return;
        }
        Set<String> setKeySet = bundle.keySet();
        j.d(setKeySet, "bundle.keySet()");
        ArrayList arrayList = new ArrayList(f.S0(setKeySet, 10));
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            if (j.a((String) it.next(), "cover")) {
                itemBookEndBinding.f6744b.b(searchBook2.getCoverUrl(), searchBook2.getName(), searchBook2.getAuthor());
            }
            arrayList.add(v.a);
        }
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    @NotNull
    public DiffUtil.ItemCallback<SearchBook> f() {
        return new DiffUtil.ItemCallback<SearchBook>() { // from class: io.legado.app.ui.book.info.BookEndAdapter$diffItemCallback$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(SearchBook searchBook, SearchBook searchBook2) {
                j.e(searchBook, "oldItem");
                j.e(searchBook2, "newItem");
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(SearchBook searchBook, SearchBook searchBook2) {
                SearchBook searchBook3 = searchBook;
                SearchBook searchBook4 = searchBook2;
                j.e(searchBook3, "oldItem");
                j.e(searchBook4, "newItem");
                return j.a(searchBook3.getName(), searchBook4.getName()) && j.a(searchBook3.getAuthor(), searchBook4.getAuthor());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public Object getChangePayload(SearchBook searchBook, SearchBook searchBook2) {
                SearchBook searchBook3 = searchBook;
                SearchBook searchBook4 = searchBook2;
                j.e(searchBook3, "oldItem");
                j.e(searchBook4, "newItem");
                Bundle bundle = new Bundle();
                bundle.putInt("origins", searchBook4.getOrigins().size());
                if (!j.a(searchBook3.getCoverUrl(), searchBook4.getCoverUrl())) {
                    bundle.putString("cover", searchBook4.getCoverUrl());
                }
                if (!j.a(searchBook3.getKind(), searchBook4.getKind())) {
                    bundle.putString("kind", searchBook4.getKind());
                }
                if (!j.a(searchBook3.getLatestChapterTitle(), searchBook4.getLatestChapterTitle())) {
                    bundle.putString("last", searchBook4.getLatestChapterTitle());
                }
                if (!j.a(searchBook3.getIntro(), searchBook4.getIntro())) {
                    bundle.putString("intro", searchBook4.getIntro());
                }
                return bundle;
            }
        };
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public ViewBinding i(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_book_end, viewGroup, false);
        int i2 = R.id.iv_cover;
        CoverImageView coverImageView = (CoverImageView) viewInflate.findViewById(R.id.iv_cover);
        if (coverImageView != null) {
            i2 = R.id.tv_name;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
            if (textView != null) {
                ItemBookEndBinding itemBookEndBinding = new ItemBookEndBinding((LinearLayout) viewInflate, coverImageView, textView);
                j.d(itemBookEndBinding, "inflate(inflater, parent, false)");
                return itemBookEndBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void m(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        ItemBookEndBinding itemBookEndBinding = (ItemBookEndBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemBookEndBinding, "binding");
        itemBookEndBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookEndAdapter bookEndAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(bookEndAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                SearchBook item = bookEndAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                bookEndAdapter.callBack.l(item.getName(), item.getAuthor());
            }
        });
    }
}
