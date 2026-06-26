package k.b.a.a.i.a;

import java.io.Writer;

/* JADX INFO: compiled from: UnicodeUnpairedSurrogateRemover.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class k extends c {
    @Override // k.b.a.a.i.a.c
    public boolean c(int i2, Writer writer) {
        return i2 >= 55296 && i2 <= 57343;
    }
}
