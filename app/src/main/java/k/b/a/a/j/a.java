package k.b.a.a.j;

import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: DateFormatUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final b f8570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f8571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f8572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f8573f;

    static {
        TimeZone timeZone = e.f8609b;
        a = b.getInstance("yyyy-MM-dd'T'HH:mm:ss");
        b bVar = b.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
        f8569b = bVar;
        f8570c = bVar;
        f8571d = b.getInstance("yyyy-MM-dd");
        b.getInstance("yyyy-MM-ddZZ");
        b.getInstance("'T'HH:mm:ss");
        b.getInstance("'T'HH:mm:ssZZ");
        f8572e = b.getInstance("HH:mm:ss");
        f8573f = b.getInstance("HH:mm:ssZZ");
        b.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
    }
}
