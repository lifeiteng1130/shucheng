package e.a.a.f;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.service.AudioPlayService;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlayService.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.AudioPlayService$loadContent$1$1$2", f = "AudioPlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class i extends f.z.j.a.g implements f.c0.b.q<a0, Throwable, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookChapter $chapter;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;
    public final /* synthetic */ AudioPlayService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(AudioPlayService audioPlayService, BookChapter bookChapter, f.z.d<? super i> dVar) {
        super(3, dVar);
        this.this$0 = audioPlayService;
        this.$chapter = bookChapter;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
        i iVar = new i(this.this$0, this.$chapter, dVar);
        iVar.L$0 = a0Var;
        iVar.L$1 = th;
        return iVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        a0 a0Var = (a0) this.L$0;
        Throwable th = (Throwable) this.L$1;
        AudioPlayService audioPlayService = this.this$0;
        BookChapter bookChapter = this.$chapter;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = a0Var.toString();
        }
        AudioPlayService.b(audioPlayService, bookChapter, localizedMessage);
        return v.a;
    }
}
