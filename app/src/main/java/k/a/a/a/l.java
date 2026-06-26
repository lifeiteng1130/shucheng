package k.a.a.a;

/* JADX INFO: compiled from: CommonTokenStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends f {
    public l(f0 f0Var) {
        super(f0Var);
    }

    @Override // k.a.a.a.f, k.a.a.a.g0
    public d0 c(int i2) {
        k();
        if (i2 == 0) {
            return null;
        }
        if (i2 < 0) {
            return n(-i2);
        }
        int iL = this.f8357c;
        for (int i3 = 1; i3 < i2; i3++) {
            int i4 = iL + 1;
            if (m(i4)) {
                iL = l(i4, 0);
            }
        }
        return this.f8356b.get(iL);
    }

    @Override // k.a.a.a.f
    public int i(int i2) {
        return l(i2, 0);
    }

    public d0 n(int i2) {
        if (i2 != 0) {
            int size = this.f8357c;
            if (size - i2 >= 0) {
                for (int i3 = 1; i3 <= i2 && size > 0; i3++) {
                    size--;
                    m(size);
                    if (size >= size()) {
                        size = size() - 1;
                    } else {
                        while (size >= 0) {
                            d0 d0Var = this.f8356b.get(size);
                            if (d0Var.getType() == -1 || d0Var.getChannel() == 0) {
                                break;
                            }
                            size--;
                        }
                    }
                }
                if (size < 0) {
                    return null;
                }
                return this.f8356b.get(size);
            }
        }
        return null;
    }
}
