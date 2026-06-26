package io.legado.app.service;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.f.n;
import e.a.a.f.s.h;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.y;
import f.e;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import g.b.v0;
import g.b.x0;
import io.legado.app.base.BaseService;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.service.CacheBookService;
import io.wenyuange.app.release.R;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: CacheBookService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bC\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ)\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R%\u0010,\u001a\n '*\u0004\u0018\u00010&0&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R(\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001bR\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010$R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00105R\"\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002070\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010\u001bR\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010>R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lio/legado/app/service/CacheBookService;", "Lio/legado/app/base/BaseService;", "", "bookUrl", "Lf/v;", "f", "(Ljava/lang/String;)V", "e", "()V", "g", "onCreate", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "Lg/b/v0;", "d", "Lg/b/v0;", "searchPool", "j$/util/concurrent/ConcurrentHashMap", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lio/legado/app/data/entities/BookChapter;", Constants.LANDSCAPE, "Lj$/util/concurrent/ConcurrentHashMap;", "finalMap", "Lio/legado/app/data/entities/Book;", "h", "bookMap", "Lio/legado/app/model/webBook/WebBook;", ai.aA, "webBookMap", ai.aD, OptRuntime.GeneratorState.resumptionPoint_TYPE, "threadCount", "Landroidx/core/app/NotificationCompat$Builder;", "kotlin.jvm.PlatformType", "p", "Lf/e;", "getNotificationBuilder", "()Landroidx/core/app/NotificationCompat$Builder;", "notificationBuilder", "j", "downloadMap", "o", "Ljava/lang/String;", "notificationContent", "n", "downloadingCount", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runnable", "Lio/legado/app/service/CacheBookService$a;", "k", "downloadCount", "Le/a/a/d/u/a;", "Le/a/a/d/u/a;", "tasks", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "m", "Ljava/util/concurrent/CopyOnWriteArraySet;", "downloadingList", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class CacheBookService extends BaseService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f6938b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int threadCount;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public v0 searchPool;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public e.a.a.d.u.a tasks;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Handler handler;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public Runnable runnable;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ConcurrentHashMap<String, Book> bookMap;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ConcurrentHashMap<String, WebBook> webBookMap;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> downloadMap;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ConcurrentHashMap<String, a> downloadCount;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> finalMap;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final CopyOnWriteArraySet<String> downloadingList;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public volatile int downloadingCount;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public String notificationContent;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final e notificationBuilder;

    /* JADX INFO: compiled from: CacheBookService.kt */
    public static final class a {
        public volatile int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile int f6949b;
    }

    /* JADX INFO: compiled from: CacheBookService.kt */
    @DebugMetadata(c = "io.legado.app.service.CacheBookService$download$task$1", f = "CacheBookService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, f.z.d<? super v>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX INFO: compiled from: CacheBookService.kt */
        @DebugMetadata(c = "io.legado.app.service.CacheBookService$download$task$1$1", f = "CacheBookService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends g implements q<a0, Throwable, f.z.d<? super v>, Object> {
            public final /* synthetic */ BookChapter $bookChapter;
            private /* synthetic */ Object L$0;
            public /* synthetic */ Object L$1;
            public int label;
            public final /* synthetic */ CacheBookService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(CacheBookService cacheBookService, BookChapter bookChapter, f.z.d<? super a> dVar) {
                super(3, dVar);
                this.this$0 = cacheBookService;
                this.$bookChapter = bookChapter;
            }

            @Override // f.c0.b.q
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
                a aVar = new a(this.this$0, this.$bookChapter, dVar);
                aVar.L$0 = a0Var;
                aVar.L$1 = th;
                return aVar.invokeSuspend(v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
                a0 a0Var = (a0) this.L$0;
                Throwable th = (Throwable) this.L$1;
                CacheBookService cacheBookService = this.this$0;
                BookChapter bookChapter = this.$bookChapter;
                synchronized (a0Var) {
                    cacheBookService.downloadingList.remove(bookChapter.getUrl());
                }
                this.this$0.notificationContent = j.k("getContentError", th.getLocalizedMessage());
                this.this$0.g();
                return v.a;
            }
        }

        /* JADX INFO: renamed from: io.legado.app.service.CacheBookService$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CacheBookService.kt */
        @DebugMetadata(c = "io.legado.app.service.CacheBookService$download$task$1$2", f = "CacheBookService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0188b extends g implements q<a0, String, f.z.d<? super v>, Object> {
            public final /* synthetic */ Book $book;
            public final /* synthetic */ BookChapter $bookChapter;
            public int label;
            public final /* synthetic */ CacheBookService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0188b(CacheBookService cacheBookService, Book book, BookChapter bookChapter, f.z.d<? super C0188b> dVar) {
                super(3, dVar);
                this.this$0 = cacheBookService;
                this.$book = book;
                this.$bookChapter = bookChapter;
            }

            @Override // f.c0.b.q
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @NotNull String str, @Nullable f.z.d<? super v> dVar) {
                return new C0188b(this.this$0, this.$book, this.$bookChapter, dVar).invokeSuspend(v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                v vVar;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
                CacheBookService cacheBookService = this.this$0;
                Book book = this.$book;
                BookChapter bookChapter = this.$bookChapter;
                synchronized (cacheBookService) {
                    a aVar = (a) cacheBookService.downloadCount.get(book.getBookUrl());
                    if (aVar != null) {
                        aVar.f6949b++;
                    }
                    a aVar2 = (a) cacheBookService.downloadCount.get(book.getBookUrl());
                    if (aVar2 != null) {
                        aVar2.a++;
                    }
                    a aVar3 = (a) cacheBookService.downloadCount.get(book.getBookUrl());
                    Integer num = null;
                    if (aVar3 != null) {
                        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) cacheBookService.downloadMap.get(book.getBookUrl());
                        CacheBookService.d(cacheBookService, aVar3, copyOnWriteArraySet == null ? null : new Integer(copyOnWriteArraySet.size()), bookChapter.getTitle());
                    }
                    CopyOnWriteArraySet<BookChapter> copyOnWriteArraySet2 = (CopyOnWriteArraySet) cacheBookService.finalMap.get(book.getBookUrl());
                    if (copyOnWriteArraySet2 == null) {
                        copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
                        cacheBookService.finalMap.put(book.getBookUrl(), copyOnWriteArraySet2);
                    }
                    copyOnWriteArraySet2.add(bookChapter);
                    int size = copyOnWriteArraySet2.size();
                    CopyOnWriteArraySet copyOnWriteArraySet3 = (CopyOnWriteArraySet) cacheBookService.downloadMap.get(book.getBookUrl());
                    if (copyOnWriteArraySet3 != null) {
                        num = new Integer(copyOnWriteArraySet3.size());
                    }
                    if (num != null && size == num.intValue()) {
                        cacheBookService.downloadMap.remove(book.getBookUrl());
                        cacheBookService.finalMap.remove(book.getBookUrl());
                        cacheBookService.downloadCount.remove(book.getBookUrl());
                    }
                    vVar = v.a;
                }
                return vVar;
            }
        }

        /* JADX INFO: compiled from: CacheBookService.kt */
        @DebugMetadata(c = "io.legado.app.service.CacheBookService$download$task$1$3", f = "CacheBookService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class c extends g implements p<a0, f.z.d<? super v>, Object> {
            public int label;
            public final /* synthetic */ CacheBookService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(CacheBookService cacheBookService, f.z.d<? super c> dVar) {
                super(2, dVar);
                this.this$0 = cacheBookService;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new c(this.this$0, dVar);
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
                CacheBookService.c(this.this$0, true);
                return v.a;
            }
        }

        public b(f.z.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            b bVar = CacheBookService.this.new b(dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
        
            r13.downloadingList.add(r3.getUrl());
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        
            r9 = r3;
         */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 372
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.service.CacheBookService.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: CacheBookService.kt */
    @DebugMetadata(c = "io.legado.app.service.CacheBookService$download$task$2", f = "CacheBookService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public c(f.z.d<? super c> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            c cVar = CacheBookService.this.new c(dVar);
            cVar.L$0 = th;
            return cVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            Throwable th = (Throwable) this.L$0;
            CacheBookService.this.notificationContent = j.k("ERROR:", th.getLocalizedMessage());
            h.a.a(CacheBookService.this.notificationContent);
            CacheBookService.this.g();
            return v.a;
        }
    }

    /* JADX INFO: compiled from: CacheBookService.kt */
    public static final class d extends k implements f.c0.b.a<NotificationCompat.Builder> {
        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        public final NotificationCompat.Builder invoke() {
            NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(CacheBookService.this, "channel_download").setSmallIcon(R.drawable.ic_download).setOngoing(true).setContentTitle(CacheBookService.this.getString(R.string.offline_cache));
            String string = CacheBookService.this.getString(R.string.cancel);
            CacheBookService cacheBookService = CacheBookService.this;
            Intent intent = new Intent(cacheBookService, (Class<?>) CacheBookService.class);
            intent.setAction("stop");
            contentTitle.addAction(R.drawable.ic_stop_black_24dp, string, PendingIntent.getService(cacheBookService, 0, intent, 134217728));
            return contentTitle.setVisibility(1);
        }
    }

    public CacheBookService() {
        int iK = e.a.a.d.e.a.k();
        this.threadCount = iK;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iK);
        j.d(executorServiceNewFixedThreadPool, "newFixedThreadPool(threadCount)");
        this.searchPool = new x0(executorServiceNewFixedThreadPool);
        this.tasks = new e.a.a.d.u.a();
        this.handler = new Handler(Looper.getMainLooper());
        this.runnable = new Runnable() { // from class: e.a.a.f.d
            @Override // java.lang.Runnable
            public final void run() {
                CacheBookService cacheBookService = this.a;
                int i2 = CacheBookService.f6938b;
                f.c0.c.j.e(cacheBookService, "this$0");
                cacheBookService.g();
                LiveEventBus.get("upDownload").post(cacheBookService.downloadMap);
                cacheBookService.handler.removeCallbacks(cacheBookService.runnable);
                cacheBookService.handler.postDelayed(cacheBookService.runnable, 1000L);
            }
        };
        this.bookMap = new ConcurrentHashMap<>();
        this.webBookMap = new ConcurrentHashMap<>();
        this.downloadMap = new ConcurrentHashMap<>();
        this.downloadCount = new ConcurrentHashMap<>();
        this.finalMap = new ConcurrentHashMap<>();
        this.downloadingList = new CopyOnWriteArraySet<>();
        String string = k.d.a.h.g().getString(R.string.starting_download);
        j.d(string, "appCtx.getString(R.string.starting_download)");
        this.notificationContent = string;
        this.notificationBuilder = f.N3(new d());
    }

    public static final Book b(CacheBookService cacheBookService, String str) {
        Object book = cacheBookService.bookMap.get(str);
        if (book == null) {
            synchronized (cacheBookService) {
                book = cacheBookService.bookMap.get(str);
                if (book == null && (book = AppDatabaseKt.getAppDb().getBookDao().getBook(str)) == null) {
                    cacheBookService.f(str);
                }
            }
        }
        return (Book) book;
    }

    public static final void c(CacheBookService cacheBookService, boolean z) {
        cacheBookService.downloadingCount--;
        if (z) {
            cacheBookService.e();
        } else if (cacheBookService.downloadingCount < 1) {
            cacheBookService.tasks.b();
            cacheBookService.stopSelf();
        }
    }

    public static final void d(CacheBookService cacheBookService, a aVar, Integer num, String str) {
        StringBuilder sbR = c.a.a.a.a.r("进度:");
        sbR.append(aVar.a);
        sbR.append(Attributes.InternalPrefix);
        sbR.append(num);
        sbR.append(",成功:");
        sbR.append(aVar.f6949b);
        sbR.append(',');
        sbR.append(str);
        cacheBookService.notificationContent = sbR.toString();
    }

    public final void e() {
        this.downloadingCount++;
        e.a.a.d.u.b<?> bVarA = e.a.a.d.u.b.a.a(this, this.searchPool, new b(null));
        e.a.a.d.u.b.b(bVarA, null, new c(null), 1);
        this.tasks.a(bVarA);
    }

    public final void f(String bookUrl) {
        ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> concurrentHashMap = this.downloadMap;
        Objects.requireNonNull(concurrentHashMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        y.c(concurrentHashMap).remove(bookUrl);
        ConcurrentHashMap<String, CopyOnWriteArraySet<BookChapter>> concurrentHashMap2 = this.finalMap;
        Objects.requireNonNull(concurrentHashMap2, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        y.c(concurrentHashMap2).remove(bookUrl);
    }

    public final void g() {
        ((NotificationCompat.Builder) this.notificationBuilder.getValue()).setContentText(this.notificationContent);
        startForeground(1144774, ((NotificationCompat.Builder) this.notificationBuilder.getValue()).build());
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        g();
        this.handler.postDelayed(this.runnable, 1000L);
    }

    @Override // io.legado.app.base.BaseService, android.app.Service
    public void onDestroy() {
        this.tasks.b();
        this.searchPool.close();
        this.handler.removeCallbacks(this.runnable);
        this.downloadMap.clear();
        this.finalMap.clear();
        super.onDestroy();
        LiveEventBus.get("upDownload").post(this.downloadMap);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        String action;
        if (intent != null && (action = intent.getAction()) != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -934610812) {
                if (iHashCode != 3540994) {
                    if (iHashCode == 109757538 && action.equals("start")) {
                        String stringExtra = intent.getStringExtra("bookUrl");
                        int intExtra = intent.getIntExtra("start", 0);
                        int intExtra2 = intent.getIntExtra("end", 0);
                        if (stringExtra != null) {
                            if (this.downloadMap.containsKey(stringExtra)) {
                                String string = getString(R.string.already_in_download);
                                j.d(string, "getString(R.string.already_in_download)");
                                this.notificationContent = string;
                                g();
                                f.R5(this, this.notificationContent);
                            } else {
                                this.downloadCount.put(stringExtra, new a());
                                BaseService.a(this, null, null, new n(stringExtra, intExtra, intExtra2, this, null), 3, null);
                            }
                        }
                    }
                } else if (action.equals("stop")) {
                    this.tasks.b();
                    stopSelf();
                }
            } else if (action.equals("remove")) {
                f(intent.getStringExtra("bookUrl"));
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
