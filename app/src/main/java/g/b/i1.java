package g.b;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public class i1 extends k1 implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6258b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(@Nullable f1 f1Var) {
        k1 k1VarL;
        super(true);
        boolean z = true;
        E(f1Var);
        l lVarA = A();
        m mVar = (m) (lVarA instanceof m ? lVarA : null);
        if (mVar == null || (k1VarL = mVar.l()) == null) {
            z = false;
            break;
        }
        while (!k1VarL.x()) {
            l lVarA2 = k1VarL.A();
            m mVar2 = (m) (lVarA2 instanceof m ? lVarA2 : null);
            if (mVar2 == null || (k1VarL = mVar2.l()) == null) {
                z = false;
                break;
            }
        }
        this.f6258b = z;
    }

    @Override // g.b.k1
    public boolean x() {
        return this.f6258b;
    }

    @Override // g.b.k1
    public boolean y() {
        return true;
    }
}
