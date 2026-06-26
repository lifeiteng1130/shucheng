package com.ss.android.socialbase.downloader.c;

import android.text.TextUtils;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static int a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AbstractC0095a f3485b;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Logger.java */
    public static abstract class AbstractC0095a {
        public void a(String str, String str2) {
        }

        public void a(String str, String str2, Throwable th) {
        }

        public void b(String str, String str2) {
        }

        public void c(String str, String str2) {
        }

        public void d(String str, String str2) {
        }

        public void e(String str, String str2) {
        }
    }

    public static void a(int i2) {
        a = i2;
    }

    public static String b(String str) {
        return !TextUtils.isEmpty(str) ? c.a.a.a.a.i("Downloader-", str) : "DownloaderLogger";
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 4) {
            b(str);
        }
        AbstractC0095a abstractC0095a = f3485b;
        if (abstractC0095a != null) {
            abstractC0095a.c(b(str), str2);
        }
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 5) {
            b(str);
        }
        AbstractC0095a abstractC0095a = f3485b;
        if (abstractC0095a != null) {
            abstractC0095a.e(b(str), str2);
        }
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 6) {
            b(str);
        }
        AbstractC0095a abstractC0095a = f3485b;
        if (abstractC0095a != null) {
            abstractC0095a.d(b(str), str2);
        }
    }

    public static boolean a() {
        return a <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        int i2 = a;
        AbstractC0095a abstractC0095a = f3485b;
        if (abstractC0095a != null) {
            abstractC0095a.a(b(str), str2);
        }
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 3) {
            b(str);
        }
        AbstractC0095a abstractC0095a = f3485b;
        if (abstractC0095a != null) {
            abstractC0095a.b(b(str), str2);
        }
    }

    public static void c(String str) {
        d("DownloaderLogger", str);
    }

    public static void a(String str) {
        b("DownloaderLogger", str);
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (a <= 6) {
            b(str);
        }
        AbstractC0095a abstractC0095a = f3485b;
        if (abstractC0095a != null) {
            abstractC0095a.a(b(str), str2, th);
        }
    }
}
