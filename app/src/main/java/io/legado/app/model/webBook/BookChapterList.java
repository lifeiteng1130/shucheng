package io.legado.app.model.webBook;

import f.c0.b.p;
import f.c0.c.u;
import f.v;
import f.z.d;
import f.z.j.a.c;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.rule.TocRule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookChapterList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019Jo\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015JK\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lio/legado/app/model/webBook/BookChapterList;", "", "Lg/b/a0;", "scope", "Lio/legado/app/data/entities/Book;", "book", "", "baseUrl", "redirectUrl", "body", "Lio/legado/app/data/entities/rule/TocRule;", "tocRule", "listRule", "Lio/legado/app/data/entities/BookSource;", "bookSource", "", "getNextUrl", "log", "Lio/legado/app/model/webBook/ChapterData;", "", "analyzeChapterList", "(Lg/b/a0;Lio/legado/app/data/entities/Book;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/legado/app/data/entities/rule/TocRule;Ljava/lang/String;Lio/legado/app/data/entities/BookSource;ZZ)Lio/legado/app/model/webBook/ChapterData;", "Lio/legado/app/data/entities/BookChapter;", "(Lg/b/a0;Lio/legado/app/data/entities/Book;Ljava/lang/String;Lio/legado/app/data/entities/BookSource;Ljava/lang/String;Ljava/lang/String;Lf/z/d;)Ljava/lang/Object;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookChapterList {

    @NotNull
    public static final BookChapterList INSTANCE = new BookChapterList();

    /* JADX INFO: renamed from: io.legado.app.model.webBook.BookChapterList$analyzeChapterList$1, reason: invalid class name */
    /* JADX INFO: compiled from: BookChapterList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.BookChapterList", f = "BookChapterList.kt", i = {}, l = {65, 80}, m = "analyzeChapterList", n = {}, s = {})
    public static final class AnonymousClass1 extends c {
        public int I$0;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public Object L$6;
        public Object L$7;
        public Object L$8;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BookChapterList.this.analyzeChapterList(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.BookChapterList$analyzeChapterList$4, reason: invalid class name */
    /* JADX INFO: compiled from: BookChapterList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lf/v;", "<anonymous>", "(Lg/b/a0;)V"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.BookChapterList$analyzeChapterList$4", f = "BookChapterList.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ BookSource $bookSource;
        public final /* synthetic */ u<ChapterData<List<String>>> $chapterData;
        public final /* synthetic */ ArrayList<BookChapter> $chapterList;
        public final /* synthetic */ u<String> $listRule;
        public final /* synthetic */ TocRule $tocRule;
        public int I$0;
        public int I$1;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(u<ChapterData<List<String>>> uVar, Book book, BookSource bookSource, TocRule tocRule, u<String> uVar2, ArrayList<BookChapter> arrayList, d<? super AnonymousClass4> dVar) {
            super(2, dVar);
            this.$chapterData = uVar;
            this.$book = book;
            this.$bookSource = bookSource;
            this.$tocRule = tocRule;
            this.$listRule = uVar2;
            this.$chapterList = arrayList;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$chapterData, this.$book, this.$bookSource, this.$tocRule, this.$listRule, this.$chapterList, dVar);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((AnonymousClass4) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x008e -> B:17:0x0093). Please report as a decompilation issue!!! */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r23) throws java.lang.Throwable {
            /*
                r22 = this;
                r0 = r22
                f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L29
                if (r2 != r4) goto L21
                int r2 = r0.I$1
                int r3 = r0.I$0
                java.lang.Object r5 = r0.L$1
                g.b.f0[] r5 = (g.b.f0[]) r5
                java.lang.Object r6 = r0.L$0
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                c.b.a.m.f.E5(r23)
                r7 = r23
                r11 = r3
                r3 = r0
                goto L93
            L21:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L29:
                c.b.a.m.f.E5(r23)
                java.lang.Object r2 = r0.L$0
                g.b.a0 r2 = (g.b.a0) r2
                f.c0.c.u<io.legado.app.model.webBook.ChapterData<java.util.List<java.lang.String>>> r5 = r0.$chapterData
                T r5 = r5.element
                io.legado.app.model.webBook.ChapterData r5 = (io.legado.app.model.webBook.ChapterData) r5
                java.lang.Object r5 = r5.getNextUrl()
                java.util.List r5 = (java.util.List) r5
                int r11 = r5.size()
                g.b.f0[] r12 = new g.b.f0[r11]
                r5 = 0
                r10 = 0
            L44:
                if (r10 >= r11) goto L74
                g.b.k0 r5 = g.b.k0.f6264c
                g.b.y r6 = g.b.k0.f6263b
                r7 = 0
                io.legado.app.model.webBook.BookChapterList$analyzeChapterList$4$asyncArray$1$1 r8 = new io.legado.app.model.webBook.BookChapterList$analyzeChapterList$4$asyncArray$1$1
                f.c0.c.u<io.legado.app.model.webBook.ChapterData<java.util.List<java.lang.String>>> r14 = r0.$chapterData
                io.legado.app.data.entities.Book r5 = r0.$book
                io.legado.app.data.entities.BookSource r9 = r0.$bookSource
                io.legado.app.data.entities.rule.TocRule r15 = r0.$tocRule
                f.c0.c.u<java.lang.String> r13 = r0.$listRule
                r20 = 0
                r19 = r13
                r13 = r8
                r18 = r15
                r15 = r10
                r16 = r5
                r17 = r9
                r13.<init>(r14, r15, r16, r17, r18, r19, r20)
                r9 = 2
                r13 = 0
                r5 = r2
                r14 = r10
                r10 = r13
                g.b.f0 r5 = c.b.a.m.f.r0(r5, r6, r7, r8, r9, r10)
                r12[r14] = r5
                int r10 = r14 + 1
                goto L44
            L74:
                java.util.ArrayList<io.legado.app.data.entities.BookChapter> r2 = r0.$chapterList
                r6 = r2
                r5 = r12
                r2 = r0
            L79:
                if (r3 >= r11) goto La2
                r7 = r5[r3]
                r2.L$0 = r6
                r2.L$1 = r5
                r2.I$0 = r11
                r2.I$1 = r3
                r2.label = r4
                java.lang.Object r7 = r7.e(r2)
                if (r7 != r1) goto L8e
                return r1
            L8e:
                r21 = r3
                r3 = r2
                r2 = r21
            L93:
                java.util.List r7 = (java.util.List) r7
                if (r7 != 0) goto L98
                goto L9b
            L98:
                r6.addAll(r7)
            L9b:
                int r2 = r2 + r4
                r21 = r3
                r3 = r2
                r2 = r21
                goto L79
            La2:
                f.v r1 = f.v.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.BookChapterList.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private BookChapterList() {
    }

    public static /* synthetic */ ChapterData analyzeChapterList$default(BookChapterList bookChapterList, a0 a0Var, Book book, String str, String str2, String str3, TocRule tocRule, String str4, BookSource bookSource, boolean z, boolean z2, int i2, Object obj) {
        return bookChapterList.analyzeChapterList(a0Var, book, str, str2, str3, tocRule, str4, bookSource, (i2 & 256) != 0 ? true : z, (i2 & 512) != 0 ? false : z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, io.legado.app.model.webBook.ChapterData] */
    /* JADX WARN: Type inference failed for: r0v39, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v42, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v28, types: [T, io.legado.app.model.webBook.ChapterData] */
    /* JADX WARN: Type inference failed for: r5v7, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x02b1 -> B:52:0x02c6). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object analyzeChapterList(@org.jetbrains.annotations.NotNull g.b.a0 r44, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r45, @org.jetbrains.annotations.Nullable java.lang.String r46, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.BookSource r47, @org.jetbrains.annotations.NotNull java.lang.String r48, @org.jetbrains.annotations.NotNull java.lang.String r49, @org.jetbrains.annotations.NotNull f.z.d<? super java.util.List<io.legado.app.data.entities.BookChapter>> r50) {
        /*
            Method dump skipped, instruction units count: 1081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.BookChapterList.analyzeChapterList(g.b.a0, io.legado.app.data.entities.Book, java.lang.String, io.legado.app.data.entities.BookSource, java.lang.String, java.lang.String, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final io.legado.app.model.webBook.ChapterData<java.util.List<java.lang.String>> analyzeChapterList(g.b.a0 r33, io.legado.app.data.entities.Book r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, io.legado.app.data.entities.rule.TocRule r38, java.lang.String r39, io.legado.app.data.entities.BookSource r40, boolean r41, boolean r42) {
        /*
            Method dump skipped, instruction units count: 669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.BookChapterList.analyzeChapterList(g.b.a0, io.legado.app.data.entities.Book, java.lang.String, java.lang.String, java.lang.String, io.legado.app.data.entities.rule.TocRule, java.lang.String, io.legado.app.data.entities.BookSource, boolean, boolean):io.legado.app.model.webBook.ChapterData");
    }
}
