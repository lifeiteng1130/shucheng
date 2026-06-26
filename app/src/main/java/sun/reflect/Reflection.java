package sun.reflect;

import c.a.a.a.a;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import sun.misc.VM;

/* JADX INFO: loaded from: classes3.dex */
public class Reflection {
    private static volatile Map<Class, String[]> fieldFilterMap;
    private static volatile Map<Class, String[]> methodFilterMap;

    static {
        HashMap map = new HashMap();
        map.put(Reflection.class, new String[]{"fieldFilterMap", "methodFilterMap"});
        map.put(System.class, new String[]{"security"});
        fieldFilterMap = map;
        methodFilterMap = new HashMap();
    }

    public static void ensureMemberAccess(Class cls, Class cls2, Object obj, int i2) throws IllegalAccessException {
        if (cls == null || cls2 == null) {
            throw new InternalError();
        }
        if (verifyMemberAccess(cls, cls2, obj, i2)) {
            return;
        }
        StringBuilder sbR = a.r("Class ");
        sbR.append(cls.getName());
        sbR.append(" can not access a member of class ");
        sbR.append(cls2.getName());
        sbR.append(" with modifiers \"");
        sbR.append(Modifier.toString(i2));
        sbR.append("\"");
        throw new IllegalAccessException(sbR.toString());
    }

    private static Member[] filter(Member[] memberArr, String[] strArr) {
        boolean z;
        if (strArr == null || memberArr.length == 0) {
            return memberArr;
        }
        int length = memberArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                break;
            }
            Member member = memberArr[i2];
            int length2 = strArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    z2 = false;
                    break;
                }
                if (member.getName() == strArr[i4]) {
                    break;
                }
                i4++;
            }
            if (!z2) {
                i3++;
            }
            i2++;
        }
        Member[] memberArr2 = (Member[]) Array.newInstance(memberArr[0].getClass(), i3);
        int i5 = 0;
        for (Member member2 : memberArr) {
            int length3 = strArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length3) {
                    z = false;
                    break;
                }
                if (member2.getName() == strArr[i6]) {
                    z = true;
                    break;
                }
                i6++;
            }
            if (!z) {
                memberArr2[i5] = member2;
                i5++;
            }
        }
        return memberArr2;
    }

    public static Field[] filterFields(Class cls, Field[] fieldArr) {
        return fieldFilterMap == null ? fieldArr : (Field[]) filter(fieldArr, fieldFilterMap.get(cls));
    }

    public static Method[] filterMethods(Class cls, Method[] methodArr) {
        return methodFilterMap == null ? methodArr : (Method[]) filter(methodArr, methodFilterMap.get(cls));
    }

    @CallerSensitive
    public static native Class getCallerClass();

    @CallerSensitive
    @Deprecated
    public static Class getCallerClass(int i2) {
        if (VM.allowGetCallerClass()) {
            return getCallerClass0(i2 + 1);
        }
        throw new UnsupportedOperationException("This method has been disabled by a system property");
    }

    @CallerSensitive
    private static native Class getCallerClass0(int i2);

    private static native int getClassAccessFlags(Class cls);

    public static boolean isCallerSensitive(Method method) {
        ClassLoader classLoader = method.getDeclaringClass().getClassLoader();
        if (classLoader == null || isExtClassLoader(classLoader)) {
            return method.isAnnotationPresent(CallerSensitive.class);
        }
        return false;
    }

    private static boolean isExtClassLoader(ClassLoader classLoader) {
        for (ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader(); systemClassLoader != null; systemClassLoader = systemClassLoader.getParent()) {
            if (systemClassLoader.getParent() == null && systemClassLoader == classLoader) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSameClassPackage(Class cls, Class cls2) {
        return isSameClassPackage(cls.getClassLoader(), cls.getName(), cls2.getClassLoader(), cls2.getName());
    }

    public static boolean isSubclassOf(Class cls, Class cls2) {
        while (cls != null) {
            if (cls == cls2) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    public static boolean quickCheckMemberAccess(Class cls, int i2) {
        return Modifier.isPublic(getClassAccessFlags(cls) & i2);
    }

    public static synchronized void registerFieldsToFilter(Class cls, String... strArr) {
        fieldFilterMap = registerFilter(fieldFilterMap, cls, strArr);
    }

    private static Map<Class, String[]> registerFilter(Map<Class, String[]> map, Class cls, String... strArr) {
        if (map.get(cls) == null) {
            HashMap map2 = new HashMap(map);
            map2.put(cls, strArr);
            return map2;
        }
        throw new IllegalArgumentException("Filter already registered: " + cls);
    }

    public static synchronized void registerMethodsToFilter(Class cls, String... strArr) {
        methodFilterMap = registerFilter(methodFilterMap, cls, strArr);
    }

    public static boolean verifyMemberAccess(Class cls, Class cls2, Object obj, int i2) {
        boolean zIsSameClassPackage;
        boolean z;
        if (cls == cls2) {
            return true;
        }
        if (Modifier.isPublic(getClassAccessFlags(cls2))) {
            zIsSameClassPackage = false;
            z = false;
        } else {
            zIsSameClassPackage = isSameClassPackage(cls, cls2);
            if (!zIsSameClassPackage) {
                return false;
            }
            z = true;
        }
        if (Modifier.isPublic(i2)) {
            return true;
        }
        boolean z2 = Modifier.isProtected(i2) && isSubclassOf(cls, cls2);
        if (!z2 && !Modifier.isPrivate(i2)) {
            if (!z) {
                zIsSameClassPackage = isSameClassPackage(cls, cls2);
                z = true;
            }
            if (zIsSameClassPackage) {
                z2 = true;
            }
        }
        if (!z2) {
            return false;
        }
        if (Modifier.isProtected(i2)) {
            Class cls3 = obj == null ? cls2 : obj.getClass();
            if (cls3 != cls) {
                if (!z) {
                    zIsSameClassPackage = isSameClassPackage(cls, cls2);
                }
                if (!zIsSameClassPackage && !isSubclassOf(cls3, cls)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSameClassPackage(ClassLoader classLoader, String str, ClassLoader classLoader2, String str2) {
        int i2;
        int i3;
        if (classLoader != classLoader2) {
            return false;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int iLastIndexOf2 = str2.lastIndexOf(46);
        if (iLastIndexOf == -1 || iLastIndexOf2 == -1) {
            return iLastIndexOf == iLastIndexOf2;
        }
        if (str.charAt(0) == '[') {
            int i4 = 0;
            do {
                i4++;
            } while (str.charAt(i4) == '[');
            if (str.charAt(i4) != 'L') {
                throw new InternalError(a.i("Illegal class name ", str));
            }
            i2 = i4;
        } else {
            i2 = 0;
        }
        if (str2.charAt(0) == '[') {
            int i5 = 0;
            do {
                i5++;
            } while (str2.charAt(i5) == '[');
            if (str2.charAt(i5) != 'L') {
                throw new InternalError(a.i("Illegal class name ", str2));
            }
            i3 = i5;
        } else {
            i3 = 0;
        }
        int i6 = iLastIndexOf - i2;
        if (i6 != iLastIndexOf2 - i3) {
            return false;
        }
        return str.regionMatches(false, i2, str2, i3, i6);
    }
}
