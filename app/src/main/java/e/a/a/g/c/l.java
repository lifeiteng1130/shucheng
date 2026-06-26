package e.a.a.g.c;

import android.content.Intent;
import android.widget.SeekBar;
import io.legado.app.service.AudioPlayService;
import io.legado.app.ui.audio.AudioPlayActivity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AudioPlayActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements e.a.a.g.m.q.a {
    public final /* synthetic */ AudioPlayActivity a;

    public l(AudioPlayActivity audioPlayActivity) {
        this.a = audioPlayActivity;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int i2, boolean z) {
        f.c0.c.j.e(seekBar, "seekBar");
        AudioPlayActivity.U0(this.a).n.setText(AudioPlayActivity.V0(this.a).format(Long.valueOf(i2)));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        f.c0.c.j.e(seekBar, "seekBar");
        this.a.adjustProgress = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        f.c0.c.j.e(seekBar, "seekBar");
        AudioPlayActivity audioPlayActivity = this.a;
        audioPlayActivity.adjustProgress = false;
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        int progress = seekBar.getProgress();
        f.c0.c.j.e(audioPlayActivity, com.umeng.analytics.pro.c.R);
        if (AudioPlayService.f6916b) {
            Intent intent = new Intent(audioPlayActivity, (Class<?>) AudioPlayService.class);
            intent.setAction("adjustProgress");
            intent.putExtra("position", progress);
            audioPlayActivity.startService(intent);
        }
    }
}
