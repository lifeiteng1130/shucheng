package k.a.a.a;

/* JADX INFO: compiled from: RecognitionException.java */
/* JADX INFO: loaded from: classes3.dex */
public class a0 extends RuntimeException {
    private final c0 ctx;
    private final q input;
    private int offendingState;
    private d0 offendingToken;
    private final b0<?, ?> recognizer;

    public a0(b0<?, ?> b0Var, q qVar, y yVar) {
        this.offendingState = -1;
        this.recognizer = b0Var;
        this.input = qVar;
        this.ctx = yVar;
        if (b0Var != null) {
            this.offendingState = b0Var.getState();
        }
    }

    public c0 getCtx() {
        return this.ctx;
    }

    public k.a.a.a.m0.i getExpectedTokens() {
        b0<?, ?> b0Var = this.recognizer;
        if (b0Var != null) {
            return b0Var.getATN().c(this.offendingState, this.ctx);
        }
        return null;
    }

    public q getInputStream() {
        return this.input;
    }

    public int getOffendingState() {
        return this.offendingState;
    }

    public d0 getOffendingToken() {
        return this.offendingToken;
    }

    public b0<?, ?> getRecognizer() {
        return this.recognizer;
    }

    public final void setOffendingState(int i2) {
        this.offendingState = i2;
    }

    public final void setOffendingToken(d0 d0Var) {
        this.offendingToken = d0Var;
    }

    public a0(String str, b0<?, ?> b0Var, q qVar, y yVar) {
        super(str);
        this.offendingState = -1;
        this.recognizer = b0Var;
        this.input = qVar;
        this.ctx = yVar;
        if (b0Var != null) {
            this.offendingState = b0Var.getState();
        }
    }
}
