package g.b;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6259c = AtomicIntegerFieldUpdater.newUpdater(j.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    public j(@NotNull f.z.d<?> dVar, @Nullable Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + dVar + " was cancelled normally");
        }
        super(th, z);
        this._resumed = 0;
    }
}
