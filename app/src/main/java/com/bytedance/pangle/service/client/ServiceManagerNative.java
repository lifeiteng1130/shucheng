package com.bytedance.pangle.service.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Keep;
import c.c.a.i;
import c.c.a.m;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ServiceManagerNative {
    private static volatile ServiceManagerNative sInstance;
    private final HashMap<ServiceConnection, m> serviceConn2ServiceConn = new HashMap<>();
    public HashMap<IBinder, HashMap<ServiceConnection, HashSet<ComponentName>>> process2ConnAndService = new HashMap<>();
    private HashMap<ServiceConnection, HashSet<ServiceInfo>> conn2Service = new HashMap<>();

    public class a extends m.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ServiceConnection f1620b;

        public a(ServiceManagerNative serviceManagerNative, ServiceConnection serviceConnection) {
            this.f1620b = serviceConnection;
        }

        @Override // c.c.a.m
        public final int a() {
            return this.f1620b.hashCode();
        }

        @Override // c.c.a.m
        public final void e(ComponentName componentName, IBinder iBinder) {
            this.f1620b.onServiceConnected(componentName, iBinder);
        }
    }

    private ServiceManagerNative() {
    }

    public static ServiceManagerNative getInstance() {
        if (sInstance == null) {
            synchronized (ServiceManagerNative.class) {
                if (sInstance == null) {
                    sInstance = new ServiceManagerNative();
                }
            }
        }
        return sInstance;
    }

    public boolean bindServiceNative(Context context, Intent intent, ServiceConnection serviceConnection, int i2, String str) {
        ServiceInfo serviceInfoQueryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (serviceInfoQueryServiceFromPlugin == null) {
            return context.bindService(intent, serviceConnection, i2);
        }
        if (!this.serviceConn2ServiceConn.containsKey(serviceConnection)) {
            this.serviceConn2ServiceConn.put(serviceConnection, new a(this, serviceConnection));
        }
        if (this.conn2Service.get(serviceConnection) == null) {
            this.conn2Service.put(serviceConnection, new HashSet<>());
        }
        this.conn2Service.get(serviceConnection).add(serviceInfoQueryServiceFromPlugin);
        i iVarC = c.c.a.v.a.c(serviceInfoQueryServiceFromPlugin.processName);
        IBinder iBinderAsBinder = iVarC.asBinder();
        HashMap<ServiceConnection, HashSet<ComponentName>> map = this.process2ConnAndService.get(iBinderAsBinder);
        if (map == null) {
            map = new HashMap<>();
            this.process2ConnAndService.put(iBinderAsBinder, map);
        }
        HashSet<ComponentName> hashSet = map.get(serviceConnection);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            map.put(serviceConnection, hashSet);
        }
        hashSet.add(intent.getComponent());
        try {
            return iVarC.a(intent, this.serviceConn2ServiceConn.get(serviceConnection), i2, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            ZeusLogger.e(ZeusLogger.TAG_SERVICE, "bindService failed!", e2);
            return false;
        }
    }

    public ServiceInfo queryServiceFromPlugin(Intent intent, String str) {
        Zeus.loadPlugin(str);
        return PluginManager.getInstance().getPlugin(str).pluginServices.get(intent.getComponent().getClassName());
    }

    public ComponentName startServiceNative(Context context, Intent intent, String str) {
        ServiceInfo serviceInfoQueryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (serviceInfoQueryServiceFromPlugin == null) {
            return context.startService(intent);
        }
        try {
            return c.c.a.v.a.c(serviceInfoQueryServiceFromPlugin.processName).b(intent, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean stopServiceNative(Context context, Intent intent, String str) {
        ServiceInfo serviceInfoQueryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (serviceInfoQueryServiceFromPlugin == null) {
            return context.stopService(intent);
        }
        try {
            return c.c.a.v.a.c(serviceInfoQueryServiceFromPlugin.processName).c(intent, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void unbindServiceNative(ServiceConnection serviceConnection) {
        HashSet<ServiceInfo> hashSet = this.conn2Service.get(serviceConnection);
        if (hashSet != null) {
            Iterator<ServiceInfo> it = hashSet.iterator();
            while (it.hasNext()) {
                try {
                    c.c.a.v.a.c(it.next().processName).d(this.serviceConn2ServiceConn.get(serviceConnection));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
