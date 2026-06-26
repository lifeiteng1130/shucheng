package org.mozilla.javascript;

import androidx.core.app.NotificationCompat;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class BaseFunction extends IdScriptableObject implements Function {
    private static final String FUNCTION_CLASS = "Function";
    private static final Object FUNCTION_TAG = FUNCTION_CLASS;
    public static final String GENERATOR_FUNCTION_CLASS = "__GeneratorFunction";
    private static final int Id_apply = 4;
    private static final int Id_arguments = 5;
    private static final int Id_arity = 2;
    private static final int Id_bind = 6;
    private static final int Id_call = 5;
    private static final int Id_constructor = 1;
    private static final int Id_length = 1;
    private static final int Id_name = 3;
    private static final int Id_prototype = 4;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int MAX_PROTOTYPE_ID = 6;
    private static final long serialVersionUID = 5311394446546053859L;
    private int argumentsAttributes;
    private Object argumentsObj;
    private boolean isGeneratorFunction;
    private Object prototypeProperty;
    private int prototypePropertyAttributes;

    public BaseFunction() {
        this.argumentsObj = Scriptable.NOT_FOUND;
        this.isGeneratorFunction = false;
        this.prototypePropertyAttributes = 6;
        this.argumentsAttributes = 6;
    }

    private Object getArguments() {
        Object objDefaultGet = defaultHas("arguments") ? defaultGet("arguments") : this.argumentsObj;
        if (objDefaultGet != Scriptable.NOT_FOUND) {
            return objDefaultGet;
        }
        Scriptable scriptableFindFunctionActivation = ScriptRuntime.findFunctionActivation(Context.getContext(), this);
        if (scriptableFindFunctionActivation == null) {
            return null;
        }
        return scriptableFindFunctionActivation.get("arguments", scriptableFindFunctionActivation);
    }

    public static void init(Scriptable scriptable, boolean z) {
        BaseFunction baseFunction = new BaseFunction();
        baseFunction.prototypePropertyAttributes = 7;
        baseFunction.exportAsJSClass(6, scriptable, z);
    }

    public static Object initAsGeneratorFunction(Scriptable scriptable, boolean z) {
        BaseFunction baseFunction = new BaseFunction(true);
        baseFunction.prototypePropertyAttributes = 5;
        baseFunction.exportAsJSClass(6, scriptable, z);
        return ScriptableObject.getProperty(scriptable, GENERATOR_FUNCTION_CLASS);
    }

    public static boolean isApply(IdFunctionObject idFunctionObject) {
        return idFunctionObject.hasTag(FUNCTION_TAG) && idFunctionObject.methodId() == 4;
    }

    public static boolean isApplyOrCall(IdFunctionObject idFunctionObject) {
        if (!idFunctionObject.hasTag(FUNCTION_TAG)) {
            return false;
        }
        int iMethodId = idFunctionObject.methodId();
        return iMethodId == 4 || iMethodId == 5;
    }

    private Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        int i2;
        int length = objArr.length;
        StringBuilder sbR = a.r("function ");
        if (isGeneratorFunction()) {
            sbR.append("* ");
        }
        if (context.getLanguageVersion() != 120) {
            sbR.append("anonymous");
        }
        sbR.append('(');
        int i3 = 0;
        while (true) {
            i2 = length - 1;
            if (i3 >= i2) {
                break;
            }
            if (i3 > 0) {
                sbR.append(',');
            }
            sbR.append(ScriptRuntime.toString(objArr[i3]));
            i3++;
        }
        sbR.append(") {");
        if (length != 0) {
            sbR.append(ScriptRuntime.toString(objArr[i2]));
        }
        sbR.append("\n}");
        String string = sbR.toString();
        int[] iArr = new int[1];
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        if (sourcePositionFromStack == null) {
            iArr[0] = 1;
            sourcePositionFromStack = "<eval'ed string>";
        }
        String strMakeUrlForGeneratedScript = ScriptRuntime.makeUrlForGeneratedScript(false, sourcePositionFromStack, iArr[0]);
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        ErrorReporter errorReporterForEval = DefaultErrorReporter.forEval(context.getErrorReporter());
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter != null) {
            return context.compileFunction(topLevelScope, string, evaluatorCreateInterpreter, errorReporterForEval, strMakeUrlForGeneratedScript, 1, null);
        }
        throw new JavaScriptException("Interpreter not present", sourcePositionFromStack, iArr[0]);
    }

    private static BaseFunction realFunction(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        Object defaultValue = scriptable.getDefaultValue(ScriptRuntime.FunctionClass);
        if (defaultValue instanceof Delegator) {
            defaultValue = ((Delegator) defaultValue).getDelegee();
        }
        if (defaultValue instanceof BaseFunction) {
            return (BaseFunction) defaultValue;
        }
        throw ScriptRuntime.typeError1("msg.incompat.call", idFunctionObject.getFunctionName());
    }

    private synchronized Object setupDefaultPrototype() {
        Object obj = this.prototypeProperty;
        if (obj != null) {
            return obj;
        }
        NativeObject nativeObject = new NativeObject();
        nativeObject.defineProperty("constructor", this, 2);
        this.prototypeProperty = nativeObject;
        Scriptable objectPrototype = ScriptableObject.getObjectPrototype(this);
        if (objectPrototype != nativeObject) {
            nativeObject.setPrototype(objectPrototype);
        }
        return nativeObject;
    }

    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return Undefined.instance;
    }

    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable parentScope;
        Scriptable classPrototype;
        Scriptable scriptableCreateObject = createObject(context, scriptable);
        if (scriptableCreateObject != null) {
            Object objCall = call(context, scriptable, scriptableCreateObject, objArr);
            return objCall instanceof Scriptable ? (Scriptable) objCall : scriptableCreateObject;
        }
        Object objCall2 = call(context, scriptable, null, objArr);
        if (!(objCall2 instanceof Scriptable)) {
            StringBuilder sbR = a.r("Bad implementaion of call as constructor, name=");
            sbR.append(getFunctionName());
            sbR.append(" in ");
            sbR.append(getClass().getName());
            throw new IllegalStateException(sbR.toString());
        }
        Scriptable scriptable2 = (Scriptable) objCall2;
        if (scriptable2.getPrototype() == null && scriptable2 != (classPrototype = getClassPrototype())) {
            scriptable2.setPrototype(classPrototype);
        }
        if (scriptable2.getParentScope() != null || scriptable2 == (parentScope = getParentScope())) {
            return scriptable2;
        }
        scriptable2.setParentScope(parentScope);
        return scriptable2;
    }

    public Scriptable createObject(Context context, Scriptable scriptable) {
        NativeObject nativeObject = new NativeObject();
        nativeObject.setPrototype(getClassPrototype());
        nativeObject.setParentScope(getParentScope());
        return nativeObject;
    }

    public String decompile(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        boolean z = (i3 & 1) != 0;
        if (!z) {
            sb.append("function ");
            sb.append(getFunctionName());
            sb.append("() {\n\t");
        }
        sb.append("[native code, arity=");
        sb.append(getArity());
        sb.append("]\n");
        if (!z) {
            sb.append("}\n");
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        int int32;
        Scriptable scriptable3;
        Object[] objArr2;
        if (!idFunctionObject.hasTag(FUNCTION_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        int i2 = 0;
        switch (iMethodId) {
            case 1:
                return jsConstructor(context, scriptable, objArr);
            case 2:
                return realFunction(scriptable2, idFunctionObject).decompile(ScriptRuntime.toInt32(objArr, 0), 0);
            case 3:
                BaseFunction baseFunctionRealFunction = realFunction(scriptable2, idFunctionObject);
                int i3 = 2;
                if (objArr.length != 0 && (int32 = ScriptRuntime.toInt32(objArr[0])) >= 0) {
                    i2 = int32;
                    i3 = 0;
                }
                return baseFunctionRealFunction.decompile(i2, i3);
            case 4:
            case 5:
                return ScriptRuntime.applyOrCall(iMethodId == 4, context, scriptable, scriptable2, objArr);
            case 6:
                if (!(scriptable2 instanceof Callable)) {
                    throw ScriptRuntime.notFunctionError(scriptable2);
                }
                Callable callable = (Callable) scriptable2;
                int length = objArr.length;
                if (length > 0) {
                    Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, objArr[0], scriptable);
                    int i4 = length - 1;
                    Object[] objArr3 = new Object[i4];
                    System.arraycopy(objArr, 1, objArr3, 0, i4);
                    scriptable3 = objectOrNull;
                    objArr2 = objArr3;
                } else {
                    scriptable3 = null;
                    objArr2 = ScriptRuntime.emptyArgs;
                }
                return new BoundFunction(context, scriptable, callable, scriptable3, objArr2);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.setPrototype(this);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findInstanceIdInfo(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.length()
            r1 = 1
            r2 = 2
            r3 = 3
            r4 = 5
            r5 = 4
            r6 = 0
            if (r0 == r5) goto L35
            if (r0 == r4) goto L31
            r7 = 6
            if (r0 == r7) goto L2d
            r7 = 9
            if (r0 == r7) goto L16
            goto L2a
        L16:
            char r0 = r9.charAt(r6)
            r7 = 97
            if (r0 != r7) goto L22
            java.lang.String r0 = "arguments"
            r7 = 5
            goto L38
        L22:
            r7 = 112(0x70, float:1.57E-43)
            if (r0 != r7) goto L2a
            java.lang.String r0 = "prototype"
            r7 = 4
            goto L38
        L2a:
            r0 = 0
            r7 = 0
            goto L38
        L2d:
            java.lang.String r0 = "length"
            r7 = 1
            goto L38
        L31:
            java.lang.String r0 = "arity"
            r7 = 2
            goto L38
        L35:
            java.lang.String r0 = "name"
            r7 = 3
        L38:
            if (r0 == 0) goto L43
            if (r0 == r9) goto L43
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L43
            r7 = 0
        L43:
            if (r7 != 0) goto L4a
            int r9 = super.findInstanceIdInfo(r9)
            return r9
        L4a:
            if (r7 == r1) goto L67
            if (r7 == r2) goto L67
            if (r7 == r3) goto L67
            if (r7 == r5) goto L5d
            if (r7 != r4) goto L57
            int r9 = r8.argumentsAttributes
            goto L68
        L57:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L5d:
            boolean r9 = r8.hasPrototypeProperty()
            if (r9 != 0) goto L64
            return r6
        L64:
            int r9 = r8.prototypePropertyAttributes
            goto L68
        L67:
            r9 = 7
        L68:
            int r9 = org.mozilla.javascript.IdScriptableObject.instanceIdInfo(r9, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.BaseFunction.findInstanceIdInfo(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.length()
            r1 = 3
            r2 = 5
            r3 = 4
            r4 = 0
            if (r0 == r3) goto L30
            if (r0 == r2) goto L2c
            r2 = 8
            if (r0 == r2) goto L19
            r1 = 11
            if (r0 == r1) goto L15
            goto L44
        L15:
            r1 = 1
            java.lang.String r0 = "constructor"
            goto L46
        L19:
            char r0 = r6.charAt(r1)
            r2 = 111(0x6f, float:1.56E-43)
            if (r0 != r2) goto L24
            java.lang.String r0 = "toSource"
            goto L46
        L24:
            r1 = 116(0x74, float:1.63E-43)
            if (r0 != r1) goto L44
            r1 = 2
            java.lang.String r0 = "toString"
            goto L46
        L2c:
            java.lang.String r0 = "apply"
            r1 = 4
            goto L46
        L30:
            char r0 = r6.charAt(r4)
            r1 = 98
            if (r0 != r1) goto L3c
            r1 = 6
            java.lang.String r0 = "bind"
            goto L46
        L3c:
            r1 = 99
            if (r0 != r1) goto L44
            java.lang.String r0 = "call"
            r1 = 5
            goto L46
        L44:
            r0 = 0
            r1 = 0
        L46:
            if (r0 == 0) goto L51
            if (r0 == r6) goto L51
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L51
            goto L52
        L51:
            r4 = r1
        L52:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.BaseFunction.findPrototypeId(java.lang.String):int");
    }

    public int getArity() {
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return isGeneratorFunction() ? GENERATOR_FUNCTION_CLASS : FUNCTION_CLASS;
    }

    public Scriptable getClassPrototype() {
        Object prototypeProperty = getPrototypeProperty();
        return prototypeProperty instanceof Scriptable ? (Scriptable) prototypeProperty : ScriptableObject.getObjectPrototype(this);
    }

    public String getFunctionName() {
        return "";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? super.getInstanceIdName(i2) : "arguments" : "prototype" : "name" : "arity" : "length";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? super.getInstanceIdValue(i2) : getArguments() : getPrototypeProperty() : getFunctionName() : ScriptRuntime.wrapInt(getArity()) : ScriptRuntime.wrapInt(getLength());
    }

    public int getLength() {
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 5;
    }

    public Object getPrototypeProperty() {
        Object obj = this.prototypeProperty;
        if (obj == null) {
            return this instanceof NativeFunction ? setupDefaultPrototype() : Undefined.instance;
        }
        if (obj == UniqueTag.NULL_VALUE) {
            return null;
        }
        return obj;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : "function";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        Object property = ScriptableObject.getProperty(this, "prototype");
        if (property instanceof Scriptable) {
            return ScriptRuntime.jsDelegatesTo(scriptable, (Scriptable) property);
        }
        throw ScriptRuntime.typeError1("msg.instanceof.bad.prototype", getFunctionName());
    }

    public boolean hasPrototypeProperty() {
        return this.prototypeProperty != null || (this instanceof NativeFunction);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        int i3 = 1;
        switch (i2) {
            case 1:
                str = "constructor";
                break;
            case 2:
                i3 = 0;
                str = "toString";
                break;
            case 3:
                str = "toSource";
                break;
            case 4:
                i3 = 2;
                str = "apply";
                break;
            case 5:
                str = NotificationCompat.CATEGORY_CALL;
                break;
            case 6:
                str = "bind";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
        initPrototypeMethod(FUNCTION_TAG, i2, str, i3);
    }

    public boolean isGeneratorFunction() {
        return this.isGeneratorFunction;
    }

    public void setImmunePrototypeProperty(Object obj) {
        if ((this.prototypePropertyAttributes & 1) != 0) {
            throw new IllegalStateException();
        }
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        this.prototypeProperty = obj;
        this.prototypePropertyAttributes = 7;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdAttributes(int i2, int i3) {
        if (i2 == 4) {
            this.prototypePropertyAttributes = i3;
        } else if (i2 != 5) {
            super.setInstanceIdAttributes(i2, i3);
        } else {
            this.argumentsAttributes = i3;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i2, Object obj) {
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return;
        }
        if (i2 == 4) {
            if ((this.prototypePropertyAttributes & 1) == 0) {
                if (obj == null) {
                    obj = UniqueTag.NULL_VALUE;
                }
                this.prototypeProperty = obj;
                return;
            }
            return;
        }
        if (i2 != 5) {
            super.setInstanceIdValue(i2, obj);
            return;
        }
        if (obj == Scriptable.NOT_FOUND) {
            Kit.codeBug();
        }
        if (defaultHas("arguments")) {
            defaultPut("arguments", obj);
        } else if ((this.argumentsAttributes & 1) == 0) {
            this.argumentsObj = obj;
        }
    }

    public BaseFunction(boolean z) {
        this.argumentsObj = Scriptable.NOT_FOUND;
        this.isGeneratorFunction = false;
        this.prototypePropertyAttributes = 6;
        this.argumentsAttributes = 6;
        this.isGeneratorFunction = z;
    }

    public BaseFunction(Scriptable scriptable, Scriptable scriptable2) {
        super(scriptable, scriptable2);
        this.argumentsObj = Scriptable.NOT_FOUND;
        this.isGeneratorFunction = false;
        this.prototypePropertyAttributes = 6;
        this.argumentsAttributes = 6;
    }
}
