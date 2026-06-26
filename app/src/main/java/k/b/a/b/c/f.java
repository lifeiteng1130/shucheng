package k.b.a.b.c;

import java.io.IOException;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: LookupTranslator.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f8626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitSet f8627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8629e;

    public f(Map<CharSequence, CharSequence> map) {
        if (map == null) {
            throw new InvalidParameterException("lookupMap cannot be null");
        }
        this.f8626b = new HashMap();
        this.f8627c = new BitSet();
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (Map.Entry<CharSequence, CharSequence> entry : map.entrySet()) {
            this.f8626b.put(entry.getKey().toString(), entry.getValue().toString());
            this.f8627c.set(entry.getKey().charAt(0));
            int length = entry.getKey().length();
            i2 = length < i2 ? length : i2;
            if (length > i3) {
                i3 = length;
            }
        }
        this.f8628d = i2;
        this.f8629e = i3;
    }

    @Override // k.b.a.b.c.b
    public int a(CharSequence charSequence, int i2, Writer writer) throws IOException {
        if (!this.f8627c.get(charSequence.charAt(i2))) {
            return 0;
        }
        int length = this.f8629e;
        if (i2 + length > charSequence.length()) {
            length = charSequence.length() - i2;
        }
        while (length >= this.f8628d) {
            String str = this.f8626b.get(charSequence.subSequence(i2, i2 + length).toString());
            if (str != null) {
                writer.write(str);
                return length;
            }
            length--;
        }
        return 0;
    }
}
