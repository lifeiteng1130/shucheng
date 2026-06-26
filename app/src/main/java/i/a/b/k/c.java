package i.a.b.k;

/* JADX INFO: compiled from: JSONParserMemory.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends b {
    public int w;

    public c(int i2) {
        super(i2);
    }

    @Override // i.a.b.k.b
    public void i(boolean[] zArr) {
        int i2 = this.f6378k;
        r(zArr);
        t(i2, this.f6378k);
    }

    @Override // i.a.b.k.b
    public Object k(boolean[] zArr) throws g {
        int i2 = this.f6378k;
        e();
        q();
        char c2 = this.f6373f;
        if (c2 != '.' && c2 != 'E' && c2 != 'e') {
            s();
            char c3 = this.f6373f;
            if (c3 < 0 || c3 >= '~' || zArr[c3] || c3 == 26) {
                t(i2, this.f6378k);
                return d(this.f6377j);
            }
            r(zArr);
            t(i2, this.f6378k);
            if (this.n) {
                return this.f6377j;
            }
            throw new g(this.f6378k, 1, this.f6377j);
        }
        if (c2 == '.') {
            e();
            q();
        }
        char c4 = this.f6373f;
        if (c4 != 'E' && c4 != 'e') {
            s();
            char c5 = this.f6373f;
            if (c5 < 0 || c5 >= '~' || zArr[c5] || c5 == 26) {
                t(i2, this.f6378k);
                return b();
            }
            r(zArr);
            t(i2, this.f6378k);
            if (this.n) {
                return this.f6377j;
            }
            throw new g(this.f6378k, 1, this.f6377j);
        }
        this.f6375h.a('E');
        e();
        char c6 = this.f6373f;
        if (c6 != '+' && c6 != '-' && (c6 < '0' || c6 > '9')) {
            r(zArr);
            t(i2, this.f6378k);
            if (!this.n) {
                throw new g(this.f6378k, 1, this.f6377j);
            }
            if (!this.f6379l) {
                a();
            }
            return this.f6377j;
        }
        this.f6375h.a(c6);
        e();
        q();
        s();
        char c7 = this.f6373f;
        if (c7 < 0 || c7 >= '~' || zArr[c7] || c7 == 26) {
            t(i2, this.f6378k);
            return b();
        }
        r(zArr);
        t(i2, this.f6378k);
        if (this.n) {
            return this.f6377j;
        }
        throw new g(this.f6378k, 1, this.f6377j);
    }

    @Override // i.a.b.k.b
    public void n() throws g {
        if (!this.o && this.f6373f == '\'') {
            if (!this.n) {
                throw new g(this.f6378k, 0, Character.valueOf(this.f6373f));
            }
            boolean[] zArr = b.a;
            int i2 = this.f6378k;
            r(zArr);
            t(i2, this.f6378k);
            return;
        }
        f fVar = (f) this;
        int iIndexOf = fVar.x.indexOf(this.f6373f, this.f6378k + 1);
        if (iIndexOf == -1) {
            throw new g(this.w, 3, null);
        }
        fVar.f6377j = fVar.x.substring(this.f6378k + 1, iIndexOf);
        if (this.f6377j.indexOf(92) != -1) {
            this.f6375h.f6380b = -1;
            o();
            return;
        }
        if (!this.s) {
            int length = this.f6377j.length();
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = this.f6377j.charAt(i3);
                if (cCharAt >= 0) {
                    if (cCharAt <= 31) {
                        throw new g(this.f6378k + i3, 0, Character.valueOf(cCharAt));
                    }
                    if (cCharAt == 127 && this.v) {
                        throw new g(this.f6378k + i3, 0, Character.valueOf(cCharAt));
                    }
                }
            }
        }
        this.f6378k = iIndexOf;
        e();
    }

    public abstract void t(int i2, int i3);
}
