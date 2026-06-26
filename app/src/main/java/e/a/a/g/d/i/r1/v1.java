package e.a.a.g.d.i.r1;

import android.content.Context;
import android.widget.SeekBar;
import android.widget.TextView;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.ui.book.read.config.AutoReadDialog;
import java.util.Arrays;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AutoReadDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v1 implements e.a.a.g.m.q.a {
    public final /* synthetic */ AutoReadDialog a;

    public v1(AutoReadDialog autoReadDialog) {
        this.a = autoReadDialog;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int i2, boolean z) {
        f.c0.c.j.e(seekBar, "seekBar");
        if (i2 < 10) {
            i2 = 10;
        }
        AutoReadDialog autoReadDialog = this.a;
        f.f0.h<Object>[] hVarArr = AutoReadDialog.f7165b;
        TextView textView = autoReadDialog.Q().n;
        String str = String.format("%ds", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        f.c0.c.j.d(str, "java.lang.String.format(format, *args)");
        textView.setText(str);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        c.b.a.m.f.g4(this, seekBar);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        f.c0.c.j.e(seekBar, "seekBar");
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        AutoReadDialog autoReadDialog = this.a;
        f.f0.h<Object>[] hVarArr = AutoReadDialog.f7165b;
        readBookConfig.setAutoReadSpeed(autoReadDialog.Q().f6580j.getProgress() >= 10 ? this.a.Q().f6580j.getProgress() : 10);
        AutoReadDialog autoReadDialog2 = this.a;
        Objects.requireNonNull(autoReadDialog2);
        e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
        Context contextRequireContext = autoReadDialog2.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        e.a.a.f.s.j.g(contextRequireContext);
        if (BaseReadAloudService.f6929d) {
            return;
        }
        Context contextRequireContext2 = autoReadDialog2.requireContext();
        f.c0.c.j.d(contextRequireContext2, "requireContext()");
        e.a.a.f.s.j.c(contextRequireContext2);
        Context contextRequireContext3 = autoReadDialog2.requireContext();
        f.c0.c.j.d(contextRequireContext3, "requireContext()");
        e.a.a.f.s.j.e(contextRequireContext3);
    }
}
