package androidx.core.net;

import android.net.Uri;
import c.a.a.a.a;
import f.c0.c.j;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Uri.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0004*\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Landroid/net/Uri;", "toUri", "(Ljava/lang/String;)Landroid/net/Uri;", "Ljava/io/File;", "(Ljava/io/File;)Landroid/net/Uri;", "toFile", "(Landroid/net/Uri;)Ljava/io/File;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class UriKt {
    @NotNull
    public static final File toFile(@NotNull Uri uri) {
        j.f(uri, "$this$toFile");
        if (!j.a(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(a.g("Uri lacks 'file' scheme: ", uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(a.g("Uri path is null: ", uri).toString());
    }

    @NotNull
    public static final Uri toUri(@NotNull String str) {
        j.f(str, "$this$toUri");
        Uri uri = Uri.parse(str);
        j.b(uri, "Uri.parse(this)");
        return uri;
    }

    @NotNull
    public static final Uri toUri(@NotNull File file) {
        j.f(file, "$this$toUri");
        Uri uriFromFile = Uri.fromFile(file);
        j.b(uriFromFile, "Uri.fromFile(this)");
        return uriFromFile;
    }
}
