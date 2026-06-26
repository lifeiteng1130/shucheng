package e.b.a.r.n.c;

import e.b.a.r.n.c.d;
import java.util.Locale;
import java.util.Objects;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DocumentType;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TokeniserState.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final char nullChar = 0;
    public static final f Data = new k("Data", 0);
    public static final f CharacterReferenceInData = new f("CharacterReferenceInData", 1) { // from class: e.b.a.r.n.c.f.v
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$100(eVar, f.Data);
        }
    };
    public static final f Rcdata = new f("Rcdata", 2) { // from class: e.b.a.r.n.c.f.g0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cJ = aVar.j();
            if (cJ == 0) {
                eVar.k(this);
                aVar.a();
                eVar.f((char) 65533);
            } else {
                if (cJ == '&') {
                    eVar.a(f.CharacterReferenceInRcdata);
                    return;
                }
                if (cJ == '<') {
                    eVar.a(f.RcdataLessthanSign);
                } else if (cJ != 65535) {
                    eVar.h(aVar.g('&', '<', 0));
                } else {
                    eVar.g(new d.e());
                }
            }
        }
    };
    public static final f CharacterReferenceInRcdata = new f("CharacterReferenceInRcdata", 3) { // from class: e.b.a.r.n.c.f.r0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$100(eVar, f.Rcdata);
        }
    };
    public static final f Rawtext = new f("Rawtext", 4) { // from class: e.b.a.r.n.c.f.c1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$200(eVar, aVar, this, f.RawtextLessthanSign);
        }
    };
    public static final f ScriptData = new f("ScriptData", 5) { // from class: e.b.a.r.n.c.f.l1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$200(eVar, aVar, this, f.ScriptDataLessthanSign);
        }
    };
    public static final f PLAINTEXT = new f("PLAINTEXT", 6) { // from class: e.b.a.r.n.c.f.m1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cJ = aVar.j();
            if (cJ == 0) {
                eVar.k(this);
                aVar.a();
                eVar.f((char) 65533);
            } else if (cJ != 65535) {
                eVar.h(aVar.f((char) 0));
            } else {
                eVar.g(new d.e());
            }
        }
    };
    public static final f TagOpen = new f("TagOpen", 7) { // from class: e.b.a.r.n.c.f.n1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cJ = aVar.j();
            if (cJ == '!') {
                eVar.a(f.MarkupDeclarationOpen);
                return;
            }
            if (cJ == '/') {
                eVar.a(f.EndTagOpen);
                return;
            }
            if (cJ == '?') {
                eVar.a(f.BogusComment);
                return;
            }
            if (aVar.q()) {
                eVar.e(true);
                eVar.f6088e = f.TagName;
            } else {
                eVar.k(this);
                eVar.f('<');
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f EndTagOpen = new f("EndTagOpen", 8) { // from class: e.b.a.r.n.c.f.o1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.k()) {
                eVar.j(this);
                eVar.h("</");
                eVar.f6088e = f.Data;
            } else if (aVar.q()) {
                eVar.e(false);
                eVar.f6088e = f.TagName;
            } else if (aVar.o('>')) {
                eVar.k(this);
                eVar.a(f.Data);
            } else {
                eVar.k(this);
                eVar.a(f.BogusComment);
            }
        }
    };
    public static final f TagName = new f("TagName", 9) { // from class: e.b.a.r.n.c.f.a
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            int i2;
            char c2;
            aVar.b();
            int i3 = aVar.f6066e;
            int i4 = aVar.f6064c;
            char[] cArr = aVar.a;
            while (true) {
                i2 = aVar.f6066e;
                if (i2 >= i4 || (c2 = cArr[i2]) == '\t' || c2 == '\n' || c2 == '\r' || c2 == '\f' || c2 == ' ' || c2 == '/' || c2 == '>' || c2 == 0) {
                    break;
                } else {
                    aVar.f6066e = i2 + 1;
                }
            }
            eVar.f6094k.h(i2 > i3 ? e.b.a.r.n.c.a.c(aVar.a, aVar.f6069h, i3, i2 - i3) : "");
            char cD = aVar.d();
            if (cD == 0) {
                eVar.f6094k.h(f.a);
                return;
            }
            if (cD != ' ') {
                if (cD == '/') {
                    eVar.f6088e = f.SelfClosingStartTag;
                    return;
                }
                if (cD == '>') {
                    eVar.i();
                    eVar.f6088e = f.Data;
                    return;
                } else if (cD == 65535) {
                    eVar.j(this);
                    eVar.f6088e = f.Data;
                    return;
                } else if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                    eVar.f6094k.g(cD);
                    return;
                }
            }
            eVar.f6088e = f.BeforeAttributeName;
        }
    };
    public static final f RcdataLessthanSign = new f("RcdataLessthanSign", 10) { // from class: e.b.a.r.n.c.f.b
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.o(Attributes.InternalPrefix)) {
                e.b.a.r.n.c.d.b(eVar.f6093j);
                eVar.a(f.RCDATAEndTagOpen);
                return;
            }
            if (aVar.q() && eVar.q != null) {
                StringBuilder sbR = c.a.a.a.a.r("</");
                sbR.append(eVar.q);
                String string = sbR.toString();
                Locale locale = Locale.ENGLISH;
                if (!(aVar.r(string.toLowerCase(locale)) > -1 || aVar.r(string.toUpperCase(locale)) > -1)) {
                    d.h hVarE = eVar.e(false);
                    String str = eVar.q;
                    hVarE.f6076b = str;
                    hVarE.f6077c = str != null ? str.toLowerCase(locale) : "";
                    eVar.f6094k = hVarE;
                    eVar.i();
                    aVar.t();
                    eVar.f6088e = f.Data;
                    return;
                }
            }
            eVar.h("<");
            eVar.f6088e = f.Rcdata;
        }
    };
    public static final f RCDATAEndTagOpen = new f("RCDATAEndTagOpen", 11) { // from class: e.b.a.r.n.c.f.c
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (!aVar.q()) {
                eVar.h("</");
                eVar.f6088e = f.Rcdata;
            } else {
                eVar.e(false);
                eVar.f6094k.g(aVar.j());
                eVar.f6093j.append(aVar.j());
                eVar.a(f.RCDATAEndTagName);
            }
        }
    };
    public static final f RCDATAEndTagName = new f("RCDATAEndTagName", 12) { // from class: e.b.a.r.n.c.f.d
        public final void a(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            StringBuilder sbR = c.a.a.a.a.r("</");
            sbR.append(eVar.f6093j.toString());
            eVar.h(sbR.toString());
            aVar.t();
            eVar.f6088e = f.Rcdata;
        }

        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.q()) {
                String strE = aVar.e();
                eVar.f6094k.h(strE);
                eVar.f6093j.append(strE);
                return;
            }
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                if (eVar.l()) {
                    eVar.f6088e = f.BeforeAttributeName;
                    return;
                } else {
                    a(eVar, aVar);
                    return;
                }
            }
            if (cD == '/') {
                if (eVar.l()) {
                    eVar.f6088e = f.SelfClosingStartTag;
                    return;
                } else {
                    a(eVar, aVar);
                    return;
                }
            }
            if (cD != '>') {
                a(eVar, aVar);
            } else if (!eVar.l()) {
                a(eVar, aVar);
            } else {
                eVar.i();
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f RawtextLessthanSign = new f("RawtextLessthanSign", 13) { // from class: e.b.a.r.n.c.f.e
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.o(Attributes.InternalPrefix)) {
                e.b.a.r.n.c.d.b(eVar.f6093j);
                eVar.a(f.RawtextEndTagOpen);
            } else {
                eVar.f('<');
                eVar.f6088e = f.Rawtext;
            }
        }
    };
    public static final f RawtextEndTagOpen = new f("RawtextEndTagOpen", 14) { // from class: e.b.a.r.n.c.f.f
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$400(eVar, aVar, f.RawtextEndTagName, f.Rawtext);
        }
    };
    public static final f RawtextEndTagName = new f("RawtextEndTagName", 15) { // from class: e.b.a.r.n.c.f.g
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$500(eVar, aVar, f.Rawtext);
        }
    };
    public static final f ScriptDataLessthanSign = new f("ScriptDataLessthanSign", 16) { // from class: e.b.a.r.n.c.f.h
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '!') {
                eVar.h("<!");
                eVar.f6088e = f.ScriptDataEscapeStart;
            } else if (cD == '/') {
                e.b.a.r.n.c.d.b(eVar.f6093j);
                eVar.f6088e = f.ScriptDataEndTagOpen;
            } else {
                eVar.h("<");
                aVar.t();
                eVar.f6088e = f.ScriptData;
            }
        }
    };
    public static final f ScriptDataEndTagOpen = new f("ScriptDataEndTagOpen", 17) { // from class: e.b.a.r.n.c.f.i
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$400(eVar, aVar, f.ScriptDataEndTagName, f.ScriptData);
        }
    };
    public static final f ScriptDataEndTagName = new f("ScriptDataEndTagName", 18) { // from class: e.b.a.r.n.c.f.j
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$500(eVar, aVar, f.ScriptData);
        }
    };
    public static final f ScriptDataEscapeStart = new f("ScriptDataEscapeStart", 19) { // from class: e.b.a.r.n.c.f.l
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (!aVar.o('-')) {
                eVar.f6088e = f.ScriptData;
            } else {
                eVar.f('-');
                eVar.a(f.ScriptDataEscapeStartDash);
            }
        }
    };
    public static final f ScriptDataEscapeStartDash = new f("ScriptDataEscapeStartDash", 20) { // from class: e.b.a.r.n.c.f.m
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (!aVar.o('-')) {
                eVar.f6088e = f.ScriptData;
            } else {
                eVar.f('-');
                eVar.a(f.ScriptDataEscapedDashDash);
            }
        }
    };
    public static final f ScriptDataEscaped = new f("ScriptDataEscaped", 21) { // from class: e.b.a.r.n.c.f.n
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.k()) {
                eVar.j(this);
                eVar.f6088e = f.Data;
                return;
            }
            char cJ = aVar.j();
            if (cJ == 0) {
                eVar.k(this);
                aVar.a();
                eVar.f((char) 65533);
            } else if (cJ == '-') {
                eVar.f('-');
                eVar.a(f.ScriptDataEscapedDash);
            } else if (cJ != '<') {
                eVar.h(aVar.g('-', '<', 0));
            } else {
                eVar.a(f.ScriptDataEscapedLessthanSign);
            }
        }
    };
    public static final f ScriptDataEscapedDash = new f("ScriptDataEscapedDash", 22) { // from class: e.b.a.r.n.c.f.o
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.k()) {
                eVar.j(this);
                eVar.f6088e = f.Data;
                return;
            }
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f((char) 65533);
                eVar.f6088e = f.ScriptDataEscaped;
            } else if (cD == '-') {
                eVar.f(cD);
                eVar.f6088e = f.ScriptDataEscapedDashDash;
            } else if (cD == '<') {
                eVar.f6088e = f.ScriptDataEscapedLessthanSign;
            } else {
                eVar.f(cD);
                eVar.f6088e = f.ScriptDataEscaped;
            }
        }
    };
    public static final f ScriptDataEscapedDashDash = new f("ScriptDataEscapedDashDash", 23) { // from class: e.b.a.r.n.c.f.p
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.k()) {
                eVar.j(this);
                eVar.f6088e = f.Data;
                return;
            }
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f((char) 65533);
                eVar.f6088e = f.ScriptDataEscaped;
            } else {
                if (cD == '-') {
                    eVar.f(cD);
                    return;
                }
                if (cD == '<') {
                    eVar.f6088e = f.ScriptDataEscapedLessthanSign;
                } else if (cD != '>') {
                    eVar.f(cD);
                    eVar.f6088e = f.ScriptDataEscaped;
                } else {
                    eVar.f(cD);
                    eVar.f6088e = f.ScriptData;
                }
            }
        }
    };
    public static final f ScriptDataEscapedLessthanSign = new f("ScriptDataEscapedLessthanSign", 24) { // from class: e.b.a.r.n.c.f.q
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (!aVar.q()) {
                if (aVar.o(Attributes.InternalPrefix)) {
                    e.b.a.r.n.c.d.b(eVar.f6093j);
                    eVar.a(f.ScriptDataEscapedEndTagOpen);
                    return;
                } else {
                    eVar.f('<');
                    eVar.f6088e = f.ScriptDataEscaped;
                    return;
                }
            }
            e.b.a.r.n.c.d.b(eVar.f6093j);
            eVar.f6093j.append(aVar.j());
            eVar.h("<" + aVar.j());
            eVar.a(f.ScriptDataDoubleEscapeStart);
        }
    };
    public static final f ScriptDataEscapedEndTagOpen = new f("ScriptDataEscapedEndTagOpen", 25) { // from class: e.b.a.r.n.c.f.r
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (!aVar.q()) {
                eVar.h("</");
                eVar.f6088e = f.ScriptDataEscaped;
            } else {
                eVar.e(false);
                eVar.f6094k.g(aVar.j());
                eVar.f6093j.append(aVar.j());
                eVar.a(f.ScriptDataEscapedEndTagName);
            }
        }
    };
    public static final f ScriptDataEscapedEndTagName = new f("ScriptDataEscapedEndTagName", 26) { // from class: e.b.a.r.n.c.f.s
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$500(eVar, aVar, f.ScriptDataEscaped);
        }
    };
    public static final f ScriptDataDoubleEscapeStart = new f("ScriptDataDoubleEscapeStart", 27) { // from class: e.b.a.r.n.c.f.t
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$600(eVar, aVar, f.ScriptDataDoubleEscaped, f.ScriptDataEscaped);
        }
    };
    public static final f ScriptDataDoubleEscaped = new f("ScriptDataDoubleEscaped", 28) { // from class: e.b.a.r.n.c.f.u
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cJ = aVar.j();
            if (cJ == 0) {
                eVar.k(this);
                aVar.a();
                eVar.f((char) 65533);
            } else if (cJ == '-') {
                eVar.f(cJ);
                eVar.a(f.ScriptDataDoubleEscapedDash);
            } else if (cJ == '<') {
                eVar.f(cJ);
                eVar.a(f.ScriptDataDoubleEscapedLessthanSign);
            } else if (cJ != 65535) {
                eVar.h(aVar.g('-', '<', 0));
            } else {
                eVar.j(this);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f ScriptDataDoubleEscapedDash = new f("ScriptDataDoubleEscapedDash", 29) { // from class: e.b.a.r.n.c.f.w
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f((char) 65533);
                eVar.f6088e = f.ScriptDataDoubleEscaped;
            } else if (cD == '-') {
                eVar.f(cD);
                eVar.f6088e = f.ScriptDataDoubleEscapedDashDash;
            } else if (cD == '<') {
                eVar.f(cD);
                eVar.f6088e = f.ScriptDataDoubleEscapedLessthanSign;
            } else if (cD != 65535) {
                eVar.f(cD);
                eVar.f6088e = f.ScriptDataDoubleEscaped;
            } else {
                eVar.j(this);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f ScriptDataDoubleEscapedDashDash = new f("ScriptDataDoubleEscapedDashDash", 30) { // from class: e.b.a.r.n.c.f.x
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f((char) 65533);
                eVar.f6088e = f.ScriptDataDoubleEscaped;
                return;
            }
            if (cD == '-') {
                eVar.f(cD);
                return;
            }
            if (cD == '<') {
                eVar.f(cD);
                eVar.f6088e = f.ScriptDataDoubleEscapedLessthanSign;
            } else if (cD == '>') {
                eVar.f(cD);
                eVar.f6088e = f.ScriptData;
            } else if (cD != 65535) {
                eVar.f(cD);
                eVar.f6088e = f.ScriptDataDoubleEscaped;
            } else {
                eVar.j(this);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f ScriptDataDoubleEscapedLessthanSign = new f("ScriptDataDoubleEscapedLessthanSign", 31) { // from class: e.b.a.r.n.c.f.y
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (!aVar.o(Attributes.InternalPrefix)) {
                eVar.f6088e = f.ScriptDataDoubleEscaped;
                return;
            }
            eVar.f(Attributes.InternalPrefix);
            e.b.a.r.n.c.d.b(eVar.f6093j);
            eVar.a(f.ScriptDataDoubleEscapeEnd);
        }
    };
    public static final f ScriptDataDoubleEscapeEnd = new f("ScriptDataDoubleEscapeEnd", 32) { // from class: e.b.a.r.n.c.f.z
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            f.access$600(eVar, aVar, f.ScriptDataEscaped, f.ScriptDataDoubleEscaped);
        }
    };
    public static final f BeforeAttributeName = new f("BeforeAttributeName", 33) { // from class: e.b.a.r.n.c.f.a0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f6094k.k();
                aVar.t();
                eVar.f6088e = f.AttributeName;
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '\'') {
                    if (cD == '/') {
                        eVar.f6088e = f.SelfClosingStartTag;
                        return;
                    }
                    if (cD == 65535) {
                        eVar.j(this);
                        eVar.f6088e = f.Data;
                        return;
                    }
                    if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                        return;
                    }
                    switch (cD) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            eVar.i();
                            eVar.f6088e = f.Data;
                            break;
                        default:
                            eVar.f6094k.k();
                            aVar.t();
                            eVar.f6088e = f.AttributeName;
                            break;
                    }
                    return;
                }
                eVar.k(this);
                eVar.f6094k.k();
                eVar.f6094k.c(cD);
                eVar.f6088e = f.AttributeName;
            }
        }
    };
    public static final f AttributeName = new f("AttributeName", 34) { // from class: e.b.a.r.n.c.f.b0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            String strH = aVar.h(f.attributeNameCharsSorted);
            d.h hVar = eVar.f6094k;
            String str = hVar.f6078d;
            if (str != null) {
                strH = str.concat(strH);
            }
            hVar.f6078d = strH;
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f6094k.c((char) 65533);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '\'') {
                    if (cD == '/') {
                        eVar.f6088e = f.SelfClosingStartTag;
                        return;
                    }
                    if (cD == 65535) {
                        eVar.j(this);
                        eVar.f6088e = f.Data;
                        return;
                    }
                    if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                        switch (cD) {
                            case '<':
                                break;
                            case '=':
                                eVar.f6088e = f.BeforeAttributeValue;
                                break;
                            case '>':
                                eVar.i();
                                eVar.f6088e = f.Data;
                                break;
                            default:
                                eVar.f6094k.c(cD);
                                break;
                        }
                        return;
                    }
                }
                eVar.k(this);
                eVar.f6094k.c(cD);
                return;
            }
            eVar.f6088e = f.AfterAttributeName;
        }
    };
    public static final f AfterAttributeName = new f("AfterAttributeName", 35) { // from class: e.b.a.r.n.c.f.c0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f6094k.c((char) 65533);
                eVar.f6088e = f.AttributeName;
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '\'') {
                    if (cD == '/') {
                        eVar.f6088e = f.SelfClosingStartTag;
                        return;
                    }
                    if (cD == 65535) {
                        eVar.j(this);
                        eVar.f6088e = f.Data;
                        return;
                    }
                    if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                        return;
                    }
                    switch (cD) {
                        case '<':
                            break;
                        case '=':
                            eVar.f6088e = f.BeforeAttributeValue;
                            break;
                        case '>':
                            eVar.i();
                            eVar.f6088e = f.Data;
                            break;
                        default:
                            eVar.f6094k.k();
                            aVar.t();
                            eVar.f6088e = f.AttributeName;
                            break;
                    }
                    return;
                }
                eVar.k(this);
                eVar.f6094k.k();
                eVar.f6094k.c(cD);
                eVar.f6088e = f.AttributeName;
            }
        }
    };
    public static final f BeforeAttributeValue = new f("BeforeAttributeValue", 36) { // from class: e.b.a.r.n.c.f.d0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f6094k.d((char) 65533);
                eVar.f6088e = f.AttributeValue_unquoted;
                return;
            }
            if (cD != ' ') {
                if (cD == '\"') {
                    eVar.f6088e = f.AttributeValue_doubleQuoted;
                    return;
                }
                if (cD != '`') {
                    if (cD == 65535) {
                        eVar.j(this);
                        eVar.i();
                        eVar.f6088e = f.Data;
                        return;
                    }
                    if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                        return;
                    }
                    if (cD == '&') {
                        aVar.t();
                        eVar.f6088e = f.AttributeValue_unquoted;
                        return;
                    }
                    if (cD == '\'') {
                        eVar.f6088e = f.AttributeValue_singleQuoted;
                        return;
                    }
                    switch (cD) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            eVar.k(this);
                            eVar.i();
                            eVar.f6088e = f.Data;
                            break;
                        default:
                            aVar.t();
                            eVar.f6088e = f.AttributeValue_unquoted;
                            break;
                    }
                    return;
                }
                eVar.k(this);
                eVar.f6094k.d(cD);
                eVar.f6088e = f.AttributeValue_unquoted;
            }
        }
    };
    public static final f AttributeValue_doubleQuoted = new f("AttributeValue_doubleQuoted", 37) { // from class: e.b.a.r.n.c.f.e0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            String strG = aVar.g(f.attributeDoubleValueCharsSorted);
            if (strG.length() > 0) {
                eVar.f6094k.e(strG);
            } else {
                eVar.f6094k.f6081g = true;
            }
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f6094k.d((char) 65533);
                return;
            }
            if (cD == '\"') {
                eVar.f6088e = f.AfterAttributeValue_quoted;
                return;
            }
            if (cD != '&') {
                if (cD != 65535) {
                    eVar.f6094k.d(cD);
                    return;
                } else {
                    eVar.j(this);
                    eVar.f6088e = f.Data;
                    return;
                }
            }
            int[] iArrC = eVar.c('\"', true);
            if (iArrC != null) {
                eVar.f6094k.f(iArrC);
            } else {
                eVar.f6094k.d('&');
            }
        }
    };
    public static final f AttributeValue_singleQuoted = new f("AttributeValue_singleQuoted", 38) { // from class: e.b.a.r.n.c.f.f0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            String strG = aVar.g(f.attributeSingleValueCharsSorted);
            if (strG.length() > 0) {
                eVar.f6094k.e(strG);
            } else {
                eVar.f6094k.f6081g = true;
            }
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f6094k.d((char) 65533);
                return;
            }
            if (cD == 65535) {
                eVar.j(this);
                eVar.f6088e = f.Data;
                return;
            }
            if (cD != '&') {
                if (cD != '\'') {
                    eVar.f6094k.d(cD);
                    return;
                } else {
                    eVar.f6088e = f.AfterAttributeValue_quoted;
                    return;
                }
            }
            int[] iArrC = eVar.c('\'', true);
            if (iArrC != null) {
                eVar.f6094k.f(iArrC);
            } else {
                eVar.f6094k.d('&');
            }
        }
    };
    public static final f AttributeValue_unquoted = new f("AttributeValue_unquoted", 39) { // from class: e.b.a.r.n.c.f.h0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            String strH = aVar.h(f.attributeValueUnquoted);
            if (strH.length() > 0) {
                eVar.f6094k.e(strH);
            }
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.f6094k.d((char) 65533);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '`') {
                    if (cD == 65535) {
                        eVar.j(this);
                        eVar.f6088e = f.Data;
                        return;
                    }
                    if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                        if (cD == '&') {
                            int[] iArrC = eVar.c('>', true);
                            if (iArrC != null) {
                                eVar.f6094k.f(iArrC);
                                return;
                            } else {
                                eVar.f6094k.d('&');
                                return;
                            }
                        }
                        if (cD != '\'') {
                            switch (cD) {
                                case '<':
                                case '=':
                                    break;
                                case '>':
                                    eVar.i();
                                    eVar.f6088e = f.Data;
                                    break;
                                default:
                                    eVar.f6094k.d(cD);
                                    break;
                            }
                            return;
                        }
                    }
                }
                eVar.k(this);
                eVar.f6094k.d(cD);
                return;
            }
            eVar.f6088e = f.BeforeAttributeName;
        }
    };
    public static final f AfterAttributeValue_quoted = new f("AfterAttributeValue_quoted", 40) { // from class: e.b.a.r.n.c.f.i0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                eVar.f6088e = f.BeforeAttributeName;
                return;
            }
            if (cD == '/') {
                eVar.f6088e = f.SelfClosingStartTag;
                return;
            }
            if (cD == '>') {
                eVar.i();
                eVar.f6088e = f.Data;
            } else if (cD == 65535) {
                eVar.j(this);
                eVar.f6088e = f.Data;
            } else {
                eVar.k(this);
                aVar.t();
                eVar.f6088e = f.BeforeAttributeName;
            }
        }
    };
    public static final f SelfClosingStartTag = new f("SelfClosingStartTag", 41) { // from class: e.b.a.r.n.c.f.j0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '>') {
                eVar.f6094k.f6083i = true;
                eVar.i();
                eVar.f6088e = f.Data;
            } else if (cD == 65535) {
                eVar.j(this);
                eVar.f6088e = f.Data;
            } else {
                eVar.k(this);
                aVar.t();
                eVar.f6088e = f.BeforeAttributeName;
            }
        }
    };
    public static final f BogusComment = new f("BogusComment", 42) { // from class: e.b.a.r.n.c.f.k0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            aVar.t();
            d.c cVar = new d.c();
            cVar.f6072b.append(aVar.f('>'));
            eVar.g(cVar);
            eVar.a(f.Data);
        }
    };
    public static final f MarkupDeclarationOpen = new f("MarkupDeclarationOpen", 43) { // from class: e.b.a.r.n.c.f.l0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.m("--")) {
                e.b.a.r.n.c.d.b(eVar.p.f6072b);
                eVar.f6088e = f.CommentStart;
            } else if (aVar.n("DOCTYPE")) {
                eVar.f6088e = f.Doctype;
            } else if (aVar.m("[CDATA[")) {
                e.b.a.r.n.c.d.b(eVar.f6093j);
                eVar.f6088e = f.CdataSection;
            } else {
                eVar.k(this);
                eVar.a(f.BogusComment);
            }
        }
    };
    public static final f CommentStart = new f("CommentStart", 44) { // from class: e.b.a.r.n.c.f.m0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.p.f6072b.append((char) 65533);
                eVar.f6088e = f.Comment;
                return;
            }
            if (cD == '-') {
                eVar.f6088e = f.CommentStartDash;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            } else if (cD != 65535) {
                eVar.p.f6072b.append(cD);
                eVar.f6088e = f.Comment;
            } else {
                eVar.j(this);
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f CommentStartDash = new f("CommentStartDash", 45) { // from class: e.b.a.r.n.c.f.n0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.p.f6072b.append((char) 65533);
                eVar.f6088e = f.Comment;
                return;
            }
            if (cD == '-') {
                eVar.f6088e = f.CommentStartDash;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            } else if (cD != 65535) {
                eVar.p.f6072b.append(cD);
                eVar.f6088e = f.Comment;
            } else {
                eVar.j(this);
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f Comment = new f("Comment", 46) { // from class: e.b.a.r.n.c.f.o0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cJ = aVar.j();
            if (cJ == 0) {
                eVar.k(this);
                aVar.a();
                eVar.p.f6072b.append((char) 65533);
            } else if (cJ == '-') {
                eVar.a(f.CommentEndDash);
            } else {
                if (cJ != 65535) {
                    eVar.p.f6072b.append(aVar.g('-', 0));
                    return;
                }
                eVar.j(this);
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f CommentEndDash = new f("CommentEndDash", 47) { // from class: e.b.a.r.n.c.f.p0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                StringBuilder sb = eVar.p.f6072b;
                sb.append('-');
                sb.append((char) 65533);
                eVar.f6088e = f.Comment;
                return;
            }
            if (cD == '-') {
                eVar.f6088e = f.CommentEnd;
                return;
            }
            if (cD == 65535) {
                eVar.j(this);
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            } else {
                StringBuilder sb2 = eVar.p.f6072b;
                sb2.append('-');
                sb2.append(cD);
                eVar.f6088e = f.Comment;
            }
        }
    };
    public static final f CommentEnd = new f("CommentEnd", 48) { // from class: e.b.a.r.n.c.f.q0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                StringBuilder sb = eVar.p.f6072b;
                sb.append("--");
                sb.append((char) 65533);
                eVar.f6088e = f.Comment;
                return;
            }
            if (cD == '!') {
                eVar.k(this);
                eVar.f6088e = f.CommentEndBang;
                return;
            }
            if (cD == '-') {
                eVar.k(this);
                eVar.p.f6072b.append('-');
                return;
            }
            if (cD == '>') {
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            } else if (cD == 65535) {
                eVar.j(this);
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            } else {
                eVar.k(this);
                StringBuilder sb2 = eVar.p.f6072b;
                sb2.append("--");
                sb2.append(cD);
                eVar.f6088e = f.Comment;
            }
        }
    };
    public static final f CommentEndBang = new f("CommentEndBang", 49) { // from class: e.b.a.r.n.c.f.s0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                StringBuilder sb = eVar.p.f6072b;
                sb.append("--!");
                sb.append((char) 65533);
                eVar.f6088e = f.Comment;
                return;
            }
            if (cD == '-') {
                eVar.p.f6072b.append("--!");
                eVar.f6088e = f.CommentEndDash;
                return;
            }
            if (cD == '>') {
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            } else if (cD == 65535) {
                eVar.j(this);
                eVar.g(eVar.p);
                eVar.f6088e = f.Data;
            } else {
                StringBuilder sb2 = eVar.p.f6072b;
                sb2.append("--!");
                sb2.append(cD);
                eVar.f6088e = f.Comment;
            }
        }
    };
    public static final f Doctype = new f("Doctype", 50) { // from class: e.b.a.r.n.c.f.t0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                eVar.f6088e = f.BeforeDoctypeName;
                return;
            }
            if (cD != '>') {
                if (cD != 65535) {
                    eVar.k(this);
                    eVar.f6088e = f.BeforeDoctypeName;
                    return;
                }
                eVar.j(this);
            }
            eVar.k(this);
            eVar.d();
            Objects.requireNonNull(eVar.o);
            eVar.g(eVar.o);
            eVar.f6088e = f.Data;
        }
    };
    public static final f BeforeDoctypeName = new f("BeforeDoctypeName", 51) { // from class: e.b.a.r.n.c.f.u0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.q()) {
                eVar.d();
                eVar.f6088e = f.DoctypeName;
                return;
            }
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.d();
                eVar.o.f6073b.append((char) 65533);
                eVar.f6088e = f.DoctypeName;
                return;
            }
            if (cD != ' ') {
                if (cD == 65535) {
                    eVar.j(this);
                    eVar.d();
                    Objects.requireNonNull(eVar.o);
                    eVar.g(eVar.o);
                    eVar.f6088e = f.Data;
                    return;
                }
                if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                    return;
                }
                eVar.d();
                eVar.o.f6073b.append(cD);
                eVar.f6088e = f.DoctypeName;
            }
        }
    };
    public static final f DoctypeName = new f("DoctypeName", 52) { // from class: e.b.a.r.n.c.f.v0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.q()) {
                eVar.o.f6073b.append(aVar.e());
                return;
            }
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.o.f6073b.append((char) 65533);
                return;
            }
            if (cD != ' ') {
                if (cD == '>') {
                    eVar.g(eVar.o);
                    eVar.f6088e = f.Data;
                    return;
                }
                if (cD == 65535) {
                    eVar.j(this);
                    Objects.requireNonNull(eVar.o);
                    eVar.g(eVar.o);
                    eVar.f6088e = f.Data;
                    return;
                }
                if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                    eVar.o.f6073b.append(cD);
                    return;
                }
            }
            eVar.f6088e = f.AfterDoctypeName;
        }
    };
    public static final f AfterDoctypeName = new f("AfterDoctypeName", 53) { // from class: e.b.a.r.n.c.f.w0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            if (aVar.k()) {
                eVar.j(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
                return;
            }
            if (aVar.p('\t', '\n', '\r', '\f', ' ')) {
                aVar.a();
                return;
            }
            if (aVar.o('>')) {
                eVar.g(eVar.o);
                eVar.a(f.Data);
                return;
            }
            if (aVar.n(DocumentType.PUBLIC_KEY)) {
                Objects.requireNonNull(eVar.o);
                eVar.f6088e = f.AfterDoctypePublicKeyword;
            } else if (aVar.n(DocumentType.SYSTEM_KEY)) {
                Objects.requireNonNull(eVar.o);
                eVar.f6088e = f.AfterDoctypeSystemKeyword;
            } else {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.a(f.BogusDoctype);
            }
        }
    };
    public static final f AfterDoctypePublicKeyword = new f("AfterDoctypePublicKeyword", 54) { // from class: e.b.a.r.n.c.f.x0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                eVar.f6088e = f.BeforeDoctypePublicIdentifier;
                return;
            }
            if (cD == '\"') {
                eVar.k(this);
                eVar.f6088e = f.DoctypePublicIdentifier_doubleQuoted;
                return;
            }
            if (cD == '\'') {
                eVar.k(this);
                eVar.f6088e = f.DoctypePublicIdentifier_singleQuoted;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
                return;
            }
            if (cD != 65535) {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.f6088e = f.BogusDoctype;
            } else {
                eVar.j(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f BeforeDoctypePublicIdentifier = new f("BeforeDoctypePublicIdentifier", 55) { // from class: e.b.a.r.n.c.f.y0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '\"') {
                eVar.f6088e = f.DoctypePublicIdentifier_doubleQuoted;
                return;
            }
            if (cD == '\'') {
                eVar.f6088e = f.DoctypePublicIdentifier_singleQuoted;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
                return;
            }
            if (cD != 65535) {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.f6088e = f.BogusDoctype;
            } else {
                eVar.j(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f DoctypePublicIdentifier_doubleQuoted = new f("DoctypePublicIdentifier_doubleQuoted", 56) { // from class: e.b.a.r.n.c.f.z0
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.o.f6074c.append((char) 65533);
                return;
            }
            if (cD == '\"') {
                eVar.f6088e = f.AfterDoctypePublicIdentifier;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
                return;
            }
            if (cD != 65535) {
                eVar.o.f6074c.append(cD);
                return;
            }
            eVar.j(this);
            Objects.requireNonNull(eVar.o);
            eVar.g(eVar.o);
            eVar.f6088e = f.Data;
        }
    };
    public static final f DoctypePublicIdentifier_singleQuoted = new f("DoctypePublicIdentifier_singleQuoted", 57) { // from class: e.b.a.r.n.c.f.a1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.o.f6074c.append((char) 65533);
                return;
            }
            if (cD == '\'') {
                eVar.f6088e = f.AfterDoctypePublicIdentifier;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
                return;
            }
            if (cD != 65535) {
                eVar.o.f6074c.append(cD);
                return;
            }
            eVar.j(this);
            Objects.requireNonNull(eVar.o);
            eVar.g(eVar.o);
            eVar.f6088e = f.Data;
        }
    };
    public static final f AfterDoctypePublicIdentifier = new f("AfterDoctypePublicIdentifier", 58) { // from class: e.b.a.r.n.c.f.b1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                eVar.f6088e = f.BetweenDoctypePublicAndSystemIdentifiers;
                return;
            }
            if (cD == '\"') {
                eVar.k(this);
                eVar.f6088e = f.DoctypeSystemIdentifier_doubleQuoted;
                return;
            }
            if (cD == '\'') {
                eVar.k(this);
                eVar.f6088e = f.DoctypeSystemIdentifier_singleQuoted;
                return;
            }
            if (cD == '>') {
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            } else if (cD != 65535) {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.f6088e = f.BogusDoctype;
            } else {
                eVar.j(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f BetweenDoctypePublicAndSystemIdentifiers = new f("BetweenDoctypePublicAndSystemIdentifiers", 59) { // from class: e.b.a.r.n.c.f.d1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '\"') {
                eVar.k(this);
                eVar.f6088e = f.DoctypeSystemIdentifier_doubleQuoted;
                return;
            }
            if (cD == '\'') {
                eVar.k(this);
                eVar.f6088e = f.DoctypeSystemIdentifier_singleQuoted;
                return;
            }
            if (cD == '>') {
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            } else if (cD != 65535) {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.f6088e = f.BogusDoctype;
            } else {
                eVar.j(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f AfterDoctypeSystemKeyword = new f("AfterDoctypeSystemKeyword", 60) { // from class: e.b.a.r.n.c.f.e1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                eVar.f6088e = f.BeforeDoctypeSystemIdentifier;
                return;
            }
            if (cD == '\"') {
                eVar.k(this);
                eVar.f6088e = f.DoctypeSystemIdentifier_doubleQuoted;
                return;
            }
            if (cD == '\'') {
                eVar.k(this);
                eVar.f6088e = f.DoctypeSystemIdentifier_singleQuoted;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
                return;
            }
            if (cD != 65535) {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
            } else {
                eVar.j(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f BeforeDoctypeSystemIdentifier = new f("BeforeDoctypeSystemIdentifier", 61) { // from class: e.b.a.r.n.c.f.f1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '\"') {
                eVar.f6088e = f.DoctypeSystemIdentifier_doubleQuoted;
                return;
            }
            if (cD == '\'') {
                eVar.f6088e = f.DoctypeSystemIdentifier_singleQuoted;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
                return;
            }
            if (cD != 65535) {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.f6088e = f.BogusDoctype;
            } else {
                eVar.j(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f DoctypeSystemIdentifier_doubleQuoted = new f("DoctypeSystemIdentifier_doubleQuoted", 62) { // from class: e.b.a.r.n.c.f.g1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.o.f6075d.append((char) 65533);
                return;
            }
            if (cD == '\"') {
                eVar.f6088e = f.AfterDoctypeSystemIdentifier;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
                return;
            }
            if (cD != 65535) {
                eVar.o.f6075d.append(cD);
                return;
            }
            eVar.j(this);
            Objects.requireNonNull(eVar.o);
            eVar.g(eVar.o);
            eVar.f6088e = f.Data;
        }
    };
    public static final f DoctypeSystemIdentifier_singleQuoted = new f("DoctypeSystemIdentifier_singleQuoted", 63) { // from class: e.b.a.r.n.c.f.h1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == 0) {
                eVar.k(this);
                eVar.o.f6075d.append((char) 65533);
                return;
            }
            if (cD == '\'') {
                eVar.f6088e = f.AfterDoctypeSystemIdentifier;
                return;
            }
            if (cD == '>') {
                eVar.k(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
                return;
            }
            if (cD != 65535) {
                eVar.o.f6075d.append(cD);
                return;
            }
            eVar.j(this);
            Objects.requireNonNull(eVar.o);
            eVar.g(eVar.o);
            eVar.f6088e = f.Data;
        }
    };
    public static final f AfterDoctypeSystemIdentifier = new f("AfterDoctypeSystemIdentifier", 64) { // from class: e.b.a.r.n.c.f.i1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '>') {
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            } else if (cD != 65535) {
                eVar.k(this);
                eVar.f6088e = f.BogusDoctype;
            } else {
                eVar.j(this);
                Objects.requireNonNull(eVar.o);
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f BogusDoctype = new f("BogusDoctype", 65) { // from class: e.b.a.r.n.c.f.j1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            char cD = aVar.d();
            if (cD == '>') {
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            } else {
                if (cD != 65535) {
                    return;
                }
                eVar.g(eVar.o);
                eVar.f6088e = f.Data;
            }
        }
    };
    public static final f CdataSection = new f("CdataSection", 66) { // from class: e.b.a.r.n.c.f.k1
        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            String strI;
            int iR = aVar.r("]]>");
            if (iR != -1) {
                strI = e.b.a.r.n.c.a.c(aVar.a, aVar.f6069h, aVar.f6066e, iR);
                aVar.f6066e += iR;
            } else {
                strI = aVar.i();
            }
            eVar.f6093j.append(strI);
            if (aVar.m("]]>") || aVar.k()) {
                eVar.g(new d.a(eVar.f6093j.toString()));
                eVar.f6088e = f.Data;
            }
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ f[] f6096b = {Data, CharacterReferenceInData, Rcdata, CharacterReferenceInRcdata, Rawtext, ScriptData, PLAINTEXT, TagOpen, EndTagOpen, TagName, RcdataLessthanSign, RCDATAEndTagOpen, RCDATAEndTagName, RawtextLessthanSign, RawtextEndTagOpen, RawtextEndTagName, ScriptDataLessthanSign, ScriptDataEndTagOpen, ScriptDataEndTagName, ScriptDataEscapeStart, ScriptDataEscapeStartDash, ScriptDataEscaped, ScriptDataEscapedDash, ScriptDataEscapedDashDash, ScriptDataEscapedLessthanSign, ScriptDataEscapedEndTagOpen, ScriptDataEscapedEndTagName, ScriptDataDoubleEscapeStart, ScriptDataDoubleEscaped, ScriptDataDoubleEscapedDash, ScriptDataDoubleEscapedDashDash, ScriptDataDoubleEscapedLessthanSign, ScriptDataDoubleEscapeEnd, BeforeAttributeName, AttributeName, AfterAttributeName, BeforeAttributeValue, AttributeValue_doubleQuoted, AttributeValue_singleQuoted, AttributeValue_unquoted, AfterAttributeValue_quoted, SelfClosingStartTag, BogusComment, MarkupDeclarationOpen, CommentStart, CommentStartDash, Comment, CommentEndDash, CommentEnd, CommentEndBang, Doctype, BeforeDoctypeName, DoctypeName, AfterDoctypeName, AfterDoctypePublicKeyword, BeforeDoctypePublicIdentifier, DoctypePublicIdentifier_doubleQuoted, DoctypePublicIdentifier_singleQuoted, AfterDoctypePublicIdentifier, BetweenDoctypePublicAndSystemIdentifiers, AfterDoctypeSystemKeyword, BeforeDoctypeSystemIdentifier, DoctypeSystemIdentifier_doubleQuoted, DoctypeSystemIdentifier_singleQuoted, AfterDoctypeSystemIdentifier, BogusDoctype, CdataSection};
    public static final char[] attributeSingleValueCharsSorted = {0, '&', '\''};
    public static final char[] attributeDoubleValueCharsSorted = {0, '\"', '&'};
    public static final char[] attributeNameCharsSorted = {0, '\t', '\n', '\f', '\r', ' ', '\"', '\'', Attributes.InternalPrefix, '<', '=', '>'};
    public static final char[] attributeValueUnquoted = {0, '\t', '\n', '\f', '\r', ' ', '\"', '&', '\'', '<', '=', '>', '`'};
    public static final String a = String.valueOf((char) 65533);

    /* JADX INFO: compiled from: TokeniserState.java */
    public enum k extends f {
        public k(String str, int i2) {
            super(str, i2, null);
        }

        @Override // e.b.a.r.n.c.f
        public void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar) {
            int i2;
            char c2;
            char cJ = aVar.j();
            if (cJ == 0) {
                eVar.k(this);
                eVar.f(aVar.d());
                return;
            }
            if (cJ == '&') {
                eVar.a(f.CharacterReferenceInData);
                return;
            }
            if (cJ == '<') {
                eVar.a(f.TagOpen);
                return;
            }
            if (cJ == 65535) {
                eVar.g(new d.e());
                return;
            }
            aVar.b();
            int i3 = aVar.f6066e;
            int i4 = aVar.f6064c;
            char[] cArr = aVar.a;
            while (true) {
                i2 = aVar.f6066e;
                if (i2 >= i4 || (c2 = cArr[i2]) == '&' || c2 == '<' || c2 == 0) {
                    break;
                } else {
                    aVar.f6066e = i2 + 1;
                }
            }
            eVar.h(i2 > i3 ? e.b.a.r.n.c.a.c(aVar.a, aVar.f6069h, i3, i2 - i3) : "");
        }
    }

    public f(String str, int i2, k kVar) {
    }

    public static void access$100(e.b.a.r.n.c.e eVar, f fVar) {
        int[] iArrC = eVar.c(null, false);
        if (iArrC == null) {
            eVar.f('&');
        } else {
            eVar.h(new String(iArrC, 0, iArrC.length));
        }
        eVar.f6088e = fVar;
    }

    public static void access$200(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar, f fVar, f fVar2) {
        char cJ = aVar.j();
        if (cJ == 0) {
            eVar.k(fVar);
            aVar.a();
            eVar.f((char) 65533);
        } else if (cJ == '<') {
            eVar.f6086c.a();
            eVar.f6088e = fVar2;
        } else if (cJ != 65535) {
            eVar.h(aVar.g('<', 0));
        } else {
            eVar.g(new d.e());
        }
    }

    public static void access$400(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar, f fVar, f fVar2) {
        if (aVar.q()) {
            eVar.e(false);
            eVar.f6088e = fVar;
        } else {
            eVar.h("</");
            eVar.f6088e = fVar2;
        }
    }

    public static void access$500(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar, f fVar) {
        if (aVar.q()) {
            String strE = aVar.e();
            eVar.f6094k.h(strE);
            eVar.f6093j.append(strE);
            return;
        }
        boolean z2 = false;
        boolean z3 = true;
        if (eVar.l() && !aVar.k()) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                eVar.f6088e = BeforeAttributeName;
            } else if (cD == '/') {
                eVar.f6088e = SelfClosingStartTag;
            } else if (cD != '>') {
                eVar.f6093j.append(cD);
                z2 = true;
            } else {
                eVar.i();
                eVar.f6088e = Data;
            }
            z3 = z2;
        }
        if (z3) {
            StringBuilder sbR = c.a.a.a.a.r("</");
            sbR.append(eVar.f6093j.toString());
            eVar.h(sbR.toString());
            eVar.f6088e = fVar;
        }
    }

    public static void access$600(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar, f fVar, f fVar2) {
        if (aVar.q()) {
            String strE = aVar.e();
            eVar.f6093j.append(strE);
            eVar.h(strE);
            return;
        }
        char cD = aVar.d();
        if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r' && cD != ' ' && cD != '/' && cD != '>') {
            aVar.t();
            eVar.f6088e = fVar2;
        } else {
            if (eVar.f6093j.toString().equals("script")) {
                eVar.f6088e = fVar;
            } else {
                eVar.f6088e = fVar2;
            }
            eVar.f(cD);
        }
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f6096b.clone();
    }

    public abstract void read(e.b.a.r.n.c.e eVar, e.b.a.r.n.c.a aVar);
}
