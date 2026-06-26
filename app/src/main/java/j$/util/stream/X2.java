package j$.util.stream;

import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
abstract class X2 {
    int a;

    static final class a extends d<j$.util.function.s> implements j$.util.function.s {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final double[] f8154c;

        a(int i2) {
            this.f8154c = new double[i2];
        }

        @Override // j$.util.function.s
        public void accept(double d2) {
            double[] dArr = this.f8154c;
            int i2 = this.f8157b;
            this.f8157b = i2 + 1;
            dArr[i2] = d2;
        }

        @Override // j$.util.stream.X2.d
        void b(Object obj, long j2) {
            j$.util.function.s sVar = (j$.util.function.s) obj;
            for (int i2 = 0; i2 < j2; i2++) {
                sVar.accept(this.f8154c[i2]);
            }
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            Objects.requireNonNull(sVar);
            return new C0392f(this, sVar);
        }
    }

    static final class b extends d<j$.util.function.y> implements j$.util.function.y {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int[] f8155c;

        b(int i2) {
            this.f8155c = new int[i2];
        }

        @Override // j$.util.function.y
        public void accept(int i2) {
            int[] iArr = this.f8155c;
            int i3 = this.f8157b;
            this.f8157b = i3 + 1;
            iArr[i3] = i2;
        }

        @Override // j$.util.stream.X2.d
        public void b(Object obj, long j2) {
            j$.util.function.y yVar = (j$.util.function.y) obj;
            for (int i2 = 0; i2 < j2; i2++) {
                yVar.accept(this.f8155c[i2]);
            }
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            Objects.requireNonNull(yVar);
            return new C0395i(this, yVar);
        }
    }

    static final class c extends d<j$.util.function.E> implements j$.util.function.E {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long[] f8156c;

        c(int i2) {
            this.f8156c = new long[i2];
        }

        @Override // j$.util.function.E
        public void accept(long j2) {
            long[] jArr = this.f8156c;
            int i2 = this.f8157b;
            this.f8157b = i2 + 1;
            jArr[i2] = j2;
        }

        @Override // j$.util.stream.X2.d
        public void b(Object obj, long j2) {
            j$.util.function.E e2 = (j$.util.function.E) obj;
            for (int i2 = 0; i2 < j2; i2++) {
                e2.accept(this.f8156c[i2]);
            }
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e2) {
            Objects.requireNonNull(e2);
            return new C0396j(this, e2);
        }
    }

    static abstract class d<T_CONS> extends X2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8157b;

        d() {
        }

        abstract void b(Object obj, long j2);
    }

    static final class e<T> extends X2 implements Consumer<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object[] f8158b;

        e(int i2) {
            this.f8158b = new Object[i2];
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            Object[] objArr = this.f8158b;
            int i2 = this.a;
            this.a = i2 + 1;
            objArr[i2] = obj;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    X2() {
    }
}
