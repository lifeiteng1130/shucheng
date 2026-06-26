package g.b;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z1 extends CancellationException {

    @JvmField
    @Nullable
    public final f1 coroutine;

    public z1(@NotNull String str, @Nullable f1 f1Var) {
        super(str);
        this.coroutine = f1Var;
    }

    public z1(@NotNull String str) {
        this(str, null);
    }

    @Nullable
    /* JADX INFO: renamed from: createCopy, reason: merged with bridge method [inline-methods] */
    public z1 m21createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        z1 z1Var = new z1(message, this.coroutine);
        z1Var.initCause(this);
        return z1Var;
    }
}
