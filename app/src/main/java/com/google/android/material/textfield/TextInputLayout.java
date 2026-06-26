package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import c.e.a.b.a0.g;
import c.e.a.b.a0.h;
import c.e.a.b.a0.m;
import c.e.a.b.a0.n;
import c.e.a.b.a0.o;
import c.e.a.b.a0.p;
import c.e.a.b.w.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public static final int a = R$style.Widget_Design_TextInputLayout;
    public CharSequence A;
    public ColorStateList A0;
    public boolean B;

    @ColorInt
    public int B0;

    @Nullable
    public MaterialShapeDrawable C;

    @ColorInt
    public int C0;

    @Nullable
    public MaterialShapeDrawable D;

    @ColorInt
    public int D0;

    @NonNull
    public l E;

    @ColorInt
    public int E0;
    public final int F;

    @ColorInt
    public int F0;
    public int G;
    public boolean G0;
    public int H;
    public final c.e.a.b.q.a H0;
    public int I;
    public boolean I0;
    public int J;
    public boolean J0;
    public int K;
    public ValueAnimator K0;
    public boolean L0;
    public boolean M0;

    @ColorInt
    public int O;

    @ColorInt
    public int P;
    public final Rect Q;
    public final Rect R;
    public final RectF S;
    public Typeface T;

    @NonNull
    public final CheckableImageButton U;
    public ColorStateList V;
    public boolean W;
    public PorterDuff.Mode a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f2446b;
    public boolean b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2447c;

    @Nullable
    public Drawable c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2448d;
    public int d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f2449e;
    public View.OnLongClickListener e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f2450f;
    public final LinkedHashSet<e> f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f2451g;
    public int g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f2452h;
    public final SparseArray<m> h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2453i;

    @NonNull
    public final CheckableImageButton i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2454j;
    public final LinkedHashSet<f> j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2455k;
    public ColorStateList k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public TextView f2456l;
    public boolean l0;
    public int m;
    public PorterDuff.Mode m0;
    public int n;
    public boolean n0;
    public CharSequence o;

    @Nullable
    public Drawable o0;
    public boolean p;
    public int p0;
    public TextView q;
    public Drawable q0;

    @Nullable
    public ColorStateList r;
    public View.OnLongClickListener r0;
    public int s;
    public View.OnLongClickListener s0;

    @Nullable
    public ColorStateList t;

    @NonNull
    public final CheckableImageButton t0;

    @Nullable
    public ColorStateList u;
    public ColorStateList u0;

    @Nullable
    public CharSequence v;
    public ColorStateList v0;

    @NonNull
    public final TextView w;
    public ColorStateList w0;

    @Nullable
    public CharSequence x;

    @ColorInt
    public int x0;

    @NonNull
    public final TextView y;

    @ColorInt
    public int y0;
    public boolean z;

    @ColorInt
    public int z0;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final TextInputLayout a;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.a.getHint();
            CharSequence error = this.a.getError();
            CharSequence placeholderText = this.a.getPlaceholderText();
            int counterMaxLength = this.a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.a.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.a.G0;
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z2 ? hint.toString() : "";
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfoCompat.setText(string);
                if (z3 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(string);
                } else {
                    if (z) {
                        string = ((Object) text) + ", " + string;
                    }
                    accessibilityNodeInfoCompat.setText(string);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(R$id.textinput_helper_text);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface EndIconMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        @Nullable
        public CharSequence a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public CharSequence f2458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public CharSequence f2459d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public CharSequence f2460e;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("TextInputLayout.SavedState{");
            sbR.append(Integer.toHexString(System.identityHashCode(this)));
            sbR.append(" error=");
            sbR.append((Object) this.a);
            sbR.append(" hint=");
            sbR.append((Object) this.f2458c);
            sbR.append(" helperText=");
            sbR.append((Object) this.f2459d);
            sbR.append(" placeholderText=");
            sbR.append((Object) this.f2460e);
            sbR.append("}");
            return sbR.toString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.a, parcel, i2);
            parcel.writeInt(this.f2457b ? 1 : 0);
            TextUtils.writeToParcel(this.f2458c, parcel, i2);
            TextUtils.writeToParcel(this.f2459d, parcel, i2);
            TextUtils.writeToParcel(this.f2460e, parcel, i2);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2457b = parcel.readInt() == 1;
            this.f2458c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2459d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2460e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout.this.x(!r0.M0, false);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f2453i) {
                textInputLayout.s(editable.length());
            }
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.p) {
                textInputLayout2.y(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.i0.performClick();
            TextInputLayout.this.i0.jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f2450f.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.H0.w(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public interface e {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    public interface f {
        void a(@NonNull TextInputLayout textInputLayout, int i2);
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    private m getEndIconDelegate() {
        m mVar = this.h0.get(this.g0);
        return mVar != null ? mVar : this.h0.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.t0.getVisibility() == 0) {
            return this.t0;
        }
        if (i() && j()) {
            return this.i0;
        }
        return null;
    }

    public static void m(@NonNull ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z);
            }
        }
    }

    public static void p(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        ViewCompat.setImportantForAccessibility(checkableImageButton, z2 ? 1 : 2);
    }

    private void setEditText(EditText editText) {
        if (this.f2450f != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.g0 != 3) {
            boolean z = editText instanceof TextInputEditText;
        }
        this.f2450f = editText;
        k();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.H0.A(this.f2450f.getTypeface());
        c.e.a.b.q.a aVar = this.H0;
        float textSize = this.f2450f.getTextSize();
        if (aVar.f1100i != textSize) {
            aVar.f1100i = textSize;
            aVar.m();
        }
        int gravity = this.f2450f.getGravity();
        this.H0.q((gravity & (-113)) | 48);
        this.H0.u(gravity);
        this.f2450f.addTextChangedListener(new a());
        if (this.v0 == null) {
            this.v0 = this.f2450f.getHintTextColors();
        }
        if (this.z) {
            if (TextUtils.isEmpty(this.A)) {
                CharSequence hint = this.f2450f.getHint();
                this.f2451g = hint;
                setHint(hint);
                this.f2450f.setHint((CharSequence) null);
            }
            this.B = true;
        }
        if (this.f2456l != null) {
            s(this.f2450f.getText().length());
        }
        v();
        this.f2452h.b();
        this.f2447c.bringToFront();
        this.f2448d.bringToFront();
        this.f2449e.bringToFront();
        this.t0.bringToFront();
        Iterator<e> it = this.f0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        z();
        C();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        x(false, true);
    }

    private void setErrorIconVisible(boolean z) {
        this.t0.setVisibility(z ? 0 : 8);
        this.f2449e.setVisibility(z ? 8 : 0);
        C();
        if (i()) {
            return;
        }
        u();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.A)) {
            return;
        }
        this.A = charSequence;
        this.H0.z(charSequence);
        if (this.G0) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.p == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.q = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            ViewCompat.setAccessibilityLiveRegion(this.q, 1);
            setPlaceholderTextAppearance(this.s);
            setPlaceholderTextColor(this.r);
            TextView textView = this.q;
            if (textView != null) {
                this.f2446b.addView(textView);
                this.q.setVisibility(0);
            }
        } else {
            TextView textView2 = this.q;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            this.q = null;
        }
        this.p = z;
    }

    public final void A() {
        this.w.setVisibility((this.v == null || this.G0) ? 8 : 0);
        u();
    }

    public final void B(boolean z, boolean z2) {
        int defaultColor = this.A0.getDefaultColor();
        int colorForState = this.A0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.A0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.O = colorForState2;
        } else if (z2) {
            this.O = colorForState;
        } else {
            this.O = defaultColor;
        }
    }

    public final void C() {
        if (this.f2450f == null) {
            return;
        }
        int paddingEnd = 0;
        if (!j()) {
            if (!(this.t0.getVisibility() == 0)) {
                paddingEnd = ViewCompat.getPaddingEnd(this.f2450f);
            }
        }
        ViewCompat.setPaddingRelative(this.y, getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.f2450f.getPaddingTop(), paddingEnd, this.f2450f.getPaddingBottom());
    }

    public final void D() {
        int visibility = this.y.getVisibility();
        boolean z = (this.x == null || this.G0) ? false : true;
        this.y.setVisibility(z ? 0 : 8);
        if (visibility != this.y.getVisibility()) {
            getEndIconDelegate().c(z);
        }
        u();
    }

    public void E() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.C == null || this.G == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.f2450f) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.f2450f) != null && editText.isHovered());
        if (!isEnabled()) {
            this.O = this.F0;
        } else if (this.f2452h.e()) {
            if (this.A0 != null) {
                B(z2, z3);
            } else {
                this.O = this.f2452h.g();
            }
        } else if (!this.f2455k || (textView = this.f2456l) == null) {
            if (z2) {
                this.O = this.z0;
            } else if (z3) {
                this.O = this.y0;
            } else {
                this.O = this.x0;
            }
        } else if (this.A0 != null) {
            B(z2, z3);
        } else {
            this.O = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null) {
            n nVar = this.f2452h;
            if (nVar.f882k && nVar.e()) {
                z = true;
            }
        }
        setErrorIconVisible(z);
        o(this.t0, this.u0);
        o(this.U, this.V);
        n();
        m endIconDelegate = getEndIconDelegate();
        Objects.requireNonNull(endIconDelegate);
        if (endIconDelegate instanceof h) {
            if (!this.f2452h.e() || getEndIconDrawable() == null) {
                c();
            } else {
                Drawable drawableMutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
                DrawableCompat.setTint(drawableMutate, this.f2452h.g());
                this.i0.setImageDrawable(drawableMutate);
            }
        }
        if (z2 && isEnabled()) {
            this.I = this.K;
        } else {
            this.I = this.J;
        }
        if (this.G == 1) {
            if (!isEnabled()) {
                this.P = this.C0;
            } else if (z3 && !z2) {
                this.P = this.E0;
            } else if (z2) {
                this.P = this.D0;
            } else {
                this.P = this.B0;
            }
        }
        b();
    }

    @VisibleForTesting
    public void a(float f2) {
        if (this.H0.f1094c == f2) {
            return;
        }
        if (this.K0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.K0 = valueAnimator;
            valueAnimator.setInterpolator(c.e.a.b.a.a.f839b);
            this.K0.setDuration(167L);
            this.K0.addUpdateListener(new d());
        }
        this.K0.setFloatValues(this.H0.f1094c, f2);
        this.K0.start();
    }

    public void addOnEditTextAttachedListener(@NonNull e eVar) {
        this.f0.add(eVar);
        if (this.f2450f != null) {
            eVar.a(this);
        }
    }

    public void addOnEndIconChangedListener(@NonNull f fVar) {
        this.j0.add(fVar);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i2, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i2, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f2446b.addView(view, layoutParams2);
        this.f2446b.setLayoutParams(layoutParams);
        w();
        setEditText((EditText) view);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r6 = this;
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.C
            if (r0 != 0) goto L5
            return
        L5:
            c.e.a.b.w.l r1 = r6.E
            r0.setShapeAppearanceModel(r1)
            int r0 = r6.G
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L21
            int r0 = r6.I
            if (r0 <= r2) goto L1c
            int r0 = r6.O
            if (r0 == 0) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L21
            r0 = 1
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 == 0) goto L2e
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.C
            int r1 = r6.I
            float r1 = (float) r1
            int r5 = r6.O
            r0.w(r1, r5)
        L2e:
            int r0 = r6.P
            int r1 = r6.G
            if (r1 != r4) goto L44
            int r0 = com.google.android.material.R$attr.colorSurface
            android.content.Context r1 = r6.getContext()
            int r0 = c.b.a.m.f.Y1(r1, r0, r3)
            int r1 = r6.P
            int r0 = androidx.core.graphics.ColorUtils.compositeColors(r1, r0)
        L44:
            r6.P = r0
            com.google.android.material.shape.MaterialShapeDrawable r1 = r6.C
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.q(r0)
            int r0 = r6.g0
            r1 = 3
            if (r0 != r1) goto L5d
            android.widget.EditText r0 = r6.f2450f
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            r0.invalidateSelf()
        L5d:
            com.google.android.material.shape.MaterialShapeDrawable r0 = r6.D
            if (r0 != 0) goto L62
            goto L79
        L62:
            int r1 = r6.I
            if (r1 <= r2) goto L6b
            int r1 = r6.O
            if (r1 == 0) goto L6b
            r3 = 1
        L6b:
            if (r3 == 0) goto L76
            int r1 = r6.O
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.q(r1)
        L76:
            r6.invalidate()
        L79:
            r6.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.b():void");
    }

    public final void c() {
        d(this.i0, this.l0, this.k0, this.n0, this.m0);
    }

    public final void d(@NonNull CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z2) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i2) {
        EditText editText = this.f2450f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f2451g != null) {
            boolean z = this.B;
            this.B = false;
            CharSequence hint = editText.getHint();
            this.f2450f.setHint(this.f2451g);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
                return;
            } finally {
                this.f2450f.setHint(hint);
                this.B = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i2);
        onProvideAutofillVirtualStructure(viewStructure, i2);
        viewStructure.setChildCount(this.f2446b.getChildCount());
        for (int i3 = 0; i3 < this.f2446b.getChildCount(); i3++) {
            View childAt = this.f2446b.getChildAt(i3);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i3);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i2);
            if (childAt == this.f2450f) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.M0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.M0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.z) {
            this.H0.g(canvas);
        }
        MaterialShapeDrawable materialShapeDrawable = this.D;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.I;
            this.D.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.L0) {
            return;
        }
        this.L0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        c.e.a.b.q.a aVar = this.H0;
        boolean zY = aVar != null ? aVar.y(drawableState) | false : false;
        if (this.f2450f != null) {
            x(ViewCompat.isLaidOut(this) && isEnabled(), false);
        }
        v();
        E();
        if (zY) {
            invalidate();
        }
        this.L0 = false;
    }

    public final int e() {
        float fH;
        if (!this.z) {
            return 0;
        }
        int i2 = this.G;
        if (i2 == 0 || i2 == 1) {
            fH = this.H0.h();
        } else {
            if (i2 != 2) {
                return 0;
            }
            fH = this.H0.h() / 2.0f;
        }
        return (int) fH;
    }

    public final boolean f() {
        return this.z && !TextUtils.isEmpty(this.A) && (this.C instanceof g);
    }

    public final int g(int i2, boolean z) {
        int compoundPaddingLeft = this.f2450f.getCompoundPaddingLeft() + i2;
        return (this.v == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.w.getMeasuredWidth()) + this.w.getPaddingLeft();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f2450f;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i2 = this.G;
        if (i2 == 1 || i2 == 2) {
            return this.C;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.P;
    }

    public int getBoxBackgroundMode() {
        return this.G;
    }

    public float getBoxCornerRadiusBottomEnd() {
        MaterialShapeDrawable materialShapeDrawable = this.C;
        return materialShapeDrawable.f2333c.a.f1234i.a(materialShapeDrawable.h());
    }

    public float getBoxCornerRadiusBottomStart() {
        MaterialShapeDrawable materialShapeDrawable = this.C;
        return materialShapeDrawable.f2333c.a.f1233h.a(materialShapeDrawable.h());
    }

    public float getBoxCornerRadiusTopEnd() {
        MaterialShapeDrawable materialShapeDrawable = this.C;
        return materialShapeDrawable.f2333c.a.f1232g.a(materialShapeDrawable.h());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.C.l();
    }

    public int getBoxStrokeColor() {
        return this.z0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.A0;
    }

    public int getBoxStrokeWidth() {
        return this.J;
    }

    public int getBoxStrokeWidthFocused() {
        return this.K;
    }

    public int getCounterMaxLength() {
        return this.f2454j;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f2453i && this.f2455k && (textView = this.f2456l) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.t;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.t;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.v0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f2450f;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.i0.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.i0.getDrawable();
    }

    public int getEndIconMode() {
        return this.g0;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.i0;
    }

    @Nullable
    public CharSequence getError() {
        n nVar = this.f2452h;
        if (nVar.f882k) {
            return nVar.f881j;
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f2452h.m;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.f2452h.g();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.t0.getDrawable();
    }

    @VisibleForTesting
    public final int getErrorTextCurrentColor() {
        return this.f2452h.g();
    }

    @Nullable
    public CharSequence getHelperText() {
        n nVar = this.f2452h;
        if (nVar.q) {
            return nVar.p;
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        TextView textView = this.f2452h.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public CharSequence getHint() {
        if (this.z) {
            return this.A;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.H0.h();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.H0.i();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.w0;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.i0.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.i0.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.p) {
            return this.o;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.s;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.r;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.v;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.w.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.w;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.U.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.U.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.x;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.y.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.y;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.T;
    }

    public final int h(int i2, boolean z) {
        int compoundPaddingRight = i2 - this.f2450f.getCompoundPaddingRight();
        return (this.v == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.w.getMeasuredWidth() - this.w.getPaddingRight());
    }

    public final boolean i() {
        return this.g0 != 0;
    }

    public boolean j() {
        return this.f2449e.getVisibility() == 0 && this.i0.getVisibility() == 0;
    }

    public final void k() {
        int i2 = this.G;
        if (i2 == 0) {
            this.C = null;
            this.D = null;
        } else if (i2 == 1) {
            this.C = new MaterialShapeDrawable(this.E);
            this.D = new MaterialShapeDrawable();
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException(c.a.a.a.a.o(new StringBuilder(), this.G, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.z || (this.C instanceof g)) {
                this.C = new MaterialShapeDrawable(this.E);
            } else {
                this.C = new g(this.E);
            }
            this.D = null;
        }
        EditText editText = this.f2450f;
        if ((editText == null || this.C == null || editText.getBackground() != null || this.G == 0) ? false : true) {
            ViewCompat.setBackground(this.f2450f, this.C);
        }
        E();
        if (this.G == 1) {
            if (c.b.a.m.f.y3(getContext())) {
                this.H = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (c.b.a.m.f.x3(getContext())) {
                this.H = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.f2450f != null && this.G == 1) {
            if (c.b.a.m.f.y3(getContext())) {
                EditText editText2 = this.f2450f;
                ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.f2450f), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (c.b.a.m.f.x3(getContext())) {
                EditText editText3 = this.f2450f;
                ViewCompat.setPaddingRelative(editText3, ViewCompat.getPaddingStart(editText3), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.f2450f), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.G != 0) {
            w();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.l():void");
    }

    public void n() {
        o(this.i0, this.k0);
    }

    public final void o(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTintList(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        EditText editText = this.f2450f;
        if (editText != null) {
            Rect rect = this.Q;
            c.e.a.b.q.b.a(this, editText, rect);
            MaterialShapeDrawable materialShapeDrawable = this.D;
            if (materialShapeDrawable != null) {
                int i6 = rect.bottom;
                materialShapeDrawable.setBounds(rect.left, i6 - this.K, rect.right, i6);
            }
            if (this.z) {
                c.e.a.b.q.a aVar = this.H0;
                float textSize = this.f2450f.getTextSize();
                if (aVar.f1100i != textSize) {
                    aVar.f1100i = textSize;
                    aVar.m();
                }
                int gravity = this.f2450f.getGravity();
                this.H0.q((gravity & (-113)) | 48);
                this.H0.u(gravity);
                c.e.a.b.q.a aVar2 = this.H0;
                if (this.f2450f == null) {
                    throw new IllegalStateException();
                }
                Rect rect2 = this.R;
                boolean z2 = false;
                boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
                rect2.bottom = rect.bottom;
                int i7 = this.G;
                if (i7 == 1) {
                    rect2.left = g(rect.left, z3);
                    rect2.top = rect.top + this.H;
                    rect2.right = h(rect.right, z3);
                } else if (i7 != 2) {
                    rect2.left = g(rect.left, z3);
                    rect2.top = getPaddingTop();
                    rect2.right = h(rect.right, z3);
                } else {
                    rect2.left = this.f2450f.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - e();
                    rect2.right = rect.right - this.f2450f.getPaddingRight();
                }
                Objects.requireNonNull(aVar2);
                int i8 = rect2.left;
                int i9 = rect2.top;
                int i10 = rect2.right;
                int i11 = rect2.bottom;
                if (!c.e.a.b.q.a.n(aVar2.f1096e, i8, i9, i10, i11)) {
                    aVar2.f1096e.set(i8, i9, i10, i11);
                    aVar2.E = true;
                    aVar2.l();
                }
                c.e.a.b.q.a aVar3 = this.H0;
                if (this.f2450f == null) {
                    throw new IllegalStateException();
                }
                Rect rect3 = this.R;
                TextPaint textPaint = aVar3.G;
                textPaint.setTextSize(aVar3.f1100i);
                textPaint.setTypeface(aVar3.t);
                textPaint.setLetterSpacing(aVar3.S);
                float f2 = -aVar3.G.ascent();
                rect3.left = this.f2450f.getCompoundPaddingLeft() + rect.left;
                rect3.top = this.G == 1 && this.f2450f.getMinLines() <= 1 ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.f2450f.getCompoundPaddingTop();
                rect3.right = rect.right - this.f2450f.getCompoundPaddingRight();
                if (this.G == 1 && this.f2450f.getMinLines() <= 1) {
                    z2 = true;
                }
                int compoundPaddingBottom = z2 ? (int) (rect3.top + f2) : rect.bottom - this.f2450f.getCompoundPaddingBottom();
                rect3.bottom = compoundPaddingBottom;
                int i12 = rect3.left;
                int i13 = rect3.top;
                int i14 = rect3.right;
                if (!c.e.a.b.q.a.n(aVar3.f1095d, i12, i13, i14, compoundPaddingBottom)) {
                    aVar3.f1095d.set(i12, i13, i14, compoundPaddingBottom);
                    aVar3.E = true;
                    aVar3.l();
                }
                this.H0.m();
                if (!f() || this.G0) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        EditText editText;
        int iMax;
        super.onMeasure(i2, i3);
        boolean z = false;
        if (this.f2450f != null && this.f2450f.getMeasuredHeight() < (iMax = Math.max(this.f2448d.getMeasuredHeight(), this.f2447c.getMeasuredHeight()))) {
            this.f2450f.setMinimumHeight(iMax);
            z = true;
        }
        boolean zU = u();
        if (z || zU) {
            this.f2450f.post(new c());
        }
        if (this.q != null && (editText = this.f2450f) != null) {
            this.q.setGravity(editText.getGravity());
            this.q.setPadding(this.f2450f.getCompoundPaddingLeft(), this.f2450f.getCompoundPaddingTop(), this.f2450f.getCompoundPaddingRight(), this.f2450f.getCompoundPaddingBottom());
        }
        z();
        C();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.a);
        if (savedState.f2457b) {
            this.i0.post(new b());
        }
        setHint(savedState.f2458c);
        setHelperText(savedState.f2459d);
        setPlaceholderText(savedState.f2460e);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f2452h.e()) {
            savedState.a = getError();
        }
        savedState.f2457b = i() && this.i0.isChecked();
        savedState.f2458c = getHint();
        savedState.f2459d = getHelperText();
        savedState.f2460e = getPlaceholderText();
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(@androidx.annotation.NonNull android.widget.TextView r3, @androidx.annotation.StyleRes int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R$style.TextAppearance_AppCompat_Caption
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R$color.design_error
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q(android.widget.TextView, int):void");
    }

    public final void r() {
        if (this.f2456l != null) {
            EditText editText = this.f2450f;
            s(editText == null ? 0 : editText.getText().length());
        }
    }

    public void removeOnEditTextAttachedListener(@NonNull e eVar) {
        this.f0.remove(eVar);
    }

    public void removeOnEndIconChangedListener(@NonNull f fVar) {
        this.j0.remove(fVar);
    }

    public void s(int i2) {
        boolean z = this.f2455k;
        int i3 = this.f2454j;
        if (i3 == -1) {
            this.f2456l.setText(String.valueOf(i2));
            this.f2456l.setContentDescription(null);
            this.f2455k = false;
        } else {
            this.f2455k = i2 > i3;
            Context context = getContext();
            this.f2456l.setContentDescription(context.getString(this.f2455k ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(this.f2454j)));
            if (z != this.f2455k) {
                t();
            }
            this.f2456l.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.f2454j))));
        }
        if (this.f2450f == null || z == this.f2455k) {
            return;
        }
        x(false, false);
        E();
        v();
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.P != i2) {
            this.P = i2;
            this.B0 = i2;
            this.D0 = i2;
            this.E0 = i2;
            b();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.B0 = defaultColor;
        this.P = defaultColor;
        this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.D0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.E0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.G) {
            return;
        }
        this.G = i2;
        if (this.f2450f != null) {
            k();
        }
    }

    public void setBoxStrokeColor(@ColorInt int i2) {
        if (this.z0 != i2) {
            this.z0 = i2;
            E();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.x0 = colorStateList.getDefaultColor();
            this.F0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.y0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.z0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.z0 != colorStateList.getDefaultColor()) {
            this.z0 = colorStateList.getDefaultColor();
        }
        E();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            E();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.J = i2;
        E();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.K = i2;
        E();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f2453i != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f2456l = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.T;
                if (typeface != null) {
                    this.f2456l.setTypeface(typeface);
                }
                this.f2456l.setMaxLines(1);
                this.f2452h.a(this.f2456l, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f2456l.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                t();
                r();
            } else {
                this.f2452h.j(this.f2456l, 2);
                this.f2456l = null;
            }
            this.f2453i = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f2454j != i2) {
            if (i2 > 0) {
                this.f2454j = i2;
            } else {
                this.f2454j = -1;
            }
            if (this.f2453i) {
                r();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.m != i2) {
            this.m = i2;
            t();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            t();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.n != i2) {
            this.n = i2;
            t();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            t();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.v0 = colorStateList;
        this.w0 = colorStateList;
        if (this.f2450f != null) {
            x(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.i0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.i0.setCheckable(z);
    }

    public void setEndIconContentDescription(@StringRes int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i2) {
        setEndIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.g0;
        this.g0 = i2;
        Iterator<f> it = this.j0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i3);
        }
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.G)) {
            getEndIconDelegate().a();
            c();
        } else {
            StringBuilder sbR = c.a.a.a.a.r("The current box background mode ");
            sbR.append(this.G);
            sbR.append(" is not supported by the end icon mode ");
            sbR.append(i2);
            throw new IllegalStateException(sbR.toString());
        }
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.i0;
        View.OnLongClickListener onLongClickListener = this.r0;
        checkableImageButton.setOnClickListener(onClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.r0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.i0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.k0 != colorStateList) {
            this.k0 = colorStateList;
            this.l0 = true;
            c();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.m0 != mode) {
            this.m0 = mode;
            this.n0 = true;
            c();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (j() != z) {
            this.i0.setVisibility(z ? 0 : 8);
            C();
            u();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f2452h.f882k) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f2452h.i();
            return;
        }
        n nVar = this.f2452h;
        nVar.c();
        nVar.f881j = charSequence;
        nVar.f883l.setText(charSequence);
        int i2 = nVar.f879h;
        if (i2 != 1) {
            nVar.f880i = 1;
        }
        nVar.l(i2, nVar.f880i, nVar.k(nVar.f883l, charSequence));
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        n nVar = this.f2452h;
        nVar.m = charSequence;
        TextView textView = nVar.f883l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        n nVar = this.f2452h;
        if (nVar.f882k == z) {
            return;
        }
        nVar.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(nVar.a);
            nVar.f883l = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            nVar.f883l.setTextAlignment(5);
            Typeface typeface = nVar.u;
            if (typeface != null) {
                nVar.f883l.setTypeface(typeface);
            }
            int i2 = nVar.n;
            nVar.n = i2;
            TextView textView = nVar.f883l;
            if (textView != null) {
                nVar.f873b.q(textView, i2);
            }
            ColorStateList colorStateList = nVar.o;
            nVar.o = colorStateList;
            TextView textView2 = nVar.f883l;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            CharSequence charSequence = nVar.m;
            nVar.m = charSequence;
            TextView textView3 = nVar.f883l;
            if (textView3 != null) {
                textView3.setContentDescription(charSequence);
            }
            nVar.f883l.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(nVar.f883l, 1);
            nVar.a(nVar.f883l, 0);
        } else {
            nVar.i();
            nVar.j(nVar.f883l, 0);
            nVar.f883l = null;
            nVar.f873b.v();
            nVar.f873b.E();
        }
        nVar.f882k = z;
    }

    public void setErrorIconDrawable(@DrawableRes int i2) {
        setErrorIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        o(this.t0, this.u0);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.t0;
        View.OnLongClickListener onLongClickListener = this.s0;
        checkableImageButton.setOnClickListener(onClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.s0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.t0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.u0 = colorStateList;
        Drawable drawable = this.t0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.t0.getDrawable() != drawable) {
            this.t0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.t0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.t0.getDrawable() != drawable) {
            this.t0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        n nVar = this.f2452h;
        nVar.n = i2;
        TextView textView = nVar.f883l;
        if (textView != null) {
            nVar.f873b.q(textView, i2);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        n nVar = this.f2452h;
        nVar.o = colorStateList;
        TextView textView = nVar.f883l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.I0 != z) {
            this.I0 = z;
            x(false, false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (this.f2452h.q) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!this.f2452h.q) {
            setHelperTextEnabled(true);
        }
        n nVar = this.f2452h;
        nVar.c();
        nVar.p = charSequence;
        nVar.r.setText(charSequence);
        int i2 = nVar.f879h;
        if (i2 != 2) {
            nVar.f880i = 2;
        }
        nVar.l(i2, nVar.f880i, nVar.k(nVar.r, charSequence));
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        n nVar = this.f2452h;
        nVar.t = colorStateList;
        TextView textView = nVar.r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        n nVar = this.f2452h;
        if (nVar.q == z) {
            return;
        }
        nVar.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(nVar.a);
            nVar.r = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            nVar.r.setTextAlignment(5);
            Typeface typeface = nVar.u;
            if (typeface != null) {
                nVar.r.setTypeface(typeface);
            }
            nVar.r.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(nVar.r, 1);
            int i2 = nVar.s;
            nVar.s = i2;
            TextView textView = nVar.r;
            if (textView != null) {
                TextViewCompat.setTextAppearance(textView, i2);
            }
            ColorStateList colorStateList = nVar.t;
            nVar.t = colorStateList;
            TextView textView2 = nVar.r;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            nVar.a(nVar.r, 1);
        } else {
            nVar.c();
            int i3 = nVar.f879h;
            if (i3 == 2) {
                nVar.f880i = 0;
            }
            nVar.l(i3, nVar.f880i, nVar.k(nVar.r, null));
            nVar.j(nVar.r, 1);
            nVar.r = null;
            nVar.f873b.v();
            nVar.f873b.E();
        }
        nVar.q = z;
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        n nVar = this.f2452h;
        nVar.s = i2;
        TextView textView = nVar.r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.z) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.J0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.z) {
            this.z = z;
            if (z) {
                CharSequence hint = this.f2450f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.A)) {
                        setHint(hint);
                    }
                    this.f2450f.setHint((CharSequence) null);
                }
                this.B = true;
            } else {
                this.B = false;
                if (!TextUtils.isEmpty(this.A) && TextUtils.isEmpty(this.f2450f.getHint())) {
                    this.f2450f.setHint(this.A);
                }
                setHintInternal(null);
            }
            if (this.f2450f != null) {
                w();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        this.H0.o(i2);
        this.w0 = this.H0.f1103l;
        if (this.f2450f != null) {
            x(false, false);
            w();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.w0 != colorStateList) {
            if (this.v0 == null) {
                c.e.a.b.q.a aVar = this.H0;
                if (aVar.f1103l != colorStateList) {
                    aVar.f1103l = colorStateList;
                    aVar.m();
                }
            }
            this.w0 = colorStateList;
            if (this.f2450f != null) {
                x(false, false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.g0 != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.k0 = colorStateList;
        this.l0 = true;
        c();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.m0 = mode;
        this.n0 = true;
        c();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.p && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.p) {
                setPlaceholderTextEnabled(true);
            }
            this.o = charSequence;
        }
        EditText editText = this.f2450f;
        y(editText != null ? editText.getText().length() : 0);
    }

    public void setPlaceholderTextAppearance(@StyleRes int i2) {
        this.s = i2;
        TextView textView = this.q;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            TextView textView = this.q;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.v = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.w.setText(charSequence);
        A();
    }

    public void setPrefixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.w, i2);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.w.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.U.setCheckable(z);
    }

    public void setStartIconContentDescription(@StringRes int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i2) {
        setStartIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.U;
        View.OnLongClickListener onLongClickListener = this.e0;
        checkableImageButton.setOnClickListener(onClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.e0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.U;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            this.W = true;
            d(this.U, true, colorStateList, this.b0, this.a0);
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.a0 != mode) {
            this.a0 = mode;
            this.b0 = true;
            d(this.U, this.W, this.V, true, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        if ((this.U.getVisibility() == 0) != z) {
            this.U.setVisibility(z ? 0 : 8);
            z();
            u();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.y.setText(charSequence);
        D();
    }

    public void setSuffixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.y, i2);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.y.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.f2450f;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.T) {
            this.T = typeface;
            this.H0.A(typeface);
            n nVar = this.f2452h;
            if (typeface != nVar.u) {
                nVar.u = typeface;
                TextView textView = nVar.f883l;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = nVar.r;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.f2456l;
            if (textView3 != null) {
                textView3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f2456l;
        if (textView != null) {
            q(textView, this.f2455k ? this.m : this.n);
            if (!this.f2455k && (colorStateList2 = this.t) != null) {
                this.f2456l.setTextColor(colorStateList2);
            }
            if (!this.f2455k || (colorStateList = this.u) == null) {
                return;
            }
            this.f2456l.setTextColor(colorStateList);
        }
    }

    public final boolean u() {
        boolean z;
        if (this.f2450f == null) {
            return false;
        }
        boolean z2 = true;
        if (!(getStartIconDrawable() == null && this.v == null) && this.f2447c.getMeasuredWidth() > 0) {
            int measuredWidth = this.f2447c.getMeasuredWidth() - this.f2450f.getPaddingLeft();
            if (this.c0 == null || this.d0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.c0 = colorDrawable;
                this.d0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f2450f);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.c0;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.f2450f, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.c0 != null) {
                Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f2450f);
                TextViewCompat.setCompoundDrawablesRelative(this.f2450f, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.c0 = null;
                z = true;
            }
            z = false;
        }
        if ((this.t0.getVisibility() == 0 || ((i() && j()) || this.x != null)) && this.f2448d.getMeasuredWidth() > 0) {
            int measuredWidth2 = this.y.getMeasuredWidth() - this.f2450f.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()) + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.f2450f);
            Drawable drawable3 = this.o0;
            if (drawable3 == null || this.p0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.o0 = colorDrawable2;
                    this.p0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.o0;
                if (drawable4 != drawable5) {
                    this.q0 = compoundDrawablesRelative3[2];
                    TextViewCompat.setCompoundDrawablesRelative(this.f2450f, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.p0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.f2450f, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.o0, compoundDrawablesRelative3[3]);
            }
        } else {
            if (this.o0 == null) {
                return z;
            }
            Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.f2450f);
            if (compoundDrawablesRelative4[2] == this.o0) {
                TextViewCompat.setCompoundDrawablesRelative(this.f2450f, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.q0, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.o0 = null;
        }
        return z2;
    }

    public void v() {
        Drawable background;
        TextView textView;
        EditText editText = this.f2450f;
        if (editText == null || this.G != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.f2452h.e()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.f2452h.g(), PorterDuff.Mode.SRC_IN));
        } else if (this.f2455k && (textView = this.f2456l) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.f2450f.refreshDrawableState();
        }
    }

    public final void w() {
        if (this.G != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2446b.getLayoutParams();
            int iE = e();
            if (iE != layoutParams.topMargin) {
                layoutParams.topMargin = iE;
                this.f2446b.requestLayout();
            }
        }
    }

    public final void x(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f2450f;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f2450f;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean zE = this.f2452h.e();
        ColorStateList colorStateList2 = this.v0;
        if (colorStateList2 != null) {
            this.H0.p(colorStateList2);
            this.H0.t(this.v0);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.v0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.F0) : this.F0;
            this.H0.p(ColorStateList.valueOf(colorForState));
            this.H0.t(ColorStateList.valueOf(colorForState));
        } else if (zE) {
            c.e.a.b.q.a aVar = this.H0;
            TextView textView2 = this.f2452h.f883l;
            aVar.p(textView2 != null ? textView2.getTextColors() : null);
        } else if (this.f2455k && (textView = this.f2456l) != null) {
            this.H0.p(textView.getTextColors());
        } else if (z4 && (colorStateList = this.w0) != null) {
            this.H0.p(colorStateList);
        }
        if (z3 || !this.I0 || (isEnabled() && z4)) {
            if (z2 || this.G0) {
                ValueAnimator valueAnimator = this.K0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.K0.cancel();
                }
                if (z && this.J0) {
                    a(1.0f);
                } else {
                    this.H0.w(1.0f);
                }
                this.G0 = false;
                if (f()) {
                    l();
                }
                EditText editText3 = this.f2450f;
                y(editText3 != null ? editText3.getText().length() : 0);
                A();
                D();
                return;
            }
            return;
        }
        if (z2 || !this.G0) {
            ValueAnimator valueAnimator2 = this.K0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.K0.cancel();
            }
            if (z && this.J0) {
                a(0.0f);
            } else {
                this.H0.w(0.0f);
            }
            if (f() && (!((g) this.C).z.isEmpty()) && f()) {
                ((g) this.C).D(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.G0 = true;
            TextView textView3 = this.q;
            if (textView3 != null && this.p) {
                textView3.setText((CharSequence) null);
                this.q.setVisibility(4);
            }
            A();
            D();
        }
    }

    public final void y(int i2) {
        if (i2 != 0 || this.G0) {
            TextView textView = this.q;
            if (textView == null || !this.p) {
                return;
            }
            textView.setText((CharSequence) null);
            this.q.setVisibility(4);
            return;
        }
        TextView textView2 = this.q;
        if (textView2 == null || !this.p) {
            return;
        }
        textView2.setText(this.o);
        this.q.setVisibility(0);
        this.q.bringToFront();
    }

    public final void z() {
        if (this.f2450f == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.w, this.U.getVisibility() == 0 ? 0 : ViewCompat.getPaddingStart(this.f2450f), this.f2450f.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.f2450f.getCompoundPaddingBottom());
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.i0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.i0.setImageDrawable(drawable);
        n();
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.U.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.U.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            o(this.U, this.V);
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3;
        int i4;
        int i5 = a;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i5), attributeSet, i2);
        this.f2452h = new n(this);
        this.Q = new Rect();
        this.R = new Rect();
        this.S = new RectF();
        this.f0 = new LinkedHashSet<>();
        this.g0 = 0;
        this.h0 = new SparseArray<>();
        this.j0 = new LinkedHashSet<>();
        c.e.a.b.q.a aVar = new c.e.a.b.q.a(this);
        this.H0 = aVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f2446b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f2447c = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.f2448d = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f2449e = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = c.e.a.b.a.a.a;
        aVar.I = timeInterpolator;
        aVar.m();
        aVar.H = timeInterpolator;
        aVar.m();
        aVar.q(8388659);
        int[] iArr = R$styleable.TextInputLayout;
        int i6 = R$styleable.TextInputLayout_counterTextAppearance;
        int i7 = R$styleable.TextInputLayout_counterOverflowTextAppearance;
        int i8 = R$styleable.TextInputLayout_errorTextAppearance;
        int i9 = R$styleable.TextInputLayout_helperTextTextAppearance;
        int i10 = R$styleable.TextInputLayout_hintTextAppearance;
        TintTypedArray tintTypedArrayE = c.e.a.b.q.g.e(context2, attributeSet, iArr, i2, i5, i6, i7, i8, i9, i10);
        this.z = tintTypedArrayE.getBoolean(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(tintTypedArrayE.getText(R$styleable.TextInputLayout_android_hint));
        this.J0 = tintTypedArrayE.getBoolean(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.I0 = tintTypedArrayE.getBoolean(R$styleable.TextInputLayout_expandedHintEnabled, true);
        this.E = l.c(context2, attributeSet, i2, i5, new c.e.a.b.w.a(0)).a();
        this.F = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.H = tintTypedArrayE.getDimensionPixelOffset(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.J = tintTypedArrayE.getDimensionPixelSize(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.K = tintTypedArrayE.getDimensionPixelSize(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.I = this.J;
        float dimension = tintTypedArrayE.getDimension(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = tintTypedArrayE.getDimension(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = tintTypedArrayE.getDimension(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = tintTypedArrayE.getDimension(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        l lVar = this.E;
        Objects.requireNonNull(lVar);
        l.b bVar = new l.b(lVar);
        if (dimension >= 0.0f) {
            bVar.f(dimension);
        }
        if (dimension2 >= 0.0f) {
            bVar.g(dimension2);
        }
        if (dimension3 >= 0.0f) {
            bVar.e(dimension3);
        }
        if (dimension4 >= 0.0f) {
            bVar.d(dimension4);
        }
        this.E = bVar.a();
        ColorStateList colorStateListB2 = c.b.a.m.f.b2(context2, tintTypedArrayE, R$styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListB2 != null) {
            int defaultColor = colorStateListB2.getDefaultColor();
            this.B0 = defaultColor;
            this.P = defaultColor;
            if (colorStateListB2.isStateful()) {
                this.C0 = colorStateListB2.getColorForState(new int[]{-16842910}, -1);
                i3 = 2;
                this.D0 = colorStateListB2.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.E0 = colorStateListB2.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                i3 = 2;
                this.D0 = this.B0;
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context2, R$color.mtrl_filled_background_color);
                this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.E0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            i3 = 2;
            this.P = 0;
            this.B0 = 0;
            this.C0 = 0;
            this.D0 = 0;
            this.E0 = 0;
        }
        int i11 = R$styleable.TextInputLayout_android_textColorHint;
        if (tintTypedArrayE.hasValue(i11)) {
            ColorStateList colorStateList2 = tintTypedArrayE.getColorStateList(i11);
            this.w0 = colorStateList2;
            this.v0 = colorStateList2;
        }
        int i12 = R$styleable.TextInputLayout_boxStrokeColor;
        ColorStateList colorStateListB22 = c.b.a.m.f.b2(context2, tintTypedArrayE, i12);
        this.z0 = tintTypedArrayE.getColor(i12, 0);
        this.x0 = ContextCompat.getColor(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.F0 = ContextCompat.getColor(context2, R$color.mtrl_textinput_disabled_color);
        this.y0 = ContextCompat.getColor(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB22 != null) {
            setBoxStrokeColorStateList(colorStateListB22);
        }
        int i13 = R$styleable.TextInputLayout_boxStrokeErrorColor;
        if (tintTypedArrayE.hasValue(i13)) {
            setBoxStrokeErrorColor(c.b.a.m.f.b2(context2, tintTypedArrayE, i13));
        }
        if (tintTypedArrayE.getResourceId(i10, -1) != -1) {
            setHintTextAppearance(tintTypedArrayE.getResourceId(i10, 0));
        }
        int resourceId = tintTypedArrayE.getResourceId(i8, 0);
        CharSequence text = tintTypedArrayE.getText(R$styleable.TextInputLayout_errorContentDescription);
        boolean z = tintTypedArrayE.getBoolean(R$styleable.TextInputLayout_errorEnabled, false);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int i14 = R$layout.design_text_input_end_icon;
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(i14, (ViewGroup) linearLayout2, false);
        this.t0 = checkableImageButton;
        checkableImageButton.setId(R$id.text_input_error_icon);
        checkableImageButton.setVisibility(8);
        if (c.b.a.m.f.x3(context2)) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        int i15 = R$styleable.TextInputLayout_errorIconDrawable;
        if (tintTypedArrayE.hasValue(i15)) {
            setErrorIconDrawable(tintTypedArrayE.getDrawable(i15));
        }
        int i16 = R$styleable.TextInputLayout_errorIconTint;
        if (tintTypedArrayE.hasValue(i16)) {
            setErrorIconTintList(c.b.a.m.f.b2(context2, tintTypedArrayE, i16));
        }
        int i17 = R$styleable.TextInputLayout_errorIconTintMode;
        if (tintTypedArrayE.hasValue(i17)) {
            setErrorIconTintMode(c.b.a.m.f.j4(tintTypedArrayE.getInt(i17, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(checkableImageButton, i3);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int resourceId2 = tintTypedArrayE.getResourceId(i9, 0);
        boolean z2 = tintTypedArrayE.getBoolean(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence text2 = tintTypedArrayE.getText(R$styleable.TextInputLayout_helperText);
        int resourceId3 = tintTypedArrayE.getResourceId(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence text3 = tintTypedArrayE.getText(R$styleable.TextInputLayout_placeholderText);
        int resourceId4 = tintTypedArrayE.getResourceId(R$styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence text4 = tintTypedArrayE.getText(R$styleable.TextInputLayout_prefixText);
        int resourceId5 = tintTypedArrayE.getResourceId(R$styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence text5 = tintTypedArrayE.getText(R$styleable.TextInputLayout_suffixText);
        boolean z3 = tintTypedArrayE.getBoolean(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(tintTypedArrayE.getInt(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.n = tintTypedArrayE.getResourceId(i6, 0);
        this.m = tintTypedArrayE.getResourceId(i7, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this.f2447c, false);
        this.U = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (c.b.a.m.f.x3(context2)) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i18 = R$styleable.TextInputLayout_startIconDrawable;
        if (tintTypedArrayE.hasValue(i18)) {
            setStartIconDrawable(tintTypedArrayE.getDrawable(i18));
            int i19 = R$styleable.TextInputLayout_startIconContentDescription;
            if (tintTypedArrayE.hasValue(i19)) {
                setStartIconContentDescription(tintTypedArrayE.getText(i19));
            }
            setStartIconCheckable(tintTypedArrayE.getBoolean(R$styleable.TextInputLayout_startIconCheckable, true));
        }
        int i20 = R$styleable.TextInputLayout_startIconTint;
        if (tintTypedArrayE.hasValue(i20)) {
            setStartIconTintList(c.b.a.m.f.b2(context2, tintTypedArrayE, i20));
        }
        int i21 = R$styleable.TextInputLayout_startIconTintMode;
        if (tintTypedArrayE.hasValue(i21)) {
            setStartIconTintMode(c.b.a.m.f.j4(tintTypedArrayE.getInt(i21, -1), null));
        }
        setBoxBackgroundMode(tintTypedArrayE.getInt(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        this.i0 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(i14, (ViewGroup) this.f2449e, false);
        this.f2449e.addView(this.i0);
        this.i0.setVisibility(8);
        if (c.b.a.m.f.x3(context2)) {
            i4 = 0;
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.i0.getLayoutParams(), 0);
        } else {
            i4 = 0;
        }
        this.h0.append(-1, new c.e.a.b.a0.f(this));
        this.h0.append(i4, new o(this));
        this.h0.append(1, new p(this));
        this.h0.append(2, new c.e.a.b.a0.a(this));
        this.h0.append(3, new h(this));
        int i22 = R$styleable.TextInputLayout_endIconMode;
        if (tintTypedArrayE.hasValue(i22)) {
            setEndIconMode(tintTypedArrayE.getInt(i22, 0));
            int i23 = R$styleable.TextInputLayout_endIconDrawable;
            if (tintTypedArrayE.hasValue(i23)) {
                setEndIconDrawable(tintTypedArrayE.getDrawable(i23));
            }
            int i24 = R$styleable.TextInputLayout_endIconContentDescription;
            if (tintTypedArrayE.hasValue(i24)) {
                setEndIconContentDescription(tintTypedArrayE.getText(i24));
            }
            setEndIconCheckable(tintTypedArrayE.getBoolean(R$styleable.TextInputLayout_endIconCheckable, true));
        } else {
            int i25 = R$styleable.TextInputLayout_passwordToggleEnabled;
            if (tintTypedArrayE.hasValue(i25)) {
                setEndIconMode(tintTypedArrayE.getBoolean(i25, false) ? 1 : 0);
                setEndIconDrawable(tintTypedArrayE.getDrawable(R$styleable.TextInputLayout_passwordToggleDrawable));
                setEndIconContentDescription(tintTypedArrayE.getText(R$styleable.TextInputLayout_passwordToggleContentDescription));
                int i26 = R$styleable.TextInputLayout_passwordToggleTint;
                if (tintTypedArrayE.hasValue(i26)) {
                    setEndIconTintList(c.b.a.m.f.b2(context2, tintTypedArrayE, i26));
                }
                int i27 = R$styleable.TextInputLayout_passwordToggleTintMode;
                if (tintTypedArrayE.hasValue(i27)) {
                    setEndIconTintMode(c.b.a.m.f.j4(tintTypedArrayE.getInt(i27, -1), null));
                }
            }
        }
        if (!tintTypedArrayE.hasValue(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            int i28 = R$styleable.TextInputLayout_endIconTint;
            if (tintTypedArrayE.hasValue(i28)) {
                setEndIconTintList(c.b.a.m.f.b2(context2, tintTypedArrayE, i28));
            }
            int i29 = R$styleable.TextInputLayout_endIconTintMode;
            if (tintTypedArrayE.hasValue(i29)) {
                setEndIconTintMode(c.b.a.m.f.j4(tintTypedArrayE.getInt(i29, -1), null));
            }
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.w = appCompatTextView;
        appCompatTextView.setId(R$id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(appCompatTextView, 1);
        this.f2447c.addView(this.U);
        this.f2447c.addView(appCompatTextView);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(context2);
        this.y = appCompatTextView2;
        appCompatTextView2.setId(R$id.textinput_suffix_text);
        appCompatTextView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(appCompatTextView2, 1);
        this.f2448d.addView(appCompatTextView2);
        this.f2448d.addView(this.t0);
        this.f2448d.addView(this.f2449e);
        setHelperTextEnabled(z2);
        setHelperText(text2);
        setHelperTextTextAppearance(resourceId2);
        setErrorEnabled(z);
        setErrorTextAppearance(resourceId);
        setErrorContentDescription(text);
        setCounterTextAppearance(this.n);
        setCounterOverflowTextAppearance(this.m);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setPrefixText(text4);
        setPrefixTextAppearance(resourceId4);
        setSuffixText(text5);
        setSuffixTextAppearance(resourceId5);
        int i30 = R$styleable.TextInputLayout_errorTextColor;
        if (tintTypedArrayE.hasValue(i30)) {
            setErrorTextColor(tintTypedArrayE.getColorStateList(i30));
        }
        int i31 = R$styleable.TextInputLayout_helperTextTextColor;
        if (tintTypedArrayE.hasValue(i31)) {
            setHelperTextColor(tintTypedArrayE.getColorStateList(i31));
        }
        int i32 = R$styleable.TextInputLayout_hintTextColor;
        if (tintTypedArrayE.hasValue(i32)) {
            setHintTextColor(tintTypedArrayE.getColorStateList(i32));
        }
        int i33 = R$styleable.TextInputLayout_counterTextColor;
        if (tintTypedArrayE.hasValue(i33)) {
            setCounterTextColor(tintTypedArrayE.getColorStateList(i33));
        }
        int i34 = R$styleable.TextInputLayout_counterOverflowTextColor;
        if (tintTypedArrayE.hasValue(i34)) {
            setCounterOverflowTextColor(tintTypedArrayE.getColorStateList(i34));
        }
        int i35 = R$styleable.TextInputLayout_placeholderTextColor;
        if (tintTypedArrayE.hasValue(i35)) {
            setPlaceholderTextColor(tintTypedArrayE.getColorStateList(i35));
        }
        int i36 = R$styleable.TextInputLayout_prefixTextColor;
        if (tintTypedArrayE.hasValue(i36)) {
            setPrefixTextColor(tintTypedArrayE.getColorStateList(i36));
        }
        int i37 = R$styleable.TextInputLayout_suffixTextColor;
        if (tintTypedArrayE.hasValue(i37)) {
            setSuffixTextColor(tintTypedArrayE.getColorStateList(i37));
        }
        setCounterEnabled(z3);
        setEnabled(tintTypedArrayE.getBoolean(R$styleable.TextInputLayout_android_enabled, true));
        tintTypedArrayE.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            ViewCompat.setImportantForAutofill(this, 1);
        }
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.t0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f2452h.f882k);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.i0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.i0.setImageDrawable(drawable);
    }

    public void setHint(@StringRes int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }
}
