package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class C0311d extends C0310c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap<String, byte[]> f4354f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<String, Object> f4355g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C0318k f4356h = new C0318k();

    private void c(String str, Object obj) {
        this.f4355g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.C0310c
    public /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public <T> T b(String str, T t) {
        HashMap<String, byte[]> map = this.f4354f;
        if (map != null) {
            if (!map.containsKey(str)) {
                return null;
            }
            if (this.f4355g.containsKey(str)) {
                return (T) this.f4355g.get(str);
            }
            try {
                T t2 = (T) a(this.f4354f.get(str), t);
                if (t2 != null) {
                    c(str, t2);
                }
                return t2;
            } catch (Exception e2) {
                throw new C0309b(e2);
            }
        }
        if (!this.a.containsKey(str)) {
            return null;
        }
        if (this.f4355g.containsKey(str)) {
            return (T) this.f4355g.get(str);
        }
        byte[] value = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            value = next.getValue();
        }
        try {
            this.f4356h.a(value);
            this.f4356h.a(this.f4352d);
            T t3 = (T) this.f4356h.a((Object) t, 0, true);
            c(str, t3);
            return t3;
        } catch (Exception e3) {
            throw new C0309b(e3);
        }
    }

    public void a() {
        this.f4354f = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.C0310c
    public <T> void a(String str, T t) {
        if (this.f4354f == null) {
            super.a(str, t);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t != null) {
            if (!(t instanceof Set)) {
                C0319l c0319l = new C0319l();
                c0319l.a(this.f4352d);
                c0319l.a(t, 0);
                this.f4354f.put(str, C0321n.a(c0319l.a()));
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    private Object a(byte[] bArr, Object obj) {
        this.f4356h.a(bArr);
        this.f4356h.a(this.f4352d);
        return this.f4356h.a(obj, 0, true);
    }
}
