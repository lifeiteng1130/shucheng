package c.e.a.b.q;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import c.e.a.b.q.d;
import c.e.a.b.t.a;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: CollapsingTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a {

    @Nullable
    public Bitmap A;
    public float B;
    public float C;
    public int[] D;
    public boolean E;

    @NonNull
    public final TextPaint F;

    @NonNull
    public final TextPaint G;
    public TimeInterpolator H;
    public TimeInterpolator I;
    public float J;
    public float K;
    public float L;
    public ColorStateList M;
    public float N;
    public float O;
    public float P;
    public ColorStateList Q;
    public float R;
    public float S;
    public StaticLayout T;
    public float U;
    public float V;
    public float W;
    public CharSequence X;
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Rect f1095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final Rect f1096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RectF f1097f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f1102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f1103l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public c.e.a.b.t.a v;
    public c.e.a.b.t.a w;

    @Nullable
    public CharSequence x;

    @Nullable
    public CharSequence y;
    public boolean z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1098g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1099h = 16;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f1100i = 15.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1101j = 15.0f;
    public int Y = 1;

    /* JADX INFO: renamed from: c.e.a.b.q.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CollapsingTextHelper.java */
    public class C0046a implements a.InterfaceC0047a {
        public C0046a() {
        }

        @Override // c.e.a.b.t.a.InterfaceC0047a
        public void a(Typeface typeface) {
            a.this.r(typeface);
        }
    }

    /* JADX INFO: compiled from: CollapsingTextHelper.java */
    public class b implements a.InterfaceC0047a {
        public b() {
        }

        @Override // c.e.a.b.t.a.InterfaceC0047a
        public void a(Typeface typeface) {
            a.this.v(typeface);
        }
    }

    public a(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(Token.EMPTY);
        this.F = textPaint;
        this.G = new TextPaint(textPaint);
        this.f1096e = new Rect();
        this.f1095d = new Rect();
        this.f1097f = new RectF();
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i3) * f2) + (Color.alpha(i2) * f3)), (int) ((Color.red(i3) * f2) + (Color.red(i2) * f3)), (int) ((Color.green(i3) * f2) + (Color.green(i2) * f3)), (int) ((Color.blue(i3) * f2) + (Color.blue(i2) * f3)));
    }

    public static float k(float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return c.e.a.b.a.a.a(f2, f3, f4);
    }

    public static boolean n(@NonNull Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    public void A(Typeface typeface) {
        boolean z;
        c.e.a.b.t.a aVar = this.w;
        boolean z2 = true;
        if (aVar != null) {
            aVar.f1189c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
            z = true;
        } else {
            z = false;
        }
        c.e.a.b.t.a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.f1189c = true;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z2 = false;
        }
        if (z || z2) {
            m();
        }
    }

    public float b() {
        if (this.x == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.f1101j);
        textPaint.setTypeface(this.s);
        textPaint.setLetterSpacing(this.R);
        TextPaint textPaint2 = this.G;
        CharSequence charSequence = this.x;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(@NonNull CharSequence charSequence) {
        return (ViewCompat.getLayoutDirection(this.a) == 1 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    public final void d(float f2) {
        this.f1097f.left = k(this.f1095d.left, this.f1096e.left, f2, this.H);
        this.f1097f.top = k(this.m, this.n, f2, this.H);
        this.f1097f.right = k(this.f1095d.right, this.f1096e.right, f2, this.H);
        this.f1097f.bottom = k(this.f1095d.bottom, this.f1096e.bottom, f2, this.H);
        this.q = k(this.o, this.p, f2, this.H);
        this.r = k(this.m, this.n, f2, this.H);
        x(k(this.f1100i, this.f1101j, f2, this.I));
        TimeInterpolator timeInterpolator = c.e.a.b.a.a.f839b;
        this.U = 1.0f - k(0.0f, 1.0f, 1.0f - f2, timeInterpolator);
        ViewCompat.postInvalidateOnAnimation(this.a);
        this.V = k(1.0f, 0.0f, f2, timeInterpolator);
        ViewCompat.postInvalidateOnAnimation(this.a);
        ColorStateList colorStateList = this.f1103l;
        ColorStateList colorStateList2 = this.f1102k;
        if (colorStateList != colorStateList2) {
            this.F.setColor(a(j(colorStateList2), i(), f2));
        } else {
            this.F.setColor(i());
        }
        float f3 = this.R;
        float f4 = this.S;
        if (f3 != f4) {
            this.F.setLetterSpacing(k(f4, f3, f2, timeInterpolator));
        } else {
            this.F.setLetterSpacing(f3);
        }
        this.F.setShadowLayer(k(this.N, this.J, f2, null), k(this.O, this.K, f2, null), k(this.P, this.L, f2, null), a(j(this.Q), j(this.M), f2));
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    public final void e(float f2) {
        boolean z;
        float f3;
        StaticLayout staticLayoutA;
        if (this.x == null) {
            return;
        }
        float fWidth = this.f1096e.width();
        float fWidth2 = this.f1095d.width();
        if (Math.abs(f2 - this.f1101j) < 0.001f) {
            f3 = this.f1101j;
            this.B = 1.0f;
            Typeface typeface = this.u;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.u = typeface2;
                z = true;
            } else {
                z = false;
            }
        } else {
            float f4 = this.f1100i;
            Typeface typeface3 = this.u;
            Typeface typeface4 = this.t;
            if (typeface3 != typeface4) {
                this.u = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (Math.abs(f2 - f4) < 0.001f) {
                this.B = 1.0f;
            } else {
                this.B = f2 / this.f1100i;
            }
            float f5 = this.f1101j / this.f1100i;
            fWidth = fWidth2 * f5 > fWidth ? Math.min(fWidth / f5, fWidth2) : fWidth2;
            f3 = f4;
        }
        if (fWidth > 0.0f) {
            z = this.C != f3 || this.E || z;
            this.C = f3;
            this.E = false;
        }
        if (this.y == null || z) {
            this.F.setTextSize(this.C);
            this.F.setTypeface(this.u);
            this.F.setLinearText(this.B != 1.0f);
            boolean zC = c(this.x);
            this.z = zC;
            int i2 = this.Y;
            int i3 = i2 > 1 && !zC ? i2 : 1;
            try {
                d dVar = new d(this.x, this.F, (int) fWidth);
                dVar.f1119l = TextUtils.TruncateAt.END;
                dVar.f1118k = zC;
                dVar.f1115h = Layout.Alignment.ALIGN_NORMAL;
                dVar.f1117j = false;
                dVar.f1116i = i3;
                staticLayoutA = dVar.a();
            } catch (d.a e2) {
                e2.getCause().getMessage();
                staticLayoutA = null;
            }
            StaticLayout staticLayout = (StaticLayout) Preconditions.checkNotNull(staticLayoutA);
            this.T = staticLayout;
            this.y = staticLayout.getText();
        }
    }

    public final void f() {
        Bitmap bitmap = this.A;
        if (bitmap != null) {
            bitmap.recycle();
            this.A = null;
        }
    }

    public void g(@NonNull Canvas canvas) {
        int iSave = canvas.save();
        if (this.y == null || !this.f1093b) {
            return;
        }
        float lineLeft = (this.T.getLineLeft(0) + this.q) - (this.W * 2.0f);
        this.F.setTextSize(this.C);
        float f2 = this.q;
        float f3 = this.r;
        float f4 = this.B;
        if (f4 != 1.0f) {
            canvas.scale(f4, f4, f2, f3);
        }
        if (this.Y > 1 && !this.z) {
            int alpha = this.F.getAlpha();
            canvas.translate(lineLeft, f3);
            float f5 = alpha;
            this.F.setAlpha((int) (this.V * f5));
            this.T.draw(canvas);
            this.F.setAlpha((int) (this.U * f5));
            int lineBaseline = this.T.getLineBaseline(0);
            CharSequence charSequence = this.X;
            float f6 = lineBaseline;
            canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6, this.F);
            String strTrim = this.X.toString().trim();
            if (strTrim.endsWith("…")) {
                strTrim = strTrim.substring(0, strTrim.length() - 1);
            }
            String str = strTrim;
            this.F.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.T.getLineEnd(0), str.length()), 0.0f, f6, (Paint) this.F);
        } else {
            canvas.translate(f2, f3);
            this.T.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    public float h() {
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.f1101j);
        textPaint.setTypeface(this.s);
        textPaint.setLetterSpacing(this.R);
        return -this.G.ascent();
    }

    @ColorInt
    public int i() {
        return j(this.f1103l);
    }

    @ColorInt
    public final int j(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.D;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void l() {
        this.f1093b = this.f1096e.width() > 0 && this.f1096e.height() > 0 && this.f1095d.width() > 0 && this.f1095d.height() > 0;
    }

    public void m() {
        StaticLayout staticLayout;
        if (this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
            return;
        }
        float f2 = this.C;
        e(this.f1101j);
        CharSequence charSequence = this.y;
        if (charSequence != null && (staticLayout = this.T) != null) {
            this.X = TextUtils.ellipsize(charSequence, this.F, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.X;
        float fMeasureText = charSequence2 != null ? this.F.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f1099h, this.z ? 1 : 0);
        int i2 = absoluteGravity & 112;
        if (i2 == 48) {
            this.n = this.f1096e.top;
        } else if (i2 != 80) {
            this.n = this.f1096e.centerY() - ((this.F.descent() - this.F.ascent()) / 2.0f);
        } else {
            this.n = this.F.ascent() + this.f1096e.bottom;
        }
        int i3 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i3 == 1) {
            this.p = this.f1096e.centerX() - (fMeasureText / 2.0f);
        } else if (i3 != 5) {
            this.p = this.f1096e.left;
        } else {
            this.p = this.f1096e.right - fMeasureText;
        }
        e(this.f1100i);
        float height = this.T != null ? r1.getHeight() : 0.0f;
        CharSequence charSequence3 = this.y;
        float fMeasureText2 = charSequence3 != null ? this.F.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout2 = this.T;
        if (staticLayout2 != null && this.Y > 1 && !this.z) {
            fMeasureText2 = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.T;
        this.W = staticLayout3 != null ? staticLayout3.getLineLeft(0) : 0.0f;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f1098g, this.z ? 1 : 0);
        int i4 = absoluteGravity2 & 112;
        if (i4 == 48) {
            this.m = this.f1095d.top;
        } else if (i4 != 80) {
            this.m = this.f1095d.centerY() - (height / 2.0f);
        } else {
            this.m = this.F.descent() + (this.f1095d.bottom - height);
        }
        int i5 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i5 == 1) {
            this.o = this.f1095d.centerX() - (fMeasureText2 / 2.0f);
        } else if (i5 != 5) {
            this.o = this.f1095d.left;
        } else {
            this.o = this.f1095d.right - fMeasureText2;
        }
        f();
        x(f2);
        d(this.f1094c);
    }

    public void o(int i2) {
        c.e.a.b.t.b bVar = new c.e.a.b.t.b(this.a.getContext(), i2);
        ColorStateList colorStateList = bVar.a;
        if (colorStateList != null) {
            this.f1103l = colorStateList;
        }
        float f2 = bVar.f1199k;
        if (f2 != 0.0f) {
            this.f1101j = f2;
        }
        ColorStateList colorStateList2 = bVar.f1190b;
        if (colorStateList2 != null) {
            this.M = colorStateList2;
        }
        this.K = bVar.f1194f;
        this.L = bVar.f1195g;
        this.J = bVar.f1196h;
        this.R = bVar.f1198j;
        c.e.a.b.t.a aVar = this.w;
        if (aVar != null) {
            aVar.f1189c = true;
        }
        C0046a c0046a = new C0046a();
        bVar.a();
        this.w = new c.e.a.b.t.a(c0046a, bVar.n);
        bVar.b(this.a.getContext(), this.w);
        m();
    }

    public void p(ColorStateList colorStateList) {
        if (this.f1103l != colorStateList) {
            this.f1103l = colorStateList;
            m();
        }
    }

    public void q(int i2) {
        if (this.f1099h != i2) {
            this.f1099h = i2;
            m();
        }
    }

    public void r(Typeface typeface) {
        c.e.a.b.t.a aVar = this.w;
        boolean z = true;
        if (aVar != null) {
            aVar.f1189c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
        } else {
            z = false;
        }
        if (z) {
            m();
        }
    }

    public void s(int i2) {
        c.e.a.b.t.b bVar = new c.e.a.b.t.b(this.a.getContext(), i2);
        ColorStateList colorStateList = bVar.a;
        if (colorStateList != null) {
            this.f1102k = colorStateList;
        }
        float f2 = bVar.f1199k;
        if (f2 != 0.0f) {
            this.f1100i = f2;
        }
        ColorStateList colorStateList2 = bVar.f1190b;
        if (colorStateList2 != null) {
            this.Q = colorStateList2;
        }
        this.O = bVar.f1194f;
        this.P = bVar.f1195g;
        this.N = bVar.f1196h;
        this.S = bVar.f1198j;
        c.e.a.b.t.a aVar = this.v;
        if (aVar != null) {
            aVar.f1189c = true;
        }
        b bVar2 = new b();
        bVar.a();
        this.v = new c.e.a.b.t.a(bVar2, bVar.n);
        bVar.b(this.a.getContext(), this.v);
        m();
    }

    public void t(ColorStateList colorStateList) {
        if (this.f1102k != colorStateList) {
            this.f1102k = colorStateList;
            m();
        }
    }

    public void u(int i2) {
        if (this.f1098g != i2) {
            this.f1098g = i2;
            m();
        }
    }

    public void v(Typeface typeface) {
        c.e.a.b.t.a aVar = this.v;
        boolean z = true;
        if (aVar != null) {
            aVar.f1189c = true;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z = false;
        }
        if (z) {
            m();
        }
    }

    public void w(float f2) {
        float fClamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        if (fClamp != this.f1094c) {
            this.f1094c = fClamp;
            d(fClamp);
        }
    }

    public final void x(float f2) {
        e(f2);
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    public final boolean y(int[] iArr) {
        ColorStateList colorStateList;
        this.D = iArr;
        ColorStateList colorStateList2 = this.f1103l;
        if (!((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1102k) != null && colorStateList.isStateful()))) {
            return false;
        }
        m();
        return true;
    }

    public void z(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.x, charSequence)) {
            this.x = charSequence;
            this.y = null;
            f();
            m();
        }
    }
}
