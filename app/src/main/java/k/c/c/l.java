package k.c.c;

import java.util.ArrayList;
import java.util.List;
import k.c.d.u;

/* JADX INFO: compiled from: IndentedCodeBlockParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends k.c.e.g.a {
    public final k.c.d.n a = new k.c.d.n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CharSequence> f8676b = new ArrayList();

    /* JADX INFO: compiled from: IndentedCodeBlockParser.java */
    public static class a extends k.c.e.g.b {
        @Override // k.c.e.g.d
        public d a(k.c.e.g.f fVar, k.c.e.g.e eVar) {
            h hVar = (h) fVar;
            if (hVar.f8665i < 4 || hVar.f8666j || (hVar.h().g() instanceof u)) {
                return null;
            }
            d dVar = new d(new l());
            dVar.f8643c = hVar.f8661e + 4;
            return dVar;
        }
    }

    @Override // k.c.e.g.c
    public b c(k.c.e.g.f fVar) {
        if (((h) fVar).f8665i >= 4) {
            return b.a(((h) fVar).f8661e + 4);
        }
        h hVar = (h) fVar;
        if (hVar.f8666j) {
            return b.b(hVar.f8663g);
        }
        return null;
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public void e() {
        int i2;
        int size = this.f8676b.size() - 1;
        while (true) {
            if (size >= 0) {
                CharSequence charSequence = this.f8676b.get(size);
                int length = charSequence.length();
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char cCharAt = charSequence.charAt(i3);
                        if (cCharAt != ' ') {
                            switch (cCharAt) {
                            }
                        }
                        i3++;
                    } else {
                        i3 = -1;
                    }
                }
                if (i3 == -1) {
                    size--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (i2 = 0; i2 < size + 1; i2++) {
            sb.append(this.f8676b.get(i2));
            sb.append('\n');
        }
        this.a.f8725f = sb.toString();
    }

    @Override // k.c.e.g.c
    public k.c.d.a g() {
        return this.a;
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public void h(CharSequence charSequence) {
        this.f8676b.add(charSequence);
    }
}
