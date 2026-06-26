package k.b.a.a.i.a;

import java.io.Writer;

/* JADX INFO: compiled from: AggregateTranslator.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b[] f8549b;

    public a(b... bVarArr) {
        this.f8549b = (b[]) ((Object[]) bVarArr.clone());
    }

    @Override // k.b.a.a.i.a.b
    public int a(CharSequence charSequence, int i2, Writer writer) {
        for (b bVar : this.f8549b) {
            int iA = bVar.a(charSequence, i2, writer);
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }
}
