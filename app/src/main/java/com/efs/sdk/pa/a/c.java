package com.efs.sdk.pa.a;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.efs.sdk.pa.PA;
import com.efs.sdk.pa.PAANRListener;
import com.efs.sdk.pa.PAMsgListener;
import com.efs.sdk.pa.a.b;
import com.efs.sdk.pa.a.g;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class c implements PA {
    private boolean a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f1889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f1890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f1891e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1895i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f1888b = Looper.myLooper();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f1892f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f1893g = new g();

    public c(boolean z) {
        this.f1895i = z;
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableDumpToFile(String str) {
        FileOutputStream fileOutputStream;
        f fVar = this.f1890d;
        if (fVar == null || str == null || str.trim().length() == 0) {
            return;
        }
        fVar.f1902c = str;
        if (fVar.f1903d == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception unused) {
            }
            try {
                fVar.f1903d = new BufferedOutputStream(fileOutputStream);
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableLog(boolean z) {
        this.a = z;
        this.f1892f.f1884b = z;
        this.f1893g.f1904b = z;
        f fVar = this.f1890d;
        if (fVar != null) {
            fVar.f1901b = z;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final int endCalFPS(String str) {
        if (!this.f1894h) {
            return -1;
        }
        b bVar = this.f1892f;
        if (str != null && str.trim().length() != 0) {
            b.a aVar = bVar.a.get(str);
            if (aVar == null) {
                return 0;
            }
            View view = aVar.f1887d;
            if (view != null && aVar.f1886c != null) {
                view.getViewTreeObserver().removeOnPreDrawListener(aVar.f1886c);
            }
            bVar.a.remove(str);
            int iCurrentTimeMillis = (int) (aVar.f1885b / ((System.currentTimeMillis() - aVar.a) / 1000.0f));
            i = iCurrentTimeMillis > 0 ? iCurrentTimeMillis : 0;
            boolean z = bVar.f1884b;
        }
        return i;
    }

    @Override // com.efs.sdk.pa.PA
    public final long endCalTime(String str) {
        g.a aVar;
        if (!this.f1894h) {
            return -1L;
        }
        g gVar = this.f1893g;
        if (str == null || str.trim().length() == 0 || (aVar = gVar.a.get(str)) == null) {
            return 0L;
        }
        gVar.a.remove(str);
        long jCurrentTimeMillis = System.currentTimeMillis() - aVar.a;
        boolean z = gVar.f1904b;
        return jCurrentTimeMillis;
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener) {
        registerPAANRListener(context, pAANRListener, 2000L);
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAMsgListener(PAMsgListener pAMsgListener) {
        if (this.f1889c == null) {
            this.f1889c = new e();
        }
        this.f1888b.setMessageLogging(this.f1889c);
        if (this.f1890d == null) {
            this.f1890d = new f();
        }
        f fVar = this.f1890d;
        fVar.f1901b = this.a;
        fVar.a = pAMsgListener;
        this.f1889c.a.add(fVar);
    }

    @Override // com.efs.sdk.pa.PA
    public final void start() {
        if (this.f1895i) {
            this.f1894h = true;
            e eVar = this.f1889c;
            if (eVar != null) {
                this.f1888b.setMessageLogging(eVar);
            }
            a aVar = this.f1891e;
            if (aVar == null || !aVar.f1877f) {
                return;
            }
            aVar.f1877f = false;
            aVar.f1878g.post(aVar.m);
            aVar.f1881j = SystemClock.uptimeMillis();
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalFPS(String str, View view) {
        if (this.f1894h) {
            b bVar = this.f1892f;
            if (str == null || str.trim().length() == 0 || view == null || bVar.a.get(str) != null) {
                return;
            }
            b.a aVar = new b.a((byte) 0);
            aVar.f1887d = view;
            b.a.AnonymousClass1 anonymousClass1 = new ViewTreeObserver.OnPreDrawListener() { // from class: com.efs.sdk.pa.a.b.a.1
                public AnonymousClass1() {
                }

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    a.this.f1885b++;
                    return true;
                }
            };
            aVar.f1886c = anonymousClass1;
            aVar.f1887d.getViewTreeObserver().addOnPreDrawListener(anonymousClass1);
            aVar.a = System.currentTimeMillis();
            bVar.a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalTime(String str) {
        if (this.f1894h) {
            g gVar = this.f1893g;
            if (str == null || str.trim().length() == 0 || gVar.a.get(str) != null) {
                return;
            }
            g.a aVar = new g.a((byte) 0);
            aVar.a = System.currentTimeMillis();
            gVar.a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void stop() {
        this.f1894h = false;
        this.f1888b.setMessageLogging(null);
        a aVar = this.f1891e;
        if (aVar != null) {
            aVar.f1877f = true;
            aVar.f1878g.removeCallbacksAndMessages(null);
            aVar.a = true;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unRegisterPAMsgListener() {
        f fVar = this.f1890d;
        if (fVar != null) {
            fVar.a = null;
        }
        e eVar = this.f1889c;
        if (eVar != null) {
            eVar.a.remove(fVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unregisterPAANRListener() {
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j2) {
        registerPAANRListener(context, pAANRListener, j2, Looper.getMainLooper().getThread());
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j2, Thread thread) {
        if (this.f1891e == null) {
            if (thread != null) {
                this.f1891e = new a((Application) context.getApplicationContext(), j2);
            } else {
                this.f1891e = new a((Application) context.getApplicationContext(), j2, false);
            }
        }
        this.f1891e.f1879h = pAANRListener;
    }
}
