package org.seimicrawler.xpath.antlr;

import k.a.a.a.n0.b;
import k.a.a.a.n0.d;
import k.a.a.a.n0.f;
import k.a.a.a.n0.g;
import k.a.a.a.n0.h;
import org.seimicrawler.xpath.antlr.XpathParser;

/* JADX INFO: loaded from: classes3.dex */
public interface XpathVisitor<T> extends f<T> {
    /* synthetic */ T visit(d dVar);

    T visitAbbreviatedStep(XpathParser.AbbreviatedStepContext abbreviatedStepContext);

    T visitAbsoluteLocationPathNoroot(XpathParser.AbsoluteLocationPathNorootContext absoluteLocationPathNorootContext);

    T visitAdditiveExpr(XpathParser.AdditiveExprContext additiveExprContext);

    T visitAndExpr(XpathParser.AndExprContext andExprContext);

    T visitAxisSpecifier(XpathParser.AxisSpecifierContext axisSpecifierContext);

    @Override // k.a.a.a.n0.f
    /* synthetic */ T visitChildren(g gVar);

    T visitEqualityExpr(XpathParser.EqualityExprContext equalityExprContext);

    @Override // k.a.a.a.n0.f
    /* synthetic */ T visitErrorNode(b bVar);

    T visitExpr(XpathParser.ExprContext exprContext);

    T visitFilterExpr(XpathParser.FilterExprContext filterExprContext);

    T visitFunctionCall(XpathParser.FunctionCallContext functionCallContext);

    T visitFunctionName(XpathParser.FunctionNameContext functionNameContext);

    T visitLocationPath(XpathParser.LocationPathContext locationPathContext);

    T visitMain(XpathParser.MainContext mainContext);

    T visitMultiplicativeExpr(XpathParser.MultiplicativeExprContext multiplicativeExprContext);

    T visitNCName(XpathParser.NCNameContext nCNameContext);

    T visitNameTest(XpathParser.NameTestContext nameTestContext);

    T visitNodeTest(XpathParser.NodeTestContext nodeTestContext);

    T visitOrExpr(XpathParser.OrExprContext orExprContext);

    T visitPathExprNoRoot(XpathParser.PathExprNoRootContext pathExprNoRootContext);

    T visitPredicate(XpathParser.PredicateContext predicateContext);

    T visitPrimaryExpr(XpathParser.PrimaryExprContext primaryExprContext);

    T visitQName(XpathParser.QNameContext qNameContext);

    T visitRelationalExpr(XpathParser.RelationalExprContext relationalExprContext);

    T visitRelativeLocationPath(XpathParser.RelativeLocationPathContext relativeLocationPathContext);

    T visitStep(XpathParser.StepContext stepContext);

    @Override // k.a.a.a.n0.f
    /* synthetic */ T visitTerminal(h hVar);

    T visitUnaryExprNoRoot(XpathParser.UnaryExprNoRootContext unaryExprNoRootContext);

    T visitUnionExprNoRoot(XpathParser.UnionExprNoRootContext unionExprNoRootContext);

    T visitVariableReference(XpathParser.VariableReferenceContext variableReferenceContext);
}
