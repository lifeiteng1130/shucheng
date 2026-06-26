package j$.util.stream;

import j$.util.function.Predicate;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
class I1<T> extends M1<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ N1 f8047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Predicate f8048d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    I1(N1 n1, Predicate predicate) {
        super(n1);
        this.f8047c = n1;
        this.f8048d = predicate;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        if (this.a || this.f8048d.test(obj) != this.f8047c.f8058b) {
            return;
        }
        this.a = true;
        this.f8056b = this.f8047c.f8059c;
    }
}
