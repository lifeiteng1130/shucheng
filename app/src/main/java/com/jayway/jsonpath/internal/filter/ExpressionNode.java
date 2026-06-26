package com.jayway.jsonpath.internal.filter;

import com.jayway.jsonpath.Predicate;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExpressionNode implements Predicate {
    public static ExpressionNode createExpressionNode(ExpressionNode expressionNode, LogicalOperator logicalOperator, ExpressionNode expressionNode2) {
        LogicalOperator logicalOperator2 = LogicalOperator.AND;
        if (logicalOperator == logicalOperator2) {
            if (expressionNode instanceof LogicalExpressionNode) {
                LogicalExpressionNode logicalExpressionNode = (LogicalExpressionNode) expressionNode;
                if (logicalExpressionNode.getOperator() == logicalOperator2) {
                    return logicalExpressionNode.append(expressionNode2);
                }
            }
            return LogicalExpressionNode.createLogicalAnd(expressionNode2, expressionNode);
        }
        if (expressionNode instanceof LogicalExpressionNode) {
            LogicalExpressionNode logicalExpressionNode2 = (LogicalExpressionNode) expressionNode;
            if (logicalExpressionNode2.getOperator() == LogicalOperator.OR) {
                return logicalExpressionNode2.append(expressionNode2);
            }
        }
        return LogicalExpressionNode.createLogicalOr(expressionNode2, expressionNode);
    }
}
