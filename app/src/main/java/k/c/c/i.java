package k.c.c;

/* JADX INFO: compiled from: FencedCodeBlockParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends k.c.e.g.a {
    public final k.c.d.h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public StringBuilder f8670c;

    /* JADX INFO: compiled from: FencedCodeBlockParser.java */
    public static class a extends k.c.e.g.b {
        /* JADX WARN: Removed duplicated region for block: B:32:0x0058  */
        @Override // k.c.e.g.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public k.c.c.d a(k.c.e.g.f r11, k.c.e.g.e r12) {
            /*
                r10 = this;
                k.c.c.h r11 = (k.c.c.h) r11
                int r12 = r11.f8665i
                r0 = 4
                r1 = 0
                if (r12 < r0) goto L9
                return r1
            L9:
                int r0 = r11.f8663g
                java.lang.CharSequence r11 = r11.f8659c
                int r2 = r11.length()
                r3 = 0
                r4 = r0
                r5 = 0
                r6 = 0
            L15:
                r7 = 126(0x7e, float:1.77E-43)
                r8 = 96
                if (r4 >= r2) goto L2c
                char r9 = r11.charAt(r4)
                if (r9 == r8) goto L27
                if (r9 == r7) goto L24
                goto L2c
            L24:
                int r6 = r6 + 1
                goto L29
            L27:
                int r5 = r5 + 1
            L29:
                int r4 = r4 + 1
                goto L15
            L2c:
                r2 = 3
                if (r5 < r2) goto L4e
                if (r6 != 0) goto L4e
                int r2 = r0 + r5
                int r4 = r11.length()
            L37:
                r6 = -1
                if (r2 >= r4) goto L44
                char r7 = r11.charAt(r2)
                if (r7 != r8) goto L41
                goto L45
            L41:
                int r2 = r2 + 1
                goto L37
            L44:
                r2 = -1
            L45:
                if (r2 == r6) goto L48
                goto L58
            L48:
                k.c.c.i r11 = new k.c.c.i
                r11.<init>(r8, r5, r12)
                goto L59
            L4e:
                if (r6 < r2) goto L58
                if (r5 != 0) goto L58
                k.c.c.i r11 = new k.c.c.i
                r11.<init>(r7, r6, r12)
                goto L59
            L58:
                r11 = r1
            L59:
                if (r11 == 0) goto L6c
                r12 = 1
                k.c.e.g.c[] r12 = new k.c.e.g.c[r12]
                r12[r3] = r11
                k.c.c.d r1 = new k.c.c.d
                r1.<init>(r12)
                k.c.d.h r11 = r11.a
                int r11 = r11.f8716g
                int r0 = r0 + r11
                r1.f8642b = r0
            L6c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: k.c.c.i.a.a(k.c.e.g.f, k.c.e.g.e):k.c.c.d");
        }
    }

    public i(char c2, int i2, int i3) {
        k.c.d.h hVar = new k.c.d.h();
        this.a = hVar;
        this.f8670c = new StringBuilder();
        hVar.f8715f = c2;
        hVar.f8716g = i2;
        hVar.f8717h = i3;
    }

    @Override // k.c.e.g.c
    public b c(k.c.e.g.f fVar) {
        int i2 = ((h) fVar).f8663g;
        h hVar = (h) fVar;
        int i3 = hVar.f8660d;
        CharSequence charSequence = hVar.f8659c;
        boolean z = false;
        if (hVar.f8665i < 4) {
            k.c.d.h hVar2 = this.a;
            char c2 = hVar2.f8715f;
            int i4 = hVar2.f8716g;
            int iC = k.c.c.v.c.c(c2, charSequence, i2, charSequence.length()) - i2;
            if (iC >= i4 && k.c.c.v.c.d(charSequence, i2 + iC, charSequence.length()) == charSequence.length()) {
                z = true;
            }
        }
        if (z) {
            return new b(-1, -1, true);
        }
        int length = charSequence.length();
        for (int i5 = this.a.f8717h; i5 > 0 && i3 < length && charSequence.charAt(i3) == ' '; i5--) {
            i3++;
        }
        return b.b(i3);
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public void e() {
        this.a.f8718i = k.c.c.v.a.b(this.f8669b.trim());
        this.a.f8719j = this.f8670c.toString();
    }

    @Override // k.c.e.g.c
    public k.c.d.a g() {
        return this.a;
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public void h(CharSequence charSequence) {
        if (this.f8669b == null) {
            this.f8669b = charSequence.toString();
        } else {
            this.f8670c.append(charSequence);
            this.f8670c.append('\n');
        }
    }
}
