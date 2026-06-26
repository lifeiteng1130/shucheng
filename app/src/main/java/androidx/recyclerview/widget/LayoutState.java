package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes.dex */
public class LayoutState {
    public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    public static final int ITEM_DIRECTION_HEAD = -1;
    public static final int ITEM_DIRECTION_TAIL = 1;
    public static final int LAYOUT_END = 1;
    public static final int LAYOUT_START = -1;
    public int mAvailable;
    public int mCurrentPosition;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mStopInFocusable;
    public boolean mRecycle = true;
    public int mStartLine = 0;
    public int mEndLine = 0;

    public boolean hasMore(RecyclerView.State state) {
        int i2 = this.mCurrentPosition;
        return i2 >= 0 && i2 < state.getItemCount();
    }

    public View next(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public String toString() {
        StringBuilder sbR = a.r("LayoutState{mAvailable=");
        sbR.append(this.mAvailable);
        sbR.append(", mCurrentPosition=");
        sbR.append(this.mCurrentPosition);
        sbR.append(", mItemDirection=");
        sbR.append(this.mItemDirection);
        sbR.append(", mLayoutDirection=");
        sbR.append(this.mLayoutDirection);
        sbR.append(", mStartLine=");
        sbR.append(this.mStartLine);
        sbR.append(", mEndLine=");
        return a.n(sbR, this.mEndLine, MessageFormatter.DELIM_STOP);
    }
}
