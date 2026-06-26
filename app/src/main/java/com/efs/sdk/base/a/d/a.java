package com.efs.sdk.base.a.d;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.a.c.c;
import com.efs.sdk.base.a.e.f;
import com.efs.sdk.base.a.f.b;
import com.efs.sdk.base.a.g.d;
import com.efs.sdk.base.a.h.d;
import com.efs.sdk.base.a.h.e;
import com.efs.sdk.base.a.h.f;
import com.efs.sdk.base.a.h.g;
import com.efs.sdk.base.a.h.h;
import com.efs.sdk.base.a.i.f;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.pi.ACTD;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Handler.Callback {
    public static com.efs.sdk.base.a.c.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1799b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1800c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1801d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1802e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1803f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f1804g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.efs.sdk.base.a.d.a.a f1805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f1806i;

    public a(EfsReporter.Builder builder) {
        a = builder.getGlobalEnvStruct();
        Handler handler = new Handler(com.efs.sdk.base.a.h.a.a.a.getLooper(), this);
        this.f1806i = handler;
        handler.sendEmptyMessage(0);
    }

    @NonNull
    public static com.efs.sdk.base.a.c.a a() {
        return a;
    }

    private void b() {
        if (this.f1805h == null) {
            this.f1805h = new com.efs.sdk.base.a.d.a.a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            a.f1776c.registerReceiver(this.f1805h, intentFilter);
        } catch (Throwable th) {
            d.a("efs.base", "register network change receiver error", th);
            int i2 = this.f1799b + 1;
            this.f1799b = i2;
            if (i2 < 3) {
                this.f1806i.sendEmptyMessageDelayed(3, 6000L);
            }
        }
    }

    private void c(final ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        com.efs.sdk.base.a.h.a.d.a(new Runnable() { // from class: com.efs.sdk.base.a.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    iLogProtocol.insertGlobal(c.a.a.a);
                    if (!"wa".equalsIgnoreCase(iLogProtocol.getLogType())) {
                        a.b(iLogProtocol);
                    }
                    if (a.a().f1778e) {
                        final b bVarA = b.a(iLogProtocol);
                        final com.efs.sdk.base.a.g.d dVar = d.a.a;
                        com.efs.sdk.base.a.h.a.d.a(new Runnable() { // from class: com.efs.sdk.base.a.g.d.1
                            public final /* synthetic */ com.efs.sdk.base.a.f.b a;

                            public AnonymousClass1(final com.efs.sdk.base.a.f.b bVarA2) {
                                bVar = bVarA2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                d.this.a.a(bVar);
                            }
                        });
                    }
                } catch (Throwable th) {
                    com.efs.sdk.base.a.h.d.b("efs.base", "log send error", th);
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(@NonNull Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            c cVar = c.a.a;
            com.efs.sdk.base.a.c.b bVar = new com.efs.sdk.base.a.c.b();
            cVar.a = bVar;
            bVar.a(ACTD.APPID_KEY, a.a);
            int iA = g.a();
            cVar.a.a("pid", Integer.valueOf(iA));
            cVar.a.a(Constants.KEYS.PLACEMENTS, g.a(iA));
            String strA = h.a(cVar.f1798b);
            cVar.a.a("wid", strA);
            if (TextUtils.isEmpty(a.f1781h)) {
                cVar.a.a("uid", strA);
            } else {
                cVar.a.a("uid", a.f1781h);
            }
            com.efs.sdk.base.a.c.b bVar2 = cVar.a;
            com.efs.sdk.base.a.a.a.a();
            bVar2.a("stime", Long.valueOf(com.efs.sdk.base.a.a.a.b() - Process.getElapsedCpuTime()));
            cVar.a.a("pkg", cVar.f1798b.getPackageName());
            cVar.a.a("ver", f.a(cVar.f1798b));
            cVar.a.a("vcode", f.b(cVar.f1798b));
            cVar.a.a("sdk_ver", BuildConfig.VERSION_NAME);
            cVar.a.a("brand", Build.BRAND.toLowerCase());
            com.efs.sdk.base.a.c.b bVar3 = cVar.a;
            String str = Build.MODEL;
            bVar3.a("model", str == null ? EnvironmentCompat.MEDIA_UNKNOWN : str.replace(" ", "-").replace("_", "-").toLowerCase());
            DisplayMetrics displayMetrics = cVar.f1798b.getResources().getDisplayMetrics();
            cVar.a.a("dsp_w", Integer.valueOf(displayMetrics.widthPixels));
            cVar.a.a("dsp_h", Integer.valueOf(displayMetrics.heightPixels));
            cVar.a.a("fr", "android");
            cVar.a.a("rom", Build.VERSION.RELEASE);
            cVar.a.a("sdk", Integer.valueOf(Build.VERSION.SDK_INT));
            cVar.a.a("lang", Locale.getDefault().getLanguage());
            cVar.a.a("tzone", TimeZone.getDefault().getID());
            cVar.a.a("net", e.b(cVar.f1798b));
            com.efs.sdk.base.a.e.f unused = f.a.a;
            com.efs.sdk.base.a.c.a.c.a().b();
            b();
            com.efs.sdk.base.a.i.f fVar = f.a.a;
            boolean z = a.f1782i;
            com.efs.sdk.base.a.i.c cVar2 = fVar.a;
            if (z) {
                cVar2.a = "https://errlogos.umeng.com/api/crashsdk/logcollect";
                cVar2.f1850b = "4ea4e41a3993";
            } else {
                cVar2.a = "https://errlog.umeng.com/api/crashsdk/logcollect";
                cVar2.f1850b = "28ef1713347d";
            }
            fVar.f1857b = this;
            fVar.f1858c.a = this;
            fVar.f1859d.a = this;
            this.f1804g = true;
            com.efs.sdk.base.a.e.d.a().sendEmptyMessageDelayed(0, a.f1784k);
            com.efs.sdk.base.a.i.f fVar2 = f.a.a;
            if (fVar2.f1857b != null && a.f1777d) {
                fVar2.f1857b.a(new com.efs.sdk.base.a.i.b("efs_core", "pvuv", fVar2.a.f1851c));
            }
        } else if (i2 == 1) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof ILogProtocol)) {
                c((ILogProtocol) obj);
            }
        } else if (i2 == 3) {
            b();
        }
        return true;
    }

    public final void a(ILogProtocol iLogProtocol) {
        if (this.f1804g) {
            c(iLogProtocol);
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = iLogProtocol;
        this.f1806i.sendMessage(messageObtain);
    }

    @Nullable
    public static HttpResponse a(String str, int i2, String str2, boolean z, File file) {
        b bVar = new b(str, (byte) 2);
        bVar.b(1);
        bVar.f1831d = file;
        bVar.a(str2);
        bVar.a(i2);
        bVar.f1829b.f1832b = z;
        bVar.d();
        d.a.a.a.a(bVar);
        return bVar.f1829b.f1833c;
    }

    public static /* synthetic */ void b(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : a.a(9)) {
            HashMap map = new HashMap(4);
            map.put("log_type", iLogProtocol.getLogType());
            map.put("log_data", iLogProtocol.generateString());
            map.put("link_key", iLogProtocol.getLinkKey());
            map.put("link_id", iLogProtocol.getLinkId());
            Message messageObtain = Message.obtain(null, 9, map);
            Message messageObtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(messageObtain, messageObtain2));
            messageObtain.recycle();
            messageObtain2.recycle();
        }
    }
}
