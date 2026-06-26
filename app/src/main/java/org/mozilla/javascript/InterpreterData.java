package org.mozilla.javascript;

import java.io.Serializable;
import java.util.Arrays;
import org.mozilla.javascript.debug.DebuggableScript;

/* JADX INFO: loaded from: classes3.dex */
public final class InterpreterData implements Serializable, DebuggableScript {
    public static final int INITIAL_MAX_ICODE_LENGTH = 1024;
    public static final int INITIAL_NUMBERTABLE_SIZE = 64;
    public static final int INITIAL_STRINGTABLE_SIZE = 64;
    private static final long serialVersionUID = 5067677351589230234L;
    public int argCount;
    public boolean[] argIsConst;
    public String[] argNames;
    public boolean declaredAsFunctionExpression;
    public boolean declaredAsVar;
    public String encodedSource;
    public int encodedSourceEnd;
    public int encodedSourceStart;
    public boolean evalScriptFlag;
    public int firstLinePC = -1;
    private int icodeHashCode = 0;
    public boolean isES6Generator;
    public boolean isStrict;
    public double[] itsDoubleTable;
    public int[] itsExceptionTable;
    public int itsFunctionType;
    public byte[] itsICode;
    public int itsMaxCalleeArgs;
    public int itsMaxFrameArray;
    public int itsMaxLocals;
    public int itsMaxStack;
    public int itsMaxVars;
    public String itsName;
    public boolean itsNeedsActivation;
    public InterpreterData[] itsNestedFunctions;
    public Object[] itsRegExpLiterals;
    public String itsSourceFile;
    public String[] itsStringTable;
    public int languageVersion;
    public Object[] literalIds;
    public UintMap longJumps;
    public InterpreterData parentData;
    public boolean topLevel;

    public InterpreterData(int i2, String str, String str2, boolean z) {
        this.languageVersion = i2;
        this.itsSourceFile = str;
        this.encodedSource = str2;
        this.isStrict = z;
        init();
    }

    private void init() {
        this.itsICode = new byte[1024];
        this.itsStringTable = new String[64];
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public DebuggableScript getFunction(int i2) {
        return this.itsNestedFunctions[i2];
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public int getFunctionCount() {
        InterpreterData[] interpreterDataArr = this.itsNestedFunctions;
        if (interpreterDataArr == null) {
            return 0;
        }
        return interpreterDataArr.length;
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public String getFunctionName() {
        return this.itsName;
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public int[] getLineNumbers() {
        return Interpreter.getLineNumbers(this);
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public int getParamAndVarCount() {
        return this.argNames.length;
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public int getParamCount() {
        return this.argCount;
    }

    public boolean getParamOrVarConst(int i2) {
        return this.argIsConst[i2];
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public String getParamOrVarName(int i2) {
        return this.argNames[i2];
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public DebuggableScript getParent() {
        return this.parentData;
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public String getSourceName() {
        return this.itsSourceFile;
    }

    public int icodeHashCode() {
        int i2 = this.icodeHashCode;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.itsICode);
        this.icodeHashCode = iHashCode;
        return iHashCode;
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public boolean isFunction() {
        return this.itsFunctionType != 0;
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public boolean isGeneratedScript() {
        return ScriptRuntime.isGeneratedScript(this.itsSourceFile);
    }

    @Override // org.mozilla.javascript.debug.DebuggableScript
    public boolean isTopLevel() {
        return this.topLevel;
    }

    public InterpreterData(InterpreterData interpreterData) {
        this.parentData = interpreterData;
        this.languageVersion = interpreterData.languageVersion;
        this.itsSourceFile = interpreterData.itsSourceFile;
        this.encodedSource = interpreterData.encodedSource;
        this.isStrict = interpreterData.isStrict;
        init();
    }
}
