package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldMetaData.java */
/* JADX INFO: loaded from: classes.dex */
public class bc implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends aq>, Map<? extends ax, bc>> f4721d = new HashMap();
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f4722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd f4723c;

    public bc(String str, byte b2, bd bdVar) {
        this.a = str;
        this.f4722b = b2;
        this.f4723c = bdVar;
    }

    public static void a(Class<? extends aq> cls, Map<? extends ax, bc> map) {
        f4721d.put(cls, map);
    }

    public static Map<? extends ax, bc> a(Class<? extends aq> cls) {
        if (!f4721d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                StringBuilder sbR = c.a.a.a.a.r("IllegalAccessException for TBase class: ");
                sbR.append(cls.getName());
                sbR.append(", message: ");
                sbR.append(e2.getMessage());
                throw new RuntimeException(sbR.toString());
            } catch (InstantiationException e3) {
                StringBuilder sbR2 = c.a.a.a.a.r("InstantiationException for TBase class: ");
                sbR2.append(cls.getName());
                sbR2.append(", message: ");
                sbR2.append(e3.getMessage());
                throw new RuntimeException(sbR2.toString());
            }
        }
        return f4721d.get(cls);
    }
}
