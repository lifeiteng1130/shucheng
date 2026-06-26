package k.c.c;

import java.util.regex.Pattern;
import k.c.c.h;
import k.c.d.u;

/* JADX INFO: compiled from: HtmlBlockParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class k extends k.c.e.g.a {
    public static final Pattern[][] a = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pattern f8673c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k.c.d.k f8672b = new k.c.d.k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8674d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k.c.c.a f8675e = new k.c.c.a();

    /* JADX INFO: compiled from: HtmlBlockParser.java */
    public static class b extends k.c.e.g.b {
        @Override // k.c.e.g.d
        public d a(k.c.e.g.f fVar, k.c.e.g.e eVar) {
            h hVar = (h) fVar;
            int i2 = hVar.f8663g;
            CharSequence charSequence = hVar.f8659c;
            if (hVar.f8665i < 4 && charSequence.charAt(i2) == '<') {
                for (int i3 = 1; i3 <= 7; i3++) {
                    if (i3 != 7 || !(((h.a) eVar).a.g() instanceof u)) {
                        Pattern[][] patternArr = k.a;
                        Pattern pattern = patternArr[i3][0];
                        Pattern pattern2 = patternArr[i3][1];
                        if (pattern.matcher(charSequence.subSequence(i2, charSequence.length())).find()) {
                            d dVar = new d(new k(pattern2, null));
                            dVar.f8642b = hVar.f8660d;
                            return dVar;
                        }
                    }
                }
            }
            return null;
        }
    }

    public k(Pattern pattern, a aVar) {
        this.f8673c = pattern;
    }

    @Override // k.c.e.g.c
    public k.c.c.b c(k.c.e.g.f fVar) {
        if (this.f8674d) {
            return null;
        }
        if (((h) fVar).f8666j && this.f8673c == null) {
            return null;
        }
        return k.c.c.b.b(((h) fVar).f8660d);
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public void e() {
        this.f8672b.f8721f = this.f8675e.a.toString();
        this.f8675e = null;
    }

    @Override // k.c.e.g.c
    public k.c.d.a g() {
        return this.f8672b;
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public void h(CharSequence charSequence) {
        k.c.c.a aVar = this.f8675e;
        if (aVar.f8639b != 0) {
            aVar.a.append('\n');
        }
        aVar.a.append(charSequence);
        aVar.f8639b++;
        Pattern pattern = this.f8673c;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.f8674d = true;
    }
}
