package k.b.a.b.c;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AggregateTranslator.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f8613b = new ArrayList();

    public a(b... bVarArr) {
        for (b bVar : bVarArr) {
            if (bVar != null) {
                this.f8613b.add(bVar);
            }
        }
    }

    @Override // k.b.a.b.c.b
    public int a(CharSequence charSequence, int i2, Writer writer) {
        Iterator<b> it = this.f8613b.iterator();
        while (it.hasNext()) {
            int iA = it.next().a(charSequence, i2, writer);
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }
}
