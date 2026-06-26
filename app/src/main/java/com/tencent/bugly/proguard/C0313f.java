package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.bw;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class C0313f {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f4370b = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = a;
            cArr[i3 + 1] = cArr2[b2 & bw.m];
            cArr[i3 + 0] = cArr2[((byte) (b2 >>> 4)) & bw.m];
        }
        return new String(cArr);
    }
}
