package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import androidx.media2.session.SessionCommand;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class U implements Runnable {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f4317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f4319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f4320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.c f4321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final O f4322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final T f4323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f4324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final P f4325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final P f4326l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    public int p;
    public long q;
    public long r;
    private boolean s;

    public U(Context context, int i2, int i3, byte[] bArr, String str, String str2, P p, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, p, z, 2, SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME, z2, null);
    }

    public void a() {
        this.f4323i.a(this.f4324j, System.currentTimeMillis());
        P p = this.f4325k;
        if (p != null) {
            p.a(this.f4318d);
        }
        P p2 = this.f4326l;
        if (p2 != null) {
            p2.a(this.f4318d);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.bugly.crashreport.common.strategy.c cVar;
        int length = 0;
        try {
            this.p = 0;
            this.q = 0L;
            this.r = 0L;
            byte[] bArr = this.f4319e;
            if (com.tencent.bugly.crashreport.common.info.b.c(this.f4317c) == null) {
                a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArr == null || bArr.length == 0) {
                a(null, false, 0, "request package is empty!", 0);
                return;
            }
            X.a("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.f4318d));
            if (this.f4317c != null && this.f4320f != null && (cVar = this.f4321g) != null && this.f4322h != null) {
                StrategyBean strategyBeanC = cVar.c();
                if (strategyBeanC == null) {
                    a(null, false, 0, "illegal local strategy", 0);
                    return;
                }
                HashMap map = new HashMap();
                map.put("tls", SdkVersion.MINI_VERSION);
                map.put("prodId", this.f4320f.e());
                map.put("bundleId", this.f4320f.f4098g);
                map.put("appVer", this.f4320f.E);
                Map<String, String> map2 = this.o;
                if (map2 != null) {
                    map.putAll(map2);
                }
                map.put("cmd", Integer.toString(this.f4318d));
                map.put("platformId", Byte.toString((byte) 1));
                map.put("sdkVer", this.f4320f.f4103l);
                map.put("strategylastUpdateTime", Long.toString(strategyBeanC.o));
                byte[] bArrB = ca.b(bArr, 2);
                if (bArrB == null) {
                    a(null, false, 0, "failed to zip request body", 0);
                    return;
                }
                a();
                String strA = this.m;
                int i2 = 0;
                int i3 = -1;
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 >= this.a) {
                        a(null, false, i2, "failed after many attempts", 0);
                        return;
                    }
                    if (i5 > 1) {
                        X.e("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i5));
                        ca.c(this.f4316b);
                        if (i5 == this.a) {
                            X.e("[Upload] Use the back-up url at the last time: %s", this.n);
                            strA = this.n;
                        }
                    }
                    X.a("[Upload] Send %d bytes", Integer.valueOf(bArrB.length));
                    strA = a(strA);
                    X.a("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strA, Integer.valueOf(this.f4318d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    byte[] bArrA = this.f4322h.a(strA, bArrB, this, map);
                    if (bArrA == null) {
                        a(1, "Failed to upload for no response!");
                    } else {
                        Map<String, String> map3 = this.f4322h.f4301c;
                        if (a(map3)) {
                            try {
                                int i6 = Integer.parseInt(map3.get(NotificationCompat.CATEGORY_STATUS));
                                X.a("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i6), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                if (i6 != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("status of server is ");
                                    sb.append(i6);
                                    a(null, false, 1, sb.toString(), i6);
                                    return;
                                }
                                X.a("[Upload] Received %d bytes", Integer.valueOf(bArrA.length));
                                if (bArrA.length == 0) {
                                    for (Map.Entry<String, String> entry : map3.entrySet()) {
                                        X.a("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                                    }
                                    a(null, false, 1, "response data from server is empty", 0);
                                    return;
                                }
                                byte[] bArrA2 = ca.a(bArrA, 2);
                                if (bArrA2 != null) {
                                    bArrA = bArrA2;
                                }
                                qa qaVarA = M.a(bArrA, strategyBeanC, true);
                                if (qaVarA == null) {
                                    a(null, false, 1, "failed to decode response package", 0);
                                    return;
                                }
                                Object[] objArr = new Object[2];
                                objArr[0] = Integer.valueOf(qaVarA.f4422d);
                                byte[] bArr2 = qaVarA.f4423e;
                                if (bArr2 != null) {
                                    length = bArr2.length;
                                }
                                objArr[1] = Integer.valueOf(length);
                                X.a("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
                                if (a(qaVarA, this.f4320f, this.f4321g)) {
                                    a(qaVarA, true, 2, "successfully uploaded", 0);
                                    return;
                                } else {
                                    a(qaVarA, false, 2, "failed to process response package", 0);
                                    return;
                                }
                            } catch (Throwable unused) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("[Upload] Failed to upload for format of status header is invalid: ");
                                sb2.append(Integer.toString(i3));
                                a(1, sb2.toString());
                                i4 = i5;
                                i2 = 1;
                            }
                        } else {
                            X.a("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                            a(1, "[Upload] Failed to upload for no status header.");
                            if (map3 != null) {
                                for (Map.Entry<String, String> entry2 : map3.entrySet()) {
                                    X.a(String.format("[key]: %s, [value]: %s", entry2.getKey(), entry2.getValue()), new Object[0]);
                                }
                            }
                            X.a("[Upload] Failed to upload for no status header.", new Object[0]);
                        }
                    }
                    i4 = i5;
                    i2 = 1;
                }
            }
            a(null, false, 0, "illegal access error", 0);
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public U(Context context, int i2, int i3, byte[] bArr, String str, String str2, P p, boolean z, int i4, int i5, boolean z2, Map<String, String> map) {
        this.a = 2;
        this.f4316b = SessionCommand.COMMAND_CODE_VOLUME_SET_VOLUME;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = false;
        this.f4317c = context;
        this.f4320f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f4319e = bArr;
        this.f4321g = com.tencent.bugly.crashreport.common.strategy.c.b();
        this.f4322h = O.a(context);
        T tA = T.a();
        this.f4323i = tA;
        this.f4324j = i2;
        this.m = str;
        this.n = str2;
        this.f4325k = p;
        this.f4326l = tA.f4307d;
        this.f4318d = i3;
        if (i4 > 0) {
            this.a = i4;
        }
        if (i5 > 0) {
            this.f4316b = i5;
        }
        this.s = z2;
        this.o = map;
    }

    public void a(int i2, String str) {
        X.b("[Upload] Failed to upload(%d): %s", Integer.valueOf(i2), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.tencent.bugly.proguard.qa r14, boolean r15, int r16, java.lang.String r17, int r18) {
        /*
            r13 = this;
            r0 = r13
            int r1 = r0.f4318d
            r2 = 630(0x276, float:8.83E-43)
            if (r1 == r2) goto L1b
            r2 = 640(0x280, float:8.97E-43)
            if (r1 == r2) goto L18
            r2 = 830(0x33e, float:1.163E-42)
            if (r1 == r2) goto L1b
            r2 = 840(0x348, float:1.177E-42)
            if (r1 == r2) goto L18
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L1d
        L18:
            java.lang.String r1 = "userinfo"
            goto L1d
        L1b:
            java.lang.String r1 = "crash"
        L1d:
            r2 = 1
            r3 = 0
            if (r15 == 0) goto L2b
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r1
            java.lang.String r1 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.X.c(r1, r2)
            goto L3e
        L2b:
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)
            r4[r3] = r5
            r4[r2] = r1
            r1 = 2
            r4[r1] = r17
            java.lang.String r1 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.X.b(r1, r4)
        L3e:
            long r1 = r0.q
            long r3 = r0.r
            long r1 = r1 + r3
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L5e
            com.tencent.bugly.proguard.T r1 = r0.f4323i
            boolean r2 = r0.s
            long r1 = r1.a(r2)
            long r3 = r0.q
            long r1 = r1 + r3
            long r3 = r0.r
            long r1 = r1 + r3
            com.tencent.bugly.proguard.T r3 = r0.f4323i
            boolean r4 = r0.s
            r3.a(r1, r4)
        L5e:
            com.tencent.bugly.proguard.P r4 = r0.f4325k
            if (r4 == 0) goto L6f
            int r5 = r0.f4318d
            long r7 = r0.q
            long r9 = r0.r
            r6 = r14
            r11 = r15
            r12 = r17
            r4.a(r5, r6, r7, r9, r11, r12)
        L6f:
            com.tencent.bugly.proguard.P r4 = r0.f4326l
            if (r4 == 0) goto L80
            int r5 = r0.f4318d
            long r7 = r0.q
            long r9 = r0.r
            r6 = r14
            r11 = r15
            r12 = r17
            r4.a(r5, r6, r7, r9, r11, r12)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.U.a(com.tencent.bugly.proguard.qa, boolean, int, java.lang.String, int):void");
    }

    public boolean a(qa qaVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.c cVar) {
        if (qaVar == null) {
            X.e("resp == null!", new Object[0]);
            return false;
        }
        byte b2 = qaVar.f4421c;
        if (b2 != 0) {
            X.b("resp result error %d", Byte.valueOf(b2));
            return false;
        }
        try {
            if (!ca.b(qaVar.f4427i) && !com.tencent.bugly.crashreport.common.info.a.m().q().equals(qaVar.f4427i)) {
                J.a().a(com.tencent.bugly.crashreport.common.strategy.c.a, "device", qaVar.f4427i.getBytes(DataUtil.defaultCharset), (I) null, true);
                aVar.f(qaVar.f4427i);
            }
        } catch (Throwable th) {
            X.b(th);
        }
        aVar.u = qaVar.f4425g;
        int i2 = qaVar.f4422d;
        if (i2 == 510) {
            byte[] bArr = qaVar.f4423e;
            if (bArr == null) {
                X.b("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            sa saVar = (sa) M.a(bArr, sa.class);
            if (saVar == null) {
                X.b("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(qaVar.f4422d));
                return false;
            }
            cVar.a(saVar);
        }
        return true;
    }

    public void a(String str, long j2, String str2) {
        this.p++;
        this.q += j2;
    }

    public void a(long j2) {
        this.r += j2;
    }

    private static String a(String str) {
        if (ca.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            X.b(th);
            return str;
        }
    }

    private static boolean a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            if (!map.containsKey(NotificationCompat.CATEGORY_STATUS)) {
                X.e("[Upload] Headers does not contain %s", NotificationCompat.CATEGORY_STATUS);
                return false;
            }
            if (!map.containsKey("Bugly-Version")) {
                X.e("[Upload] Headers does not contain %s", "Bugly-Version");
                return false;
            }
            String str = map.get("Bugly-Version");
            if (!str.contains("bugly")) {
                X.e("[Upload] Bugly version is not valid: %s", str);
                return false;
            }
            X.a("[Upload] Bugly version from headers is: %s", str);
            return true;
        }
        X.e("[Upload] Headers is empty.", new Object[0]);
        return false;
    }
}
