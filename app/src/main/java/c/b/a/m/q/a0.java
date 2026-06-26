package c.b.a.m.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.q.g;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;

/* JADX INFO: compiled from: SourceGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class a0 implements DataFetcher.DataCallback<Object> {
    public final /* synthetic */ ModelLoader.LoadData a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f319b;

    public a0(b0 b0Var, ModelLoader.LoadData loadData) {
        this.f319b = b0Var;
        this.a = loadData;
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
    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(@Nullable Object obj) {
        b0 b0Var = this.f319b;
        ModelLoader.LoadData<?> loadData = this.a;
        ModelLoader.LoadData<?> loadData2 = b0Var.f324f;
        if (loadData2 != null && loadData2 == loadData) {
            b0 b0Var2 = this.f319b;
            ModelLoader.LoadData loadData3 = this.a;
            k kVar = b0Var2.a.p;
            if (obj != null && kVar.c(loadData3.fetcher.getDataSource())) {
                b0Var2.f323e = obj;
                b0Var2.f320b.c();
            } else {
                g.a aVar = b0Var2.f320b;
                c.b.a.m.j jVar = loadData3.sourceKey;
                DataFetcher<Data> dataFetcher = loadData3.fetcher;
                aVar.d(jVar, obj, dataFetcher, dataFetcher.getDataSource(), b0Var2.f325g);
            }
        }
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
    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        b0 b0Var = this.f319b;
        ModelLoader.LoadData<?> loadData = this.a;
        ModelLoader.LoadData<?> loadData2 = b0Var.f324f;
        if (loadData2 != null && loadData2 == loadData) {
            b0 b0Var2 = this.f319b;
            ModelLoader.LoadData loadData3 = this.a;
            g.a aVar = b0Var2.f320b;
            c.b.a.m.j jVar = b0Var2.f325g;
            DataFetcher<Data> dataFetcher = loadData3.fetcher;
            aVar.a(jVar, exc, dataFetcher, dataFetcher.getDataSource());
        }
    }
}
