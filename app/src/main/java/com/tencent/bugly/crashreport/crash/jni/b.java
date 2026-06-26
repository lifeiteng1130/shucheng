package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.e;
import com.tencent.bugly.crashreport.crash.h;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class b implements NativeExceptionHandler {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f4226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f4227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.c f4228d;

    public b(Context context, com.tencent.bugly.crashreport.common.info.a aVar, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar) {
        this.a = context;
        this.f4226b = eVar;
        this.f4227c = aVar;
        this.f4228d = cVar;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public void handleNativeException(int i2, int i3, long j2, long j3, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        X.c("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i2, i3, j2, j3, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(14:121|3|4|(2:6|7)(5:8|(1:10)|11|(1:13)(1:14)|15)|16|(3:18|(4:21|(5:23|24|25|26|(2:28|126)(3:30|31|124))(1:125)|32|19)|123)(2:33|34)|35|36|(1:44)(3:41|42|43)|45|46|(1:53)(2:51|52)|54|55)|(1:71)(4:60|61|(2:62|(2:64|(2:127|66)(1:129))(2:128|67))|(1:69)(12:70|73|74|75|76|77|(2:79|80)|81|82|(4:91|120|92|(3:94|95|96)(10:97|98|99|118|100|(1:102)|103|(1:105)|106|131))(5:86|87|88|89|90)|114|(2:116|117)(1:130)))|72|73|74|75|76|77|(0)|81|82|(1:84)|91|120|92|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02ab, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0246  */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instruction units count: 699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.b.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public CrashDetailBean packageCrashDatas(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i2;
        String str12;
        int iIndexOf;
        boolean zI = h.g().i();
        if (zI) {
            X.b("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f4130b = 1;
        crashDetailBean.f4133e = this.f4227c.l();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f4227c;
        crashDetailBean.f4134f = aVar.E;
        crashDetailBean.f4135g = aVar.i();
        crashDetailBean.m = this.f4227c.y();
        crashDetailBean.n = str3;
        crashDetailBean.o = zI ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.q = str13;
        crashDetailBean.r = j2;
        crashDetailBean.u = ca.c(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.f4227c.r();
        crashDetailBean.f4136h = this.f4227c.p();
        crashDetailBean.f4137i = this.f4227c.o();
        crashDetailBean.v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String strA = c.a(dumpFilePath, str8);
        if (!ca.b(strA)) {
            crashDetailBean.W = strA;
        }
        crashDetailBean.X = c.c(dumpFilePath);
        crashDetailBean.w = c.a(str9, h.f4187e, h.f4190h, h.m);
        crashDetailBean.x = c.a(str10, h.f4187e, null, true);
        crashDetailBean.K = str7;
        crashDetailBean.L = str6;
        crashDetailBean.M = str11;
        crashDetailBean.F = this.f4227c.v();
        crashDetailBean.G = this.f4227c.w();
        crashDetailBean.H = this.f4227c.x();
        if (z) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = ca.a(this.a, h.f4187e, h.f4190h);
            }
            crashDetailBean.y = ba.b();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f4227c;
            crashDetailBean.N = aVar2.f4095d;
            crashDetailBean.O = aVar2.C();
            crashDetailBean.z = ca.a(h.f4188f, false);
            int iIndexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (iIndexOf2 > 0 && (i2 = iIndexOf2 + 6) < crashDetailBean.q.length()) {
                String strC = c.a.a.a.a.c(crashDetailBean.q, 1, i2);
                if (strC.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (iIndexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(strC)) > 0) {
                    String strSubstring = str12.substring(iIndexOf);
                    crashDetailBean.z.put(crashDetailBean.B, strSubstring);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i2);
                    crashDetailBean.q = c.a.a.a.a.p(new StringBuilder(), crashDetailBean.q, strSubstring);
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f4227c.f4099h;
            }
            this.f4226b.d(crashDetailBean);
            crashDetailBean.R = this.f4227c.A();
            crashDetailBean.S = this.f4227c.t();
            crashDetailBean.T = this.f4227c.h();
            crashDetailBean.U = this.f4227c.g();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.N = -1L;
            crashDetailBean.R = -1;
            crashDetailBean.S = -1;
            crashDetailBean.T = map;
            crashDetailBean.U = this.f4227c.g();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
        }
        return crashDetailBean;
    }
}
