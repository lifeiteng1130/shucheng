package i.a.b.l;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements n<double[]> {
    public j(l lVar) {
    }

    @Override // i.a.b.l.n
    public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
        Objects.requireNonNull(gVar);
        appendable.append('[');
        boolean z = false;
        for (double d2 : (double[]) obj) {
            if (z) {
                appendable.append(',');
            } else {
                z = true;
            }
            appendable.append(Double.toString(d2));
        }
        appendable.append(']');
    }
}
