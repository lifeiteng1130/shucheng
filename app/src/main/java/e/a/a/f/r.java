package e.a.a.f;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.BookSource;
import io.legado.app.service.CheckSourceService;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CheckSourceService.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.CheckSourceService$check$6", f = "CheckSourceService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class r extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookSource $source;
    public int label;
    public final /* synthetic */ CheckSourceService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(CheckSourceService checkSourceService, BookSource bookSource, f.z.d<? super r> dVar) {
        super(2, dVar);
        this.this$0 = checkSourceService;
        this.$source = bookSource;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new r(this.this$0, this.$source, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((r) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        CheckSourceService.b(this.this$0, this.$source.getBookSourceUrl(), this.$source.getBookSourceName());
        return v.a;
    }
}
