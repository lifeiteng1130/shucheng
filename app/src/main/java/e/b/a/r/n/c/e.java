package e.b.a.r.n.c;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.n;
import e.b.a.r.n.c.d;
import java.util.Arrays;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: Tokeniser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final char[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f6085b = {8364, Token.EMPTY, 8218, TinkerReport.KEY_LOADED_SUCC_COST_3000_LESS, 8222, 8230, 8224, 8225, 710, 8240, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 8249, 338, Token.SETELEM_OP, 381, Token.SET_REF_OP, Token.DOTDOT, 8216, 8217, 8220, 8221, 8226, n.a.A, n.a.B, 732, 8482, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 8250, 339, 157, 382, 376};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f6086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f6087d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f6089f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d.h f6094k;
    public String q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f6088e = f.Data;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6090g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6091h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public StringBuilder f6092i = new StringBuilder(1024);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public StringBuilder f6093j = new StringBuilder(1024);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d.g f6095l = new d.g();
    public d.f m = new d.f();
    public d.b n = new d.b();
    public d.C0170d o = new d.C0170d();
    public d.c p = new d.c();
    public final int[] r = new int[1];
    public final int[] s = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        a = cArr;
        Arrays.sort(cArr);
    }

    public e(a aVar, c cVar) {
        this.f6086c = aVar;
        this.f6087d = cVar;
    }

    public void a(f fVar) {
        this.f6086c.a();
        this.f6088e = fVar;
    }

    public final void b(String str) {
        if (this.f6087d.canAddError()) {
            this.f6087d.add(new b(this.f6086c.s(), "Invalid character reference: %s", str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x01b7, code lost:
    
        if (r13.f6086c.p('=', '-', '_') == false) goto L119;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int[] c(java.lang.Character r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.r.n.c.e.c(java.lang.Character, boolean):int[]");
    }

    public void d() {
        d.C0170d c0170d = this.o;
        d.b(c0170d.f6073b);
        d.b(c0170d.f6074c);
        d.b(c0170d.f6075d);
    }

    public d.h e(boolean z) {
        d.h hVar;
        if (z) {
            hVar = this.f6095l;
            hVar.a();
        } else {
            hVar = this.m;
            hVar.a();
        }
        this.f6094k = hVar;
        return hVar;
    }

    public void f(char c2) {
        h(String.valueOf(c2));
    }

    public void g(d dVar) {
        if (this.f6090g) {
            throw new IllegalArgumentException("There is an unread token pending!");
        }
        this.f6089f = dVar;
        this.f6090g = true;
        d.i iVar = dVar.a;
        if (iVar == d.i.StartTag) {
            this.q = ((d.g) dVar).f6076b;
        } else if (iVar == d.i.EndTag && ((d.f) dVar).f6084j != null && this.f6087d.canAddError()) {
            this.f6087d.add(new b(this.f6086c.s(), "Attributes incorrectly present on end tag"));
        }
    }

    public void h(String str) {
        if (this.f6091h == null) {
            this.f6091h = str;
            return;
        }
        if (this.f6092i.length() == 0) {
            this.f6092i.append(this.f6091h);
        }
        this.f6092i.append(str);
    }

    public void i() {
        d.h hVar = this.f6094k;
        if (hVar.f6078d != null) {
            hVar.k();
        }
        g(this.f6094k);
    }

    public void j(f fVar) {
        if (this.f6087d.canAddError()) {
            this.f6087d.add(new b(this.f6086c.s(), "Unexpectedly reached end of file (EOF) in input state [%s]", fVar));
        }
    }

    public void k(f fVar) {
        if (this.f6087d.canAddError()) {
            this.f6087d.add(new b(this.f6086c.s(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f6086c.j()), fVar));
        }
    }

    public boolean l() {
        return this.q != null && this.f6094k.j().equalsIgnoreCase(this.q);
    }
}
