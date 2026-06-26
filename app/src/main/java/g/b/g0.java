package g.b;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g0<T> extends g.b.a<T> implements f0<T> {

    /* JADX INFO: compiled from: Builders.common.kt */
    @DebugMetadata(c = "kotlinx.coroutines.DeferredCoroutine", f = "Builders.common.kt", i = {}, l = {101}, m = "await$suspendImpl", n = {}, s = {})
    public static final class a extends f.z.j.a.c {
        public int label;
        public /* synthetic */ Object result;

        public a(f.z.d dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return g0.W(g0.this, this);
        }
    }

    public g0(@NotNull f.z.f fVar, boolean z) {
        super(fVar, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object W(g.b.g0 r5, f.z.d r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof g.b.g0.a
            if (r0 == 0) goto L13
            r0 = r6
            g.b.g0$a r0 = (g.b.g0.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            g.b.g0$a r0 = new g.b.g0$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            c.b.a.m.f.E5(r6)
            goto L7d
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            c.b.a.m.f.E5(r6)
            r0.label = r3
        L34:
            java.lang.Object r6 = r5.B()
            boolean r2 = r6 instanceof g.b.a1
            if (r2 != 0) goto L4b
            boolean r5 = r6 instanceof g.b.s
            if (r5 != 0) goto L46
            java.lang.Object r5 = g.b.l1.a(r6)
        L44:
            r6 = r5
            goto L7a
        L46:
            g.b.s r6 = (g.b.s) r6
            java.lang.Throwable r5 = r6.f6298b
            throw r5
        L4b:
            int r6 = r5.O(r6)
            if (r6 < 0) goto L34
            g.b.k1$a r6 = new g.b.k1$a
            f.z.d r2 = c.b.a.m.f.j3(r0)
            r6.<init>(r2, r5)
            g.b.t1 r2 = new g.b.t1
            r2.<init>(r6)
            r4 = 0
            g.b.m0 r5 = r5.c(r4, r3, r2)
            g.b.n0 r2 = new g.b.n0
            r2.<init>(r5)
            r6.a(r2)
            java.lang.Object r5 = r6.r()
            f.z.i.a r6 = f.z.i.a.COROUTINE_SUSPENDED
            if (r5 != r6) goto L44
            java.lang.String r6 = "frame"
            f.c0.c.j.e(r0, r6)
            goto L44
        L7a:
            if (r6 != r1) goto L7d
            return r1
        L7d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.g0.W(g.b.g0, f.z.d):java.lang.Object");
    }

    @Override // g.b.f0
    @Nullable
    public Object e(@NotNull f.z.d<? super T> dVar) {
        return W(this, dVar);
    }
}
