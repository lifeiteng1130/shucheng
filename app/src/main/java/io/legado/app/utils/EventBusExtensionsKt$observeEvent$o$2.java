package io.legado.app.utils;

import androidx.view.Observer;
import f.c0.b.l;
import f.v;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventBusExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n"}, d2 = {"EVENT", "kotlin.jvm.PlatformType", "it", "Lf/v;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class EventBusExtensionsKt$observeEvent$o$2<T> implements Observer {
    public final /* synthetic */ l<EVENT, v> a;

    /* JADX WARN: Multi-variable type inference failed */
    public EventBusExtensionsKt$observeEvent$o$2(l<? super EVENT, v> lVar) {
        this.a = lVar;
    }

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
    @Override // androidx.view.Observer
    public final void onChanged(EVENT event) {
        this.a.invoke(event);
    }
}
