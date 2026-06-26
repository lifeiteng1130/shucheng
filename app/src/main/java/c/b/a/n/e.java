package c.b.a.n;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import c.b.a.i;
import c.b.a.n.c;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements c {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.a f597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BroadcastReceiver f600e = new a();

    /* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f598c;
            eVar.f598c = eVar.i(context);
            if (z != e.this.f598c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    boolean z2 = e.this.f598c;
                }
                e eVar2 = e.this;
                c.a aVar = eVar2.f597b;
                boolean z3 = eVar2.f598c;
                i.b bVar = (i.b) aVar;
                Objects.requireNonNull(bVar);
                if (z3) {
                    synchronized (c.b.a.i.this) {
                        r rVar = bVar.a;
                        for (c.b.a.q.c cVar : (ArrayList) c.b.a.s.i.e(rVar.a)) {
                            if (!cVar.i() && !cVar.d()) {
                                cVar.clear();
                                if (rVar.f613c) {
                                    rVar.f612b.add(cVar);
                                } else {
                                    cVar.g();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public e(@NonNull Context context, @NonNull c.a aVar) {
        this.a = context.getApplicationContext();
        this.f597b = aVar;
    }

    @SuppressLint({"MissingPermission"})
    public boolean i(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Objects.requireNonNull(connectivityManager, "Argument must not be null");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }

    @Override // c.b.a.n.m
    public void onDestroy() {
    }

    @Override // c.b.a.n.m
    public void onStart() {
        if (this.f599d) {
            return;
        }
        this.f598c = i(this.a);
        try {
            this.a.registerReceiver(this.f600e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f599d = true;
        } catch (SecurityException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
        }
    }

    @Override // c.b.a.n.m
    public void onStop() {
        if (this.f599d) {
            this.a.unregisterReceiver(this.f600e);
            this.f599d = false;
        }
    }
}
