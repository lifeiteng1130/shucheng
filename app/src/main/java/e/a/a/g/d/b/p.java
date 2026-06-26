package e.a.a.g.d.b;

import androidx.core.app.NotificationCompat;
import f.v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CacheViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends f.c0.c.k implements f.c0.b.l<String, v> {
    public final /* synthetic */ File $bookFile;
    public final /* synthetic */ StringBuilder $stringBuilder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(File file, StringBuilder sb) {
        super(1);
        this.$bookFile = file;
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
        File file = this.$bookFile;
        Charset charsetForName = Charset.forName(e.a.a.d.e.a.d());
        f.c0.c.j.d(charsetForName, "forName(AppConfig.exportCharset)");
        f.c0.c.j.e(file, "$this$appendText");
        f.c0.c.j.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        f.c0.c.j.e(charsetForName, "charset");
        byte[] bytes = str.getBytes(charsetForName);
        f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        f.c0.c.j.e(file, "$this$appendBytes");
        f.c0.c.j.e(bytes, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(bytes);
            c.b.a.m.f.P0(fileOutputStream, null);
            this.$stringBuilder.append(str);
        } finally {
        }
    }
}
