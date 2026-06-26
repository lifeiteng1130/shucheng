package j$.util.stream;

import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.u1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0479u1<T, O> implements h3<T, O> {
    boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f8273b;

    /* JADX INFO: renamed from: j$.util.stream.u1$a */
    static final class a extends AbstractC0479u1<Double, j$.util.p> implements A2.e {
        a() {
        }

        @Override // j$.util.stream.AbstractC0479u1, j$.util.stream.A2
        public void accept(double d2) {
            accept(Double.valueOf(d2));
        }

        @Override // j$.util.function.Supplier
        public Object get() {
            if (this.a) {
                return j$.util.p.d(((Double) this.f8273b).doubleValue());
            }
            return null;
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            Objects.requireNonNull(sVar);
            return new C0392f(this, sVar);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.u1$b */
    static final class b extends AbstractC0479u1<Integer, j$.util.q> implements A2.f {
        b() {
        }

        @Override // j$.util.stream.AbstractC0479u1, j$.util.stream.A2, j$.util.function.y
        public void accept(int i2) {
            accept(Integer.valueOf(i2));
        }

        @Override // j$.util.function.Supplier
        public Object get() {
            if (this.a) {
                return j$.util.q.d(((Integer) this.f8273b).intValue());
            }
            return null;
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            Objects.requireNonNull(yVar);
            return new C0395i(this, yVar);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.u1$c */
    static final class c extends AbstractC0479u1<Long, j$.util.r> implements A2.g {
        c() {
        }

        @Override // j$.util.stream.AbstractC0479u1, j$.util.stream.A2
        public void accept(long j2) {
            accept(Long.valueOf(j2));
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e2) {
            Objects.requireNonNull(e2);
            return new C0396j(this, e2);
        }

        @Override // j$.util.function.Supplier
        public Object get() {
            if (this.a) {
                return j$.util.r.d(((Long) this.f8273b).longValue());
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.u1$d */
    static final class d<T> extends AbstractC0479u1<T, j$.util.o<T>> {
        d() {
        }

        @Override // j$.util.function.Supplier
        public Object get() {
            if (this.a) {
                return j$.util.o.d(this.f8273b);
            }
            return null;
        }
    }

    AbstractC0479u1() {
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
    public void accept(Object obj) {
        if (this.a) {
            return;
        }
        this.a = true;
        this.f8273b = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.A2
    public void l() {
    }

    @Override // j$.util.stream.A2
    public void m(long j2) {
    }

    @Override // j$.util.stream.A2
    public boolean o() {
        return this.a;
    }
}
