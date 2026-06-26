package g.b;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Unconfined.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b2 extends y {

    @NotNull
    public static final b2 a = new b2();

    @Override // g.b.y
    public void dispatch(@NotNull f.z.f fVar, @NotNull Runnable runnable) {
        if (((e2) fVar.get(e2.a)) == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
    }

    @Override // g.b.y
    public boolean isDispatchNeeded(@NotNull f.z.f fVar) {
        return false;
    }

    @Override // g.b.y
    @NotNull
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
