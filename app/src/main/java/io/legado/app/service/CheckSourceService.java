package io.legado.app.service;

import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.ai;
import e.a.a.f.o;
import e.a.a.f.q;
import e.a.a.f.r;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import g.b.v0;
import g.b.x0;
import io.legado.app.base.BaseService;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.ui.book.source.manage.BookSourceActivity;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: CheckSourceService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0004R%\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010!R\u0016\u0010%\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010'R&\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0019¨\u0006,"}, d2 = {"Lio/legado/app/service/CheckSourceService;", "Lio/legado/app/base/BaseService;", "Lf/v;", "onCreate", "()V", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", ai.aD, "e", "Landroidx/core/app/NotificationCompat$Builder;", "kotlin.jvm.PlatformType", ai.aA, "Lf/e;", "d", "()Landroidx/core/app/NotificationCompat$Builder;", "notificationBuilder", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "allIds", "g", OptRuntime.GeneratorState.resumptionPoint_TYPE, "processIndex", "b", "threadCount", "Le/a/a/d/u/a;", "Le/a/a/d/u/a;", "tasks", "h", "Ljava/lang/String;", "notificationMsg", "Lg/b/v0;", "Lg/b/v0;", "searchCoroutine", "f", "checkedIds", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class CheckSourceService extends BaseService {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int threadCount;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public v0 searchCoroutine;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public e.a.a.d.u.a tasks;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<String> allIds;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<String> checkedIds;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int processIndex;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String notificationMsg;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e notificationBuilder;

    /* JADX INFO: compiled from: CheckSourceService.kt */
    @DebugMetadata(c = "io.legado.app.service.CheckSourceService$check$2", f = "CheckSourceService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ int $index;
        public int label;
        public final /* synthetic */ CheckSourceService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, CheckSourceService checkSourceService, d<? super a> dVar) {
            super(2, dVar);
            this.$index = i2;
            this.this$0 = checkSourceService;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.$index, this.this$0, dVar);
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
            if (this.$index < this.this$0.allIds.size()) {
                String str = this.this$0.allIds.get(this.$index);
                j.d(str, "allIds[index]");
                String str2 = str;
                BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(str2);
                v vVar = null;
                if (bookSource != null) {
                    CheckSourceService checkSourceService = this.this$0;
                    Objects.requireNonNull(checkSourceService);
                    j.e(bookSource, "source");
                    e.a.a.d.u.b bVarA = BaseService.a(checkSourceService, null, checkSourceService.searchCoroutine, new o(bookSource, null), 1, null);
                    bVarA.f(180000L);
                    e.a.a.d.u.b.b(bVarA, null, new e.a.a.f.p(bookSource, null), 1);
                    bVarA.d(null, new q(bookSource, null));
                    e.a.a.d.u.b.c(bVarA, null, new r(checkSourceService, bookSource, null), 1);
                    vVar = v.a;
                }
                if (vVar == null) {
                    CheckSourceService.b(this.this$0, str2, "");
                }
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: CheckSourceService.kt */
    public static final class b extends k implements f.c0.b.a<NotificationCompat.Builder> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        public final NotificationCompat.Builder invoke() {
            NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(CheckSourceService.this, "channel_read_aloud").setSmallIcon(R.drawable.ic_network_check).setOngoing(true).setContentTitle(CheckSourceService.this.getString(R.string.check_book_source));
            CheckSourceService checkSourceService = CheckSourceService.this;
            Intent intent = new Intent(checkSourceService, (Class<?>) BookSourceActivity.class);
            intent.setAction("activity");
            NotificationCompat.Builder contentIntent = contentTitle.setContentIntent(PendingIntent.getActivity(checkSourceService, 0, intent, 134217728));
            String string = CheckSourceService.this.getString(R.string.cancel);
            CheckSourceService checkSourceService2 = CheckSourceService.this;
            Intent intent2 = new Intent(checkSourceService2, (Class<?>) CheckSourceService.class);
            intent2.setAction("stop");
            return contentIntent.addAction(R.drawable.ic_stop_black_24dp, string, PendingIntent.getService(checkSourceService2, 0, intent2, 134217728)).setVisibility(1);
        }
    }

    public CheckSourceService() {
        int iK = e.a.a.d.e.a.k();
        this.threadCount = iK;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iK);
        j.d(executorServiceNewFixedThreadPool, "newFixedThreadPool(threadCount)");
        this.searchCoroutine = new x0(executorServiceNewFixedThreadPool);
        this.tasks = new e.a.a.d.u.a();
        this.allIds = new ArrayList<>();
        this.checkedIds = new ArrayList<>();
        this.notificationMsg = "";
        this.notificationBuilder = f.N3(new b());
    }

    public static final void b(CheckSourceService checkSourceService, String str, String str2) {
        synchronized (checkSourceService) {
            checkSourceService.c();
            checkSourceService.checkedIds.add(str);
            String string = checkSourceService.getString(R.string.progress_show, new Object[]{str2, Integer.valueOf(checkSourceService.checkedIds.size()), Integer.valueOf(checkSourceService.allIds.size())});
            j.d(string, "getString(R.string.progress_show, sourceName, checkedIds.size, allIds.size)");
            checkSourceService.notificationMsg = string;
            checkSourceService.e();
            if (checkSourceService.processIndex >= (checkSourceService.allIds.size() + checkSourceService.threadCount) - 1) {
                checkSourceService.stopSelf();
            }
        }
    }

    public final void c() {
        int i2 = this.processIndex;
        synchronized (this) {
            this.processIndex++;
        }
        BaseService.a(this, null, null, new a(i2, this, null), 3, null);
    }

    public final NotificationCompat.Builder d() {
        return (NotificationCompat.Builder) this.notificationBuilder.getValue();
    }

    public final void e() {
        d().setContentText(this.notificationMsg);
        d().setProgress(this.allIds.size(), this.checkedIds.size(), false);
        LiveEventBus.get("checkSource").post(this.notificationMsg);
        startForeground(112202, d().build());
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        String string = getString(R.string.start);
        j.d(string, "getString(R.string.start)");
        this.notificationMsg = string;
        e();
    }

    @Override // io.legado.app.base.BaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.tasks.b();
        this.searchCoroutine.close();
        LiveEventBus.get("checkSourceDone").post(0);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        if (j.a(intent == null ? null : intent.getAction(), "start")) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("selectIds");
            if (stringArrayListExtra != null) {
                if (!this.allIds.isEmpty()) {
                    f.R5(this, "已有书源在校验,等完成后再试");
                } else {
                    this.tasks.b();
                    this.allIds.clear();
                    this.checkedIds.clear();
                    this.allIds.addAll(stringArrayListExtra);
                    int i2 = 0;
                    this.processIndex = 0;
                    this.threadCount = Math.min(this.allIds.size(), this.threadCount);
                    String string = getString(R.string.progress_show, new Object[]{"", 0, Integer.valueOf(this.allIds.size())});
                    j.d(string, "getString(R.string.progress_show, \"\", 0, allIds.size)");
                    this.notificationMsg = string;
                    e();
                    int i3 = this.threadCount;
                    if (i3 > 0) {
                        do {
                            i2++;
                            c();
                        } while (i2 < i3);
                    }
                }
            }
        } else {
            stopSelf();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
