package k.b.a.b.c;

import java.io.Writer;

/* JADX INFO: compiled from: CodePointTranslator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends b {
    @Override // k.b.a.b.c.b
    public final int a(CharSequence charSequence, int i2, Writer writer) {
        return c(Character.codePointAt(charSequence, i2), writer) ? 1 : 0;
    }

    public abstract boolean c(int i2, Writer writer);
}
