package org.seimicrawler.xpath.util;

import c.a.a.a.a;
import java.util.HashMap;
import java.util.Map;
import org.seimicrawler.xpath.core.AxisSelector;
import org.seimicrawler.xpath.core.Function;
import org.seimicrawler.xpath.core.NodeTest;
import org.seimicrawler.xpath.core.axis.AncestorOrSelfSelector;
import org.seimicrawler.xpath.core.axis.AncestorSelector;
import org.seimicrawler.xpath.core.axis.AttributeSelector;
import org.seimicrawler.xpath.core.axis.ChildSelector;
import org.seimicrawler.xpath.core.axis.DescendantOrSelfSelector;
import org.seimicrawler.xpath.core.axis.DescendantSelector;
import org.seimicrawler.xpath.core.axis.FollowingSelector;
import org.seimicrawler.xpath.core.axis.FollowingSiblingOneSelector;
import org.seimicrawler.xpath.core.axis.FollowingSiblingSelector;
import org.seimicrawler.xpath.core.axis.ParentSelector;
import org.seimicrawler.xpath.core.axis.PrecedingSelector;
import org.seimicrawler.xpath.core.axis.PrecedingSiblingOneSelector;
import org.seimicrawler.xpath.core.axis.PrecedingSiblingSelector;
import org.seimicrawler.xpath.core.axis.SelfSelector;
import org.seimicrawler.xpath.core.function.Concat;
import org.seimicrawler.xpath.core.function.Contains;
import org.seimicrawler.xpath.core.function.Count;
import org.seimicrawler.xpath.core.function.First;
import org.seimicrawler.xpath.core.function.FormatDate;
import org.seimicrawler.xpath.core.function.Last;
import org.seimicrawler.xpath.core.function.Not;
import org.seimicrawler.xpath.core.function.Position;
import org.seimicrawler.xpath.core.function.StartsWith;
import org.seimicrawler.xpath.core.function.StringLength;
import org.seimicrawler.xpath.core.function.SubString;
import org.seimicrawler.xpath.core.function.SubStringAfter;
import org.seimicrawler.xpath.core.function.SubStringAfterLast;
import org.seimicrawler.xpath.core.function.SubStringBefore;
import org.seimicrawler.xpath.core.function.SubStringBeforeLast;
import org.seimicrawler.xpath.core.function.SubStringEx;
import org.seimicrawler.xpath.core.node.AllText;
import org.seimicrawler.xpath.core.node.Html;
import org.seimicrawler.xpath.core.node.Node;
import org.seimicrawler.xpath.core.node.Num;
import org.seimicrawler.xpath.core.node.OuterHtml;
import org.seimicrawler.xpath.core.node.Text;
import org.seimicrawler.xpath.exception.NoSuchAxisException;
import org.seimicrawler.xpath.exception.NoSuchFunctionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class Scanner {
    private static Map<String, AxisSelector> axisSelectorMap = new HashMap();
    private static Map<String, NodeTest> nodeTestMap = new HashMap();
    private static Map<String, Function> functionMap = new HashMap();
    private static Logger logger = LoggerFactory.getLogger((Class<?>) Scanner.class);

    static {
        initAxis(AncestorOrSelfSelector.class, AncestorSelector.class, AttributeSelector.class, ChildSelector.class, DescendantOrSelfSelector.class, DescendantSelector.class, FollowingSelector.class, FollowingSiblingOneSelector.class, FollowingSiblingSelector.class, ParentSelector.class, PrecedingSelector.class, PrecedingSiblingOneSelector.class, PrecedingSiblingSelector.class, SelfSelector.class);
        initFunction(Concat.class, Contains.class, Count.class, First.class, Last.class, Not.class, Position.class, StartsWith.class, StringLength.class, SubString.class, SubStringAfter.class, SubStringBefore.class, SubStringEx.class, FormatDate.class, SubStringAfterLast.class, SubStringBeforeLast.class);
        initNode(AllText.class, Html.class, Node.class, Num.class, OuterHtml.class, Text.class);
    }

    public static Function findFunctionByName(String str) {
        Function function = functionMap.get(str);
        if (function != null) {
            return function;
        }
        throw new NoSuchFunctionException(a.i("not support function: ", str));
    }

    public static NodeTest findNodeTestByName(String str) {
        NodeTest nodeTest = nodeTestMap.get(str);
        if (nodeTest != null) {
            return nodeTest;
        }
        throw new NoSuchFunctionException(a.i("not support nodeTest: ", str));
    }

    public static AxisSelector findSelectorByName(String str) {
        AxisSelector axisSelector = axisSelectorMap.get(str);
        if (axisSelector != null) {
            return axisSelector;
        }
        throw new NoSuchAxisException(a.i("not support axis: ", str));
    }

    public static void initAxis(Class<? extends AxisSelector>... clsArr) {
        for (Class<? extends AxisSelector> cls : clsArr) {
            registerAxisSelector(cls);
        }
    }

    public static void initFunction(Class<? extends Function>... clsArr) {
        for (Class<? extends Function> cls : clsArr) {
            registerFunction(cls);
        }
    }

    public static void initNode(Class<? extends NodeTest>... clsArr) {
        for (Class<? extends NodeTest> cls : clsArr) {
            registerNodeTest(cls);
        }
    }

    public static void registerAxisSelector(Class<? extends AxisSelector> cls) {
        try {
            AxisSelector axisSelectorNewInstance = cls.newInstance();
            axisSelectorMap.put(axisSelectorNewInstance.name(), axisSelectorNewInstance);
        } catch (Exception e2) {
            logger.info(k.b.a.a.h.a.a(e2), (Throwable) e2);
        }
    }

    public static void registerFunction(Class<? extends Function> cls) {
        try {
            Function functionNewInstance = cls.newInstance();
            functionMap.put(functionNewInstance.name(), functionNewInstance);
        } catch (Exception e2) {
            logger.info(k.b.a.a.h.a.a(e2), (Throwable) e2);
        }
    }

    public static void registerNodeTest(Class<? extends NodeTest> cls) {
        try {
            NodeTest nodeTestNewInstance = cls.newInstance();
            nodeTestMap.put(nodeTestNewInstance.name(), nodeTestNewInstance);
        } catch (Exception e2) {
            logger.info(k.b.a.a.h.a.a(e2), (Throwable) e2);
        }
    }
}
