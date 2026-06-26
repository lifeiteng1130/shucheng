package k.a.a.a;

import androidx.camera.core.CameraInfo;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/* JADX INFO: compiled from: ANTLRInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements g {
    public char[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8355c = 0;

    public c(String str) {
        this.a = str.toCharArray();
        this.f8354b = str.length();
    }

    @Override // k.a.a.a.q
    public void a(int i2) {
        if (i2 <= this.f8355c) {
            this.f8355c = i2;
            return;
        }
        int iMin = Math.min(i2, this.f8354b);
        while (this.f8355c < iMin) {
            g();
        }
    }

    @Override // k.a.a.a.q
    public int b(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            i2++;
            if ((this.f8355c + i2) - 1 < 0) {
                return -1;
            }
        }
        int i3 = this.f8355c;
        if ((i3 + i2) - 1 >= this.f8354b) {
            return -1;
        }
        return this.a[(i3 + i2) - 1];
    }

    @Override // k.a.a.a.q
    public int d() {
        return -1;
    }

    @Override // k.a.a.a.g
    public String f(k.a.a.a.m0.h hVar) {
        int i2 = hVar.f8511c;
        int i3 = hVar.f8512d;
        int i4 = this.f8354b;
        if (i3 >= i4) {
            i3 = i4 - 1;
        }
        return i2 >= i4 ? "" : new String(this.a, i2, (i3 - i2) + 1);
    }

    @Override // k.a.a.a.q
    public void g() {
        int i2 = this.f8355c;
        int i3 = this.f8354b;
        if (i2 >= i3) {
            throw new IllegalStateException("cannot consume EOF");
        }
        if (i2 < i3) {
            this.f8355c = i2 + 1;
        }
    }

    @Override // k.a.a.a.q
    public String getSourceName() {
        return CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN;
    }

    @Override // k.a.a.a.q
    public void h(int i2) {
    }

    @Override // k.a.a.a.q
    public int index() {
        return this.f8355c;
    }

    @Override // k.a.a.a.q
    public int size() {
        return this.f8354b;
    }

    public String toString() {
        return new String(this.a);
    }

    public c(Reader reader) throws IOException {
        int i2;
        int i3 = 0;
        try {
            this.a = new char[1024];
            do {
                int i4 = i3 + 1024;
                char[] cArr = this.a;
                if (i4 > cArr.length) {
                    this.a = Arrays.copyOf(cArr, cArr.length * 2);
                }
                i2 = reader.read(this.a, i3, 1024);
                i3 += i2;
            } while (i2 != -1);
            this.f8354b = i3 + 1;
        } finally {
            reader.close();
        }
    }
}
