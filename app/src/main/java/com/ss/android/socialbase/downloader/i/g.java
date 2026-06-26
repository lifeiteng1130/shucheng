package com.ss.android.socialbase.downloader.i;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IPCUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.model.a a(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new a.AbstractBinderC0116a() { // from class: com.ss.android.socialbase.downloader.i.g.1
            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo a() {
                return downloadTask.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.e b() {
                return g.a(downloadTask.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public y c() {
                return g.a(downloadTask.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ae d() {
                return g.a(downloadTask.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.h e() {
                return g.a(downloadTask.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.f f() {
                return g.a(downloadTask.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public u g() {
                return g.a(downloadTask.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ah h() {
                return g.a(downloadTask.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public p i() {
                return g.a(downloadTask.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.j j() {
                return g.a(downloadTask.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.g k() {
                return g.a(downloadTask.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int l() {
                return downloadTask.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int a(int i2) {
                return downloadTask.getDownloadListenerSize(f.e(i2));
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.i b(int i2) {
                return g.a(downloadTask.getSingleDownloadListener(f.e(i2)), i2 != com.ss.android.socialbase.downloader.constants.f.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public l c(int i2) {
                return g.a(downloadTask.getDownloadCompleteHandlerByIndex(i2));
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.i a(int i2, int i3) {
                return g.a(downloadTask.getDownloadListenerByIndex(f.e(i2), i3), i2 != com.ss.android.socialbase.downloader.constants.f.SUB.ordinal());
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.i a(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new i.a() { // from class: com.ss.android.socialbase.downloader.i.g.12
            @Override // com.ss.android.socialbase.downloader.depend.i
            public int a() {
                return iDownloadListener.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onProgress(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onProgress(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void d(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPause(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPause(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void e(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onSuccessed(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void f(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onCanceled(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void g(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void h(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void i(final DownloadInfo downloadInfo) {
                IDownloadListener iDownloadListener2 = iDownloadListener;
                if (iDownloadListener2 instanceof s) {
                    if (z) {
                        g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((s) iDownloadListener).a(downloadInfo);
                            }
                        });
                    } else {
                        ((s) iDownloadListener2).a(downloadInfo);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(final DownloadInfo downloadInfo) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPrepare(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(final DownloadInfo downloadInfo, final BaseException baseException) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(final DownloadInfo downloadInfo, final BaseException baseException) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(final DownloadInfo downloadInfo, final BaseException baseException) {
                if (z) {
                    g.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.g.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onFailed(downloadInfo, baseException);
                }
            }
        };
    }

    public static y a(final z zVar) {
        if (zVar == null) {
            return null;
        }
        return new y.a() { // from class: com.ss.android.socialbase.downloader.i.g.23
            @Override // com.ss.android.socialbase.downloader.depend.y
            public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
                zVar.a(i2, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public boolean a(boolean z) {
                return zVar.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public String a() {
                return zVar.a();
            }
        };
    }

    public static ae a(final af afVar) {
        if (afVar == null) {
            return null;
        }
        return new ae.a() { // from class: com.ss.android.socialbase.downloader.i.g.26
            @Override // com.ss.android.socialbase.downloader.depend.ae
            public boolean a(DownloadInfo downloadInfo) {
                return afVar.a(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ae
            public boolean b(DownloadInfo downloadInfo) {
                return afVar.b(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ae
            public boolean c(DownloadInfo downloadInfo) {
                return afVar.c(downloadInfo);
            }
        };
    }

    public static ah a(final com.ss.android.socialbase.downloader.downloader.s sVar) {
        if (sVar == null) {
            return null;
        }
        return new ah.a() { // from class: com.ss.android.socialbase.downloader.i.g.27
            @Override // com.ss.android.socialbase.downloader.depend.ah
            public long a(int i2, int i3) {
                return sVar.a(i2, i3);
            }
        };
    }

    public static u a(final w wVar) {
        if (wVar == null) {
            return null;
        }
        return new u.a() { // from class: com.ss.android.socialbase.downloader.i.g.28
            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean a(t tVar) {
                return wVar.a(g.a(tVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.g a(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new g.a() { // from class: com.ss.android.socialbase.downloader.i.g.29
            @Override // com.ss.android.socialbase.downloader.depend.g
            public Uri a(String str, String str2) {
                return iDownloadFileUriProvider.getUriForFile(str, str2);
            }
        };
    }

    public static v a(final t tVar) {
        if (tVar == null) {
            return null;
        }
        return new v() { // from class: com.ss.android.socialbase.downloader.i.g.30
            @Override // com.ss.android.socialbase.downloader.depend.v
            public void a(List<String> list) {
                try {
                    tVar.a(list);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean a() {
                try {
                    return tVar.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static p a(final r rVar) {
        if (rVar == null) {
            return null;
        }
        return new p.a() { // from class: com.ss.android.socialbase.downloader.i.g.31
            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean a(long j2, long j3, o oVar) {
                return rVar.a(j2, j3, g.a(oVar));
            }
        };
    }

    public static q a(final o oVar) {
        if (oVar == null) {
            return null;
        }
        return new q() { // from class: com.ss.android.socialbase.downloader.i.g.2
            @Override // com.ss.android.socialbase.downloader.depend.q
            public void a() {
                try {
                    oVar.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.f a(final n nVar) {
        if (nVar == null) {
            return null;
        }
        return new f.a() { // from class: com.ss.android.socialbase.downloader.i.g.3
            @Override // com.ss.android.socialbase.downloader.depend.f
            public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                nVar.a(downloadInfo, baseException, i2);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.j a(final x xVar) {
        if (xVar == null) {
            return null;
        }
        return new j.a() { // from class: com.ss.android.socialbase.downloader.i.g.4
            @Override // com.ss.android.socialbase.downloader.depend.j
            public void a(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    xVar.a(new JSONObject(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public int[] b() {
                x xVar2 = xVar;
                if (xVar2 instanceof com.ss.android.socialbase.downloader.depend.c) {
                    return ((com.ss.android.socialbase.downloader.depend.c) xVar2).a();
                }
                return null;
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public String a() {
                return xVar.b();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.e a(final com.ss.android.socialbase.downloader.downloader.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new e.a() { // from class: com.ss.android.socialbase.downloader.i.g.5
            @Override // com.ss.android.socialbase.downloader.depend.e
            public int a(long j2) {
                return hVar.a(j2);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.h a(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new h.a() { // from class: com.ss.android.socialbase.downloader.i.g.6
            @Override // com.ss.android.socialbase.downloader.depend.h
            public boolean a() {
                return iDownloadInterceptor.intercepte();
            }
        };
    }

    public static DownloadTask a(com.ss.android.socialbase.downloader.model.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(aVar.a());
            downloadTask.chunkStategy(a(aVar.b())).notificationEventListener(a(aVar.c())).interceptor(a(aVar.e())).depend(a(aVar.f())).monitorDepend(a(aVar.j())).forbiddenHandler(a(aVar.g())).diskSpaceHandler(a(aVar.i())).fileUriProvider(a(aVar.k())).notificationClickCallback(a(aVar.d())).retryDelayTimeCalculator(a(aVar.h()));
            com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.MAIN;
            com.ss.android.socialbase.downloader.depend.i iVarB = aVar.b(fVar.ordinal());
            if (iVarB != null) {
                downloadTask.mainThreadListenerWithHashCode(iVarB.hashCode(), a(iVarB));
            }
            com.ss.android.socialbase.downloader.constants.f fVar2 = com.ss.android.socialbase.downloader.constants.f.SUB;
            com.ss.android.socialbase.downloader.depend.i iVarB2 = aVar.b(fVar2.ordinal());
            if (iVarB2 != null) {
                downloadTask.subThreadListenerWithHashCode(iVarB2.hashCode(), a(iVarB2));
            }
            com.ss.android.socialbase.downloader.constants.f fVar3 = com.ss.android.socialbase.downloader.constants.f.NOTIFICATION;
            com.ss.android.socialbase.downloader.depend.i iVarB3 = aVar.b(fVar3.ordinal());
            if (iVarB3 != null) {
                downloadTask.notificationListenerWithHashCode(iVarB3.hashCode(), a(iVarB3));
            }
            a(downloadTask, aVar, fVar);
            a(downloadTask, aVar, fVar2);
            a(downloadTask, aVar, fVar3);
            a(downloadTask, aVar);
            return downloadTask;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void a(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.a aVar, com.ss.android.socialbase.downloader.constants.f fVar) {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i2 = 0; i2 < aVar.a(fVar.ordinal()); i2++) {
            com.ss.android.socialbase.downloader.depend.i iVarA = aVar.a(fVar.ordinal(), i2);
            if (iVarA != null) {
                sparseArray.put(iVarA.a(), a(iVarA));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, fVar);
    }

    private static void a(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.a aVar) {
        for (int i2 = 0; i2 < aVar.l(); i2++) {
            l lVarC = aVar.c(i2);
            if (lVarC != null) {
                downloadTask.addDownloadCompleteHandler(a(lVarC));
            }
        }
    }

    public static z a(final y yVar) {
        if (yVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.downloader.i.g.7
            @Override // com.ss.android.socialbase.downloader.depend.z
            public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    yVar.a(i2, downloadInfo, str, str2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean a(boolean z) {
                try {
                    return yVar.a(z);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public String a() {
                try {
                    return yVar.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static m a(final l lVar) {
        if (lVar == null) {
            return null;
        }
        return new m() { // from class: com.ss.android.socialbase.downloader.i.g.8
            @Override // com.ss.android.socialbase.downloader.depend.m
            public void a(DownloadInfo downloadInfo) throws BaseException {
                try {
                    lVar.a(downloadInfo);
                } catch (RemoteException e2) {
                    throw new BaseException(PointerIconCompat.TYPE_TEXT, e2);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public boolean b(DownloadInfo downloadInfo) {
                try {
                    return lVar.b(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static l a(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new l.a() { // from class: com.ss.android.socialbase.downloader.i.g.9
            @Override // com.ss.android.socialbase.downloader.depend.l
            public void a(DownloadInfo downloadInfo) {
                try {
                    mVar.a(downloadInfo);
                } catch (BaseException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.l
            public boolean b(DownloadInfo downloadInfo) {
                return mVar.b(downloadInfo);
            }
        };
    }

    public static af a(final ae aeVar) {
        if (aeVar == null) {
            return null;
        }
        return new af() { // from class: com.ss.android.socialbase.downloader.i.g.10
            @Override // com.ss.android.socialbase.downloader.depend.af
            public boolean a(DownloadInfo downloadInfo) {
                try {
                    return aeVar.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.af
            public boolean b(DownloadInfo downloadInfo) {
                try {
                    return aeVar.b(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.af
            public boolean c(DownloadInfo downloadInfo) {
                try {
                    return aeVar.c(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.h a(final com.ss.android.socialbase.downloader.depend.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.h() { // from class: com.ss.android.socialbase.downloader.i.g.11
            @Override // com.ss.android.socialbase.downloader.downloader.h
            public int a(long j2) {
                try {
                    return eVar.a(j2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
        };
    }

    public static n a(final com.ss.android.socialbase.downloader.depend.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new n() { // from class: com.ss.android.socialbase.downloader.i.g.13
            @Override // com.ss.android.socialbase.downloader.depend.n
            public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    fVar.a(downloadInfo, baseException, i2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    public static x a(final com.ss.android.socialbase.downloader.depend.j jVar) {
        if (jVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.c() { // from class: com.ss.android.socialbase.downloader.i.g.14
            @Override // com.ss.android.socialbase.downloader.depend.x
            public void a(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    jVar.a(jSONObject.toString());
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.x
            public String b() {
                try {
                    return jVar.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.c
            public int[] a() {
                try {
                    return jVar.b();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static w a(final u uVar) {
        if (uVar == null) {
            return null;
        }
        return new w() { // from class: com.ss.android.socialbase.downloader.i.g.15
            @Override // com.ss.android.socialbase.downloader.depend.w
            public boolean a(v vVar) {
                try {
                    return uVar.a(g.a(vVar));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static t a(final v vVar) {
        if (vVar == null) {
            return null;
        }
        return new t.a() { // from class: com.ss.android.socialbase.downloader.i.g.16
            @Override // com.ss.android.socialbase.downloader.depend.t
            public void a(List<String> list) {
                vVar.a(list);
            }

            @Override // com.ss.android.socialbase.downloader.depend.t
            public boolean a() {
                return vVar.a();
            }
        };
    }

    public static aj a(final ak akVar) {
        if (akVar == null) {
            return null;
        }
        return new aj.a() { // from class: com.ss.android.socialbase.downloader.i.g.17
            @Override // com.ss.android.socialbase.downloader.depend.aj
            public void a(int i2, int i3) {
                akVar.a(i2, i3);
            }
        };
    }

    public static ak a(final aj ajVar) {
        if (ajVar == null) {
            return null;
        }
        return new ak() { // from class: com.ss.android.socialbase.downloader.i.g.18
            @Override // com.ss.android.socialbase.downloader.depend.ak
            public void a(int i2, int i3) {
                try {
                    ajVar.a(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    public static r a(final p pVar) {
        if (pVar == null) {
            return null;
        }
        return new r() { // from class: com.ss.android.socialbase.downloader.i.g.19
            @Override // com.ss.android.socialbase.downloader.depend.r
            public boolean a(long j2, long j3, q qVar) {
                try {
                    return pVar.a(j2, j3, g.a(qVar));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static o a(final q qVar) {
        if (qVar == null) {
            return null;
        }
        return new o.a() { // from class: com.ss.android.socialbase.downloader.i.g.20
            @Override // com.ss.android.socialbase.downloader.depend.o
            public void a() {
                qVar.a();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.s a(final ah ahVar) {
        if (ahVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.s() { // from class: com.ss.android.socialbase.downloader.i.g.21
            @Override // com.ss.android.socialbase.downloader.downloader.s
            public long a(int i2, int i3) {
                try {
                    return ahVar.a(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor a(final com.ss.android.socialbase.downloader.depend.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.i.g.22
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return hVar.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider a(final com.ss.android.socialbase.downloader.depend.g gVar) {
        if (gVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.i.g.24
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return gVar.a(str, str2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static IDownloadListener a(final com.ss.android.socialbase.downloader.depend.i iVar) {
        if (iVar == null) {
            return null;
        }
        return new s() { // from class: com.ss.android.socialbase.downloader.i.g.25
            @Override // com.ss.android.socialbase.downloader.depend.s
            public void a(DownloadInfo downloadInfo) {
                try {
                    iVar.i(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    iVar.f(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    iVar.a(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    iVar.g(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    iVar.h(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    iVar.d(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    iVar.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    iVar.c(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    iVar.b(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    iVar.c(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    iVar.b(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    iVar.e(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }
}
