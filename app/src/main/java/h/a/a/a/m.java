package h.a.a.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MediaTypes.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {
    public static final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f6305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f6306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f6307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f6308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f6309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f6310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f6311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l f6312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l f6313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l f6314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l f6315l;
    public static final l m;
    public static final l n;
    public static final l o;
    public static final l p;
    public static final l q;
    public static final l r;
    public static final l[] s;
    public static final Map<String, l> t;

    static {
        l lVar = new l("application/xhtml+xml", ".xhtml", new String[]{".htm", ".html", ".xhtml"});
        a = lVar;
        l lVar2 = new l("application/epub+zip", ".epub");
        f6305b = lVar2;
        l lVar3 = new l("application/x-dtbncx+xml", ".ncx");
        f6306c = lVar3;
        l lVar4 = new l("text/javascript", ".js");
        f6307d = lVar4;
        l lVar5 = new l("text/css", ".css");
        f6308e = lVar5;
        l lVar6 = new l("image/jpeg", ".jpg", new String[]{".jpg", ".jpeg"});
        f6309f = lVar6;
        l lVar7 = new l("image/png", ".png");
        f6310g = lVar7;
        l lVar8 = new l("image/gif", ".gif");
        f6311h = lVar8;
        l lVar9 = new l("image/svg+xml", ".svg");
        f6312i = lVar9;
        l lVar10 = new l("application/x-truetype-font", ".ttf");
        f6313j = lVar10;
        l lVar11 = new l("application/vnd.ms-opentype", ".otf");
        f6314k = lVar11;
        l lVar12 = new l("application/font-woff", ".woff");
        f6315l = lVar12;
        l lVar13 = new l("audio/mpeg", ".mp3");
        m = lVar13;
        l lVar14 = new l("audio/ogg", ".ogg");
        n = lVar14;
        l lVar15 = new l("video/mp4", ".mp4");
        o = lVar15;
        l lVar16 = new l("application/smil+xml", ".smil");
        p = lVar16;
        l lVar17 = new l("application/adobe-page-template+xml", ".xpgt");
        q = lVar17;
        l lVar18 = new l("application/pls+xml", ".pls");
        r = lVar18;
        l[] lVarArr = {lVar, lVar2, lVar6, lVar7, lVar8, lVar5, lVar9, lVar10, lVar3, lVar17, lVar11, lVar12, lVar16, lVar18, lVar4, lVar13, lVar15, lVar14};
        s = lVarArr;
        t = new HashMap();
        for (l lVar19 : lVarArr) {
            t.put(lVar19.getName(), lVar19);
        }
    }

    public static l a(String str) {
        for (l lVar : t.values()) {
            for (String str2 : lVar.getExtensions()) {
                if (c.b.a.m.f.w3(str2) ? true : (!c.b.a.m.f.w3(str) && str2.length() <= str.length()) ? str.substring(str.length() - str2.length()).toLowerCase().endsWith(str2.toLowerCase()) : false) {
                    return lVar;
                }
            }
        }
        return null;
    }

    public static boolean b(l lVar) {
        return lVar == f6309f || lVar == f6310g || lVar == f6311h;
    }
}
