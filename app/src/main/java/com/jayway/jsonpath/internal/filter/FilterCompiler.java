package com.jayway.jsonpath.internal.filter;

import c.a.a.a.a;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.internal.CharacterIndex;
import com.jayway.jsonpath.internal.filter.ValueNodes;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class FilterCompiler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char AND = '&';
    private static final char CLOSE_ARRAY = ']';
    private static final char CLOSE_OBJECT = '}';
    private static final char CLOSE_PARENTHESIS = ')';
    private static final char CLOSE_SQUARE_BRACKET = ']';
    private static final char DOC_CONTEXT = '$';
    private static final char DOUBLE_QUOTE = '\"';
    private static final char EQ = '=';
    private static final char EVAL_CONTEXT = '@';
    private static final char FALSE = 'f';
    private static final char GT = '>';
    private static final char IGNORE_CASE = 'i';
    private static final char LT = '<';
    private static final char MINUS = '-';
    private static final char NOT = '!';
    private static final char NULL = 'n';
    private static final char OPEN_ARRAY = '[';
    private static final char OPEN_OBJECT = '{';
    private static final char OPEN_PARENTHESIS = '(';
    private static final char OPEN_SQUARE_BRACKET = '[';
    private static final char OR = '|';
    private static final char PATTERN = '/';
    private static final char PERIOD = '.';
    private static final char SINGLE_QUOTE = '\'';
    private static final char SPACE = ' ';
    private static final char TILDE = '~';
    private static final char TRUE = 't';
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) FilterCompiler.class);
    private CharacterIndex filter;

    public static final class CompiledFilter extends Filter {
        private final Predicate predicate;

        @Override // com.jayway.jsonpath.Filter, com.jayway.jsonpath.Predicate
        public boolean apply(Predicate.PredicateContext predicateContext) {
            return this.predicate.apply(predicateContext);
        }

        public String toString() {
            String string = this.predicate.toString();
            return string.startsWith("(") ? a.k("[?", string, "]") : a.k("[?(", string, ")]");
        }

        private CompiledFilter(Predicate predicate) {
            this.predicate = predicate;
        }
    }

    private FilterCompiler(String str) {
        CharacterIndex characterIndex = new CharacterIndex(str);
        this.filter = characterIndex;
        characterIndex.trim();
        if (!this.filter.currentCharIs('[') || !this.filter.lastCharIs(']')) {
            throw new InvalidPathException(a.i("Filter must start with '[' and end with ']'. ", str));
        }
        this.filter.incrementPosition(1);
        this.filter.decrementEndPosition(1);
        this.filter.trim();
        if (!this.filter.currentCharIs('?')) {
            throw new InvalidPathException(a.i("Filter must start with '[?' and end with ']'. ", str));
        }
        this.filter.incrementPosition(1);
        this.filter.trim();
        if (!this.filter.currentCharIs(OPEN_PARENTHESIS) || !this.filter.lastCharIs(CLOSE_PARENTHESIS)) {
            throw new InvalidPathException(a.i("Filter must start with '[?(' and end with ')]'. ", str));
        }
    }

    public static Filter compile(String str) {
        return new CompiledFilter(new FilterCompiler(str).compile());
    }

    private boolean currentCharIsClosingFunctionBracket(int i2) {
        int iIndexOfPreviousSignificantChar;
        if (this.filter.currentChar() == ')' && (iIndexOfPreviousSignificantChar = this.filter.indexOfPreviousSignificantChar()) != -1 && this.filter.charAt(iIndexOfPreviousSignificantChar) == '(') {
            for (int i3 = iIndexOfPreviousSignificantChar - 1; this.filter.inBounds(i3) && i3 > i2; i3--) {
                if (this.filter.charAt(i3) == '.') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean expressionIsTerminated() {
        char cNextSignificantChar;
        char cCurrentChar = this.filter.currentChar();
        return cCurrentChar == ')' || isLogicalOperatorChar(cCurrentChar) || (cNextSignificantChar = this.filter.nextSignificantChar()) == ')' || isLogicalOperatorChar(cNextSignificantChar);
    }

    private boolean isLogicalOperatorChar(char c2) {
        return c2 == '&' || c2 == '|';
    }

    private boolean isRelationalOperatorChar(char c2) {
        return c2 == '<' || c2 == '>' || c2 == '=' || c2 == '~' || c2 == '!';
    }

    private ValueNodes.BooleanNode readBooleanLiteral() {
        int iPosition = this.filter.position();
        int iPosition2 = this.filter.currentChar() == 't' ? this.filter.position() + 3 : this.filter.position() + 4;
        if (!this.filter.inBounds(iPosition2)) {
            throw new InvalidPathException("Expected boolean literal");
        }
        CharSequence charSequenceSubSequence = this.filter.subSequence(iPosition, iPosition2 + 1);
        if (!charSequenceSubSequence.equals("true") && !charSequenceSubSequence.equals("false")) {
            throw new InvalidPathException("Expected boolean literal");
        }
        this.filter.incrementPosition(charSequenceSubSequence.length());
        logger.trace("BooleanLiteral from {} to {} -> [{}]", Integer.valueOf(iPosition), Integer.valueOf(iPosition2), charSequenceSubSequence);
        return ValueNode.createBooleanNode(charSequenceSubSequence);
    }

    private RelationalExpressionNode readExpression() {
        ValueNode valueNode = readValueNode();
        try {
            return new RelationalExpressionNode(valueNode, readRelationalOperator(), readValueNode());
        } catch (InvalidPathException unused) {
            this.filter.setPosition(this.filter.position());
            ValueNodes.PathNode pathNodeAsPathNode = valueNode.asPathNode();
            ValueNodes.PathNode pathNodeAsExistsCheck = pathNodeAsPathNode.asExistsCheck(pathNodeAsPathNode.shouldExists());
            return new RelationalExpressionNode(pathNodeAsExistsCheck, RelationalOperator.EXISTS, pathNodeAsExistsCheck.asPathNode().shouldExists() ? ValueNodes.TRUE : ValueNodes.FALSE);
        }
    }

    private ValueNodes.JsonNode readJsonLiteral() {
        int iPosition = this.filter.position();
        char cCurrentChar = this.filter.currentChar();
        char c2 = cCurrentChar == '[' ? ']' : '}';
        CharacterIndex characterIndex = this.filter;
        int iIndexOfMatchingCloseChar = characterIndex.indexOfMatchingCloseChar(characterIndex.position(), cCurrentChar, c2, true, false);
        if (iIndexOfMatchingCloseChar == -1) {
            StringBuilder sbR = a.r("String not closed. Expected ' in ");
            sbR.append(this.filter);
            throw new InvalidPathException(sbR.toString());
        }
        this.filter.setPosition(iIndexOfMatchingCloseChar + 1);
        CharacterIndex characterIndex2 = this.filter;
        CharSequence charSequenceSubSequence = characterIndex2.subSequence(iPosition, characterIndex2.position());
        logger.trace("JsonLiteral from {} to {} -> [{}]", Integer.valueOf(iPosition), Integer.valueOf(this.filter.position()), charSequenceSubSequence);
        return ValueNode.createJsonNode(charSequenceSubSequence);
    }

    private ValueNode readLiteral() {
        char cCurrentChar = this.filter.skipBlanks().currentChar();
        return cCurrentChar != '\"' ? cCurrentChar != '\'' ? cCurrentChar != '-' ? cCurrentChar != '/' ? cCurrentChar != '[' ? cCurrentChar != 'f' ? cCurrentChar != 'n' ? cCurrentChar != 't' ? cCurrentChar != '{' ? readNumberLiteral() : readJsonLiteral() : readBooleanLiteral() : readNullLiteral() : readBooleanLiteral() : readJsonLiteral() : readPattern() : readNumberLiteral() : readStringLiteral(SINGLE_QUOTE) : readStringLiteral(DOUBLE_QUOTE);
    }

    private ExpressionNode readLogicalAND() {
        int iPosition;
        ArrayList arrayList = new ArrayList();
        arrayList.add(readLogicalANDOperand());
        while (true) {
            iPosition = this.filter.position();
            if (!this.filter.hasSignificantSubSequence(LogicalOperator.AND.getOperatorString())) {
                break;
            }
            arrayList.add(readLogicalANDOperand());
        }
        this.filter.setPosition(iPosition);
        return 1 == arrayList.size() ? (ExpressionNode) arrayList.get(0) : LogicalExpressionNode.createLogicalAnd(arrayList);
    }

    private ExpressionNode readLogicalANDOperand() {
        int iPosition = this.filter.skipBlanks().position();
        if (this.filter.skipBlanks().currentCharIs(NOT)) {
            this.filter.readSignificantChar(NOT);
            char cCurrentChar = this.filter.skipBlanks().currentChar();
            if (cCurrentChar != '$' && cCurrentChar != '@') {
                return LogicalExpressionNode.createLogicalNot(readLogicalANDOperand());
            }
            this.filter.setPosition(iPosition);
        }
        if (!this.filter.skipBlanks().currentCharIs(OPEN_PARENTHESIS)) {
            return readExpression();
        }
        this.filter.readSignificantChar(OPEN_PARENTHESIS);
        ExpressionNode logicalOR = readLogicalOR();
        this.filter.readSignificantChar(CLOSE_PARENTHESIS);
        return logicalOR;
    }

    private ExpressionNode readLogicalOR() {
        int iPosition;
        ArrayList arrayList = new ArrayList();
        arrayList.add(readLogicalAND());
        while (true) {
            iPosition = this.filter.position();
            if (!this.filter.hasSignificantSubSequence(LogicalOperator.OR.getOperatorString())) {
                break;
            }
            arrayList.add(readLogicalAND());
        }
        this.filter.setPosition(iPosition);
        return 1 == arrayList.size() ? (ExpressionNode) arrayList.get(0) : LogicalExpressionNode.createLogicalOr(arrayList);
    }

    private LogicalOperator readLogicalOperator() {
        int iPosition = this.filter.skipBlanks().position();
        int i2 = iPosition + 1;
        if (!this.filter.inBounds(i2)) {
            throw new InvalidPathException("Expected boolean literal");
        }
        CharSequence charSequenceSubSequence = this.filter.subSequence(iPosition, i2 + 1);
        if (!charSequenceSubSequence.equals("||") && !charSequenceSubSequence.equals("&&")) {
            throw new InvalidPathException("Expected logical operator");
        }
        this.filter.incrementPosition(charSequenceSubSequence.length());
        logger.trace("LogicalOperator from {} to {} -> [{}]", Integer.valueOf(iPosition), Integer.valueOf(i2), charSequenceSubSequence);
        return LogicalOperator.fromString(charSequenceSubSequence.toString());
    }

    private ValueNodes.NullNode readNullLiteral() {
        int iPosition = this.filter.position();
        if (this.filter.currentChar() == 'n') {
            CharacterIndex characterIndex = this.filter;
            if (characterIndex.inBounds(characterIndex.position() + 3)) {
                CharacterIndex characterIndex2 = this.filter;
                CharSequence charSequenceSubSequence = characterIndex2.subSequence(characterIndex2.position(), this.filter.position() + 4);
                if ("null".equals(charSequenceSubSequence.toString())) {
                    logger.trace("NullLiteral from {} to {} -> [{}]", Integer.valueOf(iPosition), Integer.valueOf(this.filter.position() + 3), charSequenceSubSequence);
                    this.filter.incrementPosition(charSequenceSubSequence.length());
                    return ValueNode.createNullNode();
                }
            }
        }
        throw new InvalidPathException("Expected <null> value");
    }

    private ValueNodes.NumberNode readNumberLiteral() {
        int iPosition = this.filter.position();
        while (this.filter.inBounds()) {
            CharacterIndex characterIndex = this.filter;
            if (!characterIndex.isNumberCharacter(characterIndex.position())) {
                break;
            }
            this.filter.incrementPosition(1);
        }
        CharacterIndex characterIndex2 = this.filter;
        CharSequence charSequenceSubSequence = characterIndex2.subSequence(iPosition, characterIndex2.position());
        logger.trace("NumberLiteral from {} to {} -> [{}]", Integer.valueOf(iPosition), Integer.valueOf(this.filter.position()), charSequenceSubSequence);
        return ValueNode.createNumberNode(charSequenceSubSequence);
    }

    private ValueNodes.PathNode readPath() {
        char cPreviousSignificantChar = this.filter.previousSignificantChar();
        int iPosition = this.filter.position();
        this.filter.incrementPosition(1);
        while (this.filter.inBounds()) {
            if (this.filter.currentChar() == '[') {
                CharacterIndex characterIndex = this.filter;
                int iIndexOfMatchingCloseChar = characterIndex.indexOfMatchingCloseChar(characterIndex.position(), '[', ']', true, false);
                if (iIndexOfMatchingCloseChar == -1) {
                    StringBuilder sbR = a.r("Square brackets does not match in filter ");
                    sbR.append(this.filter);
                    throw new InvalidPathException(sbR.toString());
                }
                this.filter.setPosition(iIndexOfMatchingCloseChar + 1);
            }
            boolean z = this.filter.currentChar() == ')' && !(this.filter.currentChar() == ')' && currentCharIsClosingFunctionBracket(iPosition));
            if (!this.filter.inBounds() || isRelationalOperatorChar(this.filter.currentChar()) || this.filter.currentChar() == ' ' || z) {
                break;
            }
            this.filter.incrementPosition(1);
        }
        boolean z2 = cPreviousSignificantChar != '!';
        CharacterIndex characterIndex2 = this.filter;
        return ValueNode.createPathNode(characterIndex2.subSequence(iPosition, characterIndex2.position()), false, z2);
    }

    private ValueNodes.PatternNode readPattern() {
        int iPosition = this.filter.position();
        int iNextIndexOfUnescaped = this.filter.nextIndexOfUnescaped('/');
        if (iNextIndexOfUnescaped == -1) {
            StringBuilder sbR = a.r("Pattern not closed. Expected / in ");
            sbR.append(this.filter);
            throw new InvalidPathException(sbR.toString());
        }
        int i2 = iNextIndexOfUnescaped + 1;
        if (this.filter.inBounds(i2)) {
            int iNextIndexOf = this.filter.nextIndexOf(EQ);
            if (iNextIndexOf <= iNextIndexOfUnescaped) {
                iNextIndexOf = this.filter.nextIndexOfUnescaped(CLOSE_PARENTHESIS);
            }
            iNextIndexOfUnescaped += this.filter.subSequence(i2, iNextIndexOf).length();
        }
        this.filter.setPosition(iNextIndexOfUnescaped + 1);
        CharacterIndex characterIndex = this.filter;
        CharSequence charSequenceSubSequence = characterIndex.subSequence(iPosition, characterIndex.position());
        logger.trace("PatternNode from {} to {} -> [{}]", Integer.valueOf(iPosition), Integer.valueOf(this.filter.position()), charSequenceSubSequence);
        return ValueNode.createPatternNode(charSequenceSubSequence);
    }

    private RelationalOperator readRelationalOperator() {
        int iPosition = this.filter.skipBlanks().position();
        if (isRelationalOperatorChar(this.filter.currentChar())) {
            while (this.filter.inBounds() && isRelationalOperatorChar(this.filter.currentChar())) {
                this.filter.incrementPosition(1);
            }
        } else {
            while (this.filter.inBounds() && this.filter.currentChar() != ' ') {
                this.filter.incrementPosition(1);
            }
        }
        CharacterIndex characterIndex = this.filter;
        CharSequence charSequenceSubSequence = characterIndex.subSequence(iPosition, characterIndex.position());
        logger.trace("Operator from {} to {} -> [{}]", Integer.valueOf(iPosition), Integer.valueOf(this.filter.position() - 1), charSequenceSubSequence);
        return RelationalOperator.fromString(charSequenceSubSequence.toString());
    }

    private ValueNodes.StringNode readStringLiteral(char c2) {
        int iPosition = this.filter.position();
        int iNextIndexOfUnescaped = this.filter.nextIndexOfUnescaped(c2);
        if (iNextIndexOfUnescaped != -1) {
            this.filter.setPosition(iNextIndexOfUnescaped + 1);
            CharacterIndex characterIndex = this.filter;
            CharSequence charSequenceSubSequence = characterIndex.subSequence(iPosition, characterIndex.position());
            logger.trace("StringLiteral from {} to {} -> [{}]", Integer.valueOf(iPosition), Integer.valueOf(this.filter.position()), charSequenceSubSequence);
            return ValueNode.createStringNode(charSequenceSubSequence, true);
        }
        throw new InvalidPathException("String literal does not have matching quotes. Expected " + c2 + " in " + this.filter);
    }

    private ValueNode readValueNode() {
        char cCurrentChar = this.filter.skipBlanks().currentChar();
        if (cCurrentChar != '!') {
            return cCurrentChar != '$' ? cCurrentChar != '@' ? readLiteral() : readPath() : readPath();
        }
        this.filter.incrementPosition(1);
        char cCurrentChar2 = this.filter.skipBlanks().currentChar();
        if (cCurrentChar2 == '$') {
            return readPath();
        }
        if (cCurrentChar2 == '@') {
            return readPath();
        }
        throw new InvalidPathException(String.format("Unexpected character: %c", Character.valueOf(NOT)));
    }

    public Predicate compile() {
        try {
            ExpressionNode logicalOR = readLogicalOR();
            this.filter.skipBlanks();
            if (!this.filter.inBounds()) {
                return logicalOR;
            }
            CharacterIndex characterIndex = this.filter;
            throw new InvalidPathException(String.format("Expected end of filter expression instead of: %s", characterIndex.subSequence(characterIndex.position(), this.filter.length())));
        } catch (InvalidPathException e2) {
            throw e2;
        } catch (Exception unused) {
            StringBuilder sbR = a.r("Failed to parse filter: ");
            sbR.append(this.filter);
            sbR.append(", error on position: ");
            sbR.append(this.filter.position());
            sbR.append(", char: ");
            sbR.append(this.filter.currentChar());
            throw new InvalidPathException(sbR.toString());
        }
    }
}
