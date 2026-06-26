package g.b;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a2<U, T extends U> extends g.b.g2.p<T> implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public final long f6172e;

    public a2(long j2, @NotNull f.z.d<? super U> dVar) {
        super(dVar.getContext(), dVar);
        this.f6172e = j2;
    }

    @Override // g.b.a, g.b.k1
    @NotNull
    public String I() {
        return super.I() + "(timeMillis=" + this.f6172e + ')';
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        p(new z1("Timed out waiting for " + this.f6172e + " ms", this));
    }
}
