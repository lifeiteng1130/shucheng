package c.g.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import com.king.zxing.R$raw;
import java.io.Closeable;

/* JADX INFO: compiled from: BeepManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements MediaPlayer.OnErrorListener, Closeable {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaPlayer f1574b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Vibrator f1575c;

    public i(Context context) {
        this.a = context;
        b();
    }

    public final MediaPlayer a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(R$raw.zxl_beep);
            mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setLooping(false);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (Exception e2) {
            c.g.a.p.a.a();
            Log.getStackTraceString(e2);
            mediaPlayer.release();
            return null;
        }
    }

    public final synchronized void b() {
        if (this.f1574b == null) {
            this.f1574b = a(this.a);
        }
        if (this.f1575c == null) {
            this.f1575c = (Vibrator) this.a.getSystemService("vibrator");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            MediaPlayer mediaPlayer = this.f1574b;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.f1574b = null;
            }
        } catch (Exception e2) {
            c.g.a.p.a.a();
            Log.getStackTraceString(e2);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public synchronized boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        close();
        b();
        return true;
    }
}
