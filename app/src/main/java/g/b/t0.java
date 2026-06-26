package g.b;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 {
    public static final g.b.g2.q a = new g.b.g2.q("REMOVED_TASK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g.b.g2.q f6300b = new g.b.g2.q("CLOSED_EMPTY");

    public static final long a(long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 >= 9223372036854L ? RecyclerView.FOREVER_NS : 1000000 * j2;
    }
}
