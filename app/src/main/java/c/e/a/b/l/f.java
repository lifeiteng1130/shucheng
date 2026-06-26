package c.e.a.b.l;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.YearGridAdapter;
import java.util.Calendar;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends RecyclerView.ItemDecoration {
    public final Calendar a = u.i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Calendar f1029b = u.i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f1030c;

    public f(MaterialCalendar materialCalendar) {
        this.f1030c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (Pair<Long, Long> pair : this.f1030c.f2185d.t()) {
                Long l2 = pair.first;
                if (l2 != null && pair.second != null) {
                    this.a.setTimeInMillis(l2.longValue());
                    this.f1029b.setTimeInMillis(pair.second.longValue());
                    int iD = yearGridAdapter.d(this.a.get(1));
                    int iD2 = yearGridAdapter.d(this.f1029b.get(1));
                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iD);
                    View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iD2);
                    int spanCount = iD / gridLayoutManager.getSpanCount();
                    int spanCount2 = iD2 / gridLayoutManager.getSpanCount();
                    for (int i2 = spanCount; i2 <= spanCount2; i2++) {
                        View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i2);
                        if (viewFindViewByPosition3 != null) {
                            int top = viewFindViewByPosition3.getTop() + this.f1030c.f2189h.f1014d.a.top;
                            int bottom = viewFindViewByPosition3.getBottom() - this.f1030c.f2189h.f1014d.a.bottom;
                            canvas.drawRect(i2 == spanCount ? (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft() : 0, top, i2 == spanCount2 ? (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft() : recyclerView.getWidth(), bottom, this.f1030c.f2189h.f1018h);
                        }
                    }
                }
            }
        }
    }
}
