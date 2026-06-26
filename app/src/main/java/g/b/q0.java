package g.b;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q0 extends y {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.b.g2.a<j0<?>> f6285d;

    public final void n(boolean z) {
        long jO = this.f6283b - o(z);
        this.f6283b = jO;
        if (jO <= 0 && this.f6284c) {
            shutdown();
        }
    }

    public final long o(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public final void p(@NotNull j0<?> j0Var) {
        g.b.g2.a<j0<?>> aVar = this.f6285d;
        if (aVar == null) {
            aVar = new g.b.g2.a<>();
            this.f6285d = aVar;
        }
        Object[] objArr = aVar.a;
        int i2 = aVar.f6189c;
        objArr[i2] = j0Var;
        int length = (objArr.length - 1) & (i2 + 1);
        aVar.f6189c = length;
        int i3 = aVar.f6188b;
        if (length == i3) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            f.x.e.e(objArr, objArr2, 0, i3, 0, 10);
            Object[] objArr3 = aVar.a;
            int length3 = objArr3.length;
            int i4 = aVar.f6188b;
            f.x.e.e(objArr3, objArr2, length3 - i4, 0, i4, 4);
            aVar.a = objArr2;
            aVar.f6188b = 0;
            aVar.f6189c = length2;
        }
    }

    public final void q(boolean z) {
        this.f6283b = o(z) + this.f6283b;
        if (z) {
            return;
        }
        this.f6284c = true;
    }

    public final boolean r() {
        return this.f6283b >= o(true);
    }

    public long s() {
        if (t()) {
            return 0L;
        }
        return RecyclerView.FOREVER_NS;
    }

    public void shutdown() {
    }

    public final boolean t() {
        g.b.g2.a<j0<?>> aVar = this.f6285d;
        if (aVar != null) {
            int i2 = aVar.f6188b;
            Object obj = null;
            if (i2 != aVar.f6189c) {
                Object[] objArr = aVar.a;
                Object obj2 = objArr[i2];
                objArr[i2] = null;
                aVar.f6188b = (i2 + 1) & (objArr.length - 1);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type T");
                obj = obj2;
            }
            j0 j0Var = (j0) obj;
            if (j0Var != null) {
                j0Var.run();
                return true;
            }
        }
        return false;
    }
}
