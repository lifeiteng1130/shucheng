package k.c.d;

/* JADX INFO: compiled from: Block.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends s {
    @Override // k.c.d.s
    public s c() {
        return (a) this.a;
    }

    @Override // k.c.d.s
    public void d(s sVar) {
        if (!(sVar instanceof a)) {
            throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
        }
        this.a = sVar;
    }
}
