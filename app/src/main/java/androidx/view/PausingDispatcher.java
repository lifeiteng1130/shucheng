package androidx.view;

import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.z.f;
import g.b.g2.m;
import g.b.k0;
import g.b.y;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PausingDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/PausingDispatcher;", "Lg/b/y;", "Lf/z/f;", c.R, "", "isDispatchNeeded", "(Lf/z/f;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lf/v;", "dispatch", "(Lf/z/f;Ljava/lang/Runnable;)V", "Landroidx/lifecycle/DispatchQueue;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "<init>", "()V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class PausingDispatcher extends y {

    @JvmField
    @NotNull
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // g.b.y
    public void dispatch(@NotNull f context, @NotNull Runnable block) {
        j.e(context, c.R);
        j.e(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // g.b.y
    public boolean isDispatchNeeded(@NotNull f context) {
        j.e(context, c.R);
        y yVar = k0.a;
        if (m.f6207b.n().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
