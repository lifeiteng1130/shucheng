package e.a.a.f;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.service.AudioPlayService;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlayService.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.AudioPlayService$saveProgress$1", f = "AudioPlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class l extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public int label;
    public final /* synthetic */ AudioPlayService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(AudioPlayService audioPlayService, f.z.d<? super l> dVar) {
        super(2, dVar);
        this.this$0 = audioPlayService;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new l(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((l) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        e.a.a.f.s.a aVar = e.a.a.f.s.a.a;
        Book book = e.a.a.f.s.a.f5665e;
        if (book == null) {
            return null;
        }
        e.a.a.f.s.a.f5669i = this.this$0.c();
        AppDatabaseKt.getAppDb().getBookDao().upProgress(book.getBookUrl(), e.a.a.f.s.a.f5669i);
        return v.a;
    }
}
