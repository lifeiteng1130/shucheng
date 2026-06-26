package e.a.a.g.d.g;

import io.legado.app.data.AppDatabaseKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$loadGroup$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class i0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super String>, Object> {
    public final /* synthetic */ long $groupId;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(long j2, f.z.d<? super i0> dVar) {
        super(2, dVar);
        this.$groupId = j2;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new i0(this.$groupId, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super String> dVar) {
        return ((i0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        return f.x.e.q(AppDatabaseKt.getAppDb().getBookGroupDao().getGroupNames(this.$groupId), ",", null, null, 0, null, null, 62);
    }
}
