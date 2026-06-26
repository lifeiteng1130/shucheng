package io.legado.app.model.webBook;

import f.z.d;
import f.z.j.a.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PreciseSearch.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/legado/app/model/webBook/PreciseSearch;", "", "Lg/b/a0;", "scope", "", "Lio/legado/app/data/entities/BookSource;", "bookSources", "", "name", "author", "Lio/legado/app/data/entities/Book;", "searchFirstBook", "(Lg/b/a0;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lf/z/d;)Ljava/lang/Object;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class PreciseSearch {

    @NotNull
    public static final PreciseSearch INSTANCE = new PreciseSearch();

    /* JADX INFO: renamed from: io.legado.app.model.webBook.PreciseSearch$searchFirstBook$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreciseSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.PreciseSearch", f = "PreciseSearch.kt", i = {}, l = {23, 28}, m = "searchFirstBook", n = {}, s = {})
    public static final class AnonymousClass1 extends c {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
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
            return PreciseSearch.this.searchFirstBook(null, null, null, null, this);
        }
    }

    private PreciseSearch() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:31|32|97|33|(1:35)(6:36|91|37|(3:38|(0)(0)|103)|52|(8:56|(2:58|(1:60)(5:61|62|89|63|(1:65)(3:66|67|104)))(3:69|70|71)|72|76|82|83|25|(1:84)(0))(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:19|(3:93|20|21)|91|37|(2:38|(5:95|40|(1:45)(1:44)|46|(1:102)(1:103))(2:101|51))|52|(5:54|55|83|25|(4:27|85|28|(1:30)(5:31|32|97|33|(1:35)(6:36|91|37|(3:38|(0)(0)|103)|52|(8:56|(2:58|(1:60)(5:61|62|89|63|(1:65)(3:66|67|104)))(3:69|70|71)|72|76|82|83|25|(1:84)(0))(0))))(0))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0157, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0165, code lost:
    
        r10 = r1;
        r9 = r3;
        r8 = r4;
        r3 = r6;
        r1 = r15;
        r4 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x016c, code lost:
    
        r8 = r6;
        r9 = r15;
        r10 = r14;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0109 A[Catch: all -> 0x00fe, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x00fe, blocks: (B:40:0x00d5, B:42:0x00e6, B:46:0x00f3, B:54:0x0109), top: B:95:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0117 A[Catch: all -> 0x0157, TRY_ENTER, TryCatch #3 {all -> 0x0157, blocks: (B:37:0x00c9, B:38:0x00cf, B:52:0x0105, B:56:0x0117, B:58:0x0121, B:61:0x0128), top: B:91:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00ff -> B:82:0x016c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x010c -> B:83:0x0179). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0147 -> B:67:0x014b). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object searchFirstBook(@org.jetbrains.annotations.NotNull g.b.a0 r21, @org.jetbrains.annotations.NotNull java.util.List<io.legado.app.data.entities.BookSource> r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull java.lang.String r24, @org.jetbrains.annotations.NotNull f.z.d<? super io.legado.app.data.entities.Book> r25) {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.PreciseSearch.searchFirstBook(g.b.a0, java.util.List, java.lang.String, java.lang.String, f.z.d):java.lang.Object");
    }
}
