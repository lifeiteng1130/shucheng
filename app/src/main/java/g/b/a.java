package g.b;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractCoroutine.kt */
/* JADX INFO: loaded from: classes3.dex */
@InternalCoroutinesApi
public abstract class a<T> extends k1 implements f1, f.z.d<T>, a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final f.z.f f6170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public final f.z.f f6171c;

    public a(@NotNull f.z.f fVar, boolean z) {
        super(z);
        this.f6171c = fVar;
        this.f6170b = fVar.plus(this);
    }

    @Override // g.b.k1
    public final void D(@NotNull Throwable th) {
        c.b.a.m.f.f3(this.f6170b, th);
    }

    @Override // g.b.k1
    @NotNull
    public String I() {
        boolean z = w.a;
        return super.I();
    }

    @Override // g.b.k1
    public final void L(@Nullable Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            Throwable th = sVar.f6298b;
            sVar.a();
        }
    }

    @Override // g.b.k1
    public final void M() {
        V();
    }

    public void T(@Nullable Object obj) {
        o(obj);
    }

    public final void U() {
        E((f1) this.f6171c.get(f1.N));
    }

    public void V() {
    }

    @Override // f.z.d
    @NotNull
    public final f.z.f getContext() {
        return this.f6170b;
    }

    @Override // g.b.a0
    @NotNull
    public f.z.f getCoroutineContext() {
        return this.f6170b;
    }

    @Override // g.b.k1, g.b.f1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // g.b.k1
    @NotNull
    public String r() {
        return getClass().getSimpleName() + " was cancelled";
    }

    @Override // f.z.d
    public final void resumeWith(@NotNull Object obj) {
        Object objH = H(c.b.a.m.f.N5(obj, null));
        if (objH == l1.f6272b) {
            return;
        }
        T(objH);
    }
}
