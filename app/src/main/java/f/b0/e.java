package f.b0;

import f.c0.c.f;
import f.c0.c.j;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends c {
    public /* synthetic */ e(File file, File file2, String str, int i2, f fVar) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull File file, @Nullable File file2, @Nullable String str) {
        super(file, file2, str);
        j.e(file, "file");
    }
}
