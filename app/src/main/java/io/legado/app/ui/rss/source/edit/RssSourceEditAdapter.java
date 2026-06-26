package io.legado.app.ui.rss.source.edit;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.ai;
import e.a.a.g.k.d.b.b;
import e.a.a.g.k.d.b.e;
import e.a.a.g.k.d.b.f;
import f.c0.c.j;
import io.legado.app.databinding.ItemSourceEditBinding;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: RssSourceEditAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005RJ\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lio/legado/app/ui/rss/source/edit/RssSourceEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lio/legado/app/ui/rss/source/edit/RssSourceEditAdapter$MyViewHolder;", "", "getItemCount", "()I", "Ljava/util/ArrayList;", "Le/a/a/g/k/d/b/b;", "Lkotlin/collections/ArrayList;", ES6Iterator.VALUE_PROPERTY, ai.at, "Ljava/util/ArrayList;", "getEditEntities", "()Ljava/util/ArrayList;", "setEditEntities", "(Ljava/util/ArrayList;)V", "editEntities", "<init>", "()V", "MyViewHolder", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSourceEditAdapter extends RecyclerView.Adapter<MyViewHolder> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public ArrayList<b> editEntities = new ArrayList<>();

    /* JADX INFO: compiled from: RssSourceEditAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lio/legado/app/ui/rss/source/edit/RssSourceEditAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lio/legado/app/databinding/ItemSourceEditBinding;", ai.at, "Lio/legado/app/databinding/ItemSourceEditBinding;", "getBinding", "()Lio/legado/app/databinding/ItemSourceEditBinding;", "binding", "<init>", "(Lio/legado/app/databinding/ItemSourceEditBinding;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class MyViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        @NotNull
        public final ItemSourceEditBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyViewHolder(@NotNull ItemSourceEditBinding itemSourceEditBinding) {
            super(itemSourceEditBinding.a);
            j.e(itemSourceEditBinding, "binding");
            this.binding = itemSourceEditBinding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.editEntities.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        j.e(myViewHolder, "holder");
        b bVar = this.editEntities.get(i2);
        j.d(bVar, "editEntities[position]");
        b bVar2 = bVar;
        j.e(bVar2, "editEntity");
        ItemSourceEditBinding itemSourceEditBinding = myViewHolder.binding;
        if (itemSourceEditBinding.f6848b.getTag(R.id.tag1) == null) {
            e eVar = new e(itemSourceEditBinding);
            itemSourceEditBinding.f6848b.addOnAttachStateChangeListener(eVar);
            itemSourceEditBinding.f6848b.setTag(R.id.tag1, eVar);
        }
        Object tag = itemSourceEditBinding.f6848b.getTag(R.id.tag2);
        if (tag != null && (tag instanceof TextWatcher)) {
            itemSourceEditBinding.f6848b.removeTextChangedListener((TextWatcher) tag);
        }
        itemSourceEditBinding.f6848b.setText(bVar2.f5881b);
        itemSourceEditBinding.f6849c.setHint(myViewHolder.itemView.getContext().getString(bVar2.f5882c));
        f fVar = new f(bVar2);
        itemSourceEditBinding.f6848b.addTextChangedListener(fVar);
        itemSourceEditBinding.f6848b.setTag(R.id.tag2, fVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        j.e(viewGroup, "parent");
        ItemSourceEditBinding itemSourceEditBindingA = ItemSourceEditBinding.a(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        j.d(itemSourceEditBindingA, "inflate(LayoutInflater.from(parent.context), parent, false)");
        return new MyViewHolder(itemSourceEditBindingA);
    }
}
