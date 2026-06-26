package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class C0310c {
    public HashMap<String, HashMap<String, byte[]>> a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, Object> f4350b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, Object> f4351c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4352d = "GBK";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0318k f4353e = new C0318k();

    public void a(String str) {
        this.f4352d = str;
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        C0319l c0319l = new C0319l();
        c0319l.a(this.f4352d);
        c0319l.a(t, 0);
        byte[] bArrA = C0321n.a(c0319l.a());
        HashMap<String, byte[]> map = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        a(arrayList, t);
        map.put(C0308a.a(arrayList), bArrA);
        this.f4351c.remove(str);
        this.a.put(str, map);
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().toString().equals("byte")) {
                if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    a(arrayList, Array.get(obj, 0));
                    return;
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
            }
            throw new IllegalArgumentException("only byte[] is supported");
        }
        if (!(obj instanceof Array)) {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                    return;
                } else {
                    arrayList.add("?");
                    return;
                }
            }
            if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    a(arrayList, obj2);
                    return;
                }
                arrayList.add("?");
                arrayList.add("?");
                return;
            }
            arrayList.add(obj.getClass().getName());
            return;
        }
        throw new IllegalArgumentException("can not support Array, please use List");
    }
}
