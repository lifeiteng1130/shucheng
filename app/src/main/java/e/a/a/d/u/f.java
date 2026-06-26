package e.a.a.d.u;

import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Coroutine.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.help.coroutine.Coroutine$executeInternal$1", f = "Coroutine.kt", i = {0, 1, 7, 8}, l = {221, 223, 228, 231, 233, 239, 241, 248, 250, 257, 259, 265, 267, 265, 267}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "e", "e"}, s = {"L$0", "L$0", "L$1", "L$1"})
public final class f extends g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ p<a0, f.z.d<? super T>, Object> $block;
    public final /* synthetic */ f.z.f $context;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;
    public final /* synthetic */ b<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f(b<T> bVar, f.z.f fVar, p<? super a0, ? super f.z.d<? super T>, ? extends Object> pVar, f.z.d<? super f> dVar) {
        super(2, dVar);
        this.this$0 = bVar;
        this.$context = fVar;
        this.$block = pVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        f fVar = new f(this.this$0, this.$context, this.$block, dVar);
        fVar.L$0 = obj;
        return fVar;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((f) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ac A[Catch: all -> 0x0147, TryCatch #3 {all -> 0x0147, blocks: (B:24:0x004f, B:27:0x0058, B:51:0x00cb, B:53:0x00d1, B:56:0x00d8, B:59:0x00df, B:61:0x00e3, B:64:0x00f1, B:30:0x0060, B:44:0x009f, B:48:0x00b0, B:47:0x00ac, B:33:0x006c, B:36:0x0073, B:38:0x0077, B:41:0x0084), top: B:139:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d1 A[Catch: all -> 0x0147, TryCatch #3 {all -> 0x0147, blocks: (B:24:0x004f, B:27:0x0058, B:51:0x00cb, B:53:0x00d1, B:56:0x00d8, B:59:0x00df, B:61:0x00e3, B:64:0x00f1, B:30:0x0060, B:44:0x009f, B:48:0x00b0, B:47:0x00ac, B:33:0x006c, B:36:0x0073, B:38:0x0077, B:41:0x0084), top: B:139:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e3 A[Catch: all -> 0x0147, TryCatch #3 {all -> 0x0147, blocks: (B:24:0x004f, B:27:0x0058, B:51:0x00cb, B:53:0x00d1, B:56:0x00d8, B:59:0x00df, B:61:0x00e3, B:64:0x00f1, B:30:0x0060, B:44:0x009f, B:48:0x00b0, B:47:0x00ac, B:33:0x006c, B:36:0x0073, B:38:0x0077, B:41:0x0084), top: B:139:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f1 A[Catch: all -> 0x0147, TRY_LEAVE, TryCatch #3 {all -> 0x0147, blocks: (B:24:0x004f, B:27:0x0058, B:51:0x00cb, B:53:0x00d1, B:56:0x00d8, B:59:0x00df, B:61:0x00e3, B:64:0x00f1, B:30:0x0060, B:44:0x009f, B:48:0x00b0, B:47:0x00ac, B:33:0x006c, B:36:0x0073, B:38:0x0077, B:41:0x0084), top: B:139:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012c  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [g.b.a0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15, types: [g.b.a0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r5v1, types: [g.b.a0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v16, types: [g.b.a0] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // f.z.j.a.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.u.f.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
