package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: IndependentDownloadServiceHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends com.ss.android.socialbase.downloader.downloader.a implements ServiceConnection {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f3793e = n.class.getSimpleName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.i f3794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.n f3795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3796h = -1;

    private void g() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        try {
            synchronized (this.a) {
                sparseArrayClone = this.a.clone();
                this.a.clear();
            }
            if (sparseArrayClone == null || sparseArrayClone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.c.C() == null) {
                return;
            }
            for (int i2 = 0; i2 < sparseArrayClone.size(); i2++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i2));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.f3794f.a(com.ss.android.socialbase.downloader.i.g.a(it.next()));
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.c.a.a(f3793e, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public IBinder a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.ss.android.socialbase.downloader.g.a.a("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.c.a.b(f3793e, "onBind IndependentDownloadBinder");
        return new m();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void b(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = f3793e;
        StringBuilder sbR = c.a.a.a.a.r("tryDownload aidlService == null:");
        sbR.append(this.f3794f == null);
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
        if (this.f3794f == null) {
            a(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.c.N(), this);
            return;
        }
        g();
        try {
            this.f3794f.a(com.ss.android.socialbase.downloader.i.g.a(downloadTask));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void c(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.d.a().a(downloadTask.getDownloadId(), true);
        a aVarC = com.ss.android.socialbase.downloader.downloader.c.C();
        if (aVarC != null) {
            aVarC.a(downloadTask);
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.f3794f = null;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f3795g;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = f3793e;
        com.ss.android.socialbase.downloader.c.a.b(str, "onServiceConnected ");
        this.f3794f = i.a.a(iBinder);
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f3795g;
        if (nVar != null) {
            nVar.a(iBinder);
        }
        StringBuilder sbR = c.a.a.a.a.r("onServiceConnected aidlService!=null");
        sbR.append(this.f3794f != null);
        sbR.append(" pendingTasks.size:");
        sbR.append(this.a.size());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
        if (this.f3794f != null) {
            com.ss.android.socialbase.downloader.downloader.d.a().b();
            this.f3549b = true;
            this.f3551d = false;
            int i2 = this.f3796h;
            if (i2 != -1) {
                try {
                    this.f3794f.l(i2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f3794f != null) {
                g();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.c.a.b(f3793e, "onServiceDisconnected ");
        this.f3794f = null;
        this.f3549b = false;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f3795g;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.c.a.b(f3793e, "bindService");
            Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.i.f.a()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.g.a.c().a("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.c.a.b(f3793e, "stopService");
        this.f3549b = false;
        Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(com.ss.android.socialbase.downloader.downloader.n nVar) {
        this.f3795g = nVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(int i2) {
        com.ss.android.socialbase.downloader.downloader.i iVar = this.f3794f;
        if (iVar == null) {
            this.f3796h = i2;
            return;
        }
        try {
            iVar.l(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void startService() {
        if (this.f3794f == null) {
            startService(com.ss.android.socialbase.downloader.downloader.c.N(), this);
        }
    }
}
