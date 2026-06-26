package e.b.a.r.n.b;

import c.b.a.m.f;
import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.v;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: Attributes.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements Iterable<e.b.a.r.n.b.a>, Cloneable, Iterable {
    public static final String[] a = new String[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6059b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f6060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f6061d;

    /* JADX INFO: compiled from: Attributes.java */
    public class a implements Iterator<e.b.a.r.n.b.a>, j$.util.Iterator {
        public int a = 0;

        public a() {
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.a < b.this.f6059b;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Object next() {
            b bVar = b.this;
            String[] strArr = bVar.f6061d;
            int i2 = this.a;
            String str = strArr[i2];
            String str2 = bVar.f6060c[i2];
            if (str == null) {
                str = "";
            }
            e.b.a.r.n.b.a aVar = new e.b.a.r.n.b.a(str2, str, bVar);
            this.a++;
            return aVar;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            b bVar = b.this;
            int i2 = this.a - 1;
            this.a = i2;
            int i3 = bVar.f6059b;
            if (i2 >= i3) {
                throw new IllegalArgumentException("Must be false");
            }
            int i4 = (i3 - i2) - 1;
            if (i4 > 0) {
                String[] strArr = bVar.f6060c;
                int i5 = i2 + 1;
                System.arraycopy(strArr, i5, strArr, i2, i4);
                String[] strArr2 = bVar.f6061d;
                System.arraycopy(strArr2, i5, strArr2, i2, i4);
            }
            int i6 = bVar.f6059b - 1;
            bVar.f6059b = i6;
            bVar.f6060c[i6] = null;
            bVar.f6061d[i6] = null;
        }
    }

    public b() {
        String[] strArr = a;
        this.f6060c = strArr;
        this.f6061d = strArr;
    }

    public static String[] a(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i2));
        return strArr2;
    }

    public int b(String str) {
        f.f4(str);
        for (int i2 = 0; i2 < this.f6059b; i2++) {
            if (str.equals(this.f6060c[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public Object clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f6059b = this.f6059b;
            this.f6060c = a(this.f6060c, this.f6059b);
            this.f6061d = a(this.f6061d, this.f6059b);
            return bVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f6059b == bVar.f6059b && Arrays.equals(this.f6060c, bVar.f6060c)) {
            return Arrays.equals(this.f6061d, bVar.f6061d);
        }
        return false;
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public int hashCode() {
        return (((this.f6059b * 31) + Arrays.hashCode(this.f6060c)) * 31) + Arrays.hashCode(this.f6061d);
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public java.util.Iterator<e.b.a.r.n.b.a> iterator() {
        return new a();
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return v.o(iterator(), 0);
    }
}
