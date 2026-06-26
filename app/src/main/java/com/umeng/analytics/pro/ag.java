package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: XiaomiDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class ag implements y {
    @Override // com.umeng.analytics.pro.y
    public String a(Context context) {
        try {
            if (!((k.f.b.a.a.a.f8925b == null || k.f.b.a.a.a.a == null) ? false : true)) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            }
            Method method = k.f.b.a.a.a.f8926c;
            Object obj = k.f.b.a.a.a.a;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object objInvoke = method.invoke(obj, context);
                if (objInvoke != null) {
                    return (String) objInvoke;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
