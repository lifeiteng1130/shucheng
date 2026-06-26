package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: EncryptHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5051b = "umeng+";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5052c = "ek__id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5053d = "ek_key";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f5054e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f5055f = "umeng_subprocess_info";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f5056g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static a f5057h;

    private a() {
    }

    public static a a() {
        if (f5057h == null) {
            synchronized (a.class) {
                if (f5057h == null) {
                    f5057h = new a();
                }
            }
        }
        return f5057h;
    }

    private String c(String str) {
        String string = "";
        try {
            String strSubstring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < strSubstring.length(); i2++) {
                char cCharAt = strSubstring.charAt(i2);
                if (!Character.isDigit(cCharAt)) {
                    sb.append(cCharAt);
                } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                }
            }
            string = sb.toString();
            return string + new StringBuilder(string).reverse().toString();
        } catch (Throwable unused) {
            return string;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), a.getBytes()));
            }
            return str;
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f5054e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f5054e.getBytes()));
            } catch (Exception unused2) {
            }
            try {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                return str2;
            } catch (Exception unused3) {
                str3 = str2;
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                try {
                    String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f5056g.getBytes()));
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str4;
                    } catch (Throwable unused4) {
                        str3 = str4;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                } catch (Throwable unused5) {
                }
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f5052c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f5054e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f5054e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f5055f, 0);
                if (sharedPreferences != null) {
                    f5056g = sharedPreferences.getString(f5052c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f5056g);
                }
                a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
