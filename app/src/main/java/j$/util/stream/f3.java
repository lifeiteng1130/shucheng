package j$.util.stream;

/* JADX INFO: loaded from: classes2.dex */
class f3 implements Runnable {
    final /* synthetic */ Runnable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f8195b;

    f3(Runnable runnable, Runnable runnable2) {
        this.a = runnable;
        this.f8195b = runnable2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.run();
            this.f8195b.run();
        } catch (Throwable th) {
            try {
                this.f8195b.run();
            } catch (Throwable th2) {
                try {
                    th.addSuppressed(th2);
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
