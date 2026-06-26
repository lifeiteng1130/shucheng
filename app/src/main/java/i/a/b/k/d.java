package i.a.b.k;

import java.io.IOException;
import java.io.Reader;

/* JADX INFO: compiled from: JSONParserReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends e {
    public Reader w;

    public d(int i2) {
        super(i2);
    }

    @Override // i.a.b.k.b
    public void e() throws IOException {
        int i2 = this.w.read();
        this.f6373f = i2 == -1 ? (char) 26 : (char) i2;
        this.f6378k++;
    }

    @Override // i.a.b.k.b
    public void j() throws g, IOException {
        int i2 = this.w.read();
        if (i2 == -1) {
            throw new g(this.f6378k - 1, 3, "EOF");
        }
        this.f6373f = (char) i2;
    }

    @Override // i.a.b.k.b
    public void m() throws IOException {
        this.f6375h.a(this.f6373f);
        int i2 = this.w.read();
        if (i2 == -1) {
            this.f6373f = (char) 26;
        } else {
            this.f6373f = (char) i2;
            this.f6378k++;
        }
    }
}
