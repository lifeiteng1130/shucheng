package c.b.a.m.r.f;

import c.b.a.m.q.w;
import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: FileResource.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements w {
    public final T a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(File file) {
        Objects.requireNonNull(file, "Argument must not be null");
        this.a = file;
    }

    @Override // c.b.a.m.q.w
    public Class c() {
        return this.a.getClass();
    }

    @Override // c.b.a.m.q.w
    public final Object get() {
        return this.a;
    }

    @Override // c.b.a.m.q.w
    public final /* bridge */ /* synthetic */ int getSize() {
        return 1;
    }

    @Override // c.b.a.m.q.w
    public void recycle() {
    }
}
