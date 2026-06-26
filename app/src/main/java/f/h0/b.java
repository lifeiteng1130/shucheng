package f.h0;

import f.c0.b.p;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements f.g0.e<f.e0.d> {
    public final CharSequence a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p<CharSequence, Integer, f.g<Integer, Integer>> f6147d;

    /* JADX INFO: compiled from: Strings.kt */
    public static final class a implements Iterator<f.e0.d>, f.c0.c.z.a, j$.util.Iterator {
        public int a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public f.e0.d f6150d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6151e;

        public a() {
            int iB = f.e0.e.b(b.this.f6145b, 0, b.this.a.length());
            this.f6148b = iB;
            this.f6149c = iB;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r7 = this;
                int r0 = r7.f6149c
                r1 = 0
                if (r0 >= 0) goto Lc
                r7.a = r1
                r0 = 0
                r7.f6150d = r0
                goto L86
            Lc:
                f.h0.b r2 = f.h0.b.this
                int r3 = r2.f6146c
                r4 = -1
                r5 = 1
                if (r3 <= 0) goto L1b
                int r6 = r7.f6151e
                int r6 = r6 + r5
                r7.f6151e = r6
                if (r6 >= r3) goto L23
            L1b:
                java.lang.CharSequence r2 = r2.a
                int r2 = r2.length()
                if (r0 <= r2) goto L37
            L23:
                int r0 = r7.f6148b
                f.e0.d r1 = new f.e0.d
                f.h0.b r2 = f.h0.b.this
                java.lang.CharSequence r2 = r2.a
                int r2 = f.h0.k.l(r2)
                r1.<init>(r0, r2)
                r7.f6150d = r1
                r7.f6149c = r4
                goto L84
            L37:
                f.h0.b r0 = f.h0.b.this
                f.c0.b.p<java.lang.CharSequence, java.lang.Integer, f.g<java.lang.Integer, java.lang.Integer>> r2 = r0.f6147d
                java.lang.CharSequence r0 = r0.a
                int r3 = r7.f6149c
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.Object r0 = r2.invoke(r0, r3)
                f.g r0 = (f.g) r0
                if (r0 != 0) goto L5f
                int r0 = r7.f6148b
                f.e0.d r1 = new f.e0.d
                f.h0.b r2 = f.h0.b.this
                java.lang.CharSequence r2 = r2.a
                int r2 = f.h0.k.l(r2)
                r1.<init>(r0, r2)
                r7.f6150d = r1
                r7.f6149c = r4
                goto L84
            L5f:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r3 = r7.f6148b
                f.e0.d r3 = f.e0.e.f(r3, r2)
                r7.f6150d = r3
                int r2 = r2 + r0
                r7.f6148b = r2
                if (r0 != 0) goto L81
                r1 = 1
            L81:
                int r2 = r2 + r1
                r7.f6149c = r2
            L84:
                r7.a = r5
            L86:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f.h0.b.a.a():void");
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Object next() {
            if (this.a == -1) {
                a();
            }
            if (this.a == 0) {
                throw new NoSuchElementException();
            }
            f.e0.d dVar = this.f6150d;
            Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f6150d = null;
            this.a = -1;
            return dVar;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull CharSequence charSequence, int i2, int i3, @NotNull p<? super CharSequence, ? super Integer, f.g<Integer, Integer>> pVar) {
        f.c0.c.j.e(charSequence, "input");
        f.c0.c.j.e(pVar, "getNextMatch");
        this.a = charSequence;
        this.f6145b = i2;
        this.f6146c = i3;
        this.f6147d = pVar;
    }

    @Override // f.g0.e
    @NotNull
    public java.util.Iterator<f.e0.d> iterator() {
        return new a();
    }
}
