package io.legado.app.model.localBook;

import f.c0.b.a;
import f.c0.c.j;
import f.c0.c.k;
import io.legado.app.utils.FileUtils;
import java.io.File;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LocalBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/io/File;", "<anonymous>", "()Ljava/io/File;"}, k = 3, mv = {1, 5, 1})
public final class LocalBook$cacheFolder$2 extends k implements a<File> {
    public static final LocalBook$cacheFolder$2 INSTANCE = new LocalBook$cacheFolder$2();

    public LocalBook$cacheFolder$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // f.c0.b.a
    @NotNull
    public final File invoke() {
        File externalFilesDir = h.g().getExternalFilesDir(null);
        if (externalFilesDir == null && (externalFilesDir = h.g().getExternalCacheDir()) == null) {
            externalFilesDir = h.g().getCacheDir();
        }
        FileUtils fileUtils = FileUtils.a;
        j.d(externalFilesDir, "rootFile");
        return fileUtils.d(externalFilesDir, "bookTxt");
    }
}
