package k.b.a.a.i.a;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: NumericEntityEscaper.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class g extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8567c;

    public g(int i2, int i3, boolean z) {
        this.f8566b = i2;
        this.f8567c = i3;
    }

    public static g d(int i2, int i3) {
        return new g(i2, i3, true);
    }

    @Override // k.b.a.a.i.a.c
    public boolean c(int i2, Writer writer) throws IOException {
        if (i2 < this.f8566b || i2 > this.f8567c) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i2, 10));
        writer.write(59);
        return true;
    }
}
