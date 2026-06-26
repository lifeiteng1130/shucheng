package k.b.a.a.i.a;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: LookupTranslator.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class f extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f8562b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<Character> f8563c = new HashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8565e;

    public f(CharSequence[]... charSequenceArr) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (CharSequence[] charSequenceArr2 : charSequenceArr) {
            this.f8562b.put(charSequenceArr2[0].toString(), charSequenceArr2[1].toString());
            this.f8563c.add(Character.valueOf(charSequenceArr2[0].charAt(0)));
            int length = charSequenceArr2[0].length();
            i2 = length < i2 ? length : i2;
            if (length > i3) {
                i3 = length;
            }
        }
        this.f8564d = i2;
        this.f8565e = i3;
    }

    @Override // k.b.a.a.i.a.b
    public int a(CharSequence charSequence, int i2, Writer writer) throws IOException {
        if (!this.f8563c.contains(Character.valueOf(charSequence.charAt(i2)))) {
            return 0;
        }
        int length = this.f8565e;
        if (i2 + length > charSequence.length()) {
            length = charSequence.length() - i2;
        }
        while (length >= this.f8564d) {
            String str = this.f8562b.get(charSequence.subSequence(i2, i2 + length).toString());
            if (str != null) {
                writer.write(str);
                return length;
            }
            length--;
        }
        return 0;
    }
}
