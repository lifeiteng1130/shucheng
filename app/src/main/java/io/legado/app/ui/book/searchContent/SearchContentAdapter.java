package io.legado.app.ui.book.searchContent;

import android.content.Context;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.g.d.k.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.ItemSearchListBinding;
import io.legado.app.ui.book.searchContent.SearchContentAdapter;
import io.wenyuange.app.release.R;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SearchContentAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR)\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lio/legado/app/ui/book/searchContent/SearchContentAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Le/a/a/g/d/k/j;", "Lio/legado/app/databinding/ItemSearchListBinding;", "", ai.aA, "Ljava/lang/String;", "getAccentColor", "()Ljava/lang/String;", "accentColor", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "g", "Ljava/util/HashSet;", "getCacheFileNames", "()Ljava/util/HashSet;", "cacheFileNames", "h", "getTextColor", "textColor", "Lio/legado/app/ui/book/searchContent/SearchContentAdapter$a;", "f", "Lio/legado/app/ui/book/searchContent/SearchContentAdapter$a;", "getCallback", "()Lio/legado/app/ui/book/searchContent/SearchContentAdapter$a;", "callback", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/searchContent/SearchContentAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchContentAdapter extends RecyclerAdapter<j, ItemSearchListBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callback;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashSet<String> cacheFileNames;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String textColor;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String accentColor;

    /* JADX INFO: compiled from: SearchContentAdapter.kt */
    public interface a {
        void Y(@NotNull j jVar);

        /* JADX INFO: renamed from: n */
        int getDurChapterIndex();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchContentAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        f.c0.c.j.e(context, c.R);
        f.c0.c.j.e(aVar, "callback");
        this.callback = aVar;
        this.cacheFileNames = new HashSet<>();
        String strSubstring = f.w2(f.c2(context, R.color.primaryText)).substring(2);
        f.c0.c.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        this.textColor = strSubstring;
        String strSubstring2 = f.w2(f.M1(context)).substring(2);
        f.c0.c.j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        this.accentColor = strSubstring2;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, j jVar, List list, int i2) {
        ItemSearchListBinding itemSearchListBinding = (ItemSearchListBinding) viewBinding;
        j jVar2 = jVar;
        f.c0.c.j.e(itemViewHolder, "holder");
        f.c0.c.j.e(itemSearchListBinding, "binding");
        f.c0.c.j.e(jVar2, "item");
        f.c0.c.j.e(list, "payloads");
        boolean z = this.callback.getDurChapterIndex() == jVar2.f5816g;
        if (list.isEmpty()) {
            TextView textView = itemSearchListBinding.f6847b;
            String str = this.textColor;
            String str2 = this.accentColor;
            f.c0.c.j.e(str, "textColor");
            f.c0.c.j.e(str2, "accentColor");
            StringBuilder sb = new StringBuilder();
            int i3 = jVar2.f5818i;
            String str3 = jVar2.f5814e;
            String str4 = jVar2.f5812c;
            Objects.requireNonNull(str4, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = str4.substring(0, i3);
            f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String str5 = jVar2.f5812c;
            int length = str3.length() + i3;
            int length2 = str4.length();
            Objects.requireNonNull(str5, "null cannot be cast to non-null type java.lang.String");
            String strSubstring2 = str5.substring(length, length2);
            f.c0.c.j.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            c.a.a.a.a.z(sb, "<font color=#" + str + '>' + strSubstring + "</font><font color=#" + str2 + '>' + str3 + "</font><font color=#" + str + '>' + strSubstring2 + "</font>", "<font color=#", str2, ">(");
            sb.append(jVar2.f5813d);
            sb.append(")</font>");
            Spanned spannedFromHtml = HtmlCompat.fromHtml(sb.toString(), 0);
            f.c0.c.j.d(spannedFromHtml, "fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)");
            textView.setText(spannedFromHtml);
            itemSearchListBinding.f6847b.getPaint().setFakeBoldText(z);
        }
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        f.c0.c.j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_search_list, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_search_result);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.tv_search_result)));
        }
        ItemSearchListBinding itemSearchListBinding = new ItemSearchListBinding((ConstraintLayout) viewInflate, textView);
        f.c0.c.j.d(itemSearchListBinding, "inflate(inflater, parent, false)");
        return itemSearchListBinding;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        f.c0.c.j.e(itemViewHolder, "holder");
        f.c0.c.j.e((ItemSearchListBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.k.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchContentAdapter searchContentAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(searchContentAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                j item = searchContentAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                searchContentAdapter.callback.Y(item);
            }
        });
    }
}
