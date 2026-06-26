package org.mozilla.javascript;

import c.a.a.a.a;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.ArrayComprehension;
import org.mozilla.javascript.ast.ArrayLiteral;
import org.mozilla.javascript.ast.Assignment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.Block;
import org.mozilla.javascript.ast.BreakStatement;
import org.mozilla.javascript.ast.CatchClause;
import org.mozilla.javascript.ast.Comment;
import org.mozilla.javascript.ast.ConditionalExpression;
import org.mozilla.javascript.ast.ContinueStatement;
import org.mozilla.javascript.ast.DestructuringForm;
import org.mozilla.javascript.ast.DoLoop;
import org.mozilla.javascript.ast.ElementGet;
import org.mozilla.javascript.ast.EmptyExpression;
import org.mozilla.javascript.ast.EmptyStatement;
import org.mozilla.javascript.ast.ErrorNode;
import org.mozilla.javascript.ast.ExpressionStatement;
import org.mozilla.javascript.ast.FunctionCall;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.GeneratorExpression;
import org.mozilla.javascript.ast.GeneratorExpressionLoop;
import org.mozilla.javascript.ast.IdeErrorReporter;
import org.mozilla.javascript.ast.IfStatement;
import org.mozilla.javascript.ast.InfixExpression;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.KeywordLiteral;
import org.mozilla.javascript.ast.Label;
import org.mozilla.javascript.ast.LabeledStatement;
import org.mozilla.javascript.ast.LetNode;
import org.mozilla.javascript.ast.Loop;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NewExpression;
import org.mozilla.javascript.ast.NumberLiteral;
import org.mozilla.javascript.ast.ObjectLiteral;
import org.mozilla.javascript.ast.ObjectProperty;
import org.mozilla.javascript.ast.ParenthesizedExpression;
import org.mozilla.javascript.ast.PropertyGet;
import org.mozilla.javascript.ast.RegExpLiteral;
import org.mozilla.javascript.ast.ReturnStatement;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.ast.StringLiteral;
import org.mozilla.javascript.ast.SwitchCase;
import org.mozilla.javascript.ast.SwitchStatement;
import org.mozilla.javascript.ast.ThrowStatement;
import org.mozilla.javascript.ast.TryStatement;
import org.mozilla.javascript.ast.UnaryExpression;
import org.mozilla.javascript.ast.VariableDeclaration;
import org.mozilla.javascript.ast.VariableInitializer;
import org.mozilla.javascript.ast.WhileLoop;
import org.mozilla.javascript.ast.WithStatement;
import org.mozilla.javascript.ast.XmlDotQuery;
import org.mozilla.javascript.ast.XmlElemRef;
import org.mozilla.javascript.ast.XmlExpression;
import org.mozilla.javascript.ast.XmlLiteral;
import org.mozilla.javascript.ast.XmlMemberGet;
import org.mozilla.javascript.ast.XmlPropRef;
import org.mozilla.javascript.ast.XmlRef;
import org.mozilla.javascript.ast.XmlString;
import org.mozilla.javascript.ast.Yield;

/* JADX INFO: loaded from: classes3.dex */
public class Parser {
    public static final int ARGC_LIMIT = 65536;
    public static final int CLEAR_TI_MASK = 65535;
    private static final int GET_ENTRY = 2;
    private static final int METHOD_ENTRY = 8;
    private static final int PROP_ENTRY = 1;
    private static final int SET_ENTRY = 4;
    public static final int TI_AFTER_EOL = 65536;
    public static final int TI_CHECK_LABEL = 131072;
    public boolean calledByCompileFunction;
    public CompilerEnvirons compilerEnv;
    private int currentFlaggedToken;
    private Comment currentJsDocComment;
    private LabeledStatement currentLabel;
    public Scope currentScope;
    public ScriptNode currentScriptOrFn;
    private int currentToken;
    private boolean defaultUseStrictDirective;
    private int endFlags;
    private IdeErrorReporter errorCollector;
    private ErrorReporter errorReporter;
    private boolean inDestructuringAssignment;
    private boolean inForInit;
    public boolean inUseStrictDirective;
    private Map<String, LabeledStatement> labelSet;
    private List<Jump> loopAndSwitchSet;
    private List<Loop> loopSet;
    public int nestingOfFunction;
    private boolean parseFinished;
    private int prevNameTokenLineno;
    private int prevNameTokenStart;
    private String prevNameTokenString;
    private List<Comment> scannedComments;
    private char[] sourceChars;
    private String sourceURI;
    private int syntaxErrorCount;
    private TokenStream ts;

    public static class ConditionData {
        public AstNode condition;
        public int lp;
        public int rp;

        private ConditionData() {
            this.lp = -1;
            this.rp = -1;
        }
    }

    public static class ParserException extends RuntimeException {
        private static final long serialVersionUID = 5882582646773765630L;

        private ParserException() {
        }
    }

    public class PerFunctionVariables {
        private Scope savedCurrentScope;
        private ScriptNode savedCurrentScriptOrFn;
        private int savedEndFlags;
        private boolean savedInForInit;
        private Map<String, LabeledStatement> savedLabelSet;
        private List<Jump> savedLoopAndSwitchSet;
        private List<Loop> savedLoopSet;

        public PerFunctionVariables(FunctionNode functionNode) {
            this.savedCurrentScriptOrFn = Parser.this.currentScriptOrFn;
            Parser.this.currentScriptOrFn = functionNode;
            this.savedCurrentScope = Parser.this.currentScope;
            Parser.this.currentScope = functionNode;
            this.savedLabelSet = Parser.this.labelSet;
            Parser.this.labelSet = null;
            this.savedLoopSet = Parser.this.loopSet;
            Parser.this.loopSet = null;
            this.savedLoopAndSwitchSet = Parser.this.loopAndSwitchSet;
            Parser.this.loopAndSwitchSet = null;
            this.savedEndFlags = Parser.this.endFlags;
            Parser.this.endFlags = 0;
            this.savedInForInit = Parser.this.inForInit;
            Parser.this.inForInit = false;
        }

        public void restore() {
            Parser parser = Parser.this;
            parser.currentScriptOrFn = this.savedCurrentScriptOrFn;
            parser.currentScope = this.savedCurrentScope;
            parser.labelSet = this.savedLabelSet;
            Parser.this.loopSet = this.savedLoopSet;
            Parser.this.loopAndSwitchSet = this.savedLoopAndSwitchSet;
            Parser.this.endFlags = this.savedEndFlags;
            Parser.this.inForInit = this.savedInForInit;
        }
    }

    public Parser() {
        this(new CompilerEnvirons());
    }

    private AstNode addExpr() {
        AstNode astNodeMulExpr = mulExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i2 = this.ts.tokenBeg;
            if (iPeekToken != 21 && iPeekToken != 22) {
                return astNodeMulExpr;
            }
            consumeToken();
            astNodeMulExpr = new InfixExpression(iPeekToken, astNodeMulExpr, mulExpr(), i2);
        }
    }

    private AstNode andExpr() {
        AstNode astNodeBitOrExpr = bitOrExpr();
        if (!matchToken(106, true)) {
            return astNodeBitOrExpr;
        }
        return new InfixExpression(106, astNodeBitOrExpr, andExpr(), this.ts.tokenBeg);
    }

    private List<AstNode> argumentList() {
        if (matchToken(89, true)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.inForInit;
        this.inForInit = false;
        do {
            try {
                if (peekToken() == 89) {
                    break;
                }
                if (peekToken() == 73) {
                    reportError("msg.yield.parenthesized");
                }
                AstNode astNodeAssignExpr = assignExpr();
                if (peekToken() == 120) {
                    try {
                        arrayList.add(generatorExpression(astNodeAssignExpr, 0, true));
                    } catch (IOException unused) {
                    }
                } else {
                    arrayList.add(astNodeAssignExpr);
                }
            } catch (Throwable th) {
                this.inForInit = z;
                throw th;
            }
        } while (matchToken(90, true));
        this.inForInit = z;
        mustMatchToken(89, "msg.no.paren.arg", true);
        return arrayList;
    }

    private AstNode arrayComprehension(AstNode astNode, int i2) {
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(arrayComprehensionLoop());
        }
        int i3 = -1;
        ConditionData conditionDataCondition = null;
        if (peekToken() == 113) {
            consumeToken();
            i3 = this.ts.tokenBeg - i2;
            conditionDataCondition = condition();
        }
        mustMatchToken(85, "msg.no.bracket.arg", true);
        ArrayComprehension arrayComprehension = new ArrayComprehension(i2, this.ts.tokenEnd - i2);
        arrayComprehension.setResult(astNode);
        arrayComprehension.setLoops(arrayList);
        if (conditionDataCondition != null) {
            arrayComprehension.setIfPosition(i3);
            arrayComprehension.setFilter(conditionDataCondition.condition);
            arrayComprehension.setFilterLp(conditionDataCondition.lp - i2);
            arrayComprehension.setFilterRp(conditionDataCondition.rp - i2);
        }
        return arrayComprehension;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:14:0x003b, B:16:0x0043, B:18:0x004a, B:24:0x0059, B:27:0x006e, B:29:0x0074, B:30:0x007f, B:41:0x00ad, B:43:0x00b4, B:45:0x00c2, B:47:0x00c9, B:51:0x00e1, B:35:0x008b, B:36:0x0091, B:39:0x00a1, B:40:0x00a6, B:25:0x005f, B:26:0x0067, B:12:0x0037), top: B:57:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.ArrayComprehensionLoop arrayComprehensionLoop() {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.arrayComprehensionLoop():org.mozilla.javascript.ast.ArrayComprehensionLoop");
    }

    private AstNode arrayLiteral() {
        int iPeekToken;
        if (this.currentToken != 84) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        int i3 = tokenStream.tokenEnd;
        ArrayList arrayList = new ArrayList();
        ArrayLiteral arrayLiteral = new ArrayLiteral(i2);
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int i6 = -1;
            while (true) {
                iPeekToken = peekToken();
                if (iPeekToken != 90) {
                    if (iPeekToken != 162) {
                        break;
                    }
                    consumeToken();
                } else {
                    consumeToken();
                    i6 = this.ts.tokenEnd;
                    if (i4 == 0) {
                        i4 = 1;
                    } else {
                        arrayList.add(new EmptyExpression(this.ts.tokenBeg, 1));
                        i5++;
                    }
                }
            }
            if (iPeekToken == 85) {
                consumeToken();
                i3 = this.ts.tokenEnd;
                arrayLiteral.setDestructuringLength(arrayList.size() + i4);
                arrayLiteral.setSkipCount(i5);
                if (i6 != -1) {
                    warnTrailingComma(i2, arrayList, i6);
                }
            } else {
                if (iPeekToken == 120 && i4 == 0 && arrayList.size() == 1) {
                    return arrayComprehension((AstNode) arrayList.get(0), i2);
                }
                if (iPeekToken == 0) {
                    reportError("msg.no.bracket.arg");
                    break;
                }
                if (i4 == 0) {
                    reportError("msg.no.bracket.arg");
                }
                arrayList.add(assignExpr());
                i4 = 0;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayLiteral.addElement((AstNode) it.next());
        }
        arrayLiteral.setLength(i3 - i2);
        return arrayLiteral;
    }

    private AstNode arrowFunction(AstNode astNode) {
        int i2 = this.ts.lineno;
        int position = astNode != null ? astNode.getPosition() : -1;
        FunctionNode functionNode = new FunctionNode(position);
        functionNode.setFunctionType(4);
        functionNode.setJsDocNode(getAndResetJsDoc());
        HashMap map = new HashMap();
        Set<String> hashSet = new HashSet<>();
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            if (astNode instanceof ParenthesizedExpression) {
                functionNode.setParens(0, astNode.getLength());
                AstNode expression = ((ParenthesizedExpression) astNode).getExpression();
                if (!(expression instanceof EmptyExpression)) {
                    arrowFunctionParams(functionNode, expression, map, hashSet);
                }
            } else {
                arrowFunctionParams(functionNode, astNode, map, hashSet);
            }
            if (!map.isEmpty()) {
                Node node = new Node(90);
                for (Map.Entry entry : map.entrySet()) {
                    node.addChildToBack(createDestructuringAssignment(123, (Node) entry.getValue(), createName((String) entry.getKey())));
                }
                functionNode.putProp(23, node);
            }
            functionNode.setBody(parseFunctionBody(4, functionNode));
            functionNode.setEncodedSourceBounds(position, this.ts.tokenEnd);
            functionNode.setLength(this.ts.tokenEnd - position);
            perFunctionVariables.restore();
            if (functionNode.isGenerator()) {
                reportError("msg.arrowfunction.generator");
                return makeErrorNode();
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setBaseLineno(i2);
            functionNode.setEndLineno(this.ts.lineno);
            return functionNode;
        } catch (Throwable th) {
            perFunctionVariables.restore();
            throw th;
        }
    }

    private void arrowFunctionParams(FunctionNode functionNode, AstNode astNode, Map<String, Node> map, Set<String> set) {
        if ((astNode instanceof ArrayLiteral) || (astNode instanceof ObjectLiteral)) {
            markDestructuring(astNode);
            functionNode.addParam(astNode);
            String nextTempName = this.currentScriptOrFn.getNextTempName();
            defineSymbol(88, nextTempName, false);
            map.put(nextTempName, astNode);
            return;
        }
        if ((astNode instanceof InfixExpression) && astNode.getType() == 90) {
            InfixExpression infixExpression = (InfixExpression) astNode;
            arrowFunctionParams(functionNode, infixExpression.getLeft(), map, set);
            arrowFunctionParams(functionNode, infixExpression.getRight(), map, set);
            return;
        }
        if (!(astNode instanceof Name)) {
            reportError("msg.no.parm", astNode.getPosition(), astNode.getLength());
            functionNode.addParam(makeErrorNode());
            return;
        }
        functionNode.addParam(astNode);
        String identifier = ((Name) astNode).getIdentifier();
        defineSymbol(88, identifier);
        if (this.inUseStrictDirective) {
            if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                reportError("msg.bad.id.strict", identifier);
            }
            if (set.contains(identifier)) {
                addError("msg.dup.param.strict", identifier);
            }
            set.add(identifier);
        }
    }

    private AstNode assignExpr() {
        int iPeekToken = peekToken();
        boolean z = true;
        if (iPeekToken == 73) {
            return returnOrYield(iPeekToken, true);
        }
        AstNode astNodeCondExpr = condExpr();
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL == 1) {
            iPeekTokenOrEOL = peekToken();
        } else {
            z = false;
        }
        if (91 > iPeekTokenOrEOL || iPeekTokenOrEOL > 102) {
            if (iPeekTokenOrEOL == 83) {
                if (this.currentJsDocComment == null) {
                    return astNodeCondExpr;
                }
                astNodeCondExpr.setJsDocNode(getAndResetJsDoc());
                return astNodeCondExpr;
            }
            if (z || iPeekTokenOrEOL != 165) {
                return astNodeCondExpr;
            }
            consumeToken();
            return arrowFunction(astNodeCondExpr);
        }
        if (this.inDestructuringAssignment) {
            reportError("msg.destruct.default.vals");
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        markDestructuring(astNodeCondExpr);
        Assignment assignment = new Assignment(iPeekTokenOrEOL, astNodeCondExpr, assignExpr(), this.ts.tokenBeg);
        if (andResetJsDoc != null) {
            assignment.setJsDocNode(andResetJsDoc);
        }
        return assignment;
    }

    private AstNode attributeAccess() {
        int iNextToken = nextToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        if (iNextToken == 23) {
            saveNameTokenData(i2, "*", tokenStream.lineno);
            return propertyName(i2, 0);
        }
        if (iNextToken == 39) {
            return propertyName(i2, 0);
        }
        if (iNextToken == 84) {
            return xmlElemRef(i2, null, -1);
        }
        reportError("msg.no.name.after.xmlAttr");
        return makeErrorNode();
    }

    private void autoInsertSemicolon(AstNode astNode) {
        int iPeekFlaggedToken = peekFlaggedToken();
        int position = astNode.getPosition();
        int i2 = 65535 & iPeekFlaggedToken;
        if (i2 != -1 && i2 != 0) {
            if (i2 == 83) {
                consumeToken();
                astNode.setLength(this.ts.tokenEnd - position);
                return;
            } else if (i2 != 87) {
                if ((iPeekFlaggedToken & 65536) == 0) {
                    reportError("msg.no.semi.stmt");
                    return;
                } else {
                    warnMissingSemi(position, nodeEnd(astNode));
                    return;
                }
            }
        }
        warnMissingSemi(position, Math.max(position + 1, nodeEnd(astNode)));
    }

    private AstNode bitAndExpr() {
        AstNode astNodeEqExpr = eqExpr();
        while (matchToken(11, true)) {
            astNodeEqExpr = new InfixExpression(11, astNodeEqExpr, eqExpr(), this.ts.tokenBeg);
        }
        return astNodeEqExpr;
    }

    private AstNode bitOrExpr() {
        AstNode astNodeBitXorExpr = bitXorExpr();
        while (matchToken(9, true)) {
            astNodeBitXorExpr = new InfixExpression(9, astNodeBitXorExpr, bitXorExpr(), this.ts.tokenBeg);
        }
        return astNodeBitXorExpr;
    }

    private AstNode bitXorExpr() {
        AstNode astNodeBitAndExpr = bitAndExpr();
        while (matchToken(10, true)) {
            astNodeBitAndExpr = new InfixExpression(10, astNodeBitAndExpr, bitAndExpr(), this.ts.tokenBeg);
        }
        return astNodeBitAndExpr;
    }

    private AstNode block() {
        if (this.currentToken != 86) {
            codeBug();
        }
        consumeToken();
        int i2 = this.ts.tokenBeg;
        Scope scope = new Scope(i2);
        scope.setLineno(this.ts.lineno);
        pushScope(scope);
        try {
            statements(scope);
            mustMatchToken(87, "msg.no.brace.block", true);
            scope.setLength(this.ts.tokenEnd - i2);
            return scope;
        } finally {
            popScope();
        }
    }

    private BreakStatement breakStatement() {
        int nodeEnd;
        Name nameCreateNameNode;
        if (this.currentToken != 121) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.tokenEnd;
        if (peekTokenOrEOL() == 39) {
            nameCreateNameNode = createNameNode();
            nodeEnd = getNodeEnd(nameCreateNameNode);
        } else {
            nodeEnd = i4;
            nameCreateNameNode = null;
        }
        LabeledStatement labeledStatementMatchJumpLabelName = matchJumpLabelName();
        Jump firstLabel = labeledStatementMatchJumpLabelName != null ? labeledStatementMatchJumpLabelName.getFirstLabel() : null;
        if (firstLabel == null && nameCreateNameNode == null) {
            List<Jump> list = this.loopAndSwitchSet;
            if (list == null || list.size() == 0) {
                reportError("msg.bad.break", i3, nodeEnd - i3);
            } else {
                firstLabel = this.loopAndSwitchSet.get(r4.size() - 1);
            }
        }
        BreakStatement breakStatement = new BreakStatement(i3, nodeEnd - i3);
        breakStatement.setBreakLabel(nameCreateNameNode);
        if (firstLabel != null) {
            breakStatement.setBreakTarget(firstLabel);
        }
        breakStatement.setLineno(i2);
        return breakStatement;
    }

    private void checkBadIncDec(UnaryExpression unaryExpression) {
        int type = removeParens(unaryExpression.getOperand()).getType();
        if (type == 39 || type == 33 || type == 36 || type == 68 || type == 38) {
            return;
        }
        reportError(unaryExpression.getType() == 107 ? "msg.bad.incr" : "msg.bad.decr");
    }

    private void checkCallRequiresActivation(AstNode astNode) {
        if ((astNode.getType() == 39 && "eval".equals(((Name) astNode).getIdentifier())) || (astNode.getType() == 33 && "eval".equals(((PropertyGet) astNode).getProperty().getIdentifier()))) {
            setRequiresActivation();
        }
    }

    private RuntimeException codeBug() {
        StringBuilder sbR = a.r("ts.cursor=");
        sbR.append(this.ts.cursor);
        sbR.append(", ts.tokenBeg=");
        sbR.append(this.ts.tokenBeg);
        sbR.append(", currentToken=");
        sbR.append(this.currentToken);
        throw Kit.codeBug(sbR.toString());
    }

    private AstNode condExpr() {
        AstNode astNodeOrExpr = orExpr();
        if (!matchToken(103, true)) {
            return astNodeOrExpr;
        }
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            AstNode astNodeAssignExpr = assignExpr();
            this.inForInit = z;
            int i4 = mustMatchToken(104, "msg.no.colon.cond", true) ? this.ts.tokenBeg : -1;
            AstNode astNodeAssignExpr2 = assignExpr();
            int position = astNodeOrExpr.getPosition();
            ConditionalExpression conditionalExpression = new ConditionalExpression(position, getNodeEnd(astNodeAssignExpr2) - position);
            conditionalExpression.setLineno(i2);
            conditionalExpression.setTestExpression(astNodeOrExpr);
            conditionalExpression.setTrueExpression(astNodeAssignExpr);
            conditionalExpression.setFalseExpression(astNodeAssignExpr2);
            conditionalExpression.setQuestionMarkPosition(i3 - position);
            conditionalExpression.setColonPosition(i4 - position);
            return conditionalExpression;
        } catch (Throwable th) {
            this.inForInit = z;
            throw th;
        }
    }

    private ConditionData condition() {
        ConditionData conditionData = new ConditionData();
        if (mustMatchToken(88, "msg.no.paren.cond", true)) {
            conditionData.lp = this.ts.tokenBeg;
        }
        conditionData.condition = expr();
        if (mustMatchToken(89, "msg.no.paren.after.cond", true)) {
            conditionData.rp = this.ts.tokenBeg;
        }
        AstNode astNode = conditionData.condition;
        if (astNode instanceof Assignment) {
            addStrictWarning("msg.equal.as.assign", "", astNode.getPosition(), conditionData.condition.getLength());
        }
        return conditionData;
    }

    private void consumeToken() {
        this.currentFlaggedToken = 0;
    }

    private ContinueStatement continueStatement() {
        int nodeEnd;
        Name nameCreateNameNode;
        if (this.currentToken != 122) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.tokenEnd;
        Loop loop = null;
        if (peekTokenOrEOL() == 39) {
            nameCreateNameNode = createNameNode();
            nodeEnd = getNodeEnd(nameCreateNameNode);
        } else {
            nodeEnd = i4;
            nameCreateNameNode = null;
        }
        LabeledStatement labeledStatementMatchJumpLabelName = matchJumpLabelName();
        if (labeledStatementMatchJumpLabelName == null && nameCreateNameNode == null) {
            List<Loop> list = this.loopSet;
            if (list == null || list.size() == 0) {
                reportError("msg.continue.outside");
            } else {
                loop = this.loopSet.get(r4.size() - 1);
            }
        } else {
            if (labeledStatementMatchJumpLabelName == null || !(labeledStatementMatchJumpLabelName.getStatement() instanceof Loop)) {
                reportError("msg.continue.nonloop", i3, nodeEnd - i3);
            }
            if (labeledStatementMatchJumpLabelName != null) {
                loop = (Loop) labeledStatementMatchJumpLabelName.getStatement();
            }
        }
        ContinueStatement continueStatement = new ContinueStatement(i3, nodeEnd - i3);
        if (loop != null) {
            continueStatement.setTarget(loop);
        }
        continueStatement.setLabel(nameCreateNameNode);
        continueStatement.setLineno(i2);
        return continueStatement;
    }

    private Name createNameNode() {
        return createNameNode(false, 39);
    }

    private StringLiteral createStringLiteral() {
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        StringLiteral stringLiteral = new StringLiteral(i2, tokenStream.tokenEnd - i2);
        stringLiteral.setLineno(this.ts.lineno);
        stringLiteral.setValue(this.ts.getString());
        stringLiteral.setQuoteCharacter(this.ts.getQuoteChar());
        return stringLiteral;
    }

    private AstNode defaultXmlNamespace() {
        if (this.currentToken != 117) {
            codeBug();
        }
        consumeToken();
        mustHaveXML();
        setRequiresActivation();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        if (!matchToken(39, true) || !"xml".equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(39, true) || !"namespace".equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(91, true)) {
            reportError("msg.bad.namespace");
        }
        AstNode astNodeExpr = expr();
        UnaryExpression unaryExpression = new UnaryExpression(i3, getNodeEnd(astNodeExpr) - i3);
        unaryExpression.setOperator(75);
        unaryExpression.setOperand(astNodeExpr);
        unaryExpression.setLineno(i2);
        return new ExpressionStatement((AstNode) unaryExpression, true);
    }

    private AstNode destructuringPrimaryExpr() {
        try {
            this.inDestructuringAssignment = true;
            return primaryExpr();
        } finally {
            this.inDestructuringAssignment = false;
        }
    }

    private DoLoop doLoop() {
        if (this.currentToken != 119) {
            codeBug();
        }
        consumeToken();
        int i2 = this.ts.tokenBeg;
        DoLoop doLoop = new DoLoop(i2);
        doLoop.setLineno(this.ts.lineno);
        enterLoop(doLoop);
        try {
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(doLoop);
            mustMatchToken(118, "msg.no.while.do", true);
            doLoop.setWhilePosition(this.ts.tokenBeg - i2);
            ConditionData conditionDataCondition = condition();
            doLoop.setCondition(conditionDataCondition.condition);
            doLoop.setParens(conditionDataCondition.lp - i2, conditionDataCondition.rp - i2);
            int nodeEnd = getNodeEnd(nextStatementAfterInlineComments);
            doLoop.setBody(nextStatementAfterInlineComments);
            exitLoop();
            if (matchToken(83, true)) {
                nodeEnd = this.ts.tokenEnd;
            }
            doLoop.setLength(nodeEnd - i2);
            return doLoop;
        } catch (Throwable th) {
            exitLoop();
            throw th;
        }
    }

    private void enterLoop(Loop loop) {
        if (this.loopSet == null) {
            this.loopSet = new ArrayList();
        }
        this.loopSet.add(loop);
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(loop);
        pushScope(loop);
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null) {
            labeledStatement.setStatement(loop);
            this.currentLabel.getFirstLabel().setLoop(loop);
            loop.setRelative(-this.currentLabel.getPosition());
        }
    }

    private void enterSwitch(SwitchStatement switchStatement) {
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(switchStatement);
    }

    private AstNode eqExpr() {
        AstNode astNodeRelExpr = relExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i2 = this.ts.tokenBeg;
            if (iPeekToken != 12 && iPeekToken != 13 && iPeekToken != 46 && iPeekToken != 47) {
                return astNodeRelExpr;
            }
            consumeToken();
            if (this.compilerEnv.getLanguageVersion() == 120) {
                if (iPeekToken == 12) {
                    iPeekToken = 46;
                } else if (iPeekToken == 13) {
                    iPeekToken = 47;
                }
            }
            astNodeRelExpr = new InfixExpression(iPeekToken, astNodeRelExpr, relExpr(), i2);
        }
    }

    private void exitLoop() {
        Loop loopRemove = this.loopSet.remove(r0.size() - 1);
        this.loopAndSwitchSet.remove(r1.size() - 1);
        if (loopRemove.getParent() != null) {
            loopRemove.setRelative(loopRemove.getParent().getPosition());
        }
        popScope();
    }

    private void exitSwitch() {
        this.loopAndSwitchSet.remove(r0.size() - 1);
    }

    private AstNode expr() {
        AstNode astNodeAssignExpr = assignExpr();
        int position = astNodeAssignExpr.getPosition();
        while (matchToken(90, true)) {
            int i2 = this.ts.tokenBeg;
            if (this.compilerEnv.isStrictMode() && !astNodeAssignExpr.hasSideEffects()) {
                addStrictWarning("msg.no.side.effects", "", position, nodeEnd(astNodeAssignExpr) - position);
            }
            if (peekToken() == 73) {
                reportError("msg.yield.parenthesized");
            }
            astNodeAssignExpr = new InfixExpression(90, astNodeAssignExpr, assignExpr(), i2);
        }
        return astNodeAssignExpr;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb A[Catch: all -> 0x016d, TryCatch #1 {all -> 0x016d, blocks: (B:6:0x0020, B:9:0x0029, B:11:0x0037, B:14:0x0043, B:16:0x004b, B:18:0x0052, B:20:0x0064, B:38:0x00e3, B:40:0x00eb, B:45:0x00f7, B:55:0x013d, B:57:0x0157, B:64:0x0169, B:65:0x016c, B:46:0x0106, B:48:0x010f, B:50:0x011c, B:53:0x0125, B:54:0x012a, B:22:0x0072, B:24:0x007c, B:26:0x0082, B:28:0x0090, B:29:0x009c, B:31:0x00a9, B:33:0x00be, B:35:0x00ce, B:36:0x00dc, B:32:0x00ba, B:12:0x003e, B:56:0x0148), top: B:73:0x0020, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0106 A[Catch: all -> 0x016d, TryCatch #1 {all -> 0x016d, blocks: (B:6:0x0020, B:9:0x0029, B:11:0x0037, B:14:0x0043, B:16:0x004b, B:18:0x0052, B:20:0x0064, B:38:0x00e3, B:40:0x00eb, B:45:0x00f7, B:55:0x013d, B:57:0x0157, B:64:0x0169, B:65:0x016c, B:46:0x0106, B:48:0x010f, B:50:0x011c, B:53:0x0125, B:54:0x012a, B:22:0x0072, B:24:0x007c, B:26:0x0082, B:28:0x0090, B:29:0x009c, B:31:0x00a9, B:33:0x00be, B:35:0x00ce, B:36:0x00dc, B:32:0x00ba, B:12:0x003e, B:56:0x0148), top: B:73:0x0020, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015e A[DONT_GENERATE] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.Loop forLoop() {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.forLoop():org.mozilla.javascript.ast.Loop");
    }

    private AstNode forLoopInit(int i2) {
        AstNode astNodeVariables;
        try {
            this.inForInit = true;
            if (i2 == 83) {
                astNodeVariables = new EmptyExpression(this.ts.tokenBeg, 1);
                astNodeVariables.setLineno(this.ts.lineno);
            } else if (i2 == 123 || i2 == 154) {
                consumeToken();
                astNodeVariables = variables(i2, this.ts.tokenBeg, false);
            } else {
                astNodeVariables = expr();
                markDestructuring(astNodeVariables);
            }
            return astNodeVariables;
        } finally {
            this.inForInit = false;
        }
    }

    private FunctionNode function(int i2) {
        return function(i2, false);
    }

    private AstNode generatorExpression(AstNode astNode, int i2) {
        return generatorExpression(astNode, i2, false);
    }

    private GeneratorExpressionLoop generatorExpressionLoop() {
        if (nextToken() != 120) {
            codeBug();
        }
        int i2 = this.ts.tokenBeg;
        GeneratorExpressionLoop generatorExpressionLoop = new GeneratorExpressionLoop(i2);
        pushScope(generatorExpressionLoop);
        try {
            int i3 = mustMatchToken(88, "msg.no.paren.for", true) ? this.ts.tokenBeg - i2 : -1;
            AstNode astNodeCreateNameNode = null;
            int iPeekToken = peekToken();
            if (iPeekToken == 39) {
                consumeToken();
                astNodeCreateNameNode = createNameNode();
            } else if (iPeekToken == 84 || iPeekToken == 86) {
                astNodeCreateNameNode = destructuringPrimaryExpr();
                markDestructuring(astNodeCreateNameNode);
            } else {
                reportError("msg.bad.var");
            }
            if (astNodeCreateNameNode.getType() == 39) {
                defineSymbol(154, this.ts.getString(), true);
            }
            int i4 = mustMatchToken(52, "msg.in.after.for.name", true) ? this.ts.tokenBeg - i2 : -1;
            AstNode astNodeExpr = expr();
            int i5 = mustMatchToken(89, "msg.no.paren.for.ctrl", true) ? this.ts.tokenBeg - i2 : -1;
            generatorExpressionLoop.setLength(this.ts.tokenEnd - i2);
            generatorExpressionLoop.setIterator(astNodeCreateNameNode);
            generatorExpressionLoop.setIteratedObject(astNodeExpr);
            generatorExpressionLoop.setInPosition(i4);
            generatorExpressionLoop.setParens(i3, i5);
            return generatorExpressionLoop;
        } finally {
            popScope();
        }
    }

    private Comment getAndResetJsDoc() {
        Comment comment = this.currentJsDocComment;
        this.currentJsDocComment = null;
        return comment;
    }

    private static String getDirective(AstNode astNode) {
        if (!(astNode instanceof ExpressionStatement)) {
            return null;
        }
        AstNode expression = ((ExpressionStatement) astNode).getExpression();
        if (expression instanceof StringLiteral) {
            return ((StringLiteral) expression).getValue();
        }
        return null;
    }

    private AstNode getNextStatementAfterInlineComments(AstNode astNode) {
        AstNode astNodeStatement = statement();
        if (162 != astNodeStatement.getType()) {
            return astNodeStatement;
        }
        AstNode astNodeStatement2 = statement();
        if (astNode != null) {
            astNode.setInlineComment(astNodeStatement);
        } else {
            astNodeStatement2.setInlineComment(astNodeStatement);
        }
        return astNodeStatement2;
    }

    private static int getNodeEnd(AstNode astNode) {
        return astNode.getLength() + astNode.getPosition();
    }

    private IfStatement ifStatement() {
        if (this.currentToken != 113) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        int i3 = tokenStream.lineno;
        int i4 = -1;
        IfStatement ifStatement = new IfStatement(i2);
        ConditionData conditionDataCondition = condition();
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(ifStatement);
        AstNode astNodeStatement = null;
        if (matchToken(114, true)) {
            if (peekToken() == 162) {
                ifStatement.setElseKeyWordInlineComment((AstNode) a.E(this.scannedComments, 1));
                consumeToken();
            }
            i4 = this.ts.tokenBeg - i2;
            astNodeStatement = statement();
        }
        ifStatement.setLength(getNodeEnd(astNodeStatement != null ? astNodeStatement : nextStatementAfterInlineComments) - i2);
        ifStatement.setCondition(conditionDataCondition.condition);
        ifStatement.setParens(conditionDataCondition.lp - i2, conditionDataCondition.rp - i2);
        ifStatement.setThenPart(nextStatementAfterInlineComments);
        ifStatement.setElsePart(astNodeStatement);
        ifStatement.setElsePosition(i4);
        ifStatement.setLineno(i3);
        return ifStatement;
    }

    private AstNode let(boolean z, int i2) {
        LetNode letNode = new LetNode(i2);
        letNode.setLineno(this.ts.lineno);
        boolean z2 = true;
        if (mustMatchToken(88, "msg.no.paren.after.let", true)) {
            letNode.setLp(this.ts.tokenBeg - i2);
        }
        pushScope(letNode);
        try {
            letNode.setVariables(variables(154, this.ts.tokenBeg, z));
            if (mustMatchToken(89, "msg.no.paren.let", true)) {
                letNode.setRp(this.ts.tokenBeg - i2);
            }
            if (z && peekToken() == 86) {
                consumeToken();
                int i3 = this.ts.tokenBeg;
                AstNode astNodeStatements = statements();
                mustMatchToken(87, "msg.no.curly.let", true);
                astNodeStatements.setLength(this.ts.tokenEnd - i3);
                letNode.setLength(this.ts.tokenEnd - i2);
                letNode.setBody(astNodeStatements);
                letNode.setType(154);
            } else {
                AstNode astNodeExpr = expr();
                letNode.setLength(getNodeEnd(astNodeExpr) - i2);
                letNode.setBody(astNodeExpr);
                if (z) {
                    if (insideFunction()) {
                        z2 = false;
                    }
                    ExpressionStatement expressionStatement = new ExpressionStatement(letNode, z2);
                    expressionStatement.setLineno(letNode.getLineno());
                    return expressionStatement;
                }
            }
            return letNode;
        } finally {
            popScope();
        }
    }

    private AstNode letStatement() {
        if (this.currentToken != 154) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        AstNode astNodeLet = peekToken() == 88 ? let(true, i3) : variables(154, i3, true);
        astNodeLet.setLineno(i2);
        return astNodeLet;
    }

    private int lineBeginningFor(int i2) {
        char[] cArr = this.sourceChars;
        if (cArr == null) {
            return -1;
        }
        if (i2 <= 0) {
            return 0;
        }
        if (i2 >= cArr.length) {
            i2 = cArr.length - 1;
        }
        do {
            i2--;
            if (i2 < 0) {
                return 0;
            }
        } while (!ScriptRuntime.isJSLineTerminator(cArr[i2]));
        return i2 + 1;
    }

    private ErrorNode makeErrorNode() {
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        ErrorNode errorNode = new ErrorNode(i2, tokenStream.tokenEnd - i2);
        errorNode.setLineno(this.ts.lineno);
        return errorNode;
    }

    private LabeledStatement matchJumpLabelName() {
        if (peekTokenOrEOL() == 39) {
            consumeToken();
            Map<String, LabeledStatement> map = this.labelSet;
            labeledStatement = map != null ? map.get(this.ts.getString()) : null;
            if (labeledStatement == null) {
                reportError("msg.undef.label");
            }
        }
        return labeledStatement;
    }

    private boolean matchToken(int i2, boolean z) {
        int iPeekToken = peekToken();
        while (iPeekToken == 162 && z) {
            consumeToken();
            iPeekToken = peekToken();
        }
        if (iPeekToken != i2) {
            return false;
        }
        consumeToken();
        return true;
    }

    private AstNode memberExpr(boolean z) {
        AstNode astNodePrimaryExpr;
        int iPeekToken = peekToken();
        int i2 = this.ts.lineno;
        if (iPeekToken != 30) {
            astNodePrimaryExpr = primaryExpr();
        } else {
            consumeToken();
            int i3 = this.ts.tokenBeg;
            NewExpression newExpression = new NewExpression(i3);
            AstNode astNodeMemberExpr = memberExpr(false);
            int nodeEnd = getNodeEnd(astNodeMemberExpr);
            newExpression.setTarget(astNodeMemberExpr);
            if (matchToken(88, true)) {
                int i4 = this.ts.tokenBeg;
                List<AstNode> listArgumentList = argumentList();
                if (listArgumentList != null && listArgumentList.size() > 65536) {
                    reportError("msg.too.many.constructor.args");
                }
                TokenStream tokenStream = this.ts;
                int i5 = tokenStream.tokenBeg;
                int i6 = tokenStream.tokenEnd;
                if (listArgumentList != null) {
                    newExpression.setArguments(listArgumentList);
                }
                newExpression.setParens(i4 - i3, i5 - i3);
                nodeEnd = i6;
            }
            if (matchToken(86, true)) {
                ObjectLiteral objectLiteral = objectLiteral();
                nodeEnd = getNodeEnd(objectLiteral);
                newExpression.setInitializer(objectLiteral);
            }
            newExpression.setLength(nodeEnd - i3);
            astNodePrimaryExpr = newExpression;
        }
        astNodePrimaryExpr.setLineno(i2);
        return memberExprTail(z, astNodePrimaryExpr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.mozilla.javascript.ast.AstNode] */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.mozilla.javascript.ast.AstNode] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [org.mozilla.javascript.Node, org.mozilla.javascript.ast.AstNode] */
    /* JADX WARN: Type inference failed for: r2v13, types: [org.mozilla.javascript.Node, org.mozilla.javascript.ast.AstNode, org.mozilla.javascript.ast.FunctionCall] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [org.mozilla.javascript.Node, org.mozilla.javascript.ast.ElementGet] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7, types: [org.mozilla.javascript.Node, org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.XmlDotQuery] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [org.mozilla.javascript.Parser] */
    private AstNode memberExprTail(boolean z, AstNode astNode) {
        ?? r3;
        if (astNode == 0) {
            codeBug();
        }
        int position = astNode.getPosition();
        while (true) {
            int iPeekToken = peekToken();
            int i2 = -1;
            if (iPeekToken == 84) {
                consumeToken();
                TokenStream tokenStream = this.ts;
                int i3 = tokenStream.tokenBeg;
                int i4 = tokenStream.lineno;
                AstNode astNodeExpr = expr();
                int nodeEnd = getNodeEnd(astNodeExpr);
                if (mustMatchToken(85, "msg.no.bracket.index", true)) {
                    TokenStream tokenStream2 = this.ts;
                    i2 = tokenStream2.tokenBeg;
                    nodeEnd = tokenStream2.tokenEnd;
                }
                ?? elementGet = new ElementGet(position, nodeEnd - position);
                elementGet.setTarget(astNode);
                elementGet.setElement(astNodeExpr);
                elementGet.setParens(i3, i2);
                elementGet.setLineno(i4);
                r3 = elementGet;
            } else if (iPeekToken != 88) {
                if (iPeekToken == 109 || iPeekToken == 144) {
                    int i5 = this.ts.lineno;
                    astNode = propertyAccess(iPeekToken, astNode);
                    astNode.setLineno(i5);
                } else if (iPeekToken == 147) {
                    consumeToken();
                    TokenStream tokenStream3 = this.ts;
                    int i6 = tokenStream3.tokenBeg;
                    int i7 = tokenStream3.lineno;
                    mustHaveXML();
                    setRequiresActivation();
                    AstNode astNodeExpr2 = expr();
                    int nodeEnd2 = getNodeEnd(astNodeExpr2);
                    if (mustMatchToken(89, "msg.no.paren", true)) {
                        TokenStream tokenStream4 = this.ts;
                        i2 = tokenStream4.tokenBeg;
                        nodeEnd2 = tokenStream4.tokenEnd;
                    }
                    ?? xmlDotQuery = new XmlDotQuery(position, nodeEnd2 - position);
                    xmlDotQuery.setLeft(astNode);
                    xmlDotQuery.setRight(astNodeExpr2);
                    xmlDotQuery.setOperatorPosition(i6);
                    xmlDotQuery.setRp(i2 - position);
                    xmlDotQuery.setLineno(i7);
                    r3 = xmlDotQuery;
                } else {
                    if (iPeekToken != 162) {
                        break;
                    }
                    int i8 = this.currentFlaggedToken;
                    peekUntilNonComment(iPeekToken);
                    int i9 = this.currentFlaggedToken;
                    if ((i9 & 65536) != 0) {
                        i8 = i9;
                    }
                    this.currentFlaggedToken = i8;
                }
            } else {
                if (!z) {
                    break;
                }
                int i10 = this.ts.lineno;
                consumeToken();
                checkCallRequiresActivation(astNode);
                ?? functionCall = new FunctionCall(position);
                functionCall.setTarget(astNode);
                functionCall.setLineno(i10);
                functionCall.setLp(this.ts.tokenBeg - position);
                List<AstNode> listArgumentList = argumentList();
                if (listArgumentList != null && listArgumentList.size() > 65536) {
                    reportError("msg.too.many.function.args");
                }
                functionCall.setArguments(listArgumentList);
                functionCall.setRp(this.ts.tokenBeg - position);
                functionCall.setLength(this.ts.tokenEnd - position);
                astNode = functionCall;
            }
            astNode = r3;
        }
        return astNode;
    }

    private ObjectProperty methodDefinition(int i2, AstNode astNode, int i3) {
        FunctionNode functionNodeFunction = function(2);
        Name functionName = functionNodeFunction.getFunctionName();
        if (functionName != null && functionName.length() != 0) {
            reportError("msg.bad.prop");
        }
        ObjectProperty objectProperty = new ObjectProperty(i2);
        if (i3 == 2) {
            objectProperty.setIsGetterMethod();
            functionNodeFunction.setFunctionIsGetterMethod();
        } else if (i3 == 4) {
            objectProperty.setIsSetterMethod();
            functionNodeFunction.setFunctionIsSetterMethod();
        } else if (i3 == 8) {
            objectProperty.setIsNormalMethod();
            functionNodeFunction.setFunctionIsNormalMethod();
        }
        int nodeEnd = getNodeEnd(functionNodeFunction);
        objectProperty.setLeft(astNode);
        objectProperty.setRight(functionNodeFunction);
        objectProperty.setLength(nodeEnd - i2);
        return objectProperty;
    }

    private AstNode mulExpr() {
        AstNode astNodeUnaryExpr = unaryExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i2 = this.ts.tokenBeg;
            switch (iPeekToken) {
                case 23:
                case 24:
                case 25:
                    consumeToken();
                    astNodeUnaryExpr = new InfixExpression(iPeekToken, astNodeUnaryExpr, unaryExpr(), i2);
                    break;
                default:
                    return astNodeUnaryExpr;
            }
        }
    }

    private void mustHaveXML() {
        if (this.compilerEnv.isXmlAvailable()) {
            return;
        }
        reportError("msg.XML.not.available");
    }

    private boolean mustMatchToken(int i2, String str, boolean z) {
        TokenStream tokenStream = this.ts;
        int i3 = tokenStream.tokenBeg;
        return mustMatchToken(i2, str, i3, tokenStream.tokenEnd - i3, z);
    }

    private AstNode name(int i2, int i3) {
        String string = this.ts.getString();
        TokenStream tokenStream = this.ts;
        int i4 = tokenStream.tokenBeg;
        int i5 = tokenStream.lineno;
        if ((i2 & 131072) == 0 || peekToken() != 104) {
            saveNameTokenData(i4, string, i5);
            return this.compilerEnv.isXmlAvailable() ? propertyName(-1, 0) : createNameNode(true, 39);
        }
        Label label = new Label(i4, this.ts.tokenEnd - i4);
        label.setName(string);
        label.setLineno(this.ts.lineno);
        return label;
    }

    private AstNode nameOrLabel() {
        AstNode astNodeStatementHelper;
        if (this.currentToken != 39) {
            throw codeBug();
        }
        int i2 = this.ts.tokenBeg;
        this.currentFlaggedToken |= 131072;
        AstNode astNodeExpr = expr();
        if (astNodeExpr.getType() != 131) {
            ExpressionStatement expressionStatement = new ExpressionStatement(astNodeExpr, !insideFunction());
            expressionStatement.lineno = astNodeExpr.lineno;
            return expressionStatement;
        }
        LabeledStatement labeledStatement = new LabeledStatement(i2);
        recordLabel((Label) astNodeExpr, labeledStatement);
        labeledStatement.setLineno(this.ts.lineno);
        while (true) {
            if (peekToken() != 39) {
                astNodeStatementHelper = null;
                break;
            }
            this.currentFlaggedToken |= 131072;
            AstNode astNodeExpr2 = expr();
            if (astNodeExpr2.getType() != 131) {
                astNodeStatementHelper = new ExpressionStatement(astNodeExpr2, !insideFunction());
                autoInsertSemicolon(astNodeStatementHelper);
                break;
            }
            recordLabel((Label) astNodeExpr2, labeledStatement);
        }
        try {
            this.currentLabel = labeledStatement;
            if (astNodeStatementHelper == null) {
                astNodeStatementHelper = statementHelper();
                if (peekToken() == 162) {
                    if (astNodeStatementHelper.getLineno() == this.scannedComments.get(r3.size() - 1).getLineno()) {
                        astNodeStatementHelper.setInlineComment(this.scannedComments.get(r2.size() - 1));
                        consumeToken();
                    }
                }
            }
            labeledStatement.setLength(astNodeStatementHelper.getParent() == null ? getNodeEnd(astNodeStatementHelper) - i2 : getNodeEnd(astNodeStatementHelper));
            labeledStatement.setStatement(astNodeStatementHelper);
            return labeledStatement;
        } finally {
            this.currentLabel = null;
            Iterator<Label> it = labeledStatement.getLabels().iterator();
            while (it.hasNext()) {
                this.labelSet.remove(it.next().getName());
            }
        }
    }

    private int nextToken() {
        int iPeekToken = peekToken();
        consumeToken();
        return iPeekToken;
    }

    private static int nodeEnd(AstNode astNode) {
        return astNode.getLength() + astNode.getPosition();
    }

    private static final boolean nowAllSet(int i2, int i3, int i4) {
        return (i2 & i4) != i4 && (i3 & i4) == i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0113 A[LOOP:0: B:7:0x0024->B:76:0x0113, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011a A[EDGE_INSN: B:83:0x011a->B:77:0x011a BREAK  A[LOOP:0: B:7:0x0024->B:76:0x0113], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.ObjectLiteral objectLiteral() {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.objectLiteral():org.mozilla.javascript.ast.ObjectLiteral");
    }

    private AstNode objliteralProperty() {
        switch (peekToken()) {
            case 39:
                return createNameNode();
            case 40:
                TokenStream tokenStream = this.ts;
                return new NumberLiteral(tokenStream.tokenBeg, tokenStream.getString(), this.ts.getNumber());
            case 41:
                return createStringLiteral();
            default:
                if (this.compilerEnv.isReservedKeywordAsIdentifier() && TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective)) {
                    return createNameNode();
                }
                return null;
        }
    }

    private AstNode orExpr() {
        AstNode astNodeAndExpr = andExpr();
        if (!matchToken(105, true)) {
            return astNodeAndExpr;
        }
        return new InfixExpression(105, astNodeAndExpr, orExpr(), this.ts.tokenBeg);
    }

    private AstNode parenExpr() {
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            Comment andResetJsDoc = getAndResetJsDoc();
            TokenStream tokenStream = this.ts;
            int i2 = tokenStream.lineno;
            int i3 = tokenStream.tokenBeg;
            AstNode emptyExpression = peekToken() == 89 ? new EmptyExpression(i3) : expr();
            if (peekToken() == 120) {
                return generatorExpression(emptyExpression, i3);
            }
            mustMatchToken(89, "msg.no.paren", true);
            if (emptyExpression.getType() == 129 && peekToken() != 165) {
                reportError("msg.syntax");
                return makeErrorNode();
            }
            ParenthesizedExpression parenthesizedExpression = new ParenthesizedExpression(i3, this.ts.tokenEnd - i3, emptyExpression);
            parenthesizedExpression.setLineno(i2);
            if (andResetJsDoc == null) {
                andResetJsDoc = getAndResetJsDoc();
            }
            if (andResetJsDoc != null) {
                parenthesizedExpression.setJsDocNode(andResetJsDoc);
            }
            return parenthesizedExpression;
        } finally {
            this.inForInit = z;
        }
    }

    private AstNode parseFunctionBody(int i2, FunctionNode functionNode) {
        boolean z;
        Comment commentFunction;
        if (matchToken(86, true)) {
            z = false;
        } else if (this.compilerEnv.getLanguageVersion() >= 180 || i2 == 4) {
            z = true;
        } else {
            reportError("msg.no.brace.body");
            z = false;
        }
        boolean z2 = i2 == 4;
        this.nestingOfFunction++;
        int i3 = this.ts.tokenBeg;
        Block block = new Block(i3);
        boolean z3 = this.inUseStrictDirective;
        this.inUseStrictDirective = false;
        block.setLineno(this.ts.lineno);
        try {
            if (z) {
                AstNode astNodeAssignExpr = assignExpr();
                ReturnStatement returnStatement = new ReturnStatement(astNodeAssignExpr.getPosition(), astNodeAssignExpr.getLength(), astNodeAssignExpr);
                Boolean bool = Boolean.TRUE;
                returnStatement.putProp(25, bool);
                block.putProp(25, bool);
                if (z2) {
                    returnStatement.putProp(27, bool);
                }
                block.addStatement(returnStatement);
            } else {
                boolean z4 = true;
                while (true) {
                    int iPeekToken = peekToken();
                    if (iPeekToken == -1 || iPeekToken == 0 || iPeekToken == 87) {
                        break;
                    }
                    if (iPeekToken == 110) {
                        consumeToken();
                        commentFunction = function(1);
                    } else if (iPeekToken != 162) {
                        commentFunction = statement();
                        if (z4) {
                            String directive = getDirective(commentFunction);
                            if (directive == null) {
                                z4 = false;
                            } else if (directive.equals("use strict")) {
                                this.inUseStrictDirective = true;
                                functionNode.setInStrictMode(true);
                                if (!z3) {
                                    setRequiresActivation();
                                }
                            }
                        }
                    } else {
                        consumeToken();
                        List<Comment> list = this.scannedComments;
                        commentFunction = list.get(list.size() - 1);
                    }
                    block.addStatement(commentFunction);
                }
            }
        } catch (ParserException unused) {
        } catch (Throwable th) {
            this.nestingOfFunction--;
            this.inUseStrictDirective = z3;
            throw th;
        }
        this.nestingOfFunction--;
        this.inUseStrictDirective = z3;
        int i4 = this.ts.tokenEnd;
        getAndResetJsDoc();
        if (!z && mustMatchToken(87, "msg.no.brace.after.body", true)) {
            i4 = this.ts.tokenEnd;
        }
        block.setLength(i4 - i3);
        return block;
    }

    private void parseFunctionParams(FunctionNode functionNode) {
        if (matchToken(89, true)) {
            functionNode.setRp(this.ts.tokenBeg - functionNode.getPosition());
            return;
        }
        HashMap map = null;
        HashSet hashSet = new HashSet();
        do {
            int iPeekToken = peekToken();
            if (iPeekToken == 84 || iPeekToken == 86) {
                AstNode astNodeDestructuringPrimaryExpr = destructuringPrimaryExpr();
                markDestructuring(astNodeDestructuringPrimaryExpr);
                functionNode.addParam(astNodeDestructuringPrimaryExpr);
                if (map == null) {
                    map = new HashMap();
                }
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(88, nextTempName, false);
                map.put(nextTempName, astNodeDestructuringPrimaryExpr);
            } else if (mustMatchToken(39, "msg.no.parm", true)) {
                AstNode astNodeCreateNameNode = createNameNode();
                Comment andResetJsDoc = getAndResetJsDoc();
                if (andResetJsDoc != null) {
                    astNodeCreateNameNode.setJsDocNode(andResetJsDoc);
                }
                functionNode.addParam(astNodeCreateNameNode);
                String string = this.ts.getString();
                defineSymbol(88, string);
                if (this.inUseStrictDirective) {
                    if ("eval".equals(string) || "arguments".equals(string)) {
                        reportError("msg.bad.id.strict", string);
                    }
                    if (hashSet.contains(string)) {
                        addError("msg.dup.param.strict", string);
                    }
                    hashSet.add(string);
                }
            } else {
                functionNode.addParam(makeErrorNode());
            }
        } while (matchToken(90, true));
        if (map != null) {
            Node node = new Node(90);
            for (Map.Entry entry : map.entrySet()) {
                node.addChildToBack(createDestructuringAssignment(123, (Node) entry.getValue(), createName((String) entry.getKey())));
            }
            functionNode.putProp(23, node);
        }
        if (mustMatchToken(89, "msg.no.paren.after.parms", true)) {
            functionNode.setRp(this.ts.tokenBeg - functionNode.getPosition());
        }
    }

    private int peekFlaggedToken() {
        peekToken();
        return this.currentFlaggedToken;
    }

    private int peekToken() {
        if (this.currentFlaggedToken != 0) {
            return this.currentToken;
        }
        int lineno = this.ts.getLineno();
        int token = this.ts.getToken();
        boolean z = false;
        while (true) {
            if (token != 1 && token != 162) {
                break;
            }
            if (token == 1) {
                lineno++;
                token = this.ts.getToken();
                z = true;
            } else {
                if (this.compilerEnv.isRecordingComments()) {
                    recordComment(lineno, this.ts.getAndResetCurrentComment());
                    break;
                }
                token = this.ts.getToken();
            }
        }
        this.currentToken = token;
        this.currentFlaggedToken = token | (z ? 65536 : 0);
        return token;
    }

    private int peekTokenOrEOL() {
        int iPeekToken = peekToken();
        if ((this.currentFlaggedToken & 65536) != 0) {
            return 1;
        }
        return iPeekToken;
    }

    private int peekUntilNonComment(int i2) {
        while (i2 == 162) {
            consumeToken();
            i2 = peekToken();
        }
        return i2;
    }

    private ObjectProperty plainProperty(AstNode astNode, int i2) {
        int iPeekToken = peekToken();
        if ((iPeekToken != 90 && iPeekToken != 87) || i2 != 39 || this.compilerEnv.getLanguageVersion() < 180) {
            mustMatchToken(104, "msg.no.colon.prop", true);
            ObjectProperty objectProperty = new ObjectProperty();
            objectProperty.setOperatorPosition(this.ts.tokenBeg);
            objectProperty.setLeftAndRight(astNode, assignExpr());
            return objectProperty;
        }
        if (!this.inDestructuringAssignment) {
            reportError("msg.bad.object.init");
        }
        Name name = new Name(astNode.getPosition(), astNode.getString());
        ObjectProperty objectProperty2 = new ObjectProperty();
        objectProperty2.putProp(26, Boolean.TRUE);
        objectProperty2.setLeftAndRight(astNode, name);
        return objectProperty2;
    }

    private AstNode primaryExpr() {
        int iPeekFlaggedToken = peekFlaggedToken();
        int i2 = 65535 & iPeekFlaggedToken;
        if (i2 == -1) {
            consumeToken();
        } else {
            if (i2 != 0) {
                if (i2 != 24) {
                    if (i2 == 84) {
                        consumeToken();
                        return arrayLiteral();
                    }
                    if (i2 == 86) {
                        consumeToken();
                        return objectLiteral();
                    }
                    if (i2 == 88) {
                        consumeToken();
                        return parenExpr();
                    }
                    if (i2 != 101) {
                        if (i2 == 110) {
                            consumeToken();
                            return function(2);
                        }
                        if (i2 == 128) {
                            consumeToken();
                            reportError("msg.reserved.id", this.ts.getString());
                        } else {
                            if (i2 == 148) {
                                consumeToken();
                                mustHaveXML();
                                return attributeAccess();
                            }
                            if (i2 == 154) {
                                consumeToken();
                                return let(false, this.ts.tokenBeg);
                            }
                            switch (i2) {
                                case 39:
                                    consumeToken();
                                    return name(iPeekFlaggedToken, i2);
                                case 40:
                                    consumeToken();
                                    String string = this.ts.getString();
                                    if (this.inUseStrictDirective && this.ts.isNumberOldOctal()) {
                                        reportError("msg.no.old.octal.strict");
                                    }
                                    if (this.ts.isNumberBinary()) {
                                        string = a.i("0b", string);
                                    }
                                    if (this.ts.isNumberOldOctal()) {
                                        string = a.i("0", string);
                                    }
                                    if (this.ts.isNumberOctal()) {
                                        string = a.i("0o", string);
                                    }
                                    if (this.ts.isNumberHex()) {
                                        string = a.i("0x", string);
                                    }
                                    TokenStream tokenStream = this.ts;
                                    return new NumberLiteral(tokenStream.tokenBeg, string, tokenStream.getNumber());
                                case 41:
                                    consumeToken();
                                    return createStringLiteral();
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    consumeToken();
                                    TokenStream tokenStream2 = this.ts;
                                    int i3 = tokenStream2.tokenBeg;
                                    return new KeywordLiteral(i3, tokenStream2.tokenEnd - i3, i2);
                                default:
                                    consumeToken();
                                    reportError("msg.syntax");
                                    break;
                            }
                        }
                    }
                }
                consumeToken();
                this.ts.readRegExp(i2);
                TokenStream tokenStream3 = this.ts;
                int i4 = tokenStream3.tokenBeg;
                RegExpLiteral regExpLiteral = new RegExpLiteral(i4, tokenStream3.tokenEnd - i4);
                regExpLiteral.setValue(this.ts.getString());
                regExpLiteral.setFlags(this.ts.readAndClearRegExpFlags());
                return regExpLiteral;
            }
            consumeToken();
            reportError("msg.unexpected.eof");
        }
        consumeToken();
        return makeErrorNode();
    }

    private AstNode propertyAccess(int i2, AstNode astNode) {
        AstNode astNodePropertyName;
        String strKeywordToName;
        if (astNode == null) {
            codeBug();
        }
        int i3 = 0;
        TokenStream tokenStream = this.ts;
        int i4 = tokenStream.lineno;
        int i5 = tokenStream.tokenBeg;
        consumeToken();
        if (i2 == 144) {
            mustHaveXML();
            i3 = 4;
        }
        if (!this.compilerEnv.isXmlAvailable()) {
            if (nextToken() != 39 && (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective))) {
                reportError("msg.no.name.after.dot");
            }
            PropertyGet propertyGet = new PropertyGet(astNode, createNameNode(true, 33), i5);
            propertyGet.setLineno(i4);
            return propertyGet;
        }
        int iNextToken = nextToken();
        if (iNextToken == 23) {
            TokenStream tokenStream2 = this.ts;
            saveNameTokenData(tokenStream2.tokenBeg, "*", tokenStream2.lineno);
            astNodePropertyName = propertyName(-1, i3);
        } else if (iNextToken == 39) {
            astNodePropertyName = propertyName(-1, i3);
        } else if (iNextToken == 50) {
            TokenStream tokenStream3 = this.ts;
            saveNameTokenData(tokenStream3.tokenBeg, "throw", tokenStream3.lineno);
            astNodePropertyName = propertyName(-1, i3);
        } else if (iNextToken == 128) {
            String string = this.ts.getString();
            TokenStream tokenStream4 = this.ts;
            saveNameTokenData(tokenStream4.tokenBeg, string, tokenStream4.lineno);
            astNodePropertyName = propertyName(-1, i3);
        } else if (iNextToken == 148) {
            astNodePropertyName = attributeAccess();
        } else {
            if (!this.compilerEnv.isReservedKeywordAsIdentifier() || (strKeywordToName = Token.keywordToName(iNextToken)) == null) {
                reportError("msg.no.name.after.dot");
                return makeErrorNode();
            }
            TokenStream tokenStream5 = this.ts;
            saveNameTokenData(tokenStream5.tokenBeg, strKeywordToName, tokenStream5.lineno);
            astNodePropertyName = propertyName(-1, i3);
        }
        boolean z = astNodePropertyName instanceof XmlRef;
        InfixExpression xmlMemberGet = z ? new XmlMemberGet() : new PropertyGet();
        if (z && i2 == 109) {
            xmlMemberGet.setType(109);
        }
        int position = astNode.getPosition();
        xmlMemberGet.setPosition(position);
        xmlMemberGet.setLength(getNodeEnd(astNodePropertyName) - position);
        xmlMemberGet.setOperatorPosition(i5 - position);
        xmlMemberGet.setLineno(astNode.getLineno());
        xmlMemberGet.setLeft(astNode);
        xmlMemberGet.setRight(astNodePropertyName);
        return xmlMemberGet;
    }

    private AstNode propertyName(int i2, int i3) {
        int i4;
        Name nameCreateNameNode;
        int i5 = i2 != -1 ? i2 : this.ts.tokenBeg;
        int i6 = this.ts.lineno;
        Name nameCreateNameNode2 = createNameNode(true, this.currentToken);
        if (matchToken(Token.COLONCOLON, true)) {
            i4 = this.ts.tokenBeg;
            int iNextToken = nextToken();
            if (iNextToken == 23) {
                TokenStream tokenStream = this.ts;
                saveNameTokenData(tokenStream.tokenBeg, "*", tokenStream.lineno);
                nameCreateNameNode = createNameNode(false, -1);
            } else {
                if (iNextToken != 39) {
                    if (iNextToken == 84) {
                        return xmlElemRef(i2, nameCreateNameNode2, i4);
                    }
                    reportError("msg.no.name.after.coloncolon");
                    return makeErrorNode();
                }
                nameCreateNameNode = createNameNode();
            }
        } else {
            i4 = -1;
            nameCreateNameNode = nameCreateNameNode2;
            nameCreateNameNode2 = null;
        }
        if (nameCreateNameNode2 == null && i3 == 0 && i2 == -1) {
            return nameCreateNameNode;
        }
        XmlPropRef xmlPropRef = new XmlPropRef(i5, getNodeEnd(nameCreateNameNode) - i5);
        xmlPropRef.setAtPos(i2);
        xmlPropRef.setNamespace(nameCreateNameNode2);
        xmlPropRef.setColonPos(i4);
        xmlPropRef.setPropName(nameCreateNameNode);
        xmlPropRef.setLineno(i6);
        return xmlPropRef;
    }

    private void recordComment(int i2, String str) {
        if (this.scannedComments == null) {
            this.scannedComments = new ArrayList();
        }
        TokenStream tokenStream = this.ts;
        Comment comment = new Comment(tokenStream.tokenBeg, tokenStream.getTokenLength(), this.ts.commentType, str);
        if (this.ts.commentType == Token.CommentType.JSDOC && this.compilerEnv.isRecordingLocalJsDocComments()) {
            TokenStream tokenStream2 = this.ts;
            Comment comment2 = new Comment(tokenStream2.tokenBeg, tokenStream2.getTokenLength(), this.ts.commentType, str);
            this.currentJsDocComment = comment2;
            comment2.setLineno(i2);
        }
        comment.setLineno(i2);
        this.scannedComments.add(comment);
    }

    private void recordLabel(Label label, LabeledStatement labeledStatement) {
        if (peekToken() != 104) {
            codeBug();
        }
        consumeToken();
        String name = label.getName();
        Map<String, LabeledStatement> map = this.labelSet;
        if (map == null) {
            this.labelSet = new HashMap();
        } else {
            LabeledStatement labeledStatement2 = map.get(name);
            if (labeledStatement2 != null) {
                if (this.compilerEnv.isIdeMode()) {
                    Label labelByName = labeledStatement2.getLabelByName(name);
                    reportError("msg.dup.label", labelByName.getAbsolutePosition(), labelByName.getLength());
                }
                reportError("msg.dup.label", label.getPosition(), label.getLength());
            }
        }
        labeledStatement.addLabel(label);
        this.labelSet.put(name, labeledStatement);
    }

    private AstNode relExpr() {
        AstNode astNodeShiftExpr = shiftExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i2 = this.ts.tokenBeg;
            if (iPeekToken != 52) {
                if (iPeekToken != 53) {
                    switch (iPeekToken) {
                    }
                } else {
                    continue;
                }
                consumeToken();
                astNodeShiftExpr = new InfixExpression(iPeekToken, astNodeShiftExpr, shiftExpr(), i2);
            } else if (!this.inForInit) {
                consumeToken();
                astNodeShiftExpr = new InfixExpression(iPeekToken, astNodeShiftExpr, shiftExpr(), i2);
            }
        }
        return astNodeShiftExpr;
    }

    private AstNode returnOrYield(int i2, boolean z) {
        AstNode yield;
        if (!insideFunction()) {
            reportError(i2 == 4 ? "msg.bad.return" : "msg.bad.yield");
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i3 = tokenStream.lineno;
        int i4 = tokenStream.tokenBeg;
        int nodeEnd = tokenStream.tokenEnd;
        boolean z2 = false;
        if (i2 == 73 && this.compilerEnv.getLanguageVersion() >= 200 && peekToken() == 23) {
            consumeToken();
            z2 = true;
        }
        AstNode astNodeExpr = null;
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL != -1 && iPeekTokenOrEOL != 0 && iPeekTokenOrEOL != 1 && (iPeekTokenOrEOL == 73 ? this.compilerEnv.getLanguageVersion() >= 200 : iPeekTokenOrEOL != 83 && iPeekTokenOrEOL != 85 && iPeekTokenOrEOL != 87 && iPeekTokenOrEOL != 89)) {
            astNodeExpr = expr();
            nodeEnd = getNodeEnd(astNodeExpr);
        }
        int i5 = this.endFlags;
        if (i2 == 4) {
            this.endFlags = i5 | (astNodeExpr == null ? 2 : 4);
            int i6 = nodeEnd - i4;
            yield = new ReturnStatement(i4, i6, astNodeExpr);
            if (nowAllSet(i5, this.endFlags, 6)) {
                addStrictWarning("msg.return.inconsistent", "", i4, i6);
            }
        } else {
            if (!insideFunction()) {
                reportError("msg.bad.yield");
            }
            this.endFlags |= 8;
            yield = new Yield(i4, nodeEnd - i4, astNodeExpr, z2);
            setRequiresActivation();
            setIsGenerator();
            if (!z) {
                yield = new ExpressionStatement(yield);
            }
        }
        if (insideFunction() && nowAllSet(i5, this.endFlags, 12) && !((FunctionNode) this.currentScriptOrFn).isES6Generator()) {
            Name functionName = ((FunctionNode) this.currentScriptOrFn).getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                addError("msg.anon.generator.returns", "");
            } else {
                addError("msg.generator.returns", functionName.getIdentifier());
            }
        }
        yield.setLineno(i3);
        return yield;
    }

    private void saveNameTokenData(int i2, String str, int i3) {
        this.prevNameTokenStart = i2;
        this.prevNameTokenString = str;
        this.prevNameTokenLineno = i3;
    }

    private AstNode shiftExpr() {
        AstNode astNodeAddExpr = addExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i2 = this.ts.tokenBeg;
            switch (iPeekToken) {
                case 18:
                case 19:
                case 20:
                    consumeToken();
                    astNodeAddExpr = new InfixExpression(iPeekToken, astNodeAddExpr, addExpr(), i2);
                    break;
                default:
                    return astNodeAddExpr;
            }
        }
    }

    private AstNode statement() {
        int iPeekTokenOrEOL;
        int i2 = this.ts.tokenBeg;
        try {
            AstNode astNodeStatementHelper = statementHelper();
            if (astNodeStatementHelper != null) {
                if (this.compilerEnv.isStrictMode() && !astNodeStatementHelper.hasSideEffects()) {
                    int position = astNodeStatementHelper.getPosition();
                    int iMax = Math.max(position, lineBeginningFor(position));
                    addStrictWarning(astNodeStatementHelper instanceof EmptyStatement ? "msg.extra.trailing.semi" : "msg.no.side.effects", "", iMax, nodeEnd(astNodeStatementHelper) - iMax);
                }
                if (peekToken() == 162) {
                    int lineno = astNodeStatementHelper.getLineno();
                    List<Comment> list = this.scannedComments;
                    if (lineno == list.get(list.size() - 1).getLineno()) {
                        List<Comment> list2 = this.scannedComments;
                        astNodeStatementHelper.setInlineComment(list2.get(list2.size() - 1));
                        consumeToken();
                    }
                }
                return astNodeStatementHelper;
            }
        } catch (ParserException unused) {
        }
        do {
            iPeekTokenOrEOL = peekTokenOrEOL();
            consumeToken();
            if (iPeekTokenOrEOL == -1 || iPeekTokenOrEOL == 0 || iPeekTokenOrEOL == 1) {
                break;
            }
        } while (iPeekTokenOrEOL != 83);
        return new EmptyStatement(i2, this.ts.tokenBeg - i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.AstNode statementHelper() {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.statementHelper():org.mozilla.javascript.ast.AstNode");
    }

    private AstNode statements(AstNode astNode) {
        if (this.currentToken != 86 && !this.compilerEnv.isIdeMode()) {
            codeBug();
        }
        int i2 = this.ts.tokenBeg;
        if (astNode == null) {
            astNode = new Block(i2);
        }
        astNode.setLineno(this.ts.lineno);
        while (true) {
            int iPeekToken = peekToken();
            if (iPeekToken <= 0 || iPeekToken == 87) {
                break;
            }
            astNode.addChild(statement());
        }
        astNode.setLength(this.ts.tokenBeg - i2);
        return astNode;
    }

    private SwitchStatement switchStatement() {
        if (this.currentToken != 115) {
            codeBug();
        }
        consumeToken();
        int i2 = this.ts.tokenBeg;
        SwitchStatement switchStatement = new SwitchStatement(i2);
        if (mustMatchToken(88, "msg.no.paren.switch", true)) {
            switchStatement.setLp(this.ts.tokenBeg - i2);
        }
        switchStatement.setLineno(this.ts.lineno);
        switchStatement.setExpression(expr());
        enterSwitch(switchStatement);
        try {
            if (mustMatchToken(89, "msg.no.paren.after.switch", true)) {
                switchStatement.setRp(this.ts.tokenBeg - i2);
            }
            mustMatchToken(86, "msg.no.brace.switch", true);
            boolean z = false;
            while (true) {
                int iNextToken = nextToken();
                TokenStream tokenStream = this.ts;
                int i3 = tokenStream.tokenBeg;
                int i4 = tokenStream.lineno;
                AstNode astNodeExpr = null;
                if (iNextToken == 87) {
                    switchStatement.setLength(tokenStream.tokenEnd - i2);
                    break;
                }
                if (iNextToken != 162) {
                    if (iNextToken == 116) {
                        astNodeExpr = expr();
                        mustMatchToken(104, "msg.no.colon.case", true);
                    } else {
                        if (iNextToken != 117) {
                            reportError("msg.bad.switch");
                            break;
                        }
                        if (z) {
                            reportError("msg.double.switch.default");
                        }
                        mustMatchToken(104, "msg.no.colon.case", true);
                        z = true;
                    }
                    SwitchCase switchCase = new SwitchCase(i3);
                    switchCase.setExpression(astNodeExpr);
                    switchCase.setLength(this.ts.tokenEnd - i2);
                    switchCase.setLineno(i4);
                    while (true) {
                        int iPeekToken = peekToken();
                        if (iPeekToken == 87 || iPeekToken == 116 || iPeekToken == 117 || iPeekToken == 0) {
                            break;
                        }
                        if (iPeekToken == 162) {
                            List<Comment> list = this.scannedComments;
                            Comment comment = list.get(list.size() - 1);
                            if (switchCase.getInlineComment() == null && comment.getLineno() == switchCase.getLineno()) {
                                switchCase.setInlineComment(comment);
                            } else {
                                switchCase.addStatement(comment);
                            }
                            consumeToken();
                        } else {
                            switchCase.addStatement(statement());
                        }
                    }
                    switchStatement.addCase(switchCase);
                } else {
                    List<Comment> list2 = this.scannedComments;
                    switchStatement.addChild(list2.get(list2.size() - 1));
                }
            }
            return switchStatement;
        } finally {
            exitSwitch();
        }
    }

    private ThrowStatement throwStatement() {
        if (this.currentToken != 50) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        int i3 = tokenStream.lineno;
        if (peekTokenOrEOL() == 1) {
            reportError("msg.bad.throw.eol");
        }
        ThrowStatement throwStatement = new ThrowStatement(i2, expr());
        throwStatement.setLineno(i3);
        return throwStatement;
    }

    private TryStatement tryStatement() {
        Comment comment;
        int i2;
        boolean z;
        ArrayList arrayList;
        int i3;
        AstNode astNode;
        int i4;
        AstNode astNodeExpr;
        boolean z2;
        if (this.currentToken != 82) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        TokenStream tokenStream = this.ts;
        int i5 = tokenStream.tokenBeg;
        int i6 = tokenStream.lineno;
        TryStatement tryStatement = new TryStatement(i5);
        int iPeekToken = peekToken();
        if (iPeekToken == 162) {
            tryStatement.setInlineComment((Comment) a.E(this.scannedComments, 1));
            consumeToken();
            iPeekToken = peekToken();
        }
        if (iPeekToken != 86) {
            reportError("msg.no.brace.try");
        }
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(tryStatement);
        int nodeEnd = getNodeEnd(nextStatementAfterInlineComments);
        boolean z3 = false;
        int iPeekToken2 = peekToken();
        int i7 = Token.CATCH;
        if (iPeekToken2 == 125) {
            arrayList = null;
            for (boolean z4 = true; matchToken(i7, z4); z4 = true) {
                int i8 = this.ts.lineno;
                if (z3) {
                    reportError("msg.catch.unreachable");
                }
                int i9 = this.ts.tokenBeg;
                int i10 = mustMatchToken(88, "msg.no.paren.catch", z4) ? this.ts.tokenBeg : -1;
                mustMatchToken(39, "msg.bad.catchcond", z4);
                Name nameCreateNameNode = createNameNode();
                Comment andResetJsDoc2 = getAndResetJsDoc();
                if (andResetJsDoc2 != null) {
                    nameCreateNameNode.setJsDocNode(andResetJsDoc2);
                }
                String identifier = nameCreateNameNode.getIdentifier();
                if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                    reportError("msg.bad.id.strict", identifier);
                }
                if (matchToken(113, z4)) {
                    i4 = this.ts.tokenBeg;
                    astNodeExpr = expr();
                    z2 = z3;
                } else {
                    i4 = -1;
                    astNodeExpr = null;
                    z2 = true;
                }
                int i11 = mustMatchToken(89, "msg.bad.catchcond", z4) ? this.ts.tokenBeg : -1;
                Comment comment2 = andResetJsDoc;
                mustMatchToken(86, "msg.no.brace.catchblock", z4);
                Block block = (Block) statements();
                int nodeEnd2 = getNodeEnd(block);
                CatchClause catchClause = new CatchClause(i9);
                catchClause.setVarName(nameCreateNameNode);
                catchClause.setCatchCondition(astNodeExpr);
                catchClause.setBody(block);
                if (i4 != -1) {
                    catchClause.setIfPosition(i4 - i9);
                }
                catchClause.setParens(i10, i11);
                catchClause.setLineno(i8);
                nodeEnd = mustMatchToken(87, "msg.no.brace.after.body", true) ? this.ts.tokenEnd : nodeEnd2;
                catchClause.setLength(nodeEnd - i9);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(catchClause);
                i7 = Token.CATCH;
                z3 = z2;
                andResetJsDoc = comment2;
            }
            comment = andResetJsDoc;
            i2 = 126;
            z = true;
        } else {
            comment = andResetJsDoc;
            i2 = 126;
            if (iPeekToken2 != 126) {
                z = true;
                mustMatchToken(126, "msg.try.no.catchfinally", true);
            } else {
                z = true;
            }
            arrayList = null;
        }
        if (matchToken(i2, z)) {
            i3 = this.ts.tokenBeg;
            AstNode astNodeStatement = statement();
            astNode = astNodeStatement;
            nodeEnd = getNodeEnd(astNodeStatement);
        } else {
            i3 = -1;
            astNode = null;
        }
        tryStatement.setLength(nodeEnd - i5);
        tryStatement.setTryBlock(nextStatementAfterInlineComments);
        tryStatement.setCatchClauses(arrayList);
        tryStatement.setFinallyBlock(astNode);
        if (i3 != -1) {
            tryStatement.setFinallyPosition(i3 - i5);
        }
        tryStatement.setLineno(i6);
        if (comment != null) {
            tryStatement.setJsDocNode(comment);
        }
        return tryStatement;
    }

    private AstNode unaryExpr() {
        int iPeekToken = peekToken();
        if (iPeekToken == 162) {
            consumeToken();
            iPeekToken = peekUntilNonComment(iPeekToken);
        }
        int i2 = this.ts.lineno;
        if (iPeekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (iPeekToken != 14) {
            if (iPeekToken != 127) {
                if (iPeekToken == 21) {
                    consumeToken();
                    UnaryExpression unaryExpression = new UnaryExpression(28, this.ts.tokenBeg, unaryExpr());
                    unaryExpression.setLineno(i2);
                    return unaryExpression;
                }
                if (iPeekToken == 22) {
                    consumeToken();
                    UnaryExpression unaryExpression2 = new UnaryExpression(29, this.ts.tokenBeg, unaryExpr());
                    unaryExpression2.setLineno(i2);
                    return unaryExpression2;
                }
                if (iPeekToken != 26 && iPeekToken != 27) {
                    if (iPeekToken == 31) {
                        consumeToken();
                        UnaryExpression unaryExpression3 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, unaryExpr());
                        unaryExpression3.setLineno(i2);
                        return unaryExpression3;
                    }
                    if (iPeekToken != 32) {
                        if (iPeekToken == 107 || iPeekToken == 108) {
                            consumeToken();
                            UnaryExpression unaryExpression4 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, memberExpr(true));
                            unaryExpression4.setLineno(i2);
                            checkBadIncDec(unaryExpression4);
                            return unaryExpression4;
                        }
                    }
                }
            }
            consumeToken();
            UnaryExpression unaryExpression5 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, unaryExpr());
            unaryExpression5.setLineno(i2);
            return unaryExpression5;
        }
        if (this.compilerEnv.isXmlAvailable()) {
            consumeToken();
            return memberExprTail(true, xmlInitializer());
        }
        AstNode astNodeMemberExpr = memberExpr(true);
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL != 107 && iPeekTokenOrEOL != 108) {
            return astNodeMemberExpr;
        }
        consumeToken();
        UnaryExpression unaryExpression6 = new UnaryExpression(iPeekTokenOrEOL, this.ts.tokenBeg, astNodeMemberExpr, true);
        unaryExpression6.setLineno(i2);
        checkBadIncDec(unaryExpression6);
        return unaryExpression6;
    }

    private VariableDeclaration variables(int i2, int i3, boolean z) {
        AstNode astNodeDestructuringPrimaryExpr;
        int nodeEnd;
        Name name;
        VariableDeclaration variableDeclaration = new VariableDeclaration(i3);
        variableDeclaration.setType(i2);
        variableDeclaration.setLineno(this.ts.lineno);
        Comment andResetJsDoc = getAndResetJsDoc();
        if (andResetJsDoc != null) {
            variableDeclaration.setJsDocNode(andResetJsDoc);
        }
        do {
            int iPeekToken = peekToken();
            TokenStream tokenStream = this.ts;
            int i4 = tokenStream.tokenBeg;
            int i5 = tokenStream.tokenEnd;
            AstNode astNodeAssignExpr = null;
            if (iPeekToken == 84 || iPeekToken == 86) {
                astNodeDestructuringPrimaryExpr = destructuringPrimaryExpr();
                int nodeEnd2 = getNodeEnd(astNodeDestructuringPrimaryExpr);
                if (!(astNodeDestructuringPrimaryExpr instanceof DestructuringForm)) {
                    reportError("msg.bad.assign.left", i4, nodeEnd2 - i4);
                }
                markDestructuring(astNodeDestructuringPrimaryExpr);
                nodeEnd = nodeEnd2;
                name = null;
            } else {
                mustMatchToken(39, "msg.bad.var", true);
                Name nameCreateNameNode = createNameNode();
                nameCreateNameNode.setLineno(this.ts.getLineno());
                if (this.inUseStrictDirective) {
                    String string = this.ts.getString();
                    if ("eval".equals(string) || "arguments".equals(this.ts.getString())) {
                        reportError("msg.bad.id.strict", string);
                    }
                }
                defineSymbol(i2, this.ts.getString(), this.inForInit);
                nodeEnd = i5;
                name = nameCreateNameNode;
                astNodeDestructuringPrimaryExpr = null;
            }
            int i6 = this.ts.lineno;
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (matchToken(91, true)) {
                astNodeAssignExpr = assignExpr();
                nodeEnd = getNodeEnd(astNodeAssignExpr);
            }
            VariableInitializer variableInitializer = new VariableInitializer(i4, nodeEnd - i4);
            if (astNodeDestructuringPrimaryExpr != null) {
                if (astNodeAssignExpr == null && !this.inForInit) {
                    reportError("msg.destruct.assign.no.init");
                }
                variableInitializer.setTarget(astNodeDestructuringPrimaryExpr);
            } else {
                variableInitializer.setTarget(name);
            }
            variableInitializer.setInitializer(astNodeAssignExpr);
            variableInitializer.setType(i2);
            variableInitializer.setJsDocNode(andResetJsDoc2);
            variableInitializer.setLineno(i6);
            variableDeclaration.addVariable(variableInitializer);
        } while (matchToken(90, true));
        variableDeclaration.setLength(nodeEnd - i3);
        variableDeclaration.setIsStatement(z);
        return variableDeclaration;
    }

    private void warnMissingSemi(int i2, int i3) {
        if (this.compilerEnv.isStrictMode()) {
            int[] iArr = new int[2];
            String line = this.ts.getLine(i3, iArr);
            if (this.compilerEnv.isIdeMode()) {
                i2 = Math.max(i2, i3 - iArr[1]);
            }
            int i4 = i2;
            if (line != null) {
                addStrictWarning("msg.missing.semi", "", i4, i3 - i4, iArr[0], line, iArr[1]);
            } else {
                addStrictWarning("msg.missing.semi", "", i4, i3 - i4);
            }
        }
    }

    private void warnTrailingComma(int i2, List<?> list, int i3) {
        if (this.compilerEnv.getWarnTrailingComma()) {
            if (!list.isEmpty()) {
                i2 = ((AstNode) list.get(0)).getPosition();
            }
            int iMax = Math.max(i2, lineBeginningFor(i3));
            addWarning("msg.extra.trailing.comma", iMax, i3 - iMax);
        }
    }

    private WhileLoop whileLoop() {
        if (this.currentToken != 118) {
            codeBug();
        }
        consumeToken();
        int i2 = this.ts.tokenBeg;
        WhileLoop whileLoop = new WhileLoop(i2);
        whileLoop.setLineno(this.ts.lineno);
        enterLoop(whileLoop);
        try {
            ConditionData conditionDataCondition = condition();
            whileLoop.setCondition(conditionDataCondition.condition);
            whileLoop.setParens(conditionDataCondition.lp - i2, conditionDataCondition.rp - i2);
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(whileLoop);
            whileLoop.setLength(getNodeEnd(nextStatementAfterInlineComments) - i2);
            whileLoop.setBody(nextStatementAfterInlineComments);
            return whileLoop;
        } finally {
            exitLoop();
        }
    }

    private WithStatement withStatement() {
        if (this.currentToken != 124) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        int i4 = mustMatchToken(88, "msg.no.paren.with", true) ? this.ts.tokenBeg : -1;
        AstNode astNodeExpr = expr();
        int i5 = mustMatchToken(89, "msg.no.paren.after.with", true) ? this.ts.tokenBeg : -1;
        WithStatement withStatement = new WithStatement(i3);
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(withStatement);
        withStatement.setLength(getNodeEnd(nextStatementAfterInlineComments) - i3);
        withStatement.setJsDocNode(andResetJsDoc);
        withStatement.setExpression(astNodeExpr);
        withStatement.setStatement(nextStatementAfterInlineComments);
        withStatement.setParens(i4, i5);
        withStatement.setLineno(i2);
        return withStatement;
    }

    private XmlElemRef xmlElemRef(int i2, Name name, int i3) {
        int i4 = this.ts.tokenBeg;
        int i5 = -1;
        int i6 = i2 != -1 ? i2 : i4;
        AstNode astNodeExpr = expr();
        int nodeEnd = getNodeEnd(astNodeExpr);
        if (mustMatchToken(85, "msg.no.bracket.index", true)) {
            TokenStream tokenStream = this.ts;
            int i7 = tokenStream.tokenBeg;
            nodeEnd = tokenStream.tokenEnd;
            i5 = i7;
        }
        XmlElemRef xmlElemRef = new XmlElemRef(i6, nodeEnd - i6);
        xmlElemRef.setNamespace(name);
        xmlElemRef.setColonPos(i3);
        xmlElemRef.setAtPos(i2);
        xmlElemRef.setExpression(astNodeExpr);
        xmlElemRef.setBrackets(i4, i5);
        return xmlElemRef;
    }

    private AstNode xmlInitializer() {
        if (this.currentToken != 14) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        int firstXMLToken = tokenStream.getFirstXMLToken();
        if (firstXMLToken != 146 && firstXMLToken != 149) {
            reportError("msg.syntax");
            return makeErrorNode();
        }
        XmlLiteral xmlLiteral = new XmlLiteral(i2);
        xmlLiteral.setLineno(this.ts.lineno);
        while (firstXMLToken == 146) {
            TokenStream tokenStream2 = this.ts;
            xmlLiteral.addFragment(new XmlString(tokenStream2.tokenBeg, tokenStream2.getString()));
            mustMatchToken(86, "msg.syntax", true);
            int i3 = this.ts.tokenBeg;
            AstNode emptyExpression = peekToken() == 87 ? new EmptyExpression(i3, this.ts.tokenEnd - i3) : expr();
            mustMatchToken(87, "msg.syntax", true);
            XmlExpression xmlExpression = new XmlExpression(i3, emptyExpression);
            xmlExpression.setIsXmlAttribute(this.ts.isXMLAttribute());
            xmlExpression.setLength(this.ts.tokenEnd - i3);
            xmlLiteral.addFragment(xmlExpression);
            firstXMLToken = this.ts.getNextXMLToken();
        }
        if (firstXMLToken != 149) {
            reportError("msg.syntax");
            return makeErrorNode();
        }
        TokenStream tokenStream3 = this.ts;
        xmlLiteral.addFragment(new XmlString(tokenStream3.tokenBeg, tokenStream3.getString()));
        return xmlLiteral;
    }

    public void addError(String str) {
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        addError(str, i2, tokenStream.tokenEnd - i2);
    }

    public void addStrictWarning(String str, String str2) {
        int i2;
        TokenStream tokenStream = this.ts;
        int i3 = -1;
        if (tokenStream != null) {
            i3 = tokenStream.tokenBeg;
            i2 = tokenStream.tokenEnd - i3;
        } else {
            i2 = -1;
        }
        addStrictWarning(str, str2, i3, i2);
    }

    public void addWarning(String str, String str2) {
        int i2;
        TokenStream tokenStream = this.ts;
        int i3 = -1;
        if (tokenStream != null) {
            i3 = tokenStream.tokenBeg;
            i2 = tokenStream.tokenEnd - i3;
        } else {
            i2 = -1;
        }
        addWarning(str, str2, i3, i2);
    }

    public void checkActivationName(String str, int i2) {
        if (insideFunction()) {
            boolean z = false;
            if (("arguments".equals(str) && ((FunctionNode) this.currentScriptOrFn).getFunctionType() != 4) || ((this.compilerEnv.getActivationNames() != null && this.compilerEnv.getActivationNames().contains(str)) || ("length".equals(str) && i2 == 33 && this.compilerEnv.getLanguageVersion() == 120))) {
                z = true;
            }
            if (z) {
                setRequiresActivation();
            }
        }
    }

    public void checkMutableReference(Node node) {
        if ((node.getIntProp(16, 0) & 4) != 0) {
            reportError("msg.bad.assign.left");
        }
    }

    public Node createDestructuringAssignment(int i2, Node node, Node node2) {
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        Node nodeDestructuringAssignmentHelper = destructuringAssignmentHelper(i2, node, node2, nextTempName);
        nodeDestructuringAssignmentHelper.getLastChild().addChildToBack(createName(nextTempName));
        return nodeDestructuringAssignmentHelper;
    }

    public Node createName(String str) {
        checkActivationName(str, 39);
        return Node.newString(39, str);
    }

    public Node createNumber(double d2) {
        return Node.newNumber(d2);
    }

    public Scope createScopeNode(int i2, int i3) {
        Scope scope = new Scope();
        scope.setType(i2);
        scope.setLineno(i3);
        return scope;
    }

    public void defineSymbol(int i2, String str) {
        defineSymbol(i2, str, false);
    }

    public boolean destructuringArray(ArrayLiteral arrayLiteral, int i2, String str, Node node, List<String> list) {
        int i3 = i2 == 155 ? 156 : 8;
        boolean z = true;
        int i4 = 0;
        for (AstNode astNode : arrayLiteral.getElements()) {
            if (astNode.getType() == 129) {
                i4++;
            } else {
                Node node2 = new Node(36, createName(str), createNumber(i4));
                if (astNode.getType() == 39) {
                    String string = astNode.getString();
                    node.addChildToBack(new Node(i3, createName(49, string, null), node2));
                    if (i2 != -1) {
                        defineSymbol(i2, string, true);
                        list.add(string);
                    }
                } else {
                    node.addChildToBack(destructuringAssignmentHelper(i2, astNode, node2, this.currentScriptOrFn.getNextTempName()));
                }
                i4++;
                z = false;
            }
        }
        return z;
    }

    public Node destructuringAssignmentHelper(int i2, Node node, Node node2, String str) {
        Scope scopeCreateScopeNode = createScopeNode(Token.LETEXPR, node.getLineno());
        scopeCreateScopeNode.addChildToFront(new Node(154, createName(39, str, node2)));
        try {
            pushScope(scopeCreateScopeNode);
            boolean zDestructuringArray = true;
            defineSymbol(154, str, true);
            popScope();
            Node node3 = new Node(90);
            scopeCreateScopeNode.addChildToBack(node3);
            List<String> arrayList = new ArrayList<>();
            int type = node.getType();
            if (type == 33 || type == 36) {
                if (i2 == 123 || i2 == 154 || i2 == 155) {
                    reportError("msg.bad.assign.left");
                }
                node3.addChildToBack(simpleAssignment(node, createName(str)));
            } else if (type == 66) {
                zDestructuringArray = destructuringArray((ArrayLiteral) node, i2, str, node3, arrayList);
            } else if (type != 67) {
                reportError("msg.bad.assign.left");
            } else {
                zDestructuringArray = destructuringObject((ObjectLiteral) node, i2, str, node3, arrayList);
            }
            if (zDestructuringArray) {
                node3.addChildToBack(createNumber(0.0d));
            }
            scopeCreateScopeNode.putProp(22, arrayList);
            return scopeCreateScopeNode;
        } catch (Throwable th) {
            popScope();
            throw th;
        }
    }

    public boolean destructuringObject(ObjectLiteral objectLiteral, int i2, String str, Node node, List<String> list) {
        Node node2;
        int i3 = i2 == 155 ? 156 : 8;
        boolean z = true;
        for (ObjectProperty objectProperty : objectLiteral.getElements()) {
            TokenStream tokenStream = this.ts;
            int i4 = tokenStream != null ? tokenStream.lineno : 0;
            AstNode left = objectProperty.getLeft();
            if (left instanceof Name) {
                node2 = new Node(33, createName(str), Node.newString(((Name) left).getIdentifier()));
            } else if (left instanceof StringLiteral) {
                node2 = new Node(33, createName(str), Node.newString(((StringLiteral) left).getValue()));
            } else {
                if (!(left instanceof NumberLiteral)) {
                    throw codeBug();
                }
                node2 = new Node(36, createName(str), createNumber((int) ((NumberLiteral) left).getNumber()));
            }
            node2.setLineno(i4);
            AstNode right = objectProperty.getRight();
            if (right.getType() == 39) {
                String identifier = ((Name) right).getIdentifier();
                node.addChildToBack(new Node(i3, createName(49, identifier, null), node2));
                if (i2 != -1) {
                    defineSymbol(i2, identifier, true);
                    list.add(identifier);
                }
            } else {
                node.addChildToBack(destructuringAssignmentHelper(i2, right, node2, this.currentScriptOrFn.getNextTempName()));
            }
            z = false;
        }
        return z;
    }

    public boolean eof() {
        return this.ts.eof();
    }

    public boolean inUseStrictDirective() {
        return this.inUseStrictDirective;
    }

    public boolean insideFunction() {
        return this.nestingOfFunction != 0;
    }

    public String lookupMessage(String str) {
        return lookupMessage(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void markDestructuring(AstNode astNode) {
        if (astNode instanceof DestructuringForm) {
            ((DestructuringForm) astNode).setIsDestructuring(true);
        } else if (astNode instanceof ParenthesizedExpression) {
            markDestructuring(((ParenthesizedExpression) astNode).getExpression());
        }
    }

    public AstRoot parse(String str, String str2, int i2) {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        this.sourceURI = str2;
        if (this.compilerEnv.isIdeMode()) {
            this.sourceChars = str.toCharArray();
        }
        this.ts = new TokenStream(this, null, str, i2);
        try {
            try {
                return parse();
            } catch (IOException unused) {
                throw new IllegalStateException();
            }
        } finally {
            this.parseFinished = true;
        }
    }

    public void popScope() {
        this.currentScope = this.currentScope.getParentScope();
    }

    public void pushScope(Scope scope) {
        Scope parentScope = scope.getParentScope();
        if (parentScope == null) {
            this.currentScope.addChildScope(scope);
        } else if (parentScope != this.currentScope) {
            codeBug();
        }
        this.currentScope = scope;
    }

    public AstNode removeParens(AstNode astNode) {
        while (astNode instanceof ParenthesizedExpression) {
            astNode = ((ParenthesizedExpression) astNode).getExpression();
        }
        return astNode;
    }

    public void reportError(String str) {
        reportError(str, null);
    }

    public void setDefaultUseStrictDirective(boolean z) {
        this.defaultUseStrictDirective = z;
    }

    public void setIsGenerator() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setIsGenerator();
        }
    }

    public void setRequiresActivation() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setRequiresActivation();
        }
    }

    public Node simpleAssignment(Node node, Node node2) {
        Node firstChild;
        Node lastChild;
        int i2;
        int type = node.getType();
        if (type != 33 && type != 36) {
            if (type != 39) {
                if (type != 68) {
                    throw codeBug();
                }
                Node firstChild2 = node.getFirstChild();
                checkMutableReference(firstChild2);
                return new Node(69, firstChild2, node2);
            }
            String identifier = ((Name) node).getIdentifier();
            if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                reportError("msg.bad.id.strict", identifier);
            }
            node.setType(49);
            return new Node(8, node, node2);
        }
        if (node instanceof PropertyGet) {
            PropertyGet propertyGet = (PropertyGet) node;
            firstChild = propertyGet.getTarget();
            lastChild = propertyGet.getProperty();
        } else if (node instanceof ElementGet) {
            ElementGet elementGet = (ElementGet) node;
            firstChild = elementGet.getTarget();
            lastChild = elementGet.getElement();
        } else {
            firstChild = node.getFirstChild();
            lastChild = node.getLastChild();
        }
        if (type == 33) {
            i2 = 35;
            lastChild.setType(41);
        } else {
            i2 = 37;
        }
        return new Node(i2, firstChild, lastChild, node2);
    }

    public Parser(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    private Name createNameNode(boolean z, int i2) {
        TokenStream tokenStream = this.ts;
        int i3 = tokenStream.tokenBeg;
        String string = tokenStream.getString();
        int i4 = this.ts.lineno;
        String str = "";
        if (!"".equals(this.prevNameTokenString)) {
            i3 = this.prevNameTokenStart;
            string = this.prevNameTokenString;
            i4 = this.prevNameTokenLineno;
            this.prevNameTokenStart = 0;
            this.prevNameTokenString = "";
            this.prevNameTokenLineno = 0;
        }
        if (string != null) {
            str = string;
        } else if (!this.compilerEnv.isIdeMode()) {
            codeBug();
            str = string;
        }
        Name name = new Name(i3, str);
        name.setLineno(i4);
        if (z) {
            checkActivationName(str, i2);
        }
        return name;
    }

    private FunctionNode function(int i2, boolean z) {
        Name nameCreateNameNode;
        TokenStream tokenStream = this.ts;
        int i3 = tokenStream.lineno;
        int i4 = tokenStream.tokenBeg;
        AstNode astNodeMemberExprTail = null;
        if (matchToken(39, true)) {
            nameCreateNameNode = createNameNode(true, 39);
            if (this.inUseStrictDirective) {
                String identifier = nameCreateNameNode.getIdentifier();
                if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                    reportError("msg.bad.id.strict", identifier);
                }
            }
            if (!matchToken(88, true)) {
                if (this.compilerEnv.isAllowMemberExprAsFunctionName()) {
                    astNodeMemberExprTail = memberExprTail(false, nameCreateNameNode);
                    nameCreateNameNode = null;
                }
                mustMatchToken(88, "msg.no.paren.parms", true);
            }
        } else if (matchToken(88, true)) {
            nameCreateNameNode = null;
        } else {
            if (matchToken(23, true) && this.compilerEnv.getLanguageVersion() >= 200) {
                return function(i2, true);
            }
            AstNode astNodeMemberExpr = this.compilerEnv.isAllowMemberExprAsFunctionName() ? memberExpr(false) : null;
            mustMatchToken(88, "msg.no.paren.parms", true);
            astNodeMemberExprTail = astNodeMemberExpr;
            nameCreateNameNode = null;
        }
        int i5 = this.currentToken == 88 ? this.ts.tokenBeg : -1;
        if ((astNodeMemberExprTail != null ? 2 : i2) != 2 && nameCreateNameNode != null && nameCreateNameNode.length() > 0) {
            defineSymbol(110, nameCreateNameNode.getIdentifier());
        }
        FunctionNode functionNode = new FunctionNode(i4, nameCreateNameNode);
        functionNode.setFunctionType(i2);
        if (z) {
            functionNode.setIsES6Generator();
        }
        if (i5 != -1) {
            functionNode.setLp(i5 - i4);
        }
        functionNode.setJsDocNode(getAndResetJsDoc());
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            parseFunctionParams(functionNode);
            functionNode.setBody(parseFunctionBody(i2, functionNode));
            functionNode.setEncodedSourceBounds(i4, this.ts.tokenEnd);
            functionNode.setLength(this.ts.tokenEnd - i4);
            if (this.compilerEnv.isStrictMode() && !functionNode.getBody().hasConsistentReturnUsage()) {
                addStrictWarning((nameCreateNameNode == null || nameCreateNameNode.length() <= 0) ? "msg.anon.no.return.value" : "msg.no.return.value", nameCreateNameNode == null ? "" : nameCreateNameNode.getIdentifier());
            }
            if (astNodeMemberExprTail != null) {
                Kit.codeBug();
                functionNode.setMemberExprNode(astNodeMemberExprTail);
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setBaseLineno(i3);
            functionNode.setEndLineno(this.ts.lineno);
            if (this.compilerEnv.isIdeMode()) {
                functionNode.setParentScope(this.currentScope);
            }
            return functionNode;
        } finally {
            perFunctionVariables.restore();
        }
    }

    private AstNode generatorExpression(AstNode astNode, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(generatorExpressionLoop());
        }
        int i3 = -1;
        ConditionData conditionDataCondition = null;
        if (peekToken() == 113) {
            consumeToken();
            i3 = this.ts.tokenBeg - i2;
            conditionDataCondition = condition();
        }
        if (!z) {
            mustMatchToken(89, "msg.no.paren.let", true);
        }
        GeneratorExpression generatorExpression = new GeneratorExpression(i2, this.ts.tokenEnd - i2);
        generatorExpression.setResult(astNode);
        generatorExpression.setLoops(arrayList);
        if (conditionDataCondition != null) {
            generatorExpression.setIfPosition(i3);
            generatorExpression.setFilter(conditionDataCondition.condition);
            generatorExpression.setFilterLp(conditionDataCondition.lp - i2);
            generatorExpression.setFilterRp(conditionDataCondition.rp - i2);
        }
        return generatorExpression;
    }

    private boolean mustMatchToken(int i2, String str, int i3, int i4, boolean z) {
        if (matchToken(i2, z)) {
            return true;
        }
        reportError(str, i3, i4);
        return false;
    }

    public void addError(String str, int i2, int i3) {
        addError(str, null, i2, i3);
    }

    public void defineSymbol(int i2, String str, boolean z) {
        if (str == null) {
            if (this.compilerEnv.isIdeMode()) {
                return;
            } else {
                codeBug();
            }
        }
        Scope definingScope = this.currentScope.getDefiningScope(str);
        org.mozilla.javascript.ast.Symbol symbol = definingScope != null ? definingScope.getSymbol(str) : null;
        int declType = symbol != null ? symbol.getDeclType() : -1;
        String str2 = "msg.var.redecl";
        if (symbol != null && (declType == 155 || i2 == 155 || (definingScope == this.currentScope && declType == 154))) {
            if (declType == 155) {
                str2 = "msg.const.redecl";
            } else if (declType == 154) {
                str2 = "msg.let.redecl";
            } else if (declType != 123) {
                str2 = declType == 110 ? "msg.fn.redecl" : "msg.parm.redecl";
            }
            addError(str2, str);
            return;
        }
        if (i2 == 88) {
            if (symbol != null) {
                addWarning("msg.dup.parms", str);
            }
            this.currentScriptOrFn.putSymbol(new org.mozilla.javascript.ast.Symbol(i2, str));
            return;
        }
        if (i2 != 110 && i2 != 123) {
            if (i2 == 154) {
                if (z || !(this.currentScope.getType() == 113 || (this.currentScope instanceof Loop))) {
                    this.currentScope.putSymbol(new org.mozilla.javascript.ast.Symbol(i2, str));
                    return;
                } else {
                    addError("msg.let.decl.not.in.block");
                    return;
                }
            }
            if (i2 != 155) {
                throw codeBug();
            }
        }
        if (symbol == null) {
            this.currentScriptOrFn.putSymbol(new org.mozilla.javascript.ast.Symbol(i2, str));
        } else if (declType == 123) {
            addStrictWarning("msg.var.redecl", str);
        } else if (declType == 88) {
            addStrictWarning("msg.var.hides.arg", str);
        }
    }

    public String lookupMessage(String str, String str2) {
        return str2 == null ? ScriptRuntime.getMessage0(str) : ScriptRuntime.getMessage1(str, str2);
    }

    public void reportError(String str, String str2) {
        TokenStream tokenStream = this.ts;
        if (tokenStream == null) {
            reportError(str, str2, 1, 1);
        } else {
            int i2 = tokenStream.tokenBeg;
            reportError(str, str2, i2, tokenStream.tokenEnd - i2);
        }
    }

    public Parser(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        this.currentFlaggedToken = 0;
        this.prevNameTokenString = "";
        this.compilerEnv = compilerEnvirons;
        this.errorReporter = errorReporter;
        if (errorReporter instanceof IdeErrorReporter) {
            this.errorCollector = (IdeErrorReporter) errorReporter;
        }
    }

    public void addError(String str, String str2) {
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        addError(str, str2, i2, tokenStream.tokenEnd - i2);
    }

    public Node createName(int i2, String str, Node node) {
        Node nodeCreateName = createName(str);
        nodeCreateName.setType(i2);
        if (node != null) {
            nodeCreateName.addChildToBack(node);
        }
        return nodeCreateName;
    }

    public void addError(String str, int i2) {
        String string = Character.toString((char) i2);
        TokenStream tokenStream = this.ts;
        int i3 = tokenStream.tokenBeg;
        addError(str, string, i3, tokenStream.tokenEnd - i3);
    }

    public void addStrictWarning(String str, String str2, int i2, int i3) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i2, i3);
        }
    }

    public void addWarning(String str, int i2, int i3) {
        addWarning(str, null, i2, i3);
    }

    public void reportError(String str, int i2, int i3) {
        reportError(str, null, i2, i3);
    }

    public void addError(String str, String str2, int i2, int i3) {
        String line;
        int i4;
        int offset;
        this.syntaxErrorCount++;
        String strLookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(strLookupMessage, this.sourceURI, i2, i3);
            return;
        }
        TokenStream tokenStream = this.ts;
        if (tokenStream != null) {
            int lineno = tokenStream.getLineno();
            line = this.ts.getLine();
            offset = this.ts.getOffset();
            i4 = lineno;
        } else {
            line = "";
            i4 = 1;
            offset = 1;
        }
        this.errorReporter.error(strLookupMessage, this.sourceURI, i4, line, offset);
    }

    public void addWarning(String str, String str2, int i2, int i3) {
        String strLookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i2, i3);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(strLookupMessage, this.sourceURI, i2, i3);
        } else {
            this.errorReporter.warning(strLookupMessage, this.sourceURI, this.ts.getLineno(), this.ts.getLine(), this.ts.getOffset());
        }
    }

    public void reportError(String str, String str2, int i2, int i3) {
        addError(str, str2, i2, i3);
        if (!this.compilerEnv.recoverFromErrors()) {
            throw new ParserException();
        }
    }

    private void addStrictWarning(String str, String str2, int i2, int i3, int i4, String str3, int i5) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i2, i3, i4, str3, i5);
        }
    }

    private AstNode statements() {
        return statements(null);
    }

    @Deprecated
    public AstRoot parse(Reader reader, String str, int i2) {
        if (!this.parseFinished) {
            if (this.compilerEnv.isIdeMode()) {
                return parse(Kit.readReader(reader), str, i2);
            }
            try {
                this.sourceURI = str;
                this.ts = new TokenStream(this, reader, null, i2);
                return parse();
            } finally {
                this.parseFinished = true;
            }
        }
        throw new IllegalStateException("parser reused");
    }

    private void addWarning(String str, String str2, int i2, int i3, int i4, String str3, int i5) {
        String strLookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i2, i3, i4, str3, i5);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(strLookupMessage, this.sourceURI, i2, i3);
        } else {
            this.errorReporter.warning(strLookupMessage, this.sourceURI, i4, str3, i5);
        }
    }

    private void addError(String str, String str2, int i2, int i3, int i4, String str3, int i5) {
        this.syntaxErrorCount++;
        String strLookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(strLookupMessage, this.sourceURI, i2, i3);
        } else {
            this.errorReporter.error(strLookupMessage, this.sourceURI, i4, str3, i5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.AstRoot parse() {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.parse():org.mozilla.javascript.ast.AstRoot");
    }
}
