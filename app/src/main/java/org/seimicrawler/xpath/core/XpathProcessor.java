package org.seimicrawler.xpath.core;

import androidx.exifinterface.media.ExifInterface;
import c.a.a.a.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import k.a.a.a.d0;
import k.a.a.a.n0.d;
import k.b.a.a.f;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.antlr.XpathBaseVisitor;
import org.seimicrawler.xpath.antlr.XpathParser;
import org.seimicrawler.xpath.exception.XpathMergeValueException;
import org.seimicrawler.xpath.exception.XpathParserException;
import org.seimicrawler.xpath.util.CommonUtil;
import org.seimicrawler.xpath.util.Scanner;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public class XpathProcessor extends XpathBaseVisitor<XValue> {
    private Scope rootScope;
    private Stack<Scope> scopeStack = new Stack<>();

    public XpathProcessor(Elements elements) {
        this.rootScope = Scope.create(elements);
        this.scopeStack.push(Scope.create(elements).setParent(this.rootScope));
    }

    private Scope currentScope() {
        return this.scopeStack.peek();
    }

    private void updateCurrentContext(Elements elements) {
        this.scopeStack.peek().setContext(elements);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitAbbreviatedStep(XpathParser.AbbreviatedStepContext abbreviatedStepContext) {
        if (!"..".equals(abbreviatedStepContext.getText())) {
            return XValue.create(currentScope().context());
        }
        HashSet hashSet = new HashSet();
        Elements elements = new Elements();
        Iterator<Element> it = currentScope().context().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().parent());
        }
        elements.addAll(hashSet);
        return XValue.create(elements);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitAbsoluteLocationPathNoroot(XpathParser.AbsoluteLocationPathNorootContext absoluteLocationPathNorootContext) {
        if (Objects.equals(absoluteLocationPathNorootContext.op.getText(), "//")) {
            currentScope().recursion();
        }
        return visit(absoluteLocationPathNorootContext.relativeLocationPath());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitAdditiveExpr(XpathParser.AdditiveExprContext additiveExprContext) {
        List<XpathParser.MultiplicativeExprContext> listMultiplicativeExpr = additiveExprContext.multiplicativeExpr();
        if (listMultiplicativeExpr.size() == 1) {
            return visit(listMultiplicativeExpr.get(0));
        }
        Double dAsDouble = visit(listMultiplicativeExpr.get(0)).asDouble();
        String text = null;
        for (int i2 = 1; i2 < additiveExprContext.getChildCount(); i2++) {
            d child = additiveExprContext.getChild(i2);
            if (child instanceof XpathParser.MultiplicativeExprContext) {
                XValue xValueVisit = visit(child);
                if (Marker.ANY_NON_NULL_MARKER.equals(text)) {
                    dAsDouble = Double.valueOf(xValueVisit.asDouble().doubleValue() + dAsDouble.doubleValue());
                } else {
                    if (!"-".equals(text)) {
                        StringBuilder sbR = a.r("syntax error, ");
                        sbR.append(additiveExprContext.getText());
                        throw new XpathParserException(sbR.toString());
                    }
                    dAsDouble = Double.valueOf(dAsDouble.doubleValue() - xValueVisit.asDouble().doubleValue());
                }
            } else {
                text = child.getText();
            }
        }
        return XValue.create(dAsDouble);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitAndExpr(XpathParser.AndExprContext andExprContext) {
        List<XpathParser.EqualityExprContext> listEqualityExpr = andExprContext.equalityExpr();
        if (listEqualityExpr.size() <= 1) {
            return visit(listEqualityExpr.get(0));
        }
        Boolean boolAsBoolean = visit(listEqualityExpr.get(0)).asBoolean();
        for (int i2 = 1; i2 < listEqualityExpr.size(); i2++) {
            boolAsBoolean = Boolean.valueOf(boolAsBoolean.booleanValue() & visit(listEqualityExpr.get(i2)).asBoolean().booleanValue());
        }
        return XValue.create(boolAsBoolean);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitAxisSpecifier(XpathParser.AxisSpecifierContext axisSpecifierContext) {
        if (axisSpecifierContext.AxisName() != null) {
            return Scanner.findSelectorByName(axisSpecifierContext.AxisName().getText()).apply(currentScope().context());
        }
        if ("@".equals(axisSpecifierContext.getText())) {
            return XValue.create(null).attr();
        }
        return null;
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitEqualityExpr(XpathParser.EqualityExprContext equalityExprContext) {
        List<XpathParser.RelationalExprContext> listRelationalExpr = equalityExprContext.relationalExpr();
        if (listRelationalExpr.size() == 1) {
            return visit(listRelationalExpr.get(0));
        }
        if (listRelationalExpr.size() == 2) {
            XValue xValueVisit = visit(listRelationalExpr.get(0));
            XValue xValueVisit2 = visit(listRelationalExpr.get(1));
            return "=".equals(equalityExprContext.op.getText()) ? xValueVisit.valType().equals(xValueVisit2.valType()) ? XValue.create(Boolean.valueOf(Objects.equals(xValueVisit, xValueVisit2))) : XValue.create(Boolean.valueOf(Objects.equals(xValueVisit.asString(), xValueVisit2.asString()))) : xValueVisit.valType().equals(xValueVisit2.valType()) ? XValue.create(Boolean.valueOf(!Objects.equals(xValueVisit, xValueVisit2))) : XValue.create(Boolean.valueOf(!Objects.equals(xValueVisit.asString(), xValueVisit2.asString())));
        }
        StringBuilder sbR = a.r("error equalityExpr near:");
        sbR.append(equalityExprContext.getText());
        throw new XpathParserException(sbR.toString());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitExpr(XpathParser.ExprContext exprContext) {
        return visit(exprContext.orExpr());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitFilterExpr(XpathParser.FilterExprContext filterExprContext) {
        return visit(filterExprContext.primaryExpr());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitFunctionCall(XpathParser.FunctionCallContext functionCallContext) {
        LinkedList linkedList = new LinkedList();
        XValue xValueVisit = visit(functionCallContext.functionName());
        for (XpathParser.ExprContext exprContext : functionCallContext.expr()) {
            this.scopeStack.push(Scope.create(currentScope()));
            linkedList.add(visit(exprContext));
            this.scopeStack.pop();
        }
        return Scanner.findFunctionByName(xValueVisit.asString()).call(currentScope(), linkedList);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitFunctionName(XpathParser.FunctionNameContext functionNameContext) {
        return visit(functionNameContext.qName());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitLocationPath(XpathParser.LocationPathContext locationPathContext) {
        return (locationPathContext.relativeLocationPath() == null || locationPathContext.relativeLocationPath().isEmpty()) ? visit(locationPathContext.absoluteLocationPathNoroot()) : visit(locationPathContext.relativeLocationPath());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitMain(XpathParser.MainContext mainContext) {
        return visit(mainContext.expr());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitMultiplicativeExpr(XpathParser.MultiplicativeExprContext multiplicativeExprContext) {
        if (multiplicativeExprContext.multiplicativeExpr() == null || multiplicativeExprContext.multiplicativeExpr().isEmpty()) {
            return visit(multiplicativeExprContext.unaryExprNoRoot());
        }
        XValue xValueVisit = visit(multiplicativeExprContext.unaryExprNoRoot());
        XValue xValueVisit2 = visit(multiplicativeExprContext.multiplicativeExpr());
        switch (multiplicativeExprContext.op.getType()) {
            case 17:
                return XValue.create(Double.valueOf(xValueVisit2.asDouble().doubleValue() * xValueVisit.asDouble().doubleValue()));
            case 18:
                return XValue.create(Double.valueOf(xValueVisit.asDouble().doubleValue() / xValueVisit2.asDouble().doubleValue()));
            case 19:
                return XValue.create(Double.valueOf(xValueVisit.asDouble().doubleValue() % xValueVisit2.asDouble().doubleValue()));
            default:
                StringBuilder sbR = a.r("syntax error, ");
                sbR.append(multiplicativeExprContext.getText());
                throw new XpathParserException(sbR.toString());
        }
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitNCName(XpathParser.NCNameContext nCNameContext) {
        return nCNameContext.AxisName() != null ? XValue.create(nCNameContext.AxisName().getText()).exprStr() : XValue.create(nCNameContext.NCName().getText()).exprStr();
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitNameTest(XpathParser.NameTestContext nameTestContext) {
        if ("*".equals(nameTestContext.getText())) {
            return XValue.create("*").exprStr();
        }
        if (nameTestContext.qName() != null && !nameTestContext.qName().isEmpty()) {
            return visit(nameTestContext.qName());
        }
        if (nameTestContext.nCName() == null || nameTestContext.nCName().isEmpty()) {
            return null;
        }
        return visit(nameTestContext.nCName());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitNodeTest(XpathParser.NodeTestContext nodeTestContext) {
        if (nodeTestContext.nameTest() != null) {
            return visit(nodeTestContext.nameTest());
        }
        if (nodeTestContext.NodeType() != null) {
            return Scanner.findNodeTestByName(nodeTestContext.NodeType().getText()).call(currentScope());
        }
        return null;
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitOrExpr(XpathParser.OrExprContext orExprContext) {
        List<XpathParser.AndExprContext> listAndExpr = orExprContext.andExpr();
        if (listAndExpr.size() <= 1) {
            return visit(listAndExpr.get(0));
        }
        Boolean boolAsBoolean = visit(listAndExpr.get(0)).asBoolean();
        for (int i2 = 1; i2 < listAndExpr.size(); i2++) {
            boolAsBoolean = Boolean.valueOf(boolAsBoolean.booleanValue() | visit(listAndExpr.get(i2)).asBoolean().booleanValue());
        }
        return XValue.create(boolAsBoolean);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitPathExprNoRoot(XpathParser.PathExprNoRootContext pathExprNoRootContext) {
        if (pathExprNoRootContext.locationPath() != null && !pathExprNoRootContext.locationPath().isEmpty()) {
            return visit(pathExprNoRootContext.locationPath());
        }
        d0 d0Var = pathExprNoRootContext.op;
        if (d0Var == null) {
            return visit(pathExprNoRootContext.filterExpr());
        }
        if ("//".equals(d0Var.getText())) {
            currentScope().recursion();
        }
        return visit(pathExprNoRootContext.relativeLocationPath());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitPredicate(XpathParser.PredicateContext predicateContext) {
        Elements elements = new Elements();
        for (Element element : currentScope().context()) {
            this.scopeStack.push(Scope.create(element).setParent(currentScope()));
            XValue xValueVisit = visit(predicateContext.expr());
            this.scopeStack.pop();
            if (xValueVisit.isNumber()) {
                long jLongValue = xValueVisit.asLong().longValue();
                if (jLongValue < 0) {
                    jLongValue = 1 + ((long) CommonUtil.sameTagElNums(element, currentScope())) + jLongValue;
                }
                if (jLongValue == CommonUtil.getElIndexInSameTags(element, currentScope())) {
                    elements.add(element);
                }
            } else if (xValueVisit.isBoolean()) {
                if (xValueVisit.asBoolean().booleanValue()) {
                    elements.add(element);
                }
            } else if (xValueVisit.isString()) {
                if (f.f(xValueVisit.asString())) {
                    elements.add(element);
                }
            } else if (!xValueVisit.isElements()) {
                if (!xValueVisit.isList()) {
                    throw new XpathParserException("unknown expr val:" + xValueVisit);
                }
                if (xValueVisit.asList().size() > 0) {
                    elements.add(element);
                }
            } else if (xValueVisit.asElements().size() > 0) {
                elements.add(element);
            }
        }
        return XValue.create(elements);
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitPrimaryExpr(XpathParser.PrimaryExprContext primaryExprContext) {
        if (primaryExprContext.expr() != null && !primaryExprContext.expr().isEmpty()) {
            return visit(primaryExprContext.expr());
        }
        if (primaryExprContext.functionCall() != null && !primaryExprContext.functionCall().isEmpty()) {
            return visit(primaryExprContext.functionCall());
        }
        if (primaryExprContext.Literal() != null) {
            return XValue.create(primaryExprContext.Literal().getText()).exprStr();
        }
        if (primaryExprContext.Number() != null) {
            String text = primaryExprContext.Number().getText();
            return XValue.create(text == null ? null : Double.valueOf(text));
        }
        StringBuilder sbR = a.r("not support variableReference:");
        sbR.append(primaryExprContext.getText());
        throw new XpathParserException(sbR.toString());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitQName(XpathParser.QNameContext qNameContext) {
        List<XpathParser.NCNameContext> listNCName = qNameContext.nCName();
        if (listNCName == null) {
            return null;
        }
        if (listNCName.size() <= 1) {
            return visit(listNCName.get(0));
        }
        LinkedList linkedList = new LinkedList();
        Iterator<XpathParser.NCNameContext> it = listNCName.iterator();
        while (it.hasNext()) {
            XValue xValueVisit = visit(it.next());
            if (xValueVisit != null) {
                linkedList.add(xValueVisit.asString());
            }
        }
        return XValue.create(f.g(linkedList, ":"));
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitRelationalExpr(XpathParser.RelationalExprContext relationalExprContext) {
        List<XpathParser.AdditiveExprContext> listAdditiveExpr = relationalExprContext.additiveExpr();
        if (listAdditiveExpr.size() == 1) {
            return visit(listAdditiveExpr.get(0));
        }
        if (listAdditiveExpr.size() != 2) {
            StringBuilder sbR = a.r("error equalityExpr near:");
            sbR.append(relationalExprContext.getText());
            throw new XpathParserException(sbR.toString());
        }
        XValue xValueVisit = visit(listAdditiveExpr.get(0));
        XValue xValueVisit2 = visit(listAdditiveExpr.get(1));
        switch (relationalExprContext.op.getType()) {
            case 24:
                return XValue.create(Boolean.valueOf(xValueVisit.compareTo(xValueVisit2) < 0));
            case 25:
                return XValue.create(Boolean.valueOf(xValueVisit.compareTo(xValueVisit2) > 0));
            case 26:
                return XValue.create(Boolean.valueOf(xValueVisit.compareTo(xValueVisit2) <= 0));
            case 27:
                return XValue.create(Boolean.valueOf(xValueVisit.compareTo(xValueVisit2) >= 0));
            case 28:
            case 29:
            default:
                StringBuilder sbR2 = a.r("unknown operator");
                sbR2.append(relationalExprContext.op.getText());
                throw new XpathParserException(sbR2.toString());
            case 30:
                return XValue.create(Boolean.valueOf(xValueVisit.asString().startsWith(xValueVisit2.asString())));
            case 31:
                return XValue.create(Boolean.valueOf(xValueVisit.asString().endsWith(xValueVisit2.asString())));
            case 32:
                return XValue.create(Boolean.valueOf(xValueVisit.asString().contains(xValueVisit2.asString())));
            case 33:
                return XValue.create(Boolean.valueOf(xValueVisit.asString().matches(xValueVisit2.asString())));
            case 34:
                return XValue.create(Boolean.valueOf(!xValueVisit.asString().matches(xValueVisit2.asString())));
        }
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitRelativeLocationPath(XpathParser.RelativeLocationPathContext relativeLocationPathContext) {
        XValue xValueVisit = null;
        for (int i2 = 0; i2 < relativeLocationPathContext.getChildCount(); i2++) {
            d child = relativeLocationPathContext.getChild(i2);
            if (child instanceof XpathParser.StepContext) {
                xValueVisit = visit(child);
                if (xValueVisit.isElements()) {
                    updateCurrentContext(xValueVisit.asElements());
                }
            } else if ("//".equals(child.getText())) {
                currentScope().recursion();
            } else {
                currentScope().notRecursion();
            }
        }
        return xValueVisit;
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitStep(XpathParser.StepContext stepContext) {
        boolean z;
        XValue xValueVisit;
        if (stepContext.abbreviatedStep() != null && !stepContext.abbreviatedStep().isEmpty()) {
            return visit(stepContext.abbreviatedStep());
        }
        boolean z2 = false;
        if (stepContext.axisSpecifier() == null || stepContext.axisSpecifier().isEmpty() || (xValueVisit = visit(stepContext.axisSpecifier())) == null) {
            z = false;
        } else {
            if (xValueVisit.isElements()) {
                updateCurrentContext(xValueVisit.asElements());
            } else if (xValueVisit.isAttr()) {
                z = true;
                z2 = true;
            }
            z = true;
        }
        if (stepContext.nodeTest() != null && !stepContext.nodeTest().isEmpty()) {
            XValue xValueVisit2 = visit(stepContext.nodeTest());
            if (z2) {
                Elements elementsContext = currentScope().context();
                String strAsString = xValueVisit2.asString();
                if (!currentScope().isRecursion()) {
                    if (elementsContext.size() == 1) {
                        return XValue.create(currentScope().singleEl().attr(strAsString));
                    }
                    LinkedList linkedList = new LinkedList();
                    Iterator<Element> it = elementsContext.iterator();
                    while (it.hasNext()) {
                        linkedList.add(it.next().attr(strAsString));
                    }
                    return XValue.create(linkedList);
                }
                if (elementsContext.size() == 1) {
                    Elements elementsSelect = currentScope().singleEl().select("[" + strAsString + "]");
                    LinkedList linkedList2 = new LinkedList();
                    Iterator<Element> it2 = elementsSelect.iterator();
                    while (it2.hasNext()) {
                        linkedList2.add(it2.next().attr(strAsString));
                    }
                    return XValue.create(linkedList2);
                }
                Elements elements = new Elements();
                Iterator<Element> it3 = elementsContext.iterator();
                while (it3.hasNext()) {
                    elements.addAll(it3.next().select("[" + strAsString + "]"));
                }
                LinkedList linkedList3 = new LinkedList();
                Iterator<Element> it4 = elements.iterator();
                while (it4.hasNext()) {
                    linkedList3.add(it4.next().attr(strAsString));
                }
                return XValue.create(linkedList3);
            }
            if (!xValueVisit2.isExprStr()) {
                return xValueVisit2;
            }
            String strAsString2 = xValueVisit2.asString();
            Elements elementsContext2 = currentScope().context();
            if (currentScope().isRecursion()) {
                updateCurrentContext(elementsContext2.select(strAsString2));
            } else {
                Elements elements2 = new Elements();
                for (Element element : currentScope().context()) {
                    if (!z) {
                        for (Element element2 : element.children()) {
                            if (element2.nodeName().equals(strAsString2) || "*".equals(strAsString2)) {
                                elements2.add(element2);
                            }
                        }
                    } else if (element.nodeName().equals(strAsString2) || "*".equals(strAsString2)) {
                        elements2.add(element);
                    }
                }
                updateCurrentContext(elements2);
            }
        }
        if (stepContext.predicate() != null && stepContext.predicate().size() > 0) {
            Iterator<XpathParser.PredicateContext> it5 = stepContext.predicate().iterator();
            while (it5.hasNext()) {
                updateCurrentContext(visit(it5.next()).asElements());
            }
        }
        return XValue.create(currentScope().context());
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitUnaryExprNoRoot(XpathParser.UnaryExprNoRootContext unaryExprNoRootContext) {
        XValue xValueVisit = visit(unaryExprNoRootContext.unionExprNoRoot());
        return unaryExprNoRootContext.sign == null ? xValueVisit : XValue.create(Double.valueOf(-xValueVisit.asDouble().doubleValue()));
    }

    @Override // org.seimicrawler.xpath.antlr.XpathBaseVisitor, org.seimicrawler.xpath.antlr.XpathVisitor
    public XValue visitUnionExprNoRoot(XpathParser.UnionExprNoRootContext unionExprNoRootContext) {
        if (unionExprNoRootContext.pathExprNoRoot() == null && !unionExprNoRootContext.pathExprNoRoot().isEmpty()) {
            return visit(unionExprNoRootContext.unionExprNoRoot());
        }
        XValue xValueVisit = visit(unionExprNoRootContext.pathExprNoRoot());
        if (unionExprNoRootContext.op == null) {
            return xValueVisit;
        }
        this.scopeStack.push(Scope.create(currentScope().getParent()));
        XValue xValueVisit2 = visit(unionExprNoRootContext.unionExprNoRoot());
        this.scopeStack.pop();
        if (xValueVisit.isElements()) {
            if (xValueVisit2.isElements()) {
                xValueVisit.asElements().addAll(xValueVisit2.asElements());
            } else {
                Element element = new Element(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                element.appendText(xValueVisit2.asString());
                xValueVisit.asElements().add(element);
            }
            return xValueVisit;
        }
        if (xValueVisit.isString()) {
            if (xValueVisit2.isElements()) {
                Element element2 = new Element(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                element2.appendText(xValueVisit.asString());
                xValueVisit2.asElements().add(element2);
                return xValueVisit2;
            }
            return XValue.create(xValueVisit.asString() + xValueVisit2.asString());
        }
        if (xValueVisit.isBoolean()) {
            if (xValueVisit2.isBoolean()) {
                return XValue.create(Boolean.valueOf(xValueVisit2.asBoolean().booleanValue() | xValueVisit.asBoolean().booleanValue()));
            }
            if (xValueVisit2.isElements()) {
                Element element3 = new Element(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                element3.appendText(xValueVisit.asString());
                xValueVisit2.asElements().add(element3);
                return xValueVisit2;
            }
            if (xValueVisit2.isString()) {
                return XValue.create(xValueVisit.asBoolean() + xValueVisit2.asString());
            }
            StringBuilder sbR = a.r("can not merge val1=");
            sbR.append(xValueVisit.asBoolean());
            sbR.append(",val2=");
            sbR.append(xValueVisit2.asString());
            throw new XpathMergeValueException(sbR.toString());
        }
        if (!xValueVisit.isNumber()) {
            LinkedList linkedList = new LinkedList();
            if (f.f(xValueVisit.asString())) {
                linkedList.add(xValueVisit.asString());
            }
            if (f.f(xValueVisit2.asString())) {
                linkedList.add(xValueVisit2.asString());
            }
            return XValue.create(f.g(linkedList, ","));
        }
        if (xValueVisit2.isString()) {
            return XValue.create(xValueVisit.asDouble() + xValueVisit2.asString());
        }
        if (xValueVisit2.isElements()) {
            Element element4 = new Element(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            element4.appendText(xValueVisit.asString());
            xValueVisit2.asElements().add(element4);
            return xValueVisit2;
        }
        StringBuilder sbR2 = a.r("can not merge val1=");
        sbR2.append(xValueVisit.asDouble());
        sbR2.append(",val2=");
        sbR2.append(xValueVisit2.asString());
        throw new XpathMergeValueException(sbR2.toString());
    }
}
