package g.b;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EventLoop.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends r0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final Thread f6177g;

    public d(@NotNull Thread thread) {
        this.f6177g = thread;
    }

    @Override // g.b.s0
    @NotNull
    public Thread u() {
        return this.f6177g;
    }
}
