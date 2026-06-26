package i.a.a;

import com.tencent.bugly.beta.tinker.TinkerReport;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import k.e.a.n;
import k.e.a.o;
import k.e.a.r;

/* JADX INFO: compiled from: BeansAccess.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> {
    public static ConcurrentHashMap<Class<?>, b<?>> a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, a> f6337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a[] f6338c;

    public static void a(b<?> bVar, HashMap<String, String> map) {
        if (map == null) {
            return;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a aVar = bVar.f6337b.get(entry.getValue());
            if (aVar != null) {
                map2.put(entry.getValue(), aVar);
            }
        }
        bVar.f6337b.putAll(map2);
    }

    public static <P> b<P> c(Class<P> cls, h hVar) {
        int i2;
        int i3;
        String str;
        LinkedList linkedList;
        k.e.a.f fVar;
        a[] aVarArr;
        n[] nVarArr;
        a[] aVarArr2;
        String str2;
        String str3;
        String str4;
        b<P> bVar = (b) a.get(cls);
        if (bVar != null) {
            return bVar;
        }
        HashMap map = new HashMap();
        Class<P> superclass = cls;
        while (true) {
            i2 = 0;
            i3 = 1;
            if (superclass == Object.class) {
                break;
            }
            for (Field field : superclass.getDeclaredFields()) {
                String name = field.getName();
                if (!map.containsKey(name)) {
                    a aVar = new a(superclass, field, hVar);
                    if ((aVar.a == null && aVar.f6332c == null && aVar.f6331b == null) ? false : true) {
                        map.put(name, aVar);
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
        a[] aVarArr3 = (a[]) map.values().toArray(new a[map.size()]);
        String name2 = cls.getName();
        String strConcat = name2.startsWith("java.util.") ? "net.minidev.asm." + name2 + "AccAccess" : name2.concat("AccAccess");
        g gVar = new g(cls.getClassLoader());
        Class<?> clsA = null;
        try {
            clsA = gVar.loadClass(strConcat);
        } catch (ClassNotFoundException unused) {
        }
        LinkedList linkedList2 = new LinkedList();
        for (Class<P> superclass2 = cls; superclass2 != null && !superclass2.equals(Object.class); superclass2 = superclass2.getSuperclass()) {
            linkedList2.addLast(superclass2);
            for (Class<?> cls2 : superclass2.getInterfaces()) {
                linkedList2.addLast(cls2);
            }
        }
        linkedList2.addLast(Object.class);
        if (clsA == null) {
            c cVar = new c(cls, aVarArr3, gVar);
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                String str5 = strConcat;
                LinkedList linkedList3 = linkedList2;
                LinkedHashSet<Class<?>> linkedHashSet = d.a.get((Class) it.next());
                if (linkedHashSet != null) {
                    Iterator<T> it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        Class cls3 = (Class) it2.next();
                        if (cls3 != null) {
                            for (Method method : cls3.getMethods()) {
                                if ((method.getModifiers() & 8) != 0) {
                                    Class<?>[] parameterTypes = method.getParameterTypes();
                                    if (parameterTypes.length == 1 && parameterTypes[0].equals(Object.class)) {
                                        Class<?> returnType = method.getReturnType();
                                        if (!returnType.equals(Void.TYPE)) {
                                            cVar.f6345h.put(returnType, method);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i2 = 0;
                i3 = 1;
                strConcat = str5;
                linkedList2 = linkedList3;
            }
            k.e.a.f fVar2 = new k.e.a.f(i3);
            boolean z = cVar.f6339b.length > 10;
            fVar2.a(50, 33, cVar.f6343f, c.a.a.a.a.p(new StringBuilder("Lnet/minidev/asm/BeansAccess<L"), cVar.f6344g, ";>;"), c.a, null);
            o oVarC = fVar2.c(1, "<init>", "()V", null, null);
            oVarC.u(25, i2);
            oVarC.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, c.a, "<init>", "()V");
            oVarC.e(177);
            oVarC.n(i3, i3);
            String str6 = "()V";
            o oVarC2 = fVar2.c(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
            a[] aVarArr4 = cVar.f6339b;
            if (aVarArr4.length != 0) {
                if (aVarArr4.length > 14) {
                    oVarC2.u(21, 2);
                    n[] nVarArrB4 = c.b.a.m.f.b4(cVar.f6339b.length);
                    n nVar = new n();
                    oVarC2.r(i2, nVarArrB4.length - i3, nVar, nVarArrB4);
                    a[] aVarArr5 = cVar.f6339b;
                    int length = aVarArr5.length;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < length) {
                        a aVar2 = aVarArr5[i4];
                        int i6 = i5 + 1;
                        oVarC2.i(nVarArrB4[i5]);
                        if ((aVar2.a == null && aVar2.f6332c == null) ? false : true) {
                            cVar.b(oVarC2, aVar2);
                        } else {
                            oVarC2.e(177);
                        }
                        i4++;
                        i5 = i6;
                    }
                    oVarC2.i(nVar);
                } else {
                    n[] nVarArrB42 = c.b.a.m.f.b4(aVarArr4.length);
                    a[] aVarArr6 = cVar.f6339b;
                    int length2 = aVarArr6.length;
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < length2) {
                        a aVar3 = aVarArr6[i7];
                        cVar.a(oVarC2, 2, i8, nVarArrB42[i8]);
                        cVar.b(oVarC2, aVar3);
                        oVarC2.i(nVarArrB42[i8]);
                        oVarC2.c(3, 0, null, 0, null);
                        i8++;
                        i7++;
                        aVarArr6 = aVarArr6;
                    }
                }
            }
            Class<? extends Exception> cls4 = cVar.f6346i;
            if (cls4 != null) {
                cVar.c(oVarC2, cls4);
            } else {
                oVarC2.e(177);
            }
            oVarC2.n(0, 0);
            o oVarC3 = fVar2.c(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
            a[] aVarArr7 = cVar.f6339b;
            int i9 = 176;
            if (aVarArr7.length == 0) {
                oVarC3.c(3, 0, null, 0, null);
            } else if (aVarArr7.length > 14) {
                oVarC3.u(21, 2);
                n[] nVarArrB43 = c.b.a.m.f.b4(cVar.f6339b.length);
                n nVar2 = new n();
                oVarC3.r(0, nVarArrB43.length - 1, nVar2, nVarArrB43);
                a[] aVarArr8 = cVar.f6339b;
                int length3 = aVarArr8.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length3) {
                    n nVar3 = nVar2;
                    a aVar4 = aVarArr8[i10];
                    int i12 = i11 + 1;
                    oVarC3.i(nVarArrB43[i11]);
                    oVarC3.c(3, 0, null, 0, null);
                    if ((aVar4.a == null && aVar4.f6332c == null) ? false : true) {
                        oVarC3.u(25, 1);
                        oVarC3.t(192, cVar.f6344g);
                        r rVarH = r.h(aVar4.f6334e);
                        if (aVar4.a()) {
                            nVarArr = nVarArrB43;
                            aVarArr2 = aVarArr8;
                            oVarC3.b(180, cVar.f6344g, aVar4.f6336g, rVarH.e());
                        } else {
                            nVarArr = nVarArrB43;
                            aVarArr2 = aVarArr8;
                            oVarC3.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, cVar.f6344g, aVar4.f6332c.getName(), r.g(aVar4.f6332c));
                        }
                        c.b.a.m.f.s0(oVarC3, rVarH);
                        oVarC3.e(176);
                    } else {
                        oVarC3.e(1);
                        oVarC3.e(i9);
                        nVarArr = nVarArrB43;
                        aVarArr2 = aVarArr8;
                    }
                    i10++;
                    i9 = 176;
                    nVar2 = nVar3;
                    i11 = i12;
                    nVarArrB43 = nVarArr;
                    aVarArr8 = aVarArr2;
                }
                oVarC3.i(nVar2);
                oVarC3.c(3, 0, null, 0, null);
            } else {
                n[] nVarArrB44 = c.b.a.m.f.b4(aVarArr7.length);
                a[] aVarArr9 = cVar.f6339b;
                int length4 = aVarArr9.length;
                int i13 = 0;
                int i14 = 0;
                while (i13 < length4) {
                    String str7 = strConcat;
                    LinkedList linkedList4 = linkedList2;
                    String str8 = str6;
                    a aVar5 = aVarArr9[i13];
                    cVar.a(oVarC3, 2, i14, nVarArrB44[i14]);
                    oVarC3.u(25, 1);
                    oVarC3.t(192, cVar.f6344g);
                    r rVarH2 = r.h(aVar5.f6334e);
                    if (aVar5.a()) {
                        fVar = fVar2;
                        aVarArr = aVarArr9;
                        oVarC3.b(180, cVar.f6344g, aVar5.f6336g, rVarH2.e());
                    } else {
                        fVar = fVar2;
                        aVarArr = aVarArr9;
                        Method method2 = aVar5.f6332c;
                        if (method2 == null) {
                            throw new RuntimeException("no Getter for field " + aVar5.f6336g + " in class " + cVar.f6341d);
                        }
                        oVarC3.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, cVar.f6344g, aVar5.f6332c.getName(), r.g(method2));
                    }
                    c.b.a.m.f.s0(oVarC3, rVarH2);
                    oVarC3.e(176);
                    oVarC3.i(nVarArrB44[i14]);
                    oVarC3.c(3, 0, null, 0, null);
                    i14++;
                    i13++;
                    strConcat = str7;
                    fVar2 = fVar;
                    aVarArr9 = aVarArr;
                    str6 = str8;
                    linkedList2 = linkedList4;
                }
            }
            Class<? extends Exception> cls5 = cVar.f6346i;
            if (cls5 != null) {
                cVar.c(oVarC3, cls5);
            } else {
                oVarC3.e(1);
                oVarC3.e(176);
            }
            oVarC3.n(0, 0);
            String str9 = "(Ljava/lang/Object;)Z";
            if (z) {
                str = strConcat;
                linkedList = linkedList2;
                str2 = "java/lang/String";
            } else {
                str = strConcat;
                str2 = "java/lang/String";
                o oVarC4 = fVar2.c(1, "set", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V", null, null);
                n[] nVarArrB45 = c.b.a.m.f.b4(cVar.f6339b.length);
                a[] aVarArr10 = cVar.f6339b;
                int length5 = aVarArr10.length;
                int i15 = 0;
                int i16 = 0;
                while (i15 < length5) {
                    int i17 = length5;
                    a aVar6 = aVarArr10[i15];
                    oVarC4.u(25, 2);
                    oVarC4.j(aVar6.f6336g);
                    oVarC4.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "equals", "(Ljava/lang/Object;)Z");
                    oVarC4.h(153, nVarArrB45[i16]);
                    cVar.b(oVarC4, aVar6);
                    oVarC4.i(nVarArrB45[i16]);
                    oVarC4.c(3, 0, null, 0, null);
                    i16++;
                    i15++;
                    length5 = i17;
                    aVarArr10 = aVarArr10;
                    linkedList2 = linkedList2;
                }
                Class<? extends Exception> cls6 = cVar.f6346i;
                if (cls6 != null) {
                    cVar.d(oVarC4, cls6);
                } else {
                    oVarC4.e(177);
                }
                oVarC4.n(0, 0);
                linkedList = linkedList2;
            }
            if (!z) {
                o oVarC5 = fVar2.c(1, "get", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", null, null);
                n[] nVarArrB46 = c.b.a.m.f.b4(cVar.f6339b.length);
                a[] aVarArr11 = cVar.f6339b;
                int length6 = aVarArr11.length;
                int i18 = 0;
                int i19 = 0;
                while (i18 < length6) {
                    a aVar7 = aVarArr11[i18];
                    a[] aVarArr12 = aVarArr11;
                    oVarC5.u(25, 2);
                    oVarC5.j(aVar7.f6336g);
                    oVarC5.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "equals", str9);
                    oVarC5.h(153, nVarArrB46[i19]);
                    oVarC5.u(25, 1);
                    oVarC5.t(192, cVar.f6344g);
                    r rVarH3 = r.h(aVar7.f6334e);
                    if (aVar7.a()) {
                        str3 = str2;
                        str4 = str9;
                        oVarC5.b(180, cVar.f6344g, aVar7.f6336g, rVarH3.e());
                    } else {
                        str3 = str2;
                        str4 = str9;
                        oVarC5.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, cVar.f6344g, aVar7.f6332c.getName(), r.g(aVar7.f6332c));
                    }
                    c.b.a.m.f.s0(oVarC5, rVarH3);
                    oVarC5.e(176);
                    oVarC5.i(nVarArrB46[i19]);
                    oVarC5.c(3, 0, null, 0, null);
                    i19++;
                    i18++;
                    aVarArr11 = aVarArr12;
                    str2 = str3;
                    str9 = str4;
                }
                Class<? extends Exception> cls7 = cVar.f6346i;
                if (cls7 != null) {
                    cVar.d(oVarC5, cls7);
                } else {
                    oVarC5.e(1);
                    oVarC5.e(176);
                }
                oVarC5.n(0, 0);
            }
            o oVarC6 = fVar2.c(1, "newInstance", "()Ljava/lang/Object;", null, null);
            oVarC6.t(187, cVar.f6344g);
            oVarC6.e(89);
            oVarC6.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, cVar.f6344g, "<init>", str6);
            oVarC6.e(176);
            oVarC6.n(2, 1);
            clsA = cVar.f6340c.a(cVar.f6342e, fVar2.w());
        } else {
            str = strConcat;
            linkedList = linkedList2;
        }
        int i20 = 0;
        try {
            b<P> bVar2 = (b) clsA.newInstance();
            bVar2.f6338c = aVarArr3;
            bVar2.f6337b = new HashMap<>();
            int length7 = aVarArr3.length;
            int i21 = 0;
            while (i21 < length7) {
                a aVar8 = aVarArr3[i21];
                int i22 = i20 + 1;
                aVar8.f6333d = i20;
                bVar2.f6337b.put(aVar8.f6336g, aVar8);
                i21++;
                i20 = i22;
            }
            a.putIfAbsent(cls, bVar2);
            Iterator it3 = linkedList.iterator();
            while (it3.hasNext()) {
                a(bVar2, d.f6347b.get((Class) it3.next()));
            }
            return bVar2;
        } catch (Exception e2) {
            throw new RuntimeException("Error constructing accessor class: " + str, e2);
        }
    }

    public abstract Object b(T t, int i2);

    public abstract T d();

    public abstract void e(T t, int i2, Object obj);
}
