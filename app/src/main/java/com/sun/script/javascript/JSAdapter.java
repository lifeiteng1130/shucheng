package com.sun.script.javascript;

import java.util.Objects;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeJavaArray;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: loaded from: classes.dex */
public final class JSAdapter implements Scriptable, Function {
    private static final String DEL_PROP = "__delete__";
    private static final String GET_PROP = "__get__";
    private static final String GET_PROPIDS = "__getIds__";
    private static final String HAS_PROP = "__has__";
    private static final String PUT_PROP = "__put__";
    private Scriptable adaptee;
    private boolean isPrototype;
    private Scriptable parent;
    private Scriptable prototype;

    private JSAdapter(Scriptable scriptable) {
        setAdaptee(scriptable);
    }

    private Function getAdapteeFunction(String str) {
        Object property = ScriptableObject.getProperty(getAdaptee(), str);
        if (property instanceof Function) {
            return (Function) property;
        }
        return null;
    }

    private static Scriptable getFunctionPrototype(Scriptable scriptable) {
        return ScriptableObject.getFunctionPrototype(scriptable);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        JSAdapter jSAdapter = new JSAdapter(context.newObject(scriptable));
        jSAdapter.setParentScope(scriptable);
        jSAdapter.setPrototype(getFunctionPrototype(scriptable));
        jSAdapter.isPrototype = true;
        ScriptableObject.defineProperty(scriptable, "JSAdapter", jSAdapter, 2);
    }

    private Object mapToId(Object obj) {
        return obj instanceof Double ? new Integer(((Double) obj).intValue()) : Context.toString(obj);
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (this.isPrototype) {
            return construct(context, scriptable, objArr);
        }
        Scriptable adaptee = getAdaptee();
        if (adaptee instanceof Function) {
            return ((Function) adaptee).call(context, scriptable, adaptee, objArr);
        }
        throw Context.reportRuntimeError("TypeError: not a function");
    }

    @Override // org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        if (this.isPrototype) {
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
            if (objArr.length > 0) {
                return new JSAdapter(Context.toObject(objArr[0], topLevelScope));
            }
            throw Context.reportRuntimeError("JSAdapter requires adaptee");
        }
        Scriptable adaptee = getAdaptee();
        if (adaptee instanceof Function) {
            return ((Function) adaptee).construct(context, scriptable, objArr);
        }
        throw Context.reportRuntimeError("TypeError: not a constructor");
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(String str) {
        Function adapteeFunction = getAdapteeFunction(DEL_PROP);
        if (adapteeFunction != null) {
            call(adapteeFunction, new Object[]{str});
        } else {
            getAdaptee().delete(str);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        Function adapteeFunction = getAdapteeFunction(GET_PROP);
        if (adapteeFunction != null) {
            return call(adapteeFunction, new Object[]{str});
        }
        Scriptable adaptee = getAdaptee();
        return adaptee.get(str, adaptee);
    }

    public Scriptable getAdaptee() {
        return this.adaptee;
    }

    @Override // org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JSAdapter";
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class cls) {
        return getAdaptee().getDefaultValue(cls);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        Function adapteeFunction = getAdapteeFunction(GET_PROPIDS);
        if (adapteeFunction == null) {
            return getAdaptee().getIds();
        }
        int i2 = 0;
        Object objCall = call(adapteeFunction, new Object[0]);
        if (objCall instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) objCall;
            int length = (int) nativeArray.getLength();
            Object[] objArr = new Object[length];
            while (i2 < length) {
                objArr[i2] = mapToId(nativeArray.get(i2, nativeArray));
                i2++;
            }
            return objArr;
        }
        if (!(objCall instanceof NativeJavaArray)) {
            return Context.emptyArgs;
        }
        Object objUnwrap = ((NativeJavaArray) objCall).unwrap();
        if (objUnwrap.getClass() != Object[].class) {
            return Context.emptyArgs;
        }
        Object[] objArr2 = (Object[]) objUnwrap;
        Object[] objArr3 = new Object[objArr2.length];
        while (i2 < objArr2.length) {
            objArr3[i2] = mapToId(objArr2[i2]);
            i2++;
        }
        return objArr3;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getParentScope() {
        return this.parent;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        return this.prototype;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        Function adapteeFunction = getAdapteeFunction(HAS_PROP);
        if (adapteeFunction != null) {
            return Context.toBoolean(call(adapteeFunction, new Object[]{str}));
        }
        Scriptable adaptee = getAdaptee();
        return adaptee.has(str, adaptee);
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        if (scriptable instanceof JSAdapter) {
            return true;
        }
        for (Scriptable prototype = scriptable.getPrototype(); prototype != null; prototype = prototype.getPrototype()) {
            if (prototype.equals(this)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (scriptable != this) {
            scriptable.put(str, scriptable, obj);
            return;
        }
        Function adapteeFunction = getAdapteeFunction(PUT_PROP);
        if (adapteeFunction != null) {
            call(adapteeFunction, new Object[]{str, obj});
        } else {
            Scriptable adaptee = getAdaptee();
            adaptee.put(str, adaptee, obj);
        }
    }

    public void setAdaptee(Scriptable scriptable) {
        Objects.requireNonNull(scriptable, "adaptee can not be null");
        this.adaptee = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setParentScope(Scriptable scriptable) {
        this.parent = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setPrototype(Scriptable scriptable) {
        this.prototype = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i2) {
        Function adapteeFunction = getAdapteeFunction(DEL_PROP);
        if (adapteeFunction != null) {
            call(adapteeFunction, new Object[]{new Integer(i2)});
        } else {
            getAdaptee().delete(i2);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(int i2, Scriptable scriptable) {
        Function adapteeFunction = getAdapteeFunction(GET_PROP);
        if (adapteeFunction != null) {
            return call(adapteeFunction, new Object[]{new Integer(i2)});
        }
        Scriptable adaptee = getAdaptee();
        return adaptee.get(i2, adaptee);
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(int i2, Scriptable scriptable) {
        Function adapteeFunction = getAdapteeFunction(HAS_PROP);
        if (adapteeFunction != null) {
            return Context.toBoolean(call(adapteeFunction, new Object[]{new Integer(i2)}));
        }
        Scriptable adaptee = getAdaptee();
        return adaptee.has(i2, adaptee);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(int i2, Scriptable scriptable, Object obj) {
        if (scriptable == this) {
            Function adapteeFunction = getAdapteeFunction(PUT_PROP);
            if (adapteeFunction != null) {
                call(adapteeFunction, new Object[]{new Integer(i2), obj});
                return;
            } else {
                Scriptable adaptee = getAdaptee();
                adaptee.put(i2, adaptee, obj);
                return;
            }
        }
        scriptable.put(i2, scriptable, obj);
    }

    private Object call(Function function, Object[] objArr) {
        try {
            return function.call(Context.getCurrentContext(), function.getParentScope(), getAdaptee(), objArr);
        } catch (RhinoException e2) {
            throw Context.reportRuntimeError(e2.getMessage());
        }
    }
}
