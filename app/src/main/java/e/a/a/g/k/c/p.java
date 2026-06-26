package e.a.a.g.k.c;

import io.legado.app.ui.rss.read.ReadRssViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRssViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.read.ReadRssViewModel", f = "ReadRssViewModel.kt", i = {}, l = {150}, m = "webData2bitmap", n = {}, s = {})
public final class p extends f.z.j.a.c {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ReadRssViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(ReadRssViewModel readRssViewModel, f.z.d<? super p> dVar) {
        super(dVar);
        this.this$0 = readRssViewModel;
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReadRssViewModel.g(this.this$0, null, this);
    }
}
