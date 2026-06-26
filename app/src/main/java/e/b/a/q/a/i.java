package e.b.a.q.a;

import android.widget.TextView;
import io.noties.markwon.ext.tables.TableRowSpan;

/* JADX INFO: compiled from: TableRowsScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements TableRowSpan.d {
    public final Runnable a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f6031b;

    /* JADX INFO: compiled from: TableRowsScheduler.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = i.this.f6031b;
            textView.setText(textView.getText());
        }
    }

    public i(TextView textView) {
        this.f6031b = textView;
    }
}
