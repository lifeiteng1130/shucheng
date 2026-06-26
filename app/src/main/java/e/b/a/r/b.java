package e.b.a.r;

import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: CssProperty.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6038b;

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("CssProperty{key='");
        c.a.a.a.a.y(sbR, this.a, '\'', ", value='");
        sbR.append(this.f6038b);
        sbR.append('\'');
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
