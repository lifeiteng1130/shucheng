package e.a.a.g.d.i;

import android.widget.SeekBar;
import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 implements e.a.a.g.m.q.a {
    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int i2, boolean z) {
        f.c0.c.j.e(this, "this");
        f.c0.c.j.e(seekBar, "seekBar");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        c.b.a.m.f.g4(this, seekBar);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) throws IllegalAccessException, InvocationTargetException {
        f.c0.c.j.e(seekBar, "seekBar");
        e.a.a.f.s.k.a.s(seekBar.getProgress(), null);
    }
}
