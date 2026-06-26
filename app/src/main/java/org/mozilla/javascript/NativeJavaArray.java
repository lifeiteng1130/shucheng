package org.mozilla.javascript;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public class NativeJavaArray extends NativeJavaObject implements SymbolScriptable {
    private static final long serialVersionUID = -924022554283675333L;
    public Object array;
    public Class<?> cls;
    public int length;

    public NativeJavaArray(Scriptable scriptable, Object obj) {
        super(scriptable, null, ScriptRuntime.ObjectClass);
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            throw new RuntimeException("Array expected");
        }
        this.array = obj;
        this.length = Array.getLength(obj);
        this.cls = cls.getComponentType();
    }

    public static NativeJavaArray wrap(Scriptable scriptable, Object obj) {
        return new NativeJavaArray(scriptable, obj);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.SymbolScriptable
    public void delete(Symbol symbol) {
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        if (str.equals("length")) {
            return Integer.valueOf(this.length);
        }
        Object obj = super.get(str, scriptable);
        if (obj != Scriptable.NOT_FOUND || ScriptableObject.hasProperty(getPrototype(), str)) {
            return obj;
        }
        throw Context.reportRuntimeError2("msg.java.member.not.found", this.array.getClass().getName(), str);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaArray";
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return (cls == null || cls == ScriptRuntime.StringClass) ? this.array.toString() : cls == ScriptRuntime.BooleanClass ? Boolean.TRUE : cls == ScriptRuntime.NumberClass ? ScriptRuntime.NaNobj : this;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        int i2 = this.length;
        Object[] objArr = new Object[i2];
        while (true) {
            i2--;
            if (i2 < 0) {
                return objArr;
            }
            objArr[i2] = Integer.valueOf(i2);
        }
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        if (this.prototype == null) {
            this.prototype = ScriptableObject.getArrayPrototype(getParentScope());
        }
        return this.prototype;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return str.equals("length") || super.has(str, scriptable);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        if (!(scriptable instanceof Wrapper)) {
            return false;
        }
        return this.cls.isInstance(((Wrapper) scriptable).unwrap());
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (!str.equals("length")) {
            throw Context.reportRuntimeError1("msg.java.array.member.not.found", str);
        }
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Wrapper
    public Object unwrap() {
        return this.array;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(int i2, Scriptable scriptable) {
        return i2 >= 0 && i2 < this.length;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.SymbolScriptable
    public boolean has(Symbol symbol, Scriptable scriptable) {
        return SymbolKey.IS_CONCAT_SPREADABLE.equals(symbol);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(int i2, Scriptable scriptable, Object obj) {
        if (i2 >= 0 && i2 < this.length) {
            Array.set(this.array, i2, Context.jsToJava(obj, this.cls));
            return;
        }
        throw Context.reportRuntimeError2("msg.java.array.index.out.of.bounds", String.valueOf(i2), String.valueOf(this.length - 1));
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(int i2, Scriptable scriptable) {
        if (i2 >= 0 && i2 < this.length) {
            Context context = Context.getContext();
            return context.getWrapFactory().wrap(context, this, Array.get(this.array, i2), this.cls);
        }
        return Undefined.instance;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.SymbolScriptable
    public Object get(Symbol symbol, Scriptable scriptable) {
        if (SymbolKey.IS_CONCAT_SPREADABLE.equals(symbol)) {
            return Boolean.TRUE;
        }
        return Scriptable.NOT_FOUND;
    }
}
