package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import java.util.Objects;

/* JADX INFO: compiled from: VivoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class af implements y {
    @Override // com.umeng.analytics.pro.y
    public String a(Context context) {
        String strC = null;
        try {
            Objects.requireNonNull(k.f.b.b.a.c.a(context));
            if (k.f.b.b.a.c.f8927b) {
                strC = k.d.a.h.c(context);
            } else {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return strC;
    }
}
