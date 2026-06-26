package io.legado.app.ui.main.explore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.google.android.flexbox.FlexboxLayout;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.u.b;
import e.a.a.g.h.h.p;
import e.a.a.g.h.h.q;
import e.a.a.g.h.h.r;
import e.a.a.g.h.h.s;
import f.c0.c.j;
import g.b.a0;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.ItemFindBookBinding;
import io.legado.app.ui.main.explore.ExploreAdapter;
import io.legado.app.ui.widget.anima.RotateLoading;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ExploreAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lio/legado/app/ui/main/explore/ExploreAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/BookSource;", "Lio/legado/app/databinding/ItemFindBookBinding;", "", "h", OptRuntime.GeneratorState.resumptionPoint_TYPE, "exIndex", "Lio/legado/app/ui/main/explore/ExploreAdapter$a;", "g", "Lio/legado/app/ui/main/explore/ExploreAdapter$a;", "getCallBack", "()Lio/legado/app/ui/main/explore/ExploreAdapter$a;", "callBack", ai.aA, "scrollTo", "Lg/b/a0;", "f", "Lg/b/a0;", "scope", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lg/b/a0;Lio/legado/app/ui/main/explore/ExploreAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ExploreAdapter extends RecyclerAdapter<BookSource, ItemFindBookBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a0 scope;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int exIndex;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int scrollTo;

    /* JADX INFO: compiled from: ExploreAdapter.kt */
    public interface a {
        void G(@NotNull String str, @NotNull String str2, @NotNull String str3);

        void J(@NotNull String str);

        void a(int i2);

        void j(@NotNull BookSource bookSource);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreAdapter(@NotNull Context context, @NotNull a0 a0Var, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(a0Var, "scope");
        j.e(aVar, "callBack");
        this.scope = a0Var;
        this.callBack = aVar;
        this.exIndex = -1;
        this.scrollTo = -1;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, BookSource bookSource, List list, int i2) {
        ItemFindBookBinding itemFindBookBinding = (ItemFindBookBinding) viewBinding;
        BookSource bookSource2 = bookSource;
        j.e(itemViewHolder, "holder");
        j.e(itemFindBookBinding, "binding");
        j.e(bookSource2, "item");
        j.e(list, "payloads");
        if (itemViewHolder.getLayoutPosition() == getItemCount() - 1) {
            itemFindBookBinding.a.setPadding(f.m2(16), f.m2(12), f.m2(16), f.m2(12));
        } else {
            itemFindBookBinding.a.setPadding(f.m2(16), f.m2(12), f.m2(16), 0);
        }
        if (list.isEmpty()) {
            itemFindBookBinding.f6789f.setText(bookSource2.getBookSourceName());
        }
        if (this.exIndex != itemViewHolder.getLayoutPosition()) {
            itemFindBookBinding.f6786c.setImageResource(R.drawable.ic_arrow_right);
            itemFindBookBinding.f6788e.a();
            FlexboxLayout flexboxLayout = itemFindBookBinding.f6785b;
            j.d(flexboxLayout, "binding.glChild");
            f.e3(flexboxLayout);
            return;
        }
        itemFindBookBinding.f6786c.setImageResource(R.drawable.ic_arrow_down);
        itemFindBookBinding.f6788e.setLoadingColor(f.M1(this.context));
        itemFindBookBinding.f6788e.b();
        int i3 = this.scrollTo;
        if (i3 >= 0) {
            this.callBack.a(i3);
        }
        b bVarB = b.C0148b.b(b.a, this.scope, null, new p(bookSource2, null), 2);
        bVarB.d(null, new q(itemFindBookBinding, this, bookSource2, null));
        b.c(bVarB, null, new r(itemFindBookBinding, this, null), 1);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_find_book, viewGroup, false);
        int i2 = R.id.gl_child;
        FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate.findViewById(R.id.gl_child);
        if (flexboxLayout != null) {
            i2 = R.id.iv_status;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_status);
            if (imageView != null) {
                i2 = R.id.ll_title;
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_title);
                if (linearLayout != null) {
                    i2 = R.id.rotate_loading;
                    RotateLoading rotateLoading = (RotateLoading) viewInflate.findViewById(R.id.rotate_loading);
                    if (rotateLoading != null) {
                        i2 = R.id.tv_name;
                        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
                        if (textView != null) {
                            ItemFindBookBinding itemFindBookBinding = new ItemFindBookBinding((LinearLayout) viewInflate, flexboxLayout, imageView, linearLayout, rotateLoading, textView);
                            j.d(itemFindBookBinding, "inflate(inflater, parent, false)");
                            return itemFindBookBinding;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        ItemFindBookBinding itemFindBookBinding = (ItemFindBookBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemFindBookBinding, "binding");
        itemFindBookBinding.f6787d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.h.h.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                ExploreAdapter exploreAdapter = this;
                f.c0.c.j.e(itemViewHolder2, "$holder");
                f.c0.c.j.e(exploreAdapter, "this$0");
                int layoutPosition = itemViewHolder2.getLayoutPosition();
                int i2 = exploreAdapter.exIndex;
                exploreAdapter.exIndex = i2 == layoutPosition ? -1 : layoutPosition;
                Boolean bool = Boolean.FALSE;
                exploreAdapter.notifyItemChanged(i2, bool);
                if (exploreAdapter.exIndex != -1) {
                    exploreAdapter.scrollTo = layoutPosition;
                    exploreAdapter.callBack.a(layoutPosition);
                    exploreAdapter.notifyItemChanged(layoutPosition, bool);
                }
            }
        });
        LinearLayout linearLayout = itemFindBookBinding.f6787d;
        j.d(linearLayout, "llTitle");
        linearLayout.setOnLongClickListener(new s(true, this, itemFindBookBinding, itemViewHolder));
    }
}
