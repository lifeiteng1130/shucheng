package org.mozilla.javascript;

import c.a.a.a.a;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import k.d.a.c;
import k.d.a.d;
import org.jsoup.nodes.Attributes;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.JavaAdapter;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaAdapter implements IdFunctionCall {
    private static final Object FTAG = "JavaAdapter";
    private static final int Id_JavaAdapter = 1;

    public static class JavaAdapterSignature {
        public Class<?>[] interfaces;
        public ObjToIntMap names;
        public Class<?> superClass;

        public JavaAdapterSignature(Class<?> cls, Class<?>[] clsArr, ObjToIntMap objToIntMap) {
            this.superClass = cls;
            this.interfaces = clsArr;
            this.names = objToIntMap;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof JavaAdapterSignature)) {
                return false;
            }
            JavaAdapterSignature javaAdapterSignature = (JavaAdapterSignature) obj;
            if (this.superClass != javaAdapterSignature.superClass) {
                return false;
            }
            Class<?>[] clsArr = this.interfaces;
            Class<?>[] clsArr2 = javaAdapterSignature.interfaces;
            if (clsArr != clsArr2) {
                if (clsArr.length == clsArr2.length) {
                    int i2 = 0;
                    while (true) {
                        Class<?>[] clsArr3 = this.interfaces;
                        if (i2 >= clsArr3.length) {
                            break;
                        }
                        if (clsArr3[i2] != javaAdapterSignature.interfaces[i2]) {
                            return false;
                        }
                        i2++;
                    }
                } else {
                    return false;
                }
            }
            if (this.names.size() != javaAdapterSignature.names.size()) {
                return false;
            }
            ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(this.names);
            iterator.start();
            while (!iterator.done()) {
                String str = (String) iterator.getKey();
                int value = iterator.getValue();
                if (value != javaAdapterSignature.names.get(str, value + 1)) {
                    return false;
                }
                iterator.next();
            }
            return true;
        }

        public int hashCode() {
            return (this.superClass.hashCode() + Arrays.hashCode(this.interfaces)) ^ this.names.size();
        }
    }

    public static int appendMethodSignature(Class<?>[] clsArr, Class<?> cls, StringBuilder sb) {
        sb.append('(');
        int length = clsArr.length + 1;
        for (Class<?> cls2 : clsArr) {
            appendTypeString(sb, cls2);
            if (cls2 == Long.TYPE || cls2 == Double.TYPE) {
                length++;
            }
        }
        sb.append(')');
        appendTypeString(sb, cls);
        return length;
    }

    private static void appendOverridableMethods(Class<?> cls, ArrayList<Method> arrayList, HashSet<String> hashSet) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (int i2 = 0; i2 < declaredMethods.length; i2++) {
            String str = declaredMethods[i2].getName() + getMethodSignature(declaredMethods[i2], declaredMethods[i2].getParameterTypes());
            if (!hashSet.contains(str)) {
                int modifiers = declaredMethods[i2].getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    if (Modifier.isFinal(modifiers)) {
                        hashSet.add(str);
                    } else if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                        arrayList.add(declaredMethods[i2]);
                        hashSet.add(str);
                    }
                }
            }
        }
    }

    private static StringBuilder appendTypeString(StringBuilder sb, Class<?> cls) {
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            sb.append(cls == Boolean.TYPE ? 'Z' : cls == Long.TYPE ? 'J' : Character.toUpperCase(cls.getName().charAt(0)));
        } else {
            sb.append('L');
            sb.append(cls.getName().replace('.', Attributes.InternalPrefix));
            sb.append(';');
        }
        return sb;
    }

    public static Object callMethod(ContextFactory contextFactory, final Scriptable scriptable, final Function function, final Object[] objArr, final long j2) {
        if (function == null) {
            return null;
        }
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        final Scriptable parentScope = function.getParentScope();
        if (j2 == 0) {
            return Context.call(contextFactory, function, parentScope, scriptable, objArr);
        }
        Context currentContext = Context.getCurrentContext();
        return currentContext != null ? doCall(currentContext, parentScope, scriptable, function, objArr, j2) : contextFactory.call(new ContextAction() { // from class: k.d.b.g
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return JavaAdapter.doCall(context, parentScope, scriptable, function, objArr, j2);
            }
        });
    }

    public static Object convertResult(Object obj, Class<?> cls) {
        if (obj != Undefined.instance || cls == ScriptRuntime.ObjectClass || cls == ScriptRuntime.StringClass) {
            return Context.jsToJava(obj, cls);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] createAdapterCode(org.mozilla.javascript.ObjToIntMap r20, java.lang.String r21, java.lang.Class<?> r22, java.lang.Class<?>[] r23, java.lang.String r24) {
        /*
            Method dump skipped, instruction units count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.JavaAdapter.createAdapterCode(org.mozilla.javascript.ObjToIntMap, java.lang.String, java.lang.Class, java.lang.Class[], java.lang.String):byte[]");
    }

    public static Scriptable createAdapterWrapper(Scriptable scriptable, Object obj) {
        NativeJavaObject nativeJavaObject = new NativeJavaObject(ScriptableObject.getTopLevelScope(scriptable), obj, null, true);
        nativeJavaObject.setPrototype(scriptable);
        return nativeJavaObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object doCall(Context context, Scriptable scriptable, Scriptable scriptable2, Function function, Object[] objArr, long j2) {
        for (int i2 = 0; i2 != objArr.length; i2++) {
            if (0 != (((long) (1 << i2)) & j2)) {
                Object obj = objArr[i2];
                if (!(obj instanceof Scriptable)) {
                    objArr[i2] = context.getWrapFactory().wrap(context, scriptable, obj, null);
                }
            }
        }
        return function.call(context, scriptable, scriptable2, objArr);
    }

    private static void generateCtor(c cVar, String str, String str2, Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        short sGeneratePushParam = 3;
        if (parameterTypes.length == 0) {
            cVar.Q("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;)V", (short) 1);
            cVar.c(42);
            cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, str2, "<init>", "()V");
        } else {
            StringBuilder sb = new StringBuilder("(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;");
            int length = sb.length();
            for (Class<?> cls : parameterTypes) {
                appendTypeString(sb, cls);
            }
            sb.append(")V");
            cVar.Q("<init>", sb.toString(), (short) 1);
            cVar.c(42);
            for (Class<?> cls2 : parameterTypes) {
                sGeneratePushParam = (short) (sGeneratePushParam + generatePushParam(cVar, sGeneratePushParam, cls2));
            }
            sb.delete(1, length);
            cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, str2, "<init>", sb.toString());
        }
        cVar.c(42);
        cVar.c(43);
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, str, "delegee", OptRuntime.GeneratorState.thisObj_TYPE);
        cVar.c(42);
        cVar.c(44);
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        cVar.c(42);
        cVar.c(43);
        cVar.c(42);
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, str, "self", OptRuntime.GeneratorState.thisObj_TYPE);
        cVar.c(177);
        cVar.R(sGeneratePushParam);
    }

    private static void generateEmptyCtor(c cVar, String str, String str2, String str3) {
        cVar.Q("<init>", "()V", (short) 1);
        cVar.c(42);
        cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, str2, "<init>", "()V");
        cVar.c(42);
        cVar.c(1);
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        cVar.e(187, str3);
        cVar.c(89);
        cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, str3, "<init>", "()V");
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/JavaAdapter", "runScript", "(Lorg/mozilla/javascript/Script;)Lorg/mozilla/javascript/Scriptable;");
        cVar.c(76);
        cVar.c(42);
        cVar.c(43);
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, str, "delegee", OptRuntime.GeneratorState.thisObj_TYPE);
        cVar.c(42);
        cVar.c(43);
        cVar.c(42);
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, str, "self", OptRuntime.GeneratorState.thisObj_TYPE);
        cVar.c(177);
        cVar.R((short) 2);
    }

    private static void generateMethod(c cVar, String str, String str2, Class<?>[] clsArr, Class<?> cls, boolean z) {
        StringBuilder sb = new StringBuilder();
        int iAppendMethodSignature = appendMethodSignature(clsArr, cls, sb);
        cVar.Q(str2, sb.toString(), (short) 1);
        cVar.c(42);
        cVar.f(180, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        cVar.c(42);
        cVar.f(180, str, "self", OptRuntime.GeneratorState.thisObj_TYPE);
        cVar.c(42);
        cVar.f(180, str, "delegee", OptRuntime.GeneratorState.thisObj_TYPE);
        cVar.u(str2);
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/JavaAdapter", "getFunction", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Function;");
        generatePushWrappedArgs(cVar, clsArr, clsArr.length);
        if (clsArr.length > 64) {
            throw Context.reportRuntimeError0("JavaAdapter can not subclass methods with more then 64 arguments.");
        }
        long j2 = 0;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            if (!clsArr[i2].isPrimitive()) {
                j2 |= (long) (1 << i2);
            }
        }
        int i3 = (int) j2;
        if (i3 == j2) {
            cVar.t(i3);
            cVar.c(Token.LOOP);
        } else {
            d dVar = cVar.n;
            dVar.d(9);
            byte[] bArr = dVar.f8779k;
            int i4 = dVar.f8775g;
            int i5 = i4 + 1;
            dVar.f8775g = i5;
            bArr[i4] = 5;
            dVar.f8775g = c.M(i3, bArr, c.M((int) (j2 >>> 32), bArr, i5));
            int i6 = dVar.f8776h;
            dVar.f8776h = i6 + 2;
            dVar.f8778j.put(i6, 5);
            cVar.d(20, i6);
        }
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/JavaAdapter", "callMethod", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Function;[Ljava/lang/Object;J)Ljava/lang/Object;");
        generateReturnResult(cVar, cls, z);
        cVar.R((short) iAppendMethodSignature);
    }

    private static void generatePopResult(c cVar, Class<?> cls) {
        if (!cls.isPrimitive()) {
            cVar.c(176);
            return;
        }
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt == 'f') {
            cVar.c(174);
            return;
        }
        if (cCharAt != 'i') {
            if (cCharAt == 'l') {
                cVar.c(173);
                return;
            } else if (cCharAt != 's' && cCharAt != 'z') {
                switch (cCharAt) {
                    case 'd':
                        cVar.c(175);
                        break;
                }
                return;
            }
        }
        cVar.c(172);
    }

    private static int generatePushParam(c cVar, int i2, Class<?> cls) {
        if (!cls.isPrimitive()) {
            cVar.T(42, 25, i2);
            return 1;
        }
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt == 'f') {
            cVar.T(34, 23, i2);
            return 1;
        }
        if (cCharAt != 'i') {
            if (cCharAt == 'l') {
                cVar.T(30, 22, i2);
                return 2;
            }
            if (cCharAt != 's' && cCharAt != 'z') {
                switch (cCharAt) {
                    case 'b':
                    case 'c':
                        break;
                    case 'd':
                        cVar.T(38, 24, i2);
                        return 2;
                    default:
                        throw Kit.codeBug();
                }
            }
        }
        cVar.T(26, 21, i2);
        return 1;
    }

    public static void generatePushWrappedArgs(c cVar, Class<?>[] clsArr, int i2) {
        cVar.t(i2);
        cVar.e(189, "java/lang/Object");
        int iGenerateWrapArg = 1;
        for (int i3 = 0; i3 != clsArr.length; i3++) {
            cVar.c(89);
            cVar.t(i3);
            iGenerateWrapArg += generateWrapArg(cVar, iGenerateWrapArg, clsArr[i3]);
            cVar.c(83);
        }
    }

    public static void generateReturnResult(c cVar, Class<?> cls, boolean z) {
        if (cls == Void.TYPE) {
            cVar.c(87);
            cVar.c(177);
            return;
        }
        if (cls == Boolean.TYPE) {
            cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/Context", "toBoolean", "(Ljava/lang/Object;)Z");
            cVar.c(172);
            return;
        }
        if (cls == Character.TYPE) {
            cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/Context", "toString", "(Ljava/lang/Object;)Ljava/lang/String;");
            cVar.c(3);
            cVar.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/String", "charAt", "(I)C");
            cVar.c(172);
            return;
        }
        if (!cls.isPrimitive()) {
            String name = cls.getName();
            if (z) {
                cVar.r(name);
                cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
                cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/JavaAdapter", "convertResult", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
            }
            cVar.e(192, name);
            cVar.c(176);
            return;
        }
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/Context", "toNumber", "(Ljava/lang/Object;)D");
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt != 'b') {
            if (cCharAt == 'd') {
                cVar.c(175);
                return;
            }
            if (cCharAt == 'f') {
                cVar.c(Token.DOTDOT);
                cVar.c(174);
                return;
            } else if (cCharAt != 'i') {
                if (cCharAt == 'l') {
                    cVar.c(Token.SET_REF_OP);
                    cVar.c(173);
                    return;
                } else if (cCharAt != 's') {
                    throw new RuntimeException("Unexpected return type " + cls);
                }
            }
        }
        cVar.c(Token.LOCAL_BLOCK);
        cVar.c(172);
    }

    private static void generateSerialCtor(c cVar, String str, String str2) {
        cVar.Q("<init>", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)V", (short) 1);
        cVar.c(42);
        cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, str2, "<init>", "()V");
        cVar.c(42);
        cVar.c(43);
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        cVar.c(42);
        cVar.c(44);
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, str, "delegee", OptRuntime.GeneratorState.thisObj_TYPE);
        cVar.c(42);
        cVar.c(45);
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, str, "self", OptRuntime.GeneratorState.thisObj_TYPE);
        cVar.c(177);
        cVar.R((short) 4);
    }

    private static void generateSuper(c cVar, String str, String str2, String str3, String str4, Class<?>[] clsArr, Class<?> cls) {
        cVar.Q("super$" + str3, str4, (short) 1);
        cVar.d(25, 0);
        int iGeneratePushParam = 1;
        for (Class<?> cls2 : clsArr) {
            iGeneratePushParam += generatePushParam(cVar, iGeneratePushParam, cls2);
        }
        cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, str2, str3, str4);
        if (cls.equals(Void.TYPE)) {
            cVar.c(177);
        } else {
            generatePopResult(cVar, cls);
        }
        cVar.R((short) (iGeneratePushParam + 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int generateWrapArg(k.d.a.c r7, int r8, java.lang.Class<?> r9) {
        /*
            boolean r0 = r9.isPrimitive()
            r1 = 1
            if (r0 != 0) goto Le
            r9 = 25
            r7.d(r9, r8)
            goto L95
        Le:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            java.lang.String r2 = "<init>"
            r3 = 183(0xb7, float:2.56E-43)
            r4 = 89
            r5 = 187(0xbb, float:2.62E-43)
            r6 = 21
            if (r9 != r0) goto L2d
            java.lang.String r9 = "java/lang/Boolean"
            r7.e(r5, r9)
            r7.c(r4)
            r7.d(r6, r8)
            java.lang.String r8 = "(Z)V"
            r7.o(r3, r9, r2, r8)
            goto L95
        L2d:
            java.lang.Class r0 = java.lang.Character.TYPE
            if (r9 != r0) goto L40
            r7.d(r6, r8)
            r8 = 184(0xb8, float:2.58E-43)
            java.lang.String r9 = "java/lang/String"
            java.lang.String r0 = "valueOf"
            java.lang.String r2 = "(C)Ljava/lang/String;"
            r7.o(r8, r9, r0, r2)
            goto L95
        L40:
            java.lang.String r0 = "java/lang/Double"
            r7.e(r5, r0)
            r7.c(r4)
            java.lang.String r9 = r9.getName()
            r4 = 0
            char r9 = r9.charAt(r4)
            r4 = 98
            r5 = 2
            if (r9 == r4) goto L88
            r4 = 100
            if (r9 == r4) goto L81
            r4 = 102(0x66, float:1.43E-43)
            if (r9 == r4) goto L76
            r4 = 105(0x69, float:1.47E-43)
            if (r9 == r4) goto L88
            r4 = 108(0x6c, float:1.51E-43)
            if (r9 == r4) goto L6b
            r4 = 115(0x73, float:1.61E-43)
            if (r9 == r4) goto L88
            goto L90
        L6b:
            r9 = 22
            r7.d(r9, r8)
            r8 = 138(0x8a, float:1.93E-43)
            r7.c(r8)
            goto L86
        L76:
            r9 = 23
            r7.d(r9, r8)
            r8 = 141(0x8d, float:1.98E-43)
            r7.c(r8)
            goto L90
        L81:
            r9 = 24
            r7.d(r9, r8)
        L86:
            r1 = 2
            goto L90
        L88:
            r7.d(r6, r8)
            r8 = 135(0x87, float:1.89E-43)
            r7.c(r8)
        L90:
            java.lang.String r8 = "(D)V"
            r7.o(r3, r0, r2, r8)
        L95:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.JavaAdapter.generateWrapArg(k.d.a.c, int, java.lang.Class):int");
    }

    private static Class<?> getAdapterClass(Scriptable scriptable, Class<?> cls, Class<?>[] clsArr, Scriptable scriptable2) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<JavaAdapterSignature, Class<?>> interfaceAdapterCacheMap = classCache.getInterfaceAdapterCacheMap();
        ObjToIntMap objectFunctionNames = getObjectFunctionNames(scriptable2);
        JavaAdapterSignature javaAdapterSignature = new JavaAdapterSignature(cls, clsArr, objectFunctionNames);
        Class<?> clsLoadAdapterClass = interfaceAdapterCacheMap.get(javaAdapterSignature);
        if (clsLoadAdapterClass == null) {
            StringBuilder sbR = a.r("adapter");
            sbR.append(classCache.newClassSerialNumber());
            String string = sbR.toString();
            clsLoadAdapterClass = loadAdapterClass(string, createAdapterCode(objectFunctionNames, string, cls, clsArr, null));
            if (classCache.isCachingEnabled()) {
                interfaceAdapterCacheMap.put(javaAdapterSignature, clsLoadAdapterClass);
            }
        }
        return clsLoadAdapterClass;
    }

    public static Object getAdapterSelf(Class<?> cls, Object obj) {
        return cls.getDeclaredField("self").get(obj);
    }

    public static int[] getArgsToConvert(Class<?>[] clsArr) {
        int i2 = 0;
        for (int i3 = 0; i3 != clsArr.length; i3++) {
            if (!clsArr[i3].isPrimitive()) {
                i2++;
            }
        }
        if (i2 == 0) {
            return null;
        }
        int[] iArr = new int[i2];
        int i4 = 0;
        for (int i5 = 0; i5 != clsArr.length; i5++) {
            if (!clsArr[i5].isPrimitive()) {
                iArr[i4] = i5;
                i4++;
            }
        }
        return iArr;
    }

    public static Function getFunction(Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            return null;
        }
        if (property instanceof Function) {
            return (Function) property;
        }
        throw ScriptRuntime.notFunctionError(property, str);
    }

    private static String getMethodSignature(Method method, Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        appendMethodSignature(clsArr, method.getReturnType(), sb);
        return sb.toString();
    }

    private static ObjToIntMap getObjectFunctionNames(Scriptable scriptable) {
        Object[] propertyIds = ScriptableObject.getPropertyIds(scriptable);
        ObjToIntMap objToIntMap = new ObjToIntMap(propertyIds.length);
        for (int i2 = 0; i2 != propertyIds.length; i2++) {
            if (propertyIds[i2] instanceof String) {
                String str = (String) propertyIds[i2];
                Object property = ScriptableObject.getProperty(scriptable, str);
                if (property instanceof Function) {
                    int int32 = ScriptRuntime.toInt32(ScriptableObject.getProperty((Function) property, "length"));
                    if (int32 < 0) {
                        int32 = 0;
                    }
                    objToIntMap.put(str, int32);
                }
            }
        }
        return objToIntMap;
    }

    public static Method[] getOverridableMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            appendOverridableMethods(superclass, arrayList, hashSet);
        }
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                appendOverridableMethods(cls2, arrayList, hashSet);
            }
            cls = cls.getSuperclass();
        }
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        IdFunctionObject idFunctionObject = new IdFunctionObject(new JavaAdapter(), FTAG, 1, "JavaAdapter", 1, scriptable);
        idFunctionObject.markAsConstructor(null);
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
    }

    public static Object js_createAdapter(Context context, Scriptable scriptable, Object[] objArr) {
        Object objNewInstance;
        int length = objArr.length;
        if (length == 0) {
            throw ScriptRuntime.typeError0("msg.adapter.zero.args");
        }
        int i2 = 0;
        while (i2 < length - 1) {
            Object obj = objArr[i2];
            if (obj instanceof NativeObject) {
                break;
            }
            if (!(obj instanceof NativeJavaClass)) {
                throw ScriptRuntime.typeError2("msg.not.java.class.arg", String.valueOf(i2), ScriptRuntime.toString(obj));
            }
            i2++;
        }
        Class<?> cls = null;
        Class[] clsArr = new Class[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Class<?> classObject = ((NativeJavaClass) objArr[i4]).getClassObject();
            if (classObject.isInterface()) {
                clsArr[i3] = classObject;
                i3++;
            } else {
                if (cls != null) {
                    throw ScriptRuntime.typeError2("msg.only.one.super", cls.getName(), classObject.getName());
                }
                cls = classObject;
            }
        }
        if (cls == null) {
            cls = ScriptRuntime.ObjectClass;
        }
        Class[] clsArr2 = new Class[i3];
        System.arraycopy(clsArr, 0, clsArr2, 0, i3);
        Scriptable scriptableEnsureScriptable = ScriptableObject.ensureScriptable(objArr[i2]);
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr2, scriptableEnsureScriptable);
        int i5 = (length - i2) - 1;
        try {
            if (i5 > 0) {
                Object[] objArr2 = new Object[i5 + 2];
                objArr2[0] = scriptableEnsureScriptable;
                objArr2[1] = context.getFactory();
                System.arraycopy(objArr, i2 + 1, objArr2, 2, i5);
                NativeJavaMethod nativeJavaMethod = new NativeJavaClass(scriptable, adapterClass, true).members.ctors;
                int iFindCachedFunction = nativeJavaMethod.findCachedFunction(context, objArr2);
                if (iFindCachedFunction < 0) {
                    throw Context.reportRuntimeError2("msg.no.java.ctor", adapterClass.getName(), NativeJavaMethod.scriptSignature(objArr));
                }
                objNewInstance = NativeJavaClass.constructInternal(objArr2, nativeJavaMethod.methods[iFindCachedFunction]);
            } else {
                objNewInstance = adapterClass.getConstructor(ScriptRuntime.ScriptableClass, ScriptRuntime.ContextFactoryClass).newInstance(scriptableEnsureScriptable, context.getFactory());
            }
            Object adapterSelf = getAdapterSelf(adapterClass, objNewInstance);
            if (adapterSelf instanceof Wrapper) {
                Object objUnwrap = ((Wrapper) adapterSelf).unwrap();
                if (objUnwrap instanceof Scriptable) {
                    if (objUnwrap instanceof ScriptableObject) {
                        ScriptRuntime.setObjectProtoAndParent((ScriptableObject) objUnwrap, scriptable);
                    }
                    return objUnwrap;
                }
            }
            return adapterSelf;
        } catch (Exception e2) {
            throw Context.throwAsScriptRuntimeEx(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Class<?> loadAdapterClass(java.lang.String r4, byte[] r5) {
        /*
            java.lang.Class r0 = org.mozilla.javascript.SecurityController.getStaticSecurityDomainClass()
            java.lang.Class<java.security.CodeSource> r1 = java.security.CodeSource.class
            r2 = 0
            if (r0 == r1) goto L10
            java.lang.Class<java.security.ProtectionDomain> r1 = java.security.ProtectionDomain.class
            if (r0 != r1) goto Le
            goto L10
        Le:
            r1 = r2
            goto L28
        L10:
            java.security.ProtectionDomain r1 = org.mozilla.javascript.SecurityUtilities.getScriptProtectionDomain()
            if (r1 != 0) goto L1c
            java.lang.Class<org.mozilla.javascript.JavaAdapter> r1 = org.mozilla.javascript.JavaAdapter.class
            java.security.ProtectionDomain r1 = r1.getProtectionDomain()
        L1c:
            java.lang.Class<java.security.CodeSource> r3 = java.security.CodeSource.class
            if (r0 != r3) goto L28
            if (r1 != 0) goto L23
            goto Le
        L23:
            java.security.CodeSource r0 = r1.getCodeSource()
            r1 = r0
        L28:
            org.mozilla.javascript.GeneratedClassLoader r0 = org.mozilla.javascript.SecurityController.createLoader(r2, r1)
            java.lang.Class r4 = r0.defineClass(r4, r5)
            r0.linkClass(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.JavaAdapter.loadAdapterClass(java.lang.String, byte[]):java.lang.Class");
    }

    public static Object readAdapterObject(Scriptable scriptable, ObjectInputStream objectInputStream) throws ClassNotFoundException {
        Context currentContext = Context.getCurrentContext();
        ContextFactory factory = currentContext != null ? currentContext.getFactory() : null;
        Class<?> cls = Class.forName((String) objectInputStream.readObject());
        String[] strArr = (String[]) objectInputStream.readObject();
        Class[] clsArr = new Class[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            clsArr[i2] = Class.forName(strArr[i2]);
        }
        Scriptable scriptable2 = (Scriptable) objectInputStream.readObject();
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr, scriptable2);
        Class<Scriptable> cls2 = ScriptRuntime.ScriptableClass;
        try {
            return adapterClass.getConstructor(ScriptRuntime.ContextFactoryClass, cls2, cls2).newInstance(factory, scriptable2, scriptable);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            throw new ClassNotFoundException("adapter");
        }
    }

    public static Scriptable runScript(final Script script) {
        return (Scriptable) ContextFactory.getGlobal().call(new ContextAction() { // from class: k.d.b.h
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                Script script2 = script;
                ScriptableObject global = ScriptRuntime.getGlobal(context);
                script2.exec(context, global);
                return global;
            }
        });
    }

    public static void writeAdapterObject(Object obj, ObjectOutputStream objectOutputStream) throws IOException {
        Class<?> cls = obj.getClass();
        objectOutputStream.writeObject(cls.getSuperclass().getName());
        Class<?>[] interfaces = cls.getInterfaces();
        String[] strArr = new String[interfaces.length];
        for (int i2 = 0; i2 < interfaces.length; i2++) {
            strArr[i2] = interfaces[i2].getName();
        }
        objectOutputStream.writeObject(strArr);
        try {
            objectOutputStream.writeObject(cls.getField("delegee").get(obj));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            throw new IOException();
        }
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_createAdapter(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }
}
