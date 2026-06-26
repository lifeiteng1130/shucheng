package g.b.g2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public class k<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public k(boolean z) {
        this._cur = new l(8, z);
    }

    public final boolean a(@NotNull E e2) {
        while (true) {
            l lVar = (l) this._cur;
            int iA = lVar.a(e2);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                a.compareAndSet(this, lVar, lVar.e());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            l lVar = (l) this._cur;
            if (lVar.b()) {
                return;
            } else {
                a.compareAndSet(this, lVar, lVar.e());
            }
        }
    }

    public final int c() {
        return ((l) this._cur).c();
    }

    @Nullable
    public final E d() {
        while (true) {
            l lVar = (l) this._cur;
            E e2 = (E) lVar.f();
            if (e2 != l.f6201c) {
                return e2;
            }
            a.compareAndSet(this, lVar, lVar.e());
        }
    }
}
