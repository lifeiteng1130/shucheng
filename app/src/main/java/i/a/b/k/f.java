package i.a.b.k;

/* JADX INFO: compiled from: JSONParserString.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends c {
    public String x;

    public f(int i2) {
        super(i2);
    }

    @Override // i.a.b.k.b
    public void e() {
        int i2 = this.f6378k + 1;
        this.f6378k = i2;
        if (i2 >= this.w) {
            this.f6373f = (char) 26;
        } else {
            this.f6373f = this.x.charAt(i2);
        }
    }

    @Override // i.a.b.k.b
    public void j() throws g {
        int i2 = this.f6378k + 1;
        this.f6378k = i2;
        if (i2 < this.w) {
            this.f6373f = this.x.charAt(i2);
        } else {
            this.f6373f = (char) 26;
            throw new g(this.f6378k - 1, 3, "EOF");
        }
    }

    @Override // i.a.b.k.b
    public void m() {
        int i2 = this.f6378k + 1;
        this.f6378k = i2;
        if (i2 >= this.w) {
            this.f6373f = (char) 26;
        } else {
            this.f6373f = this.x.charAt(i2);
        }
    }

    @Override // i.a.b.k.c
    public void t(int i2, int i3) {
        while (i2 < i3 - 1 && Character.isWhitespace(this.x.charAt(i2))) {
            i2++;
        }
        while (true) {
            int i4 = i3 - 1;
            if (i4 <= i2 || !Character.isWhitespace(this.x.charAt(i4))) {
                break;
            } else {
                i3 = i4;
            }
        }
        this.f6377j = this.x.substring(i2, i3);
    }
}
