package k.c.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k.c.c.c;
import k.c.c.i;
import k.c.c.j;
import k.c.c.k;
import k.c.c.l;
import k.c.c.p;
import k.c.c.t;
import k.c.d.u;
import k.c.d.y;

/* JADX INFO: compiled from: DocumentParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements k.c.e.g.f {
    public static final Set<Class<? extends k.c.d.a>> a = new LinkedHashSet(Arrays.asList(k.c.d.b.class, k.c.d.j.class, k.c.d.h.class, k.c.d.k.class, y.class, k.c.d.q.class, k.c.d.n.class));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<? extends k.c.d.a>, k.c.e.g.d> f8658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f8659c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8662f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8666j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<k.c.e.g.d> f8667k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k.c.e.b f8668l;
    public final List<k.c.e.h.a> m;
    public final g n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8660d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8661e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8663g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8664h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8665i = 0;
    public final Map<String, k.c.d.p> o = new LinkedHashMap();
    public List<k.c.e.g.c> p = new ArrayList();
    public Set<k.c.e.g.c> q = new LinkedHashSet();

    /* JADX INFO: compiled from: DocumentParser.java */
    public static class a implements k.c.e.g.e {
        public final k.c.e.g.c a;

        public a(k.c.e.g.c cVar) {
            this.a = cVar;
        }

        public CharSequence a() {
            k.c.e.g.c cVar = this.a;
            if (!(cVar instanceof r)) {
                return null;
            }
            StringBuilder sb = ((r) cVar).f8705b.f8691b;
            if (sb.length() == 0) {
                return null;
            }
            return sb;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(k.c.d.b.class, new c.a());
        map.put(k.c.d.j.class, new j.a());
        map.put(k.c.d.h.class, new i.a());
        map.put(k.c.d.k.class, new k.b());
        map.put(y.class, new t.a());
        map.put(k.c.d.q.class, new p.a());
        map.put(k.c.d.n.class, new l.a());
        f8658b = Collections.unmodifiableMap(map);
    }

    public h(List<k.c.e.g.d> list, k.c.e.b bVar, List<k.c.e.h.a> list2) {
        this.f8667k = list;
        this.f8668l = bVar;
        this.m = list2;
        g gVar = new g();
        this.n = gVar;
        this.p.add(gVar);
        this.q.add(gVar);
    }

    public final <T extends k.c.e.g.c> T a(T t) {
        while (!h().d(t.g())) {
            e(h());
        }
        h().g().b(t.g());
        this.p.add(t);
        this.q.add(t);
        return t;
    }

    public final void b(r rVar) {
        o oVar = rVar.f8705b;
        oVar.a();
        for (k.c.d.p pVar : oVar.f8692c) {
            u uVar = rVar.a;
            Objects.requireNonNull(uVar);
            pVar.f();
            k.c.d.s sVar = uVar.f8734d;
            pVar.f8734d = sVar;
            if (sVar != null) {
                sVar.f8735e = pVar;
            }
            pVar.f8735e = uVar;
            uVar.f8734d = pVar;
            k.c.d.s sVar2 = uVar.a;
            pVar.a = sVar2;
            if (pVar.f8734d == null) {
                sVar2.f8732b = pVar;
            }
            String str = pVar.f8728f;
            if (!this.o.containsKey(str)) {
                this.o.put(str, pVar);
            }
        }
    }

    public final void c() {
        CharSequence charSequenceSubSequence;
        if (this.f8662f) {
            int i2 = this.f8660d + 1;
            CharSequence charSequence = this.f8659c;
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(i2, charSequence.length());
            int i3 = 4 - (this.f8661e % 4);
            StringBuilder sb = new StringBuilder(charSequenceSubSequence2.length() + i3);
            for (int i4 = 0; i4 < i3; i4++) {
                sb.append(' ');
            }
            sb.append(charSequenceSubSequence2);
            charSequenceSubSequence = sb.toString();
        } else {
            CharSequence charSequence2 = this.f8659c;
            charSequenceSubSequence = charSequence2.subSequence(this.f8660d, charSequence2.length());
        }
        h().h(charSequenceSubSequence);
    }

    public final void d() {
        if (this.f8659c.charAt(this.f8660d) != '\t') {
            this.f8660d++;
            this.f8661e++;
        } else {
            this.f8660d++;
            int i2 = this.f8661e;
            this.f8661e = i2 + (4 - (i2 % 4));
        }
    }

    public final void e(k.c.e.g.c cVar) {
        if (h() == cVar) {
            this.p.remove(r0.size() - 1);
        }
        if (cVar instanceof r) {
            b((r) cVar);
        }
        cVar.e();
    }

    public final void f(List<k.c.e.g.c> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            e(list.get(size));
        }
    }

    public final void g() {
        int i2 = this.f8660d;
        int i3 = this.f8661e;
        this.f8666j = true;
        int length = this.f8659c.length();
        while (true) {
            if (i2 >= length) {
                break;
            }
            char cCharAt = this.f8659c.charAt(i2);
            if (cCharAt == '\t') {
                i2++;
                i3 += 4 - (i3 % 4);
            } else if (cCharAt != ' ') {
                this.f8666j = false;
                break;
            } else {
                i2++;
                i3++;
            }
        }
        this.f8663g = i2;
        this.f8664h = i3;
        this.f8665i = i3 - this.f8661e;
    }

    public k.c.e.g.c h() {
        return this.p.get(r0.size() - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x013d, code lost:
    
        k(r11.f8663g);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.CharSequence r12) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.c.c.h.i(java.lang.CharSequence):void");
    }

    public final void j(int i2) {
        int i3;
        int i4 = this.f8664h;
        if (i2 >= i4) {
            this.f8660d = this.f8663g;
            this.f8661e = i4;
        }
        int length = this.f8659c.length();
        while (true) {
            i3 = this.f8661e;
            if (i3 >= i2 || this.f8660d == length) {
                break;
            } else {
                d();
            }
        }
        if (i3 <= i2) {
            this.f8662f = false;
            return;
        }
        this.f8660d--;
        this.f8661e = i2;
        this.f8662f = true;
    }

    public final void k(int i2) {
        int i3 = this.f8663g;
        if (i2 >= i3) {
            this.f8660d = i3;
            this.f8661e = this.f8664h;
        }
        int length = this.f8659c.length();
        while (true) {
            int i4 = this.f8660d;
            if (i4 >= i2 || i4 == length) {
                break;
            } else {
                d();
            }
        }
        this.f8662f = false;
    }
}
