package com.efs.sdk.base.a.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.a.e.f;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Handler.Callback {
    public static final Random a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IConfigRefreshAction f1791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f1793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<IConfigCallback, String[]> f1794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f1795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f1796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f1797h;

    public static class a {
        private static final c a = new c(0);
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    private void e() {
        if (!f.a.a.a()) {
            com.efs.sdk.base.a.h.d.a("efs.config", "has no permission to refresh config from remote");
            return;
        }
        if (!this.f1792c) {
            com.efs.sdk.base.a.h.d.a("efs.config", "disable refresh config from remote");
            return;
        }
        String strRefresh = g().refresh();
        com.efs.sdk.base.a.h.d.a("efs.config", "efs config is ".concat(String.valueOf(strRefresh)));
        if (TextUtils.isEmpty(strRefresh)) {
            return;
        }
        a(strRefresh);
    }

    private void f() {
        boolean zA;
        try {
            zA = this.f1796g.a(this.f1793d);
        } catch (Throwable unused) {
            zA = false;
        }
        if (zA) {
            return;
        }
        this.f1795f.sendEmptyMessageDelayed(3, 3000L);
    }

    @NonNull
    private IConfigRefreshAction g() {
        IConfigRefreshAction iConfigRefreshAction = this.f1791b;
        return iConfigRefreshAction == null ? com.efs.sdk.base.a.c.a.a.a() : iConfigRefreshAction;
    }

    private boolean h() {
        e.b();
        long j2 = 0;
        try {
            e eVar = this.f1796g;
            eVar.c();
            if (eVar.a != null) {
                j2 = eVar.a.getLong("last_refresh_time", 0L);
            }
        } catch (Throwable unused) {
        }
        return System.currentTimeMillis() - j2 >= 28800000;
    }

    private void i() {
        try {
            for (ValueCallback<Pair<Message, Message>> valueCallback : com.efs.sdk.base.a.d.a.a.a(1)) {
                Message messageObtain = Message.obtain(null, 1, new JSONObject(this.f1793d.f1789e).toString());
                Message messageObtain2 = Message.obtain();
                valueCallback.onReceiveValue(new Pair<>(messageObtain, messageObtain2));
                messageObtain.recycle();
                messageObtain2.recycle();
            }
            Iterator<IEfsReporterObserver> it = com.efs.sdk.base.a.d.a.a.o.iterator();
            while (it.hasNext()) {
                it.next().onConfigChange();
            }
        } catch (Throwable th) {
            com.efs.sdk.base.a.h.d.b("efs.base", "efs.config", th);
        }
    }

    public final Map<String, String> c() {
        return new HashMap(this.f1793d.f1789e);
    }

    public final void d() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.efs.sdk.base.a.c.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : c.this.f1794e.keySet()) {
                        String[] strArr = (String[]) c.this.f1794e.get(iConfigCallback);
                        HashMap map = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            for (String str : strArr) {
                                if (c.this.f1793d.f1789e.containsKey(str)) {
                                    map.put(str, c.this.c().get(str));
                                    com.efs.sdk.base.a.h.d.a("efs.config", "--->>> configCallback key is " + str + " ## value is " + c.this.c().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(map);
                    }
                    c.this.f1794e.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(@NonNull Message message) {
        b bVar;
        String str;
        int i2 = message.what;
        if (i2 == 0) {
            boolean zA = e.a();
            com.efs.sdk.base.a.h.d.a("efs.config", "--->>> 删除旧的配置文件 ".concat(String.valueOf(zA)));
            if (zA) {
                this.f1795f.sendEmptyMessage(1);
            } else {
                e eVar = this.f1796g;
                eVar.c();
                if (eVar.a == null) {
                    bVar = null;
                } else {
                    b bVarA = b.a();
                    bVarA.a = eVar.a.getInt("cver", -1);
                    Set<String> setKeySet = eVar.a.getAll().keySet();
                    HashMap map = new HashMap();
                    for (String str2 : setKeySet) {
                        String string = eVar.a.getString(str2, "");
                        if (!TextUtils.isEmpty(string)) {
                            map.put(str2, string);
                        }
                    }
                    bVarA.a(map);
                    bVar = bVarA;
                }
                if (bVar == null) {
                    com.efs.sdk.base.a.h.d.a("efs.config", "--->>> 首次启动本地无配置或加载失败 ");
                } else if (a(bVar)) {
                    com.efs.sdk.base.a.h.d.a("efs.config", "--->>> 一致 ");
                } else {
                    this.f1793d = bVar;
                    if (-1 != bVar.a) {
                        i();
                        d();
                        str = "load config from storage and notify observer";
                    } else {
                        str = "load config from storage";
                    }
                    com.efs.sdk.base.a.h.d.a("efs.config", str);
                }
            }
        } else if (i2 == 1) {
            int i3 = message.arg1;
            if (i3 <= this.f1793d.a) {
                com.efs.sdk.base.a.h.d.a("efs.config", "current config version is " + i3 + ", no need to refresh");
                com.efs.sdk.base.a.h.d.a("efs.config", "current config version(" + this.f1793d.a + ") is " + i3 + ", no need to refresh");
            } else {
                e();
            }
        } else if (i2 != 2) {
            if (i2 == 3) {
                f();
            }
        } else if (f.a.a.a()) {
            if (h()) {
                e();
            } else {
                com.efs.sdk.base.a.h.d.a("efs.config", "No update is required, less than 8h since the last update");
            }
        }
        return true;
    }

    private c() {
        this.f1792c = true;
        this.f1794e = new HashMap();
        this.f1795f = new Handler(com.efs.sdk.base.a.h.a.a.a.getLooper(), this);
        this.f1796g = new e();
        this.f1793d = b.a();
        this.f1797h = com.efs.sdk.base.a.d.a.a.f1783j;
    }

    public static c a() {
        return a.a;
    }

    public final void b() {
        this.f1795f.sendEmptyMessage(0);
        this.f1795f.sendEmptyMessageDelayed(2, this.f1797h);
    }

    public final void a(int i2) {
        if (i2 <= this.f1793d.a) {
            com.efs.sdk.base.a.h.d.a("efs.config", "current config version is " + i2 + ", no need to refresh");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = i2;
        messageObtain.what = 1;
        this.f1795f.sendMessage(messageObtain);
    }

    public final String a(boolean z) {
        if (z) {
            return "https://" + this.f1793d.f1787c;
        }
        return this.f1793d.f1786b + this.f1793d.f1787c;
    }

    public final void a(String str) {
        b bVarA = b.a();
        if (d.a(str, bVarA)) {
            if (a(bVarA)) {
                return;
            }
            this.f1793d = bVarA;
            f();
            i();
            d();
            return;
        }
        this.f1795f.sendEmptyMessageDelayed(1, 3000L);
    }

    private boolean a(b bVar) {
        if (this.f1793d.a >= bVar.a) {
            return true;
        }
        com.efs.sdk.base.a.h.d.a("efs.config", "current config version (" + this.f1793d.a + ") is older than another (" + bVar.a + ")");
        return false;
    }
}
