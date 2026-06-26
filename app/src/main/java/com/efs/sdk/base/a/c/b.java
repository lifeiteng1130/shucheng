package com.efs.sdk.base.a.c;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public Map<String, Object> a = new ConcurrentHashMap();

    public final void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    public final Object b(String str, Object obj) {
        Object obj2 = this.a.get(str);
        return (obj2 != null || this.a.containsKey(str)) ? obj2 : obj;
    }

    public final Map<String, Object> a() {
        HashMap map = new HashMap(this.a);
        com.efs.sdk.base.a.a.a.a();
        map.put("ctime", Long.valueOf(com.efs.sdk.base.a.a.a.b() / 1000));
        com.efs.sdk.base.a.a.a.a();
        map.put("w_tm", Long.valueOf(com.efs.sdk.base.a.a.a.b() / 1000));
        return map;
    }
}
