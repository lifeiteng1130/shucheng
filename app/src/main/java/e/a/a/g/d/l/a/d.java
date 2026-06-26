package e.a.a.g.d.l.a;

import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.model.Debug;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.book.source.debug.BookSourceDebugModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceDebugModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.debug.BookSourceDebugModel$startDebug$1", f = "BookSourceDebugModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d extends g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $key;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BookSourceDebugModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BookSourceDebugModel bookSourceDebugModel, String str, f.z.d<? super d> dVar) {
        super(2, dVar);
        this.this$0 = bookSourceDebugModel;
        this.$key = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        d dVar2 = new d(this.this$0, this.$key, dVar);
        dVar2.L$0 = obj;
        return dVar2;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        a0 a0Var = (a0) this.L$0;
        Debug debug = Debug.INSTANCE;
        debug.setCallback(this.this$0);
        WebBook webBook = this.this$0.webBook;
        j.c(webBook);
        debug.startDebug(a0Var, webBook, this.$key);
        return v.a;
    }
}
