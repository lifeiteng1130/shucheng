package e.a.a.g.d.i;

import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookProgress;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$syncBookProgress$1", f = "ReadBookViewModel.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
public final class w0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super BookProgress>, Object> {
    public final /* synthetic */ Book $book;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(Book book, f.z.d<? super w0> dVar) {
        super(2, dVar);
        this.$book = book;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new w0(this.$book, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super BookProgress> dVar) {
        return ((w0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            e.a.a.d.w.j jVar = e.a.a.d.w.j.a;
            Book book = this.$book;
            this.label = 1;
            obj = jVar.e(book, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
        }
        return obj;
    }
}
