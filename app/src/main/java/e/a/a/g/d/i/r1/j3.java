package e.a.a.g.d.i.r1;

import android.widget.SeekBar;
import io.legado.app.ui.book.read.config.ReadAloudDialog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadAloudDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j3 implements e.a.a.g.m.q.a {
    public final /* synthetic */ ReadAloudDialog a;

    public j3(ReadAloudDialog readAloudDialog) {
        this.a = readAloudDialog;
    }

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
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        f.c0.c.j.e(seekBar, "seekBar");
        e.a.a.d.e eVar = e.a.a.d.e.a;
        c.b.a.m.f.p4(k.d.a.h.g(), "ttsSpeechRate", seekBar.getProgress());
        ReadAloudDialog readAloudDialog = this.a;
        f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
        readAloudDialog.T();
    }
}
