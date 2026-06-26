package e.a.a.g.b;

import io.legado.app.ui.association.ImportRssSourceViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportRssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.association.ImportRssSourceViewModel", f = "ImportRssSourceViewModel.kt", i = {0}, l = {110}, m = "importSourceUrl", n = {"this"}, s = {"L$0"})
public final class g0 extends f.z.j.a.c {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ImportRssSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(ImportRssSourceViewModel importRssSourceViewModel, f.z.d<? super g0> dVar) {
        super(dVar);
        this.this$0 = importRssSourceViewModel;
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ImportRssSourceViewModel.e(this.this$0, null, this);
    }
}
