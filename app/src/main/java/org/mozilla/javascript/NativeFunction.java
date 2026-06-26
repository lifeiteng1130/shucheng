package org.mozilla.javascript;

import org.mozilla.javascript.debug.DebuggableScript;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeFunction extends BaseFunction {
    private static final long serialVersionUID = 8713897114082216401L;

    @Override // org.mozilla.javascript.BaseFunction
    public final String decompile(int i2, int i3) {
        String encodedSource = getEncodedSource();
        if (encodedSource == null) {
            return super.decompile(i2, i3);
        }
        UintMap uintMap = new UintMap(1);
        uintMap.put(1, i2);
        return Decompiler.decompile(encodedSource, i3, uintMap);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getArity() {
        return getParamCount();
    }

    public DebuggableScript getDebuggableView() {
        return null;
    }

    public String getEncodedSource() {
        return null;
    }

    public abstract int getLanguageVersion();

    @Override // org.mozilla.javascript.BaseFunction
    public int getLength() {
        NativeCall nativeCallFindFunctionActivation;
        int paramCount = getParamCount();
        return (getLanguageVersion() == 120 && (nativeCallFindFunctionActivation = ScriptRuntime.findFunctionActivation(Context.getContext(), this)) != null) ? nativeCallFindFunctionActivation.originalArgs.length : paramCount;
    }

    public abstract int getParamAndVarCount();

    public abstract int getParamCount();

    public boolean getParamOrVarConst(int i2) {
        return false;
    }

    public abstract String getParamOrVarName(int i2);

    public final void initScriptFunction(Context context, Scriptable scriptable) {
        initScriptFunction(context, scriptable, isGeneratorFunction());
    }

    @Deprecated
    public String jsGet_name() {
        return getFunctionName();
    }

    public Object resumeGenerator(Context context, Scriptable scriptable, int i2, Object obj, Object obj2) {
        throw new EvaluatorException("resumeGenerator() not implemented");
    }

    public final void initScriptFunction(Context context, Scriptable scriptable, boolean z) {
        ScriptRuntime.setFunctionProtoAndParent(this, scriptable, z);
    }
}
