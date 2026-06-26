package io.legado.app.ui.widget.recycler;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ItemTouchCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lio/legado/app/ui/widget/recycler/ItemTouchCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "", "isLongPressDragEnabled", "()Z", "isItemViewSwipeEnabled", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "getMovementFlags", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I", "srcViewHolder", "targetViewHolder", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "direction", "Lf/v;", "onSwiped", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "actionState", "onSelectedChanged", "clearView", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "b", "Z", "isCanDrag", "setCanDrag", "(Z)V", "Lio/legado/app/ui/widget/recycler/ItemTouchCallback$a;", ai.at, "Lio/legado/app/ui/widget/recycler/ItemTouchCallback$a;", "callback", "<init>", "(Lio/legado/app/ui/widget/recycler/ItemTouchCallback$a;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ItemTouchCallback extends ItemTouchHelper.Callback {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final a callback;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean isCanDrag;

    /* JADX INFO: compiled from: ItemTouchCallback.kt */
    public interface a {
        void a(int i2);

        void b(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder);

        boolean c(int i2, int i3);
    }

    public ItemTouchCallback(@NotNull a aVar) {
        j.e(aVar, "callback");
        this.callback = aVar;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        j.e(recyclerView, "recyclerView");
        j.e(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        this.callback.b(recyclerView, viewHolder);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        j.e(recyclerView, "recyclerView");
        j.e(viewHolder, "viewHolder");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int i2 = 0;
        if (layoutManager instanceof GridLayoutManager) {
            return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
        }
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return 0;
        }
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        int i3 = 12;
        if (orientation == 0) {
            i3 = 3;
            i2 = 12;
        } else if (orientation != 1) {
            i3 = 0;
        } else {
            i2 = 3;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(i2, i3);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    /* JADX INFO: renamed from: isLongPressDragEnabled, reason: from getter */
    public boolean getIsCanDrag() {
        return this.isCanDrag;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder srcViewHolder, @NotNull RecyclerView.ViewHolder targetViewHolder) {
        j.e(recyclerView, "recyclerView");
        j.e(srcViewHolder, "srcViewHolder");
        j.e(targetViewHolder, "targetViewHolder");
        int adapterPosition = srcViewHolder.getAdapterPosition();
        int adapterPosition2 = targetViewHolder.getAdapterPosition();
        if (adapterPosition >= adapterPosition2) {
            int i2 = adapterPosition2 + 1;
            if (i2 <= adapterPosition) {
                while (true) {
                    int i3 = adapterPosition - 1;
                    this.callback.c(adapterPosition, i3);
                    if (adapterPosition == i2) {
                        break;
                    }
                    adapterPosition = i3;
                }
            }
        } else if (adapterPosition < adapterPosition2) {
            while (true) {
                int i4 = adapterPosition + 1;
                this.callback.c(adapterPosition, i4);
                if (i4 >= adapterPosition2) {
                    break;
                }
                adapterPosition = i4;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
        j.e(viewHolder, "viewHolder");
        this.callback.a(viewHolder.getAdapterPosition());
    }
}
