package c.e.a.b.c0;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector a;

    public m(TimePickerView timePickerView, GestureDetector gestureDetector) {
        this.a = gestureDetector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.a.onTouchEvent(motionEvent);
        }
        return false;
    }
}
