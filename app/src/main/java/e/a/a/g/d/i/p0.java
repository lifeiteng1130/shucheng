package e.a.a.g.d.i;

import android.content.Intent;
import io.legado.app.ui.book.read.ReadBookViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$initData$1", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class p0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Intent $intent;
    public int label;
    public final /* synthetic */ ReadBookViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(Intent intent, ReadBookViewModel readBookViewModel, f.z.d<? super p0> dVar) {
        super(2, dVar);
        this.$intent = intent;
        this.this$0 = readBookViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new p0(this.$intent, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((p0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    @Override // f.z.j.a.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) throws java.lang.Throwable {
        /*
            r3 = this;
            int r0 = r3.label
            if (r0 != 0) goto L52
            c.b.a.m.f.E5(r4)
            e.a.a.f.s.k r4 = e.a.a.f.s.k.a
            android.content.Intent r4 = r3.$intent
            r0 = 1
            java.lang.String r1 = "inBookshelf"
            boolean r4 = r4.getBooleanExtra(r1, r0)
            e.a.a.f.s.k.f5679e = r4
            android.content.Intent r4 = r3.$intent
            java.lang.String r0 = "bookUrl"
            java.lang.String r4 = r4.getStringExtra(r0)
            r0 = 0
            if (r4 != 0) goto L20
            goto L30
        L20:
            io.legado.app.ui.book.read.ReadBookViewModel r1 = r3.this$0
            io.legado.app.data.AppDatabase r2 = io.legado.app.data.AppDatabaseKt.getAppDb()
            io.legado.app.data.dao.BookDao r2 = r2.getBookDao()
            io.legado.app.data.entities.Book r4 = r2.getBook(r4)
            if (r4 != 0) goto L32
        L30:
            r4 = r0
            goto L37
        L32:
            io.legado.app.ui.book.read.ReadBookViewModel.e(r1, r4)
            f.v r4 = f.v.a
        L37:
            if (r4 != 0) goto L50
            io.legado.app.data.AppDatabase r4 = io.legado.app.data.AppDatabaseKt.getAppDb()
            io.legado.app.data.dao.BookDao r4 = r4.getBookDao()
            io.legado.app.data.entities.Book r4 = r4.getLastReadBook()
            if (r4 != 0) goto L48
            goto L51
        L48:
            io.legado.app.ui.book.read.ReadBookViewModel r0 = r3.this$0
            io.legado.app.ui.book.read.ReadBookViewModel.e(r0, r4)
            f.v r0 = f.v.a
            goto L51
        L50:
            r0 = r4
        L51:
            return r0
        L52:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.d.i.p0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
