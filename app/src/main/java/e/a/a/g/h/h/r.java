package e.a.a.g.h.h;

import f.v;
import g.b.a0;
import io.legado.app.databinding.ItemFindBookBinding;
import io.legado.app.ui.main.explore.ExploreAdapter;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExploreAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.explore.ExploreAdapter$convert$1$3", f = "ExploreAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class r extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ ItemFindBookBinding $this_with;
    public int label;
    public final /* synthetic */ ExploreAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(ItemFindBookBinding itemFindBookBinding, ExploreAdapter exploreAdapter, f.z.d<? super r> dVar) {
        super(2, dVar);
        this.$this_with = itemFindBookBinding;
        this.this$0 = exploreAdapter;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new r(this.$this_with, this.this$0, dVar);
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
        this.$this_with.f6788e.a();
        ExploreAdapter exploreAdapter = this.this$0;
        int i2 = exploreAdapter.scrollTo;
        if (i2 >= 0) {
            exploreAdapter.callBack.a(i2);
            this.this$0.scrollTo = -1;
        }
        return v.a;
    }
}
