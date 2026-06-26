package org.mozilla.javascript.optimizer;

import androidx.core.app.NotificationCompat;
import c.a.a.a.a;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import k.d.a.c;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: loaded from: classes3.dex */
public class BodyCodegen {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ECMAERROR_EXCEPTION = 2;
    private static final int EVALUATOR_EXCEPTION = 1;
    private static final int EXCEPTION_MAX = 5;
    private static final int FINALLY_EXCEPTION = 4;
    public static final int GENERATOR_START = 0;
    public static final int GENERATOR_TERMINATE = -1;
    public static final int GENERATOR_YIELD_START = 1;
    private static final int JAVASCRIPT_EXCEPTION = 0;
    private static final int MAX_LOCALS = 1024;
    private static final int THROWABLE_EXCEPTION = 3;
    private short argsLocal;
    public c cfw;
    public Codegen codegen;
    public CompilerEnvirons compilerEnv;
    private short contextLocal;
    private int enterAreaStartLabel;
    private int epilogueLabel;
    private Map<Node, FinallyReturnPoint> finallys;
    private short firstFreeLocal;
    private OptFunctionNode fnCurrent;
    private short funObjLocal;
    private short generatorStateLocal;
    private int generatorSwitch;
    private boolean hasVarsInRegs;
    private boolean inDirectCallFunction;
    private boolean inLocalBlock;
    private boolean isGenerator;
    private boolean itsForcedObjectParameters;
    private int itsLineNumber;
    private short itsOneArgArray;
    private short itsZeroArgArray;
    private List<Node> literals;
    private int[] locals;
    private short localsMax;
    private short operationLocal;
    private short popvLocal;
    private int savedCodeOffset;
    public ScriptNode scriptOrFn;
    public int scriptOrFnIndex;
    private short thisObjLocal;
    private short[] varRegisters;
    private short variableObjectLocal;
    private ExceptionManager exceptionManager = new ExceptionManager();
    private int maxLocals = 0;
    private int maxStack = 0;
    private int unnestedYieldCount = 0;
    private IdentityHashMap<Node, String> unnestedYields = new IdentityHashMap<>();

    public class ExceptionManager {
        private LinkedList<ExceptionInfo> exceptionInfo = new LinkedList<>();

        public class ExceptionInfo {
            public Node finallyBlock;
            public int[] handlerLabels = new int[5];
            public int[] exceptionStarts = new int[5];
            public Node currentFinally = null;

            public ExceptionInfo(Jump jump, Node node) {
                this.finallyBlock = node;
            }
        }

        public ExceptionManager() {
        }

        private void endCatch(ExceptionInfo exceptionInfo, int i2, int i3) {
            int[] iArr = exceptionInfo.exceptionStarts;
            if (iArr[i2] == 0) {
                throw new IllegalStateException("bad exception start");
            }
            if (BodyCodegen.this.cfw.F(iArr[i2]) != BodyCodegen.this.cfw.F(i3)) {
                BodyCodegen.this.cfw.k(exceptionInfo.exceptionStarts[i2], i3, exceptionInfo.handlerLabels[i2], BodyCodegen.exceptionTypeToName(i2));
            }
        }

        private ExceptionInfo getTop() {
            return this.exceptionInfo.getLast();
        }

        public void addHandler(int i2, int i3, int i4) {
            ExceptionInfo top = getTop();
            top.handlerLabels[i2] = i3;
            top.exceptionStarts[i2] = i4;
        }

        public void markInlineFinallyEnd(Node node, int i2) {
            LinkedList<ExceptionInfo> linkedList = this.exceptionInfo;
            ListIterator<ExceptionInfo> listIterator = linkedList.listIterator(linkedList.size());
            while (listIterator.hasPrevious()) {
                ExceptionInfo exceptionInfoPrevious = listIterator.previous();
                for (int i3 = 0; i3 < 5; i3++) {
                    if (exceptionInfoPrevious.handlerLabels[i3] != 0 && exceptionInfoPrevious.currentFinally == node) {
                        exceptionInfoPrevious.exceptionStarts[i3] = i2;
                        exceptionInfoPrevious.currentFinally = null;
                    }
                }
                if (exceptionInfoPrevious.finallyBlock == node) {
                    return;
                }
            }
        }

        public void markInlineFinallyStart(Node node, int i2) {
            LinkedList<ExceptionInfo> linkedList = this.exceptionInfo;
            ListIterator<ExceptionInfo> listIterator = linkedList.listIterator(linkedList.size());
            while (listIterator.hasPrevious()) {
                ExceptionInfo exceptionInfoPrevious = listIterator.previous();
                for (int i3 = 0; i3 < 5; i3++) {
                    if (exceptionInfoPrevious.handlerLabels[i3] != 0 && exceptionInfoPrevious.currentFinally == null) {
                        endCatch(exceptionInfoPrevious, i3, i2);
                        exceptionInfoPrevious.exceptionStarts[i3] = 0;
                        exceptionInfoPrevious.currentFinally = node;
                    }
                }
                if (exceptionInfoPrevious.finallyBlock == node) {
                    return;
                }
            }
        }

        public void popExceptionInfo() {
            this.exceptionInfo.removeLast();
        }

        public void pushExceptionInfo(Jump jump) {
            this.exceptionInfo.add(new ExceptionInfo(jump, BodyCodegen.getFinallyAtTarget(jump.getFinally())));
        }

        public int removeHandler(int i2, int i3) {
            ExceptionInfo top = getTop();
            int[] iArr = top.handlerLabels;
            if (iArr[i2] == 0) {
                return 0;
            }
            int i4 = iArr[i2];
            endCatch(top, i2, i3);
            top.handlerLabels[i2] = 0;
            return i4;
        }

        public void setHandlers(int[] iArr, int i2) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (iArr[i3] != 0) {
                    addHandler(i3, iArr[i3], i2);
                }
            }
        }
    }

    public static class FinallyReturnPoint {
        public List<Integer> jsrPoints = new ArrayList();
        public int tableLabel = 0;
    }

    private void addDoubleWrap() {
        addOptRuntimeInvoke("wrapDouble", "(D)Ljava/lang/Double;");
    }

    private void addGoto(Node node, int i2) {
        this.cfw.d(i2, getTargetLabel(node));
    }

    private void addGotoWithReturn(Node node) {
        FinallyReturnPoint finallyReturnPoint = this.finallys.get(node);
        this.cfw.q(finallyReturnPoint.jsrPoints.size());
        addGoto(node, Token.LAST_TOKEN);
        this.cfw.c(87);
        int iB = this.cfw.b();
        this.cfw.H(iB);
        finallyReturnPoint.jsrPoints.add(Integer.valueOf(iB));
    }

    private void addInstructionCount() {
        addInstructionCount(Math.max(this.cfw.m - this.savedCodeOffset, 1));
    }

    private void addJumpedBooleanWrap(int i2, int i3) {
        this.cfw.H(i3);
        int iB = this.cfw.b();
        this.cfw.f(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
        this.cfw.d(Token.LAST_TOKEN, iB);
        this.cfw.H(i2);
        this.cfw.f(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
        this.cfw.H(iB);
        this.cfw.C(-1);
    }

    private void addLoadPropertyIds(Object[] objArr, int i2) {
        addNewObjectArray(i2);
        for (int i3 = 0; i3 != i2; i3++) {
            this.cfw.c(89);
            this.cfw.t(i3);
            Object obj = objArr[i3];
            if (obj instanceof String) {
                this.cfw.u((String) obj);
            } else {
                this.cfw.t(((Integer) obj).intValue());
                addScriptRuntimeInvoke("wrapInt", "(I)Ljava/lang/Integer;");
            }
            this.cfw.c(83);
        }
    }

    private void addLoadPropertyValues(Node node, Node node2, int i2) {
        int i3 = 0;
        if (!this.isGenerator) {
            addNewObjectArray(i2);
            while (i3 != i2) {
                this.cfw.c(89);
                this.cfw.t(i3);
                int type = node2.getType();
                if (type == 152 || type == 153 || type == 164) {
                    generateExpression(node2.getFirstChild(), node);
                } else {
                    generateExpression(node2, node);
                }
                this.cfw.c(83);
                node2 = node2.getNext();
                i3++;
            }
            return;
        }
        for (int i4 = 0; i4 != i2; i4++) {
            int type2 = node2.getType();
            if (type2 == 152 || type2 == 153 || type2 == 164) {
                generateExpression(node2.getFirstChild(), node);
            } else {
                generateExpression(node2, node);
            }
            node2 = node2.getNext();
        }
        addNewObjectArray(i2);
        while (i3 != i2) {
            this.cfw.c(90);
            this.cfw.c(95);
            this.cfw.t((i2 - i3) - 1);
            this.cfw.c(95);
            this.cfw.c(83);
            i3++;
        }
    }

    private void addNewObjectArray(int i2) {
        if (i2 != 0) {
            this.cfw.t(i2);
            this.cfw.e(189, "java/lang/Object");
            return;
        }
        short s = this.itsZeroArgArray;
        if (s >= 0) {
            this.cfw.g(s);
        } else {
            this.cfw.f(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        }
    }

    private void addObjectToDouble() {
        addScriptRuntimeInvoke("toNumber", "(Ljava/lang/Object;)D");
    }

    private void addOptRuntimeInvoke(String str, String str2) {
        this.cfw.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/optimizer/OptRuntime", str, str2);
    }

    private void addScriptRuntimeInvoke(String str, String str2) {
        this.cfw.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org.mozilla.javascript.ScriptRuntime", str, str2);
    }

    private void dcpLoadAsNumber(int i2) {
        this.cfw.T(42, 25, i2);
        this.cfw.f(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        int iB = this.cfw.b();
        this.cfw.d(Token.ARROW, iB);
        c cVar = this.cfw;
        short s = cVar.p;
        cVar.T(42, 25, i2);
        addObjectToDouble();
        int iB2 = this.cfw.b();
        this.cfw.d(Token.LAST_TOKEN, iB2);
        c cVar2 = this.cfw;
        cVar2.H(iB);
        cVar2.p = s;
        this.cfw.i(i2 + 1);
        this.cfw.H(iB2);
    }

    private void dcpLoadAsObject(int i2) {
        this.cfw.T(42, 25, i2);
        this.cfw.f(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        int iB = this.cfw.b();
        this.cfw.d(Token.ARROW, iB);
        c cVar = this.cfw;
        short s = cVar.p;
        cVar.T(42, 25, i2);
        int iB2 = this.cfw.b();
        this.cfw.d(Token.LAST_TOKEN, iB2);
        c cVar2 = this.cfw;
        cVar2.H(iB);
        cVar2.p = s;
        this.cfw.i(i2 + 1);
        addDoubleWrap();
        this.cfw.H(iB2);
    }

    private void decReferenceWordLocal(short s) {
        this.locals[s] = r0[s] - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String exceptionTypeToName(int i2) {
        if (i2 == 0) {
            return "org/mozilla/javascript/JavaScriptException";
        }
        if (i2 == 1) {
            return "org/mozilla/javascript/EvaluatorException";
        }
        if (i2 == 2) {
            return "org/mozilla/javascript/EcmaError";
        }
        if (i2 == 3) {
            return "java/lang/Throwable";
        }
        if (i2 == 4) {
            return null;
        }
        throw Kit.codeBug();
    }

    private Node findNestedYield(Node node) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            if (firstChild.getType() == 73 || firstChild.getType() == 166) {
                return firstChild;
            }
            Node nodeFindNestedYield = findNestedYield(firstChild);
            if (nodeFindNestedYield != null) {
                return nodeFindNestedYield;
            }
        }
        return null;
    }

    private void genSimpleCompare(int i2, int i3, int i4) {
        if (i3 == -1) {
            throw Codegen.badTree();
        }
        switch (i2) {
            case 14:
                this.cfw.c(152);
                this.cfw.d(155, i3);
                break;
            case 15:
                this.cfw.c(152);
                this.cfw.d(158, i3);
                break;
            case 16:
                this.cfw.c(151);
                this.cfw.d(157, i3);
                break;
            case 17:
                this.cfw.c(151);
                this.cfw.d(156, i3);
                break;
            default:
                throw Codegen.badTree();
        }
        if (i4 != -1) {
            this.cfw.d(Token.LAST_TOKEN, i4);
        }
    }

    private void generateActivationExit() {
        if (this.fnCurrent == null || this.hasVarsInRegs) {
            throw Kit.codeBug();
        }
        this.cfw.g(this.contextLocal);
        addScriptRuntimeInvoke("exitActivationFunction", Codegen.REGEXP_INIT_METHOD_SIGNATURE);
    }

    private void generateArrayLiteralFactory(Node node, int i2) {
        String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i2;
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        this.cfw.Q(str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitArrayLiteral(node, node.getFirstChild(), true);
        this.cfw.c(176);
        this.cfw.R((short) (this.localsMax + 1));
    }

    private void generateCallArgArray(Node node, Node node2, boolean z) {
        short s;
        int i2 = 0;
        for (Node next = node2; next != null; next = next.getNext()) {
            i2++;
        }
        if (i2 != 1 || (s = this.itsOneArgArray) < 0) {
            addNewObjectArray(i2);
        } else {
            this.cfw.g(s);
        }
        for (int i3 = 0; i3 != i2; i3++) {
            if (!this.isGenerator) {
                this.cfw.c(89);
                this.cfw.t(i3);
            }
            if (z) {
                int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
                if (iNodeIsDirectCallParameter >= 0) {
                    dcpLoadAsObject(iNodeIsDirectCallParameter);
                } else {
                    generateExpression(node2, node);
                    if (node2.getIntProp(8, -1) == 0) {
                        addDoubleWrap();
                    }
                }
            } else {
                generateExpression(node2, node);
            }
            if (this.isGenerator) {
                short newWordLocal = getNewWordLocal();
                this.cfw.h(newWordLocal);
                this.cfw.e(192, "[Ljava/lang/Object;");
                this.cfw.c(89);
                this.cfw.t(i3);
                this.cfw.g(newWordLocal);
                releaseWordLocal(newWordLocal);
            }
            this.cfw.c(83);
            node2 = node2.getNext();
        }
    }

    private void generateCatchBlock(int i2, short s, int i3, int i4, int i5) {
        if (i5 == 0) {
            i5 = this.cfw.b();
        }
        this.cfw.G(i5);
        this.cfw.T(75, 58, i4);
        this.cfw.T(42, 25, s);
        this.cfw.h(this.variableObjectLocal);
        this.cfw.d(Token.LAST_TOKEN, i3);
    }

    private void generateCheckForThrowOrClose(int i2, boolean z, int i3) {
        int iB = this.cfw.b();
        int iB2 = this.cfw.b();
        this.cfw.H(iB);
        this.cfw.g(this.argsLocal);
        generateThrowJavaScriptException();
        this.cfw.H(iB2);
        this.cfw.g(this.argsLocal);
        this.cfw.e(192, "java/lang/Throwable");
        this.cfw.c(191);
        if (i2 != -1) {
            this.cfw.H(i2);
        }
        if (!z) {
            this.cfw.I(this.generatorSwitch, i3);
        }
        this.cfw.m(this.operationLocal);
        this.cfw.q(2);
        this.cfw.d(Token.LETEXPR, iB2);
        this.cfw.m(this.operationLocal);
        this.cfw.q(1);
        this.cfw.d(Token.LETEXPR, iB);
    }

    private void generateEpilogue() {
        if (this.compilerEnv.isGenerateObserverCount()) {
            addInstructionCount();
        }
        if (this.isGenerator) {
            Map<Node, int[]> liveLocals = ((FunctionNode) this.scriptOrFn).getLiveLocals();
            if (liveLocals != null) {
                List<Node> resumptionPoints = ((FunctionNode) this.scriptOrFn).getResumptionPoints();
                for (int i2 = 0; i2 < resumptionPoints.size(); i2++) {
                    Node node = resumptionPoints.get(i2);
                    int[] iArr = liveLocals.get(node);
                    if (iArr != null) {
                        this.cfw.I(this.generatorSwitch, getNextGeneratorState(node));
                        generateGetGeneratorLocalsState();
                        for (int i3 = 0; i3 < iArr.length; i3++) {
                            this.cfw.c(89);
                            this.cfw.q(i3);
                            this.cfw.c(50);
                            this.cfw.h(iArr[i3]);
                        }
                        this.cfw.c(87);
                        this.cfw.d(Token.LAST_TOKEN, getTargetLabel(node));
                    }
                }
            }
            Map<Node, FinallyReturnPoint> map = this.finallys;
            if (map != null) {
                for (Map.Entry<Node, FinallyReturnPoint> entry : map.entrySet()) {
                    if (entry.getKey().getType() == 126) {
                        FinallyReturnPoint value = entry.getValue();
                        c cVar = this.cfw;
                        cVar.H(value.tableLabel);
                        cVar.p = (short) 1;
                        int iY = this.cfw.y(0, value.jsrPoints.size() - 1);
                        this.cfw.K(iY);
                        int i4 = 0;
                        for (int i5 = 0; i5 < value.jsrPoints.size(); i5++) {
                            this.cfw.I(iY, i4);
                            this.cfw.d(Token.LAST_TOKEN, value.jsrPoints.get(i5).intValue());
                            i4++;
                        }
                    }
                }
            }
        }
        int i6 = this.epilogueLabel;
        if (i6 != -1) {
            this.cfw.H(i6);
        }
        if (this.isGenerator) {
            if (((FunctionNode) this.scriptOrFn).getResumptionPoints() != null) {
                this.cfw.K(this.generatorSwitch);
            }
            generateSetGeneratorResumptionPoint(-1);
            this.cfw.g(this.variableObjectLocal);
            this.cfw.g(this.generatorStateLocal);
            addOptRuntimeInvoke("throwStopIteration", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            Codegen.pushUndefined(this.cfw);
            this.cfw.c(176);
            return;
        }
        if (this.hasVarsInRegs) {
            this.cfw.c(176);
            return;
        }
        if (this.fnCurrent == null) {
            this.cfw.g(this.popvLocal);
            this.cfw.c(176);
            return;
        }
        generateActivationExit();
        this.cfw.c(176);
        int iB = this.cfw.b();
        this.cfw.G(iB);
        short newWordLocal = getNewWordLocal();
        this.cfw.h(newWordLocal);
        generateActivationExit();
        this.cfw.g(newWordLocal);
        releaseWordLocal(newWordLocal);
        this.cfw.c(191);
        this.cfw.k(this.enterAreaStartLabel, this.epilogueLabel, iB, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0461  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void generateExpression(org.mozilla.javascript.Node r14, org.mozilla.javascript.Node r15) {
        /*
            Method dump skipped, instruction units count: 1632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.BodyCodegen.generateExpression(org.mozilla.javascript.Node, org.mozilla.javascript.Node):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void generateFunctionAndThisObj(org.mozilla.javascript.Node r5, org.mozilla.javascript.Node r6) {
        /*
            r4 = this;
            int r0 = r5.getType()
            int r1 = r5.getType()
            r2 = 33
            if (r1 == r2) goto L4e
            r3 = 34
            if (r1 == r3) goto L49
            r3 = 36
            if (r1 == r3) goto L4e
            r0 = 39
            if (r1 == r0) goto L2a
            r4.generateExpression(r5, r6)
            k.d.a.c r5 = r4.cfw
            short r6 = r4.contextLocal
            r5.g(r6)
            java.lang.String r5 = "getValueFunctionAndThis"
            java.lang.String r6 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Callable;"
            r4.addScriptRuntimeInvoke(r5, r6)
            goto L9e
        L2a:
            java.lang.String r5 = r5.getString()
            k.d.a.c r6 = r4.cfw
            r6.u(r5)
            k.d.a.c r5 = r4.cfw
            short r6 = r4.contextLocal
            r5.g(r6)
            k.d.a.c r5 = r4.cfw
            short r6 = r4.variableObjectLocal
            r5.g(r6)
            java.lang.String r5 = "getNameFunctionAndThis"
            java.lang.String r6 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;"
            r4.addScriptRuntimeInvoke(r5, r6)
            goto L9e
        L49:
            java.lang.RuntimeException r5 = org.mozilla.javascript.Kit.codeBug()
            throw r5
        L4e:
            org.mozilla.javascript.Node r6 = r5.getFirstChild()
            r4.generateExpression(r6, r5)
            org.mozilla.javascript.Node r6 = r6.getNext()
            if (r0 != r2) goto L7a
            java.lang.String r5 = r6.getString()
            k.d.a.c r6 = r4.cfw
            r6.u(r5)
            k.d.a.c r5 = r4.cfw
            short r6 = r4.contextLocal
            r5.g(r6)
            k.d.a.c r5 = r4.cfw
            short r6 = r4.variableObjectLocal
            r5.g(r6)
            java.lang.String r5 = "getPropFunctionAndThis"
            java.lang.String r6 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;"
            r4.addScriptRuntimeInvoke(r5, r6)
            goto L9e
        L7a:
            r4.generateExpression(r6, r5)
            r6 = 8
            r0 = -1
            int r5 = r5.getIntProp(r6, r0)
            if (r5 == r0) goto L89
            r4.addDoubleWrap()
        L89:
            k.d.a.c r5 = r4.cfw
            short r6 = r4.contextLocal
            r5.g(r6)
            k.d.a.c r5 = r4.cfw
            short r6 = r4.variableObjectLocal
            r5.g(r6)
            java.lang.String r5 = "getElemFunctionAndThis"
            java.lang.String r6 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;"
            r4.addScriptRuntimeInvoke(r5, r6)
        L9e:
            k.d.a.c r5 = r4.cfw
            short r6 = r4.contextLocal
            r5.g(r6)
            java.lang.String r5 = "lastStoredScriptable"
            java.lang.String r6 = "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Scriptable;"
            r4.addScriptRuntimeInvoke(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.BodyCodegen.generateFunctionAndThisObj(org.mozilla.javascript.Node, org.mozilla.javascript.Node):void");
    }

    private void generateGenerator() {
        this.cfw.Q(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        if (this.fnCurrent != null) {
            this.cfw.g(this.funObjLocal);
            this.cfw.o(185, "org/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.h(this.variableObjectLocal);
        }
        this.cfw.g(this.funObjLocal);
        this.cfw.g(this.variableObjectLocal);
        this.cfw.g(this.argsLocal);
        this.cfw.v(this.scriptOrFn.isInStrictMode());
        addScriptRuntimeInvoke("createFunctionActivation", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.h(this.variableObjectLocal);
        this.cfw.e(187, this.codegen.mainClassName);
        this.cfw.c(89);
        this.cfw.g(this.variableObjectLocal);
        this.cfw.g(this.contextLocal);
        this.cfw.t(this.scriptOrFnIndex);
        this.cfw.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, this.codegen.mainClassName, "<init>", Codegen.FUNCTION_CONSTRUCTOR_SIGNATURE);
        generateNestedFunctionInits();
        this.cfw.g(this.variableObjectLocal);
        this.cfw.g(this.thisObjLocal);
        this.cfw.q(this.maxLocals);
        this.cfw.q(this.maxStack);
        addOptRuntimeInvoke("createNativeGenerator", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;II)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.c(176);
        this.cfw.R((short) (this.localsMax + 1));
    }

    private void generateGetGeneratorLocalsState() {
        this.cfw.g(this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorLocalsState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateGetGeneratorResumptionPoint() {
        this.cfw.g(this.generatorStateLocal);
        this.cfw.f(180, OptRuntime.GeneratorState.CLASS_NAME, OptRuntime.GeneratorState.resumptionPoint_NAME, OptRuntime.GeneratorState.resumptionPoint_TYPE);
    }

    private void generateGetGeneratorStackState() {
        this.cfw.g(this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorStackState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateIfJump(Node node, Node node2, int i2, int i3) {
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 26) {
            generateIfJump(firstChild, node, i3, i2);
            return;
        }
        if (type != 46 && type != 47) {
            if (type != 52 && type != 53) {
                if (type == 105 || type == 106) {
                    int iB = this.cfw.b();
                    if (type == 106) {
                        generateIfJump(firstChild, node, iB, i3);
                    } else {
                        generateIfJump(firstChild, node, i2, iB);
                    }
                    this.cfw.H(iB);
                    generateIfJump(firstChild.getNext(), node, i2, i3);
                    return;
                }
                switch (type) {
                    case 12:
                    case 13:
                        break;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        break;
                    default:
                        generateExpression(node, node2);
                        addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
                        this.cfw.d(154, i2);
                        this.cfw.d(Token.LAST_TOKEN, i3);
                        break;
                }
                return;
            }
            visitIfJumpRelOp(node, firstChild, i2, i3);
            return;
        }
        visitIfJumpEqOp(node, firstChild, i2, i3);
    }

    private void generateIntegerUnwrap() {
        this.cfw.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/Integer", "intValue", "()I");
    }

    private void generateIntegerWrap() {
        this.cfw.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    }

    private void generateLocalYieldPoint(Node node, boolean z) {
        short s = this.cfw.p;
        int i2 = this.maxStack;
        if (i2 <= s) {
            i2 = s;
        }
        this.maxStack = i2;
        if (s != 0) {
            generateGetGeneratorStackState();
            for (int i3 = 0; i3 < s; i3++) {
                this.cfw.c(90);
                this.cfw.c(95);
                this.cfw.q(i3);
                this.cfw.c(95);
                this.cfw.c(83);
            }
            this.cfw.c(87);
        }
        Node firstChild = node.getFirstChild();
        if (firstChild != null) {
            generateExpression(firstChild, node);
        } else {
            Codegen.pushUndefined(this.cfw);
        }
        if (node.getType() == 166) {
            this.cfw.e(187, "org/mozilla/javascript/ES6Generator$YieldStarResult");
            this.cfw.c(90);
            this.cfw.c(95);
            this.cfw.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, "org/mozilla/javascript/ES6Generator$YieldStarResult", "<init>", "(Ljava/lang/Object;)V");
        }
        int nextGeneratorState = getNextGeneratorState(node);
        generateSetGeneratorResumptionPoint(nextGeneratorState);
        boolean zGenerateSaveLocals = generateSaveLocals(node);
        this.cfw.c(176);
        generateCheckForThrowOrClose(getTargetLabel(node), zGenerateSaveLocals, nextGeneratorState);
        if (s != 0) {
            generateGetGeneratorStackState();
            for (int i4 = s - 1; i4 >= 0; i4--) {
                this.cfw.c(89);
                this.cfw.q(i4);
                this.cfw.c(50);
                this.cfw.c(95);
            }
            this.cfw.c(87);
        }
        if (z) {
            this.cfw.g(this.argsLocal);
        }
    }

    private void generateNestedFunctionInits() {
        int functionCount = this.scriptOrFn.getFunctionCount();
        for (int i2 = 0; i2 != functionCount; i2++) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn, i2);
            if (optFunctionNode.fnode.getFunctionType() == 1) {
                visitFunction(optFunctionNode, 1);
            }
        }
    }

    private void generateObjectLiteralFactory(Node node, int i2) {
        String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i2;
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        this.cfw.Q(str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitObjectLiteral(node, node.getFirstChild(), true);
        this.cfw.c(176);
        this.cfw.R((short) (this.localsMax + 1));
    }

    private void generatePrologue() {
        String str;
        short newWordLocal;
        if (this.inDirectCallFunction) {
            int paramCount = this.scriptOrFn.getParamCount();
            if (this.firstFreeLocal != 4) {
                Kit.codeBug();
            }
            for (int i2 = 0; i2 != paramCount; i2++) {
                short[] sArr = this.varRegisters;
                short s = this.firstFreeLocal;
                sArr[i2] = s;
                this.firstFreeLocal = (short) (s + 3);
            }
            if (!this.fnCurrent.getParameterNumberContext()) {
                this.itsForcedObjectParameters = true;
                for (int i3 = 0; i3 != paramCount; i3++) {
                    short s2 = this.varRegisters[i3];
                    this.cfw.g(s2);
                    this.cfw.f(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                    int iB = this.cfw.b();
                    this.cfw.d(166, iB);
                    this.cfw.i(s2 + 1);
                    addDoubleWrap();
                    this.cfw.h(s2);
                    this.cfw.H(iB);
                }
            }
        }
        if (this.fnCurrent != null) {
            this.cfw.g(this.funObjLocal);
            this.cfw.o(185, "org/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.h(this.variableObjectLocal);
        }
        short s3 = this.firstFreeLocal;
        short s4 = (short) (s3 + 1);
        this.firstFreeLocal = s4;
        this.argsLocal = s3;
        this.localsMax = s4;
        if (this.isGenerator) {
            short s5 = (short) (s4 + 1);
            this.firstFreeLocal = s5;
            this.operationLocal = s4;
            this.localsMax = s5;
            this.cfw.g(this.thisObjLocal);
            short s6 = this.firstFreeLocal;
            short s7 = (short) (s6 + 1);
            this.firstFreeLocal = s7;
            this.generatorStateLocal = s6;
            this.localsMax = s7;
            this.cfw.e(192, OptRuntime.GeneratorState.CLASS_NAME);
            this.cfw.c(89);
            this.cfw.h(this.generatorStateLocal);
            this.cfw.f(180, OptRuntime.GeneratorState.CLASS_NAME, OptRuntime.GeneratorState.thisObj_NAME, OptRuntime.GeneratorState.thisObj_TYPE);
            this.cfw.h(this.thisObjLocal);
            if (this.epilogueLabel == -1) {
                this.epilogueLabel = this.cfw.b();
            }
            List<Node> resumptionPoints = ((FunctionNode) this.scriptOrFn).getResumptionPoints();
            if (resumptionPoints != null) {
                generateGetGeneratorResumptionPoint();
                this.generatorSwitch = this.cfw.y(0, resumptionPoints.size() + 0);
                generateCheckForThrowOrClose(-1, false, 0);
            }
        }
        if (this.fnCurrent == null && this.scriptOrFn.getRegexpCount() != 0) {
            this.cfw.g(this.contextLocal);
            this.cfw.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, this.codegen.mainClassName, Codegen.REGEXP_INIT_METHOD_NAME, Codegen.REGEXP_INIT_METHOD_SIGNATURE);
        }
        if (this.compilerEnv.isGenerateObserverCount()) {
            saveCurrentCodeOffset();
        }
        if (this.isGenerator) {
            return;
        }
        if (!this.hasVarsInRegs) {
            ScriptNode scriptNode = this.scriptOrFn;
            boolean z = (scriptNode instanceof FunctionNode) && ((FunctionNode) scriptNode).getFunctionType() == 4;
            if (this.fnCurrent != null) {
                this.cfw.g(this.funObjLocal);
                this.cfw.g(this.variableObjectLocal);
                this.cfw.g(this.argsLocal);
                String str2 = z ? "createArrowFunctionActivation" : "createFunctionActivation";
                this.cfw.v(this.scriptOrFn.isInStrictMode());
                addScriptRuntimeInvoke(str2, "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Lorg/mozilla/javascript/Scriptable;");
                this.cfw.h(this.variableObjectLocal);
                this.cfw.g(this.contextLocal);
                this.cfw.g(this.variableObjectLocal);
                addScriptRuntimeInvoke("enterActivationFunction", Codegen.FUNCTION_INIT_SIGNATURE);
                str = "activation";
            } else {
                this.cfw.g(this.funObjLocal);
                this.cfw.g(this.thisObjLocal);
                this.cfw.g(this.contextLocal);
                this.cfw.g(this.variableObjectLocal);
                this.cfw.t(0);
                addScriptRuntimeInvoke("initScript", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Z)V");
                str = "global";
            }
            this.enterAreaStartLabel = this.cfw.b();
            this.epilogueLabel = this.cfw.b();
            this.cfw.H(this.enterAreaStartLabel);
            generateNestedFunctionInits();
            if (this.compilerEnv.isGenerateDebugInfo()) {
                c cVar = this.cfw;
                cVar.B(str, OptRuntime.GeneratorState.thisObj_TYPE, cVar.m, this.variableObjectLocal);
            }
            OptFunctionNode optFunctionNode = this.fnCurrent;
            if (optFunctionNode == null) {
                this.popvLocal = getNewWordLocal();
                Codegen.pushUndefined(this.cfw);
                this.cfw.h(this.popvLocal);
                int endLineno = this.scriptOrFn.getEndLineno();
                if (endLineno != -1) {
                    this.cfw.p((short) endLineno);
                    return;
                }
                return;
            }
            if (optFunctionNode.itsContainsCalls0) {
                this.itsZeroArgArray = getNewWordLocal();
                this.cfw.f(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
                this.cfw.h(this.itsZeroArgArray);
            }
            if (this.fnCurrent.itsContainsCalls1) {
                this.itsOneArgArray = getNewWordLocal();
                this.cfw.t(1);
                this.cfw.e(189, "java/lang/Object");
                this.cfw.h(this.itsOneArgArray);
                return;
            }
            return;
        }
        int paramCount2 = this.scriptOrFn.getParamCount();
        if (paramCount2 > 0 && !this.inDirectCallFunction) {
            this.cfw.g(this.argsLocal);
            this.cfw.c(190);
            this.cfw.t(paramCount2);
            int iB2 = this.cfw.b();
            this.cfw.d(Token.COMMENT, iB2);
            this.cfw.g(this.argsLocal);
            this.cfw.t(paramCount2);
            addScriptRuntimeInvoke("padArguments", "([Ljava/lang/Object;I)[Ljava/lang/Object;");
            this.cfw.h(this.argsLocal);
            this.cfw.H(iB2);
        }
        int paramCount3 = this.fnCurrent.fnode.getParamCount();
        int paramAndVarCount = this.fnCurrent.fnode.getParamAndVarCount();
        boolean[] paramAndVarConst = this.fnCurrent.fnode.getParamAndVarConst();
        short s8 = -1;
        for (int i4 = 0; i4 != paramAndVarCount; i4++) {
            if (i4 < paramCount3) {
                if (this.inDirectCallFunction) {
                    newWordLocal = -1;
                } else {
                    newWordLocal = getNewWordLocal();
                    this.cfw.g(this.argsLocal);
                    this.cfw.t(i4);
                    this.cfw.c(50);
                    this.cfw.h(newWordLocal);
                }
            } else if (this.fnCurrent.isNumberVar(i4)) {
                newWordLocal = getNewWordPairLocal(paramAndVarConst[i4]);
                this.cfw.s(0.0d);
                this.cfw.j(newWordLocal);
            } else {
                newWordLocal = getNewWordLocal(paramAndVarConst[i4]);
                if (s8 == -1) {
                    Codegen.pushUndefined(this.cfw);
                    s8 = newWordLocal;
                } else {
                    this.cfw.g(s8);
                }
                this.cfw.h(newWordLocal);
            }
            if (newWordLocal >= 0) {
                if (paramAndVarConst[i4]) {
                    this.cfw.t(0);
                    this.cfw.n((this.fnCurrent.isNumberVar(i4) ? (short) 2 : (short) 1) + newWordLocal);
                }
                this.varRegisters[i4] = newWordLocal;
            }
            if (this.compilerEnv.isGenerateDebugInfo()) {
                String paramOrVarName = this.fnCurrent.fnode.getParamOrVarName(i4);
                String str3 = this.fnCurrent.isNumberVar(i4) ? "D" : "Ljava/lang/Object;";
                c cVar2 = this.cfw;
                int i5 = cVar2.m;
                if (newWordLocal < 0) {
                    newWordLocal = this.varRegisters[i4];
                }
                cVar2.B(paramOrVarName, str3, i5, newWordLocal);
            }
        }
    }

    private boolean generateSaveLocals(Node node) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.firstFreeLocal; i3++) {
            if (this.locals[i3] != 0) {
                i2++;
            }
        }
        if (i2 == 0) {
            ((FunctionNode) this.scriptOrFn).addLiveLocals(node, null);
            return false;
        }
        int i4 = this.maxLocals;
        if (i4 <= i2) {
            i4 = i2;
        }
        this.maxLocals = i4;
        int[] iArr = new int[i2];
        int i5 = 0;
        for (int i6 = 0; i6 < this.firstFreeLocal; i6++) {
            if (this.locals[i6] != 0) {
                iArr[i5] = i6;
                i5++;
            }
        }
        ((FunctionNode) this.scriptOrFn).addLiveLocals(node, iArr);
        generateGetGeneratorLocalsState();
        for (int i7 = 0; i7 < i2; i7++) {
            this.cfw.c(89);
            this.cfw.q(i7);
            this.cfw.g(iArr[i7]);
            this.cfw.c(83);
        }
        this.cfw.c(87);
        return true;
    }

    private void generateSetGeneratorResumptionPoint(int i2) {
        this.cfw.g(this.generatorStateLocal);
        this.cfw.q(i2);
        this.cfw.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, OptRuntime.GeneratorState.CLASS_NAME, OptRuntime.GeneratorState.resumptionPoint_NAME, OptRuntime.GeneratorState.resumptionPoint_TYPE);
    }

    private void generateSetGeneratorReturnValue() {
        this.cfw.g(this.generatorStateLocal);
        this.cfw.c(95);
        addOptRuntimeInvoke("setGeneratorReturnValue", "(Ljava/lang/Object;Ljava/lang/Object;)V");
    }

    private void generateStatement(Node node) {
        updateLineNumber(node);
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 50) {
            generateExpression(firstChild, node);
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount();
            }
            generateThrowJavaScriptException();
            return;
        }
        if (type == 51) {
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount();
            }
            this.cfw.g(getLocalBlockRegister(node));
            this.cfw.c(191);
            return;
        }
        if (type != 65) {
            if (type == 82) {
                visitTryCatchFinally((Jump) node, firstChild);
                return;
            }
            int i2 = 1;
            if (type == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn, node.getExistingIntProp(1));
                int functionType = optFunctionNode.fnode.getFunctionType();
                if (functionType == 3) {
                    visitFunction(optFunctionNode, functionType);
                    return;
                } else {
                    if (functionType != 1) {
                        throw Codegen.badTree();
                    }
                    return;
                }
            }
            if (type == 115) {
                if (this.compilerEnv.isGenerateObserverCount()) {
                    addInstructionCount();
                }
                visitSwitch((Jump) node, firstChild);
                return;
            }
            if (type != 124) {
                if (type == 126) {
                    if (this.isGenerator) {
                        if (this.compilerEnv.isGenerateObserverCount()) {
                            saveCurrentCodeOffset();
                        }
                        this.cfw.p = (short) 1;
                        short newWordLocal = getNewWordLocal();
                        int iB = this.cfw.b();
                        int iB2 = this.cfw.b();
                        this.cfw.H(iB);
                        generateIntegerWrap();
                        this.cfw.h(newWordLocal);
                        while (firstChild != null) {
                            generateStatement(firstChild);
                            firstChild = firstChild.getNext();
                        }
                        this.cfw.g(newWordLocal);
                        this.cfw.e(192, "java/lang/Integer");
                        generateIntegerUnwrap();
                        FinallyReturnPoint finallyReturnPoint = this.finallys.get(node);
                        int iB3 = this.cfw.b();
                        finallyReturnPoint.tableLabel = iB3;
                        this.cfw.d(Token.LAST_TOKEN, iB3);
                        this.cfw.p = (short) 0;
                        releaseWordLocal(newWordLocal);
                        this.cfw.H(iB2);
                        return;
                    }
                    return;
                }
                if (type == 142) {
                    boolean z = this.inLocalBlock;
                    this.inLocalBlock = true;
                    short newWordLocal2 = getNewWordLocal();
                    if (this.isGenerator) {
                        this.cfw.c(1);
                        this.cfw.h(newWordLocal2);
                    }
                    node.putIntProp(2, newWordLocal2);
                    while (firstChild != null) {
                        generateStatement(firstChild);
                        firstChild = firstChild.getNext();
                    }
                    releaseWordLocal(newWordLocal2);
                    node.removeProp(2);
                    this.inLocalBlock = z;
                    return;
                }
                if (type != 161) {
                    switch (type) {
                        case 2:
                            generateExpression(firstChild, node);
                            this.cfw.g(this.contextLocal);
                            this.cfw.g(this.variableObjectLocal);
                            addScriptRuntimeInvoke("enterWith", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                            this.cfw.h(this.variableObjectLocal);
                            incReferenceWordLocal(this.variableObjectLocal);
                            return;
                        case 3:
                            this.cfw.g(this.variableObjectLocal);
                            addScriptRuntimeInvoke("leaveWith", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                            this.cfw.h(this.variableObjectLocal);
                            decReferenceWordLocal(this.variableObjectLocal);
                            return;
                        case 4:
                            break;
                        default:
                            switch (type) {
                                case 57:
                                    this.cfw.p = (short) 0;
                                    int localBlockRegister = getLocalBlockRegister(node);
                                    int existingIntProp = node.getExistingIntProp(14);
                                    String string = firstChild.getString();
                                    generateExpression(firstChild.getNext(), node);
                                    if (existingIntProp == 0) {
                                        this.cfw.c(1);
                                    } else {
                                        this.cfw.g(localBlockRegister);
                                    }
                                    this.cfw.u(string);
                                    this.cfw.g(this.contextLocal);
                                    this.cfw.g(this.variableObjectLocal);
                                    addScriptRuntimeInvoke("newCatchScope", "(Ljava/lang/Throwable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                                    this.cfw.h(localBlockRegister);
                                    return;
                                case 58:
                                case 59:
                                case 60:
                                case 61:
                                    generateExpression(firstChild, node);
                                    this.cfw.g(this.contextLocal);
                                    this.cfw.g(this.variableObjectLocal);
                                    if (type == 58) {
                                        i2 = 0;
                                    } else if (type != 59) {
                                        i2 = type == 61 ? 6 : 2;
                                    }
                                    this.cfw.t(i2);
                                    addScriptRuntimeInvoke("enumInit", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                                    this.cfw.h(getLocalBlockRegister(node));
                                    return;
                                default:
                                    switch (type) {
                                        case Token.EMPTY /* 129 */:
                                        case 130:
                                        case Token.LABEL /* 131 */:
                                        case Token.LOOP /* 133 */:
                                        case Token.SCRIPT /* 137 */:
                                            break;
                                        case Token.TARGET /* 132 */:
                                            if (this.compilerEnv.isGenerateObserverCount()) {
                                                addInstructionCount();
                                            }
                                            this.cfw.H(getTargetLabel(node));
                                            if (this.compilerEnv.isGenerateObserverCount()) {
                                                saveCurrentCodeOffset();
                                                return;
                                            }
                                            return;
                                        case Token.EXPR_VOID /* 134 */:
                                            if (firstChild.getType() == 56) {
                                                visitSetVar(firstChild, firstChild.getFirstChild(), false);
                                                return;
                                            }
                                            if (firstChild.getType() == 157) {
                                                visitSetConstVar(firstChild, firstChild.getFirstChild(), false);
                                                return;
                                            }
                                            if (firstChild.getType() == 73 || firstChild.getType() == 166) {
                                                generateYieldPoint(firstChild, false);
                                                return;
                                            }
                                            generateExpression(firstChild, node);
                                            if (node.getIntProp(8, -1) != -1) {
                                                this.cfw.c(88);
                                                return;
                                            } else {
                                                this.cfw.c(87);
                                                return;
                                            }
                                        case Token.EXPR_RESULT /* 135 */:
                                            generateExpression(firstChild, node);
                                            if (this.popvLocal < 0) {
                                                this.popvLocal = getNewWordLocal();
                                            }
                                            this.cfw.h(this.popvLocal);
                                            return;
                                        case Token.JSR /* 136 */:
                                            break;
                                        default:
                                            throw Codegen.badTree();
                                    }
                                    break;
                            }
                        case 5:
                        case 6:
                        case 7:
                            if (this.compilerEnv.isGenerateObserverCount()) {
                                addInstructionCount();
                            }
                            visitGoto((Jump) node, type, firstChild);
                            return;
                    }
                } else {
                    return;
                }
            }
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount(1);
            }
            while (firstChild != null) {
                generateStatement(firstChild);
                firstChild = firstChild.getNext();
            }
            return;
        }
        if (firstChild != null) {
            generateExpression(firstChild, node);
        } else if (type == 4) {
            Codegen.pushUndefined(this.cfw);
        } else {
            short s = this.popvLocal;
            if (s < 0) {
                throw Codegen.badTree();
            }
            this.cfw.g(s);
        }
        if (this.isGenerator) {
            generateSetGeneratorReturnValue();
        }
        if (this.compilerEnv.isGenerateObserverCount()) {
            addInstructionCount();
        }
        if (this.epilogueLabel == -1) {
            if (!this.hasVarsInRegs) {
                throw Codegen.badTree();
            }
            this.epilogueLabel = this.cfw.b();
        }
        this.cfw.d(Token.LAST_TOKEN, this.epilogueLabel);
    }

    private void generateThrowJavaScriptException() {
        this.cfw.e(187, "org/mozilla/javascript/JavaScriptException");
        this.cfw.c(90);
        this.cfw.c(95);
        this.cfw.u(this.scriptOrFn.getSourceName());
        this.cfw.t(this.itsLineNumber);
        this.cfw.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, "org/mozilla/javascript/JavaScriptException", "<init>", "(Ljava/lang/Object;Ljava/lang/String;I)V");
        this.cfw.c(191);
    }

    private void generateYieldPoint(Node node, boolean z) {
        if (this.unnestedYields.containsKey(node)) {
            if (z) {
                this.cfw.g(this.variableObjectLocal);
                this.cfw.r(this.unnestedYields.get(node));
                this.cfw.g(this.contextLocal);
                this.cfw.g(this.variableObjectLocal);
                addScriptRuntimeInvoke("getObjectPropNoWarn", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
                return;
            }
            return;
        }
        Node nodeFindNestedYield = findNestedYield(node);
        if (nodeFindNestedYield != null) {
            generateYieldPoint(nodeFindNestedYield, true);
            StringBuilder sbR = a.r("__nested__yield__");
            sbR.append(this.unnestedYieldCount);
            String string = sbR.toString();
            this.unnestedYieldCount++;
            this.cfw.g(this.variableObjectLocal);
            this.cfw.c(95);
            this.cfw.r(string);
            this.cfw.c(95);
            this.cfw.g(this.contextLocal);
            addScriptRuntimeInvoke("setObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
            this.cfw.c(87);
            this.unnestedYields.put(nodeFindNestedYield, string);
        }
        generateLocalYieldPoint(node, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Node getFinallyAtTarget(Node node) {
        Node next;
        if (node == null) {
            return null;
        }
        if (node.getType() == 126) {
            return node;
        }
        if (node.getType() == 132 && (next = node.getNext()) != null && next.getType() == 126) {
            return next;
        }
        throw Kit.codeBug("bad finally target");
    }

    private static int getLocalBlockRegister(Node node) {
        return ((Node) node.getProp(3)).getExistingIntProp(2);
    }

    private short getNewWordIntern(int i2) {
        int i3;
        int i4;
        int[] iArr = this.locals;
        if (i2 > 1) {
            i3 = this.firstFreeLocal;
            loop0: while (true) {
                if (i3 + i2 > 1024) {
                    i3 = -1;
                    break;
                }
                i4 = 0;
                while (i4 < i2) {
                    if (iArr[i3 + i4] != 0) {
                        break;
                    }
                    i4++;
                }
                break loop0;
                i3 += i4 + 1;
            }
        } else {
            i3 = this.firstFreeLocal;
        }
        if (i3 != -1) {
            iArr[i3] = 1;
            if (i2 > 1) {
                iArr[i3 + 1] = 1;
            }
            if (i2 > 2) {
                iArr[i3 + 2] = 1;
            }
            if (i3 != this.firstFreeLocal) {
                return (short) i3;
            }
            for (int i5 = i2 + i3; i5 < 1024; i5++) {
                if (iArr[i5] == 0) {
                    short s = (short) i5;
                    this.firstFreeLocal = s;
                    if (this.localsMax < s) {
                        this.localsMax = s;
                    }
                    return (short) i3;
                }
            }
        }
        throw Context.reportRuntimeError("Program too complex (out of locals)");
    }

    private short getNewWordLocal(boolean z) {
        return getNewWordIntern(z ? 2 : 1);
    }

    private short getNewWordPairLocal(boolean z) {
        return getNewWordIntern(z ? 3 : 2);
    }

    private int getNextGeneratorState(Node node) {
        return ((FunctionNode) this.scriptOrFn).getResumptionPoints().indexOf(node) + 1;
    }

    private int getTargetLabel(Node node) {
        int iLabelId = node.labelId();
        if (iLabelId != -1) {
            return iLabelId;
        }
        int iB = this.cfw.b();
        node.labelId(iB);
        return iB;
    }

    private void incReferenceWordLocal(short s) {
        int[] iArr = this.locals;
        iArr[s] = iArr[s] + 1;
    }

    private void initBodyGeneration() {
        int paramAndVarCount;
        this.varRegisters = null;
        if (this.scriptOrFn.getType() == 110) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn);
            this.fnCurrent = optFunctionNode;
            boolean z = !optFunctionNode.fnode.requiresActivation();
            this.hasVarsInRegs = z;
            if (z && (paramAndVarCount = this.fnCurrent.fnode.getParamAndVarCount()) != 0) {
                this.varRegisters = new short[paramAndVarCount];
            }
            boolean zIsTargetOfDirectCall = this.fnCurrent.isTargetOfDirectCall();
            this.inDirectCallFunction = zIsTargetOfDirectCall;
            if (zIsTargetOfDirectCall && !this.hasVarsInRegs) {
                Codegen.badTree();
            }
        } else {
            this.fnCurrent = null;
            this.hasVarsInRegs = false;
            this.inDirectCallFunction = false;
        }
        this.locals = new int[1024];
        this.funObjLocal = (short) 0;
        this.contextLocal = (short) 1;
        this.variableObjectLocal = (short) 2;
        this.thisObjLocal = (short) 3;
        this.localsMax = (short) 4;
        this.firstFreeLocal = (short) 4;
        this.popvLocal = (short) -1;
        this.argsLocal = (short) -1;
        this.itsZeroArgArray = (short) -1;
        this.itsOneArgArray = (short) -1;
        this.epilogueLabel = -1;
        this.enterAreaStartLabel = -1;
        this.generatorStateLocal = (short) -1;
    }

    private void inlineFinally(Node node, int i2, int i3) {
        Node finallyAtTarget = getFinallyAtTarget(node);
        finallyAtTarget.resetTargets();
        this.exceptionManager.markInlineFinallyStart(finallyAtTarget, i2);
        for (Node firstChild = finallyAtTarget.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            generateStatement(firstChild);
        }
        this.exceptionManager.markInlineFinallyEnd(finallyAtTarget, i3);
    }

    private static boolean isArithmeticNode(Node node) {
        int type = node.getType();
        return type == 22 || type == 25 || type == 24 || type == 23;
    }

    private int nodeIsDirectCallParameter(Node node) {
        if (node.getType() != 55 || !this.inDirectCallFunction || this.itsForcedObjectParameters) {
            return -1;
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        if (this.fnCurrent.isParameter(varIndex)) {
            return this.varRegisters[varIndex];
        }
        return -1;
    }

    private void releaseWordLocal(short s) {
        if (s < this.firstFreeLocal) {
            this.firstFreeLocal = s;
        }
        this.locals[s] = 0;
    }

    private void saveCurrentCodeOffset() {
        this.savedCodeOffset = this.cfw.m;
    }

    private void updateLineNumber(Node node) {
        int lineno = node.getLineno();
        this.itsLineNumber = lineno;
        if (lineno == -1) {
            return;
        }
        this.cfw.p((short) lineno);
    }

    private boolean varIsDirectCallParameter(int i2) {
        return this.fnCurrent.isParameter(i2) && this.inDirectCallFunction && !this.itsForcedObjectParameters;
    }

    private void visitArithmetic(Node node, int i2, Node node2, Node node3) {
        if (node.getIntProp(8, -1) != -1) {
            generateExpression(node2, node);
            generateExpression(node2.getNext(), node);
            this.cfw.c(i2);
            return;
        }
        boolean zIsArithmeticNode = isArithmeticNode(node3);
        generateExpression(node2, node);
        if (!isArithmeticNode(node2)) {
            addObjectToDouble();
        }
        generateExpression(node2.getNext(), node);
        if (!isArithmeticNode(node2.getNext())) {
            addObjectToDouble();
        }
        this.cfw.c(i2);
        if (zIsArithmeticNode) {
            return;
        }
        addDoubleWrap();
    }

    private void visitArrayLiteral(Node node, Node node2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (Node next = node2; next != null; next = next.getNext()) {
            i3++;
        }
        if (!z && ((i3 > 10 || this.cfw.m > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new LinkedList();
            }
            this.literals.add(node);
            String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.g(this.funObjLocal);
            this.cfw.g(this.contextLocal);
            this.cfw.g(this.variableObjectLocal);
            this.cfw.g(this.thisObjLocal);
            this.cfw.g(this.argsLocal);
            this.cfw.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, this.codegen.mainClassName, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            for (int i4 = 0; i4 != i3; i4++) {
                generateExpression(node2, node);
                node2 = node2.getNext();
            }
            addNewObjectArray(i3);
            while (i2 != i3) {
                this.cfw.c(90);
                this.cfw.c(95);
                this.cfw.t((i3 - i2) - 1);
                this.cfw.c(95);
                this.cfw.c(83);
                i2++;
            }
        } else {
            addNewObjectArray(i3);
            while (i2 != i3) {
                this.cfw.c(89);
                this.cfw.t(i2);
                generateExpression(node2, node);
                this.cfw.c(83);
                node2 = node2.getNext();
                i2++;
            }
        }
        int[] iArr = (int[]) node.getProp(11);
        if (iArr == null) {
            this.cfw.c(1);
            this.cfw.c(3);
        } else {
            this.cfw.u(OptRuntime.encodeIntArray(iArr));
            this.cfw.t(iArr.length);
        }
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        addOptRuntimeInvoke("newArrayLiteral", "([Ljava/lang/Object;Ljava/lang/String;ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitBitOp(Node node, int i2, Node node2) {
        int intProp = node.getIntProp(8, -1);
        generateExpression(node2, node);
        if (i2 == 20) {
            addScriptRuntimeInvoke("toUint32", "(Ljava/lang/Object;)J");
            generateExpression(node2.getNext(), node);
            addScriptRuntimeInvoke("toInt32", "(Ljava/lang/Object;)I");
            this.cfw.t(31);
            this.cfw.c(126);
            this.cfw.c(Token.CATCH);
            this.cfw.c(Token.TYPEOFNAME);
            addDoubleWrap();
            return;
        }
        if (intProp == -1) {
            addScriptRuntimeInvoke("toInt32", "(Ljava/lang/Object;)I");
            generateExpression(node2.getNext(), node);
            addScriptRuntimeInvoke("toInt32", "(Ljava/lang/Object;)I");
        } else {
            addScriptRuntimeInvoke("toInt32", "(D)I");
            generateExpression(node2.getNext(), node);
            addScriptRuntimeInvoke("toInt32", "(D)I");
        }
        if (i2 == 18) {
            this.cfw.c(120);
        } else if (i2 != 19) {
            switch (i2) {
                case 9:
                    this.cfw.c(128);
                    break;
                case 10:
                    this.cfw.c(130);
                    break;
                case 11:
                    this.cfw.c(126);
                    break;
                default:
                    throw Codegen.badTree();
            }
        } else {
            this.cfw.c(122);
        }
        this.cfw.c(Token.EXPR_RESULT);
        if (intProp == -1) {
            addDoubleWrap();
        }
    }

    private void visitDotQuery(Node node, Node node2) {
        updateLineNumber(node);
        generateExpression(node2, node);
        this.cfw.g(this.variableObjectLocal);
        addScriptRuntimeInvoke("enterDotQuery", "(Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.h(this.variableObjectLocal);
        this.cfw.c(1);
        int iB = this.cfw.b();
        this.cfw.H(iB);
        this.cfw.c(87);
        generateExpression(node2.getNext(), node);
        addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
        this.cfw.g(this.variableObjectLocal);
        addScriptRuntimeInvoke("updateDotQuery", "(ZLorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        this.cfw.c(89);
        this.cfw.d(198, iB);
        this.cfw.g(this.variableObjectLocal);
        addScriptRuntimeInvoke("leaveDotQuery", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.h(this.variableObjectLocal);
    }

    private void visitFunction(OptFunctionNode optFunctionNode, int i2) {
        int index = this.codegen.getIndex(optFunctionNode.fnode);
        this.cfw.e(187, this.codegen.mainClassName);
        this.cfw.c(89);
        this.cfw.g(this.variableObjectLocal);
        this.cfw.g(this.contextLocal);
        this.cfw.t(index);
        this.cfw.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, this.codegen.mainClassName, "<init>", Codegen.FUNCTION_CONSTRUCTOR_SIGNATURE);
        if (i2 == 4) {
            this.cfw.g(this.contextLocal);
            this.cfw.g(this.variableObjectLocal);
            this.cfw.g(this.thisObjLocal);
            addOptRuntimeInvoke("bindThis", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Function;");
        }
        if (i2 == 2 || i2 == 4) {
            return;
        }
        this.cfw.t(i2);
        this.cfw.g(this.variableObjectLocal);
        this.cfw.g(this.contextLocal);
        addOptRuntimeInvoke("initFunction", "(Lorg/mozilla/javascript/NativeFunction;ILorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;)V");
    }

    private void visitGetProp(Node node, Node node2) {
        generateExpression(node2, node);
        Node next = node2.getNext();
        generateExpression(next, node);
        if (node.getType() == 34) {
            this.cfw.g(this.contextLocal);
            this.cfw.g(this.variableObjectLocal);
            addScriptRuntimeInvoke("getObjectPropNoWarn", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        } else if (node2.getType() == 43 && next.getType() == 41) {
            this.cfw.g(this.contextLocal);
            addScriptRuntimeInvoke("getObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
        } else {
            this.cfw.g(this.contextLocal);
            this.cfw.g(this.variableObjectLocal);
            addScriptRuntimeInvoke("getObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        }
    }

    private void visitGetVar(Node node) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        short s = this.varRegisters[varIndex];
        if (varIsDirectCallParameter(varIndex)) {
            if (node.getIntProp(8, -1) != -1) {
                dcpLoadAsNumber(s);
                return;
            } else {
                dcpLoadAsObject(s);
                return;
            }
        }
        if (this.fnCurrent.isNumberVar(varIndex)) {
            this.cfw.i(s);
        } else {
            this.cfw.g(s);
        }
    }

    private void visitGoto(Jump jump, int i2, Node node) {
        Node node2 = jump.target;
        if (i2 != 6 && i2 != 7) {
            if (i2 != 136) {
                addGoto(node2, Token.LAST_TOKEN);
                return;
            } else if (this.isGenerator) {
                addGotoWithReturn(node2);
                return;
            } else {
                inlineFinally(node2);
                return;
            }
        }
        if (node == null) {
            throw Codegen.badTree();
        }
        int targetLabel = getTargetLabel(node2);
        int iB = this.cfw.b();
        if (i2 == 6) {
            generateIfJump(node, jump, targetLabel, iB);
        } else {
            generateIfJump(node, jump, iB, targetLabel);
        }
        this.cfw.H(iB);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void visitIfJumpEqOp(org.mozilla.javascript.Node r18, org.mozilla.javascript.Node r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.BodyCodegen.visitIfJumpEqOp(org.mozilla.javascript.Node, org.mozilla.javascript.Node, int, int):void");
    }

    private void visitIfJumpRelOp(Node node, Node node2, int i2, int i3) {
        if (i2 == -1 || i3 == -1) {
            throw Codegen.badTree();
        }
        int type = node.getType();
        Node next = node2.getNext();
        if (type == 53 || type == 52) {
            generateExpression(node2, node);
            generateExpression(next, node);
            this.cfw.g(this.contextLocal);
            addScriptRuntimeInvoke(type == 53 ? "instanceOf" : "in", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Z");
            this.cfw.d(154, i2);
            this.cfw.d(Token.LAST_TOKEN, i3);
            return;
        }
        int intProp = node.getIntProp(8, -1);
        int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
        int iNodeIsDirectCallParameter2 = nodeIsDirectCallParameter(next);
        if (intProp != -1) {
            if (intProp != 2) {
                generateExpression(node2, node);
            } else if (iNodeIsDirectCallParameter != -1) {
                dcpLoadAsNumber(iNodeIsDirectCallParameter);
            } else {
                generateExpression(node2, node);
                addObjectToDouble();
            }
            if (intProp != 1) {
                generateExpression(next, node);
            } else if (iNodeIsDirectCallParameter2 != -1) {
                dcpLoadAsNumber(iNodeIsDirectCallParameter2);
            } else {
                generateExpression(next, node);
                addObjectToDouble();
            }
            genSimpleCompare(type, i2, i3);
            return;
        }
        if (iNodeIsDirectCallParameter == -1 || iNodeIsDirectCallParameter2 == -1) {
            generateExpression(node2, node);
            generateExpression(next, node);
        } else {
            c cVar = this.cfw;
            short s = cVar.p;
            int iB = cVar.b();
            this.cfw.g(iNodeIsDirectCallParameter);
            this.cfw.f(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
            this.cfw.d(166, iB);
            this.cfw.i(iNodeIsDirectCallParameter + 1);
            dcpLoadAsNumber(iNodeIsDirectCallParameter2);
            genSimpleCompare(type, i2, i3);
            c cVar2 = this.cfw;
            if (s != cVar2.p) {
                throw Codegen.badTree();
            }
            cVar2.H(iB);
            int iB2 = this.cfw.b();
            this.cfw.g(iNodeIsDirectCallParameter2);
            this.cfw.f(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
            this.cfw.d(166, iB2);
            this.cfw.g(iNodeIsDirectCallParameter);
            addObjectToDouble();
            this.cfw.i(iNodeIsDirectCallParameter2 + 1);
            genSimpleCompare(type, i2, i3);
            c cVar3 = this.cfw;
            if (s != cVar3.p) {
                throw Codegen.badTree();
            }
            cVar3.H(iB2);
            this.cfw.g(iNodeIsDirectCallParameter);
            this.cfw.g(iNodeIsDirectCallParameter2);
        }
        if (type == 17 || type == 16) {
            this.cfw.c(95);
        }
        addScriptRuntimeInvoke((type == 14 || type == 16) ? "cmp_LT" : "cmp_LE", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
        this.cfw.d(154, i2);
        this.cfw.d(Token.LAST_TOKEN, i3);
    }

    private void visitIncDec(Node node) {
        int existingIntProp = node.getExistingIntProp(13);
        Node firstChild = node.getFirstChild();
        int type = firstChild.getType();
        if (type == 33) {
            Node firstChild2 = firstChild.getFirstChild();
            generateExpression(firstChild2, node);
            generateExpression(firstChild2.getNext(), node);
            this.cfw.g(this.contextLocal);
            this.cfw.g(this.variableObjectLocal);
            this.cfw.t(existingIntProp);
            addScriptRuntimeInvoke("propIncrDecr", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
            return;
        }
        if (type == 34) {
            throw Kit.codeBug();
        }
        if (type == 36) {
            Node firstChild3 = firstChild.getFirstChild();
            generateExpression(firstChild3, node);
            generateExpression(firstChild3.getNext(), node);
            this.cfw.g(this.contextLocal);
            this.cfw.g(this.variableObjectLocal);
            this.cfw.t(existingIntProp);
            if (firstChild3.getNext().getIntProp(8, -1) != -1) {
                addOptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                return;
            } else {
                addScriptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                return;
            }
        }
        if (type == 39) {
            this.cfw.g(this.variableObjectLocal);
            this.cfw.u(firstChild.getString());
            this.cfw.g(this.contextLocal);
            this.cfw.t(existingIntProp);
            addScriptRuntimeInvoke("nameIncrDecr", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;");
            return;
        }
        if (type != 55) {
            if (type != 68) {
                Codegen.badTree();
                return;
            }
            generateExpression(firstChild.getFirstChild(), node);
            this.cfw.g(this.contextLocal);
            this.cfw.g(this.variableObjectLocal);
            this.cfw.t(existingIntProp);
            addScriptRuntimeInvoke("refIncrDecr", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
            return;
        }
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        boolean z = (existingIntProp & 2) != 0;
        int varIndex = this.fnCurrent.getVarIndex(firstChild);
        short s = this.varRegisters[varIndex];
        if (this.fnCurrent.fnode.getParamAndVarConst()[varIndex]) {
            if (node.getIntProp(8, -1) != -1) {
                this.cfw.i(s + (varIsDirectCallParameter(varIndex) ? 1 : 0));
                if (z) {
                    return;
                }
                this.cfw.s(1.0d);
                if ((existingIntProp & 1) == 0) {
                    this.cfw.c(99);
                    return;
                } else {
                    this.cfw.c(103);
                    return;
                }
            }
            if (varIsDirectCallParameter(varIndex)) {
                dcpLoadAsObject(s);
            } else {
                this.cfw.g(s);
            }
            if (z) {
                this.cfw.c(89);
                addObjectToDouble();
                this.cfw.c(88);
                return;
            } else {
                addObjectToDouble();
                this.cfw.s(1.0d);
                if ((existingIntProp & 1) == 0) {
                    this.cfw.c(99);
                } else {
                    this.cfw.c(103);
                }
                addDoubleWrap();
                return;
            }
        }
        if (node.getIntProp(8, -1) != -1) {
            boolean zVarIsDirectCallParameter = varIsDirectCallParameter(varIndex);
            c cVar = this.cfw;
            int i2 = s + (zVarIsDirectCallParameter ? 1 : 0);
            cVar.i(i2);
            if (z) {
                this.cfw.c(92);
            }
            this.cfw.s(1.0d);
            if ((existingIntProp & 1) == 0) {
                this.cfw.c(99);
            } else {
                this.cfw.c(103);
            }
            if (!z) {
                this.cfw.c(92);
            }
            this.cfw.j(i2);
            return;
        }
        if (varIsDirectCallParameter(varIndex)) {
            dcpLoadAsObject(s);
        } else {
            this.cfw.g(s);
        }
        addObjectToDouble();
        if (z) {
            this.cfw.c(92);
        }
        this.cfw.s(1.0d);
        if ((existingIntProp & 1) == 0) {
            this.cfw.c(99);
        } else {
            this.cfw.c(103);
        }
        addDoubleWrap();
        if (!z) {
            this.cfw.c(89);
        }
        this.cfw.h(s);
        if (z) {
            addDoubleWrap();
        }
    }

    private void visitObjectLiteral(Node node, Node node2, boolean z) {
        boolean z2;
        Object[] objArr = (Object[]) node.getProp(12);
        int length = objArr.length;
        if (!z && ((length > 10 || this.cfw.m > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new LinkedList();
            }
            this.literals.add(node);
            String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.g(this.funObjLocal);
            this.cfw.g(this.contextLocal);
            this.cfw.g(this.variableObjectLocal);
            this.cfw.g(this.thisObjLocal);
            this.cfw.g(this.argsLocal);
            this.cfw.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, this.codegen.mainClassName, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            addLoadPropertyValues(node, node2, length);
            addLoadPropertyIds(objArr, length);
            this.cfw.c(95);
        } else {
            addLoadPropertyIds(objArr, length);
            addLoadPropertyValues(node, node2, length);
        }
        Node next = node2;
        for (int i2 = 0; i2 != length; i2++) {
            int type = next.getType();
            if (type == 152 || type == 153) {
                z2 = true;
                break;
            }
            next = next.getNext();
        }
        z2 = false;
        if (z2) {
            this.cfw.t(length);
            this.cfw.d(188, 10);
            for (int i3 = 0; i3 != length; i3++) {
                this.cfw.c(89);
                this.cfw.t(i3);
                int type2 = node2.getType();
                if (type2 == 152) {
                    this.cfw.c(2);
                } else if (type2 == 153) {
                    this.cfw.c(4);
                } else {
                    this.cfw.c(3);
                }
                this.cfw.c(79);
                node2 = node2.getNext();
            }
        } else {
            this.cfw.c(1);
        }
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        addScriptRuntimeInvoke("newObjectLiteral", "([Ljava/lang/Object;[Ljava/lang/Object;[ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitOptimizedCall(Node node, OptFunctionNode optFunctionNode, int i2, Node node2) {
        short newWordLocal;
        Node next = node2.getNext();
        String str = this.codegen.mainClassName;
        if (i2 == 30) {
            generateExpression(node2, node);
            newWordLocal = 0;
        } else {
            generateFunctionAndThisObj(node2, node);
            newWordLocal = getNewWordLocal();
            this.cfw.h(newWordLocal);
        }
        int iB = this.cfw.b();
        int iB2 = this.cfw.b();
        this.cfw.c(89);
        this.cfw.e(193, str);
        this.cfw.d(153, iB2);
        this.cfw.e(192, str);
        this.cfw.c(89);
        this.cfw.f(180, str, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
        this.cfw.t(this.codegen.getIndex(optFunctionNode.fnode));
        this.cfw.d(160, iB2);
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        if (i2 == 30) {
            this.cfw.c(1);
        } else {
            this.cfw.g(newWordLocal);
        }
        for (Node next2 = next; next2 != null; next2 = next2.getNext()) {
            int iNodeIsDirectCallParameter = nodeIsDirectCallParameter(next2);
            if (iNodeIsDirectCallParameter >= 0) {
                this.cfw.g(iNodeIsDirectCallParameter);
                this.cfw.i(iNodeIsDirectCallParameter + 1);
            } else if (next2.getIntProp(8, -1) == 0) {
                this.cfw.f(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                generateExpression(next2, node);
            } else {
                generateExpression(next2, node);
                this.cfw.s(0.0d);
            }
        }
        this.cfw.f(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        c cVar = this.cfw;
        Codegen codegen = this.codegen;
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, codegen.mainClassName, i2 == 30 ? codegen.getDirectCtorName(optFunctionNode.fnode) : codegen.getBodyMethodName(optFunctionNode.fnode), this.codegen.getBodyMethodSignature(optFunctionNode.fnode));
        this.cfw.d(Token.LAST_TOKEN, iB);
        this.cfw.H(iB2);
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        if (i2 != 30) {
            this.cfw.g(newWordLocal);
            releaseWordLocal(newWordLocal);
        }
        generateCallArgArray(node, next, true);
        if (i2 == 30) {
            addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        } else {
            this.cfw.o(185, "org/mozilla/javascript/Callable", NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        }
        this.cfw.H(iB);
    }

    private void visitSetConst(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.g(this.contextLocal);
        this.cfw.u(string);
        addScriptRuntimeInvoke("setConst", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSetConstVar(Node node, Node node2, boolean z) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        short s = this.varRegisters[varIndex];
        int iB = this.cfw.b();
        int iB2 = this.cfw.b();
        if (z2) {
            int i2 = s + 2;
            this.cfw.m(i2);
            this.cfw.d(154, iB2);
            c cVar = this.cfw;
            short s2 = cVar.p;
            cVar.t(1);
            this.cfw.n(i2);
            this.cfw.j(s);
            if (z) {
                this.cfw.i(s);
                c cVar2 = this.cfw;
                cVar2.H(iB2);
                cVar2.p = s2;
            } else {
                this.cfw.d(Token.LAST_TOKEN, iB);
                c cVar3 = this.cfw;
                cVar3.H(iB2);
                cVar3.p = s2;
                this.cfw.c(88);
            }
        } else {
            int i3 = s + 1;
            this.cfw.m(i3);
            this.cfw.d(154, iB2);
            c cVar4 = this.cfw;
            short s3 = cVar4.p;
            cVar4.t(1);
            this.cfw.n(i3);
            this.cfw.h(s);
            if (z) {
                this.cfw.g(s);
                c cVar5 = this.cfw;
                cVar5.H(iB2);
                cVar5.p = s3;
            } else {
                this.cfw.d(Token.LAST_TOKEN, iB);
                c cVar6 = this.cfw;
                cVar6.H(iB2);
                cVar6.p = s3;
                this.cfw.c(87);
            }
        }
        this.cfw.H(iB);
    }

    private void visitSetElem(int i2, Node node, Node node2) {
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i2 == 141) {
            this.cfw.c(89);
        }
        generateExpression(next, node);
        Node next2 = next.getNext();
        boolean z = node.getIntProp(8, -1) != -1;
        if (i2 == 141) {
            if (z) {
                this.cfw.c(93);
                this.cfw.g(this.contextLocal);
                this.cfw.g(this.variableObjectLocal);
                addScriptRuntimeInvoke("getObjectIndex", "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
            } else {
                this.cfw.c(90);
                this.cfw.g(this.contextLocal);
                this.cfw.g(this.variableObjectLocal);
                addScriptRuntimeInvoke("getObjectElem", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
            }
        }
        generateExpression(next2, node);
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        if (z) {
            addScriptRuntimeInvoke("setObjectIndex", "(Ljava/lang/Object;DLjava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        } else {
            addScriptRuntimeInvoke("setObjectElem", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        }
    }

    private void visitSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        this.cfw.u(string);
        addScriptRuntimeInvoke("setName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSetProp(int i2, Node node, Node node2) {
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i2 == 140) {
            this.cfw.c(89);
        }
        generateExpression(next, node);
        Node next2 = next.getNext();
        if (i2 == 140) {
            this.cfw.c(90);
            if (node2.getType() == 43 && next.getType() == 41) {
                this.cfw.g(this.contextLocal);
                addScriptRuntimeInvoke("getObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
            } else {
                this.cfw.g(this.contextLocal);
                this.cfw.g(this.variableObjectLocal);
                addScriptRuntimeInvoke("getObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
            }
        }
        generateExpression(next2, node);
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        addScriptRuntimeInvoke("setObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
    }

    private void visitSetVar(Node node, Node node2, boolean z) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        short s = this.varRegisters[varIndex];
        if (this.fnCurrent.fnode.getParamAndVarConst()[varIndex]) {
            if (z) {
                return;
            }
            if (z2) {
                this.cfw.c(88);
                return;
            } else {
                this.cfw.c(87);
                return;
            }
        }
        if (!varIsDirectCallParameter(varIndex)) {
            boolean zIsNumberVar = this.fnCurrent.isNumberVar(varIndex);
            if (!z2) {
                if (zIsNumberVar) {
                    Kit.codeBug();
                }
                this.cfw.h(s);
                if (z) {
                    this.cfw.g(s);
                    return;
                }
                return;
            }
            if (zIsNumberVar) {
                this.cfw.j(s);
                if (z) {
                    this.cfw.i(s);
                    return;
                }
                return;
            }
            if (z) {
                this.cfw.c(92);
            }
            addDoubleWrap();
            this.cfw.h(s);
            return;
        }
        if (!z2) {
            if (z) {
                this.cfw.c(89);
            }
            this.cfw.h(s);
            return;
        }
        if (z) {
            this.cfw.c(92);
        }
        this.cfw.g(s);
        this.cfw.f(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        int iB = this.cfw.b();
        int iB2 = this.cfw.b();
        this.cfw.d(Token.ARROW, iB);
        short s2 = this.cfw.p;
        addDoubleWrap();
        this.cfw.h(s);
        this.cfw.d(Token.LAST_TOKEN, iB2);
        c cVar = this.cfw;
        cVar.H(iB);
        cVar.p = s2;
        this.cfw.j(s + 1);
        this.cfw.H(iB2);
    }

    private void visitSpecialCall(Node node, int i2, int i3, Node node2) {
        String str;
        String str2;
        this.cfw.g(this.contextLocal);
        if (i2 == 30) {
            generateExpression(node2, node);
        } else {
            generateFunctionAndThisObj(node2, node);
        }
        generateCallArgArray(node, node2.getNext(), false);
        if (i2 == 30) {
            this.cfw.g(this.variableObjectLocal);
            this.cfw.g(this.thisObjLocal);
            this.cfw.t(i3);
            str = "newObjectSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Ljava/lang/Object;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
        } else {
            this.cfw.g(this.variableObjectLocal);
            this.cfw.g(this.thisObjLocal);
            this.cfw.t(i3);
            String sourceName = this.scriptOrFn.getSourceName();
            c cVar = this.cfw;
            if (sourceName == null) {
                sourceName = "";
            }
            cVar.u(sourceName);
            this.cfw.t(this.itsLineNumber);
            str = "callSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;ILjava/lang/String;I)Ljava/lang/Object;";
        }
        addOptRuntimeInvoke(str, str2);
    }

    private void visitStandardCall(Node node, Node node2) {
        String str;
        String str2;
        if (node.getType() != 38) {
            throw Codegen.badTree();
        }
        Node next = node2.getNext();
        int type = node2.getType();
        if (next == null) {
            if (type == 39) {
                this.cfw.u(node2.getString());
                str = "callName0";
                str2 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else if (type == 33) {
                Node firstChild = node2.getFirstChild();
                generateExpression(firstChild, node);
                this.cfw.u(firstChild.getNext().getString());
                str = "callProp0";
                str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                if (type == 34) {
                    throw Kit.codeBug();
                }
                generateFunctionAndThisObj(node2, node);
                str = "call0";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
        } else if (type == 39) {
            String string = node2.getString();
            generateCallArgArray(node, next, false);
            this.cfw.u(string);
            str = "callName";
            str2 = "([Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        } else {
            int i2 = 0;
            for (Node next2 = next; next2 != null; next2 = next2.getNext()) {
                i2++;
            }
            generateFunctionAndThisObj(node2, node);
            if (i2 == 1) {
                generateExpression(next, node);
                str = "call1";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else if (i2 == 2) {
                generateExpression(next, node);
                generateExpression(next.getNext(), node);
                str = "call2";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                generateCallArgArray(node, next, false);
                str = "callN";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
        }
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        addOptRuntimeInvoke(str, str2);
    }

    private void visitStandardNew(Node node, Node node2) {
        if (node.getType() != 30) {
            throw Codegen.badTree();
        }
        Node next = node2.getNext();
        generateExpression(node2, node);
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        generateCallArgArray(node, next, false);
        addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitStrictSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.g(this.contextLocal);
        this.cfw.g(this.variableObjectLocal);
        this.cfw.u(string);
        addScriptRuntimeInvoke("strictSetName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSwitch(Jump jump, Node node) {
        generateExpression(node, jump);
        short newWordLocal = getNewWordLocal();
        this.cfw.h(newWordLocal);
        for (Jump jump2 = (Jump) node.getNext(); jump2 != null; jump2 = (Jump) jump2.getNext()) {
            if (jump2.getType() != 116) {
                throw Codegen.badTree();
            }
            generateExpression(jump2.getFirstChild(), jump2);
            this.cfw.g(newWordLocal);
            addScriptRuntimeInvoke("shallowEq", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
            addGoto(jump2.target, 154);
        }
        releaseWordLocal(newWordLocal);
    }

    private void visitTryCatchFinally(Jump jump, Node node) {
        int i2;
        int i3;
        short newWordLocal = getNewWordLocal();
        this.cfw.g(this.variableObjectLocal);
        this.cfw.h(newWordLocal);
        int iB = this.cfw.b();
        c cVar = this.cfw;
        cVar.H(iB);
        cVar.p = (short) 0;
        Node node2 = jump.target;
        Node node3 = jump.getFinally();
        int[] iArr = new int[5];
        this.exceptionManager.pushExceptionInfo(jump);
        if (node2 != null) {
            iArr[0] = this.cfw.b();
            iArr[1] = this.cfw.b();
            iArr[2] = this.cfw.b();
            Context currentContext = Context.getCurrentContext();
            if (currentContext != null && currentContext.hasFeature(13)) {
                iArr[3] = this.cfw.b();
            }
        }
        if (node3 != null) {
            iArr[4] = this.cfw.b();
        }
        this.exceptionManager.setHandlers(iArr, iB);
        if (this.isGenerator && node3 != null) {
            FinallyReturnPoint finallyReturnPoint = new FinallyReturnPoint();
            if (this.finallys == null) {
                this.finallys = new HashMap();
            }
            this.finallys.put(node3, finallyReturnPoint);
            this.finallys.put(node3.getNext(), finallyReturnPoint);
        }
        for (Node next = node; next != null; next = next.getNext()) {
            if (next == node2) {
                int targetLabel = getTargetLabel(node2);
                this.exceptionManager.removeHandler(0, targetLabel);
                this.exceptionManager.removeHandler(1, targetLabel);
                this.exceptionManager.removeHandler(2, targetLabel);
                this.exceptionManager.removeHandler(3, targetLabel);
            }
            generateStatement(next);
        }
        int iB2 = this.cfw.b();
        this.cfw.d(Token.LAST_TOKEN, iB2);
        int localBlockRegister = getLocalBlockRegister(jump);
        if (node2 != null) {
            int iLabelId = node2.labelId();
            i2 = localBlockRegister;
            i3 = iB2;
            generateCatchBlock(0, newWordLocal, iLabelId, localBlockRegister, iArr[0]);
            generateCatchBlock(1, newWordLocal, iLabelId, localBlockRegister, iArr[1]);
            generateCatchBlock(2, newWordLocal, iLabelId, localBlockRegister, iArr[2]);
            Context currentContext2 = Context.getCurrentContext();
            if (currentContext2 != null && currentContext2.hasFeature(13)) {
                generateCatchBlock(3, newWordLocal, iLabelId, i2, iArr[3]);
            }
        } else {
            i2 = localBlockRegister;
            i3 = iB2;
        }
        if (node3 != null) {
            int iB3 = this.cfw.b();
            int iB4 = this.cfw.b();
            this.cfw.G(iB3);
            if (!this.isGenerator) {
                this.cfw.H(iArr[4]);
            }
            int i4 = i2;
            this.cfw.h(i4);
            this.cfw.g(newWordLocal);
            this.cfw.h(this.variableObjectLocal);
            int iLabelId2 = node3.labelId();
            if (this.isGenerator) {
                addGotoWithReturn(node3);
            } else {
                inlineFinally(node3, iArr[4], iB4);
            }
            this.cfw.g(i4);
            if (this.isGenerator) {
                this.cfw.e(192, "java/lang/Throwable");
            }
            this.cfw.c(191);
            this.cfw.H(iB4);
            if (this.isGenerator) {
                this.cfw.k(iB, iLabelId2, iB3, null);
            }
        }
        releaseWordLocal(newWordLocal);
        this.cfw.H(i3);
        if (this.isGenerator) {
            return;
        }
        this.exceptionManager.popExceptionInfo();
    }

    private void visitTypeofname(Node node) {
        int indexForNameNode;
        if (!this.hasVarsInRegs || (indexForNameNode = this.fnCurrent.fnode.getIndexForNameNode(node)) < 0) {
            this.cfw.g(this.variableObjectLocal);
            this.cfw.u(node.getString());
            addScriptRuntimeInvoke("typeofName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/String;");
            return;
        }
        if (this.fnCurrent.isNumberVar(indexForNameNode)) {
            this.cfw.u("number");
            return;
        }
        if (!varIsDirectCallParameter(indexForNameNode)) {
            this.cfw.g(this.varRegisters[indexForNameNode]);
            addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
            return;
        }
        short s = this.varRegisters[indexForNameNode];
        this.cfw.g(s);
        this.cfw.f(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        int iB = this.cfw.b();
        this.cfw.d(Token.ARROW, iB);
        c cVar = this.cfw;
        short s2 = cVar.p;
        cVar.g(s);
        addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
        int iB2 = this.cfw.b();
        this.cfw.d(Token.LAST_TOKEN, iB2);
        c cVar2 = this.cfw;
        cVar2.H(iB);
        cVar2.p = s2;
        this.cfw.u("number");
        this.cfw.H(iB2);
    }

    public void generateBodyCode() {
        this.isGenerator = Codegen.isGenerator(this.scriptOrFn);
        initBodyGeneration();
        if (this.isGenerator) {
            String strP = a.p(a.r("("), this.codegen.mainClassSignature, "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
            this.cfw.Q(this.codegen.getBodyMethodName(this.scriptOrFn) + "_gen", strP, (short) 10);
        } else {
            this.cfw.Q(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        }
        generatePrologue();
        generateStatement(this.fnCurrent != null ? this.scriptOrFn.getLastChild() : this.scriptOrFn);
        generateEpilogue();
        this.cfw.R((short) (this.localsMax + 1));
        if (this.isGenerator) {
            generateGenerator();
        }
        if (this.literals != null) {
            for (int i2 = 0; i2 < this.literals.size(); i2++) {
                Node node = this.literals.get(i2);
                int type = node.getType();
                if (type == 66) {
                    generateArrayLiteralFactory(node, i2 + 1);
                } else if (type != 67) {
                    Kit.codeBug(Token.typeToName(type));
                } else {
                    generateObjectLiteralFactory(node, i2 + 1);
                }
            }
        }
    }

    private short getNewWordLocal() {
        return getNewWordIntern(1);
    }

    private void addInstructionCount(int i2) {
        this.cfw.g(this.contextLocal);
        this.cfw.t(i2);
        addScriptRuntimeInvoke("addInstructionCount", "(Lorg/mozilla/javascript/Context;I)V");
    }

    private void inlineFinally(Node node) {
        int iB = this.cfw.b();
        int iB2 = this.cfw.b();
        this.cfw.H(iB);
        inlineFinally(node, iB, iB2);
        this.cfw.H(iB2);
    }
}
