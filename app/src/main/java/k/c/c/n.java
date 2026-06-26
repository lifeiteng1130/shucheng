package k.c.c;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.c.d.x;

/* JADX INFO: compiled from: InlineParserImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class n implements k.c.e.a {
    public static final Pattern a = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f8678b = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f8679c = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f8680d = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f8681e = Pattern.compile("`+");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f8682f = Pattern.compile("^`+");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f8683g = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f8684h = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f8685i = Pattern.compile("^ *(?:\n *)?");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f8686j = Pattern.compile("^[\\p{Zs}\t\r\n\f]");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f8687k = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f8688l = Pattern.compile(" *$");
    public final BitSet m;
    public final BitSet n;
    public final Map<Character, k.c.e.h.a> o;
    public final m p;
    public String q;
    public int r;
    public f s;
    public e t;

    /* JADX INFO: compiled from: InlineParserImpl.java */
    public static class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f8689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f8690c;

        public a(int i2, boolean z, boolean z2) {
            this.a = i2;
            this.f8690c = z;
            this.f8689b = z2;
        }
    }

    public n(m mVar) {
        List<k.c.e.h.a> list = mVar.a;
        HashMap map = new HashMap();
        b(Arrays.asList(new k.c.c.u.a(), new k.c.c.u.c()), map);
        b(list, map);
        this.o = map;
        Set setKeySet = map.keySet();
        BitSet bitSet = new BitSet();
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        this.n = bitSet;
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        this.m = bitSet2;
        this.p = mVar;
    }

    public static void a(char c2, k.c.e.h.a aVar, Map<Character, k.c.e.h.a> map) {
        if (map.put(Character.valueOf(c2), aVar) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c2 + "'");
    }

    public static void b(Iterable<k.c.e.h.a> iterable, Map<Character, k.c.e.h.a> map) {
        s sVar;
        for (k.c.e.h.a aVar : iterable) {
            char cE = aVar.e();
            char c2 = aVar.c();
            if (cE == c2) {
                k.c.e.h.a aVar2 = map.get(Character.valueOf(cE));
                if (aVar2 == null || aVar2.e() != aVar2.c()) {
                    a(cE, aVar, map);
                } else {
                    if (aVar2 instanceof s) {
                        sVar = (s) aVar2;
                    } else {
                        s sVar2 = new s(cE);
                        sVar2.f(aVar2);
                        sVar = sVar2;
                    }
                    sVar.f(aVar);
                    map.put(Character.valueOf(cE), sVar);
                }
            } else {
                a(cE, aVar, map);
                a(c2, aVar, map);
            }
        }
    }

    public final String c(Pattern pattern) {
        if (this.r >= this.q.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.q);
        matcher.region(this.r, this.q.length());
        if (!matcher.find()) {
            return null;
        }
        this.r = matcher.end();
        return matcher.group();
    }

    public final void d(x xVar, x xVar2, int i2) {
        if (xVar == null || xVar2 == null || xVar == xVar2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(xVar.f8738f);
        k.c.d.s sVar = xVar.f8735e;
        k.c.d.s sVar2 = xVar2.f8735e;
        while (sVar != sVar2) {
            sb.append(((x) sVar).f8738f);
            k.c.d.s sVar3 = sVar.f8735e;
            sVar.f();
            sVar = sVar3;
        }
        xVar.f8738f = sb.toString();
    }

    public final void e(k.c.d.s sVar, k.c.d.s sVar2) {
        x xVar = null;
        x xVar2 = null;
        int length = 0;
        while (sVar != null) {
            if (sVar instanceof x) {
                xVar2 = (x) sVar;
                if (xVar == null) {
                    xVar = xVar2;
                }
                length = xVar2.f8738f.length() + length;
            } else {
                d(xVar, xVar2, length);
                xVar = null;
                xVar2 = null;
                length = 0;
            }
            if (sVar == sVar2) {
                break;
            } else {
                sVar = sVar.f8735e;
            }
        }
        d(xVar, xVar2, length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0015 A[PHI: r14
  0x0015: PHI (r14v90 ??) = (r14v4 ??), (r14v17 ??) binds: [B:4:0x0013, B:261:0x04c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012d  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v74, types: [k.c.d.s] */
    /* JADX WARN: Type inference failed for: r0v75 */
    /* JADX WARN: Type inference failed for: r0v76 */
    /* JADX WARN: Type inference failed for: r0v77 */
    /* JADX WARN: Type inference failed for: r14v14, types: [k.c.d.v] */
    /* JADX WARN: Type inference failed for: r14v15, types: [k.c.d.i] */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v23, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v26, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v36 */
    /* JADX WARN: Type inference failed for: r14v38 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v43, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v46 */
    /* JADX WARN: Type inference failed for: r14v49, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v51, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v56, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v57, types: [k.c.d.i] */
    /* JADX WARN: Type inference failed for: r14v60, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v63, types: [k.c.d.s] */
    /* JADX WARN: Type inference failed for: r14v65, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v66, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v70, types: [k.c.d.x] */
    /* JADX WARN: Type inference failed for: r14v85 */
    /* JADX WARN: Type inference failed for: r14v89 */
    /* JADX WARN: Type inference failed for: r14v9, types: [k.c.d.v] */
    /* JADX WARN: Type inference failed for: r14v90 */
    /* JADX WARN: Type inference failed for: r14v91 */
    /* JADX WARN: Type inference failed for: r14v92 */
    /* JADX WARN: Type inference failed for: r15v0, types: [k.c.d.s] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.lang.String r14, k.c.d.s r15) {
        /*
            Method dump skipped, instruction units count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.c.c.n.f(java.lang.String, k.c.d.s):void");
    }

    public final char g() {
        if (this.r < this.q.length()) {
            return this.q.charAt(this.r);
        }
        return (char) 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        r9 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(k.c.c.f r12) {
        /*
            r11 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            k.c.c.f r1 = r11.s
        L7:
            if (r1 == 0) goto Lf
            k.c.c.f r2 = r1.f8654e
            if (r2 == r12) goto Lf
            r1 = r2
            goto L7
        Lf:
            if (r1 == 0) goto Lbb
            char r2 = r1.f8651b
            java.util.Map<java.lang.Character, k.c.e.h.a> r3 = r11.o
            java.lang.Character r4 = java.lang.Character.valueOf(r2)
            java.lang.Object r3 = r3.get(r4)
            k.c.e.h.a r3 = (k.c.e.h.a) r3
            boolean r4 = r1.f8653d
            if (r4 == 0) goto Lb7
            if (r3 != 0) goto L27
            goto Lb7
        L27:
            char r4 = r3.e()
            k.c.c.f r5 = r1.f8654e
            r6 = 0
            r7 = 0
            r8 = 0
        L30:
            r9 = 1
            if (r5 == 0) goto L52
            if (r5 == r12) goto L52
            java.lang.Character r10 = java.lang.Character.valueOf(r2)
            java.lang.Object r10 = r0.get(r10)
            if (r5 == r10) goto L52
            boolean r10 = r5.f8652c
            if (r10 == 0) goto L4f
            char r10 = r5.f8651b
            if (r10 != r4) goto L4f
            int r7 = r3.a(r5, r1)
            r8 = 1
            if (r7 <= 0) goto L4f
            goto L53
        L4f:
            k.c.c.f r5 = r5.f8654e
            goto L30
        L52:
            r9 = 0
        L53:
            if (r9 != 0) goto L6a
            if (r8 != 0) goto L67
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            k.c.c.f r3 = r1.f8654e
            r0.put(r2, r3)
            boolean r2 = r1.f8652c
            if (r2 != 0) goto L67
            r11.j(r1)
        L67:
            k.c.c.f r1 = r1.f8655f
            goto Lf
        L6a:
            k.c.d.x r2 = r5.a
            k.c.d.x r4 = r1.a
            int r8 = r5.f8656g
            int r8 = r8 - r7
            r5.f8656g = r8
            int r8 = r1.f8656g
            int r8 = r8 - r7
            r1.f8656g = r8
            java.lang.String r8 = r2.f8738f
            java.lang.String r8 = c.a.a.a.a.c(r8, r7, r6)
            r2.f8738f = r8
            java.lang.String r8 = r4.f8738f
            java.lang.String r6 = c.a.a.a.a.c(r8, r7, r6)
            r4.f8738f = r6
            k.c.c.f r6 = r1.f8654e
        L8a:
            if (r6 == 0) goto L95
            if (r6 == r5) goto L95
            k.c.c.f r8 = r6.f8654e
            r11.j(r6)
            r6 = r8
            goto L8a
        L95:
            if (r2 == r4) goto La1
            k.c.d.s r6 = r2.f8735e
            if (r6 != r4) goto L9c
            goto La1
        L9c:
            k.c.d.s r8 = r4.f8734d
            r11.e(r6, r8)
        La1:
            r3.b(r2, r4, r7)
            int r2 = r5.f8656g
            if (r2 != 0) goto Lab
            r11.i(r5)
        Lab:
            int r2 = r1.f8656g
            if (r2 != 0) goto Lf
            k.c.c.f r2 = r1.f8655f
            r11.i(r1)
            r1 = r2
            goto Lf
        Lb7:
            k.c.c.f r1 = r1.f8655f
            goto Lf
        Lbb:
            k.c.c.f r0 = r11.s
            if (r0 == 0) goto Lc5
            if (r0 == r12) goto Lc5
            r11.j(r0)
            goto Lbb
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k.c.c.n.h(k.c.c.f):void");
    }

    public final void i(f fVar) {
        fVar.a.f();
        f fVar2 = fVar.f8654e;
        if (fVar2 != null) {
            fVar2.f8655f = fVar.f8655f;
        }
        f fVar3 = fVar.f8655f;
        if (fVar3 == null) {
            this.s = fVar2;
        } else {
            fVar3.f8654e = fVar2;
        }
    }

    public final void j(f fVar) {
        f fVar2 = fVar.f8654e;
        if (fVar2 != null) {
            fVar2.f8655f = fVar.f8655f;
        }
        f fVar3 = fVar.f8655f;
        if (fVar3 == null) {
            this.s = fVar2;
        } else {
            fVar3.f8654e = fVar2;
        }
    }

    public final void k() {
        this.t = this.t.f8647d;
    }

    public final x l(String str, int i2, int i3) {
        return new x(str.substring(i2, i3));
    }
}
