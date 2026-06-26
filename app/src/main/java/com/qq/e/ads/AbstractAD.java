package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractAD<T> {
    public T a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f2635e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f2633c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f2634d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f2632b = new Handler(Looper.getMainLooper());

    public static final void a(Class cls, ADEvent aDEvent) {
        GDTLogger.e(cls.getSimpleName() + ":ADEvent参数错误(" + aDEvent + ")");
    }

    private void b(final Context context, final String str, final String str2) {
        this.f2635e = true;
        if (!GDTADManager.getInstance().isInitialized()) {
            a(ErrorCode.NOT_INIT);
            return;
        }
        final String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
        if (a.a(context)) {
            this.f2634d = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        AbstractAD.this.f2632b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        AbstractAD abstractAD = AbstractAD.this;
                                        abstractAD.a = (T) abstractAD.a(context, pOFactory2, appid, str, str2);
                                        AbstractAD.this.f2633c = true;
                                        AbstractAD abstractAD2 = AbstractAD.this;
                                        T t = abstractAD2.a;
                                        if (t == null) {
                                            abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                        } else {
                                            abstractAD2.a(t);
                                        }
                                    } else {
                                        AbstractAD.this.f2633c = true;
                                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                    }
                                } catch (Throwable th) {
                                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                    AbstractAD.this.f2633c = true;
                                    AbstractAD.this.a(ErrorCode.INIT_ERROR);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                        AbstractAD.this.f2633c = true;
                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                    }
                }
            });
        } else {
            GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            a(ErrorCode.MANIFEST_ERROR);
        }
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    public final void a(final int i2) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i2);
        } else {
            this.f2632b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i2);
                }
            });
        }
    }

    public final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            b(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(ErrorCode.INIT_ERROR);
        }
    }

    public final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(ErrorCode.INIT_ERROR);
        }
    }

    public abstract void a(T t);

    public final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    public final boolean a() {
        return this.f2635e && this.f2634d;
    }

    public abstract void b(int i2);

    public final boolean b() {
        return this.f2633c;
    }

    public final void c() {
        GDTLogger.e(getClass().getSimpleName() + ":此构造方法已废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo，构造函数中传入的appId将被忽略，实际使用的是GDTADManager.getInstance().initWith() 传入的appId");
    }
}
