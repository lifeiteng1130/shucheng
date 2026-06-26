package org.seimicrawler.xpath.antlr;

import k.a.a.a.n0.a;
import org.seimicrawler.xpath.antlr.XpathParser;

/* JADX INFO: loaded from: classes3.dex */
public class XpathBaseVisitor<T> extends a<T> implements XpathVisitor<T> {
    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitAbbreviatedStep(XpathParser.AbbreviatedStepContext abbreviatedStepContext) {
        return visitChildren(abbreviatedStepContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitAbsoluteLocationPathNoroot(XpathParser.AbsoluteLocationPathNorootContext absoluteLocationPathNorootContext) {
        return visitChildren(absoluteLocationPathNorootContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitAdditiveExpr(XpathParser.AdditiveExprContext additiveExprContext) {
        return visitChildren(additiveExprContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitAndExpr(XpathParser.AndExprContext andExprContext) {
        return visitChildren(andExprContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitAxisSpecifier(XpathParser.AxisSpecifierContext axisSpecifierContext) {
        return visitChildren(axisSpecifierContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitEqualityExpr(XpathParser.EqualityExprContext equalityExprContext) {
        return visitChildren(equalityExprContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitExpr(XpathParser.ExprContext exprContext) {
        return visitChildren(exprContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitFilterExpr(XpathParser.FilterExprContext filterExprContext) {
        return visitChildren(filterExprContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitFunctionCall(XpathParser.FunctionCallContext functionCallContext) {
        return visitChildren(functionCallContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitFunctionName(XpathParser.FunctionNameContext functionNameContext) {
        return visitChildren(functionNameContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitLocationPath(XpathParser.LocationPathContext locationPathContext) {
        return visitChildren(locationPathContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitMain(XpathParser.MainContext mainContext) {
        return visitChildren(mainContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitMultiplicativeExpr(XpathParser.MultiplicativeExprContext multiplicativeExprContext) {
        return visitChildren(multiplicativeExprContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitNCName(XpathParser.NCNameContext nCNameContext) {
        return visitChildren(nCNameContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitNameTest(XpathParser.NameTestContext nameTestContext) {
        return visitChildren(nameTestContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitNodeTest(XpathParser.NodeTestContext nodeTestContext) {
        return visitChildren(nodeTestContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitOrExpr(XpathParser.OrExprContext orExprContext) {
        return visitChildren(orExprContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitPathExprNoRoot(XpathParser.PathExprNoRootContext pathExprNoRootContext) {
        return visitChildren(pathExprNoRootContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitPredicate(XpathParser.PredicateContext predicateContext) {
        return visitChildren(predicateContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitPrimaryExpr(XpathParser.PrimaryExprContext primaryExprContext) {
        return visitChildren(primaryExprContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitQName(XpathParser.QNameContext qNameContext) {
        return visitChildren(qNameContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitRelationalExpr(XpathParser.RelationalExprContext relationalExprContext) {
        return visitChildren(relationalExprContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitRelativeLocationPath(XpathParser.RelativeLocationPathContext relativeLocationPathContext) {
        return visitChildren(relativeLocationPathContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitStep(XpathParser.StepContext stepContext) {
        return visitChildren(stepContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitUnaryExprNoRoot(XpathParser.UnaryExprNoRootContext unaryExprNoRootContext) {
        return visitChildren(unaryExprNoRootContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitUnionExprNoRoot(XpathParser.UnionExprNoRootContext unionExprNoRootContext) {
        return visitChildren(unionExprNoRootContext);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathVisitor
    public T visitVariableReference(XpathParser.VariableReferenceContext variableReferenceContext) {
        return visitChildren(variableReferenceContext);
    }
}
