package com.efs.sdk.base.a.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.os.EnvironmentCompat;
import com.efs.sdk.base.a.c.c;
import com.efs.sdk.base.a.i.f;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class b extends Handler {
    private static final Map<String, Long> a = new AnonymousClass1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f1808b = new AnonymousClass2();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, AtomicInteger> f1809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile SharedPreferences f1810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile SharedPreferences.Editor f1811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f1812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1813g;

    /* JADX INFO: renamed from: com.efs.sdk.base.a.e.b$1, reason: invalid class name */
    public static class AnonymousClass1 extends HashMap<String, Long> implements j$.util.Map {
        public AnonymousClass1() {
            super(3);
            put("flow_5min", 300000L);
            put("flow_hour", 3600000L);
            put("flow_day", 86400000L);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
            return Map.CC.$default$compute(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
            return Map.CC.$default$computeIfAbsent(this, obj, function);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
            return Map.CC.$default$computeIfPresent(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return Map.CC.$default$getOrDefault(this, obj, obj2);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return Map.CC.$default$putIfAbsent(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean remove(Object obj, Object obj2) {
            return Map.CC.$default$remove(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object replace(Object obj, Object obj2) {
            return Map.CC.$default$replace(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
            return Map.CC.$default$replace(this, obj, obj2, obj3);
        }

        @Override // j$.util.Map
        public /* synthetic */ void replaceAll(BiFunction biFunction) {
            Map.CC.$default$replaceAll(this, biFunction);
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.base.a.e.b$2, reason: invalid class name */
    public static class AnonymousClass2 extends HashMap<String, Long> implements j$.util.Map {
        public AnonymousClass2() {
            super(3);
            Long lValueOf = Long.valueOf(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            put("flow_5min", lValueOf);
            put("flow_hour", lValueOf);
            put("flow_day", Long.valueOf(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE));
        }

        @Override // j$.util.Map
        public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
            return Map.CC.$default$compute(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
            return Map.CC.$default$computeIfAbsent(this, obj, function);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
            return Map.CC.$default$computeIfPresent(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return Map.CC.$default$getOrDefault(this, obj, obj2);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return Map.CC.$default$putIfAbsent(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean remove(Object obj, Object obj2) {
            return Map.CC.$default$remove(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object replace(Object obj, Object obj2) {
            return Map.CC.$default$replace(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
            return Map.CC.$default$replace(this, obj, obj2, obj3);
        }

        @Override // j$.util.Map
        public /* synthetic */ void replaceAll(BiFunction biFunction) {
            Map.CC.$default$replaceAll(this, biFunction);
        }
    }

    public static class a {
        private static final b a = new b(0);
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static b a() {
        return a.a;
    }

    private void b() {
        try {
            c();
        } catch (Throwable th) {
            com.efs.sdk.base.a.h.d.b("efs.flow", "init sharedpreferences error", th);
        }
    }

    private void c() {
        if (this.f1810d == null) {
            synchronized (b.class) {
                if (this.f1810d == null) {
                    this.f1810d = SharedPreferencesUtils.getSharedPreferences(this.f1812f, this.f1813g.toLowerCase() + "_flow");
                }
            }
        }
        if (this.f1811e == null) {
            synchronized (b.class) {
                if (this.f1811e == null) {
                    this.f1811e = this.f1810d.edit();
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i2 = message.what;
        if (i2 == 0) {
            b();
            if (this.f1810d == null) {
                com.efs.sdk.base.a.h.d.a("efs.flow", "sharedpreferences is null, cann't get last flow stat", null);
                return;
            }
            if (this.f1811e == null) {
                com.efs.sdk.base.a.h.d.a("efs.flow", "sharedpreferences editor is null, cann't refresh flow stat", null);
                return;
            }
            String strValueOf = String.valueOf(message.obj);
            long j2 = message.arg1;
            String strA = c.a.a.a();
            for (String str : a.keySet()) {
                String strConcat = "curr_time_".concat(String.valueOf(str));
                if (!this.f1810d.contains(strConcat)) {
                    this.f1811e.putLong(strConcat, System.currentTimeMillis());
                }
                for (String str2 : a(str, strValueOf, strA)) {
                    this.f1811e.putLong(str2, this.f1810d.getLong(str2, 0L) + j2);
                }
            }
            this.f1811e.apply();
            return;
        }
        if (i2 != 1) {
            com.efs.sdk.base.a.h.d.a("efs.flow", "flow stat listener not support action '" + message.what + "'", null);
            return;
        }
        String strValueOf2 = String.valueOf(message.obj);
        long j3 = message.arg1;
        b();
        if (this.f1810d == null) {
            com.efs.sdk.base.a.h.d.a("efs.flow", "sharedpreferences is null, cann't get last refresh timestamp", null);
            return;
        }
        if (this.f1811e == null) {
            com.efs.sdk.base.a.h.d.a("efs.flow", "sharedpreferences editor is null, cann't refresh timestamp", null);
            return;
        }
        String strConcat2 = "curr_time_".concat(strValueOf2);
        if (Math.abs(System.currentTimeMillis() - this.f1810d.getLong(strConcat2, System.currentTimeMillis())) >= j3) {
            for (String str3 : this.f1810d.getAll().keySet()) {
                if (str3.startsWith(strValueOf2)) {
                    this.f1811e.putLong(str3, 0L);
                }
            }
            this.f1811e.putLong(strConcat2, System.currentTimeMillis());
            this.f1811e.apply();
            this.f1809c.clear();
        }
    }

    private b() {
        super(com.efs.sdk.base.a.h.a.a.a.getLooper());
        this.f1809c = new ConcurrentHashMap(5);
        this.f1812f = com.efs.sdk.base.a.d.a.a().f1776c;
        this.f1813g = com.efs.sdk.base.a.d.a.a().a;
        b();
        File fileC = com.efs.sdk.base.a.h.a.c(com.efs.sdk.base.a.d.a.a().f1776c, com.efs.sdk.base.a.d.a.a().a);
        if (fileC.exists()) {
            com.efs.sdk.base.a.h.b.b(fileC);
        }
    }

    private boolean a(@NonNull String str, long j2, @NonNull String str2, @NonNull String str3, long j3) {
        b();
        if (this.f1810d == null) {
            com.efs.sdk.base.a.h.d.a("efs.flow", "sharedpreferences is null, cann't get last flow stat", null);
            return false;
        }
        List<String> listA = a(str, str2, str3);
        java.util.Map<String, String> mapC = com.efs.sdk.base.a.c.a.c.a().c();
        for (String str4 : listA) {
            if (Math.abs(System.currentTimeMillis() - this.f1810d.getLong("curr_time_".concat(String.valueOf(str)), System.currentTimeMillis())) > j2) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = str;
                messageObtain.arg1 = Long.valueOf(j2).intValue();
                sendMessage(messageObtain);
            }
            long jA = a(mapC, str, str4);
            long j4 = this.f1810d.getLong(str4, 0L);
            if (j4 + j3 > jA) {
                com.efs.sdk.base.a.h.d.a("efs.flow", "flow limit, key: " + str4 + ", max: " + jA + ", now: " + j4 + ", size: " + j3);
                a(str4);
                return false;
            }
        }
        return true;
    }

    private void a(String str) {
        if (!this.f1809c.containsKey(str) || this.f1809c.get(str) == null || this.f1809c.get(str).get() <= 10) {
            f.a.a.a(com.efs.sdk.base.a.c.a.c.a().f1793d.a, str);
            if (str.equals("flow_day")) {
                f.a.a.a(com.efs.sdk.base.a.c.a.c.a().f1793d.a);
            }
            if (!this.f1809c.containsKey(str)) {
                this.f1809c.put(str, new AtomicInteger());
            }
            this.f1809c.get(str).incrementAndGet();
        }
    }

    private static long a(java.util.Map<String, String> map, @NonNull String str, @NonNull String str2) {
        long jLongValue = f1808b.get(str).longValue();
        if (map == null || !map.containsKey(str2) || TextUtils.isEmpty(map.get(str2))) {
            return jLongValue;
        }
        try {
            return Long.parseLong(map.get(str2));
        } catch (Throwable th) {
            com.efs.sdk.base.a.h.d.a("efs.flow", "get max flow error", th);
            return jLongValue;
        }
    }

    private static List<String> a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str + "_" + str2);
        }
        if (!TextUtils.isEmpty(str3) && !EnvironmentCompat.MEDIA_UNKNOWN.equalsIgnoreCase(str3)) {
            arrayList.add(str + "_" + str3);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            arrayList.add(str + "_" + str2 + "_" + str3);
        }
        return arrayList;
    }

    public final boolean a(@NonNull String str, long j2) {
        String strA = c.a.a.a();
        boolean zA = true;
        for (Map.Entry<String, Long> entry : a.entrySet()) {
            zA = a(entry.getKey(), entry.getValue().longValue(), str, strA, j2);
            if (!zA) {
                break;
            }
        }
        return zA;
    }
}
