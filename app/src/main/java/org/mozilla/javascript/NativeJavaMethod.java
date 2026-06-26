package org.mozilla.javascript;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class NativeJavaMethod extends BaseFunction {
    private static final int PREFERENCE_AMBIGUOUS = 3;
    private static final int PREFERENCE_EQUAL = 0;
    private static final int PREFERENCE_FIRST_ARG = 1;
    private static final int PREFERENCE_SECOND_ARG = 2;
    private static final boolean debug = false;
    private static final long serialVersionUID = -3440381785576412928L;
    private String functionName;
    public MemberBox[] methods;
    private final transient CopyOnWriteArrayList<ResolvedOverload> overloadCache;

    public NativeJavaMethod(MemberBox[] memberBoxArr) {
        this.overloadCache = new CopyOnWriteArrayList<>();
        this.functionName = memberBoxArr[0].getName();
        this.methods = memberBoxArr;
    }

    public static int findFunction(Context context, MemberBox[] memberBoxArr, Object[] objArr) {
        int i2 = -1;
        if (memberBoxArr.length == 0) {
            return -1;
        }
        if (memberBoxArr.length == 1) {
            MemberBox memberBox = memberBoxArr[0];
            Class<?>[] clsArr = memberBox.argTypes;
            int length = clsArr.length;
            if (memberBox.vararg) {
                length--;
                if (length > objArr.length) {
                    return -1;
                }
            } else if (length != objArr.length) {
                return -1;
            }
            for (int i3 = 0; i3 != length; i3++) {
                if (!NativeJavaObject.canConvert(objArr[i3], clsArr[i3])) {
                    return -1;
                }
            }
            return 0;
        }
        int[] iArr = null;
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        while (i4 < memberBoxArr.length) {
            MemberBox memberBox2 = memberBoxArr[i4];
            Class<?>[] clsArr2 = memberBox2.argTypes;
            int length2 = clsArr2.length;
            if (!memberBox2.vararg ? length2 == objArr.length : length2 - 1 <= objArr.length) {
                break;
            }
            for (int i7 = 0; i7 < length2; i7++) {
                if (!NativeJavaObject.canConvert(objArr[i7], clsArr2[i7])) {
                    break;
                }
            }
            if (i5 >= 0) {
                int i8 = -1;
                int i9 = 0;
                int i10 = 0;
                while (i8 != i6) {
                    MemberBox memberBox3 = memberBoxArr[i8 == i2 ? i5 : iArr[i8]];
                    if (!context.hasFeature(13) || memberBox3.isPublic() == memberBox2.isPublic()) {
                        int iPreferSignature = preferSignature(objArr, clsArr2, memberBox2.vararg, memberBox3.argTypes, memberBox3.vararg);
                        if (iPreferSignature == 3) {
                            break;
                        }
                        if (iPreferSignature != 1) {
                            if (iPreferSignature != 2) {
                                if (iPreferSignature != 0) {
                                    Kit.codeBug();
                                }
                                if (memberBox3.isStatic() && memberBox3.getDeclaringClass().isAssignableFrom(memberBox2.getDeclaringClass())) {
                                    if (i8 != -1) {
                                        iArr[i8] = i4;
                                    }
                                }
                            }
                            i10++;
                        }
                        i9++;
                    } else if (memberBox3.isPublic()) {
                        i10++;
                    } else {
                        i9++;
                    }
                    i8++;
                    i2 = -1;
                }
                int i11 = i6 + 1;
                if (i9 == i11) {
                    i5 = i4;
                    i6 = 0;
                } else if (i10 != i11) {
                    if (iArr == null) {
                        iArr = new int[memberBoxArr.length - 1];
                    }
                    iArr[i6] = i4;
                    i6 = i11;
                }
            }
            i5 = i4;
            i4++;
            i2 = -1;
        }
        if (i5 < 0) {
            return -1;
        }
        if (i6 == 0) {
            return i5;
        }
        StringBuilder sb = new StringBuilder();
        int i12 = -1;
        while (i12 != i6) {
            int i13 = i12 == -1 ? i5 : iArr[i12];
            sb.append("\n    ");
            sb.append(memberBoxArr[i13].toJavaDeclaration());
            i12++;
        }
        MemberBox memberBox4 = memberBoxArr[i5];
        String name = memberBox4.getName();
        String name2 = memberBox4.getDeclaringClass().getName();
        if (memberBoxArr[0].isCtor()) {
            throw Context.reportRuntimeError3("msg.constructor.ambiguous", name, scriptSignature(objArr), sb.toString());
        }
        throw Context.reportRuntimeError4("msg.method.ambiguous", name2, name, scriptSignature(objArr), sb.toString());
    }

    private static int preferSignature(Object[] objArr, Class<?>[] clsArr, boolean z, Class<?>[] clsArr2, boolean z2) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length) {
            int i4 = 1;
            Class<?> cls = (!z || i2 < clsArr.length) ? clsArr[i2] : clsArr[clsArr.length - 1];
            Class<?> cls2 = (!z2 || i2 < clsArr2.length) ? clsArr2[i2] : clsArr2[clsArr2.length - 1];
            if (cls != cls2) {
                Object obj = objArr[i2];
                int conversionWeight = NativeJavaObject.getConversionWeight(obj, cls);
                int conversionWeight2 = NativeJavaObject.getConversionWeight(obj, cls2);
                if (conversionWeight >= conversionWeight2) {
                    if (conversionWeight <= conversionWeight2) {
                        if (conversionWeight == 0) {
                            if (!cls.isAssignableFrom(cls2)) {
                                if (!cls2.isAssignableFrom(cls)) {
                                }
                            }
                        }
                        i4 = 3;
                    }
                    i4 = 2;
                }
                i3 |= i4;
                if (i3 == 3) {
                    break;
                }
            }
            i2++;
        }
        return i3;
    }

    private static void printDebug(String str, MemberBox memberBox, Object[] objArr) {
    }

    public static String scriptSignature(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 != objArr.length; i2++) {
            Object obj = objArr[i2];
            String name = obj == null ? "null" : obj instanceof Boolean ? "boolean" : obj instanceof String ? "string" : obj instanceof Number ? "number" : obj instanceof Scriptable ? obj instanceof Undefined ? "undefined" : obj instanceof Wrapper ? ((Wrapper) obj).unwrap().getClass().getName() : obj instanceof Function ? "function" : "object" : JavaMembers.javaSignature(obj.getClass());
            if (i2 != 0) {
                sb.append(',');
            }
            sb.append(name);
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object[] objArr2;
        Object obj;
        Object objJsToJava;
        if (this.methods.length == 0) {
            throw new RuntimeException("No methods defined for call");
        }
        int iFindCachedFunction = findCachedFunction(context, objArr);
        int i2 = 0;
        if (iFindCachedFunction < 0) {
            throw Context.reportRuntimeError1("msg.java.no_such_method", this.methods[0].method().getDeclaringClass().getName() + '.' + getFunctionName() + '(' + scriptSignature(objArr) + ')');
        }
        MemberBox memberBox = this.methods[iFindCachedFunction];
        Class<?>[] clsArr = memberBox.argTypes;
        if (memberBox.vararg) {
            objArr2 = new Object[clsArr.length];
            for (int i3 = 0; i3 < clsArr.length - 1; i3++) {
                objArr2[i3] = Context.jsToJava(objArr[i3], clsArr[i3]);
            }
            if (objArr.length == clsArr.length && (objArr[objArr.length - 1] == null || (objArr[objArr.length - 1] instanceof NativeArray) || (objArr[objArr.length - 1] instanceof NativeJavaArray))) {
                objJsToJava = Context.jsToJava(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
            } else {
                Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
                Object objNewInstance = Array.newInstance(componentType, (objArr.length - clsArr.length) + 1);
                while (i2 < Array.getLength(objNewInstance)) {
                    Array.set(objNewInstance, i2, Context.jsToJava(objArr[(clsArr.length - 1) + i2], componentType));
                    i2++;
                }
                objJsToJava = objNewInstance;
            }
            objArr2[clsArr.length - 1] = objJsToJava;
        } else {
            objArr2 = objArr;
            while (i2 < objArr2.length) {
                Object obj2 = objArr2[i2];
                Object objJsToJava2 = Context.jsToJava(obj2, clsArr[i2]);
                if (objJsToJava2 != obj2) {
                    if (objArr == objArr2) {
                        objArr2 = (Object[]) objArr2.clone();
                    }
                    objArr2[i2] = objJsToJava2;
                }
                i2++;
            }
        }
        if (!memberBox.isStatic()) {
            Class<?> declaringClass = memberBox.getDeclaringClass();
            for (Scriptable prototype = scriptable2; prototype != null; prototype = prototype.getPrototype()) {
                if (prototype instanceof Wrapper) {
                    Object objUnwrap = ((Wrapper) prototype).unwrap();
                    if (declaringClass.isInstance(objUnwrap)) {
                        obj = objUnwrap;
                    }
                }
            }
            throw Context.reportRuntimeError3("msg.nonjava.method", getFunctionName(), ScriptRuntime.toString(scriptable2), declaringClass.getName());
        }
        obj = null;
        Object objInvoke = memberBox.invoke(obj, objArr2);
        Class<?> returnType = memberBox.method().getReturnType();
        Object objWrap = context.getWrapFactory().wrap(context, scriptable, objInvoke, returnType);
        return (objWrap == null && returnType == Void.TYPE) ? Undefined.instance : objWrap;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String decompile(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        boolean z = (i3 & 1) != 0;
        if (!z) {
            sb.append("function ");
            sb.append(getFunctionName());
            sb.append("() {");
        }
        sb.append("/*\n");
        sb.append(toString());
        sb.append(z ? "*/\n" : "*/}\n");
        return sb.toString();
    }

    public int findCachedFunction(Context context, Object[] objArr) {
        MemberBox[] memberBoxArr = this.methods;
        if (memberBoxArr.length <= 1) {
            return findFunction(context, memberBoxArr, objArr);
        }
        for (ResolvedOverload resolvedOverload : this.overloadCache) {
            if (resolvedOverload.matches(objArr)) {
                return resolvedOverload.index;
            }
        }
        int iFindFunction = findFunction(context, this.methods, objArr);
        if (this.overloadCache.size() < this.methods.length * 2) {
            this.overloadCache.addIfAbsent(new ResolvedOverload(objArr, iFindFunction));
        }
        return iFindFunction;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return this.functionName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.methods.length;
        for (int i2 = 0; i2 != length; i2++) {
            if (this.methods[i2].isMethod()) {
                Method method = this.methods[i2].method();
                sb.append(JavaMembers.javaSignature(method.getReturnType()));
                sb.append(' ');
                sb.append(method.getName());
            } else {
                sb.append(this.methods[i2].getName());
            }
            sb.append(JavaMembers.liveConnectSignature(this.methods[i2].argTypes));
            sb.append('\n');
        }
        return sb.toString();
    }

    public NativeJavaMethod(MemberBox[] memberBoxArr, String str) {
        this.overloadCache = new CopyOnWriteArrayList<>();
        this.functionName = str;
        this.methods = memberBoxArr;
    }

    public NativeJavaMethod(MemberBox memberBox, String str) {
        this.overloadCache = new CopyOnWriteArrayList<>();
        this.functionName = str;
        this.methods = new MemberBox[]{memberBox};
    }

    public NativeJavaMethod(Method method, String str) {
        this(new MemberBox(method), str);
    }
}
