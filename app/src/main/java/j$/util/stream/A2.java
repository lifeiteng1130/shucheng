package j$.util.stream;

import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public interface A2<T> extends Consumer<T> {

    public static abstract class a<E_OUT> implements e {
        protected final A2 a;

        public a(A2 a2) {
            Objects.requireNonNull(a2);
            this.a = a2;
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

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Double d2) {
            Q1.a(this, d2);
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            Objects.requireNonNull(sVar);
            return new C0392f(this, sVar);
        }

        @Override // j$.util.stream.A2
        public void l() {
            this.a.l();
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            this.a.m(j2);
        }

        @Override // j$.util.stream.A2
        public boolean o() {
            return this.a.o();
        }
    }

    public static abstract class b<E_OUT> implements f {
        protected final A2 a;

        public b(A2 a2) {
            Objects.requireNonNull(a2);
            this.a = a2;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d2) {
            j$.time.a.c(this);
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

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Integer num) {
            Q1.b(this, num);
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            Objects.requireNonNull(yVar);
            return new C0395i(this, yVar);
        }

        @Override // j$.util.stream.A2
        public void l() {
            this.a.l();
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            this.a.m(j2);
        }

        @Override // j$.util.stream.A2
        public boolean o() {
            return this.a.o();
        }
    }

    public static abstract class c<E_OUT> implements g {
        protected final A2 a;

        public c(A2 a2) {
            Objects.requireNonNull(a2);
            this.a = a2;
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

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Long l2) {
            Q1.c(this, l2);
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e2) {
            Objects.requireNonNull(e2);
            return new C0396j(this, e2);
        }

        @Override // j$.util.stream.A2
        public void l() {
            this.a.l();
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            this.a.m(j2);
        }

        @Override // j$.util.stream.A2
        public boolean o() {
            return this.a.o();
        }
    }

    public static abstract class d<T, E_OUT> implements A2<T> {
        protected final A2 a;

        public d(A2 a2) {
            Objects.requireNonNull(a2);
            this.a = a2;
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

        @Override // j$.util.stream.A2
        public void l() {
            this.a.l();
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            this.a.m(j2);
        }

        @Override // j$.util.stream.A2
        public boolean o() {
            return this.a.o();
        }
    }

    public interface e extends A2<Double>, j$.util.function.s {
        @Override // j$.util.stream.A2
        void accept(double d2);
    }

    public interface f extends A2<Integer>, j$.util.function.y {
        @Override // j$.util.stream.A2, j$.util.function.y
        void accept(int i2);
    }

    public interface g extends A2<Long>, j$.util.function.E {
        @Override // j$.util.stream.A2
        void accept(long j2);
    }

    void accept(double d2);

    void accept(int i2);

    void accept(long j2);

    void l();

    void m(long j2);

    boolean o();
}
