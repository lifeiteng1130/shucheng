package i.a.b;

import i.a.b.l.l;
import i.a.b.l.n;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: JSONValue.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static g a = g.a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f6360b = new l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i.a.b.m.j f6361c = new i.a.b.m.j();

    public static void a(String str, Appendable appendable, g gVar) {
        if (str == null) {
            return;
        }
        gVar.f6359i.a(str, appendable);
    }

    public static void b(Object obj, Appendable appendable, g gVar) throws IOException {
        n<?> nVar;
        if (obj == null) {
            appendable.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        l lVar = f6360b;
        n<?> nVar2 = (n) lVar.f6390k.get(cls);
        if (nVar2 == null) {
            if (cls.isArray()) {
                nVar = l.f6388i;
            } else {
                Class<?> cls2 = obj.getClass();
                Iterator<l.i> it = lVar.f6391l.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        nVar = null;
                        break;
                    }
                    l.i next = it.next();
                    if (next.a.isAssignableFrom(cls2)) {
                        nVar = next.f6392b;
                        break;
                    }
                }
                if (nVar == null) {
                    nVar = l.f6387h;
                }
            }
            nVar2 = nVar;
            f6360b.a(nVar2, cls);
        }
        nVar2.a(obj, appendable, gVar);
    }
}
