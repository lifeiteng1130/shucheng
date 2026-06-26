package e.a.a.d.w;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookWebDav.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.help.storage.BookWebDav", f = "BookWebDav.kt", i = {0, 1}, l = {57, 58}, m = "getWebDavFileNames", n = {"names", "names"}, s = {"L$1", "L$0"})
public final class k extends f.z.j.a.c {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, f.z.d<? super k> dVar) {
        super(dVar);
        this.this$0 = jVar;
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return j.a(this.this$0, this);
    }
}
