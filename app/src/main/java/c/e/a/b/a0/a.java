package c.e.a.b.a0;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextWatcher f851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View.OnFocusChangeListener f852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextInputLayout.e f853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextInputLayout.f f854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f856i;

    /* JADX INFO: renamed from: c.e.a.b.a0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class C0039a implements TextWatcher {
        public C0039a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (a.this.a.getSuffixText() != null) {
                return;
            }
            a.this.d(editable.length() > 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            a.this.d((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class c implements TextInputLayout.e {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
        @Override // com.google.android.material.textfield.TextInputLayout.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout r5) {
            /*
                r4 = this;
                android.widget.EditText r0 = r5.getEditText()
                boolean r1 = r0.hasFocus()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L1c
                android.text.Editable r1 = r0.getText()
                int r1 = r1.length()
                if (r1 <= 0) goto L18
                r1 = 1
                goto L19
            L18:
                r1 = 0
            L19:
                if (r1 == 0) goto L1c
                goto L1d
            L1c:
                r2 = 0
            L1d:
                r5.setEndIconVisible(r2)
                r5.setEndIconCheckable(r3)
                c.e.a.b.a0.a r5 = c.e.a.b.a0.a.this
                android.view.View$OnFocusChangeListener r5 = r5.f852e
                r0.setOnFocusChangeListener(r5)
                c.e.a.b.a0.a r5 = c.e.a.b.a0.a.this
                android.text.TextWatcher r5 = r5.f851d
                r0.removeTextChangedListener(r5)
                c.e.a.b.a0.a r5 = c.e.a.b.a0.a.this
                android.text.TextWatcher r5 = r5.f851d
                r0.addTextChangedListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.e.a.b.a0.a.c.a(com.google.android.material.textfield.TextInputLayout):void");
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class d implements TextInputLayout.f {

        /* JADX INFO: renamed from: c.e.a.b.a0.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
        public class RunnableC0040a implements Runnable {
            public final /* synthetic */ EditText a;

            public RunnableC0040a(EditText editText) {
                this.a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(a.this.f851d);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 2) {
                return;
            }
            editText.post(new RunnableC0040a(editText));
            if (editText.getOnFocusChangeListener() == a.this.f852e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.n();
        }
    }

    public a(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f851d = new C0039a();
        this.f852e = new b();
        this.f853f = new c();
        this.f854g = new d();
    }

    @Override // c.e.a.b.a0.m
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f871b, R$drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.addOnEditTextAttachedListener(this.f853f);
        this.a.addOnEndIconChangedListener(this.f854g);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(c.e.a.b.a.a.f841d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new c.e.a.b.a0.e(this));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = c.e.a.b.a.a.a;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new c.e.a.b.a0.d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f855h = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f855h.addListener(new c.e.a.b.a0.b(this));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new c.e.a.b.a0.d(this));
        this.f856i = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new c.e.a.b.a0.c(this));
    }

    @Override // c.e.a.b.a0.m
    public void c(boolean z) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        d(z);
    }

    public final void d(boolean z) {
        boolean z2 = this.a.j() == z;
        if (z && !this.f855h.isRunning()) {
            this.f856i.cancel();
            this.f855h.start();
            if (z2) {
                this.f855h.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.f855h.cancel();
        this.f856i.start();
        if (z2) {
            this.f856i.end();
        }
    }
}
