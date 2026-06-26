package c.e.a.b.a0;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public TextInputLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CheckableImageButton f872c;

    public m(@NonNull TextInputLayout textInputLayout) {
        this.a = textInputLayout;
        this.f871b = textInputLayout.getContext();
        this.f872c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int i2) {
        return true;
    }

    public void c(boolean z) {
    }
}
