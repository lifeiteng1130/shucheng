package c.b.a.m.q.d0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import androidx.exifinterface.media.ExifInterface;
import c.b.a.s.j.a;
import c.b.a.s.j.d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/* JADX INFO: compiled from: SafeKeyGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public final c.b.a.s.f<c.b.a.m.j, String> a = new c.b.a.s.f<>(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pools.Pool<b> f378b = c.b.a.s.j.a.a(10, new a(this));

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    public class a implements a.b<b> {
        public a(k kVar) {
        }

        @Override // c.b.a.s.j.a.b
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    public static final class b implements a.d {
        public final MessageDigest a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.b.a.s.j.d f379b = new d.b();

        public b(MessageDigest messageDigest) {
            this.a = messageDigest;
        }

        @Override // c.b.a.s.j.a.d
        @NonNull
        public c.b.a.s.j.d b() {
            return this.f379b;
        }
    }

    public String a(c.b.a.m.j jVar) {
        String str;
        synchronized (this.a) {
            str = this.a.get(jVar);
        }
        if (str == null) {
            b bVarAcquire = this.f378b.acquire();
            Objects.requireNonNull(bVarAcquire, "Argument must not be null");
            b bVar = bVarAcquire;
            try {
                jVar.updateDiskCacheKey(bVar.a);
                byte[] bArrDigest = bVar.a.digest();
                char[] cArr = c.b.a.s.i.f679b;
                synchronized (cArr) {
                    for (int i2 = 0; i2 < bArrDigest.length; i2++) {
                        int i3 = bArrDigest[i2] & ExifInterface.MARKER;
                        int i4 = i2 * 2;
                        char[] cArr2 = c.b.a.s.i.a;
                        cArr[i4] = cArr2[i3 >>> 4];
                        cArr[i4 + 1] = cArr2[i3 & 15];
                    }
                    str = new String(cArr);
                }
            } finally {
                this.f378b.release(bVar);
            }
        }
        synchronized (this.a) {
            this.a.put(jVar, str);
        }
        return str;
    }
}
