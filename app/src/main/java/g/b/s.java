package g.b;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public class s {
    public static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(s.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Throwable f6298b;

    public s(@NotNull Throwable th, boolean z) {
        this.f6298b = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '[' + this.f6298b + ']';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public s(Throwable th, boolean z, int i2) {
        ?? r2 = (i2 & 2) != 0 ? 0 : z;
        this.f6298b = th;
        this._handled = r2;
    }
}
