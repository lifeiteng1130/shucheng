package b.a.b;

import androidx.camera.core.SafeCloseImageReaderProxy;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u1 implements Runnable {
    public final /* synthetic */ SafeCloseImageReaderProxy a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.safeClose();
    }
}
