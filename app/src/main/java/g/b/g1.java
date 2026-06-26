package g.b;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g1 extends CancellationException {

    @JvmField
    @NotNull
    public final f1 job;

    public g1(@NotNull String str, @Nullable Throwable th, @NotNull f1 f1Var) {
        super(str);
        this.job = f1Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: createCopy, reason: merged with bridge method [inline-methods] */
    public g1 m20createCopy() {
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (obj instanceof g1) {
                g1 g1Var = (g1) obj;
                if (!f.c0.c.j.a(g1Var.getMessage(), getMessage()) || !f.c0.c.j.a(g1Var.job, this.job) || !f.c0.c.j.a(g1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    @NotNull
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        f.c0.c.j.c(message);
        int iHashCode = (this.job.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }
}
