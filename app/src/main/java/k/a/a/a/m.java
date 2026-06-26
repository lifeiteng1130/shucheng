package k.a.a.a;

/* JADX INFO: compiled from: ConsoleErrorListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends e {
    public static final m a = new m();

    @Override // k.a.a.a.e, k.a.a.a.a
    public void syntaxError(b0<?, ?> b0Var, Object obj, int i2, int i3, String str, a0 a0Var) {
        System.err.println("line " + i2 + ":" + i3 + " " + str);
    }
}
