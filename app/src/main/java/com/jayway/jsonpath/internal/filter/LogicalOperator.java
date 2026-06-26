package com.jayway.jsonpath.internal.filter;

import c.a.a.a.a;
import com.jayway.jsonpath.InvalidPathException;
import org.antlr.v4.runtime.tree.xpath.XPath;

/* JADX INFO: loaded from: classes.dex */
public enum LogicalOperator {
    AND("&&"),
    NOT(XPath.NOT),
    OR("||");

    private final String operatorString;

    LogicalOperator(String str) {
        this.operatorString = str;
    }

    public static LogicalOperator fromString(String str) {
        LogicalOperator logicalOperator = AND;
        if (logicalOperator.operatorString.equals(str)) {
            return logicalOperator;
        }
        LogicalOperator logicalOperator2 = NOT;
        if (logicalOperator2.operatorString.equals(str)) {
            return logicalOperator2;
        }
        LogicalOperator logicalOperator3 = OR;
        if (logicalOperator3.operatorString.equals(str)) {
            return logicalOperator3;
        }
        throw new InvalidPathException(a.i("Failed to parse operator ", str));
    }

    public String getOperatorString() {
        return this.operatorString;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.operatorString;
    }
}
