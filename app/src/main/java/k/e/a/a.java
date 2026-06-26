package k.e.a;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f8811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f8812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f8814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f8815h;

    public a(f fVar, boolean z, c cVar, c cVar2, int i2) {
        this.a = fVar;
        this.f8810c = z;
        this.f8811d = cVar;
        this.f8812e = cVar2;
        this.f8813f = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(int r3, k.e.a.s r4, k.e.a.c r5) {
        /*
            int r0 = r3 >>> 24
            r1 = 1
            if (r0 == 0) goto L1f
            if (r0 == r1) goto L1f
            switch(r0) {
                case 19: goto L17;
                case 20: goto L17;
                case 21: goto L17;
                case 22: goto L1f;
                default: goto La;
            }
        La:
            switch(r0) {
                case 71: goto L1b;
                case 72: goto L1b;
                case 73: goto L1b;
                case 74: goto L1b;
                case 75: goto L1b;
                default: goto Ld;
            }
        Ld:
            r2 = 16776960(0xffff00, float:2.3509528E-38)
            r3 = r3 & r2
            int r3 = r3 >> 8
            r5.c(r0, r3)
            goto L24
        L17:
            r5.e(r0)
            goto L24
        L1b:
            r5.g(r3)
            goto L24
        L1f:
            int r3 = r3 >>> 16
            r5.i(r3)
        L24:
            if (r4 != 0) goto L2b
            r3 = 0
            r5.e(r3)
            goto L37
        L2b:
            byte[] r3 = r4.a
            int r4 = r4.f8920b
            r0 = r3[r4]
            int r0 = r0 * 2
            int r0 = r0 + r1
            r5.f(r3, r4, r0)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.a.b(int, k.e.a.s, k.e.a.c):void");
    }

    public static void d(a[] aVarArr, int i2, c cVar) {
        int length = ((aVarArr.length - i2) * 2) + 1;
        int i3 = i2;
        while (true) {
            int iA = 0;
            if (i3 >= aVarArr.length) {
                break;
            }
            if (aVarArr[i3] != null) {
                iA = aVarArr[i3].a();
            }
            length += iA;
            i3++;
        }
        cVar.g(length);
        cVar.e(aVarArr.length - i2);
        while (i2 < aVarArr.length) {
            a aVar = null;
            int i4 = 0;
            for (a aVar2 = aVarArr[i2]; aVar2 != null; aVar2 = aVar2.f8814g) {
                i4++;
                aVar2.g();
                aVar2.f8815h = aVar;
                aVar = aVar2;
            }
            cVar.i(i4);
            while (aVar != null) {
                c cVar2 = aVar.f8811d;
                cVar.f(cVar2.a, 0, cVar2.f8818b);
                aVar = aVar.f8815h;
            }
            i2++;
        }
    }

    public int a() {
        int i2 = 0;
        for (a aVar = this; aVar != null; aVar = aVar.f8814g) {
            i2 += aVar.f8811d.f8818b;
        }
        return i2;
    }

    public void c(c cVar) {
        int i2 = 2;
        int i3 = 0;
        a aVar = null;
        for (a aVar2 = this; aVar2 != null; aVar2 = aVar2.f8814g) {
            i3++;
            i2 += aVar2.f8811d.f8818b;
            aVar2.g();
            aVar2.f8815h = aVar;
            aVar = aVar2;
        }
        cVar.g(i2);
        cVar.i(i3);
        while (aVar != null) {
            c cVar2 = aVar.f8811d;
            cVar.f(cVar2.a, 0, cVar2.f8818b);
            aVar = aVar.f8815h;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void e(String str, Object obj) {
        int i2;
        c cVar;
        f fVar;
        String strE;
        int iV;
        this.f8809b++;
        if (this.f8810c) {
            this.f8811d.i(this.a.v(str));
        }
        if (obj instanceof String) {
            cVar = this.f8811d;
            i2 = 115;
            fVar = this.a;
            strE = (String) obj;
        } else {
            i2 = 66;
            if (obj instanceof Byte) {
                cVar = this.f8811d;
                iV = this.a.h(((Byte) obj).byteValue()).a;
                cVar.c(i2, iV);
            }
            if (obj instanceof Boolean) {
                this.f8811d.c(90, this.a.h(((Boolean) obj).booleanValue() ? 1 : 0).a);
                return;
            }
            if (obj instanceof Character) {
                this.f8811d.c(67, this.a.h(((Character) obj).charValue()).a);
                return;
            }
            if (obj instanceof Short) {
                this.f8811d.c(83, this.a.h(((Short) obj).shortValue()).a);
                return;
            }
            if (!(obj instanceof r)) {
                int i3 = 0;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    this.f8811d.c(91, bArr.length);
                    while (i3 < bArr.length) {
                        this.f8811d.c(66, this.a.h(bArr[i3]).a);
                        i3++;
                    }
                    return;
                }
                if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    this.f8811d.c(91, zArr.length);
                    while (i3 < zArr.length) {
                        this.f8811d.c(90, this.a.h(zArr[i3] ? 1 : 0).a);
                        i3++;
                    }
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    this.f8811d.c(91, sArr.length);
                    while (i3 < sArr.length) {
                        this.f8811d.c(83, this.a.h(sArr[i3]).a);
                        i3++;
                    }
                    return;
                }
                if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    this.f8811d.c(91, cArr.length);
                    while (i3 < cArr.length) {
                        this.f8811d.c(67, this.a.h(cArr[i3]).a);
                        i3++;
                    }
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    this.f8811d.c(91, iArr.length);
                    while (i3 < iArr.length) {
                        this.f8811d.c(73, this.a.h(iArr[i3]).a);
                        i3++;
                    }
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    this.f8811d.c(91, jArr.length);
                    while (i3 < jArr.length) {
                        this.f8811d.c(74, this.a.j(jArr[i3]).a);
                        i3++;
                    }
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    this.f8811d.c(91, fArr.length);
                    while (i3 < fArr.length) {
                        this.f8811d.c(70, this.a.g(fArr[i3]).a);
                        i3++;
                    }
                    return;
                }
                if (!(obj instanceof double[])) {
                    m mVarK = this.a.k(obj);
                    this.f8811d.c(".s.IFJDCS".charAt(mVarK.f8874b), mVarK.a);
                    return;
                }
                double[] dArr = (double[]) obj;
                this.f8811d.c(91, dArr.length);
                while (i3 < dArr.length) {
                    this.f8811d.c(68, this.a.f(dArr[i3]).a);
                    i3++;
                }
                return;
            }
            cVar = this.f8811d;
            i2 = 99;
            fVar = this.a;
            strE = ((r) obj).e();
        }
        iV = fVar.v(strE);
        cVar.c(i2, iV);
    }

    public a f(String str) {
        this.f8809b++;
        if (this.f8810c) {
            this.f8811d.i(this.a.v(str));
        }
        this.f8811d.c(91, 0);
        f fVar = this.a;
        c cVar = this.f8811d;
        return new a(fVar, false, cVar, cVar, cVar.f8818b - 2);
    }

    public void g() {
        c cVar = this.f8812e;
        if (cVar != null) {
            byte[] bArr = cVar.a;
            int i2 = this.f8813f;
            int i3 = this.f8809b;
            bArr[i2] = (byte) (i3 >>> 8);
            bArr[i2 + 1] = (byte) i3;
        }
    }
}
