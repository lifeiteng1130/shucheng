package e.a.a.f;

import f.v;
import g.b.a0;
import io.legado.app.service.AudioPlayService;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlayService.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.AudioPlayService$play$2$1", f = "AudioPlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class k extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Throwable $it;
    public int label;
    public final /* synthetic */ AudioPlayService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(AudioPlayService audioPlayService, Throwable th, f.z.d<? super k> dVar) {
        super(2, dVar);
        this.this$0 = audioPlayService;
        this.$it = th;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new k(this.this$0, this.$it, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((k) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        c.b.a.m.f.R5(this.this$0, this.this$0.url + ' ' + ((Object) this.$it.getLocalizedMessage()));
        this.this$0.stopSelf();
        return v.a;
    }
}
