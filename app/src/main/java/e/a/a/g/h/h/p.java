package e.a.a.g.h.h;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.BookSource;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExploreAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.explore.ExploreAdapter$convert$1$1", f = "ExploreAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class p extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super ArrayList<BookSource.ExploreKind>>, Object> {
    public final /* synthetic */ BookSource $item;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(BookSource bookSource, f.z.d<? super p> dVar) {
        super(2, dVar);
        this.$item = bookSource;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new p(this.$item, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super ArrayList<BookSource.ExploreKind>> dVar) {
        return ((p) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        return this.$item.getExploreKinds();
    }
}
