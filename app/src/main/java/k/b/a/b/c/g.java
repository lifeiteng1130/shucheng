package k.b.a.b.c;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: NumericEntityEscaper.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k.b.a.a.d<Integer> f8631c;

    public g(int i2, int i3, boolean z) {
        this.f8631c = k.b.a.a.d.between(Integer.valueOf(i2), Integer.valueOf(i3));
        this.f8630b = z;
    }

    public static g d(int i2, int i3) {
        return new g(i2, i3, true);
    }

    @Override // k.b.a.b.c.c
    public boolean c(int i2, Writer writer) throws IOException {
        if (this.f8630b != this.f8631c.contains(Integer.valueOf(i2))) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i2, 10));
        writer.write(59);
        return true;
    }
}
