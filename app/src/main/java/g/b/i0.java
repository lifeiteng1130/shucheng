package g.b;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i0<T> extends g.b.g2.p<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6257e = AtomicIntegerFieldUpdater.newUpdater(i0.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public i0(@NotNull f.z.f fVar, @NotNull f.z.d<? super T> dVar) {
        super(fVar, dVar);
        this._decision = 0;
    }

    @Override // g.b.g2.p, g.b.a
    public void T(@Nullable Object obj) {
        boolean z;
        while (true) {
            int i2 = this._decision;
            z = false;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
            } else if (f6257e.compareAndSet(this, 0, 2)) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        g.b.g2.g.b(c.b.a.m.f.j3(this.f6208d), c.b.a.m.f.F4(obj, this.f6208d), null, 2);
    }

    @Nullable
    public final Object W() {
        boolean z;
        while (true) {
            int i2 = this._decision;
            z = false;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new IllegalStateException("Already suspended".toString());
                }
            } else if (f6257e.compareAndSet(this, 0, 1)) {
                z = true;
                break;
            }
        }
        if (z) {
            return f.z.i.a.COROUTINE_SUSPENDED;
        }
        Object objA = l1.a(B());
        if (objA instanceof s) {
            throw ((s) objA).f6298b;
        }
        return objA;
    }

    @Override // g.b.g2.p, g.b.k1
    public void o(@Nullable Object obj) {
        T(obj);
    }
}
