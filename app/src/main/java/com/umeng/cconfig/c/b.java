package com.umeng.cconfig.c;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5046b;

    public b(String str, JSONArray jSONArray) {
        this.a = str;
        this.f5046b = jSONArray.toString();
    }

    public b(String str, JSONObject jSONObject) {
        this.a = str;
        this.f5046b = jSONObject.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[Catch: all -> 0x003c, Exception -> 0x003e, TryCatch #2 {Exception -> 0x003e, blocks: (B:2:0x0000, B:10:0x0024, B:12:0x002a, B:14:0x0034, B:6:0x0017), top: B:19:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[Catch: all -> 0x003c, Exception -> 0x003e, TRY_LEAVE, TryCatch #2 {Exception -> 0x003e, blocks: (B:2:0x0000, B:10:0x0024, B:12:0x002a, B:14:0x0034, B:6:0x0017), top: B:19:0x0000 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r5 = this;
            java.lang.String r0 = r5.a     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r1 = r5.f5046b     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r0 = com.umeng.cconfig.c.a.a(r0, r1)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r1 = -1
            java.lang.String r2 = r5.a     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r3 = "https://ucc.umeng.com/v1/fetch"
            boolean r2 = r2.contains(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r3 = 0
            if (r2 == 0) goto L17
            r1 = 1
        L15:
            r2 = r0
            goto L24
        L17:
            java.lang.String r2 = r5.a     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r4 = "https://pslog.umeng.com/ablog"
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r2 == 0) goto L23
            r1 = 2
            goto L15
        L23:
            r2 = r3
        L24:
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r0 == 0) goto L34
            com.umeng.cconfig.UMRemoteConfig r0 = com.umeng.cconfig.UMRemoteConfig.getInstance()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r3 = r5.f5046b     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r0.handlerMessage(r1, r2, r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            return
        L34:
            com.umeng.cconfig.UMRemoteConfig r0 = com.umeng.cconfig.UMRemoteConfig.getInstance()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r0.handlerMessage(r1, r2, r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            return
        L3c:
            r0 = move-exception
            throw r0
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.cconfig.c.b.run():void");
    }
}
