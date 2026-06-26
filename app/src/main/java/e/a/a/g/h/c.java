package e.a.a.g.h;

import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.model.webBook.WebBook;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.MainViewModel$cacheBook$1", f = "MainViewModel.kt", i = {0, 0}, l = {126}, m = "invokeSuspend", n = {"chapter", "downloadToIndex"}, s = {"L$3", "I$0"})
public final class c extends g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ WebBook $webBook;
    public int I$0;
    public int I$1;
    public int I$2;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Book book, WebBook webBook, f.z.d<? super c> dVar) {
        super(2, dVar);
        this.$book = book;
        this.$webBook = webBook;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        c cVar = new c(this.$book, this.$webBook, dVar);
        cVar.L$0 = obj;
        return cVar;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0105  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x007f -> B:35:0x0102). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x008f -> B:19:0x0096). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c1 -> B:31:0x00f8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00f5 -> B:31:0x00f8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0100 -> B:34:0x0101). Please report as a decompilation issue!!! */
    @Override // f.z.j.a.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.h.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
