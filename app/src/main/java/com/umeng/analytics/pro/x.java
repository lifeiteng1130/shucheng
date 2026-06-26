package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.camera.core.FocusMeteringAction;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SessionIdManager.java */
/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile x f4972c;
    private v a = new w();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4973b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<a> f4974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4975e;

    /* JADX INFO: compiled from: SessionIdManager.java */
    public interface a {
        void a(String str, long j2, long j3, long j4);

        void a(String str, String str2, long j2, long j3, long j4);
    }

    private x() {
    }

    public static x a() {
        if (f4972c == null) {
            synchronized (x.class) {
                if (f4972c == null) {
                    f4972c = new x();
                }
            }
        }
        return f4972c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString(t.f4958d, d(context));
            editorEdit.commit();
        } catch (Exception unused) {
        }
        long jH = h(context);
        long jI = i(context);
        String str = this.f4973b;
        long jA = t.a(context);
        long j2 = jA * FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + jA);
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        a(jI, jH, j2, str, false);
        this.f4973b = this.a.a(context);
        a(jI, jH, j2, str, true);
        this.a.a(context, this.f4973b);
        return this.f4973b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f4973b) && h.a(context).a(this.f4973b) > 0;
    }

    private long h(Context context) {
        return a(context, t.f4960f);
    }

    private long i(Context context) {
        return a(context, t.a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j2 = sharedPreferences.getLong(t.f4959e, 0L);
            long j3 = sharedPreferences.getLong(t.f4960f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.E) && j2 > 0 && j3 == 0) {
                long jA = t.a(appContext);
                if (jA > 0) {
                    long j4 = jA * FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j3 = j2 + j4;
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j3 - j2));
            return this.a.a(j2, j3);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f4973b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f4973b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f4973b)) {
            try {
                this.f4973b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f4973b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f4973b)) {
            this.f4973b = d(context);
        }
        return TextUtils.isEmpty(this.f4973b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f4973b = d(appContext);
        if (e(appContext)) {
            try {
                this.f4973b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f4973b;
    }

    public void a(long j2) {
        this.a.a(j2);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String string = "";
        try {
            synchronized (x.class) {
                string = PreferenceWrapper.getDefault(appContext).getString(t.f4958d, "");
            }
        } catch (Exception unused) {
        }
        return string;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f4974d) == null || list.size() == 0) {
            return;
        }
        this.f4974d.remove(aVar);
    }

    public String a(Context context, long j2) {
        if (TextUtils.isEmpty(this.f4975e)) {
            String strF = c.a.a.a.a.f("SUB", j2);
            StringBuilder sbR = c.a.a.a.a.r(strF);
            StringBuilder sbR2 = c.a.a.a.a.r("%0");
            sbR2.append(32 - strF.length());
            sbR2.append("d");
            sbR.append(String.format(sbR2.toString(), 0));
            this.f4975e = sbR.toString();
        }
        return this.f4975e;
    }

    private long a(Context context, String str) {
        long j2;
        try {
            j2 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j2 = 0;
        }
        return j2 <= 0 ? System.currentTimeMillis() : j2;
    }

    private void a(long j2, long j3, long j4, String str, boolean z) {
        List<a> list = this.f4974d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.f4973b, j2, j3, j4);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f4973b, j2, j3, j4);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f4974d == null) {
            this.f4974d = new ArrayList();
        }
        if (this.f4974d.contains(aVar)) {
            return;
        }
        this.f4974d.add(aVar);
    }
}
