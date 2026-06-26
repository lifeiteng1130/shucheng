package g.b.h2;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements Runnable {

    @JvmField
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public j f6243b;

    public i(long j2, @NotNull j jVar) {
        this.a = j2;
        this.f6243b = jVar;
    }

    public i() {
        g gVar = g.a;
        this.a = 0L;
        this.f6243b = gVar;
    }
}
