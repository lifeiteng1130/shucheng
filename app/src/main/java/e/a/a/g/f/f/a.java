package e.a.a.g.f.f;

import android.graphics.drawable.Drawable;
import f.c0.c.j;
import h.a.a.a.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FileItem.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {

    @Nullable
    private Drawable icon;
    private boolean isDirectory;

    @Nullable
    private String name;

    @NotNull
    private String path = w.DEFAULT_PATH_SEPARATOR;
    private long size;

    @Nullable
    public final Drawable getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public final void setIcon(@Nullable Drawable drawable) {
        this.icon = drawable;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPath(@NotNull String str) {
        j.e(str, "<set-?>");
        this.path = str;
    }

    public final void setSize(long j2) {
        this.size = j2;
    }
}
