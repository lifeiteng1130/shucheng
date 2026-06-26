package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public class NativeScript extends BaseFunction {
    private static final int Id_compile = 3;
    private static final int Id_constructor = 1;
    private static final int Id_exec = 4;
    private static final int Id_toString = 2;
    private static final int MAX_PROTOTYPE_ID = 4;
    private static final Object SCRIPT_TAG = "Script";
    private static final long serialVersionUID = -6795101161980121700L;
    private Script script;

    private NativeScript(Script script) {
        this.script = script;
    }

    private static Script compile(Context context, String str) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        if (sourcePositionFromStack == null) {
            iArr[0] = 1;
            sourcePositionFromStack = "<Script object>";
        }
        return context.compileString(str, null, DefaultErrorReporter.forEval(context.getErrorReporter()), sourcePositionFromStack, iArr[0], null);
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeScript(null).exportAsJSClass(4, scriptable, z);
    }

    private static NativeScript realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeScript) {
            return (NativeScript) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Script script = this.script;
        return script != null ? script.exec(context, scriptable) : Undefined.instance;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        throw Context.reportRuntimeError0("msg.script.is.not.constructor");
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String decompile(int i2, int i3) {
        Object obj = this.script;
        return obj instanceof NativeFunction ? ((NativeFunction) obj).decompile(i2, i3) : super.decompile(i2, i3);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(SCRIPT_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            NativeScript nativeScript = new NativeScript(compile(context, objArr.length != 0 ? ScriptRuntime.toString(objArr[0]) : ""));
            ScriptRuntime.setObjectProtoAndParent(nativeScript, scriptable);
            return nativeScript;
        }
        if (iMethodId == 2) {
            Script script = realThis(scriptable2, idFunctionObject).script;
            return script == null ? "" : context.decompileScript(script, 0);
        }
        if (iMethodId != 3) {
            if (iMethodId != 4) {
                throw new IllegalArgumentException(String.valueOf(iMethodId));
            }
            throw Context.reportRuntimeError1("msg.cant.call.indirect", "exec");
        }
        NativeScript nativeScriptRealThis = realThis(scriptable2, idFunctionObject);
        nativeScriptRealThis.script = compile(context, ScriptRuntime.toString(objArr, 0));
        return nativeScriptRealThis;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i2 = 4;
        if (length == 4) {
            str2 = "exec";
        } else if (length == 11) {
            i2 = 1;
            str2 = "constructor";
        } else if (length == 7) {
            i2 = 3;
            str2 = "compile";
        } else if (length != 8) {
            str2 = null;
            i2 = 0;
        } else {
            i2 = 2;
            str2 = "toString";
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i2;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getArity() {
        return 0;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Script";
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getLength() {
        return 0;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        String str2;
        int i3 = 0;
        if (i2 != 1) {
            if (i2 == 2) {
                str2 = "toString";
            } else if (i2 == 3) {
                str = "compile";
            } else {
                if (i2 != 4) {
                    throw new IllegalArgumentException(String.valueOf(i2));
                }
                str2 = "exec";
            }
            initPrototypeMethod(SCRIPT_TAG, i2, str2, i3);
        }
        str = "constructor";
        str2 = str;
        i3 = 1;
        initPrototypeMethod(SCRIPT_TAG, i2, str2, i3);
    }
}
