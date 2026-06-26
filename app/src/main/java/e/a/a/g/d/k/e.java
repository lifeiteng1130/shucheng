package e.a.a.g.d.k;

import com.tencent.bugly.beta.tinker.TinkerReport;
import io.legado.app.ui.book.searchContent.SearchContentActivity;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchContentActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.searchContent.SearchContentActivity", f = "SearchContentActivity.kt", i = {0, 0}, l = {TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT}, m = "searchChapter", n = {"searchResults", "bookContent"}, s = {"L$3", "L$7"})
public final class e extends f.z.j.a.c {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public Object L$7;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SearchContentActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SearchContentActivity searchContentActivity, f.z.d<? super e> dVar) {
        super(dVar);
        this.this$0 = searchContentActivity;
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SearchContentActivity.T0(this.this$0, null, null, this);
    }
}
