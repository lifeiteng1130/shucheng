package io.legado.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TimeBatteryReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lio/legado/app/receiver/TimeBatteryReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", c.R, "Landroid/content/Intent;", "intent", "Lf/v;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TimeBatteryReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String action = intent == null ? null : intent.getAction();
        if (j.a(action, "android.intent.action.TIME_TICK")) {
            LiveEventBus.get("timeChanged").post("");
        } else if (j.a(action, "android.intent.action.BATTERY_CHANGED")) {
            LiveEventBus.get("batteryChanged").post(Integer.valueOf(intent.getIntExtra("level", -1)));
        }
    }
}
