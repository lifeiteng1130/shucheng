package g.b.g2;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
@InternalCoroutinesApi
public class j {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6196b = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6197c = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_removedRef");
    public volatile /* synthetic */ Object _next = this;
    public volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @PublishedApi
    public static abstract class a extends c<j> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        @Nullable
        public j f6198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        @NotNull
        public final j f6199c;

        public a(@NotNull j jVar) {
            this.f6199c = jVar;
        }

        @Override // g.b.g2.c
        public void b(j jVar, Object obj) {
            j jVar2 = jVar;
            boolean z = obj == null;
            j jVar3 = z ? this.f6199c : this.f6198b;
            if (jVar3 != null && j.a.compareAndSet(jVar2, this, jVar3) && z) {
                j jVar4 = this.f6199c;
                j jVar5 = this.f6198b;
                f.c0.c.j.c(jVar5);
                jVar4.d(jVar5);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        if (g.b.g2.j.a.compareAndSet(r2, r1, ((g.b.g2.o) r3).a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g.b.g2.j c(g.b.g2.n r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r7 = r6._prev
            g.b.g2.j r7 = (g.b.g2.j) r7
            r0 = 0
            r1 = r7
        L6:
            r2 = r0
        L7:
            java.lang.Object r3 = r1._next
            if (r3 != r6) goto L18
            if (r7 != r1) goto Le
            return r1
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = g.b.g2.j.f6196b
            boolean r7 = r0.compareAndSet(r6, r7, r1)
            if (r7 != 0) goto L17
            goto L0
        L17:
            return r1
        L18:
            boolean r4 = r6.i()
            if (r4 == 0) goto L1f
            return r0
        L1f:
            if (r3 != 0) goto L22
            return r1
        L22:
            boolean r4 = r3 instanceof g.b.g2.n
            if (r4 == 0) goto L2c
            g.b.g2.n r3 = (g.b.g2.n) r3
            r3.a(r1)
            goto L0
        L2c:
            boolean r4 = r3 instanceof g.b.g2.o
            if (r4 == 0) goto L46
            if (r2 == 0) goto L41
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = g.b.g2.j.a
            g.b.g2.o r3 = (g.b.g2.o) r3
            g.b.g2.j r3 = r3.a
            boolean r1 = r4.compareAndSet(r2, r1, r3)
            if (r1 != 0) goto L3f
            goto L0
        L3f:
            r1 = r2
            goto L6
        L41:
            java.lang.Object r1 = r1._prev
            g.b.g2.j r1 = (g.b.g2.j) r1
            goto L7
        L46:
        */
        //  java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            java.util.Objects.requireNonNull(r3, r2)
            r2 = r3
            g.b.g2.j r2 = (g.b.g2.j) r2
            r5 = r2
            r2 = r1
            r1 = r5
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.g2.j.c(g.b.g2.n):g.b.g2.j");
    }

    public final void d(j jVar) {
        j jVar2;
        do {
            jVar2 = (j) jVar._prev;
            if (f() != jVar) {
                return;
            }
        } while (!f6196b.compareAndSet(jVar, jVar2, this));
        if (i()) {
            jVar.c(null);
        }
    }

    @NotNull
    public final Object f() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof n)) {
                return obj;
            }
            ((n) obj).a(this);
        }
    }

    @NotNull
    public final j g() {
        j jVar;
        Object objF = f();
        o oVar = (o) (!(objF instanceof o) ? null : objF);
        if (oVar != null && (jVar = oVar.a) != null) {
            return jVar;
        }
        Objects.requireNonNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        return (j) objF;
    }

    @NotNull
    public final j h() {
        j jVarC = c(null);
        if (jVarC == null) {
            Object obj = this._prev;
            while (true) {
                jVarC = (j) obj;
                if (!jVarC.i()) {
                    break;
                }
                obj = jVarC._prev;
            }
        }
        return jVarC;
    }

    public boolean i() {
        return f() instanceof o;
    }

    public boolean j() {
        j jVar;
        while (true) {
            Object objF = f();
            if (objF instanceof o) {
                jVar = ((o) objF).a;
                break;
            }
            if (objF == this) {
                jVar = (j) objF;
                break;
            }
            Objects.requireNonNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            j jVar2 = (j) objF;
            o oVar = (o) jVar2._removedRef;
            if (oVar == null) {
                oVar = new o(jVar2);
                f6197c.lazySet(jVar2, oVar);
            }
            if (a.compareAndSet(this, objF, oVar)) {
                jVar = null;
                jVar2.c(null);
                break;
            }
        }
        return jVar == null;
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
