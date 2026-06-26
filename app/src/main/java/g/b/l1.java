package g.b;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 {
    public static final g.b.g2.q a = new g.b.g2.q("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final g.b.g2.q f6272b = new g.b.g2.q("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g.b.g2.q f6273c = new g.b.g2.q("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.b.g2.q f6274d = new g.b.g2.q("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g.b.g2.q f6275e = new g.b.g2.q("SEALED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p0 f6276f = new p0(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p0 f6277g = new p0(true);

    @Nullable
    public static final Object a(@Nullable Object obj) {
        a1 a1Var;
        b1 b1Var = (b1) (!(obj instanceof b1) ? null : obj);
        return (b1Var == null || (a1Var = b1Var.a) == null) ? obj : a1Var;
    }
}
