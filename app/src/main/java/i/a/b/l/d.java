package i.a.b.l;

import java.io.IOException;
import java.util.Date;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements n<Date> {
    public d(l lVar) {
    }

    @Override // i.a.b.l.n
    public void a(Object obj, Appendable appendable, i.a.b.g gVar) throws IOException {
        appendable.append('\"');
        i.a.b.i.a(((Date) obj).toString(), appendable, gVar);
        appendable.append('\"');
    }
}
