package g.b.h2;

import g.b.g2.r;
import g.b.y;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final y f6232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final b f6233g;

    static {
        b bVar = new b();
        f6233g = bVar;
        int i2 = r.a;
        f6232f = new e(bVar, c.b.a.m.f.z5("kotlinx.coroutines.io.parallelism", 64 < i2 ? i2 : 64, 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    public b() {
        super(0, 0, null, 7);
    }

    @Override // g.b.v0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // g.b.y
    @NotNull
    public String toString() {
        return "Dispatchers.Default";
    }
}
