package e.a.a.f.s;

import android.content.Context;
import android.content.Intent;
import androidx.view.MutableLiveData;
import com.jeremyliao.liveeventbus.LiveEventBus;
import e.a.a.d.u.b;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.service.AudioPlayService;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlay.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f5664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public static Book f5665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public static BookChapter f5666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f5667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f5668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f5669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public static WebBook f5670j;

    @NotNull
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static MutableLiveData<String> f5662b = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static MutableLiveData<String> f5663c = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public static final ArrayList<Integer> f5671k = new ArrayList<>();

    /* JADX INFO: renamed from: e.a.a.f.s.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AudioPlay.kt */
    @DebugMetadata(c = "io.legado.app.service.help.AudioPlay$next$1", f = "AudioPlay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0160a extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Context $context;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0160a(Context context, f.z.d<? super C0160a> dVar) {
            super(2, dVar);
            this.$context = context;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new C0160a(this.$context, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((C0160a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            a aVar = a.a;
            Book book = a.f5665e;
            if (book == null) {
                return null;
            }
            Context context = this.$context;
            if (book.getDurChapterIndex() < book.getTotalChapterNum()) {
                a.f5668h++;
                a.f5669i = 0;
                a.f5666f = null;
                book.setDurChapterIndex(a.f5668h);
                book.setDurChapterPos(0);
                aVar.f();
                aVar.d(context);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: AudioPlay.kt */
    @DebugMetadata(c = "io.legado.app.service.help.AudioPlay$saveRead$1", f = "AudioPlay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public int label;

        public b(f.z.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new b(dVar);
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
            c.b.a.m.f.E5(obj);
            a aVar = a.a;
            Book book = a.f5665e;
            if (book == null) {
                return null;
            }
            book.setLastCheckCount(0);
            book.setDurChapterTime(System.currentTimeMillis());
            book.setDurChapterIndex(a.f5668h);
            book.setDurChapterPos(a.f5669i);
            BookChapter chapter = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(book.getBookUrl(), book.getDurChapterIndex());
            if (chapter != null) {
                book.setDurChapterTitle(chapter.getTitle());
            }
            AppDatabaseKt.getAppDb().getBookDao().update(book);
            return v.a;
        }
    }

    public final void a(@NotNull Context context, float f2) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (AudioPlayService.f6916b) {
            Intent intent = new Intent(context, (Class<?>) AudioPlayService.class);
            intent.setAction("adjustSpeed");
            intent.putExtra("adjust", f2);
            context.startService(intent);
        }
    }

    public final void b(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new C0160a(context, null), 3);
    }

    public final void c(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (AudioPlayService.f6916b) {
            Intent intent = new Intent(context, (Class<?>) AudioPlayService.class);
            intent.setAction("pause");
            context.startService(intent);
        }
    }

    public final void d(@NotNull Context context) {
        String title;
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        Book book = f5665e;
        if (book == null) {
            return;
        }
        if (f5666f == null) {
            f.c0.c.j.e(book, "book");
            BookChapter chapter = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(book.getBookUrl(), f5668h);
            f5666f = chapter;
            if (chapter == null || (title = chapter.getTitle()) == null) {
                title = "";
            }
            LiveEventBus.get("audioSubTitle").post(title);
            BookChapter bookChapter = f5666f;
            Long end = bookChapter == null ? null : bookChapter.getEnd();
            LiveEventBus.get("audioSize").post(Integer.valueOf(end == null ? 0 : (int) end.longValue()));
            LiveEventBus.get("audioProgress").post(Integer.valueOf(f5669i));
        }
        if (f5666f == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AudioPlayService.class);
        intent.setAction("play");
        context.startService(intent);
    }

    public final void e(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (AudioPlayService.f6916b) {
            Intent intent = new Intent(context, (Class<?>) AudioPlayService.class);
            intent.setAction("resume");
            context.startService(intent);
        }
    }

    public final void f() {
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new b(null), 3);
    }

    public final void g(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (AudioPlayService.f6916b) {
            Intent intent = new Intent(context, (Class<?>) AudioPlayService.class);
            intent.setAction("stop");
            context.startService(intent);
        }
    }

    public final void h(@NotNull Book book) {
        String title;
        f.c0.c.j.e(book, "book");
        BookChapter chapter = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(book.getBookUrl(), f5668h);
        f5666f = chapter;
        String str = "";
        if (chapter != null && (title = chapter.getTitle()) != null) {
            str = title;
        }
        LiveEventBus.get("audioSubTitle").post(str);
        BookChapter bookChapter = f5666f;
        Long end = bookChapter == null ? null : bookChapter.getEnd();
        LiveEventBus.get("audioSize").post(Integer.valueOf(end == null ? 0 : (int) end.longValue()));
        LiveEventBus.get("audioProgress").post(Integer.valueOf(f5669i));
    }
}
