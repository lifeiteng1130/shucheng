package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class FieldManager {
    private static final String a = "cfgfd";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f5070b = b.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f5071c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f5072d = new Object();

    public static class a {
        private static final FieldManager a = new FieldManager();

        private a() {
        }
    }

    public static FieldManager a() {
        return a.a;
    }

    public static boolean allow(String str) {
        synchronized (f5072d) {
            if (!f5071c) {
                return false;
            }
            return b.a(str);
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (f5072d) {
            z = f5071c;
        }
        return z;
    }

    private FieldManager() {
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3758096383,2147483647,262143,2047";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0130d.class.getName()};
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3758096383,2147483647,262143,2047");
        synchronized (f5072d) {
            Pair<Long, String> pairA = a(strImprintProperty);
            if (((Long) pairA.first).longValue() > 1000 && (str = (String) pairA.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] strArrSplit = str2.split(",");
            int length = strArrSplit.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i2)).a(strArrSplit[i2], f5070b, d.b(strArr[i2]));
                }
            }
            f5071c = true;
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3758096383,2147483647,262143,2047";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0130d.class.getName()};
        synchronized (f5072d) {
            f5070b.a();
            if (str != null) {
                Pair<Long, String> pairA = a(str);
                if (((Long) pairA.first).longValue() > 1000 && (str2 = (String) pairA.second) != null && str2.length() > 0) {
                    str3 = str2;
                }
            }
            String[] strArrSplit = str3.split(",");
            int length = strArrSplit.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i2)).a(strArrSplit[i2], f5070b, d.b(strArr[i2]));
                }
            }
            f5071c = true;
        }
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length < 2) {
                return pair;
            }
            try {
                long j2 = Long.parseLong(strArrSplit[0]);
                return new Pair<>(Long.valueOf(j2), strArrSplit[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
