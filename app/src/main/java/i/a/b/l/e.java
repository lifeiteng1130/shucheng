package i.a.b.l;

import java.io.IOException;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements n<Float> {
    public e(l lVar) {
    }

    @Override // i.a.b.l.n
    public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
        Float f2 = (Float) obj;
        if (f2.isInfinite()) {
            appendable.append("null");
        } else {
            appendable.append(f2.toString());
        }
    }
}
