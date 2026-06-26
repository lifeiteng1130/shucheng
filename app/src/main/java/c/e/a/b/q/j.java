package c.e.a.b.q;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {
    public final /* synthetic */ View a;

    public j(View view) {
        this.a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 1);
    }
}
