package c.e.a.b.a0;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.b.w.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextWatcher f858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View.OnFocusChangeListener f859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextInputLayout.AccessibilityDelegate f860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextInputLayout.e f861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.f f862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public StateListDrawable f866l;
    public MaterialShapeDrawable m;

    @Nullable
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class a extends c.e.a.b.q.f {

        /* JADX INFO: renamed from: c.e.a.b.a0.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        public class RunnableC0041a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView a;

            public RunnableC0041a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.a.isPopupShowing();
                h.f(h.this, zIsPopupShowing);
                h.this.f863i = zIsPopupShowing;
            }
        }

        public a() {
        }

        @Override // c.e.a.b.q.f, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewD = h.d(h.this.a.getEditText());
            if (h.this.n.isTouchExplorationEnabled() && h.e(autoCompleteTextViewD) && !h.this.f872c.hasFocus()) {
                autoCompleteTextViewD.dismissDropDown();
            }
            autoCompleteTextViewD.post(new RunnableC0041a(autoCompleteTextViewD));
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            h.this.a.setEndIconActivated(z);
            if (z) {
                return;
            }
            h.f(h.this, false);
            h.this.f863i = false;
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class c extends TextInputLayout.AccessibilityDelegate {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!h.e(h.this.a.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewD = h.d(h.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && h.this.n.isTouchExplorationEnabled() && !h.e(h.this.a.getEditText())) {
                h.g(h.this, autoCompleteTextViewD);
            }
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class d implements TextInputLayout.e {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e
        public void a(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextViewD = h.d(textInputLayout.getEditText());
            h hVar = h.this;
            int boxBackgroundMode = hVar.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextViewD.setDropDownBackgroundDrawable(hVar.m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextViewD.setDropDownBackgroundDrawable(hVar.f866l);
            }
            h hVar2 = h.this;
            Objects.requireNonNull(hVar2);
            if (!(autoCompleteTextViewD.getKeyListener() != null)) {
                int boxBackgroundMode2 = hVar2.a.getBoxBackgroundMode();
                MaterialShapeDrawable boxBackground = hVar2.a.getBoxBackground();
                int iZ1 = c.b.a.m.f.Z1(autoCompleteTextViewD, R$attr.colorControlHighlight);
                int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
                if (boxBackgroundMode2 == 2) {
                    int iZ12 = c.b.a.m.f.Z1(autoCompleteTextViewD, R$attr.colorSurface);
                    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.f2333c.a);
                    int iM3 = c.b.a.m.f.M3(iZ1, iZ12, 0.1f);
                    materialShapeDrawable.q(new ColorStateList(iArr, new int[]{iM3, 0}));
                    materialShapeDrawable.setTint(iZ12);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iM3, iZ12});
                    MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.f2333c.a);
                    materialShapeDrawable2.setTint(-1);
                    ViewCompat.setBackground(autoCompleteTextViewD, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground}));
                } else if (boxBackgroundMode2 == 1) {
                    int boxBackgroundColor = hVar2.a.getBoxBackgroundColor();
                    ViewCompat.setBackground(autoCompleteTextViewD, new RippleDrawable(new ColorStateList(iArr, new int[]{c.b.a.m.f.M3(iZ1, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                }
            }
            h hVar3 = h.this;
            Objects.requireNonNull(hVar3);
            autoCompleteTextViewD.setOnTouchListener(new j(hVar3, autoCompleteTextViewD));
            autoCompleteTextViewD.setOnFocusChangeListener(hVar3.f859e);
            autoCompleteTextViewD.setOnDismissListener(new k(hVar3));
            autoCompleteTextViewD.setThreshold(0);
            autoCompleteTextViewD.removeTextChangedListener(h.this.f858d);
            autoCompleteTextViewD.addTextChangedListener(h.this.f858d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!(autoCompleteTextViewD.getKeyListener() != null)) {
                ViewCompat.setImportantForAccessibility(h.this.f872c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(h.this.f860f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class e implements TextInputLayout.f {

        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView a;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(h.this.f858d);
            }
        }

        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i2 != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == h.this.f859e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            autoCompleteTextView.setOnDismissListener(null);
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.g(h.this, (AutoCompleteTextView) h.this.a.getEditText());
        }
    }

    public h(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f858d = new a();
        this.f859e = new b();
        this.f860f = new c(this.a);
        this.f861g = new d();
        this.f862h = new e();
        this.f863i = false;
        this.f864j = false;
        this.f865k = RecyclerView.FOREVER_NS;
    }

    public static AutoCompleteTextView d(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static boolean e(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static void f(h hVar, boolean z) {
        if (hVar.f864j != z) {
            hVar.f864j = z;
            hVar.p.cancel();
            hVar.o.start();
        }
    }

    public static void g(h hVar, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(hVar);
        if (autoCompleteTextView == null) {
            return;
        }
        if (hVar.i()) {
            hVar.f863i = false;
        }
        if (hVar.f863i) {
            hVar.f863i = false;
            return;
        }
        boolean z = hVar.f864j;
        boolean z2 = !z;
        if (z != z2) {
            hVar.f864j = z2;
            hVar.p.cancel();
            hVar.o.start();
        }
        if (!hVar.f864j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    @Override // c.e.a.b.a0.m
    public void a() {
        float dimensionPixelOffset = this.f871b.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f871b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f871b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable materialShapeDrawableH = h(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable materialShapeDrawableH2 = h(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = materialShapeDrawableH;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f866l = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, materialShapeDrawableH);
        this.f866l.addState(new int[0], materialShapeDrawableH2);
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f871b, R$drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new f());
        this.a.addOnEditTextAttachedListener(this.f861g);
        this.a.addOnEndIconChangedListener(this.f862h);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = c.e.a.b.a.a.a;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new i(this));
        this.p = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new i(this));
        this.o = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new l(this));
        this.n = (AccessibilityManager) this.f871b.getSystemService("accessibility");
    }

    @Override // c.e.a.b.a0.m
    public boolean b(int i2) {
        return i2 != 0;
    }

    public final MaterialShapeDrawable h(float f2, float f3, float f4, int i2) {
        l.b bVar = new l.b();
        bVar.f1241e = new c.e.a.b.w.a(f2);
        bVar.f1242f = new c.e.a.b.w.a(f2);
        bVar.f1244h = new c.e.a.b.w.a(f3);
        bVar.f1243g = new c.e.a.b.w.a(f3);
        c.e.a.b.w.l lVarA = bVar.a();
        Context context = this.f871b;
        String str = MaterialShapeDrawable.a;
        int iN4 = c.b.a.m.f.N4(context, R$attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.f2333c.f2343b = new c.e.a.b.n.a(context);
        materialShapeDrawable.C();
        materialShapeDrawable.q(ColorStateList.valueOf(iN4));
        MaterialShapeDrawable.b bVar2 = materialShapeDrawable.f2333c;
        if (bVar2.o != f4) {
            bVar2.o = f4;
            materialShapeDrawable.C();
        }
        materialShapeDrawable.f2333c.a = lVarA;
        materialShapeDrawable.invalidateSelf();
        MaterialShapeDrawable.b bVar3 = materialShapeDrawable.f2333c;
        if (bVar3.f2350i == null) {
            bVar3.f2350i = new Rect();
        }
        materialShapeDrawable.f2333c.f2350i.set(0, i2, 0, i2);
        materialShapeDrawable.invalidateSelf();
        return materialShapeDrawable;
    }

    public final boolean i() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f865k;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }
}
