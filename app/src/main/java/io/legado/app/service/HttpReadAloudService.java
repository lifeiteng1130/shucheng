package io.legado.app.service;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.qq.e.comm.constants.Constants;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.ai;
import e.a.a.h.u;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseService;
import io.legado.app.data.entities.HttpTTS;
import io.legado.app.service.HttpReadAloudService;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: HttpReadAloudService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\bE\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0007J!\u0010!\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\u0007J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0007J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001fH\u0016¢\u0006\u0004\b)\u0010&J\u000f\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010\u0007J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0007J\u0019\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J)\u00103\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000200H\u0016¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b5\u0010/J\u0019\u00108\u001a\u0004\u0018\u0001072\u0006\u00106\u001a\u00020\fH\u0016¢\u0006\u0004\b8\u00109R\u001c\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010;R\u001d\u0010@\u001a\u00020,8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b>\u0010AR\u0016\u0010D\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010C¨\u0006F"}, d2 = {"Lio/legado/app/service/HttpReadAloudService;", "Lio/legado/app/service/BaseReadAloudService;", "Landroid/media/MediaPlayer$OnPreparedListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Lf/v;", ai.az, "()V", "Ljava/io/FileDescriptor;", "fd", "w", "(Ljava/io/FileDescriptor;)V", "", "x", "()Ljava/lang/String;", "url", "ttsConfig", "content", ai.aC, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "name", "Ljava/io/File;", ai.aE, "(Ljava/lang/String;)Ljava/io/File;", "onCreate", "Landroid/content/Intent;", "rootIntent", "onTaskRemoved", "(Landroid/content/Intent;)V", "onDestroy", "dataKey", "", "play", "e", "(Ljava/lang/String;Z)V", ai.aA, "pause", "h", "(Z)V", Constants.LANDSCAPE, "reset", "o", "j", "g", "Landroid/media/MediaPlayer;", "mp", "onPrepared", "(Landroid/media/MediaPlayer;)V", "", "what", BaseConstants.EVENT_LABEL_EXTRA, "onError", "(Landroid/media/MediaPlayer;II)Z", "onCompletion", "actionStr", "Landroid/app/PendingIntent;", "b", "(Ljava/lang/String;)Landroid/app/PendingIntent;", "Le/a/a/d/u/b;", "Le/a/a/d/u/b;", "task", "Lf/e;", ai.aF, "()Landroid/media/MediaPlayer;", "player", "Ljava/lang/String;", "ttsFolder", OptRuntime.GeneratorState.resumptionPoint_TYPE, "playingIndex", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class HttpReadAloudService extends BaseReadAloudService implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
    public static final /* synthetic */ int r = 0;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public String ttsFolder;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    @Nullable
    public e.a.a.d.u.b<?> task;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final e player = f.N3(b.INSTANCE);

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public int playingIndex = -1;

    /* JADX INFO: compiled from: HttpReadAloudService.kt */
    @DebugMetadata(c = "io.legado.app.service.HttpReadAloudService$downloadAudio$1", f = "HttpReadAloudService.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public int I$0;
        public int I$1;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public int label;

        public a(d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            a aVar = HttpReadAloudService.this.new a(dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01fd A[Catch: Exception -> 0x020d, IOException -> 0x0211, ConnectException -> 0x0215, SocketTimeoutException -> 0x0219, TRY_LEAVE, TryCatch #4 {ConnectException -> 0x0215, SocketTimeoutException -> 0x0219, IOException -> 0x0211, Exception -> 0x020d, blocks: (B:53:0x01e5, B:55:0x01fd), top: B:86:0x01e5 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0231  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x010f -> B:77:0x0261). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x014f -> B:77:0x0261). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0151 -> B:77:0x0261). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01df -> B:86:0x01e5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x025d -> B:35:0x00f2). Please report as a decompilation issue!!! */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r30) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 620
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.service.HttpReadAloudService.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: HttpReadAloudService.kt */
    public static final class b extends k implements f.c0.b.a<MediaPlayer> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final MediaPlayer invoke() {
            return new MediaPlayer();
        }
    }

    public static final File p(HttpReadAloudService httpReadAloudService, String str) throws IOException {
        String str2 = httpReadAloudService.x() + str + ".mp3.cache";
        j.e(str2, "filePath");
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            String parent = file.getParent();
            if (parent != null) {
                j.e(parent, "filePath");
                File file2 = new File(parent);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            file.createNewFile();
        }
        return file;
    }

    public static final File q(HttpReadAloudService httpReadAloudService, String str) {
        return FileUtils.a.b(httpReadAloudService.x() + str + ".mp3");
    }

    public static final void r(HttpReadAloudService httpReadAloudService, String str) {
        FileUtils.g(FileUtils.a, httpReadAloudService.x() + str + ".mp3.cache", false, 2);
    }

    @Override // io.legado.app.service.BaseReadAloudService
    @Nullable
    public PendingIntent b(@NotNull String actionStr) {
        j.e(actionStr, "actionStr");
        Intent intent = new Intent(this, (Class<?>) HttpReadAloudService.class);
        intent.setAction(actionStr);
        return PendingIntent.getService(this, 0, intent, 134217728);
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void e(@Nullable String dataKey, boolean play) {
        t().reset();
        this.playingIndex = -1;
        super.e(dataKey, play);
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void g() throws IOException {
        if (this.nowSpeak < this.contentList.size() - 1) {
            t().stop();
            this.readAloudNumber = this.contentList.get(this.nowSpeak).length() + 1 + this.readAloudNumber;
            this.nowSpeak++;
            i();
        }
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void h(boolean pause) {
        super.h(pause);
        try {
            t().pause();
        } catch (IllegalStateException unused) {
        }
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void i() throws IOException {
        if (this.contentList.isEmpty()) {
            return;
        }
        e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
        HttpTTS httpTTS = e.a.a.f.s.j.f5675c;
        if (httpTTS == null) {
            return;
        }
        String url = httpTTS.getUrl();
        String strValueOf = String.valueOf(e.a.a.d.e.a.l());
        String str = this.contentList.get(this.nowSpeak);
        j.d(str, "contentList[nowSpeak]");
        String strV = v(url, strValueOf, str);
        if (this.nowSpeak == 0) {
            s();
            return;
        }
        File fileU = u(strV);
        if (!fileU.exists()) {
            s();
            return;
        }
        FileDescriptor fd = new FileInputStream(fileU).getFD();
        j.d(fd, "FileInputStream(file).fd");
        w(fd);
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void j() throws IOException {
        if (this.nowSpeak > 0) {
            t().stop();
            this.nowSpeak = this.nowSpeak - 1;
            this.readAloudNumber -= this.contentList.get(r0).length() - 1;
            i();
        }
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void l() throws IOException {
        super.l();
        if (this.playingIndex == -1) {
            i();
        } else {
            try {
                t().start();
            } catch (IllegalStateException unused) {
            }
        }
    }

    @Override // io.legado.app.service.BaseReadAloudService
    public void o(boolean reset) {
        e.a.a.d.u.b<?> bVar = this.task;
        if (bVar != null) {
            bVar.f5560d.k(null);
        }
        t().stop();
        this.playingIndex = -1;
        s();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(@Nullable MediaPlayer mp) throws IOException {
        this.readAloudNumber = this.contentList.get(this.nowSpeak).length() + 1 + this.readAloudNumber;
        if (this.nowSpeak >= f.x.e.m(this.contentList)) {
            f();
        } else {
            this.nowSpeak++;
            i();
        }
    }

    @Override // io.legado.app.service.BaseReadAloudService, android.app.Service
    public void onCreate() {
        super.onCreate();
        StringBuilder sb = new StringBuilder();
        File externalCacheDir = getExternalCacheDir();
        j.c(externalCacheDir);
        sb.append(externalCacheDir.getAbsolutePath());
        sb.append((Object) File.separator);
        sb.append("httpTTS");
        this.ttsFolder = sb.toString();
        t().setOnErrorListener(this);
        t().setOnPreparedListener(this);
        t().setOnCompletionListener(this);
    }

    @Override // io.legado.app.service.BaseReadAloudService, io.legado.app.base.BaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        e.a.a.d.u.b<?> bVar = this.task;
        if (bVar != null) {
            bVar.f5560d.k(null);
        }
        t().release();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(@Nullable MediaPlayer mp, int what, int extra) {
        u uVar = u.a;
        u.a("mp", "what:" + what + " extra:" + extra);
        if (what == -38 && extra == 0) {
            return true;
        }
        this.handler.postDelayed(new Runnable() { // from class: e.a.a.f.f
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                HttpReadAloudService httpReadAloudService = this.a;
                int i2 = HttpReadAloudService.r;
                f.c0.c.j.e(httpReadAloudService, "this$0");
                httpReadAloudService.readAloudNumber = httpReadAloudService.contentList.get(httpReadAloudService.nowSpeak).length() + 1 + httpReadAloudService.readAloudNumber;
                if (httpReadAloudService.nowSpeak >= f.x.e.m(httpReadAloudService.contentList)) {
                    httpReadAloudService.f();
                } else {
                    httpReadAloudService.nowSpeak++;
                    httpReadAloudService.i();
                }
            }
        }, 50L);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(@Nullable MediaPlayer mp) {
        super.i();
        if (BaseReadAloudService.f6929d) {
            return;
        }
        if (mp != null) {
            mp.start();
        }
        e.a.a.g.d.i.s1.g.b bVar = this.textChapter;
        if (bVar != null && this.readAloudNumber + 1 > bVar.c(this.pageIndex + 1)) {
            this.pageIndex++;
            e.a.a.f.s.k.a.l();
        }
        LiveEventBus.get("ttsStart").post(Integer.valueOf(this.readAloudNumber + 1));
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        stopSelf();
    }

    public final void s() {
        e.a.a.d.u.b<?> bVar = this.task;
        if (bVar != null) {
            bVar.f5560d.k(null);
        }
        this.task = BaseService.a(this, null, null, new a(null), 3, null);
    }

    public final MediaPlayer t() {
        return (MediaPlayer) this.player.getValue();
    }

    public final File u(String name) {
        File file = new File(x());
        String[] strArr = {j.k(name, ".mp3")};
        j.e(file, "root");
        j.e(strArr, "subDirFiles");
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        j.e(file, "root");
        j.e(strArr2, "subDirFiles");
        StringBuilder sb = new StringBuilder(file.getAbsolutePath());
        for (String str : strArr2) {
            if (str.length() > 0) {
                sb.append(File.separator);
                sb.append(str);
            }
        }
        String string = sb.toString();
        j.d(string, "path.toString()");
        return new File(string);
    }

    public final String v(String url, String ttsConfig, String content) {
        StringBuilder sb = new StringBuilder();
        e.a.a.g.d.i.s1.g.b bVar = this.textChapter;
        j.c(bVar);
        sb.append(e.a.a.h.v.b(bVar.f5766b));
        sb.append('_');
        sb.append(e.a.a.h.v.b(url + "-|-" + ttsConfig + "-|-" + content));
        return sb.toString();
    }

    public final synchronized void w(FileDescriptor fd) {
        if (this.playingIndex != this.nowSpeak && k()) {
            try {
                t().reset();
                t().setDataSource(fd);
                t().prepareAsync();
                this.playingIndex = this.nowSpeak;
                LiveEventBus.get("ttsStart").post(Integer.valueOf(this.readAloudNumber + 1));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final String x() {
        String str = this.ttsFolder;
        if (str != null) {
            return j.k(str, File.separator);
        }
        j.m("ttsFolder");
        throw null;
    }
}
