package c.e.a.b.w;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R$styleable;
import java.util.Objects;

/* JADX INFO: compiled from: ShapeAppearanceModel.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    public static final c.e.a.b.w.c a = new j(0.5f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f1227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f1228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f1229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f1230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.e.a.b.w.c f1231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c.e.a.b.w.c f1232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c.e.a.b.w.c f1233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c.e.a.b.w.c f1234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f1235j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f1236k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f1237l;
    public f m;

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface c {
        @NonNull
        c.e.a.b.w.c a(@NonNull c.e.a.b.w.c cVar);
    }

    public l(b bVar, a aVar) {
        this.f1227b = bVar.a;
        this.f1228c = bVar.f1238b;
        this.f1229d = bVar.f1239c;
        this.f1230e = bVar.f1240d;
        this.f1231f = bVar.f1241e;
        this.f1232g = bVar.f1242f;
        this.f1233h = bVar.f1243g;
        this.f1234i = bVar.f1244h;
        this.f1235j = bVar.f1245i;
        this.f1236k = bVar.f1246j;
        this.f1237l = bVar.f1247k;
        this.m = bVar.f1248l;
    }

    @NonNull
    public static b a(Context context, @StyleRes int i2, @StyleRes int i3) {
        return b(context, i2, i3, new c.e.a.b.w.a(0));
    }

    @NonNull
    public static b b(Context context, @StyleRes int i2, @StyleRes int i3, @NonNull c.e.a.b.w.c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.ShapeAppearance);
        try {
            int i4 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            c.e.a.b.w.c cVarD = d(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, cVar);
            c.e.a.b.w.c cVarD2 = d(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, cVarD);
            c.e.a.b.w.c cVarD3 = d(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, cVarD);
            c.e.a.b.w.c cVarD4 = d(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, cVarD);
            c.e.a.b.w.c cVarD5 = d(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, cVarD);
            b bVar = new b();
            d dVarJ1 = c.b.a.m.f.j1(i5);
            bVar.a = dVarJ1;
            b.b(dVarJ1);
            bVar.f1241e = cVarD2;
            d dVarJ12 = c.b.a.m.f.j1(i6);
            bVar.f1238b = dVarJ12;
            b.b(dVarJ12);
            bVar.f1242f = cVarD3;
            d dVarJ13 = c.b.a.m.f.j1(i7);
            bVar.f1239c = dVarJ13;
            b.b(dVarJ13);
            bVar.f1243g = cVarD4;
            d dVarJ14 = c.b.a.m.f.j1(i8);
            bVar.f1240d = dVarJ14;
            b.b(dVarJ14);
            bVar.f1244h = cVarD5;
            return bVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static b c(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, @NonNull c.e.a.b.w.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i2, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return b(context, resourceId, resourceId2, cVar);
    }

    @NonNull
    public static c.e.a.b.w.c d(TypedArray typedArray, int i2, @NonNull c.e.a.b.w.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i3 = typedValuePeekValue.type;
        return i3 == 5 ? new c.e.a.b.w.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i3 == 6 ? new j(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean e(@NonNull RectF rectF) {
        boolean z = this.m.getClass().equals(f.class) && this.f1236k.getClass().equals(f.class) && this.f1235j.getClass().equals(f.class) && this.f1237l.getClass().equals(f.class);
        float fA = this.f1231f.a(rectF);
        return z && ((this.f1232g.a(rectF) > fA ? 1 : (this.f1232g.a(rectF) == fA ? 0 : -1)) == 0 && (this.f1234i.a(rectF) > fA ? 1 : (this.f1234i.a(rectF) == fA ? 0 : -1)) == 0 && (this.f1233h.a(rectF) > fA ? 1 : (this.f1233h.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f1228c instanceof k) && (this.f1227b instanceof k) && (this.f1229d instanceof k) && (this.f1230e instanceof k));
    }

    @NonNull
    public l f(float f2) {
        b bVar = new b(this);
        bVar.c(f2);
        return bVar.a();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public l g(@NonNull c cVar) {
        b bVar = new b(this);
        bVar.f1241e = cVar.a(this.f1231f);
        bVar.f1242f = cVar.a(this.f1232g);
        bVar.f1244h = cVar.a(this.f1234i);
        bVar.f1243g = cVar.a(this.f1233h);
        return bVar.a();
    }

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public static final class b {

        @NonNull
        public d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public d f1238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public d f1239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        public d f1240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        public c.e.a.b.w.c f1241e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NonNull
        public c.e.a.b.w.c f1242f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NonNull
        public c.e.a.b.w.c f1243g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NonNull
        public c.e.a.b.w.c f1244h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NonNull
        public f f1245i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NonNull
        public f f1246j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @NonNull
        public f f1247k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @NonNull
        public f f1248l;

        public b() {
            this.a = new k();
            this.f1238b = new k();
            this.f1239c = new k();
            this.f1240d = new k();
            this.f1241e = new c.e.a.b.w.a(0.0f);
            this.f1242f = new c.e.a.b.w.a(0.0f);
            this.f1243g = new c.e.a.b.w.a(0.0f);
            this.f1244h = new c.e.a.b.w.a(0.0f);
            this.f1245i = new f();
            this.f1246j = new f();
            this.f1247k = new f();
            this.f1248l = new f();
        }

        public static float b(d dVar) {
            if (dVar instanceof k) {
                Objects.requireNonNull((k) dVar);
                return -1.0f;
            }
            if (dVar instanceof e) {
                Objects.requireNonNull((e) dVar);
            }
            return -1.0f;
        }

        @NonNull
        public l a() {
            return new l(this, null);
        }

        @NonNull
        public b c(@Dimension float f2) {
            this.f1241e = new c.e.a.b.w.a(f2);
            this.f1242f = new c.e.a.b.w.a(f2);
            this.f1243g = new c.e.a.b.w.a(f2);
            this.f1244h = new c.e.a.b.w.a(f2);
            return this;
        }

        @NonNull
        public b d(@Dimension float f2) {
            this.f1244h = new c.e.a.b.w.a(f2);
            return this;
        }

        @NonNull
        public b e(@Dimension float f2) {
            this.f1243g = new c.e.a.b.w.a(f2);
            return this;
        }

        @NonNull
        public b f(@Dimension float f2) {
            this.f1241e = new c.e.a.b.w.a(f2);
            return this;
        }

        @NonNull
        public b g(@Dimension float f2) {
            this.f1242f = new c.e.a.b.w.a(f2);
            return this;
        }

        public b(@NonNull l lVar) {
            this.a = new k();
            this.f1238b = new k();
            this.f1239c = new k();
            this.f1240d = new k();
            this.f1241e = new c.e.a.b.w.a(0.0f);
            this.f1242f = new c.e.a.b.w.a(0.0f);
            this.f1243g = new c.e.a.b.w.a(0.0f);
            this.f1244h = new c.e.a.b.w.a(0.0f);
            this.f1245i = new f();
            this.f1246j = new f();
            this.f1247k = new f();
            this.f1248l = new f();
            this.a = lVar.f1227b;
            this.f1238b = lVar.f1228c;
            this.f1239c = lVar.f1229d;
            this.f1240d = lVar.f1230e;
            this.f1241e = lVar.f1231f;
            this.f1242f = lVar.f1232g;
            this.f1243g = lVar.f1233h;
            this.f1244h = lVar.f1234i;
            this.f1245i = lVar.f1235j;
            this.f1246j = lVar.f1236k;
            this.f1247k = lVar.f1237l;
            this.f1248l = lVar.m;
        }
    }

    public l() {
        this.f1227b = new k();
        this.f1228c = new k();
        this.f1229d = new k();
        this.f1230e = new k();
        this.f1231f = new c.e.a.b.w.a(0.0f);
        this.f1232g = new c.e.a.b.w.a(0.0f);
        this.f1233h = new c.e.a.b.w.a(0.0f);
        this.f1234i = new c.e.a.b.w.a(0.0f);
        this.f1235j = new f();
        this.f1236k = new f();
        this.f1237l = new f();
        this.m = new f();
    }
}
