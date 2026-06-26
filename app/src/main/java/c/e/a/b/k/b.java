package c.e.a.b.k;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.f;
import com.google.android.material.circularreveal.CircularRevealHelper;

/* JADX INFO: compiled from: CircularRevealWidget.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends CircularRevealHelper.a {

    /* JADX INFO: renamed from: c.e.a.b.k.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class C0044b implements TypeEvaluator<e> {
        public static final TypeEvaluator<e> a = new C0044b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f1004b = new e(null);

        @Override // android.animation.TypeEvaluator
        @NonNull
        public e evaluate(float f2, @NonNull e eVar, @NonNull e eVar2) {
            e eVar3 = eVar;
            e eVar4 = eVar2;
            e eVar5 = this.f1004b;
            float fO3 = f.O3(eVar3.a, eVar4.a, f2);
            float fO32 = f.O3(eVar3.f1005b, eVar4.f1005b, f2);
            float fO33 = f.O3(eVar3.f1006c, eVar4.f1006c, f2);
            eVar5.a = fO3;
            eVar5.f1005b = fO32;
            eVar5.f1006c = fO33;
            return this.f1004b;
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class c extends Property<b, e> {
        public static final Property<b, e> a = new c("circularReveal");

        public c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @Nullable
        public e get(@NonNull b bVar) {
            return bVar.getRevealInfo();
        }

        @Override // android.util.Property
        public void set(@NonNull b bVar, @Nullable e eVar) {
            bVar.setRevealInfo(eVar);
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class d extends Property<b, Integer> {
        public static final Property<b, Integer> a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        public Integer get(@NonNull b bVar) {
            return Integer.valueOf(bVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void set(@NonNull b bVar, @NonNull Integer num) {
            bVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class e {
        public float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1006c;

        public e() {
        }

        public e(a aVar) {
        }

        public e(float f2, float f3, float f4) {
            this.a = f2;
            this.f1005b = f3;
            this.f1006c = f4;
        }
    }

    void a();

    void b();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    e getRevealInfo();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i2);

    void setRevealInfo(@Nullable e eVar);
}
