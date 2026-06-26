package c.c.a.n;

import com.bytedance.pangle.ZeusConstants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ThreadFactory {
    public AtomicInteger a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, ZeusConstants.BASE_LIB_NAME + "-Install-" + this.a.getAndIncrement());
    }
}
