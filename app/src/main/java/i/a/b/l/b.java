package i.a.b.l;

import java.io.IOException;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: BeansWriterASM.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements n<Object> {
    @Override // i.a.b.l.n
    public <E> void a(E e2, Appendable appendable, i.a.b.g gVar) throws IOException {
        try {
            i.a.a.b bVarC = i.a.a.b.c(e2.getClass(), i.a.b.h.a);
            appendable.append(MessageFormatter.DELIM_START);
            boolean z = false;
            for (i.a.a.a aVar : bVarC.f6338c) {
                Object objB = bVarC.b(e2, aVar.f6333d);
                if (objB != null || !gVar.f6356f) {
                    if (z) {
                        appendable.append(',');
                    } else {
                        z = true;
                    }
                    i.a.b.d.writeJSONKV(aVar.f6336g, objB, appendable, gVar);
                }
            }
            appendable.append(MessageFormatter.DELIM_STOP);
        } catch (IOException e3) {
            throw e3;
        }
    }
}
