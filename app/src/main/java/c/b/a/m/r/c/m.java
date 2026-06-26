package c.b.a.m.r.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import c.b.a.m.r.c.s;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: Downsampler.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static final c.b.a.m.k<c.b.a.m.b> a = c.b.a.m.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", c.b.a.m.b.DEFAULT);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c.b.a.m.k<c.b.a.m.m> f524b = c.b.a.m.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", c.b.a.m.m.SRGB);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c.b.a.m.k<Boolean> f525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c.b.a.m.k<Boolean> f526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<ImageHeaderParser.ImageType> f529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.b.a.m.q.c0.d f531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DisplayMetrics f532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c.b.a.m.q.c0.b f533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<ImageHeaderParser> f534l;
    public final r m = r.a();

    /* JADX INFO: compiled from: Downsampler.java */
    public class a implements b {
        @Override // c.b.a.m.r.c.m.b
        public void a(c.b.a.m.q.c0.d dVar, Bitmap bitmap) {
        }

        @Override // c.b.a.m.r.c.m.b
        public void b() {
        }
    }

    /* JADX INFO: compiled from: Downsampler.java */
    public interface b {
        void a(c.b.a.m.q.c0.d dVar, Bitmap bitmap);

        void b();
    }

    static {
        c.b.a.m.k<l> kVar = l.f522f;
        Boolean bool = Boolean.FALSE;
        f525c = c.b.a.m.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f526d = c.b.a.m.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f527e = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f528f = new a();
        f529g = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        char[] cArr = c.b.a.s.i.a;
        f530h = new ArrayDeque(0);
    }

    public m(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, c.b.a.m.q.c0.d dVar, c.b.a.m.q.c0.b bVar) {
        this.f534l = list;
        Objects.requireNonNull(displayMetrics, "Argument must not be null");
        this.f532j = displayMetrics;
        Objects.requireNonNull(dVar, "Argument must not be null");
        this.f531i = dVar;
        Objects.requireNonNull(bVar, "Argument must not be null");
        this.f533k = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap d(c.b.a.m.r.c.s r4, android.graphics.BitmapFactory.Options r5, c.b.a.m.r.c.m.b r6, c.b.a.m.q.c0.d r7) {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto La
            r6.b()
            r4.c()
        La:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = c.b.a.m.r.c.z.f563d
            r3.lock()
            android.graphics.Bitmap r4 = r4.b(r5)     // Catch: java.lang.Throwable -> L1d java.lang.IllegalArgumentException -> L1f
            r3.unlock()
            return r4
        L1d:
            r4 = move-exception
            goto L40
        L1f:
            r3 = move-exception
            java.io.IOException r0 = i(r3, r0, r1, r2, r5)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = "Downsampler"
            r2 = 3
            android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L1d
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L3f
            r7.d(r1)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L3e
            r1 = 0
            r5.inBitmap = r1     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L3e
            android.graphics.Bitmap r4 = d(r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L3e
            java.util.concurrent.locks.Lock r5 = c.b.a.m.r.c.z.f563d
            r5.unlock()
            return r4
        L3e:
            throw r0     // Catch: java.lang.Throwable -> L1d
        L3f:
            throw r0     // Catch: java.lang.Throwable -> L1d
        L40:
            java.util.concurrent.locks.Lock r5 = c.b.a.m.r.c.z.f563d
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.r.c.m.d(c.b.a.m.r.c.s, android.graphics.BitmapFactory$Options, c.b.a.m.r.c.m$b, c.b.a.m.q.c0.d):android.graphics.Bitmap");
    }

    @Nullable
    @TargetApi(19)
    public static String e(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder sbR = c.a.a.a.a.r(" (");
        sbR.append(bitmap.getAllocationByteCount());
        sbR.append(")");
        String string = sbR.toString();
        StringBuilder sbR2 = c.a.a.a.a.r("[");
        sbR2.append(bitmap.getWidth());
        sbR2.append("x");
        sbR2.append(bitmap.getHeight());
        sbR2.append("] ");
        sbR2.append(bitmap.getConfig());
        sbR2.append(string);
        return sbR2.toString();
    }

    public static int f(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    public static int[] g(s sVar, BitmapFactory.Options options, b bVar, c.b.a.m.q.c0.d dVar) {
        options.inJustDecodeBounds = true;
        d(sVar, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static boolean h(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public static IOException i(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + e(options.inBitmap), illegalArgumentException);
    }

    public static void j(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int k(double d2) {
        return (int) (d2 + 0.5d);
    }

    public final c.b.a.m.q.w<Bitmap> a(s sVar, int i2, int i3, c.b.a.m.l lVar, b bVar) {
        Queue<BitmapFactory.Options> queue;
        BitmapFactory.Options optionsPoll;
        BitmapFactory.Options options;
        byte[] bArr = (byte[]) this.f533k.e(65536, byte[].class);
        synchronized (m.class) {
            queue = f530h;
            synchronized (queue) {
                optionsPoll = queue.poll();
            }
            if (optionsPoll == null) {
                optionsPoll = new BitmapFactory.Options();
                j(optionsPoll);
            }
            options = optionsPoll;
        }
        options.inTempStorage = bArr;
        c.b.a.m.b bVar2 = (c.b.a.m.b) lVar.b(a);
        c.b.a.m.m mVar = (c.b.a.m.m) lVar.b(f524b);
        l lVar2 = (l) lVar.b(l.f522f);
        boolean zBooleanValue = ((Boolean) lVar.b(f525c)).booleanValue();
        c.b.a.m.k<Boolean> kVar = f526d;
        try {
            e eVarB = e.b(c(sVar, options, lVar2, bVar2, mVar, lVar.b(kVar) != null && ((Boolean) lVar.b(kVar)).booleanValue(), i2, i3, zBooleanValue, bVar), this.f531i);
            j(options);
            synchronized (queue) {
                queue.offer(options);
            }
            this.f533k.d(bArr);
            return eVarB;
        } catch (Throwable th) {
            j(options);
            Queue<BitmapFactory.Options> queue2 = f530h;
            synchronized (queue2) {
                queue2.offer(options);
                this.f533k.d(bArr);
                throw th;
            }
        }
    }

    public c.b.a.m.q.w<Bitmap> b(InputStream inputStream, int i2, int i3, c.b.a.m.l lVar, b bVar) {
        return a(new s.a(inputStream, this.f534l, this.f533k), i2, i3, lVar, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0197 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a4  */
    /* JADX WARN: Type inference failed for: r0v9, types: [c.b.a.m.q.c0.d] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r35v0, types: [c.b.a.m.r.c.m$b] */
    /* JADX WARN: Type inference failed for: r3v10, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap c(c.b.a.m.r.c.s r26, android.graphics.BitmapFactory.Options r27, c.b.a.m.r.c.l r28, c.b.a.m.b r29, c.b.a.m.m r30, boolean r31, int r32, int r33, boolean r34, c.b.a.m.r.c.m.b r35) {
        /*
            Method dump skipped, instruction units count: 1066
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.r.c.m.c(c.b.a.m.r.c.s, android.graphics.BitmapFactory$Options, c.b.a.m.r.c.l, c.b.a.m.b, c.b.a.m.m, boolean, int, int, boolean, c.b.a.m.r.c.m$b):android.graphics.Bitmap");
    }
}
