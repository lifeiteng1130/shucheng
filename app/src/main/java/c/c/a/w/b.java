package c.c.a.w;

import android.content.Intent;
import android.os.IBinder;
import com.bytedance.pangle.plugin.Plugin;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void attach(Plugin plugin);

    IBinder onBind(Intent intent);

    void onCreate();

    void onDestroy();

    int onStartCommand(Intent intent, int i2, int i3);

    boolean onUnbind(Intent intent);
}
