package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class C0314g extends AbstractC0320m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f4379j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, String> f4381l;
    public Map<String, String> m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f4372c = true;
    public static byte[] a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, String> f4371b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short f4373d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte f4374e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4375f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4376g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4377h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4378i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4380k = 0;

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4373d, 1);
        c0319l.a(this.f4374e, 2);
        c0319l.a(this.f4375f, 3);
        c0319l.a(this.f4376g, 4);
        c0319l.a(this.f4377h, 5);
        c0319l.a(this.f4378i, 6);
        c0319l.a(this.f4379j, 7);
        c0319l.a(this.f4380k, 8);
        c0319l.a((Map) this.f4381l, 9);
        c0319l.a((Map) this.m, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f4372c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        C0314g c0314g = (C0314g) obj;
        return C0321n.a(1, (int) c0314g.f4373d) && C0321n.a(1, (int) c0314g.f4374e) && C0321n.a(1, c0314g.f4375f) && C0321n.a(1, c0314g.f4376g) && C0321n.a((Object) 1, (Object) c0314g.f4377h) && C0321n.a((Object) 1, (Object) c0314g.f4378i) && C0321n.a((Object) 1, (Object) c0314g.f4379j) && C0321n.a(1, c0314g.f4380k) && C0321n.a((Object) 1, (Object) c0314g.f4381l) && C0321n.a((Object) 1, (Object) c0314g.m);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        try {
            this.f4373d = c0318k.a(this.f4373d, 1, true);
            this.f4374e = c0318k.a(this.f4374e, 2, true);
            this.f4375f = c0318k.a(this.f4375f, 3, true);
            this.f4376g = c0318k.a(this.f4376g, 4, true);
            this.f4377h = c0318k.a(5, true);
            this.f4378i = c0318k.a(6, true);
            if (a == null) {
                a = new byte[]{0};
            }
            this.f4379j = c0318k.a(a, 7, true);
            this.f4380k = c0318k.a(this.f4380k, 8, true);
            if (f4371b == null) {
                HashMap map = new HashMap();
                f4371b = map;
                map.put("", "");
            }
            this.f4381l = (Map) c0318k.a(f4371b, 9, true);
            if (f4371b == null) {
                HashMap map2 = new HashMap();
                f4371b = map2;
                map2.put("", "");
            }
            this.m = (Map) c0318k.a(f4371b, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder sbR = c.a.a.a.a.r("RequestPacket decode error ");
            sbR.append(C0313f.a(this.f4379j));
            printStream.println(sbR.toString());
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
        C0316i c0316i = new C0316i(sb, i2);
        c0316i.a(this.f4373d, "iVersion");
        c0316i.a(this.f4374e, "cPacketType");
        c0316i.a(this.f4375f, "iMessageType");
        c0316i.a(this.f4376g, "iRequestId");
        c0316i.a(this.f4377h, "sServantName");
        c0316i.a(this.f4378i, "sFuncName");
        c0316i.a(this.f4379j, "sBuffer");
        c0316i.a(this.f4380k, "iTimeout");
        c0316i.a((Map) this.f4381l, com.umeng.analytics.pro.c.R);
        c0316i.a((Map) this.m, NotificationCompat.CATEGORY_STATUS);
    }
}
