package com.efs.sdk.base.a.c.a;

import com.efs.sdk.base.IConfigRefreshAction;

/* JADX INFO: loaded from: classes.dex */
public final class a implements IConfigRefreshAction {

    /* JADX INFO: renamed from: com.efs.sdk.base.a.c.a.a$a, reason: collision with other inner class name */
    public static class C0064a {
        private static final a a = new a();
    }

    public static a a() {
        return C0064a.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a8, code lost:
    
        com.efs.sdk.base.a.h.d.a("efs.config", "config request succ, config is:\n ".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b5, code lost:
    
        return r4;
     */
    @Override // com.efs.sdk.base.IConfigRefreshAction
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String refresh() {
        /*
            r10 = this;
            com.efs.sdk.base.a.c.a r0 = com.efs.sdk.base.a.d.a.a()
            android.content.Context r0 = r0.f1776c
            android.net.NetworkInfo r0 = com.efs.sdk.base.a.h.e.a(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            boolean r3 = r0.isConnected()
            if (r3 == 0) goto L1e
            android.net.NetworkInfo$State r0 = r0.getState()
            android.net.NetworkInfo$State r3 = android.net.NetworkInfo.State.CONNECTED
            if (r0 != r3) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            java.lang.String r3 = "efs.config"
            java.lang.String r4 = ""
            if (r0 != 0) goto L2b
            java.lang.String r0 = "Config refresh fail, network is disconnected."
            com.efs.sdk.base.a.h.d.a(r3, r0)
            return r4
        L2b:
            com.efs.sdk.base.a.c.a.c r0 = com.efs.sdk.base.a.c.a.c.a()
            java.lang.String r0 = r0.a(r2)
            com.efs.sdk.base.a.a.c r5 = com.efs.sdk.base.a.a.c.a()
        L37:
            r6 = 3
            if (r1 >= r6) goto La8
            com.efs.sdk.base.a.a.a r6 = com.efs.sdk.base.a.a.a.a()
            java.lang.String r7 = r5.b()
            java.lang.String r8 = "/apm_cc"
            java.lang.String r8 = c.a.a.a.a.i(r0, r8)
            boolean r6 = r6.a
            if (r6 == 0) goto L5b
            java.lang.String r6 = java.lang.String.valueOf(r8)
            java.lang.String r9 = "get config from server, url is "
            java.lang.String r6 = r9.concat(r6)
            java.lang.String r9 = "efs.px.api"
            com.efs.sdk.base.a.h.d.a(r9, r6)
        L5b:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>(r2)
            java.lang.String r9 = "wpk-header"
            r6.put(r9, r7)
            com.efs.sdk.base.a.h.b.d r7 = new com.efs.sdk.base.a.h.b.d
            r7.<init>(r8)
            com.efs.sdk.base.a.h.b.d r6 = r7.a(r6)
            com.efs.sdk.base.a.a.b r7 = com.efs.sdk.base.a.a.b.a()
            com.efs.sdk.base.a.h.b.d r6 = r6.a(r7)
            com.efs.sdk.base.a.h.b.c r6 = r6.a()
            com.efs.sdk.base.a.h.b.b r7 = r6.a
            java.lang.String r8 = "get"
            r7.f1841e = r8
            java.lang.Object r6 = r6.a()
            com.efs.sdk.base.http.HttpResponse r6 = (com.efs.sdk.base.http.HttpResponse) r6
            boolean r7 = r6.succ
            if (r7 == 0) goto L8d
            java.lang.String r4 = r6.data
            goto La8
        L8d:
            java.lang.String r7 = r6.getBizCode()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto La7
            java.lang.String r6 = r6.getBizCode()
            java.lang.String r7 = "1000"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto La4
            goto La7
        La4:
            int r1 = r1 + 1
            goto L37
        La7:
            return r4
        La8:
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "config request succ, config is:\n "
            java.lang.String r0 = r1.concat(r0)
            com.efs.sdk.base.a.h.d.a(r3, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.a.c.a.a.refresh():java.lang.String");
    }
}
