package com.jayway.jsonpath.internal.filter;

import c.a.a.a.a;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.internal.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LogicalExpressionNode extends ExpressionNode {
    public List<ExpressionNode> chain;
    private final LogicalOperator operator;

    private LogicalExpressionNode(ExpressionNode expressionNode, LogicalOperator logicalOperator, ExpressionNode expressionNode2) {
        ArrayList arrayList = new ArrayList();
        this.chain = arrayList;
        arrayList.add(expressionNode);
        this.chain.add(expressionNode2);
        this.operator = logicalOperator;
    }

    public static LogicalExpressionNode createLogicalAnd(ExpressionNode expressionNode, ExpressionNode expressionNode2) {
        return new LogicalExpressionNode(expressionNode, LogicalOperator.AND, expressionNode2);
    }

    public static ExpressionNode createLogicalNot(ExpressionNode expressionNode) {
        return new LogicalExpressionNode(expressionNode, LogicalOperator.NOT, null);
    }

    public static LogicalExpressionNode createLogicalOr(ExpressionNode expressionNode, ExpressionNode expressionNode2) {
        return new LogicalExpressionNode(expressionNode, LogicalOperator.OR, expressionNode2);
    }

    public LogicalExpressionNode and(LogicalExpressionNode logicalExpressionNode) {
        return createLogicalAnd(this, logicalExpressionNode);
    }

    public LogicalExpressionNode append(ExpressionNode expressionNode) {
        this.chain.add(0, expressionNode);
        return this;
    }

    @Override // com.jayway.jsonpath.Predicate
    public boolean apply(Predicate.PredicateContext predicateContext) {
        LogicalOperator logicalOperator = this.operator;
        if (logicalOperator == LogicalOperator.OR) {
            Iterator<ExpressionNode> it = this.chain.iterator();
            while (it.hasNext()) {
                if (it.next().apply(predicateContext)) {
                    return true;
                }
            }
            return false;
        }
        if (logicalOperator != LogicalOperator.AND) {
            return !this.chain.get(0).apply(predicateContext);
        }
        Iterator<ExpressionNode> it2 = this.chain.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(predicateContext)) {
                return false;
            }
        }
        return true;
    }

    public LogicalOperator getOperator() {
        return this.operator;
    }

    public LogicalExpressionNode or(LogicalExpressionNode logicalExpressionNode) {
        return createLogicalOr(this, logicalExpressionNode);
    }

    public String toString() {
        StringBuilder sbR = a.r("(");
        StringBuilder sbR2 = a.r(" ");
        sbR2.append(this.operator.getOperatorString());
        sbR2.append(" ");
        sbR.append(Utils.join(sbR2.toString(), this.chain));
        sbR.append(")");
        return sbR.toString();
    }

    public static LogicalExpressionNode createLogicalAnd(Collection<ExpressionNode> collection) {
        return new LogicalExpressionNode(LogicalOperator.AND, collection);
    }

    public static LogicalExpressionNode createLogicalOr(Collection<ExpressionNode> collection) {
        return new LogicalExpressionNode(LogicalOperator.OR, collection);
    }

    private LogicalExpressionNode(LogicalOperator logicalOperator, Collection<ExpressionNode> collection) {
        ArrayList arrayList = new ArrayList();
        this.chain = arrayList;
        arrayList.addAll(collection);
        this.operator = logicalOperator;
    }
}
