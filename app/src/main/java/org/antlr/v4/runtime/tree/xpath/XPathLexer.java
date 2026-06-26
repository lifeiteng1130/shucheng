package org.antlr.v4.runtime.tree.xpath;

import h.a.a.a.w;
import k.a.a.a.d0;
import k.a.a.a.g;
import k.a.a.a.h0;
import k.a.a.a.i0;
import k.a.a.a.j;
import k.a.a.a.k0.a;
import k.a.a.a.m0.h;
import k.a.a.a.s;
import k.a.a.a.t;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class XPathLexer extends s {
    public static final int ANYWHERE = 3;
    public static final int BANG = 6;
    public static final int ID = 7;
    public static final int ROOT = 4;
    public static final int RULE_REF = 2;
    public static final int STRING = 8;
    public static final int TOKEN_REF = 1;
    public static final h0 VOCABULARY;
    public static final int WILDCARD = 5;
    private static final String[] _LITERAL_NAMES;
    private static final String[] _SYMBOLIC_NAMES;
    public static String[] modeNames = {"DEFAULT_MODE"};
    public static final String[] ruleNames = {"ANYWHERE", Logger.ROOT_LOGGER_NAME, "WILDCARD", "BANG", "ID", "NameChar", "NameStartChar", "STRING"};

    @Deprecated
    public static final String[] tokenNames;
    public int charPositionInLine;
    public int line;

    static {
        String[] strArr = {null, null, null, "'//'", "'/'", "'*'", "'!'"};
        _LITERAL_NAMES = strArr;
        String[] strArr2 = {null, "TOKEN_REF", "RULE_REF", "ANYWHERE", Logger.ROOT_LOGGER_NAME, "WILDCARD", "BANG", "ID", "STRING"};
        _SYMBOLIC_NAMES = strArr2;
        VOCABULARY = new i0(strArr, strArr2, null);
        tokenNames = new String[strArr2.length];
        int i2 = 0;
        while (true) {
            String[] strArr3 = tokenNames;
            if (i2 >= strArr3.length) {
                return;
            }
            h0 h0Var = VOCABULARY;
            strArr3[i2] = ((i0) h0Var).b(i2);
            if (strArr3[i2] == null) {
                strArr3[i2] = ((i0) h0Var).c(i2);
            }
            if (strArr3[i2] == null) {
                strArr3[i2] = "<INVALID>";
            }
            i2++;
        }
    }

    public XPathLexer(g gVar) {
        super(gVar);
        this.line = 1;
        this.charPositionInLine = 0;
    }

    public void consume() {
        if (this._input.b(1) == 10) {
            this.line++;
            this.charPositionInLine = 0;
        } else {
            this.charPositionInLine++;
        }
        this._input.g();
    }

    @Override // k.a.a.a.b0
    public a getATN() {
        return null;
    }

    @Override // k.a.a.a.s, k.a.a.a.f0
    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }

    @Override // k.a.a.a.b0
    public String getGrammarFileName() {
        return "XPathLexer.g4";
    }

    @Override // k.a.a.a.s
    public String[] getModeNames() {
        return modeNames;
    }

    @Override // k.a.a.a.b0
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override // k.a.a.a.s, k.a.a.a.b0
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override // k.a.a.a.b0
    public h0 getVocabulary() {
        return VOCABULARY;
    }

    public boolean isNameChar(int i2) {
        return Character.isUnicodeIdentifierPart(i2);
    }

    public boolean isNameStartChar(int i2) {
        return Character.isUnicodeIdentifierStart(i2);
    }

    public String matchID() {
        int iIndex = this._input.index();
        consume();
        while (isNameChar(this._input.b(1))) {
            consume();
        }
        g gVar = this._input;
        return gVar.f(h.c(iIndex, gVar.index() - 1));
    }

    public String matchString() {
        int iIndex = this._input.index();
        consume();
        while (this._input.b(1) != 39) {
            consume();
        }
        consume();
        g gVar = this._input;
        return gVar.f(h.c(iIndex, gVar.index() - 1));
    }

    @Override // k.a.a.a.s, k.a.a.a.f0
    public d0 nextToken() {
        this._tokenStartCharIndex = this._input.index();
        j jVar = null;
        while (jVar == null) {
            int iB = this._input.b(1);
            if (iB == -1) {
                return new j(-1, "<EOF>");
            }
            if (iB == 33) {
                consume();
                jVar = new j(6, XPath.NOT);
            } else if (iB == 39) {
                jVar = new j(8, matchString());
            } else if (iB == 42) {
                consume();
                jVar = new j(5, "*");
            } else if (iB == 47) {
                consume();
                if (this._input.b(1) == 47) {
                    consume();
                    jVar = new j(3, "//");
                } else {
                    jVar = new j(4, w.DEFAULT_PATH_SEPARATOR);
                }
            } else {
                if (!isNameStartChar(this._input.b(1))) {
                    throw new t(this, this._input, this._tokenStartCharIndex, null);
                }
                String strMatchID = matchID();
                jVar = Character.isUpperCase(strMatchID.charAt(0)) ? new j(1, strMatchID) : new j(2, strMatchID);
            }
        }
        jVar.setStartIndex(this._tokenStartCharIndex);
        jVar.setCharPositionInLine(this._tokenStartCharIndex);
        jVar.setLine(this.line);
        return jVar;
    }
}
