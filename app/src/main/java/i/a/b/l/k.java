package i.a.b.l;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class k implements n<boolean[]> {
    public k(l lVar) {
    }

    @Override // i.a.b.l.n
    public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
        Objects.requireNonNull(gVar);
        appendable.append('[');
        boolean z = false;
        for (boolean z2 : (boolean[]) obj) {
            if (z) {
                appendable.append(',');
            } else {
                z = true;
            }
            appendable.append(Boolean.toString(z2));
        }
        appendable.append(']');
    }
}
