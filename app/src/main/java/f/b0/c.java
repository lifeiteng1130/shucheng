package f.b0;

import f.c0.c.f;
import f.c0.c.j;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c extends IOException {

    @NotNull
    private final File file;

    @Nullable
    private final File other;

    @Nullable
    private final String reason;

    public c(@NotNull File file, @Nullable File file2, @Nullable String str) {
        j.e(file, "file");
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        j.d(string, "sb.toString()");
        super(string);
        this.file = file;
        this.other = file2;
        this.reason = str;
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @Nullable
    public final File getOther() {
        return this.other;
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    public /* synthetic */ c(File file, File file2, String str, int i2, f fVar) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }
}
