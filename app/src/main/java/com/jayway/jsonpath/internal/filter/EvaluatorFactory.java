package com.jayway.jsonpath.internal.filter;

import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.internal.filter.ValueNodes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class EvaluatorFactory {
    private static final Map<RelationalOperator, Evaluator> evaluators;

    public static class AllEvaluator implements Evaluator {
        private AllEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            ValueNodes.ValueListNode valueListNodeAsValueListNode = valueNode2.asValueListNode();
            if (!valueNode.isJsonNode()) {
                return false;
            }
            ValueNode valueNodeAsValueListNode = valueNode.asJsonNode().asValueListNode(predicateContext);
            if (!valueNodeAsValueListNode.isValueListNode()) {
                return true;
            }
            ValueNodes.ValueListNode valueListNodeAsValueListNode2 = valueNodeAsValueListNode.asValueListNode();
            Iterator<ValueNode> it = valueListNodeAsValueListNode.iterator();
            while (it.hasNext()) {
                if (!valueListNodeAsValueListNode2.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class AnyOfEvaluator implements Evaluator {
        private AnyOfEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            ValueNodes.ValueListNode valueListNodeAsValueListNode;
            ValueNodes.ValueListNode valueListNodeAsValueListNode2;
            if (valueNode2.isJsonNode()) {
                ValueNode valueNodeAsValueListNode = valueNode2.asJsonNode().asValueListNode(predicateContext);
                if (valueNodeAsValueListNode.isUndefinedNode()) {
                    return false;
                }
                valueListNodeAsValueListNode = valueNodeAsValueListNode.asValueListNode();
            } else {
                valueListNodeAsValueListNode = valueNode2.asValueListNode();
            }
            if (valueNode.isJsonNode()) {
                ValueNode valueNodeAsValueListNode2 = valueNode.asJsonNode().asValueListNode(predicateContext);
                if (valueNodeAsValueListNode2.isUndefinedNode()) {
                    return false;
                }
                valueListNodeAsValueListNode2 = valueNodeAsValueListNode2.asValueListNode();
            } else {
                valueListNodeAsValueListNode2 = valueNode.asValueListNode();
            }
            for (ValueNode valueNode3 : valueListNodeAsValueListNode2) {
                Iterator<ValueNode> it = valueListNodeAsValueListNode.iterator();
                while (it.hasNext()) {
                    if (valueNode3.equals(it.next())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class ContainsEvaluator implements Evaluator {
        private ContainsEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            if (valueNode.isStringNode() && valueNode2.isStringNode()) {
                return valueNode.asStringNode().contains(valueNode2.asStringNode().getString());
            }
            if (!valueNode.isJsonNode()) {
                return false;
            }
            ValueNode valueNodeAsValueListNode = valueNode.asJsonNode().asValueListNode(predicateContext);
            if (valueNodeAsValueListNode.isUndefinedNode()) {
                return false;
            }
            return valueNodeAsValueListNode.asValueListNode().contains(valueNode2);
        }
    }

    public static class EmptyEvaluator implements Evaluator {
        private EmptyEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return valueNode.isStringNode() ? valueNode.asStringNode().isEmpty() == valueNode2.asBooleanNode().getBoolean() : valueNode.isJsonNode() && valueNode.asJsonNode().isEmpty(predicateContext) == valueNode2.asBooleanNode().getBoolean();
        }
    }

    public static class EqualsEvaluator implements Evaluator {
        private EqualsEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return (valueNode.isJsonNode() && valueNode2.isJsonNode()) ? valueNode.asJsonNode().equals(valueNode2.asJsonNode(), predicateContext) : valueNode.equals(valueNode2);
        }
    }

    public static class ExistsEvaluator implements Evaluator {
        private ExistsEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            if (valueNode.isBooleanNode() || valueNode2.isBooleanNode()) {
                return valueNode.asBooleanNode().getBoolean() == valueNode2.asBooleanNode().getBoolean();
            }
            throw new JsonPathException("Failed to evaluate exists expression");
        }
    }

    public static class GreaterThanEqualsEvaluator implements Evaluator {
        private GreaterThanEqualsEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return (valueNode.isNumberNode() && valueNode2.isNumberNode()) ? valueNode.asNumberNode().getNumber().compareTo(valueNode2.asNumberNode().getNumber()) >= 0 : valueNode.isStringNode() && valueNode2.isStringNode() && valueNode.asStringNode().getString().compareTo(valueNode2.asStringNode().getString()) >= 0;
        }
    }

    public static class GreaterThanEvaluator implements Evaluator {
        private GreaterThanEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return (valueNode.isNumberNode() && valueNode2.isNumberNode()) ? valueNode.asNumberNode().getNumber().compareTo(valueNode2.asNumberNode().getNumber()) > 0 : valueNode.isStringNode() && valueNode2.isStringNode() && valueNode.asStringNode().getString().compareTo(valueNode2.asStringNode().getString()) > 0;
        }
    }

    public static class InEvaluator implements Evaluator {
        private InEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            ValueNodes.ValueListNode valueListNodeAsValueListNode;
            if (valueNode2.isJsonNode()) {
                ValueNode valueNodeAsValueListNode = valueNode2.asJsonNode().asValueListNode(predicateContext);
                if (valueNodeAsValueListNode.isUndefinedNode()) {
                    return false;
                }
                valueListNodeAsValueListNode = valueNodeAsValueListNode.asValueListNode();
            } else {
                valueListNodeAsValueListNode = valueNode2.asValueListNode();
            }
            return valueListNodeAsValueListNode.contains(valueNode);
        }
    }

    public static class LessThanEqualsEvaluator implements Evaluator {
        private LessThanEqualsEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return (valueNode.isNumberNode() && valueNode2.isNumberNode()) ? valueNode.asNumberNode().getNumber().compareTo(valueNode2.asNumberNode().getNumber()) <= 0 : valueNode.isStringNode() && valueNode2.isStringNode() && valueNode.asStringNode().getString().compareTo(valueNode2.asStringNode().getString()) <= 0;
        }
    }

    public static class LessThanEvaluator implements Evaluator {
        private LessThanEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return (valueNode.isNumberNode() && valueNode2.isNumberNode()) ? valueNode.asNumberNode().getNumber().compareTo(valueNode2.asNumberNode().getNumber()) < 0 : valueNode.isStringNode() && valueNode2.isStringNode() && valueNode.asStringNode().getString().compareTo(valueNode2.asStringNode().getString()) < 0;
        }
    }

    public static class NoneOfEvaluator implements Evaluator {
        private NoneOfEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            ValueNodes.ValueListNode valueListNodeAsValueListNode;
            ValueNodes.ValueListNode valueListNodeAsValueListNode2;
            if (valueNode2.isJsonNode()) {
                ValueNode valueNodeAsValueListNode = valueNode2.asJsonNode().asValueListNode(predicateContext);
                if (valueNodeAsValueListNode.isUndefinedNode()) {
                    return false;
                }
                valueListNodeAsValueListNode = valueNodeAsValueListNode.asValueListNode();
            } else {
                valueListNodeAsValueListNode = valueNode2.asValueListNode();
            }
            if (valueNode.isJsonNode()) {
                ValueNode valueNodeAsValueListNode2 = valueNode.asJsonNode().asValueListNode(predicateContext);
                if (valueNodeAsValueListNode2.isUndefinedNode()) {
                    return false;
                }
                valueListNodeAsValueListNode2 = valueNodeAsValueListNode2.asValueListNode();
            } else {
                valueListNodeAsValueListNode2 = valueNode.asValueListNode();
            }
            for (ValueNode valueNode3 : valueListNodeAsValueListNode2) {
                Iterator<ValueNode> it = valueListNodeAsValueListNode.iterator();
                while (it.hasNext()) {
                    if (valueNode3.equals(it.next())) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static class NotEqualsEvaluator implements Evaluator {
        private NotEqualsEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return !((Evaluator) EvaluatorFactory.evaluators.get(RelationalOperator.EQ)).evaluate(valueNode, valueNode2, predicateContext);
        }
    }

    public static class NotInEvaluator implements Evaluator {
        private NotInEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return !((Evaluator) EvaluatorFactory.evaluators.get(RelationalOperator.IN)).evaluate(valueNode, valueNode2, predicateContext);
        }
    }

    public static class PredicateMatchEvaluator implements Evaluator {
        private PredicateMatchEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return valueNode2.asPredicateNode().getPredicate().apply(predicateContext);
        }
    }

    public static class RegexpEvaluator implements Evaluator {
        private RegexpEvaluator() {
        }

        private String getInput(ValueNode valueNode) {
            return (valueNode.isStringNode() || valueNode.isNumberNode()) ? valueNode.asStringNode().getString() : valueNode.isBooleanNode() ? valueNode.asBooleanNode().toString() : "";
        }

        private boolean matches(ValueNodes.PatternNode patternNode, String str) {
            return patternNode.getCompiledPattern().matcher(str).matches();
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            if (valueNode.isPatternNode() ^ valueNode2.isPatternNode()) {
                return valueNode.isPatternNode() ? matches(valueNode.asPatternNode(), getInput(valueNode2)) : matches(valueNode2.asPatternNode(), getInput(valueNode));
            }
            return false;
        }
    }

    public static class SizeEvaluator implements Evaluator {
        private SizeEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            if (!valueNode2.isNumberNode()) {
                return false;
            }
            int iIntValue = valueNode2.asNumberNode().getNumber().intValue();
            return valueNode.isStringNode() ? valueNode.asStringNode().length() == iIntValue : valueNode.isJsonNode() && valueNode.asJsonNode().length(predicateContext) == iIntValue;
        }
    }

    public static class SubsetOfEvaluator implements Evaluator {
        private SubsetOfEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            ValueNodes.ValueListNode valueListNodeAsValueListNode;
            ValueNodes.ValueListNode valueListNodeAsValueListNode2;
            if (valueNode2.isJsonNode()) {
                ValueNode valueNodeAsValueListNode = valueNode2.asJsonNode().asValueListNode(predicateContext);
                if (valueNodeAsValueListNode.isUndefinedNode()) {
                    return false;
                }
                valueListNodeAsValueListNode = valueNodeAsValueListNode.asValueListNode();
            } else {
                valueListNodeAsValueListNode = valueNode2.asValueListNode();
            }
            if (valueNode.isJsonNode()) {
                ValueNode valueNodeAsValueListNode2 = valueNode.asJsonNode().asValueListNode(predicateContext);
                if (valueNodeAsValueListNode2.isUndefinedNode()) {
                    return false;
                }
                valueListNodeAsValueListNode2 = valueNodeAsValueListNode2.asValueListNode();
            } else {
                valueListNodeAsValueListNode2 = valueNode.asValueListNode();
            }
            return valueListNodeAsValueListNode2.subsetof(valueListNodeAsValueListNode);
        }
    }

    public static class TypeEvaluator implements Evaluator {
        private TypeEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return valueNode2.asClassNode().getClazz() == valueNode.type(predicateContext);
        }
    }

    public static class TypeSafeEqualsEvaluator implements Evaluator {
        private TypeSafeEqualsEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            if (valueNode.getClass().equals(valueNode2.getClass())) {
                return ((Evaluator) EvaluatorFactory.evaluators.get(RelationalOperator.EQ)).evaluate(valueNode, valueNode2, predicateContext);
            }
            return false;
        }
    }

    public static class TypeSafeNotEqualsEvaluator implements Evaluator {
        private TypeSafeNotEqualsEvaluator() {
        }

        @Override // com.jayway.jsonpath.internal.filter.Evaluator
        public boolean evaluate(ValueNode valueNode, ValueNode valueNode2, Predicate.PredicateContext predicateContext) {
            return !((Evaluator) EvaluatorFactory.evaluators.get(RelationalOperator.TSEQ)).evaluate(valueNode, valueNode2, predicateContext);
        }
    }

    static {
        HashMap map = new HashMap();
        evaluators = map;
        map.put(RelationalOperator.EXISTS, new ExistsEvaluator());
        map.put(RelationalOperator.NE, new NotEqualsEvaluator());
        map.put(RelationalOperator.TSNE, new TypeSafeNotEqualsEvaluator());
        map.put(RelationalOperator.EQ, new EqualsEvaluator());
        map.put(RelationalOperator.TSEQ, new TypeSafeEqualsEvaluator());
        map.put(RelationalOperator.LT, new LessThanEvaluator());
        map.put(RelationalOperator.LTE, new LessThanEqualsEvaluator());
        map.put(RelationalOperator.GT, new GreaterThanEvaluator());
        map.put(RelationalOperator.GTE, new GreaterThanEqualsEvaluator());
        map.put(RelationalOperator.REGEX, new RegexpEvaluator());
        map.put(RelationalOperator.SIZE, new SizeEvaluator());
        map.put(RelationalOperator.EMPTY, new EmptyEvaluator());
        map.put(RelationalOperator.IN, new InEvaluator());
        map.put(RelationalOperator.NIN, new NotInEvaluator());
        map.put(RelationalOperator.ALL, new AllEvaluator());
        map.put(RelationalOperator.CONTAINS, new ContainsEvaluator());
        map.put(RelationalOperator.MATCHES, new PredicateMatchEvaluator());
        map.put(RelationalOperator.TYPE, new TypeEvaluator());
        map.put(RelationalOperator.SUBSETOF, new SubsetOfEvaluator());
        map.put(RelationalOperator.ANYOF, new AnyOfEvaluator());
        map.put(RelationalOperator.NONEOF, new NoneOfEvaluator());
    }

    public static Evaluator createEvaluator(RelationalOperator relationalOperator) {
        return evaluators.get(relationalOperator);
    }
}
