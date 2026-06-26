package com.jayway.jsonpath.internal.filter;

import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.internal.Path;
import com.jayway.jsonpath.internal.filter.ValueNodes;
import com.jayway.jsonpath.internal.path.PathCompiler;
import i.a.b.k.a;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class ValueNode {
    public static ValueNodes.BooleanNode createBooleanNode(CharSequence charSequence) {
        return Boolean.parseBoolean(charSequence.toString()) ? ValueNodes.TRUE : ValueNodes.FALSE;
    }

    public static ValueNodes.ClassNode createClassNode(Class<?> cls) {
        return new ValueNodes.ClassNode(cls);
    }

    public static ValueNodes.JsonNode createJsonNode(CharSequence charSequence) {
        return new ValueNodes.JsonNode(charSequence);
    }

    public static ValueNodes.NullNode createNullNode() {
        return ValueNodes.NULL_NODE;
    }

    public static ValueNodes.NumberNode createNumberNode(CharSequence charSequence) {
        return new ValueNodes.NumberNode(charSequence);
    }

    public static ValueNodes.PathNode createPathNode(CharSequence charSequence, boolean z, boolean z2) {
        return new ValueNodes.PathNode(charSequence, z, z2);
    }

    public static ValueNodes.PatternNode createPatternNode(CharSequence charSequence) {
        return new ValueNodes.PatternNode(charSequence);
    }

    public static ValueNodes.StringNode createStringNode(CharSequence charSequence, boolean z) {
        return new ValueNodes.StringNode(charSequence, z);
    }

    public static ValueNodes.UndefinedNode createUndefinedNode() {
        return ValueNodes.UNDEFINED;
    }

    private static boolean isJson(Object obj) {
        if (obj != null && (obj instanceof String)) {
            String strTrim = obj.toString().trim();
            if (strTrim.length() <= 1) {
                return false;
            }
            char cCharAt = strTrim.charAt(0);
            char cCharAt2 = strTrim.charAt(strTrim.length() - 1);
            if ((cCharAt == '[' && cCharAt2 == ']') || (cCharAt == '{' && cCharAt2 == '}')) {
                try {
                    new a(-1).b(strTrim);
                    return true;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    private static boolean isPath(Object obj) {
        if (obj != null && (obj instanceof String)) {
            String strTrim = obj.toString().trim();
            if (strTrim.length() <= 0) {
                return false;
            }
            char cCharAt = strTrim.charAt(0);
            if (cCharAt != '@' && cCharAt != '$') {
                return false;
            }
            try {
                PathCompiler.compile(strTrim, new Predicate[0]);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static ValueNode toValueNode(Object obj) {
        if (obj == null) {
            return ValueNodes.NULL_NODE;
        }
        if (obj instanceof ValueNode) {
            return (ValueNode) obj;
        }
        if (obj instanceof Class) {
            return createClassNode((Class) obj);
        }
        if (isPath(obj)) {
            return new ValueNodes.PathNode((CharSequence) obj.toString(), false, false);
        }
        if (isJson(obj)) {
            return createJsonNode((CharSequence) obj.toString());
        }
        if (obj instanceof String) {
            return createStringNode(obj.toString(), true);
        }
        if (obj instanceof Character) {
            return createStringNode(obj.toString(), false);
        }
        if (obj instanceof Number) {
            return createNumberNode(obj.toString());
        }
        if (obj instanceof Boolean) {
            return createBooleanNode(obj.toString());
        }
        if (obj instanceof Pattern) {
            return createPatternNode((Pattern) obj);
        }
        throw new JsonPathException("Could not determine value type");
    }

    public ValueNodes.BooleanNode asBooleanNode() {
        throw new InvalidPathException("Expected boolean node");
    }

    public ValueNodes.ClassNode asClassNode() {
        throw new InvalidPathException("Expected class node");
    }

    public ValueNodes.JsonNode asJsonNode() {
        throw new InvalidPathException("Expected json node");
    }

    public ValueNodes.NullNode asNullNode() {
        throw new InvalidPathException("Expected null node");
    }

    public ValueNodes.NumberNode asNumberNode() {
        throw new InvalidPathException("Expected number node");
    }

    public ValueNodes.PathNode asPathNode() {
        throw new InvalidPathException("Expected path node");
    }

    public ValueNodes.PatternNode asPatternNode() {
        throw new InvalidPathException("Expected regexp node");
    }

    public ValueNodes.PredicateNode asPredicateNode() {
        throw new InvalidPathException("Expected predicate node");
    }

    public ValueNodes.StringNode asStringNode() {
        throw new InvalidPathException("Expected string node");
    }

    public ValueNodes.UndefinedNode asUndefinedNode() {
        throw new InvalidPathException("Expected undefined node");
    }

    public ValueNodes.ValueListNode asValueListNode() {
        throw new InvalidPathException("Expected value list node");
    }

    public boolean isBooleanNode() {
        return false;
    }

    public boolean isClassNode() {
        return false;
    }

    public boolean isJsonNode() {
        return false;
    }

    public boolean isNullNode() {
        return false;
    }

    public boolean isNumberNode() {
        return false;
    }

    public boolean isPathNode() {
        return false;
    }

    public boolean isPatternNode() {
        return false;
    }

    public boolean isPredicateNode() {
        return false;
    }

    public boolean isStringNode() {
        return false;
    }

    public boolean isUndefinedNode() {
        return false;
    }

    public boolean isValueListNode() {
        return false;
    }

    public abstract Class<?> type(Predicate.PredicateContext predicateContext);

    public static ValueNodes.JsonNode createJsonNode(Object obj) {
        return new ValueNodes.JsonNode(obj);
    }

    public static ValueNode createPathNode(Path path) {
        return new ValueNodes.PathNode(path);
    }

    public static ValueNodes.PatternNode createPatternNode(Pattern pattern) {
        return new ValueNodes.PatternNode(pattern);
    }
}
