package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.ui.BetaNotifyManager;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0329w extends DownloadTask implements Runnable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private File f4465k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4466l;
    private long m;

    public RunnableC0329w(String str, String str2, long j2, long j3, String str3) {
        super(str, "", "", str3);
        this.f4466l = 0L;
        this.m = 0L;
        File file = new File(str2);
        this.f4465k = file;
        this.f3963b = file.getParent();
        this.f3964c = this.f4465k.getName();
        this.f3966e = j2;
        this.f3967f = j3;
        getStatus();
    }

    private String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f3964c)) {
            return this.f3964c;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            for (String str : headerFields.keySet()) {
                if (str != null && (list = headerFields.get(str)) != null) {
                    for (String str2 : list) {
                        if (str2 != null && "content-disposition".equals(str.toLowerCase())) {
                            Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(str2.toLowerCase());
                            if (matcher.find()) {
                                return matcher.group(1);
                            }
                        }
                    }
                }
            }
        }
        String strSubstring = getDownloadUrl().substring(getDownloadUrl().lastIndexOf(47) + 1);
        if (!TextUtils.isEmpty(strSubstring)) {
            return strSubstring;
        }
        return UUID.randomUUID() + ".apk";
    }

    public void b() {
        this.f4466l = (System.currentTimeMillis() - this.m) + this.f4466l;
        C0323p.a.b(this);
        this.m = System.currentTimeMillis();
        BetaNotifyManager.instance.postDownloadNotify();
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(9, this.f3965d, this));
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void delete(boolean z) {
        stop();
        if (z) {
            if (getSaveFile() != null && getSaveFile().exists() && !getSaveFile().isDirectory()) {
                getSaveFile().delete();
            }
            C0323p.a.a(this);
        }
        BetaReceiver.netListeners.remove(getDownloadUrl());
        this.f3964c = null;
        this.f3966e = 0L;
        this.f3967f = 0L;
        this.f3970i = 4;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void download() {
        if (getStatus() == 1) {
            a();
            return;
        }
        if (getStatus() == 2) {
            return;
        }
        if (getSaveFile() == null || !getSaveFile().exists()) {
            this.f3966e = 0L;
            this.f3967f = 0L;
            this.f4466l = 0L;
        } else {
            this.f3966e = getSaveFile().length();
        }
        if (this.f3968g) {
            BetaNotifyManager.instance.initNotify(this);
        }
        this.m = System.currentTimeMillis();
        this.f3970i = 2;
        C0328v.a.f4463b.put(getDownloadUrl(), this);
        C0328v.a.a(this);
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public long getCostTime() {
        return this.f4466l;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public File getSaveFile() {
        return this.f4465k;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public int getStatus() {
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() == this.f3967f && !C0328v.a.f4463b.contains(this)) {
            this.f3966e = this.f3967f;
            this.f3970i = 1;
        }
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() > 0 && getSaveFile().length() < this.f3967f && !C0328v.a.f4463b.contains(this)) {
            this.f3966e = getSaveFile().length();
            this.f3970i = 3;
        }
        if ((getSaveFile() == null || !getSaveFile().exists()) && !C0328v.a.f4463b.contains(this)) {
            this.f3970i = 0;
        }
        return this.f3970i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x018f, code lost:
    
        if (r5 == null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0191, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x015d, code lost:
    
        if (r0 < 3) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0164, code lost:
    
        com.tencent.bugly.proguard.X.a(com.tencent.bugly.proguard.RunnableC0329w.class, "have retry %d times", 3);
     */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0159 A[Catch: Exception -> 0x012f, all -> 0x0170, TryCatch #4 {Exception -> 0x012f, blocks: (B:33:0x0097, B:51:0x00e0, B:66:0x011a, B:73:0x012a, B:91:0x0159, B:92:0x015c, B:88:0x0151, B:96:0x0164), top: B:122:0x0151, outer: #1 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC0329w.run():void");
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void stop() {
        if (this.f3970i != 5) {
            this.f3970i = 3;
        }
    }

    public RunnableC0329w(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.f4466l = 0L;
        this.m = 0L;
        getStatus();
    }

    public void a(int i2, String str) {
        this.f3970i = 5;
        BetaNotifyManager.instance.postDownloadNotify();
        C0328v.a.f4463b.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(10, this.f3965d, this, Integer.valueOf(i2), str));
    }

    public void a() {
        this.f3970i = 1;
        b();
        C0328v.a.f4463b.remove(getDownloadUrl());
        BetaReceiver.netListeners.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(8, this.f3965d, this));
    }
}
