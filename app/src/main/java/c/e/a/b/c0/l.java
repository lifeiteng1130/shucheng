package c.e.a.b.c0;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView a;

    public l(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean zOnDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView.b bVar = this.a.f2508i;
        if (bVar != null) {
            MaterialTimePicker.a aVar = (MaterialTimePicker.a) bVar;
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.p = 1;
            materialTimePicker.N(materialTimePicker.o);
            i iVar = MaterialTimePicker.this.f2491i;
            iVar.f933e.setChecked(iVar.f930b.f2499f == 12);
            iVar.f934f.setChecked(iVar.f930b.f2499f == 10);
        }
        return zOnDoubleTap;
    }
}
