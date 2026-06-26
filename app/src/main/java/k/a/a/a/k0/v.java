package k.a.a.a.k0;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: DecisionInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class v {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f8467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f8469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<t> f8470j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<z> f8471k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<m> f8472l = new ArrayList();
    public final List<x0> m = new ArrayList();
    public long n;
    public long o;
    public long p;
    public long q;

    public v(int i2) {
        this.a = i2;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("{decision=");
        sbR.append(this.a);
        sbR.append(", contextSensitivities=");
        sbR.append(this.f8470j.size());
        sbR.append(", errors=");
        sbR.append(this.f8471k.size());
        sbR.append(", ambiguities=");
        sbR.append(this.f8472l.size());
        sbR.append(", SLL_lookahead=");
        sbR.append(this.f8464d);
        sbR.append(", SLL_ATNTransitions=");
        sbR.append(this.n);
        sbR.append(", SLL_DFATransitions=");
        sbR.append(this.o);
        sbR.append(", LL_Fallback=");
        sbR.append(this.p);
        sbR.append(", LL_lookahead=");
        sbR.append(this.f8467g);
        sbR.append(", LL_ATNTransitions=");
        sbR.append(this.q);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
