package org.seimicrawler.xpath.antlr;

import k.a.a.a.n0.b;
import k.a.a.a.n0.e;
import k.a.a.a.n0.h;
import k.a.a.a.y;
import org.seimicrawler.xpath.antlr.XpathParser;

/* JADX INFO: loaded from: classes3.dex */
public interface XpathListener extends e {
    void enterAbbreviatedStep(XpathParser.AbbreviatedStepContext abbreviatedStepContext);

    void enterAbsoluteLocationPathNoroot(XpathParser.AbsoluteLocationPathNorootContext absoluteLocationPathNorootContext);

    void enterAdditiveExpr(XpathParser.AdditiveExprContext additiveExprContext);

    void enterAndExpr(XpathParser.AndExprContext andExprContext);

    void enterAxisSpecifier(XpathParser.AxisSpecifierContext axisSpecifierContext);

    void enterEqualityExpr(XpathParser.EqualityExprContext equalityExprContext);

    @Override // k.a.a.a.n0.e
    /* synthetic */ void enterEveryRule(y yVar);

    void enterExpr(XpathParser.ExprContext exprContext);

    void enterFilterExpr(XpathParser.FilterExprContext filterExprContext);

    void enterFunctionCall(XpathParser.FunctionCallContext functionCallContext);

    void enterFunctionName(XpathParser.FunctionNameContext functionNameContext);

    void enterLocationPath(XpathParser.LocationPathContext locationPathContext);

    void enterMain(XpathParser.MainContext mainContext);

    void enterMultiplicativeExpr(XpathParser.MultiplicativeExprContext multiplicativeExprContext);

    void enterNCName(XpathParser.NCNameContext nCNameContext);

    void enterNameTest(XpathParser.NameTestContext nameTestContext);

    void enterNodeTest(XpathParser.NodeTestContext nodeTestContext);

    void enterOrExpr(XpathParser.OrExprContext orExprContext);

    void enterPathExprNoRoot(XpathParser.PathExprNoRootContext pathExprNoRootContext);

    void enterPredicate(XpathParser.PredicateContext predicateContext);

    void enterPrimaryExpr(XpathParser.PrimaryExprContext primaryExprContext);

    void enterQName(XpathParser.QNameContext qNameContext);

    void enterRelationalExpr(XpathParser.RelationalExprContext relationalExprContext);

    void enterRelativeLocationPath(XpathParser.RelativeLocationPathContext relativeLocationPathContext);

    void enterStep(XpathParser.StepContext stepContext);

    void enterUnaryExprNoRoot(XpathParser.UnaryExprNoRootContext unaryExprNoRootContext);

    void enterUnionExprNoRoot(XpathParser.UnionExprNoRootContext unionExprNoRootContext);

    void enterVariableReference(XpathParser.VariableReferenceContext variableReferenceContext);

    void exitAbbreviatedStep(XpathParser.AbbreviatedStepContext abbreviatedStepContext);

    void exitAbsoluteLocationPathNoroot(XpathParser.AbsoluteLocationPathNorootContext absoluteLocationPathNorootContext);

    void exitAdditiveExpr(XpathParser.AdditiveExprContext additiveExprContext);

    void exitAndExpr(XpathParser.AndExprContext andExprContext);

    void exitAxisSpecifier(XpathParser.AxisSpecifierContext axisSpecifierContext);

    void exitEqualityExpr(XpathParser.EqualityExprContext equalityExprContext);

    @Override // k.a.a.a.n0.e
    /* synthetic */ void exitEveryRule(y yVar);

    void exitExpr(XpathParser.ExprContext exprContext);

    void exitFilterExpr(XpathParser.FilterExprContext filterExprContext);

    void exitFunctionCall(XpathParser.FunctionCallContext functionCallContext);

    void exitFunctionName(XpathParser.FunctionNameContext functionNameContext);

    void exitLocationPath(XpathParser.LocationPathContext locationPathContext);

    void exitMain(XpathParser.MainContext mainContext);

    void exitMultiplicativeExpr(XpathParser.MultiplicativeExprContext multiplicativeExprContext);

    void exitNCName(XpathParser.NCNameContext nCNameContext);

    void exitNameTest(XpathParser.NameTestContext nameTestContext);

    void exitNodeTest(XpathParser.NodeTestContext nodeTestContext);

    void exitOrExpr(XpathParser.OrExprContext orExprContext);

    void exitPathExprNoRoot(XpathParser.PathExprNoRootContext pathExprNoRootContext);

    void exitPredicate(XpathParser.PredicateContext predicateContext);

    void exitPrimaryExpr(XpathParser.PrimaryExprContext primaryExprContext);

    void exitQName(XpathParser.QNameContext qNameContext);

    void exitRelationalExpr(XpathParser.RelationalExprContext relationalExprContext);

    void exitRelativeLocationPath(XpathParser.RelativeLocationPathContext relativeLocationPathContext);

    void exitStep(XpathParser.StepContext stepContext);

    void exitUnaryExprNoRoot(XpathParser.UnaryExprNoRootContext unaryExprNoRootContext);

    void exitUnionExprNoRoot(XpathParser.UnionExprNoRootContext unionExprNoRootContext);

    void exitVariableReference(XpathParser.VariableReferenceContext variableReferenceContext);

    @Override // k.a.a.a.n0.e
    /* synthetic */ void visitErrorNode(b bVar);

    @Override // k.a.a.a.n0.e
    /* synthetic */ void visitTerminal(h hVar);
}
