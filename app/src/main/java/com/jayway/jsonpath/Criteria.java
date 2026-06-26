package com.jayway.jsonpath;

import c.a.a.a.a;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.internal.Path;
import com.jayway.jsonpath.internal.Utils;
import com.jayway.jsonpath.internal.filter.RelationalExpressionNode;
import com.jayway.jsonpath.internal.filter.RelationalOperator;
import com.jayway.jsonpath.internal.filter.ValueNode;
import com.jayway.jsonpath.internal.filter.ValueNodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class Criteria implements Predicate {
    private final List<Criteria> criteriaChain;
    private RelationalOperator criteriaType;
    private ValueNode left;
    private ValueNode right;

    private Criteria(List<Criteria> list, ValueNode valueNode) {
        this.left = valueNode;
        this.criteriaChain = list;
        list.add(this);
    }

    private void checkComplete() {
        if (!((this.left == null || this.criteriaType == null || this.right == null) ? false : true)) {
            throw new JsonPathException("Criteria build exception. Complete on criteria before defining next.");
        }
    }

    @Deprecated
    public static Criteria create(String str, String str2, String str3) {
        Criteria criteria = new Criteria(ValueNode.toValueNode(str));
        criteria.criteriaType = RelationalOperator.fromString(str2);
        criteria.right = ValueNode.toValueNode(str3);
        return criteria;
    }

    @Deprecated
    public static Criteria parse(String str) {
        if (str == null) {
            throw new InvalidPathException("Criteria can not be null");
        }
        String[] strArrSplit = str.trim().split(" ");
        if (strArrSplit.length == 3) {
            return create(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        }
        if (strArrSplit.length == 1) {
            return create(strArrSplit[0], "EXISTS", "true");
        }
        throw new InvalidPathException("Could not parse criteria");
    }

    private static String prefixPath(String str) {
        return (str.startsWith("$") || str.startsWith("@")) ? str : a.i("@.", str);
    }

    private Collection<RelationalExpressionNode> toRelationalExpressionNodes() {
        ArrayList arrayList = new ArrayList(this.criteriaChain.size());
        for (Criteria criteria : this.criteriaChain) {
            arrayList.add(new RelationalExpressionNode(criteria.left, criteria.criteriaType, criteria.right));
        }
        return arrayList;
    }

    @Deprecated
    public static Criteria where(Path path) {
        return new Criteria(ValueNode.createPathNode(path));
    }

    public Criteria all(Object... objArr) {
        return all(Arrays.asList(objArr));
    }

    public Criteria and(String str) {
        checkComplete();
        return new Criteria(this.criteriaChain, ValueNode.toValueNode(prefixPath(str)));
    }

    public Criteria anyof(Object... objArr) {
        return subsetof(Arrays.asList(objArr));
    }

    @Override // com.jayway.jsonpath.Predicate
    public boolean apply(Predicate.PredicateContext predicateContext) {
        Iterator<RelationalExpressionNode> it = toRelationalExpressionNodes().iterator();
        while (it.hasNext()) {
            if (!it.next().apply(predicateContext)) {
                return false;
            }
        }
        return true;
    }

    public Criteria contains(Object obj) {
        this.criteriaType = RelationalOperator.CONTAINS;
        this.right = ValueNode.toValueNode(obj);
        return this;
    }

    public Criteria empty(boolean z) {
        this.criteriaType = RelationalOperator.EMPTY;
        this.right = z ? ValueNodes.TRUE : ValueNodes.FALSE;
        return this;
    }

    public Criteria eq(Object obj) {
        return is(obj);
    }

    public Criteria exists(boolean z) {
        this.criteriaType = RelationalOperator.EXISTS;
        this.right = ValueNode.toValueNode(Boolean.valueOf(z));
        this.left = this.left.asPathNode().asExistsCheck(z);
        return this;
    }

    public Criteria gt(Object obj) {
        this.criteriaType = RelationalOperator.GT;
        this.right = ValueNode.toValueNode(obj);
        return this;
    }

    public Criteria gte(Object obj) {
        this.criteriaType = RelationalOperator.GTE;
        this.right = ValueNode.toValueNode(obj);
        return this;
    }

    public Criteria in(Object... objArr) {
        return in(Arrays.asList(objArr));
    }

    public Criteria is(Object obj) {
        this.criteriaType = RelationalOperator.EQ;
        this.right = ValueNode.toValueNode(obj);
        return this;
    }

    public Criteria lt(Object obj) {
        this.criteriaType = RelationalOperator.LT;
        this.right = ValueNode.toValueNode(obj);
        return this;
    }

    public Criteria lte(Object obj) {
        this.criteriaType = RelationalOperator.LTE;
        this.right = ValueNode.toValueNode(obj);
        return this;
    }

    public Criteria matches(Predicate predicate) {
        this.criteriaType = RelationalOperator.MATCHES;
        this.right = new ValueNodes.PredicateNode(predicate);
        return this;
    }

    public Criteria ne(Object obj) {
        this.criteriaType = RelationalOperator.NE;
        this.right = ValueNode.toValueNode(obj);
        return this;
    }

    public Criteria nin(Object... objArr) {
        return nin(Arrays.asList(objArr));
    }

    public Criteria noneof(Object... objArr) {
        return subsetof(Arrays.asList(objArr));
    }

    @Deprecated
    public Criteria notEmpty() {
        return empty(false);
    }

    public Criteria regex(Pattern pattern) {
        Utils.notNull(pattern, "pattern can not be null", new Object[0]);
        this.criteriaType = RelationalOperator.REGEX;
        this.right = ValueNode.toValueNode(pattern);
        return this;
    }

    public Criteria size(int i2) {
        this.criteriaType = RelationalOperator.SIZE;
        this.right = ValueNode.toValueNode(Integer.valueOf(i2));
        return this;
    }

    public Criteria subsetof(Object... objArr) {
        return subsetof(Arrays.asList(objArr));
    }

    public String toString() {
        return Utils.join(" && ", toRelationalExpressionNodes());
    }

    public Criteria type(Class<?> cls) {
        this.criteriaType = RelationalOperator.TYPE;
        this.right = ValueNode.createClassNode(cls);
        return this;
    }

    public static Criteria where(String str) {
        return new Criteria(ValueNode.toValueNode(prefixPath(str)));
    }

    public Criteria all(Collection<?> collection) {
        Utils.notNull(collection, "collection can not be null", new Object[0]);
        this.criteriaType = RelationalOperator.ALL;
        this.right = new ValueNodes.ValueListNode(collection);
        return this;
    }

    public Criteria anyof(Collection<?> collection) {
        Utils.notNull(collection, "collection can not be null", new Object[0]);
        this.criteriaType = RelationalOperator.ANYOF;
        this.right = new ValueNodes.ValueListNode(collection);
        return this;
    }

    public Criteria in(Collection<?> collection) {
        Utils.notNull(collection, "collection can not be null", new Object[0]);
        this.criteriaType = RelationalOperator.IN;
        this.right = new ValueNodes.ValueListNode(collection);
        return this;
    }

    public Criteria nin(Collection<?> collection) {
        Utils.notNull(collection, "collection can not be null", new Object[0]);
        this.criteriaType = RelationalOperator.NIN;
        this.right = new ValueNodes.ValueListNode(collection);
        return this;
    }

    public Criteria noneof(Collection<?> collection) {
        Utils.notNull(collection, "collection can not be null", new Object[0]);
        this.criteriaType = RelationalOperator.NONEOF;
        this.right = new ValueNodes.ValueListNode(collection);
        return this;
    }

    public Criteria subsetof(Collection<?> collection) {
        Utils.notNull(collection, "collection can not be null", new Object[0]);
        this.criteriaType = RelationalOperator.SUBSETOF;
        this.right = new ValueNodes.ValueListNode(collection);
        return this;
    }

    private Criteria(ValueNode valueNode) {
        this(new LinkedList(), valueNode);
    }
}
