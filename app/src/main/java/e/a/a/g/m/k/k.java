package e.a.a.g.m.k;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import io.legado.app.databinding.DialogWaitBinding;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WaitDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends Dialog {

    @NotNull
    public final DialogWaitBinding a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull Context context) {
        super(context);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_wait, (ViewGroup) null, false);
        int i2 = R.id.pb;
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.pb);
        if (progressBar != null) {
            i2 = R.id.tv_msg;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_msg);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                DialogWaitBinding dialogWaitBinding = new DialogWaitBinding(linearLayout, progressBar, textView);
                f.c0.c.j.d(dialogWaitBinding, "inflate(layoutInflater)");
                this.a = dialogWaitBinding;
                setCanceledOnTouchOutside(false);
                setContentView(linearLayout);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
