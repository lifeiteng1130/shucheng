package androidx.view;

import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.z.f;
import g.b.a0;
import java.io.Closeable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Lg/b/a0;", "Lf/v;", "close", "()V", "Lf/z/f;", "coroutineContext", "Lf/z/f;", "getCoroutineContext", "()Lf/z/f;", c.R, "<init>", "(Lf/z/f;)V", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class CloseableCoroutineScope implements Closeable, a0 {

    @NotNull
    private final f coroutineContext;

    public CloseableCoroutineScope(@NotNull f fVar) {
        j.e(fVar, c.R);
        this.coroutineContext = fVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c.b.a.m.f.H0(getCoroutineContext(), null, 1, null);
    }

    @Override // g.b.a0
    @NotNull
    public f getCoroutineContext() {
        return this.coroutineContext;
    }
}
