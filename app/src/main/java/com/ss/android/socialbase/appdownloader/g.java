package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: AppUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: compiled from: AppUtils.java */
    public static class a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Drawable f3402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f3403d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f3404e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3405f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f3406g;

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i2, boolean z) {
            b(str2);
            a(drawable);
            a(str);
            c(str3);
            d(str4);
            a(i2);
            a(z);
        }

        public Drawable a() {
            return this.f3402c;
        }

        public boolean b() {
            return this.f3406g;
        }

        public String c() {
            return this.a;
        }

        public String d() {
            return this.f3401b;
        }

        public String e() {
            return this.f3403d;
        }

        public int f() {
            return this.f3405f;
        }

        public String g() {
            return this.f3404e;
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("{\n  pkg name: ");
            sbR.append(c());
            sbR.append("\n  app icon: ");
            sbR.append(a());
            sbR.append("\n  app name: ");
            sbR.append(d());
            sbR.append("\n  app path: ");
            sbR.append(e());
            sbR.append("\n  app v name: ");
            sbR.append(g());
            sbR.append("\n  app v code: ");
            sbR.append(f());
            sbR.append("\n  is system: ");
            sbR.append(b());
            sbR.append("}");
            return sbR.toString();
        }

        public void a(Drawable drawable) {
            this.f3402c = drawable;
        }

        public void b(String str) {
            this.f3401b = str;
        }

        public void c(String str) {
            this.f3403d = str;
        }

        public void d(String str) {
            this.f3404e = str;
        }

        public void a(boolean z) {
            this.f3406g = z;
        }

        public void a(String str) {
            this.a = str;
        }

        public void a(int i2) {
            this.f3405f = i2;
        }
    }

    public static int a(String str) {
        if (c(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.c.N().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static a b(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.c.N().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return a(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean c(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    private static a a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        return new a(packageInfo.packageName, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
