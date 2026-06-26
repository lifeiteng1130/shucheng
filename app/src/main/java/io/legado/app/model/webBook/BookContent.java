package io.legado.app.model.webBook;

import c.a.a.a.a;
import e.a.a.h.q;
import e.a.a.h.x;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.u;
import f.v;
import f.x.e;
import f.z.d;
import f.z.j.a.c;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.rule.ContentRule;
import io.legado.app.model.Debug;
import io.legado.app.model.analyzeRule.AnalyzeRule;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookContent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJg\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00120\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014JY\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lio/legado/app/model/webBook/BookContent;", "", "Lio/legado/app/data/entities/Book;", "book", "", "baseUrl", "redirectUrl", "body", "Lio/legado/app/data/entities/rule/ContentRule;", "contentRule", "Lio/legado/app/data/entities/BookChapter;", "chapter", "Lio/legado/app/data/entities/BookSource;", "bookSource", "nextChapterUrl", "", "printLog", "Lio/legado/app/model/webBook/ContentData;", "", "analyzeContent", "(Lio/legado/app/data/entities/Book;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/legado/app/data/entities/rule/ContentRule;Lio/legado/app/data/entities/BookChapter;Lio/legado/app/data/entities/BookSource;Ljava/lang/String;Z)Lio/legado/app/model/webBook/ContentData;", "Lg/b/a0;", "scope", "bookChapter", "(Lg/b/a0;Ljava/lang/String;Lio/legado/app/data/entities/Book;Lio/legado/app/data/entities/BookChapter;Lio/legado/app/data/entities/BookSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lf/z/d;)Ljava/lang/Object;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookContent {

    @NotNull
    public static final BookContent INSTANCE = new BookContent();

    /* JADX INFO: renamed from: io.legado.app.model.webBook.BookContent$analyzeContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: BookContent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.BookContent", f = "BookContent.kt", i = {}, l = {69, 83, 116}, m = "analyzeContent", n = {}, s = {})
    public static final class AnonymousClass1 extends c {
        public Object L$0;
        public Object L$1;
        public Object L$10;
        public Object L$11;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public Object L$6;
        public Object L$7;
        public Object L$8;
        public Object L$9;
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
            return BookContent.this.analyzeContent((a0) null, (String) null, (Book) null, (BookChapter) null, (BookSource) null, (String) null, (String) null, (String) null, this);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.BookContent$analyzeContent$3, reason: invalid class name */
    /* JADX INFO: compiled from: BookContent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lf/v;", "<anonymous>", "(Lg/b/a0;)V"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.BookContent$analyzeContent$3", f = "BookContent.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ BookChapter $bookChapter;
        public final /* synthetic */ BookSource $bookSource;
        public final /* synthetic */ StringBuilder $content;
        public final /* synthetic */ u<ContentData<List<String>>> $contentData;
        public final /* synthetic */ ContentRule $contentRule;
        public final /* synthetic */ String $mNextChapterUrl;
        public final /* synthetic */ a0 $scope;
        public int I$0;
        public int I$1;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(u<ContentData<List<String>>> uVar, Book book, BookSource bookSource, ContentRule contentRule, BookChapter bookChapter, String str, a0 a0Var, StringBuilder sb, d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$contentData = uVar;
            this.$book = book;
            this.$bookSource = bookSource;
            this.$contentRule = contentRule;
            this.$bookChapter = bookChapter;
            this.$mNextChapterUrl = str;
            this.$scope = a0Var;
            this.$content = sb;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$contentData, this.$book, this.$bookSource, this.$contentRule, this.$bookChapter, this.$mNextChapterUrl, this.$scope, this.$content, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((AnonymousClass3) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00b6  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a4 -> B:17:0x00a7). Please report as a decompilation issue!!! */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) throws java.lang.Throwable {
            /*
                r21 = this;
                r0 = r21
                f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L30
                if (r2 != r3) goto L28
                int r2 = r0.I$1
                int r4 = r0.I$0
                java.lang.Object r5 = r0.L$3
                java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
                java.lang.Object r6 = r0.L$2
                g.b.f0[] r6 = (g.b.f0[]) r6
                java.lang.Object r7 = r0.L$1
                java.lang.StringBuilder r7 = (java.lang.StringBuilder) r7
                java.lang.Object r8 = r0.L$0
                g.b.a0 r8 = (g.b.a0) r8
                c.b.a.m.f.E5(r22)
                r9 = r22
                r10 = r8
                r8 = r0
                goto La7
            L28:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L30:
                c.b.a.m.f.E5(r22)
                java.lang.Object r2 = r0.L$0
                g.b.a0 r2 = (g.b.a0) r2
                f.c0.c.u<io.legado.app.model.webBook.ContentData<java.util.List<java.lang.String>>> r4 = r0.$contentData
                T r4 = r4.element
                io.legado.app.model.webBook.ContentData r4 = (io.legado.app.model.webBook.ContentData) r4
                java.lang.Object r4 = r4.getNextUrl()
                java.util.List r4 = (java.util.List) r4
                int r10 = r4.size()
                g.b.f0[] r11 = new g.b.f0[r10]
                r4 = 0
                r9 = 0
            L4b:
                if (r9 >= r10) goto L7d
                g.b.k0 r4 = g.b.k0.f6264c
                g.b.y r5 = g.b.k0.f6263b
                r6 = 0
                io.legado.app.model.webBook.BookContent$analyzeContent$3$asyncArray$1$1 r7 = new io.legado.app.model.webBook.BookContent$analyzeContent$3$asyncArray$1$1
                f.c0.c.u<io.legado.app.model.webBook.ContentData<java.util.List<java.lang.String>>> r13 = r0.$contentData
                io.legado.app.data.entities.Book r15 = r0.$book
                io.legado.app.data.entities.BookSource r4 = r0.$bookSource
                io.legado.app.data.entities.rule.ContentRule r8 = r0.$contentRule
                io.legado.app.data.entities.BookChapter r14 = r0.$bookChapter
                java.lang.String r12 = r0.$mNextChapterUrl
                r20 = 0
                r19 = r12
                r12 = r7
                r18 = r14
                r14 = r9
                r16 = r4
                r17 = r8
                r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
                r8 = 2
                r12 = 0
                r4 = r2
                r13 = r9
                r9 = r12
                g.b.f0 r4 = c.b.a.m.f.r0(r4, r5, r6, r7, r8, r9)
                r11[r13] = r4
                int r9 = r13 + 1
                goto L4b
            L7d:
                g.b.a0 r2 = r0.$scope
                java.lang.StringBuilder r4 = r0.$content
                r5 = 0
                r7 = r0
                r8 = r2
                r5 = r4
                r4 = r10
                r6 = r11
                r2 = 0
            L88:
                if (r2 >= r4) goto Lb6
                r9 = r6[r2]
                c.b.a.m.f.B1(r8)
                r7.L$0 = r8
                r7.L$1 = r5
                r7.L$2 = r6
                r7.L$3 = r5
                r7.I$0 = r4
                r7.I$1 = r2
                r7.label = r3
                java.lang.Object r9 = r9.e(r7)
                if (r9 != r1) goto La4
                return r1
            La4:
                r10 = r8
                r8 = r7
                r7 = r5
            La7:
                java.lang.String r9 = (java.lang.String) r9
                r5.append(r9)
                java.lang.String r9 = "\n"
                r5.append(r9)
                int r2 = r2 + r3
                r5 = r7
                r7 = r8
                r8 = r10
                goto L88
            Lb6:
                f.v r1 = f.v.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.BookContent.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private BookContent() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0200, code lost:
    
        if (f.c0.c.j.a(e.a.a.h.x.a(r12, (java.lang.String) r11.element), e.a.a.h.x.a(r12, r5)) != false) goto L53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:45:0x01e2, B:49:0x01eb], limit reached: 94 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0499  */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, io.legado.app.model.webBook.ContentData] */
    /* JADX WARN: Type inference failed for: r0v46, types: [T, io.legado.app.model.webBook.ContentData] */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x02b4 -> B:58:0x02ce). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object analyzeContent(@org.jetbrains.annotations.NotNull g.b.a0 r46, @org.jetbrains.annotations.Nullable java.lang.String r47, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r48, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.BookChapter r49, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.BookSource r50, @org.jetbrains.annotations.NotNull java.lang.String r51, @org.jetbrains.annotations.NotNull java.lang.String r52, @org.jetbrains.annotations.Nullable java.lang.String r53, @org.jetbrains.annotations.NotNull f.z.d<? super java.lang.String> r54) {
        /*
            Method dump skipped, instruction units count: 1239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.BookContent.analyzeContent(g.b.a0, java.lang.String, io.legado.app.data.entities.Book, io.legado.app.data.entities.BookChapter, io.legado.app.data.entities.BookSource, java.lang.String, java.lang.String, java.lang.String, f.z.d):java.lang.Object");
    }

    public static /* synthetic */ ContentData analyzeContent$default(BookContent bookContent, Book book, String str, String str2, String str3, ContentRule contentRule, BookChapter bookChapter, BookSource bookSource, String str4, boolean z, int i2, Object obj) {
        return bookContent.analyzeContent(book, str, str2, str3, contentRule, bookChapter, bookSource, str4, (i2 & 256) != 0 ? true : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentData<List<String>> analyzeContent(Book book, String baseUrl, String redirectUrl, String body, ContentRule contentRule, BookChapter chapter, BookSource bookSource, String nextChapterUrl, boolean printLog) {
        AnalyzeRule analyzeRule = new AnalyzeRule(book);
        analyzeRule.setContent(body, baseUrl);
        URL redirectUrl2 = analyzeRule.setRedirectUrl(redirectUrl);
        analyzeRule.setNextChapterUrl(nextChapterUrl);
        ArrayList arrayList = new ArrayList();
        analyzeRule.setChapter(chapter);
        String string$default = AnalyzeRule.getString$default(analyzeRule, contentRule.getContent(), false, (String) null, 6, (Object) null);
        q qVar = q.a;
        String strJ = "";
        if (string$default != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = q.f5964e.matcher(string$default);
            int iEnd = 0;
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                j.c(strGroup);
                List<String> listSplit = AnalyzeUrl.INSTANCE.getSplitUrlRegex().split(strGroup, 0);
                x xVar = x.a;
                String strB = x.b(redirectUrl2, listSplit.get(0));
                if (listSplit.size() > 1) {
                    strB = strB + ',' + listSplit.get(1);
                }
                String strSubstring = string$default.substring(iEnd, matcher.start());
                j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                stringBuffer.append(strSubstring);
                stringBuffer.append("<img src=\"" + strB + "\" >");
                iEnd = matcher.end();
            }
            if (iEnd < string$default.length()) {
                String strSubstring2 = string$default.substring(iEnd, string$default.length());
                j.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                stringBuffer.append(strSubstring2);
            }
            strJ = a.j("[\\n\\s]+$", a.j("^[\\n\\s]+", a.j("\\s*\\n+\\s*", q.f5962c.replace(q.f5961b.replace(stringBuffer, "\n"), ""), "\n\u3000\u3000"), "\u3000\u3000"), "");
        }
        String nextContentUrl = contentRule.getNextContentUrl();
        if (!(nextContentUrl == null || nextContentUrl.length() == 0)) {
            Debug debug = Debug.INSTANCE;
            Debug.log$default(debug, bookSource.getBookSourceUrl(), "┌获取正文下一页链接", printLog, false, false, 0, 56, null);
            List<String> stringList = analyzeRule.getStringList(nextContentUrl, true);
            if (stringList != null) {
                arrayList.addAll(stringList);
            }
            Debug.log$default(debug, bookSource.getBookSourceUrl(), j.k("└", e.q(arrayList, "，", null, null, 0, null, null, 62)), printLog, false, false, 0, 56, null);
        }
        return new ContentData<>(strJ, arrayList);
    }
}
