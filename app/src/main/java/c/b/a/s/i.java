package c.b.a.s;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static final char[] a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f679b = new char[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static volatile Handler f680c;

    /* JADX INFO: compiled from: Util.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!i()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int c(int i2, int i3, @Nullable Bitmap.Config config) {
        int i4 = i2 * i3;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i5 = a.a[config.ordinal()];
        int i6 = 4;
        if (i5 == 1) {
            i6 = 1;
        } else if (i5 == 2 || i5 == 3) {
            i6 = 2;
        } else if (i5 == 4) {
            i6 = 8;
        }
        return i4 * i6;
    }

    @TargetApi(19)
    public static int d(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    @NonNull
    public static <T> List<T> e(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static Handler f() {
        if (f680c == null) {
            synchronized (i.class) {
                if (f680c == null) {
                    f680c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f680c;
    }

    public static int g(@Nullable Object obj, int i2) {
        return (i2 * 31) + (obj == null ? 0 : obj.hashCode());
    }

    public static boolean h() {
        return !i();
    }

    public static boolean i() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean j(int i2, int i3) {
        if (i2 > 0 || i2 == Integer.MIN_VALUE) {
            if (i3 > 0 || i3 == Integer.MIN_VALUE) {
                return true;
            }
        }
        return false;
    }
}
