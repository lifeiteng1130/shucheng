package e.a.a.g.k.d.c;

import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import io.legado.app.data.entities.RssSource;
import io.legado.app.ui.rss.source.manage.RssSourceViewModel;
import io.legado.app.utils.FileUtils;
import java.io.File;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$shareSelection$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class e0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super Intent>, Object> {
    public final /* synthetic */ List<RssSource> $sources;
    public int label;
    public final /* synthetic */ RssSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(RssSourceViewModel rssSourceViewModel, List<RssSource> list, f.z.d<? super e0> dVar) {
        super(2, dVar);
        this.this$0 = rssSourceViewModel;
        this.$sources = list;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new e0(this.this$0, this.$sources, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super Intent> dVar) {
        return ((e0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String str = this.this$0.b().getFilesDir() + "/shareRssSource.json";
        FileUtils fileUtils = FileUtils.a;
        FileUtils.g(fileUtils, str, false, 2);
        Intent intent = new Intent("android.intent.action.SEND");
        File fileC = fileUtils.c(str);
        String json = e.a.a.h.n.a().toJson(this.$sources);
        f.c0.c.j.d(json, "GSON.toJson(sources)");
        f.b0.d.f(fileC, json, null, 2);
        Uri uriForFile = FileProvider.getUriForFile(this.this$0.b(), "io.wenyuange.app.release.fileProvider", fileC);
        intent.setType("text/*");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.setFlags(1);
        intent.addFlags(268435456);
        return intent;
    }
}
