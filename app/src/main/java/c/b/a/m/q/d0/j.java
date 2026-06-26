package c.b.a.m.q.d0;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: compiled from: MemorySizeCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f373d;

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    public static final class a {
        public static final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ActivityManager f375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f376d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f377e;

        static {
            a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f377e = a;
            this.f374b = context;
            this.f375c = (ActivityManager) context.getSystemService("activity");
            this.f376d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !this.f375c.isLowRamDevice()) {
                return;
            }
            this.f377e = 0.0f;
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    public static final class b implements c {
        public final DisplayMetrics a;

        public b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    public interface c {
    }

    public j(a aVar) {
        this.f372c = aVar.f374b;
        int i2 = aVar.f375c.isLowRamDevice() ? 2097152 : 4194304;
        this.f373d = i2;
        int iRound = Math.round(r1.getMemoryClass() * 1024 * 1024 * (aVar.f375c.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = ((b) aVar.f376d).a;
        float f2 = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        int iRound2 = Math.round(aVar.f377e * f2);
        int iRound3 = Math.round(f2 * 2.0f);
        int i3 = iRound - i2;
        if (iRound3 + iRound2 <= i3) {
            this.f371b = iRound3;
            this.a = iRound2;
        } else {
            float f3 = i3 / (aVar.f377e + 2.0f);
            this.f371b = Math.round(2.0f * f3);
            this.a = Math.round(f3 * aVar.f377e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            a(this.f371b);
            a(this.a);
            a(i2);
            a(iRound);
            aVar.f375c.getMemoryClass();
            aVar.f375c.isLowRamDevice();
        }
    }

    public final String a(int i2) {
        return Formatter.formatFileSize(this.f372c, i2);
    }
}
