package k.a.a.a;

import androidx.camera.core.CameraInfo;
import androidx.exifinterface.media.ExifInterface;
import java.nio.charset.StandardCharsets;
import org.jsoup.parser.CharacterReader;

/* JADX INFO: compiled from: CodePointCharStream.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements g {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8367c = 0;

    /* JADX INFO: compiled from: CodePointCharStream.java */
    public static final class b extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final char[] f8368d;

        public b(int i2, int i3, String str, char[] cArr, int i4, a aVar) {
            super(i2, i3, str, null);
            this.f8368d = cArr;
        }

        @Override // k.a.a.a.q
        public int b(int i2) {
            char c2;
            int iSignum = Integer.signum(i2);
            if (iSignum == -1) {
                int i3 = this.f8367c + i2;
                if (i3 < 0) {
                    return -1;
                }
                c2 = this.f8368d[i3];
            } else {
                if (iSignum == 0) {
                    return 0;
                }
                if (iSignum != 1) {
                    throw new UnsupportedOperationException("Not reached");
                }
                int i4 = (this.f8367c + i2) - 1;
                if (i4 >= this.a) {
                    return -1;
                }
                c2 = this.f8368d[i4];
            }
            return c2 & CharacterReader.EOF;
        }

        @Override // k.a.a.a.g
        public String f(k.a.a.a.m0.h hVar) {
            return new String(this.f8368d, Math.min(hVar.f8511c, this.a - 1), Math.min((hVar.f8512d - hVar.f8511c) + 1, this.a));
        }
    }

    /* JADX INFO: compiled from: CodePointCharStream.java */
    public static final class c extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f8369d;

        public c(int i2, int i3, String str, int[] iArr, int i4, a aVar) {
            super(i2, i3, str, null);
            this.f8369d = iArr;
        }

        @Override // k.a.a.a.q
        public int b(int i2) {
            int iSignum = Integer.signum(i2);
            if (iSignum == -1) {
                int i3 = this.f8367c + i2;
                if (i3 < 0) {
                    return -1;
                }
                return this.f8369d[i3];
            }
            if (iSignum == 0) {
                return 0;
            }
            if (iSignum != 1) {
                throw new UnsupportedOperationException("Not reached");
            }
            int i4 = (this.f8367c + i2) - 1;
            if (i4 >= this.a) {
                return -1;
            }
            return this.f8369d[i4];
        }

        @Override // k.a.a.a.g
        public String f(k.a.a.a.m0.h hVar) {
            return new String(this.f8369d, Math.min(hVar.f8511c, this.a - 1), Math.min((hVar.f8512d - hVar.f8511c) + 1, this.a));
        }
    }

    /* JADX INFO: compiled from: CodePointCharStream.java */
    public static final class d extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f8370d;

        public d(int i2, int i3, String str, byte[] bArr, int i4, a aVar) {
            super(i2, i3, str, null);
            this.f8370d = bArr;
        }

        @Override // k.a.a.a.q
        public int b(int i2) {
            byte b2;
            int iSignum = Integer.signum(i2);
            if (iSignum == -1) {
                int i3 = this.f8367c + i2;
                if (i3 < 0) {
                    return -1;
                }
                b2 = this.f8370d[i3];
            } else {
                if (iSignum == 0) {
                    return 0;
                }
                if (iSignum != 1) {
                    throw new UnsupportedOperationException("Not reached");
                }
                int i4 = (this.f8367c + i2) - 1;
                if (i4 >= this.a) {
                    return -1;
                }
                b2 = this.f8370d[i4];
            }
            return b2 & ExifInterface.MARKER;
        }

        @Override // k.a.a.a.g
        public String f(k.a.a.a.m0.h hVar) {
            return new String(this.f8370d, Math.min(hVar.f8511c, this.a - 1), Math.min((hVar.f8512d - hVar.f8511c) + 1, this.a), StandardCharsets.ISO_8859_1);
        }
    }

    public i(int i2, int i3, String str, a aVar) {
        this.a = i3;
        this.f8366b = str;
    }

    @Override // k.a.a.a.q
    public final void a(int i2) {
        this.f8367c = i2;
    }

    @Override // k.a.a.a.q
    public final int d() {
        return -1;
    }

    @Override // k.a.a.a.q
    public final void g() {
        int i2 = this.a;
        int i3 = this.f8367c;
        if (i2 - i3 == 0) {
            throw new IllegalStateException("cannot consume EOF");
        }
        this.f8367c = i3 + 1;
    }

    @Override // k.a.a.a.q
    public final String getSourceName() {
        String str = this.f8366b;
        return (str == null || str.isEmpty()) ? CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN : this.f8366b;
    }

    @Override // k.a.a.a.q
    public final void h(int i2) {
    }

    @Override // k.a.a.a.q
    public final int index() {
        return this.f8367c;
    }

    @Override // k.a.a.a.q
    public final int size() {
        return this.a;
    }

    public final String toString() {
        return f(k.a.a.a.m0.h.c(0, this.a - 1));
    }
}
