package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.g;
import org.jsoup.helper.HttpConnection;

/* JADX INFO: compiled from: HttpResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f3857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3860e;

    public d(String str, g gVar) {
        this.a = str;
        this.f3858c = gVar.b();
        this.f3857b = gVar;
    }

    public boolean a() {
        return f.c(this.f3858c);
    }

    public boolean b() {
        return f.a(this.f3858c, this.f3857b.a("Accept-Ranges"));
    }

    public String c() {
        return this.f3857b.a("Etag");
    }

    public String d() {
        return this.f3857b.a(HttpConnection.CONTENT_TYPE);
    }

    public String e() {
        return f.b(this.f3857b, "Content-Range");
    }

    public String f() {
        String strB = f.b(this.f3857b, "last-modified");
        return TextUtils.isEmpty(strB) ? f.b(this.f3857b, "Last-Modified") : strB;
    }

    public String g() {
        return f.b(this.f3857b, "Cache-Control");
    }

    public long h() {
        if (this.f3859d <= 0) {
            this.f3859d = f.a(this.f3857b);
        }
        return this.f3859d;
    }

    public boolean i() {
        return com.ss.android.socialbase.downloader.i.a.a(8) ? f.c(this.f3857b) : f.b(h());
    }

    public long j() {
        if (this.f3860e <= 0) {
            if (i()) {
                this.f3860e = -1L;
            } else {
                String strE = e();
                if (!TextUtils.isEmpty(strE)) {
                    this.f3860e = f.b(strE);
                }
            }
        }
        return this.f3860e;
    }

    public long k() {
        return f.i(g());
    }
}
