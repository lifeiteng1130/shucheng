package com.ss.android.downloadlib.addownload.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: InstalledAppManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f3045c = {"com", "android", "ss"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f3046d = {3101, 3102, 3103, 3201, 3202, 3203};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<a> f3047b = new LinkedList<>();

    /* JADX INFO: compiled from: InstalledAppManager.java */
    public static class a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f3051e;

        private a(String str, int i2, String str2, String str3, long j2) {
            this.a = str;
            this.f3048b = i2;
            this.f3049c = str2 != null ? str2.toLowerCase() : null;
            this.f3050d = str3 != null ? str3.toLowerCase() : null;
            this.f3051e = j2;
        }
    }

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private a c(String str) {
        try {
            PackageManager packageManager = j.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new a(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        b();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f3047b) {
            Iterator<a> it = this.f3047b.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().a)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void a(String str) {
        a aVarC;
        b();
        if (TextUtils.isEmpty(str) || (aVarC = c(str)) == null) {
            return;
        }
        synchronized (this.f3047b) {
            this.f3047b.add(aVarC);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.b.d.a, java.lang.Integer> b(com.ss.android.downloadad.api.a.b r19) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.b.d.b(com.ss.android.downloadad.api.a.b):android.util.Pair");
    }

    public a a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        b();
        synchronized (this.f3047b) {
            for (a aVar : this.f3047b) {
                if (aVar.f3051e > bVar.C()) {
                    return aVar;
                }
            }
            return null;
        }
    }

    private static boolean a(String str, String str2) {
        String[] strArrSplit;
        String[] strArrSplit2;
        boolean z;
        try {
            strArrSplit = str.split("\\.");
            strArrSplit2 = str2.split("\\.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
            int i2 = 0;
            int i3 = 0;
            for (String str3 : strArrSplit) {
                String[] strArr = f3045c;
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z = false;
                        break;
                    }
                    String str4 = strArr[i4];
                    if (str4.equals(str3)) {
                        if (i2 < strArrSplit2.length && str4.equals(strArrSplit2[i2])) {
                            i2++;
                        }
                        z = true;
                    } else {
                        i4++;
                    }
                }
                if (!z) {
                    int i5 = i3;
                    int i6 = i2;
                    while (i2 < strArrSplit2.length) {
                        if (str3.equals(strArrSplit2[i2])) {
                            if (i2 == i6) {
                                i6++;
                            }
                            i5++;
                            if (i5 >= 2) {
                                return true;
                            }
                        }
                        i2++;
                    }
                    i2 = i6;
                    i3 = i5;
                }
            }
            return false;
        }
        return false;
    }

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f3047b) {
            Iterator<a> it = this.f3047b.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().f3051e > 1800000) {
                it.remove();
            }
        }
    }
}
