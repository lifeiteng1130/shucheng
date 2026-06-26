package e.a.a.g.d.g;

import io.legado.app.data.entities.Book;
import io.legado.app.ui.book.info.BookInfoViewModel;
import io.legado.app.utils.FileUtils;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$clearCache$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class e0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ BookInfoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(BookInfoViewModel bookInfoViewModel, f.z.d<? super e0> dVar) {
        super(2, dVar);
        this.this$0 = bookInfoViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new e0(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((e0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        e.a.a.d.g gVar = e.a.a.d.g.a;
        Book value = this.this$0.bookData.getValue();
        f.c0.c.j.c(value);
        f.c0.c.j.e(value, "book");
        FileUtils fileUtils = FileUtils.a;
        fileUtils.h(fileUtils.o(e.a.a.d.g.f5530b, "book_cache", value.getFolderName()));
        return f.v.a;
    }
}
