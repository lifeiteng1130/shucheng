package com.ss.android.downloadlib.a.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.j;

/* JADX INFO: compiled from: DeviceUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(Context context) {
        try {
            return a(c.a(a(), "MD5"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context) {
        String string;
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.printStackTrace();
            string = null;
        }
        return TextUtils.isEmpty(string) ? "normal" : string;
    }

    public static String a() {
        return b(j.getContext());
    }

    public static String a(byte[] bArr) {
        return a.a(bArr);
    }
}
