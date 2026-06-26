package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
public class GDTAD {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static InitListener f2653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static e f2654c = new e() { // from class: com.qq.e.ads.cfg.GDTAD.1
        @Override // com.qq.e.comm.managers.plugin.e
        public void onLoadFail() {
            GDTLogger.w("插件加载失败");
        }

        @Override // com.qq.e.comm.managers.plugin.e
        public void onLoadSuccess() {
            boolean unused = GDTAD.a = true;
            if (GDTAD.f2653b != null) {
                GDTAD.f2653b.onSuccess();
            }
        }
    };

    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (a) {
            GDTLogger.w("SDK已经被初始化过", null);
            return;
        }
        if (context == null) {
            GDTLogger.e("Context参数不能为null");
            return;
        }
        if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
            return;
        }
        f2653b = initListener;
        GDTADManager gDTADManager = GDTADManager.getInstance();
        gDTADManager.setPluginLoadListener(f2654c);
        gDTADManager.initWith(context.getApplicationContext(), str);
    }
}
