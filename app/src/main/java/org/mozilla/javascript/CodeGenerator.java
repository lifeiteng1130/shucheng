package org.mozilla.javascript;

import androidx.core.view.InputDeviceCompat;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.Block;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.ast.VariableInitializer;

/* JADX INFO: loaded from: classes3.dex */
public class CodeGenerator extends Icode {
    private static final int ECF_TAIL = 1;
    private static final int MIN_FIXUP_TABLE_SIZE = 40;
    private static final int MIN_LABEL_TABLE_SIZE = 32;
    private CompilerEnvirons compilerEnv;
    private int doubleTableTop;
    private int exceptionTableTop;
    private long[] fixupTable;
    private int fixupTableTop;
    private int iCodeTop;
    private InterpreterData itsData;
    private boolean itsInFunctionFlag;
    private boolean itsInTryFlag;
    private int[] labelTable;
    private int labelTableTop;
    private int lineNumber;
    private int localTop;
    private ScriptNode scriptOrFn;
    private int stackDepth;
    private ObjToIntMap strings = new ObjToIntMap(20);
    private ObjArray literalIds = new ObjArray();

    private void addBackwardGoto(int i2, int i3) {
        int i4 = this.iCodeTop;
        if (i4 <= i3) {
            throw Kit.codeBug();
        }
        addGotoOp(i2);
        resolveGoto(i4, i3);
    }

    private void addExceptionHandler(int i2, int i3, int i4, boolean z, int i5, int i6) {
        int i7 = this.exceptionTableTop;
        int[] iArr = this.itsData.itsExceptionTable;
        if (iArr == null) {
            if (i7 != 0) {
                Kit.codeBug();
            }
            iArr = new int[12];
            this.itsData.itsExceptionTable = iArr;
        } else if (iArr.length == i7) {
            int[] iArr2 = new int[iArr.length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i7);
            this.itsData.itsExceptionTable = iArr2;
            iArr = iArr2;
        }
        iArr[i7 + 0] = i2;
        iArr[i7 + 1] = i3;
        iArr[i7 + 2] = i4;
        iArr[i7 + 3] = z ? 1 : 0;
        iArr[i7 + 4] = i5;
        iArr[i7 + 5] = i6;
        this.exceptionTableTop = i7 + 6;
    }

    private void addGoto(Node node, int i2) {
        int targetLabel = getTargetLabel(node);
        if (targetLabel >= this.labelTableTop) {
            Kit.codeBug();
        }
        int i3 = this.labelTable[targetLabel];
        if (i3 != -1) {
            addBackwardGoto(i2, i3);
            return;
        }
        int i4 = this.iCodeTop;
        addGotoOp(i2);
        int i5 = this.fixupTableTop;
        long[] jArr = this.fixupTable;
        if (jArr == null || i5 == jArr.length) {
            if (jArr == null) {
                this.fixupTable = new long[40];
            } else {
                long[] jArr2 = new long[jArr.length * 2];
                System.arraycopy(jArr, 0, jArr2, 0, i5);
                this.fixupTable = jArr2;
            }
        }
        this.fixupTableTop = i5 + 1;
        this.fixupTable[i5] = (((long) targetLabel) << 32) | ((long) i4);
    }

    private void addGotoOp(int i2) {
        byte[] bArrIncreaseICodeCapacity = this.itsData.itsICode;
        int i3 = this.iCodeTop;
        if (i3 + 3 > bArrIncreaseICodeCapacity.length) {
            bArrIncreaseICodeCapacity = increaseICodeCapacity(3);
        }
        bArrIncreaseICodeCapacity[i3] = (byte) i2;
        this.iCodeTop = i3 + 1 + 2;
    }

    private void addIcode(int i2) {
        if (!Icode.validIcode(i2)) {
            throw Kit.codeBug();
        }
        addUint8(i2 & 255);
    }

    private void addIndexOp(int i2, int i3) {
        addIndexPrefix(i3);
        if (Icode.validIcode(i2)) {
            addIcode(i2);
        } else {
            addToken(i2);
        }
    }

    private void addIndexPrefix(int i2) {
        if (i2 < 0) {
            Kit.codeBug();
        }
        if (i2 < 6) {
            addIcode((-32) - i2);
            return;
        }
        if (i2 <= 255) {
            addIcode(-38);
            addUint8(i2);
        } else if (i2 <= 65535) {
            addIcode(-39);
            addUint16(i2);
        } else {
            addIcode(-40);
            addInt(i2);
        }
    }

    private void addInt(int i2) {
        byte[] bArrIncreaseICodeCapacity = this.itsData.itsICode;
        int i3 = this.iCodeTop;
        int i4 = i3 + 4;
        if (i4 > bArrIncreaseICodeCapacity.length) {
            bArrIncreaseICodeCapacity = increaseICodeCapacity(4);
        }
        bArrIncreaseICodeCapacity[i3] = (byte) (i2 >>> 24);
        bArrIncreaseICodeCapacity[i3 + 1] = (byte) (i2 >>> 16);
        bArrIncreaseICodeCapacity[i3 + 2] = (byte) (i2 >>> 8);
        bArrIncreaseICodeCapacity[i3 + 3] = (byte) i2;
        this.iCodeTop = i4;
    }

    private void addStringOp(int i2, String str) {
        addStringPrefix(str);
        if (Icode.validIcode(i2)) {
            addIcode(i2);
        } else {
            addToken(i2);
        }
    }

    private void addStringPrefix(String str) {
        int size = this.strings.get(str, -1);
        if (size == -1) {
            size = this.strings.size();
            this.strings.put(str, size);
        }
        if (size < 4) {
            addIcode((-41) - size);
            return;
        }
        if (size <= 255) {
            addIcode(-45);
            addUint8(size);
        } else if (size <= 65535) {
            addIcode(-46);
            addUint16(size);
        } else {
            addIcode(-47);
            addInt(size);
        }
    }

    private void addToken(int i2) {
        if (!Icode.validTokenCode(i2)) {
            throw Kit.codeBug();
        }
        addUint8(i2);
    }

    private void addUint16(int i2) {
        if (((-65536) & i2) != 0) {
            throw Kit.codeBug();
        }
        byte[] bArrIncreaseICodeCapacity = this.itsData.itsICode;
        int i3 = this.iCodeTop;
        int i4 = i3 + 2;
        if (i4 > bArrIncreaseICodeCapacity.length) {
            bArrIncreaseICodeCapacity = increaseICodeCapacity(2);
        }
        bArrIncreaseICodeCapacity[i3] = (byte) (i2 >>> 8);
        bArrIncreaseICodeCapacity[i3 + 1] = (byte) i2;
        this.iCodeTop = i4;
    }

    private void addUint8(int i2) {
        if ((i2 & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw Kit.codeBug();
        }
        byte[] bArrIncreaseICodeCapacity = this.itsData.itsICode;
        int i3 = this.iCodeTop;
        if (i3 == bArrIncreaseICodeCapacity.length) {
            bArrIncreaseICodeCapacity = increaseICodeCapacity(1);
        }
        bArrIncreaseICodeCapacity[i3] = (byte) i2;
        this.iCodeTop = i3 + 1;
    }

    private void addVarOp(int i2, int i3) {
        if (i2 != -7) {
            if (i2 == 157) {
                if (i3 >= 128) {
                    addIndexOp(-60, i3);
                    return;
                } else {
                    addIcode(-61);
                    addUint8(i3);
                    return;
                }
            }
            if (i2 != 55 && i2 != 56) {
                throw Kit.codeBug();
            }
            if (i3 < 128) {
                addIcode(i2 == 55 ? -48 : -49);
                addUint8(i3);
                return;
            }
        }
        addIndexOp(i2, i3);
    }

    private int allocLocal() {
        int i2 = this.localTop;
        int i3 = i2 + 1;
        this.localTop = i3;
        InterpreterData interpreterData = this.itsData;
        if (i3 > interpreterData.itsMaxLocals) {
            interpreterData.itsMaxLocals = i3;
        }
        return i2;
    }

    private static RuntimeException badTree(Node node) {
        throw new RuntimeException(node.toString());
    }

    private void fixLabelGotos() {
        for (int i2 = 0; i2 < this.fixupTableTop; i2++) {
            long j2 = this.fixupTable[i2];
            int i3 = (int) j2;
            int i4 = this.labelTable[(int) (j2 >> 32)];
            if (i4 == -1) {
                throw Kit.codeBug();
            }
            resolveGoto(i3, i4);
        }
        this.fixupTableTop = 0;
    }

    private void generateCallFunAndThis(Node node) {
        int type = node.getType();
        if (type != 33 && type != 36) {
            if (type == 39) {
                addStringOp(-15, node.getString());
                stackChange(2);
                return;
            } else {
                visitExpression(node, 0);
                addIcode(-18);
                stackChange(1);
                return;
            }
        }
        Node firstChild = node.getFirstChild();
        visitExpression(firstChild, 0);
        Node next = firstChild.getNext();
        if (type == 33) {
            addStringOp(-16, next.getString());
            stackChange(1);
        } else {
            visitExpression(next, 0);
            addIcode(-17);
        }
    }

    private void generateFunctionICode() {
        this.itsInFunctionFlag = true;
        FunctionNode functionNode = (FunctionNode) this.scriptOrFn;
        this.itsData.itsFunctionType = functionNode.getFunctionType();
        this.itsData.itsNeedsActivation = functionNode.requiresActivation();
        if (functionNode.getFunctionName() != null) {
            this.itsData.itsName = functionNode.getName();
        }
        if (functionNode.isGenerator()) {
            addIcode(-62);
            addUint16(functionNode.getBaseLineno() & 65535);
        }
        if (functionNode.isInStrictMode()) {
            this.itsData.isStrict = true;
        }
        if (functionNode.isES6Generator()) {
            this.itsData.isES6Generator = true;
        }
        this.itsData.declaredAsVar = functionNode.getParent() instanceof VariableInitializer;
        generateICodeFromTree(functionNode.getLastChild());
    }

    private void generateICodeFromTree(Node node) {
        generateNestedFunctions();
        generateRegExpLiterals();
        visitStatement(node, 0);
        fixLabelGotos();
        if (this.itsData.itsFunctionType == 0) {
            addToken(65);
        }
        byte[] bArr = this.itsData.itsICode;
        int length = bArr.length;
        int i2 = this.iCodeTop;
        if (length != i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.itsData.itsICode = bArr2;
        }
        if (this.strings.size() == 0) {
            this.itsData.itsStringTable = null;
        } else {
            this.itsData.itsStringTable = new String[this.strings.size()];
            ObjToIntMap.Iterator iteratorNewIterator = this.strings.newIterator();
            iteratorNewIterator.start();
            while (!iteratorNewIterator.done()) {
                String str = (String) iteratorNewIterator.getKey();
                int value = iteratorNewIterator.getValue();
                if (this.itsData.itsStringTable[value] != null) {
                    Kit.codeBug();
                }
                this.itsData.itsStringTable[value] = str;
                iteratorNewIterator.next();
            }
        }
        int i3 = this.doubleTableTop;
        if (i3 == 0) {
            this.itsData.itsDoubleTable = null;
        } else {
            double[] dArr = this.itsData.itsDoubleTable;
            if (dArr.length != i3) {
                double[] dArr2 = new double[i3];
                System.arraycopy(dArr, 0, dArr2, 0, i3);
                this.itsData.itsDoubleTable = dArr2;
            }
        }
        int i4 = this.exceptionTableTop;
        if (i4 != 0) {
            int[] iArr = this.itsData.itsExceptionTable;
            if (iArr.length != i4) {
                int[] iArr2 = new int[i4];
                System.arraycopy(iArr, 0, iArr2, 0, i4);
                this.itsData.itsExceptionTable = iArr2;
            }
        }
        this.itsData.itsMaxVars = this.scriptOrFn.getParamAndVarCount();
        InterpreterData interpreterData = this.itsData;
        interpreterData.itsMaxFrameArray = interpreterData.itsMaxVars + interpreterData.itsMaxLocals + interpreterData.itsMaxStack;
        interpreterData.argNames = this.scriptOrFn.getParamAndVarNames();
        this.itsData.argIsConst = this.scriptOrFn.getParamAndVarConst();
        this.itsData.argCount = this.scriptOrFn.getParamCount();
        this.itsData.encodedSourceStart = this.scriptOrFn.getEncodedSourceStart();
        this.itsData.encodedSourceEnd = this.scriptOrFn.getEncodedSourceEnd();
        if (this.literalIds.size() != 0) {
            this.itsData.literalIds = this.literalIds.toArray();
        }
    }

    private void generateNestedFunctions() {
        int functionCount = this.scriptOrFn.getFunctionCount();
        if (functionCount == 0) {
            return;
        }
        InterpreterData[] interpreterDataArr = new InterpreterData[functionCount];
        for (int i2 = 0; i2 != functionCount; i2++) {
            FunctionNode functionNode = this.scriptOrFn.getFunctionNode(i2);
            CodeGenerator codeGenerator = new CodeGenerator();
            codeGenerator.compilerEnv = this.compilerEnv;
            codeGenerator.scriptOrFn = functionNode;
            codeGenerator.itsData = new InterpreterData(this.itsData);
            codeGenerator.generateFunctionICode();
            interpreterDataArr[i2] = codeGenerator.itsData;
            AstNode parent = functionNode.getParent();
            if (!(parent instanceof AstRoot) && !(parent instanceof Scope) && !(parent instanceof Block)) {
                codeGenerator.itsData.declaredAsFunctionExpression = true;
            }
        }
        this.itsData.itsNestedFunctions = interpreterDataArr;
    }

    private void generateRegExpLiterals() {
        int regexpCount = this.scriptOrFn.getRegexpCount();
        if (regexpCount == 0) {
            return;
        }
        Context context = Context.getContext();
        RegExpProxy regExpProxyCheckRegExpProxy = ScriptRuntime.checkRegExpProxy(context);
        Object[] objArr = new Object[regexpCount];
        for (int i2 = 0; i2 != regexpCount; i2++) {
            objArr[i2] = regExpProxyCheckRegExpProxy.compileRegExp(context, this.scriptOrFn.getRegexpString(i2), this.scriptOrFn.getRegexpFlags(i2));
        }
        this.itsData.itsRegExpLiterals = objArr;
    }

    private int getDoubleIndex(double d2) {
        int i2 = this.doubleTableTop;
        if (i2 == 0) {
            this.itsData.itsDoubleTable = new double[64];
        } else {
            double[] dArr = this.itsData.itsDoubleTable;
            if (dArr.length == i2) {
                double[] dArr2 = new double[i2 * 2];
                System.arraycopy(dArr, 0, dArr2, 0, i2);
                this.itsData.itsDoubleTable = dArr2;
            }
        }
        this.itsData.itsDoubleTable[i2] = d2;
        this.doubleTableTop = i2 + 1;
        return i2;
    }

    private static int getLocalBlockRef(Node node) {
        return ((Node) node.getProp(3)).getExistingIntProp(2);
    }

    private int getTargetLabel(Node node) {
        int iLabelId = node.labelId();
        if (iLabelId != -1) {
            return iLabelId;
        }
        int i2 = this.labelTableTop;
        int[] iArr = this.labelTable;
        if (iArr == null || i2 == iArr.length) {
            if (iArr == null) {
                this.labelTable = new int[32];
            } else {
                int[] iArr2 = new int[iArr.length * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.labelTable = iArr2;
            }
        }
        this.labelTableTop = i2 + 1;
        this.labelTable[i2] = -1;
        node.labelId(i2);
        return i2;
    }

    private byte[] increaseICodeCapacity(int i2) {
        byte[] bArr = this.itsData.itsICode;
        int length = bArr.length;
        int i3 = this.iCodeTop;
        int i4 = i2 + i3;
        if (i4 <= length) {
            throw Kit.codeBug();
        }
        int i5 = length * 2;
        if (i4 <= i5) {
            i4 = i5;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        this.itsData.itsICode = bArr2;
        return bArr2;
    }

    private void markTargetLabel(Node node) {
        int targetLabel = getTargetLabel(node);
        if (this.labelTable[targetLabel] != -1) {
            Kit.codeBug();
        }
        this.labelTable[targetLabel] = this.iCodeTop;
    }

    private void releaseLocal(int i2) {
        int i3 = this.localTop - 1;
        this.localTop = i3;
        if (i2 != i3) {
            Kit.codeBug();
        }
    }

    private void resolveForwardGoto(int i2) {
        int i3 = this.iCodeTop;
        if (i3 < i2 + 3) {
            throw Kit.codeBug();
        }
        resolveGoto(i2, i3);
    }

    private void resolveGoto(int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 >= 0 && i4 <= 2) {
            throw Kit.codeBug();
        }
        int i5 = i2 + 1;
        if (i4 != ((short) i4)) {
            InterpreterData interpreterData = this.itsData;
            if (interpreterData.longJumps == null) {
                interpreterData.longJumps = new UintMap();
            }
            this.itsData.longJumps.put(i5, i3);
            i4 = 0;
        }
        byte[] bArr = this.itsData.itsICode;
        bArr[i5] = (byte) (i4 >> 8);
        bArr[i5 + 1] = (byte) i4;
    }

    private void stackChange(int i2) {
        if (i2 <= 0) {
            this.stackDepth += i2;
            return;
        }
        int i3 = this.stackDepth + i2;
        InterpreterData interpreterData = this.itsData;
        if (i3 > interpreterData.itsMaxStack) {
            interpreterData.itsMaxStack = i3;
        }
        this.stackDepth = i3;
    }

    private void updateLineNumber(Node node) {
        int lineno = node.getLineno();
        if (lineno == this.lineNumber || lineno < 0) {
            return;
        }
        InterpreterData interpreterData = this.itsData;
        if (interpreterData.firstLinePC < 0) {
            interpreterData.firstLinePC = lineno;
        }
        this.lineNumber = lineno;
        addIcode(-26);
        addUint16(lineno & 65535);
    }

    private void visitArrayComprehension(Node node, Node node2, Node node3) {
        visitStatement(node2, this.stackDepth);
        visitExpression(node3, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0226  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void visitExpression(org.mozilla.javascript.Node r18, int r19) {
        /*
            Method dump skipped, instruction units count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.CodeGenerator.visitExpression(org.mozilla.javascript.Node, int):void");
    }

    private void visitIncDec(Node node, Node node2) {
        int existingIntProp = node.getExistingIntProp(13);
        int type = node2.getType();
        if (type == 33) {
            Node firstChild = node2.getFirstChild();
            visitExpression(firstChild, 0);
            addStringOp(-9, firstChild.getNext().getString());
            addUint8(existingIntProp);
            return;
        }
        if (type == 36) {
            Node firstChild2 = node2.getFirstChild();
            visitExpression(firstChild2, 0);
            visitExpression(firstChild2.getNext(), 0);
            addIcode(-10);
            addUint8(existingIntProp);
            stackChange(-1);
            return;
        }
        if (type == 39) {
            addStringOp(-8, node2.getString());
            addUint8(existingIntProp);
            stackChange(1);
        } else {
            if (type != 55) {
                if (type != 68) {
                    throw badTree(node);
                }
                visitExpression(node2.getFirstChild(), 0);
                addIcode(-11);
                addUint8(existingIntProp);
                return;
            }
            if (this.itsData.itsNeedsActivation) {
                Kit.codeBug();
            }
            addVarOp(-7, this.scriptOrFn.getIndexForNameNode(node2));
            addUint8(existingIntProp);
            stackChange(1);
        }
    }

    private void visitLiteral(Node node, Node node2) {
        Object[] objArr;
        int length;
        int type = node.getType();
        if (type == 66) {
            length = 0;
            for (Node next = node2; next != null; next = next.getNext()) {
                length++;
            }
            objArr = null;
        } else {
            if (type != 67) {
                throw badTree(node);
            }
            objArr = (Object[]) node.getProp(12);
            length = objArr.length;
        }
        addIndexOp(-29, length);
        stackChange(2);
        while (node2 != null) {
            int type2 = node2.getType();
            if (type2 == 152) {
                visitExpression(node2.getFirstChild(), 0);
                addIcode(-57);
            } else if (type2 == 153) {
                visitExpression(node2.getFirstChild(), 0);
                addIcode(-58);
            } else if (type2 == 164) {
                visitExpression(node2.getFirstChild(), 0);
                addIcode(-30);
            } else {
                visitExpression(node2, 0);
                addIcode(-30);
            }
            stackChange(-1);
            node2 = node2.getNext();
        }
        if (type == 66) {
            int[] iArr = (int[]) node.getProp(11);
            if (iArr == null) {
                addToken(66);
            } else {
                int size = this.literalIds.size();
                this.literalIds.add(iArr);
                addIndexOp(-31, size);
            }
        } else {
            int size2 = this.literalIds.size();
            this.literalIds.add(objArr);
            addIndexOp(67, size2);
        }
        stackChange(-1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0189 A[LOOP:0: B:68:0x0187->B:69:0x0189, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void visitStatement(org.mozilla.javascript.Node r14, int r15) {
        /*
            Method dump skipped, instruction units count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.CodeGenerator.visitStatement(org.mozilla.javascript.Node, int):void");
    }

    public InterpreterData compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        this.compilerEnv = compilerEnvirons;
        new NodeTransformer().transform(scriptNode, compilerEnvirons);
        if (z) {
            this.scriptOrFn = scriptNode.getFunctionNode(0);
        } else {
            this.scriptOrFn = scriptNode;
        }
        InterpreterData interpreterData = new InterpreterData(compilerEnvirons.getLanguageVersion(), this.scriptOrFn.getSourceName(), str, this.scriptOrFn.isInStrictMode());
        this.itsData = interpreterData;
        interpreterData.topLevel = true;
        if (z) {
            generateFunctionICode();
        } else {
            generateICodeFromTree(this.scriptOrFn);
        }
        return this.itsData;
    }
}
