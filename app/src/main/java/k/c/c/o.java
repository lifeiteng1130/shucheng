package k.c.c;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: LinkReferenceDefinitionParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f8693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f8696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public StringBuilder f8697h;
    public a a = a.START_DEFINITION;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f8691b = new StringBuilder();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<k.c.d.p> f8692c = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8698i = false;

    /* JADX INFO: compiled from: LinkReferenceDefinitionParser.java */
    public enum a {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    public final void a() {
        if (this.f8698i) {
            String strB = k.c.c.v.a.b(this.f8695f);
            StringBuilder sb = this.f8697h;
            this.f8692c.add(new k.c.d.p(this.f8694e, strB, sb != null ? k.c.c.v.a.b(sb.toString()) : null));
            this.f8693d = null;
            this.f8698i = false;
            this.f8694e = null;
            this.f8695f = null;
            this.f8697h = null;
        }
    }
}
