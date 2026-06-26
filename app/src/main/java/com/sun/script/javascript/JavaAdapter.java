package com.sun.script.javascript;

import javax.script.Invocable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: loaded from: classes.dex */
public final class JavaAdapter extends ScriptableObject implements Function {
    private Invocable engine;

    private JavaAdapter(Invocable invocable) {
        this.engine = invocable;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        RhinoTopLevel rhinoTopLevel = (RhinoTopLevel) scriptable;
        JavaAdapter javaAdapter = new JavaAdapter(rhinoTopLevel.getScriptEngine());
        javaAdapter.setParentScope(scriptable);
        javaAdapter.setPrototype(ScriptableObject.getFunctionPrototype(scriptable));
        ScriptableObject.putProperty(rhinoTopLevel, "JavaAdapter", javaAdapter);
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return construct(context, scriptable, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b A[PHI: r0
  0x002b: PHI (r0v5 java.lang.Class) = (r0v3 java.lang.Class), (r0v8 java.lang.Class) binds: [B:14:0x0029, B:9:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.mozilla.javascript.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mozilla.javascript.Scriptable construct(org.mozilla.javascript.Context r3, org.mozilla.javascript.Scriptable r4, java.lang.Object[] r5) {
        /*
            r2 = this;
            int r3 = r5.length
            r0 = 2
            if (r3 != r0) goto L47
            r3 = 0
            r0 = 0
            r0 = r5[r0]
            boolean r1 = r0 instanceof org.mozilla.javascript.Wrapper
            if (r1 == 0) goto L1f
            org.mozilla.javascript.Wrapper r0 = (org.mozilla.javascript.Wrapper) r0
            java.lang.Object r0 = r0.unwrap()
            boolean r1 = r0 instanceof java.lang.Class
            if (r1 == 0) goto L2c
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isInterface()
            if (r1 == 0) goto L2c
            goto L2b
        L1f:
            boolean r1 = r0 instanceof java.lang.Class
            if (r1 == 0) goto L2c
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isInterface()
            if (r1 == 0) goto L2c
        L2b:
            r3 = r0
        L2c:
            if (r3 == 0) goto L40
            org.mozilla.javascript.Scriptable r4 = org.mozilla.javascript.ScriptableObject.getTopLevelScope(r4)
            javax.script.Invocable r0 = r2.engine
            r1 = 1
            r5 = r5[r1]
            java.lang.Object r3 = r0.getInterface(r5, r3)
            org.mozilla.javascript.Scriptable r3 = org.mozilla.javascript.Context.toObject(r3, r4)
            return r3
        L40:
            java.lang.String r3 = "JavaAdapter: first arg should be interface Class"
            org.mozilla.javascript.EvaluatorException r3 = org.mozilla.javascript.Context.reportRuntimeError(r3)
            throw r3
        L47:
            java.lang.String r3 = "JavaAdapter requires two arguments"
            org.mozilla.javascript.EvaluatorException r3 = org.mozilla.javascript.Context.reportRuntimeError(r3)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.script.javascript.JavaAdapter.construct(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[]):org.mozilla.javascript.Scriptable");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaAdapter";
    }
}
