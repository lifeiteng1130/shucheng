package i.a.b.l;

import java.io.IOException;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements n<Double> {
    public c(l lVar) {
    }

    @Override // i.a.b.l.n
    public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
        Double d2 = (Double) obj;
        if (d2.isInfinite()) {
            appendable.append("null");
        } else {
            appendable.append(d2.toString());
        }
    }
}
