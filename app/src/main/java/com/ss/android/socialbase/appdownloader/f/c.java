package com.ss.android.socialbase.appdownloader.f;

import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.i.f;

/* JADX INFO: compiled from: DecryptUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(f.a(str), 0);
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (byte b2 : bArrDecode) {
            if (i2 >= length) {
                i2 %= length;
            }
            sb.append((char) (b2 ^ str2.charAt(i2)));
            i2++;
        }
        return sb.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(f.a(str), 0));
    }
}
