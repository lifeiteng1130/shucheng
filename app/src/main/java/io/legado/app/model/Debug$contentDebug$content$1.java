package io.legado.app.model;

import c.b.a.m.f;
import f.c0.b.q;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Debug.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lg/b/a0;", "", "it", "Lf/v;", "<anonymous>", "(Lg/b/a0;Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "io.legado.app.model.Debug$contentDebug$content$1", f = "Debug.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Debug$contentDebug$content$1 extends g implements q<a0, String, d<? super v>, Object> {
    public int label;

    public Debug$contentDebug$content$1(d<? super Debug$contentDebug$content$1> dVar) {
        super(3, dVar);
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull String str, @Nullable d<? super v> dVar) {
        return new Debug$contentDebug$content$1(dVar).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        f.E5(obj);
        Debug.log$default(Debug.INSTANCE, Debug.debugSource, "︽正文页解析完成", false, false, false, 1000, 28, null);
        return v.a;
    }
}
