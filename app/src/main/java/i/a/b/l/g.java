package i.a.b.l;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements n<short[]> {
    public g(l lVar) {
    }

    @Override // i.a.b.l.n
    public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
        Objects.requireNonNull(gVar);
        appendable.append('[');
        boolean z = false;
        for (short s : (short[]) obj) {
            if (z) {
                appendable.append(',');
            } else {
                z = true;
            }
            appendable.append(Short.toString(s));
        }
        appendable.append(']');
    }
}
