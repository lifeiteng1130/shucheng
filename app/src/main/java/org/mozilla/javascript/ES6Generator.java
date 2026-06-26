package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public final class ES6Generator extends IdScriptableObject {
    private static final Object GENERATOR_TAG = "Generator";
    private static final int Id_next = 1;
    private static final int Id_return = 2;
    private static final int Id_throw = 3;
    private static final int MAX_PROTOTYPE_ID = 4;
    private static final int SymbolId_iterator = 4;
    private static final long serialVersionUID = 1645892441041347273L;
    private Object delegee;
    private NativeFunction function;
    private int lineNumber;
    private String lineSource;
    private Object savedState;
    private State state = State.SUSPENDED_START;

    public enum State {
        SUSPENDED_START,
        SUSPENDED_YIELD,
        EXECUTING,
        COMPLETED
    }

    public static final class YieldStarResult {
        private Object result;

        public YieldStarResult(Object obj) {
            this.result = obj;
        }

        public Object getResult() {
            return this.result;
        }
    }

    private ES6Generator() {
    }

    private Object callReturnOptionally(Context context, Scriptable scriptable, Object obj) {
        Object obj2 = Undefined.instance;
        Object[] objArr = obj2.equals(obj) ? ScriptRuntime.emptyArgs : new Object[]{obj};
        Object objectPropNoWarn = ScriptRuntime.getObjectPropNoWarn(this.delegee, "return", context, scriptable);
        if (obj2.equals(objectPropNoWarn)) {
            return null;
        }
        if (objectPropNoWarn instanceof Callable) {
            return ((Callable) objectPropNoWarn).call(context, scriptable, ScriptableObject.ensureScriptable(this.delegee), objArr);
        }
        throw ScriptRuntime.typeError2("msg.isnt.function", "return", ScriptRuntime.typeof(objectPropNoWarn));
    }

    public static ES6Generator init(ScriptableObject scriptableObject, boolean z) {
        ES6Generator eS6Generator = new ES6Generator();
        if (scriptableObject != null) {
            eS6Generator.setParentScope(scriptableObject);
            eS6Generator.setPrototype(ScriptableObject.getObjectPrototype(scriptableObject));
        }
        eS6Generator.activatePrototypeMap(4);
        if (z) {
            eS6Generator.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(GENERATOR_TAG, eS6Generator);
        }
        return eS6Generator;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.Scriptable resumeAbruptLocal(org.mozilla.javascript.Context r14, org.mozilla.javascript.Scriptable r15, int r16, java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ES6Generator.resumeAbruptLocal(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, int, java.lang.Object):org.mozilla.javascript.Scriptable");
    }

    private Scriptable resumeDelegee(Context context, Scriptable scriptable, Object obj) {
        try {
            Scriptable scriptableEnsureScriptable = ScriptableObject.ensureScriptable(ScriptRuntime.getPropFunctionAndThis(this.delegee, ES6Iterator.NEXT_METHOD, context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), Undefined.instance.equals(obj) ? ScriptRuntime.emptyArgs : new Object[]{obj}));
            if (!ScriptRuntime.isIteratorDone(context, scriptableEnsureScriptable)) {
                return scriptableEnsureScriptable;
            }
            this.delegee = null;
            return resumeLocal(context, scriptable, ScriptableObject.getProperty(scriptableEnsureScriptable, ES6Iterator.VALUE_PROPERTY));
        } catch (RhinoException e2) {
            this.delegee = null;
            return resumeAbruptLocal(context, scriptable, 1, e2);
        }
    }

    private Scriptable resumeDelegeeReturn(Context context, Scriptable scriptable, Object obj) {
        try {
            Object objCallReturnOptionally = callReturnOptionally(context, scriptable, obj);
            if (objCallReturnOptionally == null) {
                this.delegee = null;
                return resumeAbruptLocal(context, scriptable, 2, obj);
            }
            if (!ScriptRuntime.isIteratorDone(context, objCallReturnOptionally)) {
                return ScriptableObject.ensureScriptable(objCallReturnOptionally);
            }
            this.delegee = null;
            return resumeAbruptLocal(context, scriptable, 2, ScriptRuntime.getObjectPropNoWarn(objCallReturnOptionally, ES6Iterator.VALUE_PROPERTY, context, scriptable));
        } catch (RhinoException e2) {
            this.delegee = null;
            return resumeAbruptLocal(context, scriptable, 1, e2);
        }
    }

    private Scriptable resumeDelegeeThrow(Context context, Scriptable scriptable, Object obj) {
        boolean z = false;
        try {
            Object objCall = ScriptRuntime.getPropFunctionAndThis(this.delegee, "throw", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), new Object[]{obj});
            try {
                if (!ScriptRuntime.isIteratorDone(context, objCall)) {
                    return ScriptableObject.ensureScriptable(objCall);
                }
                try {
                    callReturnOptionally(context, scriptable, Undefined.instance);
                    this.delegee = null;
                    return resumeLocal(context, scriptable, ScriptRuntime.getObjectProp(objCall, ES6Iterator.VALUE_PROPERTY, context, scriptable));
                } finally {
                }
            } catch (RhinoException e2) {
                e = e2;
                z = true;
            }
        } catch (RhinoException e3) {
            e = e3;
        }
        if (!z) {
            try {
                callReturnOptionally(context, scriptable, Undefined.instance);
            } catch (RhinoException e4) {
                return resumeAbruptLocal(context, scriptable, 1, e4);
            } finally {
            }
        }
        this.delegee = null;
        return resumeAbruptLocal(context, scriptable, 1, e);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.Scriptable resumeLocal(org.mozilla.javascript.Context r12, org.mozilla.javascript.Scriptable r13, java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ES6Generator.resumeLocal(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object):org.mozilla.javascript.Scriptable");
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(GENERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (!(scriptable2 instanceof ES6Generator)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        ES6Generator eS6Generator = (ES6Generator) scriptable2;
        Object obj = objArr.length >= 1 ? objArr[0] : Undefined.instance;
        if (iMethodId == 1) {
            return eS6Generator.delegee == null ? eS6Generator.resumeLocal(context, scriptable, obj) : eS6Generator.resumeDelegee(context, scriptable, obj);
        }
        if (iMethodId == 2) {
            return eS6Generator.delegee == null ? eS6Generator.resumeAbruptLocal(context, scriptable, 2, obj) : eS6Generator.resumeDelegeeReturn(context, scriptable, obj);
        }
        if (iMethodId == 3) {
            return eS6Generator.delegee == null ? eS6Generator.resumeAbruptLocal(context, scriptable, 1, obj) : eS6Generator.resumeDelegeeThrow(context, scriptable, obj);
        }
        if (iMethodId == 4) {
            return scriptable2;
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 4 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Generator";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        if (i2 == 4) {
            initPrototypeMethod(GENERATOR_TAG, i2, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        if (i2 == 1) {
            str = ES6Iterator.NEXT_METHOD;
        } else if (i2 == 2) {
            str = "return";
        } else {
            if (i2 != 3) {
                throw new IllegalArgumentException(String.valueOf(i2));
            }
            str = "throw";
        }
        initPrototypeMethod(GENERATOR_TAG, i2, str, 1);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i2;
        int length = str.length();
        if (length == 4) {
            i2 = 1;
            str2 = ES6Iterator.NEXT_METHOD;
        } else if (length == 5) {
            i2 = 3;
            str2 = "throw";
        } else if (length == 6) {
            i2 = 2;
            str2 = "return";
        } else {
            str2 = null;
            i2 = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i2;
        }
        return 0;
    }

    public ES6Generator(Scriptable scriptable, NativeFunction nativeFunction, Object obj) {
        this.function = nativeFunction;
        this.savedState = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((ES6Generator) ScriptableObject.getTopScopeValue(topLevelScope, GENERATOR_TAG));
    }
}
