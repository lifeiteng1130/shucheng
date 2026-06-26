package k.a.a.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: BufferedTokenStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements g0 {
    public f0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<d0> f8356b = new ArrayList(100);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8357c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8358d;

    public f(f0 f0Var) {
        Objects.requireNonNull(f0Var, "tokenSource cannot be null");
        this.a = f0Var;
    }

    @Override // k.a.a.a.q
    public void a(int i2) {
        k();
        this.f8357c = i(i2);
    }

    @Override // k.a.a.a.q
    public int b(int i2) {
        return c(i2).getType();
    }

    @Override // k.a.a.a.g0
    public d0 c(int i2) {
        throw null;
    }

    @Override // k.a.a.a.q
    public int d() {
        return 0;
    }

    @Override // k.a.a.a.g0
    public String e(d0 d0Var, d0 d0Var2) {
        if (d0Var == null || d0Var2 == null) {
            return "";
        }
        k.a.a.a.m0.h hVarC = k.a.a.a.m0.h.c(d0Var.getTokenIndex(), d0Var2.getTokenIndex());
        int i2 = hVarC.f8511c;
        int size = hVarC.f8512d;
        if (i2 < 0 || size < 0) {
            return "";
        }
        k();
        while (j(1000) >= 1000) {
        }
        if (size >= this.f8356b.size()) {
            size = this.f8356b.size() - 1;
        }
        StringBuilder sb = new StringBuilder();
        while (i2 <= size) {
            d0 d0Var3 = this.f8356b.get(i2);
            if (d0Var3.getType() == -1) {
                break;
            }
            sb.append(d0Var3.getText());
            i2++;
        }
        return sb.toString();
    }

    @Override // k.a.a.a.q
    public void g() {
        int i2 = this.f8357c;
        boolean z = false;
        if (i2 >= 0 && (!this.f8358d ? i2 < this.f8356b.size() : i2 < this.f8356b.size() - 1)) {
            z = true;
        }
        if (!z && b(1) == -1) {
            throw new IllegalStateException("cannot consume EOF");
        }
        if (m(this.f8357c + 1)) {
            this.f8357c = i(this.f8357c + 1);
        }
    }

    @Override // k.a.a.a.g0
    public d0 get(int i2) {
        if (i2 >= 0 && i2 < this.f8356b.size()) {
            return this.f8356b.get(i2);
        }
        StringBuilder sbS = c.a.a.a.a.s("token index ", i2, " out of range 0..");
        sbS.append(this.f8356b.size() - 1);
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    @Override // k.a.a.a.q
    public String getSourceName() {
        return this.a.getSourceName();
    }

    @Override // k.a.a.a.g0
    public f0 getTokenSource() {
        return this.a;
    }

    @Override // k.a.a.a.q
    public void h(int i2) {
    }

    public int i(int i2) {
        throw null;
    }

    @Override // k.a.a.a.q
    public int index() {
        return this.f8357c;
    }

    public int j(int i2) {
        if (this.f8358d) {
            return 0;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            d0 d0VarNextToken = this.a.nextToken();
            if (d0VarNextToken instanceof j0) {
                ((j0) d0VarNextToken).setTokenIndex(this.f8356b.size());
            }
            this.f8356b.add(d0VarNextToken);
            if (d0VarNextToken.getType() == -1) {
                this.f8358d = true;
                return i3 + 1;
            }
        }
        return i2;
    }

    public final void k() {
        if (this.f8357c == -1) {
            m(0);
            this.f8357c = i(0);
        }
    }

    public int l(int i2, int i3) {
        m(i2);
        if (i2 >= size()) {
            return size() - 1;
        }
        d0 d0Var = this.f8356b.get(i2);
        while (true) {
            d0 d0Var2 = d0Var;
            if (d0Var2.getChannel() == i3 || d0Var2.getType() == -1) {
                return i2;
            }
            i2++;
            m(i2);
            d0Var = this.f8356b.get(i2);
        }
    }

    public boolean m(int i2) {
        int size = (i2 - this.f8356b.size()) + 1;
        return size <= 0 || j(size) >= size;
    }

    @Override // k.a.a.a.q
    public int size() {
        return this.f8356b.size();
    }
}
