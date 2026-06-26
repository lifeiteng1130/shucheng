package c.e.a.b.a0;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements View.OnTouchListener {
    public final /* synthetic */ AutoCompleteTextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f870b;

    public j(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.f870b = hVar;
        this.a = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f870b.i()) {
                this.f870b.f863i = false;
            }
            h.g(this.f870b, this.a);
        }
        return false;
    }
}
