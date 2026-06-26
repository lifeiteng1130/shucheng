package g.b.h2;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Runnable f6244c;

    public k(@NotNull Runnable runnable, long j2, @NotNull j jVar) {
        super(j2, jVar);
        this.f6244c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f6244c.run();
        } finally {
            this.f6243b.b();
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("Task[");
        sbR.append(c.b.a.m.f.W1(this.f6244c));
        sbR.append('@');
        sbR.append(c.b.a.m.f.v2(this.f6244c));
        sbR.append(", ");
        sbR.append(this.a);
        sbR.append(", ");
        sbR.append(this.f6243b);
        sbR.append(']');
        return sbR.toString();
    }
}
