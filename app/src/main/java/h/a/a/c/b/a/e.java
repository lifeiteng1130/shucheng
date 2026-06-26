package h.a.a.c.b.a;

import java.io.IOException;
import java.io.Reader;
import java.util.regex.Pattern;
import org.jsoup.helper.DataUtil;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: XmlStreamReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends Reader {
    public static final c[] a = {c.UTF_8, c.UTF_16BE, c.UTF_16LE, c.UTF_32BE, c.UTF_32LE};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c[] f6326b = {new c(DataUtil.defaultCharset, 60, 63, 120, 109), new c("UTF-16BE", 0, 60, 0, 63), new c("UTF-16LE", 60, 0, 63, 0), new c("UTF-32BE", 0, 0, 0, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109), new c("UTF-32LE", 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109, 0, 0, 0), new c("CP1047", 76, 111, Token.LAST_TOKEN, Token.XMLATTR)};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f6327c = Pattern.compile("charset=[\"']?([.[^; \"']]*)[\"']?");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f6328d = Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))", 8);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Reader f6329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f6330f;

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(java.io.InputStream r14, java.lang.String r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a.a.c.b.a.e.<init>(java.io.InputStream, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21) throws h.a.a.c.b.a.f {
        /*
            Method dump skipped, instruction units count: 687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a.a.c.b.a.e.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6329e.close();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i2, int i3) {
        return this.f6329e.read(cArr, i2, i3);
    }
}
