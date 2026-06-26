package io.legado.app.ui.book.changesource;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import io.legado.app.databinding.ItemChangeSourceBinding;
import io.legado.app.ui.book.changesource.ChangeSourceAdapter;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeSourceAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lio/legado/app/ui/book/changesource/ChangeSourceAdapter;", "Lio/legado/app/base/adapter/DiffRecyclerAdapter;", "Lio/legado/app/data/entities/SearchBook;", "Lio/legado/app/databinding/ItemChangeSourceBinding;", "Lio/legado/app/ui/book/changesource/ChangeSourceAdapter$a;", "d", "Lio/legado/app/ui/book/changesource/ChangeSourceAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/changesource/ChangeSourceAdapter$a;", "callBack", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "f", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffItemCallback", "Landroid/content/Context;", c.R, "Lio/legado/app/ui/book/changesource/ChangeSourceViewModel;", "viewModel", "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/changesource/ChangeSourceViewModel;Lio/legado/app/ui/book/changesource/ChangeSourceAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeSourceAdapter extends DiffRecyclerAdapter<SearchBook, ItemChangeSourceBinding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: ChangeSourceAdapter.kt */
    public interface a {
        void E(@NotNull SearchBook searchBook);

        void F(@NotNull SearchBook searchBook);

        @Nullable
        String getBookUrl();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeSourceAdapter(@NotNull Context context, @NotNull ChangeSourceViewModel changeSourceViewModel, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(changeSourceViewModel, "viewModel");
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void d(ItemViewHolder itemViewHolder, ViewBinding viewBinding, SearchBook searchBook, List list) {
        ItemChangeSourceBinding itemChangeSourceBinding = (ItemChangeSourceBinding) viewBinding;
        SearchBook searchBook2 = searchBook;
        j.e(itemViewHolder, "holder");
        j.e(itemChangeSourceBinding, "binding");
        j.e(searchBook2, "item");
        j.e(list, "payloads");
        Object objN = e.n(list, 0);
        Bundle bundle = objN instanceof Bundle ? (Bundle) objN : null;
        if (bundle == null) {
            itemChangeSourceBinding.f6771e.setText(searchBook2.getOriginName());
            itemChangeSourceBinding.f6769c.setText(searchBook2.getAuthor());
            itemChangeSourceBinding.f6770d.setText(searchBook2.getDisplayLastChapterTitle());
            if (j.a(this.callBack.getBookUrl(), searchBook2.getBookUrl())) {
                AppCompatImageView appCompatImageView = itemChangeSourceBinding.f6768b;
                j.d(appCompatImageView, "ivChecked");
                f.c6(appCompatImageView);
                return;
            } else {
                AppCompatImageView appCompatImageView2 = itemChangeSourceBinding.f6768b;
                j.d(appCompatImageView2, "ivChecked");
                f.l3(appCompatImageView2);
                return;
            }
        }
        Set<String> setKeySet = bundle.keySet();
        j.d(setKeySet, "bundle.keySet()");
        ArrayList arrayList = new ArrayList(f.S0(setKeySet, 10));
        for (String str : setKeySet) {
            if (j.a(str, "name")) {
                itemChangeSourceBinding.f6771e.setText(searchBook2.getOriginName());
            } else if (j.a(str, "latest")) {
                itemChangeSourceBinding.f6770d.setText(searchBook2.getDisplayLastChapterTitle());
            }
            arrayList.add(v.a);
        }
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    @NotNull
    public DiffUtil.ItemCallback<SearchBook> f() {
        return new DiffUtil.ItemCallback<SearchBook>() { // from class: io.legado.app.ui.book.changesource.ChangeSourceAdapter$diffItemCallback$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(SearchBook searchBook, SearchBook searchBook2) {
                SearchBook searchBook3 = searchBook;
                SearchBook searchBook4 = searchBook2;
                j.e(searchBook3, "oldItem");
                j.e(searchBook4, "newItem");
                return j.a(searchBook3.getOriginName(), searchBook4.getOriginName()) && j.a(searchBook3.getDisplayLastChapterTitle(), searchBook4.getDisplayLastChapterTitle());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(SearchBook searchBook, SearchBook searchBook2) {
                SearchBook searchBook3 = searchBook;
                SearchBook searchBook4 = searchBook2;
                j.e(searchBook3, "oldItem");
                j.e(searchBook4, "newItem");
                return j.a(searchBook3.getBookUrl(), searchBook4.getBookUrl());
            }
        };
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public ViewBinding i(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_change_source, viewGroup, false);
        int i2 = R.id.iv_checked;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_checked);
        if (appCompatImageView != null) {
            i2 = R.id.tv_author;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_author);
            if (textView != null) {
                i2 = R.id.tv_last;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_last);
                if (textView2 != null) {
                    i2 = R.id.tv_origin;
                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_origin);
                    if (textView3 != null) {
                        ItemChangeSourceBinding itemChangeSourceBinding = new ItemChangeSourceBinding((ConstraintLayout) viewInflate, appCompatImageView, textView, textView2, textView3);
                        j.d(itemChangeSourceBinding, "inflate(inflater, parent, false)");
                        return itemChangeSourceBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void m(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemChangeSourceBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.d.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeSourceAdapter changeSourceAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(changeSourceAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                SearchBook item = changeSourceAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                changeSourceAdapter.callBack.E(item);
            }
        });
        View view = itemViewHolder.itemView;
        j.d(view, "holder.itemView");
        view.setOnLongClickListener(new e.a.a.g.d.d.j(true, this, itemViewHolder));
    }
}
