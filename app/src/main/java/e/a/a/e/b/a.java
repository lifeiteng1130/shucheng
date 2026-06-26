package e.a.a.e.b;

import e.a.a.e.b.c;
import e.a.a.e.b.e;
import e.a.a.e.b.f;
import e.a.a.e.b.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: CharsetDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final List<C0152a> a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5602c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f5605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5606g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f5601b = new byte[8000];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short[] f5603d = new short[256];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5604e = false;

    /* JADX INFO: renamed from: e.a.a.e.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CharsetDetector.java */
    public static class C0152a {
        public h a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5607b;

        public C0152a(h hVar, boolean z) {
            this.a = hVar;
            this.f5607b = z;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0152a(new d(), true));
        arrayList.add(new C0152a(new e.a(), true));
        arrayList.add(new C0152a(new e.b(), true));
        arrayList.add(new C0152a(new e.d(), true));
        arrayList.add(new C0152a(new e.C0154e(), true));
        arrayList.add(new C0152a(new f.d(), true));
        arrayList.add(new C0152a(new c.b(), true));
        arrayList.add(new C0152a(new c.a(), true));
        arrayList.add(new C0152a(new c.C0153c(), true));
        arrayList.add(new C0152a(new f.c(), true));
        arrayList.add(new C0152a(new f.b.a(), true));
        arrayList.add(new C0152a(new f.b.C0155b(), true));
        arrayList.add(new C0152a(new f.a(), true));
        arrayList.add(new C0152a(new g.a(), true));
        arrayList.add(new C0152a(new g.b(), true));
        arrayList.add(new C0152a(new g.d(), true));
        arrayList.add(new C0152a(new g.f(), true));
        arrayList.add(new C0152a(new g.h(), true));
        arrayList.add(new C0152a(new g.j(), true));
        arrayList.add(new C0152a(new g.k(), true));
        arrayList.add(new C0152a(new g.u(), true));
        arrayList.add(new C0152a(new g.v(), true));
        arrayList.add(new C0152a(new g.t(), true));
        arrayList.add(new C0152a(new g.m(), true));
        arrayList.add(new C0152a(new g.s(), false));
        arrayList.add(new C0152a(new g.r(), false));
        arrayList.add(new C0152a(new g.p(), false));
        arrayList.add(new C0152a(new g.o(), false));
        a = Collections.unmodifiableList(arrayList);
    }
}
