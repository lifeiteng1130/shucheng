package c.e.a.b.l;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.datepicker.MaterialCalendarGridView;

/* JADX INFO: compiled from: MaterialCalendarGridView.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends AccessibilityDelegateCompat {
    public l(MaterialCalendarGridView materialCalendarGridView) {
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setCollectionInfo(null);
    }
}
