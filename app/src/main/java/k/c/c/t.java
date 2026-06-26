package k.c.c;

import k.c.d.y;

/* JADX INFO: compiled from: ThematicBreakParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends k.c.e.g.a {
    public final y a = new y();

    /* JADX INFO: compiled from: ThematicBreakParser.java */
    public static class a extends k.c.e.g.b {
        @Override // k.c.e.g.d
        public d a(k.c.e.g.f fVar, k.c.e.g.e eVar) {
            boolean z;
            h hVar = (h) fVar;
            if (hVar.f8665i >= 4) {
                return null;
            }
            int i2 = hVar.f8663g;
            CharSequence charSequence = hVar.f8659c;
            int length = charSequence.length();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i2 < length) {
                    char cCharAt = charSequence.charAt(i2);
                    if (cCharAt != '\t' && cCharAt != ' ') {
                        if (cCharAt == '*') {
                            i5++;
                        } else if (cCharAt == '-') {
                            i3++;
                        } else {
                            if (cCharAt != '_') {
                                break;
                            }
                            i4++;
                        }
                    }
                    i2++;
                } else {
                    if ((i3 < 3 || i4 != 0 || i5 != 0) && ((i4 < 3 || i3 != 0 || i5 != 0) && (i5 < 3 || i3 != 0 || i4 != 0))) {
                        break;
                    }
                    z = true;
                }
            }
            z = false;
            if (!z) {
                return null;
            }
            d dVar = new d(new t());
            dVar.f8642b = charSequence.length();
            return dVar;
        }
    }

    @Override // k.c.e.g.c
    public b c(k.c.e.g.f fVar) {
        return null;
    }

    @Override // k.c.e.g.c
    public k.c.d.a g() {
        return this.a;
    }
}
