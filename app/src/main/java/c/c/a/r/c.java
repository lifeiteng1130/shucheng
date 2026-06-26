package c.c.a.r;

import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f784e;

    public c(String str, String str2, String str3) {
        this.a = str;
        this.f781b = str2;
        this.f782c = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f784e = jCurrentTimeMillis;
        this.f783d = jCurrentTimeMillis;
        ZeusLogger.i(this.a, this.f781b + String.format(" watcher[%s]-start", str3));
    }

    public final long a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f784e;
        ZeusLogger.i(this.a, this.f781b + String.format(" watcher[%s]-%s cost=%s", this.f782c, str, Long.valueOf(jCurrentTimeMillis)));
        this.f784e = System.currentTimeMillis();
        return jCurrentTimeMillis;
    }

    public final long b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f784e;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.f783d;
        ZeusLogger.i(this.a, this.f781b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f782c, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }
}
