package e.a.a.g.d.k;

import f.c0.b.p;
import f.c0.c.u;
import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.ui.book.searchContent.SearchContentActivity;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchContentActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.searchContent.SearchContentActivity$startContentSearch$1", f = "SearchContentActivity.kt", i = {0}, l = {152}, m = "invokeSuspend", n = {"destination$iv$iv"}, s = {"L$3"})
public final class g extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $newText;
    public final /* synthetic */ u<List<j>> $searchResults;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    public final /* synthetic */ SearchContentActivity this$0;

    /* JADX INFO: compiled from: SearchContentActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.searchContent.SearchContentActivity$startContentSearch$1$1$1", f = "SearchContentActivity.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ BookChapter $chapter;
        public final /* synthetic */ String $newText;
        public final /* synthetic */ u<List<j>> $searchResults;
        public Object L$0;
        public int label;
        public final /* synthetic */ SearchContentActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SearchContentActivity searchContentActivity, BookChapter bookChapter, u<List<j>> uVar, String str, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.this$0 = searchContentActivity;
            this.$chapter = bookChapter;
            this.$searchResults = uVar;
            this.$newText = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.this$0, this.$chapter, this.$searchResults, this.$newText, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            u<List<j>> uVar;
            T t;
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                Book book = this.this$0.V0().book;
                if (f.c0.c.j.a(book == null ? null : Boolean.valueOf(book.isLocalBook()), Boolean.TRUE) || this.this$0.U0().cacheFileNames.contains(this.$chapter.getFileName())) {
                    u<List<j>> uVar2 = this.$searchResults;
                    SearchContentActivity searchContentActivity = this.this$0;
                    String str = this.$newText;
                    BookChapter bookChapter = this.$chapter;
                    this.L$0 = uVar2;
                    this.label = 1;
                    Object objT0 = SearchContentActivity.T0(searchContentActivity, str, bookChapter, this);
                    if (objT0 == aVar) {
                        return aVar;
                    }
                    uVar = uVar2;
                    t = objT0;
                }
                return v.a;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            uVar = (u) this.L$0;
            c.b.a.m.f.E5(obj);
            t = obj;
            uVar.element = t;
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(SearchContentActivity searchContentActivity, u<List<j>> uVar, String str, f.z.d<? super g> dVar) {
        super(2, dVar);
        this.this$0 = searchContentActivity;
        this.$searchResults = uVar;
        this.$newText = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new g(this.this$0, this.$searchResults, this.$newText, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ec  */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, f.x.i] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x009a -> B:15:0x009b). Please report as a decompilation issue!!! */
    @Override // f.z.j.a.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.d.k.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
