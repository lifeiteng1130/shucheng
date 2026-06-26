package io.legado.app.ui.rss.read;

import android.app.Application;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import androidx.core.app.NotificationCompat;
import androidx.view.MutableLiveData;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.g.k.c.l;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import g.b.k0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssSource;
import io.legado.app.data.entities.RssStar;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import io.legado.app.model.rss.Rss;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRssViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002JKB\u000f\u0012\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bH\u0010IJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010 R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R&\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u001c0:j\b\u0012\u0004\u0012\u00020\u001c`;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010E\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006L"}, d2 = {"Lio/legado/app/ui/rss/read/ReadRssViewModel;", "Lio/legado/app/base/BaseViewModel;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "", NotificationCompat.CATEGORY_STATUS, "Lf/v;", "onInit", "(I)V", "onCleared", "()V", "h", "Lio/legado/app/ui/rss/read/ReadRssViewModel$a;", ai.aD, "Lio/legado/app/ui/rss/read/ReadRssViewModel$a;", "getCallBack", "()Lio/legado/app/ui/rss/read/ReadRssViewModel$a;", "setCallBack", "(Lio/legado/app/ui/rss/read/ReadRssViewModel$a;)V", "callBack", "Lio/legado/app/data/entities/RssArticle;", "e", "Lio/legado/app/data/entities/RssArticle;", "getRssArticle", "()Lio/legado/app/data/entities/RssArticle;", "setRssArticle", "(Lio/legado/app/data/entities/RssArticle;)V", "rssArticle", "Landroidx/lifecycle/MutableLiveData;", "", "f", "Landroidx/lifecycle/MutableLiveData;", "getContentLiveData", "()Landroidx/lifecycle/MutableLiveData;", "contentLiveData", "Landroid/speech/tts/TextToSpeech;", ai.aA, "Landroid/speech/tts/TextToSpeech;", "getTextToSpeech", "()Landroid/speech/tts/TextToSpeech;", "setTextToSpeech", "(Landroid/speech/tts/TextToSpeech;)V", "textToSpeech", "Lio/legado/app/model/analyzeRule/AnalyzeUrl;", "g", "getUrlLiveData", "urlLiveData", "", "j", "Z", "ttsInitFinish", "Lio/legado/app/data/entities/RssSource;", "d", "Lio/legado/app/data/entities/RssSource;", "getRssSource", "()Lio/legado/app/data/entities/RssSource;", "setRssSource", "(Lio/legado/app/data/entities/RssSource;)V", "rssSource", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "ttsTextList", "Lio/legado/app/data/entities/RssStar;", "Lio/legado/app/data/entities/RssStar;", "getRssStar", "()Lio/legado/app/data/entities/RssStar;", "setRssStar", "(Lio/legado/app/data/entities/RssStar;)V", "rssStar", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", ai.at, "b", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadRssViewModel extends BaseViewModel implements TextToSpeech.OnInitListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a callBack;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RssSource rssSource;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RssArticle rssArticle;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> contentLiveData;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<AnalyzeUrl> urlLiveData;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RssStar rssStar;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public TextToSpeech textToSpeech;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean ttsInitFinish;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public ArrayList<String> ttsTextList;

    /* JADX INFO: compiled from: ReadRssViewModel.kt */
    public interface a {
        void R(boolean z);

        void s0();
    }

    /* JADX INFO: compiled from: ReadRssViewModel.kt */
    public final class b extends UtteranceProgressListener {
        public final /* synthetic */ ReadRssViewModel a;

        public b(ReadRssViewModel readRssViewModel) {
            j.e(readRssViewModel, "this$0");
            this.a = readRssViewModel;
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(@NotNull String str) {
            j.e(str, ai.az);
            a aVar = this.a.callBack;
            if (aVar == null) {
                return;
            }
            aVar.R(false);
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(@NotNull String str) {
            j.e(str, ai.az);
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(@NotNull String str) {
            j.e(str, ai.az);
            a aVar = this.a.callBack;
            if (aVar == null) {
                return;
            }
            aVar.R(true);
        }
    }

    /* JADX INFO: compiled from: ReadRssViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.read.ReadRssViewModel$onInit$1", f = "ReadRssViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements p<a0, d<? super v>, Object> {
        public int label;

        public c(d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return ReadRssViewModel.this.new c(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            ReadRssViewModel.this.c(R.string.tts_init_failed);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadRssViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.contentLiveData = new MutableLiveData<>();
        this.urlLiveData = new MutableLiveData<>();
        this.ttsTextList = new ArrayList<>();
    }

    public static final void e(ReadRssViewModel readRssViewModel, RssArticle rssArticle, String str) {
        RssSource rssSource = readRssViewModel.rssSource;
        if (rssSource == null) {
            return;
        }
        e.a.a.d.u.b content$default = Rss.getContent$default(Rss.INSTANCE, readRssViewModel, rssArticle, str, rssSource, null, 16, null);
        k0 k0Var = k0.f6264c;
        content$default.d(k0.f6263b, new l(rssArticle, readRssViewModel, null));
    }

    public static final void f(ReadRssViewModel readRssViewModel, String str, String str2) {
        RssSource rssSource = readRssViewModel.rssSource;
        readRssViewModel.urlLiveData.postValue(new AnalyzeUrl(str, null, null, null, null, str2, true, null, null, null, rssSource == null ? null : rssSource.getHeaderMap(), 926, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(io.legado.app.ui.rss.read.ReadRssViewModel r4, java.lang.String r5, f.z.d r6) throws java.lang.Throwable {
        /*
            java.util.Objects.requireNonNull(r4)
            boolean r0 = r6 instanceof e.a.a.g.k.c.p
            if (r0 == 0) goto L16
            r0 = r6
            e.a.a.g.k.c.p r0 = (e.a.a.g.k.c.p) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            e.a.a.g.k.c.p r0 = new e.a.a.g.k.c.p
            r0.<init>(r4, r6)
        L1b:
            java.lang.Object r4 = r0.result
            f.z.i.a r6 = f.z.i.a.COROUTINE_SUSPENDED
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            c.b.a.m.f.E5(r4)
            goto L4e
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            c.b.a.m.f.E5(r4)
            boolean r4 = android.webkit.URLUtil.isValidUrl(r5)
            r1 = 0
            if (r4 == 0) goto L55
            okhttp3.OkHttpClient r4 = e.a.a.d.v.i.a()
            e.a.a.g.k.c.q r3 = new e.a.a.g.k.c.q
            r3.<init>(r5)
            r0.label = r2
            java.lang.Object r4 = c.b.a.m.f.Z3(r4, r1, r3, r0, r2)
            if (r4 != r6) goto L4e
            goto L74
        L4e:
            okhttp3.ResponseBody r4 = (okhttp3.ResponseBody) r4
            byte[] r4 = r4.bytes()
            goto L73
        L55:
            java.lang.String r4 = ","
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r6 = 6
            java.util.List r4 = f.h0.k.F(r5, r4, r1, r1, r6)
            java.lang.String[] r5 = new java.lang.String[r1]
            java.lang.Object[] r4 = r4.toArray(r5)
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T>"
            java.util.Objects.requireNonNull(r4, r5)
            java.lang.String[] r4 = (java.lang.String[]) r4
            r4 = r4[r2]
            byte[] r4 = android.util.Base64.decode(r4, r1)
        L73:
            r6 = r4
        L74:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.rss.read.ReadRssViewModel.g(io.legado.app.ui.rss.read.ReadRssViewModel, java.lang.String, f.z.d):java.lang.Object");
    }

    public final synchronized void h() {
        if (this.ttsInitFinish) {
            TextToSpeech textToSpeech = this.textToSpeech;
            if (textToSpeech != null) {
                textToSpeech.stop();
            }
            for (String str : this.ttsTextList) {
                TextToSpeech textToSpeech2 = this.textToSpeech;
                if (textToSpeech2 != null) {
                    textToSpeech2.speak(str, 1, null, "rss");
                }
            }
        }
    }

    @Override // io.legado.app.base.BaseViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        TextToSpeech textToSpeech = this.textToSpeech;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
        TextToSpeech textToSpeech2 = this.textToSpeech;
        if (textToSpeech2 == null) {
            return;
        }
        textToSpeech2.shutdown();
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public synchronized void onInit(int status) {
        try {
            if (status == 0) {
                TextToSpeech textToSpeech = this.textToSpeech;
                if (textToSpeech != null) {
                    textToSpeech.setLanguage(Locale.CHINA);
                }
                TextToSpeech textToSpeech2 = this.textToSpeech;
                if (textToSpeech2 != null) {
                    textToSpeech2.setOnUtteranceProgressListener(new b(this));
                }
                this.ttsInitFinish = true;
                h();
            } else {
                f.L3(this, null, null, new c(null), 3, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
