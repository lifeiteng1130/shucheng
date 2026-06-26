package e.b.a.r.n.c;

import androidx.annotation.NonNull;
import java.util.Locale;

/* JADX INFO: compiled from: Token.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public final i a;

    /* JADX INFO: compiled from: Token.java */
    public static final class a extends b {
        public a(String str) {
            this.f6071b = str;
        }

        @Override // e.b.a.r.n.c.d.b
        public String toString() {
            return c.a.a.a.a.p(c.a.a.a.a.r("<![CDATA["), this.f6071b, "]]>");
        }
    }

    /* JADX INFO: compiled from: Token.java */
    public static class b extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6071b;

        public b() {
            super(i.Character);
        }

        @Override // e.b.a.r.n.c.d
        public d a() {
            this.f6071b = null;
            return this;
        }

        public String toString() {
            return this.f6071b;
        }
    }

    /* JADX INFO: compiled from: Token.java */
    public static final class c extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f6072b;

        public c() {
            super(i.Comment);
            this.f6072b = new StringBuilder();
        }

        @Override // e.b.a.r.n.c.d
        public d a() {
            d.b(this.f6072b);
            return this;
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("<!--");
            sbR.append(this.f6072b.toString());
            sbR.append("-->");
            return sbR.toString();
        }
    }

    /* JADX INFO: renamed from: e.b.a.r.n.c.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Token.java */
    public static final class C0170d extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f6073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final StringBuilder f6074c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final StringBuilder f6075d;

        public C0170d() {
            super(i.Doctype);
            this.f6073b = new StringBuilder();
            this.f6074c = new StringBuilder();
            this.f6075d = new StringBuilder();
        }

        @Override // e.b.a.r.n.c.d
        public d a() {
            d.b(this.f6073b);
            d.b(this.f6074c);
            d.b(this.f6075d);
            return this;
        }
    }

    /* JADX INFO: compiled from: Token.java */
    public static final class e extends d {
        public e() {
            super(i.EOF);
        }

        @Override // e.b.a.r.n.c.d
        public d a() {
            return this;
        }
    }

    /* JADX INFO: compiled from: Token.java */
    public static final class f extends h {
        public f() {
            super(i.EndTag);
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("</");
            sbR.append(j());
            sbR.append(">");
            return sbR.toString();
        }
    }

    /* JADX INFO: compiled from: Token.java */
    public static final class g extends h {
        public g() {
            super(i.StartTag);
            this.f6084j = new e.b.a.r.n.b.b();
        }

        @Override // e.b.a.r.n.c.d.h, e.b.a.r.n.c.d
        public /* bridge */ /* synthetic */ d a() {
            a();
            return this;
        }

        @Override // e.b.a.r.n.c.d.h
        /* JADX INFO: renamed from: l */
        public h a() {
            super.a();
            this.f6084j = new e.b.a.r.n.b.b();
            return this;
        }

        public String toString() {
            e.b.a.r.n.b.b bVar = this.f6084j;
            if (bVar == null || bVar.f6059b <= 0) {
                StringBuilder sbR = c.a.a.a.a.r("<");
                sbR.append(j());
                sbR.append(">");
                return sbR.toString();
            }
            StringBuilder sbR2 = c.a.a.a.a.r("<");
            sbR2.append(j());
            sbR2.append(" ");
            sbR2.append(this.f6084j.toString());
            sbR2.append(">");
            return sbR2.toString();
        }
    }

    /* JADX INFO: compiled from: Token.java */
    public static abstract class h extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f6078d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public StringBuilder f6079e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f6080f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f6081g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f6082h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f6083i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public e.b.a.r.n.b.b f6084j;

        public h(@NonNull i iVar) {
            super(iVar);
            this.f6079e = new StringBuilder();
            this.f6081g = false;
            this.f6082h = false;
            this.f6083i = false;
        }

        public final void c(char c2) {
            String strValueOf = String.valueOf(c2);
            String str = this.f6078d;
            if (str != null) {
                strValueOf = str.concat(strValueOf);
            }
            this.f6078d = strValueOf;
        }

        public final void d(char c2) {
            i();
            this.f6079e.append(c2);
        }

        public final void e(String str) {
            i();
            if (this.f6079e.length() == 0) {
                this.f6080f = str;
            } else {
                this.f6079e.append(str);
            }
        }

        public final void f(int[] iArr) {
            i();
            for (int i2 : iArr) {
                this.f6079e.appendCodePoint(i2);
            }
        }

        public final void g(char c2) {
            h(String.valueOf(c2));
        }

        public final void h(String str) {
            String str2 = this.f6076b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f6076b = str;
            this.f6077c = str != null ? str.toLowerCase(Locale.ENGLISH) : "";
        }

        public final void i() {
            this.f6082h = true;
            String str = this.f6080f;
            if (str != null) {
                this.f6079e.append(str);
                this.f6080f = null;
            }
        }

        public final String j() {
            String str = this.f6076b;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("Must be false");
            }
            return this.f6076b;
        }

        public final void k() {
            if (this.f6084j == null) {
                this.f6084j = new e.b.a.r.n.b.b();
            }
            String str = this.f6078d;
            if (str != null) {
                String strTrim = str.trim();
                this.f6078d = strTrim;
                if (strTrim.length() > 0) {
                    String string = this.f6082h ? this.f6079e.length() > 0 ? this.f6079e.toString() : this.f6080f : this.f6081g ? "" : null;
                    e.b.a.r.n.b.b bVar = this.f6084j;
                    String str2 = this.f6078d;
                    int iB = bVar.b(str2);
                    if (iB != -1) {
                        bVar.f6061d[iB] = string;
                    } else {
                        int i2 = bVar.f6059b;
                        int i3 = i2 + 1;
                        if (!(i3 >= i2)) {
                            throw new IllegalArgumentException("Must be true");
                        }
                        String[] strArr = bVar.f6060c;
                        int length = strArr.length;
                        if (length < i3) {
                            int i4 = length >= 4 ? i2 * 2 : 4;
                            if (i3 <= i4) {
                                i3 = i4;
                            }
                            bVar.f6060c = e.b.a.r.n.b.b.a(strArr, i3);
                            bVar.f6061d = e.b.a.r.n.b.b.a(bVar.f6061d, i3);
                        }
                        String[] strArr2 = bVar.f6060c;
                        int i5 = bVar.f6059b;
                        strArr2[i5] = str2;
                        bVar.f6061d[i5] = string;
                        bVar.f6059b = i5 + 1;
                    }
                }
            }
            this.f6078d = null;
            this.f6081g = false;
            this.f6082h = false;
            d.b(this.f6079e);
            this.f6080f = null;
        }

        @Override // e.b.a.r.n.c.d
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public h a() {
            this.f6076b = null;
            this.f6077c = null;
            this.f6078d = null;
            d.b(this.f6079e);
            this.f6080f = null;
            this.f6081g = false;
            this.f6082h = false;
            this.f6083i = false;
            this.f6084j = null;
            return this;
        }
    }

    /* JADX INFO: compiled from: Token.java */
    public enum i {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public d(@NonNull i iVar) {
        this.a = iVar;
    }

    public static void b(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    public abstract d a();
}
