package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeGenerator extends IdScriptableObject {
    public static final int GENERATOR_CLOSE = 2;
    public static final int GENERATOR_SEND = 0;
    private static final Object GENERATOR_TAG = "Generator";
    public static final int GENERATOR_THROW = 1;
    private static final int Id___iterator__ = 5;
    private static final int Id_close = 1;
    private static final int Id_next = 2;
    private static final int Id_send = 3;
    private static final int Id_throw = 4;
    private static final int MAX_PROTOTYPE_ID = 5;
    private static final long serialVersionUID = 1645892441041347273L;
    private boolean firstTime = true;
    private NativeFunction function;
    private int lineNumber;
    private String lineSource;
    private boolean locked;
    private Object savedState;

    public static class GeneratorClosedException extends RuntimeException {
        private static final long serialVersionUID = 2561315658662379681L;
    }

    private NativeGenerator() {
    }

    public static NativeGenerator init(ScriptableObject scriptableObject, boolean z) {
        NativeGenerator nativeGenerator = new NativeGenerator();
        if (scriptableObject != null) {
            nativeGenerator.setParentScope(scriptableObject);
            nativeGenerator.setPrototype(ScriptableObject.getObjectPrototype(scriptableObject));
        }
        nativeGenerator.activatePrototypeMap(5);
        if (z) {
            nativeGenerator.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(GENERATOR_TAG, nativeGenerator);
        }
        return nativeGenerator;
    }

    private Object resume(Context context, Scriptable scriptable, int i2, Object obj) {
        if (this.savedState == null) {
            if (i2 == 2) {
                return Undefined.instance;
            }
            if (i2 != 1) {
                obj = NativeIterator.getStopIterationObject(scriptable);
            }
            throw new JavaScriptException(obj, this.lineSource, this.lineNumber);
        }
        try {
            try {
                synchronized (this) {
                    if (this.locked) {
                        throw ScriptRuntime.typeError0("msg.already.exec.gen");
                    }
                    this.locked = true;
                }
                Object objResumeGenerator = this.function.resumeGenerator(context, scriptable, i2, this.savedState, obj);
                synchronized (this) {
                    this.locked = false;
                }
                if (i2 == 2) {
                    this.savedState = null;
                }
                return objResumeGenerator;
            } catch (GeneratorClosedException unused) {
                Object obj2 = Undefined.instance;
                synchronized (this) {
                    this.locked = false;
                    if (i2 == 2) {
                        this.savedState = null;
                    }
                    return obj2;
                }
            } catch (RhinoException e2) {
                this.lineNumber = e2.lineNumber();
                this.lineSource = e2.lineSource();
                this.savedState = null;
                throw e2;
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.locked = false;
                if (i2 == 2) {
                    this.savedState = null;
                }
                throw th;
            }
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(GENERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (!(scriptable2 instanceof NativeGenerator)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        NativeGenerator nativeGenerator = (NativeGenerator) scriptable2;
        if (iMethodId == 1) {
            return nativeGenerator.resume(context, scriptable, 2, new GeneratorClosedException());
        }
        if (iMethodId == 2) {
            nativeGenerator.firstTime = false;
            return nativeGenerator.resume(context, scriptable, 0, Undefined.instance);
        }
        if (iMethodId != 3) {
            if (iMethodId == 4) {
                return nativeGenerator.resume(context, scriptable, 1, objArr.length > 0 ? objArr[0] : Undefined.instance);
            }
            if (iMethodId == 5) {
                return scriptable2;
            }
            throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (!nativeGenerator.firstTime || obj.equals(Undefined.instance)) {
            return nativeGenerator.resume(context, scriptable, 0, obj);
        }
        throw ScriptRuntime.typeError0("msg.send.newborn");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.length()
            r1 = 5
            r2 = 4
            r3 = 0
            if (r0 != r2) goto L1d
            char r0 = r5.charAt(r3)
            r1 = 110(0x6e, float:1.54E-43)
            if (r0 != r1) goto L15
            r1 = 2
            java.lang.String r0 = "next"
            goto L3c
        L15:
            r1 = 115(0x73, float:1.61E-43)
            if (r0 != r1) goto L3a
            r1 = 3
            java.lang.String r0 = "send"
            goto L3c
        L1d:
            if (r0 != r1) goto L33
            char r0 = r5.charAt(r3)
            r1 = 99
            if (r0 != r1) goto L2b
            r1 = 1
            java.lang.String r0 = "close"
            goto L3c
        L2b:
            r1 = 116(0x74, float:1.63E-43)
            if (r0 != r1) goto L3a
            java.lang.String r0 = "throw"
            r1 = 4
            goto L3c
        L33:
            r2 = 12
            if (r0 != r2) goto L3a
            java.lang.String r0 = "__iterator__"
            goto L3c
        L3a:
            r0 = 0
            r1 = 0
        L3c:
            if (r0 == 0) goto L47
            if (r0 == r5) goto L47
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L47
            goto L48
        L47:
            r3 = r1
        L48:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGenerator.findPrototypeId(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Generator";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        String str2;
        int i3 = 1;
        if (i2 == 1) {
            str = "close";
        } else if (i2 != 2) {
            if (i2 == 3) {
                str2 = "send";
            } else if (i2 == 4) {
                str2 = "throw";
            } else {
                if (i2 != 5) {
                    throw new IllegalArgumentException(String.valueOf(i2));
                }
                str = NativeIterator.ITERATOR_PROPERTY_NAME;
            }
            str = str2;
            i3 = 0;
        } else {
            str = ES6Iterator.NEXT_METHOD;
        }
        initPrototypeMethod(GENERATOR_TAG, i2, str, i3);
    }

    public NativeGenerator(Scriptable scriptable, NativeFunction nativeFunction, Object obj) {
        this.function = nativeFunction;
        this.savedState = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((NativeGenerator) ScriptableObject.getTopScopeValue(topLevelScope, GENERATOR_TAG));
    }
}
