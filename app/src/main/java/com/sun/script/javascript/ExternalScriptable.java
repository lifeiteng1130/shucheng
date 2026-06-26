package com.sun.script.javascript;

import c.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.script.Bindings;
import javax.script.ScriptContext;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeJavaClass;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Wrapper;

/* JADX INFO: loaded from: classes.dex */
public final class ExternalScriptable implements Scriptable {
    private ScriptContext context;
    private Map<Object, Object> indexedProps;
    private Scriptable parent;
    private Scriptable prototype;

    public ExternalScriptable(ScriptContext scriptContext) {
        this(scriptContext, new HashMap());
    }

    private String[] getAllKeys() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.context) {
            Iterator<Integer> it = this.context.getScopes().iterator();
            while (it.hasNext()) {
                Bindings bindings = this.context.getBindings(it.next().intValue());
                if (bindings != null) {
                    arrayList.ensureCapacity(bindings.size());
                    Iterator<String> it2 = bindings.keySet().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                    }
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    private boolean isEmpty(String str) {
        return str.equals("");
    }

    private Object jsToJava(Object obj) {
        boolean z = obj instanceof Wrapper;
        Object obj2 = obj;
        if (z) {
            Wrapper wrapper = (Wrapper) obj;
            if (wrapper instanceof NativeJavaClass) {
                return wrapper;
            }
            Object objUnwrap = wrapper.unwrap();
            obj2 = wrapper;
            if (!(objUnwrap instanceof Number)) {
                obj2 = wrapper;
                if (!(objUnwrap instanceof String)) {
                    obj2 = wrapper;
                    if (!(objUnwrap instanceof Boolean)) {
                        obj2 = wrapper;
                        if (!(objUnwrap instanceof Character)) {
                            return objUnwrap;
                        }
                    }
                }
            }
        }
        return obj2;
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized void delete(String str) {
        if (isEmpty(str)) {
            this.indexedProps.remove(str);
        } else {
            synchronized (this.context) {
                int attributesScope = this.context.getAttributesScope(str);
                if (attributesScope != -1) {
                    this.context.removeAttribute(str, attributesScope);
                }
            }
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized Object get(String str, Scriptable scriptable) {
        if (isEmpty(str)) {
            if (this.indexedProps.containsKey(str)) {
                return this.indexedProps.get(str);
            }
            return Scriptable.NOT_FOUND;
        }
        synchronized (this.context) {
            int attributesScope = this.context.getAttributesScope(str);
            if (attributesScope != -1) {
                return Context.javaToJS(this.context.getAttribute(str, attributesScope), this);
            }
            return Scriptable.NOT_FOUND;
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Global";
    }

    public ScriptContext getContext() {
        return this.context;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class cls) {
        String str;
        String str2;
        Object[] objArr;
        Object objCall;
        int i2 = 0;
        while (true) {
            str = "undefined";
            if (i2 >= 2) {
                throw Context.reportRuntimeError("Cannot find default value for object " + (cls != null ? cls.getName() : "undefined"));
            }
            Class<?> cls2 = ScriptRuntime.StringClass;
            boolean z = cls != cls2 ? i2 == 1 : i2 == 0;
            if (z) {
                objArr = ScriptRuntime.emptyArgs;
                str2 = "toString";
            } else {
                Object[] objArr2 = new Object[1];
                if (cls != null) {
                    if (cls == cls2) {
                        str = "string";
                    } else if (cls == ScriptRuntime.ScriptableClass) {
                        str = "object";
                    } else if (cls == ScriptRuntime.FunctionClass) {
                        str = "function";
                    } else if (cls == ScriptRuntime.BooleanClass || cls == Boolean.TYPE) {
                        str = "boolean";
                    } else {
                        if (cls != ScriptRuntime.NumberClass && cls != ScriptRuntime.ByteClass && cls != Byte.TYPE && cls != ScriptRuntime.ShortClass && cls != Short.TYPE && cls != ScriptRuntime.IntegerClass && cls != Integer.TYPE && cls != ScriptRuntime.FloatClass && cls != Float.TYPE && cls != ScriptRuntime.DoubleClass && cls != Double.TYPE) {
                            StringBuilder sbR = a.r("Invalid JavaScript value of type ");
                            sbR.append(cls.toString());
                            throw Context.reportRuntimeError(sbR.toString());
                        }
                        str = "number";
                    }
                }
                objArr2[0] = str;
                str2 = "valueOf";
                objArr = objArr2;
            }
            Object property = ScriptableObject.getProperty(this, str2);
            if (property instanceof Function) {
                Function function = (Function) property;
                try {
                    objCall = function.call(RhinoScriptEngine.enterContext(), function.getParentScope(), this, objArr);
                    if (objCall == null) {
                        continue;
                    } else {
                        if (!(objCall instanceof Scriptable)) {
                            return objCall;
                        }
                        if (cls == ScriptRuntime.ScriptableClass || cls == ScriptRuntime.FunctionClass) {
                            break;
                        }
                        if (z && (objCall instanceof Wrapper)) {
                            objCall = ((Wrapper) objCall).unwrap();
                            if (objCall instanceof String) {
                                break;
                            }
                        }
                    }
                } finally {
                    Context.exit();
                }
            }
            i2++;
        }
        return objCall;
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized Object[] getIds() {
        Object[] objArr;
        String[] allKeys = getAllKeys();
        objArr = new Object[allKeys.length + this.indexedProps.size()];
        System.arraycopy(allKeys, 0, objArr, 0, allKeys.length);
        int length = allKeys.length;
        Iterator<Object> it = this.indexedProps.keySet().iterator();
        while (it.hasNext()) {
            int i2 = length + 1;
            objArr[length] = it.next();
            length = i2;
        }
        return objArr;
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
    public synchronized boolean has(String str, Scriptable scriptable) {
        boolean z;
        if (isEmpty(str)) {
            return this.indexedProps.containsKey(str);
        }
        synchronized (this.context) {
            z = this.context.getAttributesScope(str) != -1;
        }
        return z;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
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
        synchronized (this) {
            if (isEmpty(str)) {
                this.indexedProps.put(str, obj);
            } else {
                synchronized (this.context) {
                    int attributesScope = this.context.getAttributesScope(str);
                    if (attributesScope == -1) {
                        attributesScope = 100;
                    }
                    this.context.setAttribute(str, jsToJava(obj), attributesScope);
                }
            }
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setParentScope(Scriptable scriptable) {
        this.parent = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setPrototype(Scriptable scriptable) {
        this.prototype = scriptable;
    }

    public ExternalScriptable(ScriptContext scriptContext, Map<Object, Object> map) {
        Objects.requireNonNull(scriptContext, "context is null");
        this.context = scriptContext;
        this.indexedProps = map;
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized boolean has(int i2, Scriptable scriptable) {
        return this.indexedProps.containsKey(new Integer(i2));
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i2) {
        this.indexedProps.remove(new Integer(i2));
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized Object get(int i2, Scriptable scriptable) {
        Integer num = new Integer(i2);
        if (this.indexedProps.containsKey(Integer.valueOf(i2))) {
            return this.indexedProps.get(num);
        }
        return Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(int i2, Scriptable scriptable, Object obj) {
        if (scriptable == this) {
            synchronized (this) {
                this.indexedProps.put(new Integer(i2), obj);
            }
        } else {
            scriptable.put(i2, scriptable, obj);
        }
    }
}
