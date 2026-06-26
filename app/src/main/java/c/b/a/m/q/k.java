package c.b.a.m.q;

/* JADX INFO: compiled from: DiskCacheStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static final k a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f420b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f421c = new c();

    /* JADX INFO: compiled from: DiskCacheStrategy.java */
    public class a extends k {
        @Override // c.b.a.m.q.k
        public boolean a() {
            return false;
        }

        @Override // c.b.a.m.q.k
        public boolean b() {
            return false;
        }

        @Override // c.b.a.m.q.k
        public boolean c(c.b.a.m.a aVar) {
            return false;
        }

        @Override // c.b.a.m.q.k
        public boolean d(boolean z, c.b.a.m.a aVar, c.b.a.m.c cVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: DiskCacheStrategy.java */
    public class b extends k {
        @Override // c.b.a.m.q.k
        public boolean a() {
            return true;
        }

        @Override // c.b.a.m.q.k
        public boolean b() {
            return false;
        }

        @Override // c.b.a.m.q.k
        public boolean c(c.b.a.m.a aVar) {
            return (aVar == c.b.a.m.a.DATA_DISK_CACHE || aVar == c.b.a.m.a.MEMORY_CACHE) ? false : true;
        }

        @Override // c.b.a.m.q.k
        public boolean d(boolean z, c.b.a.m.a aVar, c.b.a.m.c cVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: DiskCacheStrategy.java */
    public class c extends k {
        @Override // c.b.a.m.q.k
        public boolean a() {
            return true;
        }

        @Override // c.b.a.m.q.k
        public boolean b() {
            return true;
        }

        @Override // c.b.a.m.q.k
        public boolean c(c.b.a.m.a aVar) {
            return aVar == c.b.a.m.a.REMOTE;
        }

        @Override // c.b.a.m.q.k
        public boolean d(boolean z, c.b.a.m.a aVar, c.b.a.m.c cVar) {
            return ((z && aVar == c.b.a.m.a.DATA_DISK_CACHE) || aVar == c.b.a.m.a.LOCAL) && cVar == c.b.a.m.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(c.b.a.m.a aVar);

    public abstract boolean d(boolean z, c.b.a.m.a aVar, c.b.a.m.c cVar);
}
