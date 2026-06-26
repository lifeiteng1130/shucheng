package k.c.c;

/* JADX INFO: compiled from: BlockContinueImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8641c;

    public b(int i2, int i3, boolean z) {
        this.a = i2;
        this.f8640b = i3;
        this.f8641c = z;
    }

    public static b a(int i2) {
        return new b(-1, i2, false);
    }

    public static b b(int i2) {
        return new b(i2, -1, false);
    }
}
