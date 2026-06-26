package com.ss.android.downloadlib.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.addownload.j;
import com.umeng.analytics.pro.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: AidlClient.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f2973d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f2974e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f2975f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile a f2976g;
    public c a;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f2982k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2979h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2980i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f2981j = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<Pair<b, d>> f2983l = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<InterfaceC0076a> f2977b = new ArrayList();
    private final ServiceConnection m = new ServiceConnection() { // from class: com.ss.android.downloadlib.a.b.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f2978c) {
                a.this.a(false);
                a.this.a = c.a.a(iBinder);
                a.this.c();
                Iterator<InterfaceC0076a> it = a.this.f2977b.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f2978c) {
                a.this.a(false);
                a aVar = a.this;
                aVar.a = null;
                Iterator<InterfaceC0076a> it = aVar.f2977b.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
            }
        }
    };
    private String n = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f2978c = new Object();

    /* JADX INFO: renamed from: com.ss.android.downloadlib.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AidlClient.java */
    public interface InterfaceC0076a {
        void a();

        void b();
    }

    private a() {
    }

    public static a a() {
        if (f2976g == null) {
            synchronized (a.class) {
                if (f2976g == null) {
                    f2976g = new a();
                }
            }
        }
        return f2976g;
    }

    public void b() {
        if (this.a != null) {
            this.f2982k.unbindService(this.m);
            this.a = null;
        }
        this.f2977b.clear();
        this.f2983l.clear();
    }

    public void c() {
        for (Pair<b, d> pair : this.f2983l) {
            try {
                this.a.a((b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f2983l.clear();
    }

    public boolean d() {
        return this.f2981j;
    }

    public boolean a(Context context, boolean z) {
        if (TextUtils.isEmpty(f2973d)) {
            JSONObject jSONObjectI = j.i();
            String strOptString = jSONObjectI.optString(ai.az);
            f2973d = com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString("q"), strOptString);
            f2974e = com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString(ai.aE), strOptString);
            f2975f = com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString("w"), strOptString);
        }
        this.f2980i = z;
        if (context == null) {
            return true;
        }
        this.f2982k = context.getApplicationContext();
        if (TextUtils.isEmpty(f2975f)) {
            f2975f = this.f2982k.getPackageName();
        }
        if (this.a != null || d()) {
            return true;
        }
        return this.f2982k.bindService(a(context), this.m, 33);
    }

    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction(f2973d);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f2974e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.f2978c) {
            bVar.f2987e = f2975f;
            if (TextUtils.isEmpty(bVar.f2988f)) {
                bVar.f2988f = this.n;
            }
            c cVar = this.a;
            if (cVar != null) {
                try {
                    cVar.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (d() || a(this.f2982k, this.f2980i)) {
                this.f2983l.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void a(boolean z) {
        this.f2981j = z;
    }
}
