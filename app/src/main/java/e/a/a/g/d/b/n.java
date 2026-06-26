package e.a.a.g.d.b;

import f.v;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CacheViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends f.c0.c.k implements f.c0.b.l<String, v> {
    public final /* synthetic */ OutputStream $bookOs;
    public final /* synthetic */ StringBuilder $stringBuilder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(OutputStream outputStream, StringBuilder sb) {
        super(1);
        this.$bookOs = outputStream;
        this.$stringBuilder = sb;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(String str) throws IOException {
        invoke2(str);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String str) throws IOException {
        f.c0.c.j.e(str, "it");
        OutputStream outputStream = this.$bookOs;
        Charset charsetForName = Charset.forName(e.a.a.d.e.a.d());
        f.c0.c.j.d(charsetForName, "forName(AppConfig.exportCharset)");
        byte[] bytes = str.getBytes(charsetForName);
        f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        outputStream.write(bytes);
        this.$stringBuilder.append(str);
    }
}
