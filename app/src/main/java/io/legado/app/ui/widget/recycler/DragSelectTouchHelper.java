package io.legado.app.ui.widget.recycler;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import f.c0.c.j;
import f.c0.c.k;
import io.legado.app.ui.widget.recycler.DragSelectTouchHelper;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DragSelectTouchHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DragSelectTouchHelper {

    @NotNull
    public static final c a = c.INSIDE_EXTEND;
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public boolean G;

    @NotNull
    public final f.e H;

    @NotNull
    public final f.e I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final b f7749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final DisplayMetrics f7750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f7751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f7752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f7753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f7755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7759l;
    public boolean m;

    @Nullable
    public RecyclerView n;
    public float o;
    public float p;
    public float q;
    public float r;

    @NotNull
    public final View.OnLayoutChangeListener s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public float y;
    public float z;

    /* JADX INFO: compiled from: DragSelectTouchHelper.kt */
    public static abstract class a<T> extends b {

        @Nullable
        public EnumC0216a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public Set<T> f7760b = new LinkedHashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7761c;

        /* JADX INFO: renamed from: io.legado.app.ui.widget.recycler.DragSelectTouchHelper$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DragSelectTouchHelper.kt */
        public enum EnumC0216a {
            SelectAndKeep,
            SelectAndReverse,
            SelectAndUndo,
            ToggleAndKeep,
            ToggleAndReverse,
            ToggleAndUndo;

            /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
            public static EnumC0216a[] valuesCustom() {
                EnumC0216a[] enumC0216aArrValuesCustom = values();
                return (EnumC0216a[]) Arrays.copyOf(enumC0216aArrValuesCustom, enumC0216aArrValuesCustom.length);
            }
        }

        /* JADX INFO: compiled from: DragSelectTouchHelper.kt */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                EnumC0216a.valuesCustom();
                int[] iArr = new int[6];
                iArr[EnumC0216a.SelectAndKeep.ordinal()] = 1;
                iArr[EnumC0216a.SelectAndReverse.ordinal()] = 2;
                iArr[EnumC0216a.SelectAndUndo.ordinal()] = 3;
                iArr[EnumC0216a.ToggleAndKeep.ordinal()] = 4;
                iArr[EnumC0216a.ToggleAndReverse.ordinal()] = 5;
                iArr[EnumC0216a.ToggleAndUndo.ordinal()] = 6;
                a = iArr;
            }
        }

        public a(@Nullable EnumC0216a enumC0216a) {
            this.a = enumC0216a;
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.b
        public boolean a(int i2, boolean z) {
            EnumC0216a enumC0216a = this.a;
            switch (enumC0216a == null ? -1 : b.a[enumC0216a.ordinal()]) {
                case 1:
                    return f(i2, true);
                case 2:
                    return f(i2, z);
                case 3:
                    return z ? f(i2, true) : f(i2, this.f7760b.contains(e(i2)));
                case 4:
                    return f(i2, !this.f7761c);
                case 5:
                    return z ? f(i2, !this.f7761c) : f(i2, this.f7761c);
                case 6:
                    return z ? f(i2, !this.f7761c) : f(i2, this.f7760b.contains(e(i2)));
                default:
                    return f(i2, z);
            }
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.b
        public void b(int i2) {
            this.f7760b.clear();
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.b
        public void c(int i2) {
            this.f7760b.clear();
            Set<T> setD = d();
            if (setD != null) {
                this.f7760b.addAll(setD);
            }
            this.f7761c = this.f7760b.contains(e(i2));
        }

        @Nullable
        public abstract Set<T> d();

        public abstract T e(int i2);

        public abstract boolean f(int i2, boolean z);
    }

    /* JADX INFO: compiled from: DragSelectTouchHelper.kt */
    public static abstract class b {
        public abstract boolean a(int i2, boolean z);

        public abstract void b(int i2);

        public abstract void c(int i2);
    }

    /* JADX INFO: compiled from: DragSelectTouchHelper.kt */
    public enum c {
        INSIDE,
        INSIDE_EXTEND;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static c[] valuesCustom() {
            c[] cVarArrValuesCustom = values();
            return (c[]) Arrays.copyOf(cVarArrValuesCustom, cVarArrValuesCustom.length);
        }
    }

    /* JADX INFO: compiled from: DragSelectTouchHelper.kt */
    public static final class d {
        public static final void a(int i2, int i3) {
            StringBuilder sbR = c.a.a.a.a.r("Select state changed: ");
            sbR.append(b(i2));
            sbR.append(" --> ");
            sbR.append(b(i3));
            j.e(sbR.toString(), NotificationCompat.CATEGORY_MESSAGE);
        }

        public static final String b(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 16 ? i2 != 17 ? "Unknown" : "DragFromSlide" : "DragFromNormal" : "SlideState" : "NormalState";
        }
    }

    /* JADX INFO: compiled from: DragSelectTouchHelper.kt */
    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            c.valuesCustom();
            int[] iArr = new int[2];
            iArr[c.INSIDE.ordinal()] = 1;
            iArr[c.INSIDE_EXTEND.ordinal()] = 2;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: DragSelectTouchHelper.kt */
    public static final class f extends k implements f.c0.b.a<a> {

        /* JADX INFO: compiled from: DragSelectTouchHelper.kt */
        public static final class a implements Runnable {
            public final /* synthetic */ DragSelectTouchHelper a;

            public a(DragSelectTouchHelper dragSelectTouchHelper) {
                this.a = dragSelectTouchHelper;
            }

            @Override // java.lang.Runnable
            public void run() {
                DragSelectTouchHelper dragSelectTouchHelper = this.a;
                if (dragSelectTouchHelper.w) {
                    int i2 = dragSelectTouchHelper.x;
                    int iMin = i2 > 0 ? Math.min(i2, dragSelectTouchHelper.f7758k) : Math.max(i2, -dragSelectTouchHelper.f7758k);
                    RecyclerView recyclerView = dragSelectTouchHelper.n;
                    j.c(recyclerView);
                    recyclerView.scrollBy(0, iMin);
                    if (!(dragSelectTouchHelper.z == Float.MIN_VALUE)) {
                        if (!(dragSelectTouchHelper.A == Float.MIN_VALUE)) {
                            RecyclerView recyclerView2 = dragSelectTouchHelper.n;
                            j.c(recyclerView2);
                            dragSelectTouchHelper.m(recyclerView2, dragSelectTouchHelper.z, dragSelectTouchHelper.A);
                        }
                    }
                    RecyclerView recyclerView3 = this.a.n;
                    j.c(recyclerView3);
                    ViewCompat.postOnAnimation(recyclerView3, this);
                }
            }
        }

        public f() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final a invoke() {
            return new a(DragSelectTouchHelper.this);
        }
    }

    public DragSelectTouchHelper(@NotNull b bVar) {
        j.e(bVar, "mCallback");
        this.f7749b = bVar;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        j.d(displayMetrics, "getSystem().displayMetrics");
        this.f7750c = displayMetrics;
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = -1.0f;
        this.s = new View.OnLayoutChangeListener() { // from class: e.a.a.g.m.p.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                DragSelectTouchHelper dragSelectTouchHelper = this.a;
                j.e(dragSelectTouchHelper, "this$0");
                if (!(i6 == i2 && i8 == i4 && i7 == i3 && i9 == i5) && view == dragSelectTouchHelper.n) {
                    j.e("onLayoutChange:new: " + i2 + ' ' + i3 + ' ' + i4 + ' ' + i5, NotificationCompat.CATEGORY_MESSAGE);
                    j.e("onLayoutChange:old: " + i6 + ' ' + i7 + ' ' + i8 + ' ' + i9, NotificationCompat.CATEGORY_MESSAGE);
                    dragSelectTouchHelper.f(i5 - i3);
                }
            }
        };
        this.y = Float.MIN_VALUE;
        this.z = Float.MIN_VALUE;
        this.A = Float.MIN_VALUE;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.H = c.b.a.m.f.N3(new f());
        this.I = c.b.a.m.f.N3(new DragSelectTouchHelper$mOnItemTouchListener$2(this));
        this.f7753f = 0.2f;
        this.f7755h = c(0);
        this.f7758k = (int) ((10 * displayMetrics.density) + 0.5f);
        c cVar = a;
        int i2 = cVar != null ? e.a[cVar.ordinal()] : -1;
        if (i2 == 1) {
            this.f7756i = false;
            this.f7757j = false;
        } else if (i2 != 2) {
            this.f7756i = true;
            this.f7757j = true;
        } else {
            this.f7756i = true;
            this.f7757j = true;
        }
        this.f7759l = false;
        this.m = false;
        j(0, 0);
    }

    public final void a() {
        RecyclerView recyclerView = this.n;
        if (recyclerView != null) {
            f(recyclerView.getHeight());
        }
        d.a(this.t, 1);
        this.t = 1;
    }

    public final void b(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.n;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeOnItemTouchListener((RecyclerView.OnItemTouchListener) this.I.getValue());
        }
        this.n = recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnItemTouchListener((RecyclerView.OnItemTouchListener) this.I.getValue());
        recyclerView.addOnLayoutChangeListener(this.s);
    }

    public final int c(float f2) {
        return (int) TypedValue.applyDimension(1, f2, this.f7750c);
    }

    public final int d(RecyclerView recyclerView, float f2, float f3) {
        View viewFindChildViewUnder = recyclerView.findChildViewUnder(f2, f3);
        if (viewFindChildViewUnder != null) {
            return recyclerView.getChildAdapterPosition(viewFindChildViewUnder);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            return -1;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        int itemCount = gridLayoutManager.getItemCount() - 1;
        if (itemCount == iFindLastVisibleItemPosition) {
            return itemCount;
        }
        return -1;
    }

    public final Runnable e() {
        return (Runnable) this.H.getValue();
    }

    public final void f(int i2) {
        float f2 = i2;
        float f3 = f2 * 0.5f;
        if (this.f7755h >= f3) {
            this.f7755h = f3;
        }
        float f4 = this.f7754g;
        if (f4 <= 0.0f) {
            float f5 = this.f7753f;
            if (f5 <= 0.0f || f5 >= 0.5f) {
                this.f7753f = 0.2f;
            }
            this.f7754g = this.f7753f * f2;
        } else if (f4 >= f3) {
            this.f7754g = f3;
        }
        float f6 = this.f7755h;
        this.o = f6;
        float f7 = this.f7754g;
        float f8 = f6 + f7;
        this.p = f8;
        float f9 = f2 - f6;
        this.r = f9;
        float f10 = f9 - f7;
        this.q = f10;
        if (f8 > f10) {
            float f11 = i2 >> 1;
            this.q = f11;
            this.p = f11;
        }
        StringBuilder sbR = c.a.a.a.a.r("Hotspot: [");
        sbR.append(this.o);
        sbR.append(", ");
        sbR.append(this.p);
        sbR.append("], [");
        sbR.append(this.q);
        sbR.append(", ");
        sbR.append(this.r);
        sbR.append(']');
        j.e(sbR.toString(), NotificationCompat.CATEGORY_MESSAGE);
    }

    public final void g(int i2, int i3, boolean z) {
        if (i2 > i3) {
            return;
        }
        while (true) {
            int i4 = i2 + 1;
            this.f7749b.a(i2, z);
            if (i2 == i3) {
                return;
            } else {
                i2 = i4;
            }
        }
    }

    public final void h(int i2) {
        if (i2 != -1) {
            this.f7749b.b(i2);
        }
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        int i3 = 0;
        this.G = false;
        this.u = false;
        this.v = false;
        l();
        int i4 = this.t;
        if (i4 != 16) {
            if (i4 != 17) {
                return;
            }
            d.a(i4, 1);
            this.t = 1;
            return;
        }
        if (this.f7759l) {
            d.a(i4, 1);
            i3 = 1;
        } else {
            d.a(i4, 0);
        }
        this.t = i3;
    }

    public final boolean i(int i2) {
        boolean zA = this.f7749b.a(i2, true);
        if (zA) {
            this.B = i2;
            this.C = i2;
            this.D = i2;
            this.E = i2;
        }
        return zA;
    }

    @NotNull
    public final DragSelectTouchHelper j(int i2, int i3) {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            float f2 = this.f7750c.widthPixels;
            this.f7751d = f2 - c(i3);
            this.f7752e = f2 - c(i2);
        } else {
            this.f7751d = c(i2);
            this.f7752e = c(i3);
        }
        return this;
    }

    public final void k() {
        if (this.w) {
            return;
        }
        this.w = true;
        RecyclerView recyclerView = this.n;
        j.c(recyclerView);
        recyclerView.removeCallbacks(e());
        RecyclerView recyclerView2 = this.n;
        j.c(recyclerView2);
        ViewCompat.postOnAnimation(recyclerView2, e());
    }

    public final void l() {
        if (this.w) {
            this.w = false;
            RecyclerView recyclerView = this.n;
            if (recyclerView == null) {
                return;
            }
            recyclerView.removeCallbacks(e());
        }
    }

    public final void m(RecyclerView recyclerView, float f2, float f3) {
        int iD = d(recyclerView, f2, f3);
        if (iD == -1 || this.C == iD) {
            return;
        }
        this.C = iD;
        int i2 = this.B;
        if (i2 == -1 || iD == -1) {
            return;
        }
        int iMin = Math.min(i2, iD);
        int iMax = Math.max(this.B, this.C);
        int i3 = this.D;
        if (i3 != -1 && this.E != -1) {
            if (iMin > i3) {
                g(i3, iMin - 1, false);
            } else if (iMin < i3) {
                g(iMin, i3 - 1, true);
            }
            int i4 = this.E;
            if (iMax > i4) {
                g(i4 + 1, iMax, true);
            } else if (iMax < i4) {
                g(iMax + 1, i4, false);
            }
        } else if (iMax - iMin == 1) {
            g(iMin, iMin, true);
        } else {
            g(iMin, iMax, true);
        }
        this.D = iMin;
        this.E = iMax;
    }
}
