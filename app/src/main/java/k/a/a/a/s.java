package k.a.a.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/* JADX INFO: compiled from: Lexer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends b0<Integer, k.a.a.a.k0.c0> implements f0 {
    public static final int DEFAULT_MODE = 0;
    public static final int DEFAULT_TOKEN_CHANNEL = 0;
    public static final int HIDDEN = 1;
    public static final int MAX_CHAR_VALUE = 1114111;
    public static final int MIN_CHAR_VALUE = 0;
    public static final int MORE = -2;
    public static final int SKIP = -3;
    public int _channel;
    public boolean _hitEOF;
    public g _input;
    public String _text;
    public d0 _token;
    public k.a.a.a.m0.k<f0, g> _tokenFactorySourcePair;
    public int _tokenStartCharPositionInLine;
    public int _tokenStartLine;
    public int _type;
    public e0<?> _factory = k.a;
    public int _tokenStartCharIndex = -1;
    public final k.a.a.a.m0.g _modeStack = new k.a.a.a.m0.g();
    public int _mode = 0;

    public s() {
    }

    public void emit(d0 d0Var) {
        this._token = d0Var;
    }

    public d0 emitEOF() {
        int charPositionInLine = getCharPositionInLine();
        d0 d0VarA = ((k) this._factory).a(this._tokenFactorySourcePair, -1, null, 0, this._input.index(), this._input.index() - 1, getLine(), charPositionInLine);
        emit(d0VarA);
        return d0VarA;
    }

    public List<? extends d0> getAllTokens() {
        ArrayList arrayList = new ArrayList();
        d0 d0VarNextToken = nextToken();
        while (d0VarNextToken.getType() != -1) {
            arrayList.add(d0VarNextToken);
            d0VarNextToken = nextToken();
        }
        return arrayList;
    }

    public int getChannel() {
        return this._channel;
    }

    public String[] getChannelNames() {
        return null;
    }

    public String getCharErrorDisplay(int i2) {
        return c.a.a.a.a.k("'", getErrorDisplay(i2), "'");
    }

    public int getCharIndex() {
        return this._input.index();
    }

    @Override // k.a.a.a.f0
    public int getCharPositionInLine() {
        return getInterpreter().f8401h;
    }

    public String getErrorDisplay(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c2 : str.toCharArray()) {
            sb.append(getErrorDisplay(c2));
        }
        return sb.toString();
    }

    @Override // k.a.a.a.f0
    public int getLine() {
        return getInterpreter().f8400g;
    }

    public String[] getModeNames() {
        return null;
    }

    @Override // k.a.a.a.f0
    public String getSourceName() {
        return this._input.getSourceName();
    }

    public String getText() {
        String str = this._text;
        if (str != null) {
            return str;
        }
        k.a.a.a.k0.c0 interpreter = getInterpreter();
        return this._input.f(k.a.a.a.m0.h.c(interpreter.f8399f, r1.index() - 1));
    }

    public d0 getToken() {
        return this._token;
    }

    @Override // k.a.a.a.b0, k.a.a.a.f0
    public e0<? extends d0> getTokenFactory() {
        return this._factory;
    }

    @Override // k.a.a.a.b0
    @Deprecated
    public String[] getTokenNames() {
        return null;
    }

    public int getType() {
        return this._type;
    }

    public void mode(int i2) {
        this._mode = i2;
    }

    public void more() {
        this._type = -2;
    }

    @Override // k.a.a.a.f0
    public d0 nextToken() {
        d0 d0Var;
        int iG;
        int i2;
        g gVar = this._input;
        if (gVar == null) {
            throw new IllegalStateException("nextToken requires a non-null input stream.");
        }
        int iD = gVar.d();
        while (true) {
            try {
                if (this._hitEOF) {
                    emitEOF();
                    d0Var = this._token;
                    break;
                }
                this._token = null;
                this._channel = 0;
                this._tokenStartCharIndex = this._input.index();
                this._tokenStartCharPositionInLine = getInterpreter().f8401h;
                this._tokenStartLine = getInterpreter().f8400g;
                this._text = null;
                do {
                    this._type = 0;
                    try {
                        iG = getInterpreter().g(this._input, this._mode);
                    } catch (t e2) {
                        notifyListeners(e2);
                        recover(e2);
                        iG = -3;
                    }
                    if (this._input.b(1) == -1) {
                        this._hitEOF = true;
                    }
                    if (this._type == 0) {
                        this._type = iG;
                    }
                    i2 = this._type;
                    if (i2 == -3) {
                        break;
                    }
                } while (i2 == -2);
                if (this._token == null) {
                    emit();
                }
                d0Var = this._token;
            } finally {
                this._input.h(iD);
            }
        }
        return d0Var;
    }

    public void notifyListeners(t tVar) {
        g gVar = this._input;
        String strF = gVar.f(k.a.a.a.m0.h.c(this._tokenStartCharIndex, gVar.index()));
        StringBuilder sbR = c.a.a.a.a.r("token recognition error at: '");
        sbR.append(getErrorDisplay(strF));
        sbR.append("'");
        getErrorListenerDispatch().syntaxError(this, null, this._tokenStartLine, this._tokenStartCharPositionInLine, sbR.toString(), tVar);
    }

    public int popMode() {
        k.a.a.a.m0.g gVar = this._modeStack;
        if (gVar.f8509c == 0) {
            throw new EmptyStackException();
        }
        mode(gVar.a());
        return this._mode;
    }

    public void pushMode(int i2) {
        this._modeStack.b(this._mode);
        mode(i2);
    }

    public void recover(t tVar) {
        if (this._input.b(1) != -1) {
            getInterpreter().e(this._input);
        }
    }

    public void reset() {
        g gVar = this._input;
        if (gVar != null) {
            gVar.a(0);
        }
        this._token = null;
        this._type = 0;
        this._channel = 0;
        this._tokenStartCharIndex = -1;
        this._tokenStartCharPositionInLine = -1;
        this._tokenStartLine = -1;
        this._text = null;
        this._hitEOF = false;
        this._mode = 0;
        k.a.a.a.m0.g gVar2 = this._modeStack;
        Arrays.fill(gVar2.f8508b, 0, gVar2.f8509c, 0);
        gVar2.f8509c = 0;
        getInterpreter().a();
    }

    public void setChannel(int i2) {
        this._channel = i2;
    }

    public void setCharPositionInLine(int i2) {
        getInterpreter().f8401h = i2;
    }

    @Override // k.a.a.a.b0
    public void setInputStream(q qVar) {
        this._input = null;
        this._tokenFactorySourcePair = new k.a.a.a.m0.k<>(this, null);
        reset();
        g gVar = (g) qVar;
        this._input = gVar;
        this._tokenFactorySourcePair = new k.a.a.a.m0.k<>(this, gVar);
    }

    public void setLine(int i2) {
        getInterpreter().f8400g = i2;
    }

    public void setText(String str) {
        this._text = str;
    }

    public void setToken(d0 d0Var) {
        this._token = d0Var;
    }

    @Override // k.a.a.a.b0, k.a.a.a.f0
    public void setTokenFactory(e0<?> e0Var) {
        this._factory = e0Var;
    }

    public void setType(int i2) {
        this._type = i2;
    }

    public void skip() {
        this._type = -3;
    }

    public d0 emit() {
        d0 d0VarA = ((k) this._factory).a(this._tokenFactorySourcePair, this._type, this._text, this._channel, this._tokenStartCharIndex, getCharIndex() - 1, this._tokenStartLine, this._tokenStartCharPositionInLine);
        emit(d0VarA);
        return d0VarA;
    }

    @Override // k.a.a.a.b0, k.a.a.a.f0
    public g getInputStream() {
        return this._input;
    }

    public void recover(a0 a0Var) {
        this._input.g();
    }

    public String getErrorDisplay(int i2) {
        return i2 != -1 ? i2 != 13 ? i2 != 9 ? i2 != 10 ? String.valueOf((char) i2) : "\\n" : "\\t" : "\\r" : "<EOF>";
    }

    public s(g gVar) {
        this._input = gVar;
        this._tokenFactorySourcePair = new k.a.a.a.m0.k<>(this, gVar);
    }
}
