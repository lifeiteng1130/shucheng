package k.a.a.a.l0;

import com.umeng.analytics.pro.ai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import k.a.a.a.h0;
import k.a.a.a.i0;

/* JADX INFO: compiled from: DFASerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f8486b;

    public c(b bVar, h0 h0Var) {
        this.a = bVar;
        this.f8486b = h0Var;
    }

    public String a(d dVar) {
        int i2 = dVar.a;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f8489d ? ":" : "");
        sb.append(ai.az);
        sb.append(i2);
        sb.append(dVar.f8492g ? "^" : "");
        String string = sb.toString();
        if (!dVar.f8489d) {
            return string;
        }
        if (dVar.f8493h != null) {
            StringBuilder sbT = c.a.a.a.a.t(string, "=>");
            sbT.append(Arrays.toString(dVar.f8493h));
            return sbT.toString();
        }
        StringBuilder sbT2 = c.a.a.a.a.t(string, "=>");
        sbT2.append(dVar.f8490e);
        return sbT2.toString();
    }

    public String toString() {
        if (this.a.f8482b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b bVar = this.a;
        Objects.requireNonNull(bVar);
        ArrayList<d> arrayList = new ArrayList(bVar.a.keySet());
        Collections.sort(arrayList, new a(bVar));
        for (d dVar : arrayList) {
            d[] dVarArr = dVar.f8488c;
            int length = dVarArr != null ? dVarArr.length : 0;
            for (int i2 = 0; i2 < length; i2++) {
                d dVar2 = dVar.f8488c[i2];
                if (dVar2 != null && dVar2.a != Integer.MAX_VALUE) {
                    sb.append(a(dVar));
                    String strA = ((i0) this.f8486b).a(i2 - 1);
                    sb.append("-");
                    sb.append(strA);
                    sb.append("->");
                    sb.append(a(dVar2));
                    sb.append('\n');
                }
            }
        }
        String string = sb.toString();
        if (string.length() == 0) {
            return null;
        }
        return string;
    }
}
