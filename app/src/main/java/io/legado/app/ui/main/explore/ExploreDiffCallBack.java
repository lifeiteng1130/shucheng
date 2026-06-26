package io.legado.app.ui.main.explore;

import androidx.recyclerview.widget.DiffUtil;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import io.legado.app.data.entities.BookSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExploreDiffCallBack.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lio/legado/app/ui/main/explore/ExploreDiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "()I", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "(II)Z", "areContentsTheSame", "", "Lio/legado/app/data/entities/BookSource;", "b", "Ljava/util/List;", "newItems", ai.at, "oldItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ExploreDiffCallBack extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final List<BookSource> oldItems;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final List<BookSource> newItems;

    public ExploreDiffCallBack(@NotNull List<BookSource> list, @NotNull List<BookSource> list2) {
        j.e(list, "oldItems");
        j.e(list2, "newItems");
        this.oldItems = list;
        this.newItems = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return j.a(this.oldItems.get(oldItemPosition).getBookSourceName(), this.newItems.get(newItemPosition).getBookSourceName());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newItems.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldItems.size();
    }
}
