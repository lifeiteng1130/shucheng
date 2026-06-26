package io.legado.app.service;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioFocusRequestCompat;
import androidx.media.AudioManagerCompat;
import androidx.media.app.NotificationCompat;
import c.a.a.a.a;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.o;
import e.a.a.d.u.b;
import e.a.a.f.m;
import e.a.a.f.s.q;
import e.a.a.g.d.i.s1.g.b;
import f.c0.c.j;
import f.h0.k;
import f.v;
import f.x.e;
import io.legado.app.base.BaseService;
import io.legado.app.receiver.MediaButtonReceiver;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Objects;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BaseReadAloudService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\\\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J)\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0017\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u001d\u0010\u0005J\u0019\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u0015H&¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0003H&¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0003H&¢\u0006\u0004\b!\u0010\u0005J\r\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\tJ\u0019\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020\u0013H&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010\u0005R\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010.R,\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u001300j\b\u0012\u0004\u0012\u00020\u0013`18\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\b3\u00104R\"\u0010;\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010\tR\"\u0010>\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u00107\u001a\u0004\b<\u00109\"\u0004\b=\u0010\tR\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010G\u001a\u00020C8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010D\u001a\u0004\bE\u0010FR$\u0010N\u001a\u0004\u0018\u00010H8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010PR\u0016\u0010T\u001a\u00020R8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010SR\"\u0010W\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u00107\u001a\u0004\bU\u00109\"\u0004\bV\u0010\tR\u0016\u0010X\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010+R\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010Z¨\u0006]"}, d2 = {"Lio/legado/app/service/BaseReadAloudService;", "Lio/legado/app/base/BaseService;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "Lf/v;", ai.aD, "()V", "", "state", "m", "(I)V", "n", "onCreate", "onDestroy", "Landroid/content/Intent;", "intent", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "", "dataKey", "", "play", "e", "(Ljava/lang/String;Z)V", ai.aA, "pause", "h", "(Z)V", Constants.LANDSCAPE, "reset", "o", "j", "g", "k", "()Z", "focusChange", "onAudioFocusChange", "actionStr", "Landroid/app/PendingIntent;", "b", "(Ljava/lang/String;)Landroid/app/PendingIntent;", "f", "Ljava/lang/String;", "subtitle", "Landroid/support/v4/media/session/MediaSessionCompat;", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaSessionCompat", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getContentList$app_adsRelease", "()Ljava/util/ArrayList;", "contentList", "p", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getPageIndex$app_adsRelease", "()I", "setPageIndex$app_adsRelease", "pageIndex", "getReadAloudNumber$app_adsRelease", "setReadAloudNumber$app_adsRelease", "readAloudNumber", "Ljava/lang/Runnable;", "q", "Ljava/lang/Runnable;", "dsRunnable", "Landroid/os/Handler;", "Landroid/os/Handler;", "getHandler$app_adsRelease", "()Landroid/os/Handler;", "handler", "Le/a/a/g/d/i/s1/g/b;", "Le/a/a/g/d/i/s1/g/b;", "getTextChapter$app_adsRelease", "()Le/a/a/g/d/i/s1/g/b;", "setTextChapter$app_adsRelease", "(Le/a/a/g/d/i/s1/g/b;)V", "textChapter", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "broadcastReceiver", "Landroid/media/AudioManager;", "Landroid/media/AudioManager;", "audioManager", "getNowSpeak$app_adsRelease", "setNowSpeak$app_adsRelease", "nowSpeak", "title", "Landroidx/media/AudioFocusRequestCompat;", "Landroidx/media/AudioFocusRequestCompat;", "mFocusRequest", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseReadAloudService extends BaseService implements AudioManager.OnAudioFocusChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6927b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f6928c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f6929d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public AudioManager audioManager;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public AudioFocusRequestCompat mFocusRequest;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BroadcastReceiver broadcastReceiver;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public MediaSessionCompat mediaSessionCompat;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int nowSpeak;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int readAloudNumber;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @Nullable
    public b textChapter;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public int pageIndex;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String title = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String subtitle = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<String> contentList = new ArrayList<>();

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final Runnable dsRunnable = new Runnable() { // from class: e.a.a.f.c
        @Override // java.lang.Runnable
        public final void run() {
            BaseReadAloudService baseReadAloudService = this.a;
            boolean z = BaseReadAloudService.f6927b;
            f.c0.c.j.e(baseReadAloudService, "this$0");
            baseReadAloudService.c();
        }
    };

    public static final boolean d() {
        return f6927b && !f6929d;
    }

    @Nullable
    public abstract PendingIntent b(@NotNull String actionStr);

    public final void c() {
        if (!f6929d) {
            int i2 = f6928c - 1;
            f6928c = i2;
            if (i2 == 0) {
                stopSelf();
            } else if (i2 > 0) {
                this.handler.postDelayed(this.dsRunnable, 60000L);
            }
        }
        LiveEventBus.get("ttsDs").post(Integer.valueOf(f6928c));
        n();
    }

    @CallSuper
    public void e(@Nullable String dataKey, boolean play) {
        int iM;
        v vVar = null;
        if (dataKey != null) {
            b bVar = (b) o.a.a(dataKey);
            this.textChapter = bVar;
            if (bVar != null) {
                this.nowSpeak = 0;
                this.readAloudNumber = bVar.c(this.pageIndex);
                this.contentList.clear();
                if (f.K2(this, "readAloudByPage", false, 2)) {
                    int i2 = this.pageIndex;
                    int iM2 = e.m(bVar.f5768d);
                    if (i2 <= iM2) {
                        while (true) {
                            int i3 = i2 + 1;
                            e.a.a.g.d.i.s1.g.e eVarD = bVar.d(i2);
                            String str = eVarD == null ? null : eVarD.f5781b;
                            if (str != null) {
                                this.contentList.addAll(k.F(str, new String[]{"\n"}, false, 0, 6));
                            }
                            if (i2 == iM2) {
                                break;
                            } else {
                                i2 = i3;
                            }
                        }
                    }
                } else {
                    int i4 = this.pageIndex;
                    StringBuilder sb = new StringBuilder();
                    if ((!bVar.f5768d.isEmpty()) && i4 <= (iM = e.m(bVar.f5768d))) {
                        while (true) {
                            int i5 = i4 + 1;
                            sb.append(bVar.f5768d.get(i4).f5781b);
                            if (i4 == iM) {
                                break;
                            } else {
                                i4 = i5;
                            }
                        }
                    }
                    String string = sb.toString();
                    j.d(string, "stringBuilder.toString()");
                    for (String str2 : k.F(string, new String[]{"\n"}, false, 0, 6)) {
                        if (str2.length() > 0) {
                            this.contentList.add(str2);
                        }
                    }
                }
                if (play) {
                    i();
                }
                vVar = v.a;
            }
            if (vVar == null) {
                stopSelf();
            }
            vVar = v.a;
        }
        if (vVar == null) {
            stopSelf();
        }
    }

    public void f() {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new q(null), 3);
        if (kVar.k(true)) {
            return;
        }
        stopSelf();
    }

    public abstract void g();

    @CallSuper
    public void h(boolean pause) {
        f6929d = pause;
        n();
        m(2);
        LiveEventBus.get("aloud_state").post(3);
        e.a.a.f.s.k.w(e.a.a.f.s.k.a, false, 1);
    }

    public void i() {
        f6929d = false;
        n();
        LiveEventBus.get("aloud_state").post(1);
    }

    public abstract void j();

    public final boolean k() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            j.m("audioManager");
            throw null;
        }
        AudioFocusRequestCompat audioFocusRequestCompat = this.mFocusRequest;
        j.e(audioManager, "audioManager");
        return (audioFocusRequestCompat == null ? 1 : AudioManagerCompat.requestAudioFocus(audioManager, audioFocusRequestCompat)) == 1;
    }

    @CallSuper
    public void l() {
        f6929d = false;
        m(3);
        if (f6928c > 1) {
            c();
        }
    }

    public final void m(int state) {
        MediaSessionCompat mediaSessionCompat = this.mediaSessionCompat;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.setPlaybackState(new PlaybackStateCompat.Builder().setActions(3670015L).setState(state, this.nowSpeak, 1.0f).build());
        } else {
            j.m("mediaSessionCompat");
            throw null;
        }
    }

    public final void n() {
        String string;
        if (f6929d) {
            string = getString(R.string.read_aloud_pause);
            j.d(string, "getString(R.string.read_aloud_pause)");
        } else {
            int i2 = f6928c;
            if (1 <= i2 && i2 <= 180) {
                string = getString(R.string.read_aloud_timer, new Object[]{Integer.valueOf(i2)});
                j.d(string, "getString(\n                R.string.read_aloud_timer,\n                timeMinute\n            )");
            } else {
                string = getString(R.string.read_aloud_t);
                j.d(string, "getString(R.string.read_aloud_t)");
            }
        }
        StringBuilder sbT = a.t(string, ": ");
        sbT.append(this.title);
        String string2 = sbT.toString();
        String string3 = this.subtitle;
        if (string3.length() == 0) {
            string3 = getString(R.string.read_aloud_s);
            j.d(string3, "getString(R.string.read_aloud_s)");
        }
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(this, "channel_read_aloud").setSmallIcon(R.drawable.ic_volume_up).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon_read_book)).setOngoing(true).setContentTitle(string2).setContentText(string3);
        Intent intent = new Intent(this, (Class<?>) ReadBookActivity.class);
        intent.setAction("activity");
        NotificationCompat.Builder contentIntent = contentText.setContentIntent(PendingIntent.getActivity(this, 0, intent, 134217728));
        if (f6929d) {
            contentIntent.addAction(R.drawable.ic_play_24dp, getString(R.string.resume), b("resume"));
        } else {
            contentIntent.addAction(R.drawable.ic_pause_24dp, getString(R.string.pause), b("pause"));
        }
        contentIntent.addAction(R.drawable.ic_stop_black_24dp, getString(R.string.stop), b("stop"));
        contentIntent.addAction(R.drawable.ic_time_add_24dp, getString(R.string.set_timer), b("addTimer"));
        contentIntent.setStyle(new NotificationCompat.MediaStyle().setShowActionsInCompactView(0, 1, 2));
        contentIntent.setVisibility(1);
        startForeground(1144771, contentIntent.build());
    }

    public abstract void o(boolean reset);

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        if (focusChange == -2) {
            if (f6929d) {
                return;
            }
            h(false);
        } else if (focusChange == 1 && !f6929d) {
            l();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f6927b = true;
        Object systemService = getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        j.e(this, "audioFocusChangeListener");
        this.mFocusRequest = new AudioFocusRequestCompat.Builder(1).setAudioAttributes(new AudioAttributesCompat.Builder().setUsage(1).setContentType(2).build()).setOnAudioFocusChangeListener(this).build();
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(this, "readAloud");
        this.mediaSessionCompat = mediaSessionCompat;
        mediaSessionCompat.setCallback(new m(this));
        MediaSessionCompat mediaSessionCompat2 = this.mediaSessionCompat;
        if (mediaSessionCompat2 == null) {
            j.m("mediaSessionCompat");
            throw null;
        }
        mediaSessionCompat2.setMediaButtonReceiver(PendingIntent.getBroadcast(this, 0, new Intent("android.intent.action.MEDIA_BUTTON", null, h.g(), MediaButtonReceiver.class), 268435456));
        MediaSessionCompat mediaSessionCompat3 = this.mediaSessionCompat;
        if (mediaSessionCompat3 == null) {
            j.m("mediaSessionCompat");
            throw null;
        }
        mediaSessionCompat3.setActive(true);
        this.broadcastReceiver = new BroadcastReceiver() { // from class: io.legado.app.service.BaseReadAloudService$initBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                j.e(context, c.R);
                j.e(intent, "intent");
                if (j.a("android.media.AUDIO_BECOMING_NOISY", intent.getAction())) {
                    this.a.h(true);
                }
            }
        };
        registerReceiver(this.broadcastReceiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        n();
        m(3);
    }

    @Override // io.legado.app.base.BaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f6927b = false;
        f6929d = true;
        unregisterReceiver(this.broadcastReceiver);
        LiveEventBus.get("aloud_state").post(0);
        m(1);
        MediaSessionCompat mediaSessionCompat = this.mediaSessionCompat;
        if (mediaSessionCompat == null) {
            j.m("mediaSessionCompat");
            throw null;
        }
        mediaSessionCompat.release();
        e.a.a.f.s.k.w(e.a.a.f.s.k.a, false, 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0103  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int onStartCommand(@org.jetbrains.annotations.Nullable android.content.Intent r7, int r8, int r9) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.service.BaseReadAloudService.onStartCommand(android.content.Intent, int, int):int");
    }
}
