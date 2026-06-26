package k.a.a.a.k0;

import k.a.a.a.k0.g;

/* JADX INFO: compiled from: ATNDeserializer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements g.a {
    @Override // k.a.a.a.k0.g.a
    public int a(char[] cArr, int i2) {
        return (cArr[i2 + 1] << 16) | cArr[i2];
    }

    @Override // k.a.a.a.k0.g.a
    public int size() {
        return 2;
    }
}
