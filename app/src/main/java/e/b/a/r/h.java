package e.b.a.r;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.ai;
import e.b.a.r.f;
import e.b.a.r.n.b.b;
import e.b.a.r.n.b.b.a;
import e.b.a.r.n.c.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: MarkwonHtmlParserImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends g {

    @VisibleForTesting
    public static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(ai.at, "abbr", "acronym", "b", "bdo", "big", "br", "button", "cite", "code", "dfn", "em", ai.aA, "img", "input", "kbd", TTDownloadField.TT_LABEL, "map", "object", "q", "samp", "script", "select", "small", "span", "strong", "sub", "sup", "textarea", "time", "tt", "var")));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f6047b = Collections.unmodifiableSet(new HashSet(Arrays.asList("area", "base", "br", "col", "embed", "hr", "img", "input", "keygen", "link", TTDownloadField.TT_META, "param", "source", "track", "wbr")));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f6048c = Collections.unmodifiableSet(new HashSet(Arrays.asList("address", "article", "aside", "blockquote", "canvas", "dd", "div", "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hgroup", "hr", "li", "main", "nav", "noscript", "ol", "output", "p", "pre", "section", "table", "tfoot", "ul", "video")));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f6049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f6050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<f.b> f6051f = new ArrayList(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f.a f6052g = f.a.h();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6054i;

    public h(@NonNull c cVar, @NonNull m mVar) {
        this.f6049d = cVar;
        this.f6050e = mVar;
    }

    public static <T extends Appendable & CharSequence> void a(@NonNull T t) {
        T t2 = t;
        int length = t2.length();
        if (length <= 0 || '\n' == t2.charAt(length - 1)) {
            return;
        }
        c.b.a.m.f.l0(t, '\n');
    }

    @NonNull
    public static Map<String, String> b(@NonNull d.g gVar) {
        e.b.a.r.n.b.b bVar = gVar.f6084j;
        int i2 = bVar.f6059b;
        if (i2 <= 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(i2);
        b.a aVar = bVar.new a();
        while (aVar.hasNext()) {
            e.b.a.r.n.b.a aVar2 = (e.b.a.r.n.b.a) aVar.next();
            map.put(aVar2.a.toLowerCase(Locale.US), aVar2.f6057b);
        }
        return Collections.unmodifiableMap(map);
    }
}
