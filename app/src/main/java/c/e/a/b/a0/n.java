package c.e.a.b.a0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputLayout f873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Animator f877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public CharSequence f881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public TextView f883l;

    @Nullable
    public CharSequence m;
    public int n;

    @Nullable
    public ColorStateList o;
    public CharSequence p;
    public boolean q;

    @Nullable
    public TextView r;
    public int s;

    @Nullable
    public ColorStateList t;
    public Typeface u;

    /* JADX INFO: compiled from: IndicatorViewController.java */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f886d;

        public a(int i2, TextView textView, int i3, TextView textView2) {
            this.a = i2;
            this.f884b = textView;
            this.f885c = i3;
            this.f886d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView;
            n nVar = n.this;
            nVar.f879h = this.a;
            nVar.f877f = null;
            TextView textView2 = this.f884b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.f885c == 1 && (textView = n.this.f883l) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.f886d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.f886d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f886d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public n(@NonNull TextInputLayout textInputLayout) {
        this.a = textInputLayout.getContext();
        this.f873b = textInputLayout;
        this.f878g = r0.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    public void a(TextView textView, int i2) {
        if (this.f874c == null && this.f876e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.f874c = linearLayout;
            linearLayout.setOrientation(0);
            this.f873b.addView(this.f874c, -1, -2);
            this.f876e = new FrameLayout(this.a);
            this.f874c.addView(this.f876e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f873b.getEditText() != null) {
                b();
            }
        }
        if (i2 == 0 || i2 == 1) {
            this.f876e.setVisibility(0);
            this.f876e.addView(textView);
        } else {
            this.f874c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f874c.setVisibility(0);
        this.f875d++;
    }

    public void b() {
        if ((this.f874c == null || this.f873b.getEditText() == null) ? false : true) {
            EditText editText = this.f873b.getEditText();
            boolean zX3 = c.b.a.m.f.x3(this.a);
            LinearLayout linearLayout = this.f874c;
            int i2 = R$dimen.material_helper_text_font_1_3_padding_horizontal;
            ViewCompat.setPaddingRelative(linearLayout, h(zX3, i2, ViewCompat.getPaddingStart(editText)), h(zX3, R$dimen.material_helper_text_font_1_3_padding_top, this.a.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), h(zX3, i2, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    public void c() {
        Animator animator = this.f877f;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(@NonNull List<Animator> list, boolean z, @Nullable TextView textView, int i2, int i3, int i4) {
        if (textView == null || !z) {
            return;
        }
        if (i2 == i4 || i2 == i3) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, i4 == i2 ? 1.0f : 0.0f);
            objectAnimatorOfFloat.setDuration(167L);
            objectAnimatorOfFloat.setInterpolator(c.e.a.b.a.a.a);
            list.add(objectAnimatorOfFloat);
            if (i4 == i2) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f878g, 0.0f);
                objectAnimatorOfFloat2.setDuration(217L);
                objectAnimatorOfFloat2.setInterpolator(c.e.a.b.a.a.f841d);
                list.add(objectAnimatorOfFloat2);
            }
        }
    }

    public boolean e() {
        return (this.f880i != 1 || this.f883l == null || TextUtils.isEmpty(this.f881j)) ? false : true;
    }

    @Nullable
    public final TextView f(int i2) {
        if (i2 == 1) {
            return this.f883l;
        }
        if (i2 != 2) {
            return null;
        }
        return this.r;
    }

    @ColorInt
    public int g() {
        TextView textView = this.f883l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int h(boolean z, @DimenRes int i2, int i3) {
        return z ? this.a.getResources().getDimensionPixelSize(i2) : i3;
    }

    public void i() {
        this.f881j = null;
        c();
        if (this.f879h == 1) {
            if (!this.q || TextUtils.isEmpty(this.p)) {
                this.f880i = 0;
            } else {
                this.f880i = 2;
            }
        }
        l(this.f879h, this.f880i, k(this.f883l, null));
    }

    public void j(TextView textView, int i2) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f874c;
        if (linearLayout == null) {
            return;
        }
        if (!(i2 == 0 || i2 == 1) || (frameLayout = this.f876e) == null) {
            linearLayout.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i3 = this.f875d - 1;
        this.f875d = i3;
        LinearLayout linearLayout2 = this.f874c;
        if (i3 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean k(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.f873b) && this.f873b.isEnabled() && !(this.f880i == this.f879h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public final void l(int i2, int i3, boolean z) {
        TextView textViewF;
        TextView textViewF2;
        if (i2 == i3) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f877f = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.q, this.r, 2, i2, i3);
            d(arrayList, this.f882k, this.f883l, 1, i2, i3);
            c.b.a.m.f.k4(animatorSet, arrayList);
            animatorSet.addListener(new a(i3, f(i2), i2, f(i3)));
            animatorSet.start();
        } else if (i2 != i3) {
            if (i3 != 0 && (textViewF2 = f(i3)) != null) {
                textViewF2.setVisibility(0);
                textViewF2.setAlpha(1.0f);
            }
            if (i2 != 0 && (textViewF = f(i2)) != null) {
                textViewF.setVisibility(4);
                if (i2 == 1) {
                    textViewF.setText((CharSequence) null);
                }
            }
            this.f879h = i3;
        }
        this.f873b.v();
        this.f873b.x(z, false);
        this.f873b.E();
    }
}
