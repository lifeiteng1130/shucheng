package c.e.a.b.t;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {

    @Nullable
    public final ColorStateList a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final ColorStateList f1190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f1191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f1194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f1195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f1196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f1198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @FontRes
    public final int f1200l;
    public boolean m = false;
    public Typeface n;

    /* JADX INFO: compiled from: TextAppearance.java */
    public class a extends ResourcesCompat.FontCallback {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i2) {
            b.this.m = true;
            this.a.a(i2);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            b bVar = b.this;
            bVar.n = Typeface.create(typeface, bVar.f1192d);
            b bVar2 = b.this;
            bVar2.m = true;
            this.a.b(bVar2.n, false);
        }
    }

    public b(@NonNull Context context, @StyleRes int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.TextAppearance);
        this.f1199k = typedArrayObtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.a = f.a2(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        f.a2(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        f.a2(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f1192d = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f1193e = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int i3 = R$styleable.TextAppearance_fontFamily;
        i3 = typedArrayObtainStyledAttributes.hasValue(i3) ? i3 : R$styleable.TextAppearance_android_fontFamily;
        this.f1200l = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
        this.f1191c = typedArrayObtainStyledAttributes.getString(i3);
        typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.f1190b = f.a2(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f1194f = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f1195g = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f1196h = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
        int i4 = R$styleable.MaterialTextAppearance_android_letterSpacing;
        this.f1197i = typedArrayObtainStyledAttributes2.hasValue(i4);
        this.f1198j = typedArrayObtainStyledAttributes2.getFloat(i4, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        if (this.n == null && (str = this.f1191c) != null) {
            this.n = Typeface.create(str, this.f1192d);
        }
        if (this.n == null) {
            int i2 = this.f1193e;
            if (i2 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.n = Typeface.SERIF;
            } else if (i2 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, this.f1192d);
        }
    }

    public void b(@NonNull Context context, @NonNull d dVar) {
        a();
        int i2 = this.f1200l;
        if (i2 == 0) {
            this.m = true;
        }
        if (this.m) {
            dVar.b(this.n, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i2, new a(dVar), null);
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            dVar.a(1);
        } catch (Exception unused2) {
            this.m = true;
            dVar.a(-3);
        }
    }

    public void c(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull d dVar) {
        a();
        d(textPaint, this.n);
        b(context, new c(this, textPaint, dVar));
        ColorStateList colorStateList = this.a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f2 = this.f1196h;
        float f3 = this.f1194f;
        float f4 = this.f1195g;
        ColorStateList colorStateList2 = this.f1190b;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void d(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f1192d;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f1199k);
        if (this.f1197i) {
            textPaint.setLetterSpacing(this.f1198j);
        }
    }
}
