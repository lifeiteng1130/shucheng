package androidx.core.os;

import f.c0.b.a;
import kotlin.Metadata;

/* JADX INFO: compiled from: Handler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lf/v;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    public final /* synthetic */ a $action;

    public HandlerKt$postAtTime$runnable$1(a aVar) {
        this.$action = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
