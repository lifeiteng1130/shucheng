package i.a.b;

import i.a.b.j;
import java.io.IOException;

/* JADX INFO: compiled from: JSONStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static final g a = new g(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f6352b = new g(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j.f f6357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j.f f6358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j.g f6359i;

    public g(int i2) {
        boolean z = (i2 & 1) == 0;
        this.f6353c = z;
        boolean z2 = (i2 & 4) == 0;
        this.f6355e = z2;
        boolean z3 = (i2 & 2) == 0;
        this.f6354d = z3;
        this.f6356f = (i2 & 16) > 0;
        j.f fVar = (i2 & 8) > 0 ? j.f6363c : j.a;
        if (z2) {
            this.f6358h = j.f6362b;
        } else {
            this.f6358h = fVar;
        }
        if (z) {
            this.f6357g = j.f6362b;
        } else {
            this.f6357g = fVar;
        }
        if (z3) {
            this.f6359i = j.f6365e;
        } else {
            this.f6359i = j.f6364d;
        }
    }

    public void a(Appendable appendable, String str) throws IOException {
        if (!this.f6358h.a(str)) {
            appendable.append(str);
            return;
        }
        appendable.append('\"');
        i.a(str, appendable, this);
        appendable.append('\"');
    }
}
