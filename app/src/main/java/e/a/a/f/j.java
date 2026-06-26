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
@DebugMetadata(c = "io.legado.app.service.AudioPlayService$loadContent$1$1$3", f = "AudioPlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class j extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookChapter $chapter;
    public int label;
    public final /* synthetic */ AudioPlayService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(AudioPlayService audioPlayService, BookChapter bookChapter, f.z.d<? super j> dVar) {
        super(2, dVar);
        this.this$0 = audioPlayService;
        this.$chapter = bookChapter;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new j(this.this$0, this.$chapter, dVar);
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
        AudioPlayService audioPlayService = this.this$0;
        int index = this.$chapter.getIndex();
        boolean z = AudioPlayService.f6916b;
        audioPlayService.e(index);
        return v.a;
    }
}
