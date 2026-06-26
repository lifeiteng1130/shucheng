package e.a.a.g.d.b;

import io.legado.app.ui.book.cache.CacheViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.cache.CacheViewModel", f = "CacheViewModel.kt", i = {}, l = {94}, m = "export", n = {}, s = {})
public final class o extends f.z.j.a.c {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CacheViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(CacheViewModel cacheViewModel, f.z.d<? super o> dVar) {
        super(dVar);
        this.this$0 = cacheViewModel;
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CacheViewModel.f(this.this$0, null, null, this);
    }
}
