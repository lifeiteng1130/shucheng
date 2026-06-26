package c.b.a.m.q.c0;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SizeConfigStrategy.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
public class m implements k {
    public static final Bitmap.Config[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Bitmap.Config[] f346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Bitmap.Config[] f347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f350f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g<b, Bitmap> f351g = new g<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f352h = new HashMap();

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
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
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    public static final class b implements l {
        public final c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap.Config f354c;

        public b(c cVar) {
            this.a = cVar;
        }

        @Override // c.b.a.m.q.c0.l
        public void a() {
            this.a.c(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f353b == bVar.f353b && c.b.a.s.i.b(this.f354c, bVar.f354c);
        }

        public int hashCode() {
            int i2 = this.f353b * 31;
            Bitmap.Config config = this.f354c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return m.c(this.f353b, this.f354c);
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    public static class c extends c.b.a.m.q.c0.c<b> {
        @Override // c.b.a.m.q.c0.c
        public l a() {
            return new b(this);
        }

        public b d(int i2, Bitmap.Config config) {
            b bVarB = b();
            bVarB.f353b = i2;
            bVarB.f354c = config;
            return bVarB;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        a = configArr;
        f346b = configArr;
        f347c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f348d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f349e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String c(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapD = d(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapD.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapD.remove(num);
                return;
            } else {
                navigableMapD.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
    }

    @Nullable
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int iC = c.b.a.s.i.c(i2, i3, config);
        b bVarB = this.f350f.b();
        bVarB.f353b = iC;
        bVarB.f354c = config;
        int i4 = 0;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i5 = a.a[config.ordinal()];
            configArr = i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? new Bitmap.Config[]{config} : f349e : f348d : f347c : a;
        } else {
            configArr = f346b;
        }
        int length = configArr.length;
        while (true) {
            if (i4 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i4];
            Integer numCeilingKey = d(config2).ceilingKey(Integer.valueOf(iC));
            if (numCeilingKey == null || numCeilingKey.intValue() > iC * 8) {
                i4++;
            } else if (numCeilingKey.intValue() != iC || (config2 != null ? !config2.equals(config) : config != null)) {
                this.f350f.c(bVarB);
                bVarB = this.f350f.d(numCeilingKey.intValue(), config2);
            }
        }
        Bitmap bitmapA = this.f351g.a(bVarB);
        if (bitmapA != null) {
            a(Integer.valueOf(bVarB.f353b), bitmapA);
            bitmapA.reconfigure(i2, i3, config);
        }
        return bitmapA;
    }

    public final NavigableMap<Integer, Integer> d(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f352h.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f352h.put(config, treeMap);
        return treeMap;
    }

    public String e(Bitmap bitmap) {
        return c(c.b.a.s.i.d(bitmap), bitmap.getConfig());
    }

    public void f(Bitmap bitmap) {
        b bVarD = this.f350f.d(c.b.a.s.i.d(bitmap), bitmap.getConfig());
        this.f351g.b(bVarD, bitmap);
        NavigableMap<Integer, Integer> navigableMapD = d(bitmap.getConfig());
        Integer num = (Integer) navigableMapD.get(Integer.valueOf(bVarD.f353b));
        navigableMapD.put(Integer.valueOf(bVarD.f353b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("SizeConfigStrategy{groupedMap=");
        sbR.append(this.f351g);
        sbR.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f352h.entrySet()) {
            sbR.append(entry.getKey());
            sbR.append('[');
            sbR.append(entry.getValue());
            sbR.append("], ");
        }
        if (!this.f352h.isEmpty()) {
            sbR.replace(sbR.length() - 2, sbR.length(), "");
        }
        sbR.append(")}");
        return sbR.toString();
    }
}
