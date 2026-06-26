package e.a.a.g.l;

import f.c0.b.p;
import f.v;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WelcomeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.welcome.WelcomeActivity$init$2", f = "WelcomeActivity.kt", i = {0}, l = {64}, m = "invokeSuspend", n = {"book"}, s = {"L$1"})
public final class l extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public Object L$0;
    public Object L$1;
    public int label;

    public l(f.z.d<? super l> dVar) {
        super(2, dVar);
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new l(dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((l) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0051 -> B:15:0x0057). Please report as a decompilation issue!!! */
    @Override // f.z.j.a.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            f.z.i.a r0 = f.z.i.a.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L21
            if (r1 != r2) goto L19
            java.lang.Object r1 = r8.L$1
            io.legado.app.data.entities.Book r1 = (io.legado.app.data.entities.Book) r1
            java.lang.Object r3 = r8.L$0
            java.util.Iterator r3 = (java.util.Iterator) r3
            c.b.a.m.f.E5(r9)
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r8
            goto L57
        L19:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L21:
            c.b.a.m.f.E5(r9)
            io.legado.app.data.AppDatabase r9 = io.legado.app.data.AppDatabaseKt.getAppDb()
            io.legado.app.data.dao.BookDao r9 = r9.getBookDao()
            java.util.List r9 = r9.getAll()
            java.util.Iterator r9 = r9.iterator()
            r3 = r9
            r9 = r8
        L36:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto Laa
            java.lang.Object r1 = r3.next()
            io.legado.app.data.entities.Book r1 = (io.legado.app.data.entities.Book) r1
            e.a.a.d.w.j r4 = e.a.a.d.w.j.a
            r9.L$0 = r3
            r9.L$1 = r1
            r9.label = r2
            java.lang.Object r4 = r4.e(r1, r9)
            if (r4 != r0) goto L51
            return r0
        L51:
            r7 = r0
            r0 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r7
        L57:
            io.legado.app.data.entities.BookProgress r9 = (io.legado.app.data.entities.BookProgress) r9
            if (r9 != 0) goto L5c
            goto La6
        L5c:
            int r5 = r9.getDurChapterIndex()
            int r6 = r3.getDurChapterIndex()
            if (r5 > r6) goto L7a
            int r5 = r9.getDurChapterIndex()
            int r6 = r3.getDurChapterIndex()
            if (r5 != r6) goto La6
            int r5 = r9.getDurChapterPos()
            int r6 = r3.getDurChapterPos()
            if (r5 <= r6) goto La6
        L7a:
            int r5 = r9.getDurChapterIndex()
            r3.setDurChapterIndex(r5)
            int r5 = r9.getDurChapterPos()
            r3.setDurChapterPos(r5)
            java.lang.String r5 = r9.getDurChapterTitle()
            r3.setDurChapterTitle(r5)
            long r5 = r9.getDurChapterTime()
            r3.setDurChapterTime(r5)
            io.legado.app.data.AppDatabase r9 = io.legado.app.data.AppDatabaseKt.getAppDb()
            io.legado.app.data.dao.BookDao r9 = r9.getBookDao()
            io.legado.app.data.entities.Book[] r5 = new io.legado.app.data.entities.Book[r2]
            r6 = 0
            r5[r6] = r3
            r9.update(r5)
        La6:
            r9 = r0
            r0 = r1
            r3 = r4
            goto L36
        Laa:
            f.v r9 = f.v.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g.l.l.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
