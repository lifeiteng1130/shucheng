package g.b;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0<T> extends g.b.h2.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public int f6260c;

    public j0(int i2) {
        this.f6260c = i2;
    }

    public void c(@Nullable Object obj, @NotNull Throwable th) {
    }

    @NotNull
    public abstract f.z.d<T> d();

    @Nullable
    public Throwable e(@Nullable Object obj) {
        if (!(obj instanceof s)) {
            obj = null;
        }
        s sVar = (s) obj;
        if (sVar != null) {
            return sVar.f6298b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(@Nullable Object obj) {
        return obj;
    }

    public final void i(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            c.b.a.m.f.V(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        f.c0.c.j.c(th);
        c.b.a.m.f.f3(d().getContext(), new c0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Nullable
    public abstract Object j();

    /* JADX WARN: Removed duplicated region for block: B:27:0x007f A[Catch: all -> 0x00b0, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {all -> 0x00b0, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x001b, B:25:0x0079, B:27:0x007f, B:35:0x009e, B:38:0x00a7, B:37:0x00a4, B:39:0x00a8, B:40:0x00af, B:10:0x0021, B:12:0x002f, B:14:0x0037, B:17:0x0043, B:19:0x0049, B:23:0x0075, B:21:0x005e, B:22:0x006a), top: B:48:0x0002, inners: #3 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.j0.run():void");
    }
}
