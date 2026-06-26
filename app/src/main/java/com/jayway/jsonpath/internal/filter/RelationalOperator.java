package com.jayway.jsonpath.internal.filter;

import c.a.a.a.a;
import com.jayway.jsonpath.InvalidPathException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public enum RelationalOperator {
    GTE(">="),
    LTE("<="),
    EQ("=="),
    TSEQ("==="),
    NE("!="),
    TSNE("!=="),
    LT("<"),
    GT(">"),
    REGEX("=~"),
    NIN("NIN"),
    IN("IN"),
    CONTAINS("CONTAINS"),
    ALL("ALL"),
    SIZE("SIZE"),
    EXISTS("EXISTS"),
    TYPE("TYPE"),
    MATCHES("MATCHES"),
    EMPTY("EMPTY"),
    SUBSETOF("SUBSETOF"),
    ANYOF("ANYOF"),
    NONEOF("NONEOF");

    private final String operatorString;

    RelationalOperator(String str) {
        this.operatorString = str;
    }

    public static RelationalOperator fromString(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        RelationalOperator[] relationalOperatorArrValues = values();
        for (int i2 = 0; i2 < 21; i2++) {
            RelationalOperator relationalOperator = relationalOperatorArrValues[i2];
            if (relationalOperator.operatorString.equals(upperCase)) {
                return relationalOperator;
            }
        }
        throw new InvalidPathException(a.k("Filter operator ", str, " is not supported!"));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.operatorString;
    }
}
