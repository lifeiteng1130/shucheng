package g.b.h2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6249b = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6250c = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6251d = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceArray<i> f6252e = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    @Nullable
    public final i a(@NotNull i iVar, boolean z) {
        if (z) {
            return b(iVar);
        }
        i iVar2 = (i) a.getAndSet(this, iVar);
        if (iVar2 != null) {
            return b(iVar2);
        }
        return null;
    }

    public final i b(i iVar) {
        if (iVar.f6243b.g() == 1) {
            f6251d.incrementAndGet(this);
        }
        if (c() == 127) {
            return iVar;
        }
        int i2 = this.producerIndex & 127;
        while (this.f6252e.get(i2) != null) {
            Thread.yield();
        }
        this.f6252e.lazySet(i2, iVar);
        f6249b.incrementAndGet(this);
        return null;
    }

    public final int c() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int d() {
        return this.lastScheduledTask != null ? c() + 1 : c();
    }

    @Nullable
    public final i e() {
        i iVar = (i) a.getAndSet(this, null);
        return iVar != null ? iVar : f();
    }

    public final i f() {
        i andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f6250c.compareAndSet(this, i2, i2 + 1) && (andSet = this.f6252e.getAndSet(i3, null)) != null) {
                if (andSet.f6243b.g() == 1) {
                    f6251d.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        return h(r9, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long g(@org.jetbrains.annotations.NotNull g.b.h2.m r9) {
        /*
            r8 = this;
            int r0 = r9.consumerIndex
            int r1 = r9.producerIndex
            java.util.concurrent.atomic.AtomicReferenceArray<g.b.h2.i> r2 = r9.f6252e
        L6:
            r3 = 1
            if (r0 == r1) goto L3a
            r4 = r0 & 127(0x7f, float:1.78E-43)
            int r5 = r9.blockingTasksInBuffer
            if (r5 != 0) goto L10
            goto L3a
        L10:
            java.lang.Object r5 = r2.get(r4)
            g.b.h2.i r5 = (g.b.h2.i) r5
            if (r5 == 0) goto L37
            g.b.h2.j r6 = r5.f6243b
            int r6 = r6.g()
            r7 = 0
            if (r6 != r3) goto L22
            goto L23
        L22:
            r3 = 0
        L23:
            if (r3 == 0) goto L37
            r3 = 0
            boolean r3 = r2.compareAndSet(r4, r5, r3)
            if (r3 == 0) goto L37
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = g.b.h2.m.f6251d
            r0.decrementAndGet(r9)
            r8.a(r5, r7)
            r0 = -1
            return r0
        L37:
            int r0 = r0 + 1
            goto L6
        L3a:
            long r0 = r8.h(r9, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.h2.m.g(g.b.h2.m):long");
    }

    public final long h(m mVar, boolean z) {
        i iVar;
        do {
            iVar = (i) mVar.lastScheduledTask;
            if (iVar == null) {
                return -2L;
            }
            if (z) {
                if (!(iVar.f6243b.g() == 1)) {
                    return -2L;
                }
            }
            long jA = l.f6248e.a() - iVar.a;
            long j2 = l.a;
            if (jA < j2) {
                return j2 - jA;
            }
        } while (!a.compareAndSet(mVar, iVar, null));
        a(iVar, false);
        return -1L;
    }
}
