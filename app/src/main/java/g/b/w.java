package g.b;

import f.z.e;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final boolean a;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r0.equals("on") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r0.equals("") != false) goto L19;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = c.b.a.m.f.y5(r0)
            if (r0 != 0) goto L9
            goto L33
        L9:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L22
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L37
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            r0 = 0
            goto L34
        L22:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            goto L33
        L2b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
        L33:
            r0 = 1
        L34:
            g.b.w.a = r0
            return
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.w.<clinit>():void");
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final f.z.f a(@NotNull a0 a0Var, @NotNull f.z.f fVar) {
        f.z.f fVarPlus = a0Var.getCoroutineContext().plus(fVar);
        y yVar = k0.a;
        if (fVarPlus == yVar) {
            return fVarPlus;
        }
        int i2 = f.z.e.L;
        return fVarPlus.get(e.a.a) == null ? fVarPlus.plus(yVar) : fVarPlus;
    }

    @Nullable
    public static final c2<?> b(@NotNull f.z.d<?> dVar, @NotNull f.z.f fVar, @Nullable Object obj) {
        c2<?> c2Var = null;
        if (!(dVar instanceof f.z.j.a.d)) {
            return null;
        }
        if (!(fVar.get(d2.a) != null)) {
            return null;
        }
        f.z.j.a.d callerFrame = (f.z.j.a.d) dVar;
        while (true) {
            if ((callerFrame instanceof i0) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                break;
            }
            if (callerFrame instanceof c2) {
                c2Var = (c2) callerFrame;
                break;
            }
        }
        if (c2Var != null) {
            c2Var.f6175e = fVar;
            c2Var.f6176f = obj;
        }
        return c2Var;
    }
}
