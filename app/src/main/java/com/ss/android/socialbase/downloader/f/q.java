package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: UrlRecord.java */
/* JADX INFO: loaded from: classes.dex */
public class q {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<m> f3670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f3674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicLong f3675j;

    public q(String str, boolean z) {
        this.f3670e = new ArrayList();
        this.f3675j = new AtomicLong();
        this.a = str;
        this.f3669d = z;
        this.f3667b = null;
        this.f3668c = null;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(".");
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String e() {
        if (this.f3674i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.f3667b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f3669d);
            this.f3674i = sb.toString();
        }
        return this.f3674i;
    }

    public synchronized void b(m mVar) {
        try {
            this.f3670e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        this.f3672g = false;
    }

    public synchronized boolean d() {
        return this.f3672g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return e().equals(((q) obj).e());
        }
        return false;
    }

    public int hashCode() {
        if (this.f3673h == 0) {
            this.f3673h = e().hashCode();
        }
        return this.f3673h;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("UrlRecord{url='");
        c.a.a.a.a.y(sbR, this.a, '\'', ", ip='");
        c.a.a.a.a.y(sbR, this.f3667b, '\'', ", ipFamily='");
        c.a.a.a.a.y(sbR, this.f3668c, '\'', ", isMainUrl=");
        sbR.append(this.f3669d);
        sbR.append(", failedTimes=");
        sbR.append(this.f3671f);
        sbR.append(", isCurrentFailed=");
        sbR.append(this.f3672g);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    public synchronized void b() {
        this.f3671f++;
        this.f3672g = true;
    }

    public synchronized void a(m mVar) {
        this.f3670e.add(mVar);
    }

    public q(String str, String str2) {
        this.f3670e = new ArrayList();
        this.f3675j = new AtomicLong();
        this.a = str;
        this.f3669d = false;
        this.f3667b = str2;
        this.f3668c = a(str2);
    }

    public synchronized int a() {
        return this.f3670e.size();
    }

    public void a(long j2) {
        this.f3675j.addAndGet(j2);
    }
}
