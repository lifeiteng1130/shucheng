package c.b.a.m.q.c0;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: LruBitmapPool.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements d {
    public static final Bitmap.Config a = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Bitmap.Config> f338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f345j;

    /* JADX INFO: compiled from: LruBitmapPool.java */
    public interface a {
    }

    /* JADX INFO: compiled from: LruBitmapPool.java */
    public static final class b implements a {
    }

    public j(long j2) {
        m mVar = new m();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set<Bitmap.Config> setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f340e = j2;
        this.f337b = mVar;
        this.f338c = setUnmodifiableSet;
        this.f339d = new b();
    }

    @Override // c.b.a.m.q.c0.d
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            Log.isLoggable("LruBitmapPool", 3);
            i(0L);
        } else if (i2 >= 20 || i2 == 15) {
            i(this.f340e / 2);
        }
    }

    @Override // c.b.a.m.q.c0.d
    public void b() {
        Log.isLoggable("LruBitmapPool", 3);
        i(0L);
    }

    @Override // c.b.a.m.q.c0.d
    @NonNull
    public Bitmap c(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapH = h(i2, i3, config);
        if (bitmapH != null) {
            return bitmapH;
        }
        if (config == null) {
            config = a;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // c.b.a.m.q.c0.d
    public synchronized void d(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                Objects.requireNonNull((m) this.f337b);
                if (c.b.a.s.i.d(bitmap) <= this.f340e && this.f338c.contains(bitmap.getConfig())) {
                    Objects.requireNonNull((m) this.f337b);
                    int iD = c.b.a.s.i.d(bitmap);
                    ((m) this.f337b).f(bitmap);
                    Objects.requireNonNull((b) this.f339d);
                    this.f344i++;
                    this.f341f += (long) iD;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        ((m) this.f337b).e(bitmap);
                    }
                    f();
                    i(this.f340e);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                ((m) this.f337b).e(bitmap);
                bitmap.isMutable();
                this.f338c.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // c.b.a.m.q.c0.d
    @NonNull
    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapH = h(i2, i3, config);
        if (bitmapH != null) {
            bitmapH.eraseColor(0);
            return bitmapH;
        }
        if (config == null) {
            config = a;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    public final void f() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            g();
        }
    }

    public final void g() {
        StringBuilder sbR = c.a.a.a.a.r("Hits=");
        sbR.append(this.f342g);
        sbR.append(", misses=");
        sbR.append(this.f343h);
        sbR.append(", puts=");
        sbR.append(this.f344i);
        sbR.append(", evictions=");
        sbR.append(this.f345j);
        sbR.append(", currentSize=");
        sbR.append(this.f341f);
        sbR.append(", maxSize=");
        sbR.append(this.f340e);
        sbR.append("\nStrategy=");
        sbR.append(this.f337b);
        sbR.toString();
    }

    @Nullable
    public final synchronized Bitmap h(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap bitmapB;
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
        bitmapB = ((m) this.f337b).b(i2, i3, config != null ? config : a);
        if (bitmapB == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Objects.requireNonNull((m) this.f337b);
                m.c(c.b.a.s.i.c(i2, i3, config), config);
            }
            this.f343h++;
        } else {
            this.f342g++;
            long j2 = this.f341f;
            Objects.requireNonNull((m) this.f337b);
            this.f341f = j2 - ((long) c.b.a.s.i.d(bitmapB));
            Objects.requireNonNull((b) this.f339d);
            bitmapB.setHasAlpha(true);
            bitmapB.setPremultiplied(true);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Objects.requireNonNull((m) this.f337b);
            m.c(c.b.a.s.i.c(i2, i3, config), config);
        }
        f();
        return bitmapB;
    }

    public final synchronized void i(long j2) {
        while (this.f341f > j2) {
            m mVar = (m) this.f337b;
            Bitmap bitmapC = mVar.f351g.c();
            if (bitmapC != null) {
                mVar.a(Integer.valueOf(c.b.a.s.i.d(bitmapC)), bitmapC);
            }
            if (bitmapC == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    g();
                }
                this.f341f = 0L;
                return;
            }
            Objects.requireNonNull((b) this.f339d);
            long j3 = this.f341f;
            Objects.requireNonNull((m) this.f337b);
            this.f341f = j3 - ((long) c.b.a.s.i.d(bitmapC));
            this.f345j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                ((m) this.f337b).e(bitmapC);
            }
            f();
            bitmapC.recycle();
        }
    }
}
