package e.a.a.g.d.i;

import android.content.Context;
import android.widget.SeekBar;
import io.legado.app.ui.book.read.ReadMenu;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k1 implements e.a.a.g.m.q.a {
    public final /* synthetic */ ReadMenu a;

    public k1(ReadMenu readMenu) {
        this.a = readMenu;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int i2, boolean z) {
        f.c0.c.j.e(seekBar, "seekBar");
        this.a.setScreenBrightness(i2);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        c.b.a.m.f.g4(this, seekBar);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        f.c0.c.j.e(seekBar, "seekBar");
        Context context = this.a.getContext();
        f.c0.c.j.d(context, com.umeng.analytics.pro.c.R);
        c.b.a.m.f.p4(context, "brightness", seekBar.getProgress());
    }
}
