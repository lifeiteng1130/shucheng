package e.a.a.g.c;

import android.content.Intent;
import f.v;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookSource;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.audio.AudioPlayViewModel;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlayViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.audio.AudioPlayViewModel$initData$1$1", f = "AudioPlayViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class n extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Intent $intent;
    public final /* synthetic */ e.a.a.f.s.a $this_apply;
    public int label;
    public final /* synthetic */ AudioPlayViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Intent intent, e.a.a.f.s.a aVar, AudioPlayViewModel audioPlayViewModel, f.z.d<? super n> dVar) {
        super(2, dVar);
        this.$intent = intent;
        this.$this_apply = aVar;
        this.this$0 = audioPlayViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new n(this.$intent, this.$this_apply, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((n) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String stringExtra = this.$intent.getStringExtra("bookUrl");
        Objects.requireNonNull(this.$this_apply);
        Book book = e.a.a.f.s.a.f5665e;
        if (!f.c0.c.j.a(book == null ? null : book.getBookUrl(), stringExtra)) {
            this.$this_apply.g(this.this$0.b());
            e.a.a.f.s.a aVar = this.$this_apply;
            boolean booleanExtra = this.$intent.getBooleanExtra("inBookshelf", true);
            Objects.requireNonNull(aVar);
            e.a.a.f.s.a.f5667g = booleanExtra;
            e.a.a.f.s.a aVar2 = this.$this_apply;
            Book book2 = !(stringExtra == null || stringExtra.length() == 0) ? AppDatabaseKt.getAppDb().getBookDao().getBook(stringExtra) : AppDatabaseKt.getAppDb().getBookDao().getLastReadBook();
            Objects.requireNonNull(aVar2);
            e.a.a.f.s.a.f5665e = book2;
            Objects.requireNonNull(this.$this_apply);
            Book book3 = e.a.a.f.s.a.f5665e;
            if (book3 != null) {
                e.a.a.f.s.a aVar3 = this.$this_apply;
                AudioPlayViewModel audioPlayViewModel = this.this$0;
                Objects.requireNonNull(aVar3);
                e.a.a.f.s.a.f5662b.postValue(book3.getName());
                e.a.a.f.s.a.f5663c.postValue(book3.getDisplayCover());
                e.a.a.f.s.a.f5668h = book3.getDurChapterIndex();
                e.a.a.f.s.a.f5669i = book3.getDurChapterPos();
                e.a.a.f.s.a.f5666f = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(book3.getBookUrl(), e.a.a.f.s.a.f5668h);
                aVar3.h(book3);
                BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(book3.getOrigin());
                if (bookSource != null) {
                    e.a.a.f.s.a.f5670j = new WebBook(bookSource);
                }
                if (e.a.a.f.s.a.f5666f == null) {
                    if (book3.getTocUrl().length() == 0) {
                        Objects.requireNonNull(audioPlayViewModel);
                        BaseViewModel.a(audioPlayViewModel, null, null, new o(book3, audioPlayViewModel, null, null), 3, null);
                    } else {
                        Objects.requireNonNull(audioPlayViewModel);
                        BaseViewModel.a(audioPlayViewModel, null, null, new p(book3, null, audioPlayViewModel, null), 3, null);
                    }
                }
            }
            this.$this_apply.f();
        }
        return v.a;
    }
}
