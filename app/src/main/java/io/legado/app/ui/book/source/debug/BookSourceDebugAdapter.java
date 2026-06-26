package io.legado.app.ui.book.source.debug;

import android.content.Context;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.c;
import e.a.a.g.d.l.a.b;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.ItemLogBinding;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookSourceDebugAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/book/source/debug/BookSourceDebugAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "", "Lio/legado/app/databinding/ItemLogBinding;", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookSourceDebugAdapter extends RecyclerAdapter<String, ItemLogBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookSourceDebugAdapter(@NotNull Context context) {
        super(context);
        j.e(context, c.R);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, String str, List list, int i2) {
        ItemLogBinding itemLogBinding = (ItemLogBinding) viewBinding;
        String str2 = str;
        j.e(itemViewHolder, "holder");
        j.e(itemLogBinding, "binding");
        j.e(str2, "item");
        j.e(list, "payloads");
        if (itemLogBinding.f6809b.getTag(R.id.tag1) == null) {
            b bVar = new b(itemLogBinding);
            itemLogBinding.f6809b.addOnAttachStateChangeListener(bVar);
            itemLogBinding.f6809b.setTag(R.id.tag1, bVar);
        }
        itemLogBinding.f6809b.setText(str2);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        ItemLogBinding itemLogBindingA = ItemLogBinding.a(this.inflater, viewGroup, false);
        j.d(itemLogBindingA, "inflate(inflater, parent, false)");
        return itemLogBindingA;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemLogBinding) viewBinding, "binding");
    }
}
