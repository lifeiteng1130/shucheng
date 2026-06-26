package com.jayway.jsonpath.internal.filter;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPathException;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.internal.Path;
import com.jayway.jsonpath.internal.Utils;
import com.jayway.jsonpath.internal.path.PathCompiler;
import com.jayway.jsonpath.internal.path.PredicateContextImpl;
import com.jayway.jsonpath.spi.json.JsonProvider;
import h.a.a.a.w;
import i.a.b.k.a;
import i.a.b.k.g;
import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.v;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public interface ValueNodes {
    public static final BooleanNode FALSE;
    public static final NullNode NULL_NODE;
    public static final BooleanNode TRUE;
    public static final UndefinedNode UNDEFINED = new UndefinedNode();

    public static class BooleanNode extends ValueNode {
        private final Boolean value;

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public BooleanNode asBooleanNode() {
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BooleanNode)) {
                return false;
            }
            Boolean bool = this.value;
            Boolean bool2 = ((BooleanNode) obj).value;
            if (bool != null) {
                if (bool.equals(bool2)) {
                    return true;
                }
            } else if (bool2 == null) {
                return true;
            }
            return false;
        }

        public boolean getBoolean() {
            return this.value.booleanValue();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isBooleanNode() {
            return true;
        }

        public String toString() {
            return this.value.toString();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return Boolean.class;
        }

        private BooleanNode(CharSequence charSequence) {
            this.value = Boolean.valueOf(Boolean.parseBoolean(charSequence.toString()));
        }
    }

    public static class ClassNode extends ValueNode {
        private final Class clazz;

        public ClassNode(Class cls) {
            this.clazz = cls;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public ClassNode asClassNode() {
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClassNode)) {
                return false;
            }
            Class cls = this.clazz;
            Class cls2 = ((ClassNode) obj).clazz;
            if (cls != null) {
                if (cls.equals(cls2)) {
                    return true;
                }
            } else if (cls2 == null) {
                return true;
            }
            return false;
        }

        public Class getClazz() {
            return this.clazz;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isClassNode() {
            return true;
        }

        public String toString() {
            return this.clazz.getName();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return Class.class;
        }
    }

    public static class JsonNode extends ValueNode {
        private final Object json;
        private final boolean parsed = false;

        public JsonNode(CharSequence charSequence) {
            this.json = charSequence.toString();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public JsonNode asJsonNode() {
            return this;
        }

        public ValueNode asValueListNode(Predicate.PredicateContext predicateContext) {
            return !isArray(predicateContext) ? ValueNodes.UNDEFINED : new ValueListNode(Collections.unmodifiableList((List) parse(predicateContext)));
        }

        public boolean equals(JsonNode jsonNode, Predicate.PredicateContext predicateContext) {
            if (this == jsonNode) {
                return true;
            }
            Object obj = this.json;
            if (obj != null) {
                if (obj.equals(jsonNode.parse(predicateContext))) {
                    return true;
                }
            } else if (jsonNode.json == null) {
                return true;
            }
            return false;
        }

        public Object getJson() {
            return this.json;
        }

        public boolean isArray(Predicate.PredicateContext predicateContext) {
            return parse(predicateContext) instanceof List;
        }

        public boolean isEmpty(Predicate.PredicateContext predicateContext) {
            return (isArray(predicateContext) || isMap(predicateContext)) ? ((Collection) parse(predicateContext)).size() == 0 : !(parse(predicateContext) instanceof String) || ((String) parse(predicateContext)).length() == 0;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isJsonNode() {
            return true;
        }

        public boolean isMap(Predicate.PredicateContext predicateContext) {
            return parse(predicateContext) instanceof Map;
        }

        public boolean isParsed() {
            return this.parsed;
        }

        public int length(Predicate.PredicateContext predicateContext) {
            if (isArray(predicateContext)) {
                return ((List) parse(predicateContext)).size();
            }
            return -1;
        }

        public Object parse(Predicate.PredicateContext predicateContext) {
            try {
                return this.parsed ? this.json : new a(-1).b(this.json.toString());
            } catch (g e2) {
                throw new IllegalArgumentException(e2);
            }
        }

        public String toString() {
            return this.json.toString();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return isArray(predicateContext) ? List.class : isMap(predicateContext) ? Map.class : parse(predicateContext) instanceof Number ? Number.class : parse(predicateContext) instanceof String ? String.class : parse(predicateContext) instanceof Boolean ? Boolean.class : Void.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JsonNode)) {
                return false;
            }
            Object obj2 = this.json;
            Object obj3 = ((JsonNode) obj).json;
            if (obj2 != null) {
                if (obj2.equals(obj3)) {
                    return true;
                }
            } else if (obj3 == null) {
                return true;
            }
            return false;
        }

        public JsonNode(Object obj) {
            this.json = obj;
        }
    }

    public static class NullNode extends ValueNode {
        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public NullNode asNullNode() {
            return this;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NullNode);
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isNullNode() {
            return true;
        }

        public String toString() {
            return "null";
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return Void.class;
        }

        private NullNode() {
        }
    }

    public static class PathNode extends ValueNode {
        private static final Logger logger = LoggerFactory.getLogger((Class<?>) PathNode.class);
        private final boolean existsCheck;
        private final Path path;
        private final boolean shouldExist;

        public PathNode(Path path) {
            this(path, false, false);
        }

        public PathNode asExistsCheck(boolean z) {
            return new PathNode(this.path, true, z);
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public PathNode asPathNode() {
            return this;
        }

        public ValueNode evaluate(Predicate.PredicateContext predicateContext) {
            Object value;
            if (isExistsCheck()) {
                try {
                    return this.path.evaluate(predicateContext.item(), predicateContext.root(), Configuration.builder().jsonProvider(predicateContext.configuration().jsonProvider()).options(Option.REQUIRE_PROPERTIES).build()).getValue(false) == JsonProvider.UNDEFINED ? ValueNodes.FALSE : ValueNodes.TRUE;
                } catch (PathNotFoundException unused) {
                    return ValueNodes.FALSE;
                }
            }
            try {
                if (predicateContext instanceof PredicateContextImpl) {
                    value = ((PredicateContextImpl) predicateContext).evaluate(this.path);
                } else {
                    value = this.path.evaluate(this.path.isRootPath() ? predicateContext.root() : predicateContext.item(), predicateContext.root(), predicateContext.configuration()).getValue();
                }
                Object objUnwrap = predicateContext.configuration().jsonProvider().unwrap(value);
                if (objUnwrap instanceof Number) {
                    return ValueNode.createNumberNode(objUnwrap.toString());
                }
                if (objUnwrap instanceof String) {
                    return ValueNode.createStringNode(objUnwrap.toString(), false);
                }
                if (objUnwrap instanceof Boolean) {
                    return ValueNode.createBooleanNode(objUnwrap.toString());
                }
                if (objUnwrap == null) {
                    return ValueNodes.NULL_NODE;
                }
                if (predicateContext.configuration().jsonProvider().isArray(objUnwrap)) {
                    return ValueNode.createJsonNode(predicateContext.configuration().mappingProvider().map(objUnwrap, List.class, predicateContext.configuration()));
                }
                if (predicateContext.configuration().jsonProvider().isMap(objUnwrap)) {
                    return ValueNode.createJsonNode(predicateContext.configuration().mappingProvider().map(objUnwrap, Map.class, predicateContext.configuration()));
                }
                throw new JsonPathException("Could not convert " + objUnwrap.toString() + " to a ValueNode");
            } catch (PathNotFoundException unused2) {
                return ValueNodes.UNDEFINED;
            }
        }

        public Path getPath() {
            return this.path;
        }

        public boolean isExistsCheck() {
            return this.existsCheck;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isPathNode() {
            return true;
        }

        public boolean shouldExists() {
            return this.shouldExist;
        }

        public String toString() {
            return (!this.existsCheck || this.shouldExist) ? this.path.toString() : Utils.concat(XPath.NOT, this.path.toString());
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return Void.class;
        }

        public PathNode(CharSequence charSequence, boolean z, boolean z2) {
            this(PathCompiler.compile(charSequence.toString(), new Predicate[0]), z, z2);
        }

        public PathNode(Path path, boolean z, boolean z2) {
            this.path = path;
            this.existsCheck = z;
            this.shouldExist = z2;
            logger.trace("PathNode {} existsCheck: {}", path, Boolean.valueOf(z));
        }
    }

    public static class PredicateNode extends ValueNode {
        private final Predicate predicate;

        public PredicateNode(Predicate predicate) {
            this.predicate = predicate;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public PredicateNode asPredicateNode() {
            return this;
        }

        public boolean equals(Object obj) {
            return false;
        }

        public Predicate getPredicate() {
            return this.predicate;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isPredicateNode() {
            return true;
        }

        public String toString() {
            return this.predicate.toString();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return Void.class;
        }
    }

    public static class StringNode extends ValueNode {
        private final String string;
        private boolean useSingleQuote;

        public StringNode(CharSequence charSequence, boolean z) {
            this.useSingleQuote = true;
            if (!z || charSequence.length() <= 1) {
                this.string = charSequence.toString();
                return;
            }
            char cCharAt = charSequence.charAt(0);
            char cCharAt2 = charSequence.charAt(charSequence.length() - 1);
            if (cCharAt == '\'' && cCharAt2 == '\'') {
                charSequence = charSequence.subSequence(1, charSequence.length() - 1);
            } else if (cCharAt == '\"' && cCharAt2 == '\"') {
                charSequence = charSequence.subSequence(1, charSequence.length() - 1);
                this.useSingleQuote = false;
            }
            this.string = Utils.unescape(charSequence.toString());
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public NumberNode asNumberNode() {
            try {
                return new NumberNode(new BigDecimal(this.string));
            } catch (NumberFormatException unused) {
                return NumberNode.NAN;
            }
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public StringNode asStringNode() {
            return this;
        }

        public boolean contains(String str) {
            return getString().contains(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StringNode) && !(obj instanceof NumberNode)) {
                return false;
            }
            StringNode stringNodeAsStringNode = ((ValueNode) obj).asStringNode();
            String str = this.string;
            String string = stringNodeAsStringNode.getString();
            if (str != null) {
                if (str.equals(string)) {
                    return true;
                }
            } else if (string == null) {
                return true;
            }
            return false;
        }

        public String getString() {
            return this.string;
        }

        public boolean isEmpty() {
            return getString().isEmpty();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isStringNode() {
            return true;
        }

        public int length() {
            return getString().length();
        }

        public String toString() {
            String str = this.useSingleQuote ? "'" : "\"";
            StringBuilder sbR = c.a.a.a.a.r(str);
            sbR.append(Utils.escape(this.string, true));
            sbR.append(str);
            return sbR.toString();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return String.class;
        }
    }

    public static class UndefinedNode extends ValueNode {
        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public UndefinedNode asUndefinedNode() {
            return this;
        }

        public boolean equals(Object obj) {
            return false;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isUndefinedNode() {
            return true;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return Void.class;
        }
    }

    public static class ValueListNode extends ValueNode implements Iterable<ValueNode>, Iterable {
        private List<ValueNode> nodes = new ArrayList();

        public ValueListNode(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                this.nodes.add(ValueNode.toValueNode(it.next()));
            }
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public ValueListNode asValueListNode() {
            return this;
        }

        public boolean contains(ValueNode valueNode) {
            return this.nodes.contains(valueNode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ValueListNode) {
                return this.nodes.equals(((ValueListNode) obj).nodes);
            }
            return false;
        }

        @Override // j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        public List<ValueNode> getNodes() {
            return Collections.unmodifiableList(this.nodes);
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isValueListNode() {
            return true;
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator<ValueNode> iterator() {
            return this.nodes.iterator();
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return v.o(iterator(), 0);
        }

        public boolean subsetof(ValueListNode valueListNode) {
            Iterator<ValueNode> it = this.nodes.iterator();
            while (it.hasNext()) {
                if (!valueListNode.nodes.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("[");
            sbR.append(Utils.join(",", this.nodes));
            sbR.append("]");
            return sbR.toString();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return List.class;
        }
    }

    static {
        NULL_NODE = new NullNode();
        TRUE = new BooleanNode("true");
        FALSE = new BooleanNode("false");
    }

    public static class NumberNode extends ValueNode {
        public static NumberNode NAN = new NumberNode((BigDecimal) null);
        private final BigDecimal number;

        public NumberNode(BigDecimal bigDecimal) {
            this.number = bigDecimal;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public NumberNode asNumberNode() {
            return this;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public StringNode asStringNode() {
            return new StringNode(this.number.toString(), false);
        }

        public boolean equals(Object obj) {
            NumberNode numberNodeAsNumberNode;
            if (this == obj) {
                return true;
            }
            return ((obj instanceof NumberNode) || (obj instanceof StringNode)) && (numberNodeAsNumberNode = ((ValueNode) obj).asNumberNode()) != NAN && this.number.compareTo(numberNodeAsNumberNode.number) == 0;
        }

        public BigDecimal getNumber() {
            return this.number;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isNumberNode() {
            return true;
        }

        public String toString() {
            return this.number.toString();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return Number.class;
        }

        public NumberNode(CharSequence charSequence) {
            this.number = new BigDecimal(charSequence.toString());
        }
    }

    public static class PatternNode extends ValueNode {
        private final Pattern compiledPattern;
        private final String flags;
        private final String pattern;

        public PatternNode(CharSequence charSequence) {
            String string = charSequence.toString();
            int iIndexOf = string.indexOf(47);
            int iLastIndexOf = string.lastIndexOf(47);
            String strSubstring = string.substring(iIndexOf + 1, iLastIndexOf);
            this.pattern = strSubstring;
            int i2 = iLastIndexOf + 1;
            String strSubstring2 = string.length() > i2 ? string.substring(i2) : "";
            this.flags = strSubstring2;
            this.compiledPattern = Pattern.compile(strSubstring, PatternFlag.parseFlags(strSubstring2.toCharArray()));
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public PatternNode asPatternNode() {
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PatternNode)) {
                return false;
            }
            Pattern pattern = this.compiledPattern;
            Pattern pattern2 = ((PatternNode) obj).compiledPattern;
            if (pattern != null) {
                if (pattern.equals(pattern2)) {
                    return true;
                }
            } else if (pattern2 == null) {
                return true;
            }
            return false;
        }

        public Pattern getCompiledPattern() {
            return this.compiledPattern;
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public boolean isPatternNode() {
            return true;
        }

        public String toString() {
            if (this.pattern.startsWith(w.DEFAULT_PATH_SEPARATOR)) {
                return this.pattern;
            }
            StringBuilder sbR = c.a.a.a.a.r(w.DEFAULT_PATH_SEPARATOR);
            sbR.append(this.pattern);
            sbR.append(w.DEFAULT_PATH_SEPARATOR);
            sbR.append(this.flags);
            return sbR.toString();
        }

        @Override // com.jayway.jsonpath.internal.filter.ValueNode
        public Class<?> type(Predicate.PredicateContext predicateContext) {
            return Void.TYPE;
        }

        public PatternNode(Pattern pattern) {
            this.pattern = pattern.pattern();
            this.compiledPattern = pattern;
            this.flags = PatternFlag.parseFlags(pattern.flags());
        }
    }
}
