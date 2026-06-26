package e.a.a.g.d.l.b;

import android.content.Intent;
import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.ui.book.source.edit.BookSourceEditViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookSourceEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.source.edit.BookSourceEditViewModel$initData$1", f = "BookSourceEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class j extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Intent $intent;
    public int label;
    public final /* synthetic */ BookSourceEditViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Intent intent, BookSourceEditViewModel bookSourceEditViewModel, f.z.d<? super j> dVar) {
        super(2, dVar);
        this.$intent = intent;
        this.this$0 = bookSourceEditViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new j(this.$intent, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((j) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String stringExtra = this.$intent.getStringExtra("data");
        BookSource bookSource = stringExtra != null ? AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(stringExtra) : null;
        if (bookSource == null) {
            return null;
        }
        BookSourceEditViewModel bookSourceEditViewModel = this.this$0;
        bookSourceEditViewModel.oldSourceUrl = bookSource.getBookSourceUrl();
        bookSourceEditViewModel.bookSource = bookSource;
        return v.a;
    }
}
