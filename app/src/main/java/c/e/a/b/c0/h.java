package c.e.a.b.c0;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;

/* JADX INFO: compiled from: TimePickerTextInputKeyController.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements TextView.OnEditorActionListener, View.OnKeyListener {
    public final ChipTextInputComboView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChipTextInputComboView f927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeModel f928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f929d = false;

    public h(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.a = chipTextInputComboView;
        this.f927b = chipTextInputComboView2;
        this.f928c = timeModel;
    }

    public final void a(int i2) {
        this.f927b.setChecked(i2 == 12);
        this.a.setChecked(i2 == 10);
        this.f928c.f2499f = i2;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        boolean z = i2 == 5;
        if (z) {
            a(12);
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    @Override // android.view.View.OnKeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKey(android.view.View r6, int r7, android.view.KeyEvent r8) {
        /*
            r5 = this;
            boolean r0 = r5.f929d
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            r5.f929d = r0
            android.widget.EditText r6 = (android.widget.EditText) r6
            com.google.android.material.timepicker.TimeModel r2 = r5.f928c
            int r2 = r2.f2499f
            r3 = 12
            if (r2 != r3) goto L34
            r2 = 67
            if (r7 != r2) goto L29
            int r7 = r8.getAction()
            if (r7 != 0) goto L29
            android.text.Editable r6 = r6.getText()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L29
            r6 = 1
            goto L2a
        L29:
            r6 = 0
        L2a:
            if (r6 == 0) goto L32
            r6 = 10
            r5.a(r6)
            goto L5d
        L32:
            r0 = 0
            goto L5d
        L34:
            android.text.Editable r2 = r6.getText()
            if (r2 != 0) goto L3b
            goto L32
        L3b:
            r4 = 7
            if (r7 < r4) goto L57
            r4 = 16
            if (r7 > r4) goto L57
            int r7 = r8.getAction()
            if (r7 != r0) goto L57
            int r6 = r6.getSelectionStart()
            r7 = 2
            if (r6 != r7) goto L57
            int r6 = r2.length()
            if (r6 != r7) goto L57
            r6 = 1
            goto L58
        L57:
            r6 = 0
        L58:
            if (r6 == 0) goto L32
            r5.a(r3)
        L5d:
            r5.f929d = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.b.c0.h.onKey(android.view.View, int, android.view.KeyEvent):boolean");
    }
}
