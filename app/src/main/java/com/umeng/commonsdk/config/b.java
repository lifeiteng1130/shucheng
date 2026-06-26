package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CollectController.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements f {
    private static Map<String, Boolean> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f5073b = new Object();

    /* JADX INFO: compiled from: CollectController.java */
    public static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.a;
    }

    public void a() {
        synchronized (f5073b) {
            a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f5073b) {
            if (!a.containsKey(str)) {
                return true;
            }
            return a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f5073b) {
                Map<String, Boolean> map = a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
