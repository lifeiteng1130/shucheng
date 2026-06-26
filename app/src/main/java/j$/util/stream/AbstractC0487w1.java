package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.w1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0487w1<T> implements g3<T, Void>, h3<T, Void> {
    private final boolean a;

    /* JADX INFO: renamed from: j$.util.stream.w1$a */
    static final class a extends AbstractC0487w1<Double> implements A2.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j$.util.function.s f8275b;

        a(j$.util.function.s sVar, boolean z) {
            super(z);
            this.f8275b = sVar;
        }

        @Override // j$.util.stream.AbstractC0487w1, j$.util.stream.A2
        public void accept(double d2) {
            this.f8275b.accept(d2);
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Double d2) {
            Q1.a(this, d2);
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            Objects.requireNonNull(sVar);
            return new C0392f(this, sVar);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.w1$b */
    static final class b extends AbstractC0487w1<Integer> implements A2.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j$.util.function.y f8276b;

        b(j$.util.function.y yVar, boolean z) {
            super(z);
            this.f8276b = yVar;
        }

        @Override // j$.util.stream.AbstractC0487w1, j$.util.stream.A2, j$.util.function.y
        public void accept(int i2) {
            this.f8276b.accept(i2);
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Integer num) {
            Q1.b(this, num);
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            Objects.requireNonNull(yVar);
            return new C0395i(this, yVar);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.w1$c */
    static final class c extends AbstractC0487w1<Long> implements A2.g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j$.util.function.E f8277b;

        c(j$.util.function.E e2, boolean z) {
            super(z);
            this.f8277b = e2;
        }

        @Override // j$.util.stream.AbstractC0487w1, j$.util.stream.A2
        public void accept(long j2) {
            this.f8277b.accept(j2);
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Long l2) {
            Q1.c(this, l2);
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e2) {
            Objects.requireNonNull(e2);
            return new C0396j(this, e2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.w1$d */
    static final class d<T> extends AbstractC0487w1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f8278b;

        d(Consumer consumer, boolean z) {
            super(z);
            this.f8278b = consumer;
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            this.f8278b.accept(obj);
        }
    }

    protected AbstractC0487w1(boolean z) {
        this.a = z;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d2) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2, j$.util.function.y
    public /* synthetic */ void accept(int i2) {
        j$.time.a.a(this);
        throw null;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(long j2) {
        j$.time.a.b(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.g3
    public int b() {
        if (this.a) {
            return 0;
        }
        return T2.m;
    }

    @Override // j$.util.stream.g3
    public Object c(T1 t1, Spliterator spliterator) {
        (this.a ? new C0491x1(t1, spliterator, this) : new C0495y1(t1, spliterator, t1.u0(this))).invoke();
        return null;
    }

    @Override // j$.util.stream.g3
    public Object d(T1 t1, Spliterator spliterator) {
        AbstractC0428h1 abstractC0428h1 = (AbstractC0428h1) t1;
        abstractC0428h1.m0(abstractC0428h1.u0(this), spliterator);
        return null;
    }

    @Override // j$.util.function.Supplier
    public /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean o() {
        return false;
    }
}
