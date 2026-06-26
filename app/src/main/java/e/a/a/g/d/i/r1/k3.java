package e.a.a.g.d.i.r1;

import android.content.Context;
import android.content.Intent;
import android.widget.SeekBar;
import io.legado.app.databinding.DialogReadAloudBinding;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.ui.book.read.config.ReadAloudDialog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadAloudDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k3 implements e.a.a.g.m.q.a {
    public final /* synthetic */ ReadAloudDialog a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DialogReadAloudBinding f5731b;

    public k3(ReadAloudDialog readAloudDialog, DialogReadAloudBinding dialogReadAloudBinding) {
        this.a = readAloudDialog;
        this.f5731b = dialogReadAloudBinding;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int i2, boolean z) {
        f.c0.c.j.e(seekBar, "seekBar");
        ReadAloudDialog readAloudDialog = this.a;
        f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
        readAloudDialog.S(i2);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        c.b.a.m.f.g4(this, seekBar);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        f.c0.c.j.e(seekBar, "seekBar");
        e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
        Context contextRequireContext = this.a.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        int progress = this.f5731b.q.getProgress();
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        if (BaseReadAloudService.f6927b) {
            Intent intent = new Intent(contextRequireContext, e.a.a.f.s.j.f5674b);
            intent.setAction("setTimer");
            intent.putExtra("minute", progress);
            contextRequireContext.startService(intent);
        }
    }
}
