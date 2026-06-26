package c.b.a.q;

/* JADX INFO: compiled from: RequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public interface d {

    /* JADX INFO: compiled from: RequestCoordinator.java */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        a(boolean z) {
            this.isComplete = z;
        }

        public boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean a();

    void b(c cVar);

    boolean e(c cVar);

    boolean f(c cVar);

    d getRoot();

    void h(c cVar);

    boolean j(c cVar);
}
