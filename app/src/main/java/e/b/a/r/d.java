package e.b.a.r;

import androidx.annotation.NonNull;
import e.b.a.e;
import e.b.a.i;
import e.b.a.j;
import e.b.a.o;
import e.b.a.r.a;
import e.b.a.r.f;
import e.b.a.r.j;
import e.b.a.r.m;
import e.b.a.r.n.c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k.c.d.s;

/* JADX INFO: compiled from: HtmlPlugin.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends e.b.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f6039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f6040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f6041d = new c();
    public final j.b a = new j.b();

    /* JADX INFO: compiled from: HtmlPlugin.java */
    public class a implements i.c<k.c.d.l> {
        public a() {
        }

        @Override // e.b.a.i.c
        public void a(@NonNull e.b.a.i iVar, @NonNull s sVar) {
            d.l(d.this, iVar, ((k.c.d.l) sVar).f8722f);
        }
    }

    /* JADX INFO: compiled from: HtmlPlugin.java */
    public class b implements i.c<k.c.d.k> {
        public b() {
        }

        @Override // e.b.a.i.c
        public void a(@NonNull e.b.a.i iVar, @NonNull s sVar) {
            d.l(d.this, iVar, ((k.c.d.k) sVar).f8721f);
        }
    }

    public static void l(d dVar, e.b.a.i iVar, String str) {
        e.b.a.r.n.c.d dVar2;
        String strA;
        String strA2;
        int length;
        Objects.requireNonNull(dVar);
        if (str == null) {
            return;
        }
        g gVar = dVar.f6039b;
        o oVar = ((e.b.a.j) iVar).f5982c;
        h hVar = (h) gVar;
        Objects.requireNonNull(hVar);
        e.b.a.r.n.c.e eVar = new e.b.a.r.n.c.e(new e.b.a.r.n.c.a(str), e.b.a.r.n.c.c.noTracking());
        while (true) {
            if (eVar.f6090g) {
                f.b bVar = null;
                if (eVar.f6092i.length() > 0) {
                    String string = eVar.f6092i.toString();
                    StringBuilder sb = eVar.f6092i;
                    sb.delete(0, sb.length());
                    eVar.f6091h = null;
                    d.b bVar2 = eVar.n;
                    bVar2.f6071b = string;
                    dVar2 = bVar2;
                } else {
                    String str2 = eVar.f6091h;
                    if (str2 != null) {
                        d.b bVar3 = eVar.n;
                        bVar3.f6071b = str2;
                        eVar.f6091h = null;
                        dVar2 = bVar3;
                    } else {
                        eVar.f6090g = false;
                        dVar2 = eVar.f6089f;
                    }
                }
                d.i iVar2 = dVar2.a;
                if (d.i.EOF == iVar2) {
                    return;
                }
                int iOrdinal = iVar2.ordinal();
                if (iOrdinal == 1) {
                    d.g gVar2 = (d.g) dVar2;
                    if (h.a.contains(gVar2.f6077c)) {
                        String str3 = gVar2.f6077c;
                        f.b bVar4 = new f.b(str3, oVar.length(), h.b(gVar2));
                        if (hVar.f6054i) {
                            h.a(oVar);
                            hVar.f6054i = false;
                        }
                        if (h.f6047b.contains(str3) || gVar2.f6083i) {
                            String strA3 = hVar.f6049d.a(bVar4);
                            if (strA3 != null && strA3.length() > 0) {
                                c.b.a.m.f.m0(oVar, strA3);
                            }
                            bVar4.g(oVar.length());
                        }
                        hVar.f6051f.add(bVar4);
                    } else {
                        String str4 = gVar2.f6077c;
                        if ("p".equals(hVar.f6052g.a)) {
                            hVar.f6052g.g(oVar.length());
                            c.b.a.m.f.l0(oVar, '\n');
                            hVar.f6052g = hVar.f6052g.f6045e;
                        } else if ("li".equals(str4) && "li".equals(hVar.f6052g.a)) {
                            hVar.f6052g.g(oVar.length());
                            hVar.f6052g = hVar.f6052g.f6045e;
                        }
                        if (h.f6048c.contains(str4)) {
                            hVar.f6053h = "pre".equals(str4);
                            h.a(oVar);
                        } else if (hVar.f6054i) {
                            h.a(oVar);
                            hVar.f6054i = false;
                        }
                        int length2 = oVar.length();
                        Map<String, String> mapB = h.b(gVar2);
                        f.a aVar = hVar.f6052g;
                        f.a aVar2 = new f.a(str4, length2, mapB, aVar);
                        boolean z = h.f6047b.contains(str4) || gVar2.f6083i;
                        if (z) {
                            String strA4 = hVar.f6049d.a(aVar2);
                            if (strA4 != null && strA4.length() > 0) {
                                c.b.a.m.f.m0(oVar, strA4);
                            }
                            aVar2.g(oVar.length());
                        }
                        List arrayList = aVar.f6046f;
                        if (arrayList == null) {
                            arrayList = new ArrayList(2);
                            aVar.f6046f = arrayList;
                        }
                        arrayList.add(aVar2);
                        if (!z) {
                            hVar.f6052g = aVar2;
                        }
                    }
                } else if (iOrdinal == 2) {
                    d.f fVar = (d.f) dVar2;
                    if (h.a.contains(fVar.f6077c)) {
                        String str5 = fVar.f6077c;
                        int size = hVar.f6051f.size() - 1;
                        while (true) {
                            if (size <= -1) {
                                break;
                            }
                            f.b bVar5 = hVar.f6051f.get(size);
                            if (str5.equals(bVar5.a) && bVar5.f6044d < 0) {
                                bVar = bVar5;
                                break;
                            }
                            size--;
                        }
                        if (bVar != null) {
                            if ((bVar.f6042b == oVar.length()) && (strA2 = hVar.f6049d.a(bVar)) != null) {
                                c.b.a.m.f.m0(oVar, strA2);
                            }
                            bVar.g(oVar.length());
                        }
                    } else {
                        String str6 = fVar.f6077c;
                        f.a aVar3 = hVar.f6052g;
                        while (aVar3 != null && !str6.equals(aVar3.a) && !aVar3.isClosed()) {
                            aVar3 = aVar3.f6045e;
                        }
                        if (aVar3 != null) {
                            if ("pre".equals(str6)) {
                                hVar.f6053h = false;
                            }
                            if ((aVar3.f6042b == oVar.length()) && (strA = hVar.f6049d.a(aVar3)) != null) {
                                c.b.a.m.f.m0(oVar, strA);
                            }
                            aVar3.g(oVar.length());
                            if (!(aVar3.f6042b == aVar3.f6044d)) {
                                hVar.f6054i = h.f6048c.contains(aVar3.a);
                            }
                            if ("p".equals(str6)) {
                                c.b.a.m.f.l0(oVar, '\n');
                            }
                            hVar.f6052g = aVar3.f6045e;
                        }
                    }
                } else if (iOrdinal == 4) {
                    d.b bVar6 = (d.b) dVar2;
                    if (hVar.f6053h) {
                        c.b.a.m.f.m0(oVar, bVar6.f6071b);
                    } else {
                        if (hVar.f6054i) {
                            h.a(oVar);
                            hVar.f6054i = false;
                        }
                        m mVar = hVar.f6050e;
                        String str7 = bVar6.f6071b;
                        Objects.requireNonNull((m.a) mVar);
                        int length3 = oVar.length();
                        int length4 = str7.length();
                        boolean z2 = false;
                        for (int i2 = 0; i2 < length4; i2++) {
                            char cCharAt = str7.charAt(i2);
                            if (Character.isWhitespace(cCharAt)) {
                                z2 = true;
                            } else {
                                if (z2 && (length = oVar.length()) > 0 && !Character.isWhitespace(oVar.charAt(length - 1))) {
                                    c.b.a.m.f.l0(oVar, ' ');
                                }
                                c.b.a.m.f.l0(oVar, cCharAt);
                                z2 = false;
                            }
                        }
                        if (z2 && length3 < oVar.length()) {
                            c.b.a.m.f.l0(oVar, ' ');
                        }
                    }
                }
                dVar2.a();
            } else {
                eVar.f6088e.read(eVar, eVar.f6086c);
            }
        }
    }

    @Override // e.b.a.a, e.b.a.f
    public void f(@NonNull e.b bVar) {
        j.b bVar2 = this.a;
        Objects.requireNonNull(bVar2);
        bVar2.a(new e.b.a.r.p.d(new e.b.a.r.p.e(new a.b())));
        bVar2.a(new e.b.a.r.p.f());
        bVar2.a(new e.b.a.r.p.a());
        bVar2.a(new e.b.a.r.p.k());
        bVar2.a(new e.b.a.r.p.l());
        bVar2.a(new e.b.a.r.p.j());
        bVar2.a(new e.b.a.r.p.i());
        bVar2.a(new e.b.a.r.p.m());
        bVar2.a(new e.b.a.r.p.g());
        bVar2.a(new e.b.a.r.p.b());
        bVar2.a(new e.b.a.r.p.c());
        this.f6039b = new h(this.f6041d, new m.a());
        if (bVar2.f6056b) {
            throw new IllegalStateException("Builder has been already built");
        }
        bVar2.f6056b = true;
        this.f6040c = bVar2.a.size() > 0 ? new j(false, Collections.unmodifiableMap(bVar2.a)) : new k();
    }

    @Override // e.b.a.a, e.b.a.f
    public void j(@NonNull i.b bVar) {
        j.a aVar = (j.a) bVar;
        aVar.a.put(k.c.d.k.class, new b());
        aVar.a.put(k.c.d.l.class, new a());
    }

    @Override // e.b.a.a, e.b.a.f
    public void k(@NonNull s sVar, @NonNull e.b.a.i iVar) {
        i iVar2 = this.f6040c;
        if (iVar2 == null) {
            throw new IllegalStateException("Unexpected state, html-renderer is not defined");
        }
        iVar2.a(iVar, this.f6039b);
    }
}
