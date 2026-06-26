package c.e.a.b.a0;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextWatcher f888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextInputLayout.e f889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextInputLayout.f f890f;

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    public class a extends c.e.a.b.q.f {
        public a() {
        }

        @Override // c.e.a.b.q.f, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            p.this.f872c.setChecked(!p.d(r1));
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    public class b implements TextInputLayout.e {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            p.this.f872c.setChecked(!p.d(r4));
            editText.removeTextChangedListener(p.this.f888d);
            editText.addTextChangedListener(p.this.f888d);
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    public class c implements TextInputLayout.f {

        /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
        public class a implements Runnable {
            public final /* synthetic */ EditText a;

            public a(EditText editText) {
                this.a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(p.this.f888d);
            }
        }

        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = p.this.a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (p.d(p.this)) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            p.this.a.n();
        }
    }

    public p(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f888d = new a();
        this.f889e = new b();
        this.f890f = new c();
    }

    public static boolean d(p pVar) {
        EditText editText = pVar.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // c.e.a.b.a0.m
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f871b, R$drawable.design_password_eye));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new d());
        this.a.addOnEditTextAttachedListener(this.f889e);
        this.a.addOnEndIconChangedListener(this.f890f);
        EditText editText = this.a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
