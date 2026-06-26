package com.efs.sdk.base.a.h;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    private static String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<Integer> f1845b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f1846c = -1;

    public static int a() {
        return Process.myPid();
    }

    public static String b() {
        String str = a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = a(Process.myPid());
        a = strA;
        return strA;
    }

    public static String a(int i2) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i2 + "/cmdline")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i3 = bufferedReader2.read();
                    if (i3 <= 0) {
                        sb.trimToSize();
                        String string = sb.toString();
                        try {
                            bufferedReader2.close();
                            return string;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return string;
                        }
                    }
                    sb.append((char) i3);
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                try {
                    d.b("efs.base", "get process name error", th);
                    return "";
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            int i2 = Integer.parseInt(str);
            List<Integer> list = f1845b;
            boolean z = false;
            if (list != null && !list.isEmpty() && f1846c > 0 && System.currentTimeMillis() - f1846c <= TTAdConstant.AD_MAX_EVENT_TIME) {
                z = true;
            }
            if (!z) {
                List<Integer> list2 = f1845b;
                if (list2 != null) {
                    list2.clear();
                } else {
                    f1845b = new ArrayList();
                }
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                    while (it.hasNext()) {
                        f1845b.add(Integer.valueOf(it.next().pid));
                    }
                }
                f1846c = System.currentTimeMillis();
            }
            return f1845b.contains(Integer.valueOf(i2));
        } catch (Throwable th) {
            d.b("efs.base", "Process exist judge error", th);
            return true;
        }
    }
}
