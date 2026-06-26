package io.legado.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.d;
import e.a.a.d.e;
import e.a.a.f.s.a;
import f.c0.c.f;
import f.c0.c.j;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.service.AudioPlayService;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.ui.audio.AudioPlayActivity;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.main.MainActivity;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MediaButtonReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lio/legado/app/receiver/MediaButtonReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", c.R, "Landroid/content/Intent;", "intent", "Lf/v;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class MediaButtonReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: io.legado.app.receiver.MediaButtonReceiver$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MediaButtonReceiver.kt */
    public static final class Companion {
        public Companion(f fVar) {
        }

        public final boolean a(@NotNull Context context, @NotNull Intent intent) {
            j.e(context, c.R);
            j.e(intent, "intent");
            if (j.a("android.intent.action.MEDIA_BUTTON", intent.getAction())) {
                KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent == null) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                if (keyEvent.getAction() == 0) {
                    if (keyCode == 87) {
                        e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
                        e.a.a.f.s.j.b(context);
                    } else if (keyCode != 88) {
                        b(context, true);
                    } else {
                        e.a.a.f.s.j jVar2 = e.a.a.f.s.j.a;
                        e.a.a.f.s.j.d(context);
                    }
                }
            }
            return true;
        }

        public final void b(@NotNull Context context, boolean z) {
            j.e(context, c.R);
            if (BaseReadAloudService.f6927b) {
                if (BaseReadAloudService.d()) {
                    e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
                    e.a.a.f.s.j.c(context);
                    a.a.c(context);
                    return;
                } else {
                    e.a.a.f.s.j jVar2 = e.a.a.f.s.j.a;
                    e.a.a.f.s.j.e(context);
                    a.a.e(context);
                    return;
                }
            }
            if (AudioPlayService.f6916b) {
                if (AudioPlayService.f6917c) {
                    a.a.e(context);
                    return;
                } else {
                    a.a.c(context);
                    return;
                }
            }
            d dVar = d.a;
            if (dVar.a(ReadBookActivity.class)) {
                LiveEventBus.get("mediaButton").post(Boolean.TRUE);
                return;
            }
            if (dVar.a(AudioPlayActivity.class)) {
                LiveEventBus.get("mediaButton").post(Boolean.TRUE);
                return;
            }
            e eVar = e.a;
            if ((c.b.a.m.f.J2(h.g(), "mediaButtonOnExit", true) || !z) && AppDatabaseKt.getAppDb().getBookDao().getLastReadBook() != null) {
                if (!dVar.a(MainActivity.class)) {
                    Intent intent = new Intent(context, (Class<?>) MainActivity.class);
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                }
                Intent intent2 = new Intent(context, (Class<?>) ReadBookActivity.class);
                intent2.addFlags(268435456);
                intent2.putExtra("readAloud", true);
                context.startActivity(intent2);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        j.e(context, c.R);
        j.e(intent, "intent");
        if (INSTANCE.a(context, intent) && isOrderedBroadcast()) {
            abortBroadcast();
        }
    }
}
