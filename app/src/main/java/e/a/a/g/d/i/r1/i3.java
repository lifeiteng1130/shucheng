package e.a.a.g.d.i.r1;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import io.legado.app.databinding.DialogPageKeyBinding;
import io.legado.app.ui.widget.text.EditText;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PageKeyDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i3 extends Dialog {

    @NotNull
    public final DialogPageKeyBinding a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i3(@NotNull final Context context) {
        super(context, 2131886091);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_page_key, (ViewGroup) null, false);
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        int i2 = R.id.et_next;
        EditText editText = (EditText) viewInflate.findViewById(R.id.et_next);
        if (editText != null) {
            i2 = R.id.et_prev;
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.et_prev);
            if (editText2 != null) {
                i2 = R.id.tv_ok;
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_ok);
                if (textView != null) {
                    i2 = R.id.tv_title;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_title);
                    if (textView2 != null) {
                        LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                        DialogPageKeyBinding dialogPageKeyBinding = new DialogPageKeyBinding(linearLayout2, linearLayout, editText, editText2, textView, textView2);
                        f.c0.c.j.d(dialogPageKeyBinding, "inflate(layoutInflater)");
                        this.a = dialogPageKeyBinding;
                        setContentView(linearLayout2);
                        linearLayout.setBackgroundColor(c.b.a.m.f.R1(context));
                        editText2.setText(c.b.a.m.f.O2(context, "prevKeyCodes", null, 2));
                        editText.setText(c.b.a.m.f.O2(context, "nextKeyCodes", null, 2));
                        textView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.b0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                Context context2 = context;
                                i3 i3Var = this;
                                f.c0.c.j.e(context2, "$context");
                                f.c0.c.j.e(i3Var, "this$0");
                                Editable text = i3Var.a.f6624d.getText();
                                c.b.a.m.f.r4(context2, "prevKeyCodes", text == null ? null : text.toString());
                                Editable text2 = i3Var.a.f6623c.getText();
                                c.b.a.m.f.r4(context2, "nextKeyCodes", text2 != null ? text2.toString() : null);
                                i3Var.dismiss();
                            }
                        });
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return;
        }
        c.b.a.m.f.h3(currentFocus);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NotNull KeyEvent keyEvent) {
        f.c0.c.j.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i2 != 4 && i2 != 67) {
            if (this.a.f6624d.hasFocus()) {
                Editable editableText = this.a.f6624d.getEditableText();
                f.c0.c.j.d(editableText, "editableText");
                if ((editableText.length() == 0) || f.h0.k.g(editableText, ",", false, 2)) {
                    editableText.append((CharSequence) String.valueOf(i2));
                } else {
                    editableText.append((CharSequence) ",").append((CharSequence) String.valueOf(i2));
                }
                return true;
            }
            if (this.a.f6623c.hasFocus()) {
                Editable editableText2 = this.a.f6623c.getEditableText();
                f.c0.c.j.d(editableText2, "editableText");
                if ((editableText2.length() == 0) || f.h0.k.g(editableText2, ",", false, 2)) {
                    editableText2.append((CharSequence) String.valueOf(i2));
                } else {
                    editableText2.append((CharSequence) ",").append((CharSequence) String.valueOf(i2));
                }
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
