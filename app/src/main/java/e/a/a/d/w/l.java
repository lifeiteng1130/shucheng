package e.a.a.d.w;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookWebDav.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.help.storage.BookWebDav", f = "BookWebDav.kt", i = {}, l = {95, 98, 99}, m = "restoreWebDav", n = {}, s = {})
public final class l extends f.z.j.a.c {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j jVar, f.z.d<? super l> dVar) {
        super(dVar);
        this.this$0 = jVar;
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return j.b(this.this$0, null, this);
    }
}
