package com.jayway.jsonpath.internal.path;

import c.a.a.a.a;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.internal.CharacterIndex;
import com.jayway.jsonpath.internal.Path;
import com.jayway.jsonpath.internal.Utils;
import com.jayway.jsonpath.internal.filter.FilterCompiler;
import com.jayway.jsonpath.internal.function.ParamType;
import com.jayway.jsonpath.internal.function.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PathCompiler {
    private static final char BEGIN_FILTER = '?';
    private static final char CLOSE_BRACE = '}';
    private static final char CLOSE_PARENTHESIS = ')';
    private static final char CLOSE_SQUARE_BRACKET = ']';
    private static final char COMMA = ',';
    private static final char CR = '\r';
    private static final char DOC_CONTEXT = '$';
    private static final char DOUBLE_QUOTE = '\"';
    private static final char EVAL_CONTEXT = '@';
    private static final char LF = '\n';
    private static final char MINUS = '-';
    private static final char OPEN_BRACE = '{';
    private static final char OPEN_PARENTHESIS = '(';
    private static final char OPEN_SQUARE_BRACKET = '[';
    private static final char PERIOD = '.';
    private static final char SINGLE_QUOTE = '\'';
    private static final char SPACE = ' ';
    private static final char SPLIT = ':';
    private static final char TAB = '\t';
    private static final char WILDCARD = '*';
    private final LinkedList<Predicate> filterStack;
    private final CharacterIndex path;

    /* JADX INFO: renamed from: com.jayway.jsonpath.internal.path.PathCompiler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$jayway$jsonpath$internal$function$ParamType;

        static {
            ParamType.values();
            int[] iArr = new int[2];
            $SwitchMap$com$jayway$jsonpath$internal$function$ParamType = iArr;
            try {
                iArr[ParamType.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$jayway$jsonpath$internal$function$ParamType[ParamType.PATH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private PathCompiler(String str, LinkedList<Predicate> linkedList) {
        this(new CharacterIndex(str), linkedList);
    }

    private Path compile() {
        RootPathToken contextToken = readContextToken();
        return new CompiledPath(contextToken, contextToken.getPathFragment().equals("$"));
    }

    public static boolean fail(String str) {
        throw new InvalidPathException(str);
    }

    private Boolean isPathContext(char c2) {
        return Boolean.valueOf(c2 == '$' || c2 == '@');
    }

    private boolean isWhitespace(char c2) {
        return c2 == ' ' || c2 == '\t' || c2 == '\n' || c2 == '\r';
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.jayway.jsonpath.internal.function.Parameter> parseFunctionParameters(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jayway.jsonpath.internal.path.PathCompiler.parseFunctionParameters(java.lang.String):java.util.List");
    }

    private boolean readArrayToken(PathTokenAppender pathTokenAppender) {
        int iPosition;
        int iNextIndexOf;
        if (!this.path.currentCharIs(OPEN_SQUARE_BRACKET)) {
            return false;
        }
        char cNextSignificantChar = this.path.nextSignificantChar();
        if ((!Character.isDigit(cNextSignificantChar) && cNextSignificantChar != '-' && cNextSignificantChar != ':') || (iNextIndexOf = this.path.nextIndexOf((iPosition = this.path.position() + 1), CLOSE_SQUARE_BRACKET)) == -1) {
            return false;
        }
        String strTrim = this.path.subSequence(iPosition, iNextIndexOf).toString().trim();
        if ("*".equals(strTrim)) {
            return false;
        }
        for (int i2 = 0; i2 < strTrim.length(); i2++) {
            char cCharAt = strTrim.charAt(i2);
            if (!Character.isDigit(cCharAt) && cCharAt != ',' && cCharAt != '-' && cCharAt != ':' && cCharAt != ' ') {
                return false;
            }
        }
        if (strTrim.contains(":")) {
            pathTokenAppender.appendPathToken(PathTokenFactory.createSliceArrayPathToken(ArraySliceOperation.parse(strTrim)));
        } else {
            pathTokenAppender.appendPathToken(PathTokenFactory.createIndexArrayPathToken(ArrayIndexOperation.parse(strTrim)));
        }
        this.path.setPosition(iNextIndexOf + 1);
        return this.path.currentIsTail() || readNextToken(pathTokenAppender);
    }

    private boolean readBracketPropertyToken(PathTokenAppender pathTokenAppender) {
        if (!this.path.currentCharIs(OPEN_SQUARE_BRACKET)) {
            return false;
        }
        char cNextSignificantChar = this.path.nextSignificantChar();
        if (cNextSignificantChar != '\'' && cNextSignificantChar != '\"') {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int iPosition = this.path.position() + 1;
        int i2 = iPosition;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (!this.path.inBounds(iPosition)) {
                break;
            }
            char cCharAt = this.path.charAt(iPosition);
            if (z) {
                z = false;
            } else if ('\\' == cCharAt) {
                z = true;
            } else if (cCharAt != ']' || z2) {
                if (cCharAt == cNextSignificantChar) {
                    if (z2) {
                        char cNextSignificantChar2 = this.path.nextSignificantChar(iPosition);
                        if (cNextSignificantChar2 != ']' && cNextSignificantChar2 != ',') {
                            fail("Property must be separated by comma or Property must be terminated close square bracket at index " + iPosition);
                        }
                        arrayList.add(Utils.unescape(this.path.subSequence(i2, iPosition).toString()));
                        i3 = iPosition;
                        z2 = false;
                    } else {
                        i2 = iPosition + 1;
                        z2 = true;
                        z3 = false;
                    }
                } else if (cCharAt == ',') {
                    if (z3) {
                        fail("Found empty property at index " + iPosition);
                    }
                    z3 = true;
                }
            } else if (z3) {
                fail("Found empty property at index " + iPosition);
            }
            iPosition++;
        }
        if (z2) {
            fail("Property has not been closed - missing closing " + cNextSignificantChar);
        }
        this.path.setPosition(this.path.indexOfNextSignificantChar(i3, CLOSE_SQUARE_BRACKET) + 1);
        pathTokenAppender.appendPathToken(PathTokenFactory.createPropertyPathToken(arrayList, cNextSignificantChar));
        return this.path.currentIsTail() || readNextToken(pathTokenAppender);
    }

    private RootPathToken readContextToken() {
        readWhitespace();
        if (!isPathContext(this.path.currentChar()).booleanValue()) {
            throw new InvalidPathException("Path must start with '$' or '@'");
        }
        RootPathToken rootPathTokenCreateRootPathToken = PathTokenFactory.createRootPathToken(this.path.currentChar());
        if (this.path.currentIsTail()) {
            return rootPathTokenCreateRootPathToken;
        }
        this.path.incrementPosition(1);
        if (this.path.currentChar() != '.' && this.path.currentChar() != '[') {
            StringBuilder sbR = a.r("Illegal character at position ");
            sbR.append(this.path.position());
            sbR.append(" expected '.' or '['");
            fail(sbR.toString());
        }
        readNextToken(rootPathTokenCreateRootPathToken.getPathTokenAppender());
        return rootPathTokenCreateRootPathToken;
    }

    private boolean readDotToken(PathTokenAppender pathTokenAppender) {
        if (this.path.currentCharIs(PERIOD) && this.path.nextCharIs(PERIOD)) {
            pathTokenAppender.appendPathToken(PathTokenFactory.crateScanToken());
            this.path.incrementPosition(2);
        } else {
            if (!this.path.hasMoreCharacters()) {
                throw new InvalidPathException("Path must not end with a '.");
            }
            this.path.incrementPosition(1);
        }
        if (!this.path.currentCharIs(PERIOD)) {
            return readNextToken(pathTokenAppender);
        }
        StringBuilder sbR = a.r("Character '.' on position ");
        sbR.append(this.path.position());
        sbR.append(" is not valid.");
        throw new InvalidPathException(sbR.toString());
    }

    private boolean readFilterToken(PathTokenAppender pathTokenAppender) {
        int iIndexOfNextSignificantChar;
        int iIndexOfClosingBracket;
        if (!this.path.currentCharIs(OPEN_SQUARE_BRACKET) && !this.path.nextSignificantCharIs(BEGIN_FILTER)) {
            return false;
        }
        int iPosition = this.path.position();
        int iIndexOfNextSignificantChar2 = this.path.indexOfNextSignificantChar(BEGIN_FILTER);
        if (iIndexOfNextSignificantChar2 == -1 || (iIndexOfNextSignificantChar = this.path.indexOfNextSignificantChar(iIndexOfNextSignificantChar2, OPEN_PARENTHESIS)) == -1 || (iIndexOfClosingBracket = this.path.indexOfClosingBracket(iIndexOfNextSignificantChar, true, true)) == -1 || !this.path.nextSignificantCharIs(iIndexOfClosingBracket, CLOSE_SQUARE_BRACKET)) {
            return false;
        }
        int iIndexOfNextSignificantChar3 = this.path.indexOfNextSignificantChar(iIndexOfClosingBracket, CLOSE_SQUARE_BRACKET) + 1;
        pathTokenAppender.appendPathToken(PathTokenFactory.createPredicatePathToken(FilterCompiler.compile(this.path.subSequence(iPosition, iIndexOfNextSignificantChar3).toString())));
        this.path.setPosition(iIndexOfNextSignificantChar3);
        return this.path.currentIsTail() || readNextToken(pathTokenAppender);
    }

    private boolean readNextToken(PathTokenAppender pathTokenAppender) {
        char cCurrentChar = this.path.currentChar();
        if (cCurrentChar == '*') {
            if (!readWildCardToken(pathTokenAppender)) {
                StringBuilder sbR = a.r("Could not parse token starting at position ");
                sbR.append(this.path.position());
                if (!fail(sbR.toString())) {
                    return false;
                }
            }
            return true;
        }
        if (cCurrentChar == '.') {
            if (!readDotToken(pathTokenAppender)) {
                StringBuilder sbR2 = a.r("Could not parse token starting at position ");
                sbR2.append(this.path.position());
                if (!fail(sbR2.toString())) {
                    return false;
                }
            }
            return true;
        }
        if (cCurrentChar != '[') {
            if (!readPropertyOrFunctionToken(pathTokenAppender)) {
                StringBuilder sbR3 = a.r("Could not parse token starting at position ");
                sbR3.append(this.path.position());
                if (!fail(sbR3.toString())) {
                    return false;
                }
            }
            return true;
        }
        if (!readBracketPropertyToken(pathTokenAppender) && !readArrayToken(pathTokenAppender) && !readWildCardToken(pathTokenAppender) && !readFilterToken(pathTokenAppender) && !readPlaceholderToken(pathTokenAppender)) {
            StringBuilder sbR4 = a.r("Could not parse token starting at position ");
            sbR4.append(this.path.position());
            sbR4.append(". Expected ?, ', 0-9, * ");
            if (!fail(sbR4.toString())) {
                return false;
            }
        }
        return true;
    }

    private boolean readPlaceholderToken(PathTokenAppender pathTokenAppender) {
        int iIndexOfNextSignificantChar;
        int iPosition;
        int iNextIndexOf;
        if (!this.path.currentCharIs(OPEN_SQUARE_BRACKET) || (iIndexOfNextSignificantChar = this.path.indexOfNextSignificantChar(BEGIN_FILTER)) == -1) {
            return false;
        }
        char cNextSignificantChar = this.path.nextSignificantChar(iIndexOfNextSignificantChar);
        if ((cNextSignificantChar != ']' && cNextSignificantChar != ',') || (iNextIndexOf = this.path.nextIndexOf((iPosition = this.path.position() + 1), CLOSE_SQUARE_BRACKET)) == -1) {
            return false;
        }
        String string = this.path.subSequence(iPosition, iNextIndexOf).toString();
        String[] strArrSplit = string.split(",");
        if (this.filterStack.size() < strArrSplit.length) {
            StringBuilder sbU = a.u("Not enough predicates supplied for filter [", string, "] at position ");
            sbU.append(this.path.position());
            throw new InvalidPathException(sbU.toString());
        }
        ArrayList arrayList = new ArrayList();
        int length = strArrSplit.length;
        for (int i2 = 0; i2 < length; i2++) {
            String strTrim = strArrSplit[i2];
            if (strTrim != null) {
                strTrim = strTrim.trim();
            }
            if (!"?".equals(strTrim == null ? "" : strTrim)) {
                throw new InvalidPathException(a.i("Expected '?' but found ", strTrim));
            }
            arrayList.add(this.filterStack.pop());
        }
        pathTokenAppender.appendPathToken(PathTokenFactory.createPredicatePathToken(arrayList));
        this.path.setPosition(iNextIndexOf + 1);
        return this.path.currentIsTail() || readNextToken(pathTokenAppender);
    }

    private boolean readPropertyOrFunctionToken(PathTokenAppender pathTokenAppender) {
        int length;
        boolean z;
        if (this.path.currentCharIs(OPEN_SQUARE_BRACKET) || this.path.currentCharIs(WILDCARD) || this.path.currentCharIs(PERIOD) || this.path.currentCharIs(SPACE)) {
            return false;
        }
        int iPosition = this.path.position();
        int i2 = iPosition;
        while (this.path.inBounds(i2)) {
            char cCharAt = this.path.charAt(i2);
            if (cCharAt == ' ') {
                StringBuilder sbR = a.r("Use bracket notion ['my prop'] if your property contains blank characters. position: ");
                sbR.append(this.path.position());
                throw new InvalidPathException(sbR.toString());
            }
            if (cCharAt == '.' || cCharAt == '[') {
                length = i2;
                break;
            }
            if (cCharAt == '(') {
                length = i2;
                z = true;
                break;
            }
            i2++;
        }
        length = 0;
        z = false;
        if (length == 0) {
            length = this.path.length();
        }
        List<Parameter> functionParameters = null;
        if (z) {
            int i3 = i2 + 1;
            if (!this.path.inBounds(i3)) {
                this.path.setPosition(i2);
            } else if (this.path.charAt(i3) != ')') {
                this.path.setPosition(length + 1);
                functionParameters = parseFunctionParameters(this.path.subSequence(iPosition, length).toString());
            } else {
                this.path.setPosition(i3);
            }
        } else {
            this.path.setPosition(length);
        }
        String string = this.path.subSequence(iPosition, length).toString();
        if (z) {
            pathTokenAppender.appendPathToken(PathTokenFactory.createFunctionPathToken(string, functionParameters));
        } else {
            pathTokenAppender.appendPathToken(PathTokenFactory.createSinglePropertyPathToken(string, SINGLE_QUOTE));
        }
        return this.path.currentIsTail() || readNextToken(pathTokenAppender);
    }

    private void readWhitespace() {
        while (this.path.inBounds() && isWhitespace(this.path.currentChar())) {
            this.path.incrementPosition(1);
        }
    }

    private boolean readWildCardToken(PathTokenAppender pathTokenAppender) {
        boolean zCurrentCharIs = this.path.currentCharIs(OPEN_SQUARE_BRACKET);
        if (zCurrentCharIs && !this.path.nextSignificantCharIs(WILDCARD)) {
            return false;
        }
        if (!this.path.currentCharIs(WILDCARD)) {
            CharacterIndex characterIndex = this.path;
            if (characterIndex.isOutOfBounds(characterIndex.position() + 1)) {
                return false;
            }
        }
        if (zCurrentCharIs) {
            int iIndexOfNextSignificantChar = this.path.indexOfNextSignificantChar(WILDCARD);
            if (!this.path.nextSignificantCharIs(iIndexOfNextSignificantChar, CLOSE_SQUARE_BRACKET)) {
                throw new InvalidPathException(a.G("Expected wildcard token to end with ']' on position ", iIndexOfNextSignificantChar + 1));
            }
            this.path.setPosition(this.path.indexOfNextSignificantChar(iIndexOfNextSignificantChar, CLOSE_SQUARE_BRACKET) + 1);
        } else {
            this.path.incrementPosition(1);
        }
        pathTokenAppender.appendPathToken(PathTokenFactory.createWildCardPathToken());
        return this.path.currentIsTail() || readNextToken(pathTokenAppender);
    }

    private PathCompiler(CharacterIndex characterIndex, LinkedList<Predicate> linkedList) {
        this.filterStack = linkedList;
        this.path = characterIndex;
    }

    public static Path compile(String str, Predicate... predicateArr) {
        try {
            CharacterIndex characterIndex = new CharacterIndex(str);
            characterIndex.trim();
            if (characterIndex.charAt(0) != '$' && characterIndex.charAt(0) != '@') {
                characterIndex = new CharacterIndex("$." + str);
                characterIndex.trim();
            }
            if (characterIndex.lastCharIs(PERIOD)) {
                fail("Path must not end with a '.' or '..'");
            }
            return new PathCompiler(characterIndex, (LinkedList<Predicate>) new LinkedList(Arrays.asList(predicateArr))).compile();
        } catch (Exception e2) {
            if (e2 instanceof InvalidPathException) {
                throw ((InvalidPathException) e2);
            }
            throw new InvalidPathException(e2);
        }
    }
}
