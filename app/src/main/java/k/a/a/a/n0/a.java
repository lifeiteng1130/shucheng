package k.a.a.a.n0;

/* JADX INFO: compiled from: AbstractParseTreeVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> implements f<T> {
    public T aggregateResult(T t, T t2) {
        return t2;
    }

    public T defaultResult() {
        return null;
    }

    public boolean shouldVisitNextChild(g gVar, T t) {
        return true;
    }

    public T visit(d dVar) {
        return (T) dVar.accept(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k.a.a.a.n0.f
    public T visitChildren(g gVar) {
        T t = (T) defaultResult();
        int childCount = gVar.getChildCount();
        for (int i2 = 0; i2 < childCount && shouldVisitNextChild(gVar, t); i2++) {
            t = (T) aggregateResult(t, gVar.getChild(i2).accept(this));
        }
        return t;
    }

    @Override // k.a.a.a.n0.f
    public T visitErrorNode(b bVar) {
        return defaultResult();
    }

    @Override // k.a.a.a.n0.f
    public T visitTerminal(h hVar) {
        return defaultResult();
    }
}
