package io.legado.app.service;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.app.NotificationCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioFocusRequestCompat;
import androidx.media.AudioManagerCompat;
import androidx.media.app.NotificationCompat;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.qq.e.comm.constants.Constants;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.u.b;
import e.a.a.f.k;
import f.c0.b.p;
import f.c0.c.j;
import f.h;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseService;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.receiver.MediaButtonReceiver;
import io.legado.app.service.AudioPlayService;
import io.legado.app.ui.audio.AudioPlayActivity;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: AudioPlayService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\bX\u0010\fJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\fJ)\u0010\u001e\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010\fJ\r\u0010!\u001a\u00020\r¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J'\u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rH\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b+\u0010&J\u0017\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\rH\u0016¢\u0006\u0004\b-\u0010\u0010R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010IR\u0016\u0010L\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00106R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010@R\u001c\u0010T\u001a\u00020\u00148\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010@\u001a\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Y"}, d2 = {"Lio/legado/app/service/AudioPlayService;", "Lio/legado/app/base/BaseService;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "Landroid/media/MediaPlayer$OnPreparedListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "Landroid/media/MediaPlayer$OnCompletionListener;", "", "pause", "Lf/v;", "d", "(Z)V", "f", "()V", "", "index", "e", "(I)V", "state", "h", ai.aA, "", "action", "Landroid/app/PendingIntent;", "g", "(Ljava/lang/String;)Landroid/app/PendingIntent;", "onCreate", "Landroid/content/Intent;", "intent", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", ai.aD, "()I", "Landroid/media/MediaPlayer;", "mp", "onPrepared", "(Landroid/media/MediaPlayer;)V", "what", BaseConstants.EVENT_LABEL_EXTRA, "onError", "(Landroid/media/MediaPlayer;II)Z", "onCompletion", "focusChange", "onAudioFocusChange", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Landroid/media/AudioManager;", "Landroid/media/AudioManager;", "audioManager", "Ljava/lang/Runnable;", "p", "Ljava/lang/Runnable;", "dsRunnable", "Landroid/support/v4/media/session/MediaSessionCompat;", Constants.LANDSCAPE, "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaSessionCompat", "k", "Landroid/media/MediaPlayer;", "mediaPlayer", "j", "Ljava/lang/String;", "subtitle", "n", "url", "Landroid/content/BroadcastReceiver;", "m", "Landroid/content/BroadcastReceiver;", "broadcastReceiver", "Landroidx/media/AudioFocusRequestCompat;", "Landroidx/media/AudioFocusRequestCompat;", "mFocusRequest", "q", "mpRunnable", "", "r", "F", "playSpeed", "title", "getTag", "()Ljava/lang/String;", "tag", "o", OptRuntime.GeneratorState.resumptionPoint_TYPE, "position", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioPlayService extends BaseService implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f6917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f6918d;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public AudioManager audioManager;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public AudioFocusRequestCompat mFocusRequest;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public MediaSessionCompat mediaSessionCompat;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public BroadcastReceiver broadcastReceiver;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int position;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String tag = "AudioPlayService";

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String title = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String subtitle = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediaPlayer mediaPlayer = new MediaPlayer();

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public String url = "";

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final Runnable dsRunnable = new Runnable() { // from class: e.a.a.f.a
        @Override // java.lang.Runnable
        public final void run() {
            AudioPlayService audioPlayService = this.a;
            boolean z = AudioPlayService.f6916b;
            f.c0.c.j.e(audioPlayService, "this$0");
            if (!AudioPlayService.f6917c) {
                int i2 = AudioPlayService.f6918d - 1;
                AudioPlayService.f6918d = i2;
                if (i2 == 0) {
                    audioPlayService.stopSelf();
                } else if (i2 > 0) {
                    audioPlayService.handler.postDelayed(audioPlayService.dsRunnable, 60000L);
                }
            }
            LiveEventBus.get("ttsDs").post(Integer.valueOf(AudioPlayService.f6918d));
            audioPlayService.i();
        }
    };

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public Runnable mpRunnable = new Runnable() { // from class: e.a.a.f.b
        @Override // java.lang.Runnable
        public final void run() {
            AudioPlayService audioPlayService = this.a;
            boolean z = AudioPlayService.f6916b;
            f.c0.c.j.e(audioPlayService, "this$0");
            BaseService.a(audioPlayService, null, null, new l(audioPlayService, null), 3, null);
            LiveEventBus.get("audioProgress").post(Integer.valueOf(audioPlayService.c()));
            audioPlayService.handler.postDelayed(audioPlayService.mpRunnable, 1000L);
        }
    };

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public float playSpeed = 1.0f;

    /* JADX INFO: compiled from: AudioPlayService.kt */
    @DebugMetadata(c = "io.legado.app.service.AudioPlayService$onError$1", f = "AudioPlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ int $extra;
        public final /* synthetic */ int $what;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, int i3, d<? super a> dVar) {
            super(2, dVar);
            this.$what = i2;
            this.$extra = i3;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return AudioPlayService.this.new a(this.$what, this.$extra, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            AudioPlayService audioPlayService = AudioPlayService.this;
            StringBuilder sbR = c.a.a.a.a.r("error: ");
            sbR.append(this.$what);
            sbR.append(' ');
            sbR.append(this.$extra);
            sbR.append(' ');
            sbR.append(AudioPlayService.this.url);
            f.R5(audioPlayService, sbR.toString());
            return v.a;
        }
    }

    public static final void b(AudioPlayService audioPlayService, BookChapter bookChapter, String str) {
        Object objM11constructorimpl;
        BookSource bookSource;
        Objects.requireNonNull(audioPlayService);
        int index = bookChapter.getIndex();
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        if (index == e.a.a.f.s.a.f5668h) {
            audioPlayService.subtitle = bookChapter.getTitle();
            audioPlayService.url = str;
            audioPlayService.i();
            AudioManager audioManager = audioPlayService.audioManager;
            if (audioManager == null) {
                j.m("audioManager");
                throw null;
            }
            AudioFocusRequestCompat audioFocusRequestCompat = audioPlayService.mFocusRequest;
            j.e(audioManager, "audioManager");
            if ((audioFocusRequestCompat == null ? 1 : AudioManagerCompat.requestAudioFocus(audioManager, audioFocusRequestCompat)) == 1) {
                try {
                    e.a.a.f.s.a.f5664d = 0;
                    LiveEventBus.get("audioState").post(0);
                    audioPlayService.mediaPlayer.reset();
                    String str2 = audioPlayService.url;
                    WebBook webBook = e.a.a.f.s.a.f5670j;
                    AnalyzeUrl analyzeUrl = new AnalyzeUrl(str2, null, null, null, null, null, true, null, null, null, (webBook == null || (bookSource = webBook.getBookSource()) == null) ? null : bookSource.getHeaderMap(), 958, null);
                    audioPlayService.mediaPlayer.setDataSource(audioPlayService, Uri.parse(analyzeUrl.getUrl()), analyzeUrl.getHeaderMap());
                    audioPlayService.mediaPlayer.prepareAsync();
                    audioPlayService.handler.removeCallbacks(audioPlayService.mpRunnable);
                    objM11constructorimpl = h.m11constructorimpl(v.a);
                } catch (Throwable th) {
                    objM11constructorimpl = h.m11constructorimpl(f.m1(th));
                }
                Throwable thM14exceptionOrNullimpl = h.m14exceptionOrNullimpl(objM11constructorimpl);
                if (thM14exceptionOrNullimpl != null) {
                    thM14exceptionOrNullimpl.printStackTrace();
                    f.L3(audioPlayService, null, null, new k(audioPlayService, thM14exceptionOrNullimpl, null), 3, null);
                }
            }
        }
    }

    public final int c() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return 0;
        }
        try {
            return mediaPlayer.getCurrentPosition();
        } catch (Exception unused) {
            return 0;
        }
    }

    public final void d(boolean pause) {
        if (f.h0.k.b(this.url, ".m3u8", false)) {
            stopSelf();
            return;
        }
        try {
            f6917c = pause;
            this.handler.removeCallbacks(this.mpRunnable);
            this.position = c();
            if (this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.pause();
            }
            h(2);
            e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
            e.a.a.f.s.a.f5664d = 3;
            LiveEventBus.get("audioState").post(3);
            i();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void e(int index) {
        synchronized (this) {
            e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
            e.a.a.f.s.a.f5671k.remove(Integer.valueOf(index));
        }
    }

    public final void f() {
        boolean zIsPlaying;
        f6917c = false;
        try {
            zIsPlaying = this.mediaPlayer.isPlaying();
        } catch (IllegalStateException e2) {
            e2.getMessage();
            zIsPlaying = true;
        }
        if (!zIsPlaying) {
            this.mediaPlayer.start();
            this.mediaPlayer.seekTo(this.position);
        }
        this.handler.removeCallbacks(this.mpRunnable);
        this.handler.postDelayed(this.mpRunnable, 1000L);
        h(3);
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        e.a.a.f.s.a.f5664d = 1;
        LiveEventBus.get("audioState").post(1);
        i();
    }

    public final PendingIntent g(String action) {
        Intent intent = new Intent(this, (Class<?>) AudioPlayService.class);
        intent.setAction(action);
        return PendingIntent.getService(this, 0, intent, 134217728);
    }

    public final void h(int state) {
        MediaSessionCompat mediaSessionCompat = this.mediaSessionCompat;
        if (mediaSessionCompat == null) {
            return;
        }
        mediaSessionCompat.setPlaybackState(new PlaybackStateCompat.Builder().setActions(3670015L).setState(state, this.position, 1.0f).build());
    }

    public final void i() {
        String string;
        if (f6917c) {
            string = getString(R.string.audio_pause);
            j.d(string, "getString(R.string.audio_pause)");
        } else {
            int i2 = f6918d;
            if (1 <= i2 && i2 <= 60) {
                string = getString(R.string.playing_timer, new Object[]{Integer.valueOf(i2)});
                j.d(string, "getString(\n                R.string.playing_timer,\n                timeMinute\n            )");
            } else {
                string = getString(R.string.audio_play_t);
                j.d(string, "getString(R.string.audio_play_t)");
            }
        }
        StringBuilder sbT = c.a.a.a.a.t(string, ": ");
        sbT.append(this.title);
        String string2 = sbT.toString();
        String string3 = this.subtitle;
        if (string3.length() == 0) {
            string3 = getString(R.string.audio_play_s);
            j.d(string3, "getString(R.string.audio_play_s)");
        }
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(this, "channel_read_aloud").setSmallIcon(R.drawable.ic_volume_up).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon_read_book)).setOngoing(true).setContentTitle(string2).setContentText(string3);
        Intent intent = new Intent(this, (Class<?>) AudioPlayActivity.class);
        intent.setAction("activity");
        NotificationCompat.Builder contentIntent = contentText.setContentIntent(PendingIntent.getActivity(this, 0, intent, 134217728));
        if (f6917c) {
            contentIntent.addAction(R.drawable.ic_play_24dp, getString(R.string.resume), g("resume"));
        } else {
            contentIntent.addAction(R.drawable.ic_pause_24dp, getString(R.string.pause), g("pause"));
        }
        contentIntent.addAction(R.drawable.ic_stop_black_24dp, getString(R.string.stop), g("stop"));
        contentIntent.addAction(R.drawable.ic_time_add_24dp, getString(R.string.set_timer), g("addTimer"));
        contentIntent.setStyle(new NotificationCompat.MediaStyle().setShowActionsInCompactView(0, 1, 2));
        contentIntent.setVisibility(1);
        startForeground(1144772, contentIntent.build());
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        if (focusChange == -2) {
            if (f6917c) {
                return;
            }
            d(false);
        } else if (focusChange == 1 && !f6917c) {
            f();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(@NotNull MediaPlayer mp) {
        j.e(mp, "mp");
        this.handler.removeCallbacks(this.mpRunnable);
        e.a.a.f.s.a.a.b(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f6916b = true;
        i();
        Object systemService = getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        j.e(this, "audioFocusChangeListener");
        this.mFocusRequest = new AudioFocusRequestCompat.Builder(1).setAudioAttributes(new AudioAttributesCompat.Builder().setUsage(1).setContentType(2).build()).setOnAudioFocusChangeListener(this).build();
        this.mediaPlayer.setOnErrorListener(this);
        this.mediaPlayer.setOnPreparedListener(this);
        this.mediaPlayer.setOnCompletionListener(this);
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(this, "readAloud");
        this.mediaSessionCompat = mediaSessionCompat;
        mediaSessionCompat.setCallback(new e.a.a.f.g(this));
        MediaSessionCompat mediaSessionCompat2 = this.mediaSessionCompat;
        if (mediaSessionCompat2 != null) {
            mediaSessionCompat2.setMediaButtonReceiver(PendingIntent.getBroadcast(this, 0, new Intent("android.intent.action.MEDIA_BUTTON", null, k.d.a.h.g(), MediaButtonReceiver.class), 268435456));
        }
        MediaSessionCompat mediaSessionCompat3 = this.mediaSessionCompat;
        if (mediaSessionCompat3 != null) {
            mediaSessionCompat3.setActive(true);
        }
        this.broadcastReceiver = new BroadcastReceiver() { // from class: io.legado.app.service.AudioPlayService$initBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                j.e(context, c.R);
                j.e(intent, "intent");
                if (j.a("android.media.AUDIO_BECOMING_NOISY", intent.getAction())) {
                    AudioPlayService audioPlayService = this.a;
                    boolean z = AudioPlayService.f6916b;
                    audioPlayService.d(true);
                }
            }
        };
        registerReceiver(this.broadcastReceiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        h(3);
    }

    @Override // io.legado.app.base.BaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f6916b = false;
        this.handler.removeCallbacks(this.dsRunnable);
        this.handler.removeCallbacks(this.mpRunnable);
        this.mediaPlayer.release();
        MediaSessionCompat mediaSessionCompat = this.mediaSessionCompat;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.release();
        }
        unregisterReceiver(this.broadcastReceiver);
        h(1);
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        e.a.a.f.s.a.f5664d = 0;
        LiveEventBus.get("audioState").post(0);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(@NotNull MediaPlayer mp, int what, int extra) {
        j.e(mp, "mp");
        if (this.mediaPlayer.isPlaying()) {
            return true;
        }
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        e.a.a.f.s.a.f5664d = 0;
        LiveEventBus.get("audioState").post(0);
        f.L3(this, null, null, new a(what, extra, null), 3, null);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(@NotNull MediaPlayer mp) {
        j.e(mp, "mp");
        if (Build.VERSION.SDK_INT >= 23) {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            PlaybackParams playbackParams = mediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(this.playSpeed);
            mediaPlayer.setPlaybackParams(playbackParams);
        } else {
            this.mediaPlayer.start();
        }
        this.mediaPlayer.seekTo(this.position);
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        e.a.a.f.s.a.f5664d = 1;
        LiveEventBus.get("audioState").post(1);
        LiveEventBus.get("audioSize").post(Integer.valueOf(this.mediaPlayer.getDuration()));
        this.handler.removeCallbacks(this.mpRunnable);
        this.handler.post(this.mpRunnable);
        b.C0148b.b(b.a, null, null, new e.a.a.f.s.c(this.mediaPlayer.getDuration(), null), 3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d3  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int onStartCommand(@org.jetbrains.annotations.Nullable android.content.Intent r14, int r15, int r16) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.service.AudioPlayService.onStartCommand(android.content.Intent, int, int):int");
    }
}
