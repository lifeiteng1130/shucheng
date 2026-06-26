package e.a.a.g.c;

import android.view.View;
import io.legado.app.ui.audio.AudioPlayActivity;

/* JADX INFO: compiled from: Click.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements View.OnLongClickListener {
    public final /* synthetic */ AudioPlayActivity a;

    public k(boolean z, AudioPlayActivity audioPlayActivity) {
        this.a = audioPlayActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        e.a.a.f.s.a.a.g(this.a);
        return true;
    }
}
