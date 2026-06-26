package j$.util.stream;

import j$.util.stream.A2;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
abstract class F2<T> extends A2.d<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Comparator f8043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f8044c;

    F2(A2 a2, Comparator comparator) {
        super(a2);
        this.f8043b = comparator;
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public final boolean o() {
        this.f8044c = true;
        return false;
    }
}
