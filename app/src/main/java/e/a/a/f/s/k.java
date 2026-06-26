package e.a.a.f.s;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.view.MutableLiveData;
import com.umeng.analytics.pro.ai;
import e.a.a.d.u.b;
import f.v;
import g.b.a0;
import g.b.k0;
import g.b.y0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookProgress;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.ReadRecord;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.service.BaseReadAloudService;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: ReadBook.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static Book f5677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public static e.a.a.d.k f5678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f5679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f5680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f5681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f5682h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public static a f5684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public static e.a.a.g.d.i.s1.g.b f5685k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public static e.a.a.g.d.i.s1.g.b f5686l;

    @Nullable
    public static e.a.a.g.d.i.s1.g.b m;

    @Nullable
    public static BookSource n;

    @Nullable
    public static WebBook o;

    @Nullable
    public static String p;

    @NotNull
    public static final k a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static MutableLiveData<String> f5676b = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f5683i = true;

    @NotNull
    public static final ArrayList<Integer> q = new ArrayList<>();

    @NotNull
    public static final ReadRecord r = new ReadRecord(null, null, 0, 7, null);
    public static long s = System.currentTimeMillis();

    /* JADX INFO: compiled from: ReadBook.kt */
    public interface a {
        void A0();

        void D();

        void F0();

        void O(@NotNull Book book);

        void u(int i2, boolean z, @Nullable f.c0.b.a<v> aVar);

        void w0();
    }

    /* JADX INFO: compiled from: ReadBook.kt */
    @DebugMetadata(c = "io.legado.app.service.help.ReadBook$contentLoadFinish$1", f = "ReadBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ BookChapter $chapter;
        public final /* synthetic */ String $content;
        public final /* synthetic */ boolean $resetPageOffset;
        public final /* synthetic */ boolean $upContent;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BookChapter bookChapter, Book book, String str, boolean z, boolean z2, f.z.d<? super b> dVar) {
            super(2, dVar);
            this.$chapter = bookChapter;
            this.$book = book;
            this.$content = str;
            this.$upContent = z;
            this.$resetPageOffset = z2;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new b(this.$chapter, this.$book, this.$content, this.$upContent, this.$resetPageOffset, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            boolean z;
            String strB5;
            a aVar;
            a aVar2;
            a aVar3;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            e.a.a.g.d.i.s1.h.b bVar = e.a.a.g.d.i.s1.h.b.a;
            k kVar = k.a;
            int i2 = k.f5681g;
            synchronized (bVar) {
                Iterator<Map.Entry<Integer, ConcurrentHashMap<String, Bitmap>>> it = e.a.a.g.d.i.s1.h.b.f5799b.entrySet().iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<Integer, ConcurrentHashMap<String, Bitmap>> next = it.next();
                    int i3 = i2 - 1;
                    int i4 = i2 + 1;
                    int iIntValue = next.getKey().intValue();
                    if (i3 <= iIntValue && iIntValue <= i4) {
                        z = true;
                    }
                    if (!z) {
                        Iterator<Map.Entry<String, Bitmap>> it2 = next.getValue().entrySet().iterator();
                        while (it2.hasNext()) {
                            it2.next().getValue().recycle();
                        }
                        e.a.a.g.d.i.s1.h.b.f5799b.remove(next.getKey());
                    }
                }
            }
            k kVar2 = k.a;
            int i5 = k.f5681g;
            int i6 = i5 - 1;
            int i7 = i5 + 1;
            int index = this.$chapter.getIndex();
            if (i6 <= index && index <= i7) {
                z = true;
            }
            if (z) {
                BookChapter bookChapter = this.$chapter;
                int iB = e.a.a.d.e.a.b();
                if (iB == 1) {
                    strB5 = c.b.a.m.f.B5(this.$chapter.getTitle());
                    f.c0.c.j.d(strB5, "t2s(chapter.title)");
                } else if (iB != 2) {
                    strB5 = this.$chapter.getTitle();
                } else {
                    strB5 = c.b.a.m.f.U4(this.$chapter.getTitle());
                    f.c0.c.j.d(strB5, "s2t(chapter.title)");
                }
                bookChapter.setTitle(strB5);
                e.a.a.d.k kVar3 = k.f5678d;
                f.c0.c.j.c(kVar3);
                List<String> listB = e.a.a.d.k.b(kVar3, this.$book, this.$chapter.getTitle(), this.$content, false, false, 24);
                int index2 = this.$chapter.getIndex();
                int i8 = k.f5681g;
                if (index2 == i8) {
                    k.f5686l = e.a.a.g.d.i.s1.h.a.a.e(this.$book, this.$chapter, listB, k.f5680f);
                    if (this.$upContent && (aVar3 = k.f5684j) != null) {
                        c.b.a.m.f.V5(aVar3, 0, this.$resetPageOffset, null, 5, null);
                    }
                    a aVar4 = k.f5684j;
                    if (aVar4 != null) {
                        aVar4.w0();
                    }
                    kVar2.f();
                    a aVar5 = k.f5684j;
                    if (aVar5 != null) {
                        aVar5.F0();
                    }
                } else if (index2 == i8 - 1) {
                    k.f5685k = e.a.a.g.d.i.s1.h.a.a.e(this.$book, this.$chapter, listB, k.f5680f);
                    if (this.$upContent && (aVar2 = k.f5684j) != null) {
                        c.b.a.m.f.V5(aVar2, -1, this.$resetPageOffset, null, 4, null);
                    }
                } else if (index2 == i8 + 1) {
                    k.m = e.a.a.g.d.i.s1.h.a.a.e(this.$book, this.$chapter, listB, k.f5680f);
                    if (this.$upContent && (aVar = k.f5684j) != null) {
                        c.b.a.m.f.V5(aVar, 1, this.$resetPageOffset, null, 4, null);
                    }
                }
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBook.kt */
    @DebugMetadata(c = "io.legado.app.service.help.ReadBook$contentLoadFinish$2", f = "ReadBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends f.z.j.a.g implements f.c0.b.q<a0, Throwable, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public c(f.z.d<? super c> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            c cVar = new c(dVar);
            cVar.L$0 = th;
            return cVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            Throwable th = (Throwable) this.L$0;
            th.printStackTrace();
            c.b.a.m.f.R5(k.d.a.h.g(), f.c0.c.j.k("ChapterProvider ERROR:\n", c.b.a.m.f.C2(th)));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBook.kt */
    @DebugMetadata(c = "io.legado.app.service.help.ReadBook$contentLoadFinish$3", f = "ReadBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends f.z.j.a.g implements f.c0.b.q<a0, v, f.z.d<? super v>, Object> {
        public final /* synthetic */ f.c0.b.a<v> $success;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f.c0.b.a<v> aVar, f.z.d<? super d> dVar) {
            super(3, dVar);
            this.$success = aVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull v vVar, @Nullable f.z.d<? super v> dVar) {
            return new d(this.$success, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            f.c0.b.a<v> aVar = this.$success;
            if (aVar != null) {
                aVar.invoke();
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBook.kt */
    public static final class e extends f.c0.c.k implements f.c0.b.a<v> {
        public final /* synthetic */ f.c0.b.a<v> $success;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f.c0.b.a<v> aVar) {
            super(0);
            this.$success = aVar;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            f.c0.b.a<v> aVar = this.$success;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }
    }

    /* JADX INFO: compiled from: ReadBook.kt */
    @DebugMetadata(c = "io.legado.app.service.help.ReadBook$moveToNextChapter$1$1", f = "ReadBook.kt", i = {0, 0}, l = {Token.DOTQUERY}, m = "invokeSuspend", n = {"maxChapterIndex", ai.aA}, s = {"I$0", "I$2"})
    public static final class f extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public int I$0;
        public int I$1;
        public int I$2;
        public int label;

        public f(f.z.d<? super f> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new f(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((f) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x004b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0049 -> B:14:0x004c). Please report as a decompilation issue!!! */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                f.z.i.a r0 = f.z.i.a.COROUTINE_SUSPENDED
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L1c
                if (r1 != r2) goto L14
                int r1 = r7.I$2
                int r3 = r7.I$1
                int r4 = r7.I$0
                c.b.a.m.f.E5(r8)
                r8 = r7
                goto L4c
            L14:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1c:
                c.b.a.m.f.E5(r8)
                e.a.a.f.s.k r8 = e.a.a.f.s.k.a
                int r8 = e.a.a.f.s.k.f5680f
                int r8 = r8 - r2
                int r1 = e.a.a.f.s.k.f5681g
                e.a.a.d.e r3 = e.a.a.d.e.a
                int r3 = r3.h()
                int r3 = r3 + r1
                int r8 = java.lang.Math.min(r8, r3)
                int r1 = e.a.a.f.s.k.f5681g
                int r1 = r1 + 2
                if (r1 > r8) goto L56
                r4 = r8
                r8 = r7
            L39:
                int r3 = r1 + 1
                r5 = 1000(0x3e8, double:4.94E-321)
                r8.I$0 = r4
                r8.I$1 = r3
                r8.I$2 = r1
                r8.label = r2
                java.lang.Object r5 = c.b.a.m.f.p1(r5, r8)
                if (r5 != r0) goto L4c
                return r0
            L4c:
                e.a.a.f.s.k r5 = e.a.a.f.s.k.a
                e.a.a.f.s.k.a(r5, r1)
                if (r1 != r4) goto L54
                goto L56
            L54:
                r1 = r3
                goto L39
            L56:
                f.v r8 = f.v.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: e.a.a.f.s.k.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: ReadBook.kt */
    @DebugMetadata(c = "io.legado.app.service.help.ReadBook$moveToPrevChapter$1$1", f = "ReadBook.kt", i = {0, 0}, l = {178}, m = "invokeSuspend", n = {"minChapterIndex", ai.aA}, s = {"I$0", "I$2"})
    public static final class g extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public int I$0;
        public int I$1;
        public int I$2;
        public int label;

        public g(f.z.d<? super g> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new g(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0044 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0042 -> B:14:0x0045). Please report as a decompilation issue!!! */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                f.z.i.a r0 = f.z.i.a.COROUTINE_SUSPENDED
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L1c
                if (r1 != r2) goto L14
                int r1 = r7.I$2
                int r3 = r7.I$1
                int r4 = r7.I$0
                c.b.a.m.f.E5(r8)
                r8 = r7
                goto L45
            L14:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1c:
                c.b.a.m.f.E5(r8)
                r8 = 0
                e.a.a.f.s.k r1 = e.a.a.f.s.k.a
                int r1 = e.a.a.f.s.k.f5681g
                int r1 = r1 + (-5)
                int r8 = java.lang.Math.max(r8, r1)
                int r1 = e.a.a.f.s.k.f5681g
                int r1 = r1 + (-2)
                if (r8 > r1) goto L4f
                r4 = r8
                r8 = r7
            L32:
                int r3 = r1 + (-1)
                r5 = 1000(0x3e8, double:4.94E-321)
                r8.I$0 = r4
                r8.I$1 = r3
                r8.I$2 = r1
                r8.label = r2
                java.lang.Object r5 = c.b.a.m.f.p1(r5, r8)
                if (r5 != r0) goto L45
                return r0
            L45:
                e.a.a.f.s.k r5 = e.a.a.f.s.k.a
                e.a.a.f.s.k.a(r5, r1)
                if (r1 != r4) goto L4d
                goto L4f
            L4d:
                r1 = r3
                goto L32
            L4f:
                f.v r8 = f.v.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: e.a.a.f.s.k.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: ReadBook.kt */
    @DebugMetadata(c = "io.legado.app.service.help.ReadBook$saveRead$1", f = "ReadBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public int label;

        public h(f.z.d<? super h> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new h(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((h) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            k kVar = k.a;
            Book book = k.f5677c;
            if (book == null) {
                return null;
            }
            book.setLastCheckCount(0);
            book.setDurChapterTime(System.currentTimeMillis());
            book.setDurChapterIndex(k.f5681g);
            book.setDurChapterPos(k.f5682h);
            BookChapter chapter = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(book.getBookUrl(), k.f5681g);
            if (chapter != null) {
                book.setDurChapterTitle(chapter.getTitle());
            }
            AppDatabaseKt.getAppDb().getBookDao().update(book);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBook.kt */
    public static final class i extends f.c0.c.k implements f.c0.b.a<v> {
        public final /* synthetic */ f.c0.b.a<v> $success;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(f.c0.b.a<v> aVar) {
            super(0);
            this.$success = aVar;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            f.c0.b.a<v> aVar = this.$success;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }
    }

    public static final void a(k kVar, int i2) {
        Book book = f5677c;
        if (book == null || book.isLocalBook() || !a.b(i2)) {
            return;
        }
        e.a.a.d.u.b.b(b.C0148b.b(e.a.a.d.u.b.a, null, null, new l(book, i2, null), 3), null, new m(i2, null), 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(k kVar, Book book, BookChapter bookChapter, String str, boolean z, boolean z2, f.c0.b.a aVar, int i2) {
        boolean z3 = (i2 & 8) != 0 ? true : z;
        if ((i2 & 32) != 0) {
            aVar = null;
        }
        kVar.d(book, bookChapter, str, z3, z2, aVar);
    }

    public static void g(k kVar, BookChapter bookChapter, boolean z, f.c0.b.a aVar, int i2) {
        int i3 = i2 & 4;
        Book book = f5677c;
        WebBook webBook = o;
        if (book != null && webBook != null) {
            e.a.a.f.s.h hVar = e.a.a.f.s.h.a;
            b.C0148b c0148b = e.a.a.d.u.b.a;
            e.a.a.f.s.h.b(hVar, e.a.a.d.u.b.f5558b, webBook, book, bookChapter, false, 16);
        } else if (book == null) {
            kVar.p(bookChapter.getIndex());
        } else {
            e(kVar, book, bookChapter, "没有书源", false, z, new n(null), 8);
            kVar.p(bookChapter.getIndex());
        }
    }

    public static void j(k kVar, int i2, boolean z, boolean z2, f.c0.b.a aVar, int i3) {
        boolean z3 = (i3 & 2) != 0 ? true : z;
        f.c0.b.a aVar2 = (i3 & 8) != 0 ? null : aVar;
        Book book = f5677c;
        if (book != null && a.b(i2)) {
            e.a.a.d.u.b.b(b.C0148b.b(e.a.a.d.u.b.a, null, null, new o(book, i2, z2, z3, aVar2, null), 3), null, new p(i2, null), 1);
        }
    }

    public static void w(k kVar, boolean z, int i2) {
        Book book;
        if ((i2 & 1) != 0) {
            e.a.a.d.e eVar = e.a.a.d.e.a;
            z = c.b.a.m.f.J2(k.d.a.h.g(), "syncBookProgress", true);
        }
        if (!z || (book = f5677c) == null) {
            return;
        }
        e.a.a.d.w.j jVar = e.a.a.d.w.j.a;
        f.c0.c.j.e(book, "book");
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new e.a.a.d.w.m(book, null), 3);
    }

    public final boolean b(int i2) {
        synchronized (this) {
            ArrayList<Integer> arrayList = q;
            if (arrayList.contains(Integer.valueOf(i2))) {
                return false;
            }
            arrayList.add(Integer.valueOf(i2));
            return true;
        }
    }

    public final void c() {
        f5685k = null;
        f5686l = null;
        m = null;
    }

    public final void d(@NotNull Book book, @NotNull BookChapter bookChapter, @NotNull String str, boolean z, boolean z2, @Nullable f.c0.b.a<v> aVar) {
        f.c0.c.j.e(book, "book");
        f.c0.c.j.e(bookChapter, "chapter");
        f.c0.c.j.e(str, "content");
        e.a.a.d.u.b bVarB = b.C0148b.b(e.a.a.d.u.b.a, null, null, new b(bookChapter, book, str, z, z2, null), 3);
        e.a.a.d.u.b.b(bVarB, null, new c(null), 1);
        bVarB.d(null, new d(aVar, null));
    }

    public final void f() throws IllegalAccessException, InvocationTargetException {
        a aVar = f5684j;
        if (aVar != null) {
            aVar.A0();
        }
        if (BaseReadAloudService.f6927b) {
            o(!BaseReadAloudService.f6929d);
        }
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new q(null), 3);
    }

    public final int h() {
        e.a.a.g.d.i.s1.g.b bVar = f5686l;
        return bVar == null ? f5682h : bVar.a(f5682h);
    }

    public final void i(boolean z, @Nullable f.c0.b.a<v> aVar) {
        j(this, f5681g, false, z, new e(aVar), 2);
        j(this, f5681g + 1, false, z, null, 10);
        j(this, f5681g - 1, false, z, null, 10);
    }

    public final boolean k(boolean z) throws IllegalAccessException, InvocationTargetException {
        a aVar;
        int i2 = f5681g;
        if (i2 >= f5680f - 1) {
            return false;
        }
        f5682h = 0;
        int i3 = i2 + 1;
        f5681g = i3;
        f5685k = f5686l;
        e.a.a.g.d.i.s1.g.b bVar = m;
        f5686l = bVar;
        m = null;
        if (f5677c != null) {
            k kVar = a;
            if (bVar == null) {
                j(kVar, i3, z, false, null, 8);
            } else if (z && (aVar = f5684j) != null) {
                c.b.a.m.f.V5(aVar, 0, false, null, 7, null);
            }
            j(kVar, f5681g + 1, z, false, null, 8);
            y0 y0Var = y0.a;
            k0 k0Var = k0.f6264c;
            c.b.a.m.f.L3(y0Var, k0.f6263b, null, new f(null), 2, null);
        }
        q();
        a aVar2 = f5684j;
        if (aVar2 != null) {
            aVar2.w0();
        }
        f();
        return true;
    }

    public final void l() {
        e.a.a.g.d.i.s1.g.b bVar = f5686l;
        Integer numValueOf = bVar == null ? null : Integer.valueOf(bVar.c(bVar.a(f5682h) + 1));
        f5682h = numValueOf == null ? f5682h : numValueOf.intValue();
        a aVar = f5684j;
        if (aVar != null) {
            c.b.a.m.f.V5(aVar, 0, false, null, 7, null);
        }
        q();
    }

    public final boolean m(boolean z, boolean z2) throws IllegalAccessException, InvocationTargetException {
        a aVar;
        e.a.a.g.d.i.s1.g.b bVar;
        int iC = 0;
        if (f5681g <= 0) {
            return false;
        }
        if (z2 && (bVar = f5685k) != null) {
            iC = bVar.c(f.x.e.m(bVar.f5768d));
        }
        f5682h = iC;
        int i2 = f5681g - 1;
        f5681g = i2;
        m = f5686l;
        e.a.a.g.d.i.s1.g.b bVar2 = f5685k;
        f5686l = bVar2;
        f5685k = null;
        if (f5677c != null) {
            k kVar = a;
            if (bVar2 == null) {
                j(kVar, i2, z, false, null, 8);
            } else if (z && (aVar = f5684j) != null) {
                c.b.a.m.f.V5(aVar, 0, false, null, 7, null);
            }
            j(kVar, f5681g - 1, z, false, null, 8);
            y0 y0Var = y0.a;
            k0 k0Var = k0.f6264c;
            c.b.a.m.f.L3(y0Var, k0.f6263b, null, new g(null), 2, null);
        }
        q();
        a aVar2 = f5684j;
        if (aVar2 != null) {
            aVar2.w0();
        }
        f();
        return true;
    }

    public final int n() {
        Book book = f5677c;
        return book == null ? ReadBookConfig.INSTANCE.getPageAnim() : book.getPageAnim() < 0 ? ReadBookConfig.INSTANCE.getPageAnim() : book.getPageAnim();
    }

    public final void o(boolean z) throws IllegalAccessException, InvocationTargetException {
        Book book = f5677c;
        e.a.a.g.d.i.s1.g.b bVar = f5686l;
        if (book == null || bVar == null) {
            return;
        }
        String strB = e.a.a.d.o.b(e.a.a.d.o.a, bVar, null, 2);
        j jVar = j.a;
        Context contextG = k.d.a.h.g();
        String name = book.getName();
        String str = bVar.f5766b;
        int iH = h();
        f.c0.c.j.e(contextG, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(name, "title");
        f.c0.c.j.e(str, "subtitle");
        f.c0.c.j.e(strB, "dataKey");
        Intent intent = new Intent(contextG, j.f5674b);
        intent.setAction("play");
        intent.putExtra("title", name);
        intent.putExtra("subtitle", str);
        intent.putExtra("pageIndex", iH);
        intent.putExtra("dataKey", strB);
        intent.putExtra("play", z);
        contextG.startService(intent);
    }

    public final void p(int i2) {
        synchronized (this) {
            q.remove(Integer.valueOf(i2));
        }
    }

    public final void q() {
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new h(null), 3);
    }

    public final void r(@NotNull BookProgress bookProgress) {
        f.c0.c.j.e(bookProgress, "progress");
        f5681g = bookProgress.getDurChapterIndex();
        f5682h = bookProgress.getDurChapterPos();
        c();
        i(true, null);
    }

    public final void s(int i2, @Nullable f.c0.b.a<v> aVar) throws IllegalAccessException, InvocationTargetException {
        e.a.a.g.d.i.s1.g.b bVar = f5686l;
        if (bVar != null) {
            i2 = bVar.c(i2);
        }
        f5682h = i2;
        a aVar2 = f5684j;
        if (aVar2 != null) {
            c.b.a.m.f.V5(aVar2, 0, false, new i(aVar), 3, null);
        }
        f();
        q();
    }

    @Nullable
    public final e.a.a.g.d.i.s1.g.b t(int i2) {
        if (i2 == -1) {
            return f5685k;
        }
        if (i2 == 0) {
            return f5686l;
        }
        if (i2 != 1) {
            return null;
        }
        return m;
    }

    public final void u(@Nullable String str) {
        if (f.c0.c.j.a(p, str)) {
            return;
        }
        p = str;
        a aVar = f5684j;
        if (aVar == null) {
            return;
        }
        c.b.a.m.f.V5(aVar, 0, false, null, 7, null);
    }

    public final void v(@NotNull Book book) {
        v vVar;
        f.c0.c.j.e(book, "book");
        if (f.c0.c.j.a(book.getOrigin(), "loc_book")) {
            n = null;
            o = null;
            return;
        }
        BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(book.getOrigin());
        if (bookSource == null) {
            vVar = null;
        } else {
            n = bookSource;
            o = new WebBook(bookSource);
            String imageStyle = book.getImageStyle();
            if (imageStyle == null || f.h0.k.s(imageStyle)) {
                book.setImageStyle(bookSource.getContentRule().getImageStyle());
            }
            vVar = v.a;
        }
        if (vVar == null) {
            n = null;
            o = null;
        }
    }
}
