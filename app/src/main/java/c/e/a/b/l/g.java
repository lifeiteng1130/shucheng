package c.e.a.b.l;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.MaterialCalendar;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends AccessibilityDelegateCompat {
    public final /* synthetic */ MaterialCalendar a;

    public g(MaterialCalendar materialCalendar) {
        this.a = materialCalendar;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setHintText(this.a.f2193l.getVisibility() == 0 ? this.a.getString(R$string.mtrl_picker_toggle_to_year_selection) : this.a.getString(R$string.mtrl_picker_toggle_to_day_selection));
    }
}
