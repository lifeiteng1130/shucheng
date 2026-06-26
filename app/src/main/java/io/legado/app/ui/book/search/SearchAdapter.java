package io.legado.app.ui.book.search;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import io.legado.app.databinding.ItemSearchBinding;
import io.legado.app.ui.book.search.SearchAdapter;
import io.legado.app.ui.widget.LabelsBar;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SearchAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lio/legado/app/ui/book/search/SearchAdapter;", "Lio/legado/app/base/adapter/DiffRecyclerAdapter;", "Lio/legado/app/data/entities/SearchBook;", "Lio/legado/app/databinding/ItemSearchBinding;", "binding", "", "latestChapterTitle", "Lf/v;", "p", "(Lio/legado/app/databinding/ItemSearchBinding;Ljava/lang/String;)V", "", "kinds", "o", "(Lio/legado/app/databinding/ItemSearchBinding;Ljava/util/List;)V", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "f", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffItemCallback", "Lio/legado/app/ui/book/search/SearchAdapter$a;", "d", "Lio/legado/app/ui/book/search/SearchAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/search/SearchAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/search/SearchAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchAdapter extends DiffRecyclerAdapter<SearchBook, ItemSearchBinding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: SearchAdapter.kt */
    public interface a {
        void l(@NotNull String str, @NotNull String str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void d(ItemViewHolder itemViewHolder, ViewBinding viewBinding, SearchBook searchBook, List list) {
        ItemSearchBinding itemSearchBinding = (ItemSearchBinding) viewBinding;
        SearchBook searchBook2 = searchBook;
        j.e(itemViewHolder, "holder");
        j.e(itemSearchBinding, "binding");
        j.e(searchBook2, "item");
        j.e(list, "payloads");
        Object objN = e.n(list, 0);
        Bundle bundle = objN instanceof Bundle ? (Bundle) objN : null;
        if (bundle == null) {
            itemSearchBinding.f6846h.setText(searchBook2.getName());
            itemSearchBinding.f6843e.setText(this.context.getString(R.string.author_show, searchBook2.getAuthor()));
            itemSearchBinding.f6840b.setBadgeCount(searchBook2.getOrigins().size());
            p(itemSearchBinding, searchBook2.getLatestChapterTitle());
            String intro = searchBook2.getIntro();
            if (intro == null || intro.length() == 0) {
                itemSearchBinding.f6844f.setText(this.context.getString(R.string.intro_show_null));
            } else {
                itemSearchBinding.f6844f.setText(this.context.getString(R.string.intro_show, searchBook2.getIntro()));
            }
            o(itemSearchBinding, searchBook2.getKindList());
            itemSearchBinding.f6841c.b(searchBook2.getCoverUrl(), searchBook2.getName(), searchBook2.getAuthor());
            return;
        }
        Set<String> setKeySet = bundle.keySet();
        j.d(setKeySet, "bundle.keySet()");
        ArrayList arrayList = new ArrayList(f.S0(setKeySet, 10));
        for (String str : setKeySet) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1202440691:
                        if (str.equals("origins")) {
                            itemSearchBinding.f6840b.setBadgeCount(searchBook2.getOrigins().size());
                        }
                        break;
                    case 3292052:
                        if (str.equals("kind")) {
                            o(itemSearchBinding, searchBook2.getKindList());
                        }
                        break;
                    case 3314326:
                        if (str.equals("last")) {
                            p(itemSearchBinding, searchBook2.getLatestChapterTitle());
                        }
                        break;
                    case 94852023:
                        if (str.equals("cover")) {
                            itemSearchBinding.f6841c.b(searchBook2.getCoverUrl(), searchBook2.getName(), searchBook2.getAuthor());
                        }
                        break;
                    case 100361836:
                        if (str.equals("intro")) {
                            String intro2 = searchBook2.getIntro();
                            if (intro2 == null || intro2.length() == 0) {
                                itemSearchBinding.f6844f.setText(this.context.getString(R.string.intro_show_null));
                            } else {
                                itemSearchBinding.f6844f.setText(this.context.getString(R.string.intro_show, searchBook2.getIntro()));
                            }
                        }
                        break;
                }
            }
            arrayList.add(v.a);
        }
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    @NotNull
    public DiffUtil.ItemCallback<SearchBook> f() {
        return new DiffUtil.ItemCallback<SearchBook>() { // from class: io.legado.app.ui.book.search.SearchAdapter$diffItemCallback$1
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
        ItemSearchBinding itemSearchBindingA = ItemSearchBinding.a(this.inflater, viewGroup, false);
        j.d(itemSearchBindingA, "inflate(inflater, parent, false)");
        return itemSearchBindingA;
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void m(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        ItemSearchBinding itemSearchBinding = (ItemSearchBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemSearchBinding, "binding");
        itemSearchBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.j.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAdapter searchAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(searchAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                SearchBook item = searchAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                searchAdapter.callBack.l(item.getName(), item.getAuthor());
            }
        });
    }

    public final void o(ItemSearchBinding binding, List<String> kinds) {
        if (kinds.isEmpty()) {
            LabelsBar labelsBar = binding.f6842d;
            j.d(labelsBar, "llKind");
            f.e3(labelsBar);
        } else {
            LabelsBar labelsBar2 = binding.f6842d;
            j.d(labelsBar2, "llKind");
            f.c6(labelsBar2);
            binding.f6842d.setLabels(kinds);
        }
    }

    public final void p(ItemSearchBinding binding, String latestChapterTitle) {
        if (latestChapterTitle == null || latestChapterTitle.length() == 0) {
            TextView textView = binding.f6845g;
            j.d(textView, "tvLasted");
            f.e3(textView);
        } else {
            binding.f6845g.setText(this.context.getString(R.string.lasted_show, latestChapterTitle));
            TextView textView2 = binding.f6845g;
            j.d(textView2, "tvLasted");
            f.c6(textView2);
        }
    }
}
