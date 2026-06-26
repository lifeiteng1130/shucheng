package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class C0312e extends C0311d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static HashMap<String, byte[]> f4362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static HashMap<String, HashMap<String, byte[]>> f4363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C0314g f4364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4365l;

    public C0312e() {
        C0314g c0314g = new C0314g();
        this.f4364k = c0314g;
        this.f4365l = 0;
        c0314g.f4373d = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.C0311d, com.tencent.bugly.proguard.C0310c
    public <T> void a(String str, T t) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException(c.a.a.a.a.i("put name can not startwith . , now is ", str));
        }
        super.a(str, t);
    }

    public byte[] b() {
        C0314g c0314g = this.f4364k;
        if (c0314g.f4373d != 2) {
            if (c0314g.f4377h == null) {
                c0314g.f4377h = "";
            }
            if (c0314g.f4378i == null) {
                c0314g.f4378i = "";
            }
        } else {
            if (c0314g.f4377h.equals("")) {
                throw new IllegalArgumentException("servantName can not is null");
            }
            if (this.f4364k.f4378i.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        }
        C0319l c0319l = new C0319l(0);
        c0319l.a(this.f4352d);
        if (this.f4364k.f4373d == 2) {
            c0319l.a((Map) this.a, 0);
        } else {
            c0319l.a((Map) this.f4354f, 0);
        }
        this.f4364k.f4379j = C0321n.a(c0319l.a());
        C0319l c0319l2 = new C0319l(0);
        c0319l2.a(this.f4352d);
        a(c0319l2);
        byte[] bArrA = C0321n.a(c0319l2.a());
        int length = bArrA.length + 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length).put(bArrA).flip();
        return byteBufferAllocate.array();
    }

    public void c(String str) {
        this.f4364k.f4377h = str;
    }

    @Override // com.tencent.bugly.proguard.C0311d
    public void a() {
        super.a();
        this.f4364k.f4373d = (short) 3;
    }

    public void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                C0318k c0318k = new C0318k(bArr, 4);
                c0318k.a(this.f4352d);
                a(c0318k);
                C0314g c0314g = this.f4364k;
                if (c0314g.f4373d == 3) {
                    C0318k c0318k2 = new C0318k(c0314g.f4379j);
                    c0318k2.a(this.f4352d);
                    if (f4362i == null) {
                        HashMap<String, byte[]> map = new HashMap<>();
                        f4362i = map;
                        map.put("", new byte[0]);
                    }
                    this.f4354f = c0318k2.a((Map) f4362i, 0, false);
                    return;
                }
                C0318k c0318k3 = new C0318k(c0314g.f4379j);
                c0318k3.a(this.f4352d);
                if (f4363j == null) {
                    f4363j = new HashMap<>();
                    HashMap<String, byte[]> map2 = new HashMap<>();
                    map2.put("", new byte[0]);
                    f4363j.put("", map2);
                }
                this.a = c0318k3.a((Map) f4363j, 0, false);
                this.f4350b = new HashMap<>();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public void b(String str) {
        this.f4364k.f4378i = str;
    }

    public void a(int i2) {
        this.f4364k.f4376g = i2;
    }

    public void a(C0319l c0319l) {
        this.f4364k.a(c0319l);
    }

    public void a(C0318k c0318k) {
        this.f4364k.a(c0318k);
    }
}
