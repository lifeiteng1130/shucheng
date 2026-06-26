package i.a.b.k;

import i.a.b.k.b;

/* JADX INFO: compiled from: JSONParserStream.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends b {
    public e(int i2) {
        super(i2);
    }

    @Override // i.a.b.k.b
    public void i(boolean[] zArr) {
        this.f6375h.f6380b = -1;
        r(zArr);
        this.f6377j = this.f6375h.toString().trim();
    }

    @Override // i.a.b.k.b
    public Object k(boolean[] zArr) throws g {
        b.a aVar = this.f6375h;
        aVar.f6380b = -1;
        aVar.a(this.f6373f);
        e();
        q();
        char c2 = this.f6373f;
        if (c2 != '.' && c2 != 'E' && c2 != 'e') {
            s();
            char c3 = this.f6373f;
            if (c3 < 0 || c3 >= '~' || zArr[c3] || c3 == 26) {
                String strTrim = this.f6375h.toString().trim();
                this.f6377j = strTrim;
                return d(strTrim);
            }
            r(zArr);
            String strTrim2 = this.f6375h.toString().trim();
            this.f6377j = strTrim2;
            if (this.n) {
                return strTrim2;
            }
            throw new g(this.f6378k, 1, this.f6377j);
        }
        if (c2 == '.') {
            this.f6375h.a(c2);
            e();
            q();
        }
        char c4 = this.f6373f;
        if (c4 != 'E' && c4 != 'e') {
            s();
            char c5 = this.f6373f;
            if (c5 < 0 || c5 >= '~' || zArr[c5] || c5 == 26) {
                this.f6377j = this.f6375h.toString().trim();
                return b();
            }
            r(zArr);
            String strTrim3 = this.f6375h.toString().trim();
            this.f6377j = strTrim3;
            if (this.n) {
                return strTrim3;
            }
            throw new g(this.f6378k, 1, this.f6377j);
        }
        this.f6375h.a('E');
        e();
        char c6 = this.f6373f;
        if (c6 != '+' && c6 != '-' && (c6 < '0' || c6 > '9')) {
            r(zArr);
            this.f6377j = this.f6375h.toString().trim();
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
            this.f6377j = this.f6375h.toString().trim();
            return b();
        }
        r(zArr);
        String strTrim4 = this.f6375h.toString().trim();
        this.f6377j = strTrim4;
        if (this.n) {
            return strTrim4;
        }
        throw new g(this.f6378k, 1, this.f6377j);
    }

    @Override // i.a.b.k.b
    public void n() throws g {
        if (this.o || this.f6373f != '\'') {
            this.f6375h.f6380b = -1;
            o();
        } else {
            if (!this.n) {
                throw new g(this.f6378k, 0, Character.valueOf(this.f6373f));
            }
            i(b.a);
        }
    }
}
