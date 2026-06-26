package io.legado.app.service;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.e;
import e.a.a.f.s.k;
import f.c0.b.p;
import f.c0.c.j;
import f.h;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseService;
import io.wenyuange.app.release.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TTSReadAloudService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010\u0005R\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010&\u001a\u00060#R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lio/legado/app/service/TTSReadAloudService;", "Lio/legado/app/service/BaseReadAloudService;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "Lf/v;", "onCreate", "()V", "Landroid/content/Intent;", "rootIntent", "onTaskRemoved", "(Landroid/content/Intent;)V", "onDestroy", "p", "", NotificationCompat.CATEGORY_STATUS, "onInit", "(I)V", ai.aA, "", "reset", "o", "(Z)V", "j", "g", "pause", "h", Constants.LANDSCAPE, "", "actionStr", "Landroid/app/PendingIntent;", "b", "(Ljava/lang/String;)Landroid/app/PendingIntent;", "q", ai.az, "Z", "ttsInitFinish", "Lio/legado/app/service/TTSReadAloudService$a;", ai.aF, "Lio/legado/app/service/TTSReadAloudService$a;", "ttsUtteranceListener", "Landroid/speech/tts/TextToSpeech;", "r", "Landroid/speech/tts/TextToSpeech;", "textToSpeech", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TTSReadAloudService extends BaseReadAloudService implements TextToSpeech.OnInitListener {

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @Nullable
    public TextToSpeech textToSpeech;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public boolean ttsInitFinish;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @NotNull
    public final a ttsUtteranceListener = new a(this);

    /* JADX INFO: compiled from: TTSReadAloudService.kt */
    public final class a extends UtteranceProgressListener {
        public final /* synthetic */ TTSReadAloudService a;

        public a(TTSReadAloudService tTSReadAloudService) {
            j.e(tTSReadAloudService, "this$0");
            this.a = tTSReadAloudService;
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(@NotNull String str) {
            j.e(str, ai.az);
            TTSReadAloudService tTSReadAloudService = this.a;
            tTSReadAloudService.readAloudNumber = tTSReadAloudService.contentList.get(tTSReadAloudService.nowSpeak).length() + 1 + tTSReadAloudService.readAloudNumber;
            TTSReadAloudService tTSReadAloudService2 = this.a;
            int i2 = tTSReadAloudService2.nowSpeak + 1;
            tTSReadAloudService2.nowSpeak = i2;
            if (i2 >= tTSReadAloudService2.contentList.size()) {
                this.a.f();
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(@NotNull String str) {
            j.e(str, ai.az);
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onRangeStart(@Nullable String str, int i2, int i3, int i4) {
            super.onRangeStart(str, i2, i3, i4);
            TTSReadAloudService tTSReadAloudService = this.a;
            e.a.a.g.d.i.s1.g.b bVar = tTSReadAloudService.textChapter;
            if (bVar != null && tTSReadAloudService.readAloudNumber + i2 > bVar.c(tTSReadAloudService.pageIndex + 1)) {
                tTSReadAloudService.pageIndex++;
                k.a.l();
                LiveEventBus.get("ttsStart").post(Integer.valueOf(tTSReadAloudService.readAloudNumber + i2));
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(@NotNull String str) {
            j.e(str, ai.az);
            TTSReadAloudService tTSReadAloudService = this.a;
            e.a.a.g.d.i.s1.g.b bVar = tTSReadAloudService.textChapter;
            if (bVar == null) {
                return;
            }
            if (tTSReadAloudService.readAloudNumber + 1 > bVar.c(tTSReadAloudService.pageIndex + 1)) {
                tTSReadAloudService.pageIndex++;
                k.a.l();
            }
            LiveEventBus.get("ttsStart").post(Integer.valueOf(tTSReadAloudService.readAloudNumber + 1));
        }
    }

    /* JADX INFO: compiled from: TTSReadAloudService.kt */
    @DebugMetadata(c = "io.legado.app.service.TTSReadAloudService$onInit$2", f = "TTSReadAloudService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public b(f.z.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return TTSReadAloudService.this.new b(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            f.Q5(TTSReadAloudService.this, R.string.tts_init_failed);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: TTSReadAloudService.kt */
    @DebugMetadata(c = "io.legado.app.service.TTSReadAloudService$play$1", f = "TTSReadAloudService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public c(f.z.d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return TTSReadAloudService.this.new c(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            TTSReadAloudService tTSReadAloudService = TTSReadAloudService.this;
            j.e(tTSReadAloudService, "mContext");
            try {
                final MediaPlayer mediaPlayerCreate = MediaPlayer.create(tTSReadAloudService, R.raw.silent_sound);
                mediaPlayerCreate.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: e.a.a.d.a
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayerCreate.release();
                    }
                });
                mediaPlayerCreate.start();
                h.m11constructorimpl(v.a);
            } catch (Throwable th) {
                h.m11constructorimpl(f.m1(th));
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: TTSReadAloudService.kt */
    @DebugMetadata(c = "io.legado.app.service.TTSReadAloudService$play$2", f = "TTSReadAloudService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public d(f.z.d<? super d> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return TTSReadAloudService.this.new d(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            TTSReadAloudService tTSReadAloudService = TTSReadAloudService.this;
            TextToSpeech textToSpeech = tTSReadAloudService.textToSpeech;
            if (textToSpeech != null) {
                textToSpeech.speak("", 0, null, null);
                int i2 = tTSReadAloudService.nowSpeak;
                int size = tTSReadAloudService.contentList.size();
                if (i2 < size) {
                    while (true) {
                        int i3 = i2 + 1;
                        textToSpeech.speak(tTSReadAloudService.contentList.get(i2), 1, null, j.k("Legado", new Integer(i2)));
                        if (i3 >= size) {
                            break;
                        }
                        i2 = i3;
                    }
                }
            }
            return v.a;
        }
    }

    @Override // io.legado.app.service.BaseReadAloudService
    @Nullable
    public PendingIntent b(@NotNull String actionStr) {
        j.e(actionStr, "actionStr");
        Intent intent = new Intent(this, (Class<?>) TTSReadAloudService.class);
        intent.setAction(actionStr);
        return PendingIntent.getService(this, 0, intent, 134217728);
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void g() {
        if (this.nowSpeak < this.contentList.size() - 1) {
            TextToSpeech textToSpeech = this.textToSpeech;
            if (textToSpeech != null) {
                textToSpeech.stop();
            }
            this.readAloudNumber = this.contentList.get(this.nowSpeak).length() + 1 + this.readAloudNumber;
            this.nowSpeak++;
            i();
        }
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void h(boolean pause) {
        super.h(pause);
        TextToSpeech textToSpeech = this.textToSpeech;
        if (textToSpeech == null) {
            return;
        }
        textToSpeech.stop();
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public synchronized void i() {
        if ((!this.contentList.isEmpty()) && this.ttsInitFinish && k()) {
            super.i();
            e.a.a.d.u.b.c(BaseService.a(this, null, null, new c(null), 3, null), null, new d(null), 1);
        }
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void j() {
        if (this.nowSpeak > 0) {
            TextToSpeech textToSpeech = this.textToSpeech;
            if (textToSpeech != null) {
                textToSpeech.stop();
            }
            this.nowSpeak = this.nowSpeak - 1;
            this.readAloudNumber -= this.contentList.get(r0).length() - 1;
            i();
        }
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void l() {
        super.l();
        i();
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void o(boolean reset) {
        if (f.J2(this, "ttsFollowSys", true)) {
            if (reset) {
                p();
                q();
                return;
            }
            return;
        }
        TextToSpeech textToSpeech = this.textToSpeech;
        if (textToSpeech == null) {
            return;
        }
        textToSpeech.setSpeechRate((e.a.l() + 5) / 10.0f);
    }

    @Override // io.legado.app.service.BaseReadAloudService, android.app.Service
    public void onCreate() {
        super.onCreate();
        q();
        o(false);
    }

    @Override // io.legado.app.service.BaseReadAloudService, io.legado.app.base.BaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        p();
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int status) {
        if (status != 0) {
            f.L3(this, null, null, new b(null), 3, null);
            return;
        }
        TextToSpeech textToSpeech = this.textToSpeech;
        if (textToSpeech == null) {
            return;
        }
        textToSpeech.setOnUtteranceProgressListener(this.ttsUtteranceListener);
        textToSpeech.setLanguage(Locale.CHINA);
        this.ttsInitFinish = true;
        i();
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        p();
        stopSelf();
    }

    public final synchronized void p() {
        TextToSpeech textToSpeech = this.textToSpeech;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
        TextToSpeech textToSpeech2 = this.textToSpeech;
        if (textToSpeech2 != null) {
            textToSpeech2.shutdown();
        }
        this.textToSpeech = null;
        this.ttsInitFinish = false;
    }

    public final synchronized void q() {
        this.ttsInitFinish = false;
        this.textToSpeech = new TextToSpeech(this, this);
    }
}
