package i.a.b.l;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ArrayWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements n<Object> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.a.b.l.n
    public <E> void a(E e2, Appendable appendable, i.a.b.g gVar) throws IOException {
        Objects.requireNonNull(gVar);
        appendable.append('[');
        boolean z = false;
        for (Object obj : (Object[]) e2) {
            if (z) {
                appendable.append(',');
            } else {
                z = true;
            }
            i.a.b.i.b(obj, appendable, gVar);
        }
        appendable.append(']');
    }
}
