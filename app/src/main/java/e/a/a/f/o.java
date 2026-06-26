package e.a.a.f;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.BookSource;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: CheckSourceService.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.CheckSourceService$check$3", f = "CheckSourceService.kt", i = {0, 0, 3}, l = {110, 123, Token.CATCH, 126, 127}, m = "invokeSuspend", n = {"$this$execute", "webBook", "book"}, s = {"L$0", "L$1", "L$2"})
public final class o extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookSource $source;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(BookSource bookSource, f.z.d<? super o> dVar) {
        super(2, dVar);
        this.$source = bookSource;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        o oVar = new o(this.$source, dVar);
        oVar.L$0 = obj;
        return oVar;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((o) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0116 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0157  */
    @Override // f.z.j.a.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r19) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.f.o.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
