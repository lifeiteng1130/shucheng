package com.jayway.jsonpath.internal.filter;

import com.jayway.jsonpath.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class RelationalExpressionNode extends ExpressionNode {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) RelationalExpressionNode.class);
    private final ValueNode left;
    private final RelationalOperator relationalOperator;
    private final ValueNode right;

    public RelationalExpressionNode(ValueNode valueNode, RelationalOperator relationalOperator, ValueNode valueNode2) {
        this.left = valueNode;
        this.relationalOperator = relationalOperator;
        this.right = valueNode2;
        logger.trace("ExpressionNode {}", toString());
    }

    @Override // com.jayway.jsonpath.Predicate
    public boolean apply(Predicate.PredicateContext predicateContext) {
        ValueNode valueNodeEvaluate = this.left;
        ValueNode valueNodeEvaluate2 = this.right;
        if (valueNodeEvaluate.isPathNode()) {
            valueNodeEvaluate = this.left.asPathNode().evaluate(predicateContext);
        }
        if (this.right.isPathNode()) {
            valueNodeEvaluate2 = this.right.asPathNode().evaluate(predicateContext);
        }
        Evaluator evaluatorCreateEvaluator = EvaluatorFactory.createEvaluator(this.relationalOperator);
        if (evaluatorCreateEvaluator != null) {
            return evaluatorCreateEvaluator.evaluate(valueNodeEvaluate, valueNodeEvaluate2, predicateContext);
        }
        return false;
    }

    public String toString() {
        if (this.relationalOperator == RelationalOperator.EXISTS) {
            return this.left.toString();
        }
        return this.left.toString() + " " + this.relationalOperator.toString() + " " + this.right.toString();
    }
}
