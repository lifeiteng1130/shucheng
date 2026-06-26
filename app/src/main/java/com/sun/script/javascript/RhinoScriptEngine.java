package com.sun.script.javascript;

import c.i.a.a.a;
import com.umeng.analytics.pro.c;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.security.AccessControlContext;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.AllPermission;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.JavaScriptException;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;

/* JADX INFO: loaded from: classes.dex */
public final class RhinoScriptEngine extends AbstractScriptEngine implements Invocable, Compilable {
    private static final boolean DEBUG = false;
    private static final String RHINO_JS_VERSION = "rhino.js.version";
    private static final String RHINO_OPT_LEVEL = "rhino.opt.level";
    private static final int languageVersion = getLanguageVersion();
    private static final int optimizationLevel = getOptimizationLevel();
    private static final String printSource = "function print(str, newline) {                \n    if (typeof(str) == 'undefined') {         \n        str = 'undefined';                    \n    } else if (str == null) {                 \n        str = 'null';                         \n    }                                         \n    var out = context.getWriter();            \n    if (!(out instanceof java.io.PrintWriter))\n        out = new java.io.PrintWriter(out);   \n    out.print(String(str));                   \n    if (newline) out.print('\\n');            \n    out.flush();                              \n}\nfunction println(str) {                       \n    print(str, true);                         \n}";
    private AccessControlContext accCtxt;
    private ScriptEngineFactory factory;
    private a implementor;
    private Map<Object, Object> indexedProps;
    private RhinoTopLevel topLevel;

    static {
        ContextFactory.initGlobal(new ContextFactory() { // from class: com.sun.script.javascript.RhinoScriptEngine.1
            /* JADX INFO: Access modifiers changed from: private */
            public Object superDoTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
                return super.doTopCall(callable, context, scriptable, scriptable2, objArr);
            }

            @Override // org.mozilla.javascript.ContextFactory
            public Object doTopCall(final Callable callable, final Context context, final Scriptable scriptable, final Scriptable scriptable2, final Object[] objArr) {
                Scriptable prototype = ScriptableObject.getTopLevelScope(scriptable).getPrototype();
                AccessControlContext accessContext = prototype instanceof RhinoTopLevel ? ((RhinoTopLevel) prototype).getAccessContext() : null;
                return accessContext != null ? AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: com.sun.script.javascript.RhinoScriptEngine.1.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        return superDoTopCall(callable, context, scriptable, scriptable2, objArr);
                    }
                }, accessContext) : superDoTopCall(callable, context, scriptable, scriptable2, objArr);
            }

            @Override // org.mozilla.javascript.ContextFactory
            public Context makeContext() {
                Context contextMakeContext = super.makeContext();
                contextMakeContext.setLanguageVersion(RhinoScriptEngine.languageVersion);
                contextMakeContext.setOptimizationLevel(RhinoScriptEngine.optimizationLevel);
                contextMakeContext.setClassShutter(RhinoClassShutter.getInstance());
                contextMakeContext.setWrapFactory(RhinoWrapFactory.getInstance());
                return contextMakeContext;
            }
        });
    }

    public RhinoScriptEngine() {
        if (System.getSecurityManager() != null) {
            try {
                AccessController.checkPermission(new AllPermission());
            } catch (AccessControlException unused) {
                this.accCtxt = AccessController.getContext();
            }
        }
        try {
            this.topLevel = new RhinoTopLevel(enterContext(), this);
            Context.exit();
            this.indexedProps = new HashMap();
            this.implementor = new a(this) { // from class: com.sun.script.javascript.RhinoScriptEngine.2
                @Override // c.i.a.a.a
                public Object convertResult(Method method, Object obj) {
                    Class<?> returnType = method.getReturnType();
                    if (returnType == Void.TYPE) {
                        return null;
                    }
                    return Context.jsToJava(obj, returnType);
                }

                @Override // c.i.a.a.a
                public boolean isImplemented(Object obj, Class<?> cls) {
                    RhinoScriptEngine.enterContext();
                    if (obj != null) {
                        try {
                            if (!(obj instanceof Scriptable)) {
                                obj = Context.toObject(obj, RhinoScriptEngine.this.topLevel);
                            }
                        } finally {
                            Context.exit();
                        }
                    }
                    RhinoScriptEngine rhinoScriptEngine = RhinoScriptEngine.this;
                    Scriptable runtimeScope = rhinoScriptEngine.getRuntimeScope(rhinoScriptEngine.context);
                    if (obj != null) {
                        runtimeScope = (Scriptable) obj;
                    }
                    for (Method method : cls.getMethods()) {
                        if (method.getDeclaringClass() != Object.class && !(ScriptableObject.getProperty(runtimeScope, method.getName()) instanceof Function)) {
                            return false;
                        }
                    }
                    Context.exit();
                    return true;
                }
            };
        } catch (Throwable th) {
            Context.exit();
            throw th;
        }
    }

    public static Context enterContext() {
        return Context.enter();
    }

    private static int getLanguageVersion() {
        String str = (String) AccessController.doPrivileged(new l.a.a.a(RHINO_JS_VERSION));
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 180;
    }

    private static int getOptimizationLevel() {
        if (System.getSecurityManager() == null) {
            return Integer.getInteger(RHINO_OPT_LEVEL, -1).intValue();
        }
        return -1;
    }

    private Object invoke(Object obj, String str, Object... objArr) {
        Context contextEnterContext = enterContext();
        try {
            try {
                if (str == null) {
                    throw new NullPointerException("method name is null");
                }
                if (obj != null && !(obj instanceof Scriptable)) {
                    obj = Context.toObject(obj, this.topLevel);
                }
                Scriptable runtimeScope = getRuntimeScope(this.context);
                Scriptable scriptable = obj != null ? (Scriptable) obj : runtimeScope;
                Object property = ScriptableObject.getProperty(scriptable, str);
                if (!(property instanceof Function)) {
                    throw new NoSuchMethodException("no such method: " + str);
                }
                Function function = (Function) property;
                Scriptable parentScope = function.getParentScope();
                if (parentScope != null) {
                    runtimeScope = parentScope;
                }
                return unwrapReturnValue(function.call(contextEnterContext, runtimeScope, scriptable, wrapArguments(objArr)));
            } catch (RhinoException e2) {
                int iLineNumber = e2.lineNumber();
                if (iLineNumber == 0) {
                    iLineNumber = -1;
                }
                ScriptException scriptException = new ScriptException(e2.toString(), e2.sourceName(), iLineNumber);
                scriptException.initCause(e2);
                throw scriptException;
            }
        } finally {
            Context.exit();
        }
    }

    @Override // javax.script.Compilable
    public CompiledScript compile(String str) {
        return compile(new StringReader(str));
    }

    @Override // javax.script.ScriptEngine
    public Bindings createBindings() {
        return new SimpleBindings();
    }

    @Override // javax.script.ScriptEngine
    public Object eval(Reader reader, ScriptContext scriptContext) {
        Context contextEnterContext = enterContext();
        try {
            try {
                try {
                    Scriptable runtimeScope = getRuntimeScope(scriptContext);
                    String str = (String) get(ScriptEngine.FILENAME);
                    if (str == null) {
                        str = "<Unknown source>";
                    }
                    Object objEvaluateReader = contextEnterContext.evaluateReader(runtimeScope, reader, str, 1, null);
                    Context.exit();
                    return unwrapReturnValue(objEvaluateReader);
                } catch (IOException e2) {
                    throw new ScriptException(e2);
                }
            } catch (RhinoException e3) {
                int iLineNumber = e3.lineNumber();
                if (iLineNumber == 0) {
                    iLineNumber = -1;
                }
                ScriptException scriptException = new ScriptException(e3 instanceof JavaScriptException ? String.valueOf(((JavaScriptException) e3).getValue()) : e3.toString(), e3.sourceName(), iLineNumber);
                scriptException.initCause(e3);
                throw scriptException;
            }
        } catch (Throwable th) {
            Context.exit();
            throw th;
        }
    }

    public AccessControlContext getAccessContext() {
        return this.accCtxt;
    }

    @Override // javax.script.ScriptEngine
    public ScriptEngineFactory getFactory() {
        ScriptEngineFactory scriptEngineFactory = this.factory;
        return scriptEngineFactory != null ? scriptEngineFactory : new RhinoScriptEngineFactory();
    }

    @Override // javax.script.Invocable
    public <T> T getInterface(Class<T> cls) {
        try {
            return (T) this.implementor.getInterface(null, cls);
        } catch (ScriptException unused) {
            return null;
        }
    }

    public Scriptable getRuntimeScope(ScriptContext scriptContext) {
        Objects.requireNonNull(scriptContext, "null script context");
        Scriptable externalScriptable = new ExternalScriptable(scriptContext, this.indexedProps);
        externalScriptable.setPrototype(this.topLevel);
        externalScriptable.put(c.R, externalScriptable, scriptContext);
        try {
            enterContext().evaluateString(externalScriptable, printSource, "print", 1, null);
            return externalScriptable;
        } finally {
            Context.exit();
        }
    }

    @Override // javax.script.Invocable
    public Object invokeFunction(String str, Object... objArr) {
        return invoke(null, str, objArr);
    }

    @Override // javax.script.Invocable
    public Object invokeMethod(Object obj, String str, Object... objArr) {
        if (obj != null) {
            return invoke(obj, str, objArr);
        }
        throw new IllegalArgumentException("script object can not be null");
    }

    public void setEngineFactory(ScriptEngineFactory scriptEngineFactory) {
        this.factory = scriptEngineFactory;
    }

    public Object unwrapReturnValue(Object obj) {
        if (obj instanceof Wrapper) {
            obj = ((Wrapper) obj).unwrap();
        }
        if (obj instanceof Undefined) {
            return null;
        }
        return obj;
    }

    public Object[] wrapArguments(Object[] objArr) {
        if (objArr == null) {
            return Context.emptyArgs;
        }
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        for (int i2 = 0; i2 < length; i2++) {
            objArr2[i2] = Context.javaToJS(objArr[i2], this.topLevel);
        }
        return objArr2;
    }

    @Override // javax.script.Compilable
    public CompiledScript compile(Reader reader) {
        Context contextEnterContext = enterContext();
        try {
            try {
                String str = (String) get(ScriptEngine.FILENAME);
                if (str == null) {
                    str = "<Unknown Source>";
                }
                return new RhinoCompiledScript(this, contextEnterContext.compileReader(getRuntimeScope(this.context), reader, str, 1, null));
            } catch (Exception e2) {
                throw new ScriptException(e2);
            }
        } finally {
            Context.exit();
        }
    }

    @Override // javax.script.Invocable
    public <T> T getInterface(Object obj, Class<T> cls) {
        if (obj == null) {
            throw new IllegalArgumentException("script object can not be null");
        }
        try {
            return (T) this.implementor.getInterface(obj, cls);
        } catch (ScriptException unused) {
            return null;
        }
    }

    @Override // javax.script.ScriptEngine
    public Object eval(String str, ScriptContext scriptContext) {
        Objects.requireNonNull(str, "null script");
        return eval(new StringReader(str), scriptContext);
    }
}
