package c.b.a.s.j;

/* JADX INFO: compiled from: StateVerifier.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: compiled from: StateVerifier.java */
    public static class b extends d {
        public volatile boolean a;

        public b() {
            super(null);
        }

        @Override // c.b.a.s.j.d
        public void a() {
            if (this.a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public d(a aVar) {
    }

    public abstract void a();
}
