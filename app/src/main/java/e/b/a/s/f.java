package e.b.a.s;

import android.widget.TextView;
import androidx.annotation.NonNull;
import e.b.a.s.e;

/* JADX INFO: compiled from: AsyncDrawableScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements e.b, Runnable {
    public final TextView a;

    public f(@NonNull TextView textView) {
        this.a = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView = this.a;
        textView.setText(textView.getText());
    }
}
