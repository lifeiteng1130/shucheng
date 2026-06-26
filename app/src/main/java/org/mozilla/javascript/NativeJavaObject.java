package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import org.mozilla.javascript.TopLevel;

/* JADX INFO: loaded from: classes3.dex */
public class NativeJavaObject implements Scriptable, SymbolScriptable, Wrapper, Serializable {
    private static final Object COERCED_INTERFACE_KEY = "Coerced Interface";
    public static final byte CONVERSION_NONE = 99;
    public static final byte CONVERSION_NONTRIVIAL = 0;
    public static final byte CONVERSION_TRIVIAL = 1;
    private static final int JSTYPE_BOOLEAN = 2;
    private static final int JSTYPE_JAVA_ARRAY = 7;
    private static final int JSTYPE_JAVA_CLASS = 5;
    private static final int JSTYPE_JAVA_OBJECT = 6;
    private static final int JSTYPE_NULL = 1;
    private static final int JSTYPE_NUMBER = 3;
    private static final int JSTYPE_OBJECT = 8;
    private static final int JSTYPE_STRING = 4;
    private static final int JSTYPE_UNDEFINED = 0;
    private static Method adapter_readAdapterObject = null;
    private static Method adapter_writeAdapterObject = null;
    private static final long serialVersionUID = -6948590651130498591L;
    private transient Map<String, FieldAndMethods> fieldAndMethods;
    public transient boolean isAdapter;
    public transient Object javaObject;
    public transient JavaMembers members;
    public Scriptable parent;
    public Scriptable prototype;
    public transient Class<?> staticType;

    static {
        Class<?>[] clsArr = new Class[2];
        Class<?> clsClassOrNull = Kit.classOrNull("org.mozilla.javascript.JavaAdapter");
        if (clsClassOrNull != null) {
            try {
                clsArr[0] = ScriptRuntime.ObjectClass;
                clsArr[1] = Kit.classOrNull("java.io.ObjectOutputStream");
                adapter_writeAdapterObject = clsClassOrNull.getMethod("writeAdapterObject", clsArr);
                clsArr[0] = ScriptRuntime.ScriptableClass;
                clsArr[1] = Kit.classOrNull("java.io.ObjectInputStream");
                adapter_readAdapterObject = clsClassOrNull.getMethod("readAdapterObject", clsArr);
            } catch (NoSuchMethodException unused) {
                adapter_writeAdapterObject = null;
                adapter_readAdapterObject = null;
            }
        }
    }

    public NativeJavaObject() {
    }

    public static boolean canConvert(Object obj, Class<?> cls) {
        return getConversionWeight(obj, cls) < 99;
    }

    private static Object coerceToNumber(Class<?> cls, Object obj) {
        Class<?> cls2 = obj.getClass();
        if (cls == Character.TYPE || cls == ScriptRuntime.CharacterClass) {
            return cls2 == ScriptRuntime.CharacterClass ? obj : Character.valueOf((char) toInteger(obj, r1, 0.0d, 65535.0d));
        }
        if (cls == ScriptRuntime.ObjectClass || cls == ScriptRuntime.DoubleClass || cls == Double.TYPE) {
            return cls2 == ScriptRuntime.DoubleClass ? obj : Double.valueOf(toDouble(obj));
        }
        Class<?> cls3 = ScriptRuntime.FloatClass;
        if (cls == cls3 || cls == Float.TYPE) {
            if (cls2 == cls3) {
                return obj;
            }
            double d2 = toDouble(obj);
            if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 == 0.0d) {
                return Float.valueOf((float) d2);
            }
            double dAbs = Math.abs(d2);
            if (dAbs < 1.401298464324817E-45d) {
                return Float.valueOf(d2 > 0.0d ? 0.0f : -0.0f);
            }
            if (dAbs > 3.4028234663852886E38d) {
                return Float.valueOf(d2 > 0.0d ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY);
            }
            return Float.valueOf((float) d2);
        }
        Class<?> cls4 = ScriptRuntime.IntegerClass;
        if (cls == cls4 || cls == Integer.TYPE) {
            return cls2 == cls4 ? obj : Integer.valueOf((int) toInteger(obj, cls4, -2.147483648E9d, 2.147483647E9d));
        }
        Class<?> cls5 = ScriptRuntime.LongClass;
        if (cls == cls5 || cls == Long.TYPE) {
            if (cls2 == cls5) {
                return obj;
            }
            return Long.valueOf(toInteger(obj, cls5, Double.longBitsToDouble(-4332462841530417152L), Double.longBitsToDouble(4890909195324358655L)));
        }
        Class<?> cls6 = ScriptRuntime.ShortClass;
        if (cls == cls6 || cls == Short.TYPE) {
            return cls2 == cls6 ? obj : Short.valueOf((short) toInteger(obj, cls6, -32768.0d, 32767.0d));
        }
        Class<?> cls7 = ScriptRuntime.ByteClass;
        return (cls == cls7 || cls == Byte.TYPE) ? cls2 == cls7 ? obj : Byte.valueOf((byte) toInteger(obj, cls7, -128.0d, 127.0d)) : Double.valueOf(toDouble(obj));
    }

    @Deprecated
    public static Object coerceType(Class<?> cls, Object obj) {
        return coerceTypeImpl(cls, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Object coerceTypeImpl(Class<?> cls, Object obj) {
        if (obj != null && obj.getClass() == cls) {
            return obj;
        }
        switch (getJSTypeCode(obj)) {
            case 0:
                if (cls == ScriptRuntime.StringClass || cls == ScriptRuntime.ObjectClass) {
                    return "undefined";
                }
                reportConversionError("undefined", cls);
                return obj;
            case 1:
                if (!cls.isPrimitive()) {
                    return null;
                }
                reportConversionError(obj, cls);
                return null;
            case 2:
                if (cls == Boolean.TYPE || cls == ScriptRuntime.BooleanClass || cls == ScriptRuntime.ObjectClass) {
                    return obj;
                }
                if (cls == ScriptRuntime.StringClass) {
                    return obj.toString();
                }
                reportConversionError(obj, cls);
                return obj;
            case 3:
                if (cls == ScriptRuntime.StringClass) {
                    return ScriptRuntime.toString(obj);
                }
                if (cls == ScriptRuntime.ObjectClass) {
                    Context currentContext = Context.getCurrentContext();
                    return (currentContext != null && currentContext.hasFeature(18) && ((double) Math.round(toDouble(obj))) == toDouble(obj)) ? coerceToNumber(Long.TYPE, obj) : coerceToNumber(Double.TYPE, obj);
                }
                if ((cls.isPrimitive() && cls != Boolean.TYPE) || ScriptRuntime.NumberClass.isAssignableFrom(cls)) {
                    return coerceToNumber(cls, obj);
                }
                reportConversionError(obj, cls);
                return obj;
            case 4:
                if (cls == ScriptRuntime.StringClass || cls.isInstance(obj)) {
                    return obj.toString();
                }
                if (cls == Character.TYPE || cls == ScriptRuntime.CharacterClass) {
                    CharSequence charSequence = (CharSequence) obj;
                    return charSequence.length() == 1 ? Character.valueOf(charSequence.charAt(0)) : coerceToNumber(cls, obj);
                }
                if ((cls.isPrimitive() && cls != Boolean.TYPE) || ScriptRuntime.NumberClass.isAssignableFrom(cls)) {
                    return coerceToNumber(cls, obj);
                }
                reportConversionError(obj, cls);
                return obj;
            case 5:
                if (obj instanceof Wrapper) {
                    obj = ((Wrapper) obj).unwrap();
                }
                if (cls == ScriptRuntime.ClassClass || cls == ScriptRuntime.ObjectClass) {
                    return obj;
                }
                if (cls == ScriptRuntime.StringClass) {
                    return obj.toString();
                }
                reportConversionError(obj, cls);
                return obj;
            case 6:
            case 7:
                if (obj instanceof Wrapper) {
                    obj = ((Wrapper) obj).unwrap();
                }
                if (cls.isPrimitive()) {
                    if (cls == Boolean.TYPE) {
                        reportConversionError(obj, cls);
                    }
                    return coerceToNumber(cls, obj);
                }
                if (cls == ScriptRuntime.StringClass) {
                    return obj.toString();
                }
                if (cls.isInstance(obj)) {
                    return obj;
                }
                reportConversionError(obj, cls);
                return obj;
            case 8:
                if (cls == ScriptRuntime.StringClass) {
                    return ScriptRuntime.toString(obj);
                }
                if (cls.isPrimitive()) {
                    if (cls == Boolean.TYPE) {
                        reportConversionError(obj, cls);
                    }
                    return coerceToNumber(cls, obj);
                }
                if (cls.isInstance(obj)) {
                    return obj;
                }
                if (cls == ScriptRuntime.DateClass && (obj instanceof NativeDate)) {
                    return new Date((long) ((NativeDate) obj).getJSTimeValue());
                }
                if (cls.isArray() && (obj instanceof NativeArray)) {
                    NativeArray nativeArray = (NativeArray) obj;
                    long length = nativeArray.getLength();
                    Class<?> componentType = cls.getComponentType();
                    Object objNewInstance = Array.newInstance(componentType, (int) length);
                    for (int i2 = 0; i2 < length; i2++) {
                        try {
                            Array.set(objNewInstance, i2, coerceTypeImpl(componentType, nativeArray.get(i2, nativeArray)));
                        } catch (EvaluatorException unused) {
                            reportConversionError(obj, cls);
                        }
                    }
                    return objNewInstance;
                }
                if (obj instanceof Wrapper) {
                    obj = ((Wrapper) obj).unwrap();
                    if (cls.isInstance(obj)) {
                        return obj;
                    }
                    reportConversionError(obj, cls);
                } else {
                    if (cls.isInterface() && ((obj instanceof NativeObject) || (obj instanceof NativeFunction) || (obj instanceof ArrowFunction))) {
                        return createInterfaceAdapter(cls, (ScriptableObject) obj);
                    }
                    reportConversionError(obj, cls);
                }
                return obj;
            default:
                return obj;
        }
    }

    public static Object createInterfaceAdapter(Class<?> cls, ScriptableObject scriptableObject) {
        Object objMakeHashKeyFromPair = Kit.makeHashKeyFromPair(COERCED_INTERFACE_KEY, cls);
        Object associatedValue = scriptableObject.getAssociatedValue(objMakeHashKeyFromPair);
        return associatedValue != null ? associatedValue : scriptableObject.associateValue(objMakeHashKeyFromPair, InterfaceAdapter.create(Context.getContext(), cls, scriptableObject));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0100 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0100 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getConversionWeight(java.lang.Object r7, java.lang.Class<?> r8) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJavaObject.getConversionWeight(java.lang.Object, java.lang.Class):int");
    }

    private static int getJSTypeCode(Object obj) {
        if (obj == null) {
            return 1;
        }
        if (obj == Undefined.instance) {
            return 0;
        }
        if (obj instanceof CharSequence) {
            return 4;
        }
        if (obj instanceof Number) {
            return 3;
        }
        if (obj instanceof Boolean) {
            return 2;
        }
        if (!(obj instanceof Scriptable)) {
            if (obj instanceof Class) {
                return 5;
            }
            return obj.getClass().isArray() ? 7 : 6;
        }
        if (obj instanceof NativeJavaClass) {
            return 5;
        }
        if (obj instanceof NativeJavaArray) {
            return 7;
        }
        return obj instanceof Wrapper ? 6 : 8;
    }

    public static int getSizeRank(Class<?> cls) {
        if (cls == Double.TYPE) {
            return 1;
        }
        if (cls == Float.TYPE) {
            return 2;
        }
        if (cls == Long.TYPE) {
            return 3;
        }
        if (cls == Integer.TYPE) {
            return 4;
        }
        if (cls == Short.TYPE) {
            return 5;
        }
        if (cls == Character.TYPE) {
            return 6;
        }
        if (cls == Byte.TYPE) {
            return 7;
        }
        return cls == Boolean.TYPE ? 99 : 8;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        boolean z = objectInputStream.readBoolean();
        this.isAdapter = z;
        if (z) {
            Method method = adapter_readAdapterObject;
            if (method == null) {
                throw new ClassNotFoundException();
            }
            try {
                this.javaObject = method.invoke(null, this, objectInputStream);
            } catch (Exception unused) {
                throw new IOException();
            }
        } else {
            this.javaObject = objectInputStream.readObject();
        }
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.staticType = Class.forName(str);
        } else {
            this.staticType = null;
        }
        initMembers();
    }

    public static void reportConversionError(Object obj, Class<?> cls) {
        throw Context.reportRuntimeError2("msg.conversion.not.allowed", String.valueOf(obj), JavaMembers.javaSignature(cls));
    }

    private static double toDouble(Object obj) {
        Method method;
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        if (obj instanceof String) {
            return ScriptRuntime.toNumber((String) obj);
        }
        if (obj instanceof Scriptable) {
            return obj instanceof Wrapper ? toDouble(((Wrapper) obj).unwrap()) : ScriptRuntime.toNumber(obj);
        }
        try {
            method = obj.getClass().getMethod("doubleValue", null);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null) {
            try {
                return ((Number) method.invoke(obj, null)).doubleValue();
            } catch (IllegalAccessException unused2) {
                reportConversionError(obj, Double.TYPE);
            } catch (InvocationTargetException unused3) {
                reportConversionError(obj, Double.TYPE);
            }
        }
        return ScriptRuntime.toNumber(obj.toString());
    }

    private static long toInteger(Object obj, Class<?> cls, double d2, double d3) {
        double d4 = toDouble(obj);
        if (Double.isInfinite(d4) || Double.isNaN(d4)) {
            reportConversionError(ScriptRuntime.toString(obj), cls);
        }
        double dFloor = d4 > 0.0d ? Math.floor(d4) : Math.ceil(d4);
        if (dFloor < d2 || dFloor > d3) {
            reportConversionError(ScriptRuntime.toString(obj), cls);
        }
        return (long) dFloor;
    }

    @Deprecated
    public static Object wrap(Scriptable scriptable, Object obj, Class<?> cls) {
        Context context = Context.getContext();
        return context.getWrapFactory().wrap(context, scriptable, obj, cls);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeBoolean(this.isAdapter);
        if (this.isAdapter) {
            Method method = adapter_writeAdapterObject;
            if (method == null) {
                throw new IOException();
            }
            try {
                method.invoke(null, this.javaObject, objectOutputStream);
            } catch (Exception unused) {
                throw new IOException();
            }
        } else {
            objectOutputStream.writeObject(this.javaObject);
        }
        Class<?> cls = this.staticType;
        if (cls != null) {
            objectOutputStream.writeObject(cls.getName());
        } else {
            objectOutputStream.writeObject(null);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i2) {
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(String str) {
    }

    public void delete(Symbol symbol) {
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        FieldAndMethods fieldAndMethods;
        Map<String, FieldAndMethods> map = this.fieldAndMethods;
        return (map == null || (fieldAndMethods = map.get(str)) == null) ? this.members.get(this, str, this.javaObject, false) : fieldAndMethods;
    }

    @Override // org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaObject";
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        String str;
        if (cls == null) {
            Object obj = this.javaObject;
            if (obj instanceof Boolean) {
                cls = ScriptRuntime.BooleanClass;
            }
            if (obj instanceof Number) {
                cls = ScriptRuntime.NumberClass;
            }
        }
        if (cls == null || cls == ScriptRuntime.StringClass) {
            return this.javaObject.toString();
        }
        if (cls == ScriptRuntime.BooleanClass) {
            str = "booleanValue";
        } else {
            if (cls != ScriptRuntime.NumberClass) {
                throw Context.reportRuntimeError0("msg.default.value");
            }
            str = "doubleValue";
        }
        Object obj2 = get(str, this);
        if (obj2 instanceof Function) {
            Function function = (Function) obj2;
            return function.call(Context.getContext(), function.getParentScope(), this, ScriptRuntime.emptyArgs);
        }
        if (cls == ScriptRuntime.NumberClass) {
            Object obj3 = this.javaObject;
            if (obj3 instanceof Boolean) {
                return ((Boolean) obj3).booleanValue() ? ScriptRuntime.wrapNumber(1.0d) : ScriptRuntime.zeroObj;
            }
        }
        return this.javaObject.toString();
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return this.members.getIds(false);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getParentScope() {
        return this.parent;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        Scriptable scriptable = this.prototype;
        return (scriptable == null && (this.javaObject instanceof String)) ? TopLevel.getBuiltinPrototype(ScriptableObject.getTopLevelScope(this.parent), TopLevel.Builtins.String) : scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(int i2, Scriptable scriptable) {
        return false;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return this.members.has(str, false);
    }

    public boolean has(Symbol symbol, Scriptable scriptable) {
        return false;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        return false;
    }

    public void initMembers() {
        Object obj = this.javaObject;
        JavaMembers javaMembersLookupClass = JavaMembers.lookupClass(this.parent, obj != null ? obj.getClass() : this.staticType, this.staticType, this.isAdapter);
        this.members = javaMembersLookupClass;
        this.fieldAndMethods = javaMembersLookupClass.getFieldAndMethodsObjects(this, this.javaObject, false);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (this.prototype == null || this.members.has(str, false)) {
            this.members.put(this, str, this.javaObject, obj, false);
        } else {
            Scriptable scriptable2 = this.prototype;
            scriptable2.put(str, scriptable2, obj);
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

    public Object unwrap() {
        return this.javaObject;
    }

    public NativeJavaObject(Scriptable scriptable, Object obj, Class<?> cls) {
        this(scriptable, obj, cls, false);
    }

    public NativeJavaObject(Scriptable scriptable, Object obj, Class<?> cls, boolean z) {
        this.parent = scriptable;
        this.javaObject = obj;
        this.staticType = cls;
        this.isAdapter = z;
        initMembers();
    }

    public Object get(Symbol symbol, Scriptable scriptable) {
        return Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.SymbolScriptable
    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        String string = symbol.toString();
        if (this.prototype != null && !this.members.has(string, false)) {
            Scriptable scriptable2 = this.prototype;
            if (scriptable2 instanceof SymbolScriptable) {
                ((SymbolScriptable) scriptable2).put(symbol, scriptable2, obj);
                return;
            }
            return;
        }
        this.members.put(this, string, this.javaObject, obj, false);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(int i2, Scriptable scriptable) {
        throw this.members.reportMemberNotFound(Integer.toString(i2));
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(int i2, Scriptable scriptable, Object obj) {
        throw this.members.reportMemberNotFound(Integer.toString(i2));
    }
}
